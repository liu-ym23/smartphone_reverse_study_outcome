package com.bytedance.android.live.room.enterprocess;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomFlushInfo;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J.\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016JD\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\"\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0005H\u0016J4\u0010%\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J0\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010 2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J:\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u001c2\b\u0010-\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00100\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J$\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016¨\u00063"}, d2 = {"Lcom/bytedance/android/live/room/enterprocess/IFeedBizInterceptor;", "", "onActivityStateChanged", "", "isFinishing", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "processEnterRoomParam", "roomId", "", "enterRoomParam", "Landroid/os/Bundle;", "processHandleIntent", "enterArgs", "outputEnterExtra", "processInstantiateItem", "position", "", "activityIntent", "Landroid/content/Intent;", "targetRoomArgs", "processLogShow", "targetRoomPosition", "outputLogMap", "", "", "roomFlushInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomFlushInfo;", "targetRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "processOnDestroy", "curRoom", "hashTag", "passJumpToOtherCheck", "processPageSelected", "currentPos", "roomListSize", "processSaveBackRoomInfo", "roomInfo", "currentRoomBundle", "processSetup", "enterFromMerge", "enterMethod", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "processStartFirstRoomRunnable", "processStatusBarHeight", "statusBarHeight", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFeedBizInterceptor {
    void onActivityStateChanged(boolean r1, LifecycleOwner r2, Lifecycle.Event r3);

    void processEnterRoomParam(long r1, Bundle r3);

    void processHandleIntent(Bundle r1, Bundle r2);

    void processInstantiateItem(int r1, Intent r2, Bundle r3, Bundle r4);

    void processLogShow(int r1, Bundle r2, Map<String, String> r3, RoomFlushInfo r4, Room r5);

    void processOnDestroy(Room r1, int r2, boolean r3);

    void processPageSelected(int r1, int r2, int r3, Room r4, Bundle r5);

    void processSaveBackRoomInfo(Room r1, Bundle r2, Bundle r3, RoomFlushInfo r4);

    void processSetup(String r1, String r2, Bundle r3, Bundle r4, Lifecycle r5);

    void processStartFirstRoomRunnable(Bundle r1, Bundle r2);

    int processStatusBarHeight(int r1, Intent r2, Bundle r3);
}
