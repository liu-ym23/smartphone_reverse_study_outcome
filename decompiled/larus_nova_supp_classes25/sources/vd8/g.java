package vd8;

import com.bytedance.keva.Keva;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.z;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements td8.c {
    public static final Lazy<Keva> b = null;
    public final td8.d a;

    public static final class a {
    }

    static {
        b = LazyKt.lazy(new f());
    }

    public static nf8.d c() {
        return new nf8.d(b0.j(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -65, 31, null), 8));
    }

    public g(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContextTask");
        this.a = r2;
    }

    @Override // td8.c
    public final boolean a(int r4, xc8.b r5, xc8.b r6, List<? extends xc8.b> r7) {
        Intrinsics.checkNotNullParameter(r6, "current");
        Intrinsics.checkNotNullParameter(r7, "input");
        if ((this.a.l() instanceof z) == false) goto L5;
        return false;
    L5:
        if (this.a.c() == false) goto L7;
        return false;
    L7:
        if ((this.a.l() instanceof com.larus.bmhome.social.userchat.model.b) == true) goto L36;
        wc9.e r8 = this.a.g();
        Lazy r9 = ic8.n.a;
        if (r8 == null) goto L15;
        String r1 = r8.a;
        if (r1 == null) goto L15;
        if (StringsKt.contains$default(r1, "doc_manager", false, 2, null) != true) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L27;
        if (r8 == null) goto L23;
        String r10 = r8.a;
        if (r10 == null) goto L23;
        if (StringsKt.contains$default(r10, "doc_detail", false, 2, null) != true) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == true) goto L27;
        boolean r12 = false;
    L28:
        if (r12 == true) goto L37;
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r13 == null) goto L32;
        r13.C0();
        hc9.d r14 = hc9.d.a;
    L32:
        return true;
    L37:
        return false;
    L23:
        r11 = false;
    L27:
        r12 = true;
    L15:
        r2 = false;
        goto L16
    L36:
        return false;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r51, xc8.b r52, xc8.b r53, List<xc8.b> r54) {
        Intrinsics.checkNotNullParameter(r53, "current");
        Intrinsics.checkNotNullParameter(r54, "input");
        FLogger r2 = FLogger.a;
        r2.i("Pipeline_List_BigAvatarTask", "BigAvatarTask process, input size = " + r54.size());
        wc9.e r3 = this.a.g();
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r6 = false;
        if (r5 == null) goto L9;
        FlowAppletServiceImpl r7 = r5.g0();
        if (r7 == null) goto L9;
        if (r7.m(r3) != true) goto L9;
        boolean r8 = true;
    L11:
        if (ic8.n.D(r3) == false) goto L17;
        if (r8 == false) goto L17;
        if (this.a.e() == false) goto L35;
        r2.i("Pipeline_List_BigAvatarTask", "mini app debug sub cvs is load completed, add big avatar");
        r54.add(c());
    L35:
        return r54;
    L17:
        if (ic8.n.D(r3) == false) goto L25;
        z2 r4 = z2.a;
        r4.w3();
        if (this.a.e() == false) goto L35;
        if (r54.isEmpty() == false) goto L35;
        if (r4.enableSubSmallAvatar() == false) goto L35;
        r2.i("Pipeline_List_BigAvatarTask", "sub cvs is load completed, input empty, add small avatar");
        r54.add(new nf8.j(b0.j(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -65, 31, null), 9)));
        goto L35
    L25:
        boolean r9 = this.a.e();
        int r10 = r54.size();
        if (r9 == true) goto L34;
        if (1 <= r10) goto L29;
    L31:
        if (r6 == true) goto L34;
        r2.i("Pipeline_List_BigAvatarTask", "cvs is load completed or input size(" + r54.size() + ") >= 8, not add big avatar");
        goto L35
    L29:
        if (r10 >= 8) goto L31;
        r6 = true;
    L34:
        r2.i("Pipeline_List_BigAvatarTask", "cvs is load completed or input size < 8, add big avatar, isLoadCompleted = " + r9 + ", inputSize = " + r10);
        r54.add(c());
    L9:
        r8 = false;
        goto L11
    }
}
