package com.ss.android.lark.inline.ai.creationai;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
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
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.inline.ai.api.creationai.ButtonGroups;
import com.ss.android.lark.inline.ai.api.creationai.CreationAIPanel;
import com.ss.android.lark.inline.ai.api.creationai.DragBar;
import com.ss.android.lark.inline.ai.api.creationai.Editor;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackJSParams;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackResult;
import com.ss.android.lark.inline.ai.api.creationai.Footer;
import com.ss.android.lark.inline.ai.api.creationai.Header;
import com.ss.android.lark.inline.ai.api.creationai.Input;
import com.ss.android.lark.inline.ai.api.creationai.ItemContainer;
import com.ss.android.lark.inline.ai.api.creationai.Label;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.api.creationai.Recommend;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import com.ss.android.lark.inline.ai.api.creationai.Title;
import com.ss.android.lark.inline.ai.api.creationai.UIConfig;
import com.ss.android.lark.inline.ai.creationai.editor.AIPreviewData;
import com.ss.android.lark.inline.ai.creationai.editor.CreationAIEditorWebview;
import com.ss.android.lark.inline.ai.creationai.label.LabelRecyclerView;
import com.ss.android.lark.inline.ai.creationai.operates.ButtonGroupsLinearLayout;
import com.ss.android.lark.inline.ai.creationai.operates.ButtonGroupsRecyclerView;
import com.ss.android.lark.inline.ai.creationai.recommend.RecommendRecyclerView;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.tool.voice.vote.FeedbackReasonDataConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.myai.export.model.DownVoteFeedbackParam;
import com.ss.android.lark.pb.ai_engine.FeedsbackData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CreationAIPanelController implements f0 {
    public final CreationAIDragView A;
    public final e B;
    public final StateFlowImpl C;
    public final LifecycleCoroutineScope D;
    public Dialog E;
    public UDButton F;
    public final a G;
    public final Integer H;
    public int I;
    public long J;
    public boolean K;
    public g L;
    public CreationAIEditorWebview M;
    public final vlb.a a;
    public final vlb.b b;
    public final nsb.b c;
    public final Lazy d;
    public final ConstraintLayout e;
    public final View f;
    public final ViewGroup g;
    public final UDShadowLayout h;
    public final ViewGroup i;
    public final FrameLayout j;
    public final ButtonGroupsLinearLayout k;
    public final ButtonGroupsRecyclerView l;
    public final ButtonGroupsRecyclerView m;
    public final ButtonGroupsRecyclerView n;
    public final TextView o;
    public final ViewGroup p;
    public final ViewGroup q;
    public final CreationAIEditText r;
    public final AppCompatImageView s;
    public final AppCompatImageView t;
    public final ViewGroup u;
    public final LabelRecyclerView v;
    public final RecommendRecyclerView w;
    public CreationAIPanel x;
    public final Lazy y;
    public boolean z;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ CreationAIPanelController a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public a(CreationAIPanelController r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.r.setCursorVisible(false);
            this.a.r.setCursorVisible(true);
        }
    }

    public static final class b implements CreationAIDragView.d {
        public final /* synthetic */ CreationAIPanelController a;

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void c() {
            Intrinsics.checkNotNullParameter("swipe_down", "closeType");
            this.a.b.c();
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void d() {
            if (this.a.n() == false) goto L5;
            this.a.m();
        L5:
            CreationAIPanel r0 = this.a.x;
            if (r0 == null) goto L8;
            String r1 = r0.getWritingStatus();
        L10:
            if (TextUtils.equals(r1, "writing") == true) goto L12;
            this.a.l(true);
        L12:
            this.a.b.c();
            return;
        L8:
            r1 = null;
            goto L10
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void onClose() {
            Intrinsics.checkNotNullParameter("swipe_down", "closeType");
            Log.i("CreationAIPanelController", "onClose, closeType = swipe_down");
            this.a.l(true);
            this.a.b.c();
        }

        public b(CreationAIPanelController r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void a(int r2) {
            this.a.b.a(r2);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void b(boolean r2) {
            if (r2 == true) goto L4;
            this.a.r.clearFocus();
        L4:
            this.a.b.b(r2);
        }
    }

    public final class c implements Runnable {
        public int a;
        public int b;
        public final /* synthetic */ CreationAIPanelController c;

        public final void a() {
            Log.i("CreationAIPanelController", "check focus, isShowing = " + this.c.o() + ", isHiding = " + this.c.z + ", hasFocus = " + this.c.r.hasFocus() + ", checkTimes = " + this.a + ", focusTimes = " + this.b);
            if (this.c.o() == false) goto L19;
            CreationAIPanelController r0 = this.c;
            if (r0.z == true) goto L20;
            int r1 = this.a;
            if (r1 >= 10) goto L21;
            this.a = r1 + 1;
            if (r0.r.hasFocus() == false) goto L14;
            int r2 = this.b + 1;
            this.b = r2;
            if (r2 < 3) goto L17;
            return;
        L17:
            this.c.e.postDelayed(this, 100);
            return;
        L14:
            this.b = 0;
            if (this.c.n() == false) goto L17;
            this.c.r.requestFocus();
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

        public c(CreationAIPanelController r1) {
            this.c = r1;
        }
    }

    public static final class d {
    }

    public final class e {
        public long a;
        public a b;
        public final /* synthetic */ CreationAIPanelController c;

        public final class a implements Runnable {
            public final String a;
            public final /* synthetic */ e b;

            public final void a() {
                Log.i("CreationAIPanelController", "notify text change, text length: " + this.a.length());
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

            public a(e r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "text");
                this.b = r2;
                this.a = r3;
            }
        }

        public e(CreationAIPanelController r3) {
            this.c = r3;
            this.a = -1;
        }
    }

    public /* synthetic */ class f {
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

    public static final class g implements Runnable {
        public final /* synthetic */ CreationAIPanelController a;

        public g(CreationAIPanelController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CreationAIPanelController r0 = this.a;     // Catch: Throwable -> L6
            CreationAIPanel r1 = r0.x;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r0.p(r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements nsb.a {
        public final /* synthetic */ CreationAIPanelController a;

        public h(CreationAIPanelController r1) {
            this.a = r1;
        }

        @Override // nsb.a
        public final void a(com.ss.android.lark.keyboard.plugin.tool.voice.vote.a r2) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            Log.i("CreationAIPanelController", "click feedback thumbs down: onDialogShowSuccess");
        }

        @Override // nsb.a
        public final void b(ErrorResult r3) {
            Intrinsics.checkNotNullParameter(r3, "errorResult");
            Log.i("CreationAIPanelController", "click feedback thumbs down: onDialogShowError: " + r3);
            UDToast.show(this.a.a.getActivity(), 2131891714);
        }
    }

    public static final class i implements osb.f {
        public final /* synthetic */ CreationAIPanelController a;
        public final /* synthetic */ FeedbackJSParams b;

        public i(CreationAIPanelController r1, FeedbackJSParams r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // osb.f
        public final void a(UDButton r2, String r3, FeedsbackData r4, DownVoteFeedbackParam r5) {
            Intrinsics.checkNotNullParameter(r3, "feedBackDescription");
            Intrinsics.checkNotNullParameter(r4, "feedbackData");
            Intrinsics.checkNotNullParameter(r5, "feedbackParam");
            CreationAIPanelController r6 = this.a;
            r6.F = r2;
            r6.b.k(new FeedbackResult(this.b.getData(), r4.mreason_id, r4.mextra));
        }
    }

    static {
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void onActivityResult() {
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void hide() {
        Log.i("CreationAIPanelController", "hide");
        g r0 = this.L;
        if (r0 == null) goto L9;
        vlb.a r1 = this.a;
        View r2 = r1.b;
        if (r2 != null) goto L8;
        r2 = a(r1.getActivity().getWindow());
    L8:
        Intrinsics.checkNotNull(r2);
        r2.removeCallbacks(r0);
    L9:
        l(true);
        SubPanelManager r3 = k();
        int r4 = SubPanelManager.d;
        r3.b(false);
    }

    public final void i() {
        NestedScrollingChild3 r0 = this.M;
        if (r0 == null) goto L17;
        ViewParent r1 = r0.getParent();     // Catch: Exception -> L12
        if ((r1 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r1).removeView(r0);     // Catch: Exception -> L12
    L7:
        CreationAIEditorWebview r2 = this.M;     // Catch: Exception -> L12
        if (r2 == null) goto L10;
        r2.destroy();     // Catch: Exception -> L12
    L10:
        this.M = null;     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.i("CreationAIPanelController", "destroyCreationAIEditorWebview== e: " + e);
        return;
    }

    public final SubPanelManager k() {
        return (SubPanelManager) this.d.getValue();
    }

    public final void m() {
        rcb.c.c(this.a.getActivity());
    }

    public final boolean n() {
        wlb.d r0 = this.a.c;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isKeyboardShowing();
    }

    public final boolean o() {
        return ((Boolean) this.C.getValue()).booleanValue();
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final boolean onBackPressed() {
        StringBuilder r0 = new StringBuilder("onBackPressed, isShowing = ");
        r0.append(o());
        r0.append(", sub panel isShowing = ");
        r0.append(SubPanelManager.c(k()));
        r0.append(", lock = ");
        CreationAIPanel r1 = this.x;
        String r2 = null;
        if (r1 == null) goto L7;
        UIConfig r3 = r1.getUiConfig();
        if (r3 == null) goto L7;
        Boolean r4 = r3.getLock();
    L8:
        r0.append(r4);
        r0.append(", dragBar = ");
        CreationAIPanel r5 = this.x;
        if (r5 == null) goto L11;
        DragBar r6 = r5.getDragBar();
    L12:
        r0.append(r6);
        Log.i("CreationAIPanelController", r0.toString());
        boolean r7 = false;
        if (SubPanelManager.c(k()) == false) goto L17;
        k().b(false);
        return true;
    L17:
        if (o() == true) goto L19;
        return false;
    L19:
        CreationAIPanel r8 = this.x;
        if (r8 != null) goto L22;
        return false;
    L22:
        UIConfig r9 = r8.getUiConfig();
        if (r9 == null) goto L25;
        boolean r10 = Intrinsics.areEqual(r9.getLock(), Boolean.TRUE);
    L26:
        if (r10 == true) goto L34;
        UIConfig r11 = r8.getUiConfig();
        if (r11 == null) goto L30;
        Boolean r12 = r11.getLock();
    L31:
        if (r12 == null) goto L34;
        this.b.c();
    L56:
        return true;
    L30:
        r12 = null;
    L34:
        DragBar r13 = r8.getDragBar();
        if (r13 != null) goto L37;
    L39:
        boolean r14 = false;
    L40:
        if (r14 == false) goto L49;
        DragBar r15 = r8.getDragBar();
        if (r15 != null) goto L44;
    L46:
        if (r7 == false) goto L48;
        this.b.c();
        goto L56
    L48:
        l(true);
        this.b.c();
        goto L56
    L44:
        if (r15.getDoubleConfirm() != true) goto L46;
        r7 = true;
        goto L46
    L49:
        CreationAIPanel r16 = this.x;
        if (r16 == null) goto L53;
        r2 = r16.getWritingStatus();
    L53:
        if (TextUtils.equals(r2, "writing") == true) goto L55;
        l(true);
    L55:
        this.b.c();
        goto L56
    L37:
        if (r13.getShow() != true) goto L39;
        r14 = true;
        goto L40
    L25:
        r10 = false;
        goto L26
    L11:
        r6 = null;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void destroy() {
        if (SubPanelManager.c(k()) == false) goto L6;
        k().b(true);
    L6:
        if (o() == false) goto L8;
        l(false);
    L8:
        View.OnAttachStateChangeListener r0 = this.G;
        if (r0 == null) goto L11;
        this.r.removeOnAttachStateChangeListener(r0);
    L11:
        i();
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void e() {
        k().a("model_setting_panel");
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void g() {
        k().a("history_panel");
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final StateFlowImpl isShowing() {
        return this.C;
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

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void b(SubPanelInfo r3) {
        k().d(r3, "model_setting_panel");
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void c(FeedbackJSParams r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Boolean r0 = r5.getShow();
        if (r0 != null) goto L5;
        Log.i("CreationAIPanelController", "showFeedback, show is null");
        if (Intrinsics.areEqual(r5.isSuccess(), Boolean.FALSE) == false) goto L57;
        UDButton r6 = this.F;
        if (r6 == null) goto L58;
        com.larksuite.component.universe_design.button.e.c(r6, 2131889556);
        r6.setEnabled(true);
        return;
    L58:
        return;
    L57:
        return;
    L5:
        if (r0.booleanValue() == true) goto L28;
        Dialog r7 = this.E;
        if (r7 == null) goto L27;
        Log.i("CreationAIPanelController", r7 + " existed, start dismiss, " + r7.isShowing());
        if (r7.isShowing() == false) goto L50;
        Handler r1 = DialogLancet.resolveDialogHandler(r7);
        if (r1 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r2 == null) goto L24;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L13:
        if (Looper.myLooper() == r1.getLooper()) goto L15;
        r1.post(DialogLancet.createDismissRunnable(r7));
        return;
    L50:
        return;
    L27:
        return;
    L28:
        DownVoteFeedbackParam.a r3 = new DownVoteFeedbackParam.a();
        Intrinsics.checkNotNullParameter("", "id");
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r3.a = "";
        h r4 = new h(this);
        Intrinsics.checkNotNullParameter(r4, "callback");
        r3.b = r4;
        i r8 = new i(this, r5);
        Intrinsics.checkNotNullParameter(r8, "listener");
        r3.c = r8;
        final DownVoteFeedbackParam r9 = new DownVoteFeedbackParam(r3);
        final FragmentActivity r10 = this.a.getActivity();
        Dialog r11 = this.E;
        if (r11 == null) goto L37;
        Log.i("CreationAIPanelController", r11 + " existed, start show, " + r11.isShowing());
        if (r11.isShowing() == false) goto L33;
        return;
    L33:
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r11);
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L36:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        return;
    L37:
        SettingManager.getInstance().get(FeedbackReasonDataConfig.class, new CreationAIPanelController$showDownVoteFeedback$2(r10, r9, this));
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void d(SubPanelInfo r3) {
        k().d(r3, "history_panel");
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void f(Object r4) {
        StringBuilder r0 = new StringBuilder("onMessage,  data = ");
        JSONObject r1 = null;
        if (r4 == null) goto L7;
        String r2 = r4.toString();
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.length());
    L8:
        r0.append(r3);
        Log.i("CreationAIPanelController", r0.toString());
        CreationAIEditorWebview r5 = this.M;
        if (r5 == null) goto L20;
        com.ss.android.lark.inline.ai.creationai.editor.a r6 = r5.O;
        if (r6 != null) goto L13;
        return;
    L13:
        if ((r4 instanceof JSONObject) == false) goto L15;
        r1 = (JSONObject) r4;
    L15:
        if (r1 == null) goto L22;
        at5.j r7 = r6.f;
        if (r7 == null) goto L23;
        r7.a(Status.SUCCESS, r1);
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.ss.android.lark.inline.ai.creationai.f0
    public final void h(CreationAIPanel r8) {
        Intrinsics.checkNotNullParameter(r8, "panel");
        if (this.e.getParent() == null) goto L5;
        j(r8, false);
    L23:
        this.x = r8;
        return;
    L5:
        int r0 = d0.b;
        long r1 = System.currentTimeMillis();
        if (d0.a != 0) goto L9;
        d0.a = r1;
    L9:
        if (this.K == false) goto L12;
        this.x = r8;
        return;
    L12:
        this.K = true;
        if (n() == false) goto L22;
        Log.i("CreationAIPanelController", "show panel with keyboard showing isPanelMounting: " + this.K);
        this.b.j();
        m();
        vlb.a r2 = this.a;
        View r3 = r2.b;
        if (r3 != null) goto L18;
        r3 = a(r2.getActivity().getWindow());
    L18:
        Intrinsics.checkNotNull(r3);
        Runnable r4 = this.L;
        if (r4 == null) goto L21;
        r3.removeCallbacks(r4);
    L21:
        g r5 = new g(this);
        this.L = r5;
        r3.postDelayed(r5, 140);
        goto L23
    L22:
        Log.i("CreationAIPanelController", "show panel without keyboard");
        p(r8);
        goto L23
    }

    public final void l(boolean r5) {
        Log.i("CreationAIPanelController", "hideInternal, anim = " + r5);
        this.h.c(2131953869);
        CreationAIEditorWebview r0 = this.M;
        if (r0 == null) goto L15;
        Disposable r2 = r0.W;
        if (r2 != null) goto L7;
    L9:
        com.ss.android.lark.inline.ai.creationai.editor.a r1 = r0.O;
        if (r1 == null) goto L15;
        at5.j r3 = r1.g;
        if (r3 == null) goto L15;
        r3.a(Status.SUCCESS, "");
        goto L15
    L7:
        if (r2.isDisposed() == true) goto L9;
        r2.dispose();
    L15:
        if (o() == true) goto L17;
        return;
    L17:
        if (this.z == false) goto L19;
        return;
    L19:
        if (this.r.hasFocus() == true) goto L21;
    L23:
        this.z = true;
        Log.i("CreationAIPanelController", "hideInternal, hide, forceHideToolbar--->");
        this.b.j();
        this.A.h(r5, new CreationAIPanelController$hideInternal$1(this));
        return;
    L21:
        if (n() == false) goto L23;
        Log.i("CreationAIPanelController", "hideInternal, hideKeyboard -->");
        m();
        this.b.b(false);
        goto L23
    }

    public final void p(CreationAIPanel r11) {
        Log.i("CreationAIPanelController", "addToContainer");
        vlb.a r0 = this.a;
        Object r2 = r0.b;
        if (r2 != null) goto L6;
        r2 = a(r0.getActivity().getWindow());
    L6:
        Intrinsics.checkNotNull(r2);
        Boolean r3 = null;
        if ((r2 instanceof ViewGroup) == false) goto L9;
        this.e.getViewTreeObserver().addOnPreDrawListener(new p(this));
        ViewGroup r4 = (ViewGroup) r2;
        r4.addView(this.e);
        r4.requestChildFocus(this.e, null);
        BuildersKt.launch$default(this.D, null, null, new CreationAIPanelController$addToContainer$2(this, null), 3, null);
    L10:
        boolean r1 = true;
        j(r11, true);
        UIConfig r5 = r11.getUiConfig();
        if (r5 == null) goto L17;
        Input r6 = r5.getInput();
        if (r6 == null) goto L17;
        if (r6.getShow() != true) goto L17;
    L18:
        if (r1 == false) goto L27;
        UIConfig r12 = r11.getUiConfig();
        if (r12 == null) goto L24;
        Input r13 = r12.getInput();
        if (r13 == null) goto L24;
        boolean r14 = Intrinsics.areEqual(r13.getShowKeyboard(), Boolean.TRUE);
    L25:
        if (r14 == false) goto L27;
        r3 = Boolean.TRUE;
    L24:
        r14 = false;
    L27:
        this.A.r(r3, new CreationAIPanelController$showPanel$1(this));
        this.K = false;
        return;
    L17:
        r1 = false;
        goto L18
    L9:
        Log.e("CreationAIPanelController", "containerView is not ViewGroup!");
        goto L10
    }

    /* JADX WARN: Type inference failed for: r5v72, types: [android.webkit.WebView, com.ss.android.lark.inline.ai.creationai.editor.CreationAIEditorWebview] */
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
    public final void j(CreationAIPanel r19, boolean r20) {
        Boolean r2 = null;
        boolean r3 = true;
        if (Intrinsics.areEqual(r19.getMaskType(), "none") == false) goto L5;
        this.f.setBackground(null);
        this.h.c(2131953898);
        this.A.Y = false;
    L6:
        UIConfig r1 = r19.getUiConfig();
        if (r1 == null) goto L9;
        Header r4 = r1.getHeader();
    L10:
        if (r4 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        ViewGroup r6 = this.p;
        if (r5 == false) goto L18;
        int r8 = 0;
    L19:
        r6.setVisibility(r8);
        if (r5 == false) goto L64;
        if (r4 == null) goto L28;
        ItemContainer r7 = r4.getLeftItem();
        if (r7 == null) goto L28;
        if (r7.getShow() != true) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L35;
        this.l.setVisibility(0);
        ButtonGroupsRecyclerView r10 = this.l;
        ItemContainer r11 = r4.getLeftItem();
        if (r11 == null) goto L33;
        ArrayList<MenuItem> r12 = r11.getData();
    L34:
        r10.setData(r12);
    L36:
        if (r4 == null) goto L42;
        ItemContainer r13 = r4.getRightItem();
        if (r13 == null) goto L42;
        if (r13.getShow() != true) goto L42;
        boolean r14 = true;
    L43:
        if (r14 == false) goto L49;
        this.m.setVisibility(0);
        ButtonGroupsRecyclerView r15 = this.m;
        ItemContainer r16 = r4.getRightItem();
        if (r16 == null) goto L47;
        ArrayList<MenuItem> r17 = r16.getData();
    L48:
        r15.setData(r17);
    L50:
        if (r4 == null) goto L56;
        Title r18 = r4.getTitle();
        if (r18 == null) goto L56;
        if (r18.getShow() != true) goto L56;
        boolean r21 = true;
    L57:
        if (r21 == false) goto L63;
        this.o.setVisibility(0);
        TextView r22 = this.o;
        Title r23 = r4.getTitle();
        if (r23 == null) goto L61;
        String r24 = r23.getText();
    L62:
        r22.setText(r24);
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(new q(this));
        goto L64
    L61:
        r24 = null;
        goto L62
    L63:
        this.o.setVisibility(8);
    L56:
        r21 = false;
        goto L57
    L47:
        r17 = null;
        goto L48
    L49:
        this.m.setVisibility(8);
    L42:
        r14 = false;
        goto L43
    L33:
        r12 = null;
        goto L34
    L35:
        this.l.setVisibility(8);
    L28:
        r9 = false;
    L64:
        UIConfig r25 = r19.getUiConfig();
        if (r25 == null) goto L67;
        Recommend r26 = r25.getRecommend();
    L68:
        if (r26 != null) goto L70;
    L72:
        boolean r27 = false;
    L73:
        RecyclerView r28 = this.w;
        if (r27 == false) goto L76;
        int r29 = 0;
    L77:
        r28.setVisibility(r29);
        if (r27 == false) goto L85;
        RecommendRecyclerView r30 = this.w;
        if (r26 == null) goto L83;
        ArrayList<MenuItem> r31 = r26.getData();
    L84:
        r30.setData(r31);
        goto L85
    L83:
        r31 = null;
    L85:
        UIConfig r32 = r19.getUiConfig();
        if (r32 == null) goto L88;
        Label r33 = r32.getLabel();
    L89:
        if (r33 != null) goto L91;
    L93:
        boolean r34 = false;
    L94:
        RecyclerView r35 = this.v;
        if (r34 == false) goto L97;
        int r36 = 0;
    L98:
        r35.setVisibility(r36);
        if (r34 == false) goto L106;
        LabelRecyclerView r37 = this.v;
        if (r33 == null) goto L104;
        ArrayList<MenuItem> r38 = r33.getData();
    L105:
        r37.setData(r38);
        goto L106
    L104:
        r38 = null;
    L106:
        UIConfig r39 = r19.getUiConfig();
        if (r39 == null) goto L109;
        Footer r40 = r39.getFooter();
    L110:
        if (r40 != null) goto L112;
    L114:
        boolean r41 = false;
    L115:
        RecyclerView r42 = this.n;
        if (r41 == false) goto L118;
        int r43 = 0;
    L119:
        r42.setVisibility(r43);
        if (r41 == false) goto L127;
        ButtonGroupsRecyclerView r44 = this.n;
        if (r40 == null) goto L125;
        ArrayList<MenuItem> r45 = r40.getData();
    L126:
        r44.setData(r45);
        goto L127
    L125:
        r45 = null;
    L127:
        Editor r46 = r19.getEditor();
        if (r46 != null) goto L130;
    L132:
        boolean r47 = false;
    L133:
        FrameLayout r48 = this.j;
        if (r47 == false) goto L136;
        int r49 = 0;
    L137:
        r48.setVisibility(r49);
        if (r47 == false) goto L197;
        FrameLayout r50 = this.j;
        if (this.M != null) goto L145;
        ?? r51 = new CreationAIEditorWebview(this.a.getActivity(), this.a, this.b, new c0(this));
        r51.setBackgroundColor(ContextCompat.getColor(this.a.getActivity(), 2131100557));
        r51.setFocusable(false);
        this.M = r51;
        r51.p();
        CreationAIEditorWebview r52 = this.M;
        if (r52 == null) goto L145;
        r52.W = Single.just(Boolean.TRUE).map(new com.ss.android.lark.inline.ai.creationai.editor.g(r52)).subscribeOn(new ExecutorScheduler(CoreThreadPool.getDefault().getSingleScheduledThreadPool(r52.M), false)).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.ss.android.lark.inline.ai.creationai.editor.h(r52, Integer.toHexString(ContextCompat.getColor(this.a.getActivity(), 2131100557)).substring(2).toUpperCase(Locale.ROOT), r19.getMode()), new com.ss.android.lark.inline.ai.creationai.editor.i(r52));
    L145:
        NestedScrollingChild3 r53 = this.M;
        if (r53 == null) goto L148;
        ViewParent r54 = r53.getParent();
    L150:
        if (Intrinsics.areEqual(r54, r50) == true) goto L154;
        if (r54 == null) goto L153;
        Intrinsics.checkNotNull(r54, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r54).removeView(this.M);
    L153:
        r50.removeAllViews();
        NestedScrollingChild3 r55 = this.M;
        FrameLayout.LayoutParams r56 = new FrameLayout.LayoutParams(-1, -1);
        r56.leftMargin = n0.a(2);
        r56.rightMargin = n0.a(2);
        Unit r57 = Unit.INSTANCE;
        r50.addView(r55, r56);
    L154:
        boolean r58 = h18.f.a(this.a.getActivity());
        CreationAIEditorWebview r59 = this.M;
        if (r59 == null) goto L194;
        Editor r60 = r19.getEditor();
        if (r60 == null) goto L159;
        Object r61 = r60.getData();
    L160:
        String r110 = r19.getConversationId();
        String r111 = r19.getTaskId();
        if (r58 == false) goto L163;
        String r62 = "dark";
    L164:
        String r112 = r62;
        CreationAIPanel r63 = this.x;
        if (r63 == null) goto L171;
        UIConfig r64 = r63.getUiConfig();
        if (r64 == null) goto L171;
        Input r65 = r64.getInput();
        if (r65 == null) goto L171;
        String r66 = r65.getWritingStatus();
    L173:
        if (TextUtils.equals(r66, "waiting") == false) goto L175;
        String r113 = "finish";
    L176:
        int r67 = f.a[zz7.b.d().ordinal()];
        if (r67 == 1) goto L190;
        if (r67 != 2) goto L180;
        String r68 = "L";
    L191:
        AIPreviewData r114 = new AIPreviewData(r61, r110, r111, r112, null, r113, r68, 16, null);
        com.ss.android.lark.inline.ai.creationai.editor.a r69 = r59.O;
        if (r69 == null) goto L194;
        r69.a(r114);
        goto L194
    L180:
        if (r67 != 3) goto L182;
        r68 = "XL";
        goto L191
    L182:
        if (r67 != 4) goto L184;
        r68 = "2XL";
        goto L191
    L184:
        if (r67 == 5) goto L186;
        r68 = "M";
        goto L191
    L186:
        r68 = "3XL";
        goto L191
    L190:
        r68 = "S";
        goto L191
    L175:
        r113 = null;
    L171:
        r66 = null;
        goto L173
    L163:
        r62 = "light";
        goto L164
    L159:
        r61 = null;
    L194:
        NestedScrollingChild3 r70 = this.M;
        if (r70 == null) goto L197;
        r70.setNestedScrollingEnabled(this.a.i);
        goto L197
    L148:
        r54 = null;
    L197:
        UIConfig r71 = r19.getUiConfig();
        if (r71 == null) goto L200;
        ButtonGroups r72 = r71.getButtonGroups();
    L201:
        if (r72 != null) goto L203;
    L205:
        boolean r73 = false;
    L206:
        ButtonGroupsLinearLayout r74 = this.k;
        if (r73 == false) goto L209;
        int r75 = 0;
    L210:
        r74.setVisibility(r75);
        if (r73 == false) goto L218;
        ButtonGroupsLinearLayout r76 = this.k;
        if (r72 == null) goto L216;
        ArrayList<MenuItem> r77 = r72.getData();
    L217:
        r76.setData(r77);
        goto L218
    L216:
        r77 = null;
    L218:
        UIConfig r78 = r19.getUiConfig();
        if (r78 == null) goto L221;
        Input r79 = r78.getInput();
    L222:
        if (r79 != null) goto L224;
    L226:
        boolean r80 = false;
    L227:
        ViewGroup r81 = this.q;
        if (r80 == false) goto L230;
        int r82 = 0;
    L231:
        r81.setVisibility(r82);
        if (r80 == false) goto L293;
        if (r79 == null) goto L293;
        String r83 = r79.getText();
        if (r83 == null) goto L238;
        this.r.setText(r83);
        this.r.setSelection(r83.length());
    L238:
        CharSequence r84 = r79.getPlaceholder();
        if (r84 == null) goto L242;
        this.r.setHint(r84);
    L242:
        if (r79.getShowStopBtn() == false) goto L244;
        this.s.setVisibility(0);
        this.t.setVisibility(8);
    L261:
        ViewGroup r85 = this.u;
        if (this.t.getVisibility() == 8) goto L264;
    L266:
        int r86 = 0;
    L267:
        r85.setVisibility(r86);
        boolean r87 = n();
        Log.i("CreationAIPanelController", "input.showKeyboard = " + r79.getShowKeyboard() + ", isKeyboardShowing = " + r87 + ",  input.writingStatus = " + r79.getWritingStatus());
        if (r79.getShowKeyboard() != null) goto L271;
        if (r20 == false) goto L293;
    L271:
        if (r20 == true) goto L273;
    L275:
        Boolean r88 = r79.getShowKeyboard();
        if (r88 != null) goto L278;
    L285:
        boolean r89 = false;
    L287:
        if (r79.getShowKeyboard() != null) goto L290;
        if (r87 == false) goto L290;
        this.r.requestFocus();
        r89 = true;
    L290:
        if (r89 == false) goto L293;
        if (r20 == false) goto L293;
        this.e.postDelayed(new c(this), 100);
        goto L293
    L278:
        if (r88.booleanValue() == false) goto L282;
        if (r87 == true) goto L281;
        this.b.b(true);
    L281:
        rcb.c.h(this.r, null);
        r89 = true;
        goto L287
    L282:
        if (r87 == false) goto L284;
        this.b.b(false);
    L284:
        m();
        goto L285
    L273:
        if (r79.getShowKeyboard() != null) goto L275;
        r79.setShowKeyboard(Boolean.FALSE);
        goto L275
    L264:
        if (this.s.getVisibility() != 8) goto L266;
        r86 = 8;
        goto L267
    L244:
        this.s.setVisibility(8);
        this.t.setVisibility(0);
        AppCompatImageView r90 = this.t;
        Editable r91 = this.r.getText();
        if (r91 == null) goto L251;
        CharSequence r92 = StringsKt.trim(r91);
        if (r92 == null) goto L251;
        if (r92.length() <= 0) goto L251;
        boolean r93 = true;
    L252:
        r90.setActivated(r93);
        AppCompatImageView r94 = this.t;
        Editable r95 = this.r.getText();
        if (r95 == null) goto L259;
        CharSequence r96 = StringsKt.trim(r95);
        if (r96 == null) goto L259;
        if (r96.length() <= 0) goto L259;
        boolean r97 = true;
    L260:
        r94.setEnabled(r97);
    L259:
        r97 = false;
    L251:
        r93 = false;
    L293:
        DragBar r98 = r19.getDragBar();
        if (r98 != null) goto L296;
    L298:
        boolean r99 = false;
    L299:
        ViewGroup r100 = this.i;
        if (r99 == false) goto L302;
        int r101 = 0;
    L303:
        r100.setVisibility(r101);
        NestedScrollingChild3 r102 = this.M;
        if (r102 == null) goto L306;
        r102.setNestedScrollingEnabled(false);
    L306:
        Editor r103 = r19.getEditor();
        if (r103 != null) goto L309;
    L311:
        boolean r104 = false;
    L312:
        if (r104 == false) goto L318;
        CreationAIDragView r105 = this.A;
        r105.V = true;
        if (this.j.getChildCount() <= 0) goto L316;
        View r106 = this.j.getChildAt(0);
    L317:
        r105.p(r106);
    L320:
        if (this.p.getVisibility() == 8) goto L326;
        if (r99 == false) goto L324;
        int r107 = 44;
    L325:
        this.p.getLayoutParams().height = y9c.d.a(r107);
        goto L326
    L324:
        r107 = 52;
    L326:
        CreationAIDragView r108 = this.A;
        DragBar r109 = r19.getDragBar();
        if (r109 == null) goto L329;
        boolean r115 = r109.getDoubleConfirm();
    L330:
        r108.B = r115;
        vlb.a r116 = this.a;
        if (r116.b == null) goto L333;
    L339:
        CreationAIDragView r117 = this.A;
        UIConfig r118 = r19.getUiConfig();
        if (r118 == null) goto L342;
        boolean r119 = Intrinsics.areEqual(r118.getLock(), Boolean.TRUE);
    L343:
        if (r119 == true) goto L350;
        UIConfig r120 = r19.getUiConfig();
        if (r120 == null) goto L347;
        r2 = r120.getLock();
    L347:
        if (r2 == null) goto L350;
        r3 = false;
    L350:
        r117.C = r3;
        if (r20 == true) goto L353;
        return;
    L353:
        if (TextUtils.equals(r19.getScene(), "enterprise_qa") == false) goto L357;
        CreationAIDragView r121 = this.A;
        ViewGroup r122 = this.p;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r122, "dragView");
        r122.setOnTouchListener(new CreationAIDragView.c(r121));
        return;
    L357:
        return;
    L342:
        r119 = false;
        goto L343
    L333:
        if (com.ss.android.lark.utils.m0.b(r116.getActivity()) == false) goto L339;
        ConstraintLayout r123 = this.e;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 == null) goto L338;
        ViewGroup.MarginLayoutParams r125 = (ViewGroup.MarginLayoutParams) r124;
        r125.bottomMargin = com.ss.android.lark.utils.m0.a(this.a.getActivity());
        r123.setLayoutParams(r125);
        goto L339
    L338:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L329:
        r115 = false;
        goto L330
    L316:
        r106 = this.j;
        goto L317
    L318:
        CreationAIDragView r126 = this.A;
        r126.V = false;
        r126.p(null);
        goto L320
    L309:
        if (r103.getShow() != true) goto L311;
        r104 = true;
        goto L312
    L302:
        r101 = 8;
        goto L303
    L296:
        if (r98.getShow() != true) goto L298;
        r99 = true;
        goto L299
    L230:
        r82 = 8;
        goto L231
    L224:
        if (r79.getShow() != true) goto L226;
        r80 = true;
        goto L227
    L221:
        r79 = null;
        goto L222
    L209:
        r75 = 8;
        goto L210
    L203:
        if (r72.getShow() != true) goto L205;
        r73 = true;
        goto L206
    L200:
        r72 = null;
        goto L201
    L136:
        r49 = 8;
        goto L137
    L130:
        if (r46.getShow() != true) goto L132;
        r47 = true;
        goto L133
    L118:
        r43 = 8;
        goto L119
    L112:
        if (r40.getShow() != true) goto L114;
        r41 = true;
        goto L115
    L109:
        r40 = null;
        goto L110
    L97:
        r36 = 8;
        goto L98
    L91:
        if (r33.getShow() != true) goto L93;
        r34 = true;
        goto L94
    L88:
        r33 = null;
        goto L89
    L76:
        r29 = 8;
        goto L77
    L70:
        if (r26.getShow() != true) goto L72;
        r27 = true;
        goto L73
    L67:
        r26 = null;
        goto L68
    L18:
        r8 = 8;
        goto L19
    L12:
        if (r4.getShow() != true) goto L14;
        r5 = true;
        goto L15
    L9:
        r4 = null;
        goto L10
    L5:
        View r127 = this.f;
        int r128 = com.ss.android.lark.inline.ai.utils.e.a;
        r127.setBackground(com.ss.android.lark.inline.ai.utils.e.b(this.a.getActivity()));
        this.h.c(2131953869);
        this.A.Y = true;
        goto L6
    }

    public CreationAIPanelController(vlb.a r32, vlb.b r33, nsb.b r34) {
        Intrinsics.checkNotNullParameter(r32, "config");
        Intrinsics.checkNotNullParameter(r33, "callback");
        this.a = r32;
        this.b = r33;
        this.c = r34;
        this.d = LazyKt.lazy(new CreationAIPanelController$subPanelManager$2(this));
        this.y = LazyKt.lazy(CreationAIPanelController$userComponentAbility$2.INSTANCE);
        new AutoTransition().setDuration(100);
        this.B = new e(this);
        this.C = j1.a(Boolean.FALSE);
        this.D = LifecycleOwnerKt.getLifecycleScope(r32.getActivity());
        ConstraintLayout r3 = LayoutInflater.from(r32.getActivity()).inflate(2131559968, null, false);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout r8 = r3;
        this.e = r8;
        ViewGroup r4 = (ViewGroup) r8.findViewById(2131368266);
        this.g = r4;
        this.h = r8.findViewById(2131368230);
        View r5 = r8.findViewById(2131368263);
        this.f = r5;
        int r6 = com.ss.android.lark.inline.ai.utils.e.a;
        r5.setBackground(com.ss.android.lark.inline.ai.utils.e.b(r32.getActivity()));
        ViewGroup r7 = (ViewGroup) r4.findViewById(2131368241);
        this.i = r7;
        this.j = (FrameLayout) r4.findViewById(2131368231);
        ButtonGroupsLinearLayout r15 = (ButtonGroupsLinearLayout) r4.findViewById(2131368264);
        this.k = r15;
        this.o = (TextView) r4.findViewById(2131368249);
        ButtonGroupsRecyclerView r14 = (ButtonGroupsRecyclerView) r4.findViewById(2131368247);
        this.l = r14;
        ButtonGroupsRecyclerView r13 = (ButtonGroupsRecyclerView) r4.findViewById(2131368248);
        this.m = r13;
        ViewGroup r12 = (ViewGroup) r4.findViewById(2131368246);
        this.p = r12;
        this.q = (ViewGroup) r4.findViewById(2131368254);
        AppCompatEditText r11 = (CreationAIEditText) r4.findViewById(2131368258);
        this.r = r11;
        AppCompatImageView r10 = r4.findViewById(2131368257);
        this.s = r10;
        AppCompatImageView r9 = r4.findViewById(2131368256);
        this.t = r9;
        this.u = (ViewGroup) r4.findViewById(2131368255);
        RecommendRecyclerView r16 = (RecommendRecyclerView) r4.findViewById(2131368268);
        this.w = r16;
        LabelRecyclerView r17 = (LabelRecyclerView) r4.findViewById(2131368269);
        this.v = r17;
        ButtonGroupsRecyclerView r18 = (ButtonGroupsRecyclerView) r4.findViewById(2131368244);
        this.n = r18;
        ExtensionEditTextCompatKt.n(r11);
        r11.setCallback(r33);
        a r2 = new a(this);
        this.G = r2;
        r11.addOnAttachStateChangeListener(r2);
        CreationAIDragView r19 = new CreationAIDragView(r32.getActivity(), r8, r4, r32.c, new b(this), r32.d, r32.e, r32.f, false, r32.h);
        this.A = r19;
        Intrinsics.checkNotNullParameter(r7, "dragView");
        r7.setOnTouchListener(new CreationAIDragView.c(r19));
        vlb.d r1 = r32.h;
        if (r1 == null) goto L5;
        Integer r20 = Integer.valueOf(r1.a());
    L6:
        this.H = r20;
        r4.setOnClickListener(t.a);
        r15.setOnOperateClickListener(new u(this));
        r12.setOnClickListener(new v(this));
        r14.setUseType(1);
        r14.setOnOperateClickListener(new w(this));
        r13.setUseType(2);
        r13.setOnOperateClickListener(new x(this));
        r16.setOnOperateClickListener(new y(this));
        r17.setOnOperateClickListener(new z(this));
        r18.setUseType(3);
        r18.setOnOperateClickListener(new a0(this));
        r11.addTextChangedListener(new b0(this));
        r10.setOnClickListener(new r(this));
        r9.setOnClickListener(new s(this));
        return;
    L5:
        r20 = null;
        goto L6
    }
}
