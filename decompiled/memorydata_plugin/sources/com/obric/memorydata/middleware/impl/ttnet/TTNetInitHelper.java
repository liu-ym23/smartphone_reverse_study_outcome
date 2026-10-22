package com.obric.memorydata.middleware.impl.ttnet;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.utility.h;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.AppConfig;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.api.ttnet.ITTNetInitHelper;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.az;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/middleware/impl/ttnet/TTNetInitHelper;", "Lcom/obric/memorydata/middleware/api/ttnet/ITTNetInitHelper;", "<init>", "()V", "uxpEnable", "", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "initTTNet", "", "context", "Landroid/content/Context;", "application", "Landroid/app/Application;", "sMonitorProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "packageRequestParamters", "info", "jsonObject", "Lorg/json/JSONObject;", "Companion", "InnerApiProcessHook", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TTNetInitHelper implements ITTNetInitHelper {
    private static final String COMMON_PARAM_USER_EXPERIENCE_ENABLE = "user_experience_enable";
    public static final a Companion = null;
    private static final String TAG = "TTNetInitHelper";
    private final f.l<com.bytedance.ttnet.b.b> sMonitorProcessHook;
    private final Lazy store$delegate;
    private boolean uxpEnable;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/impl/ttnet/TTNetInitHelper$Companion;", "", "<init>", "()V", "TAG", "", "COMMON_PARAM_USER_EXPERIENCE_ENABLE", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J1\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00152\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d\"\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/middleware/impl/ttnet/TTNetInitHelper$InnerApiProcessHook;", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "context", "Landroid/content/Context;", "<init>", "(Lcom/obric/memorydata/middleware/impl/ttnet/TTNetInitHelper;Landroid/content/Context;)V", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "handleApiError", "", "url", "", "e", "", OaidModel.KEY_TIME, "", "info", "handleApiOk", "addCommonParams", "isApi", "", "getCommonParamsByLevel", "", "level", "", "addRequestVertifyParams", "isAddCommonParam", WsConstants.KEY_EXTRA, "", "", "(Ljava/lang/String;Z[Ljava/lang/Object;)Ljava/lang/String;", "putCommonParams", TrackerImpl.PARAMS, "onTryInit", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class b implements f.d<com.bytedance.ttnet.b.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TTNetInitHelper f11873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f11874b;
        private final IStore c;

        public b(TTNetInitHelper r4, Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "context");
            this.f11873a = r4;
            this.f11874b = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            this.c = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.d
        public String a(String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "url");
            String r5 = AppLog.addNetCommonParams(this.f11874b, r3, r4, Level.L1);
            Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            if (TTNetInitHelper.access$getUxpEnable$p(this.f11873a) == false) goto L5;
            String r2 = "1";
        L6:
            r6.put(TTNetInitHelper.COMMON_PARAM_USER_EXPERIENCE_ENABLE, r2);
            r6.put("security_aid", "ocean_memorydata");
            r6.put("device_id", AppContext.INSTANCE.getServerDeviceId());
            com.obric.aiagent.product.feature.a.a r7 = am.f13169a.b();
            if (r7 == null) goto L10;
            String r8 = r7.d();
            if (r8 == null) goto L10;
        L11:
            r6.put("flow_app_variant", r8);
            String r9 = AppContext.INSTANCE.getIid();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
            boolean r0 = true;
        L15:
            if (r0 == false) goto L17;
            r6.put("iid", r9);
        L17:
            Uri r10 = az.a(r5);
            if (r10 == null) goto L20;
            Uri r11 = az.a(r10, r6);
        L22:
            return String.valueOf(r11);
        L20:
            r11 = null;
            goto L22
        L14:
            r0 = false;
        L10:
            r8 = "obric";
            goto L11
        L5:
            r2 = "2";
            goto L6
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.d
        public String a(String r1, boolean r2, Object... r3) {
            Intrinsics.checkNotNullParameter(r1, "url");
            Intrinsics.checkNotNullParameter(r3, WsConstants.KEY_EXTRA);
            return r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.d
        public Map<String, String> a(int r2) {
            return (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.d
        public void a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/middleware/impl/ttnet/TTNetInitHelper$initTTNet$1", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "onKeyChanged", "", "repoName", "", "key", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.middleware.api.store.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TTNetInitHelper f11875a;

        c(TTNetInitHelper r1) {
            this.f11875a = r1;
        }

        @Override // com.obric.memorydata.middleware.api.store.b
        public void onKeyChanged(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "repoName");
            Intrinsics.checkNotNullParameter(r3, "key");
            if (Intrinsics.areEqual(r3, "memory_user_experience") == false) goto L6;
            TTNetInitHelper r1 = this.f11875a;
            TTNetInitHelper.access$setUxpEnable$p(r1, TTNetInitHelper.access$getStore(r1).getBoolean("memory_user_experience", false));
            return;
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J6\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/middleware/impl/ttnet/TTNetInitHelper$sMonitorProcessHook$1", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "monitorApiError", "", "duration", "", "sendTime", "url", "", "traceCode", "info", "e", "", "monitorApiOk", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements f.l<com.bytedance.ttnet.b.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TTNetInitHelper f11876a;

        d(TTNetInitHelper r1) {
            this.f11876a = r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.l
        public /* synthetic */ void a(long r9, long r11, String r13, String r14, com.bytedance.frameworks.baselib.network.http.b r15) {
            a(r9, r11, r13, r14, (com.bytedance.ttnet.b.b) ZeusTransformUtils.preCheckCast(r15, com.bytedance.ttnet.b.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.l
        public /* synthetic */ void a(long r11, long r13, String r15, String r16, com.bytedance.frameworks.baselib.network.http.b r17, Throwable r18) {
            a(r11, r13, r15, r16, (com.bytedance.ttnet.b.b) ZeusTransformUtils.preCheckCast(r17, com.bytedance.ttnet.b.b.class, "com.obric.memorydata.plugin"), r18);
        }

        public void a(long r12, long r14, String r16, String r17, com.bytedance.ttnet.b.b r18) {
            String[] r1 = new String[1];     // Catch: Throwable -> L11
            JSONObject r10 = new JSONObject();     // Catch: Throwable -> L11
            if (h.a(r1[0]) == false) goto L9;
            if (r18 == null) goto L7;
            String r3 = r18.w;     // Catch: Throwable -> L11
        L8:
            r1[0] = r3;     // Catch: Throwable -> L11
            goto L9
        L7:
            r3 = null;
        L9:
            TTNetInitHelper.access$packageRequestParamters(this.f11876a, r18, r10);     // Catch: Throwable -> L11
            com.bytedance.apm.a.a(r12, r14, r16, r1[0], r17, 200, r10);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            RunLog.INSTANCE.error(TTNetInitHelper.TAG, "monitorApiOk :", th);
        }

        public void a(long r16, long r18, String r20, String r21, com.bytedance.ttnet.b.b r22, Throwable r23) {
            String[] r3 = new String[1];     // Catch: Throwable -> L27
            int r13 = com.obric.memorydata.middleware.impl.ttnet.a.a(r23, r3);     // Catch: Throwable -> L27
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L27
            if (r23 == null) goto L20;
            if (h.a(r23.getClass().getName()) == true) goto L20;
            r14.put("ex_name", r23.getClass().getName());     // Catch: Throwable -> L27
            if (r13 != 1) goto L12;
            if (ApmDelegate.a().a("ex_message_open") == false) goto L12;
        L13:
            String r1 = com.bytedance.ttnet.utils.d.a(r23);     // Catch: Throwable -> L27
            if (h.a(r1) == true) goto L16;
            r14.put("ex_message", r1);     // Catch: Throwable -> L27
        L16:
            String r2 = com.bytedance.ttnet.c.a();     // Catch: Throwable -> L27
            if (h.a(r2) == true) goto L20;
            r14.put("cronet_init_ex_message", r2);     // Catch: Throwable -> L27
        L12:
            if (ApmDelegate.a().a("debug_ex_message_open") == true) goto L13;
        L20:
            if (h.a(r3[0]) == false) goto L25;
            if (r22 == null) goto L23;
            String r4 = r22.w;     // Catch: Throwable -> L27
        L24:
            r3[0] = r4;     // Catch: Throwable -> L27
            goto L25
        L23:
            r4 = null;
        L25:
            TTNetInitHelper.access$packageRequestParamters(this.f11876a, r22, r14);     // Catch: Throwable -> L27
            com.bytedance.apm.a.b(r16, r18, r20, r3[0], r21, r13, r14);     // Catch: Throwable -> L27
            com.bytedance.apm.a.a(r16, r18, r20, r3[0], r21, r13, r14);     // Catch: Throwable -> L27
            return;
        L27:
            th = move-exception;
            RunLog.INSTANCE.error(TTNetInitHelper.TAG, "monitorApiError :", th);
        }
    }

    static {
        Companion = new a(null);
    }

    public TTNetInitHelper() {
        this.store$delegate = LazyKt.lazy($$Lambda$TTNetInitHelper$mdP25g18G_VDKFff_6qKYPGyv_4.INSTANCE);
        this.sMonitorProcessHook = (f.l) ZeusTransformUtils.preCheckCast(new d(this), f.l.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ IStore access$getStore(TTNetInitHelper r0) {
        return r0.getStore();
    }

    public static final /* synthetic */ boolean access$getUxpEnable$p(TTNetInitHelper r0) {
        return r0.uxpEnable;
    }

    public static final /* synthetic */ void access$packageRequestParamters(TTNetInitHelper r0, com.bytedance.ttnet.b.b r1, JSONObject r2) {
        r0.packageRequestParamters(r1, r2);
    }

    public static final /* synthetic */ void access$setUxpEnable$p(TTNetInitHelper r0, boolean r1) {
        r0.uxpEnable = r1;
    }

    private final IStore getStore() {
        return (IStore) ZeusTransformUtils.preCheckCast(this.store$delegate.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ IStore lambda$mdP25g18G_VDKFff_6qKYPGyv_4() {
        return store_delegate$lambda$0();
    }

    private final void packageRequestParamters(com.bytedance.ttnet.b.b r3, JSONObject r4) {
        if (r3 == null) goto L18;
        if (r4 == null) goto L19;
        r4.put("cronet_plugin_install", TTNetInit.getTTNetDepend().a());     // Catch: JSONException -> L13
        r4.put("appLevelRequestStart", r3.e);     // Catch: JSONException -> L13
        r4.put("beforeAllInterceptors", r3.f);     // Catch: JSONException -> L13
        r4.put("requestStart", r3.g);     // Catch: JSONException -> L13
        r4.put("responseBack", r3.h);     // Catch: JSONException -> L13
        r4.put("completeReadResponse", r3.i);     // Catch: JSONException -> L13
        r4.put("requestEnd", r3.j);     // Catch: JSONException -> L13
        r4.put("recycleCount", r3.C);     // Catch: JSONException -> L13
        if (r3.G != 0) goto L9;
        r4.put("timing_dns", r3.n);     // Catch: JSONException -> L13
        r4.put("timing_connect", r3.o);     // Catch: JSONException -> L13
        r4.put("timing_ssl", r3.p);     // Catch: JSONException -> L13
        r4.put("timing_send", r3.q);     // Catch: JSONException -> L13
        r4.put("timing_waiting", r3.s);     // Catch: JSONException -> L13
        r4.put("timing_receive", r3.t);     // Catch: JSONException -> L13
        r4.put("timing_total", r3.u);     // Catch: JSONException -> L13
        r4.put("timing_isSocketReused", r3.D);     // Catch: JSONException -> L13
        r4.put("timing_totalSendBytes", r3.x);     // Catch: JSONException -> L13
        r4.put("timing_totalReceivedBytes", r3.y);     // Catch: JSONException -> L13
        r4.put("timing_remoteIP", r3.w);     // Catch: JSONException -> L13
        r4.put("request_log", r3.f2361J);     // Catch: JSONException -> L13
    L9:
        if (r3.K == null) goto L11;
        r4.put("req_info", r3.K);     // Catch: JSONException -> L13
    L11:
        r4.put("streaming", r3.L);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "packageRequestParamters error:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        return;
    }

    private static final IStore store_delegate$lambda$0() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    @Override // com.obric.memorydata.middleware.api.ttnet.ITTNetInitHelper
    public void initTTNet(Context r11, Application r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Application r14 = (Application) ZeusTransformUtils.wrapperContextForParams(r12, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "application");
        TTNetCronetDependAdapter.INSTANCE.inJect();
        TTNetInit.setTTNetDepend((com.bytedance.ttnet.d) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.middleware.impl.ttnet.b(r13), com.bytedance.ttnet.d.class, "com.obric.memorydata.plugin"));
        TTNetInit.setCronetDepend((ICronetAppProvider) ZeusTransformUtils.preCheckCast(TTNetCronetDependAdapter.INSTANCE, ICronetAppProvider.class, "com.obric.memorydata.plugin"));
        TTNetInit.setBypassOfflineCheck(true);
        com.bytedance.frameworks.baselib.network.http.cookie.a.a();
        TTNetInit.tryInitTTNet(r13, r14, (f.d) ZeusTransformUtils.preCheckCast(new b(this, r13), f.d.class, "com.obric.memorydata.plugin"), this.sMonitorProcessHook, null, true, new boolean[]{false});
        AppConfig.getInstance(r13).setDisableFallbackReasonBoot(true);
        TTNetInit.preInitCronetKernel();
        com.bytedance.common.utility.f.a((com.bytedance.common.utility.f) ZeusTransformUtils.preCheckCast(new com.bytedance.article.common.network.a(), com.bytedance.common.utility.f.class, "com.obric.memorydata.plugin"));
        this.uxpEnable = getStore().getBoolean("memory_user_experience", false);
        getStore().registerChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(new c(this), com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.middleware.impl.network.d.f11766a.a((Context) ZeusTransformUtils.preCheckCast(r14, Context.class, "com.obric.memorydata.plugin"));
    }
}
