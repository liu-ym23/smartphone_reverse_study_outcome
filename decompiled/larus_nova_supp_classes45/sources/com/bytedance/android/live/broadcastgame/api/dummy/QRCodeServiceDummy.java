package com.bytedance.android.live.broadcastgame.api.dummy;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/dummy/QRCodeServiceDummy;", "Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService;", "Landroid/content/Context;", "context", "Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService$b;", "scanResultListener", "", "startScanQRCode", "Landroid/os/Bundle;", "bundle", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveBgBroadcastFragment;", "createQRCodeFragment", "<init>", "()V", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QRCodeServiceDummy implements IQRCodeService {
    public QRCodeServiceDummy() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService
    public ILiveBgBroadcastFragment createQRCodeFragment(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService
    public void startScanQRCode(Context r1, IQRCodeService.b r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }
}
