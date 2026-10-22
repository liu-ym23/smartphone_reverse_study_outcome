package com.bytedance.android.live.broadcastgame.api.opengame.qrcode;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcastgame.qrcode.QRCodeServiceImpl")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \f2\u00020\u0001:\u0002\r\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "context", "Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService$b;", "scanResultListener", "", "startScanQRCode", "Landroid/os/Bundle;", "bundle", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveBgBroadcastFragment;", "createQRCodeFragment", "Companion", "a", "b", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.broadcastgame.api.dummy.QRCodeServiceDummy")
public interface IQRCodeService extends IService {
    public static final int CAMERA_PERMISSION_REQ_CODE = 250;
    public static final a Companion = null;
    public static final int ERR_CAMERA = -1000;
    public static final int ERR_INIT = -2000;
    public static final int ERR_RENDER = -2001;
    public static final int ERR_TIMEOUT = -2002;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    public interface b {
        boolean b(int r1);

        boolean c(String r1);
    }

    static {
        Companion = a.a;
    }

    ILiveBgBroadcastFragment createQRCodeFragment(Bundle r1);

    void startScanQRCode(Context r1, b r2);
}
