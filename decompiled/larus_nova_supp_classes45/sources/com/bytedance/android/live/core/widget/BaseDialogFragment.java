package com.bytedance.android.live.core.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.BaseDialogFragmentV2;
import com.bytedance.common.utility.collection.WeakContainer;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BaseDialogFragment extends BaseDialogFragmentV2 implements tw2.b {
    private static final int DELAY_100_MS = 100;
    private WeakContainer<tb1.b> mMonitors;
    private DialogInterface.OnDismissListener mOnClickListener;
    protected boolean mSoftKeyIsShow;
    protected boolean mStatusActive;
    protected boolean mStatusDestroyed;
    protected boolean mStatusViewValid;

    public static /* synthetic */ void S90(BaseDialogFragment r0, View r1) {
        r0.lambda$showIme$1(r1);
    }

    public static /* synthetic */ boolean T90(BaseDialogFragment r0, DialogInterface r1, int r2, KeyEvent r3) {
        return r0.lambda$onViewCreated$0(r1, r2, r3);
    }

    public static /* synthetic */ int access$000(BaseDialogFragmentV2 r0, FragmentTransaction r1, String r2) {
        return super.show(r1, r2);
    }

    public static /* synthetic */ void access$001(BaseDialogFragmentV2 r0, FragmentManager r1, String r2) {
        super.show(r1, r2);
    }

    public static /* synthetic */ void access$002(BaseDialogFragmentV2 r0, FragmentManager r1, String r2) {
        super.showNow(r1, r2);
    }

    public Map<String, Object> getEnvData() {
        return null;
    }

    public Map<String, Object> getPropertyParams() {
        return null;
    }

    public String getSpm() {
        return null;
    }

    public boolean isIgnored() {
        return false;
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onDismiss(DialogInterface r1) {
        com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onDismiss(this, r1);
    }

    public void setUpWindowParams(int r1) {
    }

    public BaseDialogFragment() {
        this.mMonitors = new WeakContainer();
    }

    public boolean isShowing() {
        if (getDialog() != null) goto L5;
    L7:
        return false;
    L5:
        if (getDialog().isShowing() == false) goto L7;
        return true;
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.mStatusViewValid = false;
        this.mStatusDestroyed = true;
        if (this.mMonitors.isEmpty() == true) goto L17;
        Iterator r0 = this.mMonitors.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        tb1.b r1 = (tb1.b) r0.next();
        if (r1 == null) goto L6;
        r1.onDestroy();
        goto L6
    L10:
        this.mMonitors.clear();
        return;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mStatusViewValid = false;
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if (this.mMonitors.isEmpty() == true) goto L10;
        Iterator r0 = this.mMonitors.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        tb1.b r1 = (tb1.b) r0.next();
        if (r1 == null) goto L6;
        r1.onPause();
        goto L6
    L16:
        return;
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        this.mStatusActive = true;
        if (this.mMonitors.isEmpty() == true) goto L10;
        Iterator r0 = this.mMonitors.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        tb1.b r1 = (tb1.b) r0.next();
        if (r1 == null) goto L6;
        r1.onResume();
        goto L6
    L16:
        return;
    }

    public void onStop() {
        super.onStop();
        this.mStatusActive = false;
        if (this.mMonitors.isEmpty() == true) goto L10;
        Iterator r0 = this.mMonitors.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        tb1.b r1 = (tb1.b) r0.next();
        if (r1 == null) goto L6;
        r1.onStop();
        goto L6
    L16:
        return;
    }

    public boolean isActive() {
        return this.mStatusActive;
    }

    public boolean isDestroyed() {
        return this.mStatusDestroyed;
    }

    public boolean isViewValid() {
        return this.mStatusViewValid;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(BaseDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(BaseDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    private /* synthetic */ void lambda$showIme$1(View r3) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        r3.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(r3, 1);
        setUpWindowParams(0);
        this.mSoftKeyIsShow = true;
    }

    public void com_bytedance_android_live_core_widget_BaseDialogFragment__onDismiss$___twin___(DialogInterface r2) {
        super.onDismiss(r2);
        DialogInterface.OnDismissListener r0 = this.mOnClickListener;
        if (r0 == null) goto L6;
        r0.onDismiss(r2);
        return;
    }

    public void onCancel(DialogInterface r1) {
        super.onCancel(r1);
        INVOKEVIRTUAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this);     // Catch: IllegalStateException -> L5
        return;
    L5:
        INVOKEVIRTUAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this);
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mStatusActive = false;
        this.mStatusViewValid = false;
        this.mStatusDestroyed = false;
    }

    public void onSaveInstanceState(Bundle r3) {
        if (r3 == null) goto L4;
        r3.putBoolean("WORKAROUND_FOR_BUG_19917_KEY", true);
    L4:
        super.onSaveInstanceState(r3);
    }

    public void registerLifeCycleMonitor(tb1.b r2) {
        this.mMonitors.add(r2);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener r1) {
        this.mOnClickListener = r1;
    }

    public void showIme(final View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        r4.postDelayed(new a(this, r4), 100);
    }

    public void unregisterLifeCycleMonitor(tb1.b r2) {
        this.mMonitors.remove(r2);
    }

    public static void com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onDismiss(BaseDialogFragment r1, DialogInterface r2) {
        r1.com_bytedance_android_live_core_widget_BaseDialogFragment__onDismiss$___twin___(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r1.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r1);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r1);
        return;
    L5:
        th = move-exception;
        if ((r1 instanceof DialogFragment) == false) goto L9;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r1.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r1);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r1);
    L9:
        throw th;
    }

    public static void show(FragmentManager r1, BaseDialogFragment r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        INVOKEVIRTUAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r2, r1, r2.getClass().getCanonicalName());
        return;
    L8:
        return;
    }

    public void hideIme(View r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (getActivity() == null) goto L9;
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(r3.getWindowToken(), 0);
        setUpWindowParams(r4);
        this.mSoftKeyIsShow = false;
        return;
    }

    public void onViewCreated(View r1, Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r1, r2);
        this.mStatusViewValid = true;
        getDialog().setOnKeyListener(new b(this));
    }

    @Override // com.bytedance.android.live.BaseDialogFragmentV2
    public void showNow(FragmentManager r1, String r2) {
        INVOKESPECIAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_showNow(this, r1, r2);
    }

    public static void show(FragmentActivity r1, DialogFragment r2) {
        show(r1, r2, r2.getClass().getCanonicalName());
    }

    @Override // com.bytedance.android.live.BaseDialogFragmentV2
    public int show(FragmentTransaction r1, String r2) {
        return INVOKESPECIAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(this, r1, r2);
    }

    @Override // com.bytedance.android.live.BaseDialogFragmentV2
    public void show(FragmentManager r1, String r2) {
        INVOKESPECIAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(this, r1, r2);
    }

    public static int INVOKESPECIAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(BaseDialogFragmentV2 r2, FragmentTransaction r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        BaseDialogFragmentV2 r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r0, r1) == false) goto L14;
        return -1;
    L14:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L12:
        return access$000(r2, r3, r4);
    L5:
        r0 = null;
        goto L6
    }

    public static void INVOKESPECIAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_showNow(BaseDialogFragmentV2 r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        BaseDialogFragmentV2 r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        access$002(r2, r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ boolean lambda$onViewCreated$0(DialogInterface r1, int r2, KeyEvent r3) {
        if (4 == r2) goto L5;
        return false;
    L5:
        if (1 == r3.getAction()) goto L7;
        return false;
    L7:
        return onBackPressed();
    }

    public static void show(FragmentActivity r0, DialogFragment r1, String r2) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        INVOKEVIRTUAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r1, r0.getSupportFragmentManager(), r2);
        return;
    L8:
        return;
    }

    public static void INVOKESPECIAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(BaseDialogFragmentV2 r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        BaseDialogFragmentV2 r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        access$001(r2, r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_core_widget_BaseDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(BaseDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        BaseDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
