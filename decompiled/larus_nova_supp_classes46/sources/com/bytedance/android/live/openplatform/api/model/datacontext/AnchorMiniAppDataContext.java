package com.bytedance.android.live.openplatform.api.model.datacontext;

import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.openplatform.api.model.coupon.b;
import com.bytedance.android.livesdk.message.model.el;
import com.bytedance.android.livesdk.message.model.pf;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b/\u00100R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\rR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\rR!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R=\u0010.\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'j\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)`*0&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/datacontext/AnchorMiniAppDataContext;", "Lcom/bytedance/android/live/openplatform/api/model/datacontext/MiniAppDataContext;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/broadcastgame/api/model/response/MiniAppEntrancePermissionResponse;", "entranceInfo$delegate", "Lcom/bytedance/live/datacontext/p;", "getEntranceInfo", "()Lcom/bytedance/live/datacontext/n;", "entranceInfo", "Lcom/bytedance/live/datacontext/m;", "", "supportComponentCoexist$delegate", "getSupportComponentCoexist", "()Lcom/bytedance/live/datacontext/m;", "supportComponentCoexist", "", "coexistComponentBeforeStart$delegate", "getCoexistComponentBeforeStart", "coexistComponentBeforeStart", "Lcom/bytedance/android/live/openplatform/api/model/coupon/b;", "couponInfoOnMorePanel$delegate", "getCouponInfoOnMorePanel", "couponInfoOnMorePanel", "microAppMountPunishing$delegate", "getMicroAppMountPunishing", "microAppMountPunishing", "Llo0/b;", "privateMsgTabInfo$delegate", "getPrivateMsgTabInfo", "privateMsgTabInfo", "Lcom/bytedance/android/livesdk/message/model/el;", "shelfTradeData$delegate", "getShelfTradeData", "shelfTradeData", "Lcom/bytedance/android/livesdk/message/model/pf$a;", "microAppLiveMountLimitData$delegate", "getMicroAppLiveMountLimitData", "microAppLiveMountLimitData", "Lcom/bytedance/live/datacontext/i;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "sellingPointEditCache$delegate", "getSellingPointEditCache", "()Lcom/bytedance/live/datacontext/i;", "sellingPointEditCache", "<init>", "()V", "Companion", "a", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorMiniAppDataContext extends MiniAppDataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p coexistComponentBeforeStart$delegate;
    private final p couponInfoOnMorePanel$delegate;
    private final p entranceInfo$delegate;
    private final p microAppLiveMountLimitData$delegate;
    private final p microAppMountPunishing$delegate;
    private final p privateMsgTabInfo$delegate;
    private final p sellingPointEditCache$delegate;
    private final p shelfTradeData$delegate;
    private final p supportComponentCoexist$delegate;

    public static final class a {
        @JvmStatic
        public static AnchorMiniAppDataContext a() {
            OpenPlatformDataContext.Companion.getClass();
            return (AnchorMiniAppDataContext) OpenPlatformDataContext.a.a(AnchorMiniAppDataContext.class);
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "entranceInfo", "getEntranceInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "supportComponentCoexist", "getSupportComponentCoexist()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "coexistComponentBeforeStart", "getCoexistComponentBeforeStart()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "couponInfoOnMorePanel", "getCouponInfoOnMorePanel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "microAppMountPunishing", "getMicroAppMountPunishing()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "privateMsgTabInfo", "getPrivateMsgTabInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "shelfTradeData", "getShelfTradeData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "microAppLiveMountLimitData", "getMicroAppLiveMountLimitData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AnchorMiniAppDataContext.class, "sellingPointEditCache", "getSellingPointEditCache()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final AnchorMiniAppDataContext getShared() {
        Companion.getClass();
        return a.a();
    }

    public final m<Integer> getCoexistComponentBeforeStart() {
        return (m) this.coexistComponentBeforeStart$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<b> getCouponInfoOnMorePanel() {
        return (n) this.couponInfoOnMorePanel$delegate.a(this, $$delegatedProperties[3]);
    }

    public final n<MiniAppEntrancePermissionResponse> getEntranceInfo() {
        return (n) this.entranceInfo$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<pf.a> getMicroAppLiveMountLimitData() {
        return (n) this.microAppLiveMountLimitData$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> getMicroAppMountPunishing() {
        return (m) this.microAppMountPunishing$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<lo0.b> getPrivateMsgTabInfo() {
        return (n) this.privateMsgTabInfo$delegate.a(this, $$delegatedProperties[5]);
    }

    public final i<HashMap<Long, String>> getSellingPointEditCache() {
        return (i) this.sellingPointEditCache$delegate.a(this, $$delegatedProperties[8]);
    }

    public final n<el> getShelfTradeData() {
        return (n) this.shelfTradeData$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> getSupportComponentCoexist() {
        return (m) this.supportComponentCoexist$delegate.a(this, $$delegatedProperties[1]);
    }

    public AnchorMiniAppDataContext() {
        this.entranceInfo$delegate = q.c(this);
        Boolean r0 = Boolean.FALSE;
        this.supportComponentCoexist$delegate = q.d(this, r0);
        this.coexistComponentBeforeStart$delegate = q.d(this, 0);
        this.couponInfoOnMorePanel$delegate = q.c(this);
        this.microAppMountPunishing$delegate = q.d(this, r0);
        this.privateMsgTabInfo$delegate = q.c(this);
        this.shelfTradeData$delegate = q.c(this);
        this.microAppLiveMountLimitData$delegate = q.c(this);
        this.sellingPointEditCache$delegate = ConstantKt.d(this, new HashMap());
    }
}
