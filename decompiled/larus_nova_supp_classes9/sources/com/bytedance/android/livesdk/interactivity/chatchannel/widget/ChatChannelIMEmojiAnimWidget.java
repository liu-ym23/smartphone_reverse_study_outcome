package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.os.Handler;
import android.view.ViewGroup;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelIMEmojiAnimWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelIMEmojiAnimWidget extends RoomRecyclableWidget {
    public static final /* synthetic */ int h = 0;
    public ViewGroup a;
    public com.bytedance.android.livesdk.interactivity.api.c b;
    public final CompositeDisposable c;
    public Disposable d;
    public long e;
    public final Lazy f;
    public final b g;

    public static final class a {
    }

    public static final class b implements IPlayerActionListener {
        public final /* synthetic */ ChatChannelIMEmojiAnimWidget a;

        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.-CC.$default$onFirstFrame(this);
        }

        public final /* synthetic */ void onReportPlayMetrics(Map r1) {
            IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
        }

        public final void onEnd() {
            ChatChannelIMEmojiAnimWidget r0 = this.a;
            int r1 = ChatChannelIMEmojiAnimWidget.h;
            r0.xq("player end");
        }

        public final void onStart() {
            ChatChannelIMEmojiAnimWidget r0 = this.a;
            int r1 = ChatChannelIMEmojiAnimWidget.h;
            r0.xq("player start");
        }

        public final void onStop() {
            ChatChannelIMEmojiAnimWidget r0 = this.a;
            int r1 = ChatChannelIMEmojiAnimWidget.h;
            r0.xq("player stop");
        }

        public b(ChatChannelIMEmojiAnimWidget r1) {
            this.a = r1;
        }

        public final void onFileLoaded(int r4, int r5) {
            ChatChannelIMEmojiAnimWidget r0 = this.a;
            String r6 = "onFileLoaded with=" + r4 + " height=" + r5;
            int r7 = ChatChannelIMEmojiAnimWidget.h;
            r0.xq(r6);
        }

        public final void updateTextEffectPosition(float r4, float r5, float r6, float r7) {
            ChatChannelIMEmojiAnimWidget r0 = this.a;
            String r8 = "updateTextEffectPosition. w=" + r4 + " h=" + r5 + " x=" + r6 + " y=" + r7;
            int r9 = ChatChannelIMEmojiAnimWidget.h;
            r0.xq(r8);
            float r10 = 0;
            if (r4 > r10) goto L5;
            return;
        L5:
            if (r5 <= r10) goto L23;
            ViewGroup r11 = this.a.a;
            if (r11 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
        L10:
            if (PadConfigUtils.c() == false) goto L17;
            if (e5.n() == false) goto L14;
            float r13 = UtilityKotlinExtentionsKt.h(155);
            float r14 = 0.3f;
        L15:
            float r15 = r13 * r14;
        L20:
            r11.setTranslationY(r15);
            return;
        L14:
            r13 = UtilityKotlinExtentionsKt.h(155);
            r14 = 0.5f;
            goto L15
        L17:
            if (this.a.isScreenPortrait() == false) goto L19;
            r15 = UtilityKotlinExtentionsKt.h(155) + (s1.w() - r5);
            goto L20
        L19:
            r15 = 0.0f;
            goto L20
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565295;
    }

    public final void onUnload() {
        yq("onUnload");
        this.b = null;
        this.c.clear();
        ((Handler) this.f.getValue()).removeCallbacksAndMessages(null);
    }

    public ChatChannelIMEmojiAnimWidget() {
        this.c = new CompositeDisposable();
        this.e = -1;
        this.f = LazyKt.lazy(ChatChannelIMEmojiAnimWidget$mainHandler$2.INSTANCE);
        this.g = new b(this);
    }

    public final void onInit(Object[] r2) {
        this.a = (ViewGroup) ((Widget) this).contentView.findViewById(2131365483);
    }

    public final void onLoad(Object[] r2) {
        xq("onLoad");
        RoomContext r3 = getDataContext();
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.f r4 = com.bytedance.android.livesdk.interactivity.api.g.a(r3);
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.j<s22.e> r5 = r4.getChatChannelManager();
        if (r5 == null) goto L12;
        r5.c(new AnonymousClass1(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void xq(String r2) {
        ALogger.i("ChatChannelIMEmojiAnimWidget", r2);
    }

    public final void yq(String r3) {
        xq("release. reason=" + r3);
        this.e = -1;
        com.bytedance.android.livesdk.interactivity.api.c r4 = this.b;
        if (r4 == null) goto L5;
        r4.release();
    L5:
        Disposable r5 = this.d;
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        this.d = null;
    }

    public static final void wq(ChatChannelIMEmojiAnimWidget r3, long r4) {
        r3.getClass();
        r3.xq("onChannelPageVisible. curChannelId=" + r3.e + " channelId=" + r4);
        if (r3.e != r4) goto L6;
        return;
    L6:
        if (r4 > 0) goto L8;
        r3.yq("invalid channelId " + r4);
        return;
    L8:
        r3.e = r4;
        Disposable r0 = r3.d;
        if (r0 == null) goto L11;
        r0.dispose();
    L11:
        s22.e r1 = ChatChannelUtils.b(r3.getDataContext());
        if (r1 == null) goto L20;
        s22.a r5 = r1.getChannel(r4);
        if (r5 == null) goto L20;
        com.bytedance.android.livesdk.interactivity.service.messagelist.g r6 = r5.A();
        if (r6 == null) goto L20;
        PropertyOwner<IMessageListManager.a> r7 = r6.c;
        r7.getClass();
        Observable r8 = r7.subscribeOn(AndroidSchedulers.mainThread());
        if (r8 == null) goto L20;
        Disposable r9 = r8.subscribe(new h(r3));
    L21:
        r3.d = r9;
        return;
    L20:
        r9 = null;
        goto L21
    }
}
