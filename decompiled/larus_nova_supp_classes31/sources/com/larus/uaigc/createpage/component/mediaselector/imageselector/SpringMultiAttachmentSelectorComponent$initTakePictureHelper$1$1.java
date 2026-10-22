package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {290, 294}, m = "invokeSuspend", n = {}, s = {})
final class SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ xp9.i $config;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ry9.a $resourceConfig;
        int label;
        final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(SpringMultiAttachmentSelectorComponent r1, ry9.a r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$resourceConfig = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$resourceConfig, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L14:
            SpringMultiAttachmentSelectorComponent r14 = this.this$0;
            if (r14.E == null) goto L25;
            ICoreInputAbility r15 = (ICoreInputAbility) r14.o.getValue();
            if (r15 == null) goto L19;
            r15.g2(1, true);
        L19:
            ICoreInputAbility r4 = SpringMultiAttachmentSelectorComponent.L2(this.this$0);
            if (r4 == null) goto L22;
            ICoreInputAbility.b.d(r4, String.valueOf(this.this$0.E), false, false, null, null, false, 62);
        L22:
            ICoreInputAbility r16 = SpringMultiAttachmentSelectorComponent.L2(this.this$0);
            if (r16 == null) goto L25;
            ICoreInputAbility.b.e(r16, "tryShowUpdateDialog", null, false, 6);
        L25:
            Function0<Unit> r17 = this.this$0.H;
            if (r17 == null) goto L28;
            r17.invoke();
        L28:
            SpringMultiAttachmentSelectorComponent r18 = this.this$0;
            r18.E = null;
            r18.H = null;
            ys8.a r19 = (ys8.a) r18.n.getValue();
            if (r19 == null) goto L31;
            r19.c00(this.this$0.F);
        L31:
            this.this$0.F = -1;
            if (com.larus.platform.exp.g.a() == false) goto L37;
            ICoreInputAbility r110 = SpringMultiAttachmentSelectorComponent.L2(this.this$0);
            if (r110 == null) goto L37;
            r110.C1(false, false, "multimodal_input");
        L37:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            Function1<? super ry9.a, Unit> r111 = this.this$0.u;
            if (r111 == null) goto L11;
            r111.invoke(this.$resourceConfig);
        L11:
            SpringMultiAttachmentSelectorComponent r112 = this.this$0;
            ry9.a r2 = this.$resourceConfig;
            this.label = 1;
            if (SpringMultiAttachmentSelectorComponent.N2(r112, r2) != r0) goto L14;
            return r0;
        }
    }

    public SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1(SpringMultiAttachmentSelectorComponent r1, xp9.i r2, Continuation<? super SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1> r3) {
        this.this$0 = r1;
        this.$config = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1(this.this$0, this.$config, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        SpringMultiAttachmentSelectorComponent r5 = this.this$0;
        AnonymousClass1 r4 = new AnonymousClass1(r5, (ry9.a) r8, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r4, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$resourceConfig$1 r3 = new SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$resourceConfig$1(this.this$0, this.$config, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r9, r3, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
