package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LandscapeTopMoreAdapter;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.widget.CustomShaderRectView;
import com.bytedance.android.livesdk.widget.GridItemDecoration;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LandscapeTopMoreDialog;", "Landroid/app/Dialog;", "Lcom/bytedance/android/livesdk/utils/y1;", "Lcom/bytedance/android/livesdk/utils/c2;", "Lcom/bytedance/android/livesdk/utils/z1;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopMoreDialog extends Dialog implements com.bytedance.android.livesdk.utils.y1, com.bytedance.android.livesdk.utils.c2, com.bytedance.android.livesdk.utils.z1, Observer<KVData> {
    public DataCenter a;
    public final int b;
    public LandscapeTopMoreAdapter c;
    public LandscapeTopMoreAdapter d;
    public final PublishSubject<List<ExtendedToolbarButton>> e;
    public long f;
    public final Stack<ExtendedToolbarButton> g;
    public boolean h;
    public final Lazy i;
    public Disposable j;
    public final int k;
    public final List<ExtendedToolbarButton> l;
    public final List<ToolbarButton> m;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LandscapeTopMoreDialog a;

        public a(LandscapeTopMoreDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            List<? extends ExtendedToolbarButton> r7 = (List) r6;
            LandscapeTopMoreDialog r0 = this.a;
            LandscapeTopMoreAdapter r1 = r0.d;
            if (r1 == null) goto L31;
            Intrinsics.checkNotNull(r1);
            com.bytedance.android.livesdk.utils.e2.c(r7, r1.c);
            com.bytedance.android.livesdk.utils.e2.f(r7, r0.f, r0.g);
            Intrinsics.checkNotNullParameter(r7, "$this$sortBySpecificRule");
            Collections.sort(r7, com.bytedance.android.livesdk.utils.d2.a);
            LandscapeTopMoreAdapter r2 = r0.d;
            Intrinsics.checkNotNull(r2);
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r3 = r2.c;
            Intrinsics.checkNotNullParameter(r7, "$this$releaseOldView");
            Intrinsics.checkNotNullParameter(r3, "toolbarManager");
            Iterator<? extends ExtendedToolbarButton> r4 = r7.iterator();
        L6:
            if (r4.hasNext() == false) goto L12;
            ExtendedToolbarButton r5 = r4.next();
            View r8 = (View) ((HashMap) r3.c).get(r5);
            if (r8 == null) goto L6;
            r3.C(r5, r8);
            ((HashMap) r3.c).remove(r5);
            goto L6
        L12:
            if (r7.isEmpty() == true) goto L24;
            LandscapeTopMoreAdapter r9 = r0.d;
            if (r9 == null) goto L24;
            Intrinsics.checkNotNull(r9);
            if (com.bytedance.android.livesdk.utils.e2.e(r7, r9.c) == false) goto L24;
            UtilityKotlinExtentionsKt.w(r0.findViewById(2131369197));
            UtilityKotlinExtentionsKt.w(r0.findViewById(2131388309));
            LandscapeTopMoreAdapter r10 = r0.d;
            if (r10 == null) goto L21;
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r10.i = r7;
        L21:
            LandscapeTopMoreAdapter r11 = r0.d;
            if (r11 == null) goto L32;
            r11.notifyDataSetChanged();
            return;
        L32:
            return;
        L24:
            UtilityKotlinExtentionsKt.t(r0.findViewById(2131369197));
            UtilityKotlinExtentionsKt.t(r0.findViewById(2131388309));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final /* synthetic */ void A() {
    }

    public final void onUnload() {
        Disposable r0 = this.j;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.livesdk.f.d().f();
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
        goto L17
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        CustomShaderRectView r0 = findViewById(2131369197);
        if (r0 == null) goto L5;
        r0.post(new a7(this));
    L5:
        DataCenter r1 = this.a;
        if (r1 == null) goto L10;
        Boolean r2 = (Boolean) r1.get("data_is_anchor", Boolean.FALSE);
        if (r2 == null) goto L10;
        boolean r3 = r2.booleanValue();
    L11:
        this.h = r3;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(r3) == false) goto L21;
        LandscapeTopMoreAdapter r4 = this.c;
        if (r4 != null) goto L16;
    L18:
        LandscapeTopMoreAdapter r5 = this.c;
        if (r5 == null) goto L21;
        r5.notifyDataSetChanged();
        goto L21
    L16:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(r4.a) == false) goto L18;
        r4.b.clear();
        RedDotHelper.b(r4.i, r4.c, r4.b);
    L21:
        DataCenter r6 = this.a;
        if (r6 == null) goto L24;
        r6.observe("cmd_live_toolbarmore_dialog_dismiss", this);
    L24:
        DataCenter r7 = this.a;
        if (r7 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z3.c(r7, false);
        return;
    L28:
        return;
    L10:
        r3 = false;
        goto L11
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((CompositeDisposable) this.i.getValue()).clear();
        DataCenter r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().a();
        DataCenter r0 = this.a;
        if (r0 == null) goto L14;
        r0.put("data_predictor_more_entrance_shwo", Boolean.TRUE);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final void K(ExtendedToolbarButton.c r3) {
        Intrinsics.checkNotNullParameter(r3, "tempAreaStateItem");
        if (com.bytedance.android.livesdk.utils.e2.d(this.l, r3) == false) goto L5;
        return;
    L5:
        List<ExtendedToolbarButton> r0 = this.l;
        com.bytedance.android.livesdk.utils.e2.b(r0, r3);
        ListProtector.add(r0, 0, r3);
        this.e.onNext(this.l);
    }

    public final void V1(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        ((CompositeDisposable) this.i.getValue()).add(r2);
    }

    public final void a(ViewGroup.MarginLayoutParams r3) {
        int r0 = this.m.size();
        if (r0 != 1) goto L5;
    L7:
        r3.rightMargin = UtilityKotlinExtentionsKt.i(45);
        return;
    L5:
        if (r0 == 2) goto L7;
        r3.rightMargin = UtilityKotlinExtentionsKt.i(20);
    }

    public final void f0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Iterator<ExtendedToolbarButton> r0 = this.l.iterator();
        int r1 = -1;
    L4:
        if (r0.hasNext() == false) goto L29;
        ExtendedToolbarButton r2 = r0.next();
        r1 = r1 + 1;
        if ((r2 instanceof ExtendedToolbarButton.c) == false) goto L4;
        if (Intrinsics.areEqual(((ExtendedToolbarButton.c) r2).s, r5) == false) goto L4;
        this.l.remove(r2);
        LandscapeTopMoreAdapter r6 = this.d;
        if (r6 == null) goto L13;
        r6.notifyItemRemoved(r1);
    L13:
        if ((!this.g.isEmpty()) == true) goto L15;
    L21:
        this.e.onNext(this.l);
        return;
    L15:
        if (this.g.contains(r2) == false) goto L18;
        this.g.remove(r2);
        goto L21
    L18:
        if (this.l.size() > this.f) goto L20;
        this.g.clear();
        goto L21
    L20:
        this.g.pop();
        goto L21
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r4.getKey(), "cmd_live_toolbarmore_dialog_dismiss") == false) goto L27;
        Handler r5 = DialogLancet.resolveDialogHandler(this);
        if (r5 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r6 == null) goto L20;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r5.getLooper()) goto L11;
        r5.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        View r12 = LayoutInflater.from(getContext()).inflate(2131565580, null);
        r12.setBackground(com.bytedance.android.live.core.utils.s1.m(this.k));
        int r0 = r12.getPaddingTop();
        int r1 = r12.getPaddingBottom();
        boolean r2 = false;
        r12.setPadding(UtilityKotlinExtentionsKt.i(0), r0, UtilityKotlinExtentionsKt.i(0), r1);
        setContentView(r12);
        Window r13 = getWindow();
        if (r13 == null) goto L5;
        r13.setDimAmount(0.0f);
        r13.setLayout(-2, -1);
        r13.setGravity(8388613);
    L5:
        DataCenter r14 = this.a;
        if (r14 == null) goto L10;
        Boolean r15 = (Boolean) r14.get("data_is_anchor", Boolean.FALSE);
        if (r15 == null) goto L10;
        r2 = r15.booleanValue();
    L10:
        this.h = r2;
        LandscapeTopMoreAdapter r16 = new LandscapeTopMoreAdapter(getContext(), this.a, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.t.a(this.m), 0, 0, new LandscapeTopMoreDialog$initView$1(this));
        this.c = r16;
        r16.a = this.h;
        LandscapeTopMoreAdapter r17 = new LandscapeTopMoreAdapter(getContext(), this.a, this.l, 0, 0, this, new LandscapeTopMoreDialog$initView$2(this));
        r17.a = this.h;
        r17.e = 32;
        r17.d = 32;
        r17.f = true;
        Unit r3 = Unit.INSTANCE;
        this.d = r17;
        if (findViewById(2131387155) == null) goto L18;
        ViewGroup.LayoutParams r4 = findViewById(2131387155).getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        a((ViewGroup.MarginLayoutParams) r4);
        findViewById(2131387155).setLayoutParams(r4);
    L17:
        findViewById(2131388309).setLayoutParams(findViewById(2131387155).getLayoutParams());
        goto L18
    L16:
        ViewGroup.MarginLayoutParams r5 = new ViewGroup.MarginLayoutParams(r4);
        a(r5);
        findViewById(2131387155).setLayoutParams(r5);
    L18:
        findViewById(2131387155).addItemDecoration(new GridItemDecoration(this.b));
        findViewById(2131387155).setAdapter(this.c);
        Context r6 = getContext();
        int r7 = this.m.size();
        int r8 = this.b;
        if (r7 > r8) goto L22;
        r8 = this.m.size();
    L22:
        GridLayoutManager r9 = new GridLayoutManager(r6, r8);
        findViewById(2131387155).setLayoutManager(r9);
        findViewById(2131388309).addItemDecoration(new GridItemDecoration(this.b));
        findViewById(2131388309).setAdapter(this.d);
        Context r10 = getContext();
        int r18 = this.m.size();
        int r19 = this.b;
        if (r18 > r19) goto L26;
        r19 = this.m.size();
    L26:
        GridLayoutManager r110 = new GridLayoutManager(r10, r19);
        findViewById(2131388309).setLayoutManager(r110);
        this.j = RxUtilKt.h(this.e).subscribe(new a(this), b.a);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r5) {
        super.onWindowFocusChanged(r5);
        if (r5 == false) goto L16;
        Window r6 = getWindow();
        int r0 = com.bytedance.android.livesdk.utils.y3.a;
        if (r6 == null) goto L17;
        View r1 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L11:
        if (r1 == null) goto L13;
        Boolean r7 = Boolean.valueOf(r1.post(new com.bytedance.android.livesdk.utils.x3(r1, r6)));
    L14:
        r7.booleanValue();
        return;
    L13:
        r7 = null;
        goto L14
    L17:
        return;
    }

    public final void setDataCenter(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }

    public final void t(List<? extends ExtendedToolbarButton.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "tempAreaStateData");
        com.bytedance.android.livesdk.utils.e2.a(this.l);
        this.g.clear();
        this.l.addAll(r2);
        this.e.onNext(this.l);
    }

    public final void z(long r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LandscapeTopMoreDialog(Context r2, List<ExtendedToolbarButton> r3, List<? extends ToolbarButton> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "tempStateAreaConfigList");
        Intrinsics.checkNotNullParameter(r4, "stableStateAreaConfigList");
        super(r2, 2131954584);
        this.l = r3;
        this.m = r4;
        this.b = 3;
        this.e = PublishSubject.create();
        this.f = 16;
        this.g = new Stack();
        this.i = LazyKt.lazy(LandscapeTopMoreDialog$compositeDispose$2.INSTANCE);
        int r5 = r4.size();
        if (r5 != 1) goto L5;
        int r6 = 2131249576;
    L9:
        this.k = r6;
        return;
    L5:
        if (r5 == 2) goto L7;
        r6 = 2131249572;
        goto L9
    L7:
        r6 = 2131249577;
        goto L9
    }

    public final void N(long r2, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "iconUrl");
        Intrinsics.checkNotNullParameter(r5, "iconName");
        Intrinsics.checkNotNullParameter(r6, "iconDescription");
        int r3 = com.bytedance.android.livesdk.utils.e2.g(this.l, String.valueOf(r2), r4, r5, r6);
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= this.l.size()) goto L11;
        LandscapeTopMoreAdapter r7 = this.d;
        if (r7 == null) goto L12;
        r7.notifyItemChanged(r3);
        return;
    L12:
        return;
    }
}
