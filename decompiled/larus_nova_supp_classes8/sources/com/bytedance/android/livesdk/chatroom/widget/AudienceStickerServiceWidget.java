package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.effect.beauty.sticker.LiveStickerBeautyFragment;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.pm;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/AudienceStickerServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceStickerServiceWidget extends LiveRecyclableWidget implements vlc.l {
    public static final /* synthetic */ int b = 0;
    public final CompositeDisposable a;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AudienceStickerServiceWidget a;

        public b(AudienceStickerServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r14) {
            zg1.o r5 = (zg1.o) r14;
            AudienceStickerServiceWidget r15 = this.a;
            int r0 = AudienceStickerServiceWidget.b;
            r15.getClass();
            IInteractService r16 = jc1.k.f(IInteractService.class);
            if (r16 != null) goto L5;
        L23:
            boolean r17 = false;
        L24:
            if (r17 == false) goto L42;
            Ref.ObjectRef r4 = new Ref.ObjectRef();
            String r18 = r5.a;
            if (Intrinsics.areEqual(r18, com.bytedance.android.live.effect.api.d0.e) == false) goto L28;
        L31:
            String r19 = com.bytedance.android.live.effect.api.d0.c;
        L32:
            r4.element = r19;
            Effect r110 = r5.b;
            boolean r3 = r5.c;
            AudienceStickerServiceWidget$onLoad$1$1 r7 = new AudienceStickerServiceWidget$onLoad$1$1(r4, r5);
            List r2 = LiveEffectContext.h;
            List r6 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.LINK).a().o((String) r4.element);
            Ref.BooleanRef r8 = new Ref.BooleanRef();
            r8.element = false;
            Iterator r1 = r6.iterator();
        L34:
            if (r1.hasNext() == false) goto L41;
            long r9 = ((Sticker) r1.next()).getId();
            Long r10 = StringsKt.toLongOrNull(r110.getEffect_id());
            if (r10 == null) goto L34;
            if (r9 != r10.longValue()) goto L34;
            r8.element = true;
        L41:
            RxUtilKt.c(com.bytedance.android.live.effect.sticker.d.c(r110).subscribe(new g(this, r8, r3, r4, r5, r6, r7)), this.a.a);
            return;
        L28:
            if (Intrinsics.areEqual(r18, com.bytedance.android.live.effect.api.d0.f) == true) goto L31;
            r19 = r5.a;
            goto L32
        L42:
            com.bytedance.android.live.core.utils.f2.b(2131918774, 0);
            zg1.q r111 = r5.d;
            if (r111 == null) goto L53;
            zg1.q.a.a(r111, false);
            return;
        L53:
            return;
        L5:
            if (r16.isAudienceVideoLinkEngineOn() != true) goto L23;
            IMiddlewareUserService r112 = jc1.k.f(IMiddlewareUserService.class);
            if (r112 == null) goto L12;
            com.bytedance.android.livesdk.user.e r113 = r112.user();
            if (r113 == null) goto L12;
            String r114 = r113.n();
            if (r114 == null) goto L12;
        L13:
            IInteractService r11 = jc1.k.f(IInteractService.class);
            if (r11 == null) goto L18;
            com.bytedance.android.live.liveinteract.plantform.base.i r12 = r11.getLinkUserInfoCenter();
            if (r12 == null) goto L18;
            ILinkPlayerInfoBridge r115 = (ILinkPlayerInfoBridge) r12.getGuestInfo(r114, "");
        L19:
            if (r115 == null) goto L23;
            if (r115.getLinkType() != 1) goto L23;
            r17 = true;
        L18:
            r115 = null;
        L12:
            r114 = "";
            goto L13
        }
    }

    public static final class c implements com.bytedance.android.live.effect.api.k.e {
        public c() {
        }

        public final void onFetchFailed() {
        }

        public final void onFetchSuccess(List<Effect> r2) {
            Intrinsics.checkNotNullParameter(r2, "effectList");
            xs2.b.a().post(new LiveStickerBeautyFragment.b());
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeMessageListener(MessageType.ANCHOR_UPDATE_CAMPAIGN_STICKER_MESSAGE.getIntType(), this);
    L9:
        this.a.clear();
    }

    public AudienceStickerServiceWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onLoad(Object[] r5) {
        RxUtilKt.c(xs2.b.a().b(zg1.o.class).subscribe(new b(this)), this.a);
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L10;
        com.bytedance.live.datacontext.j r7 = r6.getMessageManager();
        if (r7 == null) goto L11;
        vlc.d r8 = (vlc.d) r7.getValue();
        if (r8 == null) goto L12;
        r8.addMessageListener(MessageType.ANCHOR_UPDATE_CAMPAIGN_STICKER_MESSAGE.getIntType(), this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof pm) == false) goto L6;
        List r5 = LiveEffectContext.h;
        com.bytedance.android.live.effect.sticker.presenter.o.a.b(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.LINK).b().d(), com.bytedance.android.live.effect.api.d0.f, "guestactivity", new c());
        return;
    }
}
