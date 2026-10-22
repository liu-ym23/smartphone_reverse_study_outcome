package com.ss.android.lark.inline.ai.ui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.component.ui.imageview.LKUILottieAnimationView;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.inline.ai.api.MentionType;
import com.ss.android.lark.inline.ai.api.ui.DragBar;
import com.ss.android.lark.inline.ai.api.ui.Feedback;
import com.ss.android.lark.inline.ai.api.ui.History;
import com.ss.android.lark.inline.ai.api.ui.Images;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.inline.ai.api.ui.Input;
import com.ss.android.lark.inline.ai.api.ui.Operates;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import com.ss.android.lark.inline.ai.api.ui.Prompts;
import com.ss.android.lark.inline.ai.api.ui.Range;
import com.ss.android.lark.inline.ai.api.ui.TextContentList;
import com.ss.android.lark.inline.ai.api.ui.Tips;
import com.ss.android.lark.inline.ai.ui.images.InlineAIImageRecyclerView;
import com.ss.android.lark.inline.ai.ui.operates.OperatesRecyclerView;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView;
import com.ss.android.lark.inline.ai.ui.richtext.AIPreviewData;
import com.ss.android.lark.inline.ai.ui.richtext.RichtextPreviewWebview;
import com.ss.android.lark.inline.ai.ui.view.InlineEditTextFunctionImpl$insertUrl$1;
import com.ss.android.lark.inline.ai.ui.view.URLRecognition;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.m0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InlineAIPanelController implements com.ss.android.lark.inline.ai.ui.b {
    public static final /* synthetic */ int X = 0;
    public final ViewGroup A;
    public final AppCompatImageView B;
    public final LKUILottieAnimationView C;
    public final InlineAIEditText D;
    public final AppCompatImageView E;
    public final AppCompatImageView F;
    public final ViewGroup G;
    public final AppCompatImageView H;
    public final View I;
    public final com.ss.android.lark.inline.ai.ui.view.c J;
    public final ViewGroup K;
    public final TextView L;
    public final AppCompatImageView M;
    public InlineAIImageRecyclerView N;
    public InlineAIPanel O;
    public final Lazy P;
    public boolean Q;
    public final Lazy R;
    public final InlineAIDragView S;
    public final g T;
    public final StateFlowImpl U;
    public final LifecycleCoroutineScope V;
    public RichtextPreviewWebview W;
    public final wlb.h a;
    public final wlb.e b;
    public final nsb.b c;
    public final Lazy d;
    public final ConstraintLayout e;
    public final View f;
    public final View g;
    public final PanelView h;
    public final ViewGroup i;
    public final ViewGroup j;
    public final TextView k;
    public final ViewGroup l;
    public final ViewGroup m;
    public final AppCompatImageView n;
    public final TextView o;
    public final AppCompatImageView p;
    public final ViewGroup q;
    public final ViewGroup r;
    public final FrameLayout s;
    public final ViewGroup t;
    public final AppCompatImageView u;
    public final AppCompatImageView v;
    public final OperatesRecyclerView w;
    public final View x;
    public final PromptsRecyclerView y;
    public final View z;

    public static final class a implements com.ss.android.lark.inline.ai.ui.view.c.b {
        public final /* synthetic */ InlineAIPanelController a;

        @Override // com.ss.android.lark.inline.ai.ui.view.c.b
        public final Input getInput() {
            InlineAIPanel r0 = this.a.O;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getInput();
        }

        public a(InlineAIPanelController r1) {
            this.a = r1;
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ InlineAIPanelController a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public b(InlineAIPanelController r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.D.setCursorVisible(false);
            this.a.D.setCursorVisible(true);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InlineAIPanelController a;

        public c(InlineAIPanelController r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            InlineAIPanelController r5 = this.a;
            com.ss.android.lark.inline.ai.ui.view.c r0 = r5.J;
            AppCompatEditText r6 = r5.D;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "editText");
            if (r0.b() == false) goto L12;
            r0.e = true;
            int r1 = r6.getSelectionStart();
            if (r1 >= 0) goto L7;
        L10:
            r6.getEditableText().append("@");
            return;
        L7:
            if (r1 >= r6.getEditableText().length()) goto L10;
            r6.getEditableText().insert(r1, "@");
            return;
        }
    }

    public static final class d implements InlineAIDragView.d {
        public final /* synthetic */ InlineAIPanelController a;

        @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
        public final void c() {
            Intrinsics.checkNotNullParameter("swipe_down", "closeType");
            this.a.b.s("swipe_down");
        }

        @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
        public final void d() {
            if (this.a.k() == false) goto L5;
            this.a.i();
            return;
        L5:
            this.a.b.s("click_anywhere");
        }

        @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
        public final void onClose() {
            Intrinsics.checkNotNullParameter("swipe_down", "closeType");
            this.a.h(true);
            this.a.b.i("swipe_down");
        }

        public d(InlineAIPanelController r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
        public final void a(int r2) {
            this.a.b.a(r2);
        }

        @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
        public final void b(boolean r2) {
            if (r2 == true) goto L4;
            this.a.D.clearFocus();
        L4:
            this.a.b.b(r2);
        }
    }

    public final class e implements Runnable {
        public int a;
        public int b;
        public final /* synthetic */ InlineAIPanelController c;

        public final void a() {
            Log.i("InlineAIPanelController", "check focus, isShowing = " + this.c.l() + ", isHiding = " + this.c.Q + ", hasFocus = " + this.c.D.hasFocus() + ", checkTimes = " + this.a + ", focusTimes = " + this.b);
            if (this.c.l() == false) goto L19;
            InlineAIPanelController r0 = this.c;
            if (r0.Q == true) goto L20;
            int r1 = this.a;
            if (r1 >= 10) goto L21;
            this.a = r1 + 1;
            if (r0.D.hasFocus() == false) goto L14;
            int r2 = this.b + 1;
            this.b = r2;
            if (r2 < 3) goto L17;
            return;
        L17:
            this.c.e.postDelayed(this, 100);
            return;
        L14:
            this.b = 0;
            if (this.c.k() == false) goto L17;
            this.c.D.requestFocus();
            goto L17
        L21:
            return;
        L20:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(InlineAIPanelController r1) {
            this.c = r1;
        }
    }

    public static final class f {
    }

    public final class g {
        public long a;
        public a b;
        public final /* synthetic */ InlineAIPanelController c;

        public final class a implements Runnable {
            public final String a;
            public final /* synthetic */ g b;

            public final void a() {
                Log.i("InlineAIPanelController", "notify text change, text length: " + this.a.length());
                this.b.a = System.currentTimeMillis();
                this.b.c.b.onInputTextChange(this.a);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(g r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "text");
                this.b = r2;
                this.a = r3;
            }
        }

        public g(InlineAIPanelController r3) {
            this.c = r3;
            this.a = -1;
        }
    }

    public /* synthetic */ class h {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ZoomLevel6.values().length];
            r0[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ZoomLevel6.LARGE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ZoomLevel6.LARGE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ZoomLevel6.LARGE3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ZoomLevel6.LARGE4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ InlineAIPanelController a;

        public i(InlineAIPanelController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.a.a.getActivity().isFinishing() == false) goto L5;
            return;
        L5:
            if (this.a.a.getActivity().isDestroyed() == true) goto L16;
            KeyboardUtils.showKeyboard(this.a.D);     // Catch: Throwable -> L9
            this.a.D.requestFocus();     // Catch: Throwable -> L9
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.inline.ai.ui.b
    public final void hide() {
        h(true);
        SubPromptsPanelController r1 = g();
        int r2 = SubPromptsPanelController.g;
        r1.a(true, true);
    }

    public final void e() {
        NestedScrollingChild3 r0 = this.W;
        if (r0 == null) goto L17;
        ViewParent r1 = r0.getParent();     // Catch: Exception -> L12
        if ((r1 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r1).removeView(r0);     // Catch: Exception -> L12
    L7:
        RichtextPreviewWebview r2 = this.W;     // Catch: Exception -> L12
        if (r2 == null) goto L10;
        r2.destroy();     // Catch: Exception -> L12
    L10:
        this.W = null;     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.i("InlineAIPanelController", "destroyRichtextPreviewWebview== e: " + e);
        return;
    }

    public final SubPromptsPanelController g() {
        return (SubPromptsPanelController) this.d.getValue();
    }

    public final void i() {
        rcb.c.c(this.a.getActivity());
    }

    public final boolean k() {
        wlb.d r0 = this.a.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isKeyboardShowing();
    }

    public final boolean l() {
        return ((Boolean) this.U.getValue()).booleanValue();
    }

    @Override // com.ss.android.lark.inline.ai.ui.b
    public final boolean onBackPressed() {
        StringBuilder r0 = new StringBuilder("onBackPressed, isShowing = ");
        r0.append(l());
        r0.append(", sub panel isShowing = ");
        r0.append(g().b());
        r0.append(", lock = ");
        InlineAIPanel r1 = this.O;
        DragBar r2 = null;
        if (r1 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r1.getLock());
    L6:
        r0.append(r3);
        r0.append(", dragBar = ");
        InlineAIPanel r4 = this.O;
        if (r4 == null) goto L9;
        r2 = r4.getDragBar();
    L9:
        r0.append(r2);
        Log.i("InlineAIPanelController", r0.toString());
        boolean r5 = false;
        if (g().b() == false) goto L14;
        g().a(false, true);
        return true;
    L14:
        if (l() == true) goto L16;
        return false;
    L16:
        InlineAIPanel r6 = this.O;
        if (r6 != null) goto L20;
        return false;
    L20:
        if (r6.getLock() == false) goto L40;
        DragBar r7 = r6.getDragBar();
        if (r7 != null) goto L24;
    L26:
        boolean r8 = false;
    L28:
        if (r8 == false) goto L37;
        DragBar r9 = r6.getDragBar();
        if (r9 != null) goto L32;
    L34:
        if (r5 == false) goto L36;
        this.b.s("backspace");
    L38:
        return true;
    L36:
        h(true);
        this.b.i("backspace");
        goto L38
    L32:
        if (r9.getDoubleConfirm() != true) goto L34;
        r5 = true;
        goto L34
    L37:
        this.b.s("backspace");
        goto L38
    L24:
        if (r7.getShow() != true) goto L26;
        r8 = true;
        goto L28
    L40:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.ss.android.lark.inline.ai.ui.b
    public final void c() {
        if (l() == false) goto L6;
        SubPromptsPanelController r0 = g();
        int r1 = SubPromptsPanelController.g;
        r0.a(true, true);
        return;
    }

    @Override // com.ss.android.lark.inline.ai.ui.b
    public final void destroy() {
        if (l() == false) goto L5;
        h(false);
    L5:
        e();
        g().a(true, false);
    }

    @Override // com.ss.android.lark.inline.ai.ui.b
    public final StateFlowImpl isShowing() {
        return this.U;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static boolean j(InlineAIPanel r3) {
        if (r3.isContentUseCustomView() == true) goto L5;
    L6:
        String r0 = r3.getContent();
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L25;
        Images r4 = r3.getImages();
        if (r4 != null) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == true) goto L26;
        return false;
    L26:
        return true;
    L17:
        if (r4.getShow() != true) goto L19;
        r5 = true;
        goto L20
    L25:
        return true;
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    L5:
        if (r3.getContentCustomView() == null) goto L6;
        return true;
    }

    @Override // com.ss.android.lark.inline.ai.ui.b
    public final void d(InlineAIPanel r11) {
        Intrinsics.checkNotNullParameter(r11, "panel");
        if (this.e.getParent() == null) goto L5;
        f(r11, false);
    L23:
        this.O = r11;
        return;
    L5:
        int r0 = zlb.a.d;
        long r1 = System.currentTimeMillis();
        if (zlb.a.c != 0) goto L8;
        zlb.a.c = r1;
    L8:
        Log.i("InlineAIPanelController", "addToContainer");
        wlb.h r2 = this.a;
        Object r3 = r2.c;
        if (r3 != null) goto L12;
        r3 = a(r2.getActivity().getWindow());
    L12:
        Intrinsics.checkNotNull(r3);
        Boolean r4 = null;
        if ((r3 instanceof ViewGroup) == false) goto L15;
        this.e.getViewTreeObserver().addOnPreDrawListener(new m(this));
        ViewGroup r5 = (ViewGroup) r3;
        r5.addView(this.e);
        r5.requestChildFocus(this.e, null);
        BuildersKt.launch$default(this.V, null, null, new InlineAIPanelController$addToContainer$2(this, null), 3, null);
    L16:
        f(r11, true);
        InlineAIDragView r6 = this.S;
        r6.B = Intrinsics.areEqual(r11.getStyle(), "fullScreen");
        Float r7 = r11.getHeightRatio();
        if (r7 == null) goto L19;
        this.S.h = r7.floatValue();
    L19:
        InlineAIDragView r8 = this.S;
        Input r9 = r11.getInput();
        if (r9 == null) goto L22;
        r4 = r9.getShowKeyboard();
    L22:
        r8.m(r4);
        goto L23
    L15:
        Log.e("InlineAIPanelController", "containerView is not ViewGroup!");
        goto L16
    }

    public final void h(boolean r3) {
        if (l() == false) goto L13;
        if (this.Q == true) goto L13;
        if (this.D.hasFocus() == true) goto L9;
    L11:
        this.Q = true;
        this.O = null;
        this.S.g(r3, new InlineAIPanelController$hideInternal$1(this));
        return;
    L9:
        if (k() == false) goto L11;
        i();
        this.b.b(false);
    L13:
        if (l() == true) goto L19;
        RichtextPreviewWebview r4 = this.W;
        if (r4 == null) goto L20;
        r4.p();
        return;
    L20:
        return;
    }

    public final void m(Feedback r5) {
        int r0 = 0;
        if (r5 == null) goto L7;
        boolean r2 = true;
        if (r5.getShow() != true) goto L7;
    L8:
        ViewGroup r1 = this.t;
        if (r2 == true) goto L12;
        r0 = 8;
    L12:
        r1.setVisibility(r0);
        if (r2 == false) goto L33;
        if (r5 == null) goto L34;
        AppCompatImageView r3 = this.u;
        if (r5.getLike() == false) goto L19;
        int r4 = 2131256002;
    L20:
        r3.setImageResource(r4);
        AppCompatImageView r6 = this.u;
        FragmentActivity r7 = this.a.getActivity();
        int r8 = 2131102420;
        if (r5.getLike() == false) goto L23;
        int r9 = 2131101124;
    L24:
        r6.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r7, r9)));
        AppCompatImageView r10 = this.v;
        if (r5.getUnlike() == false) goto L27;
        int r11 = 2131256000;
    L28:
        r10.setImageResource(r11);
        AppCompatImageView r12 = this.v;
        FragmentActivity r13 = this.a.getActivity();
        if (r5.getUnlike() == false) goto L31;
        r8 = 2131102419;
    L31:
        r12.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r13, r8)));
        return;
    L27:
        r11 = 2131256001;
        goto L28
    L23:
        r9 = 2131102420;
        goto L24
    L19:
        r4 = 2131256003;
        goto L20
    L34:
        return;
    L33:
        return;
    L7:
        r2 = false;
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void n(InlineAIPanel r6) {
        ConstraintLayout r0 = this.h;
        DragBar r1 = r6.getDragBar();
        boolean r2 = true;
        int r3 = 0;
        if (r1 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
    L69:
        r0.setPadding(r0.getPaddingLeft(), r3, r0.getPaddingRight(), r0.getPaddingBottom());
        return;
    L11:
        if (j(r6) == false) goto L13;
        r3 = f0.a(10);
        goto L69
    L13:
        Tips r5 = r6.getTips();
        if (r5 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == true) goto L69;
        History r8 = r6.getHistory();
        if (r8 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L69;
        Feedback r10 = r6.getFeedback();
        if (r10 != null) goto L32;
    L34:
        boolean r11 = false;
    L35:
        if (r11 == true) goto L69;
        Operates r12 = r6.getOperates();
        if (r12 != null) goto L40;
    L42:
        boolean r13 = false;
    L43:
        if (r13 == false) goto L45;
        r3 = f0.a(6);
        goto L69
    L45:
        Prompts r14 = r6.getPrompts();
        if (r14 != null) goto L48;
    L50:
        boolean r15 = false;
    L51:
        if (r15 == false) goto L53;
        r3 = f0.a(10);
        goto L69
    L53:
        Range r16 = r6.getRange();
        if (r16 != null) goto L56;
    L58:
        boolean r17 = false;
    L59:
        if (r17 == false) goto L61;
        r3 = f0.a(4);
        goto L69
    L61:
        Input r18 = r6.getInput();
        if (r18 != null) goto L64;
    L66:
        r2 = false;
    L67:
        if (r2 == false) goto L69;
        r3 = f0.a(10);
        goto L69
    L64:
        if (r18.getShow() != true) goto L66;
    L56:
        if (r16.getShow() != true) goto L58;
        r17 = true;
        goto L59
    L48:
        if (r14.getShow() != true) goto L50;
        r15 = true;
        goto L51
    L40:
        if (r12.getShow() != true) goto L42;
        r13 = true;
        goto L43
    L32:
        if (r10.getShow() != true) goto L34;
        r11 = true;
        goto L35
    L24:
        if (r8.getShow() != true) goto L26;
        r9 = true;
        goto L27
    L16:
        if (r5.getShow() != true) goto L18;
        r7 = true;
        goto L19
    L5:
        if (r1.getShow() != true) goto L7;
        r4 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r11v18, types: [android.webkit.WebView, com.ss.android.lark.inline.ai.ui.richtext.RichtextPreviewWebview] */
    /* JADX WARN: Type inference failed for: r1v37, types: [android.view.ViewGroup, com.ss.android.lark.inline.ai.ui.PanelView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void f(InlineAIPanel r22, boolean r23) {
        InlineAIPanel r1 = this.O;
        boolean r2 = true;
        if (r1 == null) goto L9;
        Input r3 = r1.getInput();
        if (r3 == null) goto L9;
        if (r3.getStatus() != 1) goto L9;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L20;
        Input r5 = r22.getInput();
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L20;
        InlineAIDragView r7 = this.S;
        r7.getClass();
        Log.i("InlineAIDragView", "resetSelfAdjust");
        r7.I = Integer.MAX_VALUE;
        r7.F = null;
        goto L20
    L15:
        if (r5.getStatus() != 1) goto L17;
        r6 = true;
    L20:
        InlineAIDragView r8 = this.S;
        InlineAIPanel r9 = this.O;
        if (r9 == null) goto L25;
        History r10 = r9.getHistory();
        if (r10 == null) goto L25;
        Integer r11 = Integer.valueOf(r10.getCurNum());
    L26:
        History r12 = r22.getHistory();
        if (r12 == null) goto L29;
        Integer r13 = Integer.valueOf(r12.getCurNum());
    L30:
        r8.U = !Intrinsics.areEqual(r11, r13);
        String r14 = r22.getMaskType();
        if (Intrinsics.areEqual(r14, "aroundPanel") == false) goto L34;
        this.f.setVisibility(8);
        this.g.setVisibility(0);
    L37:
        History r15 = r22.getHistory();
        Feedback r16 = r22.getFeedback();
        Tips r17 = r22.getTips();
        if (r15 != null) goto L40;
    L42:
        boolean r18 = false;
    L43:
        if (r16 != null) goto L45;
    L47:
        boolean r19 = false;
    L48:
        if (r17 != null) goto L50;
    L52:
        boolean r20 = false;
    L53:
        if (r18 == true) goto L58;
        if (r19 == false) goto L57;
        if (r20 == false) goto L58;
    L57:
        boolean r21 = false;
    L59:
        ViewGroup r24 = this.m;
        if (r21 == false) goto L62;
        int r25 = 0;
    L63:
        r24.setVisibility(r25);
        if (r18 == false) goto L75;
        if (r15 == null) goto L75;
        this.q.setVisibility(0);
        TextView r26 = this.o;
        StringBuilder r27 = new StringBuilder();
        r27.append(r15.getCurNum());
        r27.append('/');
        r27.append(r15.getTotal());
        r26.setText(r27.toString());
        AppCompatImageView r28 = this.n;
        FragmentActivity r29 = this.a.getActivity();
        int r30 = 2131102418;
        if (r15.getLeftArrowEnabled() == false) goto L69;
        int r31 = 2131102418;
    L70:
        r28.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r29, r31)));
        AppCompatImageView r32 = this.p;
        FragmentActivity r33 = this.a.getActivity();
        if (r15.getRightArrowEnabled() == true) goto L74;
        r30 = 2131102416;
    L74:
        r32.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r33, r30)));
        this.n.setEnabled(r15.getLeftArrowEnabled());
        this.p.setEnabled(r15.getRightArrowEnabled());
    L76:
        boolean r34 = j(r22);
        FrameLayout r35 = this.s;
        if (r34 == false) goto L79;
        int r36 = 0;
    L80:
        r35.setVisibility(r36);
        int r37 = -1;
        if (r34 == false) goto L200;
        ConstraintLayout.LayoutParams r38 = this.s.getLayoutParams();
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r39 = r38;
        Prompts r110 = r22.getPrompts();
        if (r110 != null) goto L86;
    L88:
        boolean r111 = false;
    L89:
        if (r111 == false) goto L98;
        Prompts r112 = r22.getPrompts();
        if (r112 != null) goto L93;
    L95:
        boolean r113 = false;
    L96:
        if (r113 == false) goto L98;
        int r114 = f0.a(150);
    L99:
        ((ViewGroup.MarginLayoutParams) r39).height = r114;
        this.s.setLayoutParams(r39);
        String r40 = r22.getContent();
        if (r40 != null) goto L102;
    L105:
        boolean r41 = true;
    L107:
        if (r41 == true) goto L158;
        FrameLayout r42 = this.s;
        if (this.W != null) goto L113;
        ?? r115 = new RichtextPreviewWebview(this.a.getActivity(), this.a, this.b, new a0(this));
        FragmentActivity r116 = this.a.getActivity();
        com.ss.android.lark.storage.a r117 = com.ss.android.lark.inline.ai.logic.b.a;
        r115.setBackgroundColor(ContextCompat.getColor(r116, 2131100557));
        r115.setFocusable(false);
        this.W = r115;
        r115.q();
        RichtextPreviewWebview r118 = this.W;
        if (r118 == null) goto L113;
        r118.r(Integer.toHexString(ContextCompat.getColor(this.a.getActivity(), 2131100557)).substring(2).toUpperCase(Locale.ROOT), "0,16,0,16", null);
    L113:
        NestedScrollingChild3 r119 = this.W;
        if (r119 == null) goto L116;
        ViewParent r120 = r119.getParent();
    L118:
        if (Intrinsics.areEqual(r120, r42) == true) goto L122;
        if (r120 == null) goto L121;
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r120).removeView(this.W);
    L121:
        r42.removeAllViews();
        NestedScrollingChild3 r121 = this.W;
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(-1, -1);
        r122.leftMargin = f0.a(2);
        r122.rightMargin = f0.a(2);
        Unit r123 = Unit.INSTANCE;
        r42.addView(r121, r122);
    L122:
        RichtextPreviewWebview r43 = this.W;
        if (r43 == null) goto L155;
        String r124 = r22.getContent();
        HashMap<String, Object> r125 = r22.getContentExtra();
        String r126 = r22.getConversationId();
        String r127 = r22.getTaskId();
        String r128 = r22.getTheme();
        Input r129 = r22.getInput();
        if (r129 != null) goto L127;
    L129:
        boolean r130 = false;
    L130:
        if (r130 == false) goto L132;
        String r131 = "finish";
    L133:
        int r132 = h.a[zz7.b.d().ordinal()];
        if (r132 == 1) goto L146;
        if (r132 != 2) goto L137;
        String r44 = "L";
    L147:
        AIPreviewData r133 = new AIPreviewData(r124, r125, r126, r127, r128, null, r131, r44, 32, null);
        com.ss.android.lark.inline.ai.ui.richtext.g r45 = r43.S;
        if (r45 == null) goto L152;
        amb.d r46 = r45.g;
        if (r46 == null) goto L152;
        r46.b();
    L152:
        com.ss.android.lark.inline.ai.ui.richtext.g r47 = r43.S;
        if (r47 == null) goto L155;
        r47.a(r133);
        goto L155
    L137:
        if (r132 == 3) goto L144;
        if (r132 != 4) goto L140;
        r44 = "2XL";
        goto L147
    L140:
        if (r132 == 5) goto L142;
        r44 = "M";
        goto L147
    L142:
        r44 = "3XL";
        goto L147
    L144:
        r44 = "XL";
        goto L147
    L146:
        r44 = "S";
        goto L147
    L132:
        r131 = null;
        goto L133
    L127:
        if (r129.getStatus() != 0) goto L129;
        r130 = true;
    L155:
        NestedScrollingChild3 r48 = this.W;
        if (r48 == null) goto L200;
        r48.setNestedScrollingEnabled(this.a.k);
        goto L200
    L116:
        r120 = null;
        goto L118
    L158:
        Images r49 = r22.getImages();
        if (r49 != null) goto L161;
    L163:
        boolean r50 = false;
    L164:
        if (r50 == false) goto L188;
        FrameLayout r51 = this.s;
        if (this.N != null) goto L172;
        InlineAIImageRecyclerView r52 = new InlineAIImageRecyclerView(this.a.getActivity(), null, 6, 0);
        this.N = r52;
        r52.setImagesCallback(new z(this));
        InlineAIImageRecyclerView r53 = this.N;
        if (r53 == null) goto L172;
        RecyclerView.Adapter r54 = r53.getAdapter();
        if (r54 == null) goto L172;
        r54.notifyDataSetChanged();
    L172:
        RecyclerView r55 = this.N;
        if (r55 == null) goto L175;
        ViewParent r56 = r55.getParent();
    L177:
        if (Intrinsics.areEqual(r56, r51) == true) goto L181;
        if (r56 == null) goto L180;
        Intrinsics.checkNotNull(r56, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r56).removeView(this.N);
    L180:
        r51.removeAllViews();
        RecyclerView r57 = this.N;
        FrameLayout.LayoutParams r58 = new FrameLayout.LayoutParams(-1, -1);
        r58.leftMargin = f0.a(2);
        r58.rightMargin = f0.a(2);
        Unit r134 = Unit.INSTANCE;
        r51.addView(r57, r58);
    L181:
        InlineAIImageRecyclerView r59 = this.N;
        if (r59 == null) goto L200;
        Images r60 = r22.getImages();
        if (r60 != null) goto L186;
        r60 = new Images(true, 0, null, null);
    L186:
        r59.setData(r60);
        goto L200
    L175:
        r56 = null;
        goto L177
    L188:
        if (r22.isContentUseCustomView() == false) goto L200;
        if (r22.getContentCustomView() == null) goto L200;
        FrameLayout r61 = this.s;
        View r62 = r22.getContentCustomView();
        if (r62 == null) goto L194;
        ViewParent r63 = r62.getParent();
    L196:
        if (Intrinsics.areEqual(r63, r61) == true) goto L200;
        if (r63 == null) goto L199;
        Intrinsics.checkNotNull(r63, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r63).removeView(r22.getContentCustomView());
    L199:
        r61.removeAllViews();
        View r64 = r22.getContentCustomView();
        FrameLayout.LayoutParams r65 = new FrameLayout.LayoutParams(-1, -1);
        r65.leftMargin = f0.a(2);
        r65.rightMargin = f0.a(2);
        Unit r135 = Unit.INSTANCE;
        r61.addView(r64, r65);
        goto L200
    L194:
        r63 = null;
        goto L196
    L161:
        if (r49.getShow() != true) goto L163;
        r50 = true;
        goto L164
    L102:
        if (r40.length() == 0) goto L105;
        r41 = false;
        goto L107
    L93:
        if (r112.getOverlap() == true) goto L95;
        r113 = true;
    L98:
        r114 = 0;
        goto L99
    L86:
        if (r110.getShow() != true) goto L88;
        r111 = true;
    L200:
        Feedback r66 = r22.getFeedback();
        History r67 = r22.getHistory();
        Tips r68 = r22.getTips();
        if (r67 != null) goto L203;
    L205:
        boolean r69 = false;
    L206:
        if (r68 != null) goto L208;
    L210:
        boolean r70 = false;
    L211:
        if (r69 == false) goto L213;
        ViewGroup r71 = this.r;
    L217:
        if (Intrinsics.areEqual(this.t.getParent(), r71) == true) goto L225;
        ViewParent r72 = this.t.getParent();
        if ((r72 instanceof ViewGroup) == false) goto L221;
        ViewGroup r73 = (ViewGroup) r72;
    L222:
        if (r73 == null) goto L224;
        r73.removeView(this.t);
    L224:
        r71.addView(this.t);
        goto L225
    L221:
        r73 = null;
    L225:
        m(r66);
        Tips r74 = r22.getTips();
        if (r74 != null) goto L228;
    L230:
        boolean r75 = false;
    L231:
        ViewGroup r76 = this.j;
        if (r75 == false) goto L234;
        int r136 = 0;
    L235:
        r76.setVisibility(r136);
        if (r75 == false) goto L240;
        if (r74 == null) goto L240;
        this.k.setText(r74.getText());
    L240:
        Operates r77 = r22.getOperates();
        if (r77 != null) goto L243;
    L245:
        boolean r78 = false;
    L246:
        RecyclerView r79 = this.w;
        if (r78 == false) goto L249;
        int r137 = 0;
    L250:
        r79.setVisibility(r137);
        if (r78 == false) goto L255;
        if (r77 == null) goto L255;
        this.w.setData(r77.getData());
    L255:
        Prompts r80 = r22.getPrompts();
        if (r80 != null) goto L258;
    L260:
        boolean r81 = false;
    L261:
        if (r81 == false) goto L271;
        ArrayList<PromptGroup> r82 = r80.getData();
        if (r82 != null) goto L265;
    L268:
        boolean r83 = true;
    L269:
        if (r83 == true) goto L271;
        boolean r84 = true;
    L272:
        RecyclerView r85 = this.y;
        if (r84 == false) goto L275;
        int r138 = 0;
    L276:
        r85.setVisibility(r138);
        if (r84 == true) goto L279;
        this.z.setVisibility(8);
    L279:
        if (r84 == false) goto L312;
        if (r80 == null) goto L312;
        ViewGroup.LayoutParams r86 = this.y.getLayoutParams();
        Intrinsics.checkNotNull(r86, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r87 = (ConstraintLayout.LayoutParams) r86;
        int r139 = 2131381556;
        if (r80.getOverlap() == true) goto L286;
        r37 = 2131381556;
    L286:
        ((ConstraintLayout.LayoutParams) r87).topToBottom = r37;
        this.y.setLayoutParams(r87);
        ViewGroup.LayoutParams r88 = this.w.getLayoutParams();
        Intrinsics.checkNotNull(r88, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r89 = (ConstraintLayout.LayoutParams) r88;
        if (r80.getOverlap() == false) goto L289;
        int r90 = 2131383651;
    L290:
        ((ConstraintLayout.LayoutParams) r89).bottomToTop = r90;
        this.w.setLayoutParams(r89);
        ViewGroup.LayoutParams r91 = this.K.getLayoutParams();
        Intrinsics.checkNotNull(r91, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r92 = (ConstraintLayout.LayoutParams) r91;
        if (r80.getOverlap() == true) goto L294;
        r139 = 2131383397;
    L294:
        ((ConstraintLayout.LayoutParams) r92).topToBottom = r139;
        this.K.setLayoutParams(r92);
        RecyclerView r93 = this.y;
        if (r80.getOverlap() == false) goto L297;
        int r94 = f0.a(8);
    L298:
        r93.setPadding(r93.getPaddingLeft(), r94, r93.getPaddingRight(), r93.getPaddingBottom());
        ViewParent r95 = ((View) this.R.getValue()).getParent();
        if ((r95 instanceof ViewGroup) == false) goto L301;
        ViewGroup r96 = (ViewGroup) r95;
    L302:
        if (r96 == null) goto L305;
        r96.removeView((View) this.R.getValue());
    L305:
        if (r80.getOverlap() == false) goto L307;
        this.h.addView((View) this.R.getValue(), this.h.indexOfChild(this.x));
    L307:
        View r97 = this.x;
        if (r80.getOverlap() == false) goto L310;
        int r98 = 0;
    L311:
        r97.setVisibility(r98);
        this.y.setData(r80.getData());
        goto L312
    L310:
        r98 = 8;
        goto L311
    L301:
        r96 = null;
        goto L302
    L297:
        r94 = 0;
        goto L298
    L289:
        r90 = 2131383397;
    L312:
        Range r99 = r22.getRange();
        if (r99 == null) goto L324;
        Window r100 = this.a.getActivity().getWindow();
        if (r100 == null) goto L319;
        View r101 = a(r100);
        if (r101 == null) goto L319;
        this.L.post(new n(this, r101));
    L319:
        boolean r102 = r99.getShow();
        ViewGroup r103 = this.K;
        if (r102 == false) goto L322;
        int r104 = 0;
    L323:
        r103.setVisibility(r104);
        this.L.setText(r99.getText());
        this.K.setClickable(r99.getEnable());
        goto L324
    L322:
        r104 = 8;
    L324:
        Input r105 = r22.getInput();
        boolean r106 = ((bmb.a) this.P.getValue()).b.isCurrentEnable("ccm.docx.my_ai.show_tool_detail");
        if (r105 != null) goto L327;
    L329:
        boolean r107 = false;
    L330:
        ViewGroup r108 = this.A;
        if (r107 == false) goto L333;
        int r109 = 0;
    L334:
        r108.setVisibility(r109);
        if (r107 == false) goto L498;
        if (r105 == null) goto L498;
        if (r105.getStatus() != 0) goto L444;
        this.D.setEnabled(true);
        if (String.valueOf(this.D.getText()).length() != 0) goto L343;
        boolean r140 = true;
    L344:
        CharSequence r141 = "";
        if (r140 == true) goto L347;
    L375:
        if (r106 == false) goto L377;
        this.D.setMaxLines(4);
        this.D.setEllipsize(null);
    L377:
        com.ss.android.lark.inline.ai.ui.view.c r142 = this.J;
        AppCompatEditText r143 = this.D;
        String r144 = r105.getPlaceholder();
        if (r144 != null) goto L380;
        r144 = "";
    L380:
        r142.getClass();
        Intrinsics.checkNotNullParameter(r143, "editText");
        Intrinsics.checkNotNullParameter(r144, "placeholder");
        if (r142.j != null) goto L383;
        r142.j = new com.ss.android.lark.inline.ai.ui.at.a();
    L383:
        com.ss.android.lark.inline.ai.ui.at.a r145 = r142.j;
        if (r145 == null) goto L404;
        Intrinsics.checkNotNullParameter(r144, "placeholder");
        if (TextUtils.isEmpty(r144) == true) goto L405;
        Iterator r146 = Regex.findAll$default(r145.a, r144, 0, 2, null).iterator();
        String r147 = r144;
    L390:
        if (r146.hasNext() == false) goto L403;
        MatchResult r148 = (MatchResult) r146.next();
        MatchResult r149 = Regex.find$default(r145.b, r148.getValue(), 0, 2, null);
        if (r149 == null) goto L401;
        MatchResult.Destructured r150 = r149.getDestructured();
        if (r150 == null) goto L401;
        MatchResult r151 = r150.getMatch();
        if (r151 == null) goto L401;
        String r152 = r151.getValue();
        if (r152 == null) goto L401;
        String r153 = r152;
    L402:
        r147 = StringsKt.replace$default(r147, r148.getValue(), r153, false, 4, null);
    L401:
        r153 = "";
        goto L402
    L403:
        r141 = r147;
    L405:
        r143.setHint(r141);
        this.D.setHintTextColor(ContextCompat.getColor(this.a.getActivity(), 2131102420));
        if (r105.getRecentPrompt() == null) goto L408;
        boolean r154 = true;
    L409:
        boolean r155 = r105.getPlacehoderSelected();
        String r156 = String.valueOf(this.D.getText());
        AppCompatImageView r157 = this.F;
        if (r156.length() <= 0) goto L412;
        boolean r158 = true;
    L413:
        if (r158 == false) goto L415;
    L423:
        boolean r159 = true;
    L424:
        r157.setEnabled(r159);
        this.F.setVisibility(0);
        this.E.setVisibility(8);
        this.B.setVisibility(0);
        wlb.a r160 = this.a.e;
        if (r160 == null) goto L427;
        MentionType r161 = r160.a;
    L429:
        if (r161 == MentionType.USER) goto L442;
        if (r160 == null) goto L432;
        MentionType r162 = r160.a;
    L434:
        if (r162 == MentionType.DOCUMENT) goto L442;
        if (r160 == null) goto L437;
        MentionType r163 = r160.a;
    L439:
        if (r163 == MentionType.ALL) goto L442;
        int r164 = 8;
        this.H.setVisibility(8);
        this.I.setVisibility(8);
    L443:
        this.C.setVisibility(r164);
        this.C.cancelAnimation();
        this.M.setEnabled(true);
        this.L.setTextColor(ContextCompat.getColor(this.a.getActivity(), 2131106622));
        this.M.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this.a.getActivity(), 2131102419)));
    L474:
        ViewGroup r165 = this.G;
        if (this.F.getVisibility() == 8) goto L477;
    L479:
        int r166 = 0;
    L480:
        r165.setVisibility(r166);
        boolean r167 = k();
        Log.i("InlineAIPanelController", "input.showKeyboard = " + r105.getShowKeyboard() + ", isKeyboardShowing = " + r167);
        Boolean r168 = r105.getShowKeyboard();
        if (r168 != null) goto L483;
    L490:
        boolean r169 = false;
    L492:
        if (r105.getShowKeyboard() != null) goto L495;
        if (r167 == false) goto L495;
        this.D.requestFocus();
        r169 = true;
    L495:
        if (r169 == false) goto L498;
        if (r23 == false) goto L498;
        this.e.postDelayed(new e(this), 100);
        goto L498
    L483:
        if (r168.booleanValue() == false) goto L487;
        if (r167 == true) goto L486;
        this.b.b(true);
    L486:
        KeyboardUtils.showKeyboard(this.D);
        r169 = true;
        goto L492
    L487:
        if (r167 == false) goto L489;
        this.b.b(false);
    L489:
        i();
        goto L490
    L477:
        if (this.E.getVisibility() != 8) goto L479;
        r166 = 8;
        goto L480
    L437:
        r163 = null;
        goto L439
    L432:
        r162 = null;
    L442:
        r164 = 8;
        this.H.setVisibility(0);
        this.I.setVisibility(0);
        goto L443
    L427:
        r161 = null;
        goto L429
    L415:
        if (r156.length() != 0) goto L417;
        boolean r170 = true;
    L418:
        if (r170 == false) goto L422;
        if (r154 == true) goto L423;
        if (r155 == true) goto L423;
    L422:
        r159 = false;
        goto L424
    L417:
        r170 = false;
        goto L418
    L412:
        r158 = false;
        goto L413
    L408:
        r154 = false;
        goto L409
    L404:
        r141 = null;
        goto L405
    L347:
        if (r105.getTextContentList() != null) goto L349;
    L353:
        String r171 = r105.getText();
        if (r171 != null) goto L356;
    L359:
        boolean r172 = true;
    L360:
        if (r172 == true) goto L375;
        com.ss.android.lark.inline.ai.ui.view.c r173 = this.J;
        r173.f = null;
        AppCompatEditText r174 = this.D;
        String r175 = r105.getText();
        if (r175 != null) goto L364;
        r175 = "";
    L364:
        Intrinsics.checkNotNullParameter(r174, "editText");
        Intrinsics.checkNotNullParameter(r175, "text");
        if (r173.j != null) goto L367;
        r173.j = new com.ss.android.lark.inline.ai.ui.at.a();
    L367:
        com.ss.android.lark.inline.ai.ui.at.a r176 = r173.j;
        if (r176 == null) goto L370;
        r176.b(r175, r174);
    L370:
        Editable r177 = r174.getText();
        if (r177 == null) goto L373;
        int r178 = r177.length();
    L374:
        r174.setSelection(r178);
        goto L375
    L373:
        r178 = 0;
        goto L374
    L356:
        if (r171.length() == 0) goto L359;
        r172 = false;
        goto L360
    L349:
        if (r105.getPlacehoderSelected() == true) goto L353;
        TextContentList r179 = r105.getTextContentList();
        if (r179 == null) goto L375;
        com.ss.android.lark.inline.ai.ui.view.c r180 = this.J;
        r180.f = r179;
        r180.d(this.D, r179);
        goto L375
    L343:
        r140 = false;
        goto L344
    L444:
        this.D.setEnabled(false);
        this.D.setText(null);
        this.D.setHint(r105.getWritingText());
        this.D.setHintTextColor(ContextCompat.getColor(this.a.getActivity(), 2131106607));
        if (r106 == false) goto L447;
        this.D.setMaxLines(1);
        this.D.setEllipsize(TextUtils.TruncateAt.END);
    L447:
        this.F.setVisibility(8);
        wlb.a r181 = this.a.e;
        if (r181 == null) goto L450;
        MentionType r182 = r181.a;
    L452:
        if (r182 == MentionType.USER) goto L465;
        if (r181 == null) goto L455;
        MentionType r183 = r181.a;
    L457:
        if (r183 == MentionType.DOCUMENT) goto L465;
        if (r181 == null) goto L460;
        MentionType r184 = r181.a;
    L462:
        if (r184 == MentionType.ALL) goto L465;
        int r185 = 8;
    L466:
        AppCompatImageView r186 = this.E;
        if (r105.getShowStopBtn() == false) goto L469;
        int r187 = 0;
    L470:
        r186.setVisibility(r187);
        this.B.setVisibility(r185);
        this.C.setVisibility(0);
        if (this.C.isAnimating() == true) goto L473;
        this.C.playAnimation();
    L473:
        this.M.setEnabled(false);
        int r188 = ContextCompat.getColor(this.a.getActivity(), 2131106613);
        this.L.setTextColor(r188);
        this.M.setImageTintList(ColorStateList.valueOf(r188));
        goto L474
    L469:
        r187 = 8;
        goto L470
    L460:
        r184 = null;
        goto L462
    L455:
        r183 = null;
    L465:
        r185 = 8;
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        goto L466
    L450:
        r182 = null;
    L498:
        DragBar r189 = r22.getDragBar();
        if (r189 != null) goto L501;
    L503:
        boolean r190 = false;
    L504:
        ViewGroup r191 = this.i;
        if (r190 == false) goto L507;
        int r192 = 0;
    L508:
        r191.setVisibility(r192);
        Prompts r193 = r22.getPrompts();
        if (r193 != null) goto L511;
    L513:
        boolean r194 = false;
    L514:
        if (r194 == false) goto L527;
        Prompts r195 = r22.getPrompts();
        if (r195 == null) goto L518;
        ArrayList<PromptGroup> r196 = r195.getData();
    L519:
        if (r196 != null) goto L521;
    L524:
        boolean r197 = true;
    L525:
        if (r197 == true) goto L527;
        boolean r198 = true;
    L528:
        boolean r199 = j(r22);
        if (r198 == false) goto L538;
        Prompts r200 = r22.getPrompts();
        if (r200 != null) goto L533;
    L535:
        boolean r201 = false;
    L536:
        if (r201 == false) goto L538;
        this.S.l(this.y, 1);
    L545:
        InlineAIDragView r202 = this.S;
        DragBar r203 = r22.getDragBar();
        if (r203 == null) goto L548;
        boolean r204 = r203.getDoubleConfirm();
    L549:
        r202.A = r204;
        n(r22);
        ConstraintLayout r205 = this.h;
        ViewGroup.LayoutParams r206 = r205.getLayoutParams();
        if (r206 == null) goto L581;
        ViewGroup.MarginLayoutParams r207 = (ViewGroup.MarginLayoutParams) r206;
        if (Intrinsics.areEqual(r22.getStyle(), "fullScreen") == false) goto L554;
        r207.leftMargin = 0;
        r207.rightMargin = 0;
    L555:
        r205.setLayoutParams(r207);
        if (m0.b(this.a.getActivity()) == false) goto L566;
        View r208 = this.f;
        ViewGroup.LayoutParams r209 = r208.getLayoutParams();
        if (r209 == null) goto L564;
        ViewGroup.MarginLayoutParams r210 = (ViewGroup.MarginLayoutParams) r209;
        if (Intrinsics.areEqual(r22.getStyle(), "fullScreen") == false) goto L562;
        r210.bottomMargin = m0.a(this.a.getActivity());
    L562:
        r208.setLayoutParams(r210);
        goto L566
    L564:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L566:
        if (Intrinsics.areEqual(r22.getStyle(), "fullScreen") == false) goto L568;
        this.h.setBackground(AppCompatResources.getDrawable(this.a.getActivity(), 2131238278));
    L578:
        this.S.C = r22.getLock();
        return;
    L568:
        ?? r211 = this.h;
        Input r212 = r22.getInput();
        if (r212 != null) goto L571;
    L573:
        r2 = false;
    L574:
        if (r2 == false) goto L576;
        Drawable r213 = r211.d;
    L577:
        r211.setBackground(r213);
        goto L578
    L576:
        r213 = r211.c;
        goto L577
    L571:
        if (r212.getStatus() != 1) goto L573;
    L554:
        r207.leftMargin = f0.a(8);
        r207.rightMargin = f0.a(8);
        goto L555
    L581:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L548:
        r204 = false;
        goto L549
    L533:
        if (r200.getOverlap() == true) goto L535;
        r201 = true;
    L538:
        if (r199 == false) goto L544;
        InlineAIDragView r214 = this.S;
        if (this.s.getChildCount() <= 0) goto L542;
        View r215 = this.s.getChildAt(0);
    L543:
        r214.l(r215, 0);
        goto L545
    L542:
        r215 = this.s;
        goto L543
    L544:
        this.S.l(null, 0);
        goto L545
    L521:
        if (r196.isEmpty() == true) goto L524;
        r197 = false;
        goto L525
    L518:
        r196 = null;
    L527:
        r198 = false;
        goto L528
    L511:
        if (r193.getShow() != true) goto L513;
        r194 = true;
        goto L514
    L507:
        r192 = 8;
        goto L508
    L501:
        if (r189.getShow() != true) goto L503;
        r190 = true;
        goto L504
    L333:
        r109 = 8;
        goto L334
    L327:
        if (r105.getShow() != true) goto L329;
        r107 = true;
        goto L330
    L275:
        r138 = 8;
        goto L276
    L265:
        if (r82.isEmpty() == true) goto L268;
        r83 = false;
    L271:
        r84 = false;
        goto L272
    L258:
        if (r80.getShow() != true) goto L260;
        r81 = true;
        goto L261
    L249:
        r137 = 8;
        goto L250
    L243:
        if (r77.getShow() != true) goto L245;
        r78 = true;
        goto L246
    L234:
        r136 = 8;
        goto L235
    L228:
        if (r74.getShow() != true) goto L230;
        r75 = true;
        goto L231
    L213:
        if (r70 == false) goto L215;
        r71 = this.l;
        goto L217
    L215:
        r71 = this.r;
        goto L217
    L208:
        if (r68.getShow() != true) goto L210;
        r70 = true;
        goto L211
    L203:
        if (r67.getShow() != true) goto L205;
        r69 = true;
        goto L206
    L79:
        r36 = 8;
        goto L80
    L69:
        r31 = 2131102416;
    L75:
        this.q.setVisibility(8);
        goto L76
    L62:
        r25 = 8;
    L58:
        r21 = true;
        goto L59
    L50:
        if (r17.getShow() != true) goto L52;
        r20 = true;
        goto L53
    L45:
        if (r16.getShow() != true) goto L47;
        r19 = true;
        goto L48
    L40:
        if (r15.getShow() != true) goto L42;
        r18 = true;
        goto L43
    L34:
        if (Intrinsics.areEqual(r14, "none") == false) goto L36;
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        goto L37
    L36:
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        goto L37
    L29:
        r13 = null;
    L25:
        r11 = null;
    L9:
        r4 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r2v18, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout, com.ss.android.lark.inline.ai.ui.PanelView] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.widget.EditText, androidx.appcompat.widget.AppCompatEditText, com.ss.android.lark.inline.ai.ui.InlineAIEditText] */
    public InlineAIPanelController(wlb.h r27, wlb.e r28, nsb.b r29) {
        Intrinsics.checkNotNullParameter(r27, "config");
        Intrinsics.checkNotNullParameter(r28, "callback");
        this.a = r27;
        this.b = r28;
        this.c = r29;
        this.d = LazyKt.lazy(new InlineAIPanelController$subPromptsPanelController$2(this));
        this.P = LazyKt.lazy(InlineAIPanelController$userComponentAbility$2.INSTANCE);
        this.R = LazyKt.lazy(new InlineAIPanelController$promptsOverlapMask$2(this));
        new AutoTransition().setDuration(100);
        this.T = new g(this);
        this.U = j1.a(Boolean.FALSE);
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r27.getActivity());
        this.V = r3;
        ConstraintLayout r2 = LayoutInflater.from(r27.getActivity()).inflate(2131561547, null, false);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout r9 = r2;
        this.e = r9;
        ?? r4 = (PanelView) r9.findViewById(2131381901);
        this.h = r4;
        View r5 = r9.findViewById(2131379665);
        this.f = r5;
        int r7 = com.ss.android.lark.inline.ai.utils.e.a;
        r5.setBackground(com.ss.android.lark.inline.ai.utils.e.b(r27.getActivity()));
        View r6 = r9.findViewById(2131379661);
        this.g = r6;
        r6.setBackground(com.ss.android.lark.inline.ai.utils.e.a(r27.getActivity()));
        ViewGroup r8 = (ViewGroup) r4.findViewById(2131370217);
        this.i = r8;
        this.j = (ViewGroup) r4.findViewById(2131388750);
        this.k = (TextView) r4.findViewById(2131388767);
        this.l = (ViewGroup) r4.findViewById(2131372279);
        this.m = (ViewGroup) r4.findViewById(2131374386);
        AppCompatImageView r15 = r4.findViewById(2131374418);
        this.n = r15;
        this.o = (TextView) r4.findViewById(2131374424);
        AppCompatImageView r14 = r4.findViewById(2131374415);
        this.p = r14;
        this.q = (ViewGroup) r4.findViewById(2131374401);
        this.r = (ViewGroup) r4.findViewById(2131372278);
        this.s = (FrameLayout) r4.findViewById(2131367812);
        this.t = (ViewGroup) r4.findViewById(2131372287);
        AppCompatImageView r13 = r4.findViewById(2131372317);
        this.u = r13;
        AppCompatImageView r12 = r4.findViewById(2131372316);
        this.v = r12;
        OperatesRecyclerView r11 = (OperatesRecyclerView) r4.findViewById(2131381556);
        this.w = r11;
        this.x = r4.findViewById(2131383395);
        PromptsRecyclerView r10 = (PromptsRecyclerView) r4.findViewById(2131383397);
        this.y = r10;
        this.z = r4.findViewById(2131383396);
        this.A = (ViewGroup) r4.findViewById(2131375375);
        this.B = r4.findViewById(2131375376);
        this.C = r4.findViewById(2131375377);
        ?? r16 = (InlineAIEditText) r4.findViewById(2131375415);
        this.D = r16;
        AppCompatImageView r17 = r4.findViewById(2131375411);
        this.E = r17;
        AppCompatImageView r18 = r4.findViewById(2131375407);
        this.F = r18;
        this.G = (ViewGroup) r4.findViewById(2131375403);
        AppCompatImageView r19 = r4.findViewById(2131375338);
        this.H = r19;
        View r20 = r4.findViewById(2131375365);
        this.I = r20;
        com.ss.android.lark.inline.ai.ui.view.c r110 = new com.ss.android.lark.inline.ai.ui.view.c(r27, new a(this));
        this.J = r110;
        r16.setEditTextFunction(r110);
        ExtensionEditTextCompatKt.n(r16);
        ViewGroup r111 = (ViewGroup) r4.findViewById(2131383651);
        this.K = r111;
        this.M = r4.findViewById(2131383652);
        this.L = (TextView) r4.findViewById(2131383657);
        r16.addOnAttachStateChangeListener(new b(this));
        wlb.a r112 = r27.e;
        if (r112 == null) goto L5;
        MentionType r21 = r112.a;
    L7:
        if (r21 == MentionType.USER) goto L20;
        if (r112 == null) goto L10;
        MentionType r22 = r112.a;
    L12:
        if (r22 == MentionType.DOCUMENT) goto L20;
        if (r112 == null) goto L15;
        MentionType r23 = r112.a;
    L17:
        if (r23 == MentionType.ALL) goto L20;
        r19.setVisibility(8);
        r20.setVisibility(8);
    L21:
        InlineAIDragView r24 = new InlineAIDragView(r27.getActivity(), r9, r4, r27.d, new d(this), r27.f, r27.g, r27.h);
        this.S = r24;
        Intrinsics.checkNotNullParameter(r8, "dragView");
        r8.setOnTouchListener(new InlineAIDragView.c(r24));
        r4.setOnClickListener(p.a);
        r13.setOnClickListener(new InlineAIPanelController$initListeners$2(this));
        r12.setOnClickListener(new q(this));
        r14.setOnClickListener(new r(this));
        r15.setOnClickListener(new s(this));
        r10.setOnPromptClickListener(new x(this));
        r10.setOnShadowChangeListener(new y(this));
        r11.setOnOperateClickListener(new t(this));
        r16.addTextChangedListener(new u(this));
        r17.setOnClickListener(new v(this));
        r18.setOnClickListener(new w(this));
        r111.setOnClickListener(new o(this));
        wlb.f r1 = r27.j;
        if (r1 == null) goto L25;
        BuildersKt.launch$default(r3, null, null, new InlineAIPanelController$handleStatusBar$1$1(this, new Ref.ObjectRef(), r1, null), 3, null);
        return;
    L25:
        return;
    L15:
        r23 = null;
        goto L17
    L10:
        r22 = null;
    L20:
        r19.setVisibility(0);
        r20.setVisibility(0);
        r19.setOnClickListener(new c(this));
        goto L21
    L5:
        r21 = null;
        goto L7
    }

    @Override // com.ss.android.lark.inline.ai.ui.b
    public final void onActivityResult(int r12, int r13, Intent r14) {
        if (r14 != null) goto L4;
    L44:
        wlb.a r15 = this.a.e;
        if (r15 == null) goto L49;
        boolean r16 = true;
        if (r15.b != true) goto L49;
    L50:
        if (r16 == false) goto L54;
        this.D.postDelayed(new i(this), 300);
        return;
    L54:
        return;
    L49:
        r16 = false;
        goto L50
    L4:
        if (r13 == (-1)) goto L6;
    L34:
        if (r13 != (-1)) goto L44;
        if (r12 != 39315) goto L44;
        Object r17 = r14.getSerializableExtra("MENTION_DATA");
        if (r17 != null) goto L40;
        r17 = CollectionsKt.emptyList();
    L40:
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.search.dto.info.SearchBaseInfo>");
        List r18 = (List) r17;
        if (r18.isEmpty() == false) goto L43;
        return;
    L43:
        this.J.c(this.a.i, this.D, r18);
        goto L44
    L6:
        if (r12 != 39314) goto L34;
        String r1 = r14.getStringExtra("mention_type");
        if (Intrinsics.areEqual(r1, MentionType.USER.getValue()) == false) goto L21;
        String r2 = r14.getStringExtra("select_user");
        Log.i("InlineAIPanelController", "mentionUsers: " + r2);
        if (r2 == null) goto L34;
        com.ss.android.lark.inline.ai.ui.view.c r3 = this.J;
        InlineAIEditText r4 = this.D;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "editText");
        Intrinsics.checkNotNullParameter(r2, "users");
        if ((r4 instanceof InlineAIEditText) == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L34;
        Iterator r5 = JsonParser.parseString(r2).getAsJsonArray().iterator();
    L18:
        if (r5.hasNext() == false) goto L34;
        JsonElement r6 = (JsonElement) r5.next();
        String r7 = r6.getAsJsonObject().get("uid").getAsString();
        String r8 = r6.getAsJsonObject().get("uname").getAsString();
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r8);
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) r4.q(com.ss.android.lark.keyboard.edittext2.edittors.a.e)).insert(new hob.c(r7, r8, r8, false, false));
        goto L18
    L21:
        if (Intrinsics.areEqual(r1, MentionType.DOCUMENT.getValue()) == false) goto L33;
        final String r9 = r14.getStringExtra("doc_title");
        final String r10 = "";
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        String r11 = r14.getStringExtra("doc_url");
        if (r11 == null) goto L29;
        r10 = r11;
    L29:
        final com.ss.android.lark.inline.ai.ui.view.c r19 = this.J;
        final AppCompatEditText r20 = this.D;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "editText");
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r9, "defaultTitle");
        if (TextUtils.isEmpty(r10) == true) goto L34;
        URLRecognition.a(r10, new InlineEditTextFunctionImpl$insertUrl$1(r19, r20, r10, r9));
        goto L34
    L33:
        Log.i("InlineAIPanelController", "err mentionType: " + r1);
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v37, types: [com.ss.android.lark.inline.ai.ui.InlineAIDragView] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [android.view.View] */
    @Override // com.ss.android.lark.inline.ai.ui.b
    public final void b(List<PromptGroup> r23, String r24, boolean r25, final Function0<Unit> r26) {
        Intrinsics.checkNotNullParameter(r23, "promptList");
        ?? r6 = 0;
        if (r25 == false) goto L15;
        SubPromptsPanelController r7 = g();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r23, "promptGroups");
        PromptsRecyclerView r4 = r7.e;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("promptsRv");
        r4 = null;
    L7:
        r4.setData(r23);
        InlineAIDragView r1 = r7.f;
        ?? r2 = r1;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIDragView");
        r2 = 0;
    L10:
        PromptsRecyclerView r3 = r7.e;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("promptsRv");
    L14:
        r2.l(r6, 1);
        return;
    L13:
        r6 = r3;
        goto L14
    L15:
        SubPromptsPanelController r8 = g();
        if (r24 != null) goto L18;
        String r9 = "";
    L20:
        if (r9.length() != 0) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L28;
        InlineAIPanel r11 = this.O;
        if (r11 == null) goto L27;
        r9 = r11.getMaskType();
        goto L28
    L27:
        r9 = null;
    L28:
        Function0<Unit> r12 = new InlineAIPanelController$showSubPromptsPanel$2(this, r26);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r23, "promptGroups");
        List<Triple<View, InlineAIDragView, Function0<Unit>>> r5 = r8.d;
        ConstraintLayout r13 = LayoutInflater.from(r8.c).inflate(2131561551, null, false);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout r14 = r13;
        ConstraintLayout r16 = r14.findViewById(2131381901);
        View r15 = r14.findViewById(2131379665);
        int r17 = com.ss.android.lark.inline.ai.utils.e.a;
        r15.setBackground(com.ss.android.lark.inline.ai.utils.e.b(r8.a.getActivity()));
        View r18 = r14.findViewById(2131379661);
        r18.setBackground(com.ss.android.lark.inline.ai.utils.e.a(r8.a.getActivity()));
        ViewGroup r19 = (ViewGroup) r14.findViewById(2131370217);
        r8.e = (PromptsRecyclerView) r14.findViewById(2131383397);
        View r110 = r14.findViewById(2131383396);
        PromptsRecyclerView r20 = r8.e;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("promptsRv");
        r20 = null;
    L31:
        r20.setData(r23);
        PromptsRecyclerView r21 = r8.e;
        if (r21 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("promptsRv");
        r21 = null;
    L34:
        r21.setOnPromptClickListener(new b0(r8));
        PromptsRecyclerView r22 = r8.e;
        if (r22 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("promptsRv");
        r22 = null;
    L37:
        r22.setOnShadowChangeListener(new c0(r8, r110));
        if (Intrinsics.areEqual(r9, "aroundPanel") == false) goto L41;
        r15.setVisibility(8);
        r18.setVisibility(0);
    L44:
        FragmentActivity r111 = r8.a.getActivity();
        wlb.h r27 = r8.a;
        InlineAIDragView r28 = new InlineAIDragView(r111, r14, r16, r27.d, new d0(r8), r27.f, r27.g, r27.h);
        r8.f = r28;
        Intrinsics.checkNotNullParameter(r19, "dragView");
        r19.setOnTouchListener(new InlineAIDragView.c(r28));
        InlineAIDragView r29 = r8.f;
        if (r29 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIDragView");
        r29 = null;
    L47:
        RecyclerView r30 = r8.e;
        if (r30 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("promptsRv");
        int r31 = 1;
        r30 = null;
    L51:
        r29.l(r30, r31);
        wlb.h r32 = r8.a;
        View r33 = r32.c;
        if (r33 != null) goto L59;
        r33 = r32.getActivity().getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L59;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r34 = ThreadMethodProxy.currentThread();
        if (r34 == com.larus.home.impl.utils.c.a) goto L59;
        com.larus.home.impl.utils.c.a(r34, "getDecorView");
    L59:
        Intrinsics.checkNotNull(r33);
        if ((r33 instanceof ViewGroup) == false) goto L62;
        ((ViewGroup) r33).addView(r14);
    L63:
        InlineAIDragView r35 = r8.f;
        if (r35 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIDragView");
        r35 = null;
    L66:
        r35.m(null);
        InlineAIDragView r36 = r8.f;
        if (r36 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIDragView");
        r36 = null;
    L69:
        ((ArrayList) r5).add(new Triple(r14, r36, r12));
        StringBuilder r37 = new StringBuilder("show sub panel, panelRootView.parent is null = ");
        if (this.e.getParent() != null) goto L72;
        boolean r38 = true;
    L73:
        r37.append(r38);
        r37.append(", isShowing.value = ");
        r37.append(((Boolean) this.U.getValue()).booleanValue());
        Log.i("InlineAIPanelController", r37.toString());
        if (this.e.getParent() == null) goto L76;
        return;
    L76:
        if (((Boolean) this.U.getValue()).booleanValue() == true) goto L81;
        BuildersKt.launch$default(this.V, null, null, new InlineAIPanelController$showSubPromptsPanel$3(this, null), 3, null);
        return;
    L81:
        return;
    L72:
        r38 = false;
        goto L73
    L62:
        Log.e("SubPromptsPanelController", "containerView is not ViewGroup!");
        goto L63
    L50:
        r31 = 1;
        goto L51
    L41:
        if (Intrinsics.areEqual(r9, "none") == false) goto L43;
        r15.setVisibility(8);
        r18.setVisibility(8);
        goto L44
    L43:
        r15.setVisibility(0);
        r18.setVisibility(8);
        goto L44
    L22:
        r10 = false;
        goto L23
    L18:
        r9 = r24;
        goto L20
    }
}
