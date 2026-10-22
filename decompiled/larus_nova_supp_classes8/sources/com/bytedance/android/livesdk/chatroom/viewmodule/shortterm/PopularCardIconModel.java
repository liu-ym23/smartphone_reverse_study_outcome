package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.TiltedIconTemplate;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.tg1;
import com.bytedance.android.livesdk.config.xi0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.android.livesdkapi.sti.framework.IIconService;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PopularCardIconModel extends com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a<b> {

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.PopularCardIconModel$b$b, reason: collision with other inner class name */
        public static final class C0054b extends b {
            public final long a;
            public final boolean b;

            public C0054b(long r1, boolean r3) {
                this.a = r1;
                this.b = r3;
            }
        }

        public b() {
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ vlc.d a;
        public final /* synthetic */ Function1 b;

        public c(vlc.d r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            vlc.d r0 = this.a;
            if (r0 == null) goto L9;
            Function1 r1 = this.b;
            if (r1 == null) goto L7;
            r1 = new d(r1);
        L7:
            r0.removeMessageListener((vlc.l) r1);
            return;
        }
    }

    public final class d implements vlc.l {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onMessage(tlc.d r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final IIconModel.EntryView getBigCardEntryViewForState() {
        return null;
    }

    public PopularCardIconModel() {
        super(b.a.a, ShortTermIndicatorConfig.ElementType.PopularCard.getTypeId());
    }

    public final void onClick() {
        xi0 r0 = xi0.a;
        if (r0.getValue().length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        UrlBuilder r2 = new UrlBuilder(r0.getValue());
        com.bytedance.android.livesdk.chatroom.o r5 = z51.a.h(null, 3);
        String r6 = "";
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.m r7 = r5.getRoom();
        if (r7 == null) goto L16;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L16;
        String r9 = r8.getOwnerUserIdString();
        if (r9 == null) goto L16;
    L17:
        r2.addParam("anchor_id", r9);
        com.bytedance.android.livesdk.chatroom.o r10 = z51.a.h(null, 3);
        if (r10 == null) goto L25;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L25;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L25;
        String r13 = r12.getIdStr();
        if (r13 == null) goto L25;
    L26:
        r2.addParam("room_id", r13);
        r2.addParam("user_id", TTLiveSDKContext.getHostService().h().a.getIdString());
        String r14 = r2.build();
        if (tb1.c.a == false) goto L29;
        i2 r3 = new i2(r14, "", 17, 280, 253, 2);
    L30:
        r3.h = false;
        xs2.b.a().post(r3);
        Pair[] r4 = new Pair[2];
        com.bytedance.android.livesdk.chatroom.o r15 = z51.a.h(null, 3);
        if (r15 == null) goto L38;
        com.bytedance.live.datacontext.m r16 = r15.getRoom();
        if (r16 == null) goto L38;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L38;
        String r18 = r17.getIdStr();
        if (r18 == null) goto L38;
    L39:
        r4[0] = TuplesKt.to("room_id", r18);
        com.bytedance.android.livesdk.chatroom.o r19 = z51.a.h(null, 3);
        if (r19 == null) goto L49;
        com.bytedance.live.datacontext.m r20 = r19.getRoom();
        if (r20 == null) goto L49;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L49;
        String r22 = r21.getOwnerUserIdString();
        if (r22 == null) goto L49;
        r6 = r22;
    L49:
        r4[1] = TuplesKt.to("anchor_id", r6);
        Map r23 = MapsKt.mapOf(r4);
        u.l().sendLog("popular_card_icon_click", r23, new Object[0]);
        return;
    L38:
        r18 = "";
        goto L39
    L29:
        r3 = new i2(r14, "", 17, 280, 233, 2);
    L25:
        r13 = "";
    L16:
        r9 = "";
        goto L17
    L5:
        r1 = false;
        goto L6
    }

    public final void onCreate() {
        Function1<tlc.d, Unit> r1 = new PopularCardIconModel$onCreate$listener$1(this);
        com.bytedance.android.livesdk.chatroom.o r4 = z51.a.h(null, 3);
        if (r4 == null) goto L7;
        com.bytedance.live.datacontext.j r5 = r4.getMessageManager();
        if (r5 == null) goto L7;
        vlc.d r6 = (vlc.d) r5.getValue();
    L8:
        if (r6 == null) goto L10;
        r6.addMessageListener(MessageType.POPULAR_CARD_MESSAGE.getIntType(), new d(r1));
    L10:
        bindModel(Disposables.fromAction(new c(r6, r1)));
        com.bytedance.android.livesdk.chatroom.o r2 = z51.a.h(null, 3);
        if (r2 == null) goto L17;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L17;
        IRoom r7 = (IRoom) r3.getValue();
        if (r7 == null) goto L17;
        long r9 = r7.getId();
    L18:
        com.bytedance.android.livesdk.chatroom.o r8 = z51.a.h(null, 3);
        if (r8 == null) goto L31;
        com.bytedance.live.datacontext.m r10 = r8.getRoom();
        if (r10 == null) goto L31;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L31;
        IBaseUser r12 = r11.getOwner();
        if (r12 == null) goto L31;
        String r13 = r12.getIdString();
        if (r13 == null) goto L31;
        Long r14 = StringsKt.toLongOrNull(r13);
        if (r14 == null) goto L31;
        long r15 = r14.longValue();
    L33:
        if (r9 != 0) goto L35;
        return;
    L35:
        if (r15 == 0) goto L40;
        com.bytedance.android.livesdk.service.l.d().getClass();
        bindModel(RxUtilKt.p(((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).queryPopularCardInfo(r9, r15, 0, 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()), "PopularCardIconModel", new PopularCardIconModel$queryPopularCardInfo$1(this)));
        return;
    L40:
        return;
    L31:
        r15 = 0;
    L17:
        r9 = 0;
    L7:
        r6 = null;
        goto L8
    }

    public final IconTemplate getViewForState(Object r5) {
        b r6 = (b) r5;
        Intrinsics.checkNotNullParameter(r6, "state");
        if ((r6 instanceof b.C0054b) == false) goto L6;
        TiltedIconTemplate r7 = new TiltedIconTemplate(getContext(), null, 6, 0);
        r7.setContentView(imageViewOf(2131252630, 26.0f, 32.0f));
        r7.setContentRightMargin(UtilityKotlinExtentionsKt.i(9));
        r7.setContentTopMargin(UtilityKotlinExtentionsKt.i(6));
        return r7;
    L6:
        return null;
    }

    public final IIconModel.EntryView getEntryViewForState(Object r8, Object r9) {
        b r10 = (b) r8;
        b r11 = (b) r9;
        Intrinsics.checkNotNullParameter(r10, "state");
        Boolean r0 = tg1.a.getValue();
        if ((r10 instanceof b.C0054b) == true) goto L5;
    L11:
        return null;
    L5:
        if ((r11 instanceof b.C0054b) == true) goto L11;
        if (r0.booleanValue() == false) goto L13;
        if (((b.C0054b) r10).b == true) goto L11;
    L13:
        return new IIconModel.EntryView(imageViewOf(2131252631, 80.0f, 96.0f), 0, false, 6, null);
    }

    public final void applyState(Object r11, Object r12, IconTemplate r13) {
        b r14 = (b) r11;
        b r15 = (b) r12;
        Intrinsics.checkNotNullParameter(r15, "curState");
        if ((r15 instanceof b.C0054b) == false) goto L6;
        IIconService.DefaultImpls.startCountDown$default(this, (((b.C0054b) r15).a * ((long) BubbleId.PadCast)) - System.currentTimeMillis(), b.a.a, null, null, 12, null);
        return;
    }
}
