package x3;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final com.bytedance.ai.bridge.core.a.b b(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        f3.a r11 = f3.a.g;
        g.a.e(r10, "call failed, errNo=" + r11.a + ", msg=file manager not available");
        return new com.bytedance.ai.bridge.core.a.b(0, "file manager not available", null, r11, 21);
    }

    public static final com.bytedance.ai.bridge.core.a.b c(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        f3.a r11 = f3.a.h;
        g.a.e(r10, "call failed, errNo=" + r11.a + ", msg=invalid base64 data");
        return new com.bytedance.ai.bridge.core.a.b(0, "invalid base64 data", null, r11, 21);
    }

    public static final AppletFileManager d(d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        a0 r11 = r10.getContainerContext();
        if (r11 == null) goto L12;
        String r12 = r11.getAppletId();
        if (r12 == null) goto L12;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r13 = AppletAppManagerService.b(r12);
        if (r13 != null) goto L11;
        return null;
    L11:
        return r13.J();
    L12:
        return null;
    }

    public static final com.bytedance.ai.bridge.core.a.b a(String r10, AppletFileError r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, "e");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if ((r11 instanceof AppletFileError.NotExist) == false) goto L7;
        f3.a r0 = f3.a.t;
    L5:
        f3.a r12 = r0;
        String r1 = r11.getMessage();
        if (r1 != null) goto L29;
        String r13 = r11.getCode();
    L30:
        g.a.e(r10, "call failed, errNo=" + r12.a + ", msg=" + r13);
        return new com.bytedance.ai.bridge.core.a.b(0, r13, null, r12, 21);
    L29:
        r13 = r1;
        goto L30
    L7:
        if ((r11 instanceof AppletFileError.InvalidUri) == false) goto L9;
    L25:
        r0 = f3.a.v;
        goto L5
    L9:
        if ((r11 instanceof AppletFileError.PathEscape) == true) goto L25;
        if ((r11 instanceof AppletFileError.QuotaExceeded) == false) goto L15;
        r0 = f3.a.u;
        goto L5
    L15:
        if ((r11 instanceof AppletFileError.IsDir) == false) goto L18;
        f3.a.C0156a r14 = f3.a.c;
        f3.a r15 = b.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        r0 = b.l;
        goto L5
    L18:
        if ((r11 instanceof AppletFileError.NotDir) == false) goto L21;
        f3.a.C0156a r16 = f3.a.c;
        f3.a r17 = b.a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        r0 = b.m;
        goto L5
    L21:
        if ((r11 instanceof AppletFileError.IoError) == false) goto L24;
        r0 = f3.a.f;
        goto L5
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public static final String e(d r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "vfsPath");
        if (StringsKt.startsWith$default(r11, "appletfile://", false, 2, null) == true) goto L5;
        return r11;
    L5:
        AppletFileManager r12 = d(r10);
        if (r12 != null) goto L12;
        return r11;
    L12:
        int r0 = com.bytedance.ai.file.a.b;     // Catch: Exception -> L11
        String r13 = r12.n(com.bytedance.ai.file.a.C0040a.a(r11)).getAbsolutePath();     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L11
        return r13;
    L14:
        return r11;
    }
}
