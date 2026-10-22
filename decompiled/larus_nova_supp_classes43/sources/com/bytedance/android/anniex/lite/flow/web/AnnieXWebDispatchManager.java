package com.bytedance.android.anniex.lite.flow.web;

import android.net.Uri;
import com.bytedance.android.anniex.lite.c;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.service.base.h;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXWebDispatchManager extends com.bytedance.android.anniex.lite.flow.base.b implements b {
    public final com.bytedance.android.anniex.lite.flow.model.a g;
    public WeakReference<AnnieXWebKit> h;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManager$1", f = "AnnieXWebDispatchManager.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AnnieXWebDispatchManager this$0;

        /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManager$1$a */
        public static final class a implements FlowCollector<AnnieXWebKit> {
            public final /* synthetic */ AnnieXWebDispatchManager a;

            public a(AnnieXWebDispatchManager r1) {
                this.a = r1;
            }

            public final Object emit(Object r10, Continuation r11) {
                AnnieXWebDispatchManager r12 = this.a;
                r12.h = new WeakReference((AnnieXWebKit) r10);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(AnnieXWebDispatchManager r1, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AnnieXWebDispatchManager r11 = this.this$0;
            com.bytedance.android.anniex.lite.flow.model.a r12 = r11.g;
            if (r12 == null) goto L16;
            b1 r13 = r12.e;
            if (r13 == null) goto L16;
            a r14 = new a(r11);
            this.label = 1;
            if (r13.collect(r14, this) != r0) goto L16;
            return r0;
        }
    }

    @Override // com.bytedance.android.anniex.lite.flow.web.b
    public final AnnieXWebKit d() {
        WeakReference<AnnieXWebKit> r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // com.bytedance.android.anniex.lite.flow.web.b
    public final void a() {
        if (h.A() == false) goto L6;
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
        return;
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.b
    public final void e() {
        super.e();
        WeakReference<AnnieXWebKit> r0 = this.h;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.e
    public final void onRelease() {
        e();
    }

    public final void f(oa.b r10) {
        Intrinsics.checkNotNullParameter(r10, "loadFlowTask");
        BuildersKt.launch$default(this.d, Dispatchers.getDefault(), null, new AnnieXWebDispatchManager$dispatchFlow$1(this, r10, null), 2, null);
    }

    public AnnieXWebDispatchManager(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        super(r10, r11);
        com.bytedance.android.anniex.lite.flow.base.model.a r12 = this.e;
        if (r12 == null) goto L5;
        com.bytedance.android.anniex.lite.flow.model.a r13 = (com.bytedance.android.anniex.lite.flow.model.a) r12.a(com.bytedance.android.anniex.lite.flow.model.a.class);
    L6:
        this.g = r13;
        BuildersKt.launch$default(this.d, Dispatchers.getDefault(), null, new AnonymousClass1(this, null), 2, null);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.android.anniex.lite.flow.web.b
    public final AnnieXWebModel b(String r10, Uri r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        return c.b(r10, r11, r12);
    }
}
