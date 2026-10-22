package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.o8;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u000e\u001a\u00020\b2\u0015\u0010\u0004\u001a\u00110\u0000¢\u0006\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u000324\u0010\u000b\u001a0\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t¢\u0006\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/o8;", "Lkotlin/ParameterName;", "name", "reserverRecord", "p1", "Lkotlin/Function1;", "", "type", "", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/NotifyReplyReserveInfo;", "notifyReplyReserveInfo", "p2", "invoke", "(Lcom/bytedance/android/livesdk/link/model/o8;Lkotlin/jvm/functions/Function1;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class InteractPkReserveView$updateAdapterItemList$2 extends FunctionReferenceImpl implements Function2<o8, Function1<? super Integer, ? extends Unit>, Unit> {
    public InteractPkReserveView$updateAdapterItemList$2(InteractPkReserveView r8) {
        super(2, r8, InteractPkReserveView.class, "openReserveReplyDialog", "openReserveReplyDialog(Lcom/bytedance/android/livesdk/link/model/IReserveRecord;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkReserveView, java.lang.Object] */
    public final void invoke(o8 r14, Function1<? super Integer, Unit> r15) {
        Intrinsics.checkNotNullParameter(r14, "p1");
        Intrinsics.checkNotNullParameter(r15, "p2");
        ?? r0 = (InteractPkReserveView) ((CallableReference) this).receiver;
        int r1 = InteractPkReserveView.j;
        r0.getClass();
        long r3 = r0.h;
        String r2 = r14.getUser().getUserId();
        if (r2 != null) goto L5;
        String r5 = "";
    L6:
        long r6 = r14.getRoom().getRoomId();
        String r8 = r14.getBattleAttachedInfo();
        String r9 = r14.getReserveId();
        String r4 = r14.getUser().getUserId();
        if (r4 != null) goto L9;
        String r10 = "";
    L10:
        o r7 = new o(r3, r5, r6, r8, r9, r10, 8);
        Context r12 = r0.getContext();
        IBaseUser r16 = r14.getUser();
        if (r16 == null) goto L16;
        String r17 = r16.getRealNickName();
        if (r17 == null) goto L16;
        String r13 = r17;
    L17:
        AnchorReplyReserveDialog r18 = new AnchorReplyReserveDialog(r12, r7, r13, r0.f, r15);
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r18);
    L22:
        Function1<? super Boolean, Unit> r19 = r0.f;
        if (r19 == null) goto L29;
        Unit r110 = (Unit) r19.invoke(Boolean.TRUE);
        return;
    L29:
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L21:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
    L16:
        r13 = "";
        goto L17
    L9:
        r10 = r4;
        goto L10
    L5:
        r5 = r2;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((o8) r1, (Function1) r2);
        return Unit.INSTANCE;
    }
}
