package kq1;

import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.replay.paid.PaidReplayScene;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    MutableLiveData<Integer> a();

    void b(FrameLayout r1, ReplayPaidInfo r2, @PaidReplayScene String r3, Map<String, String> r4, vlc.d r5, boolean r6);

    long c(long r1);

    MutableLiveData<Long> getReplayPaidCountDown();

    void release();

    void setOnBuyTicketAction(Function0<Unit> r1);
}
