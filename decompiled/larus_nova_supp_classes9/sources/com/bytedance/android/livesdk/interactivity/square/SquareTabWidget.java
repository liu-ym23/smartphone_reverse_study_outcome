package com.bytedance.android.livesdk.interactivity.square;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.SquareChatApi;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import com.bytedance.android.livesdk.interactivity.square.common.BaseMessageModelAdapter;
import com.bytedance.android.livesdk.interactivity.square.common.BaseModelListScrollManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import ec2.e1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/square/SquareTabWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/e;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SquareTabWidget extends MiddlewareRoomRecyclableWidget implements com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e {
    public static final /* synthetic */ int i = 0;
    public RecyclerView a;
    public LinearLayout b;
    public NoMoreSpaceTextView c;
    public com.bytedance.android.livesdk.interactivity.square.common.f d;
    public CompositeDisposable e;
    public Disposable f;
    public final com.bytedance.android.livesdk.interactivity.square.b g;
    public final c h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SquareTabWidget a;

        public b(SquareTabWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            o42.b r5 = (o42.b) r4;
            SquareTabWidget r6 = this.a;
            int r0 = SquareTabWidget.i;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = r6.xq();
            e52.a r2 = null;
            if (r1 == null) goto L5;
            e52.a r3 = r1.getTextConfig();
        L7:
            if ((r3 instanceof q92.a) == false) goto L10;
            r2 = r3;
        L10:
            q92.a r7 = (q92.a) r2;
            if (r7 == null) goto L19;
            DataCenter r8 = ((Widget) r6).dataCenter;
            if (r8 != null) goto L15;
        L17:
            boolean r9 = false;
        L18:
            r7.m = q.a(r7, true, r9);
            goto L19
        L15:
            if (z.b(r8).c != true) goto L17;
            r9 = true;
        L19:
            com.bytedance.android.livesdk.interactivity.square.common.f r10 = r6.d;
            if (r10 == null) goto L23;
            r10.e.notifyDataSetChanged();
            return;
        L23:
            return;
        L5:
            r3 = null;
            goto L7
        }
    }

    public static final class c implements o<Object> {
        public final /* synthetic */ SquareTabWidget a;

        public c(SquareTabWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o
        public final void a(Object r7) {
            Intrinsics.checkNotNullParameter(r7, "updateInfo");
            SquareTabWidget r8 = this.a;
            int r0 = SquareTabWidget.i;
            if (((Widget) r8).dataCenter == null) goto L30;
            com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r1 = r8.wq();
            if (r1 == null) goto L10;
            int r2 = 1;
            if (r1.f() != true) goto L10;
        L11:
            IRoom r3 = z.b(((Widget) r8).dataCenter).a;
            if (r3 == null) goto L14;
            long r4 = r3.getRoomId();
        L15:
            Ref.BooleanRef r5 = new Ref.BooleanRef();
            r5.element = false;
            Disposable r6 = r8.f;
            if (r6 == null) goto L18;
            r6.dispose();
        L18:
            SquareChatApi.a.getClass();
            SquareChatApi r9 = (SquareChatApi) com.bytedance.android.live.network.c.b().e(SquareChatApi.class);
            if (r9 == null) goto L27;
            Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.a>> r10 = r9.getSquareTabChat(Long.valueOf(r4), r2);
            if (r10 == null) goto L27;
            Observable r11 = r10.subscribeOn(Schedulers.io());
            if (r11 == null) goto L27;
            Observable r13 = r11.observeOn(AndroidSchedulers.mainThread());
            if (r13 == null) goto L27;
            Disposable r14 = r13.subscribe(new k(r8, r2, r5), l.a);
        L28:
            r8.f = r14;
            return;
        L27:
            r14 = null;
            goto L28
        L14:
            r4 = 0;
        L10:
            r2 = 0;
            goto L11
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567468;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e
    public final void l2() {
        ALogger.i("square_tab", "square tab visiable");
        com.bytedance.android.livesdk.interactivity.square.common.f r0 = this.d;
        if (r0 == null) goto L5;
        BaseModelListScrollManager r1 = r0.a;
        r1.j.post(new com.bytedance.android.livesdk.interactivity.square.common.d(r1));
    L5:
        this.g.h();
        com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r2 = wq();
        if (r2 == null) goto L9;
        r2.b();
        return;
    }

    public final void onUnload() {
        ALogger.i("square_tab", "widget unload");
        com.bytedance.android.livesdk.interactivity.square.common.f r0 = this.d;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.d = null;
        this.g.i();
        com.bytedance.android.livesdk.interactivity.square.b r1 = this.g;
        c r2 = this.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) r1.a).remove(r2);
        CompositeDisposable r3 = this.e;
        if (r3 == null) goto L8;
        r3.dispose();
    L8:
        this.e = null;
        Disposable r4 = this.f;
        if (r4 == null) goto L11;
        r4.dispose();
    L11:
        com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r5 = wq();
        if (r5 == null) goto L14;
        r5.stopMessage();
    L14:
        com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r6 = wq();
        if (r6 == null) goto L17;
        r6.h();
    L17:
        Disposable r7 = e.c;
        if (r7 == null) goto L20;
        r7.dispose();
    L20:
        e.c = null;
        Disposable r8 = e.d;
        if (r8 == null) goto L23;
        r8.dispose();
    L23:
        e.d = null;
        if (e.e <= 0) goto L27;
        e.b();
        return;
    }

    public final com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b wq() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(((Widget) this).dataCenter, 1);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b> r1 = r0.getSquareTabManager();
        if (r1 == null) goto L7;
        return (com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b) r1.getValue();
    L7:
        return null;
    }

    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.l xq() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(((Widget) this).dataCenter, 1);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r1 = r0.getPublicScreenContext();
        if (r1 == null) goto L7;
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e
    public final void z5() {
        ALogger.i("square_tab", "square tab inVisiable");
        com.bytedance.android.livesdk.interactivity.square.common.f r0 = this.d;
        if (r0 == null) goto L5;
        BaseModelListScrollManager r1 = r0.a;
        r1.b = r1.a;
    L5:
        com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r2 = wq();
        if (r2 == null) goto L8;
        r2.h();
    L8:
        this.g.i();
    }

    public SquareTabWidget() {
        this.g = new com.bytedance.android.livesdk.interactivity.square.b(((long) com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.d.a.f()) * 1000);
        this.h = new c(this);
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onDestroy();
        com.bytedance.android.livesdk.interactivity.square.common.f r0 = this.d;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void onInit(Object[] r2) {
        this.a = ((Widget) this).contentView.findViewById(2131387131);
        this.b = (LinearLayout) ((Widget) this).contentView.findViewById(2131387130);
        this.c = ((Widget) this).contentView.findViewById(2131374378);
        if (((Boolean) e1.a.getValue()).booleanValue() == true) goto L11;
        RecyclerView r3 = this.a;
        if (r3 == null) goto L7;
        r3.setHorizontalFadingEdgeEnabled(false);
    L7:
        RecyclerView r4 = this.a;
        if (r4 == null) goto L12;
        r4.setVerticalFadingEdgeEnabled(false);
        return;
    L12:
        return;
    }

    public final void onLoad(Object[] r9) {
        ALogger.i("square_tab", "widget onload");
        RecyclerView r2 = this.a;
        if (r2 != null) goto L5;
        return;
    L5:
        LinearLayout r3 = this.b;
        if (r3 != null) goto L8;
        return;
    L8:
        NoMoreSpaceTextView r4 = this.c;
        if (r4 != null) goto L11;
        return;
    L11:
        com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b r0 = wq();
        if (r0 != null) goto L14;
        return;
    L14:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = xq();
        if (r1 != null) goto L17;
        return;
    L17:
        k52.a r5 = r0.k();
        this.e = new CompositeDisposable();
        ALogger.i("square_tab", "onload manager is " + r0);
        com.bytedance.android.livesdk.interactivity.square.common.f r7 = new com.bytedance.android.livesdk.interactivity.square.common.f(r2, r3, r4, new BaseMessageModelAdapter(r1, ((Widget) this).context, r5), s1.f(2.0f));
        IModelListDataManager r10 = r0.g();
        Intrinsics.checkNotNullParameter(r10, "manager");
        BaseMessageModelAdapter r6 = r7.e;
        List<h52.c> r8 = r10.getMessageList();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r8, "items");
        r6.a = r8;
        r7.e.notifyDataSetChanged();
        BaseModelListScrollManager r11 = r7.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "manager");
        r11.h = r10;
        Disposable r13 = r11.g;
        if (r13 == null) goto L20;
        r13.dispose();
    L20:
        m52.e r14 = r10.c();
        if (r14 == null) goto L25;
        PublishSubject<Integer> r15 = r14.b;
        if (r15 == null) goto L25;
        Disposable r16 = r15.subscribe(new com.bytedance.android.livesdk.interactivity.square.common.c(r11));
    L26:
        r11.g = r16;
        r11.c();
        RxUtilKt.c(r10.a().subscribe(new com.bytedance.android.livesdk.interactivity.square.common.h(r7)), r7.c);
        Unit r17 = Unit.INSTANCE;
        this.d = r7;
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).b(o42.b.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.e);
        this.g.b(this.h);
        r0.j();
        r0.startMessage();
        int r18 = e.a;
        z.b(((Widget) this).dataCenter);
        z.b(((Widget) this).dataCenter);
        int r19 = e.b;
        if (r19 <= 0) goto L33;
        Disposable r20 = e.d;
        if (r20 == null) goto L31;
        r20.dispose();
    L31:
        e.d = Observable.interval(r19, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(d.a);
        return;
    L33:
        return;
    L25:
        r16 = null;
        goto L26
    }
}
