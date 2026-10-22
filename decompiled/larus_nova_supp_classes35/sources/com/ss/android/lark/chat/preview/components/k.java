package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.preview.components.view.PreviewHeaderView;
import com.ss.android.lark.chat.preview.components.view.TailDrawableTextView;
import com.ss.android.lark.chat.preview.entity.component.Tag;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.chat.preview.entity.component.property.PreviewHeaderProperty;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.FontType;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k extends q6c.e<PreviewHeaderProperty, PreviewHeaderView, r6c.a> {
    public static final float s = 0.0f;
    public final s6c.b f;
    public final com.ss.android.lark.chat.preview.actions.b g;
    public final URLPreviewParams h;
    public final PreviewHeaderView.Type i;
    public s6c.b.a j;
    public final int k;
    public final int l;
    public final Token m;
    public final boolean n;
    public final String o;
    public TailDrawableTextView p;
    public boolean q;
    public final boolean r;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Tag.values().length];
            r0[Tag.APPROVAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L38:
            r0[Tag.OFFICIAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L52:
            r0[Tag.ONCALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L40:
            r0[Tag.ONCALL_OFFLINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L42:
            r0[Tag.EXTERNAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L12:
            a = r0;
            int[] r1 = new int[ZoomLevel6.values().length];
            r1[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L34:
            r1[ZoomLevel6.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L46:
            r1[ZoomLevel6.LARGE1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L32:
            r1[ZoomLevel6.LARGE2.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L44:
            r1[ZoomLevel6.LARGE3.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L36:
            r1[ZoomLevel6.LARGE4.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L19:
            b = r1;
        }
    }

    public static final class c extends SimpleTarget<Drawable> {
        public final /* synthetic */ k a;
        public final /* synthetic */ ImageView b;
        public final /* synthetic */ Drawable c;

        public final void onLoadFailed(Drawable r2) {
            super.onLoadFailed(r2);
            this.b.setImageDrawable(this.c);
        }

        public final void onResourceReady(Object r4) {
            Drawable r5 = (Drawable) r4;
            super.onResourceReady(r5);
            if (r5 != null) goto L5;
        L7:
            this.b.setImageDrawable(r5);
            return;
        L5:
            if (((PreviewHeaderProperty) ((q6c.e) this.a).e).getIconColor() == null) goto L7;
            r5.mutate();
            ThemeColor r0 = ((PreviewHeaderProperty) ((q6c.e) this.a).e).getIconColor();
            Intrinsics.checkNotNull(r0);
            r5.setTint(com.ss.android.lark.export.entity.preview.a.a(r0, this.b.getContext(), null));
            goto L7
        }

        public c(k r1, ImageView r2, Drawable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ k a;

        public d(k r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.chat.preview.actions.b r3 = this.a.g;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r3.a(1);
        }
    }

    static {
        s = UIHelper.dp2px(2.5f);
    }

    public final String m() {
        r6c.a r0 = ((q6c.a) this).a;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        UDIcon r2 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r2 == null) goto L9;
        String r3 = r2.getUnicode();
    L10:
        boolean r4 = false;
        if (r3 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L21;
        UDIcon r6 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r6 != null) goto L67;
        return null;
    L67:
        return r6.getUnicode();
    L21:
        UDIcon r7 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r7 == null) goto L24;
        String r8 = r7.getKey();
    L25:
        if (r8 != null) goto L27;
    L30:
        boolean r9 = true;
    L31:
        if (r9 == true) goto L35;
        UDIcon r10 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r10 != null) goto L69;
        return null;
    L69:
        return r10.getKey();
    L35:
        if (r1 != null) goto L37;
    L52:
        ImageSet r11 = ((PreviewHeaderProperty) ((q6c.e) this).e).getIconKey();
        if (r11 == null) goto L55;
        String r12 = r11.getKey();
    L56:
        if (r12 != null) goto L58;
    L59:
        r4 = true;
    L60:
        if (r4 == true) goto L65;
        ImageSet r13 = ((PreviewHeaderProperty) ((q6c.e) this).e).getIconKey();
        if (r13 != null) goto L73;
        return null;
    L73:
        return r13.getKey();
    L65:
        return ((PreviewHeaderProperty) ((q6c.e) this).e).getFaviconUrl();
    L58:
        if (r12.length() != 0) goto L60;
    L55:
        r12 = null;
        goto L56
    L37:
        if (h18.f.a(r1) == false) goto L52;
        ImageSet r14 = ((PreviewHeaderProperty) ((q6c.e) this).e).getDmIcon();
        if (r14 == null) goto L41;
        String r15 = r14.getKey();
    L42:
        if (r15 != null) goto L44;
    L47:
        boolean r16 = true;
    L48:
        if (r16 == true) goto L52;
        ImageSet r17 = ((PreviewHeaderProperty) ((q6c.e) this).e).getDmIcon();
        if (r17 != null) goto L71;
        return null;
    L71:
        return r17.getKey();
    L44:
        if (r15.length() == 0) goto L47;
        r16 = false;
        goto L48
    L41:
        r15 = null;
        goto L42
    L27:
        if (r8.length() == 0) goto L30;
        r9 = false;
        goto L31
    L24:
        r8 = null;
        goto L25
    L13:
        if (r3.length() == 0) goto L16;
        r5 = false;
        goto L17
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final String i() {
        return this.o;
    }

    public final boolean j() {
        return this.n;
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 == null) goto L9;
        Context r2 = r1.getContext();
        if (r2 == null) goto L9;
        return new PreviewHeaderView(r2);
    L9:
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.widget.TextView, com.ss.android.lark.chat.preview.components.view.TailDrawableTextView] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.widget.TextView, com.ss.android.lark.chat.preview.components.view.TailDrawableTextView] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final s6c.b.a d(s6c.b.a r8) {
        Intrinsics.checkNotNullParameter(r8, "size");
        int r0 = UIHelper.dp2px(r8.a);
        int r9 = UIHelper.dp2px(r8.b);
        s6c.b r1 = this.f;
        String r2 = null;
        if (r1 == null) goto L5;
        s6c.b.a r3 = r1.d(new s6c.b.a(PreviewHeaderView.h, r9));
    L6:
        float r4 = 0.0f;
        if (r3 == null) goto L9;
        float r5 = r3.a;
    L10:
        int r6 = UIHelper.dp2px(r5);
        if (r3 == null) goto L13;
        r4 = r3.b;
    L13:
        int r7 = UIHelper.dp2px(r4);
        this.j = r3;
        Log.d("[URLPreview]PreviewTitleComponent", "CustomRectSize is:" + r3);
        String r10 = ((PreviewHeaderProperty) ((q6c.e) this).e).getTitle();
        if (r10 == null) goto L17;
        r2 = StringsKt.trim(r10).toString();
    L17:
        if (TextUtils.isEmpty(r2) == false) goto L21;
        s6c.b.a r11 = new s6c.b.a(UIHelper.px2dp(r0), UIHelper.px2dp(RangesKt.coerceAtLeast(this.k, r7)));
        Log.d("[URLPreview]PreviewTitleComponent", "title is empty, size is:" + r11);
        return r11;
    L21:
        if (this.r == false) goto L23;
    L26:
        int r12 = (r0 - this.k) - PreviewHeaderView.j;
    L28:
        if (this.f == null) goto L31;
        r12 = (r12 - r6) - PreviewHeaderView.g;
    L31:
        if (TextUtils.isEmpty(m()) == true) goto L33;
        r12 = (r12 - this.k) - PreviewHeaderView.j;
    L33:
        r6c.a r13 = ((q6c.a) this).a;
        if (r13 == null) goto L42;
        Context r14 = r13.getContext();
        if (r14 == null) goto L42;
        TailDrawableTextView r15 = this.p;
        ?? r16 = r15;
        if (r15 != null) goto L41;
        ?? r17 = new TailDrawableTextView(r14);
        r17.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.p = r17;
        r16 = r17;
    L41:
        k(r16);
        r16.measure(View.MeasureSpec.makeMeasureSpec(r12, PluginList.LEVEL_NOT_SET), View.MeasureSpec.makeMeasureSpec(r9, PluginList.LEVEL_NOT_SET));
        int r18 = r16.getMeasuredHeight();
    L43:
        int r19 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(this.k, r7), r18);
        Log.i("[URLPreview]PreviewTitleComponent", "sizeToFit, width is:" + r0 + ", height is:" + r19);
        return new s6c.b.a(UIHelper.px2dp(r0), UIHelper.px2dp(r19));
    L42:
        r18 = 0;
        goto L43
    L23:
        if (this.q == true) goto L26;
        r12 = r0;
        goto L28
    L9:
        r5 = 0.0f;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(TailDrawableTextView r13) {
        Integer r0 = ((PreviewHeaderProperty) ((q6c.e) this).e).getNumberOfLines();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        r13.setMaxLines(Math.min(Math.max(0, r1), Integer.MAX_VALUE));
        int r2 = h6b.a.a;
        r13.setTextSize(0, h6b.a.c(r13.getContext(), new FontLevel(FontType.HEADLINE, 0, 2, null)));
        r13.getPaint().setFakeBoldText(true);
        Context r3 = r13.getContext();
        TCStyle r4 = ((q6c.b) this).c;
        if ((r4 instanceof Style) == false) goto L12;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        ThemeColor r5 = ((Style) r4).getTextColorV2();
        if (r5 == null) goto L12;
        int r6 = com.ss.android.lark.export.entity.preview.a.a(r5, r3, null);
    L15:
        r13.setTextColor(r6);
        r13.setLineSpacing(s, zz7.b.d().getMultiplier());
        String r7 = ((PreviewHeaderProperty) ((q6c.e) this).e).getTitle();
        if (r7 == null) goto L18;
        String r8 = StringsKt.trim(r7).toString();
    L19:
        r13.setTailContent("…");
        if (((PreviewHeaderProperty) ((q6c.e) this).e).getLarkTag() != null) goto L55;
        r6c.a r9 = ((q6c.a) this).a;
        if (r9 == null) goto L79;
        Context r10 = r9.getContext();
        if (r10 == null) goto L79;
        String r11 = ((PreviewHeaderProperty) ((q6c.e) this).e).getHeaderTag();
        if (r11 != null) goto L29;
    L32:
        boolean r12 = true;
    L33:
        if (r12 == true) goto L79;
        String r14 = ((PreviewHeaderProperty) ((q6c.e) this).e).getHeaderTag();
        int r15 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r16 = new com.larksuite.component.ui.tag.f.a();
        r16.d = r14;
        ThemeColor r17 = ((PreviewHeaderProperty) ((q6c.e) this).e).getTagTextColor();
        if (r17 == null) goto L38;
        Integer r18 = Integer.valueOf(com.ss.android.lark.export.entity.preview.a.a(r17, r10, null));
    L39:
        r16.f = r18;
        ThemeColor r19 = ((PreviewHeaderProperty) ((q6c.e) this).e).getTagColor();
        if (r19 == null) goto L42;
        Integer r20 = Integer.valueOf(com.ss.android.lark.export.entity.preview.a.a(r19, r10, null));
    L43:
        r16.h = r20;
        com.larksuite.component.ui.tag.f r21 = new com.larksuite.component.ui.tag.f(r16);
        int r22 = LarkNameTag.d;
        LarkNameTag.d r23 = LarkNameTag.f.a(r10);
        TCStyle r24 = ((q6c.b) this).c;
        if ((r24 instanceof Style) == false) goto L54;
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        FontLevel r25 = ((Style) r24).getFontLevel();
        if (r25 == null) goto L49;
        FontType r26 = r25.getType();
        if (r26 == null) goto L49;
    L50:
        if (r25 == null) goto L52;
        int r27 = r25.getLevel();
    L53:
        ((LarkNameTag.c) r23).g = UIHelper.sp2px(h6b.a.b(r26, r27).getNormal());
        goto L54
    L52:
        r27 = 0;
    L49:
        r26 = FontType.CAPTION;
    L54:
        r23.e(r21, true);
        com.larksuite.component.ui.tag.d r28 = r23.f().b();
    L80:
        if (r28 != null) goto L82;
        r13.setText(r8);
        r13.d = null;
        r13.e = 0;
        r13.f = 0;
        r13.g = false;
        return;
    L82:
        r13.getContext();
        ncc.g r29 = new ncc.g();
        r29.a(r8);
        Context r30 = r13.getContext();
        int r31 = r28.getIntrinsicWidth();
        int r32 = r28.getIntrinsicHeight();
        int r33 = PreviewHeaderView.i;
        r29.b("$", new com.ss.android.lark.chat.preview.components.view.a(r30, r31, r32, r33, r28), 33);
        r13.d = r28;
        r13.e = r33;
        r13.f = 0;
        r13.g = false;
        r13.setText(r29);
        return;
    L42:
        r20 = null;
        goto L43
    L38:
        r18 = null;
        goto L39
    L29:
        if (r11.length() == 0) goto L32;
        r12 = false;
    L79:
        r28 = null;
        goto L80
    L55:
        r6c.a r34 = ((q6c.a) this).a;
        if (r34 == null) goto L79;
        Context r35 = r34.getContext();
        if (r35 == null) goto L79;
        int r36 = UIHelper.dp2px(12.0f);
        int r37 = LarkNameTag.d;
        LarkNameTag.d r38 = LarkNameTag.f.a(r35);
        ((LarkNameTag.c) r38).g = r36;
        Tag r39 = ((PreviewHeaderProperty) ((q6c.e) this).e).getLarkTag();
        if (r39 != null) goto L63;
        int r40 = -1;
    L64:
        if (r40 == 1) goto L77;
        if (r40 != 2) goto L67;
        r38.y = true;
    L78:
        r28 = r38.f().b();
        goto L80
    L67:
        if (r40 != 3) goto L69;
        r38.n = true;
        r38.o = false;
        goto L78
    L69:
        if (r40 != 4) goto L71;
        r38.n = false;
        r38.o = true;
        goto L78
    L71:
        if (r40 == 5) goto L73;
        Unit r41 = Unit.INSTANCE;
        goto L78
    L73:
        ((LarkNameTag.c) r38).e = true;
        goto L78
    L77:
        r38.m = true;
        goto L78
    L63:
        r40 = b.a[r39.ordinal()];
        goto L64
    L18:
        r8 = null;
    L12:
        if (((PreviewHeaderProperty) ((q6c.e) this).e).getTheme() != Theme.LIGHT) goto L14;
        r6 = UDColorUtils.getColor(r3, 2131106622);
        goto L15
    L14:
        r6 = UDColorUtils.getColor(r3, 2131105560);
        goto L15
    L5:
        r1 = PreviewHeaderView.k;
        goto L6
    }

    public final ImageSet l(Context r1) {
        if (h18.f.a(r1) == false) goto L17;
        ImageSet r2 = ((PreviewHeaderProperty) ((q6c.e) this).e).getDmIcon();
        if (r2 == null) goto L7;
        String r3 = r2.getKey();
    L8:
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L17;
        return ((PreviewHeaderProperty) ((q6c.e) this).e).getDmIcon();
    L10:
        if (r3.length() == 0) goto L13;
        r4 = false;
        goto L14
    L7:
        r3 = null;
    L17:
        return ((PreviewHeaderProperty) ((q6c.e) this).e).getIconKey();
    }

    public final void n(ImageView r5) {
        IRequestCreator r0 = ImageLoader.with(r5.getContext());
        ImageSet r1 = l(r5.getContext());
        if (r1 == null) goto L5;
        String r2 = r1.getKey();
    L7:
        if (r2 != null) goto L9;
    L14:
        IRequestCreator r3 = r0.load(((PreviewHeaderProperty) ((q6c.e) this).e).getFaviconUrl()).diskCacheStrategy(DiskCacheStrategy.RESULT);
    L15:
        Drawable r4 = UIHelper.getDrawable(2131235936);
        int r6 = this.k;
        r4.setBounds(0, 0, r6, r6);
        Intrinsics.checkNotNull(r4);
        IRequestCreator r7 = r3.placeholder(r4);
        g6b.a.InterfaceC0223a r8 = g6b.a.a;
        if (r8 == null) goto L18;
        r8.c();
    L18:
        IRequestCreator r9 = r7.isAsync(false);
        int r10 = this.k;
        r9.override(r10, r10).into(new c(this, r5, r4));
        return;
    L9:
        if (r2.length() <= 0) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L14;
        r3 = r0.load(new EncryptImage(r2));
        goto L15
    L11:
        r11 = false;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    public void update(PreviewHeaderView r14) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.update(r14);
        PreviewHeaderView.Type r0 = r14.getType();
        PreviewHeaderView.Type r1 = this.i;
        boolean r3 = true;
        if (r0 == r1) goto L13;
        Intrinsics.checkNotNullParameter(r1, IPortraitService.TYPE);
        r14.e = r1;
        r14.a = (TailDrawableTextView) r14.findViewById(2131391606);
        r14.b = (FrameLayout) r14.findViewById(2131368368);
        r14.c = (ImageView) r14.findViewById(2131364767);
        r14.d = (ImageView) r14.findViewById(2131376682);
        int r2 = UIHelper.dp2px(20.0f);
        int r4 = UIHelper.dp2px(30.0f);
        ImageView r5 = r14.c;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreBtn");
        r5 = null;
    L7:
        UIUtils.expandClickRegion(r5, r2, r2, r4, r2);
        if (Build.VERSION.SDK_INT < 29) goto L13;
        AppCompatTextView r6 = r14.a;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleTV");
        r6 = null;
    L12:
        r6.setBreakStrategy(1);
    L13:
        k(r14.getTitleView());
        Paint.FontMetrics r7 = r14.getTitleView().getPaint().getFontMetrics();
        float r8 = r7.bottom - r7.top;
        g6b.a.InterfaceC0223a r9 = g6b.a.a;
        if (r9 == null) goto L20;
        com.ss.android.lark.officesdk.integrator.im.h r10 = r9.getFeatureGatingDependency();
        if (r10 == null) goto L20;
        if (r10.a("lark.url_preview.dark_mode_icon") != true) goto L20;
        boolean r11 = true;
    L21:
        ImageView r12 = r14.getTitleIconView();
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r13;
        int r16 = this.k;
        r15.width = r16;
        r15.height = r16;
        if (r11 == true) goto L24;
        r15.topMargin = (int) ((r8 - r16) / 2);
    L26:
        if (TextUtils.isEmpty(m()) == false) goto L28;
        Drawable r17 = com.larksuite.framework.utils.UIUtils.getDrawable(r12.getContext(), 2131255013);
        r17.mutate();
        r17.setTint(UDColorUtils.getColor(r12.getContext(), 2131102121));
        r12.setImageDrawable(r17);
    L120:
        FrameLayout r18 = r14.getCustomContainer();
        s6c.b r19 = this.f;
        int r20 = 8;
        if (r19 != null) goto L123;
        r18.setVisibility(8);
    L133:
        ImageView r21 = r14.getMoreBtn();
        r6c.a r22 = ((q6c.a) this).a;
        if ((r22 instanceof vcb.d) == false) goto L136;
        vcb.d r23 = (vcb.d) r22;
    L137:
        if (r23 == null) goto L139;
        URLPreviewParams r24 = r23.d;
    L140:
        if (r24 != null) goto L142;
    L144:
        boolean r25 = false;
    L145:
        if (r25 == false) goto L147;
        r21.setVisibility(8);
        r21.setOnClickListener(null);
    L181:
        TCStyle r26 = ((q6c.b) this).c;
        if ((r26 instanceof Style) == false) goto L184;
        Style r27 = (Style) r26;
    L185:
        if (r27 == null) goto L188;
        Style.applyBackground$default(r27, r14, null, 2, null);
    L188:
        if (this.g != null) goto L190;
        r14.setOnClickListener(null);
        r14.setClickable(false);
        return;
    L190:
        r14.setOnClickListener(new d(this));
        return;
    L184:
        r27 = null;
        goto L185
    L147:
        if (r24 == null) goto L156;
        Boolean r28 = r24.j;
        if (r28 == null) goto L151;
        boolean r29 = r28.booleanValue();
    L152:
        if (r29 == false) goto L156;
        if (r24.k == true) goto L156;
        boolean r30 = true;
    L157:
        g6b.a.InterfaceC0223a r31 = g6b.a.a;
        if (r31 == null) goto L164;
        com.ss.android.lark.officesdk.integrator.im.c r32 = r31.c();
        if (r32 == null) goto L164;
        if (r32.b() != true) goto L164;
        boolean r33 = true;
    L166:
        if (this.q == false) goto L170;
        if (r33 == false) goto L171;
        if (r30 == true) goto L170;
    L171:
        this.q = r3;
        if (r3 == false) goto L174;
    L175:
        r20 = 0;
    L176:
        r21.setVisibility(r20);
        Context r34 = r21.getContext();
        if (((PreviewHeaderProperty) ((q6c.e) this).e).getTheme() != Theme.LIGHT) goto L179;
        int r35 = UDColorUtils.getColor(r34, 2131102419);
    L180:
        r21.setImageDrawable(UDIconUtils.getIconDrawable(r21.getContext(), 2131255147, r35));
        ViewGroup.LayoutParams r36 = r21.getLayoutParams();
        int r37 = this.l;
        r36.width = r37;
        r36.height = r37;
        r21.setOnClickListener(new l(this, r21));
        goto L181
    L179:
        r35 = UDColorUtils.getAlphaColor(r34, 2131105560, 0.8f);
        goto L180
    L174:
        if (this.r == false) goto L176;
    L170:
        r3 = false;
    L164:
        r33 = false;
        goto L166
    L151:
        r29 = false;
    L156:
        r30 = false;
        goto L157
    L142:
        if (r24.m != true) goto L144;
        r25 = true;
        goto L145
    L139:
        r24 = null;
        goto L140
    L136:
        r23 = null;
        goto L137
    L123:
        r18.setVisibility(0);
        if (r18.getChildCount() <= 0) goto L126;
        r19.h(r18.getChildAt(0));
        goto L133
    L126:
        s6c.b.a r38 = this.j;
        if (r38 == null) goto L133;
        int r39 = UIHelper.dp2px(r38.a);
        int r40 = UIHelper.dp2px(r38.b);
        View r41 = r19.a(new RectF(0.0f, r39, 0.0f, r40));
        if (r41 == null) goto L133;
        r18.addView(r41, new FrameLayout.LayoutParams(r39, r40));
        r19.h(r41);
        goto L133
    L28:
        UDIcon r42 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r42 == null) goto L31;
        String r43 = r42.getUnicode();
    L32:
        if (r43 != null) goto L34;
    L37:
        boolean r44 = true;
    L38:
        if (r44 == true) goto L48;
        Integer[] r45 = sbb.d.a;
        UDIcon r46 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r46 == null) goto L43;
        String r47 = r46.getUnicode();
        if (r47 == null) goto L43;
    L44:
        Bitmap r48 = sbb.d.a(r47);
        if (r48 != null) goto L47;
        n(r12);
        goto L120
    L47:
        r12.setImageBitmap(r48);
    L43:
        r47 = BuildConfig.FLAVOR;
        goto L44
    L48:
        UDIcon r49 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r49 == null) goto L51;
        String r50 = r49.getKey();
    L52:
        if (r50 != null) goto L54;
    L57:
        boolean r51 = true;
    L58:
        if (r51 == true) goto L79;
        int r52 = edb.a.a;
        UDIcon r53 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r53 == null) goto L62;
        String r54 = r53.getKey();
    L63:
        int r55 = edb.a.a(r54);
        if (r55 != 0) goto L66;
        n(r12);
        goto L120
    L66:
        Drawable r56 = r12.getContext().getResources().getDrawable(r55, null);
        if (r56 == null) goto L78;
        UDIcon r57 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r57 == null) goto L71;
        ThemeColor r58 = r57.getThemeColor();
    L72:
        if (r58 == null) goto L78;
        r56.mutate();
        UDIcon r59 = ((PreviewHeaderProperty) ((q6c.e) this).e).getUdIcon();
        if (r59 == null) goto L76;
        ThemeColor r60 = r59.getThemeColor();
    L77:
        Intrinsics.checkNotNull(r60);
        r56.setTint(com.ss.android.lark.export.entity.preview.a.a(r60, r12.getContext(), null));
        goto L78
    L76:
        r60 = null;
        goto L77
    L71:
        r58 = null;
    L78:
        r12.setImageDrawable(r56);
        goto L120
    L62:
        r54 = null;
        goto L63
    L79:
        Drawable r61 = UIHelper.getDrawable(2131235936);
        int r62 = this.k;
        r61.setBounds(0, 0, r62, r62);
        Intrinsics.checkNotNull(r61);
        ImageSet r63 = l(r12.getContext());
        h6b.b.a r64 = new h6b.b.a();
        r64.a = r63;
        r64.b = ((PreviewHeaderProperty) ((q6c.e) this).e).getFaviconUrl();
        r64.g = ((PreviewHeaderProperty) ((q6c.e) this).e).getIconColor();
        Intrinsics.checkNotNullParameter(r61, "placeHolder");
        r64.c = r61;
        Intrinsics.checkNotNullParameter(r61, "errorDrawable");
        r64.d = r61;
        int r65 = this.k;
        r64.e = r65;
        r64.f = r65;
        h6b.b r66 = new h6b.b(r64);
        if (r63 == null) goto L82;
        String r67 = r63.getKey();
    L83:
        if (r67 != null) goto L85;
    L88:
        boolean r68 = true;
    L90:
        if (r68 == false) goto L104;
        int r69 = h6b.e.a;
        Intrinsics.checkNotNullParameter(r12, "imageView");
        Intrinsics.checkNotNullParameter(r66, "imageLoadParams");
        String r70 = r66.g;
        if (r70 != null) goto L94;
    L97:
        boolean r71 = true;
    L98:
        if (r71 == false) goto L100;
        r12.setImageDrawable(r66.b);
        goto L120
    L100:
        IRequestCreator r72 = ImageLoader.with(r12.getContext()).load(r70).asDrawable().placeholder(r66.b).error(r66.c);
        g6b.a.InterfaceC0223a r73 = g6b.a.a;
        if (r73 == null) goto L103;
        r73.c();
    L103:
        r72.isAsync(false).override(r66.d, r66.e).centerCrop().into(new h6b.d(r66, r12));
        goto L120
    L94:
        if (r70.length() == 0) goto L97;
        r71 = false;
        goto L98
    L104:
        int r74 = h6b.e.a;
        Intrinsics.checkNotNullParameter(r12, "imageView");
        Intrinsics.checkNotNullParameter(r66, "imageLoadParams");
        ImageSet r75 = r66.a;
        if (r75 == null) goto L107;
        String r76 = r75.getKey();
    L108:
        if (r76 != null) goto L110;
    L113:
        boolean r77 = true;
    L114:
        if (r77 == false) goto L116;
        r12.setImageDrawable(r66.b);
        goto L120
    L116:
        IRequestCreator r78 = ImageLoader.with(r12.getContext()).load(new EncryptImage(r76)).placeholder(r66.b);
        g6b.a.InterfaceC0223a r79 = g6b.a.a;
        if (r79 == null) goto L119;
        r79.c();
    L119:
        r78.isAsync(false).override(r66.d, r66.e).dontAnimate(false).centerCrop().into(new h6b.c(r66, r12));
        goto L120
    L110:
        if (r76.length() == 0) goto L113;
        r77 = false;
        goto L114
    L107:
        r76 = null;
        goto L108
    L85:
        if (r67.length() == 0) goto L88;
        r68 = false;
        goto L90
    L82:
        r67 = null;
        goto L83
    L54:
        if (r50.length() == 0) goto L57;
        r51 = false;
        goto L58
    L51:
        r50 = null;
        goto L52
    L34:
        if (r43.length() == 0) goto L37;
        r44 = false;
        goto L38
    L31:
        r43 = null;
        goto L32
    L24:
        r14.f = true;
    L20:
        r11 = false;
        goto L21
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((PreviewHeaderView) r1);
    }

    public k(s6c.b r4, PreviewHeaderProperty r5, Style r6, vcb.d r7) {
        Intrinsics.checkNotNullParameter(r5, "props");
        Intrinsics.checkNotNullParameter(r7, "dependency");
        super(r5, r6, r7);
        this.f = r4;
        this.g = null;
        this.h = r7.d;
        this.i = PreviewHeaderView.Type.ONELINE;
        Integer r8 = ((PreviewHeaderProperty) ((q6c.e) this).e).getIconSize();
        if (r8 == null) goto L5;
        int r9 = r8.intValue();
    L6:
        int r10 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r9, 16), 36);
        g6b.a.InterfaceC0223a r11 = g6b.a.a;
        boolean r12 = true;
        if (r11 == null) goto L13;
        com.ss.android.lark.officesdk.integrator.im.h r13 = r11.getFeatureGatingDependency();
        if (r13 == null) goto L13;
        if (r13.a("lark.url_preview.dark_mode_icon") != true) goto L13;
        boolean r14 = true;
    L14:
        float r0 = 16.0f;
        if (r14 == false) goto L18;
        float r15 = r10 * zz7.b.d().getMultiplier();
    L24:
        this.k = UIHelper.dp2px(r15);
        switch(b.b[zz7.b.d().ordinal()]) {
            case 1: goto L29;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            default: goto L27;
        };
    L28:
        r0 = 18.0f;
        goto L30
    L29:
        r0 = 15.0f;
    L30:
        this.l = UIHelper.dp2px(r0);
        this.m = new Token("LARK-PSDA-messenger-android-copy-url-preview-card");
        this.n = true;
        this.o = "com.ss.android.lark.chat.preview.components.view.PreviewHeaderView";
        Boolean r16 = r5.isNeedClose();
        if (r16 == null) goto L33;
        boolean r17 = r16.booleanValue();
    L34:
        this.q = r17;
        Boolean r18 = r5.isNeedCopyLink();
        if (r18 == null) goto L37;
        r12 = r18.booleanValue();
    L37:
        this.r = r12;
        return;
    L33:
        r17 = true;
        goto L34
    L27:
        throw new NoWhenBranchMatchedException();
    L18:
        switch(b.b[zz7.b.d().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L21;
            case 5: goto L21;
            case 6: goto L21;
            default: goto L20;
        };
    L21:
        r15 = 18.0f;
        goto L24
    L22:
        r15 = 16.0f;
        goto L24
    L23:
        r15 = 15.0f;
        goto L24
    L20:
        throw new NoWhenBranchMatchedException();
    L13:
        r14 = false;
        goto L14
    L5:
        r9 = 16;
        goto L6
    }
}
