package com.larus.bmhome.view.actionbar.custom;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.InstructionInputComponent;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$5", f = "CustomActionBar.kt", i = {0}, l = {1587, 1595}, m = "invokeSuspend", n = {"sourceConversationId"}, s = {"L$0"})
public final class CustomActionBar$onCustomActionBarClick$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bizArgs;
    final /* synthetic */ aq8.e $instructionExtraData;
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
    final /* synthetic */ int $openFrom;
    Object L$0;
    int label;
    final /* synthetic */ CustomActionBar this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$5$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$5$1", f = "CustomActionBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $bizArgs;
        final /* synthetic */ aq8.e $instructionExtraData;
        final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
        final /* synthetic */ int $openFrom;
        final /* synthetic */ String $sourceConversationId;
        int label;
        final /* synthetic */ CustomActionBar this$0;

        public AnonymousClass1(CustomActionBar r1, String r2, com.larus.bmhome.actionbar.model.z0 r3, int r4, aq8.e r5, Bundle r6, Continuation<? super AnonymousClass1> r7) {
            this.this$0 = r1;
            this.$sourceConversationId = r2;
            this.$item = r3;
            this.$openFrom = r4;
            this.$instructionExtraData = r5;
            this.$bizArgs = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass1(this.this$0, this.$sourceConversationId, this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L62;
            ResultKt.throwOnFailure(r10);
            CustomActionBarViewModel r11 = this.this$0.o;
            boolean r0 = false;
            Boolean r2 = null;
            if (r11 == null) goto L16;
            String r12 = r11.getConversationId();
            if (r12 == null) goto L16;
            if (com.larus.utils.o0.d(r12) == true) goto L11;
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
            String r8 = r7.Y1();
        L28:
            if (r7 == null) goto L52;
            if (r12 == null) goto L52;
            if (Intrinsics.areEqual(r8, this.$sourceConversationId) == false) goto L52;
            Lazy r9 = com.larus.im.j.a;
            if (com.larus.im.j.f(this.$sourceConversationId) == false) goto L52;
            String r13 = r7.getBotId();
            CustomActionBar r14 = this.this$0;
            if (r13.length() != 0) goto L37;
            boolean r15 = true;
        L38:
            if (r15 == false) goto L46;
            ChatParam r16 = r14.h;
            if (r16 == null) goto L42;
            r13 = r16.b;
        L43:
            if (r13 != null) goto L46;
            r13 = "";
            goto L46
        L42:
            r13 = null;
        L46:
            if (r13.length() <= 0) goto L49;
            r0 = true;
        L49:
            if (r0 == false) goto L51;
            FLogger.a.i("CustomActionBar", "sync remote conversation to host, localCvsId=" + r8 + ", remoteCvsId=" + r12);
            r7.updateConversationId(r12, r13);
            goto L52
        L51:
            FLogger.a.e("CustomActionBar", "sync remote conversation to host failed, botId is empty");
            goto L52
        L37:
            r15 = false;
        L52:
            vp8.k r17 = this.this$0.K;
            if (r17 == null) goto L56;
            r2 = Boxing.boxBoolean(r17.c(this.$item));
        L56:
            if (Intrinsics.areEqual(r2, Boxing.boxBoolean(true)) == true) goto L58;
            CustomActionBar.r(this.this$0, this.$item, null, this.$openFrom, null, this.$instructionExtraData, this.$bizArgs, 8);
            return Unit.INSTANCE;
        L58:
            return Unit.INSTANCE;
        L27:
            r8 = null;
        L24:
            r7 = null;
            goto L25
        L11:
            if (com.larus.im.j.f(r12) == true) goto L13;
            r3 = true;
        L16:
            r12 = null;
            goto L17
        L62:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CustomActionBar$onCustomActionBarClick$5(CustomActionBar r1, com.larus.bmhome.actionbar.model.z0 r2, int r3, aq8.e r4, Bundle r5, Continuation<? super CustomActionBar$onCustomActionBarClick$5> r6) {
        this.this$0 = r1;
        this.$item = r2;
        this.$openFrom = r3;
        this.$instructionExtraData = r4;
        this.$bizArgs = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CustomActionBar$onCustomActionBarClick$5(this.this$0, this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs, r9);
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
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L33:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L12
        String r3 = r2;
    L23:
        boolean r16 = ((Boolean) r15).booleanValue();     // Catch: Throwable -> L12
        r1 = r3;
    L25:
        if (r16 == true) goto L29;
        FLogger.a.d("CustomActionBar", "reject jump! check remote conv failed!");     // Catch: Throwable -> L12
        return Unit.INSTANCE;
    L29:
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, r1, this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r17, r4, this) != r0) goto L33;
        return r0;
    L14:
        ResultKt.throwOnFailure(r15);
        CustomActionBarViewModel r18 = this.this$0.o;
        if (r18 == null) goto L17;
        String r5 = r18.getConversationId();
    L18:
        CustomActionBarViewModel r19 = this.this$0.o;     // Catch: Throwable -> L12
        if (r19 == null) goto L24;
        this.L$0 = r5;     // Catch: Throwable -> L12
        this.label = 1;     // Catch: Throwable -> L12
        r15 = r19.checkCoCoCOnvRemote(this);     // Catch: Throwable -> L12
        r3 = r5;
        if (r15 != r0) goto L23;
        return r0;
    L24:
        r16 = false;
        r1 = r5;
        goto L25
    L17:
        r5 = null;
    L12:
        th = move-exception;
        FLogger.a.e("CustomActionBar", "check schema err! msg=" + th.getMessage());
        goto L29
    }
}
