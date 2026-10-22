package com.ss.android.lark.keyboard.editor.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.ui.ViewTransitionContainer;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.extension.keyboard.config.EnterKeyBehavior;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiEmbeddedUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.base.IKeyboardSwitcherPlugin;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiconTextView;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RichTextInputShrinkPlugin extends BaseRichTextInputPlugin implements k {
    public final boolean K;
    public final boolean L;
    public final String M;
    public final boolean N;
    public final Fragment O;
    public final Function0<yxa.a> P;
    public LinearLayout Q;
    public ImageView R;
    public View S;
    public EllipsizedEmojiconTextView T;
    public ViewTransitionContainer<EllipsizedEmojiconTextView> U;
    public IKeyboardSwitcherPlugin V;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.editor.input.RichTextInputShrinkPlugin$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/config/KeyboardConfig;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    final class AnonymousClass1 extends Lambda implements Function0<yxa.a> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final yxa.a m1068invoke() {
            return new yxa.a(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m1068invoke();
        }
    }

    public static final class a {
    }

    public static final class b implements rcc.d {
        public final /* synthetic */ RichTextInputShrinkPlugin a;

        public b(RichTextInputShrinkPlugin r1) {
            this.a = r1;
        }

        public final void a(int r2, int r3, int r4) {
            if (r2 == r3) goto L8;
            RichTextInputShrinkPlugin r5 = this.a;
            CharSequence r6 = r5.c0(r5.a);
            if (Intrinsics.areEqual(r6, this.a.a) == false) goto L6;
            this.a.I(r6);
            return;
        L6:
            float r7 = ((this.a.L().getMeasuredWidth() - this.a.L().getPaddingLeft()) - this.a.L().getPaddingRight()) - 1.0f;
            o r8 = this.a.U();
            Lazy r0 = PluginUtils.a;
            r8.a(0, PluginUtils.a(r6, this.a.L().getPaint(), r7));
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final int W() {
        return 2131561730;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void e0(boolean r1) {
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin, com.ss.android.lark.keyboard.base.f
    public final void D() {
        int r0 = xob.a.a;
        Context r1 = X().getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        xob.a.b(new Pair[]{new Pair("click", "full_screen"), new Pair("target", "none"), new Pair("action_type", "open"), new Pair("keyboard_status", xob.a.a(r1))});
        Q().c(InputSupportType.Post, false);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void K() {
        if (this.A == true) goto L5;
        return;
    L5:
        this.A = false;
        LinearLayout r0 = this.Q;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("replyRegion");
        r0 = null;
    L8:
        r0.setVisibility(8);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void J() {
        super.J();
        A0(false);
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText, java.lang.Object] */
    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void a0() {
        super.a0();
        boolean r1 = false;
        L().setPadding(0, 0, 0, 0);
        L().setOnSizeChangeListener(new b(this));
        if ((X().getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L6;
        View r0 = X();
        ViewGroup.LayoutParams r2 = X().getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        r3.gravity = 80;
        r0.setLayoutParams(r3);
    L6:
        if (((yxa.a) this.P.invoke()).a != EnterKeyBehavior.SEND) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L14;
        int r4 = com.ss.android.lark.keyboard.utils.d.a;
        ?? r5 = L();
        Intrinsics.checkNotNullParameter(r5, "editText");
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r5.getCustomInsertionActionModeCallback() != null) goto L14;
        r5.setCustomInsertionActionModeCallback(new com.ss.android.lark.keyboard.utils.e(r5));
    L14:
        x0(r1, L());
        L().setMaxHeight(L().getLineHeight() * 4);
        ExtensionEditTextCompatKt.o(L(), this.L);
        KeyboardFunctionEditText r6 = L();
        String r7 = this.M;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "chatId");
        if ((r6 instanceof FlowKeyboardFunctionEditText) == false) goto L18;
        ((FlowKeyboardFunctionEditText) r6).setCurChatId(r7);
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void b0() {
        super.b0();
        ExtensionEditTextCompatKt.o(Z(), false);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void g0() {
        super.g0();
        com.ss.android.lark.c.c(Q().n());
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void p0() {
        super.p0();
        final com.ss.android.lark.keyboard.b r0 = Q().n();
        com.ss.android.lark.keyboard.ime.a r1 = r0.z();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        boolean r3 = r0 instanceof BasicKeyboard;
        int r4 = 0;
        if (r3 == false) goto L5;
        int r5 = ((BasicKeyboard) r0).f.f.getHeight();
    L6:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r3 == false) goto L9;
        r4 = ((BasicKeyboard) r0).T().getHeight();
    L9:
        final int r6 = r5 + r4;
        Function0<Unit> r2 = new RichTextInputShrinkPlugin$notifyHeightChangeOnAnimEnd$action$1(r0, r6);
        com.ss.android.lark.keyboard.ime.c r7 = r1.v(this);
        if (r1.y() == false) goto L13;
        r7.g(r2);
    L13:
        if (r1.B() == false) goto L16;
        r7.e(r2);
        return;
    L16:
        return;
    L5:
        r5 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void t0() {
        EditText r0 = Z();
        LarkFont r1 = LarkFont.HEADLINE;
        zz7.a.d(r0, r1);
        ExtensionEditTextCompatKt.m(Z(), (int) zz7.b.i(getActivity(), r1));
        zz7.a.d(L(), r1);
        ExtensionEditTextCompatKt.m(L(), zz7.b.g(getActivity(), 19));
        ExtensionEditTextCompatKt.m(L(), (int) zz7.b.i(getActivity(), r1));
        zz7.a.a(Y(), 24);
        TextView r2 = this.T;
        EmojiconTextView r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r2 = null;
    L5:
        zz7.a.d(r2, LarkFont.BODY1);
        EmojiconTextView r4 = this.T;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
    L9:
        r3.setEmojiconSize(zz7.b.g(getActivity(), 16));
        KeyboardFunctionEditText r5 = L();
        CodeBlockV2ProcessParams.b r6 = CodeBlockV2ProcessParams.Companion;
        int r7 = (int) zz7.b.h(getActivity(), 6);
        int r8 = zz7.b.g(getActivity(), 8);
        r6.getClass();
        ExtensionEditTextCompatKt.k(r5, CodeBlockV2ProcessParams.b.e(r7, r8));
        return;
    L8:
        r3 = r4;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void u() {
        boolean r1 = true;
        if (Z().getEditableText().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        Z().setVisibility(8);
        L().setSelection(0);
        if (L().getEditableText().length() > 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L15;
        BaseRichTextInputPlugin.r0(L());
        return;
    L15:
        return;
    L13:
        Z().setVisibility(0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return InputSupportType.Text;
    }

    public final void A0(boolean r5) {
        LinearLayout r0 = this.Q;
        ViewTransitionContainer<EllipsizedEmojiconTextView> r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("replyRegion");
        r0 = null;
    L6:
        if (r5 == false) goto L8;
        int r6 = 0;
    L9:
        r0.setVisibility(r6);
        View r7 = this.S;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("closeReplyLeftDivider");
        r7 = null;
    L12:
        r7.setVisibility(8);
        final String r8 = UIUtils.getString(this.O.requireContext(), 2131889986);
        EmojiconTextView r2 = this.T;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r2 = null;
    L15:
        r2.setTranslateEmojiCode(false);
        ViewTransitionContainer<EllipsizedEmojiconTextView> r3 = this.U;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTVTransitionContainer");
    L19:
        Function1<EllipsizedEmojiconTextView, Unit> r4 = new RichTextInputShrinkPlugin$showReEditView$1(r8);
        int r9 = ViewTransitionContainer.g;
        r1.update(true, r4);
        return;
    L18:
        r1 = r3;
        goto L19
    L8:
        r6 = 8;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin, com.ss.android.lark.keyboard.base.f
    public final void I(CharSequence r4) {
        Intrinsics.checkNotNullParameter(r4, "hint");
        if (this.G == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.a = r4;
        float r0 = ((L().getMeasuredWidth() - L().getPaddingLeft()) - L().getPaddingRight()) - 1.0f;
        o r1 = U();
        Lazy r2 = PluginUtils.a;
        r1.a(0, PluginUtils.a(r4, L().getPaint(), r0));
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void g(View r5) {
        Intrinsics.checkNotNullParameter(r5, "rootView");
        ViewGroup r0 = (ViewGroup) r5.findViewById(2131375390);
        V().z().v(this).c(new RichTextInputShrinkPlugin$setupFocusCleaner$1(this));
        Intrinsics.checkNotNull(r0);
        r0.setMinimumHeight(0);
        r0.findViewById(2131382379).setVisibility(8);
        Context r6 = r5.getContext();
        Z().setTag(2131388363, UIUtils.getString(r6, 2131914278));
        L().setTag(2131388363, UIUtils.getString(r6, 2131914277));
        Y().setTag(2131388363, UIUtils.getString(r6, 2131914279));
        Y().setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void h0(final KeyboardFunctionEditText r3) {
        Intrinsics.checkNotNullParameter(r3, "editor");
        Intrinsics.checkNotNullParameter(r3, "editor");
        if (r3.getEditableText().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        BaseRichTextInputPlugin.r0(r3);
    L9:
        if (this.H == false) goto L12;
        new RichTextInputShrinkPlugin$onEditorSelectOnStart$action$1(this, r3).invoke();
        this.H = false;
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void i0(View r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Z().setHint(UIHelper.getString(2131892094));
        I(c0(this.a));
        if ((r3.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L6;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        r1.gravity = 80;
        r3.setLayoutParams(r1);
    L6:
        if (this.K == false) goto L8;
        Y().setVisibility(8);
    L8:
        z0(r3);
        r3.setOnClickListener(c.a);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.k
    public final void l(IKeyboardSwitcherPlugin r2) {
        Intrinsics.checkNotNullParameter(r2, "switcher");
        this.V = r2;
        z0(X());
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void n0(com.ss.android.lark.keyboard.base.n r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        cya.a r0 = (cya.a) r6.a(cya.a.c);
        if (r0 == null) goto L6;
        RichText r1 = r0.a;
        if (r1 == null) goto L6;
    L7:
        if (r0 == null) goto L10;
        String r2 = r0.b;
        if (r2 == null) goto L10;
    L11:
        v0(r2);
        s0(r1);
        QueryStatusInfo r3 = (QueryStatusInfo) r6.a(QueryStatusInfo.Companion);
        if (r3 == null) goto L14;
        u0(r3);
    L14:
        L().setSelection(L().length());
        cya.i.a r4 = cya.i.h;
        cya.i r5 = (cya.i) r6.a(r4);
        boolean r7 = true;
        if (r5 != null) goto L17;
    L19:
        boolean r8 = false;
    L21:
        if (this.A == false) goto L31;
        cya.i r9 = (cya.i) r6.a(r4);
        if (r9 != null) goto L25;
    L27:
        r7 = false;
    L28:
        if (r7 == false) goto L31;
        if (r8 == true) goto L31;
        Editable r10 = L().getEditableText();
        q.a.getClass();
        r10.setSpan(new p(), 0, L().getEditableText().length(), 33);
        goto L31
    L25:
        if (r9.d != true) goto L27;
    L31:
        w0();
        return;
    L17:
        if (r5.e != true) goto L19;
        r8 = true;
    L10:
        r2 = "";
    L6:
        r1 = com.ss.android.lark.widget.richtext.c.a();
        goto L7
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void o0(boolean r1) {
        super.o0(r1);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin, com.ss.android.lark.keyboard.base.c
    public final void onConfigurationChanged(Configuration r8) {
        Intrinsics.checkNotNullParameter(r8, "newConfig");
        Activity r0 = V().l().getContext();
        boolean r2 = false;
        if (r8.screenHeightDp <= 900.0f) goto L5;
        boolean r1 = true;
    L6:
        int r5 = r8.orientation;
        if (DeviceUtils.isPad() == false) goto L11;
        if (r5 != 1) goto L11;
        if (r1 == false) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
    L16:
        int r4 = r8.orientation;
        int r9 = r8.screenHeightDp;
        if (r9 <= 900.0f) goto L19;
        boolean r6 = true;
    L21:
        if (DeviceUtils.isPad() == false) goto L25;
        if (r4 != 1) goto L25;
        if (r6 == false) goto L25;
        r2 = true;
    L25:
        if (r2 == false) goto L27;
        int r7 = 6;
    L28:
        int r10 = L().getLineHeight();
        Log.i("RichTextInputShrinkPlugin", "setMaxHeight, appHeightInDp: " + r9 + ", isLargeScreen: " + r6 + ", maxLines: " + r7);
        L().setMaxHeight(r10 * r7);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.chat.input_bg_config_change_fix.reverse") == true) goto L37;
        Lazy r11 = ForsetiConfig.a;
        if (ForsetiConfig.a(getActivity()) == false) goto L33;
        return;
    L33:
        if (ForsetiEmbeddedUtils.b() == false) goto L39;
        X().post(new y(this));
        return;
    L39:
        return;
    L37:
        return;
    L27:
        r7 = 4;
        goto L28
    L19:
        r6 = false;
        goto L21
    L14:
        if (V().z().y() == false) goto L16;
        KeyboardUtils.showKeyboard(r0);
    L11:
        r3 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void r(View r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        n(2131561743, 2131375383);
        this.Q = (LinearLayout) X().findViewById(2131377591);
        LinearLayout r4 = (LinearLayout) X().findViewById(2131377590);
        this.R = (ImageView) X().findViewById(2131364683);
        this.S = X().findViewById(2131369251);
        ImageView r0 = null;
        if (PluginUtils.c() == false) goto L8;
        View r5 = this.S;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("closeReplyLeftDivider");
        r5 = null;
    L7:
        r5.setBackgroundResource(2131102046);
    L8:
        this.T = X().findViewById(2131391327);
        ViewTransitionContainer<EllipsizedEmojiconTextView> r6 = X().findViewById(2131391328);
        this.U = r6;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTVTransitionContainer");
        r6 = null;
    L11:
        r6.setTransitionType(ViewTransitionContainer.TransitionType.SLIDING_DOWN_FADE);
        ImageView r7 = this.R;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("closeReplyBtn");
    L15:
        r0.setOnClickListener(new x(this));
        return;
    L14:
        r0 = r7;
        goto L15
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r5) {
        this.C = !r5;
        boolean r0 = true;
        if (r5 == false) goto L5;
    L11:
        boolean r2 = true;
    L12:
        L().setEnabled(r2);
        if (r5 == false) goto L15;
    L21:
        boolean r3 = true;
    L22:
        Z().setEnabled(r3);
        if (StringsKt.trim(L().getEditableText().toString()).toString().length() <= 0) goto L25;
        boolean r4 = true;
    L27:
        if (StringsKt.trim(Z().getEditableText().toString()).toString().length() <= 0) goto L29;
        boolean r6 = true;
    L30:
        if (r4 == true) goto L34;
        if (r6 == true) goto L34;
        r0 = false;
    L34:
        m0(r0);
        Y().setEnabled(r5);
        return;
    L29:
        r6 = false;
        goto L30
    L25:
        r4 = false;
        goto L27
    L15:
        if (Z().getEditableText().length() <= 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L21;
        r3 = false;
        goto L22
    L17:
        r7 = false;
        goto L18
    L5:
        if (L().getEditableText().length() <= 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r8 = false;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void y(cya.i r11) {
        Intrinsics.checkNotNullParameter(r11, "replyData");
        this.A = true;
        this.E = r11.g;
        View r1 = this.S;
        ViewTransitionContainer<EllipsizedEmojiconTextView> r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("closeReplyLeftDivider");
        r1 = null;
    L5:
        r1.setVisibility(0);
        if (r11.f == true) goto L8;
    L13:
        final CharSequence r12 = r11.c;
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        EmojiconTextView r3 = this.T;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r3 = null;
    L19:
        r3.setTranslateEmojiCode(false);
        SpannableStringBuilder r4 = new SpannableStringBuilder(r12);
        Iterator r5 = ArrayIteratorKt.iterator((ncc.e[]) r4.getSpans(0, r4.length(), ncc.e.class));
    L21:
        if (r5.hasNext() == false) goto L33;
        ncc.e r6 = (ncc.e) r5.next();
        EllipsizedEmojiconTextView r7 = this.T;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r7 = null;
    L25:
        r6.a(new z(this, r7));
        Bitmap r8 = r6.b;
        if (r8 == null) goto L31;
        Paint r9 = new Paint();
        TextView r10 = this.T;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r10 = null;
    L30:
        r9.setColorFilter(new PorterDuffColorFilter(r10.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        Bitmap r13 = Bitmap.createBitmap(r8.getWidth(), r8.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNull(r13);
        new Canvas(r13).drawBitmap(r8, 0.0f, 0.0f, r9);
    L32:
        r6.b = r13;
        goto L21
    L31:
        r13 = null;
        goto L32
    L33:
        ViewTransitionContainer<EllipsizedEmojiconTextView> r14 = this.U;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTVTransitionContainer");
    L37:
        Function1<EllipsizedEmojiconTextView, Unit> r15 = new RichTextInputShrinkPlugin$showReplyView$2(r12);
        int r16 = ViewTransitionContainer.g;
        r2.update(true, r15);
        return;
    L36:
        r2 = r14;
        goto L37
    L8:
        if (this.N == true) goto L13;
        LinearLayout r17 = this.Q;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("replyRegion");
        r17 = null;
    L12:
        r17.setVisibility(0);
        goto L13
    }

    public final void z0(View r6) {
        ConstraintLayout r7 = r6.findViewById(2131387954);
        if (this.V != null) goto L5;
        r7.setVisibility(8);
        return;
    L5:
        r7.setVisibility(0);
        IKeyboardSwitcherPlugin r1 = this.V;
        if (r1 == null) goto L10;
        getActivity();
        Intrinsics.checkNotNull(r7);
        View r2 = r1.a();
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(-2, -2);
        r3.startToStart = 0;
        r3.endToEnd = 0;
        r3.bottomToBottom = 0;
        r7.addView(r2, r3);
        r1.b();
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void v(ReEditInfo r2, cya.i r3) {
        Intrinsics.checkNotNullParameter(r2, "reEditData");
        super.v(r2, r3);
        A0(true);
    }

    public RichTextInputShrinkPlugin(com.ss.android.lark.keyboard.editor.f r3, BaseRichTextInputPlugin.b r4, boolean r5, boolean r6, String r7, boolean r8, Fragment r9, Function0 r10) {
        Intrinsics.checkNotNullParameter("", "hint");
        Intrinsics.checkNotNullParameter(r3, "sendPostCallback");
        Intrinsics.checkNotNullParameter(r7, "curChatId");
        Intrinsics.checkNotNullParameter(r9, "host");
        Intrinsics.checkNotNullParameter(r10, "keyboardConfigProvider");
        super(r3, r4, r9);
        this.K = r5;
        this.L = r6;
        this.M = r7;
        this.N = r8;
        this.O = r9;
        this.P = r10;
    }
}
