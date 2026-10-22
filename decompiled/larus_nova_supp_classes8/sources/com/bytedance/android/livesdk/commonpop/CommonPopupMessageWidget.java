package com.bytedance.android.livesdk.commonpop;

import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.livesdkapi.LiveSdkApiForSaaS;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.LinkedList;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/commonpop/CommonPopupMessageWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/commonpop/ICommonPopupMessageView;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "<init>", "()V", "a", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonPopupMessageWidget extends LiveRecyclableWidget implements ICommonPopupMessageView, WeakHandler.IHandler {
    public static final /* synthetic */ int g = 0;
    public h a;
    public HybridCard b;
    public final LinkedList<b> c;
    public boolean d;
    public final WeakHandler e;
    public final long f;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L12;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = ((r1 * 31) + this.b) * 31;
            boolean r3 = this.c;
            ?? r4 = r3;
            if (r3 == false) goto L10;
            r4 = 1;
        L10:
            return r2 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "ShowItem(url=" + this.a + ", duration=" + this.b + ", lynxEnabled=" + this.c + ")";
        }

        public b(String r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CommonPopupMessageWidget a;

        public c(CommonPopupMessageWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.livesdk.commonpop.b r6 = (com.bytedance.android.livesdk.commonpop.b) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            CommonPopupMessageWidget r0 = this.a;
            int r1 = CommonPopupMessageWidget.g;
            r0.getClass();
            String r2 = UriProtector.getQueryParameter(r6.a, "url");
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.length() <= 0) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == false) goto L10;
            String r4 = r2;
        L11:
            if (r4 == null) goto L18;
            String r7 = UriProtector.getQueryParameter(r6.a, "duration");
            if (r7 != null) goto L15;
            r7 = "10";
        L15:
            b r8 = new b(r2, CastIntegerProtector.parseInt(r7), r6.b);
            r0.c.push(r8);
            r0.xq();
            return;
        L18:
            return;
        L10:
            r4 = null;
            goto L11
        L7:
            r3 = false;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CommonPopupMessageWidget a;

        public d(CommonPopupMessageWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ToolbarClearScreenEvent r4 = (ToolbarClearScreenEvent) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            CommonPopupMessageWidget r0 = this.a;
            int r1 = CommonPopupMessageWidget.g;
            r0.getClass();
            r0.yq(r4.b);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ CommonPopupMessageWidget a;

        public e(CommonPopupMessageWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            s r4 = (s) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            CommonPopupMessageWidget r0 = this.a;
            int r1 = CommonPopupMessageWidget.g;
            r0.getClass();
            r0.yq(r4.a);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ CommonPopupMessageWidget a;

        public f(CommonPopupMessageWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.commonpop.a) r2, "event");
            CommonPopupMessageWidget r3 = this.a;
            int r0 = CommonPopupMessageWidget.g;
            r3.wq();
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ CommonPopupMessageWidget a;

        public g(CommonPopupMessageWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            i r3 = (i) r7;
            Intrinsics.checkNotNullParameter(r3, "event");
            final CommonPopupMessageWidget r1 = this.a;
            int r8 = CommonPopupMessageWidget.g;
            r1.getClass();
            LiveSdkApiForSaaS.Companion.getClass();
            LiveSdkApiForSaaS.a.a().commonPopupMessageWidgetOnInRoomPushEvent(r1, r1.e, r3, 1, new CommonPopupMessageWidget$onEvent$1(r1));
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565329;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    public final void wq() {
        this.d = false;
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        HybridCard r2 = this.b;
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L28;
        ((ViewGroup) r3).removeAllViews();
        HybridCard r4 = this.b;
        if (r4 == null) goto L13;
        r4.release();
    L13:
        this.b = null;
        if (this.c.isEmpty() == true) goto L16;
    L25:
        xq();
        return;
    L16:
        if (k.f(IGiftServiceExternal.class) == null) goto L18;
        k.n(IGiftServiceExternal.class).toggleVideoGiftView(true);
    L18:
        RoomContext r5 = com.bytedance.live.datacontext.d.e(Integer.valueOf(((Widget) this).dataCenter.hashCode()), RoomContext.class);
        if (r5 == null) goto L25;
        m r6 = r5.getCommonPopupModel();
        if (r6 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.b r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.b) r6.getValue();
        if (r7 == null) goto L25;
        r7.a = false;
        goto L25
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onUnload() {
        h r0 = this.a;
        Intrinsics.checkNotNull(r0);
        r0.detachView();
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L10;
        ((ViewGroup) r1).removeAllViews();
        HybridCard r2 = this.b;
        if (r2 == null) goto L7;
        r2.release();
    L7:
        this.b = null;
        this.c.clear();
        this.d = false;
        this.e.removeCallbacksAndMessages(null);
        ((Widget) this).contentView.setVisibility(0);
        ((Widget) this).contentView.setTranslationX(0.0f);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void xq() {
        if ((!this.c.isEmpty()) == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L38;
        b r0 = this.c.poll();
        this.d = true;
        boolean r2 = r0.c;
        String r3 = r0.a;
        if (r2 == true) goto L9;
        Uri r4 = x6.a.b(r3);
    L10:
        HybridCard r5 = k.n(IBrowserService.class).getHybridCard(((Widget) this).context, r4, new com.bytedance.android.livesdk.commonpop.d(this));
        if (r5 == null) goto L22;
        r5.registerMethod("close", new com.bytedance.android.livesdk.commonpop.c(this));
        this.b = r5;
        if (r5.hybridType() != IHybridComponent.HybridType.H5) goto L16;
        r5.setBackgroundColor(0);
        r5.setVisibility(4);
    L16:
        if (r5.getParent() != null) goto L22;
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View r6 = ((Widget) this).contentView;
        if (r6 == null) goto L21;
        ((ViewGroup) r6).addView(r5, 0);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L22:
        ((Widget) this).contentView.setVisibility(4);
        HybridCard r7 = this.b;
        if (r7 == null) goto L25;
        r7.setVisibility(4);
    L25:
        String r8 = r0.a;
        HybridCard r9 = this.b;
        if (r9 == null) goto L28;
        View r10 = r9.getHybridView();
    L30:
        if ((r10 instanceof WebView) == false) goto L32;
        r8 = k.n(IBrowserService.class).appendCommonParams(r8);
    L32:
        HybridCard r11 = this.b;
        if (r11 == null) goto L35;
        a7.a.a(r11, r8, null, 2);
    L35:
        Message r1 = this.e.obtainMessage(1);
        this.e.removeCallbacksAndMessages(null);
        this.e.sendMessageDelayed(r1, r0.b * BubbleId.PadCast);
        return;
    L28:
        r10 = null;
        goto L30
    L9:
        r4 = x6.a.d(r3);
        goto L10
    }

    public CommonPopupMessageWidget() {
        this.c = new LinkedList();
        this.e = new WeakHandler(this);
        this.f = 200;
    }

    @Override // com.bytedance.android.livesdk.commonpop.ICommonPopupMessageView
    public final void J2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scheme");
        k.n(IRoomService.class).actionHandler().handle(getContext(), r3);
    }

    public final void handleMsg(Message r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.what != 1) goto L8;
        wq();
        return;
    }

    public final void onInit(Object[] r1) {
        this.a = new h();
    }

    public final void onLoad(Object[] r2) {
        h r3 = this.a;
        Intrinsics.checkNotNull(r3);
        r3.g0(this);
        L7(com.bytedance.android.livesdk.commonpop.b.class, new c(this));
        L7(ToolbarClearScreenEvent.class, new d(this));
        L7(s.class, new e(this));
        L7(com.bytedance.android.livesdk.commonpop.a.class, new f(this));
        L7(i.class, new g(this));
        ((Widget) this).contentView.setVisibility(4);
    }

    public final void yq(boolean r4) {
        float r1 = 0.0f;
        if (ClearScreenHelper.c() == false) goto L9;
        ViewPropertyAnimator r0 = ((Widget) this).contentView.animate();
        if (r4 == true) goto L8;
        r1 = 1.0f;
    L8:
        r0.alpha(r1).setDuration(this.f).setInterpolator(new com.bytedance.android.live.core.widget.g()).start();
        return;
    L9:
        if (r4 == false) goto L11;
        r1 = ((Widget) this).contentView.getWidth();
    L11:
        ((Widget) this).contentView.animate().x(r1).setDuration(this.f).setInterpolator(new com.bytedance.android.live.core.widget.g()).start();
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }
}
