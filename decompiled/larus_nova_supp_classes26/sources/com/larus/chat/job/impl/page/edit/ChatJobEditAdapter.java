package com.larus.chat.job.impl.page.edit;

import android.graphics.Typeface;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.job.impl.databinding.LarusChatJobEditOptionsItemBinding;
import com.larus.chat.job.impl.databinding.LarusChatJobEditTextItemBinding;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cBE\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onTextChanged", "Lkotlin/Function2;", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditTextKey;", "", "", "onOptionClick", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditOptionKey;", "Landroid/view/View;", "readOnly", "", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Z)V", "textInputSelections", "", "Lcom/larus/chat/job/impl/page/edit/TextInputSelection;", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobEditAdapter extends ListAdapter<z, RecyclerView.ViewHolder> {
    public static final ChatJobEditAdapter$Companion$DIFF_CALLBACK$1 e = null;
    public final Function2<ChatJobEditTextKey, String, Unit> a;
    public final Function2<ChatJobEditOptionKey, View, Unit> b;
    public final boolean c;
    public final Map<ChatJobEditTextKey, q1> d;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.chat.job.impl.page.edit.ChatJobEditAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        e = new ChatJobEditAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final int getItemViewType(int r2) {
        z r3 = (z) getItem(r2);
        if ((r3 instanceof z.b) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof z.a) == false) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.larus.chat.job.impl.page.edit.e, java.lang.Object] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        final z r15 = (z) getItem(r14);
        if ((r15 instanceof z.b) == false) goto L77;
        if ((r13 instanceof u1) == false) goto L7;
        u1 r16 = (u1) r13;
    L8:
        if (r16 != null) goto L10;
        return;
    L10:
        z.b r0 = (z.b) r15;
        boolean r4 = this.c;
        ?? r5 = new e(this, r15);
        Intrinsics.checkNotNullParameter(r0, "item");
        Intrinsics.checkNotNullParameter(r5, "onTextChanged");
        FrameLayout r17 = r16.a.a;
        int r6 = gz8.g.a;
        r17.setBackground(gz8.g.a(r17.getContext()));
        FrameLayout r18 = r16.a.a;
        ViewGroup.LayoutParams r7 = r18.getLayoutParams();
        if (r7 == null) goto L75;
        FrameLayout r8 = r16.a.a;
        boolean r9 = r0.c;
        if (r9 == false) goto L15;
        int r10 = 2130971200;
    L16:
        if (r9 == false) goto L18;
        int r11 = 2131166769;
    L19:
        r7.height = r8.getResources().getDimensionPixelSize(v19.c.b(r10, r8.getContext(), r11));
        r18.setLayoutParams(r7);
        r16.a.b.removeTextChangedListener(r16.d);
        final EditText r19 = r16.a.b;
        boolean r12 = r19.isFocused();
        int r20 = r19.getSelectionStart();
        int r21 = r19.getSelectionEnd();
        Intrinsics.checkNotNull(r19);
        boolean r22 = r0.c;
        if (Intrinsics.areEqual(r16.e, Boolean.valueOf(r22)) == true) goto L39;
        r19.setSingleLine(!r22);
        r19.setMinLines(1);
        int r110 = 6;
        if (r22 == false) goto L25;
        int r111 = 6;
    L26:
        r19.setMaxLines(r111);
        if (r22 == false) goto L29;
        int r112 = 131073;
    L30:
        r19.setInputType(r112);
        if (r22 == false) goto L33;
        r110 = 1;
    L33:
        r19.setImeOptions(r110);
        r19.setVerticalScrollBarEnabled(r22);
        r19.setHorizontallyScrolling(false);
        if (r22 == true) goto L36;
        r16.a.b.setOnTouchListener(null);
    L37:
        r16.e = Boolean.valueOf(r22);
        goto L39
    L36:
        r16.a.b.setOnTouchListener(new s1());
        goto L37
    L29:
        r112 = 16385;
        goto L30
    L25:
        r111 = 1;
    L39:
        if (r0.a != ChatJobEditTextKey.TITLE) goto L41;
        String r23 = "sans-serif-medium";
    L42:
        r19.setTypeface(Typeface.create(r23, 0));
        Editable r24 = r19.getText();
        if (r24 == null) goto L45;
        String r25 = r24.toString();
    L46:
        boolean r2 = true ^ Intrinsics.areEqual(r25, r0.b);
        q1 r26 = (q1) r16.b.invoke(r0.a);
        if (r26 == null) goto L49;
        r20 = r26.a;
    L49:
        if (r26 == null) goto L51;
        r21 = r26.b;
    L51:
        if (r2 == false) goto L53;
        r19.setText(r0.b);
    L53:
        if (r12 == true) goto L58;
        if (r26 != null) goto L58;
        if (r2 == false) goto L69;
        r19.setSelection(0);
        r19.scrollTo(0, 0);
        r19.post(new r1(r19));
    L69:
        if (r4 == false) goto L71;
        r19.setKeyListener(null);
        r19.setFocusable(false);
        r19.setFocusableInTouchMode(false);
        r19.setCursorVisible(false);
        r19.setLongClickable(false);
        r19.setTextColor(gz8.g.c(r19.getContext()));
    L71:
        if (r4 == true) goto L138;
        t1 r113 = new t1(r16, r0, r5);
        r16.a.b.addTextChangedListener(r113);
        r16.d = r113;
        return;
    L138:
        return;
    L58:
        if (r20 < 0) goto L69;
        if (r21 < 0) goto L69;
        Editable r3 = r19.getText();
        if (r3 == null) goto L64;
        int r27 = r3.length();
    L65:
        int r28 = RangesKt.coerceIn(r20, 0, r27);
        int r29 = RangesKt.coerceIn(r21, 0, r27);
        if (r28 > r29) goto L68;
        r19.setSelection(r28, r29);
        goto L69
    L68:
        r19.setSelection(r29, r28);
        goto L69
    L64:
        r27 = 0;
        goto L65
    L45:
        r25 = null;
        goto L46
    L41:
        r23 = "sans-serif";
        goto L42
    L18:
        r11 = 2131167393;
        goto L19
    L15:
        r10 = 2130971512;
        goto L16
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L7:
        r16 = null;
        goto L8
    L77:
        if ((r15 instanceof z.a) == false) goto L132;
        if ((r13 instanceof o1) == false) goto L81;
        o1 r114 = (o1) r13;
    L82:
        if (r114 == null) goto L137;
        z.a r115 = (z.a) r15;
        final Function2<ChatJobEditOptionKey, View, Unit> r1 = this.b;
        Intrinsics.checkNotNullParameter(r115, "section");
        Intrinsics.checkNotNullParameter(r1, "onOptionClick");
        LinearLayout r30 = r114.a.a;
        int r31 = gz8.g.a;
        r30.setBackground(gz8.g.a(r30.getContext()));
        Iterator<T> r116 = r114.b.iterator();
        int r32 = 0;
    L85:
        if (r116.hasNext() == false) goto L139;
        Object r33 = r116.next();
        int r34 = r32 + 1;
        if (r32 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        final o1.b r35 = (o1.b) r33;
        final a0 r36 = (a0) CollectionsKt.getOrNull(r115.b, r32);
        if (r32 != CollectionsKt.getLastIndex(r115.b)) goto L92;
        boolean r37 = true;
    L93:
        if (r36 == null) goto L95;
        boolean r38 = true;
    L96:
        View r39 = r35.a;
        int r117 = 8;
        if (r38 == false) goto L99;
        int r118 = 0;
    L100:
        r39.setVisibility(r118);
        View r40 = r35.d;
        if (r40 == null) goto L110;
        if (r38 == false) goto L105;
        if (r37 == true) goto L105;
        boolean r41 = true;
    L106:
        if (r41 == false) goto L108;
        int r42 = 0;
    L109:
        r40.setVisibility(r42);
        goto L110
    L108:
        r42 = 8;
    L105:
        r41 = false;
    L110:
        if (r36 == null) goto L128;
        r35.b.setText(r36.b);
        r35.c.setText(r36.c);
        r35.a.setEnabled(r36.d);
        TextView r43 = r35.b;
        float r44 = 0.34f;
        if (r36.d == false) goto L114;
        float r45 = 1.0f;
    L115:
        r43.setAlpha(r45);
        TextView r46 = r35.c;
        if (r36.d == false) goto L118;
        r44 = 1.0f;
    L118:
        r46.setAlpha(r44);
        View r47 = r35.e;
        if (r47 == null) goto L125;
        if (r36.e == false) goto L123;
        r117 = 0;
    L123:
        r47.setVisibility(r117);
    L125:
        if (r36.e == false) goto L127;
        r35.a.setOnClickListener(new n1(r1, r36, r35));
    L129:
        r32 = r34;
        goto L85
    L127:
        r35.a.setOnClickListener(null);
        goto L129
    L114:
        r45 = 0.34f;
        goto L115
    L128:
        r35.a.setOnClickListener(null);
        goto L129
    L99:
        r118 = 8;
        goto L100
    L95:
        r38 = false;
        goto L96
    L92:
        r37 = false;
        goto L93
    L139:
        return;
    L137:
        return;
    L81:
        r114 = null;
        goto L82
    L132:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.larus.chat.job.impl.page.edit.f] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.chat.job.impl.page.edit.g] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r33, int r34) {
        Intrinsics.checkNotNullParameter(r33, "parent");
        LayoutInflater r2 = LayoutInflater.from(r33.getContext());
        if (r34 != 1) goto L9;
        View r1 = r2.inflate(2131561889, r33, false);
        EditText r5 = (EditText) ViewBindings.findChildViewById(r1, 2131377217);
        if (r5 == null) goto L8;
        RecyclerView.ViewHolder r3 = new u1(new LarusChatJobEditTextItemBinding((FrameLayout) r1, r5), new f(this), new g(this));
    L58:
        return r3;
    L8:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(2131377217)));
    L9:
        View r4 = r2.inflate(2131561888, r33, false);
        int r6 = 2131377190;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r4, 2131377190);
        if (r8 == null) goto L60;
        r6 = 2131377191;
        View r9 = ViewBindings.findChildViewById(r4, 2131377191);
        if (r9 == null) goto L60;
        r6 = 2131377192;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r4, 2131377192);
        if (r10 == null) goto L60;
        r6 = 2131377193;
        ConstraintLayout r11 = ViewBindings.findChildViewById(r4, 2131377193);
        if (r11 == null) goto L60;
        r6 = 2131377194;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r4, 2131377194);
        if (r12 == null) goto L60;
        r6 = 2131377196;
        AppCompatImageView r13 = ViewBindings.findChildViewById(r4, 2131377196);
        if (r13 == null) goto L60;
        r6 = 2131377197;
        View r14 = ViewBindings.findChildViewById(r4, 2131377197);
        if (r14 == null) goto L60;
        r6 = 2131377198;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r4, 2131377198);
        if (r15 == null) goto L60;
        r6 = 2131377199;
        ConstraintLayout r16 = ViewBindings.findChildViewById(r4, 2131377199);
        if (r16 == null) goto L60;
        r6 = 2131377200;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r4, 2131377200);
        if (r17 == null) goto L60;
        r6 = 2131377203;
        AppCompatImageView r18 = ViewBindings.findChildViewById(r4, 2131377203);
        if (r18 == null) goto L60;
        r6 = 2131377204;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r4, 2131377204);
        if (r19 == null) goto L60;
        r6 = 2131377205;
        ConstraintLayout r20 = ViewBindings.findChildViewById(r4, 2131377205);
        if (r20 == null) goto L60;
        r6 = 2131377206;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r4, 2131377206);
        if (r21 == null) goto L60;
        r6 = 2131377207;
        AppCompatImageView r22 = ViewBindings.findChildViewById(r4, 2131377207);
        if (r22 == null) goto L60;
        r6 = 2131377208;
        View r23 = ViewBindings.findChildViewById(r4, 2131377208);
        if (r23 == null) goto L60;
        r6 = 2131377209;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r4, 2131377209);
        if (r24 == null) goto L60;
        r6 = 2131377210;
        ConstraintLayout r25 = ViewBindings.findChildViewById(r4, 2131377210);
        if (r25 == null) goto L60;
        r6 = 2131377211;
        TextView r26 = (TextView) ViewBindings.findChildViewById(r4, 2131377211);
        if (r26 == null) goto L60;
        r6 = 2131377212;
        AppCompatImageView r27 = ViewBindings.findChildViewById(r4, 2131377212);
        if (r27 == null) goto L60;
        r6 = 2131377213;
        View r28 = ViewBindings.findChildViewById(r4, 2131377213);
        if (r28 == null) goto L60;
        r6 = 2131377214;
        TextView r29 = (TextView) ViewBindings.findChildViewById(r4, 2131377214);
        if (r29 == null) goto L60;
        r6 = 2131377215;
        ConstraintLayout r30 = ViewBindings.findChildViewById(r4, 2131377215);
        if (r30 == null) goto L60;
        r6 = 2131377216;
        TextView r31 = (TextView) ViewBindings.findChildViewById(r4, 2131377216);
        if (r31 == null) goto L60;
        r3 = new o1(new LarusChatJobEditOptionsItemBinding((LinearLayout) r4, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31), this.c);
    L60:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r6)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatJobEditAdapter(Function2<? super ChatJobEditTextKey, ? super String, Unit> r2, Function2<? super ChatJobEditOptionKey, ? super View, Unit> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "onTextChanged");
        Intrinsics.checkNotNullParameter(r3, "onOptionClick");
        super(e);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new LinkedHashMap();
    }
}
