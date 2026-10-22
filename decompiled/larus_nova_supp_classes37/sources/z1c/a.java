package z1c;

import android.content.Context;
import com.ss.android.lark.qrcode.ui.QRScanResultDefaultActivity;
import com.ss.android.lark.qrcode.ui.e;
import com.ss.android.lark.qrcode.ui.h;
import com.ss.android.lark.qrcode.ui.i;
import com.ss.android.lark.qrcode.ui.y;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import qqb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final a2c.a a = null;

    /* JADX INFO: renamed from: z1c.a$a, reason: collision with other inner class name */
    public static final class C0207a {
        @JvmStatic
        public static void a(String r3, Context r4) {
            Intrinsics.checkNotNullParameter(r3, "qrContent");
            Intrinsics.checkNotNullParameter(r4, "context");
            h r0 = h.c.a;
            r0.getClass();
            r0.c = new i(r4);
            if (((y) c.b("QRCodeScanManager handleParseResult", new e(r0, 2, r3))).a == true) goto L5;
            QRScanResultDefaultActivity.z1(r4, r3, false);
        L5:
            r0.c = null;
        }
    }

    static {
        a = (a2c.a) ApiUtils.getApi(a2c.a.class);
    }
}
