package com.larus.bmhome.view.actionbar.custom;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.InstructionInputComponent;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$6", f = "CustomActionBar.kt", i = {0}, l = {1640, 1648}, m = "invokeSuspend", n = {"sourceConversationId"}, s = {"L$0"})
public final class CustomActionBar$onCustomActionBarClick$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bizArgs;
    final /* synthetic */ aq8.e $instructionExtraData;
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
    final /* synthetic */ int $openFrom;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CustomActionBar this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$6$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$6$4", f = "CustomActionBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $bizArgs;
        final /* synthetic */ aq8.e $instructionExtraData;
        final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
        final /* synthetic */ int $openFrom;
        final /* synthetic */ String $sourceConversationId;
        int label;
        final /* synthetic */ CustomActionBar this$0;

        public AnonymousClass4(CustomActionBar r1, String r2, com.larus.bmhome.actionbar.model.z0 r3, int r4, aq8.e r5, Bundle r6, Continuation<? super AnonymousClass4> r7) {
            this.this$0 = r1;
            this.$sourceConversationId = r2;
            this.$item = r3;
            this.$openFrom = r4;
            this.$instructionExtraData = r5;
            this.$bizArgs = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass4(this.this$0, this.$sourceConversationId, this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L54;
            ResultKt.throwOnFailure(r8);
            CustomActionBarViewModel r9 = this.this$0.o;
            boolean r0 = false;
            String r2 = null;
            if (r9 == null) goto L16;
            String r10 = r9.getConversationId();
            if (r10 == null) goto L16;
            if (com.larus.utils.o0.d(r10) == true) goto L11;
        L13:
            boolean r3 = false;
        L14:
            if (r3 == false) goto L16;
        L17:
            InstructionInputComponent r4 = this.this$0.i;
            if (r4 == null) goto L24;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            Fragment r5 = com.larus.ui.arch.component.internal.attach.a.b(r4, r4);
            if (r5 == null) goto L24;
            t1a.b r6 = s1a.a.g(r5);
            if (r6 == null) goto L24;
            com.larus.bmhome.chat.component.cvs.y r7 = (com.larus.bmhome.chat.component.cvs.y) r6.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        L25:
            if (r7 == null) goto L27;
            String r11 = r7.Y1();
        L28:
            if (r7 == null) goto L51;
            if (r10 == null) goto L51;
            if (Intrinsics.areEqual(r11, this.$sourceConversationId) == false) goto L51;
            Lazy r12 = com.larus.im.j.a;
            if (com.larus.im.j.f(this.$sourceConversationId) == false) goto L51;
            String r13 = r7.getBotId();
            CustomActionBar r14 = this.this$0;
            if (r13.length() != 0) goto L37;
            boolean r15 = true;
        L38:
            if (r15 == false) goto L46;
            ChatParam r16 = r14.h;
            if (r16 == null) goto L42;
            r2 = r16.b;
        L42:
            if (r2 != null) goto L44;
            r2 = "";
        L44:
            r13 = r2;
        L46:
            if (r13.length() <= 0) goto L48;
            r0 = true;
        L48:
            if (r0 == false) goto L50;
            r7.updateConversationId(r10, r13);
            goto L51
        L50:
            FLogger.a.e("CustomActionBar", "sync remote conversation to host failed, botId is empty");
            goto L51
        L37:
            r15 = false;
        L51:
            this.this$0.s(this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs);
            return Unit.INSTANCE;
        L27:
            r11 = null;
        L24:
            r7 = null;
            goto L25
        L11:
            if (com.larus.im.j.f(r10) == true) goto L13;
            r3 = true;
        L16:
            r10 = null;
            goto L17
        L54:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CustomActionBar$onCustomActionBarClick$6(CustomActionBar r1, com.larus.bmhome.actionbar.model.z0 r2, int r3, aq8.e r4, Bundle r5, Continuation<? super CustomActionBar$onCustomActionBarClick$6> r6) {
        this.this$0 = r1;
        this.$item = r2;
        this.$openFrom = r3;
        this.$instructionExtraData = r4;
        this.$bizArgs = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        CustomActionBar$onCustomActionBarClick$6 r7 = new CustomActionBar$onCustomActionBarClick$6(this.this$0, this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L41:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L12
        String r3 = r2;
    L24:
        Boolean r15 = (Boolean) r14;     // Catch: Throwable -> L12
        r1 = r3;
    L26:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L12
        ?? r4 = r1;
    L29:
        ?? r7 = r4;
        if (Result.isSuccess-impl(r16) == true) goto L32;
    L34:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L37;
        FLogger.a.e("CustomActionBar", "check remote conv err! msg=" + r17.getMessage());
    L37:
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        AnonymousClass4 r5 = new AnonymousClass4(this.this$0, r7, this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r18, r5, this) != r0) goto L41;
        return r0;
    L32:
        if (Intrinsics.areEqual((Boolean) r16, Boxing.boxBoolean(false)) == false) goto L34;
        FLogger.a.d("CustomActionBar", "continue jump, check remote conv failed!");
        goto L34
    L14:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        CustomActionBarViewModel r110 = this.this$0.o;
        if (r110 == null) goto L17;
        String r6 = r110.getConversationId();
    L18:
        CustomActionBar r111 = this.this$0;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L12
        CustomActionBarViewModel r112 = r111.o;     // Catch: Throwable -> L12
        if (r112 == null) goto L25;
        this.L$0 = r6;     // Catch: Throwable -> L12
        this.label = 1;     // Catch: Throwable -> L12
        r14 = r112.checkCoCoCOnvRemote(this);     // Catch: Throwable -> L12
        r3 = r6;
        if (r14 != r0) goto L24;
        return r0;
    L25:
        r15 = null;
        r1 = r6;
        goto L26
    L17:
        r6 = null;
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        r4 = r1;
        goto L29
    }
}
