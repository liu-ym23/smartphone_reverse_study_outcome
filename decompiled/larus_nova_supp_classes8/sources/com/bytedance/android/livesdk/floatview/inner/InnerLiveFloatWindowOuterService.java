package com.bytedance.android.livesdk.floatview.inner;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.floatview.FloatWindowConfig;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/inner/InnerLiveFloatWindowOuterService;", "Lcom/bytedance/android/livesdkapi/service/IInnerLiveFloatWindowService;", "()V", "addVideoFloatManagerListener", "", "listener", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "dismissFloatWindow", "reason", "", "floatWindowIsShowing", "", "getFloatWindowTag", "getManagers", "", "Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowManager;", "isContinueShowingWhenBackground", "removeVideoFloatManagerListener", "showLiveSteamFloatWindow", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "floatWindowConfig", "Lcom/bytedance/android/livesdkapi/floatview/FloatWindowConfig;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InnerLiveFloatWindowOuterService implements IInnerLiveFloatWindowService {
    public InnerLiveFloatWindowOuterService() {
    }

    public boolean isContinueShowingWhenBackground() {
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_INNER_FLOAT_WINDOW_TO_OUT.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        List<IInnerFloatWindowManager> r0 = getManagers();
        if (r0 != null) goto L8;
        return false;
    L8:
        Iterator<IInnerFloatWindowManager> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L34;
        IInnerFloatWindowManager r2 = r1.next();
        if (r2 != null) goto L14;
    L18:
        boolean r4 = false;
    L20:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.k0.getValue()).booleanValue() == false) goto L22;
    L23:
        if (r2 != null) goto L25;
    L27:
        boolean r5 = false;
    L28:
        if (r2 == null) goto L10;
        if (r2.floatWindowIsShowing() != true) goto L10;
        if (r4 == true) goto L10;
        if (r5 == true) goto L10;
        return true;
    L25:
        if (r2.hideWindowWhenToDesktop() != true) goto L27;
    L26:
        r5 = true;
        goto L28
    L22:
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_INNER_FLOAT_WINDOW_TO_OUT.getValue()).booleanValue() == false) goto L26;
    L14:
        if (r2.floatWindowEntityExists() != true) goto L18;
        if (r2.dismissWindowWhenToDesktop() != true) goto L18;
        r4 = true;
        goto L20
    L34:
        return false;
    }

    private final List<IInnerFloatWindowManager> getManagers() {
        if (TTLiveService.getLiveService() != null) goto L7;
        return null;
    L7:
        return b.b;
    }

    public boolean floatWindowIsShowing() {
        List<IInnerFloatWindowManager> r0 = getManagers();
        if (r0 != null) goto L5;
        return false;
    L5:
        Iterator<IInnerFloatWindowManager> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        IInnerFloatWindowManager r2 = r1.next();
        if (r2 == null) goto L7;
        if (r2.floatWindowIsShowing() != true) goto L7;
        return true;
    L13:
        return false;
    }

    public String getFloatWindowTag() {
        List<IInnerFloatWindowManager> r0 = getManagers();
        if (r0 != null) goto L5;
        return "";
    L5:
        Iterator<IInnerFloatWindowManager> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L30;
        IInnerFloatWindowManager r2 = r1.next();
        if (r2 == null) goto L7;
        if (r2.floatWindowEntityExists() == false) goto L7;
        if ((r2 instanceof IInnerFloatWindowSceneInterceptor) == true) goto L15;
        r2 = null;
    L15:
        IInnerFloatWindowSceneInterceptor r3 = (IInnerFloatWindowSceneInterceptor) r2;
        if (r3 == null) goto L28;
        String r4 = r3.tag();
        if (r4 != null) goto L21;
        return "";
    L21:
        return r4;
    L28:
        return "";
    L30:
        return "";
    }

    public void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r3) {
        List<IInnerFloatWindowManager> r0 = getManagers();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<IInnerFloatWindowManager> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        IInnerFloatWindowManager r2 = r1.next();
        if (r2 == null) goto L7;
        r2.addVideoFloatManagerListener(r3);
        goto L7
    }

    public void dismissFloatWindow(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        List<IInnerFloatWindowManager> r0 = getManagers();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<IInnerFloatWindowManager> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        IInnerFloatWindowManager r2 = r1.next();
        if (r2 == null) goto L7;
        if (r2.floatWindowEntityExists() == false) goto L7;
        IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(r2, 0, null, false, 7, null);
        f.a(r10);
        goto L7
    }

    public void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r3) {
        List<IInnerFloatWindowManager> r0 = getManagers();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<IInnerFloatWindowManager> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        IInnerFloatWindowManager r2 = r1.next();
        if (r2 == null) goto L7;
        r2.removeVideoFloatManagerListener(r3);
        goto L7
    }

    public void showLiveSteamFloatWindow(IRoom r4, FloatWindowConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "floatWindowConfig");
        List<IInnerFloatWindowManager> r0 = getManagers();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<IInnerFloatWindowManager> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        IInnerFloatWindowManager r2 = r1.next();
        if ((r2 instanceof VideoWatchingInnerFloatWindowManager) == false) goto L7;
        ((VideoWatchingInnerFloatWindowManager) r2).showFloat(r4, r5);
        goto L7
    }
}
