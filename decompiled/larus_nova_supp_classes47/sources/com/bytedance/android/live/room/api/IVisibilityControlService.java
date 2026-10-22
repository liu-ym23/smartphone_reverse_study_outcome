package com.bytedance.android.live.room.api;

import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControl;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.live.room.api.visibilitycontrol.a;
import com.bytedance.android.live.room.api.visibilitycontrol.c;
import com.bytedance.android.live.room.api.visibilitycontrol.d;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.room.IVisibilityControlService")
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\rH&J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\rH&J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\rH&J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0006H&J\b\u0010\u001f\u001a\u00020\u0006H&J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\rH&J\\\u0010.\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\r2\b\b\u0002\u0010+\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010-\u001a\u00020\rH&J\u0010\u0010.\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H&J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u00102\u001a\u00020\u0006H&J\u0010\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000103H&J\b\u00105\u001a\u00020\u0006H&J\b\u00106\u001a\u00020\u0006H&J\b\u00107\u001a\u00020\u0006H&J\u0010\u00109\u001a\u00020\u00192\u0006\u00108\u001a\u00020\rH&J\b\u0010:\u001a\u00020\u0006H&J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H&J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0019H&J\b\u0010@\u001a\u00020\u0006H&¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/room/api/IVisibilityControlService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControlContext;", "provideContext", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "manager", "", "injectWidgetManager", "getWidgetManager", "Lcom/bytedance/android/live/room/api/visibilitycontrol/c;", "widget", "registerControlWidget", "clearControlWidget", "", "getLockStatus", "lock", "setLockStatus", "getVisibilityStatus", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$KEY;", "key", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "getControlItemStatus", "visible", "setVisibilityStatus", "", "customDuration", "setControlItemStatus", "changeVisibilityStatus", "changeTetrisVisible", "markVisibilityStatusChangeByUser", "resetHideTask", "enable", "setAutoHideTaskEnable", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Type;", "type", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Style;", "style", "Landroid/view/View;", "view", "", "attachMarginDp", "needDynamicControl", "ignoreLock", "Lcom/bytedance/android/live/room/api/visibilitycontrol/a;", "reverse", "addControlItem", "Lcom/bytedance/android/live/room/api/visibilitycontrol/d;", "item", "removeControlItem", "releaseService", "Lio/reactivex/Observable;", "startVisibilityTimer", "stopVisibilityTimer", "startPlayBackTimer", "pausePlayBackTimer", "isPlayingInPlayBack", "stopPlayBackTimer", "resetPlayBackTimer", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "shutdownPlayback", "countdown", "countDownShift", "onUnload", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVisibilityControlService extends IService {
    void addControlItem(LiveVisibilityControl.KEY r1, LiveVisibilityControl.Type r2, LiveVisibilityControl.Style r3, View r4, float r5, boolean r6, boolean r7, a r8, boolean r9);

    void addControlItem(d r1);

    void changeTetrisVisible();

    void changeVisibilityStatus();

    void clearControlWidget();

    void countDownShift(long r1);

    NextLiveData<Integer> getControlItemStatus(LiveVisibilityControl.KEY r1);

    boolean getLockStatus();

    boolean getVisibilityStatus();

    WidgetManager getWidgetManager();

    void injectWidgetManager(WidgetManager r1);

    void markVisibilityStatusChangeByUser();

    void onUnload();

    void pausePlayBackTimer();

    LiveVisibilityControlContext provideContext();

    void registerControlWidget(c r1);

    void releaseService();

    void removeControlItem(LiveVisibilityControl.KEY r1);

    void resetHideTask();

    void resetPlayBackTimer();

    void setAutoHideTaskEnable(boolean r1);

    void setControlItemStatus(LiveVisibilityControl.KEY r1, boolean r2);

    void setControlItemStatus(LiveVisibilityControl.KEY r1, boolean r2, long r3);

    void setLockStatus(boolean r1);

    void setVisibilityStatus(boolean r1);

    void setVisibilityStatus(boolean r1, long r2);

    void shutdownPlayback(DataCenter r1);

    void startPlayBackTimer();

    Observable<Unit> startVisibilityTimer();

    long stopPlayBackTimer(boolean r1);

    void stopVisibilityTimer();
}
