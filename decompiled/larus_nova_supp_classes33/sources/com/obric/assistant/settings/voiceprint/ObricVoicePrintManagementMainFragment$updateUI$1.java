package com.obric.assistant.settings.voiceprint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.obric.assistant.impl.databinding.ObricFragmentVoicePrintManagementBinding;
import com.obric.assistant.t1;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementMainFragment$updateUI$1", f = "ObricVoicePrintManagementMainFragment.kt", i = {0, 0, 1, 1}, l = {183, 294}, m = "invokeSuspend", n = {"vb", "context", "recordedAccessories", "isVoicePrintExisted"}, s = {"L$0", "L$1", "L$0", "Z$0"})
public final class ObricVoicePrintManagementMainFragment$updateUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ ObricVoicePrintManagementMainFragment this$0;

    public ObricVoicePrintManagementMainFragment$updateUI$1(ObricVoicePrintManagementMainFragment r1, Continuation<? super ObricVoicePrintManagementMainFragment$updateUI$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricVoicePrintManagementMainFragment$updateUI$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        AttributeSet r4 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        List r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r19);
        ((Boolean) r19).booleanValue();
        int r5 = 8;
    L94:
        ObricFragmentVoicePrintManagementBinding r6 = this.this$0.e;
        if (r6 == null) goto L99;
        r6.e.setVisibility(r5);
    L99:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        final Context r7 = (Context) this.L$1;
        ObricFragmentVoicePrintManagementBinding r8 = (ObricFragmentVoicePrintManagementBinding) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r9 = r19;
    L18:
        boolean r10 = ((Boolean) r9).booleanValue();
        if (r10 == false) goto L23;
        t1 r11 = t1.a;
        if (r11.u() == false) goto L23;
        r11.A0();
    L23:
        r8.g.removeAllViews();
        Intrinsics.checkNotNull(r7);
        int r12 = 6;
        View r13 = new OCardListItem(r7, null, 6, 0);
        final ObricVoicePrintManagementMainFragment r14 = this.this$0;
        r13.setCardType(0);
        OCardListItem.h(r13, 0);
        if (r14.k == true) goto L26;
        rda.a.a(r13, 0);
    L26:
        r13.q(false);
        r13.r(false);
        if (r10 == false) goto L43;
        r13.setTitle(r7.getString(2131912586));
        r13.setIcon(2131236109);
        r13.setCustomEndView(2131561713);
        View r15 = r13.getCustomEndView();
        if ((r15 instanceof ViewGroup) == false) goto L31;
        ViewGroup r16 = (ViewGroup) r15;
    L32:
        if (r16 == null) goto L42;
        final View r17 = r16.findViewById(2131362013);
        if (r17 == null) goto L42;
        if ((r17 instanceof ImageView) == false) goto L38;
        ImageView r18 = (ImageView) r17;
    L39:
        if (r18 == null) goto L41;
        r18.setImageResource(2131236090);
    L41:
        r17.setOnClickListener(new r(r14, r17, r7));
        goto L42
    L38:
        r18 = null;
    L42:
        r13.p(true);
        r13.m(true);
    L44:
        r8.g.addView(r13);
        OTextView r20 = r8.h;
        if (r10 == true) goto L47;
        int r21 = 0;
    L48:
        r20.setVisibility(r21);
        this.this$0.getClass();
        List r22 = CollectionsKt.emptyList();
        if ((!r22.isEmpty()) == false) goto L92;
        if (r10 == false) goto L92;
        r8.d.setVisibility(0);
        final ObricVoicePrintManagementMainFragment r23 = this.this$0;
        ObricFragmentVoicePrintManagementBinding r24 = r23.e;
        if (r24 == null) goto L91;
        final Context r25 = r24.a.getContext();
        r24.b.removeAllViews();
        Iterator r110 = r22.iterator();
        int r111 = 0;
    L55:
        if (r110.hasNext() == false) goto L90;
        Object r112 = r110.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        final ObricVoicePrintManagementMainFragment.a r26 = (ObricVoicePrintManagementMainFragment.a) r112;
        Intrinsics.checkNotNull(r25);
        View r114 = new OCardListItem(r25, r4, r12, 0);
        r114.setTitle("“" + r26.b + 8221 + r25.getString(2131912574));
        r114.setIcon(ObricVoicePrintManagementMainFragment.X90(r26.c, r26.d));
        r114.p(true);
        r114.setCardType(0);
        if (r22.size() != 1) goto L64;
        OCardListItem.h(r114, 0);
        if (r23.k == true) goto L73;
        rda.a.a(r114, 0);
    L73:
        r114.q(false);
        r114.r(false);
        r114.setCustomEndView(2131561713);
        View r27 = r114.getCustomEndView();
        if ((r27 instanceof ViewGroup) == false) goto L76;
        ViewGroup r28 = (ViewGroup) r27;
    L77:
        if (r28 == null) goto L89;
        final View r29 = r28.findViewById(2131362013);
        if (r29 == null) goto L89;
        if ((r29 instanceof ImageView) == false) goto L83;
        ImageView r30 = (ImageView) r29;
    L85:
        if (r30 == null) goto L87;
        r30.setImageResource(2131236090);
    L87:
        r29.setOnClickListener(new k(r23, r29, r26, r25));
        goto L89
    L83:
        r30 = null;
    L89:
        r114.m(true);
        r24.b.addView(r114);
        r111 = r113;
        r4 = null;
        r12 = 6;
        goto L55
    L76:
        r28 = null;
        goto L77
    L64:
        if (r111 != 0) goto L67;
        int r31 = 1;
    L70:
        OCardListItem.h(r114, r31);
        if (r23.k == true) goto L73;
        rda.a.a(r114, r31);
        goto L73
    L67:
        if (r111 != (r22.size() - 1)) goto L69;
        r31 = 3;
        goto L70
    L69:
        r31 = 2;
        goto L70
    L90:
        Unit r32 = Unit.INSTANCE;
    L91:
        r5 = 8;
    L93:
        this.this$0.getClass();
        this.this$0.getClass();
        r8.f.setVisibility(r5);
        r8.c.removeAllViews();
    L92:
        r5 = 8;
        r8.d.setVisibility(8);
        r8.b.removeAllViews();
        goto L93
    L47:
        r21 = 8;
        goto L48
    L31:
        r16 = null;
        goto L32
    L43:
        r13.setCardType(2);
        r13.p(false);
        r13.s(false);
        r13.m(false);
        r13.r(false);
        r13.setCustomStartView(2131561714);
        r13.n(true);
        r13.setOnContentClickListener(new s(r14));
        goto L44
    L10:
        ResultKt.throwOnFailure(r19);
        r8 = this.this$0.e;
        if (r8 == null) goto L13;
        Context r33 = r8.a.getContext();
        CoroutineDispatcher r34 = Dispatchers.getIO();
        ObricVoicePrintManagementMainFragment$updateUI$1$isVoicePrintExisted$1 r35 = new ObricVoicePrintManagementMainFragment$updateUI$1$isVoicePrintExisted$1(null);
        this.L$0 = r8;
        this.L$1 = r33;
        this.label = 1;
        r9 = BuildersKt.withContext(r34, r35, this);
        if (r9 != r1) goto L17;
        return r1;
    L17:
        r7 = r33;
        goto L18
    L13:
        return Unit.INSTANCE;
    }
}
