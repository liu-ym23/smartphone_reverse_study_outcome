package com.bytedance.android.livesdk.chatroom.vs_host;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livesdk.chatroom.backroom.LiveBackRoomStackManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.IPreviewController;
import com.bytedance.android.livesdkapi.depend.live.IRelateLiveInsertPresenter;
import com.bytedance.android.livesdkapi.depend.live.IRoomAction;
import com.bytedance.android.livesdkapi.depend.live.IRoomEventListener;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.ExternalRoomExitReason;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.LiveExternalConfig;
import com.bytedance.android.livesdkapi.feed.IMultiTabProviderCallback;
import com.bytedance.android.livesdkapi.view.IBackPress;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import j40.j2;
import jm1.d;
import jm1.e;
import jm1.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_host/ReplayDelegateFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRoomPageFragment;", "Lcom/bytedance/android/livesdkapi/view/IBackPress;", "<init>", "()V", "a", "vs-host_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayDelegateFragment extends BaseFragment implements ILiveRoomPageFragment, IBackPress {
    public static final /* synthetic */ int e = 0;
    public f d;

    public static final class a {
    }

    public static final class b implements d {
        public final /* synthetic */ IRoomAction a;

        public final void exitRoom() {
            this.a.exitRoom();
        }

        public final boolean interceptRoomClose() {
            return this.a.interceptRoomClose();
        }

        public b(IRoomAction r1) {
            this.a = r1;
        }
    }

    public static final class c implements e {
        public final /* synthetic */ IRoomEventListener a;

        public final void onFirsFrame() {
            this.a.onFirsFrame();
        }

        public final void onNotSmoothLeave() {
            this.a.onNotSmoothLeave();
        }

        public final void onSmoothLeaveRoom() {
            this.a.onSmoothLeaveRoom();
        }

        public c(IRoomEventListener r1) {
            this.a = r1;
        }

        public final void a(IRoom r3) {
            IRoomEventListener r0 = this.a;
            if ((r3 instanceof Room) == false) goto L5;
            Room r4 = (Room) r3;
        L6:
            r0.onEnterRoom(r4);
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final void onConfigurationChanged(Configuration r2) {
            this.a.onConfigurationChanged(r2);
        }

        public final void onDislikeItem(long r2) {
            this.a.onDislikeItem(r2);
        }

        public final void onLiveEnd(View r2, View r3) {
            this.a.onLiveEnd(r2, r3);
        }

        public final void onMaskLayerChanged(String r2, boolean r3) {
            this.a.onMaskLayerChanged(r2, r3);
        }

        public final void onInteractionViewsAdapt(boolean r7, View r8, View r9, View r10, View r11) {
            this.a.onInteractionViewsAdapt(r7, r8, r9, r10, r11);
        }
    }

    static {
    }

    public final /* synthetic */ void createExternalConfigJudger(String r1, LiveExternalConfig r2) {
        ILiveRoomPageFragment.-CC.$default$createExternalConfigJudger(this, r1, r2);
    }

    public final /* synthetic */ void deleteRoomFromList(Room r1) {
        ILiveRoomPageFragment.-CC.$default$deleteRoomFromList(this, r1);
    }

    public final void forceSmoothExit() {
    }

    public final ILiveRoomPlayFragment getCurrentFragment() {
        return null;
    }

    public final int getCurrentPosition() {
        return -1;
    }

    public final /* synthetic */ IExternalConfigJudger getExternalConfigJudger() {
        return ILiveRoomPageFragment.-CC.$default$getExternalConfigJudger(this);
    }

    public final ILiveRoomPageFragment getRealAction() {
        return this;
    }

    public final /* synthetic */ IRelateLiveInsertPresenter getRelateLiveInsertPresenter() {
        return ILiveRoomPageFragment.-CC.$default$getRelateLiveInsertPresenter(this);
    }

    public final String getRoomSetTag() {
        return "";
    }

    public final /* synthetic */ void initLogger() {
        ILiveRoomPageFragment.-CC.$default$initLogger(this);
    }

    public final /* synthetic */ boolean invokeBackPress() {
        return ILiveRoomPageFragment.-CC.$default$invokeBackPress(this);
    }

    public final boolean isSmoothEnter() {
        return false;
    }

    public final void notifyDataSetChange() {
    }

    public final /* synthetic */ void onOuterPageScrollStateChanged(int r1) {
        ILiveRoomPageFragment.-CC.$default$onOuterPageScrollStateChanged(this, r1);
    }

    public final void onUserLeaveHint() {
    }

    public final /* synthetic */ void prePrepare(String r1) {
        ILiveRoomPageFragment.-CC.$default$prePrepare(this, r1);
    }

    public final /* synthetic */ void prePullStream(boolean r1, String r2) {
        ILiveRoomPageFragment.-CC.$default$prePullStream(this, r1, r2);
    }

    public final /* synthetic */ IPreviewController previewController() {
        return ILiveRoomPageFragmentForSaas.-CC.$default$previewController(this);
    }

    public final /* synthetic */ void removeCurrentRoom(long r1, ExternalRoomExitReason r3) {
        ILiveRoomPageFragment.-CC.$default$removeCurrentRoom(this, r1, r3);
    }

    public final void saveBackRoomInfo(Bundle r1, Bundle r2) {
    }

    public final /* synthetic */ void saveBackRoomInfo(String r1) {
        ILiveRoomPageFragmentForSaas.-CC.$default$saveBackRoomInfo(this, r1);
    }

    public final /* synthetic */ void saveBackRoomInfo(String r1, Bundle r2) {
        ILiveRoomPageFragmentForSaas.-CC.$default$saveBackRoomInfo(this, r1, r2);
    }

    public final Fragment self() {
        return this;
    }

    public final /* synthetic */ void setCurrentPosition(String r1, int r2, ExternalRoomExitReason r3) {
        ILiveRoomPageFragment.-CC.$default$setCurrentPosition(this, r1, r2, r3);
    }

    public final /* synthetic */ void setRoomListProvider(IMultiTabProviderCallback r1) {
        ILiveRoomPageFragment.-CC.$default$setRoomListProvider(this, r1);
    }

    public final /* synthetic */ void stopPrePullStream() {
        ILiveRoomPageFragment.-CC.$default$stopPrePullStream(this);
    }

    public final /* synthetic */ void stopRoom() {
        ILiveRoomPageFragmentForSaas.-CC.$default$stopRoom(this);
    }

    public final void updateRoomSession(long r1) {
    }

    public final /* synthetic */ void updateStartTimeForLog(long r1) {
        ILiveRoomPageFragment.-CC.$default$updateStartTimeForLog(this, r1);
    }

    public final boolean isNestedOutside() {
        f r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isNestedOutside() != true) goto L7;
        return true;
    }

    public final boolean onBackPressed() {
        f r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.onBackPressed() != true) goto L7;
        return true;
    }

    public final void onScrollAway() {
        f r0 = this.d;
        if (r0 == null) goto L6;
        r0.onScrollAway();
        return;
    }

    public final IRoomAction roomAction() {
        f r0 = this.d;
        d r1 = null;
        if (r0 == null) goto L5;
        d r2 = r0.roomAction();
    L6:
        if (r2 == null) goto L12;
        f r3 = this.d;
        if (r3 == null) goto L11;
        r1 = r3.roomAction();
    L11:
        return new IRoomAction.ReplayDelegate(r1);
    L12:
        return null;
    L5:
        r2 = null;
        goto L6
    }

    public final IRoomEventListener roomEventListener() {
        f r0 = this.d;
        e r1 = null;
        if (r0 == null) goto L5;
        e r2 = r0.roomEventListener();
    L6:
        if (r2 == null) goto L12;
        f r3 = this.d;
        if (r3 == null) goto L11;
        r1 = r3.roomEventListener();
    L11:
        return new IRoomEventListener.ReplayDelegate(r1);
    L12:
        return null;
    L5:
        r2 = null;
        goto L6
    }

    public ReplayDelegateFragment() {
        if (getArguments() != null) goto L6;
        setArguments(new Bundle());
        Unit r0 = Unit.INSTANCE;
        return;
    }

    public final void onActivityCreated(Bundle r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityCreated(r5);
        f r6 = this.d;
        if (r6 == null) goto L17;
        Fragment r7 = r6.self();
        if (r7 == null) goto L18;
        Bundle r0 = getArguments();
        if (r0 == null) goto L11;
        Bundle r1 = r7.getArguments();
        if (r1 == null) goto L11;
        r1.putAll(r0);
    L11:
        FragmentTransaction r2 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ReplayPlayFragment", 2131382432) == true) goto L15;
        r2 = r2.add(2131382432, r7, "ReplayPlayFragment");
    L15:
        r2.commitNowAllowingStateLoss();
        return;
    L18:
        return;
    }

    public final void setNestedOutside(boolean r2) {
        f r0 = this.d;
        if (r0 == null) goto L6;
        r0.setNestedOutside(r2);
        return;
    }

    public final void setRoomAction(IRoomAction r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        f r0 = this.d;
        if (r0 == null) goto L8;
        r0.TC(new b(r3));
        return;
    }

    public final void setRoomEventListener(IRoomEventListener r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        f r0 = this.d;
        if (r0 == null) goto L8;
        r0.Ad(new c(r3));
        return;
    }

    public final void startRoom(String r2) {
        f r0 = this.d;
        if (r0 == null) goto L6;
        r0.startRoom(r2);
        return;
    }

    public final void stopRoom(String r1) {
        f r2 = this.d;
        if (r2 == null) goto L6;
        r2.stopRoom();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (((Boolean) j2.a.getValue()).booleanValue() == false) goto L6;
        LiveBackRoomStackManager.c().clear();
    L6:
        return r2.inflate(2131566082, r3, false);
    }
}
