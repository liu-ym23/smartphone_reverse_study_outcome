package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.content.Context;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.FeedbackApi;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public final CompositeDisposable a;
    public final NextLiveData<List<com.bytedance.android.livesdk.rank.model.b>> b;
    public final NextLiveData<Boolean> c;
    public final IRoom d;
    public final boolean e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ p a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public a(p r1, String r2, String r3, String r4, String r5, String r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
            this.a.c.setValue(Boolean.TRUE);
            f2.b(2131918393, 0);
            p r7 = this.a;
            String r0 = this.b;
            r7.getClass();
            if (Intrinsics.areEqual("ksong_song_info", r0) == false) goto L7;
            String r8 = this.c;
            String r1 = this.d;
            String r2 = this.e;
            String r3 = this.f;
            pb0.a r4 = pb0.b.a;
            Intrinsics.checkNotNullParameter(r8, "requestPage");
            Intrinsics.checkNotNullParameter(r1, "songName");
            Intrinsics.checkNotNullParameter(r2, "singerName");
            Intrinsics.checkNotNullParameter(r3, "feedback");
            pb0.a r9 = pb0.b.a;
            if (r9 == null) goto L11;
            r9.l(r8, r1, r2, r3);
            return;
        L11:
            return;
        L7:
            String r11 = this.f;
            String r12 = this.g;
            p r13 = this.a;
            String r14 = this.b;
            r13.getClass();
            boolean r15 = Intrinsics.areEqual("ksong", r14);
            pb0.a r16 = pb0.b.a;
            Intrinsics.checkNotNullParameter(r12, "content");
            pb0.a r17 = pb0.b.a;
            if (r17 == null) goto L13;
            r17.h(r11, r12, r15);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.c.setValue(Boolean.FALSE);
            Context r0 = s1.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ p a;

        public c(p r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            NextLiveData<List<com.bytedance.android.livesdk.rank.model.b>> r0 = this.a.b;
            List r3 = KotlinTypeUtilsKt.castElementType(((com.bytedance.android.livesdk.rank.model.g) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r2)).data).getIssueCategories());
            if (r3 != null) goto L5;
            r3 = CollectionsKt.emptyList();
        L5:
            r0.setValue(r3);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Context r0 = s1.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    public p() {
        IRoom r0 = com.bytedance.android.live.ktv.common.util.a.c();
        boolean r1 = com.bytedance.android.live.ktv.common.util.a.e();
        Intrinsics.checkNotNullParameter(r0, NewBroadcastMonitor.PAGE.ROOM);
        this.d = r0;
        this.e = r1;
        this.a = new CompositeDisposable();
        this.b = new NextLiveData();
        this.c = new NextLiveData();
    }

    public final void b(int r9, String r11) {
        Intrinsics.checkNotNullParameter(r11, "thirdPartyScene");
        RxUtilKt.c(RxUtilKt.h(FeedbackApi.a.a((FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class), this.d.getId(), this.d.getId(), r9, r11).subscribeOn(Schedulers.io())).subscribe(new c(this), d.a), this.a);
    }

    public final void a(String r17, int r18, String r19, String r21, String r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r17, "requestPage");
        Intrinsics.checkNotNullParameter(r19, "thirdPartyScene");
        Intrinsics.checkNotNullParameter(r21, "musicName");
        Intrinsics.checkNotNullParameter(r22, "singer");
        Intrinsics.checkNotNullParameter(r23, "categories");
        Intrinsics.checkNotNullParameter(r24, "contents");
        tc0.c r0 = tc0.c.h();
        JSONObject r1 = new JSONObject();
        int r9 = jc1.k.n(IInteractService.class).getLinkMode();
        r1.put("link_mode", r9);
        if (r9 == 0) goto L12;
        if (r9 == 2) goto L11;
        if (r9 != 8) goto L7;
        String r11 = "audio_talk";
    L13:
        r1.put("link_type", r11);
        r1.put("music_name", r21);
        r1.put("singer_name", r22);
        if (this.e == true) goto L16;
    L20:
        bb0.a r12 = bb0.b.a;
        if (r12 == null) goto L24;
        List<String> r13 = r12.j();
        if (r13 == null) goto L24;
    L25:
        r1.put("recent_song_info", r13);
        r1.put("link_mic_str", r0.f);
        RxUtilKt.h(((FeedbackApi) com.bytedance.android.live.network.c.b().e(FeedbackApi.class)).feedback(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", Long.valueOf(this.d.getId())), TuplesKt.to("channel_id", Long.valueOf(this.d.getId())), TuplesKt.to("issue_category", r23), TuplesKt.to("issue_content", r24), TuplesKt.to("scene", Integer.valueOf(r18)), TuplesKt.to("third_party_scene", r19), TuplesKt.to("anchor_id", this.d.getOwnerUserIdString()), TuplesKt.to("self_id", jc1.k.n(IMiddlewareUserService.class).user().n()), TuplesKt.to("extra_str", r1.toString())})).subscribeOn(Schedulers.io())).subscribe(new a(this, r19, r17, r21, r22, r23, r24), new b(this));
        return;
    L24:
        r13 = new ArrayList();
        goto L25
    L16:
        if (r0.u != 1) goto L18;
        boolean r14 = true;
    L19:
        r1.put("is_client_mixstream", r14);
        goto L20
    L18:
        r14 = false;
        goto L19
    L7:
        if (r9 == 32) goto L9;
        r11 = "other";
        goto L13
    L9:
        r11 = "video_talk";
        goto L13
    L11:
        r11 = "video_audience";
        goto L13
    L12:
        r11 = "none";
        goto L13
    }
}
