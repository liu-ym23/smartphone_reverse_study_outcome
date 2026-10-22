package com.obric.assistant.remote_card_container;

import android.content.DialogInterface;
import android.os.IBinder;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.account.base.api.ILoginService;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.RemoteCardImpl$init$1$showDialog$1", f = "RemoteCardImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteCardImpl$init$1$showDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o9a.a $dialogBean;
    int label;
    final /* synthetic */ RemoteCardImpl this$0;

    public RemoteCardImpl$init$1$showDialog$1(RemoteCardImpl r1, o9a.a r2, Continuation<? super RemoteCardImpl$init$1$showDialog$1> r3) {
        this.this$0 = r1;
        this.$dialogBean = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RemoteCardImpl$init$1$showDialog$1(this.this$0, this.$dialogBean, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L54;
        ResultKt.throwOnFailure(r12);
        if (ILoginService.a.getAccountInfo().a == true) goto L8;
        FLogger.a.w("RemoteCardImpl", "user is not login, cannot show dialog");
        return Unit.INSTANCE;
    L8:
        final RemoteCardImpl r13 = this.this$0;
        o9a.a r1 = this.$dialogBean;
        int r2 = RemoteCardImpl.c;
        r13.getClass();
        FragmentActivity r3 = ObricChatContextServiceDelegate.b.d();
        if (r3 != null) goto L11;
        FLogger.a.w("RemoteCardImpl", "chatActivity is null, cannot show dialog");
    L52:
        return Unit.INSTANCE;
    L11:
        FragmentManager r4 = r3.getSupportFragmentManager();
        FLogger.a.i("RemoteCardImpl", "show remote card dialog: " + r1);
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        IHostApiCallback r6 = r1.e;
        if (r6 != null) goto L14;
        r6 = r1.f;
    L14:
        Unit r7 = null;
        if (r6 == null) goto L17;
        final IBinder r8 = r6.asBinder();
    L18:
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = new i(r8, r5);
        CommonDialog.a r10 = new CommonDialog.a();
        String r11 = r1.a;
        String r14 = "";
        if (r11 != null) goto L21;
        r11 = "";
    L21:
        Intrinsics.checkNotNullParameter(r11, "title");
        r10.a = r11;
        String r15 = r1.b;
        if (r15 == null) goto L25;
        r14 = r15;
    L25:
        Intrinsics.checkNotNullParameter(r14, "message");
        r10.i = r14;
        r10.b = o0.d(r1.b);
        final IHostApiCallback r16 = r1.e;
        if (r16 == null) goto L28;
        CommonDialog.a.e(r10, new RemoteCardImpl$showDialog$1$1$1(r13, r16), r1.c, 4);
    L28:
        final IHostApiCallback r17 = r1.f;
        if (r17 == null) goto L31;
        CommonDialog.a.f(r10, new RemoteCardImpl$showDialog$1$2$1(r13, r17), r1.d, false, 12);
    L31:
        DialogInterface.OnDismissListener r18 = new a(r8, r9);
        Intrinsics.checkNotNullParameter(r18, "listener");
        r10.x = r18;
        CommonDialog r19 = r10.a();
        r5.element = r19;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L34
        r19.T90(r4, "remote_card_dialog");     // Catch: Throwable -> L34
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r21 = Result.exceptionOrNull-impl(r110);
        if (r21 == null) goto L40;
        FLogger.a.w("RemoteCardImpl", "show dialog failed: " + r21, r21);
    L40:
        if (Result.isSuccess-impl(r110) == false) goto L52;
        Unit r111 = (Unit) r110;
        FLogger.a.w("RemoteCardImpl", "show dialog succeed");
        if (r8 != null) goto L55;
    L44:
        Object r112 = Result.constructor-impl(r7);     // Catch: Throwable -> L46
    L48:
        Throwable r113 = Result.exceptionOrNull-impl(r112);
        if (r113 == null) goto L52;
        FLogger.a.w("RemoteCardImpl", "linkToDeath failed", r113);
    L46:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L55:
        r8.linkToDeath((IBinder.DeathRecipient) r9.element, 0);     // Catch: Throwable -> L46
        r7 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L34:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L17:
        r8 = null;
        goto L18
    L54:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
