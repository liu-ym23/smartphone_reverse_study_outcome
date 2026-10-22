package np1;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c {
    void closeSettingPanel();

    CompositeDisposable getCd();

    Context getContext();

    DataCenter getDataCenter();

    void notifyListDataChange(int r1);
}
