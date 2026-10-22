package com.bytedance.android.livesdk.explore.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdk.config.m0;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentForSaas;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.feed.DrawOperate;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mz.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/explore/view/AbsBaseFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRoomPlayFragment;", "Lcom/bytedance/android/livesdkapi/eventbus/JumpToOtherRoomEvent;", "event", "", "onEvent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsBaseFragment extends BaseFragment implements ILiveRoomPlayFragment {
    public ILiveRoomPlayFragment.LiveRoomListener d;
    public final CompositeDisposable e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AbsBaseFragment a;

        public a(AbsBaseFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            AbsBaseFragment r0 = this.a;
            r0.onEvent((JumpToOtherRoomEvent) r2);
        }
    }

    public final void addDoChangePageDelayTime(long r1) {
    }

    public final void attachSurfaceView() {
    }

    public final void detachSurfaceView() {
    }

    public final void ensureMute(boolean r1) {
    }

    public final void enterWormhole(boolean r1) {
    }

    public final void exitWormhole() {
    }

    public IRoom getCurRoom() {
        return null;
    }

    public final b getExplicitInfo() {
        return null;
    }

    public final Fragment getFragment() {
        return this;
    }

    public final double getPullStreamAvg() {
        return 0.0d;
    }

    public final ILiveRoomPlayFragment getRealAction() {
        return this;
    }

    public final void goneOnPageSelected(int r1) {
    }

    public final void initLogger(Bundle r1) {
    }

    public final void injectOperateRecorder(DrawOperate r1) {
    }

    public final boolean isAllWidgetLoaded() {
        return false;
    }

    public final boolean isInWormhole() {
        return false;
    }

    public final boolean isP1WidgetLoaded() {
        return false;
    }

    public final boolean isP2WidgetLoaded() {
        return false;
    }

    public final boolean isRoomEnd() {
        return false;
    }

    public final boolean isSmoothLeaveDoubleRenderSurface() {
        return false;
    }

    public final /* synthetic */ ILivePlayerClient livePlayerClient() {
        return ILiveRoomPlayFragmentForSaas.-CC.$default$livePlayerClient(this);
    }

    public final void mutePlayerClient(boolean r1) {
    }

    public final void notifyToolbarWidgetClearData() {
    }

    public boolean onBackPressed() {
        return false;
    }

    public final void onOuterPageScrollStateChanged(int r1) {
    }

    public final void onPageScrollStateChanged(int r1) {
    }

    public final void onPageSelected(int r1, ILiveRoomPlayFragment r2) {
    }

    public final /* synthetic */ void onPreviewBackPressed() {
        ILiveRoomPlayFragmentForSaas.-CC.$default$onPreviewBackPressed(this);
    }

    public final /* synthetic */ void onPreviewStateChange(Boolean r1) {
        ILiveRoomPlayFragmentForSaas.-CC.$default$onPreviewStateChange(this, r1);
    }

    public void onScrolling() {
    }

    public final void onSelected(boolean r1) {
    }

    public final void onUserLeaveHint() {
    }

    public final ILiveRoomPageFragment parentPage() {
        return null;
    }

    public final void playerPreload() {
    }

    public final void preBackendRoom() {
    }

    public final void preEnterRoom() {
    }

    public final void preInitLandscapeRoomUIContext() {
    }

    public final void prePlaySwitchRes() {
    }

    public final boolean prePrepare(String r2) {
        Intrinsics.checkNotNullParameter(r2, "resolution");
        return false;
    }

    public final void prePullStream(boolean r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "triggerType");
    }

    public final void preRequestRoomEnter() {
    }

    public final void preRequestRoomPreload(boolean r1) {
    }

    public final /* synthetic */ void reallyHideInteractionFragment() {
        ILiveRoomPlayFragmentForSaas.-CC.$default$reallyHideInteractionFragment(this);
    }

    public final /* synthetic */ void reallyShowInteractionFragment() {
        ILiveRoomPlayFragmentForSaas.-CC.$default$reallyShowInteractionFragment(this);
    }

    public final /* synthetic */ void reloadInteraction() {
        ILiveRoomPlayFragmentForSaas.-CC.$default$reloadInteraction(this);
    }

    public final /* synthetic */ void resetLoggerInPreview() {
        ILiveRoomPlayFragmentForSaas.-CC.$default$resetLoggerInPreview(this);
    }

    public final void resetSmoothDoubleRenderSurface() {
    }

    public final void scrollEnd(boolean r1) {
    }

    public final void setLinkShareInviteId(String r1, String r2, long r3) {
    }

    public final void setRefreshStatusObservable(PublishSubject<Boolean> r1) {
    }

    public final void setScrollStatusObservable(PublishSubject<Boolean> r1) {
    }

    public final void showPlayerBackground(String r1) {
    }

    public final void stopInteractionLoad() {
    }

    public final void stopPlayerForNextRoomPrePullStream() {
    }

    public void stopRoomWithoutReleasePlayer(boolean r1) {
    }

    public final void tryPauseStream(String r1) {
    }

    public final void updateCurrentController() {
    }

    public final void updateEnterRoomMonitor() {
    }

    public final void updateRoomSession(long r1) {
    }

    public final void updateStartTimeForLog(long r1) {
    }

    public final void wormholeNoStreamCheck() {
    }

    public void startRoom() {
        a r1 = new a(this);
        Intrinsics.checkNotNullParameter(JumpToOtherRoomEvent.class, "clazz");
        Intrinsics.checkNotNullParameter(r1, "consumer");
        this.e.add(xs2.b.a().b(JumpToOtherRoomEvent.class).subscribe(r1));
    }

    public AbsBaseFragment() {
        this.e = new CompositeDisposable();
    }

    public final LiveRoomState getCurState() {
        return LiveRoomState.INITIALIZED;
    }

    public final ILiveRoomPlayFragment.LiveRoomListener getLiveRoomListener() {
        return this.d;
    }

    public final void onEvent(JumpToOtherRoomEvent r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (getUserVisibleHint() == true) goto L11;
        if (m0.a.getValue().enable() == false) goto L11;
        kn1.b.a(4, this);
        return;
    L11:
        if (l.d().e().isRecording() == false) goto L14;
        f2.b(2131921972, 0);
        kn1.b.a(5, this);
        return;
    L14:
        IMicRoomService r0 = k.f(IMicRoomService.class);
        if (r0 == null) goto L20;
        if (r0.isMicRoom(getRealAction().getCurRoom()) == false) goto L20;
        r4.enterExtra.putString("mic_room_jump_type", r0.getChangeTypeForLog());
    L20:
        if (getLiveRoomListener() == null) goto L25;
        ILiveRoomPlayFragment.LiveRoomListener r1 = getLiveRoomListener();
        if (r1 == null) goto L26;
        r1.jump2Other(r4);
        return;
    L26:
        return;
    }

    public final void register(Disposable r1) {
        super.register(r1);
    }

    public final void setLiveRoomListener(ILiveRoomPlayFragment.LiveRoomListener r1) {
        this.d = r1;
    }

    public void stopRoom(String r1) {
        this.e.clear();
    }
}
