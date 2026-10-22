package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.dress.u;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.enteranim.view.EnterAnimationView;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.BuildConfig;
import ec2.x0;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RevenueUtils {
    public static final b i = null;
    public final CompositeDisposable a;
    public final Lazy b;
    public final Lazy c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public final Map<Long, List<SingleEmitter<Pair<com.bytedance.android.live.core.resources.e, Boolean>>>> g;
    public final d h;

    public static final class a {
        public final String a;
        public final com.bytedance.android.live.core.resources.e b;
        public final long c;
        public final long d;
        public final boolean e;
        public final boolean f;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L18;
            a r7 = (a) r6;
            if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (this.d == r7.d) goto L14;
            return false;
        L14:
            if (this.e == r7.e) goto L16;
            return false;
        L16:
            if (this.f == r7.f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            com.bytedance.android.live.core.resources.e r4 = this.b;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (r3 + r1) * 31;
            long r6 = this.c;
            int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
            long r8 = this.d;
            int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
            boolean r10 = this.e;
            ?? r11 = 1;
            ?? r13 = r10;
            if (r10 == false) goto L12;
            r13 = 1;
        L12:
            int r14 = (r9 + r13) * 31;
            boolean r15 = this.f;
            if (r15 == true) goto L17;
            r11 = r15;
        L17:
            return r14 + r11;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "AssetDownloadInfo(path=" + this.a + ", model=" + this.b + ", startTime=" + this.c + ", downloadDuration=" + this.d + ", syncFromRemote=" + this.e + ", downloadFromRemote=" + this.f + ")";
        }

        public a(String r2, com.bytedance.android.live.core.resources.e r3, long r4, long r6, boolean r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "model");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r8;
            this.f = r9;
        }
    }

    public static final class b {
        public b() {
        }

        public static JSONObject a(k32.a r3) {
            JSONObject r0 = new JSONObject();
            if (r3 == null) goto L8;
            va.a r4 = r3.k;
            if (r4 == null) goto L8;
            BaseMonitor.add(r0, "anim_asset_id", String.valueOf(r4.getAnimAssetId()));
            BaseMonitor.add(r0, "center_anim_asset_id", String.valueOf(r4.getCenterAnimAssetId()));
            BaseMonitor.add(r0, "mp4_anim_asset_id", String.valueOf(r4.a()));
        L8:
            return r0;
        }

        @JvmStatic
        public static void f(k32.a r10) {
            Intrinsics.checkNotNullParameter(r10, "msg");
            String r0 = r10.a;
            if (r0 != null) goto L5;
        L19:
            va.a r1 = r10.k;
            if (r1 != null) goto L22;
            return;
        L22:
            String r3 = r1.getDressId();
            if (r3 != null) goto L25;
            return;
        L25:
            com.bytedance.android.live.profit.dress.l r4 = yt0.c.a().getDressData(r3, 2, "RevenueUtilsKt.prepareDressProfilePreview");
            if (r4 != null) goto L28;
            return;
        L28:
            com.bytedance.android.live.profit.dress.config.h r5 = r4.n;
            if (r5 != null) goto L31;
            return;
        L31:
            com.bytedance.android.live.profit.player.d r6 = yt0.c.h();
            if (r6 != null) goto L34;
            return;
        L34:
            Map r2 = r1.l();
            if (r2 != null) goto L38;
            return;
        L38:
            if (r5.getProfilePreviewAssetId() > 0) goto L40;
            return;
        L40:
            uu0.b.a r7 = new uu0.b.a(r5, r4, r2, r10.c);
            ((uu0.b) r7).a.put("wear_id", r3);
            Unit r11 = Unit.INSTANCE;
            r6.no(r7);
            return;
        L5:
            if (r0.length() <= 0) goto L7;
            boolean r8 = true;
        L8:
            if (r8 != true) goto L19;
            String r9 = r10.a;
            IRoomContextService r13 = jc1.k.f(IRoomContextService.class);
            String r14 = null;
            if (r13 == null) goto L17;
            com.bytedance.android.livesdk.chatroom.o r15 = IRoomContextService.a.a(r13, null, 0, 3);
            if (r15 == null) goto L17;
            User r16 = r15.getUser();
            if (r16 == null) goto L17;
            r14 = r16.getIdString();
        L17:
            if (Intrinsics.areEqual(r9, r14) == false) goto L19;
            return;
        L7:
            r8 = false;
            goto L8
        }

        public static boolean c(k32.a r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "$this$isSelfMessage");
            String r3 = r1.a;
            if (r2 != null) goto L11;
            IMiddlewareUserService r4 = jc1.k.f(IMiddlewareUserService.class);
            if (r4 == null) goto L9;
            com.bytedance.android.livesdk.user.e r5 = r4.user();
            if (r5 == null) goto L9;
            r2 = r5.n();
        L9:
            r2 = null;
        L11:
            return Intrinsics.areEqual(r3, r2);
        }

        public static com.bytedance.android.live.profit.player.k.a b(int r2, int r3, int r4) {
            int r0 = Math.min(s1.y(), s1.f(((Float) x0.a.getValue()).floatValue()));
            int r5 = (r3 * r0) / r2;
            return new com.bytedance.android.live.profit.player.k.a(r4 - (r5 / 2), r0, r5);
        }

        public static /* synthetic */ void e(b r1, k32.a r2, String r3, JSONObject r4) {
            r1.getClass();
            d(r2, r3, false, null, r4);
        }

        public static void d(k32.a r16, String r17, boolean r18, String r19, JSONObject r20) {
            Intrinsics.checkNotNullParameter(r16, "msg");
            Intrinsics.checkNotNullParameter(r17, "step");
            IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
            if (r1 == null) goto L7;
            com.bytedance.android.livesdk.user.e r2 = r1.user();
            if (r2 == null) goto L7;
            String r8 = r2.n();
        L9:
            if (c(r16, r8) == true) goto L11;
            return;
        L11:
            IRoomContextService r3 = jc1.k.f(IRoomContextService.class);
            if (r3 == null) goto L18;
            com.bytedance.android.livesdk.chatroom.o r4 = IRoomContextService.a.a(r3, null, 0, 3);
            if (r4 == null) goto L18;
            com.bytedance.live.datacontext.m r5 = r4.getRoom();
            if (r5 == null) goto L18;
            IRoom r6 = (IRoom) r5.getValue();
        L19:
            StringBuilder r7 = new StringBuilder();
            va.a r9 = r16.k;
            if (r9 == null) goto L22;
            int r10 = r9.getType();
        L23:
            r7.append(r10);
            r7.append('_');
            va.a r11 = r16.k;
            if (r11 == null) goto L27;
            String r13 = r11.getDressId();
            if (r13 == null) goto L27;
        L28:
            r7.append(r13);
            r7.append('_');
            r7.append(System.currentTimeMillis());
            String r14 = r7.toString();
            ALogger.d("RevenueUtils", "[trace user enter] step=" + r17 + ", error=" + r19 + ", message=" + r16.q);
            if (r6 == null) goto L31;
            String r15 = r6.getAnchorId();
        L32:
            if (r6 == null) goto L34;
            String r110 = r6.getIdStr();
        L35:
            TraceMonitor.h(new com.bytedance.android.live.core.monitor.trace.e("ttlive_privilege_user_enter", "user_enter", r14, "webcast_client_privilege_user_enter", r17, r110, r15, r8, Integer.valueOf(r18 ? 1 : 0), r19, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message_id", Long.valueOf(r16.q))}), 8), r20);
            return;
        L34:
            r110 = null;
            goto L35
        L31:
            r15 = null;
        L27:
            r13 = BuildConfig.FLAVOR;
            goto L28
        L22:
            r10 = -1;
        L18:
            r6 = null;
        L7:
            r8 = null;
            goto L9
        }
    }

    public static final class c {
        public final long a;
        public final int b;
        public final String c;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof c) == false) goto L12;
            c r7 = (c) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
            String r2 = this.c;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r1 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public final String toString() {
            return "ResourceInfo(assetId=" + this.a + ", assetType=" + this.b + ", dressId=" + this.c + ")";
        }

        public c(long r1, String r3) {
            this.a = r1;
            this.b = 4;
            this.c = r3;
        }
    }

    public static final class d implements IAssetsManager.b {
        public final /* synthetic */ RevenueUtils a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public d(RevenueUtils r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r6) {
            Intrinsics.checkNotNullParameter(r6, "assetsModels");
            Iterator r7 = ((LinkedHashMap) this.a.g).entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L12;
            Map.Entry r0 = (Map.Entry) r7.next();
            long r1 = ((Number) r0.getKey()).longValue();
            List r2 = (List) r0.getValue();
            com.bytedance.android.live.core.resources.e r3 = this.a.c().G1(r1);
            if (r3 == null) goto L4;
            ALogger.i("RevenueUtils", "asset model synced id=" + r3.getId());
            Iterator r4 = r2.iterator();
        L9:
            if (r4.hasNext() == false) goto L11;
            ((SingleEmitter) r4.next()).onSuccess(TuplesKt.to(r3, Boolean.TRUE));
            goto L9
        L11:
            r2.clear();
            goto L4
        }
    }

    public final IAssetsManager c() {
        return (IAssetsManager) this.b.getValue();
    }

    static {
        i = new b();
    }

    public RevenueUtils() {
        this.a = new CompositeDisposable();
        this.b = LazyKt.lazy(RevenueUtils$assetsManager$2.INSTANCE);
        this.c = LazyKt.lazy(RevenueUtils$dressService$2.INSTANCE);
        this.e = LazyKt.lazy(RevenueUtils$isAnchor$2.INSTANCE);
        this.f = LazyKt.lazy(RevenueUtils$syncAssetParamsFixed$2.INSTANCE);
        this.g = new LinkedHashMap();
        this.h = new d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void e(EnterAnimationView r5, k32.a r6) {
        i.getClass();
        va.a r7 = r6.k;
        if (r5 != 0) goto L5;
        return;
    L5:
        if (r5.getContext() == null) goto L29;
        if (r7 == null) goto L31;
        HashMap r8 = new HashMap();
        py.k r0 = r7.getTextIconOverlay();
        String r1 = "1";
        if (r0 != null) goto L11;
    L13:
        Object r2 = "0";
    L14:
        r8.put("text_icon_overlay", r2);
        r8.put("center_asse_id", String.valueOf(r7.getCenterAnimAssetId()));
        py.k r3 = r7.getDynamicImage();
        if (r3 != null) goto L17;
    L19:
        r1 = "0";
    L20:
        r8.put("dynamic_image", r1);
        r8.put("mp4_anim_asset_id", String.valueOf(r7.a()));
        if (r7.getDressId() == null) goto L23;
        boolean r4 = true;
    L24:
        r8.put("is_dress", String.valueOf(r4));
        r8.put("dress_id", String.valueOf(r7.getDressId()));
        r8.put("enter_type", String.valueOf(r7.getType()));
        IPerformanceManager r9 = jc1.k.f(IPerformanceManager.class);
        if (r9 == null) goto L30;
        r9.onModuleStart("user_enter", r8);
        return;
    L30:
        return;
    L23:
        r4 = false;
        goto L24
    L17:
        if (r3.isValid() == false) goto L19;
    L11:
        if (r0.isValid() == false) goto L13;
        r2 = "1";
        goto L14
    L31:
        return;
    }

    public final boolean d(k32.a r17, g r18) {
        Intrinsics.checkNotNullParameter(r17, "msg");
        Intrinsics.checkNotNullParameter(r18, "resLoadListener");
        if ((r17 instanceof k32.c) == false) goto L9;
        k32.c r6 = (k32.c) r17;
        u r1 = ((zt0.e) this.c.getValue()).getDressData(r6.u, 23, "RevenueUtils.getAssetIdToLoad-OpenAsset");
        if (r1 == null) goto L48;
        long r7 = r1.a;
        if (r7 == 0) goto L48;
        c r2 = new c(r7, r6.u);
    L50:
        if (r2 != null) goto L53;
        ALogger.w("RevenueUtils", "no resource to load");
        return false;
    L53:
        long r13 = r2.a;
        int r8 = r2.b;
        String r14 = r2.c;
        if (r13 > 0) goto L58;
        ALogger.w("RevenueUtils", "no resource to load");
        return false;
    L58:
        if (r2.a(r14) == false) goto L62;
        String r3 = "dress_resource_load";
    L60:
        String r15 = r3;
        i.getClass();
        boolean r4 = b.c(r17, null);
        com.bytedance.android.live.core.resources.e r5 = c().G1(r13);
        if (r5 == null) goto L68;
        Single r9 = Single.just(TuplesKt.to(r5, Boolean.FALSE));
    L69:
        RxUtilKt.c(r9.flatMap(new j(this, r13, r4)).subscribe(new k(r13, r17, r15, r14, r18, r8), new l(r13, r17, r15, r14, r18)), this.a);
        return true;
    L68:
        r9 = Single.create(new h(this, r13));
        goto L69
    L62:
        if (r8 != 4) goto L64;
        r3 = "mp4_load";
        goto L60
    L64:
        r3 = "other_resource_load";
    L48:
        r2 = null;
        goto L50
    L9:
        va.a r10 = r17.k;
        if (r10 == null) goto L48;
        String r11 = r10.getDressId();
        if (r10.a() == 0) goto L15;
    L26:
        if (r11 != null) goto L28;
    L31:
        boolean r16 = true;
    L32:
        if (r16 == true) goto L39;
        com.bytedance.android.live.profit.dress.l r19 = ((zt0.e) this.c.getValue()).getDressData(r11, 2, "RevenueUtils.getAssetIdToLoad");
        if (r19 == null) goto L39;
        long r20 = r19.j;
        if (r20 == 0) goto L39;
        r2 = new c(r20, r11);
    L39:
        if (r10.a() == 0) goto L43;
        c r21 = new c(r10.a(), null);
    L41:
        r2 = r21;
        goto L50
    L43:
        if (r10.getCenterAnimAssetId() == 0) goto L46;
        r21 = new c(r10.getCenterAnimAssetId(), null);
        goto L41
    L46:
        if (r10.getAnimAssetId() == 0) goto L48;
        r21 = new c(r10.getAnimAssetId(), null);
        goto L41
    L28:
        if (r11.length() == 0) goto L31;
        r16 = false;
        goto L32
    L15:
        if (r10.getCenterAnimAssetId() != 0) goto L26;
        if (r10.getAnimAssetId() != 0) goto L26;
        if (r11 != null) goto L20;
    L23:
        boolean r23 = true;
    L24:
        if (r23 == false) goto L26;
    L20:
        if (r11.length() == 0) goto L23;
        r23 = false;
        goto L24
    }

    @JvmStatic
    public static final void a(String r2, View r3, k32.a r4, long r5) {
        i.getClass();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getContext() == null) goto L11;
        if (r4 == null) goto L12;
        long r0 = SystemClock.uptimeMillis() - r5;
        JSONObject r6 = b.a(r4);
        BaseMonitor.add(r6, "status", 0);
        BaseMonitor.add(r6, "anim_type", r2);
        JSONObject r7 = new JSONObject();
        BaseMonitor.add(r7, "duration", r0);
        boolean r8 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(yt0.b.class).getPrivilegeSlardarMonitor().j(r6, r7, r4.a);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void b(long r2, int r4, long r5, boolean r7, int r8, String r9, k32.a r10, EnterAnimationView r11) {
        i.getClass();
        if (r11 != 0) goto L5;
        return;
    L5:
        if (r11.getContext() == null) goto L11;
        if (r10 == null) goto L12;
        long r0 = SystemClock.uptimeMillis() - r5;
        JSONObject r6 = b.a(r10);
        BaseMonitor.add(r6, "status", r8);
        BaseMonitor.add(r6, "status_msg", r9);
        BaseMonitor.add(r6, "load_resource_id", r2);
        BaseMonitor.add(r6, "assets_type", r4);
        BaseMonitor.add(r6, "assets_is_downloaded", String.valueOf(r7));
        JSONObject r3 = new JSONObject();
        BaseMonitor.add(r3, "duration", r0);
        boolean r13 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(yt0.b.class).getPrivilegeSlardarMonitor().c(r6, r3, r10.a);
        return;
    L12:
        return;
    }
}
