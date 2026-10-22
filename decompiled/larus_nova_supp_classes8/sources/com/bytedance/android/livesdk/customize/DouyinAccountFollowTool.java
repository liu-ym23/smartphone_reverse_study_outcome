package com.bytedance.android.livesdk.customize;

import android.content.Context;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.customize.IInternalFollowTool;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.user.b;
import com.bytedance.android.livesdk.user.m;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J4\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u0006H\u0016J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/customize/DouyinAccountFollowTool;", "Lcom/bytedance/android/live/customize/IInternalFollowTool;", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lkotlin/Function1;", "", "Lcom/bytedance/android/livesdk/user/b;", "paramBuilder", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/depend/model/follow/FollowPair;", "makeFollowByRoom", "Lcom/bytedance/android/livesdk/user/m;", "makeUnFollowByRoom", "followPair", "", "showToastWithFollowStateSyncCheck", "shouldTreatAsFollowed", "", "", "logExtra", "showFollowSyncDialog", "openUserId", "getUnFollowDialogText", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DouyinAccountFollowTool implements IInternalFollowTool {
    public void showToastWithFollowStateSyncCheck(Context r2, Room r3, FollowPair r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "followPair");
    }

    public DouyinAccountFollowTool() {
        k.l(IInternalFollowTool.class, this);
    }

    public Observable<String> getUnFollowDialogText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "openUserId");
        return Observable.just(LiveResUtil.getString(2131919781));
    }

    public boolean shouldTreatAsFollowed(Room r1, FollowPair r2) {
        if (r2 != null) goto L4;
    L7:
        return true;
    L4:
        if (r2.followStatus != 0) goto L7;
        return false;
    }

    public Observable<Boolean> showFollowSyncDialog(Context r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "logExtra");
        return Single.just(Boolean.FALSE).toObservable();
    }

    public Observable<FollowPair> makeFollowByRoom(Context r1, Room r2, Function1<? super Boolean, ? extends b> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "paramBuilder");
        b r4 = (b) r3.invoke(Boolean.FALSE);
        return TTLiveSDKContext.getHostService().h().h(r4);
    }

    public Observable<FollowPair> makeUnFollowByRoom(Context r1, Room r2, Function1<? super Boolean, ? extends m> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "paramBuilder");
        m r4 = (m) r3.invoke(Boolean.FALSE);
        return TTLiveSDKContext.getHostService().h().i(r4);
    }
}
