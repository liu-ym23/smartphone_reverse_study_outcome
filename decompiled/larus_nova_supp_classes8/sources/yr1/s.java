package yr1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface s {
    void a(DataCenter r1, Observer<KVData> r2);

    boolean c(DataCenter r1);

    NextLiveData<Boolean> d();

    MutableLiveData<Boolean> f();

    void g(DataCenter r1, Observer<KVData> r2);

    void h(DataCenter r1, int r2);
}
