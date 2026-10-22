package com.bytedance.android.livesdk.floatview;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.config.ql;
import com.bytedance.android.livesdk.config.rl;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSwitchManager;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b2\u00103J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0016J\u0011\u0010&\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b&\u0010'J\u0012\u0010*\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010+\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010.\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010/\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0018\u00100\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u00101\u001a\u00020\fH\u0016¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/VideoFloatWindowOuterService;", "Lcom/bytedance/android/livesdkapi/service/ILiveVideoFloatWindowService;", "Lcom/bytedance/android/livesdk/floatview/NewVideoInnerFloatManager;", "getFloatManager", "Lcom/bytedance/android/livesdk/floatview/VideoFloatWindowManager;", "getOuterFloatManager", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/widget/FrameLayout;", "rootView", "Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;", "extra", "", "showFloatWindow", "Landroid/view/MotionEvent;", "event", "", "onFloatWindowInterceptTouchEvent", "hideFloatWindow", "specialHideFloatWindow", "Landroidx/fragment/app/DialogFragment;", "startShowFloat", "Landroid/app/Activity;", "activity", "startShowFloatInNextLifecycle", "stopShowFloatInNextLifecycle", "stopShowFloat", "stopShowNow", "isPipOpen", "isFloatOpen", "mute", "toggleLiveAudio", "checkWindowConflict", "isFloatWindowMute", "isFloatWindowShowing", "", "bottomMargin", "setFloatWindowBottomMargin", "getFloatWindowBottomMargin", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "listener", "addVideoFloatManagerListener", "removeVideoFloatManagerListener", "Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowSwitchManager;", "getFloatWindowSwitchManager", "addFloatManagerListenerForOuter", "removeFloatManagerListenerForOuter", "preloadVideoFloatWindowView", "init", "<init>", "()V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VideoFloatWindowOuterService implements ILiveVideoFloatWindowService {
    public static final a Companion = null;
    private static final String TAG = "VideoFloatWindowOuterService";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public VideoFloatWindowOuterService() {
    }

    public void init() {
        int r0 = px1.a.a;
        String r1 = "init() >>> " + getFloatManager();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.d("ECFloatWindow_VideoFloatWindowOuterService", r1);
    }

    public boolean isFloatOpen() {
        boolean r0 = p.a;
        return p.d(jc1.a.b());
    }

    private final NewVideoInnerFloatManager getFloatManager() {
        if (TTLiveService.getLiveService() != null) goto L6;
        return null;
    L6:
        q r0 = NewVideoInnerFloatManager.p;
        return NewVideoInnerFloatManager.b.a();
    }

    private final VideoFloatWindowManager getOuterFloatManager() {
        if (TTLiveService.getLiveService() != null) goto L6;
        return null;
    L6:
        q r0 = VideoFloatWindowManager.f;
        return VideoFloatWindowManager.b.a();
    }

    public boolean checkWindowConflict() {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L14;
        int r1 = r0.f;
        if (r1 != 2) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 != true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r1 == 3) goto L10;
        r2 = false;
        goto L11
    L14:
        return false;
    }

    public Integer getFloatWindowBottomMargin() {
        NewVideoInnerFloatManager r0 = getFloatManager();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L20;
        VideoFloatWindowView r2 = r0.b;
        if (r2 == null) goto L9;
        FrameLayout r3 = r2.getVideoContainer();
        if (r3 == null) goto L9;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L11:
        if ((r4 instanceof RelativeLayout.LayoutParams) == false) goto L14;
        r1 = r4;
    L14:
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r1;
        if (r5 == null) goto L17;
        int r6 = r5.bottomMargin;
    L19:
        return Integer.valueOf(r6);
    L17:
        r6 = (int) 86.0f;
    L9:
        r4 = null;
        goto L11
    L20:
        return null;
    }

    public IInnerFloatWindowSwitchManager getFloatWindowSwitchManager() {
        if (TTLiveService.getLiveService() != null) goto L7;
        return null;
    L7:
        return com.bytedance.android.livesdk.floatview.inner.e.a;
    }

    public boolean isFloatWindowMute() {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L16;
        VideoFloatWindowView r1 = r0.b;
        if (r1 == null) goto L11;
        LivePlayerView r2 = r1.getMLivePlayerView$livesdk_saasRelease();
        if (r2 == null) goto L11;
        ILivePlayerClient r3 = r2.getClient();
        if (r3 == null) goto L11;
        boolean r4 = r3.isMute();
    L13:
        if (r4 != true) goto L17;
        return true;
    L17:
        return false;
    L11:
        r4 = false;
        goto L13
    L16:
        return false;
    }

    public boolean isFloatWindowShowing() {
        if (getFloatManager() != null) goto L5;
    L7:
        return false;
    L5:
        if (NewVideoInnerFloatManager.j() != true) goto L7;
        return true;
    }

    public boolean isPipOpen() {
        return p.f();
    }

    public void stopShowFloat() {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L6;
        r0.s();
        return;
    }

    public void stopShowFloatInNextLifecycle() {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L8;
        ALogger.i("NewVideoInnerFloatManager", "stopShowFloatInNextLifecycle, floatWindowCurrentState: " + r0.f);
        if (r0.f != 2) goto L9;
        r0.f = 3;
        return;
    L9:
        return;
    }

    public void stopShowNow() {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L6;
        r0.r();
        return;
    }

    public void addFloatManagerListenerForOuter(IVideoFloatManager.VideoFloatManagerListener r2) {
        VideoFloatWindowManager r0 = getOuterFloatManager();
        if (r0 == null) goto L6;
        r0.addVideoFloatManagerListener(r2);
        return;
    }

    public void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r4) {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L10;
        if (r4 != null) goto L7;
        return;
    L7:
        if (((ArrayList) r0.d).contains(r4) == true) goto L11;
        ((ArrayList) r0.d).add(r4);
        ALogger.d("NewVideoInnerFloatManager", "add listener " + r4 + ", size: " + ((ArrayList) r0.d).size());
        return;
    L11:
        return;
    }

    public void preloadVideoFloatWindowView(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        NewVideoInnerFloatManager r1 = getFloatManager();
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (((Boolean) LiveInfraSettingKeys.PRELOAD_COMMERCE_FLOAT_WINDOW_VIEW.getValue()).booleanValue() == false) goto L12;
        FrameLayout r5 = ox1.d.a(r4, null).getRootView();
        if (r5 == null) goto L13;
        r1.c = new VideoFloatWindowView(r5.getContext(), 1);
        return;
    L13:
        return;
    L12:
        return;
    }

    public void removeFloatManagerListenerForOuter(IVideoFloatManager.VideoFloatManagerListener r2) {
        VideoFloatWindowManager r0 = getOuterFloatManager();
        if (r0 == null) goto L6;
        r0.removeVideoFloatManagerListener(r2);
        return;
    }

    public void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r4) {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L10;
        if (r4 != null) goto L7;
        return;
    L7:
        if (((ArrayList) r0.d).contains(r4) == false) goto L11;
        ((ArrayList) r0.d).remove(r4);
        ALogger.d("NewVideoInnerFloatManager", "remove listener " + r4 + ", size: " + ((ArrayList) r0.d).size());
        return;
    L11:
        return;
    }

    public void setFloatWindowBottomMargin(int r5) {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L18;
        if (r5 < 0) goto L21;
        VideoFloatWindowView r1 = r0.b;
        if (r1 == null) goto L19;
        FrameLayout r2 = r1.getVideoContainer();
        if (r2 == null) goto L20;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        RelativeLayout.LayoutParams r4 = null;
        if ((r3 instanceof RelativeLayout.LayoutParams) == true) goto L13;
        r3 = null;
    L13:
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) r3;
        if (r6 == null) goto L16;
        r6.bottomMargin = (int) t6.a(jc1.a.b(), r5);
        r6.topMargin = 0;
        Unit r7 = Unit.INSTANCE;
        r4 = r6;
    L16:
        r2.setLayoutParams(r4);
        return;
    L20:
        return;
    L19:
        return;
    L21:
        return;
    }

    public void toggleLiveAudio(boolean r4) {
        NewVideoInnerFloatManager r0 = getFloatManager();
        if (r0 == null) goto L19;
        VideoFloatWindowView r1 = r0.b;
        if (r1 == null) goto L20;
        ALogger.i("VideoFloatWindowView", "toggleLiveAudio: " + r4);
        r1.a(2131372953).setSelected(r4);
        r1.t = Boolean.valueOf(r4);
        if (r4 == false) goto L13;
        LivePlayerView r5 = r1.i;
        if (r5 == null) goto L21;
        ILivePlayerClient r6 = r5.getClient();
        if (r6 == null) goto L22;
        r6.mute("VideoFloatWindowView.toggleLiveAudio");
        return;
    L22:
        return;
    L21:
        return;
    L13:
        LivePlayerView r7 = r1.i;
        if (r7 == null) goto L24;
        ILivePlayerClient r8 = r7.getClient();
        if (r8 == null) goto L25;
        r8.unmute("VideoFloatWindowView.toggleLiveAudio");
        return;
    L25:
        return;
    L24:
        return;
    L20:
        return;
    }

    public void hideFloatWindow(Fragment r4, FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        NewVideoInnerFloatManager r2 = getFloatManager();
        if (r2 == null) goto L10;
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        if ((r4 instanceof IVideoFloatManager.AutoFloatEnable) == true) goto L7;
        return;
    L7:
        if (((IVideoFloatManager.AutoFloatEnable) r4).isAutoFloatEnable() == false) goto L12;
        ALogger.i("NewVideoInnerFloatManager", "detachFragment by " + r4);
        r2.s();
        return;
    L12:
        return;
    }

    public boolean onFloatWindowInterceptTouchEvent(Fragment r5, MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "event");
        NewVideoInnerFloatManager r2 = getFloatManager();
        if (r2 == null) goto L13;
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "event");
        if (r2.h != r5.hashCode()) goto L16;
        VideoFloatWindowView r7 = r2.b;
        if (r7 == null) goto L14;
        Intrinsics.checkNotNullParameter(r6, "event");
        Boolean r8 = Boolean.valueOf(((DragRelativeLayout) r7.a(2131372943)).a(r6));
        if (r8 != null) goto L12;
        return false;
    L12:
        return r8.booleanValue();
    L14:
        return false;
    L16:
        return false;
    L13:
        return false;
    }

    public void preloadVideoFloatWindowView(DialogFragment r4, FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        NewVideoInnerFloatManager r2 = getFloatManager();
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        if (((Boolean) LiveInfraSettingKeys.PRELOAD_COMMERCE_FLOAT_WINDOW_VIEW.getValue()).booleanValue() == false) goto L12;
        FrameLayout r6 = ox1.d.b(r4, r5, null).getRootView();
        if (r6 == null) goto L13;
        r2.c = new VideoFloatWindowView(r6.getContext(), 1);
        return;
    L13:
        return;
    L12:
        return;
    }

    public void specialHideFloatWindow(Fragment r4, FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        NewVideoInnerFloatManager r2 = getFloatManager();
        if (r2 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        if ((r4 instanceof IVideoFloatManager.AutoFloatEnable) == true) goto L7;
        return;
    L7:
        if (((IVideoFloatManager.AutoFloatEnable) r4).isAutoFloatEnable() == false) goto L16;
        ALogger.i("NewVideoInnerFloatManager", "specialDetachFragment by " + r4 + ", floatWindowCurrentState = " + r2.f);
        if (ql.a.getValue().booleanValue() == true) goto L11;
    L12:
        r2.s();
        return;
    L11:
        if (r2.f != 1) goto L12;
        return;
    L16:
        return;
    }

    public void startShowFloat(Activity r6, InnerContextEntity.InnerFloatExtra r7) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "extra");
        NewVideoInnerFloatManager r2 = getFloatManager();
        if (r2 == null) goto L24;
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "extra");
        if (((List) r2.k.getValue()).contains(r6.getClass().getSimpleName()) == true) goto L7;
        Lazy r0 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger r1 = VideoFloatWindowLogger.a.a();
        String r3 = r6.getClass().getSimpleName();
        r1.getClass();
        VideoFloatWindowLogger.b(r3);
    L7:
        NewVideoInnerFloatManager.c(r7.getBusinessLine());
        NewVideoInnerFloatManager.g();
        boolean r4 = true;
        if (p.a() == true) goto L13;
        if ((!Intrinsics.areEqual(r7.getRequestPage(), "live_cloud_game")) == false) goto L13;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L13:
        if (r7.getSkipCheckResumed() == true) goto L20;
        Activity r5 = jc1.k.n(IHostApp.class).getTopActivity();
        Class<?> r8 = r6.getClass();
        if (r5 == null) goto L18;
        Class<?> r9 = r5.getClass();
    L19:
        r4 = Intrinsics.areEqual(r8, r9);
        goto L20
    L18:
        r9 = null;
    L20:
        if (r4 == true) goto L22;
        ALogger.i("NewVideoInnerFloatManager", "entity is not resumed");
        return;
    L22:
        ALogger.i("NewVideoInnerFloatManager", "startShowFloat by " + r6);
        r2.e();
        r2.j = r7;
        InnerContextEntity r10 = ox1.d.a(r6, r7);
        r10.setRequestPage(r7.getRequestPage());
        ((ArrayList) r2.g).add(r10);
        r2.f = 2;
        r2.b(r10, (LifecycleOwner) r6);
        r2.h = r6.hashCode();
        return;
    }

    public void startShowFloatInNextLifecycle(Activity r5, InnerContextEntity.InnerFloatExtra r6) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "extra");
        NewVideoInnerFloatManager r2 = getFloatManager();
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "extra");
        if (((List) r2.k.getValue()).contains(r5.getClass().getSimpleName()) == true) goto L7;
        Lazy r0 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger r1 = VideoFloatWindowLogger.a.a();
        String r3 = r5.getClass().getSimpleName();
        r1.getClass();
        VideoFloatWindowLogger.b(r3);
    L7:
        NewVideoInnerFloatManager.c(r6.getBusinessLine());
        NewVideoInnerFloatManager.g();
        if (p.a() == true) goto L10;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L10:
        ALogger.i("NewVideoInnerFloatManager", "startShowFloatInNextLifecycle by " + r5);
        r2.e();
        r2.f = 1;
        r2.h = r5.hashCode();
        r2.j = r6;
        return;
    }

    public void startShowFloatInNextLifecycle(DialogFragment r5, InnerContextEntity.InnerFloatExtra r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "extra");
        NewVideoInnerFloatManager r2 = getFloatManager();
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "extra");
        if (((List) r2.k.getValue()).contains(r5.getClass().getSimpleName()) == true) goto L7;
        Lazy r0 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger r1 = VideoFloatWindowLogger.a.a();
        String r3 = r5.getClass().getSimpleName();
        r1.getClass();
        VideoFloatWindowLogger.b(r3);
    L7:
        NewVideoInnerFloatManager.c(r6.getBusinessLine());
        NewVideoInnerFloatManager.g();
        if (p.a() == true) goto L10;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L10:
        ALogger.i("NewVideoInnerFloatManager", "startShowFloatInNextLifecycle by " + r5);
        r2.e();
        r2.f = 1;
        r2.h = r5.hashCode();
        r2.j = r6;
        return;
    }

    public void showFloatWindow(Fragment r6, FrameLayout r7, InnerContextEntity.InnerFloatExtra r8) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "rootView");
        NewVideoInnerFloatManager r2 = getFloatManager();
        if (r2 == null) goto L24;
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "rootView");
        if (((List) r2.k.getValue()).contains(r6.getClass().getSimpleName()) == true) goto L7;
        Lazy r0 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger r1 = VideoFloatWindowLogger.a.a();
        String r3 = r6.getClass().getSimpleName();
        r1.getClass();
        VideoFloatWindowLogger.b(r3);
    L7:
        NewVideoInnerFloatManager.g();
        if (p.a() == true) goto L11;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L11:
        if ((r6 instanceof IVideoFloatManager.AutoFloatEnable) == false) goto L26;
        IVideoFloatManager.AutoFloatEnable r4 = (IVideoFloatManager.AutoFloatEnable) r6;
        if (r4.isAutoFloatEnable() == false) goto L27;
        ALogger.i("NewVideoInnerFloatManager", "attachFragment by " + r6);
        r2.e();
        if (r8 != null) goto L17;
        InnerContextEntity.InnerFloatExtra r5 = new InnerContextEntity.InnerFloatExtra();
    L18:
        r5.setRequestPage(r4.getRequestPage());
        Unit r9 = Unit.INSTANCE;
        r2.j = r5;
        InnerContextEntity r10 = new InnerContextEntity(r4, r7, true);
        r10.setRequestPage(r4.getRequestPage());
        r10.setDataSource(ox1.c.a(r8));
        if (r8 == null) goto L21;
        HashMap r11 = r8.getMobParams();
    L22:
        r10.setMobParams(r11);
        r10.setEnterExtra(r2.j);
        ((ArrayList) r2.g).add(r10);
        r2.b(r10, r6);
        r2.f = 3;
        r2.h = r6.hashCode();
        return;
    L21:
        r11 = null;
        goto L22
    L17:
        r5 = r8;
        goto L18
    L27:
        return;
    L26:
        return;
    }

    public void startShowFloat(DialogFragment r5, FrameLayout r6, InnerContextEntity.InnerFloatExtra r7) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "rootView");
        Intrinsics.checkNotNullParameter(r7, "extra");
        NewVideoInnerFloatManager r3 = getFloatManager();
        if (r3 == null) goto L19;
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "rootView");
        Intrinsics.checkNotNullParameter(r7, "extra");
        if (((List) r3.k.getValue()).contains(r5.getClass().getSimpleName()) == true) goto L7;
        Lazy r0 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger r1 = VideoFloatWindowLogger.a.a();
        String r2 = r5.getClass().getSimpleName();
        r1.getClass();
        VideoFloatWindowLogger.b(r2);
    L7:
        NewVideoInnerFloatManager.c(r7.getBusinessLine());
        NewVideoInnerFloatManager.g();
        if (p.a() == true) goto L13;
        if ((!Intrinsics.areEqual(r7.getRequestPage(), "live_cloud_game")) == false) goto L13;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L13:
        if (r5.isResumed() == false) goto L15;
    L17:
        ALogger.i("NewVideoInnerFloatManager", "startShowFloat by " + r5);
        r3.e();
        r3.j = r7;
        InnerContextEntity r8 = ox1.d.b(r5, r6, r7);
        r8.setRequestPage(r7.getRequestPage());
        ((ArrayList) r3.g).add(r8);
        r3.f = 2;
        r3.b(r8, r5);
        r3.h = r5.hashCode();
        return;
    L15:
        if (rl.a.getValue().booleanValue() == false) goto L17;
        ALogger.i("NewVideoInnerFloatManager", "entity is not resumed");
        return;
    }
}
