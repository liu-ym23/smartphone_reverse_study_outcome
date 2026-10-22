package com.bytedance.android.anniex.lite.flow.web.task;

import android.app.Application;
import com.bytedance.android.anniex.lite.flow.model.PreTaskSchemaModel;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.kit.web.impl.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2", f = "AnnieXWebEnginePreloadTask.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXWebEnginePreloadTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.android.anniex.lite.flow.base.model.a $input;
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ com.bytedance.android.anniex.lite.flow.web.task.a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "model", "", "enable", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2$1", f = "AnnieXWebEnginePreloadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<AnnieXWebModel, Boolean, Continuation<? super AnnieXWebModel>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(3, r10);
        }

        public final Object invoke(AnnieXWebModel r10, boolean r11, Continuation<? super AnnieXWebModel> r12) {
            AnonymousClass1 r0 = new AnonymousClass1(r12);
            r0.L$0 = r10;
            r0.Z$0 = r11;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10, Object r11) {
            return invoke((AnnieXWebModel) r1, ((Boolean) r10).booleanValue(), (Continuation) r11);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r10);
            AnnieXWebModel r11 = (AnnieXWebModel) this.L$0;
            if (this.Z$0 == true) goto L11;
            return null;
        L11:
            return r11;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements FlowCollector<AnnieXWebModel> {
        public final /* synthetic */ CoroutineScope a;
        public final /* synthetic */ Application b;
        public final /* synthetic */ com.bytedance.android.anniex.lite.flow.model.a c;

        public final Object emit(Object r11, Continuation r12) {
            AnnieXWebModel r10 = (AnnieXWebModel) r11;
            if (r10 == null) goto L8;
            boolean r13 = c.s;
            if (c.s == true) goto L8;
            BuildersKt.launch$default(this.a, Dispatchers.getMain(), null, new AnnieXWebEnginePreloadTask$work$2$2$1$1(this.b, null, r10, this.c, null), 2, null);
        L8:
            return Unit.INSTANCE;
        }

        public a(CoroutineScope r1, Application r10, com.bytedance.android.anniex.lite.flow.model.a r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public AnnieXWebEnginePreloadTask$work$2(com.bytedance.android.anniex.lite.flow.base.model.a r1, CoroutineScope r10, com.bytedance.android.anniex.lite.flow.web.task.a r11, Continuation<? super AnnieXWebEnginePreloadTask$work$2> r12) {
        this.$input = r1;
        this.$scope = r10;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AnnieXWebEnginePreloadTask$work$2(this.$input, this.$scope, null, r11);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Application r11 = h.h.b;
        com.bytedance.android.anniex.lite.flow.model.a r12 = (com.bytedance.android.anniex.lite.flow.model.a) this.$input.a(com.bytedance.android.anniex.lite.flow.model.a.class);
        PreTaskSchemaModel r13 = (PreTaskSchemaModel) this.$input.a(PreTaskSchemaModel.class);
        v0 r14 = new v0(r12.d, r13.f, new AnonymousClass1(null));
        a r15 = new a(this.$scope, r11, r12);
        this.label = 1;
        if (r14.collect(r15, this) != r0) goto L12;
        return r0;
    }
}
