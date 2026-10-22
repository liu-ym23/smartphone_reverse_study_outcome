package com.bytedance.android.live.liveinteract.videotalk.quickinteract;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.j;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.k;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.message.model.n7;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nd0.g;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/QuickInteractWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/live/liveinteract/videotalk/quickinteract/b;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class QuickInteractWidget extends MiddlewareRoomWidget implements com.bytedance.android.live.liveinteract.videotalk.quickinteract.b, l {
    public static long e;
    public static final /* synthetic */ int f = 0;
    public final LinkedList<QuickInteractTask> a;
    public final CompositeDisposable b;
    public com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a c;
    public final Handler d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ QuickInteractWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Function1 f;

        public b(QuickInteractWidget r1, long r2, long r4, String r6, String r7, Function1 r8) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r27) {
            com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r27;
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            long r3 = this.b;
            long r6 = this.c;
            String r8 = r1.logId;
            r2.getClass();
            TalkRoomBusinessFullLinkMonitor.u0(r3, 0, r6, r8);
            Long r4 = null;
            vlc.d r5 = (vlc.d) ((Widget) this.a).dataCenter.get("data_message_manager", null);
            tlc.d r7 = ((com.bytedance.android.live.liveinteract.voicechat.model.a) r1.data).a();
            if (r7 == null) goto L33;
            QuickInteractWidget r9 = this.a;
            int r10 = QuickInteractWidget.f;
            r7.setCurrUserIsAnchor(a0.d(((Widget) r9).dataCenter, false));
            if (r5 == null) goto L7;
            r5.B(r7);
        L7:
            TalkRoomLogUtils.n(a0.d(((Widget) this.a).dataCenter, false), this.d, je0.d.f(), r7.getDynamicEmojiFlex());
            w8 r11 = ((com.bytedance.android.live.liveinteract.voicechat.model.a) r1.data).a();
            if (r11 == null) goto L10;
            r4 = Long.valueOf(r11.getMessageId());
        L10:
            x.s0(r4.longValue(), r7.getDynamicEmojiFlex());
            QuickInteractWidget r12 = this.a;
            String r15 = this.e;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r15, "sendGiftId");
            Iterator<QuickInteractTask> r13 = r12.a.descendingIterator();
            if (r13.hasNext() == false) goto L16;
            QuickInteractTask r14 = r13.next();
            if (Intrinsics.areEqual(r14.d, r15) == false) goto L16;
            r14.c = 0;
        L16:
            if (r13.hasNext() == false) goto L20;
            if (Intrinsics.areEqual(r13.next().d, r15) == false) goto L16;
            r13.remove();
            goto L16
        L20:
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a r16 = r12.c;
            if (r16 == null) goto L24;
            r16.c(new QuickInteractTask(je0.d.b0(), null, 0, r15, null, null, 0, null, true, null, null, null, null, 7862));
        L24:
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a r17 = r12.c;
            if (r17 == null) goto L27;
            r17.c(new QuickInteractTask(je0.d.b0(), null, 0, r15, null, null, 1, null, true, null, null, null, null, 7862));
        L27:
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a r18 = r12.c;
            if (r18 == null) goto L30;
            r18.c(new QuickInteractTask(je0.d.b0(), null, 0, r15, null, null, 2, null, true, null, null, null, null, 7862));
        L30:
            this.f.invoke(1);
            return;
        L33:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.ILinkMicDynamicEmojiMessage");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ QuickInteractWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function1 d;

        public c(QuickInteractWidget r1, long r2, long r4, Function1 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
        }

        public final void accept(Object r8) {
            ApiServerException r9 = (Throwable) r8;
            QuickInteractWidget r0 = this.a;
            int r1 = QuickInteractWidget.f;
            r0.getClass();
            if ((r9 instanceof ApiServerException) == false) goto L7;
            ApiServerException r2 = r9;
            if (TextUtils.isEmpty(r2.getPrompt()) == true) goto L7;
            f2.c(r2.getPrompt(), 0);
            boolean r3 = true;
        L8:
            if (r3 == true) goto L10;
            ExceptionUtils.handleException(((Widget) this.a).context, r9);
        L10:
            TalkRoomBusinessFullLinkMonitor r4 = TalkRoomBusinessFullLinkMonitor.a;
            long r5 = this.b;
            long r6 = this.c;
            r4.getClass();
            TalkRoomBusinessFullLinkMonitor.t0(r5, 0, r6, r9);
            x.r0(r9, false);
            this.d.invoke(0);
            return;
        L7:
            r3 = false;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ QuickInteractWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ QuickInteractTask c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function1 e;

        public d(QuickInteractWidget r1, long r2, QuickInteractTask r4, String r5, Function1 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            int r0 = g.a;
            g.c(je0.d.f(), 1, 4, this.b, r9);
            Iterator<T> r10 = ((k) r9.data).getEmojiList().iterator();
        L4:
            if (r10.hasNext() == false) goto L11;
            T r1 = r10.next();
            if (((j) r1).getEmojiCategory() != 4) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
        L12:
            j r3 = (j) r1;
            if (r3 == null) goto L21;
            long r4 = r3.getEmojiId();
            QuickInteractWidget.e = r4;
            this.a.aj(this.c.d, r4, this.d, this.e);
            return;
        L21:
            return;
        L8:
            r2 = false;
            goto L9
        L11:
            r1 = null;
            goto L12
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public e(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            int r1 = je0.d.f();
            long r4 = this.a;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.y(r1, 1, 4, r4, r8);
            ALogger.e("quick_interact_service", "error when get emoji id e:" + r8);
            this.b.invoke(0);
        }
    }

    static {
        e = -1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final void F6() {
        this.d.post(new com.bytedance.android.live.liveinteract.videotalk.quickinteract.d(this));
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    public final void xq() {
        QuickInteractTask r0 = (QuickInteractTask) CollectionsKt.lastOrNull(this.a);
        this.a.clear();
        if (r0 == null) goto L8;
        r0.c = 0;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a r1 = this.c;
        if (r1 == null) goto L9;
        r1.c(r0);
        return;
    L9:
        return;
    }

    public QuickInteractWidget() {
        this.a = new LinkedList();
        this.b = new CompositeDisposable();
        this.d = new Handler(Looper.getMainLooper());
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(QuickInteractWidget$onCreate$pair$1.INSTANCE);
        ((QuickInteractContext) r0.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r0.getFirst(), "quick_interact_service");
        this.b.add((Disposable) r0.getSecond());
        t r1 = m.b();
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.j r2 = r1.getMessageManager();
        if (r2 == null) goto L7;
        r2.c(new AnonymousClass1(this));
    L7:
        xq();
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        xq();
        t r0 = m.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeMessageListener(this);
    L9:
        this.b.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final void C9(BaseMultiLinkWindowManager.c r1) {
        xq();
        this.c = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final void Fn(String r5) {
        Intrinsics.checkNotNullParameter(r5, "emojiID");
        String r0 = (String) vm2.d.s5.getValue(null, vm2.d.a[328(0x148, float:4.6E-43)]);
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.live.datacontext.m r2 = m.j(this).getRoom();
        if (r2 == null) goto L7;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L7;
        long r4 = r3.getId();
    L8:
        r1.put("room_id", String.valueOf(r4));
        r1.put("emoji_id", r5);
        String r6 = y0.b(r0, r1);
        jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r6);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final void Xb(QuickInteractTask r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Intrinsics.checkNotNullParameter("on_seat", "requestPage");
        Integer r0 = r4.l;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 1) goto L9;
        i0 r1 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.k1("on_seat", r4.d);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final void k7(QuickInteractTask r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        this.d.post(new com.bytedance.android.live.liveinteract.videotalk.quickinteract.d(this));
    }

    public final void onMessage(tlc.d r2) {
        if ((r2 instanceof n7) == false) goto L8;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.a r0 = this.c;
        if (r0 == null) goto L9;
        r0.a((n7) r2);
        return;
    L9:
        return;
    }

    public final void wq(QuickInteractTask r6) {
        QuickInteractTask r0 = (QuickInteractTask) CollectionsKt.lastOrNull(this.a);
        if (r0 == null) goto L11;
        if (r0.c <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        this.a.removeLast();
        goto L11
    L7:
        r1 = false;
    L11:
        if (this.a.size() <= ((Number) vm2.d.i4.getValue(null, vm2.d.a[266(0x10a, float:3.73E-43)])).intValue()) goto L13;
        this.a.removeFirst();
    L13:
        this.a.addLast(r6);
        this.d.post(new com.bytedance.android.live.liveinteract.videotalk.quickinteract.d(this));
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final void Si(QuickInteractTask r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "task");
        if (r4 == true) goto L6;
        wq(r3);
        return;
    L6:
        QuickInteractTask r5 = (QuickInteractTask) CollectionsKt.lastOrNull(this.a);
        if (r5 != null) goto L9;
    L14:
        wq(r3);
        return;
    L9:
        if (TextUtils.equals(r5.b, r3.b) == false) goto L14;
        if (r5.getType() != r3.getType()) goto L14;
        ALogger.e("quick_interact_service", "drop task for equal, task: " + r3.b + "  last: " + r5.b);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final void vk(QuickInteractTask r13, String r14, Function1<? super Integer, Unit> r15) {
        Intrinsics.checkNotNullParameter(r13, "task");
        Intrinsics.checkNotNullParameter(r14, "requestPage");
        Intrinsics.checkNotNullParameter(r15, "onFinished");
        String r0 = r13.k;
        boolean r2 = false;
        if (((Number) vm2.d.j4.getValue(null, vm2.d.a[267(0x10b, float:3.74E-43)])).intValue() == 0) goto L17;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L17;
        ALogger.i("[quick_interact]", "handleSchemaClick schema:" + r0);
        IBaseLiveActionHandler r3 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r3 == null) goto L16;
        r3.handle(((Widget) this).context, UriProtector.parse(r0));
    L16:
        r2 = true;
        goto L17
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
    L17:
        if (r2 == false) goto L25;
        Integer r16 = r13.l;
        if (r16 != null) goto L22;
        return;
    L22:
        if (r16.intValue() != 1) goto L36;
        i0 r17 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.j1("on_seat", r13.d);
        return;
    L36:
        return;
    L25:
        long r4 = e;
        if (r4 != (-1)) goto L34;
        long r5 = System.currentTimeMillis();
        LinkApi r6 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        com.bytedance.live.datacontext.m r7 = m.j(this).getRoom();
        if (r7 == null) goto L32;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L32;
        long r9 = r8.getId();
    L33:
        RxUtilKt.c(LinkApi.a.a(r6, r9, je0.d.f(), 1, 4).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r5, r13, r14, r15), new e(r5, r15)), this.b);
        return;
    L32:
        r9 = 0;
        goto L33
    L34:
        aj(r13.d, r4, r14, r15);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.quickinteract.b
    public final void aj(String r17, long r18, String r20, Function1<? super Integer, Unit> r21) {
        Intrinsics.checkNotNullParameter(r17, "toUserID");
        Intrinsics.checkNotNullParameter(r20, "requestPage");
        Intrinsics.checkNotNullParameter(r21, "onFinished");
        long r13 = System.currentTimeMillis();
        LinkApi r1 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        com.bytedance.live.datacontext.m r0 = m.j(this).getRoom();
        if (r0 == null) goto L7;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L7;
        long r3 = r2.getId();
    L8:
        RxUtilKt.c(r1.sendTalkRoomInteractEmoji(r3, r18, je0.d.f(), 1, r17, r17).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r18, r13, r20, r17, r21), new c(this, r18, r13, r21)), this.b);
        return;
    L7:
        r3 = 0;
        goto L8
    }
}
