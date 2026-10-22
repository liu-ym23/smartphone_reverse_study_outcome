package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.interactivity.api.base.InteractionInfoApi;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.FusionEmojiBanList;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.InputFunctionList;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.MentionChatApi;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.MsgOptPanel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ InteractivityContext a;

        public a(InteractivityContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Disposable r3 = (Disposable) r2;
            this.a.getRecommendShortcutEmoji().setValue(l42.a.j.getValue());
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractivityContext a;
        public final /* synthetic */ RoomContext b;
        public final /* synthetic */ DataCenter c;

        public b(InteractivityContext r1, RoomContext r2, DataCenter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            int r0 = h.a;
            h.a((com.bytedance.android.livesdk.interactivity.api.publicscreen.api.q) ((BaseResponse) ((Response) r4)).data, this.a, this.b, this.c);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ALogger.e("fetch Interaction Res Error", (Throwable) r2);
        }
    }

    public static final class d extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public d() {
        }
    }

    public h() {
    }

    static {
    }

    public static final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.model.b r2, InteractivityContext r3, RoomContext r4) {
        im2.d r0 = new im2.d(((Boolean) r4.isAnchor().getValue()).booleanValue());
        List<com.bytedance.android.livesdk.chatroom.model.n> r5 = r2.messages;
        if (r5 == null) goto L17;
        final ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        tlc.d r1 = r0.b((com.bytedance.android.livesdk.chatroom.model.n) r7.next());
        if (r1 == null) goto L6;
        r6.add(r1);
        goto L6
    L10:
        r3.getPublicScreenContext().c(new InteractivityContextInitHelper$handleHistoryMentionChat$1$1(r6));
        return;
    }

    public static final void c(InteractivityContext r1, long r2, String r4) {
        s0 r0 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(r2, r4, null);
        if (PublicScreenABHelper.P == true) goto L6;
        return;
    L6:
        if (o3.f().isMediaRoom() == false) goto L8;
    L11:
        ALogger.e("PSTopMessage", "is media or vs room, don't need to request backup");
        return;
    L8:
        if (Intrinsics.areEqual(o3.f().isVSRoom(), Boolean.TRUE) == true) goto L11;
        r1.getPsTopMessage().d(new PSTopMessagePayload(null));
    }

    public static final void d(RoomContext r3, InteractivityContext r4, CompositeDisposable r5) {
        com.bytedance.android.live.network.c r0 = com.bytedance.android.live.network.c.b();
        if (r0 == null) goto L14;
        MentionChatApi r1 = (MentionChatApi) r0.e(MentionChatApi.class);
        if (r1 == null) goto L15;
        Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.b>> r2 = r1.getHistoryMentionChat(((Room) r3.getRoom().getValue()).getRoomId());
        if (r2 == null) goto L16;
        Observable r6 = r2.compose(RxUtil.rxSchedulerHelper());
        if (r6 == null) goto L17;
        Disposable r7 = r6.subscribe(new f(r4, r3), g.a);
        if (r7 == null) goto L18;
        RxUtilKt.c(r7, r5);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static final void a(com.bytedance.android.livesdk.interactivity.api.publicscreen.api.q r3, InteractivityContext r4, RoomContext r5, DataCenter r6) {
        if (r3 == null) goto L26;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r r0 = r3.iconInfo;
        if (r0 == null) goto L6;
        r4.getLikeIconInfo().setValue(r0);
    L6:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.t r1 = r3.matchChatInfo;
        if (r1 == null) goto L9;
        r4.getMatchChatInfo().setValue(r1);
    L9:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w r2 = r3.recommendShortcutEmoji;
        if (r2 == null) goto L12;
        r4.getRecommendShortcutEmoji().setValue(r2);
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w> r7 = l42.a.j;
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r2);
    L12:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.g r8 = r3.frequentChatInfo;
        if (r8 == null) goto L15;
        r4.getFrequentChatInfo().d(r8);
    L15:
        InputFunctionList r9 = r3.inputFunctionList;
        if (r9 == null) goto L18;
        r4.getInputFunctionInfo().d(r9);
    L18:
        final FusionEmojiBanList r10 = r3.fusionEmojiBanList;
        if (r10 == null) goto L21;
        r4.getFusionEmojiBanList().d(r10);
        r4.getFusionEmojiManager().c(new InteractivityContextInitHelper$handleData$1$6$1(r10));
    L21:
        final MsgOptPanel r11 = r3.msgOptPanel;
        if (r11 == null) goto L24;
        r4.getPsOperatePanelItem().d(r11);
        r4.getPsOperatePanelManager().c(new InteractivityContextInitHelper$handleData$1$7$1(r11));
    L24:
        r4.handleInteractionData(r3, r5, r6);
        return;
    }

    public static void e(RoomContext r7, InteractivityContext r8, CompositeDisposable r9, DataCenter r10) {
        Intrinsics.checkNotNullParameter(r7, "roomContext");
        Intrinsics.checkNotNullParameter(r8, "interactionContext");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        String r0 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new d()).second;
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        String r6 = r0;
        InteractionInfoApi r1 = (InteractionInfoApi) com.bytedance.android.live.network.c.b().e(InteractionInfoApi.class);
        long r2 = ((Room) r7.getRoom().getValue()).getRoomId();
        if (a0.c(r10) == false) goto L8;
        String r3 = "preview_feed_v2";
    L9:
        String r4 = r3;
        IUserService r5 = jc1.k.f(IUserService.class);
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.user.f r11 = r5.user();
        if (r11 == null) goto L14;
        IUser r13 = r11.b();
    L15:
        Disposable r14 = r1.getInteractionInfo(r2, r4, fb2.e.a(r13), r6).doOnSubscribe(new a(r8)).subscribeOn(Schedulers.io()).subscribe(new b(r8, r7, r10), c.a);
        if (r14 == null) goto L19;
        RxUtilKt.c(r14, r9);
        return;
    L19:
        return;
    L14:
        r13 = null;
        goto L15
    L8:
        r3 = "enter";
        goto L9
    }
}
