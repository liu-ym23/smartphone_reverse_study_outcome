package com.bytedance.android.live.profile.profilecontext;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;
import com.bytedance.android.live.profile.event.EventHub;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.m;
import com.bytedance.android.live.profile.ui.base.n;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import com.bytedance.android.live.profile.usecase.q;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements h, m {
    public final h a;
    public final m b;

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final void a(ProfileNestedScrollView.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.a(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final Integer b() {
        return this.b.b();
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final Integer c() {
        return this.b.c();
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final void d(ProfileNestedScrollView.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.d(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void dismiss() {
        this.a.dismiss();
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final int e() {
        return this.b.e();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void enterWaitFor(Observable<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "wait");
        this.a.enterWaitFor(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final n findView(int r2) {
        return this.b.findView(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final k getDressImageModelWithFallback(DressType r2) {
        Intrinsics.checkNotNullParameter(r2, "dressType");
        return this.a.getDressImageModelWithFallback(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.a> getEnterExitState() {
        return this.a.getEnterExitState();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final EventHub getEventHub() {
        return this.a.getEventHub();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    /* JADX INFO: renamed from: getFinalProfileUser */
    public final com.bytedance.android.live.core.arch.mvvm.d<sh6.b<NewProfileUser>> mo5getFinalProfileUser() {
        return this.a.mo5getFinalProfileUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final String getFlashCardAsset() {
        return this.a.getFlashCardAsset();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    /* JADX INFO: renamed from: getLifecycleState */
    public final com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.b> mo6getLifecycleState() {
        return this.a.mo6getLifecycleState();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final NewProfileTrackUseCase getLogUseCase() {
        return this.a.getLogUseCase();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final q getPageTypeUseCase() {
        return this.a.getPageTypeUseCase();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final String getParallaxAsset() {
        return this.a.getParallaxAsset();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final NewProfileUser getPreTargetUser() {
        return this.a.getPreTargetUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final ProfileMode getProfileMode() {
        return this.a.getProfileMode();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final ProfileMonitor getProfileMonitor() {
        return this.a.getProfileMonitor();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final int getProfileWidth(Boolean r2) {
        return this.a.getProfileWidth(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final ps0.b getRoom() {
        return this.a.getRoom();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final DataCenter getRoomDataCenter() {
        return this.a.getRoomDataCenter();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final IBaseUser getRoomUser() {
        return this.a.getRoomUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final NewProfileUser getTargetUser() {
        return this.a.getTargetUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final UserProfileEvent getUserProfileEvent() {
        return this.a.getUserProfileEvent();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final boolean isMyLive() {
        return this.a.isMyLive();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final boolean isPad() {
        return this.a.isPad();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final boolean isVertical() {
        return this.a.isVertical();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void logSubscribeVIPCardShow() {
        this.a.logSubscribeVIPCardShow();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void recordBusinessClick(String r2, Map<? extends String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.a.recordBusinessClick(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void recordBusinessShow(TrackArea r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "area");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.a.recordBusinessShow(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void recordShowMap(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a.recordShowMap(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void sendLog(String r2, Map<String, String> r3, Object... r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "logMap");
        Intrinsics.checkNotNullParameter(r4, "args");
        this.a.sendLog(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void showFansClub(FragmentActivity r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter("mini_card", "from");
        this.a.showFansClub(r2, "mini_card", r4);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void showKtvPanel(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.showKtvPanel(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void showSubscribePanel(FragmentActivity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.showSubscribePanel(r2, false);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void showWhiteCertPageNoLog(Context r2, WhiteCategoryCert.SubCertInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.showWhiteCertPageNoLog(r2, r3);
    }

    public a(NewProfileInfoViewModel r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        Intrinsics.checkNotNullParameter(r3, "viewProfileContext");
        this.a = r2;
        this.b = r3;
    }
}
