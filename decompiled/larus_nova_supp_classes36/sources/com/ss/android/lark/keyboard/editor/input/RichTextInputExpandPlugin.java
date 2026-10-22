package com.ss.android.lark.keyboard.editor.input;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.extension.keyboard.config.EnterKeyBehavior;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.keyboard.widget.DragShrinkLayout;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RichTextInputExpandPlugin extends BaseRichTextInputPlugin {
    public final String K;
    public final Fragment L;
    public final Function0<yxa.a> M;
    public final Function0<Unit> N;
    public DragShrinkLayout O;
    public View P;
    public View Q;
    public int R;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.editor.input.RichTextInputExpandPlugin$1, reason: invalid class name */
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
        public final yxa.a m1064invoke() {
            return new yxa.a(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m1064invoke();
        }
    }

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ RichTextInputExpandPlugin a;

        public b(RichTextInputExpandPlugin r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            RichTextInputExpandPlugin.z0(this.a, 0.0f);
            this.a.Q().c(InputSupportType.Text, false);
            DragShrinkLayout r4 = this.a.O;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
            r4 = null;
        L5:
            r4.setDragEnabled(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            DragShrinkLayout r3 = this.a.O;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
            r3 = null;
        L5:
            r3.setDragEnabled(false);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void K() {
        this.A = false;
        A0(false);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final int W() {
        return 2131561729;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin, com.ss.android.lark.keyboard.base.f
    public final void D() {
        int r0 = xob.a.a;
        Context r1 = X().getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        xob.a.b(new Pair[]{new Pair("click", "full_screen"), new Pair("target", "none"), new Pair("action_type", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE), new Pair("keyboard_status", xob.a.a(r1))});
        B0();
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final String k0() {
        if (this.A == false) goto L7;
        return "";
    L7:
        return super.k0();
    }

    public final void B0() {
        com.ss.android.lark.c.c(Q().n());
        DragShrinkLayout r0 = this.O;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r0 = null;
    L5:
        r0.b(new b(this));
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void H() {
        super.H();
        d0();
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void J() {
        super.J();
        Z().setVisibility(0);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText, java.lang.Object] */
    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void a0() {
        super.a0();
        if (((yxa.a) this.M.invoke()).a != EnterKeyBehavior.SEND) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        int r1 = com.ss.android.lark.keyboard.utils.d.a;
        ?? r2 = L();
        Intrinsics.checkNotNullParameter(r2, "editText");
        if (Build.VERSION.SDK_INT < 23) goto L12;
        if (r2.getCustomInsertionActionModeCallback() != null) goto L12;
        r2.setCustomInsertionActionModeCallback(new com.ss.android.lark.keyboard.utils.e(r2));
    L12:
        x0(r0, L());
        KeyboardFunctionEditText r3 = L();
        String r4 = this.K;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "chatId");
        if ((r3 instanceof FlowKeyboardFunctionEditText) == false) goto L16;
        ((FlowKeyboardFunctionEditText) r3).setCurChatId(r4);
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void d0() {
        super.d0();
        B0();
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void p0() {
        super.p0();
        X().setVisibility(8);
        View r0 = this.P;
        DragShrinkLayout r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
        r0 = null;
    L5:
        r0.setVisibility(8);
        DragShrinkLayout r1 = this.O;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
    L9:
        r2.setVisibility(8);
        Q().b().c(true, Direction.Top);
        Q().b().c(true, Direction.TopMiddle);
        return;
    L8:
        r2 = r1;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void t0() {
        EditText r0 = Z();
        LarkFont r1 = LarkFont.HEADLINE;
        zz7.a.d(r0, r1);
        ExtensionEditTextCompatKt.m(Z(), (int) zz7.b.i(getActivity(), r1));
        zz7.a.d(L(), r1);
        ExtensionEditTextCompatKt.m(L(), (int) zz7.b.i(getActivity(), r1));
        ExtensionEditTextCompatKt.m(L(), (int) zz7.b.i(getActivity(), r1));
        KeyboardFunctionEditText r2 = L();
        CodeBlockV2ProcessParams.b r3 = CodeBlockV2ProcessParams.Companion;
        int r4 = (int) zz7.b.h(getActivity(), 6);
        int r5 = zz7.b.g(getActivity(), 8);
        r3.getClass();
        ExtensionEditTextCompatKt.k(r2, CodeBlockV2ProcessParams.b.e(r4, r5));
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return InputSupportType.Post;
    }

    public final void A0(boolean r4) {
        if (r4 == false) goto L5;
        Z().setEnabled(false);
        Z().setTextColor(y9c.d.c(Z().getContext(), 2131106620));
        Z().setSingleLine(true);
        Z().setEllipsize(TextUtils.TruncateAt.END);
        Z().setKeyListener(null);
        return;
    L5:
        Z().setSingleLine(false);
        Z().setMaxHeight(Integer.MAX_VALUE);
        Z().setKeyListener(TextKeyListener.getInstance());
        Z().setEnabled(true ^ this.C);
        Z().setTextColor(y9c.d.c(Z().getContext(), 2131106622));
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void e0(boolean r3) {
        ((ImageView) X().findViewById(2131375942)).setEnabled(r3);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void g(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        ViewGroup r0 = (ViewGroup) r4.findViewById(2131382824);
        r4.findViewById(2131373338);
        final Function0<Unit> r1 = new RichTextInputExpandPlugin$afterViewInit$1(this);
        V().e().of(this).d(com.ss.android.lark.keyboard.event.n.class, new RichTextInputExpandPlugin$doOnImeFullShow$1(r1));
        Context r5 = r4.getContext();
        Z().setTag(2131388363, UIUtils.getString(r5, 2131914262));
        L().setTag(2131388363, UIUtils.getString(r5, 2131914261));
        Y().setTag(2131388363, UIUtils.getString(r5, 2131914263));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void h0(final KeyboardFunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r2, "editor");
        BaseRichTextInputPlugin.r0(r2);
        if (this.H == false) goto L6;
        new RichTextInputExpandPlugin$onEditorSelectOnStart$action$1(this, r2).invoke();
        this.H = false;
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void i0(View r5) {
        Intrinsics.checkNotNullParameter(r5, "rootView");
        this.R = WindowInsetsUtils.b(this.L).a();
        DragShrinkLayout r0 = (DragShrinkLayout) X().findViewById(2131376773);
        this.O = r0;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r0 = null;
    L5:
        r0.setOnClickListener(s.a);
        DragShrinkLayout r2 = this.O;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r2 = null;
    L8:
        r2.setListener(new t(this));
        View r3 = X().findViewById(2131386044);
        this.P = r3;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
        r3 = null;
    L11:
        r3.getLayoutParams().height = DeviceUtils.getScreenHeight(getActivity());
        View r4 = X().findViewById(2131386035);
        this.Q = r4;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("shadowClickCover");
    L15:
        r1.setOnClickListener(new v(this));
        L().setHint(this.a);
        Z().setHint(UIHelper.getString(2131892094));
        r5.setVisibility(8);
        Y().setVisibility(0);
        final ImageView r6 = (ImageView) r5.findViewById(2131375942);
        r6.setImageResource(PluginUtils.b());
        Intrinsics.checkNotNull(r6);
        r6.setOnClickListener(new u(this));
        V().e().of(this).d(cya.h.class, new RichTextInputExpandPlugin$refreshSendUI$1$1(r6, this));
        return;
    L14:
        r1 = r4;
        goto L15
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void n0(com.ss.android.lark.keyboard.base.n r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        cya.a r0 = (cya.a) r5.a(cya.a.c);
        if (r0 != null) goto L5;
        r0 = new cya.a(com.ss.android.lark.widget.richtext.c.a(), "");
    L5:
        String r1 = r0.b;
        RichText r2 = r0.a;
        if (this.A == true) goto L8;
    L9:
        v0(r1);
    L10:
        s0(r2);
        QueryStatusInfo r3 = (QueryStatusInfo) r5.a(QueryStatusInfo.Companion);
        if (r3 == null) goto L13;
        u0(r3);
    L13:
        L().setSelection(L().length());
        if (this.A == false) goto L24;
        cya.i r6 = (cya.i) r5.a(cya.i.h);
        if (r6 == null) goto L20;
        boolean r4 = true;
        if (r6.d != true) goto L20;
    L21:
        if (r4 == false) goto L25;
        Editable r7 = L().getEditableText();
        q.a.getClass();
        r7.setSpan(new p(), 0, L().getEditableText().length(), 33);
        return;
    L25:
        return;
    L20:
        r4 = false;
        goto L21
    L24:
        return;
    L8:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void o0(boolean r6) {
        super.o0(r6);
        X().setVisibility(0);
        A0(this.A);
        DragShrinkLayout r0 = this.O;
        DragShrinkLayout r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r0 = null;
    L5:
        r0.setTranslationY(X().getRootView().getHeight());
        DragShrinkLayout r1 = this.O;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
    L9:
        r2.c(new w(this), Boolean.valueOf(r6));
        Q().b().c(false, Direction.Top);
        Q().b().c(false, Direction.TopMiddle);
        return;
    L8:
        r2 = r1;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void r(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        n(2131561741, 2131382823);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r5) {
        this.C = !r5;
        boolean r2 = false;
        if (this.A == false) goto L5;
        Z().setEnabled(false);
    L13:
        AppCompatEditText r0 = L();
        if (r5 == false) goto L16;
    L17:
        r2 = true;
    L18:
        r0.setEnabled(r2);
        m0(!TextUtils.isEmpty(StringsKt.trim(L().getEditableText())));
        ((ImageView) X().findViewById(2131375942)).setEnabled(r5);
        return;
    L16:
        if (TextUtils.isEmpty(L().getEditableText()) == true) goto L18;
    L5:
        EditText r1 = Z();
        if (r5 == false) goto L8;
    L11:
        boolean r3 = true;
    L12:
        r1.setEnabled(r3);
        goto L13
    L8:
        if (TextUtils.isEmpty(Z().getEditableText()) == false) goto L11;
        r3 = false;
        goto L12
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void y(cya.i r3) {
        Intrinsics.checkNotNullParameter(r3, "replyData");
        this.A = true;
        this.E = r3.g;
        A0(true);
        v0(r3.c);
    }

    public static final void z0(RichTextInputExpandPlugin r4, float r5) {
        int r0 = ColorUtils.compositeColors(UDColorUtils.getAlphaColor(UDColorUtils.getColor(r4.getActivity(), 2131102494), r5), r4.R);
        Activity r1 = r4.L.getActivity();
        View r3 = null;
        if ((r1 instanceof Activity) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        WindowInsetsUtils.c(r1).b(r0);
    L8:
        WindowInsetsUtils.b(r4.L).b(r0);
        View r6 = r4.P;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
    L12:
        Drawable r7 = r3.getBackground();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        ColorDrawable r8 = (ColorDrawable) r7;
        r8.setAlpha((int) (r5 * 256));
        r8.invalidateSelf();
        return;
    L11:
        r3 = r6;
        goto L12
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void v(ReEditInfo r2, cya.i r3) {
        Intrinsics.checkNotNullParameter(r2, "reEditData");
        super.v(r2, r3);
        Z().setVisibility(4);
    }

    public RichTextInputExpandPlugin(com.ss.android.lark.keyboard.editor.f r3, BaseRichTextInputPlugin.b r4, String r5, Fragment r6, Function0 r7) {
        Intrinsics.checkNotNullParameter("", "hint");
        Intrinsics.checkNotNullParameter(r3, "onSendPostCallback");
        Intrinsics.checkNotNullParameter(r5, "curChatId");
        Intrinsics.checkNotNullParameter(r6, "applyInsetsFragment");
        Intrinsics.checkNotNullParameter(r7, "keyboardConfigProvider");
        super(r3, r4, r6);
        this.K = r5;
        this.L = r6;
        this.M = r7;
        this.N = RichTextInputExpandPlugin$actionOnStartAnimEnd$1.INSTANCE;
    }
}
