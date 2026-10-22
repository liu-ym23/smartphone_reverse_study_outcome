package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.text.TextUtils;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.VideoGiftView;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.f;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.m;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayController;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m02.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidgetOrigin;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidget;", "<init>", "()V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseVideoGiftWidgetOrigin extends BaseVideoGiftWidget {
    public static final int L = 0;
    public final i02.c<EffectMessage> J;
    public final List<EffectMessage> K;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BaseVideoGiftWidgetOrigin a;

        public a(BaseVideoGiftWidgetOrigin r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            BaseVideoGiftWidgetOrigin r0 = this.a;
            if (r0.l == false) goto L14;
            if (r4 == false) goto L15;
            VideoGiftView r5 = r0.e;
            if (r5 == null) goto L12;
            f r6 = r5.h;
            if (r6 == null) goto L12;
            ILiveGiftPlayController r7 = r6.f;
            if (r7 == null) goto L12;
            r7.cancel();
        L12:
            r0.l = false;
            return;
        L15:
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements f.a {
        public final /* synthetic */ BaseVideoGiftWidgetOrigin a;

        public c(BaseVideoGiftWidgetOrigin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.player.f.a
        public final boolean a() {
            List<EffectMessage> r0 = this.a.K;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (((ArrayList) r0).isEmpty() == true) goto L7;
            return true;
        }
    }

    public static final class d<E> implements i02.c.a {
        public final /* synthetic */ BaseVideoGiftWidgetOrigin a;

        public d(BaseVideoGiftWidgetOrigin r1) {
            this.a = r1;
        }

        @Override // i02.c.a
        public final boolean compare(Object r3, Object r4) {
            EffectMessage r5 = (EffectMessage) r3;
            EffectMessage r6 = (EffectMessage) r4;
            int r0 = r5.c;
            int r1 = r6.c;
            if (r0 != r1) goto L7;
            List<EffectMessage> r2 = this.a.K;
            Intrinsics.checkNotNull(r2);
            if (((ArrayList) r2).indexOf(r5) > ((ArrayList) this.a.K).indexOf(r6)) goto L8;
        L9:
            return false;
        L8:
            return true;
        L7:
            if (r0 >= r1) goto L9;
            goto L8
        }
    }

    static {
        L = ((Number) com.bytedance.android.livesdk.gift.platform.business.a.n.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[12])).intValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final f.a Gq() {
        return new c(this);
    }

    public BaseVideoGiftWidgetOrigin() {
        this.K = new ArrayList();
        d r0 = new d(this);
        this.J = new i02.c(L + 1, r0);
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L12;
        k<Boolean> r2 = r1.getNeedStopEffect();
        if (r2 == null) goto L13;
        PublishSubject r3 = r2.onEvent();
        if (r3 == null) goto L14;
        ObservableSubscribeProxy r4 = (ObservableSubscribeProxy) r3.as(AutoDispose.bind(this));
        if (r4 == null) goto L15;
        r4.subscribe(new a(this));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final boolean jr(EffectMessage r6) {
        if (r6 != null) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.b, "loadEffectResource: effectMessage is null");
        return false;
    L6:
        e r1 = this.c.G1(r6.b);
        if (this.c.O9(r1) == true) goto L14;
        String r7 = this.b;
        StringBuilder r2 = new StringBuilder("loadEffectResource: assets is not valid ; assets = ");
        if (r1 == null) goto L11;
        Object r3 = Long.valueOf(r1.getId());
    L12:
        r2.append(r3);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r7, r2.toString());
        return false;
    L11:
        r3 = "null";
        goto L12
    L14:
        if (r1 != null) goto L16;
    L18:
        this.c.j4(r6.b, new com.bytedance.android.livesdk.gift.platform.business.effect.widget.b(this, r6), 4);
        return true;
    L16:
        if (r1.getResourceType() != 9) goto L18;
        return false;
    }

    public static final void hr(BaseVideoGiftWidgetOrigin r13, EffectMessage r14) {
        if (r13.isViewValid() == false) goto L99;
        if (r14 == null) goto L99;
        boolean r1 = true;
        if (r14.g == false) goto L9;
        List<EffectMessage> r0 = r13.K;
        Intrinsics.checkNotNull(r0);
        ListProtector.add(r0, 0, r14);
    L20:
        List<EffectMessage> r15 = r13.K;
        Intrinsics.checkNotNull(r15);
        if (((ArrayList) r15).isEmpty() == false) goto L23;
    L90:
        String r16 = r13.b;
        StringBuilder r3 = new StringBuilder("[tryConsumeEffectMessage] not consume, mEffectMessageList:");
        r3.append(((ArrayList) r13.K).size());
        r3.append(" mIsPlayingSpecialGift:");
        r3.append(r13.l);
        r3.append(" mVideoGiftView(null?):");
        if (r13.e != null) goto L93;
        boolean r4 = true;
    L94:
        r3.append(r4);
        r3.append(" mRoom(null?):");
        if (r13.d == null) goto L98;
        r1 = false;
    L98:
        r3.append(r1);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r16, r3.toString());
        int r17 = i02.b.e;
        i02.b.a.a(-1);
        return;
    L93:
        r4 = false;
        goto L94
    L23:
        if (r13.l == true) goto L90;
        if (r13.e == null) goto L90;
        if (r13.d == null) goto L90;
        EffectMessage r18 = (EffectMessage) ListProtector.remove(r13.K, 0);
        if (r18 != null) goto L32;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r13.b, "msg from EffectMessageList is null");
        int r19 = i02.b.e;
        i02.b.a.a(-1);
        return;
    L32:
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.consume_effect_message, r18.a, r18.l, r18.b);
        r13.o = r18;
        i02.c<EffectMessage> r5 = r13.J;
        int r6 = 0;
    L34:
        if (r6 >= r5.c) goto L38;
        r6 = r6 + 1;
        if (r5.a[r6].equals(r18) == false) goto L34;
        Object[] r7 = r5.a;
        int r8 = r5.c;
        r5.c = r8 - 1;
        r7[r6] = r7[r8];
        r5.a();
    L38:
        e r9 = r13.c.G1(r18.b);
        if (r9 != null) goto L45;
        String r2 = String.valueOf(r18.l);
        String r10 = String.valueOf(r18.a);
        EffectMessage r11 = r13.o;
        if (r11 == null) goto L43;
        Intrinsics.checkNotNull(r11);
        String r20 = r11.n;
    L44:
        h.x("特效列表找不到该Id", r2, r10, BuildConfig.FLAVOR, r20);
        r13.Fq();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r13.b, "assets not found consume next one, effectId:" + r18.b);
        int r110 = i02.b.e;
        i02.b.a.a(-1);
        return;
    L43:
        r20 = BuildConfig.FLAVOR;
        goto L44
    L45:
        Intrinsics.checkNotNullParameter(r18, "msg");
        int r21 = g02.a.a(r18);
        if (r21 != 0) goto L48;
        boolean r23 = false;
    L60:
        if (r23 == false) goto L62;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r13.b, "resource type not match" + r18.b);
        r13.Fq();
        int r111 = i02.b.e;
        i02.b.a.a(-1);
        return;
    L62:
        Intrinsics.checkNotNullParameter(r18, "msg");
        Intrinsics.checkNotNullParameter(r9, "assets");
        if (r9.getResourceType() != 4) goto L65;
    L68:
        Intrinsics.checkNotNullParameter(r18, "msg");
        Intrinsics.checkNotNullParameter(r9, "assets");
        if (TextUtils.isEmpty(r18.d) == false) goto L71;
        r13.fr(r18);
        r13.Fq();
        int r112 = i02.b.e;
        i02.b.a.a(-1);
    L89:
        int r113 = i02.b.e;
        return;
    L71:
        r13.l = true;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r13.b, "ConsumeEffectMessage(), giftId = " + r18.l);
        i r24 = r13.m;
        long r25 = r18.b;
        r24.getClass();
        r24.a = jc1.k.n(IGiftService.class).getAssets("effects", r25);
        boolean r26 = u.s();
        if (x.b() == false) goto L74;
    L82:
        if (r1 == false) goto L84;
        r13.Iq(r18);
    L88:
        h.x("播放视频礼物", String.valueOf(r18.l), String.valueOf(r18.a), BuildConfig.FLAVOR, r18.n);
        int r114 = i02.b.e;
        goto L89
    L84:
        VideoGiftView r27 = r13.e;
        Intrinsics.checkNotNull(r27);
        r27.d(r13.j);
        int r28 = m02.f.a(Long.valueOf(r18.b), r18.d);
        SuperResolutionModel r29 = new SuperResolutionModel(m02.f.d(r18.d), m02.f.c(r18.d), r13.Kq(r28), r18.b, r28);
        VideoGiftView r30 = r13.e;
        Intrinsics.checkNotNull(r30);
        IRoom r31 = r13.d;
        Intrinsics.checkNotNull(r31);
        r31.getOwner();
        r30.g(r18, r29);
        n02.a r33 = r13.i;
        if (r33 == null) goto L87;
        Intrinsics.checkNotNull(r33);
        n02.a.a(r18);
    L87:
        r13.Bq(r18, r28);
        goto L88
    L74:
        if (r13.q == true) goto L78;
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT, Boolean.FALSE)).booleanValue() == false) goto L82;
    L78:
        if (r18.o == true) goto L82;
        if (r26 == true) goto L82;
        r1 = false;
        goto L82
    L65:
        if (r9.getResourceType() == 15) goto L68;
        BaseVideoGiftWidget.cr(r18, r9);
        r13.Fq();
        goto L89
    L48:
        if (r21 == 1) goto L56;
        if (r21 == 2) goto L53;
    L58:
        r23 = true;
        goto L60
    L53:
        if (m.h(r18) == false) goto L58;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r13.b, "recycle resource" + r18.b);
        r13.jr(r18);
        goto L58
    L56:
        if (m.g(r18) == false) goto L58;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r13.b, "recycle resource" + r18.b);
        r13.jr(r18);
        goto L58
    L9:
        List<EffectMessage> r34 = r13.K;
        Intrinsics.checkNotNull(r34);
        ((ArrayList) r34).add(r14);
        i02.c<EffectMessage> r35 = r13.J;
        int r36 = r35.c;
        if (r36 == r35.b) goto L12;
        int r37 = r36 + 1;
        r35.c = r37;
        r35.a[r37] = r14;
        int r115 = r37 / 2;
    L16:
        if (r115 <= 0) goto L20;
        i02.c.a r38 = r35.d;
        Object[] r39 = r35.a;
        if (r38.compare(r39[r37], r39[r115]) == false) goto L20;
        Object[] r40 = r35.a;
        Object r41 = r40[r115];
        r40[r115] = r40[r37];
        r40[r37] = r41;
        r37 = r115;
        r115 = r115 / 2;
        goto L16
    L12:
        if (r35.d.compare(r14, r35.a[1]) == true) goto L20;
        r35.a[1] = r14;
        r35.a();
    L99:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r13.b, "addSpecialMessage failed: message" + r14);
    }
}
