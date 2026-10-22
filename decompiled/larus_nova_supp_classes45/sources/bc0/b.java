package bc0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {
    void a(TuningButtonListAdapter r1);

    void b(LifecycleOwner r1);

    int c();

    void clearData();

    void d(TuningButtonListAdapter r1, WeakReference r2, LifecycleOwner r3);

    void e(TuningButtonListAdapter r1, ac0.a r2, boolean r3);
}
