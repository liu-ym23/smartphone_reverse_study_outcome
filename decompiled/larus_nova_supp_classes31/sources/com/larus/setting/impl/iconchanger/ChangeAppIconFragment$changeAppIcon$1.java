package com.larus.setting.impl.iconchanger;

import android.content.Context;
import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common_ui.dialog.e0;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotUpdateType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$changeAppIcon$1", f = "ChangeAppIconFragment.kt", i = {}, l = {478, 478, 481}, m = "invokeSuspend", n = {}, s = {})
public final class ChangeAppIconFragment$changeAppIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ b $selectChangeAppIconData;
    int label;
    final /* synthetic */ ChangeAppIconFragment this$0;

    /* JADX INFO: renamed from: com.larus.setting.impl.iconchanger.ChangeAppIconFragment$changeAppIcon$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$changeAppIcon$1$1", f = "ChangeAppIconFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        final /* synthetic */ String $mainBotId;
        final /* synthetic */ b $selectChangeAppIconData;
        int label;
        final /* synthetic */ ChangeAppIconFragment this$0;

        /* JADX INFO: renamed from: com.larus.setting.impl.iconchanger.ChangeAppIconFragment$changeAppIcon$1$1$a */
        public static final class a implements IIMCallback<uc9.t> {
            public final /* synthetic */ ChangeAppIconFragment a;
            public final /* synthetic */ Function0<Unit> b;

            public final boolean mustInMain() {
                return true;
            }

            public final void onFailure(IIMError r8) {
                Intrinsics.checkNotNullParameter(r8, "error");
                Intrinsics.checkNotNullParameter(r8, "error");
                l0 r9 = (l0) this.a.y.getValue();
                if (r9 == null) goto L15;
                e0.b(r9, this.a.getActivity());
            L15:
                t19.s r1 = t19.s.a;     // Catch: Exception -> L12
                Context r2 = this.a.getContext();     // Catch: Exception -> L12
                Context r10 = this.a.getContext();     // Catch: Exception -> L12
                if (r10 == null) goto L9;
                String r11 = r10.getString(2131910883);     // Catch: Exception -> L12
                if (r11 == null) goto L9;
            L10:
                t19.s.j(r1, r2, r11, null, false, 28);     // Catch: Exception -> L12
                return;
            L9:
                r11 = "";
            L12:
                e = move-exception;
                FLogger.a.e("ChangeAppIconFragment", "get string failed e = " + e.getMessage());
            }

            public final void onSuccess(Object r2) {
                Intrinsics.checkNotNullParameter((uc9.t) r2, "result");
                l0 r3 = (l0) this.a.y.getValue();
                if (r3 == null) goto L5;
                e0.b(r3, this.a.getActivity());
            L5:
                Function0<Unit> r4 = this.b;
                if (r4 == null) goto L9;
                r4.invoke();
                return;
            }

            public a(ChangeAppIconFragment r1, Function0<Unit> r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public AnonymousClass1(b r1, ChangeAppIconFragment r2, String r3, Function0<Unit> r4, Continuation<? super AnonymousClass1> r5) {
            this.$selectChangeAppIconData = r1;
            this.this$0 = r2;
            this.$mainBotId = r3;
            this.$callback = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$selectChangeAppIconData, this.this$0, this.$mainBotId, this.$callback, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r31) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r31);
            BotUpdateType r3 = BotUpdateType.OTHERS;
            String r7 = this.$selectChangeAppIconData.i.d();
            String r13 = this.this$0.i;
            String r14 = this.$selectChangeAppIconData.i.b();
            Integer r1 = this.$selectChangeAppIconData.g;
            if (r1 == null) goto L7;
            String r2 = r1.toString();
        L8:
            String r4 = this.$mainBotId;
            Boolean r12 = Boxing.boxBoolean(false);
            uc9.s r5 = new uc9.s(r3, r4, null, null, r7, null, null, null, null, r12, r13, r14, r2, null, null, null, null, null, null, null, null, null, null, null, null, null, 67101164);
            com.larus.im.d.a().updateBot(r5, new a(this.this$0, this.$callback));
            return Unit.INSTANCE;
        L7:
            r2 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChangeAppIconFragment$changeAppIcon$1(ChangeAppIconFragment r1, b r2, Function0<Unit> r3, Continuation<? super ChangeAppIconFragment$changeAppIcon$1> r4) {
        this.this$0 = r1;
        this.$selectChangeAppIconData = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChangeAppIconFragment$changeAppIcon$1(this.this$0, this.$selectChangeAppIconData, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_setting_impl_iconchanger_ChangeAppIconFragment$changeAppIcon$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L31:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L20:
        List r11 = (List) r10;
        if (r11 == null) goto L33;
        String r6 = (String) CollectionsKt.firstOrNull(r11);
        if (r6 == null) goto L33;
        l0 r12 = (l0) this.this$0.y.getValue();
        if (r12 == null) goto L27;
        INVOKEVIRTUAL_com_larus_setting_impl_iconchanger_ChangeAppIconFragment$changeAppIcon$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r12);
    L27:
        CoroutineDispatcher r13 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$selectChangeAppIconData, this.this$0, r6, this.$callback, null);
        this.label = 3;
        if (BuildersKt.withContext(r13, r2, this) != r0) goto L31;
        return r0;
    L33:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r10);
    L15:
        wc9.e r14 = (wc9.e) r10;
        if (r14 == null) goto L33;
        this.label = 2;
        r10 = ic8.n.c(r14, this);
        if (r10 != r0) goto L20;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        Flow r15 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        ChangeAppIconFragment$changeAppIcon$1$mainBotId$1 r3 = new ChangeAppIconFragment$changeAppIcon$1$mainBotId$1(null);
        this.label = 1;
        r10 = kotlinx.coroutines.flow.e.u(r15, r3, this);
        if (r10 != r0) goto L15;
        return r0;
    }
}
