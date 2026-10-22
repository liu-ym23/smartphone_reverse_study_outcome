package vba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OButtonBlock;
import com.larus.im.bean.message.block.OButtonGroupBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.block.base.CheckLastMessageBlockHolder;
import com.obric.assistant.card.databinding.ObricBlockOmniButtonGroupBinding;
import com.obric.assistant.card.databinding.ObricBlockOmniButtonItemBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends CheckLastMessageBlockHolder<vba.a> {
    public ObricBlockOmniButtonGroupBinding p;
    public final List<ObricBlockOmniButtonItemBinding> q;
    public boolean r;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final String c() {
        return "ButtonGroupBlockHolder";
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void i() {
        FLogger.a.i("ButtonGroupBlockHolder", "onViewRecycled");
        super.i();
        ((ArrayList) this.q).clear();
    }

    public c() {
        this.q = new ArrayList();
    }

    public static void o(ObricBlockOmniButtonItemBinding r3) {
        r3.b.setEnabled(false);
        r3.b.setAlpha(0.6f);
        r3.b.setTextColor(ContextCompat.getColor(r3.a.getContext(), 2131103794));
        r3.b.setOnClickListener(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v7 */
    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void g(jc8.a r26) {
        final vba.a r7 = (vba.a) r26;
        Intrinsics.checkNotNullParameter(r7, "blockModel");
        super.g(r7);
        Block r0 = ((jc8.a) r7).a;
        Integer r1 = null;
        if (r0 == null) goto L7;
        BlockContent r2 = r0.getContent();
        if (r2 == null) goto L7;
        OButtonGroupBlock r8 = r2.getOButtonGroupBlock();
    L8:
        FLogger r3 = FLogger.a;
        r3.i("ButtonGroupBlockHolder", "onBindBlockView: userSelectBlock=" + r8);
        if (r8 != null) goto L11;
        r3.w("ButtonGroupBlockHolder", "onBindBlockView: userSelectBlock is null");
        return;
    L11:
        final ObricBlockOmniButtonGroupBinding r10 = this.p;
        if (r10 != null) goto L14;
        r3.w("ButtonGroupBlockHolder", "onBindBlockView: binding is null");
        return;
    L14:
        Boolean r4 = r8.enabled;
        Boolean r5 = Boolean.TRUE;
        boolean r6 = Intrinsics.areEqual(r4, r5);
        boolean r11 = l();
        r3.i("ButtonGroupBlockHolder", "onBindBlockView: isBlockEnabled = " + r6 + ", isLastestMessage = " + r11);
        cd8.a r9 = jc8.c.a(this, cd8.a.class);
        int r12 = -1;
        ?? r13 = 0;
        int r14 = 1;
        if (r9 == null) goto L24;
        Integer r15 = Integer.valueOf(r9.a);
        if (r15.intValue() <= 0) goto L19;
        boolean r16 = true;
    L20:
        if (r16 == false) goto L22;
        r1 = r15;
    L22:
        if (r1 == null) goto L24;
        int r17 = r1.intValue();
    L25:
        ViewGroup.LayoutParams r18 = r10.a.getLayoutParams();
        if (r18 != null) goto L28;
    L30:
        boolean r19 = false;
    L31:
        if (r19 == true) goto L37;
        RelativeLayout r20 = r10.a;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L36;
        r21.width = r17;
        r20.setLayoutParams(r21);
        goto L37
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L37:
        r10.b.removeAllViews();
        ((ArrayList) this.q).clear();
        LayoutInflater r110 = LayoutInflater.from(r10.a.getContext());
        r3.i("ButtonGroupBlockHolder", "setDataToView: enabled = " + r8.enabled);
        Integer r22 = r8.orientation;
        if (r22 != null) goto L41;
    L43:
        boolean r111 = false;
    L44:
        if (r111 == false) goto L46;
        r10.b.setOrientation(1);
    L47:
        this.r = Intrinsics.areEqual(r8.notAutoDisable, r5);
        List r23 = r8.buttons;
        if (r23 == null) goto L91;
        List r24 = CollectionsKt.filterNotNull(r23);
        if (r24 == null) goto L91;
        Iterator r112 = r24.iterator();
        int r25 = 0;
    L53:
        if (r112.hasNext() == false) goto L91;
        Object r27 = r112.next();
        int r113 = r25 + 1;
        if (r25 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        final OButtonBlock r28 = (OButtonBlock) r27;
        View r29 = r110.inflate(2131563945, r10.b, r13);
        if (r29 == null) goto L90;
        TextView r30 = (TextView) r29;
        ObricBlockOmniButtonItemBinding r31 = new ObricBlockOmniButtonItemBinding(r30, r30);
        String r32 = r28.buttonContent;
        if (r32 != null) goto L62;
        r32 = NameKeys.UnloadStrategy_No_Strategy;
    L62:
        r30.setText(r32);
        Integer r33 = r28.buttonSpecialStyle;
        Context r34 = r30.getContext();
        if (r33 != null) goto L66;
    L68:
        int r35 = ContextCompat.getColor(r34, 2131103681);
    L69:
        r30.setTextColor(r35);
        we8.a.b(r30, i5.m(), false, null, null, 12);
        ViewGroup.LayoutParams r36 = r30.getLayoutParams();
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r37 = (LinearLayout.LayoutParams) r36;
        if (r111 == false) goto L72;
        r37.width = r12;
        r37.weight = 0.0f;
    L73:
        if (r25 < r14) goto L79;
        LinearLayout r38 = r10.b;
        View r39 = new View(r10.a.getContext());
        if (r111 == false) goto L77;
        ViewGroup.LayoutParams r114 = new ViewGroup.LayoutParams(r13, i5.h());
    L78:
        r39.setLayoutParams(r114);
        r39.setVisibility(4);
        r38.addView(r39);
        goto L79
    L77:
        r114 = new ViewGroup.LayoutParams(i5.h(), r13);
    L79:
        Boolean r40 = r8.enabled;
        Boolean r41 = Boolean.TRUE;
        if (Intrinsics.areEqual(r40, r41) == true) goto L82;
    L87:
        ObricBlockOmniButtonItemBinding r115 = r31;
        TextView r116 = r30;
        o(r115);
    L88:
        ((ArrayList) this.q).add(r115);
        r10.b.addView(r116);
        r25 = r113;
        r12 = -1;
        r13 = 0;
        r14 = 1;
        goto L53
    L82:
        if (Intrinsics.areEqual(r28.enabled, r41) == false) goto L87;
        if (r11 == false) goto L85;
    L86:
        r30.setAlpha(1.0f);
        final OButtonGroupBlock r42 = r8;
        r115 = r31;
        r116 = r30;
        e1.d(r116, new b(r28, this, r42, r10, r7));
        goto L88
    L85:
        if (this.r == false) goto L87;
    L72:
        r37.width = r13;
        r37.weight = 1.0f;
        goto L73
    L66:
        if (r33.intValue() != r14) goto L68;
        r35 = ContextCompat.getColor(r34, 2131104390);
        goto L69
    L90:
        throw new NullPointerException("rootView");
    L91:
        List r43 = r8.buttons;
        if (r43 != null) goto L94;
    L97:
        boolean r117 = true;
    L98:
        if (r117 == true) goto L100;
        j19.c.f(r10.a);
        return;
    L100:
        FLogger.a.w("ButtonGroupBlockHolder", "setDataToView: buttons is empty");
        j19.c.d(r10.a);
        return;
    L94:
        if (r43.isEmpty() == true) goto L97;
        r117 = false;
        goto L98
    L46:
        r10.b.setOrientation(0);
        goto L47
    L41:
        if (r22.intValue() != 1) goto L43;
        r111 = true;
        goto L44
    L28:
        if (r18.width != r17) goto L30;
        r19 = true;
        goto L31
    L19:
        r16 = false;
    L24:
        r17 = -1;
    L7:
        r8 = null;
        goto L8
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FLogger.a.i("ButtonGroupBlockHolder", "onCreatedBlockView: viewGroup=" + r4);
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563944, r4, false);
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131364692);
        if (r1 == null) goto L11;
        RelativeLayout r6 = (RelativeLayout) r5;
        this.p = new ObricBlockOmniButtonGroupBinding(r6, r1);
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L7;
        r0.width = -1;
    L8:
        r6.setLayoutParams(r0);
        return r6;
    L7:
        r0 = new ViewGroup.MarginLayoutParams(-1, -2);
        goto L8
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131364692)));
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void m(boolean r4) {
        FLogger.a.i("ButtonGroupBlockHolder", "onLastMessageStateChange: isLastMessage = " + r4);
        if (this.r == true) goto L9;
        if (r4 == true) goto L11;
        Iterator r5 = ((ArrayList) this.q).iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        o((ObricBlockOmniButtonItemBinding) r5.next());
        goto L7
    L12:
        return;
    L11:
        return;
    }
}
