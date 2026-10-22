package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u000bH\u0016J\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\bH\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0016J8\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016H\u0016J0\u0010\u001a\u001a\u00020\u00192&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016H\u0016J\u0006\u0010\u001b\u001a\u00020\bJ\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0006\u0010\u001e\u001a\u00020\u001cJ\u0010\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u001a\u0010#\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0016\u0010&\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\u0003J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016R\u001a\u0010,\u001a\u00020\u001c8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lxh0/b;", "", "onCreate", "", "beforeOpen", "onDestroy", "", "getScene", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getOverlayWhiteList", "toScene", "Lkotlin/Pair;", "", "isSupportSceneChange", "toUiLayout", "isSupportUiLayoutChang", "isOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "notifyPlayModeStatus", "Lxh0/g;", "isCanOpen", "getPlayModeKey", "Lne0/c;", "createPlayModeStore", "getStore", "Lcom/bytedance/android/live/network/response/EnterRoomInfoResult;", "enterRoomInfo", "onPreEnterConsume", "isAsync", "onPreGetEnterInfo", "playMode", "isFromEnter", "onAsyncGetPlayModeInfo", "onPreGetEnterInfoUniversal", "removePreGetEnterInfoObserver", "Lcom/bytedance/android/livesdk/link/model/bridge/ILinkMicGuideMessageBridge;", MultiLinkOpenSource.MESSAGE, "handleGuideMessage", "mStore", "Lne0/c;", "getMStore", "()Lne0/c;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "mGetEnterInfoObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lio/reactivex/disposables/Disposable;", "mGetPlayModeInfoDisposable", "Lio/reactivex/disposables/Disposable;", "getMGetPlayModeInfoDisposable", "()Lio/reactivex/disposables/Disposable;", "setMGetPlayModeInfoDisposable", "(Lio/reactivex/disposables/Disposable;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsPlayModeWidget extends PlatformMultiLinkWidget implements xh0.b {
    private Observer<KVData> mGetEnterInfoObserver;
    private Disposable mGetPlayModeInfoDisposable;
    private final ne0.c mStore;

    public static final class a<T> implements Observer {
        public final /* synthetic */ AbsPlayModeWidget a;

        public a(AbsPlayModeWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            if (r4 == null) goto L5;
            EnterRoomInfoResult r5 = (EnterRoomInfoResult) r4.getData();
        L6:
            this.a.onPreGetEnterInfo(r5, true);
            this.a.removePreGetEnterInfoObserver();
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    @Override // xh0.b
    public boolean beforeOpen() {
        return true;
    }

    @Override // xh0.b
    public ArrayList<Integer> getOverlayWhiteList() {
        return null;
    }

    public boolean handleGuideMessage(ILinkMicGuideMessageBridge r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        return false;
    }

    public void onPreGetEnterInfo(EnterRoomInfoResult r1, boolean r2) {
    }

    public ne0.c createPlayModeStore() {
        return new com.bytedance.android.live.liveinteract.revenuebase.f(this);
    }

    public final void removePreGetEnterInfoObserver() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver("data_room_enter_info", this.mGetEnterInfoObserver);
        return;
    }

    public AbsPlayModeWidget() {
        this.mStore = createPlayModeStore();
    }

    public final int getPlayModeKey() {
        return getPlayModeInfo().a;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public int getScene() {
        return je0.d.f();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r0 = MultiRevenueDataContext.a.d();
        if (r0 == null) goto L6;
        r0.c(this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r0 = MultiRevenueDataContext.a.d();
        if (r0 == null) goto L6;
        r0.i(this);
        return;
    }

    public final Disposable getMGetPlayModeInfoDisposable() {
        return this.mGetPlayModeInfoDisposable;
    }

    public final ne0.c getMStore() {
        return this.mStore;
    }

    public final ne0.c getStore() {
        return this.mStore;
    }

    @Override // xh0.b
    public xh0.g isCanOpen(HashMap<String, Object> r7) {
        return new xh0.g(IncompatibleTag.PLAY_MODE, getPlayModeKey(), true, null, 24);
    }

    @Override // xh0.b
    public Pair<Boolean, String> isSupportSceneChange(int r3) {
        return new Pair(Boolean.TRUE, "");
    }

    @Override // xh0.b
    public Pair<Boolean, String> isSupportUiLayoutChang(int r3) {
        return new Pair(Boolean.TRUE, "");
    }

    public final void onPreEnterConsume(EnterRoomInfoResult r3) {
        if (r3 == null) goto L5;
        onPreGetEnterInfo(r3, false);
        return;
    L5:
        if (this.mGetEnterInfoObserver != null) goto L11;
        a r4 = new a(this);
        this.mGetEnterInfoObserver = r4;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L12;
        r0.observe("data_room_enter_info", r4);
        return;
    L12:
        return;
    }

    public final void onPreGetEnterInfoUniversal(int r5) {
        Disposable r0 = this.mGetPlayModeInfoDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        int r1 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r2 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, 0L);
        if (r2 == null) goto L8;
        r2.k(r5, true);
    L8:
        MultiSceneEnterRoomStatisticsUtils r3 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, 0L);
        if (r3 == null) goto L12;
        r3.l(r5, true);
        return;
    }

    public final void setMGetPlayModeInfoDisposable(Disposable r1) {
        this.mGetPlayModeInfoDisposable = r1;
    }

    public void notifyPlayModeStatus(boolean r3, HashMap<String, Object> r4) {
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r0 = MultiRevenueDataContext.a.d();
        if (r0 == null) goto L6;
        r0.j(getPlayModeKey(), r3, r4);
        return;
    }

    public final void onAsyncGetPlayModeInfo(int r4, boolean r5) {
        if (r5 == false) goto L10;
        ALogger.i("PlayMode_PreEnter_Listen", "onAsyncGetPlayModeInfo--未命中预加载：" + u0.k(r4));
        removePreGetEnterInfoObserver();
        int r6 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, 0L);
        if (r7 == null) goto L6;
        r7.k(r4, false);
    L6:
        MultiSceneEnterRoomStatisticsUtils r8 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, 0L);
        if (r8 == null) goto L11;
        r8.l(r4, false);
        return;
    L11:
        return;
    }
}
