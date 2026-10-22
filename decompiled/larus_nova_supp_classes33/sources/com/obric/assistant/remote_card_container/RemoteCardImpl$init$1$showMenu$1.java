package com.obric.assistant.remote_card_container;

import android.os.IBinder;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import com.obric.assistant.remote_card_container.widget.RemoteCardContainer;
import com.obric.assistant.remote_card_container.widget.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.obric.assistant.remote_card_container.RemoteCardImpl$init$1$showMenu$1", f = "RemoteCardImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteCardImpl$init$1$showMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o9a.b $menuBean;
    int label;
    final /* synthetic */ RemoteCardImpl this$0;

    public RemoteCardImpl$init$1$showMenu$1(RemoteCardImpl r1, o9a.b r2, Continuation<? super RemoteCardImpl$init$1$showMenu$1> r3) {
        this.this$0 = r1;
        this.$menuBean = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RemoteCardImpl$init$1$showMenu$1(this.this$0, this.$menuBean, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [com.obric.assistant.remote_card_container.b] */
    /* JADX WARN: Type inference failed for: r13v8, types: [com.obric.assistant.remote_card_container.c] */
    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L63;
        ResultKt.throwOnFailure(r13);
        final RemoteCardImpl r14 = this.this$0;
        final o9a.b r0 = this.$menuBean;
        int r1 = RemoteCardImpl.c;
        r14.getClass();
        FLogger r2 = FLogger.a;
        r2.i("RemoteCardImpl", "showMenu: " + r0);
        RemoteCardContainer r3 = l.a.get();
        if (r3 != null) goto L7;
        r2.w("RemoteCardImpl", "no focus remote view");
    L61:
        return Unit.INSTANCE;
    L7:
        Intrinsics.checkNotNullParameter(r3, "<this>");
        pca.a r4 = r3.getParent();
        Unit r5 = null;
        if ((r4 instanceof ViewGroup) == false) goto L10;
        ViewGroup r6 = (ViewGroup) r4;
    L11:
        if (r6 == null) goto L19;
        if ((r6 instanceof pca.a) == true) goto L14;
        ViewParent r7 = r6.getParent();
        if ((r7 instanceof ViewGroup) == true) goto L17;
    L10:
        r3 = r3;
        r6 = null;
        goto L11
    L17:
        r6 = (ViewGroup) r7;
        goto L11
    L14:
        AttachReceiver r8 = ((pca.a) r6).getAttachReceiver();
    L20:
        if (r8 != null) goto L22;
        FLogger.a.w("RemoteCardImpl", "no attachReceiver");
        goto L61
    L22:
        u7 r9 = (u7) LazyKt.lazy(new j(r8)).getValue();
        if (r9 == null) goto L25;
        MessageAdapter r10 = r9.MF();
    L27:
        if ((r10 instanceof q0) == false) goto L29;
        MessageAdapter r11 = r10;
    L30:
        o9a.c r12 = (o9a.c) CollectionsKt.firstOrNull(r0.a);
        if (r12 == null) goto L35;
        IHostApiCallback r15 = r12.b;
        if (r15 == null) goto L35;
        final IBinder r16 = r15.asBinder();
    L36:
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        r18.element = new k(r16, r17);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L55
        yca.d r20 = yca.d.a;     // Catch: Throwable -> L55
        List r21 = r0.a;     // Catch: Throwable -> L55
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));     // Catch: Throwable -> L55
        Iterator r22 = r21.iterator();     // Catch: Throwable -> L55
    L39:
        if (r22.hasNext() == false) goto L41;
        r110.add(((o9a.c) r22.next()).a);     // Catch: Throwable -> L55
        goto L39
    L41:
        yca.e r111 = yca.d.a(r20, r3, r11, r110, new b(r0, r14), new c(r16, r18));     // Catch: Throwable -> L55
        r17.element = r111;     // Catch: Throwable -> L55
        if (r111 != null) goto L66;
    L53:
        Object r112 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L55
    L57:
        Throwable r113 = Result.exceptionOrNull-impl(r112);
        if (r113 == null) goto L61;
        FLogger.a.w("RemoteCardImpl", "showMenu failed: " + r113, r113);
        goto L61
    L66:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L48
        if (r16 == null) goto L46;
        r16.linkToDeath((IBinder.DeathRecipient) r18.element, 0);     // Catch: Throwable -> L48
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L48
    L46:
        Object r115 = Result.constructor-impl(r5);     // Catch: Throwable -> L48
    L50:
        Throwable r116 = Result.exceptionOrNull-impl(r115);     // Catch: Throwable -> L55
        if (r116 == null) goto L53;
        FLogger.a.w("RemoteCardImpl", "linkToDeath failed", r116);     // Catch: Throwable -> L55
        goto L53
    L48:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L55
        r115 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
    L35:
        r16 = null;
        goto L36
    L29:
        r11 = null;
        goto L30
    L25:
        r10 = null;
        goto L27
    L19:
        r8 = null;
        goto L20
    L68:
        r6 = null;
        goto L11
    L63:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
