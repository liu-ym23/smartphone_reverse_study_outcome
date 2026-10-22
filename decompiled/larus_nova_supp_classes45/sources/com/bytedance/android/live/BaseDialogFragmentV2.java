package com.bytedance.android.live;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BaseDialogFragmentV2 extends DialogFragment {
    public BaseDialogFragmentV2() {
    }

    private void setFieldUseReflect(String r2, Object r3) {
        Field r4 = BaseDialogFragmentV2.class.getSuperclass().getDeclaredField(r2);     // Catch: Exception -> L4
        r4.setAccessible(true);     // Catch: Exception -> L4
        r4.set(this, r3);     // Catch: Exception -> L4
        return;
    }

    public int show(FragmentTransaction r4, String r5) {
        Boolean r0 = Boolean.FALSE;
        setFieldUseReflect("mDismissed", r0);
        setFieldUseReflect("mShownByMe", Boolean.TRUE);
        INVOKEVIRTUAL_com_bytedance_android_live_BaseDialogFragmentV2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r4, this, r5);
        setFieldUseReflect("mViewDestroyed", r0);
        int r6 = r4.commitAllowingStateLoss();
        setFieldUseReflect("mBackStackId", Integer.valueOf(r6));
        return r6;
    }

    public void showNow(FragmentManager r3, String r4) {
        setFieldUseReflect("mDismissed", Boolean.FALSE);
        setFieldUseReflect("mShownByMe", Boolean.TRUE);
        FragmentTransaction r5 = r3.beginTransaction();
        r5.remove(this);
        INVOKEVIRTUAL_com_bytedance_android_live_BaseDialogFragmentV2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r5, this, r4);
        r5.commitNowAllowingStateLoss();     // Catch: Throwable -> L5
        return;
    L5:
        r5.commitAllowingStateLoss();
    }

    public void show(FragmentManager r3, String r4) {
        setFieldUseReflect("mDismissed", Boolean.FALSE);
        setFieldUseReflect("mShownByMe", Boolean.TRUE);
        FragmentTransaction r5 = r3.beginTransaction();
        INVOKEVIRTUAL_com_bytedance_android_live_BaseDialogFragmentV2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r5, this, r4);
        r5.commitAllowingStateLoss();
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_android_live_BaseDialogFragmentV2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }
}
