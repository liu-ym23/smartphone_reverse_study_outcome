package com.bytedance.android.live.broadcastgame.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.g0;
import com.bytedance.android.live.broadcastgame.network.BroadcastGameApi;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import j20.e;
import j20.f;
import j20.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/view/InteractGameFeedbackDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractGameFeedbackDialog extends CommonBottomDialog {
    public static final /* synthetic */ int i = 0;
    public j20.a a;
    public final Set<String> b;
    public Disposable c;
    public Disposable d;
    public final long e;
    public final long f;
    public final int g;
    public final boolean h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InteractGameFeedbackDialog a;

        public b(InteractGameFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Object r0 = r3.getTag();
            if (r0 == null) goto L10;
            r3.setSelected(!r3.isSelected());
            if (r3.isSelected() == false) goto L7;
            this.a.b.add(r0.toString());
        L8:
            InteractGameFeedbackDialog r4 = this.a;
            int r1 = InteractGameFeedbackDialog.i;
            r4.N0();
            return;
        L7:
            this.a.b.remove(r0.toString());
            goto L8
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InteractGameFeedbackDialog a;

        public c(InteractGameFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (this.a.b.isEmpty() == false) goto L6;
            f2.c("请选择要反馈的玩法存在的问题", 0);
            return;
        L6:
            InteractGameFeedbackDialog r6 = this.a;
            Set<String> r0 = r6.b;
            String r1 = ((EditText) r6.findViewById(2131383092)).getText().toString();
            if (r6.d != null) goto L16;
            StringBuilder r2 = new StringBuilder();
            Iterator<T> r3 = r0.iterator();
        L11:
            if (r3.hasNext() == false) goto L13;
            r2.append((String) r3.next());
            r2.append("|");
            goto L11
        L13:
            r2.append(r1);
            RequestBody r4 = RequestBody.create(MediaType.parse("text/plain"), r2.toString());
            int r7 = g0.a;
            Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
            r6.d = ((BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class)).postGameFeedback(r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r6), new g(r6));
            return;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ InteractGameFeedbackDialog a;

        public d(InteractGameFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Rect r0 = new Rect();
            Window r1 = this.a.getWindow();
            if (r1 == null) goto L7;
            View r2 = a(r1);
            if (r2 == null) goto L7;
            r2.getWindowVisibleDisplayFrame(r0);
        L7:
            Window r3 = this.a.getWindow();
            if (r3 == null) goto L29;
            View r4 = a(r3);
            if (r4 == null) goto L30;
            View r5 = r4.getRootView();
            if (r5 == null) goto L31;
            int r6 = r5.getHeight() - r0.bottom;
            float r7 = (((Button) this.a.findViewById(2131387572)).getBottom() - ((EditText) this.a.findViewById(2131383092)).getBottom()) + s1.f(5.0f);
            if (r6 <= 0) goto L23;
            if ((this.a.findViewById(2131372303).getParent() instanceof View) == false) goto L32;
            Object r8 = this.a.findViewById(2131372303).getParent();
            if (r8 == null) goto L21;
            ((View) r8).setTranslationY(r7);
            return;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L32:
            return;
        L23:
            if ((this.a.findViewById(2131372303).getParent() instanceof View) == false) goto L34;
            Object r9 = this.a.findViewById(2131372303).getParent();
            if (r9 == null) goto L28;
            ((View) r9).setTranslationY(0.0f);
            return;
        L28:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L34:
            return;
        L31:
            return;
        L30:
            return;
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
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (this.h == true) goto L11;
        Context r0 = getContext();
        if ((r0 instanceof ContextThemeWrapper) == true) goto L7;
        r0 = null;
    L7:
        ContextThemeWrapper r1 = (ContextThemeWrapper) r0;
        if (r1 == null) goto L11;
        r1.setTheme(2131954639);
    L11:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public final void N0() {
        ((Button) findViewById(2131387572)).setEnabled(!this.b.isEmpty());
        if ((!this.b.isEmpty()) == false) goto L5;
        String r1 = "#ffffff";
    L6:
        ((Button) findViewById(2131387572)).setTextColor(ColorProtector.parseColor(r1));
        return;
    L5:
        r1 = "#57ffffff";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getLayoutId() {
        Window r0 = getWindow();
        if (r0 == null) goto L7;
        r0.setSoftInputMode(18);
        return 2131565521;
    L7:
        return 2131565521;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ArrayList r0 = new ArrayList();
        r0.add("不理解规则");
        r0.add("画面卡顿延迟");
        r0.add("玩法无趣");
        r0.add("违法违禁");
        r0.add("政治敏感");
        r0.add("淫秽色情");
        r0.add("广告欺骗");
        Disposable r1 = this.c;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        int r2 = g0.a;
        Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
        this.c = ((BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class)).getGameFeedbackTagList(this.f, this.e, this.g).compose(RxUtil.rxSchedulerHelper()).subscribe(new j20.d(this), new e(this, r0));
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.d;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void M0(InteractGameFeedbackDialog r3) {
        Disposable r0 = r3.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        r3.d = null;
        Handler r1 = DialogLancet.resolveDialogHandler(r3);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        this.a = new j20.a(new b(this));
        RecyclerView r0 = findViewById(2131383094);
        j20.a r1 = this.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r0.setAdapter(r1);
        findViewById(2131383094).setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        findViewById(2131383094).addItemDecoration(new AnonymousClass2());
        if (this.h == false) goto L22;
        Window r8 = getWindow();
        if (r8 == null) goto L12;
        WindowManager.LayoutParams r9 = r8.getAttributes();
        if (r9 == null) goto L12;
        r9.width = s1.f(390.0f);
    L12:
        Window r11 = getWindow();
        if (r11 == null) goto L15;
        r11.setGravity(5);
    L15:
        Drawable r2 = findViewById(2131372303).getBackground();
        if ((r2 instanceof GradientDrawable) == true) goto L18;
        r2 = null;
    L18:
        GradientDrawable r3 = (GradientDrawable) r2;
        a1.k(findViewById(2131372303), s1.q(getContext()).heightPixels);
        float r12 = s1.e(12.0f);
        if (r3 == null) goto L21;
        r3.setCornerRadii(new float[]{r12, r12, 0.0f, 0.0f, 0.0f, 0.0f, r12, r12});
    L21:
        t8.d(getWindow());
    L22:
        N0();
        ((Button) findViewById(2131387572)).setOnClickListener(new c(this));
        if (this.h == true) goto L36;
        Window r13 = getWindow();
        if (r13 == null) goto L37;
        View r14 = r13.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L31;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L31;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L31:
        if (r14 == null) goto L38;
        ViewTreeObserver r15 = r14.getViewTreeObserver();
        if (r15 == null) goto L39;
        r15.addOnGlobalLayoutListener(new d(this));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r2) {
        super/*android.app.Dialog*/.onWindowFocusChanged(r2);
        if (this.h == false) goto L7;
        if (r2 == false) goto L8;
        t8.d(getWindow());
        return;
    L8:
        return;
    }

    public InteractGameFeedbackDialog(Context r2, long r3, long r5, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r8, false);
        this.e = r3;
        this.f = r5;
        this.g = r7;
        this.h = r8;
        this.b = new LinkedHashSet();
    }
}
