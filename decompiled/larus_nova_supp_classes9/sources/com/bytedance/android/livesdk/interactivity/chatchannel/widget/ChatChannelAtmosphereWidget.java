package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelAtmosphereWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelAtmosphereWidget extends RoomRecyclableWidget implements vlc.l {
    public CompositeDisposable a;
    public com.bytedance.android.livesdk.interactivity.api.c b;
    public com.bytedance.android.livesdk.interactivity.chatchannel.manager.a<com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c> c;
    public boolean d;
    public final b e;
    public final a f;

    public static final class a implements IPlayerActionListener {
        public boolean a;
        public final /* synthetic */ ChatChannelAtmosphereWidget b;

        public final void onFileLoaded(int r1, int r2) {
        }

        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.-CC.$default$onFirstFrame(this);
        }

        public final /* synthetic */ void onReportPlayMetrics(Map r1) {
            IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
        }

        public final void updateTextEffectPosition(float r1, float r2, float r3, float r4) {
        }

        public final void onEnd() {
            this.b.wq("play onEnd");
            this.a = false;
        }

        public final void onStart() {
            this.b.wq("play onStart");
            if (this.a == true) goto L6;
            this.a = true;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_effect_show", null);
            return;
        }

        public final void onStop() {
            this.b.wq("play onStop");
        }

        public a(ChatChannelAtmosphereWidget r1) {
            this.b = r1;
        }
    }

    public static final class b implements com.bytedance.android.livesdk.interactivity.chatchannel.manager.a.b<com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c> {
        public final /* synthetic */ ChatChannelAtmosphereWidget a;

        public b(ChatChannelAtmosphereWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.manager.a.b
        public final void a(l62.a<com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c> r4) {
            Intrinsics.checkNotNullParameter(r4, "assetsDownloadModel");
            ChatChannelAtmosphereWidget r0 = this.a;
            if (r0.d == false) goto L5;
        L12:
            r0.xq("start play, blockMessage = true");
            return;
        L5:
            if (((Widget) r0).dataCenter == null) goto L12;
            if (ChatChannelUtils.k(r0.getDataContext(), ((Widget) r0).dataCenter) == false) goto L12;
            r0.wq("startPlay");
            com.bytedance.android.livesdk.interactivity.api.c r1 = r0.b;
            if (r1 == null) goto L14;
            r1.a(new com.bytedance.android.livesdk.interactivity.api.c.a(r4.b, 4));
            return;
        }
    }

    public final int getLayoutId() {
        return 2131565293;
    }

    public final void onUnload() {
        wq("onUnload");
        CompositeDisposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        xq("on unload");
        this.b = null;
    }

    public ChatChannelAtmosphereWidget() {
        this.e = new b(this);
        this.f = new a(this);
    }

    public final void onInit(Object[] r3) {
        IAssetsManager r4 = jc1.k.n(IGiftServiceExternal.class).getAssetsManager();
        if (r4 == null) goto L14;
        RoomContext r0 = getDataContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L11;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L11;
        boolean r5 = r2.booleanValue();
    L12:
        this.c = new com.bytedance.android.livesdk.interactivity.chatchannel.manager.a(r5, r4);
        return;
    L11:
        r5 = false;
        goto L12
    }

    public final void onLoad(Object[] r2) {
        wq("onLoad");
        this.a = new CompositeDisposable();
        RoomContext r3 = getRoomContext();
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

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void onMessage(tlc.d r10) {
        if (this.d == false) goto L5;
        return;
    L5:
        if ((r10 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c) == true) goto L7;
        return;
    L7:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o.a((BaseMessage) r10) == ChatChannelUtils.d(getDataContext())) goto L9;
        return;
    L9:
        l62.a r0 = new l62.a();
        r0.a = ((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c) r10).getAssetId();
        r0.c = System.currentTimeMillis();
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.a<com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c> r11 = this.c;
        if (r11 == null) goto L18;
        b r1 = this.e;
        Intrinsics.checkNotNullParameter(r0, "assetsDownloadModel");
        Intrinsics.checkNotNullParameter(r1, "successListener");
        r11.a.add((l62.a<T>) r0);
        r11.b.a = r1;
        if (r11.d.G1(r0.a) != null) goto L14;
        r11.d.T(new com.bytedance.android.livesdk.interactivity.chatchannel.manager.b(r11, r0));
        r11.d.d4(4, r11.c, r0.a, "fetchAssetById");
        return;
    L14:
        r11.d.j4(r0.a, r11.b, 4);
        return;
    }

    public final void wq(String r2) {
        ALogger.i("ChatChannelAtmosphereWidget", r2);
    }

    public final void xq(String r2) {
        wq(r2);
        com.bytedance.android.livesdk.interactivity.api.c r3 = this.b;
        if (r3 == null) goto L5;
        r3.release();
    L5:
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.a<com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c> r4 = this.c;
        if (r4 == null) goto L9;
        r4.a.clear();
        r4.b.a = null;
        return;
    }
}
