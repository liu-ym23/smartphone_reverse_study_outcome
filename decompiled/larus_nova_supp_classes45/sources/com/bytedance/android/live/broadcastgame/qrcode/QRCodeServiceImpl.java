package com.bytedance.android.live.broadcastgame.qrcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import com.bytedance.bpea.cert.token.TokenCert;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m60.c;
import m60.i;
import o60.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/qrcode/QRCodeServiceImpl;", "Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService;", "Landroid/content/Context;", "context", "", "scanActivity", "Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService$b;", "scanResultListener", "startScanQRCode", "Landroid/os/Bundle;", "bundle", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveBgBroadcastFragment;", "createQRCodeFragment", "Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService$b;", "getScanResultListener", "()Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService$b;", "setScanResultListener", "(Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService$b;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class QRCodeServiceImpl implements IQRCodeService {
    private IQRCodeService.b scanResultListener;

    public static final class a implements e {
        public final /* synthetic */ QRCodeServiceImpl a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ IQRCodeService.b c;

        @Override // o60.e
        public final void onPermissionDenied(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
            IQRCodeService.b r3 = this.c;
            if (r3 == null) goto L6;
            r3.b(IQRCodeService.ERR_CAMERA);
            return;
        }

        @Override // o60.e
        public final void onPermissionGrant(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "permissions");
            QRCodeServiceImpl.access$scanActivity(this.a, this.b);
        }

        public a(QRCodeServiceImpl r1, Context r2, IQRCodeService.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public QRCodeServiceImpl() {
        k.l(IQRCodeService.class, this);
    }

    public final IQRCodeService.b getScanResultListener() {
        return this.scanResultListener;
    }

    private final void scanActivity(Context r4) {
        r4.startActivity(new Intent(r4, k.n(IHostApp.class).getHostActivity(33)));
    }

    @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService
    public ILiveBgBroadcastFragment createQRCodeFragment(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "bundle");
        int r0 = LiveQRCodeInteractFragment.e;
        IQRCodeService.b r1 = this.scanResultListener;
        Bundle r2 = new Bundle();
        LiveQRCodeInteractFragment r3 = new LiveQRCodeInteractFragment();
        r2.putBundle("extra", r5);
        r3.setArguments(r2);
        if (r1 == null) goto L5;
        r3.d = r1;
    L5:
        this.scanResultListener = null;
        return r3;
    }

    public final void setScanResultListener(IQRCodeService.b r1) {
        this.scanResultListener = r1;
    }

    public static final /* synthetic */ void access$scanActivity(QRCodeServiceImpl r0, Context r1) {
        r0.scanActivity(r1);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService
    public void startScanQRCode(Context r4, IQRCodeService.b r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (c.d(r4, new String[]{"android.permission.CAMERA"}) == false) goto L5;
        this.scanResultListener = r5;
        scanActivity(r4);
        return;
    L5:
        SettingKey<Boolean> r2 = i.a;
        new i.b((Activity) r4).b(new a(this, r4, r5), null, TokenCert.Companion.with("bpea-openplatform_lynx_debug_scan_qrcode"), new String[]{"android.permission.CAMERA"});
    }
}
