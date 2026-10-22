package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListPreLoadService implements com.bytedance.android.scope.o {
    public static final ReadOnlyProperty i = null;
    public static final ReadOnlyProperty j = null;
    public static final a k = null;
    public final Lazy a;
    public final Lazy b;
    public final Map<String, Long> c;
    public boolean d;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x e;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y f;
    public final DataCenter g;
    public final yz0.g h;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_DISABLE_SORT_REQUEST_PROP_LIST", "getLIVE_DISABLE_SORT_REQUEST_PROP_LIST()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_SORT_MSG_REQUEST_GIFT_LIST_DELAY", "getLIVE_SORT_MSG_REQUEST_GIFT_LIST_DELAY()J", 0))};
        }

        public a() {
        }
    }

    public static final class b implements wp2.l {
        public b() {
        }
    }

    static {
        k = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_sort_request_prop_list", Boolean.FALSE, Boolean.TYPE, false);
        KProperty[] r1 = a.a;
        KProperty r10 = r1[0];
        i = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sort_msg_request_gift_list_delay", 0L, Long.TYPE, false);
        KProperty r8 = r1[1];
        j = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r8);
    }

    public final void onStart() {
        if (((com.bytedance.android.livesdk.gift.configmodel.d2) this.a.getValue()).b() == true) goto L5;
        return;
    L5:
        this.d = true;
        vh6.c.b(rq2.a.class).bm(new b());
    }

    public final void onStop() {
        if (this.d == true) goto L5;
        return;
    L5:
        vh6.c.b(rq2.a.class).removeGiftListPreloadCallback();
    }

    public final void a(final int r18, final ca0.w r19, final Map<String, String> r20) {
        final IRoom r3 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.getOwner() == null) goto L8;
        IBaseUser r0 = r3.getOwner();
        Intrinsics.checkNotNull(r0);
        final String r6 = com.bytedance.android.live.base.model.user.o.a(r0);
    L10:
        if (CollectionsKt.listOf(new Integer[]{512, 1024}).contains(1) == true) goto L18;
        a r1 = k;
        r1.getClass();
        if (((Boolean) i.getValue(r1, a.a[0])).booleanValue() == true) goto L18;
        long r10 = r3.getId();
        String r2 = r3.getAnchorId();
        if (r2 != null) goto L16;
        String r13 = BuildConfig.FLAVOR;
    L17:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0.c(r10, r13, 1, r3.getId());
        goto L18
    L16:
        r13 = r2;
    L18:
        long r11 = 0;
        if (r18 == 16) goto L21;
    L23:
        long r14 = 0;
    L25:
        if (r18 == 16) goto L27;
    L44:
        final int r4 = 1;
        v02.b.a(r14, false, new GiftListPreLoadService$syncGiftListForSort$2(this, r19, r3, r4, r18, r6, r20), 6);
        return;
    L27:
        if (((com.bytedance.android.livesdk.gift.configmodel.u0) this.b.getValue()).m() <= 0) goto L44;
        IBaseUser r5 = this.h.getRoom().getOwnerKt();
        if (r5 == null) goto L34;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        String r7 = r5.getCastSecUid();
        if (r7 == null) goto L34;
        String r8 = r7;
    L35:
        String r9 = String.valueOf(r3.getId()) + "_" + r8;
        Long r15 = (Long) ((LinkedHashMap) this.c).get(r9);
        if (r15 == null) goto L39;
        r11 = r15.longValue();
    L39:
        if ((System.currentTimeMillis() - r11) < ((com.bytedance.android.livesdk.gift.configmodel.u0) this.b.getValue()).m()) goto L41;
        this.c.put(r9, Long.valueOf(System.currentTimeMillis()));
        final int r16 = 1;
        final String r17 = r6;
        final String r21 = r8;
        v02.b.a(r14, false, new GiftListPreLoadService$syncGiftListForSort$1(r19, r3, r16, r18, r17, r21, r20), 6);
        return;
    L41:
        return;
    L34:
        r8 = BuildConfig.FLAVOR;
        goto L35
    L21:
        if (i12.m.e2.a() == null) goto L23;
        a r23 = k;
        r23.getClass();
        r14 = ((Number) j.getValue(r23, a.a[1])).longValue();
        goto L25
    L8:
        r6 = BuildConfig.FLAVOR;
        goto L10
    }

    public GiftListPreLoadService(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r3, DataCenter r4, yz0.g r5) {
        Intrinsics.checkNotNullParameter(r2, "recommendReceiverService");
        Intrinsics.checkNotNullParameter(r3, "selectReceiverService");
        Intrinsics.checkNotNullParameter(r4, "mDataCenter");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = LazyKt.lazy(GiftListPreLoadService$liveGiftListPreloadConfig$2.INSTANCE);
        this.b = LazyKt.lazy(GiftListPreLoadService$panelOpenOptConfig$2.INSTANCE);
        this.c = new LinkedHashMap();
    }
}
