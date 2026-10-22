package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import android.util.AttributeSet;
import com.bytedance.android.live.base.model.message.i;
import com.bytedance.android.live.base.model.message.k6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import f32.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements f52.d, l {
    public f52.b a;
    public PlayerProgressServiceContext b;
    public boolean c;
    public final CompositeDisposable d;
    public NewHotMsgView e;
    public final List<Runnable> f;
    public f32.e g;
    public final b h;
    public final String i;

    public static final class a {
    }

    public static final class b implements h32.d<f32.e> {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // h32.d
        public final void a(f r2) {
            f32.e r3 = (f32.e) r2;
            Intrinsics.checkNotNullParameter(r3, "newConfig");
            this.a.g = r3;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Ref.ObjectRef d;

        public c(d r1, List r2, int r3, Ref.ObjectRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            f52.b r0 = this.a.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("container");
        L5:
            NewHotMsgPSTopView r1 = new NewHotMsgPSTopView((i) ListProtector.get(this.b, this.c), this.a.d());
            r1.n = ((tlc.d) this.d.element).getHighlightAreaPriorityConfig();
            Unit r2 = Unit.INSTANCE;
            r0.a(r1);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final NewHotMsgView d() {
        NewHotMsgView r0 = this.e;
        if (r0 != null) goto L10;
        f52.b r1 = this.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L7:
        AttributeSet r4 = null;
        r0 = new NewHotMsgView(r1.getContext(), r4, 6, 0);
        r0.setVisibility(8);
        this.e = r0;
        f52.b r2 = this.a;
        if (r2 == null) goto L10;
        z.a r3 = z.a;
        DataCenter r5 = r2.getDataCenter();
        r3.getClass();
        r0.setShowInPSHighlightArea(z.a.a(r5));
    L10:
        return r0;
    }

    @Override // f52.d
    public final void onUnload() {
        ALogger.i("NewHotMsgViewManager", "onUnload");
        this.d.clear();
        Iterator r0 = ((ArrayList) this.f).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MainThreadPostUtils.d((Runnable) r0.next());
        goto L4
    L6:
        ((ArrayList) this.f).clear();
    }

    public d() {
        this.d = new CompositeDisposable();
        this.f = new ArrayList();
        this.g = new f32.e(false, 3);
        this.h = new b(this);
        this.i = "NewHotMsgViewManager";
    }

    @Override // f52.d
    public final String getId() {
        return this.i;
    }

    @Override // f52.d
    public final void j(f52.b r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        this.a = r5;
        ALogger.i("NewHotMsgViewManager", "onLoad");
        o r0 = r5.getRoomContext();
        if (r0 == null) goto L5;
        boolean r1 = r0.isVSFirstShow();
    L6:
        this.c = r1;
        DataCenter r6 = r5.getDataCenter();
        IVSPlayerService r2 = k.f(IVSPlayerService.class);
        if (r2 == null) goto L11;
        IPlayerProgressService r3 = r2.provideVSProgressService(r6);
        if (r3 == null) goto L11;
        PlayerProgressServiceContext r4 = r3.provideContext(r6);
    L12:
        this.b = r4;
        IRoomContextService r7 = k.f(IRoomContextService.class);
        if (r7 == null) goto L23;
        o r8 = IRoomContextService.a.a(r7, r6, 0, 2);
        if (r8 == null) goto L23;
        j r9 = r8.getMessageManager();
        if (r9 == null) goto L23;
        vlc.d r10 = (vlc.d) r9.getValue();
        if (r10 == null) goto L23;
        int r11 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.a;
        Disposable r13 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.c(r10, MessageType.NEW_HOT_MSG_MESSAGE.getWsMethod(), this);
        if (r13 == null) goto L23;
        RxUtilKt.c(r13, this.d);
    L23:
        h r14 = com.bytedance.android.livesdk.interactivity.api.i.b(r6, 1);
        if (r14 == null) goto L35;
        j<h32.a> r15 = r14.getDegradeManager();
        if (r15 == null) goto L36;
        h32.a r16 = (h32.a) r15.getValue();
        if (r16 == null) goto L37;
        h32.c<f32.e> r17 = r16.g();
        if (r17 == null) goto L38;
        Disposable r18 = g32.b.a(r17, this.h);
        if (r18 == null) goto L39;
        RxUtilKt.c(r18, this.d);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L11:
        r4 = null;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public final void onMessage(tlc.d r13) {
        ALogger.i("NewHotMsgViewManager", "receive new message");
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        if (r13 != null) goto L5;
        return;
    L5:
        r1.element = r13;
        tlc.d r14 = r13;
        if ((r14 instanceof k6) == false) goto L63;
        k6 r15 = (k6) r14;
        boolean r3 = true;
        int r4 = 0;
        if (this.c == false) goto L19;
        PlayerProgressServiceContext r2 = this.b;
        if (r2 == null) goto L16;
        m r5 = r2.getAtLatest();
        if (r5 == null) goto L16;
        if (((Boolean) r5.getValue()).booleanValue() == true) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
    L35:
        if (r3 == true) goto L72;
        List r16 = ((tlc.d) r1.element).E();
        if (r16 != null) goto L39;
        return;
    L39:
        List r7 = r16;
        Iterator r8 = r7.iterator();
    L41:
        if (r8.hasNext() == false) goto L43;
        i r9 = (i) r8.next();
        r9.a = Long.valueOf(((tlc.d) r1.element).getMessageId());
        r9.b = Long.valueOf(((tlc.d) r1.element).G());
        goto L41
    L43:
        Iterator r10 = ((ArrayList) this.f).iterator();
    L45:
        if (r10.hasNext() == false) goto L47;
        MainThreadPostUtils.d((Runnable) r10.next());
        goto L45
    L47:
        ((ArrayList) this.f).clear();
        if (((tlc.d) r1.element).G() != 0) goto L56;
        Iterator r17 = r7.iterator();
    L51:
        if (r17.hasNext() == false) goto L73;
        i r11 = (i) r17.next();
        ALogger.i("NewHotMsgViewManager", "requestShow，assemble");
        f52.b r18 = this.a;
        if (r18 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L55:
        NewHotMsgPSTopView r19 = new NewHotMsgPSTopView(r11, d());
        r19.n = ((tlc.d) r1.element).getHighlightAreaPriorityConfig();
        Unit r20 = Unit.INSTANCE;
        r18.a(r19);
        goto L51
    L73:
        return;
    L56:
        int r0 = r16.size();
        long r21 = 0;
    L57:
        if (r4 >= r0) goto L74;
        c r23 = new c(this, r16, r4, r1);
        ((ArrayList) this.f).add(r23);
        MainThreadPostUtils.c(r23, r21);
        Long r24 = ((i) ListProtector.get(r16, r4)).f();
        if (r24 == null) goto L61;
        long r25 = r24.longValue() + ((tlc.d) r1.element).G();
    L62:
        r21 = r21 + (r25 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        r4 = r4 + 1;
        goto L57
    L61:
        r25 = 0;
        goto L62
    L74:
        return;
    L72:
        return;
    L16:
        r6 = false;
    L19:
        if (((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.b.a.getValue()).booleanValue() == true) goto L21;
    L23:
        boolean r26 = false;
    L24:
        if (r26 == true) goto L35;
        List r110 = r15.E();
        if (r110 != null) goto L28;
    L31:
        boolean r111 = true;
    L32:
        if (r111 == true) goto L35;
        r3 = false;
        goto L35
    L28:
        if (r110.isEmpty() == true) goto L31;
        r111 = false;
        goto L32
    L21:
        if (this.g.a == true) goto L23;
        r26 = true;
        goto L24
    }
}
