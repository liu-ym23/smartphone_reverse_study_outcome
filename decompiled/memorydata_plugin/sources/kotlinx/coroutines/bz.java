package kotlinx.coroutines;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class bz extends ce implements z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f17254b;

    public bz(bx r3) {
        bx r4 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        super(true);
        a(r4);
        this.f17254b = g();
    }

    private final boolean g() {
        t r4 = n();
        if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L5;
        u r5 = (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.memorydata.plugin");
    L7:
        if (r5 == null) goto L22;
        ce r6 = r5.c();
        if (r6 == null) goto L22;
    L12:
        if (r6.p_() == true) goto L13;
        t r7 = r6.n();
        if (ZeusTransformUtils.instanceOf(r7, u.class) == false) goto L18;
        u r8 = (u) ZeusTransformUtils.preCheckCast(r7, u.class, "com.obric.memorydata.plugin");
    L19:
        if (r8 == null) goto L22;
        r6 = r8.c();
        if (r6 != null) goto L12;
    L18:
        r8 = null;
        goto L19
    L13:
        return true;
    L22:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    @Override // kotlinx.coroutines.ce
    public boolean o_() {
        return true;
    }

    @Override // kotlinx.coroutines.ce
    public boolean p_() {
        return this.f17254b;
    }
}
