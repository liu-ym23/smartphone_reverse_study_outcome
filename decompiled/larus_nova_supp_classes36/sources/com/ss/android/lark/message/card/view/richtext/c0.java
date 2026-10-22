package com.ss.android.lark.message.card.view.richtext;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.android.VirtualYogaLayout;
import com.facebook.yoga.android.YogaLayout;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.navigation.LKUIClearEditText;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberNonDirectionalPage$Param$Type;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.message.card.entity.CardImageShowMode;
import com.ss.android.lark.message.card.setting.MessageCardPWidthTypeConfig;
import com.ss.android.lark.message.card.utils.CardTimeFormatUtils;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiconTextView;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import com.ss.android.lark.widget.span.AtInfo;
import com.ss.android.lark.widget.span.EmojiconInfo;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c0 {
    public final float a;
    public final float b;
    public final int c;
    public final Context d;
    public final String e;
    public final String f;
    public String g;
    public final x0 h;
    public final int i;
    public final boolean j;
    public final f k;
    public Scene l;

    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ MsgCardRoundedYogaLayout b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ c0 e;

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.e.getClass();
        }

        public a(c0 r1, String r2, MsgCardRoundedYogaLayout r3, String r4, Map r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Log.d("alert cancel, actionId: " + this.a);
        }
    }

    public class c implements mcc.o {
        public final /* synthetic */ c0 a;

        public c(c0 r1) {
            this.a = r1;
        }

        public final void r(View r1, UrlInfo r2) {
            this.a.getClass();
        }

        public final boolean t(View r1, UrlInfo r2) {
            this.a.getClass();
            return true;
        }
    }

    public class d implements mcc.b {
        public final rcc.a a;
        public final /* synthetic */ c0 b;

        public final boolean c(View r1, String r2, String r3) {
            return true;
        }

        public d(c0 r1) {
            this.b = r1;
            this.a = new rcc.a();
        }

        public final void d(View r1, String r2, String r3) {
            if (this.a.a() == false) goto L5;
            return;
        L5:
            this.b.getClass();
        }
    }

    public class e implements mcc.i {
        public final /* synthetic */ c0 a;

        public final boolean o(View r1, String r2, String r3, boolean r4) {
            return false;
        }

        public e(c0 r1) {
            this.a = r1;
        }

        public final void p(View r1, String r2, String r3, boolean r4, String r5) {
            this.a.getClass();
        }
    }

    public class f implements ListenerParams.b {
        @Override // com.ss.android.lark.image.entity.ListenerParams.b
        public final void b(Object r1, Object r2, DataSource r3, boolean r4) {
        }

        public f() {
        }

        @Override // com.ss.android.lark.image.entity.ListenerParams.b
        public final void a(Exception r2) {
            jrb.d r3 = jrb.d.e;
            OPMonitor r0 = jrb.c.a(r3);
            r0.setErrorMessage(((OPMonitorCode) r3).message);
            r0.flush();
        }
    }

    public class g implements mcc.a {
        public final /* synthetic */ c0 a;

        public g(c0 r1) {
            this.a = r1;
        }

        public final void s(View r1, AbbreviationInfo r2, float r3, float r4) {
            this.a.getClass();
        }
    }

    public static /* synthetic */ class h {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichTextElement.RichTextTag.values().length];
            a = r0;
            r0[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L72:
            a[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L52:
            a[RichTextElement.RichTextTag.EMOTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L66:
            a[RichTextElement.RichTextTag.ITALIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L74:
            a[RichTextElement.RichTextTag.BOLD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L54:
            a[RichTextElement.RichTextTag.UNDERLINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L58:
            a[RichTextElement.RichTextTag.TEXT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L86:
            a[RichTextElement.RichTextTag.IMG.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            a[RichTextElement.RichTextTag.DIV.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L78:
            a[RichTextElement.RichTextTag.TEXTABLEAREA.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L82:
            a[RichTextElement.RichTextTag.FIGURE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L62:
            a[RichTextElement.RichTextTag.PARAGRAPH.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L70:
            a[RichTextElement.RichTextTag.TIME.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L50:
            a[RichTextElement.RichTextTag.BUTTON.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L56:
            a[RichTextElement.RichTextTag.LINK.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L84:
            a[RichTextElement.RichTextTag.SELECTMENU.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L46:
            a[RichTextElement.RichTextTag.OVERFLOWMENU.ordinal()] = 17;     // Catch: NoSuchFieldError -> L41
        L76:
            a[RichTextElement.RichTextTag.DATEPICKER.ordinal()] = 18;     // Catch: NoSuchFieldError -> L42
        L80:
            a[RichTextElement.RichTextTag.TIMEPICKER.ordinal()] = 19;     // Catch: NoSuchFieldError -> L43
        L60:
            a[RichTextElement.RichTextTag.DATETIMEPICKER.ordinal()] = 20;     // Catch: NoSuchFieldError -> L44
        L68:
            a[RichTextElement.RichTextTag.UNKNOWN_TAG.ordinal()] = 21;     // Catch: NoSuchFieldError -> L45
            return;
        }
    }

    public class i implements View.OnLongClickListener {
        public final /* synthetic */ c0 a;

        public i(c0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            this.a.getClass();
            return true;
        }
    }

    public interface j {
        void a(String r1);
    }

    public static class k extends LinearSmoothScroller {
        public k(Context r1) {
            super(r1);
        }

        public final float calculateSpeedPerPixel(DisplayMetrics r2) {
            return 100.0f / r2.densityDpi;
        }

        public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
            return (r3 + ((r4 - r3) / 2)) - (r1 + ((r2 - r1) / 2));
        }
    }

    public interface l {
        void a(View r1, Image r2);
    }

    public interface m {
        void a(String r1, String r2, RichTextElement.LinkProperty.Source r3);
    }

    public interface n {
        void a();
    }

    public interface o {
        void onLongClick(View r1);
    }

    public interface p {
        void a(String r1, Map<String, String> r2);
    }

    public class q implements View.OnClickListener {
        public final RichTextElement.SelectMenuProperty a;
        public final RoundedTextWithImage b;
        public CharSequence[] c;
        public final CharSequence[] d;
        public final HashMap<String, String> e;
        public final int f;
        public final /* synthetic */ c0 g;

        public class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ q a;

            public a(q r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r10, int r11) {
                krb.a.a(this.a.g.f, "interaction", "select_static");
                HashMap r7 = new HashMap();
                q r0 = this.a;
                CharSequence[] r1 = r0.c;
                if (r11 >= r1.length) goto L5;
                r7.put("selected_option", r0.e.get(r1[r11]));
                q r2 = this.a;
                c0 r3 = r2.g;
                RichTextElement.ConfirmProperty r4 = r2.a.getConfirm();
                q r5 = this.a;
                r3.d(r4, r5.b, r5.a.getActionId(), r7, this.a.c[r11].toString());
            L6:
                if (r10 == null) goto L9;
                r10.dismiss();
                return;
            L9:
                return;
            L5:
                Log.w("RichTextRender", "SelectMenuListener select is out of array selected:" + r11);
                goto L6
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r16) {
            List r0 = this.a.getOptions();
            if (CollectionUtils.isEmpty(r0) == true) goto L5;
        L7:
            int r3 = 0;
            if (this.a.getType() != RichTextElement.SelectMenuProperty.Type.PERSON) goto L18;
            if (CollectionUtils.isEmpty(r0) == false) goto L12;
            com.ss.android.lark.message.card.b.a().pickGroupMember((Activity) r16.getContext(), this.g.e, new ArrayList(), true, null, new RichTextRender$SelectMenuListener$2(this));
            return;
        L12:
            ArrayList r2 = new ArrayList();
        L14:
            if (r3 >= r0.size()) goto L16;
            r2.add(((RichTextElement.MenuOption) ListProtector.get(r0, r3)).getValue());
            r3 = r3 + 1;
            goto L14
        L16:
            com.ss.android.lark.message.card.b.a().pickTargetMember((Activity) r16.getContext(), r2, new ArrayList(), true, null, new RichTextRender$SelectMenuListener$1(this));
            return;
        L18:
            if (r0.size() >= 8) goto L20;
            RichTextRenderAdapter r1 = new RichTextRenderAdapter(this.g.d, 2131564132, this.f);
            new UDActionPanelBuilder(this.g.d).items(Arrays.asList(this.c)).itemClickListener(new r0(this)).adapter(r1).addActionButton(2131391775, 2131891960, null).show();
            return;
        L20:
            RichTextElement.SelectMenuProperty r5 = this.a;
            com.larksuite.component.ui.dialog.i r4 = new com.larksuite.component.ui.dialog.i(r16.getContext());
            r4.n(this.c);
            ((com.larksuite.component.ui.dialog.b) r4).f = new a(this);
            View r6 = LayoutInflater.from(this.g.d).inflate(2131559261, null);
            View r7 = LayoutInflater.from(this.g.d).inflate(2131559937, null);
            RichTextRenderAdapter r8 = new RichTextRenderAdapter(this.g.d, 2131564131, this.f);
            r4.m(2131564131);
            ((com.larksuite.component.ui.dialog.d) r4).c.width(1.0f);
            r4.f(1.0f);
            r4.k(this.g.d.getString(2131891984));
            ((com.larksuite.component.ui.dialog.d) r4).c.titleSize(17);
            ((com.larksuite.component.ui.dialog.d) r4).c.titleBold(true);
            ((com.larksuite.component.ui.dialog.d) r4).c.marginInDp(0);
            ((com.larksuite.component.ui.dialog.d) r4).c.titleColor(2131106622);
            ((com.larksuite.component.ui.dialog.d) r4).c.titlePadding(0, 0, 0, 0);
            ((com.larksuite.component.ui.dialog.d) r4).c.headerLayout(r6);
            ((com.larksuite.component.ui.dialog.d) r4).c.contentLayout(r7);
            ((com.larksuite.component.ui.dialog.d) r4).c.rootLayoutRes(2131564286);
            r4.g(new s0(this));
            ((com.larksuite.component.ui.dialog.b) r4).g.adapter(r8);
            LKUIDialog r9 = r4.i();
            RecyclerView r10 = r7.findViewById(com.larksuite.component.ui.dialog.d.e.get(2131378559));
            Context r11 = this.g.d;
            int r12 = this.f;
            CharSequence[] r13 = this.c;
            if (r13 != null) goto L23;
            int r14 = 0;
        L25:
            if (r12 <= (-1)) goto L29;
            if (r14 <= r12) goto L29;
            if (r10 == null) goto L29;
            k r15 = new k(r11);
            r15.setTargetPosition(r12);
            r10.getLayoutManager().startSmoothScroll(r15);
        L29:
            LKUISearchView r17 = r6.findViewById(2131385804);
            r6.findViewById(2131385803).setOnClickListener(new t0(r17, r9));
            LinearLayout r18 = (LinearLayout) r7.findViewById(2131378676);
            TextView r19 = (TextView) r7.findViewById(2131390562);
            r17.setCancelEnabled(false);
            u0 r110 = new u0(this, r10, r18, r8, r5, r19);
            LKUIClearEditText r20 = r17.w;
            if (r20 == null) goto L37;
            r20.addTextChangedListener(r110);
            return;
        L37:
            return;
        L23:
            r14 = r13.length;
            goto L25
        L5:
            if (this.a.getType() == RichTextElement.SelectMenuProperty.Type.PERSON) goto L7;
        }

        public static List a(q r4, CharSequence[] r5) {
            r4.getClass();
            ArrayList r6 = new ArrayList();
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r6.add(new UDBaseListDialogBuilder.ListItemBuilder(r5[r1]).build());
            r1 = r1 + 1;
            goto L3
        L5:
            return r6;
        }

        public q(c0 r1, RichTextElement.SelectMenuProperty r2, RoundedTextWithImage r3, String[] r4, HashMap<String, String> r5, int r6) {
            this.g = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public interface r {
        void a(View r1, String r2);

        void b(View r1, String r2);
    }

    public static String p(RichTextElement.TimeProperty r5) {
        SimpleDateFormat r2 = new SimpleDateFormat(r5.getFormat().replace('d', 'E').replace('D', 'd').replaceAll("GMT", "z"), com.ss.android.lark.message.card.b.a().getLanguageSetting());
        r2.setTimeZone(TimeZone.getDefault());
        return r2.format(new Date(r5.getMillisecondSince1970()));
    }

    public final void t(LKUILightTextView r2) {
        r2.setUrlSpanClickListener(new c(this));
        r2.setAtSpanClickListener(new d(this));
        r2.setMentionSpanClickListener(new e(this));
        r2.setAbbreviationClickListener(new g(this));
    }

    public static void a(View r5, YogaProperty r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if ((r5 instanceof YogaLayout) == true) goto L8;
        int r0 = (int) r6.paddingLeft;
        int r1 = (int) r6.paddingTop;
        int r2 = (int) r6.paddingRight;
        int r3 = (int) r6.paddingBottom;
        r6.paddingLeft = 0.0f;
        r6.paddingTop = 0.0f;
        r6.paddingRight = 0.0f;
        r6.paddingBottom = 0.0f;
        r5.setPadding(r0, r1, r2, r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(NodeParams r1, MsgCardLinkEmojiTextView r2) {
        if (r1 == null) goto L9;
        Map<String, String> r3 = r1.mExtraProperties;
        if (r3 == null) goto L10;
        String r4 = r3.get("textAlign");
        if (TextUtils.isEmpty(r4) == true) goto L11;
        r2.setGravity(com.ss.android.lark.message.card.view.richtext.b.k(r4));
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void c(NodeParams r1, LKUILightTextView r2) {
        if (r1 == null) goto L9;
        Map<String, String> r3 = r1.mExtraProperties;
        if (r3 == null) goto L10;
        String r4 = r3.get("textAlign");
        if (TextUtils.isEmpty(r4) == true) goto L11;
        r2.setGravity(com.ss.android.lark.message.card.view.richtext.b.k(r4));
        return;
    L11:
        return;
    L10:
        return;
    }

    public static String m(RichTextElement.TimeProperty r6, String r7) {
        if (TextUtils.isEmpty(r6.getFormat_type()) == false) goto L7;
        Log.w("RichTextRender", "getNewTimeComponent format type is null");
        return "";
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L15;
        Lazy r0 = CardTimeFormatUtils.a;
        String r1 = CardTimeFormatUtils.c(r6.getFormat_type(), r7, true);
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return "";
    L12:
        if (r7.equals("zh-Hant") == false) goto L14;
        Locale r8 = Locale.TAIWAN;
    L23:
        SimpleDateFormat r3 = new SimpleDateFormat(r1, r8);     // Catch: Exception -> L20
        r3.setTimeZone(TimeZone.getDefault());     // Catch: Exception -> L20
        return r3.format(new Date(r6.getMillisecondSince1970()));
    L20:
        e = move-exception;
        Log.e("RichTextRender", "format time exception", e);
        return "";
    L14:
        r8 = new Locale(r7);
        goto L23
    L15:
        r8 = com.ss.android.lark.message.card.b.a().getLanguageSetting();
        Lazy r2 = CardTimeFormatUtils.a;
        r1 = CardTimeFormatUtils.a(r6.getFormat_type(), r8, true);
        if (TextUtils.isEmpty(r1) == false) goto L23;
        return "";
    }

    public static boolean u(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        if (r2 == true) goto L6;
        boolean r3 = false;
    L7:
        if (r3 == true) goto L9;
        jrb.d r4 = jrb.d.h;
        OPMonitor r0 = jrb.c.a(r4);
        r0.setErrorMessage(((OPMonitorCode) r4).message);
        r0.flush();
    L9:
        return r3;
    L6:
        r3 = true;
        goto L7
    }

    public final void j(v0 r42, NodeParams r43) {
        LKUILightTextView r10 = new LKUILightTextView(this.d);
        r42.a(r10);
        YogaNode r1 = r42.b(r10);
        a(r10, r43.mYogaProperty);
        r1.copyStyle(w0.a(r43.mYogaProperty));
        r10.setSpacingExtra(this.a);
        c(r43, r10);
        RichTextElement.RichTextTag r2 = r43.mRichTextTag;
        RichTextElement.RichTextTag r3 = RichTextElement.RichTextTag.TEXT;
        if (r2 != r3) goto L13;
        RichTextElement.TextProperty r4 = r43.mRichTextProperty;
        if (r4.getNumberOfLines() <= 0) goto L10;
        r10.setMaxLines(r4.getNumberOfLines());
        if (r4.getNumberOfLines() != 1) goto L12;
        r10.setSingleLine(true);
    L12:
        r10.setEllipsize(TextUtils.TruncateAt.END);
        goto L13
    L10:
        if (r43.mParents.mRichTextTag != RichTextElement.RichTextTag.BUTTON) goto L12;
        r10.setSingleLine(true);
    L13:
        t(r10);
        float r5 = r43.mTextSize;
        float r11 = 14.0f;
        if (r5 <= 0.0f) goto L16;
        r10.setTextSize(UIUtils.dp2px(this.d, r5));
    L17:
        CharSequence r6 = r43.mSpannableString;
        if (r6 != null) goto L20;
        Log.w("RichTextRender", "textview: no preParsed string");
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        ArrayList r9 = new ArrayList();
        ArrayList r12 = new ArrayList();
        StringBuilder r40 = new StringBuilder();
        o(this.d, r7, r8, r9, r12, r40, r43, null);
        new ArrayList();
        new ArrayList();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        new ArrayList();
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        new ArrayList();
        List r20 = new RecogniseSpansResult(r8, r7, r13, r14, r9, r15, r16, r17, r18, r19, r12, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()).getAllSpanInfos();
        com.ss.android.lark.widget.light.e.a r21 = new com.ss.android.lark.widget.light.e.a(this.d);
        Context r22 = this.d;
        float r23 = r43.mTextSize;
        if (r23 <= 0.0f) goto L31;
        r11 = r23;
    L31:
        r21.g = UIUtils.dp2px(r22, r11);
        r21.a(com.ss.android.lark.message.card.b.a().getLoginUserId());
        r21.c = false;
        r21.u = UIHelper.getColor(2131103404);
        r21.t = UIHelper.getColor(2131103449);
        com.ss.android.lark.widget.light.e r24 = new com.ss.android.lark.widget.light.e(r21);
        r10.setContentText(com.ss.android.lark.widget.light.f.a.a.b(this.d, r40.toString(), r20, r24));
        return;
    L20:
        if (r43.mRichTextTag != r3) goto L27;
        RichTextElement.TextProperty r25 = r43.mRichTextProperty;
        if (TextUtils.isEmpty(r6) == false) goto L24;
    L25:
        r10.setContentText(" ");
        return;
    L24:
        if (TextUtils.isEmpty(r25.getContent()) == true) goto L25;
    L27:
        r10.setContentText(r43.mSpannableString);
        return;
    L16:
        r10.setTextSize(UIUtils.dp2px(this.d, 14.0f));
        goto L17
    }

    public static String l(String r7, long r8, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        Locale r11 = com.ss.android.lark.message.card.b.a().getLanguageSetting();
        if ("date_and_time".equals(r7) == false) goto L18;
        String r9 = CardTimeFormatUtils.a("date", r11, false) + " " + CardTimeFormatUtils.a("time", r11, false);
    L20:
        if (TextUtils.isEmpty(r9) == false) goto L27;
        return "";
    L27:
        SimpleDateFormat r0 = new SimpleDateFormat(r9, r11);     // Catch: Exception -> L24
        r0.setTimeZone(TimeZone.getDefault());     // Catch: Exception -> L24
        return r0.format(new Date(r8));
    L24:
        e = move-exception;
        Log.e("RichTextRender", "format date_pick exception formatString:" + r9, e);
        return "";
    L18:
        r9 = CardTimeFormatUtils.a(r7, r11, false);
        goto L20
    L5:
        if ("date_and_time".equals(r7) == false) goto L7;
        r9 = CardTimeFormatUtils.c("date", r10, false) + " " + CardTimeFormatUtils.c("time", r10, false);
    L9:
        if (TextUtils.isEmpty(r9) == false) goto L12;
        return "";
    L12:
        if (r10.equals("zh-Hant") == false) goto L14;
        r11 = Locale.TAIWAN;
        goto L27
    L14:
        r11 = new Locale(r10);
        goto L27
    L7:
        r9 = CardTimeFormatUtils.c(r7, r10, false);
        goto L9
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.ViewGroup, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedYogaLayout, com.ss.android.lark.message.card.view.richtext.RoundedTextWithImage] */
    public final void f(v0 r8, NodeParams r9, com.ss.android.lark.message.card.view.i r10) {
        final ?? r11 = n(r8, r9, Boolean.TRUE);
        final RichTextElement.DateTimePickerProperty r5 = r9.mRichTextProperty;
        if (r5.isLoading() == false) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (com.larksuite.framework.utils.f0.a(r5.getInitialDateTime()) == true) goto L15;
        String r0 = r5.getInitialDateTime();
        final long r3 = com.ss.android.lark.message.card.view.richtext.b.l(r5.getInitialDateTime(), "yyyy-MM-dd HH:mm");
        if (r3 == (-1)) goto L14;
        r0 = l("date_and_time", r3, null);
    L14:
        r11.e(r0, Boolean.valueOf(r12));
    L17:
        if (r5.isDisable() == false) goto L19;
        int r13 = UDColorUtils.getColor(this.d, 2131102416);
    L20:
        r11.setImageDrawable(UDIconUtils.getIconDrawable(this.d, 2131253990, r13));
        int r14 = this.h.f(this.d, 16);
        Log.i("RichTextRender", "date time picker zoomImageSize:" + r14);
        r11.setImgWidth(r14);
        r11.setImgHeight(r14);
        if (r5.isLoading() == false) goto L23;
        r11.c();
    L23:
        r10.getClass();
        r11.setEnabled(u(r5.isDisable(), false));
        Log.i("RichTextRender", "isForward:false property disable is :" + r5.isDisable());
        r11.setOnClickListener(new s(this, r3, r5, r11));
        r11.setOnLongClickListener(new i(this));
        return;
    L19:
        r13 = UDColorUtils.getColor(this.d, 2131102419);
        goto L20
    L15:
        r11.d(r5.getPlaceHolder(), Boolean.valueOf(r12));
        r3 = -1;
        goto L17
    L5:
        if (r5.isDisable() == true) goto L8;
        r12 = false;
        goto L10
    }

    public final void h(v0 r38, List<NodeParams> r39, NodeParams r40) {
        LKUILightTextView r3 = new LKUILightTextView(this.d);
        r38.a(r3);
        YogaNode r1 = r38.b(r3);
        a(r3, r40.mYogaProperty);
        r1.copyStyle(w0.a(r40.mYogaProperty));
        int r2 = r40.mBgColor;
        if (r2 == 0) goto L5;
        r3.setBackgroundColor(r2);
    L5:
        int r4 = r40.mTextColor;
        if (r4 == 0) goto L8;
        r3.setTextColor(r4);
    L8:
        c(r40, r3);
        RichTextElement.TextableAreaProperty r5 = r40.mRichTextProperty;
        if (r5.getNumberOfLines() <= 0) goto L14;
        r3.setMaxLines(r5.getNumberOfLines());
        if (r5.getNumberOfLines() != 1) goto L16;
        r3.setSingleLine(true);
    L16:
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r3.setTypeface(Typeface.create(r3.getTypeface(), r40.mFontStyleAndWeight));
        float r6 = r40.mTextSize;
        float r7 = 14.0f;
        if (r6 <= 0.0f) goto L19;
        r3.setTextSize(UIUtils.dp2px(this.d, r6));
    L20:
        r3.setSpacingExtra(this.a);
        t(r3);
        CharSequence r8 = r40.mSpannableString;
        if (r8 == null) goto L28;
        if (TextUtils.isEmpty(r8) == false) goto L26;
        r3.setContentText(" ");
        return;
    L26:
        r3.setContentText(r40.mSpannableString);
        return;
    L28:
        if (CollectionUtils.isNotEmpty(r39) == false) goto L40;
        Log.w("RichTextRender", "textarea: no preParsed string");
        List<NodeParams> r9 = r40.mChildParams;
        ArrayList r17 = new ArrayList();
        ArrayList r33 = new ArrayList();
        ArrayList r34 = new ArrayList();
        ArrayList r35 = new ArrayList();
        StringBuilder r36 = new StringBuilder();
        Iterator<NodeParams> r10 = r9.iterator();
    L31:
        if (r10.hasNext() == false) goto L33;
        NodeParams r12 = r10.next();
        o(this.d, r17, r33, r34, r35, r36, r12, null);
        goto L31
    L33:
        new ArrayList();
        new ArrayList();
        ArrayList r11 = new ArrayList();
        ArrayList r13 = new ArrayList();
        new ArrayList();
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        new ArrayList();
        List r20 = new RecogniseSpansResult(r33, r17, r11, r13, r34, r14, r15, r16, r18, r19, r35, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()).getAllSpanInfos();
        com.ss.android.lark.widget.light.e.a r21 = new com.ss.android.lark.widget.light.e.a(this.d);
        Context r22 = this.d;
        float r23 = r40.mTextSize;
        if (r23 <= 0.0f) goto L36;
        r7 = r23;
    L36:
        r21.g = UIUtils.dp2px(r22, r7);
        r21.a(com.ss.android.lark.message.card.b.a().getLoginUserId());
        r21.c = false;
        r21.u = UIHelper.getColor(2131103404);
        r21.t = UIHelper.getColor(2131103449);
        com.ss.android.lark.widget.light.e r24 = new com.ss.android.lark.widget.light.e(r21);
        r3.setContentText(com.ss.android.lark.widget.light.f.a.a.b(this.d, r36.toString(), r20, r24));
        return;
    L40:
        return;
    L19:
        r3.setTextSize(UIUtils.dp2px(this.d, 14.0f));
        goto L20
    L14:
        if (r40.mParents.mRichTextTag != RichTextElement.RichTextTag.BUTTON) goto L16;
        r3.setSingleLine(true);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.view.View, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedYogaLayout, com.ss.android.lark.message.card.view.richtext.RoundedTextWithImage] */
    public final RoundedTextWithImage n(v0 r11, NodeParams r12, Boolean r13) {
        Context r0 = this.d;
        r13.booleanValue();
        ?? r14 = new RoundedTextWithImage(r0, null);
        r14.setZoomRule(this.h);
        RichTextElement.RichTextTag r1 = r12.mRichTextTag;
        RichTextElement.RichTextTag r2 = RichTextElement.RichTextTag.OVERFLOWMENU;
        if (r1 != r2) goto L5;
        r12.mYogaProperty.paddingRight = UIUtils.dp2px(this.d, 10.0f);
        r12.mYogaProperty.paddingLeft = UIUtils.dp2px(this.d, 10.0f);
    L6:
        r11.a(r14);
        MsgCardRoundedYogaLayout.a r3 = new MsgCardRoundedYogaLayout.a();
        r3.e = Integer.valueOf(UIUtils.dp2px(this.d, 1.0f));
        r3.f = Float.valueOf(UIUtils.dp2px(this.d, 6.0f));
        Map<String, String> r4 = r12.mExtraProperties;
        if (r4 != null) goto L9;
    L31:
        YogaNode r15 = r11.b(r14);
        a(r14, r12.mYogaProperty);
        YogaNode r5 = w0.a(r12.mYogaProperty);
        if (r12.mRichTextTag != r2) goto L34;
        r5.setHeight(UIUtils.dp2px(this.d, 36.0f));
    L34:
        this.h.b(this.d, r5, r12);
        r15.copyStyle(r5);
        return r14;
    L9:
        if (r4.isEmpty() == true) goto L31;
        if (r4.get("backgroundColor") == null) goto L14;
        r3.a = Integer.valueOf(com.ss.android.lark.message.card.view.richtext.b.e(r4, "backgroundColor"));
    L14:
        if (r4.get("backgroundColorDisable") == null) goto L17;
        r3.c = Integer.valueOf(com.ss.android.lark.message.card.view.richtext.b.e(r4, "backgroundColorDisable"));
    L17:
        if (r4.get("backgroundColorActive") == null) goto L20;
        r3.b = Integer.valueOf(com.ss.android.lark.message.card.view.richtext.b.e(r4, "backgroundColorActive"));
    L20:
        if (r4.get("borderColor") == null) goto L30;
        int r6 = com.ss.android.lark.message.card.view.richtext.b.e(r4, "borderColor");
        Log.d("RichTextRender", "rounded layout border styles=" + r4 + " color=" + String.format("#%08X", new Object[]{Integer.valueOf(r6 & (-1))}));
        r3.d = Integer.valueOf(r6);
        RichTextElement.ButtonProperty r7 = r12.mRichTextProperty;
        if ((r7 instanceof RichTextElement.ButtonProperty) == false) goto L30;
        RichTextElement.ButtonProperty r8 = r7;
        if (r8.isShowLoadingIcon() == true) goto L28;
        if (r8.isDisable() == false) goto L30;
    L28:
        if (RichTextStyle.ButtonMode.MODE_DEFAULT.getMode().equals(r8.getMode()) == true) goto L30;
        int r9 = Color.argb(153, Color.red(r6), Color.green(r6), Color.blue(r6));
        r3.d = Integer.valueOf(r9);
        Log.d("RichTextRender", "rounded layout border dark color=" + String.format("#%08X", new Object[]{Integer.valueOf(r9 & (-1))}));
    L30:
        r14.setCustomizations(r3);
        goto L31
    L5:
        r12.mYogaProperty.paddingLeft = UIUtils.dp2px(this.d, 12.0f);
        goto L6
    }

    public final int x(YogaLayout r3, NodeParams r4, com.ss.android.lark.message.card.view.i r5) {
        if (r4 == null) goto L13;
        List<NodeParams> r6 = r4.mChildParams;
        if (CollectionUtils.isEmpty(r6) == false) goto L7;
        return 2;
    L7:
        v0 r0 = new v0(this.d);
        Intrinsics.checkNotNullParameter(r3, "yogaLayout");
        r0.b = r3;
        Iterator<NodeParams> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        w(r0, r7.next(), r5, null);
        goto L9
    L11:
        return 0;
    L13:
        return 1;
    }

    public c0(Context r2, String r3, String r4, int r5) {
        this.g = null;
        this.l = Scene.Chat;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.i = r5;
        this.a = UIUtils.dp2px(r2, 4.0f);
        this.c = UIUtils.getColor(r2, 2131103463);
        Resources r6 = r2.getResources();
        this.b = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density;
        this.h = new x0(r5);
        this.k = new f();
        Log.i("RichTextRender", "is use new set style fg:true");
        this.j = com.ss.android.lark.message.card.b.a().getFgValue("messagecard.surpportcopy.enable", false);
    }

    public static TextStyleInfo k(Context r6, StringBuilder r7, NodeParams r8, RichTextElement.TextProperty r9) {
        TextStyleInfo r0 = new TextStyleInfo();
        ((SpanInfo) r0).type = 4;
        int r10 = r7.toString().length();
        ((SpanInfo) r0).start = r10;
        ((SpanInfo) r0).end = r10 + r9.getContent().length();
        ((SpanInfo) r0).text = r9.getContent();
        int r11 = r8.mTextColor;
        if (r11 == 0) goto L5;
        r0.textColor = r11;
    L9:
        r0.textBgColor = r8.mBgColor;
        NodeParams r12 = r8.mParents;
        if (r12 == null) goto L22;
        RichTextElement.ButtonProperty r13 = r12.mRichTextProperty;
        if ((r13 instanceof RichTextElement.ButtonProperty) == false) goto L22;
        RichTextElement.ButtonProperty r14 = r13;
        if (r14.isDisable() == false) goto L16;
    L17:
        int r2 = Color.red(r0.textColor);
        int r3 = Color.green(r0.textColor);
        int r4 = Color.blue(r0.textColor);
        if (RichTextStyle.ButtonMode.MODE_DEFAULT.getMode().equals(r14.getMode()) == false) goto L20;
        r0.textColor = Color.argb(82, r2, r3, r4);
    L21:
        r0.textSize = (int) UIUtils.sp2px(r6, 16.0f);
    L35:
        Map<String, String> r15 = r8.mExtraProperties;
        if (r15 == null) goto L65;
        String r16 = r15.get("textDecoration");
        if (TextUtils.isEmpty(r16) == true) goto L65;
        r16.getClass();
        int r17 = r16.hashCode();
        if (r17 == (-1608317383)) goto L55;
        if (r17 == (-1027917076)) goto L51;
        if (r17 == (-950577103)) goto L47;
    L56:
        byte r18 = -1;
    L58:
        if (r18 == 0) goto L64;
        if (r18 == 1) goto L63;
        if (r18 != 2) goto L65;
        r0.isStrikeThruText = true;
        goto L65
    L63:
        r0.isUnderlineText = true;
        goto L65
    L64:
        r0.isStrikeThruText = true;
        r0.isUnderlineText = true;
        goto L65
    L47:
        if (r16.equals("lineThrough") == false) goto L56;
        r18 = 2;
        goto L58
    L51:
        if (r16.equals("underLine") == false) goto L56;
        r18 = 1;
        goto L58
    L55:
        if (r16.equals("underLineThrough") == false) goto L56;
        r18 = 0;
    L65:
        return r0;
    L20:
        r0.textColor = Color.argb(153, r2, r3, r4);
        goto L21
    L16:
        if (r14.isShowLoadingIcon() == false) goto L21;
    L22:
        float r19 = r8.mTextSize;
        if (r19 <= 0.0f) goto L25;
        r0.textSize = (int) UIUtils.sp2px(r6, r19);
    L26:
        int r20 = r8.mFontStyleAndWeight;
        if (r20 == 1) goto L34;
        if (r20 != 2) goto L30;
        r0.isItalic = true;
        goto L35
    L30:
        if (r20 != 3) goto L35;
        r0.isItalic = true;
        r0.isBold = true;
        goto L35
    L34:
        r0.isBold = true;
        goto L35
    L25:
        r0.textSize = (int) UIUtils.sp2px(r6, 14.0f);
        goto L26
    L5:
        if (r8.cardVersion != 1) goto L7;
        r0.textColor = UIUtils.getColor(r6, 2131103451);
        goto L9
    L7:
        r0.textColor = UIUtils.getColor(r6, 2131108998);
        goto L9
    }

    public static TextStyleInfo q(Context r6, StringBuilder r7, NodeParams r8, String r9) {
        TextStyleInfo r0 = new TextStyleInfo();
        ((SpanInfo) r0).type = 4;
        int r10 = r7.toString().length();
        ((SpanInfo) r0).start = r10;
        ((SpanInfo) r0).end = r10 + r9.length();
        ((SpanInfo) r0).text = r9;
        int r11 = r8.mTextColor;
        if (r11 == 0) goto L5;
        r0.textColor = r11;
    L9:
        r0.textBgColor = r8.mBgColor;
        NodeParams r12 = r8.mParents;
        if (r12 == null) goto L22;
        RichTextElement.ButtonProperty r13 = r12.mRichTextProperty;
        if ((r13 instanceof RichTextElement.ButtonProperty) == false) goto L22;
        RichTextElement.ButtonProperty r14 = r13;
        if (r14.isDisable() == false) goto L16;
    L17:
        int r2 = Color.red(r0.textColor);
        int r3 = Color.green(r0.textColor);
        int r4 = Color.blue(r0.textColor);
        if (RichTextStyle.ButtonMode.MODE_DEFAULT.getMode().equals(r14.getMode()) == false) goto L20;
        r0.textColor = Color.argb(82, r2, r3, r4);
    L21:
        r0.textSize = (int) UIUtils.sp2px(r6, 16.0f);
    L35:
        Map<String, String> r15 = r8.mExtraProperties;
        if (r15 == null) goto L65;
        String r16 = r15.get("textDecoration");
        if (TextUtils.isEmpty(r16) == true) goto L65;
        r16.getClass();
        int r17 = r16.hashCode();
        if (r17 == (-1608317383)) goto L55;
        if (r17 == (-1027917076)) goto L51;
        if (r17 == (-950577103)) goto L47;
    L56:
        byte r18 = -1;
    L58:
        if (r18 == 0) goto L64;
        if (r18 == 1) goto L63;
        if (r18 != 2) goto L65;
        r0.isStrikeThruText = true;
        goto L65
    L63:
        r0.isUnderlineText = true;
        goto L65
    L64:
        r0.isStrikeThruText = true;
        r0.isUnderlineText = true;
        goto L65
    L47:
        if (r16.equals("lineThrough") == false) goto L56;
        r18 = 2;
        goto L58
    L51:
        if (r16.equals("underLine") == false) goto L56;
        r18 = 1;
        goto L58
    L55:
        if (r16.equals("underLineThrough") == false) goto L56;
        r18 = 0;
    L65:
        return r0;
    L20:
        r0.textColor = Color.argb(153, r2, r3, r4);
        goto L21
    L16:
        if (r14.isShowLoadingIcon() == false) goto L21;
    L22:
        float r19 = r8.mTextSize;
        if (r19 <= 0.0f) goto L25;
        r0.textSize = (int) UIUtils.sp2px(r6, r19);
    L26:
        int r20 = r8.mFontStyleAndWeight;
        if (r20 == 1) goto L34;
        if (r20 != 2) goto L30;
        r0.isItalic = true;
        goto L35
    L30:
        if (r20 != 3) goto L35;
        r0.isItalic = true;
        r0.isBold = true;
        goto L35
    L34:
        r0.isBold = true;
        goto L35
    L25:
        r0.textSize = (int) UIUtils.sp2px(r6, 14.0f);
        goto L26
    L5:
        if (r8.cardVersion != 1) goto L7;
        r0.textColor = UIUtils.getColor(r6, 2131103451);
        goto L9
    L7:
        r0.textColor = UIUtils.getColor(r6, 2131108998);
        goto L9
    }

    public final void i(v0 r40, NodeParams r41, com.ss.android.lark.message.card.view.i r42, RichTextElement.LinkProperty r43) {
        dwa.j r2 = dwa.j.d(this.d);
        String r3 = MsgCardLinkEmojiTextView.class.getName();
        r2.getClass();
        dwa.b.c(r3);
        EmojiconTextView r10 = new MsgCardLinkEmojiTextView(this.d);
        if (this.g != null) goto L5;
        this.g = com.ss.android.lark.message.card.b.a().getLoginUserId();
    L5:
        boolean r4 = false;
        r10.setTranslateEmojiCode(false);
        r10.setCurrentUserId(this.g);
        r40.a(r10);
        YogaNode r1 = r40.b(r10);
        a(r10, r41.mYogaProperty);
        r1.copyStyle(w0.a(r41.mYogaProperty));
        r10.setLineSpacing(this.a, 1.0f);
        b(r41, r10);
        if (r41.mRichTextTag != RichTextElement.RichTextTag.TEXT) goto L24;
        RichTextElement.TextProperty r5 = r41.mRichTextProperty;
        if (r41.mParents.mRichTextTag != RichTextElement.RichTextTag.BUTTON) goto L11;
        r4 = true;
    L11:
        if (r5.getNumberOfLines() <= 0) goto L15;
        r10.setMaxLines(r5.getNumberOfLines());
        if (r5.getNumberOfLines() != 1) goto L17;
        r10.setSingleLine();
    L17:
        r10.setEllipsize(TextUtils.TruncateAt.END);
        if (r4 == false) goto L24;
        RichTextElement.ButtonProperty r6 = r41.mParents.mRichTextProperty;
        if ((r6 instanceof RichTextElement.ButtonProperty) == false) goto L24;
        if (InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK.equals(r6.getMode()) == true) goto L24;
        r1.setHeight(UIUtils.dp2px(this.d, 22.0f));
        goto L24
    L15:
        if (r4 == false) goto L17;
        r10.setSingleLine();
    L24:
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        ArrayList r9 = new ArrayList();
        ArrayList r11 = new ArrayList();
        StringBuilder r38 = new StringBuilder();
        o(this.d, r7, r8, r9, r11, r38, r41, null);
        new ArrayList();
        new ArrayList();
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        new ArrayList();
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        new ArrayList();
        RecogniseSpansResult r19 = new RecogniseSpansResult(r8, r7, r12, r13, r9, r14, r15, r16, r17, r18, r11, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        s(r10, r41.mParents.mRichTextProperty, r42, r43);
        r10.G(r38.toString(), r19);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(MsgCardLinkEmojiTextView r3, RichTextElement.RichTextProperty r4, com.ss.android.lark.message.card.view.i r5, RichTextElement.LinkProperty r6) {
        if (this.j == false) goto L10;
        r3.setOnLongClickListener(new d0(this));
        if ((r4 instanceof RichTextElement.ButtonProperty) == false) goto L7;
        final RichTextElement.ButtonProperty r7 = (RichTextElement.ButtonProperty) r4;
        r5.getClass();
        Log.i("RichTextRender", "isForward:false property disable is :" + r7.isDisable());
        r5.a(r7.getActionId());
        r3.setOnClickListener(new u(this, r7));
        goto L10
    L7:
        if (r6 == null) goto L9;
        r3.setOnClickListener(new e0(this, r6));
        goto L10
    L9:
        r5.getClass();
    L10:
        r3.setUrlStringClickListner(new f0(this));
        r3.setAtStringClickListner(new g0(this));
        r3.setAbbreviationClickListener(new h0(this));
        r3.setMentionSpanClickListener(new i0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.view.View, android.widget.ImageView, com.larksuite.component.ui.imageview.LKUIRoundedImageView2, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedImageView] */
    /* JADX WARN: Type inference failed for: r10v9, types: [android.view.ViewGroup, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedYogaLayout, com.ss.android.lark.message.card.view.richtext.RoundedTextWithImage] */
    /* JADX WARN: Type inference failed for: r13v26, types: [android.view.ViewGroup, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedYogaLayout, com.ss.android.lark.message.card.view.richtext.RoundedTextWithImage] */
    /* JADX WARN: Type inference failed for: r2v54, types: [android.view.ViewGroup, com.facebook.yoga.android.YogaLayout, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedYogaLayout, com.ss.android.lark.message.card.view.richtext.RoundedTextWithImage] */
    /* JADX WARN: Type inference failed for: r4v39, types: [android.view.View, android.view.ViewGroup, com.facebook.yoga.android.YogaLayout, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedYogaLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.ss.android.lark.message.card.view.richtext.q, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v63, types: [android.view.ViewGroup, com.ss.android.lark.message.card.view.richtext.MsgCardRoundedYogaLayout, com.ss.android.lark.message.card.view.richtext.RoundedTextWithImage] */
    public final void w(v0 r37, NodeParams r38, com.ss.android.lark.message.card.view.i r39, RichTextElement.LinkProperty r40) {
        if (r38 != null) goto L5;
    L366:
        OPMonitor r1 = jrb.c.a(jrb.d.a).addTag("RichTextRender");
        if (r38 != null) goto L369;
        r1.setErrorMessage("node params is null");
    L370:
        r1.flush();
        return;
    L369:
        r1.setErrorMessage("rich text tag is null");
        goto L370
    L5:
        if (r38.mRichTextTag == null) goto L366;
        boolean r3 = com.ss.android.lark.message.card.b.a().getFgValue("lark.card.message.lightview");
        switch(h.a[r38.mRichTextTag.ordinal()]) {
            case 1: goto L362;
            case 2: goto L362;
            case 3: goto L362;
            case 4: goto L362;
            case 5: goto L362;
            case 6: goto L362;
            case 7: goto L362;
            case 8: goto L265;
            case 9: goto L262;
            case 10: goto L259;
            case 11: goto L210;
            case 12: goto L210;
            case 13: goto L174;
            case 14: goto L122;
            case 15: goto L112;
            case 16: goto L70;
            case 17: goto L56;
            case 18: goto L34;
            case 19: goto L12;
            case 20: goto L11;
            case 21: goto L10;
            default: goto L406;
        };
    L10:
        TextView r2 = new TextView(this.d);
        r37.a(r2);
        r2.setTextColor(this.c);
        r2.setText(2131892290);
        YogaNode r4 = r37.b(r2);
        a(r2, r38.mYogaProperty);
        r4.copyStyle(w0.a(r38.mYogaProperty));
        return;
    L11:
        f(r37, r38, r39);
        return;
    L12:
        final ?? r13 = n(r37, r38, Boolean.TRUE);
        final RichTextElement.TimePickerProperty r0 = r38.mRichTextProperty;
        if (r0.isLoading() == false) goto L15;
    L18:
        boolean r5 = true;
    L20:
        if (com.larksuite.framework.utils.f0.a(r0.getInitialTime()) == true) goto L25;
        String r6 = r0.getInitialTime();
        long r7 = com.ss.android.lark.message.card.view.richtext.b.l(r0.getInitialTime(), "HH:mm");
        if (r7 == (-1)) goto L24;
        r6 = l("time", r7, null);
    L24:
        r13.e(r6, Boolean.valueOf(r5));
        final long r8 = r7;
    L27:
        if (r0.isDisable() == false) goto L29;
        c0 r9 = this;
        int r10 = UDColorUtils.getColor(r9.d, 2131102416);
        c0 r11 = r9;
    L30:
        r13.setImageDrawable(UDIconUtils.getIconDrawable(r11.d, 2131256006, r10));
        int r12 = r11.h.f(r11.d, 16);
        Log.i("RichTextRender", "date picker zoomImageSize:" + r12);
        r13.setImgWidth(r12);
        r13.setImgHeight(r12);
        if (r0.isLoading() == false) goto L33;
        r13.c();
    L33:
        r39.getClass();
        r13.setEnabled(u(r0.isDisable(), false));
        Log.i("RichTextRender", "isForward:false property disable is :" + r0.isDisable());
        r13.setOnClickListener(new w(this, r8, r0, r13));
        r13.setOnLongClickListener(new k0(r11));
        return;
    L29:
        c0 r14 = this;
        r10 = UDColorUtils.getColor(r14.d, 2131102419);
        r11 = r14;
        goto L30
    L25:
        r13.d(r0.getPlaceHolder(), Boolean.valueOf(r5));
        r8 = -1;
        goto L27
    L15:
        if (r0.isDisable() == true) goto L18;
        r5 = false;
        goto L20
    L34:
        final ?? r15 = n(r37, r38, Boolean.TRUE);
        final RichTextElement.DatePickerProperty r16 = r38.mRichTextProperty;
        if (r16.isLoading() == false) goto L37;
    L40:
        boolean r17 = true;
    L42:
        if (com.larksuite.framework.utils.f0.a(r16.getInitialDate()) == true) goto L47;
        String r18 = r16.getInitialDate();
        long r19 = com.ss.android.lark.message.card.view.richtext.b.l(r16.getInitialDate(), "yyyy-MM-dd");
        if (r19 == (-1)) goto L46;
        r18 = l("date", r19, null);
    L46:
        r15.e(r18, Boolean.valueOf(r17));
        final long r20 = r19;
    L49:
        if (r16.isDisable() == false) goto L51;
        int r21 = UDColorUtils.getColor(this.d, 2131102416);
    L52:
        r15.setImageDrawable(UDIconUtils.getIconDrawable(this.d, 2131253990, r21));
        int r22 = this.h.f(this.d, 16);
        Log.i("RichTextRender", "date picker zoomImageSize:" + r22);
        r15.setImgWidth(r22);
        r15.setImgHeight(r22);
        if (r16.isLoading() == false) goto L55;
        r15.c();
    L55:
        r39.getClass();
        r15.setEnabled(u(r16.isDisable(), false));
        Log.i("RichTextRender", "isForward:false property disable is :" + r16.isDisable());
        r15.setOnClickListener(new com.ss.android.lark.message.card.view.richtext.o(this, r20, r16, r15));
        r15.setOnLongClickListener(new l0(this));
        return;
    L51:
        r21 = UDColorUtils.getColor(this.d, 2131102419);
        goto L52
    L47:
        r15.d(r16.getPlaceHolder(), Boolean.valueOf(r17));
        r20 = -1;
        goto L49
    L37:
        if (r16.isDisable() == true) goto L40;
        r17 = false;
        goto L42
    L56:
        final ?? r23 = n(r37, r38, Boolean.FALSE);
        final RichTextElement.OverflowMenuProperty r24 = r38.mRichTextProperty;
        r39.getClass();
        boolean r25 = u(r24.isDisable(), false);
        LinkEmojiTextView r26 = r23.s;
        if (r26 == null) goto L60;
        r23.removeView(r26);
        r23.s = null;
        r23.t = null;
    L60:
        if (r24.isDisable() == true) goto L62;
        boolean r27 = false;
    L63:
        if (r27 == false) goto L65;
        int r28 = UDColorUtils.getColor(this.d, 2131102416);
    L66:
        r23.setImageDrawable(UDIconUtils.getIconDrawable(this.d, 2131255147, r28));
        int r29 = this.h.f(this.d, 20);
        Log.i("RichTextRender", "over flow zoomImageSize:" + r29);
        r23.setImgWidth(r29);
        r23.setImgHeight(r29);
        if (r24.isLoading() == false) goto L69;
        r23.c();
    L69:
        r23.setEnabled(r25);
        Log.i("RichTextRender", "isForward:false property disable is :" + r24.isDisable());
        r23.setOnClickListener(new com.ss.android.lark.message.card.view.richtext.d(this, r24, r23));
        r23.setOnLongClickListener(new m0(this));
        return;
    L65:
        r28 = UDColorUtils.getColor(this.d, 2131102419);
        goto L66
    L62:
        r27 = true;
        goto L63
    L70:
        ?? r110 = n(r37, r38, Boolean.TRUE);
        RichTextElement.SelectMenuProperty r30 = r38.mRichTextProperty;
        if (r30.isLoading() == false) goto L73;
    L76:
        boolean r31 = true;
    L77:
        r39.getClass();
        boolean r32 = u(r30.isDisable(), false);
        if (r30.isLoading() == false) goto L81;
        r110.c();
    L88:
        r110.setEnabled(r32);
        List r33 = r30.getOptions();
        String r34 = r30.getInitialOption();
        if (r30.getType() != RichTextElement.SelectMenuProperty.Type.PERSON) goto L96;
        if (com.larksuite.framework.utils.f0.a(r34) == false) goto L93;
        r110.d(r30.getPlaceHolder(), Boolean.valueOf(r31));
    L94:
        String[] r35 = null;
        HashMap r111 = null;
        int r36 = -1;
    L111:
        Log.i("RichTextRender", "isForward:false property disable is :" + r30.isDisable());
        r110.setOnClickListener(new n0(new q(this, r30, r110, r35, r111, r36)));
        r110.setOnLongClickListener(new o0(this));
        return;
    L93:
        r110.e(r34, Boolean.valueOf(r31));
        goto L94
    L96:
        if (CollectionUtils.isEmpty(r33) == false) goto L98;
        int r41 = 0;
    L99:
        String[] r112 = new String[r41];
        r111 = new HashMap();
        int r113 = 0;
        int r114 = -1;
    L100:
        if (r113 >= r41) goto L106;
        String r115 = ((RichTextElement.MenuOption) ListProtector.get(r33, r113)).getText();
        r112[r113] = r115;
        r111.put(r115, ((RichTextElement.MenuOption) ListProtector.get(r33, r113)).getValue());
        if (com.larksuite.framework.utils.f0.c(r34, ((RichTextElement.MenuOption) ListProtector.get(r33, r113)).getValue()) == false) goto L104;
        r110.e(((RichTextElement.MenuOption) ListProtector.get(r33, r113)).getText(), Boolean.valueOf(r31));
        r114 = r113;
    L104:
        r113 = r113 + 1;
        goto L100
    L106:
        if (r114 == (-1)) goto L108;
    L110:
        r35 = r112;
        r36 = r114;
        goto L111
    L108:
        if (com.larksuite.framework.utils.f0.a(r30.getPlaceHolder()) == true) goto L110;
        r110.d(r30.getPlaceHolder(), Boolean.valueOf(r31));
        goto L110
    L98:
        r41 = r33.size();
        goto L99
    L81:
        if (r30.isDisable() == true) goto L83;
        boolean r42 = false;
    L84:
        if (r42 == false) goto L86;
        int r43 = UDColorUtils.getColor(this.d, 2131102416);
    L87:
        r110.setImageDrawable(UDIconUtils.getIconDrawable(this.d, 2131254261, r43));
        int r44 = this.h.f(this.d, 16);
        Log.i("RichTextRender", "select menu flow zoomImageSize:" + r44);
        r110.setImgWidth(r44);
        r110.setImgHeight(r44);
        goto L88
    L86:
        r43 = UDColorUtils.getColor(this.d, 2131102419);
        goto L87
    L83:
        r42 = true;
        goto L84
    L73:
        if (r30.isDisable() == true) goto L76;
        r31 = false;
        goto L77
    L112:
        YogaLayout r45 = new YogaLayout(this.d);
        r37.a(r45);
        int r46 = r38.mBgColor;
        if (r46 == 0) goto L115;
        r45.setBackgroundColor(r46);
    L115:
        YogaNode r47 = r37.b(r45);
        a(r45, r38.mYogaProperty);
        r47.copyStyle(w0.a(r38.mYogaProperty));
        RichTextElement.LinkProperty r48 = r38.mRichTextProperty;
        if (CollectionUtils.isNotEmpty(r38.mChildParams) == false) goto L121;
        v0 r49 = new v0(this.d);
        Intrinsics.checkNotNullParameter(r45, "yogaLayout");
        r49.b = r45;
        Iterator<NodeParams> r50 = r38.mChildParams.iterator();
    L119:
        if (r50.hasNext() == false) goto L121;
        w(r49, r50.next(), r39, r48);
    L121:
        r45.setOnClickListener(new a0(this, r48));
        r45.setOnLongClickListener(new b0(this));
        return;
    L122:
        ?? r51 = new MsgCardRoundedYogaLayout(this.d);
        r37.a(r51);
        YogaNode r52 = r37.b(r51);
        a(r51, r38.mYogaProperty);
        if (this.i != 2) goto L128;
        Log.i("RichTextRender", "button refine logic");
        if (TextUtils.equals(r38.mRichTextProperty.getMode(), InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK) == true) goto L127;
        int r53 = UIUtils.dp2px(this.d, 16.0f);
        YogaProperty r54 = r38.mYogaProperty;
        float r55 = r53;
        r54.paddingLeft = r55;
        r54.paddingRight = r55;
        goto L128
    L127:
        r38.mYogaProperty.paddingRight = 0.0f;
        r51.q.setAlignSelf(YogaAlign.FLEX_START);
        r51.q.setPosition(YogaEdge.RIGHT, 0.0f);
        r51.q.setPosition(YogaEdge.TOP, 5.0f);
    L128:
        YogaNode r56 = w0.a(r38.mYogaProperty);
        Context r57 = r51.getContext();
        MsgCardRoundedYogaLayout.a r116 = new MsgCardRoundedYogaLayout.a();
        r116.e = Integer.valueOf(UIUtils.dp2px(r57, 1.0f));
        r116.f = Float.valueOf(UIUtils.dp2px(r57, 6.0f));
        Map<String, String> r117 = r38.mExtraProperties;
        RichTextElement.ButtonProperty r118 = r38.mRichTextProperty;
        if (r118 != null) goto L131;
    L133:
        if (r117 != null) goto L135;
    L160:
        r51.setCustomizations(r116);
    L161:
        this.h.b(this.d, r56, r38);
        r52.copyStyle(r56);
        RichTextElement.ButtonProperty r58 = r38.mRichTextProperty;
        if (CollectionUtils.isNotEmpty(r38.mChildParams) == false) goto L168;
        v0 r59 = new v0(this.d);
        Intrinsics.checkNotNullParameter(r51, "yogaLayout");
        r59.b = r51;
        Iterator<NodeParams> r60 = r38.mChildParams.iterator();
    L165:
        if (r60.hasNext() == false) goto L168;
        w(r59, r60.next(), r39, null);
    L168:
        if (r58.isShowLoadingIcon() == true) goto L170;
    L173:
        r39.getClass();
        Log.i("RichTextRender", "isForward:false property disable is :" + r58.isDisable());
        r51.setOnClickListener(new y(this, r39.a(r58.getActionId()), r58, r51));
        r51.setOnLongClickListener(new z(this));
        r51.setEnabled(u(r58.isDisable(), false));
        return;
    L170:
        if (com.larksuite.framework.utils.f0.c(r58.getMode(), "danger") == false) goto L172;
        r51.setTintColorForLoadingIcon(2131102093);
    L172:
        r51.c();
        goto L173
    L135:
        if (r117.isEmpty() == true) goto L160;
        if (r117.get("backgroundColor") == null) goto L141;
        r116.a = Integer.valueOf(com.ss.android.lark.message.card.view.richtext.b.e(r117, "backgroundColor"));
    L141:
        if (r117.get("backgroundColorDisable") == null) goto L144;
        r116.c = Integer.valueOf(com.ss.android.lark.message.card.view.richtext.b.e(r117, "backgroundColorDisable"));
    L144:
        if (r117.get("backgroundColorActive") == null) goto L147;
        r116.b = Integer.valueOf(com.ss.android.lark.message.card.view.richtext.b.e(r117, "backgroundColorActive"));
    L147:
        if (r117.get("borderColor") == null) goto L159;
        String r61 = r118.getMode();
        int r119 = UIUtils.getColor(this.d, 2131103352);
        if (RichTextStyle.ButtonMode.MODE_PRIMARY.getMode().equals(r61) == false) goto L152;
        r119 = UIUtils.getColor(this.d, 2131105548);
    L154:
        Log.d("RichTextRender", "rounded layout border styles=" + r117 + " color=" + String.format("#%08X", new Object[]{Integer.valueOf(r119 & (-1))}));
        r116.d = Integer.valueOf(r119);
        if (r118.isShowLoadingIcon() == false) goto L157;
    L158:
        int r62 = Color.argb(153, Color.red(r119), Color.green(r119), Color.blue(r119));
        r116.d = Integer.valueOf(r62);
        Log.d("RichTextRender", "rounded layout border dark color=" + String.format("#%08X", new Object[]{Integer.valueOf(r62 & (-1))}));
        goto L159
    L157:
        if (r118.isDisable() == false) goto L159;
    L152:
        if (RichTextStyle.ButtonMode.MODE_DANGER.getMode().equals(r61) == false) goto L154;
        r119 = UIUtils.getColor(this.d, 2131102093);
    L159:
        r51.setCustomizations(r116);
        goto L161
    L131:
        if (TextUtils.equals(r118.getMode(), InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK) == true) goto L133;
        r56.setHeight(UIUtils.dp2px(r57, 36.0f));
        goto L133
    L174:
        RichTextElement.TimeProperty r63 = r38.mRichTextProperty;
        if (TextUtils.isEmpty(r63.getFormat_type()) == true) goto L200;
        String r64 = m(r63, null);
        if (TextUtils.isEmpty(r64) == true) goto L407;
        dwa.j r65 = dwa.j.d(this.d);
        String r66 = MsgCardLinkEmojiTextView.class.getName();
        r65.getClass();
        dwa.b.c(r66);
        EmojiconTextView r67 = new MsgCardLinkEmojiTextView(this.d);
        if (this.g != null) goto L182;
        this.g = com.ss.android.lark.message.card.b.a().getLoginUserId();
    L182:
        r67.setTranslateEmojiCode(false);
        r67.setCurrentUserId(this.g);
        r37.a(r67);
        YogaNode r68 = r37.b(r67);
        a(r67, r38.mYogaProperty);
        r68.copyStyle(w0.a(r38.mYogaProperty));
        r67.setLineSpacing(this.a, 1.0f);
        b(r38, r67);
        if (r38.mParents.mRichTextTag != RichTextElement.RichTextTag.BUTTON) goto L185;
        boolean r69 = true;
    L186:
        if (r69 == false) goto L188;
        r67.setSingleLine();
    L188:
        r67.setEllipsize(TextUtils.TruncateAt.END);
        if (r69 == false) goto L195;
        RichTextElement.ButtonProperty r70 = r38.mParents.mRichTextProperty;
        if ((r70 instanceof RichTextElement.ButtonProperty) == false) goto L195;
        if (InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK.equals(r70.getMode()) == true) goto L195;
        r68.setHeight(UIUtils.dp2px(this.d, 22.0f));
    L195:
        ArrayList r120 = new ArrayList();
        ArrayList r121 = new ArrayList();
        StringBuilder r71 = new StringBuilder();
        if (TextUtils.isEmpty(r63.getLink()) == true) goto L198;
        r120.add(r(this.d, r71, r38, r64, r63.getLink()));
    L199:
        r71.append(r64);
        new ArrayList();
        ArrayList r72 = new ArrayList();
        ArrayList r73 = new ArrayList();
        ArrayList r74 = new ArrayList();
        new ArrayList();
        RecogniseSpansResult r75 = new RecogniseSpansResult(r120, r72, r73, r74, r121, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        s(r67, r38.mParents.mRichTextProperty, r39, null);
        r67.G(r71.toString(), r75);
        return;
    L198:
        r121.add(q(this.d, r71, r38, r64));
        goto L199
    L185:
        r69 = false;
        goto L186
    L407:
        return;
    L200:
        TextView r76 = new TextView(this.d);
        r76.setText(p(r63));
        r37.a(r76);
        YogaNode r77 = r37.b(r76);
        a(r76, r38.mYogaProperty);
        r77.copyStyle(w0.a(r38.mYogaProperty));
        int r78 = r38.mBgColor;
        if (r78 == 0) goto L203;
        r76.setBackgroundColor(r78);
    L203:
        int r79 = r38.mTextColor;
        if (r79 == 0) goto L206;
        r76.setTextColor(r79);
    L206:
        r76.setTypeface(r76.getTypeface(), r38.mFontStyleAndWeight);
        float r80 = r38.mTextSize;
        if (r80 <= 0.0f) goto L209;
        r76.setTextSize(r80);
    L209:
        r76.setLineSpacing(this.a, 1.0f);
        return;
    L210:
        v0 r81 = new v0(this.d);
        Integer r82 = Integer.valueOf(r38.mBgColor);
        if (r82 == null) goto L221;
        if (r82.intValue() == 0) goto L221;
        if (r81.b != null) goto L217;
        r81.b = new YogaLayout(r81.a);
    L217:
        YogaLayout r83 = r81.b;
        if (r83 == null) goto L221;
        r83.setBackgroundColor(r82.intValue());
    L221:
        if (CollectionUtils.isNotEmpty(r38.mChildParams) == false) goto L226;
        Iterator<NodeParams> r84 = r38.mChildParams.iterator();
    L224:
        if (r84.hasNext() == false) goto L226;
        w(r81, r84.next(), r39, r40);
    L226:
        VirtualYogaLayout r85 = r81.b;
        if (r85 != null) goto L230;
        r85 = r81.c;
    L230:
        if (r85 != null) goto L232;
        r85 = new YogaLayout(this.d);
        Intrinsics.checkNotNullParameter(r85, "yogaLayout");
        r81.b = r85;
    L232:
        r37.a(r85);
        YogaLayout r86 = r81.b;
        if (r86 == null) goto L235;
        YogaNode r87 = r86.getYogaNode();
    L239:
        if (r87 == null) goto L391;
        r87.copyStyle(w0.a(r38.mYogaProperty));
        if (r87.getWidth().unit != YogaUnit.AUTO) goto L392;
        int r88 = ((MessageCardPWidthTypeConfig) SettingManager.getInstance().get(MessageCardPWidthTypeConfig.class)).p_width_type;
        if (r88 != 1) goto L245;
        YogaProperty r89 = r38.mYogaProperty;
        if (r89 != null) goto L256;
    L257:
        r87.setWidthPercent(100.0f);
        return;
    L256:
        if (r89.display != YogaDisplay.FLEX.intValue()) goto L257;
        return;
    L245:
        if (r88 != 2) goto L247;
        return;
    L247:
        if (r88 == 3) goto L394;
        List<String> r90 = r38.mStyleKeys;
        if (r90 != null) goto L251;
    L252:
        r87.setWidthPercent(100.0f);
        return;
    L251:
        if (r90.contains("block_column_width_auto") == false) goto L252;
        return;
    L394:
        return;
    L392:
        return;
    L391:
        return;
    L235:
        VirtualYogaLayout r91 = r81.c;
        if (r91 == null) goto L238;
        r87 = r91.getYogaNode();
        goto L239
    L238:
        r87 = null;
        goto L239
    L262:
        View r92 = new View(this.d);
        r37.a(r92);
        YogaNode r93 = r37.b(r92);
        a(r92, r38.mYogaProperty);
        r93.copyStyle(w0.a(r38.mYogaProperty));
        r93.setHeight(UIUtils.dp2px(this.d, 1.0f));
        int r94 = r38.mBgColor;
        if (r94 == 0) goto L401;
        r92.setBackgroundColor(r94);
        return;
    L401:
        return;
    L265:
        boolean r95 = true;
        final RichTextElement.ImageProperty r96 = r38.mRichTextProperty;
        final ?? r122 = new MsgCardRoundedImageView(this.d);
        r37.a(r122);
        if (r96.getOriginWidth() == 0) goto L268;
        float r97 = r96.getOriginHeight() / r96.getOriginWidth();
    L270:
        if (r96.getShowMode() != CardImageShowMode.STRETCH.getShowModeValue()) goto L272;
        boolean r98 = true;
    L274:
        if (r98 == true) goto L276;
    L278:
        boolean r99 = false;
    L279:
        YogaNode r100 = r37.b(r122);
        a(r122, r38.mYogaProperty);
        if (r96.getCustomWidth() != 0) goto L283;
        r95 = false;
    L283:
        if (r95 == false) goto L287;
        r38.mYogaProperty.width = UIUtils.dp2px(this.d, r96.getCustomWidth());
        if (r99 == false) goto L287;
        r38.mYogaProperty.maxHeight = UIUtils.dp2px(this.d, r96.getCustomWidth()) * 1.78f;
    L287:
        r100.copyStyle(w0.a(r38.mYogaProperty));
        final Image r123 = com.ss.android.lark.widget.richtext.d.g(r96);
        if (r100.getWidth().equals(YogaValue.parse("auto")) == false) goto L291;
        r100.setWidth(this.b * r123.getWidth());
    L291:
        if (r100.getHeight().equals(YogaValue.parse("auto")) == false) goto L293;
        r100.setHeight(this.b * r123.getHeight());
    L293:
        if (r99 == false) goto L295;
        r122.setScaleType(ImageView.ScaleType.MATRIX);
    L295:
        Map<String, String> r101 = r38.mExtraProperties;
        if (r101 == null) goto L317;
        String r102 = r101.get("borderRadius");
        if (TextUtils.isEmpty(r102) == false) goto L300;
        Log.w("RichTextRender", "msg " + this.f + " has no radius style info");
    L318:
        IMBizImageRenderInterceptor.a r103 = new com.ss.android.lark.message.card.view.richtext.p(r122);
        Intrinsics.checkNotNullParameter(r103, "func");
        ?? r104 = new com.ss.android.lark.message.card.view.richtext.q(r96);
        Intrinsics.checkNotNullParameter(r104, "data");
        kpc.a r105 = (kpc.a) r104.invoke();
        Context r106 = r122.getContext();
        Intrinsics.checkNotNullParameter(r106, "context");
        com.suite.lark.platform.component.widgetrenderinterceptor.a r124 = new com.suite.lark.platform.component.widgetrenderinterceptor.a(r106);
        r124.c = r105;
        r124.b = r103;
        if (TextUtils.isEmpty(r123.getToken()) == true) goto L353;
        String r107 = r123.getKey();
        if (TextUtils.isEmpty(r107) == false) goto L323;
        jrb.c.a(jrb.d.b).addTag("RichTextRender").flush();
        Log.e("local url in rich text render! token: " + r123.getToken());
    L359:
        if (r96.isImgCanPreview() == false) goto L403;
        r124.b(new com.ss.android.lark.message.card.view.richtext.r(this, r122, r123));
        r124.a();
        return;
    L403:
        return;
    L323:
        if (r96.getResourceCleanScene() != null) goto L325;
    L333:
        if (r99 == true) goto L335;
    L350:
        v(r124, r122, r107, r123, r99);
        goto L359
    L335:
        if (r95 == true) goto L337;
    L338:
        if (r95 == true) goto L350;
        if (r96.getOriginWidth() < 60) goto L350;
    L341:
        TextView r108 = new TextView(this.d);
        r37.a(r108);
        YogaNode r109 = r37.b(r108);
        if (r109 == null) goto L350;
        r109.setPositionType(YogaPositionType.ABSOLUTE);
        if (r96.getCustomWidth() != 0) goto L346;
    L348:
        r109.setPosition(YogaEdge.RIGHT, 1.0f);
    L349:
        YogaEdge r125 = YogaEdge.BOTTOM;
        r109.setPosition(r125, 1.0f);
        r109.setPosition(r125, 1.0f);
        int r126 = UIUtils.dp2px(this.d, 2.0f);
        int r127 = UIUtils.dp2px(this.d, 6.0f);
        r108.setBackgroundColor(UIUtils.getColor(this.d, 2131106511));
        r108.setTextColor(UIUtils.getColor(this.d, 2131106521));
        r108.setPadding(r127, r126, r127, r126);
        r108.setTextSize(10.0f);
        r108.setText(2131891989);
        goto L350
    L346:
        if (r96.getCustomWidth() >= 260) goto L348;
        r109.setPosition(YogaEdge.LEFT, UIUtils.dp2px(this.d, r96.getCustomWidth()) - (UIUtils.dp2px(this.d, 12.0f) + (UIUtils.sp2px(this.d, 10.0f) * 2.0f)));
        goto L349
    L337:
        if (r96.getCustomWidth() >= 60) goto L341;
    L325:
        if (r122.getWidth() != 0) goto L333;
        if (r122.getHeight() != 0) goto L333;
        Log.d("RichTextRender", "loadImage " + r107 + ", width=" + r122.getWidth() + ", height=" + r122.getHeight());
        if (r122.getWidth() != 0) goto L359;
        if (r122.getHeight() != 0) goto L359;
        r122.setOnSizeChangedListener(new p0(this, r124, r122, r107, r123, r99));
        goto L359
    L353:
        if (CollectionUtils.isNotEmpty(r123.getUrls()) == false) goto L359;
        ColorStateList r128 = UDColorUtils.getColorStateList(this.d, 2131101951);
        r122.setImageTintMode(PorterDuff.Mode.SRC_OVER);
        r122.setImageTintList(r128);
        IRequestCreator r129 = ImageLoader.with(this.d).load(ListProtector.get(r123.getUrls(), 0));
        if (r99 == true) goto L357;
        r129.centerCrop();
    L357:
        ListenerParams.a r130 = new ListenerParams.a();
        r130.a(Biz.Messenger);
        r130.d(this.l);
        r130.c(ListenerParams.FromType.CARD);
        r130.c = r122.getWidth();
        r130.d = r122.getHeight();
        r129.listener(new PerfLoadPicMonitor.MonitorRequestListener(r130.b())).into(r122);
        goto L359
    L300:
        if (r102.indexOf("%") != (-1)) goto L302;
    L314:
        e = move-exception;
        Log.e("RichTextRender", "parse img style radius failed strBorderRadius=" + r102 + " err=", e);
        goto L318
    L310:
        if (CastDoubleProtector.parseDouble(r102) <= 2.0d) goto L312;
        r122.setRadiusInDp(8.0f);     // Catch: NumberFormatException -> L314
    L372:
        goto L318
    L312:
        r122.setRadiusInDp(2.0f);     // Catch: NumberFormatException -> L314
        goto L372
    L302:
        if (TextUtils.isEmpty(r102) == false) goto L304;
        float r131 = 0.0f;
    L308:
        r122.setRadiusPercent(r131);
        goto L318
    L304:
        int r132 = r102.indexOf("%");
        if ((-1) == r132) goto L307;
        r131 = com.ss.android.lark.message.card.view.richtext.b.a(r102.substring(0, r132), 0.0f) / 100.0f;
        goto L308
    L307:
        r131 = UIHelper.dp2px(com.ss.android.lark.message.card.view.richtext.b.a(r102, 0.0f));
        goto L308
    L317:
        Log.w("RichTextRender", "msg " + this.f + " has no style info");
        goto L318
    L276:
        if (r97 <= 1.78f) goto L278;
        r99 = true;
        goto L279
    L272:
        r98 = false;
        goto L274
    L268:
        r97 = 0.0f;
        goto L270
    L406:
        return;
    L259:
        if (r3 == false) goto L261;
        h(r37, r38.mChildParams, r38);
        return;
    L261:
        g(r37, r38.mChildParams, r38, r39, r40);
        return;
    L362:
        if (r3 == false) goto L364;
        j(r37, r38);
        return;
    L364:
        i(r37, r38, r39, r40);
    }

    public static UrlInfo r(Context r3, StringBuilder r4, NodeParams r5, String r6, String r7) {
        UrlInfo r0 = new UrlInfo();
        ((SpanInfo) r0).type = 1;
        int r8 = r4.toString().length();
        ((SpanInfo) r0).start = r8;
        ((SpanInfo) r0).end = r8 + r6.length();
        ((SpanInfo) r0).text = r6;
        float r9 = r5.mTextSize;
        if (r9 <= 0.0f) goto L5;
        ((TextStyleInfo) r0).textSize = (int) UIUtils.sp2px(r3, r9);
    L6:
        r0.href = r7;
        int r10 = r5.mFontStyleAndWeight;
        if (r10 == 1) goto L14;
        if (r10 != 2) goto L10;
        ((TextStyleInfo) r0).isItalic = true;
    L15:
        Map<String, String> r11 = r5.mExtraProperties;
        if (r11 == null) goto L45;
        String r12 = r11.get("textDecoration");
        if (TextUtils.isEmpty(r12) == true) goto L45;
        r12.getClass();
        int r13 = r12.hashCode();
        if (r13 == (-1608317383)) goto L35;
        if (r13 == (-1027917076)) goto L31;
        if (r13 == (-950577103)) goto L27;
    L36:
        byte r14 = -1;
    L38:
        if (r14 == 0) goto L44;
        if (r14 == 1) goto L43;
        if (r14 != 2) goto L45;
        ((TextStyleInfo) r0).isStrikeThruText = true;
        goto L45
    L43:
        ((TextStyleInfo) r0).isUnderlineText = true;
        goto L45
    L44:
        ((TextStyleInfo) r0).isStrikeThruText = true;
        ((TextStyleInfo) r0).isUnderlineText = true;
        goto L45
    L27:
        if (r12.equals("lineThrough") == false) goto L36;
        r14 = 2;
        goto L38
    L31:
        if (r12.equals("underLine") == false) goto L36;
        r14 = 1;
        goto L38
    L35:
        if (r12.equals("underLineThrough") == false) goto L36;
        r14 = 0;
    L45:
        return r0;
    L10:
        if (r10 != 3) goto L15;
        ((TextStyleInfo) r0).isBold = true;
        ((TextStyleInfo) r0).isItalic = true;
        goto L15
    L14:
        ((TextStyleInfo) r0).isBold = true;
        goto L15
    L5:
        ((TextStyleInfo) r0).textSize = (int) UIUtils.sp2px(r3, 14.0f);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(RichTextElement.ConfirmProperty r8, MsgCardRoundedYogaLayout r9, String r10, Map<String, String> r11, String r12) {
        e(r8, r9, r10, r11, r12, r9.getContext());
    }

    public final void g(v0 r36, List<NodeParams> r37, NodeParams r38, com.ss.android.lark.message.card.view.i r39, RichTextElement.LinkProperty r40) {
        dwa.j r3 = dwa.j.d(this.d);
        String r4 = MsgCardLinkEmojiTextView.class.getName();
        r3.getClass();
        dwa.b.c(r4);
        EmojiconTextView r5 = new MsgCardLinkEmojiTextView(this.d);
        r5.setTranslateEmojiCode(false);
        r5.setCurrentUserId(com.ss.android.lark.message.card.b.a().getLoginUserId());
        r36.a(r5);
        YogaNode r1 = r36.b(r5);
        a(r5, r38.mYogaProperty);
        r1.copyStyle(w0.a(r38.mYogaProperty));
        int r2 = r38.mBgColor;
        if (r2 == 0) goto L5;
        r5.setBackgroundColor(r2);
    L5:
        int r6 = r38.mTextColor;
        if (r6 == 0) goto L8;
        r5.setTextColor(r6);
    L8:
        b(r38, r5);
        RichTextElement.TextableAreaProperty r7 = r38.mRichTextProperty;
        if (r7.getNumberOfLines() <= 0) goto L14;
        r5.setMaxLines(r7.getNumberOfLines());
        if (r7.getNumberOfLines() != 1) goto L16;
        r5.setSingleLine();
    L16:
        r5.setEllipsize(TextUtils.TruncateAt.END);
        r5.setTypeface(r5.getTypeface(), r38.mFontStyleAndWeight);
        float r8 = r38.mTextSize;
        if (r8 <= 0.0f) goto L19;
        r5.setTextSize(r8);
    L19:
        r5.setLineSpacing(this.a, 1.0f);
        List<NodeParams> r9 = r38.mChildParams;
        ArrayList r15 = new ArrayList();
        ArrayList r31 = new ArrayList();
        ArrayList r32 = new ArrayList();
        ArrayList r33 = new ArrayList();
        StringBuilder r34 = new StringBuilder();
        if (CollectionUtils.isNotEmpty(r37) == false) goto L28;
        Iterator<NodeParams> r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L25;
        NodeParams r11 = r10.next();
        o(this.d, r15, r31, r32, r33, r34, r11, null);
        goto L23
    L25:
        new ArrayList();
        new ArrayList();
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        new ArrayList();
        ArrayList r14 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        new ArrayList();
        RecogniseSpansResult r20 = new RecogniseSpansResult(r31, r15, r12, r13, r32, r14, r16, r17, r18, r19, r33, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        s(r5, r38.mParents.mRichTextProperty, r39, r40);
        r5.G(r34.toString(), r20);
        return;
    L28:
        return;
    L14:
        if (r38.mParents.mRichTextTag != RichTextElement.RichTextTag.BUTTON) goto L16;
        r5.setSingleLine();
        goto L16
    }

    public final void v(com.suite.lark.platform.component.widgetrenderinterceptor.a r9, final MsgCardRoundedImageView r10, final String r11, final Image r12, final boolean r13) {
        Log.d("RichTextRender", "do load image " + r11);
        r9.c(new com.ss.android.lark.message.card.view.richtext.e(this, r10, r11, r12, r13));
        r9.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(RichTextElement.ConfirmProperty r8, MsgCardRoundedYogaLayout r9, String r10, Map<String, String> r11, String r12, Context r13) {
        if (r8 == null) goto L8;
        Log.d("show confirm, actionId: " + r10);
        if (r9 == 0) goto L6;
        r13 = r9.getContext();
    L6:
        new UDDialogBuilder(r13).titleBold(true).title(r8.getTitle()).message(r8.getText()).addActionButton(2131391778, this.d.getText(2131891541), new b(r10)).addActionButton(2131391777, this.d.getText(2131891623), new a(this, r12, r9, r10, r11)).cancelOnTouchOutside(false).show();
        return;
    }

    public static void o(Context r17, List<AtInfo> r18, List<UrlInfo> r19, List<TextStyleInfo> r20, List<EmojiconInfo> r21, StringBuilder r22, NodeParams r23, String r24) {
        if (r23.mRichTextTag != null) goto L5;
        return;
    L5:
        NodeParams r1 = r23.mParents;
        if (r1 != null) goto L8;
    L23:
        int r2 = h.a[r23.mRichTextTag.ordinal()];
        if (r2 != 10) goto L26;
        Iterator<NodeParams> r11 = r23.mChildParams.iterator();
    L171:
        if (r11.hasNext() == false) goto L185;
        o(r17, r18, r19, r20, r21, r22, r11.next(), r24);
        goto L171
    L185:
        return;
    L26:
        if (r2 != 13) goto L28;
        RichTextElement.TimeProperty r3 = r23.mRichTextProperty;
        if (TextUtils.isEmpty(r3.getFormat_type()) == true) goto L168;
        String r4 = m(r3, r24);
        if (TextUtils.isEmpty(r4) == false) goto L164;
        return;
    L164:
        if (TextUtils.isEmpty(r3.getLink()) == true) goto L166;
        UrlInfo r0 = r(r17, r22, r23, r4, r3.getLink());
        ((ArrayList) r19).add(r0);
    L167:
        r22.append(r4);
        return;
    L166:
        ArrayList r5 = (ArrayList) r20;
        r5.add(q(r17, r22, r23, r4));
        goto L167
    L168:
        r22.append(p(r3));
        return;
    L28:
        switch(r2) {
            case 1: goto L104;
            case 2: goto L61;
            case 3: goto L54;
            case 4: goto L43;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            default: goto L183;
        };
    L30:
        RichTextElement.TextProperty r6 = r23.mRichTextProperty;
        ArrayList r7 = (ArrayList) r20;
        r7.add(k(r17, r22, r23, r6));
        r22.append(r6.getContent());
        return;
    L31:
        RichTextElement.UnderlineProperty r8 = r23.mRichTextProperty;
        TextStyleInfo r9 = k(r17, r22, r23, r8);
        r9.isUnderlineText = true;
        ((ArrayList) r20).add(r9);
        r22.append(r8.getContent());
        return;
    L32:
        RichTextElement.BoldProperty r10 = r23.mRichTextProperty;
        TextStyleInfo r12 = k(r17, r22, r23, r10);
        int r13 = r23.mFontStyleAndWeight;
        if (r13 != 0) goto L35;
        r12.isBold = true;
    L42:
        ((ArrayList) r20).add(r12);
        r22.append(r10.getContent());
        return;
    L35:
        if (r13 == 1) goto L41;
        if (r13 == 2) goto L40;
        if (r13 != 3) goto L42;
        r12.isBold = true;
        r12.isItalic = true;
        goto L42
    L40:
        r12.isItalic = true;
        goto L42
    L41:
        r12.isBold = true;
        goto L42
    L43:
        RichTextElement.ItalicProperty r14 = r23.mRichTextProperty;
        TextStyleInfo r15 = k(r17, r22, r23, r14);
        int r16 = r23.mFontStyleAndWeight;
        if (r16 != 0) goto L46;
        r15.isItalic = true;
    L53:
        ((ArrayList) r20).add(r15);
        r22.append(r14.getContent());
        return;
    L46:
        if (r16 == 1) goto L52;
        if (r16 == 2) goto L51;
        if (r16 != 3) goto L53;
        r15.isBold = true;
        r15.isItalic = true;
        goto L53
    L51:
        r15.isItalic = true;
        goto L53
    L52:
        r15.isBold = true;
        goto L53
    L54:
        RichTextElement.EmotionProperty r25 = r23.mRichTextProperty;
        String r26 = EmojiHandler.e(r25.getKey());
        String r27 = r25.getKey();
        Intrinsics.checkNotNullParameter(r27, TabAppInfo.IMAGE_JSON_KEY);
        EmojiconInfo r28 = null;
        Drawable r29 = EmojiHandler.c(r27, null, null);
        if (r29 == null) goto L58;
        r28 = new EmojiconInfo();
        ((SpanInfo) r28).type = 10;
        ((SpanInfo) r28).text = r26;
        int r30 = r22.toString().length();
        ((SpanInfo) r28).start = r30;
        ((SpanInfo) r28).end = r30 + ((SpanInfo) r28).text.length();
        r28.key = r25.getKey();
        r28.drawable = r29;
    L58:
        if (r28 == null) goto L60;
        ((ArrayList) r21).add(r28);
    L60:
        r22.append(r26);
        return;
    L61:
        RichTextElement.AtProperty r31 = r23.mRichTextProperty;
        String r32 = com.ss.android.lark.utils.o.a(r31.getUserId(), r31.getAtContent());
        AtInfo r33 = new AtInfo();
        ((SpanInfo) r33).type = 0;
        r33.userId = r31.getUserId();
        ((SpanInfo) r33).text = r31.getAtContent();
        int r34 = r22.toString().length();
        ((SpanInfo) r33).start = r34;
        ((SpanInfo) r33).end = r34 + r32.length();
        float r35 = r23.mTextSize;
        if (r35 <= 0.0f) goto L64;
        ((TextStyleInfo) r33).textSize = (int) UIUtils.sp2px(r17, r35);
    L65:
        int r36 = r23.mFontStyleAndWeight;
        if (r36 == 1) goto L72;
        if (r36 == 2) goto L71;
        if (r36 != 3) goto L73;
        ((TextStyleInfo) r33).isBold = true;
        ((TextStyleInfo) r33).isItalic = true;
    L73:
        Map<String, String> r37 = r23.mExtraProperties;
        if (r37 == null) goto L103;
        String r38 = r37.get("textDecoration");
        if (TextUtils.isEmpty(r38) == true) goto L103;
        r38.getClass();
        int r39 = r38.hashCode();
        if (r39 == (-1608317383)) goto L93;
        if (r39 == (-1027917076)) goto L89;
        if (r39 == (-950577103)) goto L85;
    L94:
        byte r40 = -1;
    L96:
        if (r40 == 0) goto L102;
        if (r40 == 1) goto L101;
        if (r40 != 2) goto L103;
        ((TextStyleInfo) r33).isStrikeThruText = true;
        goto L103
    L101:
        ((TextStyleInfo) r33).isUnderlineText = true;
        goto L103
    L102:
        ((TextStyleInfo) r33).isStrikeThruText = true;
        ((TextStyleInfo) r33).isUnderlineText = true;
        goto L103
    L85:
        if (r38.equals("lineThrough") == false) goto L94;
        r40 = 2;
        goto L96
    L89:
        if (r38.equals("underLine") == false) goto L94;
        r40 = 1;
        goto L96
    L93:
        if (r38.equals("underLineThrough") == false) goto L94;
        r40 = 0;
    L103:
        ((ArrayList) r18).add(r33);
        r22.append(r32);
        return;
    L71:
        ((TextStyleInfo) r33).isItalic = true;
        goto L73
    L72:
        ((TextStyleInfo) r33).isBold = true;
        goto L73
    L64:
        ((TextStyleInfo) r33).textSize = (int) UIUtils.sp2px(r17, 14.0f);
        goto L65
    L104:
        RichTextElement.AnchorProperty r41 = r23.mRichTextProperty;
        if (TextUtils.isEmpty(r41.getContent()) == true) goto L107;
    L111:
        UrlInfo r42 = new UrlInfo();
        ((SpanInfo) r42).type = 1;
        int r43 = r22.toString().length();
        ((SpanInfo) r42).start = r43;
        ((SpanInfo) r42).end = r43 + r41.getContent().length();
        ((SpanInfo) r42).text = r41.getContent();
        float r44 = r23.mTextSize;
        if (r44 <= 0.0f) goto L114;
        ((TextStyleInfo) r42).textSize = (int) UIUtils.sp2px(r17, r44);
    L116:
        if (TextUtils.isEmpty(r41.getAndroidHref()) == false) goto L118;
        r42.href = r41.getHref();
    L119:
        int r45 = r23.mFontStyleAndWeight;
        if (r45 == 1) goto L126;
        if (r45 == 2) goto L125;
        if (r45 != 3) goto L127;
        ((TextStyleInfo) r42).isBold = true;
        ((TextStyleInfo) r42).isItalic = true;
    L127:
        Map<String, String> r46 = r23.mExtraProperties;
        if (r46 == null) goto L157;
        String r47 = r46.get("textDecoration");
        if (TextUtils.isEmpty(r47) == true) goto L157;
        r47.getClass();
        int r48 = r47.hashCode();
        if (r48 == (-1608317383)) goto L147;
        if (r48 == (-1027917076)) goto L143;
        if (r48 == (-950577103)) goto L139;
    L148:
        byte r49 = -1;
    L150:
        if (r49 == 0) goto L156;
        if (r49 == 1) goto L155;
        if (r49 != 2) goto L157;
        ((TextStyleInfo) r42).isStrikeThruText = true;
        goto L157
    L155:
        ((TextStyleInfo) r42).isUnderlineText = true;
        goto L157
    L156:
        ((TextStyleInfo) r42).isStrikeThruText = true;
        ((TextStyleInfo) r42).isUnderlineText = true;
        goto L157
    L139:
        if (r47.equals("lineThrough") == false) goto L148;
        r49 = 2;
        goto L150
    L143:
        if (r47.equals("underLine") == false) goto L148;
        r49 = 1;
        goto L150
    L147:
        if (r47.equals("underLineThrough") == false) goto L148;
        r49 = 0;
    L157:
        ((ArrayList) r19).add(r42);
        r22.append(r41.getContent());
        return;
    L125:
        ((TextStyleInfo) r42).isItalic = true;
        goto L127
    L126:
        ((TextStyleInfo) r42).isBold = true;
        goto L127
    L118:
        r42.href = r41.getAndroidHref();
        goto L119
    L114:
        ((TextStyleInfo) r42).textSize = (int) UIUtils.sp2px(r17, 14.0f);
        goto L116
    L107:
        if (TextUtils.isEmpty(r41.getAndroidHref()) == false) goto L109;
        String r50 = r41.getHref();
    L110:
        r41.setContent(r50);
        goto L111
    L109:
        r50 = r41.getAndroidHref();
        goto L110
    L183:
        return;
    L8:
        if (r1.mRichTextTag != RichTextElement.RichTextTag.TEXTABLEAREA) goto L23;
        Map<String, String> r51 = r1.mExtraProperties;
        if (r51 == null) goto L23;
        int r52 = r23.mFontStyleAndWeight;
        r23.mFontStyleAndWeight = r1.mFontStyleAndWeight | r52;
        String r53 = r51.get("textDecoration");
        if (y0.d(r53) == true) goto L23;
        Map<String, String> r54 = r23.mExtraProperties;
        if (r54 != null) goto L16;
        HashMap r55 = new HashMap();
        r23.mExtraProperties = r55;
        r55.put("textDecoration", r53);
        goto L23
    L16:
        String r56 = r54.get("textDecoration");
        if (y0.d(r56) == false) goto L19;
    L22:
        r23.mExtraProperties.put("textDecoration", r53);
        goto L23
    L19:
        if (r53.equals(r56) == true) goto L22;
        r23.mExtraProperties.put("textDecoration", "lineThrough");
        goto L23
    }
}
