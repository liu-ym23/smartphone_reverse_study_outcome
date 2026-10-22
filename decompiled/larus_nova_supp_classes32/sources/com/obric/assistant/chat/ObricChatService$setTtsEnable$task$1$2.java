package com.obric.assistant.chat;

import by9.a;
import com.larus.platform.api.g0;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.ObricChatService$setTtsEnable$task$1$2", f = "ObricChatService.kt", i = {}, l = {661, 672}, m = "invokeSuspend", n = {}, s = {})
public final class ObricChatService$setTtsEnable$task$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enable;
    final /* synthetic */ Ref.BooleanRef $hasClickedInUI;
    int label;
    final /* synthetic */ ObricChatService this$0;

    /* JADX INFO: renamed from: com.obric.assistant.chat.ObricChatService$setTtsEnable$task$1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.chat.ObricChatService$setTtsEnable$task$1$2$1", f = "ObricChatService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ ObricChatService this$0;

        public AnonymousClass1(ObricChatService r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$enable = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$enable, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L26;
            ResultKt.throwOnFailure(r9);
            FLogger r10 = FLogger.a;
            r10.i("ObricChatService", "AFTER PERFORM ! update the live data");
            ObricChatService r0 = this.this$0;
            boolean r2 = this.$enable;
            ComponentFeature r3 = r0.c;
            Boolean r4 = null;
            if (r3 == null) goto L9;
            t1a.b r5 = d.a(r3);
            if (r5 == null) goto L9;
            a r6 = (a) r5.getAbility(a.class);
        L10:
            if (r6 == null) goto L12;
            Boolean r7 = r6.L9();
        L13:
            StringBuilder r8 = new StringBuilder("updateTtsCheckedLiveData current is : ");
            r8.append(r7);
            r8.append(" desireValue is ");
            r8.append(r2);
            r8.append(" chatTitle Checked / Baned ?  ");
            g0 r11 = r0.t();
            if (r11 == null) goto L16;
            Boolean r12 = Boolean.valueOf(r11.getTtsChecked());
        L17:
            r8.append(r12);
            r8.append(" / ");
            g0 r1 = r0.t();
            if (r1 == null) goto L20;
            r4 = Boolean.valueOf(r1.getTtsBanned());
        L20:
            r8.append(r4);
            r10.i("ObricChatService", r8.toString());
            if (Intrinsics.areEqual(Boolean.valueOf(r2), r7) == false) goto L24;
            r6.M9();
        L24:
            return Unit.INSTANCE;
        L16:
            r12 = null;
            goto L17
        L12:
            r7 = null;
        L9:
            r6 = null;
            goto L10
        L26:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricChatService$setTtsEnable$task$1$2(Ref.BooleanRef r1, boolean r2, ObricChatService r3, Continuation<? super ObricChatService$setTtsEnable$task$1$2> r4) {
        this.$hasClickedInUI = r1;
        this.$enable = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricChatService$setTtsEnable$task$1$2(this.$hasClickedInUI, this.$enable, this.this$0, r5);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L19:
        FLogger r10 = FLogger.a;
        r10.i("ObricChatService", "AFTER PERFORM ! updateTitle");
        this.this$0.updateTitle();
        r10.i("ObricChatService", "AFTER PERFORM ! @ END @");
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L15:
        FLogger.a.i("ObricChatService", "AFTER PERFORM ! withTimeoutOrNull result is :" + ((Boolean) r9) + " , 【 Notes 】: null means Timeout , might set failue , value means the checked status ！");
    L16:
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$enable, null);
        this.label = 2;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("ObricChatService", "AFTER PERFORM ! start waiting to make sure the value is SET correctly! performClicked ? " + this.$hasClickedInUI.element + " want value is " + this.$enable);
        if (this.$hasClickedInUI.element == false) goto L16;
        ObricChatService$setTtsEnable$task$1$2$t$1 r12 = new ObricChatService$setTtsEnable$task$1$2$t$1(this.$enable, this.this$0, null);
        this.label = 1;
        r9 = TimeoutKt.c(1000, r12, this);
        if (r9 != r0) goto L15;
        return r0;
    }
}
