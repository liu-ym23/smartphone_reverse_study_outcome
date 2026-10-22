package com.bytedance.android.livesdk.interactivity.barrage.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.d0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.settings.config.g0;
import com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import f52.h;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r52.j2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/widget/CarnivalManagerServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/log/filter/v;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarnivalManagerServiceWidget extends MiddlewareRoomRecyclableWidget implements v {
    public o22.d a;
    public Disposable b;
    public final Boolean c;
    public Disposable d;
    public final a e;
    public boolean f;

    public static final class a implements h32.d<f32.a> {
        public final /* synthetic */ CarnivalManagerServiceWidget a;

        public a(CarnivalManagerServiceWidget r1) {
            this.a = r1;
        }

        @Override // h32.d
        public final void a(f32.f r2) {
            f32.a r3 = (f32.a) r2;
            Intrinsics.checkNotNullParameter(r3, "newConfig");
            this.a.getClass();
            if (r3.a == false) goto L7;
            ALogger.i("DanmakuCarnivalManager", "degrade cancel to init");
            o22.d r4 = this.a.a;
            if (r4 == null) goto L11;
            r4.init();
            return;
        L11:
            return;
        L7:
            ALogger.i("DanmakuCarnivalManager", "degrade to reset");
            o22.d r5 = this.a.a;
            if (r5 == null) goto L13;
            r5.reset();
            return;
        }
    }

    public final void Rd() {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onRemove() {
    }

    public final void onUnload() {
        o22.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        this.a = null;
        Disposable r1 = this.b;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.b = null;
        Disposable r2 = this.d;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.d = null;
        if (this.f == false) goto L15;
        j0.l().removeSendLogFilter(CarnivalManagerServiceWidget.class);
        this.f = false;
        return;
    }

    public CarnivalManagerServiceWidget() {
        this.c = (Boolean) com.bytedance.android.livesdk.interactivity.service.settings.b.a.getValue();
        this.e = new a(this);
    }

    public final void onLoad(Object[] r5) {
        BarrageWidgetContext r6 = b.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter);
        if (r6 != null) goto L6;
        ALogger.i("DanmakuCarnivalManager", "barrageContext is null, init failed");
        return;
    L6:
        final o22.d r0 = (o22.d) r6.getDanmakuCarnivalManager().getValue();
        if (r0 != null) goto L9;
        r0 = new DanmakuCarnivalManager(((Widget) this).dataCenter);
        r6.getDanmakuCarnivalManager().d(r0);
    L9:
        this.a = r0;
        Disposable r1 = null;
        if (isScreenPortrait() == false) goto L32;
        g0.a.getClass();
        if (((g0) j2.a.getValue()).a() == false) goto L32;
        int r7 = h.a;
        DataContext r8 = getRoomContext();
        DataCenter r2 = ((Widget) this).dataCenter;
        Function1<f52.b, Unit> r3 = new AnonymousClass1(r0);
        Intrinsics.checkNotNullParameter(r3, "action");
        com.bytedance.android.livesdk.interactivity.api.h r4 = i.a(r8, r2);
        if (r4 == null) goto L18;
        n<f52.b> r9 = r4.getPsTopContainer();
        if (r9 == null) goto L18;
        f52.b r10 = (f52.b) r9.getValue();
    L19:
        if (r10 == null) goto L21;
        r3.invoke(r10);
    L30:
        Disposable r11 = null;
    L31:
        this.b = r11;
    L34:
        if (this.c.booleanValue() == true) goto L36;
    L50:
        boolean r13 = ((Boolean) r52.g0.a.getValue()).booleanValue();
        this.f = r13;
        if (r13 == false) goto L54;
        j0.l().addSendLogFilter(CarnivalManagerServiceWidget.class, this);
        return;
    L54:
        return;
    L36:
        if (isScreenPortrait() == false) goto L50;
        Disposable r14 = this.d;
        if (r14 == null) goto L40;
        r14.dispose();
    L40:
        com.bytedance.android.livesdk.interactivity.api.h r15 = i.a(((MiddlewareRoomRecyclableWidget) this).dataContext, ((Widget) this).dataCenter);
        if (r15 == null) goto L49;
        j<h32.a> r16 = r15.getDegradeManager();
        if (r16 == null) goto L49;
        h32.a r17 = (h32.a) r16.getValue();
        if (r17 == null) goto L49;
        h32.c<f32.a> r18 = r17.i();
        if (r18 == null) goto L49;
        r1 = g32.b.a(r18, this.e);
    L49:
        this.d = r1;
        goto L50
    L21:
        com.bytedance.android.livesdk.interactivity.api.h r19 = i.a(r8, r2);
        if (r19 == null) goto L30;
        n<f52.b> r20 = r19.getPsTopContainer();
        if (r20 == null) goto L30;
        Observable r21 = d0.c(r20);
        if (r21 == null) goto L30;
        Observable r23 = r21.observeOn(AndroidSchedulers.mainThread());
        if (r23 == null) goto L30;
        r11 = r23.subscribe(new f52.g(r3));
    L18:
        r10 = null;
    L32:
        r0.init();
        goto L34
    }

    public final void L9(String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        o22.d r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r4.hashCode();
        if (r1 == (-1235807369)) goto L14;
        if (r1 == 21313630) goto L11;
        return;
    L11:
        if (r4.equals("livesdk_audience_live_message") == true) goto L16;
        return;
    L16:
        if (r0.i() == false) goto L19;
        r5.put("comment_activity", "comment_carnival");
        return;
    L19:
        if (r0.a() == false) goto L25;
        r5.put("comment_activity", "general_carnival");
        return;
    L25:
        return;
    L14:
        if (r4.equals("livesdk_performance_monitor_base_new") == true) goto L16;
    }
}
