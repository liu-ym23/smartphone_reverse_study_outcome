package com.bytedance.securityguardkit.ai;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/securityguardkit/ai/ContentDetector;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "packageResource", "Lcom/obric/aikernel/sdk/data/PackageResource;", "batchInfer", "Lorg/json/JSONArray;", "batchContent", "", "", "([Ljava/lang/String;)Lorg/json/JSONArray;", "downloadModelAsync", "", "getPackageCapability", "Lorg/json/JSONObject;", "infer", Params.CONTENT, CommonConsts.APM_INNER_EVENT_COST_INIT, "Companion", "SecurityGuardKit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0163a f3165a = null;
    private static volatile a d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f3166b;
    private PackageResource c;

    /* JADX INFO: renamed from: com.bytedance.securityguardkit.ai.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/securityguardkit/ai/ContentDetector$Companion;", "", "()V", "TAG", "", "instance", "Lcom/bytedance/securityguardkit/ai/ContentDetector;", "getInstance", "context", "Landroid/content/Context;", "SecurityGuardKit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C0163a {
        private C0163a() {
        }

        public /* synthetic */ C0163a(DefaultConstructorMarker r1) {
            this();
        }

        public final a a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            a r0 = a.c();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = a.c();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            Intrinsics.checkNotNullExpressionValue(r5, "appContext");     // Catch: Throwable -> L10
            r0 = new a(r5, null);     // Catch: Throwable -> L10
            C0163a r6 = a.f3165a;     // Catch: Throwable -> L10
            a.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        f3165a = new C0163a(null);
    }

    private a(Context r3) {
        this.f3166b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public /* synthetic */ a(Context r2, DefaultConstructorMarker r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(a r0) {
        d = r0;
    }

    public static final /* synthetic */ void a(a r0, PackageResource r1) {
        r0.c = r1;
    }

    public static final /* synthetic */ a c() {
        return d;
    }

    public final JSONArray a(String[] r4) {
        Intrinsics.checkNotNullParameter(r4, "batchContent");
        return (JSONArray) ZeusTransformUtils.preCheckCast(i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new ContentDetector$batchInfer$1(r4, null), Function2.class, "com.obric.memorydata.plugin")), JSONArray.class, "com.obric.memorydata.plugin");
    }

    public final JSONObject a(String r3) {
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        JSONArray r2 = a(new String[]{r3});
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getJSONObject(0);
    }

    public final void a() {
        AIKernelConfig r0 = new AIKernelConfig.Builder(this.f3166b).appId(570851).build();
        AIKernelManager.INSTANCE.init(r0);
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ContentDetector$init$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final JSONObject b() {
        PackageResource r3 = this.c;
        if (r3 == null) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put(ActivityLifecycle.NAME, r3.getName());
        r0.put("version", r3.getVersion());
        return r0;
    L5:
        return null;
    }
}
