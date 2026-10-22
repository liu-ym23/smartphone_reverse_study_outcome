package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {321, 328}, m = "invokeSuspend", n = {}, s = {})
final class SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $albumUri;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {330}, m = "invokeSuspend", n = {}, s = {})
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

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L14:
            SpringMultiAttachmentSelectorComponent r12 = this.this$0;
            if (r12.E == null) goto L25;
            ICoreInputAbility r13 = (ICoreInputAbility) r12.o.getValue();
            if (r13 == null) goto L19;
            r13.g2(1, true);
        L19:
            ICoreInputAbility r2 = SpringMultiAttachmentSelectorComponent.L2(this.this$0);
            if (r2 == null) goto L22;
            ICoreInputAbility.b.d(r2, String.valueOf(this.this$0.E), false, false, null, null, false, 62);
        L22:
            ICoreInputAbility r14 = SpringMultiAttachmentSelectorComponent.L2(this.this$0);
            if (r14 == null) goto L25;
            ICoreInputAbility.b.e(r14, "tryShowUpdateDialog", null, false, 6);
        L25:
            Function0<Unit> r15 = this.this$0.H;
            if (r15 == null) goto L28;
            r15.invoke();
        L28:
            SpringMultiAttachmentSelectorComponent r16 = this.this$0;
            r16.E = null;
            r16.H = null;
            ys8.a r17 = (ys8.a) r16.n.getValue();
            if (r17 == null) goto L31;
            r17.c00(this.this$0.F);
        L31:
            this.this$0.F = -1;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            Function1<? super ry9.a, Unit> r18 = this.this$0.u;
            if (r18 == null) goto L11;
            r18.invoke(this.$resourceConfig);
        L11:
            SpringMultiAttachmentSelectorComponent r19 = this.this$0;
            ry9.a r3 = this.$resourceConfig;
            this.label = 1;
            if (SpringMultiAttachmentSelectorComponent.N2(r19, r3) != r0) goto L14;
            return r0;
        }
    }

    public SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1(Uri r1, SpringMultiAttachmentSelectorComponent r2, Continuation<? super SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1> r3) {
        this.$albumUri = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1(this.$albumUri, this.this$0, r4);
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
        SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1$resourceConfig$1 r3 = new SpringMultiAttachmentSelectorComponent$initTakePictureHelper$2$1$1$resourceConfig$1(this.$albumUri, this.this$0, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r9, r3, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
