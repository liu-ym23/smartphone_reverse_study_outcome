package com.bytedance.android.live.openplatform.impl.miniappanchor.context;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.api.utils.h;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorShelfAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.coupon.AnchorCouponContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.coupon.d;
import com.bytedance.android.live.openplatform.impl.miniappanchor.debug.MiniAppAnchorDebugContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.debug.e;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincard.AnchorExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.im.AnchorImContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.important.AnchorImportantCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.memory.MemoryContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.openapi.MiniAppAnchorOpenApiHandler;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.LiveAnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.bridge.BridgeContextService;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import e33.l;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import rp0.f;
import rp0.g;
import rp0.i;
import sp0.c;
import yo0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B#\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R.\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/context/LiveAnchorMiniAppContext;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/context/AnchorMiniAppContext;", "", "initParams", "", "preMount", "onCreate", "Lro0/a;", "manager", "onMessageManagerInitialized", "onDestroy", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "instance", "onMiniAppInstanceCreate", "onMiniAppInstanceDestroy", "Lyo0/b;", "<set-?>", "openApiService", "Lyo0/b;", "getOpenApiService", "()Lyo0/b;", "setOpenApiService", "(Lyo0/b;)V", "isInLive", "Z", "()Z", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/view/ViewGroup;", "containerView", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Landroid/view/ViewGroup;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorMiniAppContext extends AnchorMiniAppContext {
    public static final a Companion = null;
    private static final String TAG = "LiveAnchorMiniAppContext";
    private final boolean isInLive;
    private b openApiService;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext, com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext, com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onDestroy() {
        MemoryContextService r0 = (MemoryContextService) getService(MemoryContextService.class);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r1 = AnchorMiniAppDataContext.a.a();
        if (r1 == null) goto L7;
        n<ShelfInfo> r2 = r1.m618getShelfInfo();
        if (r2 == null) goto L7;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
    L8:
        r0.g(r3);
        ((AnchorShelfAppLogContextService) getService(AnchorShelfAppLogContextService.class)).reportWhenEndLive();
        super.onDestroy();
        return;
    L7:
        r3 = null;
        goto L8
    }

    private final void initParams() {
        Context r0 = getContext();
        Serializable r2 = null;
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 == null) goto L8;
        Intent r3 = r1.getIntent();
    L9:
        MemoryContextService r4 = (MemoryContextService) getService(MemoryContextService.class);
        r4.getClass();
        int r5 = 0;
        if (r3 == null) goto L13;
        MemoryStatus r6 = (MemoryStatus) r3.getParcelableExtra("extra_mini_app_memory_switch_status");
        if (r6 == null) goto L13;
    L14:
        r4.a = r6;
        int r7 = qo0.a.a;
        qo0.a.c("MemoryContextService", "init, memory status: " + r4.a);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r8 = AnchorMiniAppDataContext.a.a();
        if (r8 == null) goto L29;
        n<MiniAppEntrancePermissionResponse> r9 = r8.getEntranceInfo();
        if (r9 == null) goto L29;
        if (r3 == null) goto L20;
        Serializable r10 = r3.getSerializableExtra("extra_mini_app_entrance_info");
    L22:
        if ((r10 instanceof MiniAppEntrancePermissionResponse) == false) goto L25;
        r2 = r10;
    L25:
        MiniAppEntrancePermissionResponse r11 = (MiniAppEntrancePermissionResponse) r2;
        if (r11 != null) goto L28;
        r11 = new MiniAppEntrancePermissionResponse();
    L28:
        r9.setValue(r11);
        goto L29
    L20:
        r10 = null;
    L29:
        AnchorMiniAppDataContext r12 = AnchorMiniAppDataContext.a.a();
        if (r12 == null) goto L37;
        m<Boolean> r13 = r12.getSupportComponentCoexist();
        if (r13 == null) goto L37;
        if (r3 == null) goto L35;
        boolean r14 = r3.getBooleanExtra("extra_mini_app_support_component_coexist", false);
    L36:
        r13.setValue(Boolean.valueOf(r14));
        goto L37
    L35:
        r14 = false;
    L37:
        AnchorMiniAppDataContext r15 = AnchorMiniAppDataContext.a.a();
        if (r15 == null) goto L45;
        m<Integer> r16 = r15.getCoexistComponentBeforeStart();
        if (r16 == null) goto L46;
        if (r3 == null) goto L43;
        r5 = r3.getIntExtra("extra_mini_app_coexist_component_before_start", 0);
    L43:
        r16.setValue(Integer.valueOf(r5));
        return;
    L46:
        return;
    L45:
        return;
    L13:
        r6 = new MemoryStatus(0);
        goto L14
    L8:
        r3 = null;
        goto L9
    }

    private final boolean preMount() {
        Room r0 = getRoom();
        ShelfInfo r1 = null;
        if (r0 == null) goto L7;
        List r2 = r0.getRoomStamps();
        if (r2 == null) goto L7;
        RoomStampInfo r3 = (RoomStampInfo) CollectionsKt.firstOrNull(r2);
    L9:
        if (r3 != null) goto L11;
    L13:
        Context r4 = getContext();
        if ((r4 instanceof Activity) == true) goto L16;
        r4 = null;
    L16:
        Activity r5 = (Activity) r4;
        if (r5 == null) goto L21;
        Intent r6 = r5.getIntent();
        if (r6 == null) goto L21;
        r1 = (ShelfInfo) r6.getParcelableExtra("extra_mini_app_mounted_params");
    L21:
        ShelfInfo r7 = r1;
        int r8 = qo0.a.a;
        qo0.a.c(TAG, "preMount params: " + r7);
        if (r7 == null) goto L25;
        AnchorShelfContextService.modifyShelf$default((AnchorShelfContextService) getService(AnchorShelfContextService.class), r7, true, null, null, 12, null);
        return true;
    L25:
        return false;
    L11:
        if (r3.getType() != 4) goto L13;
        return false;
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext, com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        qo0.a.c(TAG, "onCreate");
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        po0.a.C0252a r0 = ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a();
        setMiniAppAnchorService((so0.a) r0.a.b.get());
        setOpenApiService((b) r0.a.c.get());
        l[] r1 = m13.a.a;
        com.bytedance.android.scope.m r2 = com.bytedance.android.scope.m.e;
        m13.a r3 = m13.a.b;
        r2.getClass();
        com.bytedance.android.scope.m.e(r3);
        initParams();
        boolean r4 = preMount();
        ((LiveAnchorShelfContextService) getService(LiveAnchorShelfContextService.class)).initShelfInfo(r4);
        ((AnchorCouponContextService) getService(AnchorCouponContextService.class)).g();
        ((AnchorExplainCardContextService) getService(AnchorExplainCardContextService.class)).f();
        ((AnchorImportantCardContextService) getService(AnchorImportantCardContextService.class)).f();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext, com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext
    public void onMiniAppInstanceDestroy() {
        super.onMiniAppInstanceDestroy();
        if (((uc1) ee0.a.getValue()).c() == true) goto L13;
        b r0 = this.openApiService;
        if (r0 == null) goto L14;
        MiniAppInstance r1 = getMiniAppInstance();
        if (r1 == null) goto L10;
        String r2 = r1.getAppId();
        if (r2 == null) goto L10;
    L11:
        r0.d(r2);
        return;
    L10:
        r2 = "";
        goto L11
    L14:
        return;
    }

    public final b getOpenApiService() {
        return this.openApiService;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isInLive() {
        return this.isInLive;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onMessageManagerInitialized(ro0.a r9) {
        Intrinsics.checkNotNullParameter(r9, "manager");
        super.onMessageManagerInitialized(r9);
        AnchorImContextService r2 = (AnchorImContextService) getService(AnchorImContextService.class);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "manager");
        Intrinsics.checkNotNullParameter(r9, "manager");
        r9.a(new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.a(r2.getOpenPlatformContext()));
        r9.a(new d(r2.getOpenPlatformContext()));
        r9.a(new sp0.a(r2.getOpenPlatformContext()));
        r9.a(new sp0.b(r2.getOpenPlatformContext()));
        boolean r3 = true;
        if (((uc1) ee0.a.getValue()).u() != 1) goto L5;
        r9.a(new c(r2.getOpenPlatformContext()));
    L5:
        MiniAppAnchorDebugContextService r10 = (MiniAppAnchorDebugContextService) getService(MiniAppAnchorDebugContextService.class);
        Pair[] r1 = new Pair[1];
        Object r7 = null;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L12;
        j r5 = r4.getPreviewSourceParam();
        if (r5 == null) goto L12;
        PreviewSourceParam r6 = (PreviewSourceParam) r5.getValue();
        if (r6 == null) goto L12;
        String r8 = r6.getOriginalRawString();
    L13:
        r1[0] = TuplesKt.to("source_params", r8);
        Map r11 = MapsKt.mutableMapOf(r1);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "extraParams");
        Intrinsics.checkNotNullParameter(r11, "extraParams");
        Object r12 = r11.get("source_params");
        if ((r12 instanceof String) == false) goto L17;
        r7 = r12;
    L17:
        String r13 = (String) r7;
        String r14 = "";
        if (r13 != null) goto L61;
        r13 = "";
    L61:
        JSONObject r15 = new JSONObject(r13);     // Catch: JSONException -> L60
        String r16 = JSONObjectProtectorUtils.getString(r15, "timor_schema");     // Catch: JSONException -> L60
        Intrinsics.checkNotNullParameter(r16, "<set-?>");     // Catch: JSONException -> L60
        r10.a = r16;     // Catch: JSONException -> L60
        String r17 = JSONObjectProtectorUtils.getString(r15, "open_type");     // Catch: JSONException -> L60
        String r18 = JSONObjectProtectorUtils.getString(r15, "enter_from");     // Catch: JSONException -> L60
        if (h.d(r10.a) == true) goto L25;
        return;
    L25:
        if (r10.a.length() != 0) goto L27;
        boolean r19 = true;
    L28:
        if (r19 == false) goto L30;
    L58:
        f2.c(s1.B(2131920847), 0);
        return;
    L30:
        if (r17.length() != 0) goto L32;
        boolean r20 = true;
    L33:
        if (r20 == true) goto L58;
        if (r18.length() == 0) goto L38;
        r3 = false;
    L38:
        if (r3 == true) goto L58;
        SchemaInfo.b r21 = SchemaInfo.s;
        String r22 = r10.a;
        r21.getClass();
        SchemaInfo r23 = SchemaInfo.b.b(r22);
        if (r23 == null) goto L68;
        String r24 = r23.a();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r10.b = r24;
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter("", MultiLinkOpenSource.DEFAULT);
        String r25 = UriProtector.getQueryParameter(r23.o, "url");     // Catch: Exception -> L48
        if (r25 == null) goto L49;
        r14 = r25;
    L49:
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        ro0.a r0 = r10.getOpenPlatformContext().getMessageManager();
        if (r0 == null) goto L52;
        r0.a(new MiniAppAnchorDebugContextService.c(r10));
    L52:
        Disposable r26 = r10.c;
        if (r26 == null) goto L55;
        r26.dispose();
    L55:
        Disposable r27 = Observable.timer(1, TimeUnit.MINUTES).compose(RxUtil.rxSchedulerHelper()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.openplatform.impl.miniappanchor.debug.d(r10), new e(r10));
        r10.c = r27;
        if (r27 == null) goto L65;
        r10.autoDispose(r27);
        return;
    L65:
        return;
    L68:
        return;
    L32:
        r20 = false;
        goto L33
    L27:
        r19 = false;
    L69:
        return;
    L12:
        r8 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext, com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext
    public void onMiniAppInstanceCreate(MiniAppInstance r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        super.onMiniAppInstanceCreate(r3);
        if (((uc1) ee0.a.getValue()).c() == true) goto L7;
        b r0 = this.openApiService;
        if (r0 == null) goto L7;
        r0.b(new MiniAppAnchorOpenApiHandler(this, r3.getAppId()));
    L7:
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_app_resume", new i(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_mini_app_stop", new rp0.a(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_update_screen_page", new rp0.j(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_start_cast", new rp0.d(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_stop_cast", new rp0.e(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_error", new rp0.c(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("is_live_casting", new rp0.b(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_cast_button_show", new g(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_cast_button_click", new f(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_cast_dialog_action", new rp0.h(this));
    }

    @Inject
    public final void setOpenApiService(b r1) {
        this.openApiService = r1;
    }

    public LiveAnchorMiniAppContext(Context r2, DataCenter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.isInLive = true;
    }
}
