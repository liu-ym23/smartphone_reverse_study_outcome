package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductJumpSetting;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.MiniAppMemoryApi;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IStartLiveManager;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/memory/MemoryContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IStartLiveManager$IOnStartClickListener;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MemoryContextService extends OpenPlatformContextService implements IStartLiveManager.IOnStartClickListener {
    public static final /* synthetic */ int c = 0;
    public MemoryStatus a;
    public Disposable b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MemoryContextService a;

        public b(MemoryContextService r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            int r0 = qo0.a.a;
            qo0.a.c("MemoryContextService", "requestMemoryAbilityStatus success, data: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.h) r9.data));
            MemoryContextService r1 = this.a;
            int r2 = ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.h) r9.data).b();
            int r3 = ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.h) r9.data).a();
            boolean r6 = true;
            if (((uc1) ee0.a.getValue()).u() != 1) goto L5;
            int r4 = ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.h) r9.data).d();
        L6:
            r1.a = new MemoryStatus(r2, r3, r4, ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.h) r9.data).c());
            xs2.b r10 = xs2.b.a();
            if (this.a.a.d != (-1)) goto L10;
            r6 = false;
        L10:
            r10.post(new j(r6));
            return;
        L5:
            r4 = -1;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            qo0.a.b("MemoryContextService", "requestMemoryAbilityStatus fail", (Throwable) r3);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.e r2 = (com.bytedance.android.live.network.response.e) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            int r0 = qo0.a.a;
            qo0.a.b("MemoryContextService", "set memory data error " + ((Throwable) r3), null);
        }
    }

    static {
    }

    public final void onStartClicked() {
        qo0.a.c("MemoryContextService", "on start live clicked");
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        IBroadcastService r0 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r0 == null) goto L8;
        IStartLiveManager r1 = r0.startLiveManager();
        if (r1 == null) goto L9;
        r1.removePreStartLiveListener(this);
        return;
    L9:
        return;
    }

    public MemoryContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new MemoryStatus(0);
    }

    public final void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "appId");
        qo0.a.c("MemoryContextService", "requestMemoryAbilityStatus begin");
        Lazy r0 = LiveOpenPlatformClient.c;
        autoDispose(((MiniAppMemoryApi) LiveOpenPlatformClient.a.a().a(MiniAppMemoryApi.class)).getMemoryAbility(getOpenPlatformContext().getRoomId(), r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), c.a));
    }

    public final void g(ShelfInfo r54) {
        int r2 = this.a.a;
        if (r2 != 1) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L90;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        if (r4 == null) goto L91;
        n<MiniAppEntrancePermissionResponse> r5 = r4.getEntranceInfo();
        if (r5 == null) goto L92;
        MiniAppEntrancePermissionResponse r6 = (MiniAppEntrancePermissionResponse) r5.getValue();
        if (r6 != null) goto L17;
        return;
    L17:
        if (r6.getPermit() != true) goto L94;
        String r7 = "";
        if (r54 != null) goto L21;
    L80:
        qo0.a.c("MemoryContextService", "save empty memory data");
        String r8 = "";
    L81:
        Lazy r0 = LiveOpenPlatformClient.c;
        ((MiniAppMemoryApi) LiveOpenPlatformClient.a.a().a(MiniAppMemoryApi.class)).setMemoryData(r8).compose(RxUtil.rxSchedulerHelper()).subscribe(d.a, e.a);
        return;
    L21:
        if (r54.e() == true) goto L80;
        if (r54.d() == true) goto L80;
        qo0.a.c("MemoryContextService", "save memory data");
        Gson r9 = GsonHelper.get();
        String r10 = "extra";
        ko0.a r11 = new ko0.a();
        ShelfMicroAppInfo r12 = r54.appInfo;
        if (r12 == null) goto L27;
        String r13 = r12.appId;
    L28:
        if (r12 == null) goto L30;
        String r14 = r12.name;
    L31:
        if (r12 == null) goto L37;
        ImageModel r15 = r12.icon;
        if (r15 == null) goto L37;
        List r16 = r15.getUrls();
        if (r16 == null) goto L37;
        String r17 = (String) CollectionsKt.firstOrNull(r16);
    L38:
        String r18 = r54.entryPagePath;
        ArrayList r19 = new ArrayList();
        List<ShelfCardInfo> r1 = r54.cardInfoList;
        if (r1 == null) goto L79;
        Iterator r20 = r1.iterator();
    L42:
        if (r20.hasNext() == false) goto L79;
        ShelfCardInfo r21 = (ShelfCardInfo) r20.next();
        String r110 = r21.a0();
        String r111 = r21.I();
        String r112 = r21.F();
        String r113 = r21.E();
        String r22 = r21.D();
        String r23 = r21.M();
        String r24 = r21.i0();
        long r25 = r21.getStatus();
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L49
        String r114 = r21.t();     // Catch: JSONException -> L49
        if (r114 != null) goto L47;
        r114 = r7;
    L47:
        r26.put(r10, new JSONObject(r114).optJSONObject(r10));     // Catch: JSONException -> L49
        Unit r27 = Unit.INSTANCE;     // Catch: JSONException -> L49
        String r28 = r26.toString();     // Catch: JSONException -> L49
    L50:
        ProductInfo r29 = r21.getProductInfo();
        if (r29 == null) goto L77;
        String r30 = r29.productId;
        String r115 = r29.title;
        String r31 = r29.imgUrl;
        List<ProductIntroductionInfo> r32 = r29.introductionList;
        if (r32 == null) goto L59;
        List<ProductIntroductionInfo> r33 = r32;
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r35 = r33.iterator();
    L56:
        if (r35.hasNext() == false) goto L58;
        ProductIntroductionInfo r36 = (ProductIntroductionInfo) r35.next();
        r36.getClass();
        Iterator r210 = r35;
        Gson r38 = r9;
        ko0.a r39 = r11;
        r34.add(new ko0.a.d(r36.content, r36.fontSize, r36.fontColor, r36.introductionType));
        r35 = r210;
        r9 = r38;
        r11 = r39;
        goto L56
    L58:
        Gson r310 = r9;
        ko0.a r311 = r11;
        ArrayList r37 = r34;
    L60:
        List<ProductLabelInfo> r40 = r29.labelList;
        if (r40 == null) goto L67;
        List<ProductLabelInfo> r41 = r40;
        ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator r43 = r41.iterator();
    L64:
        if (r43.hasNext() == false) goto L66;
        ProductLabelInfo r44 = (ProductLabelInfo) r43.next();
        r44.getClass();
        Iterator r211 = r43;
        String r49 = r18;
        String r50 = r17;
        String r51 = r14;
        String r52 = r13;
        r42.add(new ko0.a.f(r44.leftIconList, r44.leftText, r44.rightText, r44.fontSize, r44.fontColor, r44.borderColor, r44.dividingLine, r44.labelType));
        r43 = r211;
        r18 = r49;
        r17 = r50;
        r14 = r51;
        r13 = r52;
        goto L64
    L66:
        String r53 = r13;
        String r55 = r14;
        String r56 = r17;
        String r410 = r18;
        ArrayList r312 = r42;
    L68:
        ProductPriceInfo r45 = r29.price;
        if (r45 == null) goto L71;
        ko0.a.g r313 = new ko0.a.g(r45.originalPrice, r45.currentPrice, r45.currentPrefix, r45.currentSuffix);
    L72:
        String r46 = r29.actionText;
        boolean r47 = r29.isShow;
        ProductJumpSetting r48 = r29.jumpSetting;
        if (r48 == null) goto L75;
        ko0.a.e r314 = new ko0.a.e(r48.isJumpToOtherPage, r48.jumpToOtherPageAppId, r48.jumpToOtherPagePath, r48.jumpToOtherPageQuery);
    L76:
        ko0.a.c r212 = new ko0.a.c(r30, r115, r31, r37, r312, r313, r46, r47, r314);
    L78:
        r19.add(new ko0.a.h(r110, r111, r112, r113, r22, r23, r24, r25, r28, r212, r21.b(), r21.S(), r21.o0(), r21.j0(), r21.b0(), r21.z(), r21.c0()));
        r20 = r20;
        r7 = r7;
        r10 = r10;
        r9 = r310;
        r11 = r311;
        r18 = r410;
        r17 = r56;
        r14 = r55;
        r13 = r53;
        goto L42
    L75:
        r314 = null;
        goto L76
    L71:
        r313 = null;
        goto L72
    L67:
        r53 = r13;
        r55 = r14;
        r56 = r17;
        r410 = r18;
        r312 = null;
        goto L68
    L59:
        r310 = r9;
        r311 = r11;
        r37 = null;
        goto L60
    L77:
        r7 = r7;
        r310 = r9;
        r10 = r10;
        r311 = r11;
        r53 = r13;
        r55 = r14;
        r56 = r17;
        r410 = r18;
        r212 = null;
    L49:
        r28 = null;
    L79:
        ko0.a r315 = r11;
        Unit r57 = Unit.INSTANCE;
        r315.a(new ko0.a.i(r13, r14, r17, r18, r19));
        r8 = GsonProtectorUtils.toJson(r9, r315);
    L37:
        r17 = null;
        goto L38
    L30:
        r14 = null;
        goto L31
    L27:
        r13 = null;
        goto L28
    L94:
        return;
    L92:
        return;
    L91:
        return;
    L90:
        return;
    L5:
        if (r2 == 2) goto L8;
        r3 = false;
        goto L9
    }

    public final void i(int r11, final boolean r12) {
        int r2 = 2;
        int r3 = 1;
        if (r11 == 1) goto L24;
        if (r11 == 2) goto L20;
        if (r11 == 3) goto L16;
        if (r11 == 4) goto L11;
        return;
    L11:
        if (r12 == false) goto L13;
        int r7 = 2;
    L14:
        int r4 = r7;
        h(this, 0, 0, 0, r4, new MemoryContextService$updateMemoryStatus$4(this, r12), 7);
        return;
    L13:
        r7 = 1;
        goto L14
    L16:
        if (r12 == false) goto L18;
        r3 = 2;
    L18:
        h(this, 0, 0, r3, 0, new MemoryContextService$updateMemoryStatus$3(this, r12), 11);
        return;
    L20:
        if (r12 == true) goto L23;
        r2 = 1;
    L23:
        h(this, 0, r2, 0, 0, new MemoryContextService$updateMemoryStatus$2(this, r12), 13);
        return;
    L24:
        if (r12 == true) goto L27;
        r2 = 1;
    L27:
        int r1 = r2;
        h(this, r1, 0, 0, 0, new MemoryContextService$updateMemoryStatus$1(this, r12), 14);
    }

    public static void h(MemoryContextService r9, int r10, int r11, int r12, int r13, Function0 r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        int r5 = -1;
    L7:
        if ((r15 & 2) == 0) goto L9;
        int r6 = -1;
    L11:
        if ((r15 & 4) == 0) goto L13;
        int r7 = -1;
    L15:
        if ((r15 & 8) == 0) goto L17;
        int r8 = -1;
    L18:
        r9.getClass();
        int r16 = qo0.a.a;
        qo0.a.c("MemoryContextService", "updateMemoryAbilityStatus begin, remember miniApp=" + r5 + ", remember card=" + r6 + ", show live data=" + r7);
        Lazy r17 = LiveOpenPlatformClient.c;
        ((MiniAppMemoryApi) LiveOpenPlatformClient.a.a().a(MiniAppMemoryApi.class)).updateMemoryAbility(r9.getOpenPlatformContext().getRoomId(), r5, r6, r7, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.openplatform.impl.miniappanchor.memory.c(r14), com.bytedance.android.live.openplatform.impl.miniappanchor.memory.d.a);
        return;
    L17:
        r8 = r13;
        goto L18
    L13:
        r7 = r12;
        goto L15
    L9:
        r6 = r11;
        goto L11
    L5:
        r5 = r10;
        goto L7
    }
}
