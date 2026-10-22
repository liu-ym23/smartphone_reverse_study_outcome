package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class Mp4EnhancedEnterPlayer extends AnimPlayer<k32.a> {
    public final CompositeDisposable c;
    public final Lazy d;
    public boolean e;
    public Disposable f;

    public static final class a implements Action {
        public final /* synthetic */ Mp4EnhancedEnterPlayer a;

        public a(Mp4EnhancedEnterPlayer r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.c.clear();
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ com.bytedance.android.live.profit.player.d d;
        public final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$4 e;
        public final /* synthetic */ AnimPlayer.a f;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a g;
        public final /* synthetic */ Mp4EnhancedEnterPlayer$playAnim$3 h;
        public final /* synthetic */ String i;

        public c(Mp4EnhancedEnterPlayer r1, Mp4EnhancedEnterPlayer$playAnim$2 r2, String r3, long r4, com.bytedance.android.live.profit.player.d r6, Mp4EnhancedEnterPlayer$playAnim$4 r7, AnimPlayer.a r8, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r9, Mp4EnhancedEnterPlayer$playAnim$3 r10, String r11) {
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.profit.player.s r9 = (com.bytedance.android.live.profit.player.s) r8;
            List r0 = (List) r9.b();
            if (r0 != null) goto L9;
            Mp4EnhancedEnterPlayer$playAnim$2 r1 = this.a;
            StringBuilder r2 = new StringBuilder("MaskSrc list create failed: ");
            Throwable r10 = r9.a();
            if (r10 == null) goto L7;
            String r11 = r10.getMessage();
        L8:
            r2.append(r11);
            r1.invoke(r2.toString(), this.b, String.valueOf(this.c));
            return;
        L7:
            r11 = null;
            goto L8
        L9:
            this.d.lh(this.c, new com.bytedance.android.live.profit.player.n(r0, new Mp4EnhancedEnterPlayer$playAnim$8$1(this), new q(this), 1));
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.Mp4EnhancedEnter;
    }

    public Mp4EnhancedEnterPlayer(InteractivityPlatformContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "interactivityContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
        CompositeDisposable r4 = new CompositeDisposable();
        this.c = r4;
        this.d = LazyKt.lazy(Mp4EnhancedEnterPlayer$assetManager$2.INSTANCE);
        RxUtilKt.c(r2.getOnCleared().subscribe(new a(this)), r4);
        com.bytedance.android.live.profit.player.d r5 = yt0.c.h();
        if (r5 == null) goto L10;
        PublishSubject r6 = r5.x1();
        if (r6 == null) goto L11;
        Disposable r7 = r6.subscribe(new p(this));
        if (r7 == null) goto L12;
        RxUtilKt.c(r7, r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(k32.a r28, Context r29, AnimPlayer.a r30, ViewGroup r31, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r33) {
        Intrinsics.checkNotNullParameter(r28, "msg");
        Intrinsics.checkNotNullParameter(r29, "context");
        Intrinsics.checkNotNullParameter(r30, "animParams");
        Intrinsics.checkNotNullParameter(r31, "parentView");
        Intrinsics.checkNotNullParameter(r33, "playerListener");
        if (this.e == false) goto L8;
        ALogger.w("Mp4EnhancedEnterPlayer", "skip enter effect caused by profile preview showing");
        View.OnClickListener r0 = r30.c;
        if (r0 == null) goto L42;
        r0.onClick(r31);
        return;
    L42:
        return;
    L8:
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        r2.element = false;
        Mp4EnhancedEnterPlayer$playAnim$1 r6 = new Mp4EnhancedEnterPlayer$playAnim$1(this, r2, r33);
        final Mp4EnhancedEnterPlayer$playAnim$2 r3 = new Mp4EnhancedEnterPlayer$playAnim$2(r6, r28);
        final Mp4EnhancedEnterPlayer$playAnim$3 r10 = new Mp4EnhancedEnterPlayer$playAnim$3(r6, r28);
        ALogger.w("Mp4EnhancedEnterPlayer", "start to play");
        va.a r4 = r28.k;
        if (r4 != null) goto L12;
        Mp4EnhancedEnterPlayer$playAnim$2.invoke$default(r3, "Message.effectConfig is null", null, null, 6, null);
        return;
    L12:
        final String r7 = r4.getDressId();
        if (r7 != null) goto L16;
        Mp4EnhancedEnterPlayer$playAnim$2.invoke$default(r3, "Message.effectConfig.dressId is null", null, null, 6, null);
        return;
    L16:
        com.bytedance.android.live.profit.dress.l r8 = yt0.c.a().getDressData(r7, 2, "Mp4EnhancedEnterPlayer: playAnim");
        if (r8 != null) goto L20;
        Mp4EnhancedEnterPlayer$playAnim$2.invoke$default(r3, "dressModel is null", r7, null, 4, null);
        return;
    L20:
        final long r14 = r8.j;
        com.bytedance.android.live.profit.player.d r11 = yt0.c.h();
        if (r11 != null) goto L24;
        r3.invoke("playerService is null", r7, String.valueOf(r14));
        return;
    L24:
        final String r24 = ((IAssetsManager) this.d.getValue()).H0(r14);
        if (r24 != null) goto L28;
        r3.invoke("resource not ready", r7, String.valueOf(r14));
        return;
    L28:
        Mp4EnhancedEnterPlayer$playAnim$4 r13 = new Mp4EnhancedEnterPlayer$playAnim$4(r30, r31, r28);
        RevenueUtils.b r1 = RevenueUtils.i;
        JSONObject r5 = UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("enter_type", 9), TuplesKt.to("dress_id", r7), TuplesKt.to("resource_id", Long.valueOf(r14))});
        r1.getClass();
        RevenueUtils.b.d(r28, "user_enter_play", false, null, r5);
        if (((Boolean) j40.z.a.getValue()).booleanValue() == false) goto L32;
        r11.Nc(new com.bytedance.android.live.profit.player.a(r7, r4.l(), r28.c, s1.G(r30.a) + 11.0f, new Mp4EnhancedEnterPlayer$playAnim$5(r13), new Mp4EnhancedEnterPlayer$playAnim$6(r10, r7, r14, r24), new Mp4EnhancedEnterPlayer$playAnim$7(r3, r7, r14)));
        ((v72.c.a) r33).b();
        return;
    L32:
        a5 r9 = r8.m;
        if (r9 != null) goto L36;
        r3.invoke("template is null", r7, String.valueOf(r14));
        return;
    L36:
        com.bytedance.android.live.profit.player.e r15 = r11.Qh();
        Map r16 = r4.l();
        if (r16 == null) goto L39;
        Map r17 = MapsKt.toMap(r16);
    L40:
        RxUtilKt.c(com.bytedance.android.live.profit.player.e.a.a(r15, r29, r24, r9, r17, r8.p, r28.c, r8.o, 0, null, 896).subscribe(new c(this, r3, r7, r14, r11, r13, r30, r33, r10, r24)), this.c);
        return;
    L39:
        r17 = null;
        goto L40
    }
}
