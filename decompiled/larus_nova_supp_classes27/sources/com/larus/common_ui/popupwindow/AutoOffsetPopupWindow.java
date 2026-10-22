package com.larus.common_ui.popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.widget.PopupWindowCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.larus.utils.i;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import jm8.j;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import m19.b;
import m19.c;
import m19.d;
import m19.e;
import r27.a;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AutoOffsetPopupWindow {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WindowGravity extends Enum<WindowGravity> {
        public static final WindowGravity BOTTOM = null;
        public static final WindowGravity TOP = null;
        public static final /* synthetic */ WindowGravity[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<WindowGravity> getEntries() {
            return b;
        }

        static {
            WindowGravity r0 = new WindowGravity("TOP", 0);
            TOP = r0;
            WindowGravity r1 = new WindowGravity("BOTTOM", 1);
            BOTTOM = r1;
            WindowGravity[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static WindowGravity[] values() {
            return (WindowGravity[]) a.clone();
        }

        public static WindowGravity valueOf(String r1) {
            return (WindowGravity) a.a(WindowGravity.class, r1);
        }

        public WindowGravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }

    public AutoOffsetPopupWindow() {
    }

    public static PopupWindow a(Context r28, View r210, String r30, Integer r31, String r32, int r33, int r34, int r35, WindowGravity r36, int r37, int r38, Function0 r310, Function1 r40, int r41, int r42, Function0 r43, j r44, Integer r45, boolean r46, boolean r47, Integer r48, int r410, String r50, boolean r51, Integer r52, int r53) {
        if ((r53 & 8) == 0) goto L5;
        Integer r9 = null;
    L7:
        if ((r53 & 1024) == 0) goto L9;
        int r11 = 0;
    L11:
        if ((r53 & 2048) == 0) goto L13;
        Function0 r13 = null;
    L15:
        if ((r53 & 4096) == 0) goto L17;
        final Function1 r14 = null;
    L19:
        if ((r53 & 8192) == 0) goto L21;
        int r15 = 0;
    L23:
        if ((r53 & 16384) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r53 & 32768) == 0) goto L29;
        Function0 r18 = null;
    L31:
        if ((r53 & 65536) == 0) goto L33;
        j r110 = null;
    L35:
        if ((r53 & 131072) == 0) goto L37;
        Integer r17 = null;
    L39:
        if ((r53 & 262144) == 0) goto L41;
        boolean r20 = false;
    L43:
        if ((r53 & 524288) == 0) goto L45;
        boolean r21 = false;
    L47:
        if ((r53 & 1048576) == 0) goto L49;
        Integer r22 = null;
    L51:
        if ((r53 & 2097152) == 0) goto L53;
        boolean r23 = true;
    L55:
        if ((r53 & 4194304) == 0) goto L57;
        int r25 = i5.e0();
    L59:
        if ((r53 & 8388608) == 0) goto L61;
        String r12 = "";
    L63:
        if ((r53 & 16777216) == 0) goto L65;
        boolean r24 = true;
    L67:
        if ((r53 & 33554432) == 0) goto L69;
        Integer r8 = null;
    L70:
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r210, "anchorView");
        Intrinsics.checkNotNullParameter(r30, "title");
        Intrinsics.checkNotNullParameter(r32, "desc");
        Intrinsics.checkNotNullParameter(r36, "windowGravity");
        Intrinsics.checkNotNullParameter(r12, "textColorString");
    L222:
        r14 = null;
    L224:
        return r14;
    L72:
        int r26 = r11;
        View r16 = LayoutInflater.from(r28).inflate(2131561815, null, false);     // Catch: Throwable -> L221
        final ConstraintLayout r5 = r16.findViewById(2131367798);     // Catch: Throwable -> L221
        Object r111 = r16.findViewById(2131386033);     // Catch: Throwable -> L221
        ((ShadowConstraintLayout) r111).setAnchorView(r5);     // Catch: Throwable -> L222
        ShadowConstraintLayout r112 = (ShadowConstraintLayout) r111;     // Catch: Throwable -> L222
        TextView r2 = (TextView) r16.findViewById(2131388791);     // Catch: Throwable -> L222
        r2.setText(r30);     // Catch: Throwable -> L222
        if (r9 == null) goto L79;
        r2.setTextColor(ContextCompat.getColor(AppHost.a.getApplication(), r9.intValue()));     // Catch: Throwable -> L222
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L222
    L79:
        if ((!StringsKt.isBlank(r12)) == true) goto L230;
    L90:
        if (r22 == null) goto L99;
        int r1 = r22.intValue();     // Catch: Throwable -> L222
        if (r23 == false) goto L94;
        int r27 = r1;
    L95:
        if (r23 == false) goto L98;
        r1 = 0;
    L98:
        r2.setCompoundDrawablesWithIntrinsicBounds(r27, 0, r1, 0);     // Catch: Throwable -> L222
        r2.setCompoundDrawablePadding(r25);     // Catch: Throwable -> L222
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L222
        goto L99
    L94:
        r27 = 0;
    L99:
        AppCompatTextView r4 = r16.findViewById(2131368823);     // Catch: Throwable -> L222
        if (r8 == null) goto L102;
        r4.setMaxWidth(r8.intValue());     // Catch: Throwable -> L222
    L102:
        r4.setText(r32);     // Catch: Throwable -> L222
        if (r21 == false) goto L116;
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L222
        ConstraintLayout.LayoutParams r54 = r4.getLayoutParams();     // Catch: Throwable -> L222
        if (r54 == null) goto L115;
        if ((r54 instanceof ConstraintLayout.LayoutParams) == false) goto L110;
        ConstraintLayout.LayoutParams r55 = r54;     // Catch: Throwable -> L222
    L111:
        if (r55 == null) goto L113;
        ((ViewGroup.MarginLayoutParams) r55).topMargin = i5.b();     // Catch: Throwable -> L222
        ((ViewGroup.MarginLayoutParams) r55).bottomMargin = 0;     // Catch: Throwable -> L222
        ((ViewGroup.MarginLayoutParams) r55).leftMargin = 0;     // Catch: Throwable -> L222
        ((ViewGroup.MarginLayoutParams) r55).rightMargin = 0;     // Catch: Throwable -> L222
        Unit r56 = Unit.INSTANCE;     // Catch: Throwable -> L222
    L113:
        r4.setLayoutParams(r54);     // Catch: Throwable -> L222
        goto L116
    L110:
        r55 = null;
        goto L111
    L115:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L222
    L116:
        final View r6 = r16.findViewById(2131366978);     // Catch: Throwable -> L222
        if (r20 == false) goto L120;
        ConstraintSet r57 = new ConstraintSet();     // Catch: Throwable -> L222
        r57.clone(r5);     // Catch: Throwable -> L222
        r57.clear(r6.getId(), 7);     // Catch: Throwable -> L222
        r57.clear(r6.getId(), 3);     // Catch: Throwable -> L222
        r57.connect(r6.getId(), 3, 2131388791, 3);     // Catch: Throwable -> L222
        r57.connect(r6.getId(), 7, 0, 7);     // Catch: Throwable -> L222
        r57.connect(r6.getId(), 4, 2131388791, 4);     // Catch: Throwable -> L222
        r57.applyTo(r5);     // Catch: Throwable -> L222
    L120:
        AppCompatImageView r58 = r16.findViewById(2131389101);     // Catch: Throwable -> L222
        ImageView r60 = (AppCompatImageView) r16.findViewById(2131364346);     // Catch: Throwable -> L222
        final PopupWindow r113 = new PopupWindow(r28);     // Catch: Throwable -> L222
        r113.setContentView(r16);     // Catch: Throwable -> L222
        r113.setHeight(-2);     // Catch: Throwable -> L222
        r113.setWidth(-2);     // Catch: Throwable -> L222
        r113.setBackgroundDrawable(new ColorDrawable(0));     // Catch: Throwable -> L222
        r113.setOutsideTouchable(true);     // Catch: Throwable -> L222
        r113.setFocusable(false);     // Catch: Throwable -> L222
        r113.setClippingEnabled(true);     // Catch: Throwable -> L222
        r113.update();     // Catch: Throwable -> L222
        r16.measure(0, 0);     // Catch: Throwable -> L222
        final Ref.BooleanRef r7 = new Ref.BooleanRef();     // Catch: Throwable -> L222
        final Function0 r114 = r18;
        if (r114 == null) goto L123;
        r5.setOnClickListener(new m19.a(r114, r113));     // Catch: Throwable -> L222
        r5.post(new b(r5, r6));     // Catch: Throwable -> L222
    L123:
        r6.setOnClickListener(new c(r7, r113));     // Catch: Throwable -> L222
        final j r61 = r110;
        r2.setOnClickListener(new d(r61, r113));     // Catch: Throwable -> L222
        r113.setOnDismissListener(new e(r14, r7));     // Catch: Throwable -> L222
        WindowGravity r62 = WindowGravity.BOTTOM;     // Catch: Throwable -> L222
        if (r36 != r62) goto L126;
        int r63 = r58.getDrawable().getIntrinsicHeight();     // Catch: Throwable -> L222
    L229:
        if (r36 != r62) goto L142;
        Intrinsics.checkNotNull(r58);     // Catch: Throwable -> L222
        ViewGroup.LayoutParams r64 = r58.getLayoutParams();     // Catch: Throwable -> L222
        if (r64 == null) goto L141;
        if ((r64 instanceof ViewGroup.MarginLayoutParams) == false) goto L133;
        ViewGroup.MarginLayoutParams r65 = (ViewGroup.MarginLayoutParams) r64;     // Catch: Throwable -> L222
    L134:
        if (r65 == null) goto L136;
        r65.topMargin = r35;     // Catch: Throwable -> L222
        r65.leftMargin = r15;     // Catch: Throwable -> L222
        r65.rightMargin = r10;     // Catch: Throwable -> L222
    L136:
        r58.setLayoutParams(r64);     // Catch: Throwable -> L222
        if (r24 == false) goto L139;
        e1.x(r58);     // Catch: Throwable -> L222
    L155:
        View r66 = r16.findViewById(2131382375);     // Catch: Throwable -> L222
        Intrinsics.checkNotNull(r66);     // Catch: Throwable -> L222
        ViewGroup.LayoutParams r67 = r66.getLayoutParams();     // Catch: Throwable -> L222
        if (r67 == null) goto L218;
        r67.width = r33;     // Catch: Throwable -> L222
        r66.setLayoutParams(r67);     // Catch: Throwable -> L222
        if (r33 <= 0) goto L160;
        boolean r68 = true;
    L162:
        if (Boolean.valueOf(r68).booleanValue() == false) goto L164;
        e1.x(r66);     // Catch: Throwable -> L222
    L165:
        View r70 = r16.findViewById(2131382376);     // Catch: Throwable -> L222
        Intrinsics.checkNotNull(r70);     // Catch: Throwable -> L222
        ViewGroup.LayoutParams r71 = r70.getLayoutParams();     // Catch: Throwable -> L222
        if (r71 == null) goto L216;
        r71.width = r34;     // Catch: Throwable -> L222
        r70.setLayoutParams(r71);     // Catch: Throwable -> L222
        if (r34 <= 0) goto L170;
        boolean r72 = true;
    L172:
        if (Boolean.valueOf(r72).booleanValue() == false) goto L174;
        e1.x(r70);     // Catch: Throwable -> L222
    L175:
        int r73 = r63 + r35;     // Catch: Throwable -> L222
        View r74 = r16.findViewById(2131382377);     // Catch: Throwable -> L222
        Intrinsics.checkNotNull(r74);     // Catch: Throwable -> L222
        ViewGroup.LayoutParams r75 = r74.getLayoutParams();     // Catch: Throwable -> L222
        if (r75 == null) goto L214;
        r75.height = r73;     // Catch: Throwable -> L222
        r74.setLayoutParams(r75);     // Catch: Throwable -> L222
        if (r73 <= 0) goto L180;
        boolean r76 = true;
    L182:
        if (Boolean.valueOf(r76).booleanValue() == false) goto L184;
        e1.x(r74);     // Catch: Throwable -> L222
    L185:
        View r77 = r16.findViewById(2131382378);     // Catch: Throwable -> L222
        Intrinsics.checkNotNull(r77);     // Catch: Throwable -> L222
        ViewGroup.LayoutParams r78 = r77.getLayoutParams();     // Catch: Throwable -> L222
        if (r78 == null) goto L212;
        r78.height = r73;     // Catch: Throwable -> L222
        r77.setLayoutParams(r78);     // Catch: Throwable -> L222
        if (r73 <= 0) goto L190;
        boolean r80 = true;
    L192:
        if (Boolean.valueOf(r80).booleanValue() == false) goto L194;
        e1.x(r77);     // Catch: Throwable -> L222
    L195:
        r112.setShadowRadius(RangesKt.coerceAtMost(RangesKt.coerceAtMost(Math.min(r33, r34), r73), r37));     // Catch: Throwable -> L222
        int r81 = i.d(r28);     // Catch: Throwable -> L222
        int r82 = RangesKt.coerceAtLeast(r5.getMeasuredWidth(), 0);     // Catch: Throwable -> L222
        int r83 = RangesKt.coerceAtLeast(r5.getMeasuredHeight(), 0);     // Catch: Throwable -> L222
        int[] r115 = new int[2];     // Catch: Throwable -> L222
        r210.getLocationOnScreen(r115);     // Catch: Throwable -> L225
        int r116 = (r210.getWidth() / 2) - ((r82 / 2) + r33);     // Catch: Throwable -> L225
        int r117 = (r210.getWidth() / 2) + ArraysKt.first(r115);     // Catch: Throwable -> L225
        int r84 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r117, r33 + (r82 / 2)), (r81 - r34) - (r82 / 2));     // Catch: Throwable -> L225
        if (r36 != r62) goto L202;
        if (r17 == null) goto L201;
        int r85 = r17.intValue();     // Catch: Throwable -> L225
    L203:
        r58.setTranslationX(r117 - r84);     // Catch: Throwable -> L225
        r113.setAnimationStyle(2131954383);     // Catch: Throwable -> L225
        PopupWindowCompat.showAsDropDown(r113, r210, r116, r85 + r26, 17);     // Catch: Throwable -> L225
        if (r13 == 0) goto L206;
        r13.invoke();     // Catch: Throwable -> L225
        Unit r86 = Unit.INSTANCE;     // Catch: Throwable -> L225
    L206:
        OverlaySource r87 = PopupWindowLancet.resolveSource(r210);     // Catch: Throwable -> L225
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r113, r210, r87) == true) goto L232;
        r113.showAsDropDown(r210);     // Catch: Throwable -> L225
        PopupWindowLancet.trackAfterShow(r113, r87, r210);     // Catch: Throwable -> L225
    L232:
        return r113;
    L201:
        r85 = 0;
        goto L203
    L202:
        r85 = ((-r83) - r210.getMeasuredHeight()) - (r73 * 2);     // Catch: Throwable -> L225
        goto L203
    L194:
        e1.o(r77);     // Catch: Throwable -> L222
        goto L195
    L190:
        r80 = false;
        goto L192
    L212:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L225
    L184:
        e1.o(r74);     // Catch: Throwable -> L222
        goto L185
    L180:
        r76 = false;
        goto L182
    L214:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L225
    L174:
        e1.o(r70);     // Catch: Throwable -> L222
        goto L175
    L170:
        r72 = false;
        goto L172
    L216:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L225
    L164:
        e1.o(r66);     // Catch: Throwable -> L222
        goto L165
    L160:
        r68 = false;
        goto L162
    L218:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L225
    L139:
        e1.o(r58);     // Catch: Throwable -> L222
        goto L155
    L133:
        r65 = null;
        goto L134
    L141:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L222
    L142:
        Intrinsics.checkNotNull(r60);     // Catch: Throwable -> L222
        ViewGroup.LayoutParams r88 = r60.getLayoutParams();     // Catch: Throwable -> L222
        if (r88 == null) goto L220;
        if ((r88 instanceof ViewGroup.MarginLayoutParams) == false) goto L147;
        ViewGroup.MarginLayoutParams r90 = (ViewGroup.MarginLayoutParams) r88;     // Catch: Throwable -> L222
    L148:
        if (r90 == null) goto L150;
        r90.bottomMargin = r35;     // Catch: Throwable -> L222
        r90.leftMargin = r15;     // Catch: Throwable -> L222
        r90.rightMargin = r10;     // Catch: Throwable -> L222
    L150:
        r60.setLayoutParams(r88);     // Catch: Throwable -> L222
        if (r24 == false) goto L153;
        e1.x(r60);     // Catch: Throwable -> L222
    L154:
        r58 = r60;
        goto L155
    L153:
        e1.o(r60);     // Catch: Throwable -> L222
        goto L154
    L147:
        r90 = null;
        goto L148
    L220:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L225
    L126:
        r63 = r60.getDrawable().getIntrinsicHeight();     // Catch: Throwable -> L222
        goto L229
    L230:
        Result.Companion r91 = Result.Companion;     // Catch: Throwable -> L82
        Object r92 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r12)));     // Catch: Throwable -> L82
    L85:
        if (Result.isFailure-impl(r92) == false) goto L87;
        r92 = null;
    L87:
        Integer r93 = (Integer) r92;     // Catch: Throwable -> L222
        if (r93 == null) goto L90;
        r2.setTextColor(r93.intValue());     // Catch: Throwable -> L222
    L82:
        th = move-exception;
        Result.Companion r94 = Result.Companion;     // Catch: Throwable -> L222
        r92 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L222
    L221:
        r14 = null;
        goto L224
    L69:
        r8 = r52;
        goto L70
    L65:
        r24 = r51;
        goto L67
    L61:
        r12 = r50;
        goto L63
    L57:
        r25 = r410;
        goto L59
    L53:
        r23 = false;
        goto L55
    L49:
        r22 = r48;
        goto L51
    L45:
        r21 = r47;
        goto L47
    L41:
        r20 = r46;
        goto L43
    L37:
        r17 = r45;
        goto L39
    L33:
        r110 = r44;
        goto L35
    L29:
        r18 = r43;
        goto L31
    L25:
        r10 = r42;
        goto L27
    L21:
        r15 = r41;
        goto L23
    L17:
        r14 = r40;
        goto L19
    L13:
        r13 = r310;
        goto L15
    L9:
        r11 = r38;
        goto L11
    L5:
        r9 = r31;
        goto L7
    }
}
