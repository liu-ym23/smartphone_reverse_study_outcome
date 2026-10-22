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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$initTakePictureHelper$2$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {760, 767}, m = "invokeSuspend", n = {}, s = {})
final class MultiAttachmentSelectorComponent$initTakePictureHelper$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ xp9.i $config;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {769}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ry9.a $resourceConfig;
        int label;
        final /* synthetic */ MultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(MultiAttachmentSelectorComponent r1, ry9.a r2, Continuation<? super AnonymousClass1> r3) {
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

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L14:
            MultiAttachmentSelectorComponent r10 = this.this$0;
            if (r10.R == null) goto L25;
            ICoreInputAbility r11 = (ICoreInputAbility) r10.p.getValue();
            if (r11 == null) goto L19;
            r11.g2(1, true);
        L19:
            ICoreInputAbility r2 = MultiAttachmentSelectorComponent.U2(this.this$0);
            if (r2 == null) goto L22;
            ICoreInputAbility.b.d(r2, String.valueOf(this.this$0.R), false, false, null, null, false, 62);
        L22:
            py9.a r12 = (py9.a) this.this$0.q.getValue();
            if (r12 == null) goto L25;
            r12.Bl("tryShowUpdateDialog");
        L25:
            Function0<Unit> r13 = this.this$0.U;
            if (r13 == null) goto L28;
            r13.invoke();
        L28:
            MultiAttachmentSelectorComponent r14 = this.this$0;
            r14.R = null;
            r14.U = null;
            ys8.a r15 = r14.d4();
            if (r15 == null) goto L31;
            r15.c00(this.this$0.S);
        L31:
            this.this$0.S = -1;
            if (com.larus.platform.exp.g.a() == false) goto L37;
            ICoreInputAbility r16 = MultiAttachmentSelectorComponent.U2(this.this$0);
            if (r16 == null) goto L37;
            r16.C1(false, false, "multimodal_input");
        L37:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            Function1<? super ry9.a, Unit> r17 = this.this$0.B;
            if (r17 == null) goto L11;
            r17.invoke(this.$resourceConfig);
        L11:
            MultiAttachmentSelectorComponent r18 = this.this$0;
            ry9.a r3 = this.$resourceConfig;
            this.label = 1;
            if (MultiAttachmentSelectorComponent.m3(r18, r3) != r0) goto L14;
            return r0;
        }
    }

    public MultiAttachmentSelectorComponent$initTakePictureHelper$2$1(MultiAttachmentSelectorComponent r1, xp9.i r2, Continuation<? super MultiAttachmentSelectorComponent$initTakePictureHelper$2$1> r3) {
        this.this$0 = r1;
        this.$config = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiAttachmentSelectorComponent$initTakePictureHelper$2$1(this.this$0, this.$config, r4);
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
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L11
    L17:
        ry9.a r9 = (ry9.a) r8;     // Catch: Throwable -> L11
        MultiAttachmentSelectorComponent.P2(this.this$0);
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, r9, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r4, this) != r0) goto L22;
        return r0;
    L13:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r10 = Dispatchers.getIO();     // Catch: Throwable -> L11
        MultiAttachmentSelectorComponent$initTakePictureHelper$2$1$resourceConfig$1 r3 = new MultiAttachmentSelectorComponent$initTakePictureHelper$2$1$resourceConfig$1(this.this$0, this.$config, null);     // Catch: Throwable -> L11
        this.label = 1;     // Catch: Throwable -> L11
        r8 = BuildersKt.withContext(r10, r3, this);     // Catch: Throwable -> L11
        if (r8 != r0) goto L17;
        return r0;
    L11:
        th = move-exception;
        MultiAttachmentSelectorComponent.P2(this.this$0);
        throw th;
    }
}
