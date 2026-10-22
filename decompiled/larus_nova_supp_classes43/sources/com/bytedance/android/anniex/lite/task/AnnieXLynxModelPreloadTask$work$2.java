package com.bytedance.android.anniex.lite.task;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.lite.flow.model.PreTaskSchemaModel;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.v0;
import t36.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLynxModelPreloadTask$work$2", f = "AnnieXLynxModelPreloadTask.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {39, 42, 44, 66}, m = "invokeSuspend", n = {"loadStateModel", "preTaskModel", "schemaModelUnion", "loadStateModel", "preTaskModel", "schemaModelUnion", "loadStateModel", "preTaskModel"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
final class AnnieXLynxModelPreloadTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.android.anniex.lite.flow.base.model.a $input;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ d this$0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.task.AnnieXLynxModelPreloadTask$work$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lt36/j;", "schemaModelUnion", "", "enable", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLynxModelPreloadTask$work$2$2", f = "AnnieXLynxModelPreloadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<j, Boolean, Continuation<? super j>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r10) {
            super(3, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10, Object r11) {
            return invoke((j) r1, ((Boolean) r10).booleanValue(), (Continuation) r11);
        }

        public final Object invoke(j r10, boolean r11, Continuation<? super j> r12) {
            AnonymousClass2 r0 = new AnonymousClass2(r12);
            r0.L$0 = r10;
            r0.Z$0 = r11;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r10);
            j r11 = (j) this.L$0;
            if (this.Z$0 == true) goto L11;
            return null;
        L11:
            return r11;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements FlowCollector<j> {
        public a(qa.b r1) {
        }

        public final Object emit(Object r1, Continuation r10) {
            j r11 = (j) r1;
            if (r11 == null) goto L12;
            String r12 = (String) r11.a.c().get(com.bytedance.android.ec.core.event.a.KEY_URL);
            if (r12 != null) goto L7;
        L8:
            Uri r13 = Uri.EMPTY;
        L9:
            com.bytedance.android.anniex.lite.b r14 = com.bytedance.android.anniex.lite.b.a;
            throw null;
        L7:
            if (UriProtector.parse(r12) != null) goto L9;
        L12:
            return Unit.INSTANCE;
        }
    }

    public AnnieXLynxModelPreloadTask$work$2(com.bytedance.android.anniex.lite.flow.base.model.a r1, d r10, Continuation<? super AnnieXLynxModelPreloadTask$work$2> r11) {
        this.$input = r1;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AnnieXLynxModelPreloadTask$work$2(this.$input, null, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 != 0) goto L5;
        ResultKt.throwOnFailure(r11);
        qa.b r12 = (qa.b) this.$input.a(qa.b.class);
        PreTaskSchemaModel r13 = (PreTaskSchemaModel) this.$input.a(PreTaskSchemaModel.class);
        LruCache<String, AnnieXWebModel> r14 = com.bytedance.android.anniex.lite.c.a;
        throw null;
    L5:
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L12;
        if (r1 != 4) goto L11;
        ResultKt.throwOnFailure(r11);
    L27:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        PreTaskSchemaModel r10 = (PreTaskSchemaModel) this.L$1;
        qa.b r15 = (qa.b) this.L$0;
        ResultKt.throwOnFailure(r11);
    L23:
        v0 r16 = new v0(r15.c, r10.d, new AnonymousClass2(null));
        a r17 = new a(r15);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 4;
        if (r16.collect(r17, this) != r0) goto L27;
        return r0;
    L13:
        j r18 = (j) this.L$2;
        PreTaskSchemaModel r19 = (PreTaskSchemaModel) this.L$1;
        qa.b r20 = (qa.b) this.L$0;
        ResultKt.throwOnFailure(r11);
        j r110 = r18;
        r10 = r19;
        r15 = r20;
    L20:
        this.L$0 = r15;
        this.L$1 = r10;
        this.L$2 = null;
        this.label = 3;
        r15.b.setValue(r110);
        Unit r111 = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r111 != r0) goto L23;
        return r0;
    L14:
        j r21 = (j) this.L$2;
        PreTaskSchemaModel r22 = (PreTaskSchemaModel) this.L$1;
        qa.b r23 = (qa.b) this.L$0;
        ResultKt.throwOnFailure(r11);
        Lazy r112 = SchemaService.f;
        SchemaService r113 = SchemaService.a.a();
        t36.d r24 = r21.a;
        r113.getClass();
        pa.a r114 = (pa.a) SchemaService.d(r24, pa.a.class);
        if (r114 == null) goto L19;
        this.L$0 = r23;
        this.L$1 = r22;
        this.L$2 = r21;
        this.label = 2;
        if (r22.b(r114, this) != r0) goto L19;
        return r0;
    L19:
        r110 = r21;
        r10 = r22;
        r15 = r23;
        goto L20
    }
}
