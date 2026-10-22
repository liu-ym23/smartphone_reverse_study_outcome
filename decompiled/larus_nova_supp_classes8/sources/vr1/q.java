package vr1;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface q {
    Boolean allowQuickRecordShare();

    Boolean allowQuickShotShare();

    HashMap<String, String> generateShareLogParams(DataCenter r1, String r2);

    void launchMatchShare(Context r1, boolean r2, MatchShareParam r3);

    void logQuickRecordAudioOpen(Map<String, String> r1);

    void logQuickRecordBtnClick(long r1);

    void logQuickRecordBtnShow(DataCenter r1);

    void logQuickRecordShareDialogClick();

    void logQuickRecordShareDialogShow(long r1, long r3);

    void logQuickRecordTaskFinish(Map<String, String> r1);

    void logQuickShotBtnClick(long r1);

    void logQuickShotBtnShow(DataCenter r1);

    void logQuickShotFinish(Map<String, String> r1);

    void logQuickShotShareDialogClick();

    void logQuickShotShareDialogShow(long r1);

    void showShareDialog(FragmentActivity r1, MatchShareParam r2, CollectionItem r3);
}
