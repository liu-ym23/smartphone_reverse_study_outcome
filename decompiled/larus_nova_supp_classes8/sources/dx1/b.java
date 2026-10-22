package dx1;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    FeedbackCard getLiveRoomFeedback(long r1);

    FeedbackCard getPreviewFeedback(long r1);

    FeedItem getRoomFeedback(long r1);

    void insertLiveRoomFeedback(long r1, Function1<? super FeedbackCard, Unit> r3);

    void insertRoomFeedback(long r1, Function1<? super FeedItem, Unit> r3);

    void onReadFeedback(FeedItem r1);

    void removeLiveRoomFeedback(long r1, Function1<? super FeedbackCard, Unit> r3);

    void removePreviewFeedback(long r1);

    void removeRoomFeedback(long r1, Function1<? super FeedItem, Unit> r3);

    void saveLiveRoomFeedback(long r1, FeedbackCard r3);

    void savePreviewFeedback(long r1, Bundle r3);

    void saveRoomFeedback(long r1, FeedItem r3);

    void saveUnReadFeedback(FeedItem r1, String r2);
}
