package com.bytedance.android.livesdk.interactivity.medialink.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiLinkAudienceControlContext;
import com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAudienceControlView;
import com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.MediaMultiLinkAudienceControlPresenter;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/MediaMultiLinkAudienceControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/IMediaMultiLinkAudienceControlView;", "Lx82/c;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAudienceControlWidget extends LiveWidget implements IMediaMultiLinkAudienceControlView, x82.c {
    public MediaMultiLinkAudienceControlPresenter a;
    public hy.a b;
    public final a c;
    public final CompositeDisposable d;
    public long e;

    public static final class a extends hy.f.a {
        public final /* synthetic */ MediaMultiLinkAudienceControlWidget a;

        public a(MediaMultiLinkAudienceControlWidget r1) {
            this.a = r1;
        }

        public final void d(int r2, List<AnchorLinkUser> r3) {
            if (r3 == null) goto L5;
            ((Widget) this.a).dataCenter.put("DATA_ANCHOR_LINK_USERS", r3);
            return;
        }
    }

    public static final class b implements hy.g {
        public final /* synthetic */ MediaMultiLinkAudienceControlWidget a;

        public final long getChannelId() {
            return this.a.e;
        }

        public b(MediaMultiLinkAudienceControlWidget r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.medialink.widget.MediaMultiLinkAudienceControlWidget$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/MediaMultiLinkAudienceControlContext;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<MediaMultiLinkAudienceControlContext> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0, MediaMultiLinkAudienceControlContext.class, "<init>", "<init>()V", 0);
        }

        public final MediaMultiLinkAudienceControlContext invoke() {
            return new MediaMultiLinkAudienceControlContext();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m750invoke() {
            return invoke();
        }
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a207";
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.b
    @Deprecated(message = "拆分空实现！ 勿用！ 全量后删除")
    public final void jg(int r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "reqSrc");
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.b
    public final hy.e Np() {
        hy.a r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkUserCenter");
    L5:
        return r0;
    }

    public MediaMultiLinkAudienceControlWidget() {
        this.c = new a(this);
        this.d = new CompositeDisposable();
    }

    public final void onCreate() {
        super.onCreate();
        ALogger.e("MediaLinkTracer", "MediaMultiLinkAudienceControlWidget onCreate");
        Room r0 = (Room) ((Widget) this).dataCenter.get("data_room", new Room());
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L5:
        MediaMultiLinkAudienceControlPresenter r1 = new MediaMultiLinkAudienceControlPresenter(r0);
        this.a = r1;
        r1.g0(this);
        hy.a r2 = new hy.a(((Widget) this).dataCenter, new b(this));
        this.b = r2;
        r2.attach();
        hy.a r3 = this.b;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkUserCenter");
    L8:
        r3.i(this.c);
        Pair r4 = com.bytedance.live.datacontext.d.a(AnonymousClass2.INSTANCE);
        ((MediaMultiLinkAudienceControlContext) r4.getFirst()).getLinkService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r4.getFirst(), MediaLinkContext.class);
        ((MediaMultiLinkAudienceControlContext) r4.getFirst()).getLogParams().d(new w82.a(0));
        RxUtilKt.c((Disposable) r4.getSecond(), this.d);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.clear();
        MediaMultiLinkAudienceControlPresenter r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L5:
        r0.detachView();
    }

    @Override // x82.c
    public final long getChannelId() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAudienceControlView
    public final void rM(com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.b r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "reqSrc");
        ALogger.e("MediaLinkTracer", "MediaMultiLinkAudienceControlWidget try load MultiLinkAudienceWidget " + r5 + " from " + r4);
        this.e = r5;
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r0 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r0 == null) goto L6;
        int r1 = com.bytedance.android.livesdk.interactivity.medialink.contract.e.c;
        Intrinsics.checkNotNullParameter(r4, "source");
        r0.gq(new com.bytedance.android.livesdk.interactivity.medialink.contract.e(null, new com.bytedance.android.livesdk.interactivity.medialink.contract.g(r5, r4), 1));
        return;
    }
}
