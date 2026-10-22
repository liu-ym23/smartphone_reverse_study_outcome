package o80;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.rxutils.rxlifecycle.BindingFragment;
import com.bytedance.android.live.core.utils.rxutils.rxlifecycle.LifecycleEvent;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<V> {
    public final Observable<V> a;

    public a(BehaviorSubject r1) {
        this.a = r1;
    }

    public static a<LifecycleEvent> a(FragmentManager r4) {
        BindingFragment r1 = (BindingFragment) r4.findFragmentByTag("_LIVE_LIFECYCLE_BINDING_FRAGMENT_");
        if (r1 != null) goto L10;
        r1 = new BindingFragment();
        FragmentTransaction r5 = r4.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "_LIVE_LIFECYCLE_BINDING_FRAGMENT_", 0) == true) goto L8;
        r5.add(r1, "_LIVE_LIFECYCLE_BINDING_FRAGMENT_");
    L8:
        r5.commitAllowingStateLoss();
    L13:
        return new a(r1.d);
    L10:
        if (r1.isDetached() == false) goto L13;
        FragmentTransaction r6 = r4.beginTransaction();
        r6.attach(r1);
        r6.commitAllowingStateLoss();
        goto L13
    }
}
