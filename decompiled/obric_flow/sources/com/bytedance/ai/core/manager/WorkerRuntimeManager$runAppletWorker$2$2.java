package com.bytedance.ai.core.manager;

import android.content.Context;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.utils.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/AppletRuntime;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager$runAppletWorker$2$2", f = "WorkerRuntimeManager.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
final class WorkerRuntimeManager$runAppletWorker$2$2 extends SuspendLambda implements Function1<Continuation<? super AppletRuntime>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f2111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2113c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ b e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f2114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f2115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f2116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SessionType f2117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Map f2118l;

    public WorkerRuntimeManager$runAppletWorker$2$2(String r5, Ref.ObjectRef r10, b r11, Context r12, String r13, String r14, String r15, String r16, SessionType r17, Map r18, Continuation r19) {
        this.f2113c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.f2114h = r14;
        this.f2115i = r15;
        this.f2116j = r16;
        this.f2117k = r17;
        this.f2118l = r18;
        super(1, r19);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation r14) {
        return new WorkerRuntimeManager$runAppletWorker$2$2(this.f2113c, this.d, this.e, this.f, this.g, this.f2114h, this.f2115i, this.f2116j, this.f2117k, this.f2118l, r14);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AppletRuntime> r5) {
        return ((WorkerRuntimeManager$runAppletWorker$2$2) create(r5)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2112b;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        Ref.ObjectRef r11 = this.f2111a;
        ResultKt.throwOnFailure(r14);
        T r15 = r14;
    L15:
        r11.element = r15;
        return this.d.element;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        String r16 = ug.a.c(new StringBuilder("runApplet "), this.f2113c, " Inner", "WorkerRuntimeManager");
        d r12 = c.f2846a;
        if (r12 == null) goto L11;
        r12.i("WorkerRuntimeManager", r16);
    L11:
        Ref.ObjectRef r17 = this.d;
        b r13 = this.e;
        String r18 = this.f2113c;
        Context r19 = this.f;
        String r20 = this.g;
        String r21 = this.f2114h;
        String r22 = this.f2115i;
        String r23 = this.f2116j;
        SessionType r110 = this.f2117k;
        Map r111 = this.f2118l;
        this.f2111a = r17;
        this.f2112b = 1;
        Object r24 = b.a(r13, r18, r19, r20, r21, r22, r23, r110, r111, this);
        if (r24 != r5) goto L14;
        return r5;
    L14:
        r11 = r17;
        r15 = r24;
        goto L15
    }
}
