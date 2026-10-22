package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.e;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.widget.MaxHeightRecyclerView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/viewmodel/CommonShelfDisplayViewModel;", "VM", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CommonShelfDisplayDialog<VM extends CommonShelfDisplayViewModel<?>> extends BottomSheetDialogFragment {
    public static final int i = 0;
    public Map<Integer, View> d;
    public final Lazy e;
    public View f;
    public View g;
    public MultiTypeAdapter h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CommonShelfDisplayDialog a;

        public b(CommonShelfDisplayDialog r1) {
            this.a = r1;
        }

        public final void a() {
            MaxHeightRecyclerView r0 = this.a.T90(2131386216);
            Integer r2 = Integer.valueOf(this.a.U90());
            if (r2.intValue() == 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == true) goto L9;
            r2 = null;
        L9:
            if (r2 == null) goto L11;
            int r4 = r2.intValue();
        L12:
            r0.setMaxHeight(r4 - this.a.X90().getHeight());
            this.a.T90(2131386216).requestLayout();
            return;
        L11:
            int r5 = CommonShelfDisplayDialog.i;
            r4 = CommonShelfDisplayDialog.i;
            goto L12
        L5:
            r3 = false;
            goto L6
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
    }

    public static final class c implements LinkCastItemViewHolder.a {
        public final /* synthetic */ CommonShelfDisplayDialog a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.LinkCastItemViewHolder.a
        public final void onClick() {
            this.a.W90().openLinkCastPage();
        }

        public c(CommonShelfDisplayDialog r1) {
            this.a = r1;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ CommonShelfDisplayDialog a;

        public d(CommonShelfDisplayDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == true) goto L12;
            return;
        L12:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L15;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public abstract int U90();

    public final VM W90() {
        return (VM) this.e.getValue();
    }

    public abstract View Y90(View r1);

    public abstract VM Z90();

    static {
        i = UtilityKotlinExtentionsKt.i(592);
    }

    public void S90() {
        this.d.clear();
    }

    public final MultiTypeAdapter V90() {
        MultiTypeAdapter r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("shelfDisplayAdapter");
    L5:
        return r0;
    }

    public final View X90() {
        View r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topView");
    L5:
        return r0;
    }

    public CommonShelfDisplayDialog() {
        new CompositeDisposable();
        this.d = new LinkedHashMap();
        this.e = InfraKotlinExtsKt.mainThreadLazy(new CommonShelfDisplayDialog$shelfDisplayViewModel$2(this));
    }

    public void initView() {
        T90(2131386216).post(new b(this));
        T90(2131386216).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        T90(2131386216).addItemDecoration(new SpaceItemDecoration(1, UtilityKotlinExtentionsKt.i(8), true));
        MultiTypeAdapter r1 = new MultiTypeAdapter();
        T90(2131386216).setAdapter(r1);
        Unit r0 = Unit.INSTANCE;
        this.h = r1;
        r1.z2(wq0.a.class, new com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.a(new c(this)));
        W90().getDismiss().observe(this, new d(this));
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        S90();
    }

    public View T90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.d).get(2131386216);
        if (r4 != null) goto L14;
        View r5 = getView();
        if (r5 == null) goto L12;
        View r6 = r5.findViewById(2131386216);
        if (r6 == null) goto L12;
        this.d.put(2131386216, r6);
        return r6;
    L12:
        return null;
    L14:
        return r4;
    }

    public final void aa0(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "fragmentActivity");
        FragmentManager r4 = r3.getSupportFragmentManager();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "CommonShelfDisplayDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        show(r4, "CommonShelfDisplayDialog");
        return;
    }

    public void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L12
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L12
    L9:
        e.b().d();     // Catch: Throwable -> L12
        f.d().f();     // Catch: Throwable -> L12
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        Dialog r7 = getDialog();
        if (r7 == null) goto L28;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L28;
        r8.setLayout(-1, -1);
        int r1 = U90();
        FrameLayout r9 = (FrameLayout) r8.findViewById(2131368870);
        if (r9 == null) goto L9;
        r9.getLayoutParams().width = -1;
        r9.getLayoutParams().height = -2;
        r9.setBackgroundResource(R.color.transparent);
    L9:
        BottomSheetBehavior r10 = BottomSheetBehavior.from(r9);
        r10.setHideable(false);
        Integer r2 = Integer.valueOf(r1);
        if (r2.intValue() == 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        int r4 = r2.intValue();
    L19:
        r10.setPeekHeight(r4);
        if (r1 == 0) goto L28;
        ConstraintLayout r11 = this.f;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L24:
        if (r11 == null) goto L27;
        ConstraintLayout r12 = r11;
        Intrinsics.checkNotNullParameter(r12, "$this$setHeight");
        r12.getLayoutParams().height = r1;
        r12.requestLayout();
        r12.setMinHeight(0);
        r12.setMaxHeight(Integer.MAX_VALUE);
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L18:
        r4 = i;
        goto L19
    L12:
        r3 = false;
    L28:
        W90().initData();
        initView();
        HashMap<String, zo0.f> r13 = g.a;
        zo0.f r14 = h.b(PerformanceScene.SHELF_DIALOG);
        int r0 = zo0.f.d;
        r14.l("view_created", null);
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        if (isAdded() == false) goto L6;
        return;
    L6:
        if (r3.findFragmentByTag(r4) == null) goto L8;
        return;
    L8:
        e.b().a();
        f.d().a();
        FragmentTransaction r5 = r3.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == true) goto L12;
        r5.add(this, r4);
    L12:
        r5.commitAllowingStateLoss();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566966, r3, false);
        this.f = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        this.g = Y90(r5);
        View r6 = this.f;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        return r6;
    }
}
