package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.preview.entity.component.property.RichTextProperty;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.listeners.RegexParseListener;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.FontType;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Span;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.TextStyleInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.lark.widget.span.g0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n extends q6c.e<RichTextProperty, LKUILightTextView, r6c.a> {
    public static final int n = 0;
    public static final int o = 0;
    public final Style f;
    public final com.ss.android.lark.chat.preview.actions.b g;
    public final Map<String, UrlPreviewAction> h;
    public final UrlPreviewBody i;
    public final String j;
    public Layout k;
    public RichText l;
    public final URLPreviewParams m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[URLPreviewComponent.RichTextProperty.RichTextTheme.values().length];
            r0[URLPreviewComponent.RichTextProperty.RichTextTheme.DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[URLPreviewComponent.RichTextProperty.RichTextTheme.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ n a;

        public c(n r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.chat.preview.actions.b r3 = this.a.g;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r3.a(1);
        }
    }

    public static final class d implements mcc.o {
        public final /* synthetic */ n a;

        public final boolean t(View r2, UrlInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "urlInfo");
            return false;
        }

        public d(n r1) {
            this.a = r1;
        }

        public final void r(View r3, UrlInfo r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "urlInfo");
            n r0 = this.a;
            Context r5 = r3.getContext();
            String r1 = r4.href;
            String r6 = r4.urlPreviewId;
            if (r6 != null) goto L5;
            r6 = BuildConfig.FLAVOR;
        L5:
            n.k(r0, r5, r1, r6);
        }
    }

    public final String i() {
        return "com.ss.android.lark.widget.light.LKUILightTextView";
    }

    public final boolean j() {
        return true;
    }

    static {
        n = UIHelper.dp2px(2.0f);
        o = 2;
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 == null) goto L6;
        LKUILightTextView r4 = new LKUILightTextView(n(r1.getContext()));
        r4.setTEXT_ITALIC_PADDING(0);
        return r4;
    L6:
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    }

    public final s6c.b.a d(s6c.b.a r8) {
        Intrinsics.checkNotNullParameter(r8, "size");
        int r0 = UIHelper.dp2px(r8.a);
        UIHelper.dp2px(r8.b);
        r6c.a r9 = ((q6c.a) this).a;
        float r1 = 0.0f;
        if (r9 == null) goto L42;
        Context r10 = r9.getContext();
        if (r10 == null) goto L42;
        Context r11 = n(r10);
        if (r11 == null) goto L42;
        Layout r12 = l(r11, ((RichTextProperty) ((q6c.e) this).e).getRichText(), r0);
        if (r12 == null) goto L12;
        SpannableStringBuilder r2 = new SpannableStringBuilder(r12.getText());
        boolean r4 = false;
        Iterator r3 = ArrayIteratorKt.iterator((ncc.h[]) r2.getSpans(0, r2.length(), ncc.h.class));
    L15:
        if (r3.hasNext() == false) goto L21;
        TextStyleInfo r5 = ((ncc.h) r3.next()).a;
        if (r5 == null) goto L15;
        if (r5.isItalic == false) goto L15;
        boolean r6 = true;
    L22:
        this.k = r12;
        this.l = ((RichTextProperty) ((q6c.e) this).e).getRichText();
        int r7 = UIHelper.px2dp(r12.getWidth());
        if (UIHelper.dp2px(r7) != r12.getWidth()) goto L25;
        int r13 = 0;
    L26:
        if (r7 <= 0) goto L32;
        int r14 = r7 + r13;
        if (r6 == false) goto L30;
        int r15 = n;
    L31:
        float r16 = r14 + r15;
    L34:
        if (r16 != 0.0f) goto L36;
        r4 = true;
    L36:
        if (r4 == true) goto L40;
        r1 = UIHelper.px2dp(com.ss.android.lark.widget.light.layout.e.a(r12));
    L40:
        return new s6c.b.a(r16, r1);
    L30:
        r15 = 0;
        goto L31
    L32:
        r16 = 0.0f;
        goto L34
    L25:
        r13 = o;
        goto L26
    L21:
        r6 = false;
        goto L22
    L12:
        return new s6c.b.a(0.0f, 0.0f);
    L42:
        return new s6c.b.a(0.0f, 0.0f);
    }

    public final Context n(Context r4) {
        Configuration r0 = new Configuration();
        r0.setTo(r4.getResources().getConfiguration());
        URLPreviewComponent.RichTextProperty.RichTextTheme r1 = ((RichTextProperty) ((q6c.e) this).e).getTheme();
        if (r1 != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 != 1) goto L9;
        int r3 = 32;
    L13:
        r0.uiMode = r3 | (r0.uiMode & (-49));
        Context r5 = r4.createConfigurationContext(r0);
        NewMiraResourcesManager.getInstance().install(r5);
        return r5;
    L9:
        if (r2 == 2) goto L11;
        r3 = r0.uiMode & 48;
        goto L13
    L11:
        r3 = 16;
        goto L13
    L5:
        r2 = b.a[r1.ordinal()];
        goto L7
    }

    public final void o(RichText r6) {
        if (this.j != null) goto L5;
        return;
    L5:
        UrlPreviewBody r0 = this.i;
        if (r0 != null) goto L8;
        return;
    L8:
        HashMap<String, Map<String, PreviewHangPoint>> r1 = r0.getComponentHangPoints();
        com.ss.android.lark.officesdk.integrator.im.e r2 = null;
        if (r1 == null) goto L11;
        Map<String, PreviewHangPoint> r3 = r1.get(this.j);
    L12:
        if (r3 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L39;
        g6b.a.InterfaceC0223a r5 = g6b.a.a;
        if (r5 == null) goto L23;
        r2 = r5.g();
    L23:
        if (r2 != null) goto L25;
        Log.w("RichTextComponent", "richTextDependency == null");
        return;
    L25:
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Map.Entry<String, PreviewHangPoint>> r8 = r3.entrySet().iterator();
    L27:
        if (r8.hasNext() == false) goto L31;
        Map.Entry<String, PreviewHangPoint> r9 = r8.next();
        String r10 = r9.getKey();
        PreviewHangPoint r11 = r9.getValue();
        if (r11 == null) goto L27;
        r7.put(r10, r11);
        goto L27
    L31:
        r2.c(r6, r7);
        return;
    L39:
        return;
    L14:
        if (r3.isEmpty() == true) goto L17;
        r4 = false;
        goto L18
    L11:
        r3 = null;
        goto L12
    }

    public void update(LKUILightTextView r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        int r0 = h6b.a.a;
        Style r1 = this.f;
        if (r1 == null) goto L5;
        FontLevel r2 = r1.getFontLevel();
    L6:
        r6.setFakeBoldText(h6b.a.a(r2));
        if (((RichTextProperty) ((q6c.e) this).e).getNumberOfLines() == 0) goto L9;
        r6.setMaxLines(((RichTextProperty) ((q6c.e) this).e).getNumberOfLines());
        r6.setEllipsize(TextUtils.TruncateAt.END);
    L10:
        Context r3 = r6.getContext();
        Style r4 = this.f;
        if (r4 == null) goto L13;
        FontLevel r5 = r4.getFontLevel();
    L14:
        r6.setTextSize((int) h6b.a.c(r3, r5));
        Context r7 = r6.getContext();
        Style r8 = this.f;
        if (r8 == null) goto L19;
        ThemeColor r9 = r8.getTextColorV2();
        if (r9 == null) goto L19;
        int r10 = com.ss.android.lark.export.entity.preview.a.a(r9, r7, null);
    L20:
        r6.setTextColor(r10);
        r6.setSpacingMulti(zz7.b.d().getMultiplier());
        r6.setSpacingExtra(UIHelper.dp2px(2.5f));
        if (this.k != null) goto L23;
    L25:
        Log.d("RichTextComponent", "cache is invalid when update textView, richtext is:" + ((RichTextProperty) ((q6c.e) this).e).getRichText() + ", view width is:" + r6.getMeasuredWidth());
        r6c.a r11 = ((q6c.a) this).a;
        if (r11 == null) goto L43;
        Context r12 = r11.getContext();
        if (r12 == null) goto L44;
        Context r13 = n(r12);
        if (r13 == null) goto L45;
        Layout r14 = l(r13, ((RichTextProperty) ((q6c.e) this).e).getRichText(), r6.getMeasuredWidth());
        if (r14 != null) goto L36;
        Log.e("RichTextComponent", "Content is empty, skip update");
        return;
    L36:
        this.k = r14;
        this.l = ((RichTextProperty) ((q6c.e) this).e).getRichText();
        r6.setContentLayout(r14);
    L38:
        if (this.g != null) goto L40;
        r6.setOnClickListener(null);
        r6.setClickable(false);
    L41:
        r6.setUrlSpanClickListener(new d(this));
        return;
    L40:
        r6.setOnClickListener(new c(this));
        goto L41
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L23:
        if (Intrinsics.areEqual(((RichTextProperty) ((q6c.e) this).e).getRichText(), this.l) == false) goto L25;
        Layout r15 = this.k;
        Intrinsics.checkNotNull(r15);
        r6.setContentLayout(r15);
    L19:
        r10 = y9c.d.c(r7, 2131106622);
        goto L20
    L13:
        r5 = null;
        goto L14
    L9:
        r6.setMaxLines(Integer.MAX_VALUE);
        r6.setEllipsize(null);
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((LKUILightTextView) r1);
    }

    public final Layout l(Context r21, RichText r22, final int r23) {
        int r2 = h6b.a.a;
        Style r3 = this.f;
        if (r3 == null) goto L5;
        FontLevel r4 = r3.getFontLevel();
    L6:
        int r10 = (int) h6b.a.c(r21, r4);
        Style r5 = this.f;
        if (r5 == null) goto L9;
        FontLevel r6 = r5.getFontLevel();
    L10:
        boolean r7 = h6b.a.a(r6);
        Style r8 = this.f;
        if (r8 == null) goto L15;
        ThemeColor r9 = r8.getTextColorV2();
        if (r9 == null) goto L15;
        int r11 = com.ss.android.lark.export.entity.preview.a.a(r9, r21, null);
    L16:
        int r12 = r11;
        Pattern r13 = com.ss.android.lark.widget.richtext.i.a;
        int r14 = 0;
        if (xbc.d.a().isFeatureGatingEnable("messener.im.refactor_richtext_moments_and_pin") == false) goto L33;
        if (r22 == null) goto L20;
        o(r22);
    L20:
        Style r15 = this.f;
        if (r15 == null) goto L23;
        FontLevel r16 = r15.getFontLevel();
    L24:
        if (r16 == null) goto L27;
        FontType r17 = r16.getType();
        if (r17 == null) goto L27;
    L28:
        if (r16 == null) goto L30;
        int r18 = r16.getLevel();
    L31:
        LarkFont r19 = h6b.a.b(r17, r18);
        ZoomLevel6 r20 = zz7.b.a;
        Intrinsics.checkNotNullParameter(r19, "larkFont");
        final float r24 = zz7.b.b(r19, zz7.b.d());
        final com.ss.android.lark.coremd.base.parse.j r25 = com.ss.android.lark.coremd.base.parse.l.a(LarkThemeExtend.m, new RichTextComponent$parseRichTextToCharSequenceV2$theme$1(r24, r23));
        p r26 = new p(this, r21);
        t9b.d r27 = t9b.d.a;
        com.ss.android.lark.coremdbiz.facade.a.C0187a r110 = com.ss.android.lark.coremdbiz.facade.a.a;
        Intrinsics.checkNotNullParameter(r27, "<this>");
        final List r28 = CollectionsKt.listOf(new com.ss.android.lark.coremd.base.parse.g[]{com.ss.android.lark.coremdbiz.facade.plugins.u.a, r26});
        final List r29 = CollectionsKt.listOf(new RegexParseListener());
        com.ss.android.lark.coremd.base.parse.b r30 = com.ss.android.lark.coremd.base.parse.c.a(LarkContextExtend.s, new RichTextComponent$parseRichTextToCharSequenceV2$parseContext$1(r23, r28, r25, r29));
        t9b.a r31 = t9b.a.a;
        com.ss.android.lark.richtextmd.parse.impl.b r32 = com.ss.android.lark.richtextmd.parse.ext.a.b(r21);
        com.ss.android.lark.richtextmd.parse.ext.a.a(r32, RichTextComponent$parseRichTextToCharSequenceV2$node$1.INSTANCE);
        v7b.s r1 = r32.b(r22);
        t9b.b r33 = t9b.b.a;
        com.ss.android.lark.coremd.impl.parse.b.a r34 = t9b.b.a(r21);
        com.ss.android.lark.coremd.ext.l.b(r34, r28);
        r34.c(r25);
        CharSequence r35 = r34.a(r1, r30);
    L32:
        CharSequence r111 = r35;
        if (r111 == null) goto L65;
        CharSequence r112 = StringsKt.trim(r111);
    L66:
        if (r7 == false) goto L68;
        Typeface r36 = h18.e.b(r21, 1);
    L69:
        Typeface r113 = r36;
        TextLayoutBuilder r37 = m(r112, r21, r10, r12, r23, r113);
        if (((RichTextProperty) ((q6c.e) this).e).getNumberOfLines() == 0) goto L121;
        r37.e(((RichTextProperty) ((q6c.e) this).e).getNumberOfLines());
        r37.d(TextUtils.TruncateAt.END);
        if ((r111 instanceof Spanned) == false) goto L121;
        if (r111.length() <= 0) goto L76;
        boolean r38 = true;
    L77:
        if (r38 == false) goto L121;
        TextLayoutBuilder r39 = r37;
        TextLayoutBuilder r40 = m(r112, r21, r10, r12, r23, r113);
        r40.e(((RichTextProperty) ((q6c.e) this).e).getNumberOfLines());
        r40.d(TextUtils.TruncateAt.END);
        Layout r41 = r40.a();
        if (r41 == null) goto L89;
        int r42 = r41.getLineCount();
        if (r42 <= 0) goto L86;
        int r43 = r42 - 1;
        int r114 = r41.getLineStart(r43);
        int r44 = r41.getLineEnd(r43) - 1;
        CharSequence r45 = r111;
        int r46 = RangesKt.coerceAtLeast(StringsKt.lastIndexOf$default(r111, '\n', r114, false, 4, null), 0);
        PrefixSpan[] r47 = (PrefixSpan[]) ((Spanned) r45).getSpans(r46, r44, PrefixSpan.class);
        Log.i("RichTextComponent", "preLayout last line(" + r46 + ',' + r44 + "),spans:" + r47.length);
        int r48 = r47.length;
        int r49 = 0;
        int r50 = 0;
    L83:
        if (r49 >= r48) goto L85;
        r50 = r50 + r47[r49].getLeadingMargin(true);
        r49 = r49 + 1;
        goto L83
    L85:
        Integer r51 = Integer.valueOf(r50);
    L87:
        if (r51 == null) goto L90;
    L113:
        if (r51 == null) goto L120;
        Log.i("RichTextComponent", "maxWidth:" + r23 + ",leftMargin:" + r51);
        int r52 = RangesKt.coerceAtLeast(r23 - r51.intValue(), 0);
        TextLayoutBuilder.a r53 = r39.c;
        if (r53.l == r52) goto L117;
        r53.l = r52;
        r39.d = null;
    L117:
        Spanned r115 = (Spanned) r45;
        CodeBlockV2Span[] r54 = (CodeBlockV2Span[]) r115.getSpans(0, r115.length(), CodeBlockV2Span.class);
        int r55 = r54.length;
    L118:
        if (r14 >= r55) goto L123;
        r54[r14].b(r52);
        r14 = r14 + 1;
    L123:
        return r39.a();
    L120:
        Log.i("RichTextComponent", "leftMargin == null");
    L90:
        Spanned r116 = (Spanned) r45;
        PrefixSpan[] r56 = (PrefixSpan[]) r116.getSpans(0, r116.length(), PrefixSpan.class);
        Log.w("RichTextComponent", "preLayout == null,span:" + r56.length);
        if (r56.length != 0) goto L93;
        boolean r57 = true;
    L95:
        if ((!r57) == true) goto L97;
        r51 = null;
        goto L113
    L97:
        if (r56.length != 0) goto L99;
        boolean r58 = true;
    L100:
        if (r58 == true) goto L111;
        Integer r59 = Integer.valueOf(r56[0].getLeadingMargin(true));
        int r60 = ArraysKt.getLastIndex(r56);
        if (1 > r60) goto L109;
        int r61 = 1;
    L104:
        Integer r117 = Integer.valueOf(r56[r61].getLeadingMargin(true));
        if (r59.compareTo(r117) >= 0) goto L107;
        r59 = r117;
    L107:
        if (r61 == r60) goto L109;
        r61 = r61 + 1;
    L109:
        r51 = r59;
        goto L113
    L111:
        throw new NoSuchElementException();
    L99:
        r58 = false;
        goto L100
    L93:
        r57 = false;
        goto L95
    L86:
        r45 = r111;
        Log.i("RichTextComponent", "preLayout line count == 0");
        r51 = null;
        goto L87
    L89:
        r45 = r111;
        goto L90
    L76:
        r38 = false;
    L121:
        r39 = r37;
        goto L123
    L68:
        r36 = h18.e.b(r21, 0);
        goto L69
    L65:
        r112 = null;
        goto L66
    L30:
        r18 = 0;
    L27:
        r17 = FontType.CAPTION;
        goto L28
    L23:
        r16 = null;
        goto L24
    L33:
        if (r22 == null) goto L35;
        o(r22);
    L35:
        Style r62 = this.f;
        if (r62 == null) goto L38;
        FontLevel r63 = r62.getFontLevel();
    L39:
        int r64 = (int) h6b.a.c(r21, r63);
        g6b.a.InterfaceC0223a r65 = g6b.a.a;
        if (r65 == null) goto L44;
        com.ss.android.lark.officesdk.integrator.im.e r66 = r65.g();
        if (r66 == null) goto L44;
        HashMap r67 = r66.a(r21, r22);
    L45:
        lec.b.a r68 = new lec.b.a();
        r68.a = true;
        r68.f = true;
        r68.q = r67;
        r68.p = CodeBlockV2ProcessParams.b.d(CodeBlockV2ProcessParams.Companion, r23, 0, 6);
        lec.e r69 = lec.d.a(r21, r22, new lec.b(r68));
        if (r69 != null) goto L48;
        r35 = null;
        goto L32
    L48:
        ArrayList r70 = new ArrayList();
        List r71 = r69.b.getAllSpanInfos();
        if (CollectionUtils.isNotEmpty(r71) == false) goto L51;
        r70.addAll(r71);
    L51:
        Pattern r72 = g0.d;
        g0 r73 = g0.a.a;
        String r74 = r69.a;
        r73.getClass();
        if (TextUtils.isEmpty(r74) == true) goto L55;
        g0.a(r70, g0.e(r74, r70));
        g0.a(r70, g0.h(r74, null, r70));
        Collections.sort(r70);
    L55:
        g6b.a.InterfaceC0223a r75 = g6b.a.a;
        if (r75 == null) goto L61;
        com.ss.android.lark.officesdk.integrator.im.d r76 = r75.getLoginDependency();
        if (r76 == null) goto L61;
        String r77 = r76.a();
        if (r77 == null) goto L61;
    L62:
        com.ss.android.lark.widget.light.e.a r78 = new com.ss.android.lark.widget.light.e.a(r21);
        r78.g = r64;
        r78.j = r64;
        r78.c = false;
        Intrinsics.checkNotNullParameter(r77, "currentUserId");
        r78.d = r77;
        r35 = com.ss.android.lark.widget.light.f.a.a.b(r21, r69.a, r70, new com.ss.android.lark.widget.light.e(r78));
    L61:
        r77 = BuildConfig.FLAVOR;
    L44:
        r67 = null;
        goto L45
    L38:
        r63 = null;
    L15:
        r11 = y9c.d.c(r21, 2131106622);
        goto L16
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static final void k(n r11, Context r12, String r13, String r14) {
        r11.getClass();
        String r7 = UriProtector.getQueryParameter(UriProtector.parse(r13), "actionID");
        boolean r0 = true;
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L21;
        r6c.a r15 = ((q6c.a) r11).a;
        if ((r15 instanceof vcb.d) == false) goto L14;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.ss.android.lark.export.dependency.UrlPreviewDependency");
        vcb.d r16 = (vcb.d) r15;
    L15:
        Map<String, UrlPreviewAction> r17 = r11.h;
        if (r17 == null) goto L18;
        UrlPreviewAction r18 = r17.get(r7);
    L19:
        com.ss.android.lark.chat.preview.actions.a.a(r18, r7, r11.i, r16, null).a(1);
    L34:
        g6b.a.InterfaceC0223a r19 = g6b.a.a;
        if (r19 == null) goto L48;
        com.ss.android.lark.officesdk.integrator.im.a r3 = r19.a();
        if (r3 == null) goto L49;
        URLPreviewParams r110 = r11.m;
        String r111 = r110.c;
        String r4 = r110.a;
        String r6 = r11.j;
        Long r112 = r110.h;
        if (r112 == null) goto L41;
        String r8 = r112.toString();
    L42:
        Long r113 = r11.m.i;
        if (r113 == null) goto L45;
        String r9 = r113.toString();
    L46:
        r3.c(r111, r4, "page_click", r6, r7, r8, r9, r11.m.e);
        return;
    L45:
        r9 = null;
        goto L46
    L41:
        r8 = null;
        goto L42
    L49:
        return;
    L48:
        return;
    L18:
        r18 = null;
        goto L19
    L14:
        r16 = new vcb.d(r12, null, r11.m);
        goto L15
    L21:
        if (r13.length() > 0) goto L24;
        r0 = false;
    L24:
        if (r0 == false) goto L34;
        g6b.a.InterfaceC0223a r114 = g6b.a.a;
        if (r114 == null) goto L34;
        com.ss.android.lark.officesdk.integrator.im.a r115 = r114.a();
        if (r115 == null) goto L34;
        r6c.a r1 = ((q6c.a) r11).a;
        if (r1 == null) goto L32;
        Context r5 = r1.getContext();
    L33:
        r115.a(r5, r13, r14);
        goto L34
    L32:
        r5 = null;
        goto L33
    L5:
        if (r7.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public n(RichTextProperty r2, Style r3, vcb.d r4, Map r5, UrlPreviewBody r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
        this.g = null;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.m = r4.d;
    }

    public static final TextLayoutBuilder m(CharSequence r1, Context r2, int r3, int r4, int r5, Typeface r6) {
        TextLayoutBuilder r0 = new TextLayoutBuilder();
        r0.h(r1);
        com.ss.android.lark.widget.light.viewstub.f.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        r0.c.s = new com.ss.android.lark.widget.light.viewstub.e(r2);
        r0.j(r3);
        r0.k(UIHelper.dp2px(2.5f));
        r0.i(r4);
        r0.f(r5);
        r0.l(zz7.b.d().getMultiplier());
        r0.m(r6);
        return r0;
    }
}
