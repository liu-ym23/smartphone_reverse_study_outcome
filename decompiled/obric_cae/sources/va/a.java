package va;

import ae.d;
import ce.c;
import ce.e;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;

/* JADX INFO: loaded from: classes.dex */
@e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", l = {IdlErrors.E_RejectInferDeviceOverheat}, m = "getPackageResource-0E7RQCE")
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIKernelApi f12777b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12778m;

    public a(AIKernelApi r8, d<? super a> r10) {
        this.f12777b = r8;
        super(r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        this.f12776a = r8;
        this.f12778m |= Integer.MIN_VALUE;
        Object r10 = AIKernelApi.a(this.f12777b, null, null, this);
        if (r10 != be.a.f3165a) goto L6;
        return r10;
    L6:
        return new xd.e(r10);
    }
}
