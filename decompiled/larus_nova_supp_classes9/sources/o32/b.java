package o32;

import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    m<Integer> getAnnouncementBottom();

    boolean getCleared();

    k<HighlightItem> getItemDisplayEndEvent();

    m<Integer> getPinContainerBottom();

    n<Map<String, HighlightItem>> getReviewingPinAndQAHighlightItems();

    m<Boolean> isAnnouncementShown();

    m<Boolean> isPinContainerShown();
}
