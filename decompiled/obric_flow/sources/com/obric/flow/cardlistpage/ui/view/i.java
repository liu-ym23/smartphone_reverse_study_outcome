package com.obric.flow.cardlistpage.ui.view;

import ai.p;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.Size;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.oui.button.OButton;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.s;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import ym.k;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.oui.privacy.c f11853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f11854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f11855c;
    public final LinearLayout d;
    public final OTextView e;
    public Size f;

    public i(Context r17, com.obric.oui.privacy.c r18) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "config");
        super(r17);
        this.f11853a = r18;
        setBackgroundColor(ContextCompat.getColor(r17, R$color.oui_bg_base_2));
        LinearLayout r10 = new LinearLayout(r17);
        r10.setOrientation(1);
        r10.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        AttributeSet r12 = null;
        int r13 = 0;
        String r5 = r18.f14186c;
        if (r5 != null) goto L5;
    L12:
        OTextView r11 = null;
    L13:
        this.e = r11;
        LinearLayout r14 = new LinearLayout(getContext());
        r14.setOrientation(1);
        r14.setGravity(1);
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        OImageAppIcon r15 = new OImageAppIcon(getContext(), r12, 6, r13);
        int r16 = r15.getContext().getResources().getDimensionPixelSize(R$dimen.oui_image_size_xl);
        r15.setLayoutParams(new LinearLayout.LayoutParams(r16, r16));
        String r19 = r18.f14184a;
        if (r19 != null) goto L16;
    L19:
        r14.addView(r15);
        LinearLayout r20 = new LinearLayout(getContext());
        r20.setOrientation(1);
        r20.setGravity(1);
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-1, -2);
        float r110 = 32;
        r21.leftMargin = androidx.room.jarjarred.org.antlr.runtime.a.a(r110, 1);
        r21.rightMargin = androidx.room.jarjarred.org.antlr.runtime.a.a(r110, 1);
        float r22 = 20;
        r21.topMargin = androidx.room.jarjarred.org.antlr.runtime.a.a(r22, 1);
        r20.setLayoutParams(r21);
        OTextView r23 = new OTextView(new ContextThemeWrapper(getContext(), R$style.Title_4_Bold), null, 0, 14);
        r23.setIncludeFontPadding(true);
        r23.setTextColor(ContextCompat.getColor(r23.getContext(), R$color.oui_basic_text_1));
        r23.setText(r18.f14185b);
        r23.setGravity(17);
        r23.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r20.addView(r23);
        if (r11 == null) goto L22;
        r20.addView(r11);
    L22:
        r14.addView(r20);
        r10.addView(r14);
        this.d = r14;
        FrameLayout r24 = new FrameLayout(r17);
        r24.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r111 = new FrameLayout(getContext());
        FrameLayout.LayoutParams r25 = new FrameLayout.LayoutParams(-1, -1);
        r25.bottomMargin = androidx.room.jarjarred.org.antlr.runtime.a.a(8, 1);
        r111.setLayoutParams(r25);
        final RecyclerView r26 = new RecyclerView(getContext());
        r26.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r26.setClipToPadding(false);
        r26.getContext();
        final s r27 = new s();
        r26.setLayoutManager(r27);
        r26.setAdapter(new com.obric.oui.privacy.adapter.b(r18.d));
        r26.addOnLayoutChangeListener(new c(r26, r27));
        r26.h(new e(this));
        this.f11854b = r26;
        r111.addView(r26);
        int r28 = androidx.room.jarjarred.org.antlr.runtime.a.a(75, 1);
        final View r29 = new View(getContext());
        FrameLayout.LayoutParams r30 = new FrameLayout.LayoutParams(-1, r28);
        r30.gravity = 48;
        r29.setLayoutParams(r30);
        r29.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ContextCompat.getColor(r29.getContext(), R$color.oui_bg_base_2), 0}));
        r29.setAlpha(0.0f);
        r111.addView(r29);
        final View r31 = new View(getContext());
        FrameLayout.LayoutParams r32 = new FrameLayout.LayoutParams(-1, r28);
        r32.gravity = 80;
        r31.setLayoutParams(r32);
        r31.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ContextCompat.getColor(r31.getContext(), R$color.oui_bg_base_2), 0}));
        r31.setAlpha(0.0f);
        r111.addView(r31);
        final Ref.BooleanRef r33 = new Ref.BooleanRef();
        final Ref.BooleanRef r112 = new Ref.BooleanRef();
        RecyclerView r34 = this.f11854b;
        if (r34 == null) goto L25;
        r34.i(new f(r29, r31, r33, r112));
    L25:
        RecyclerView r113 = this.f11854b;
        if (r113 == null) goto L29;
        r113.addOnLayoutChangeListener(new d(this, r29, r31, r33, r112));
    L29:
        r24.addView(r111);
        r10.addView(r24);
        LinearLayout r35 = new LinearLayout(getContext());
        r35.setOrientation(1);
        r35.setGravity(1);
        r35.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r35.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r22, Resources.getSystem().getDisplayMetrics())), androidx.room.jarjarred.org.antlr.runtime.a.a(16, 1), androidx.room.jarjarred.org.antlr.runtime.a.a(r22, 1), androidx.room.jarjarred.org.antlr.runtime.a.a(r110, 1));
        String r36 = r18.e;
        if (r36 == null) goto L43;
        OTextView r37 = new OTextView(new ContextThemeWrapper(getContext(), R$style.Button_1_Regular), null, 0, 14);
        r37.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r37.setTextColor(ContextCompat.getColor(r37.getContext(), R$color.oui_basic_text_1));
        r37.setGravity(GravityCompat.START);
        List r38 = r18.f;
        if (r38.isEmpty() == true) goto L41;
        SpannableString r39 = new SpannableString(r36);
        Iterator r40 = r38.iterator();
    L35:
        if (r40.hasNext() == false) goto L40;
        String r41 = (String) r40.next();
        int r114 = 0;
    L37:
        Intrinsics.checkNotNull(r36);
        int r115 = StringsKt.r(r41, r114, 4, r36);
        if (r115 < 0) goto L35;
        int r116 = r41.length() + r115;
        r39.setSpan(new g(this, r41, r37, 0), r115, r116, 33);
        r114 = r116;
        goto L37
    L40:
        r37.setText(r39);
        r37.setMovementMethod(LinkMovementMethod.getInstance());
        r37.setHighlightColor(0);
    L42:
        r35.addView(r37);
        goto L43
    L41:
        r37.setText(r36);
    L43:
        LinearLayout r42 = new LinearLayout(getContext());
        r42.setOrientation(1);
        r42.setGravity(1);
        LinearLayout.LayoutParams r43 = new LinearLayout.LayoutParams(-1, -2);
        r43.topMargin = androidx.room.jarjarred.org.antlr.runtime.a.a(14, 1);
        r42.setLayoutParams(r43);
        float r44 = 4;
        r42.setPadding(androidx.room.jarjarred.org.antlr.runtime.a.a(r44, 1), 0, androidx.room.jarjarred.org.antlr.runtime.a.a(r44, 1), 0);
        Context r45 = getContext();
        final String r46 = r18.g;
        if (r46 != null) goto L46;
        r46 = getContext().getString(R$string.oui_agree);
    L46:
        Intrinsics.checkNotNull(r46);
        int r47 = R$style.OStyleV2_OButton_L_Standard_Primary;
        final Function1<View, Unit> r48 = new OPrivacyView$buildFooterView$agreeButton$1(this);
        r42.addView((OButton) k.d(r45, r47, new OPrivacyView$createSingleButton$1(r46, r48)));
        Context r49 = getContext();
        final String r50 = r18.f14187h;
        if (r50 != null) goto L49;
        r50 = getContext().getString(R$string.oui_exit);
    L49:
        Intrinsics.checkNotNull(r50);
        int r51 = R$style.OStyleV2_OButton_L_Trans_Neutral;
        final Function1<View, Unit> r52 = new OPrivacyView$buildFooterView$exitButton$1(this);
        View r53 = (OButton) k.d(r49, r51, new OPrivacyView$createSingleButton$1(r50, r52));
        LinearLayout.LayoutParams r54 = new LinearLayout.LayoutParams(-1, -2);
        r54.topMargin = androidx.room.jarjarred.org.antlr.runtime.a.a(12, 1);
        r53.setLayoutParams(r54);
        r42.addView(r53);
        r35.addView(r42);
        r10.addView(r35);
        addView(r10);
        if (this.f11853a.f14189j == false) goto L52;
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new b(this));
    L52:
        addOnLayoutChangeListener(new com.bytedance.ai.widget.contianer.c(this, 3));
        return;
    L16:
        if (StringsKt.isBlank(r19) == true) goto L19;
        Intrinsics.checkNotNull(r19);
        r15.setImagePackageName(r19);
        goto L19
    L5:
        if (StringsKt.isBlank(r5) == true) goto L12;
        r11 = new OTextView(new ContextThemeWrapper(getContext(), R$style.Body_1_Regular), null, 0, 14);
        r11.setIncludeFontPadding(true);
        r11.setTextColor(ContextCompat.getColor(r11.getContext(), R$color.oui_basic_text_3));
        r11.setText(r5);
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.ENGLISH.getLanguage()) == false) goto L10;
        int r55 = 17;
    L11:
        r11.setGravity(r55);
        r11.setMaxLines(3);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r56 = new LinearLayout.LayoutParams(-2, -2);
        r56.topMargin = androidx.room.jarjarred.org.antlr.runtime.a.a(8, 1);
        r11.setLayoutParams(r56);
        goto L13
    L10:
        r55 = GravityCompat.START;
        goto L11
    }

    public static final void a(Ref.BooleanRef r5, Ref.BooleanRef r10, View r11, boolean r12, boolean r13) {
        if (r13 == false) goto L4;
        boolean r14 = r5.element;
    L5:
        if (r14 != r12) goto L7;
        return;
    L7:
        if (r13 == false) goto L9;
        r5.element = r12;
    L10:
        r11.animate().cancel();
        ViewPropertyAnimator r15 = r11.animate();
        if (r12 == false) goto L13;
        float r16 = 1.0f;
    L14:
        r15.alpha(r16).setDuration(300).start();
        return;
    L13:
        r16 = 0.0f;
        goto L14
    L9:
        r10.element = r12;
        goto L10
    L4:
        r14 = r10.element;
        goto L5
    }
}
