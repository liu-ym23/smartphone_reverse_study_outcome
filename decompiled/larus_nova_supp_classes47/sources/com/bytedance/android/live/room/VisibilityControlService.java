package com.bytedance.android.live.room;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControl;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\rH\u0016J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\rH\u0016JR\u0010.\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\rH\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u0010\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000103H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\u0010\u00109\u001a\u00020\u00182\u0006\u00108\u001a\u00020\rH\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0016J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016R\u0014\u0010A\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\bC\u0010BR\u0014\u0010D\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\bD\u0010BR\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010BR\u0016\u0010L\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010BR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006\\"}, d2 = {"Lcom/bytedance/android/live/room/VisibilityControlService;", "Lcom/bytedance/android/live/room/api/IVisibilityControlService;", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControlContext;", "provideContext", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "manager", "", "injectWidgetManager", "getWidgetManager", "Lcom/bytedance/android/live/room/api/visibilitycontrol/c;", "widget", "registerControlWidget", "clearControlWidget", "", "getLockStatus", "lock", "setLockStatus", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$KEY;", "key", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "getControlItemStatus", "visible", "setControlItemStatus", "", "customDuration", "getVisibilityStatus", "setVisibilityStatus", "changeVisibilityStatus", "changeTetrisVisible", "markVisibilityStatusChangeByUser", "resetHideTask", "enable", "setAutoHideTaskEnable", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Type;", "type", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Style;", "style", "Landroid/view/View;", "view", "", "attachMarginDp", "needDynamicControl", "ignoreLock", "Lcom/bytedance/android/live/room/api/visibilitycontrol/a;", "reverse", "addControlItem", "Lcom/bytedance/android/live/room/api/visibilitycontrol/d;", "item", "removeControlItem", "releaseService", "Lio/reactivex/Observable;", "startVisibilityTimer", "stopVisibilityTimer", "startPlayBackTimer", "pausePlayBackTimer", "isPlayingInPlayBack", "stopPlayBackTimer", "resetPlayBackTimer", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "shutdownPlayback", "countdown", "countDownShift", "onUnload", "ANIM_DURATION", "J", "defaultTimer", "HIDE_VIEW_DELAY_TIME", "Lcom/bytedance/android/live/room/api/visibilitycontrol/f;", "timer$delegate", "Lkotlin/Lazy;", "getTimer", "()Lcom/bytedance/android/live/room/api/visibilitycontrol/f;", "timer", "playbackDuration", "lastPlaybackStartTime", "prePlayingInPlayBack", "Z", "context", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControlContext;", "activeClearWidget", "Lcom/bytedance/android/live/room/api/visibilitycontrol/c;", "widgetManager", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "Lio/reactivex/disposables/Disposable;", "shiftDisposal", "Lio/reactivex/disposables/Disposable;", "<init>", "()V", "Companion", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VisibilityControlService implements IVisibilityControlService {
    public static final a Companion = null;
    private static final String durationTag = null;
    private final long ANIM_DURATION;
    private final long HIDE_VIEW_DELAY_TIME;
    private com.bytedance.android.live.room.api.visibilitycontrol.c activeClearWidget;
    private LiveVisibilityControlContext context;
    private final long defaultTimer;
    private long lastPlaybackStartTime;
    private long playbackDuration;
    private boolean prePlayingInPlayBack;
    private Disposable shiftDisposal;
    private final Lazy timer$delegate;
    private WidgetManager widgetManager;

    public static final class a {
        public static String a() {
            return "VisibilityControlService#" + VisibilityControlService.Companion.hashCode();
        }

        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VisibilityControlService a;

        public b(VisibilityControlService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            ALogger.d("enterRoomInPlayback", "shift countdown 结束，setPlayBackAbilityInShift true");
            VisibilityControlService.access$getContext$p(this.a).setPlayBackAbilityInShift(true);
        }
    }

    private final com.bytedance.android.live.room.api.visibilitycontrol.f getTimer() {
        return (com.bytedance.android.live.room.api.visibilitycontrol.f) this.timer$delegate.getValue();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void clearControlWidget() {
        this.activeClearWidget = null;
        Companion.getClass();
        ALogger.w(a.a(), "clear activeWidget!");
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void releaseService() {
        this.activeClearWidget = null;
        this.widgetManager = null;
        com.bytedance.android.live.room.api.visibilitycontrol.f r1 = getTimer();
        r1.a();
        r1.a = null;
        Companion.getClass();
        ALogger.w(a.a(), "release service");
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void startPlayBackTimer() {
        this.prePlayingInPlayBack = true;
        this.lastPlaybackStartTime = System.currentTimeMillis();
        String r0 = durationTag;
        ALogger.d(r0, "startPlayBackTimer");
        ALogger.d(r0, "lastPlaybackStartTime is " + this.lastPlaybackStartTime);
    }

    static {
        Companion = new a();
        durationTag = "durationTag";
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void changeTetrisVisible() {
        LiveVisibilityControlContext r0 = this.context;
        r0.setPlaybackVisibleValue(!r0.getPlaybackVisibleValue());
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void changeVisibilityStatus() {
        LiveVisibilityControlContext r0 = this.context;
        r0.setViewVisibleValue(!((Boolean) r0.getViewVisibleMutable().getValue()).booleanValue());
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public boolean getLockStatus() {
        return ((Boolean) this.context.isLocked().getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public boolean getVisibilityStatus() {
        return ((Boolean) this.context.getViewVisibleMutable().getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void markVisibilityStatusChangeByUser() {
        this.context.getPlayerViewVisibleTriggeredByUser().setValue(Boolean.TRUE);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void onUnload() {
        Disposable r0 = this.shiftDisposal;
        if (r0 != null) goto L5;
    L10:
        this.context.setPlaybackVisibleValue(false);
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void pausePlayBackTimer() {
        if (this.lastPlaybackStartTime != 0) goto L5;
    L7:
        this.prePlayingInPlayBack = false;
        return;
    L5:
        if (this.prePlayingInPlayBack == false) goto L7;
        String r0 = durationTag;
        ALogger.d(r0, "pausePlayBackTimer");
        ALogger.d(r0, "lastPlaybackStartTime is " + this.lastPlaybackStartTime);
        long r1 = System.currentTimeMillis();
        ALogger.d(r0, "currentTimeMillis is " + r1);
        long r2 = r1 - this.lastPlaybackStartTime;
        this.playbackDuration = this.playbackDuration + r2;
        ALogger.d(r0, "该事件段消费时长为 is " + r2);
        ALogger.d(r0, "playbackDuration update to " + this.playbackDuration);
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void resetHideTask() {
        this.context.getResetHideTaskEvent().post(Unit.INSTANCE);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void resetPlayBackTimer() {
        this.playbackDuration = 0;
        this.lastPlaybackStartTime = 0;
        this.prePlayingInPlayBack = false;
    }

    public VisibilityControlService() {
        this.ANIM_DURATION = 300;
        this.defaultTimer = 5;
        this.HIDE_VIEW_DELAY_TIME = 5000;
        this.timer$delegate = LazyKt.lazy(VisibilityControlService$timer$2.INSTANCE);
        this.context = new LiveVisibilityControlContext();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public Observable<Unit> startVisibilityTimer() {
        com.bytedance.android.live.room.api.visibilitycontrol.f r0 = getTimer();
        long r1 = this.defaultTimer;
        r0.getClass();
        ALogger.d(LiveVisibilityControlContext.timerTag, "start countdown, duration is " + r1);
        r0.a();
        r0.a = Observable.timer(r1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.api.visibilitycontrol.e(r0));
        return r0.c;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void stopVisibilityTimer() {
        getTimer().a();
    }

    public static final /* synthetic */ String access$getDurationTag$cp() {
        return durationTag;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public WidgetManager getWidgetManager() {
        return this.widgetManager;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public LiveVisibilityControlContext provideContext() {
        return this.context;
    }

    public static final /* synthetic */ LiveVisibilityControlContext access$getContext$p(VisibilityControlService r0) {
        return r0.context;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void addControlItem(com.bytedance.android.live.room.api.visibilitycontrol.d r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        com.bytedance.android.live.room.api.visibilitycontrol.c r0 = this.activeClearWidget;
        if (r0 == null) goto L9;
        r0.addControlItem(r4);
        Companion.getClass();
        String r1 = a.a();
        StringBuilder r2 = new StringBuilder("activeWidget[");
        com.bytedance.android.live.room.api.visibilitycontrol.c r3 = this.activeClearWidget;
        if (r3 == null) goto L7;
        int r5 = r3.hashCode();
    L8:
        r2.append(r5);
        r2.append("] not null,do direct add, key:");
        r2.append(r4.f.getDescribe());
        ALogger.d(r1, r2.toString());
        return;
    L7:
        r5 = 0;
        goto L8
    L9:
        this.context.getTmpControlItemList().add(r4);
        Companion.getClass();
        ALogger.w(a.a(), "activeWidget null,add to tmp list,key:" + r4.f.getDescribe());
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void countDownShift(long r3) {
        Disposable r0 = this.shiftDisposal;
        if (r0 != null) goto L5;
    L10:
        this.shiftDisposal = Observable.timer(r3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public NextLiveData<Integer> getControlItemStatus(LiveVisibilityControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.c r0 = this.activeClearWidget;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.wd(r2);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void injectWidgetManager(WidgetManager r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        this.activeClearWidget = null;
        this.widgetManager = r2;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void registerControlWidget(com.bytedance.android.live.room.api.visibilitycontrol.c r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        this.activeClearWidget = r3;
        Companion.getClass();
        String r4 = a.a();
        StringBuilder r0 = new StringBuilder("register activeWidget![");
        com.bytedance.android.live.room.api.visibilitycontrol.c r1 = this.activeClearWidget;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        r0.append(r2);
        r0.append(']');
        ALogger.w(r4, r0.toString());
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void removeControlItem(LiveVisibilityControl.KEY r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.c r0 = this.activeClearWidget;
        if (r0 == null) goto L10;
        r0.removeControlItem(r4);
        Companion.getClass();
        String r1 = a.a();
        StringBuilder r2 = new StringBuilder("activeWidget[");
        com.bytedance.android.live.room.api.visibilitycontrol.c r3 = this.activeClearWidget;
        if (r3 == null) goto L7;
        int r5 = r3.hashCode();
    L8:
        r2.append(r5);
        r2.append("] not null,do remove, key:");
        r2.append(r4.getDescribe());
        ALogger.d(r1, r2.toString());
        return;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setAutoHideTaskEnable(boolean r2) {
        this.context.getAutoHideTaskEnable().setValue(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setLockStatus(boolean r2) {
        this.context.isLocked().setValue(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setVisibilityStatus(boolean r2) {
        this.context.setViewVisibleValue(r2);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void shutdownPlayback(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        LiveVisibilityControlContext r3 = this.context;
        if (r3 == null) goto L5;
        r3.setPlayBackAbilityInMsg(false);
    L5:
        LiveVisibilityControlContext r4 = this.context;
        if (r4 == null) goto L8;
        r4.setPlaybackVisibleValue(false);
    L8:
        setControlItemStatus(LiveVisibilityControl.KEY.LiveProgressBar, false);
        setControlItemStatus(LiveVisibilityControl.KEY.LivePlayControl, false);
        setControlItemStatus(LiveVisibilityControl.KEY.LiveThumb, false);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public long stopPlayBackTimer(boolean r8) {
        String r0 = durationTag;
        ALogger.d(r0, "stopPlayBackTimer");
        if (r8 == true) goto L5;
    L7:
        ALogger.d(r0, "playbackDuration is  " + this.playbackDuration);
        return this.playbackDuration;
    L5:
        if (this.prePlayingInPlayBack == false) goto L7;
        this.playbackDuration += System.currentTimeMillis() - this.lastPlaybackStartTime;
        goto L7
    }

    public static final /* synthetic */ void access$setContext$p(VisibilityControlService r0, LiveVisibilityControlContext r1) {
        r0.context = r1;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setControlItemStatus(LiveVisibilityControl.KEY r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.c r0 = this.activeClearWidget;
        if (r0 == null) goto L6;
        r0.Gc(r4, r5, this.ANIM_DURATION);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setVisibilityStatus(boolean r4, long r5) {
        Companion.getClass();
        ALogger.w(a.a(), "setVisibilityStatus[" + r4 + "] with customDuration:" + r5);
        this.context.getCustomAnimDuration().setValue(Long.valueOf(r5));
        this.context.setViewVisibleValue(r4);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setControlItemStatus(LiveVisibilityControl.KEY r2, boolean r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.c r0 = this.activeClearWidget;
        if (r0 == null) goto L6;
        r0.Gc(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void addControlItem(LiveVisibilityControl.KEY r12, LiveVisibilityControl.Type r13, LiveVisibilityControl.Style r14, View r15, float r16, boolean r17, boolean r18, com.bytedance.android.live.room.api.visibilitycontrol.a r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "key");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "style");
        Intrinsics.checkNotNullParameter(r15, "view");
        if (r19 == null) goto L5;
        com.bytedance.android.live.room.api.visibilitycontrol.d r0 = new com.bytedance.android.live.room.api.visibilitycontrol.d(r12, r19, r15, r13, r14, r16, r17, r18, r20);
    L6:
        addControlItem(r0);
        return;
    L5:
        r0 = new com.bytedance.android.live.room.api.visibilitycontrol.d(r12, null, r15, r13, r14, r16, r17, r18, r20);
        goto L6
    }
}
