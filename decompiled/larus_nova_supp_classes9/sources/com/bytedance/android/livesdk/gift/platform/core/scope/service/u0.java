package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.Context;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.banner.di.BannerGiftModule_ProvideBannerGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.banner.di.PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.banner.di.PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.blindbox.di.BlindBoxModule_ProvideBlindBoxFactoryFactory;
import com.bytedance.android.livesdk.gift.defaultbanner.di.NormalBannerModule_ProvideNormalBannerPluginFactoryFactory;
import com.bytedance.android.livesdk.gift.fastgift.di.FastGiftModule_ProvideFastGiftPluginFactoryFactory;
import com.bytedance.android.livesdk.gift.goods.di.GoodModule_ProvideGoodsPluginFactoryFactory;
import com.bytedance.android.livesdk.gift.lynxbanner.di.LynxBannerModule_ProvideLynxGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.messageboard.di.MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.periodcard.di.PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.platform.business.GiftPluginType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.redpacket.di.PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.redpacket.di.RechargeCouponModule_ProvideRedPacketGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.redpacket.di.RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory;
import com.bytedance.android.livesdk.gift.vs.di.VSModule_ProviderVSGiftDialogFactory;
import com.bytedance.android.livesdk.gift.vs.di.VSModule_ProviderVSGiftTrayFactory;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u0 implements com.bytedance.android.scope.o, com.bytedance.android.livesdk.gift.platform.business.g {
    public static final mz1.a.C0251a i = null;
    public final Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> a;
    public final List<com.bytedance.android.livesdk.gift.platform.core.j> b;
    public final List<com.bytedance.android.livesdk.gift.platform.business.f> c;

    @Inject
    public Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h.a> d;
    public h12.f e;
    public h12.g f;
    public final Context g;
    public final DataCenter h;

    public static final class a {
    }

    static {
        i = mz1.a.a();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.g
    public final void g() {
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.h) ((Map.Entry) r0.next()).getValue()).w();
        goto L4
    }

    public final void onStart() {
        mz1.a.C0251a r0 = i;
        r0.getClass();
        this.d = ImmutableMap.builderWithExpectedSize(13).e(GiftPluginType.TYPE_RED_PACKET, RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory.provideRedPacketGiftFactory(r0.a)).e(GiftPluginType.TYPE_RECHARGE_COUPON, RechargeCouponModule_ProvideRedPacketGiftFactoryFactory.provideRedPacketGiftFactory(r0.b)).e(GiftPluginType.TYPE_POPULAR_BOX, PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory.providePopularBoxGiftFactory(r0.c)).e(GiftPluginType.TYPE_PERIOD_CARD, PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory.providePeriodCardGiftFactory(r0.d)).e(GiftPluginType.TYPE_FAST_GIFT, FastGiftModule_ProvideFastGiftPluginFactoryFactory.provideFastGiftPluginFactory(r0.e)).e(GiftPluginType.TYPE_BANNER, BannerGiftModule_ProvideBannerGiftFactoryFactory.provideBannerGiftFactory(r0.f)).e(GiftPluginType.TYPE_PROP_POPULAR_CARD, PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory.providePopularCardGiftFactory(r0.g)).e(GiftPluginType.TYPE_PK_PROP, PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory.providePopularCardGiftFactory(r0.h)).e(GiftPluginType.TYPE_GOODS, GoodModule_ProvideGoodsPluginFactoryFactory.provideGoodsPluginFactory(r0.i)).e(GiftPluginType.TYPE_MSGBOARD_GIFT, MsgBoardGiftModule_ProvideMsgBoardGiftFactoryFactory.provideMsgBoardGiftFactory(r0.j)).e(GiftPluginType.TYPE_LYNX_BANNER, LynxBannerModule_ProvideLynxGiftFactoryFactory.provideLynxGiftFactory(r0.k)).e(GiftPluginType.TYPE_BLIND_BOX, BlindBoxModule_ProvideBlindBoxFactoryFactory.provideBlindBoxFactory(r0.l)).e(GiftPluginType.TYPE_DEFAULT_BANNER, NormalBannerModule_ProvideNormalBannerPluginFactoryFactory.provideNormalBannerPluginFactory(r0.m)).a();
        this.e = VSModule_ProviderVSGiftDialogFactory.providerVSGiftDialog(r0.n);
        this.f = VSModule_ProviderVSGiftTrayFactory.providerVSGiftTray(r0.n);
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
        Iterator r1 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.h) ((Map.Entry) r1.next()).getValue()).onDestroy();
        goto L4
    L6:
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h.a> r2 = this.d;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("pluginFactoryMap");
    L9:
        Iterator<T> r3 = r2.entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r3.next();
        i(((com.bytedance.android.livesdk.gift.platform.business.h.a) r4.getValue()).a(this.h, this.g), (GiftPluginType) r4.getKey(), this.g);
        goto L11
    }

    public final void onStop() {
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.h) ((Map.Entry) r0.next()).getValue()).onDestroy();
        goto L4
    L6:
        ((LinkedHashMap) this.a).clear();
        ((ArrayList) this.b).clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.g
    public final List<com.bytedance.android.livesdk.gift.platform.business.f> c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.g
    public final List<com.bytedance.android.livesdk.gift.platform.core.j> d() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.g
    public Context getContext() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.g
    public final Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> h() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.g
    public final com.bytedance.android.livesdk.gift.platform.business.tray.k a(DataCenter r2) {
        h12.g r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    public u0(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.g = r2;
        this.h = r3;
        this.a = new LinkedHashMap();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final void i(com.bytedance.android.livesdk.gift.platform.business.h r1, GiftPluginType r2, Context r3) {
        r1.k(r3);
        this.a.put(r2, r1);
        r1.a();
        if ((r1 instanceof com.bytedance.android.livesdk.gift.platform.business.f) == false) goto L6;
        ArrayList r4 = (ArrayList) this.c;
        r4.add((com.bytedance.android.livesdk.gift.platform.business.f) r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.g
    public final LiveDialogFragment f(DataCenter r2, Context r3, GiftViewModelManager r4, LocateGiftInfo r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        h12.f r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r3, r2, r4, r5);
    }
}
