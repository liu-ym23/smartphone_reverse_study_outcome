package com.larus.chat.gallery.impl.preview.toolbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.common_res.common_ui.databinding.LarusCreateMenuItemLayoutBinding;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u0003345B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J0\u0010&\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016J\u0014\u0010'\u001a\u00020$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016J\"\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u001a2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0,J\u0016\u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/J\u0012\u00100\u001a\u0004\u0018\u00010\u001d2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mode", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarLayoutMode;", "visualStyle", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarVisualStyle;", "listener", "Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarView$OnToolbarActionListener;", "emphasizedKeys", "", "", "container", "Landroid/widget/LinearLayout;", "lastButtonSignature", "", "Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarView$ToolbarButtonSignature;", "itemViewMap", "", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarButtonType;", "Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarItemView;", "mainItems", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarButtonItem;", "overflowItems", "overflowMenu", "Lcom/larus/bmhome/view/menu/CreateMenu;", "overflowAnchor", "allItems", "updateEmphasizedKeys", "", "emphasizedButtons", "init", "setButtons", "items", "updateButton", "type", "updater", "Lkotlin/Function1;", "setButtonLoading", "loading", "", "findCurrentItem", "showOverflowMenu", "anchor", "Companion", "OnToolbarActionListener", "ToolbarButtonSignature", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewToolbarView extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public ToolbarLayoutMode a;
    public ToolbarVisualStyle b;
    public b c;
    public Set<String> d;
    public final LinearLayout e;
    public List<c> f;
    public final Map<ToolbarButtonType, PreviewToolbarItemView> g;
    public List<j> h;
    public List<j> i;
    public CreateMenu j;
    public PreviewToolbarItemView k;
    public List<j> l;

    public static final class a {
    }

    public interface b {
        void a(ToolbarButtonType r1, boolean r2);
    }

    public static final class c {
        public static final /* synthetic */ int h = 0;
        public final ToolbarButtonType a;
        public final int b;
        public final int c;
        public final String d;
        public final boolean e;
        public final boolean f;
        public final boolean g;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31;
            String r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            int r4 = 1231;
            if (this.e == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r3 + r5) * 31;
            if (this.f == false) goto L13;
            int r7 = 1231;
        L14:
            int r8 = (r6 + r7) * 31;
            if (this.g == true) goto L19;
            r4 = 1237;
        L19:
            return r8 + r4;
        L13:
            r7 = 1237;
            goto L14
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ToolbarButtonSignature(type=" + this.a + ", iconRes=" + this.b + ", textRes=" + this.c + ", textHardcode=" + this.d + ", visible=" + this.e + ", enabled=" + this.f + ", overflow=" + this.g + ')';
        }

        public final ToolbarButtonType getType() {
            return this.a;
        }

        public c(ToolbarButtonType r2, int r3, int r4, String r5, boolean r6, boolean r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ToolbarLayoutMode.values().length];
            r0[ToolbarLayoutMode.VERTICAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ToolbarLayoutMode.HORIZONTAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[ToolbarVisualStyle.values().length];
            r1[ToolbarVisualStyle.LEGACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[ToolbarVisualStyle.MEDIA_SOURCE_V4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    static {
    }

    public PreviewToolbarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PreviewToolbarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setButtons(List<j> r17) {
        Intrinsics.checkNotNullParameter(r17, "items");
        List<j> r2 = r17;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        j r5 = (j) r4.next();
        int r6 = c.h;
        Intrinsics.checkNotNullParameter(r5, "item");
        r3.add(new c(r5.getType(), r5.b, r5.d, r5.e, r5.f, r5.g, r5.h));
        goto L4
    L7:
        if (Intrinsics.areEqual(r3, this.f) == false) goto L10;
        FLogger.a.d("PreviewToolbarView", "setButtons 签名未变化，跳过重建");
        return;
    L10:
        this.f = r3;
        this.l = r17;
        this.e.removeAllViews();
        ((LinkedHashMap) this.g).clear();
        ToolbarLayoutMode r7 = this.a;
        int r8 = d.a[r7.ordinal()];
        if (r8 == 1) goto L22;
        if (r8 != 2) goto L21;
        ToolbarVisualStyle r9 = this.b;
        int r10 = d.b[r9.ordinal()];
        if (r10 == 1) goto L19;
        if (r10 != 2) goto L18;
        int r11 = i5.h();
    L23:
        int r12 = 0;
        if (this.a != ToolbarLayoutMode.VERTICAL) goto L26;
        boolean r13 = true;
    L27:
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        Iterator<j> r1 = r17.iterator();
        int r16 = 0;
    L29:
        if (r1.hasNext() == false) goto L150;
        final j r18 = r1.next();
        if (r18.f == false) goto L29;
        if (r18.h == false) goto L35;
        r14.add(r18);
        goto L29
    L35:
        r15.add(r18);
        boolean r19 = this.d.contains(r18.getType().getKey());
        if (r13 == false) goto L38;
    L44:
        final PreviewToolbarItemView r20 = new PreviewToolbarItemView(getContext(), null, 6, r12);
        ToolbarLayoutMode r21 = this.a;
        Intrinsics.checkNotNullParameter(r18, "item");
        Intrinsics.checkNotNullParameter(r21, "mode");
        r20.d = r18;
        r20.e = r21;
        r20.f = r19;
        r20.c = null;
        r20.removeAllViews();
        int r110 = PreviewToolbarItemView.b.a[r21.ordinal()];
        if (r110 != 1) goto L47;
        int r111 = 2131563089;
    L58:
        LayoutInflater.from(r20.getContext()).inflate(r111, r20);
        r20.a = (ImageView) r20.findViewById(2131376297);
        r20.b = (TextView) r20.findViewById(2131391574);
        ToolbarLayoutMode r112 = ToolbarLayoutMode.VERTICAL;
        if (r21 == r112) goto L61;
    L72:
        ImageView r22 = r20.a;
        if (r22 == null) goto L92;
        if (r21 == ToolbarLayoutMode.HORIZONTAL) goto L77;
    L79:
        int r113 = i5.A();
    L80:
        ViewGroup.LayoutParams r114 = r22.getLayoutParams();
        if ((r114 instanceof LinearLayout.LayoutParams) == false) goto L83;
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r114;
    L84:
        if (r115 == null) goto L86;
        r115.width = r113;
        r115.height = r113;
    L87:
        r22.setLayoutParams(r115);
        int r116 = r18.b;
        if (r116 == 0) goto L90;
        r22.setImageResource(r116);
        r22.setVisibility(0);
        goto L92
    L90:
        r22.setVisibility(8);
        goto L92
    L86:
        r115 = null;
        goto L87
    L83:
        r115 = null;
        goto L84
    L77:
        if (r18.getType() != ToolbarButtonType.CROP) goto L79;
        r113 = i5.E();
    L92:
        if (r21 == r112) goto L94;
    L95:
        TextView r23 = r20.b;
        if (r23 == null) goto L123;
        Object r117 = r18.i.get("selected");
        if ((r117 instanceof Boolean) == false) goto L101;
        Boolean r118 = (Boolean) r117;
    L102:
        boolean r119 = Intrinsics.areEqual(r118, Boolean.TRUE);
        if (r20.e == ToolbarLayoutMode.HORIZONTAL) goto L105;
    L110:
        String r120 = r18.e;
        if (r120 != null) goto L113;
    L116:
        boolean r121 = true;
    L117:
        if (r121 == true) goto L119;
        r23.setText(r18.e);
        goto L123
    L119:
        int r122 = r18.d;
        if (r122 == 0) goto L123;
        r23.setText(r122);
        goto L123
    L113:
        if (r120.length() == 0) goto L116;
        r121 = false;
        goto L117
    L105:
        if (r18.getType() != ToolbarButtonType.SELECT) goto L110;
        if (r20.f == false) goto L110;
        if (r119 == false) goto L110;
        r23.setText(2131900472);
        goto L123
    L101:
        r118 = null;
    L123:
        if (r20.e == ToolbarLayoutMode.HORIZONTAL) goto L125;
    L142:
        r12 = 0;
    L143:
        r20.a();
        r20.setClickable(true);
        r20.setFocusable(true);
        r20.setOnClickListener(new g(r18, this, r20));
        LinearLayout.LayoutParams r123 = new LinearLayout.LayoutParams(-2, -2);
        if (r16 <= 0) goto L148;
        if (r13 == false) goto L147;
        r123.topMargin = r11;
        goto L148
    L147:
        r123.setMarginStart(r11);
    L148:
        this.e.addView(r20, r123);
        this.g.put(r18.getType(), r20);
        r16 = r16 + 1;
        goto L29
    L125:
        if (r18.getType() != ToolbarButtonType.SELECT) goto L142;
        if (r20.f == false) goto L142;
        Object r24 = r18.i.get("selected");
        if ((r24 instanceof Boolean) == false) goto L132;
        Boolean r124 = (Boolean) r24;
    L133:
        boolean r25 = Intrinsics.areEqual(r124, Boolean.TRUE);
        r12 = 0;
        View r125 = r20.getChildAt(0);
        if (r125 == null) goto L139;
        if (r25 == false) goto L137;
        int r26 = 2131243172;
    L138:
        r125.setBackgroundResource(r26);
        goto L139
    L137:
        r26 = 2131243171;
    L139:
        ImageView r27 = r20.a;
        if (r27 == null) goto L143;
        r27.setImageResource(r18.b);
        goto L143
    L132:
        r124 = null;
        goto L133
    L94:
        if (r18.getType() == ToolbarButtonType.MORE) goto L123;
    L61:
        if (r18.getType() != ToolbarButtonType.MORE) goto L72;
        int r28 = r20.getResources().getDimensionPixelSize(v19.c.b(2130971490, null, 2131167350));
        View r126 = r20.getChildAt(0);
        if (r126 == null) goto L69;
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        if (r127 == null) goto L67;
        r127.width = r28;
        r127.height = r28;
    L68:
        r126.setLayoutParams(r127);
        goto L69
    L67:
        r127 = new FrameLayout.LayoutParams(r28, r28);
    L69:
        TextView r29 = r20.b;
        if (r29 == null) goto L72;
        r29.setVisibility(8);
        goto L72
    L47:
        if (r110 != 2) goto L56;
        if (r18.getType() != ToolbarButtonType.SELECT) goto L52;
        if (r19 == false) goto L52;
        r111 = 2131563088;
    L52:
        if (r19 == false) goto L54;
        r111 = 2131563087;
        goto L58
    L54:
        r111 = 2131563086;
        goto L58
    L56:
        throw new NoWhenBranchMatchedException();
    L38:
        if (this.b != ToolbarVisualStyle.MEDIA_SOURCE_V4) goto L44;
        if (r16 <= 0) goto L44;
        if (r18.getType() != ToolbarButtonType.SELECT) goto L44;
        if (r19 == false) goto L44;
        LinearLayout r128 = this.e;
        View r129 = new View(getContext());
        r129.setBackgroundColor(ContextCompat.getColor(r129.getContext(), 2131106537));
        LinearLayout.LayoutParams r30 = new LinearLayout.LayoutParams(i5.b(), i5.q());
        r30.gravity = 16;
        r30.setMarginStart(r11);
        Unit r31 = Unit.INSTANCE;
        r128.addView(r129, r30);
        goto L44
    L150:
        this.i = r14;
        return;
    L26:
        r13 = false;
        goto L27
    L18:
        throw new NoWhenBranchMatchedException();
    L19:
        r11 = i5.r0();
        goto L23
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r11 = i5.Y();
        goto L23
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.ViewGroup, com.larus.bmhome.view.menu.CreateMenu] */
    public final void a(ToolbarButtonType r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "type");
        PreviewToolbarItemView r0 = (PreviewToolbarItemView) ((LinkedHashMap) this.g).get(r9);
        if (r0 == null) goto L5;
        r0.setLoading(r10);
        return;
    L5:
        ?? r1 = this.j;
        if (r1 == 0) goto L57;
        Iterator<T> r2 = this.i.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        if (((j) r3).getType() != r9) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
    L17:
        j r4 = (j) r3;
        if (r4 == null) goto L57;
        int r5 = r4.c;
        if (r5 != 0) goto L23;
        r5 = r4.b;
    L23:
        boolean r7 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L26;
        int r8 = 2131241743;
    L27:
        int r11 = r9.ordinal();
        if (r10 == true) goto L31;
        r8 = 0;
    L31:
        if (r10 == false) goto L34;
        r5 = 0;
    L34:
        LarusCreateMenuItemLayoutBinding r12 = r1.b.get(r11);
        if (r12 == null) goto L52;
        SimpleDraweeView r13 = r12.c;
        if (r10 == false) goto L42;
        if (r8 == 0) goto L41;
        r13.setImageDrawable(AppCompatResources.getDrawable(r1.getContext(), r8));
    L41:
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r13, "rotation", new float[]{0.0f, 360.0f});
        r14.setDuration(1000);
        r14.setRepeatCount(-1);
        r14.setInterpolator(new LinearInterpolator());
        r14.start();
        r13.setTag(2131392492, r14);
        r12.a.setEnabled(false);
        r12.a.setClickable(false);
        goto L52
    L42:
        Object r15 = r13.getTag(2131392492);
        if ((r15 instanceof ObjectAnimator) == false) goto L45;
        ObjectAnimator r16 = (ObjectAnimator) r15;
    L46:
        if (r16 == null) goto L48;
        r16.cancel();
    L48:
        r13.setRotation(0.0f);
        r13.setTag(2131392492, null);
        if (r5 == 0) goto L51;
        r13.setImageResource(r5);
    L51:
        r12.a.setEnabled(true);
        r12.a.setClickable(true);
        goto L52
    L45:
        r16 = null;
    L52:
        if (r10 == true) goto L66;
        PreviewToolbarItemView r17 = this.k;
        if (r17 == null) goto L67;
        com.larus.bmhome.view.screenmenu.d r18 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r17);
        return;
    L67:
        return;
    L66:
        return;
    L26:
        r8 = 2131241742;
        goto L27
    L13:
        r6 = false;
        goto L14
    L16:
        r3 = null;
    L57:
        PreviewToolbarItemView r19 = (PreviewToolbarItemView) ((LinkedHashMap) this.g).get(ToolbarButtonType.MORE);
        if (r19 == null) goto L69;
        r19.setLoading(r10);
        return;
    }

    public final void b(ToolbarButtonType r5, Function1<? super j, j> r6) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "updater");
        List<j> r0 = this.l;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        j r3 = (j) r2.next();
        if (r3.getType() != r5) goto L8;
        r3 = (j) r6.invoke(r3);
    L8:
        r1.add(r3);
        goto L4
    L10:
        if (Intrinsics.areEqual(r1, this.l) == false) goto L12;
        return;
    L12:
        setButtons(r1);
    }

    public PreviewToolbarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ToolbarLayoutMode.VERTICAL;
        this.b = ToolbarVisualStyle.LEGACY;
        this.d = SetsKt.emptySet();
        this.e = new LinearLayout(r2);
        this.f = CollectionsKt.emptyList();
        this.g = new LinkedHashMap();
        this.h = CollectionsKt.emptyList();
        this.i = CollectionsKt.emptyList();
        this.l = CollectionsKt.emptyList();
    }

    public /* synthetic */ PreviewToolbarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
