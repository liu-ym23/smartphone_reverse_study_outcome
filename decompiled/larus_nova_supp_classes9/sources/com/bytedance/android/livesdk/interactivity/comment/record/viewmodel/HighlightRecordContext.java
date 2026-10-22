package com.bytedance.android.livesdk.interactivity.comment.record.viewmodel;

import am2.x;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.comment.highlight.MarkHighlightApi;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001RB\u001b\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\b\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0005R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0018\u0010\u001a\u001a\u00060\u0018j\u0002`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b\n\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\"R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\"R \u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b+\u0010%R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\"R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b.\u0010%R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010\"R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b0\u0010%R\"\u00102\u001a\u0002018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u0002018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R(\u0010=\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u00105R\u0019\u0010F\u001a\u0004\u0018\u00010E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010K\u001a\u0004\u0018\u00010J8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N¨\u0006S"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/viewmodel/HighlightRecordContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lz22/a;", BuildConfig.FLAVOR, "isStart", BuildConfig.FLAVOR, "notifyRecordReqStart", "isStop", "notifyRecordReqStop", "cancelRecord", "isRecording", "changeIsRecording", "sendRecordStartLog", "notifyClickRecordStopBtn", BuildConfig.BUILD_TYPE, "reqRecord", "tryCancelRecord", BuildConfig.FLAVOR, "tag", "Ljava/lang/String;", BuildConfig.FLAVOR, "STATUS_SECURITY_BAN", "I", "STATUS_ANCHOR_CLOSE", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/Disposable;", "statRecordReqDp", "Lio/reactivex/disposables/Disposable;", "stopRecordReqDp", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "_isRecording", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "()Lcom/bytedance/android/live/core/arch/mvvm/d;", "_clickRecordStopBtn", "clickRecordStopBtn", "getClickRecordStopBtn", "_recordReqStart", "recordReqStart", "getRecordReqStart", "_recordReqStop", "recordReqStop", "getRecordReqStop", "_cancelRecord", "getCancelRecord", BuildConfig.FLAVOR, "startRecordTimeMs", "J", "getStartRecordTimeMs", "()J", "setStartRecordTimeMs", "(J)V", "endRecordTimeMs", "getEndRecordTimeMs", "setEndRecordTimeMs", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/d;", "<set-?>", "recordResponse", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/d;", "getRecordResponse", "()Lcom/bytedance/android/livesdk/interactivity/comment/highlight/d;", "roomId$delegate", "Lkotlin/Lazy;", "getRoomId", "roomId", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightRecordContext extends DataContext implements z22.a {
    public static final b Companion = null;
    private final int STATUS_ANCHOR_CLOSE;
    private final int STATUS_SECURITY_BAN;
    private final PropertyOwner<Boolean> _cancelRecord;
    private final PropertyOwner<Boolean> _clickRecordStopBtn;
    private final PropertyOwner<Boolean> _isRecording;
    private final PropertyOwner<Boolean> _recordReqStart;
    private final PropertyOwner<Boolean> _recordReqStop;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> cancelRecord;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> clickRecordStopBtn;
    private final DataCenter dataCenter;
    private long endRecordTimeMs;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> isRecording;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> recordReqStart;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> recordReqStop;
    private com.bytedance.android.livesdk.interactivity.comment.highlight.d recordResponse;
    private final MiddlewareRoomContext roomContext;
    private final Lazy roomId$delegate;
    private long startRecordTimeMs;
    private Disposable statRecordReqDp;
    private Disposable stopRecordReqDp;
    private final String tag;

    public static final class a implements Action {
        public final /* synthetic */ HighlightRecordContext a;

        public a(HighlightRecordContext r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.release();
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static HighlightRecordContext a(MiddlewareRoomContext r4, DataCenter r5) {
            ViewModel r0 = null;
            if (r4 == null) goto L8;
            j r6 = r4.getHighlightRecordContext();
            if (r6 == null) goto L8;
            ViewModel r7 = (ViewModel) r6.getValue();
            if (r7 == null) goto L8;
        L15:
            if ((r7 instanceof HighlightRecordContext) == false) goto L19;
            r0 = r7;
        L19:
            return (HighlightRecordContext) r0;
        L8:
            MiddlewareRoomContext r8 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r5, 0, 2);
            if (r8 == null) goto L13;
            j r9 = r8.getHighlightRecordContext();
            if (r9 == null) goto L13;
            r7 = (ViewModel) r9.getValue();
        L13:
            r7 = null;
            goto L15
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ HighlightRecordContext a;
        public final /* synthetic */ boolean b;

        public c(HighlightRecordContext r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r13) {
            com.bytedance.android.livesdk.interactivity.comment.highlight.d r14 = (com.bytedance.android.livesdk.interactivity.comment.highlight.d) ((BaseResponse) ((Response) r13)).data;
            HighlightRecordContext.access$setRecordResponse$p(this.a, r14);
            if (this.b == false) goto L5;
            HighlightRecordContext.access$notifyRecordReqStart(this.a, true);
            HighlightRecordContext.access$sendRecordStartLog(this.a);
            return;
        L5:
            if (r14 == null) goto L28;
            com.bytedance.android.livesdk.interactivity.comment.highlight.b r15 = r14.a();
            if (r15 == null) goto L28;
            Long r0 = r15.g();
            boolean r2 = false;
            Long r5 = null;
            if (r0 != null) goto L11;
        L19:
            Long r16 = r15.d();
            if (r16 == null) goto L28;
            if (r16.longValue() <= 0) goto L24;
            r2 = true;
        L24:
            if (r2 == false) goto L26;
            r5 = r16;
        L26:
            if (r5 == null) goto L28;
            this.a.setEndRecordTimeMs(r5.longValue() * 1000);
            goto L28
        L11:
            if (r0.longValue() <= 0) goto L13;
            boolean r8 = true;
        L14:
            if (r8 == true) goto L17;
            r0 = null;
        L17:
            if (r0 == null) goto L19;
            this.a.setStartRecordTimeMs(r0.longValue() * 1000);
            goto L19
        L13:
            r8 = false;
        L28:
            HighlightRecordContext.access$notifyRecordReqStop(this.a, true);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ HighlightRecordContext a;

        public d(HighlightRecordContext r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            ApiServerException r6 = (Throwable) r5;
            HighlightRecordContext.access$changeIsRecording(this.a, false);
            if ((r6 instanceof ApiServerException) == true) goto L5;
            ApiServerException r0 = null;
        L6:
            ApiServerException r1 = r0;
            if (r1 == null) goto L9;
            int r2 = r1.getErrorCode();
        L11:
            if (r2 != HighlightRecordContext.access$getSTATUS_SECURITY_BAN$p(this.a)) goto L13;
        L16:
            if (r1 == null) goto L19;
            String r3 = r1.getPrompt();
            if (r3 == null) goto L19;
        L20:
            f2.c(r3, 0);
        L21:
            ALogger.e(HighlightRecordContext.access$getTag$p(this.a), "errorCode=" + r2, r6);
            return;
        L19:
            r3 = "该直播不支持录屏沉淀";
            goto L20
        L13:
            if (r2 == HighlightRecordContext.access$getSTATUS_ANCHOR_CLOSE$p(this.a)) goto L16;
            f2.c("录制失败", 0);
            goto L21
        L9:
            r2 = 0;
            goto L11
        L5:
            r0 = r6;
            goto L6
        }
    }

    static {
        Companion = new b();
    }

    private final void cancelRecord() {
        changeIsRecording(false);
        this._cancelRecord.a(Boolean.TRUE);
    }

    private final long getRoomId() {
        return ((Number) this.roomId$delegate.getValue()).longValue();
    }

    @JvmStatic
    public static final HighlightRecordContext getShared(MiddlewareRoomContext r1, DataCenter r2) {
        Companion.getClass();
        return b.a(r1, r2);
    }

    public void notifyClickRecordStopBtn() {
        this._clickRecordStopBtn.a(Boolean.TRUE);
    }

    public void release() {
        Disposable r0 = this.statRecordReqDp;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.stopRecordReqDp;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        setStartRecordTimeMs(0);
        setEndRecordTimeMs(0);
        this.recordResponse = null;
        changeIsRecording(false);
        this.cd.clear();
    }

    private final void sendRecordStartLog() {
        j0 r0 = j0.l();
        Pair[] r1 = new Pair[4];
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r2 = this.recordResponse;
        String r3 = null;
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r4 = r2.a();
        if (r4 == null) goto L7;
        String r5 = String.valueOf(r4.e());
    L8:
        r1[0] = TuplesKt.to("highlights_content_id", r5);
        DataCenter r6 = getDataCenter();
        if (r6 == null) goto L15;
        IRoom r7 = a0.n(r6);
        if (r7 == null) goto L15;
        IBaseUser r8 = r7.getOwner();
        if (r8 == null) goto L15;
        r3 = r8.getIdString();
    L15:
        r1[1] = TuplesKt.to("anchor_id", String.valueOf(r3));
        r1[2] = TuplesKt.to("click_area", "record");
        r1[3] = TuplesKt.to("module_name", "comment_highlight_choose");
        r0.sendLog("livesdk_comment_highlight_record_click", MapsKt.mapOf(r1), new Object[]{IRoom.class, x.class});
        return;
    L7:
        r5 = null;
        goto L8
    }

    /* JADX INFO: renamed from: isRecording, reason: collision with other method in class */
    public boolean m632isRecording() {
        return ((Boolean) isRecording().getValue()).booleanValue();
    }

    public final void tryCancelRecord() {
        if (m632isRecording() == true) goto L5;
        return;
    L5:
        release();
        cancelRecord();
    }

    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> getCancelRecord() {
        return this.cancelRecord;
    }

    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> getClickRecordStopBtn() {
        return this.clickRecordStopBtn;
    }

    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public long getEndRecordTimeMs() {
        return this.endRecordTimeMs;
    }

    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> getRecordReqStart() {
        return this.recordReqStart;
    }

    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> getRecordReqStop() {
        return this.recordReqStop;
    }

    public final com.bytedance.android.livesdk.interactivity.comment.highlight.d getRecordResponse() {
        return this.recordResponse;
    }

    public final MiddlewareRoomContext getRoomContext() {
        return this.roomContext;
    }

    public long getStartRecordTimeMs() {
        return this.startRecordTimeMs;
    }

    @Override // z22.a
    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> isRecording() {
        return this.isRecording;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.highlight.d access$getRecordResponse$p(HighlightRecordContext r0) {
        return r0.recordResponse;
    }

    public static final /* synthetic */ int access$getSTATUS_ANCHOR_CLOSE$p(HighlightRecordContext r0) {
        return r0.STATUS_ANCHOR_CLOSE;
    }

    public static final /* synthetic */ int access$getSTATUS_SECURITY_BAN$p(HighlightRecordContext r0) {
        return r0.STATUS_SECURITY_BAN;
    }

    public static final /* synthetic */ String access$getTag$p(HighlightRecordContext r0) {
        return r0.tag;
    }

    public static final /* synthetic */ void access$sendRecordStartLog(HighlightRecordContext r0) {
        r0.sendRecordStartLog();
    }

    private final void changeIsRecording(boolean r2) {
        this._isRecording.a(Boolean.valueOf(r2));
    }

    private final void notifyRecordReqStart(boolean r2) {
        this._recordReqStart.a(Boolean.valueOf(r2));
        changeIsRecording(true);
    }

    private final void notifyRecordReqStop(boolean r2) {
        changeIsRecording(false);
        this._recordReqStop.a(Boolean.valueOf(r2));
    }

    public final void reqRecord(boolean r14) {
        if (r14 == false) goto L11;
        if (m632isRecording() == false) goto L7;
        ALogger.i(this.tag, "reqRecord,start record fail, now is recording");
        return;
    L7:
        Disposable r0 = this.statRecordReqDp;
        if (r0 == null) goto L17;
        r0.dispose();
    L17:
        if (r14 == false) goto L19;
        long r1 = 1;
    L20:
        long r11 = r1;
        long r2 = p6.b();
        long r3 = 0;
        if (r14 == false) goto L23;
        setStartRecordTimeMs(r2);
        long r9 = 0;
    L30:
        MarkHighlightApi.a.getClass();
        MarkHighlightApi r4 = (MarkHighlightApi) com.bytedance.android.live.network.c.b().e(MarkHighlightApi.class);
        if (r4 == null) goto L46;
        long r5 = getRoomId();
        long r6 = r2 / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        DataCenter r7 = getDataCenter();
        if (r7 == null) goto L41;
        Room r8 = z.o(r7);
        if (r8 == null) goto L41;
        String r10 = r8.getAnchorId();
        if (r10 == null) goto L41;
        Long r13 = StringsKt.toLongOrNull(r10);
        if (r13 == null) goto L41;
        r3 = r13.longValue();
    L41:
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.highlight.d>> r15 = r4.startScreenRecordRequest(r5, r6, r3, r9, r11);
        if (r15 == null) goto L46;
        Observable r16 = RxUtilKt.h(r15);
        if (r16 == null) goto L46;
        Disposable r17 = r16.subscribe(new c(this, r14), new d(this));
    L47:
        if (r14 == false) goto L49;
        this.statRecordReqDp = r17;
        return;
    L49:
        this.stopRecordReqDp = r17;
        return;
    L46:
        r17 = null;
        goto L47
    L23:
        setEndRecordTimeMs(r2);
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r18 = this.recordResponse;
        if (r18 == null) goto L28;
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r19 = r18.a();
        if (r19 == null) goto L28;
        long r20 = r19.e();
    L29:
        r9 = r20;
    L28:
        r20 = 0;
        goto L29
    L19:
        r1 = 2;
        goto L20
    L11:
        if (m632isRecording() == true) goto L14;
        ALogger.i(this.tag, "reqRecord: stop record fail, now is not recording");
        return;
    L14:
        Disposable r21 = this.stopRecordReqDp;
        if (r21 == null) goto L17;
        r21.dispose();
        goto L17
    }

    public void setEndRecordTimeMs(long r1) {
        this.endRecordTimeMs = r1;
    }

    public void setStartRecordTimeMs(long r1) {
        this.startRecordTimeMs = r1;
    }

    public HighlightRecordContext(MiddlewareRoomContext r2, DataCenter r3) {
        this.roomContext = r2;
        this.dataCenter = r3;
        this.tag = "HighlightRecordContext";
        this.STATUS_SECURITY_BAN = 4011137;
        this.STATUS_ANCHOR_CLOSE = 4003220;
        CompositeDisposable r4 = new CompositeDisposable();
        this.cd = r4;
        Boolean r0 = Boolean.FALSE;
        PropertyOwner<Boolean> r5 = new PropertyOwner(r0);
        this._isRecording = r5;
        this.isRecording = r5;
        PropertyOwner<Boolean> r6 = new PropertyOwner(r0);
        this._clickRecordStopBtn = r6;
        this.clickRecordStopBtn = r6;
        PropertyOwner<Boolean> r7 = new PropertyOwner(r0);
        this._recordReqStart = r7;
        this.recordReqStart = r7;
        PropertyOwner<Boolean> r8 = new PropertyOwner(r0);
        this._recordReqStop = r8;
        this.recordReqStop = r8;
        PropertyOwner<Boolean> r9 = new PropertyOwner(r0);
        this._cancelRecord = r9;
        this.cancelRecord = r9;
        this.roomId$delegate = LazyKt.lazy(new HighlightRecordContext$roomId$2(this));
        f.a(getOnCleared().subscribe(new a(this)), r4);
    }

    public static final /* synthetic */ void access$changeIsRecording(HighlightRecordContext r0, boolean r1) {
        r0.changeIsRecording(r1);
    }

    public static final /* synthetic */ void access$notifyRecordReqStart(HighlightRecordContext r0, boolean r1) {
        r0.notifyRecordReqStart(r1);
    }

    public static final /* synthetic */ void access$notifyRecordReqStop(HighlightRecordContext r0, boolean r1) {
        r0.notifyRecordReqStop(r1);
    }

    public static final /* synthetic */ void access$setRecordResponse$p(HighlightRecordContext r0, com.bytedance.android.livesdk.interactivity.comment.highlight.d r1) {
        r0.recordResponse = r1;
    }
}
