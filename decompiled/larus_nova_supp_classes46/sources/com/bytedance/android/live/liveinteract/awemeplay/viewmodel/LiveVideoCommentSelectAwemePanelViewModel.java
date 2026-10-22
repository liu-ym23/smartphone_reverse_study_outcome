package com.bytedance.android.live.liveinteract.awemeplay.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.awemeplay.api.LiveVideoCommentApi;
import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u0002H\u0014R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/viewmodel/LiveVideoCommentSelectAwemePanelViewModel;", "Landroidx/lifecycle/ViewModel;", "", "fetchTabData", "Lsd0/a;", "video", "", "type", "", "isPin", "shareVideo", "Lud0/c;", "action", "doAction", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "Lud0/d;", "viewEvent", "Landroidx/lifecycle/MutableLiveData;", "getViewEvent", "()Landroidx/lifecycle/MutableLiveData;", "selectedAwemeVideo", "getSelectedAwemeVideo", "Lcom/bytedance/android/live/liveinteract/awemeplay/model/VideoTab;", "selectPageTab", "getSelectPageTab", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectAwemePanelViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<VideoTab> selectPageTab;
    private final MutableLiveData<sd0.a> selectedAwemeVideo;
    private final MutableLiveData<ud0.d> viewEvent;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LiveVideoCommentSelectAwemePanelViewModel a;

        public a(LiveVideoCommentSelectAwemePanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.getViewEvent().setValue(new ud0.d.b((sd0.d) ((Response) r3).data));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveVideoCommentSelectAwemePanelViewModel a;

        public b(LiveVideoCommentSelectAwemePanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getViewEvent().setValue(ud0.d.g.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveVideoCommentSelectAwemePanelViewModel a;
        public final /* synthetic */ sd0.a b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;

        public c(LiveVideoCommentSelectAwemePanelViewModel r1, sd0.a r2, long r3, int r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r9) {
            Response r10 = (Response) r9;
            this.a.getViewEvent().setValue(ud0.d.a.a);
            t5 r0 = f.c(t5.class);
            Long r1 = ((sd0.c) r10.data).b();
            long r2 = 0;
            if (r1 == null) goto L5;
            long r4 = r1.longValue();
        L6:
            r0.setItemId(r4);
            Long r3 = ((sd0.c) r10.data).c();
            if (r3 == null) goto L9;
            long r5 = r3.longValue();
        L10:
            r0.setItemType(r5);
            r0.setTitle(((sd0.c) r10.data).e());
            r0.setBaseUser(((sd0.c) r10.data).f());
            Long r6 = ((sd0.c) r10.data).b();
            if (r6 == null) goto L13;
            String r7 = String.valueOf(r6.longValue());
        L14:
            r0.setItemIdStr(r7);
            Long r8 = ((sd0.c) r10.data).c();
            if (r8 == null) goto L17;
            String r11 = String.valueOf(r8.longValue());
        L18:
            r0.setItemTypeStr(r11);
            Long r12 = ((sd0.c) r10.data).d();
            if (r12 == null) goto L21;
            r2 = r12.longValue();
        L21:
            m0 r13 = f.c(m0.class);
            r13.setRoomId(this.c);
            r13.setMessageId(r2);
            a5 r14 = ((sd0.c) r10.data).a();
            if (r14 == null) goto L24;
            r13.setDisplayText(r14);
        L24:
            r13.setShowMsg(true);
            r13.setMethod("WebcastVideoShareMessage");
            r0.setBaseMessage(r13);
            r0.setPin(this.e);
            r0.setMessageMethod("WebcastVideoShareMessage");
            this.a.getViewEvent().setValue(new ud0.d.C0277d(r0));
            m r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r15 == null) goto L29;
            IRoom r16 = (IRoom) r15.getValue();
            if (r16 == null) goto L29;
            String r17 = r16.getOwnerUserIdString();
        L30:
            m r18 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r18 == null) goto L35;
            IRoom r19 = (IRoom) r18.getValue();
            if (r19 == null) goto L35;
            Long r20 = Long.valueOf(r19.getId());
        L36:
            Long r21 = this.b.b();
            if (r17 == null) goto L45;
            if (r20 == null) goto L46;
            if (r21 == null) goto L47;
            long r22 = r21.longValue();
            long r23 = r20.longValue();
            Map<Integer, String> r24 = td0.b.a;
            int r25 = this.d;
            Intrinsics.checkNotNullParameter(r17, "anchorId");
            LinkedHashMap r26 = new LinkedHashMap();
            TalkRoomLogUtils.J0(r26);
            r26.put("anchor_id", r17);
            r26.put("room_id", String.valueOf(r23));
            td0.b.b(r26);
            TalkRoomLogUtils.B0(r26, null, null, 6);
            LinkedHashMap r27 = (LinkedHashMap) td0.b.a;
            String r28 = (String) r27.get(Integer.valueOf(r25));
            if (r28 != null) goto L43;
            r28 = "";
        L43:
            r26.put("tab_send", r28);
            r26.put("video_id", String.valueOf(r22));
            j0.l().sendLog("livesdk_video_comment_send_success", r26, new Object[0]);
            ALogger.i("LiveVideoCommentPlayLog", "livesdk_video_comment_send_success: tab_send=" + ((String) r27.get(Integer.valueOf(r25))) + ", video_id=" + r22);
            return;
        L47:
            return;
        L46:
            return;
        L45:
            return;
        L35:
            r20 = null;
        L29:
            r17 = null;
            goto L30
        L17:
            r11 = null;
            goto L18
        L13:
            r7 = null;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveVideoCommentSelectAwemePanelViewModel a;

        public d(LiveVideoCommentSelectAwemePanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.getViewEvent().setValue(ud0.d.a.a);
            this.a.getViewEvent().setValue(new ud0.d.c((Throwable) r3));
        }
    }

    private final void fetchTabData() {
        this.viewEvent.setValue(ud0.d.f.a);
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L10;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L10;
        long r2 = r1.getId();
        Disposable r3 = ((LiveVideoCommentApi) com.bytedance.android.live.network.c.b().e(LiveVideoCommentApi.class)).videoTab(r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this));
        if (r3 == null) goto L12;
        RxUtilKt.c(r3, this.compositeDisposable);
        return;
    L12:
        return;
    L10:
        this.viewEvent.setValue(ud0.d.g.a);
    }

    public LiveVideoCommentSelectAwemePanelViewModel() {
        this.viewEvent = new MutableLiveData();
        this.selectedAwemeVideo = new MutableLiveData();
        this.selectPageTab = new MutableLiveData();
        this.compositeDisposable = new CompositeDisposable();
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final MutableLiveData<VideoTab> getSelectPageTab() {
        return this.selectPageTab;
    }

    public final MutableLiveData<sd0.a> getSelectedAwemeVideo() {
        return this.selectedAwemeVideo;
    }

    public final MutableLiveData<ud0.d> getViewEvent() {
        return this.viewEvent;
    }

    public final void doAction(ud0.c r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if ((r3 instanceof ud0.c.a) == false) goto L6;
        fetchTabData();
        return;
    L6:
        if ((r3 instanceof ud0.c.b) == false) goto L10;
        ud0.c.b r4 = (ud0.c.b) r3;
        shareVideo(r4.a, r4.getType(), r4.c);
        return;
    }

    private final void shareVideo(sd0.a r12, int r13, boolean r14) {
        this.viewEvent.setValue(ud0.d.e.a);
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L22;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L23;
        long r9 = r1.getId();
        Long r2 = r12.b();
        if (r2 == null) goto L24;
        long r4 = r2.longValue();
        Long r3 = r12.c();
        if (r3 == null) goto L11;
        long r5 = r3.longValue();
    L12:
        long r6 = r5;
        LiveVideoCommentApi r7 = (LiveVideoCommentApi) com.bytedance.android.live.network.c.b().e(LiveVideoCommentApi.class);
        if (r7 == null) goto L25;
        Observable<Response<sd0.c>> r8 = r7.videoShare(r9, r4, r6, r13);
        if (r8 == null) goto L26;
        Observable r10 = r8.compose(RxUtil.rxSchedulerHelper());
        if (r10 == null) goto L27;
        Disposable r15 = r10.subscribe(new c(this, r12, r9, r13, r14), new d(this));
        if (r15 == null) goto L28;
        RxUtilKt.c(r15, this.compositeDisposable);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L11:
        r5 = 0;
        goto L12
    L24:
        return;
    L23:
        return;
    }
}
