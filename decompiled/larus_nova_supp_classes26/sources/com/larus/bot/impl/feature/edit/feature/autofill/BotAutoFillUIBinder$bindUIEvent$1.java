package com.larus.bot.impl.feature.edit.feature.autofill;

import android.content.Context;
import android.content.DialogInterface;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import t19.s;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/autofill/AutoFillUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillUIBinder$bindUIEvent$1", f = "BotAutoFillUIBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BotAutoFillUIBinder$bindUIEvent$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotAutoFillUIBinder this$0;

    public BotAutoFillUIBinder$bindUIEvent$1(BotAutoFillUIBinder r1, Continuation<? super BotAutoFillUIBinder$bindUIEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotAutoFillUIBinder$bindUIEvent$1 r0 = new BotAutoFillUIBinder$bindUIEvent$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r11);
        b r12 = (b) this.L$0;
        if (Intrinsics.areEqual(r12, b.a.a) == false) goto L17;
        final BotAutoFillUIBinder r13 = this.this$0;
        FragmentActivity r0 = r13.a.getActivity();
        if (r0 == null) goto L20;
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        CommonDialog.a r2 = new CommonDialog.a();
        int r3 = j0.a;
        r2.i(j0.d(2131901066));
        CommonDialog.a.f(r2, new f(r13, r1), j0.d(2131901065), false, 12);
        CommonDialog.a.e(r2, new g(r13, r1), j0.d(2131901064), 4);
        DialogInterface.OnDismissListener r4 = new e(r1, r13);
        Intrinsics.checkNotNullParameter(r4, "listener");
        r2.x = r4;
        CommonDialog r5 = r2.d(ContextCompat.getColor(r0, 2131103203));
        FragmentManager r6 = r13.a.getChildFragmentManager();
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, null, r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r5, r7) == false) goto L26;
    L13:
        dv8.b r8 = r13.d;
        if (r8 == null) goto L20;
        o3.a(r8.f(), r13.d.d(), r13.d.o(), r13.d.c(), "auto_fill", r13.d.i(), r13.d.h(), r13.a, 257);
        goto L20
    L26:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L12:
        r5.show(r6, null);
    L20:
        return Unit.INSTANCE;
    L17:
        if ((r12 instanceof b.C0054b) == false) goto L22;
        s r9 = s.a;
        Context r10 = this.this$0.a.getContext();
        String r14 = ((b.C0054b) r12).a.toString(this.this$0.a.getContext());
        r9.getClass();
        s.t(r10, r14);
        goto L20
    L22:
        throw new NoWhenBranchMatchedException();
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
