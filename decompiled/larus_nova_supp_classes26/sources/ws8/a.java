package ws8;

import com.larus.bmhome.actionbar.model.d2;
import com.larus.bmhome.actionbar.model.m0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.home.impl.sdk.e2;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import wa8.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final boolean a(z0 r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (k1.c(r3) == true) goto L8;
        m0 r4 = r3.u;
        if (r4 == null) goto L52;
        d2 r5 = r4.u;
        if (r5 != null) goto L50;
        return false;
    L50:
        return Intrinsics.areEqual(r5.d, Boolean.TRUE);
    L52:
        return false;
    L8:
        if (AccountService.a.a() == false) goto L11;
        return false;
    L11:
        if (k1.c(r3) == false) goto L55;
        m0 r6 = r3.u;
        if (r6 == null) goto L18;
        d2 r7 = r6.u;
        if (r7 == null) goto L18;
        String r8 = r7.a;
    L20:
        if (r8 != null) goto L22;
    L25:
        boolean r9 = true;
    L26:
        if (r9 == true) goto L56;
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L33;
        r10.r0();
        if (e2.a.w() != true) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L57;
        i1 r12 = IAIChatUgcAIGCService.a.E();
        if (r12 != null) goto L39;
    L41:
        boolean r13 = false;
    L42:
        if (r13 == true) goto L58;
        return true;
    L58:
        return false;
    L39:
        if (((Boolean) r12.getValue()).booleanValue() != true) goto L41;
        r13 = true;
        goto L42
    L57:
        return false;
    L33:
        r11 = false;
        goto L34
    L56:
        return false;
    L22:
        if (r8.length() == 0) goto L25;
        r9 = false;
    L18:
        r8 = null;
        goto L20
    L55:
        return false;
    }
}
