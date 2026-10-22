package tc8;

import androidx.fragment.app.Fragment;
import com.larus.extension.offline_message.api.OfflineMessageServiceDelegate;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public static String b() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L27
        if (r2 == null) goto L8;
        r2.P();     // Catch: Throwable -> L27
        Fragment r3 = ChatServiceImpl.a.f();     // Catch: Throwable -> L27
    L10:
        if ((r3 instanceof xe8.a) == false) goto L12;
        xe8.a r4 = (xe8.a) r3;     // Catch: Throwable -> L27
    L13:
        if (r4 == null) goto L24;
        String r5 = r4.getConversationId();     // Catch: Throwable -> L27
        if (r5 == null) goto L24;
        boolean r6 = true;
        if ((!StringsKt.isBlank(r5)) == true) goto L19;
    L21:
        r6 = false;
    L22:
        if (r6 == false) goto L24;
    L25:
        Object r7 = Result.constructor-impl(r5);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r7) == true) goto L34;
        r0 = r7;
    L34:
        return a((String) r0);
    L19:
        if (Intrinsics.areEqual(r5, "-1") == true) goto L21;
    L24:
        r5 = null;
        goto L25
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
    L27:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public static String a(String r4) {
        String r0 = null;
        if (r4 == null) goto L25;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r5)) == true) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L27;
        String r2 = OfflineMessageServiceDelegate.b.a(r5);
        if (r2 == null) goto L24;
        if ((true ^ StringsKt.isBlank(r2)) == false) goto L21;
        r0 = r2;
    L21:
        if (r0 == null) goto L24;
        return r0;
    L24:
        return r5;
    L27:
        return null;
    L9:
        if (Intrinsics.areEqual(r5, "-1") == true) goto L11;
        r1 = true;
        goto L12
    L25:
        return null;
    }
}
