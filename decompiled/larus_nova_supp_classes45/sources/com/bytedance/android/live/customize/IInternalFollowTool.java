package com.bytedance.android.live.customize;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.user.b;
import com.bytedance.android.livesdk.user.m;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H&J4\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u0006H&J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH&J\u001c\u0010\u0012\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0017\u001a\u00020\u0014H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/customize/IInternalFollowTool;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", NewBroadcastMonitor.PAGE.ROOM, "Lkotlin/Function1;", "", "Lcom/bytedance/android/livesdk/user/b;", "paramBuilder", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/depend/model/follow/FollowPair;", "makeFollowByRoom", "Lcom/bytedance/android/livesdk/user/m;", "makeUnFollowByRoom", "followPair", "", "showToastWithFollowStateSyncCheck", "shouldTreatAsFollowed", "", "", "logExtra", "showFollowSyncDialog", "openUserId", "getUnFollowDialogText", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInternalFollowTool extends IService {
    Observable<String> getUnFollowDialogText(String r1);

    Observable<FollowPair> makeFollowByRoom(Context r1, Room r2, Function1<? super Boolean, ? extends b> r3);

    Observable<FollowPair> makeUnFollowByRoom(Context r1, Room r2, Function1<? super Boolean, ? extends m> r3);

    boolean shouldTreatAsFollowed(Room r1, FollowPair r2);

    Observable<Boolean> showFollowSyncDialog(Context r1, Map<String, String> r2);

    void showToastWithFollowStateSyncCheck(Context r1, Room r2, FollowPair r3);
}
