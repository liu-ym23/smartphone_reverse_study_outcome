package com.obric.assistant.block.complex.call_for_me;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OComplexCallForMeBlock;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricImBlockComplexCallForMeBinding;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends uba.a<com.obric.assistant.block.complex.call_for_me.a> {
    public ObricImBlockComplexCallForMeBinding d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CallState.values().length];
            r0[CallState.CALL_FOR_ME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CallState.CALL_ONGOING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final void i() {
        FLogger.a.i("ComplexCallForMeBlockHolder", "onViewRecycled");
    }

    public d() {
    }

    public final void g(jc8.a r14) {
        com.obric.assistant.block.complex.call_for_me.a r15 = (com.obric.assistant.block.complex.call_for_me.a) r14;
        Intrinsics.checkNotNullParameter(r15, "blockModel");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onBindBlockView, oComplexCallForMeBlock = ");
        BlockContent r2 = ((jc8.a) r15).a.getContent();
        if (r2 == null) goto L5;
        OComplexCallForMeBlock r3 = r2.getOComplexCallForMeBlock();
    L6:
        r1.append(r3);
        r0.i("ComplexCallForMeBlockHolder", r1.toString());
        final ObricImBlockComplexCallForMeBinding r4 = this.d;
        if (r4 != null) goto L9;
        r0.w("ComplexCallForMeBlockHolder", "onBindBlockView, blockViewBinding is null");
        return;
    L9:
        BlockContent r16 = ((jc8.a) r15).a.getContent();
        if (r16 == null) goto L50;
        OComplexCallForMeBlock r17 = r16.getOComplexCallForMeBlock();
        if (r17 == null) goto L50;
        Context r5 = r4.a.getContext();
        TextView r6 = r4.e;
        String r7 = r17.phone;
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        if (r7 != null) goto L17;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L17:
        r6.setText(r7);
        TextView r9 = r4.d;
        String r10 = r17.name;
        if (r10 == null) goto L21;
        r8 = r10;
    L21:
        r9.setText(r8);
        String r11 = r17.phone;
        if (r11 != null) goto L24;
    L27:
        boolean r12 = true;
    L29:
        if (r12 == false) goto L31;
        r4.c.setImageResource(2131244449);
    L32:
        CallState.a r13 = CallState.Companion;
        String r18 = r17.state;
        r13.getClass();
        CallState[] r19 = CallState.values();
        int r20 = r19.length;
        int r21 = 0;
    L33:
        if (r21 >= r20) goto L38;
        final CallState r22 = r19[r21];
        if (Intrinsics.areEqual(r22.getStateStr(), r18) == true) goto L39;
        r21 = r21 + 1;
    L39:
        if (r22 != null) goto L41;
        r22 = CallState.UNKNOWN;
    L41:
        FLogger.a.i("ComplexCallForMeBlockHolder", "callState = " + r22);
        r4.b.setText(r5.getString(r22.getBtnTextResId()));
        r4.b.setEnabled(r22.getBtnEnabled());
        r4.b.setActivated(r22.getBtnActivated());
        if (r22 != CallState.CALL_ONGOING) goto L48;
        TextView r110 = r4.b;
        Drawable r23 = r4.a.getContext().getDrawable(2131244314);
        if (r23 == null) goto L46;
        r23.setBounds(0, 0, r23.getIntrinsicWidth(), r23.getIntrinsicHeight());
        Unit r24 = Unit.INSTANCE;
    L47:
        r110.setCompoundDrawables(null, null, r23, null);
    L49:
        e1.d(r4.b, new c(r22, r4, this));
        return;
    L46:
        r23 = null;
        goto L47
    L48:
        r4.b.setCompoundDrawables(null, null, null, null);
        goto L49
    L38:
        r22 = null;
        goto L39
    L31:
        r4.c.getHierarchy().setPlaceholderImage(2131244449);
        ImageLoaderKt.x(r4.c, y0.j(r17.phone), "obric_chat.cards", null, new com.obric.assistant.block.complex.call_for_me.b(), 4);
        goto L32
    L24:
        if (r11.length() == 0) goto L27;
        r12 = false;
    L50:
        r0.w("ComplexCallForMeBlockHolder", "onBindBlockView, oComplexCallForMeBlock is null");
        RoundConstraintLayout r111 = r4.a;
        if (r111 == null) goto L58;
        e1.o(r111);
        return;
    L58:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final View h(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "viewGroup");
        FLogger.a.i("ComplexCallForMeBlockHolder", "onCreatedBlockView");
        RoundConstraintLayout r10 = LayoutInflater.from(r9.getContext()).inflate(2131564020, r9, false);
        int r0 = 2131364672;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131364672);
        if (r4 == null) goto L13;
        r0 = 2131374718;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r10, 2131374718);
        if (r5 == null) goto L13;
        r0 = 2131391531;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, 2131391531);
        if (r6 == null) goto L13;
        r0 = 2131391606;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, 2131391606);
        if (r7 == null) goto L13;
        RoundConstraintLayout r11 = r10;
        this.d = new ObricImBlockComplexCallForMeBinding(r11, r4, r5, r6, r7);
        return r11;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
