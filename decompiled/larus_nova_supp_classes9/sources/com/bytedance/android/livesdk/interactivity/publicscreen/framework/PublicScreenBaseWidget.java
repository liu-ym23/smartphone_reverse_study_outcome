package com.bytedance.android.livesdk.interactivity.publicscreen.framework;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.DummyMessageRepoManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.NormalMessageRepoManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.NormalMessageRepoManagerV2;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/framework/PublicScreenBaseWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PublicScreenBaseWidget extends MiddlewareRoomRecyclableWidget {
    public PublicScreenContext a;
    public q92.a b;
    public q92.a c;
    public IPSMessageRepoManager d;
    public BaseMessageRepoManager e;

    public void onUnload() {
        boolean r0 = TextMessageTracer.a;
        TextMessageTracer.A("base widget onUnload");
        this.a = null;
        this.b = null;
        this.d = null;
    }

    public final TransTextMessagePresenter wq() {
        PublicScreenContext r1 = this.a;
        IPSMessageRepoManager r0 = this.d;
        IPSMessageRepoManager r2 = r0;
        if (r0 != null) goto L15;
        boolean r3 = TextMessageTracer.a;
        TextMessageTracer.A("use default RepoManager");
        BaseMessageRepoManager r4 = this.e;
        r2 = r4;
        if (r4 != null) goto L15;
        if (((Widget) this).dataCenter != null) goto L10;
        BaseMessageRepoManager r5 = new DummyMessageRepoManager();
    L14:
        this.e = r5;
        r2 = r5;
        goto L15
    L10:
        if (PublicScreenABHelper.P == false) goto L12;
        r5 = new NormalMessageRepoManagerV2(((Widget) this).dataCenter, xq());
        goto L14
    L12:
        r5 = new NormalMessageRepoManager(((Widget) this).dataCenter, xq());
    L15:
        IPSMessageRepoManager r6 = r2;
        c r7 = xq().v;
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a r8 = xq().w;
        q92.a r9 = xq();
        int r10 = aa2.c.a;
        Intrinsics.checkNotNullParameter(r6, "repoManager");
        Intrinsics.checkNotNullParameter(r7, "updater");
        Intrinsics.checkNotNullParameter(r8, "waitBuffer");
        Intrinsics.checkNotNullParameter(r9, "config");
        if (r1 == null) goto L19;
        return new PublicScreenExtendsPresenter(r1, r6, r7, r8, r9);
    L19:
        return new TransTextMessagePresenter(r6, r7, r8, r9);
    }

    public final q92.a xq() {
        q92.a r0 = this.b;
        if (r0 != null) goto L12;
        boolean r1 = TextMessageTracer.a;
        TextMessageTracer.A("use default TextMessageConfig");
        r0 = this.c;
        if (r0 != null) goto L12;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        r0 = q92.b.b(((Boolean) r2.get("data_is_anchor", Boolean.FALSE)).booleanValue(), (IRoom) ((Widget) this).dataCenter.get("data_room"));
    L11:
        this.c = r0;
        goto L12
    L10:
        r0 = q92.b.b(false, null);
    L12:
        return r0;
    }

    public PublicScreenBaseWidget() {
    }

    public void onLoad(Object[] r7) {
        final DataCenter r8 = ((Widget) this).dataCenter;
        DataContext r0 = getRoomContext();
        IPSMessageRepoManager r1 = null;
        if (r0 == null) goto L9;
        IRoomContextService r2 = k.f(IRoomContextService.class);
        if (r2 == null) goto L7;
        o r3 = r2.getRoomDataContext(r0);
    L8:
        if (r3 == null) goto L9;
    L13:
        if (r3 == null) goto L17;
        j r4 = r3.M1();
        if (r4 == null) goto L17;
        ViewModel r5 = (ViewModel) r4.getValue();
    L19:
        if ((r5 instanceof h) == true) goto L21;
        r5 = null;
    L21:
        final h r6 = (h) r5;
        boolean r9 = TextMessageTracer.a;
        TextMessageTracer.A("PublicScreenContext init, dataCenter is " + r8 + ", roomContext is " + r0 + ", dataService is " + r3 + ", interactivityContext is " + r6);
        StringBuilder r10 = new StringBuilder("PublicScreenContext init, roomContext cleared state is ");
        if (r0 == null) goto L24;
        Boolean r11 = Boolean.valueOf(r0.isCleared());
    L25:
        r10.append(r11);
        r10.append(", interactivityContext alive state is ");
        if (r6 == null) goto L28;
        Boolean r13 = Boolean.valueOf(r6.isAlive());
    L29:
        r10.append(r13);
        TextMessageTracer.A(r10.toString());
        if (r8 == null) goto L42;
        if (r6 == null) goto L42;
        Object r14 = r6.getPublicScreenContext().getValue();
        if ((r14 instanceof PublicScreenContext) == true) goto L36;
        r14 = null;
    L36:
        PublicScreenContext r15 = (PublicScreenContext) r14;
        if (r15 != null) goto L51;
        r6.getPublicScreenContext().e(new PublicScreenBaseWidget$getOrInitPublicScreenContext$$inlined$let$lambda$1(this, r6, r8));
        Object r16 = r6.getPublicScreenContext().getValue();
        if ((r16 instanceof PublicScreenContext) == true) goto L41;
        r16 = null;
    L41:
        r15 = (PublicScreenContext) r16;
    L51:
        this.a = r15;
        if (r15 != null) goto L57;
        SafetyGuard.a(null, null, "PublicScreenContext is Null");
        if (v.a() == false) goto L56;
        f2.c("PublicScreenContext is null", 0);
    L56:
        s0 r17 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.h(CardLockInfo.sUNKNOWN);
    L57:
        PublicScreenContext r18 = this.a;
        if (r18 == null) goto L62;
        j<q92.a> r19 = r18.getConfig();
        if (r19 == null) goto L62;
        q92.a r20 = (q92.a) r19.getValue();
    L63:
        this.b = r20;
        PublicScreenContext r21 = this.a;
        if (r21 == null) goto L68;
        j<IPSMessageRepoManager> r23 = r21.getMessageRepoManager();
        if (r23 == null) goto L68;
        r1 = (IPSMessageRepoManager) r23.getValue();
    L68:
        this.d = r1;
        return;
    L62:
        r20 = null;
    L42:
        s0 r24 = PublicScreenTraceMonitor.a;
        StringBuilder r25 = new StringBuilder("DataCenterEmpty:");
        boolean r26 = true;
        if (r8 != null) goto L45;
        boolean r27 = true;
    L46:
        r25.append(r27);
        r25.append(",InteractivityContextEmpty:");
        if (r6 == null) goto L50;
        r26 = false;
    L50:
        r25.append(r26);
        PublicScreenTraceMonitor.h(r25.toString());
        r15 = null;
        goto L51
    L45:
        r27 = false;
        goto L46
    L28:
        r13 = null;
        goto L29
    L24:
        r11 = null;
    L17:
        r5 = null;
        goto L19
    L7:
        r3 = null;
    L9:
        IRoomContextService r28 = k.f(IRoomContextService.class);
        if (r28 == null) goto L12;
        r3 = IRoomContextService.a.a(r28, r8, 0, 2);
        goto L13
    L12:
        r3 = null;
        goto L13
    }
}
