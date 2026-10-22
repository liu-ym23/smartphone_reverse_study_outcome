package com.ss.android.lark.flow.passport.ui.widget.common;

import android.os.Build;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import com.ss.android.lark.flow.passport.ui.widget.layout.CommonContainerLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.widget.CommonTitleBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uzb.i;
import uzb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CommonUiContainer extends com.ss.android.lark.flow.passport.ui.widget.common.a {
    public static final /* synthetic */ int j = 0;
    public final CommonContainerLayout d;
    public final LinearLayout e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/flow/passport/ui/widget/common/CommonUiContainer$AddTo;", "", "<init>", "(Ljava/lang/String;I)V", "Header", "Content", "Footer", "flow-passport-ui_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum AddTo extends Enum<AddTo> {
        public static final AddTo Content = null;
        public static final AddTo Footer = null;
        public static final AddTo Header = null;
        public static final /* synthetic */ AddTo[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AddTo> getEntries() {
            return b;
        }

        static {
            AddTo r0 = new AddTo("Header", 0);
            Header = r0;
            AddTo r1 = new AddTo("Content", 1);
            Content = r1;
            AddTo r3 = new AddTo("Footer", 2);
            Footer = r3;
            AddTo[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static AddTo[] values() {
            return (AddTo[]) a.clone();
        }

        public static AddTo valueOf(String r1) {
            return (AddTo) r27.a.a(AddTo.class, r1);
        }

        public AddTo(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends CommonTitleBar.c {
        public final /* synthetic */ FragmentActivity a;

        public final void b() {
            this.a.onBackPressed();
        }

        public a(FragmentActivity r1) {
            this.a = r1;
        }
    }

    public static final class b {
        /* JADX WARN: Type inference failed for: r6v7, types: [android.view.ViewGroup, com.ss.android.lark.flow.passport.ui.widget.layout.CommonContainerLayout, java.lang.Object] */
        @JvmStatic
        public static CommonUiContainer a(FragmentActivity r4, int r5, ViewGroup r6) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            LayoutInflater r7 = LayoutInflater.from(r4);
            Intrinsics.checkNotNull(r7);
            int r0 = com.ss.android.lark.flow.passport.ui.widget.layout.f.a;
            Intrinsics.checkNotNullParameter(r7, "inflater");
            BaseContainerLayout r1 = new BaseContainerLayout(r7.getContext(), null, 6, 0);
            r1.a(2131564166);
            ?? r8 = (CommonContainerLayout) r1.findViewById(2131377610);
            View.inflate(r8.getContext(), r5, r8.g);
            Intrinsics.checkNotNull(r8);
            return new CommonUiContainer(r4, r1, r8);
        }
    }

    static {
    }

    public final void a(CharSequence r14) {
        TextView r0 = (TextView) this.g.getValue();
        boolean r1 = true;
        int r2 = 0;
        if (r14 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if ((!r3) == false) goto L12;
        int r4 = 0;
    L13:
        r0.setVisibility(r4);
        if (r14 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L40;
        FragmentActivity r6 = this.a;
        TextView r7 = (TextView) this.g.getValue();
        String r15 = r14.toString();
        if (TextUtils.isEmpty(r15) == true) goto L40;
        r15 = uzb.g.a(r15, r6);     // Catch: Exception -> L26
    L29:
        if (TextUtils.isEmpty(r15) == false) goto L32;
        r15 = "";
    L32:
        if (Build.VERSION.SDK_INT < 24) goto L34;
        Spanned r16 = Html.fromHtml(r15, 63);
    L35:
        SpannableStringBuilder r8 = new SpannableStringBuilder(r16);
        URLSpan[] r17 = (URLSpan[]) r8.getSpans(0, r16.length(), URLSpan.class);
        int r9 = r17.length;
        int r10 = 0;
    L36:
        if (r10 >= r9) goto L38;
        URLSpan r11 = r17[r10];
        int r12 = r8.getSpanStart(r11);
        int r13 = r8.getSpanEnd(r11);
        int r18 = r8.getSpanFlags(r11);
        r8.removeSpan(r11);
        r8.setSpan(new uzb.h(r6, new i(r11, r6)), r12, r13, r18);
        r10 = r10 + 1;
        goto L36
    L38:
        r7.setText(r8);
        r7.setMovementMethod(LinkMovementMethod.getInstance());
        r7.setHighlightColor(0);
        goto L40
    L34:
        r16 = Html.fromHtml(r15);
    L26:
        e = move-exception;
        PassportLog.b("MatchUtil", "regex exception:" + e.getMessage());
    L40:
        if (((TextView) this.g.getValue()).getVisibility() == 0) goto L43;
        r1 = false;
    L43:
        if (r1 == true) goto L46;
        r2 = l.a(((TextView) this.g.getValue()).getContext(), 24.0f);
    L46:
        TextView r19 = (TextView) this.f.getValue();
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L51;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        r21.bottomMargin = r2;
        r19.setLayoutParams(r21);
        return;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        if (StringsKt.isBlank(r14) == true) goto L19;
        r5 = false;
        goto L20
    L12:
        r4 = 8;
        goto L13
    L5:
        if (StringsKt.isBlank(r14) == true) goto L8;
        r3 = false;
        goto L10
    }

    public final void b(CharSequence r5) {
        TextView r0 = (TextView) this.f.getValue();
        if (r5 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if ((true ^ r3) == false) goto L12;
        int r1 = 0;
    L13:
        r0.setVisibility(r1);
        ((TextView) this.f.getValue()).setText(r5);
        ((CommonTitleBar) this.i.getValue()).setTitleText(r5);
        ((CommonTitleBar) this.i.getValue()).getTitleView().setAlpha(0.0f);
        this.d.getTitleBarContainer().setBackgroundResource(2131100548);
        this.d.getTitleBarContainer().getBackground().mutate().setAlpha(0);
        this.d.setOnContentScrollListener(new CommonUiContainer$observeContentScroll$1(this));
        return;
    L12:
        r1 = 8;
        goto L13
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r3 = false;
        goto L10
    }

    public CommonUiContainer(FragmentActivity r2, BaseContainerLayout r3, CommonContainerLayout r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "rootLayout");
        Intrinsics.checkNotNullParameter(r4, "commonLayout");
        super(r2, r3);
        this.d = r4;
        r4.getTitleBarContainer();
        r4.getHeaderContainer();
        r4.getContentContainer();
        this.e = r4.getFooterContainer();
        r4.getContentScrollView();
        this.f = LazyKt.lazy(new CommonUiContainer$titleView$2(this));
        this.g = LazyKt.lazy(new CommonUiContainer$subTitleView$2(this));
        this.h = LazyKt.lazy(new CommonUiContainer$footerButton$2(this));
        Lazy r5 = LazyKt.lazy(new CommonUiContainer$titleBar$2(this));
        this.i = r5;
        ((CommonTitleBar) r5.getValue()).setTitleClickListener(new a(r2));
    }
}
