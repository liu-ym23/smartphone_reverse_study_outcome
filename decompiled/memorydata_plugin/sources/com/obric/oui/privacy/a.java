package com.obric.oui.privacy;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Size;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.c.e;
import com.obric.oui.common.util.h;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J8\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u001a\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\fJ(\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\u0019H\u0002J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/oui/privacy/OPrivacySheet;", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/oui/privacy/OPrivacySheetConfig;", "(Landroid/content/Context;Lcom/obric/oui/privacy/OPrivacySheetConfig;)V", "listener", "Lcom/obric/oui/privacy/OPrivacySheetListener;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "buildBodyView", "Landroid/view/View;", "buildDescView", "Lcom/obric/oui/text/OTextView;", "buildFooterView", "buildHeaderView", "descView", "createSingleButton", "Lcom/obric/oui/button/OButton;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "styleRes", "", "onClickListener", "Lkotlin/Function1;", "", "dismiss", "dismissImmediately", "getHeaderLayoutRemovePadding", "windowSize", "Landroid/util/Size;", "getSheet", "setHeaderPadding", "windowHeightDp", "header", "shouldRemovePadding", "setListener", "show", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0769a f14377a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14378b;
    private final com.obric.oui.privacy.b c;
    private OSheet d;
    private RecyclerView e;
    private com.obric.oui.privacy.c f;

    /* JADX INFO: renamed from: com.obric.oui.privacy.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/privacy/OPrivacySheet$Companion;", "", "()V", "DEFAULT_FADE_EDGE_DP", "", "MAX_SMALL_WINDOW_HEIGHT", "TEXT_CONTAINER_HORIZONTAL_MARGIN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0769a {
        private C0769a() {
        }

        public /* synthetic */ C0769a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/oui/privacy/OPrivacySheet$buildBodyView$2$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends RecyclerView.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView f14380b;

        b(a r1, PrivacyTopDownAlphaMaskRecyclerView r2) {
            this.f14379a = r1;
            this.f14380b = r2;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r2, View r3, RecyclerView r4, RecyclerView.s r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            int r6 = r4.getChildAdapterPosition(r3);
            if (r6 <= 0) goto L15;
            com.obric.oui.privacy.d r7 = (com.obric.oui.privacy.d) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(a.c(this.f14379a).d(), r6), com.obric.oui.privacy.d.class, "com.obric.memorydata.plugin");
            com.obric.oui.privacy.d r8 = (com.obric.oui.privacy.d) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(a.c(this.f14379a).d(), r6 - 1), com.obric.oui.privacy.d.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L11;
            if (r8 == null) goto L11;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r7.getClass()), Reflection.getOrCreateKotlinClass(r8.getClass())) == true) goto L11;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14380b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r1, "context");
            int r9 = h.a(r1, 16);
        L13:
            r2.top = r9;
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.privacy.d.b.class) == false) goto L16;
            r9 = 0;
            goto L13
        L16:
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/oui/privacy/OPrivacySheet$buildFooterView$policyTextView$1$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14382b;
        final /* synthetic */ OTextView c;

        c(a r1, String r2, OTextView r3) {
            this.f14381a = r1;
            this.f14382b = r2;
            this.c = r3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            com.obric.oui.privacy.c r3 = a.a(this.f14381a);
            if (r3 == null) goto L7;
            r3.a(this.f14382b);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r4) {
            Intrinsics.checkNotNullParameter(r4, "ds");
            super.updateDrawState(r4);
            r4.setColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6")));
            r4.setUnderlineText(false);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/privacy/OPrivacySheet$show$oSheet$1$3", "Lcom/obric/oui/dialog/DialogExtInterface$OnConfigurationListener;", "onConfigurationChanged", "", "dialog", "Landroid/app/Dialog;", "configuration", "Landroid/content/res/Configuration;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements com.obric.oui.dialog.a.InterfaceC0745a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f14384b;
        final /* synthetic */ int c;

        d(a r1, View r2, int r3) {
            this.f14383a = r1;
            this.f14384b = r2;
            this.c = r3;
        }

        @Override // com.obric.oui.dialog.a.InterfaceC0745a
        public void a(Dialog r6, Configuration r7) {
            Intrinsics.checkNotNullParameter(r6, "dialog");
            Intrinsics.checkNotNullParameter(r7, "configuration");
            a r8 = this.f14383a;
            int r0 = r7.screenHeightDp;
            View r1 = this.f14384b;
            a.a(r8, r0, r1, com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), this.c);
            RecyclerView r5 = a.b(this.f14383a);
            if (r5 != null) goto L6;
            return;
        L6:
            if (r7.screenHeightDp <= 650) goto L8;
            r5.setPadding(0, h.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), 16), 0, h.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), 16));
            return;
        L8:
            r5.setPadding(0, 0, 0, 0);
        }
    }

    static {
        f14377a = new C0769a(null);
    }

    public a(Context r3, com.obric.oui.privacy.b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        this.f14378b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
    }

    private final int a(Size r3, OTextView r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        r4.measure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(r3.getWidth() - (h.a(this.f14378b, 32) * 2), 0), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (RangesKt.coerceAtLeast(r4.getLineCount(), 1) - 1) * r4.getLineHeight();
    }

    private final View a(OTextView r15) {
        LinearLayout r0 = new LinearLayout(this.f14378b);
        r0.setOrientation(1);
        r0.setGravity(1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        OImageAppIcon r2 = new OImageAppIcon(this.f14378b, null, 0, 6, null);
        int r5 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_image_size_xl, "dimen", "oui_image_size_xl"));
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r5, r5), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(this.c.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        r2.setImagePackageName(this.c.a());
    L11:
        r0.addView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        LinearLayout r3 = new LinearLayout(this.f14378b);
        r3.setOrientation(1);
        r3.setGravity(1);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        r8.leftMargin = h.a(r4, 32);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "context");
        r8.rightMargin = h.a(r9, 32);
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        r8.topMargin = h.a(r10, 20);
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        OTextView r11 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(this.f14378b, ZeusTransformUtils.mapRes(R.style.Title_4_Bold, "style", "Title_4_Bold")), Context.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null);
        r11.setIncludeFontPadding(true);
        r11.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.c.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        r11.setGravity(17);
        r11.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r3.addView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
        if (r15 == null) goto L14;
        r3.addView((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"));
    L14:
        r0.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r7 = false;
        goto L9
    }

    private final OButton a(Context r2, String r3, int r4, Function1<? super View, Unit> r5) {
        return (OButton) ZeusTransformUtils.preCheckCast(e.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r4, (Function3) ZeusTransformUtils.preCheckCast(new OPrivacySheet$createSingleButton$1(r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin")), Function3.class, "com.obric.memorydata.plugin")), OButton.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ com.obric.oui.privacy.c a(a r0) {
        return r0.f;
    }

    private final void a(int r2, View r3, Size r4, int r5) {
        if (r2 <= 650) goto L5;
        int r6 = (int) (r4.getHeight() * 0.135f);
        int r7 = (int) ((r4.getHeight() * 0.10375f) - r5);
    L6:
        r3.setPadding(0, r6, 0, r7);
        return;
    L5:
        r6 = h.a(r3, 20);
        r7 = h.a(r3, 12);
        goto L6
    }

    public static final /* synthetic */ void a(a r0, int r1, View r2, Size r3, int r4) {
        r0.a(r1, r2, r3, r4);
    }

    private static final void a(a r2, DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        com.obric.oui.privacy.c r5 = r2.f;
        if (r5 == null) goto L7;
        r5.c();
        return;
    }

    private static final boolean a(a r2, DialogInterface r3, int r4, KeyEvent r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r4 == 4) goto L5;
    L16:
        return false;
    L5:
        if (r5 != null) goto L8;
    L6:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L16;
        com.obric.oui.privacy.c r8 = r2.f;
        if (r8 == null) goto L15;
        r8.d();
    L15:
        return true;
    L8:
        if (r5.getAction() != 1) goto L6;
        r7 = true;
        goto L10
    }

    public static final /* synthetic */ RecyclerView b(a r0) {
        return r0.e;
    }

    public static final /* synthetic */ com.obric.oui.privacy.b c(a r0) {
        return r0.c;
    }

    private final OTextView e() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.c.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L15;
        OTextView r2 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(this.f14378b, ZeusTransformUtils.mapRes(R.style.Body_1_Regular, "style", "Body_1_Regular")), Context.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null);
        r2.setIncludeFontPadding(true);
        r2.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.c.c(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.ENGLISH.getLanguage()) == false) goto L13;
        int r10 = 17;
    L14:
        r2.setGravity(r10);
        r2.setMaxLines(3);
        r2.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        r11.topMargin = h.a(r3, 8);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return r2;
    L13:
        r10 = GravityCompat.START;
        goto L14
    L15:
        return null;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final View f() {
        int r0 = h.a(this.f14378b, com.obric.oui.window.a.d(this.f14378b).getHeight());
        FrameLayout r1 = new FrameLayout(this.f14378b);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -1);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        r2.bottomMargin = h.a(r4, 8);
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        PrivacyTopDownAlphaMaskRecyclerView r3 = new PrivacyTopDownAlphaMaskRecyclerView(this.f14378b, null, 0, 6, null);
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (r0 <= 650) goto L5;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        int r6 = h.a(r5, 16);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        r3.setPadding(0, r6, 0, h.a(r7, 16));
    L6:
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        r3.setFadeEdgeLength(h.b(r8, 75));
        r3.setFadeTop(true);
        r3.setFadeBottom(true);
        r3.setDynamicFade(true);
        r3.setBackgroundColor(0);
        r3.setClipToPadding(false);
        r3.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        r3.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(new com.obric.oui.privacy.adapter.b(this.c.d()), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r3.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new b(this, r3), RecyclerView.g.class, "com.obric.memorydata.plugin"));
        RecyclerView r9 = (RecyclerView) ZeusTransformUtils.preCheckCast(r3, RecyclerView.class, "com.obric.memorydata.plugin");
        this.e = r9;
        r1.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    L5:
        r3.setPadding(0, 0, 0, 0);
        goto L6
    }

    private final View g() {
        LinearLayout r1 = new LinearLayout(this.f14378b);
        r1.setOrientation(1);
        r1.setGravity(1);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        int r4 = h.a(r3, 20);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "context");
        int r10 = h.a(r9, 16);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        int r8 = h.a(r11, 20);
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        r1.setPadding(r4, r10, r8, h.a(r12, 8));
        if (this.c.e() == null) goto L17;
        OTextView r5 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(this.f14378b, ZeusTransformUtils.mapRes(R.style.Button_1_Regular, "style", "Button_1_Regular")), Context.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r5.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
        r5.setGravity(GravityCompat.START);
        String r13 = this.c.e();
        List<String> r14 = this.c.f();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        SpannableString r15 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
        Iterator<String> r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L14;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        int r18 = 0;
    L10:
        int r19 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), r17, r18, false, 4, null);
        if (r19 < 0) goto L8;
        int r110 = r17.length() + r19;
        r15.setSpan(new c(this, r17, r5), r19, r110, 33);
        r18 = r110;
        goto L10
    L14:
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
        r5.setMovementMethod(LinkMovementMethod.getInstance());
        r5.setHighlightColor(0);
    L16:
        r1.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
        goto L17
    L15:
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
    L17:
        LinearLayout r6 = new LinearLayout(this.f14378b);
        r6.setOrientation(1);
        r6.setGravity(1);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -2);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        r2.topMargin = h.a(r7, 14);
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        Context r20 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r20, "context");
        int r21 = h.a(r20, 4);
        Context r22 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r22, "context");
        r6.setPadding(r21, 0, h.a(r22, 4), 0);
        Context r23 = this.f14378b;
        String r24 = this.c.g();
        if (r24 != null) goto L20;
        r24 = this.f14378b.getString(ZeusTransformUtils.mapRes(R.string.oui_agree, TypedValues.Custom.S_STRING, "oui_agree"));
        Intrinsics.checkNotNullExpressionValue(r24, "context.getString(R.string.oui_agree)");
    L20:
        r6.addView((View) ZeusTransformUtils.preCheckCast(a(r23, r24, ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Primary, "style", "OStyleV2_OButton_L_Standard_Primary"), (Function1) ZeusTransformUtils.preCheckCast(new OPrivacySheet$buildFooterView$agreeButton$1(this), Function1.class, "com.obric.memorydata.plugin")), View.class, "com.obric.memorydata.plugin"));
        Context r25 = this.f14378b;
        String r26 = this.c.h();
        if (r26 != null) goto L23;
        r26 = this.f14378b.getString(ZeusTransformUtils.mapRes(R.string.oui_exit, TypedValues.Custom.S_STRING, "oui_exit"));
        Intrinsics.checkNotNullExpressionValue(r26, "context.getString(R.string.oui_exit)");
    L23:
        OButton r0 = a(r25, r26, ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Trans_Neutral, "style", "OStyleV2_OButton_L_Trans_Neutral"), (Function1) ZeusTransformUtils.preCheckCast(new OPrivacySheet$buildFooterView$exitButton$1(this), Function1.class, "com.obric.memorydata.plugin"));
        LinearLayout.LayoutParams r27 = new LinearLayout.LayoutParams(-1, -2);
        Context r28 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r28, "context");
        r27.topMargin = h.a(r28, 12);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r27, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6.addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        r1.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$nYlfaoU4El5xDVm-9rZX72rOzHM, reason: not valid java name */
    public static /* synthetic */ void m1344lambda$nYlfaoU4El5xDVm9rZX72rOzHM(a r0, DialogInterface r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$x3Ta2fWusl8OI_dCL6q0NV5d-3E, reason: not valid java name */
    public static /* synthetic */ boolean m1345lambda$x3Ta2fWusl8OI_dCL6q0NV5d3E(a r0, DialogInterface r1, int r2, KeyEvent r3) {
        return a(r0, r1, r2, r3);
    }

    public final a a() {
        OSheet r8 = new OSheet(this.f14378b, 0, 0, false, false, 14, null);
        r8.a(OSheet.HeightMode.FULL_HEIGHT);
        r8.setCanceledOnTouchOutside(false);
        r8.setCancelable(false);
        r8.b(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_bg_base_2, TypedValues.Custom.S_COLOR, "oui_bg_base_2")));
        OTextView r0 = e();
        View r2 = a(r0);
        Size r3 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        int r5 = h.a(r4, r3.getHeight());
        int r1 = a(r3, r0);
        a(r5, r2, r3, r1);
        r8.b(r2);
        r8.c(f());
        r8.d(g());
        r8.e(!this.c.i());
        r8.setOnDismissListener(new $$Lambda$a$nYlfaoU4El5xDVm9rZX72rOzHM(this));
        if (this.c.j() == false) goto L5;
        r8.setOnKeyListener(new $$Lambda$a$x3Ta2fWusl8OI_dCL6q0NV5d3E(this));
    L5:
        r8.a((com.obric.oui.dialog.a.InterfaceC0745a) ZeusTransformUtils.preCheckCast(new d(this, r2, r1), com.obric.oui.dialog.a.InterfaceC0745a.class, "com.obric.memorydata.plugin"));
        this.d = r8;
        r8.b(this.c.k());
        r8.show();
        return this;
    }

    public final a a(com.obric.oui.privacy.c r3) {
        com.obric.oui.privacy.c r4 = (com.obric.oui.privacy.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.privacy.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f = r4;
        return this;
    }

    public final void b() {
        OSheet r0 = this.d;     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        r0.dismiss();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final void c() {
        OSheet r0 = this.d;     // Catch: Exception -> L7
        if (r0 == null) goto L10;
        r0.h();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final OSheet d() {
        return this.d;
    }
}
