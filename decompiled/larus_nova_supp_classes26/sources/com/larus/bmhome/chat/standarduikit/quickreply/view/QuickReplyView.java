package com.larus.bmhome.chat.standarduikit.quickreply.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tm8.b;
import tm8.c;
import tm8.d;
import tm8.e;
import tm8.f;
import tm8.i;
import tm8.j;
import tm8.m;
import tm8.n;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u00013B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020#H\u0014J\b\u0010'\u001a\u00020#H\u0014J\u0012\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0004H\u0002J\u001f\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u00100J\u001f\u00101\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u00100J\u0010\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/quickreply/view/QuickReplyView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/quickreply/view/QuickReplyViewInput;", "Lcom/larus/bmhome/chat/standarduikit/quickreply/view/QuickReplyViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "itemInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getItemInflater", "()Landroid/view/LayoutInflater;", "itemInflater$delegate", "Lkotlin/Lazy;", "verticalSpacing", "", "underlineTextColor", "getUnderlineTextColor", "()I", "underlineTextColor$delegate", "underlineColor", "getUnderlineColor", "underlineColor$delegate", "exposureObserveStages", "", "itemExposureOwnerToken", "", "ownedItemExposureKeys", "", "", "bindData", "", "input", "output", "onAttachedToWindow", "onDetachedFromWindow", "addGuideTextIfNeeded", "guideText", "renderVertical", "createItemView", "Landroid/view/View;", "item", "Lcom/larus/bmhome/chat/standarduikit/quickreply/view/QuickReplyButtonViewInput;", "itemBackgroundRes", "(Lcom/larus/bmhome/chat/standarduikit/quickreply/view/QuickReplyButtonViewInput;Ljava/lang/Integer;)Landroid/view/View;", "createButtonView", "createUnderlineView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickReplyView extends LinearLayout {
    public static final Handler h = null;
    public static final Map<String, Object> i = null;
    public final Lazy a;
    public final int b;
    public final Lazy c;
    public final Lazy d;
    public final List<Integer> e;
    public Object f;
    public final Set<String> g;

    public static final class a {
    }

    static {
        h = new Handler(Looper.getMainLooper());
        i = new LinkedHashMap();
    }

    private final LayoutInflater getItemInflater() {
        return (LayoutInflater) this.a.getValue();
    }

    private final int getUnderlineColor() {
        return ((Number) this.d.getValue()).intValue();
    }

    private final int getUnderlineTextColor() {
        return ((Number) this.c.getValue()).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        this.f = new Object();
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        final String r1 = (String) r0.next();
        final Object r2 = this.f;
        h.postDelayed(new m(r1, r2), 100);
        goto L4
    L6:
        this.g.clear();
        super.onDetachedFromWindow();
    }

    public QuickReplyView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public QuickReplyView(final Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = LazyKt.lazy(new c(r3));
        this.b = j19.c.c(12);
        this.c = LazyKt.lazy(new d(r3));
        this.d = LazyKt.lazy(new e(r3));
        this.e = CollectionsKt.listOf(new Integer[]{0, 1, 2});
        this.f = new Object();
        this.g = new LinkedHashSet();
        setOrientation(1);
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [android.widget.TextView, com.larus.bmhome.chat.standarduikit.quickreply.view.QuickReplyUnderlineTextView, java.lang.Object] */
    public final void a(final n r26, final com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d.c r27) {
        Intrinsics.checkNotNullParameter(r26, "input");
        Intrinsics.checkNotNullParameter(r27, "output");
        removeAllViews();
        String r0 = r26.e;
        boolean r11 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        AppCompatTextView r2 = new AppCompatTextView(getContext());
        r2.setText(r0);
        r2.setTextColor(ContextCompat.getColor(r2.getContext(), v19.c.b(2130972079, r2.getContext(), 2131103136)));
        r2.setTextSize(17.0f);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.bottomMargin = j19.c.c(8);
        r2.setLayoutParams(r3);
        addView(r2);
    L13:
        ExposureTrackerExtKt.a(this, new f(this, r26, r27));
        if (r26.c == true) goto L111;
        Iterator<T> r14 = r26.d.iterator();
        final int r15 = 0;
    L17:
        if (r14.hasNext() == false) goto L115;
        Object r4 = r14.next();
        int r16 = r15 + 1;
        if (r15 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        final tm8.a r7 = (tm8.a) r4;
        Integer r5 = r26.f;
        String r6 = null;
        String r8 = "";
        if (r7.f != 2) goto L44;
        View r9 = getItemInflater().inflate(2131561843, this, r11);
        final ?? r10 = (QuickReplyUnderlineTextView) r9.findViewById(2131383566);
        boolean r12 = h.a;
        if (h.a(null) == false) goto L26;
        String r13 = r7.d;
    L27:
        String r17 = r7.a;
        if (r17 != null) goto L30;
        r17 = "";
    L30:
        int r18 = getUnderlineTextColor();
        int r19 = getUnderlineColor();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r17, "title");
        r10.d = r17;
        if (r13 != null) goto L33;
    L38:
        r13 = null;
    L39:
        r10.e = r13;
        r10.f = null;
        r10.setTextColor(r18);
        r10.setUnderlineColor(r19);
        r10.x();
        final String r20 = r10.e;
        if (r20 == null) goto L43;
        ImageLoaderKt.o(r20, "block_button_icon", null, new b(r10, r20), null, 116);
    L43:
        Intrinsics.checkNotNull(r9);
        final View r110 = r9;
    L97:
        if (r7.g == false) goto L99;
        int r21 = -1;
    L100:
        LinearLayout.LayoutParams r22 = new LinearLayout.LayoutParams(r21, -2);
        if (r15 <= 0) goto L103;
        r22.topMargin = this.b;
    L103:
        r110.setLayoutParams(r22);
        addView(r110);
        StringBuilder r23 = new StringBuilder("quick_reply_view_item_");
        r23.append(r26.a);
        r23.append('_');
        String r24 = r7.a;
        if (r24 == null) goto L107;
        r8 = r24;
    L107:
        r23.append(r8);
        r23.append('_');
        r23.append(r7.b);
        r23.append('_');
        r23.append(r15);
        final String r111 = r23.toString();
        Map<String, String> r25 = r7.i;
        if (r25 == null) goto L110;
        r6 = r25.get(MusicAppletPage.KEY_SOURCE);
    L110:
        final boolean r28 = Intrinsics.areEqual(r6, "cta_button");
        final int r29 = r15;
        ExposureTrackerExtKt.a(r110, new i(this, r26, r7, r29, r28, r27, r111));
        e1.d(r110, new j(r7, r15, r27, r110));
        r15 = r16;
        r11 = false;
        goto L17
    L99:
        r21 = -2;
        goto L100
    L33:
        if (r13.length() <= 0) goto L35;
        boolean r30 = true;
    L36:
        if (r30 == false) goto L38;
    L35:
        r30 = false;
        goto L36
    L26:
        r13 = r7.c;
        goto L27
    L44:
        View r31 = getItemInflater().inflate(2131561827, this, r11);
        View r32 = r31.findViewById(2131383559);
        if (r5 == null) goto L47;
        int r33 = r5.intValue();
    L55:
        r32.setBackground(ContextCompat.getDrawable(getContext(), r33));
        View r34 = (SimpleDraweeView) r31.findViewById(2131383560);
        View r35 = (SimpleDraweeView) r31.findViewById(2131383561);
        AppCompatTextView r36 = r31.findViewById(2131383564);
        ProgressBar r112 = (ProgressBar) r31.findViewById(2131383562);
        ViewGroup.LayoutParams r113 = r32.getLayoutParams();
        if (r7.g == false) goto L58;
        int r114 = -1;
    L59:
        r113.width = r114;
        r32.setLayoutParams(r113);
        boolean r37 = h.a;
        if (h.a(null) == false) goto L62;
        String r38 = r7.d;
    L63:
        String r115 = r7.a;
        if (r115 != null) goto L66;
        r115 = "";
    L66:
        r36.setText(r115);
        if (r7.h == false) goto L69;
        int r116 = ContextCompat.getColor(getContext(), 2131103683);
    L70:
        r36.setTextColor(r116);
        Intrinsics.checkNotNull(r36);
        String r117 = r7.a;
        if (r117 != null) goto L73;
    L76:
        boolean r118 = true;
    L77:
        e1.y(r36, !r118);
        int r39 = r7.e;
        if (r39 != 0) goto L80;
        View r119 = r34;
    L81:
        if (r39 != 0) goto L83;
        r34 = r35;
    L83:
        Intrinsics.checkNotNull(r34);
        e1.o(r34);
        if (r7.h == false) goto L86;
        Intrinsics.checkNotNull(r119);
        e1.o(r119);
        Intrinsics.checkNotNull(r112);
        j19.c.f(r112);
    L95:
        Intrinsics.checkNotNull(r31);
        r110 = r31;
        goto L97
    L86:
        if (r38 != null) goto L88;
    L91:
        boolean r40 = true;
    L92:
        if (r40 == false) goto L94;
        Intrinsics.checkNotNull(r119);
        e1.o(r119);
        Intrinsics.checkNotNull(r112);
        e1.o(r112);
        goto L95
    L94:
        Intrinsics.checkNotNull(r119);
        j19.c.f(r119);
        ImageLoaderKt.u(r119, r38, "block_button_icon");
        Intrinsics.checkNotNull(r112);
        e1.o(r112);
        goto L95
    L88:
        if (r38.length() == 0) goto L91;
        r40 = false;
        goto L92
    L80:
        r119 = r35;
        goto L81
    L73:
        if (r117.length() == 0) goto L76;
        r118 = false;
        goto L77
    L69:
        r116 = ContextCompat.getColor(getContext(), 2131103681);
        goto L70
    L62:
        r38 = r7.c;
        goto L63
    L58:
        r114 = -2;
        goto L59
    L47:
        Map<String, String> r41 = r7.i;
        if (r41 == null) goto L50;
        String r42 = r41.get("show_dash_border");
    L52:
        if (Intrinsics.areEqual(r42, "1") == false) goto L54;
        r33 = v19.c.b(2130970791, getContext(), 2131239545);
        goto L55
    L54:
        r33 = v19.c.b(2130970790, getContext(), 2131239542);
        goto L55
    L50:
        r42 = null;
        goto L52
    L115:
        return;
    L111:
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
