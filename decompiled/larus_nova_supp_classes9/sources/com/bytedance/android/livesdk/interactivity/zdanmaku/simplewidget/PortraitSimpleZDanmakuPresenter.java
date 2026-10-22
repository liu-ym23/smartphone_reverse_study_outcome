package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import android.content.Context;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.config.ck0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.SimpleCommonTextDanmakuShooter;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.api.HistoryMsgApi;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PortraitSimpleZDanmakuPresenter extends n<IView> implements l {
    public final SimpleCommonTextDanmakuShooter e;
    public Disposable f;
    public int g;
    public Disposable h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/PortraitSimpleZDanmakuPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        int U();

        void X(Object r1, boolean r2);

        /* synthetic */ Context getContext();

        Room getRoom();

        boolean isEnablePreviewDanmaku();

        void jR();

        p22.n mp();

        void ps();

        boolean t7();
    }

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ PortraitSimpleZDanmakuPresenter a;

        public b(PortraitSimpleZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final Object apply(Object r8) {
            Response r9 = (Response) r8;
            Intrinsics.checkNotNullParameter(r9, "it");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L43;
            if (r0.isEnablePreviewDanmaku() != true) goto L43;
            im2.d r1 = new im2.d(z.e(((n) this.a).c, false));
            List<com.bytedance.android.livesdk.chatroom.model.n> r10 = ((com.bytedance.android.livesdk.interactivity.api.barrage.model.b) ((BaseResponse) r9).data).a();
            Integer r2 = null;
            if (r10 == null) goto L17;
            ArrayList r3 = new ArrayList();
            Iterator<T> r11 = r10.iterator();
        L10:
            if (r11.hasNext() == false) goto L18;
            tlc.d r4 = r1.b((com.bytedance.android.livesdk.chatroom.model.n) r11.next());
            if ((r4 instanceof e2) == true) goto L14;
            r4 = null;
        L14:
            e2 r5 = (e2) r4;
            if (r5 == null) goto L10;
            r3.add(r5);
        L18:
            long r6 = System.currentTimeMillis();
            if (r3 == null) goto L32;
            ArrayList r13 = new ArrayList();
            Iterator<T> r7 = r3.iterator();
        L22:
            if (r7.hasNext() == false) goto L33;
            k0 r14 = (e2) r7.next();
            if ((r14 instanceof k0) == true) goto L26;
            k0 r15 = null;
        L27:
            if (r15 == null) goto L29;
            r15.setDanmakuReceiveTime(r6);
        L29:
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r16 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r14);
            if (r16 == null) goto L22;
            r13.add(r16);
            goto L22
        L26:
            r15 = r14;
        L33:
            int r17 = i.a;
            StringBuilder r18 = new StringBuilder("origin history message size: ");
            if (r3 == null) goto L36;
            Integer r19 = Integer.valueOf(r3.size());
        L37:
            r18.append(r19);
            r18.append(", text message size: ");
            if (r13 == null) goto L40;
            r2 = Integer.valueOf(r13.size());
        L40:
            r18.append(r2);
            i.c(r18.toString());
            return r13;
        L36:
            r19 = null;
            goto L37
        L32:
            r13 = null;
            goto L33
        L17:
            r3 = null;
        L43:
            throw new Exception("map#1, room auth is false or danmaku is off");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PortraitSimpleZDanmakuPresenter a;

        public c(PortraitSimpleZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            List r5 = (List) r4;
            i.c("request history danmaku success");
            this.a.i0(2);
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L23;
            boolean r2 = true;
            if (r0.isEnablePreviewDanmaku() != true) goto L23;
            List r1 = r5;
            if (r1 != null) goto L10;
        L13:
            if (r2 == false) goto L15;
            i.c("history message is empty");
            this.a.i0(4);
            return;
        L15:
            IView r3 = ((q46.b) this.a).a;
            if (r3 == null) goto L18;
            r3.jR();
        L18:
            this.a.i0(3);
            Iterator<T> r6 = r5.iterator();
        L20:
            if (r6.hasNext() == false) goto L22;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r7 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) r6.next();
            this.a.k0(r7);
            goto L20
        L22:
            PortraitSimpleZDanmakuPresenter r8 = this.a;
            r8.h0();
            r8.h = Observable.timer(LivePreviewDanmakuConfig.Companion.getHistoryDanmakuTimeoutDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.b(r8));
            return;
        L10:
            if (r1.isEmpty() == true) goto L13;
            r2 = false;
        L23:
            i.c("room auth is false or danmaku is off");
            this.a.i0(4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PortraitSimpleZDanmakuPresenter a;

        public d(PortraitSimpleZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.i0(4);
            int r0 = i.a;
            StringBuilder r1 = new StringBuilder("request history danmaku error, msg: ");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r1.append(r5);
            i.b(r1.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class e implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
        public final /* synthetic */ PortraitSimpleZDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            return true;
        }

        public e(PortraitSimpleZDanmakuPresenter r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    static {
    }

    public final void l0() {
        i0(1);
        Disposable r0 = this.f;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (((Boolean) ck0.a.getValue()).booleanValue() == false) goto L8;
        i.c("request use bytelink");
        HistoryMsgApi r1 = (HistoryMsgApi) ac2.e.b().a(HistoryMsgApi.class);
    L9:
        HistoryMsgApi r2 = r1;
        IView r3 = ((q46.b) this).a;
        if (r3 == null) goto L14;
        Room r4 = r3.getRoom();
        if (r4 == null) goto L14;
        long r5 = r4.id;
    L15:
        this.f = r2.getHistoryMsg(1, r5, "preview").subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).map(new b(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
        return;
    L14:
        r5 = 0;
        goto L15
    L8:
        i.c("request use http");
        r1 = (HistoryMsgApi) com.bytedance.android.live.network.c.b().e(HistoryMsgApi.class);
        goto L9
    }

    public final void detachView() {
        this.e.d();
        this.e.getClass();
        Disposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.f = null;
        h0();
        i0(0);
        super.detachView();
    }

    public final void h0() {
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.h = null;
    }

    public final boolean j0() {
        int r0 = this.g;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return true;
    L7:
        if (r0 == 3) goto L13;
        return false;
    L13:
        return true;
    }

    public PortraitSimpleZDanmakuPresenter() {
        this.e = new SimpleCommonTextDanmakuShooter(new e(this));
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r1) {
        super.c0(r1);
        this.e.getClass();
    }

    public final void i0(int r3) {
        int r0 = i.a;
        i.c("change history danmaku state, oldState: " + this.g + ", newState: " + r3);
        this.g = r3;
    }

    public final void k0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11 instanceof b0) == false) goto L36;
        p0 r13 = (p0) r11;
        IView r0 = ((q46.b) this).a;
        if (r0 == null) goto L49;
        int r1 = (int) r0.mp().i;
        tb2.d r2 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.b.a(r13, r1);
        int r3 = (int) r0.mp().d;
        Iterator<tb2.c> r4 = r2.a.iterator();
    L11:
        if (r4.hasNext() == false) goto L34;
        tb2.c r5 = r4.next();
        ITextPieceImage r6 = r5.getImageValue();
        if (r6 == null) goto L11;
        if (r6.getScalingRate() == 0.0f) goto L11;
        float r7 = r1;
        if (((int) (r6.getScalingRate() * r7)) <= (r3 - s1.f(4.0f))) goto L19;
        int r8 = r3 - s1.f(4.0f);
    L21:
        if (r6.getWidth() != 0) goto L23;
    L25:
        r6.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r6.setHeight(r8);
    L27:
        if ((r13 instanceof a0) == false) goto L11;
        if (r13.getDefaultContent().length() <= 0) goto L31;
        boolean r9 = true;
    L32:
        if (r9 == false) goto L11;
        r6.setEnableTextWhenFailed(true);
        r5.setText(r13.getDefaultContent());
        goto L11
    L31:
        r9 = false;
        goto L32
    L23:
        if (r6.getHeight() == 0) goto L25;
        r6.setWidth((int) ((r6.getWidth() / r6.getHeight()) * r8));
        r6.setHeight(r8);
        goto L27
    L19:
        r8 = (int) (r7 * r6.getScalingRate());
        goto L21
    L34:
        qb2.c.b(r2, new com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.a(this, r13), null, 16);
        return;
    L49:
        return;
    L36:
        this.e.a(r11);
    }

    public final void onMessage(tlc.d r6) {
        k0 r1 = null;
        if ((r6 instanceof t) == true) goto L5;
        tlc.d r0 = null;
    L6:
        k0 r2 = (t) r0;
        if (r2 != null) goto L9;
        return;
    L9:
        String r3 = r2.getMessageMethod();
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.hashCode() == 41447196) goto L16;
        return;
    L16:
        if (r3.equals("WebcastChatMessage") == false) goto L52;
        i.c("receive chat message");
        IView r4 = ((q46.b) this).a;
        if (r4 != null) goto L20;
    L50:
        i.c("room auth is false or danmaku is off");
        return;
    L20:
        if (r4.isEnablePreviewDanmaku() != true) goto L50;
        if ((r2 instanceof e2) == true) goto L25;
        k0 r5 = null;
    L26:
        e2 r7 = (e2) r5;
        if (r7 == null) goto L48;
        PublicAreaCommon r8 = r7.getOrInitPublicAreaCommon();
        if (r8 == null) goto L48;
        if (r8.getShowInDanmaku() != true) goto L48;
        if (j0() == false) goto L37;
        i.c("history danmaku is running, current history is " + this.g);
        return;
    L37:
        IView r9 = ((q46.b) this).a;
        if (r9 == null) goto L41;
        r9.jR();
    L41:
        if ((r2 instanceof k0) == false) goto L44;
        r1 = r2;
    L44:
        k0 r10 = r1;
        if (r10 == null) goto L47;
        r10.setDanmakuReceiveTime(System.currentTimeMillis());
    L47:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        k0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a((t) r6));
        return;
    L48:
        i.c("message isn't danmaku");
        return;
    L25:
        r5 = r2;
        goto L26
    L52:
        return;
    L5:
        r0 = r6;
        goto L6
    }
}
