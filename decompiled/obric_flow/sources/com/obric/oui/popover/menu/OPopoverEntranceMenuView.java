package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.widget.MaxHeightNestedScrollView;
import com.obric.oui.popover.view.CheckableImageView;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "", "setPopoverMaxHeight", "(I)V", "getAvailableItemWidth", "()I", "com/obric/oui/popover/menu/b", "com/obric/oui/popover/menu/c", "WidthLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverEntranceMenuView extends OPopoverMenuView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f14129n = 0;
    public Lambda e;
    public ArrayList f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f14131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f14132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MaxHeightNestedScrollView f14135m;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$WidthLevel;", "", "", "value", "I", "getValue", "()I", "WIDTH_LEVEL_STANDARD", "WIDTH_LEVEL_BROAD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum WidthLevel extends Enum<WidthLevel> {
        public static final WidthLevel WIDTH_LEVEL_BROAD = null;
        public static final WidthLevel WIDTH_LEVEL_STANDARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WidthLevel[] f14137a = null;
        private final int value;

        static {
            int r5 = OPopoverEntranceMenuView.f14129n;
            WidthLevel r10 = new WidthLevel("WIDTH_LEVEL_STANDARD", 0, 184);
            WIDTH_LEVEL_STANDARD = r10;
            WidthLevel r11 = new WidthLevel("WIDTH_LEVEL_BROAD", 1, 208);
            WIDTH_LEVEL_BROAD = r11;
            f14137a = new WidthLevel[]{r10, r11};
        }

        public WidthLevel(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static WidthLevel valueOf(String r5) {
            return (WidthLevel) Enum.valueOf(WidthLevel.class, r5);
        }

        public static WidthLevel[] values() {
            return (WidthLevel[]) f14137a.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final int getAvailableItemWidth() {
        return this.g;
    }

    /* JADX WARN: Type inference failed for: r0v59, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c() {
        boolean r10 = true;
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R$layout.o_view_popover_menu_type, this, true);
        MaxHeightNestedScrollView r5 = (MaxHeightNestedScrollView) findViewById(R$id.popover_scroll);
        this.f14135m = r5;
        if (r5 == null) goto L6;
        r5.setMaxHeight(this.f14133k);
    L6:
        MaxHeightNestedScrollView r11 = this.f14135m;
        boolean r12 = false;
        if (r11 == null) goto L10;
        int r13 = this.f14130h;
        r11.setPadding(0, r13, 0, r13);
    L10:
        MaxHeightNestedScrollView r14 = this.f14135m;
        if (r14 == null) goto L14;
        r14.setScrollBarStyle(33554432);
    L14:
        MaxHeightNestedScrollView r15 = this.f14135m;
        if (r15 == null) goto L18;
        r15.setClipToPadding(false);
    L18:
        LinearLayout r16 = (LinearLayout) findViewById(R$id.popover_container);
        Iterator r17 = this.f.iterator();
        int r18 = 0;
        int r19 = 0;
    L20:
        if (r17.hasNext() == false) goto L163;
        Object r20 = r17.next();
        int r110 = r18 + 1;
        if (r18 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        final c r111 = (c) r20;
        r111.getClass();
        CharSequence r21 = r111.f;
        int r22 = r111.f14151a;
        if ((r22 & 1) == 0) goto L28;
    L29:
        boolean r23 = r10;
    L32:
        if (r23 == false) goto L39;
        View r24 = LayoutInflater.from(getContext()).inflate(R$layout.o_item_popover_menu_filter, r16, r12);
        if (r24 == null) goto L38;
        PopoverMenuLinearLayout r25 = (PopoverMenuLinearLayout) r24;
    L36:
        final PopoverMenuLinearLayout r26 = r25;
        OStateGradientDrawable r27 = new OStateGradientDrawable();
        r27.setCornerRadius(com.lynx.tasm.utils.a.r(20, getContext()));
        ColorStateList r28 = ContextCompat.getColorStateList(getContext(), R$color.o_pop_list_item_bg_color);
        Intrinsics.checkNotNull(r28);
        r27.setSolidColors(r28);
        r26.setBackground(r27);
        LinearLayout r29 = (LinearLayout) r26.findViewById(R$id.item_container);
        ImageView r30 = (ImageView) r26.findViewById(R$id.iv_popover_action);
        ImageView r31 = (ImageView) r26.findViewById(R$id.iv_popover_tail_image);
        OTextView r32 = (OTextView) r26.findViewById(R$id.tv_popover_action);
        OTextView r33 = (OTextView) r26.findViewById(R$id.tv_popover_action_sub);
        OTextView r34 = (OTextView) r26.findViewById(R$id.tv_popover_value);
        LinearLayout.LayoutParams r112 = null;
        if (r23 == false) goto L45;
        CheckableImageView r35 = (CheckableImageView) r26.findViewById(R$id.popover_menu_radio);
    L46:
        r26.findViewById(R$id.popover_badge_default);
        OBadgeView r36 = (OBadgeView) r26.findViewById(R$id.popover_badge_number);
        OBadgeView r37 = (OBadgeView) r26.findViewById(R$id.popover_badge_ellipsis);
        LinearLayout r113 = (LinearLayout) r26.findViewById(R$id.ll_popover_text_container);
        if (r35 != null) goto L50;
    L54:
        final CheckableImageView r210 = r35;
        Iterator r211 = r17;
        final LinearLayout r38 = r16;
        LinearLayout r212 = r16;
        final int r39 = r19;
        r26.setOnClickListener(new a(r111, r210, r38, this, r39));
        r26.getLayoutParams().width = getAvailableItemWidth();
        CharSequence r40 = r111.g;
        if (r40 != null) goto L57;
        r33.setVisibility(8);
        r26.getLayoutParams().height = -2;
    L58:
        r33.setText(r40);
        CharSequence r41 = r111.f14154h;
        r34.setText(r41);
        if (TextUtils.isEmpty(r41) == false) goto L61;
        int r42 = 8;
    L62:
        r34.setVisibility(r42);
        if (this.f.size() != 1) goto L72;
        r26.setIndexPos(PopoverMenuLinearLayout.Index.ONLY_ONE);
        ViewGroup.LayoutParams r43 = r26.getLayoutParams();
        if ((r43 instanceof LinearLayout.LayoutParams) == false) goto L67;
        LinearLayout.LayoutParams r44 = (LinearLayout.LayoutParams) r43;
    L68:
        if (r44 == null) goto L90;
        r44.topMargin = 0;
        r44.bottomMargin = 0;
        Unit r45 = Unit.INSTANCE;
    L90:
        Intrinsics.checkNotNullParameter(r26, "itemView");
        if (this.f14139b == false) goto L93;
        r26.setNotifyPressedCallback(new OPopoverMenuView$registerPressedCallback$1(this, r26));
    L93:
        int r46 = r111.f14153c;
        if (r46 == 0) goto L96;
        int r47 = 0;
        r30.setVisibility(0);
        r30.setImageResource(r46);
    L97:
        int r48 = r111.d;
        if (r48 == 0) goto L100;
        ImageView r49 = r31;
        r49.setVisibility(r47);
        r49.setImageResource(r48);
    L102:
        if (r21 == null) goto L104;
        r32.setText(r21);
    L104:
        r32.setSingleLine(this.f14134l);
        r32.setEllipsize(TextUtils.TruncateAt.END);
        if (this.f14134l == false) goto L107;
        int r50 = 1;
    L108:
        r32.setMaxLines(r50);
        int r51 = r111.e;
        if (r51 == 0) goto L111;
        r30.setImageTintList(ColorStateList.valueOf(r51));
        r49.setImageTintList(ColorStateList.valueOf(r51));
    L111:
        Integer r52 = r111.f14157k;
        if (r52 == null) goto L116;
        r32.setTextColor(r52.intValue());
        Unit r53 = Unit.INSTANCE;
    L116:
        if (getForceDark() == false) goto L119;
        int r54 = ContextCompat.getColor(getContext(), R$color.ConstTextInverse2);
        r32.setTextColor(r54);
        r30.setImageTintList(ColorStateList.valueOf(r54));
        r49.setImageTintList(ColorStateList.valueOf(r54));
        r26.setForceDark(true);
    L119:
        if (r111.f14155i == false) goto L122;
        int r55 = ContextCompat.getColor(getContext(), R$color.Negative);
        r32.setTextColor(r55);
        r30.setImageTintList(ColorStateList.valueOf(r55));
    L122:
        if (r210 != null) goto L124;
        boolean r56 = false;
    L160:
        this.e.invoke(r26);
        r26.setEnabled(true);
        r26.setClickable(true);
        r26.setAlpha(1.0f);
        r212.addView(r26);
        r19 = r19 + 1;
        r10 = true;
        r16 = r212;
        r12 = r56;
        r18 = r110;
        r17 = r211;
        goto L20
    L124:
        if (r51 != 0) goto L127;
        r51 = ContextCompat.getColor(getContext(), R$color.oui_accent_fg);
    L127:
        r210.setImageTintList(ColorStateList.valueOf(r51));
        r210.setVisibility(0);
        if ((r22 & 4) == 0) goto L130;
        boolean r57 = true;
    L131:
        r210.setChecked(r57);
        if ((r111.f14151a & 2) == 0) goto L158;
        ViewGroup.LayoutParams r58 = r210.getLayoutParams();
        if ((r58 instanceof LinearLayout.LayoutParams) == false) goto L136;
        LinearLayout.LayoutParams r59 = (LinearLayout.LayoutParams) r58;
    L137:
        if (r59 != null) goto L139;
        r56 = false;
    L140:
        r18.removeView(r210);
        r29.addView(r210);
        ViewGroup.LayoutParams r60 = r30.getLayoutParams();
        if ((r60 instanceof LinearLayout.LayoutParams) == false) goto L143;
        LinearLayout.LayoutParams r61 = (LinearLayout.LayoutParams) r60;
    L145:
        if (r61 == null) goto L149;
        r61.setMarginStart(com.lynx.tasm.utils.a.p(12, getContext()));
        Unit r62 = Unit.INSTANCE;
    L149:
        if (r30.getVisibility() != 8) goto L159;
        if (r113 == null) goto L159;
        ViewGroup.LayoutParams r63 = r113.getLayoutParams();
        if ((r63 instanceof LinearLayout.LayoutParams) == false) goto L154;
        r112 = (LinearLayout.LayoutParams) r63;
    L154:
        LinearLayout.LayoutParams r64 = r112;
        if (r64 == null) goto L159;
        r64.setMarginStart(com.lynx.tasm.utils.a.p(12, getContext()));
        Unit r65 = Unit.INSTANCE;
    L159:
        Unit r66 = Unit.INSTANCE;
        goto L160
    L143:
        r61 = null;
        goto L145
    L139:
        r56 = false;
        r59.setMarginStart(0);
        r59.setMarginEnd(com.lynx.tasm.utils.a.p(8, getContext()));
        Unit r67 = Unit.INSTANCE;
        goto L140
    L136:
        r59 = null;
        goto L137
    L158:
        r56 = false;
        goto L159
    L130:
        r57 = false;
        goto L131
    L107:
        r50 = 6;
        goto L108
    L100:
        r49 = r31;
        r49.setVisibility(8);
        goto L102
    L96:
        r47 = 0;
        r30.setVisibility(8);
        goto L97
    L67:
        r44 = null;
        goto L68
    L72:
        if (r18 != (this.f.size() - 1)) goto L80;
        r26.setIndexPos(PopoverMenuLinearLayout.Index.LAST);
        ViewGroup.LayoutParams r68 = r26.getLayoutParams();
        if ((r68 instanceof LinearLayout.LayoutParams) == false) goto L76;
        LinearLayout.LayoutParams r69 = (LinearLayout.LayoutParams) r68;
    L77:
        if (r69 == null) goto L90;
        r69.topMargin = 0;
        r69.bottomMargin = 0;
        Unit r70 = Unit.INSTANCE;
        goto L90
    L76:
        r69 = null;
        goto L77
    L80:
        if (r18 < 0) goto L90;
        if (r18 != 0) goto L83;
        r26.setIndexPos(PopoverMenuLinearLayout.Index.FIRST);
    L83:
        ViewGroup.LayoutParams r71 = r26.getLayoutParams();
        if ((r71 instanceof LinearLayout.LayoutParams) == false) goto L86;
        LinearLayout.LayoutParams r72 = (LinearLayout.LayoutParams) r71;
    L87:
        if (r72 == null) goto L90;
        r72.topMargin = 0;
        r72.bottomMargin = this.f14131i;
        Unit r73 = Unit.INSTANCE;
        goto L90
    L86:
        r72 = null;
        goto L87
    L61:
        r42 = 0;
        goto L62
    L57:
        r33.setVisibility(0);
        r26.getLayoutParams().height = -2;
        goto L58
    L50:
        if (r111.f14152b == false) goto L52;
        int r74 = 0;
    L53:
        r35.setVisibility(r74);
        goto L54
    L52:
        r74 = 4;
        goto L53
    L45:
        r35 = null;
        goto L46
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    L39:
        View r75 = LayoutInflater.from(getContext()).inflate(R$layout.o_item_popover_menu_type, r16, r12);
        if (r75 == null) goto L162;
        r25 = (PopoverMenuLinearLayout) r75;
        goto L36
    L162:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
    L28:
        if ((r22 & 2) != 0) goto L29;
        r23 = r12;
        goto L32
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        if (r11 != Integer.MIN_VALUE) goto L5;
        int r13 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r12, this.f14133k), Integer.MIN_VALUE);
    L9:
        super.onMeasure(r5, r13);
        if (getMeasuredHeight() <= this.f14133k) goto L13;
        setMeasuredDimension(getMeasuredWidth(), this.f14133k);
        return;
    L13:
        return;
    L5:
        if (r11 == 1073741824) goto L7;
        r13 = View.MeasureSpec.makeMeasureSpec(this.f14133k, Integer.MIN_VALUE);
        goto L9
    L7:
        r13 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r12, this.f14133k), BasicMeasure.EXACTLY);
        goto L9
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView
    public void setPopoverMaxHeight(int r5) {
        int r10 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r5, com.lynx.tasm.utils.a.B(40, this)), this.f14132j);
        if (this.f14133k != r10) goto L5;
        return;
    L5:
        this.f14133k = r10;
        MaxHeightNestedScrollView r11 = this.f14135m;
        if (r11 == null) goto L9;
        r11.setMaxHeight(r10);
    L9:
        requestLayout();
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OPopoverEntranceMenuView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.e = OPopoverEntranceMenuView$itemLayoutProcess$1.INSTANCE;
        this.f = new ArrayList();
        this.g = com.lynx.tasm.utils.a.p(184, r5);
        this.f14130h = com.lynx.tasm.utils.a.p(8, r5);
        this.f14131i = com.lynx.tasm.utils.a.p(4, r5);
        if (r5.getResources().getConfiguration().orientation != 2) goto L5;
        int r12 = r5.getResources().getDimensionPixelSize(R$dimen.oui_popover_max_height_landscape);
    L6:
        this.f14132j = r12;
        this.f14133k = r12;
        return;
    L5:
        r12 = r5.getResources().getDimensionPixelSize(R$dimen.oui_popover_max_height);
        goto L6
    }
}
