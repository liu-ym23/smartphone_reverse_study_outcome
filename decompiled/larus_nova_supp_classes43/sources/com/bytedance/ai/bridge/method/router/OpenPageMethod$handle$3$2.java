package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.OpenPageMethod$handle$3$2", f = "OpenPageMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OpenPageMethod$handle$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletRuntime $appletRuntime;
    final /* synthetic */ f3.h<AbsOpenPageMethodIDL.b> $callback;
    final /* synthetic */ PageInfo $pageInfo;
    int label;

    public static final class a implements Function3<k2.j, Boolean, String, Unit> {
        public final /* synthetic */ f3.h<AbsOpenPageMethodIDL.b> a;

        public a(f3.h<AbsOpenPageMethodIDL.b> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10, Object r11, Object r12) {
            k2.j r13 = (k2.j) r10;
            boolean r14 = ((Boolean) r11).booleanValue();
            String r15 = (String) r12;
            Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_MSG);
            String r0 = null;
            if (r14 == false) goto L8;
            f3.h<AbsOpenPageMethodIDL.b> r16 = this.a;
            Intrinsics.checkNotNullParameter(AbsOpenPageMethodIDL.b.class, "<this>");
            BaseModel r1 = k3.c.a(AbsOpenPageMethodIDL.b.class);
            AbsOpenPageMethodIDL.b r17 = (AbsOpenPageMethodIDL.b) r1;
            if (r13 == null) goto L7;
            r0 = r13.getPageID();
        L7:
            r17.setViewId(r0);
            r17.setFloatingShowResult(StringsKt.toIntOrNull(r15));
            f3.h.a.b(r16, (ResultModel) r1);
        L10:
            return Unit.INSTANCE;
        L8:
            f3.h.a.a(this.a, r15, null, null, 14);
            goto L10
        }
    }

    public OpenPageMethod$handle$3$2(AppletRuntime r1, PageInfo r10, f3.h<AbsOpenPageMethodIDL.b> r11, Continuation<? super OpenPageMethod$handle$3$2> r12) {
        this.$appletRuntime = r1;
        this.$pageInfo = r10;
        this.$callback = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new OpenPageMethod$handle$3$2(this.$appletRuntime, this.$pageInfo, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        AppletRuntime r11 = this.$appletRuntime;
        if (r11 == null) goto L8;
        r11.r(this.$pageInfo, null, new a(this.$callback));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
