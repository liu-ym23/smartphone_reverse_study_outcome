package com.bytedance.android.live.liveinteract.linkpanel.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.util.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.util.z;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.linkpanel.widget.GuestApplyContentWidget;
import com.bytedance.android.live.liveinteract.linkpanel.widget.GuestApplyTopBarWidget;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/dialog/GuestApplyDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lxf0/a;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestApplyDialog extends LiveDialogFragment implements xf0.a {
    public static final /* synthetic */ int o = 0;
    public IRoom d;
    public Function0<Unit> e;
    public a5 f;
    public int g;
    public WidgetManager h;
    public final Lazy i;
    public boolean j;
    public String k;
    public GuestApplyTopBarWidget l;
    public GuestApplyContentWidget m;
    public final b n;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ GuestApplyDialog a;

        public b(GuestApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            Integer r13 = (Integer) r12;
            if (r13 != null) goto L5;
            return;
        L5:
            if (r13.intValue() != 0) goto L14;
            GuestApplyDialog r14 = this.a;
            int r0 = GuestApplyDialog.o;
            GuestApplyViewModel r2 = r14.S90();
            if (r2 == null) goto L35;
            GuestApplyDialog r15 = this.a;
            IRoom r4 = r15.d;
            GuestApplyContentWidget r16 = r15.m;
            if (r16 == null) goto L11;
            int r6 = r16.n;
        L12:
            GuestApplyViewModel.fetchList$default(r2, true, r4, null, r6, 0, false, 52, null);
            return;
        L11:
            r6 = 0;
            goto L12
        L35:
            return;
        L14:
            if (r13.intValue() != 1) goto L23;
            GuestApplyDialog r17 = this.a;
            int r1 = GuestApplyDialog.o;
            GuestApplyViewModel r3 = r17.S90();
            if (r3 == null) goto L37;
            GuestApplyDialog r18 = this.a;
            IRoom r5 = r18.d;
            GuestApplyContentWidget r19 = r18.m;
            if (r19 == null) goto L20;
            int r7 = r19.n;
        L21:
            GuestApplyViewModel.fetchList$default(r3, true, r5, null, r7, 0, false, 52, null);
            return;
        L20:
            r7 = 0;
            goto L21
        L37:
            return;
        L23:
            if (r13.intValue() == 2) goto L32;
            return;
        L32:
            this.a.dismiss();     // Catch: Exception -> L27
            return;
        L27:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r110 = DialogFragmentLancet.sLastShowStack;
            if (r110 == null) goto L40;
            com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ GuestApplyDialog a;

        public d(GuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            GuestApplyDialog r4 = this.a;
            int r0 = GuestApplyDialog.o;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L17;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L18;
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class e<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            if (r6 == null) goto L13;
            int r1 = r6.intValue();
            if (r1 == 71) goto L12;
            if (r1 == 41) goto L12;
            if (r1 != 42) goto L11;
            com.bytedance.android.livesdk.sharedpref.e r2 = b6.B;
            r2.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r2, 42);
            goto L13
        L11:
            com.bytedance.android.livesdk.sharedpref.e r3 = b6.B;
            r3.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r3, 40);
        L12:
            com.bytedance.android.livesdk.sharedpref.e r4 = b6.B;
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, 41);
        L13:
            if (r6 != null) goto L16;
            com.bytedance.android.livesdk.sharedpref.e r7 = b6.B;
            r7.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r7, 40);
            return;
        }
    }

    static {
    }

    public final GuestApplyViewModel S90() {
        return (GuestApplyViewModel) this.i.getValue();
    }

    public GuestApplyDialog() {
        this.g = -1;
        this.i = LazyKt.lazy(LazyThreadSafetyMode.NONE, GuestApplyDialog$vm$2.INSTANCE);
        this.n = new b(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        t61 r0 = z.a();
        if (r0 != null) goto L5;
    L18:
        hd0.c.f().e(this.n);
        return;
    L5:
        if (u61.c(r0) != true) goto L18;
        WidgetManager r1 = this.h;
        if (r1 == null) goto L9;
        r1.unload(this.l);
    L9:
        WidgetManager r2 = this.h;
        if (r2 == null) goto L12;
        r2.unload(this.m);
    L12:
        WidgetManager r3 = this.h;
        if (r3 == null) goto L15;
        r3.contentView = null;
    L15:
        this.h = null;
        this.l = null;
        this.m = null;
        Function0<Unit> r4 = this.e;
        if (r4 == null) goto L18;
        r4.invoke();
        this.e = null;
        goto L18
    }

    @Deprecated(message = "Deprecated in Java")
    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L12;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L12;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setGravity(80);
        r7.setSoftInputMode(48);
        c1.b(r7, 0, 14);
    L12:
        setBottomSheetSlideProcessor(c.a);
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setStyle(1, 2131954719);
        String r0 = this.k;
        LinkedHashMap r1 = new LinkedHashMap();
        m.G(r1);
        m.B(r1, null, 6);
        m.z(r1);
        if (r0 == null) goto L5;
        r1.put("request_page", r0);
    L5:
        m.H(r1, Integer.valueOf(o.c()));
        j0.l().sendLog("livesdk_guest_connection_apply_page_show", r1, new Object[]{IRoom.class});
        Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 != null) goto L9;
    L10:
        hd0.c.f().c(this.n);
        return;
    L9:
        if (r6.intValue() != 2) goto L10;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new d(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L15
        this.j = false;     // Catch: Throwable -> L15
        GuestApplyContentWidget r1 = this.m;     // Catch: Throwable -> L15
        if (r1 == null) goto L5;
        r1.m = false;     // Catch: Throwable -> L15
    L5:
        super.onDismiss(r3);     // Catch: Throwable -> L15
        GuestApplyViewModel r4 = S90();     // Catch: Throwable -> L15
        if (r4 == null) goto L8;
        r4.release();     // Catch: Throwable -> L15
    L8:
        GuestApplyViewModel r5 = S90();     // Catch: Throwable -> L15
        if (r5 == null) goto L13;
        LiveData<Integer> r6 = r5.getSortTypeLiveData();     // Catch: Throwable -> L15
        if (r6 == null) goto L13;
        r6.removeObservers(this);     // Catch: Throwable -> L15
    L13:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L15:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        this.l = new GuestApplyTopBarWidget(S90(), this.d, this.g);
        WidgetManager r8 = WidgetManager.of(this, r6);
        this.h = r8;
        if (r8 == null) goto L5;
        r8.load(2131389241, this.l);
    L5:
        GuestApplyContentWidget r9 = new GuestApplyContentWidget(S90(), this.d, this);
        this.m = r9;
        WidgetManager r2 = this.h;
        if (r2 == null) goto L8;
        r2.load(2131374053, r9);
    L8:
        int r10 = c1.a;
        if (e5.n() == false) goto L29;
        FrameLayout r11 = (FrameLayout) r6.findViewById(2131374053);
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof ConstraintLayout.LayoutParams) == true) goto L13;
        r12 = null;
    L13:
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        if (r13 == null) goto L29;
        ((ViewGroup.MarginLayoutParams) r13).height = s1.w() - s1.f(56.0f);
        r11.setLayoutParams(r13);
    L29:
        ALogger.i("GuestApplyDialog", "sortTypeLiveData start observe owner = " + this);     // Catch: Exception -> L27
        GuestApplyViewModel r14 = S90();     // Catch: Exception -> L27
        if (r14 == null) goto L21;
        LiveData<Integer> r15 = r14.getSortTypeLiveData();     // Catch: Exception -> L27
        if (r15 == null) goto L21;
        r15.removeObservers(this);     // Catch: Exception -> L27
    L21:
        GuestApplyViewModel r16 = S90();     // Catch: Exception -> L27
        if (r16 == null) goto L31;
        LiveData<Integer> r17 = r16.getSortTypeLiveData();     // Catch: Exception -> L27
        if (r17 == null) goto L32;
        r17.observe(this, e.a);     // Catch: Exception -> L27
        return;
    L32:
        return;
    L31:
        return;
    L27:
        ALogger.e("GuestApplyDialog", "sortTypeLiveData observe err. owner = " + this);
    }

    public final void show(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (isShowing() == false) goto L5;
        return;
    L5:
        if (this.j == true) goto L20;
        this.j = true;
        this.k = r3;
        FragmentActivity r4 = ContextUtil.contextToFragmentActivity(r2);
        if (r4 == null) goto L21;
        FragmentManager r5 = r4.getSupportFragmentManager();
        if (r5 == null) goto L22;
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "GuestApplyDialog", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, this, r6) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        show(r5, "GuestApplyDialog");
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565481, r2);
    }
}
