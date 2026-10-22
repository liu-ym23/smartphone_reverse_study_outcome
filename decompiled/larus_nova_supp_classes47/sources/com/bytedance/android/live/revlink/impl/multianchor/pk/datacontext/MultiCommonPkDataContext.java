package com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0002<=B\u000f\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b9\u0010:J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0018\u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-RB\u00100\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/datacontext/MultiCommonPkDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "getPlayPkLogParam", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "getRoomContext", "()Lcom/bytedance/android/livesdk/revenue/room/a;", "setRoomContext", "(Lcom/bytedance/android/livesdk/revenue/room/a;)V", "Lj31/a;", "startParam", "Lj31/a;", "getStartParam", "()Lj31/a;", "setStartParam", "(Lj31/a;)V", "", "killFinishType", "Ljava/lang/Integer;", "getKillFinishType", "()Ljava/lang/Integer;", "setKillFinishType", "(Ljava/lang/Integer;)V", "endReason", "getEndReason", "setEndReason", "", "isTopSecKillTrigger", "Z", "()Z", "setTopSecKillTrigger", "(Z)V", "initiatorId", "Ljava/lang/String;", "getInitiatorId", "()Ljava/lang/String;", "setInitiatorId", "(Ljava/lang/String;)V", "isPkManager", "setPkManager", "eventTrackingInfo", "Ljava/util/Map;", "getEventTrackingInfo", "()Ljava/util/Map;", "setEventTrackingInfo", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/datacontext/MultiCommonPkDataContext$c;", "bizContainer", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/datacontext/MultiCommonPkDataContext$c;", "<init>", "(Lcom/bytedance/android/live/revlink/impl/multianchor/pk/datacontext/MultiCommonPkDataContext$c;)V", "Companion", "b", "c", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiCommonPkDataContext extends DataContext {
    public static final b Companion = null;
    public static final String TAG = "MultiCommonPkDataContext";
    private final c bizContainer;
    private final CompositeDisposable cd;
    private Integer endReason;
    private Map<String, String> eventTrackingInfo;
    private String initiatorId;
    private String isPkManager;
    private boolean isTopSecKillTrigger;
    private Integer killFinishType;
    private com.bytedance.android.livesdk.revenue.room.a roomContext;
    private j31.a startParam;

    public static final class a implements Action {
        public final /* synthetic */ MultiCommonPkDataContext a;

        public a(MultiCommonPkDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            MultiCommonPkDataContext.access$getCd$p(this.a).dispose();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public interface c {
        Map<String, String> a();
    }

    static {
        Companion = new b();
    }

    public final Map<String, String> getPlayPkLogParam() {
        return this.bizContainer.a();
    }

    public final Integer getEndReason() {
        return this.endReason;
    }

    public final Map<String, String> getEventTrackingInfo() {
        return this.eventTrackingInfo;
    }

    public final String getInitiatorId() {
        return this.initiatorId;
    }

    public final Integer getKillFinishType() {
        return this.killFinishType;
    }

    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        return this.roomContext;
    }

    public final j31.a getStartParam() {
        return this.startParam;
    }

    public final String isPkManager() {
        return this.isPkManager;
    }

    public final boolean isTopSecKillTrigger() {
        return this.isTopSecKillTrigger;
    }

    public MultiCommonPkDataContext(c r3) {
        Intrinsics.checkNotNullParameter(r3, "bizContainer");
        this.bizContainer = r3;
        CompositeDisposable r4 = new CompositeDisposable();
        this.cd = r4;
        this.isPkManager = DataType.FALSE;
        f.a(getOnCleared().subscribe(new a(this)), r4);
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(MultiCommonPkDataContext r0) {
        return r0.cd;
    }

    public final void setEndReason(Integer r1) {
        this.endReason = r1;
    }

    public final void setEventTrackingInfo(Map<String, String> r1) {
        this.eventTrackingInfo = r1;
    }

    public final void setInitiatorId(String r1) {
        this.initiatorId = r1;
    }

    public final void setKillFinishType(Integer r1) {
        this.killFinishType = r1;
    }

    public final void setPkManager(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isPkManager = r2;
    }

    public final void setRoomContext(com.bytedance.android.livesdk.revenue.room.a r1) {
        this.roomContext = r1;
    }

    public final void setStartParam(j31.a r1) {
        this.startParam = r1;
    }

    public final void setTopSecKillTrigger(boolean r1) {
        this.isTopSecKillTrigger = r1;
    }
}
