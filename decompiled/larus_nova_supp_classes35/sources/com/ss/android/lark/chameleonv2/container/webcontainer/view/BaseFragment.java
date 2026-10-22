package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import sa5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseFragment extends LifeCycleFragment implements sa5.d, q {
    public BaseFragment() {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_BaseFragment", getClass().getSimpleName().concat(" constructor"));
    }

    public Context getContext() {
        Context r0 = super/*androidx.fragment.app.Fragment*/.getContext();
        if (r0 != null) goto L5;
        return null;
    L5:
        return swb.h.a(r0);
    }

    public final boolean onBackPressed() {
        List r0 = getChildFragmentManager().getFragments();
        if (r0 == null) goto L13;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L19;
        sa5.d r3 = (Fragment) ListProtector.get(r0, r1);
        if ((r3 instanceof sa5.d) == false) goto L12;
        if (r3.onBackPressed() == false) goto L12;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_BaseFragment", "Back press consumed by :" + r3);
        return true;
    L12:
        r1 = r1 - 1;
        goto L5
    L19:
        return false;
    L13:
        return false;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_BaseFragment", getClass().getSimpleName().concat(" onDestroy"));
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_BaseFragment", getClass().getSimpleName().concat(" onDetach"));
    }

    public final boolean dispatchKeyEvent(KeyEvent r4) {
        if (r4.getKeyCode() != 4) goto L5;
        r4.getAction();
    L5:
        return false;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_BaseFragment", getClass().getSimpleName().concat(" onCreate"));
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r1, r2);
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_BaseFragment", getClass().getSimpleName().concat(" onViewCreated"));
    }
}
