package com.obric.memorydata.init.tasks;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.privacy.PrivacySdk;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.env.EnvManager;
import com.obric.memorydata.middleware.api.env.NetEnv;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J2\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\u0082\b¢\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\u0082\b¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/init/tasks/PrivacySdkInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "readTokenMap", "", "", "safeGet", ExifInterface.GPS_DIRECTION_TRUE, ActivityLifecycle.NAME, "default", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "safeGetOrNull", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "safeRun", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PrivacySdkInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9906a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/init/tasks/PrivacySdkInitTask$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/init/tasks/PrivacySdkInitTask$run$1$1", "Lcom/bytedance/privacy/bridge/IAccountBridge;", "onGetUserId", "", "onIsAccountLogin", "", "onGetXttTokenMap", "", "onTeaEvent", "", "event", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "onGetDeviceId", "onGetUDID", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.bytedance.privacy.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrivacySdkInitTask f9907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrivacySdkInitTask f9908b;

        b(PrivacySdkInitTask r1, PrivacySdkInitTask r2) {
            this.f9907a = r1;
            this.f9908b = r2;
        }

        @Override // com.bytedance.privacy.a.a
        public String a() {
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L4
            Object r5 = Result.m1421constructorimpl(AppContext.INSTANCE.getUserId());     // Catch: Throwable -> L4
        L6:
            Throwable r0 = Result.m1424exceptionOrNullimpl(r5);
            if (r0 == null) goto L10;
            RunLog.INSTANCE.error("PrivacySdkInitTask", "onGetUserId failed: " + r0.getMessage(), r0);
        L10:
            if (Result.m1427isFailureimpl(r5) == false) goto L13;
            r5 = null;
        L13:
            return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        L4:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L6
        }

        @Override // com.bytedance.privacy.a.a
        public boolean b() {
            Object r5 = false;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Object r1 = Result.m1421constructorimpl(Boolean.valueOf(AppContext.INSTANCE.isLogin()));     // Catch: Throwable -> L5
        L7:
            Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
            if (r2 == null) goto L11;
            RunLog.INSTANCE.error("PrivacySdkInitTask", "onIsAccountLogin failed: " + r2.getMessage(), r2);
        L11:
            if (Result.m1427isFailureimpl(r1) == true) goto L15;
            r5 = r1;
        L15:
            return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        L5:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        @Override // com.bytedance.privacy.a.a
        public Map<String, String> c() {
            return PrivacySdkInitTask.a(this.f9908b);
        }

        @Override // com.bytedance.privacy.a.a
        public String d() {
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L4
            Object r5 = Result.m1421constructorimpl(AppContext.INSTANCE.getServerDeviceId());     // Catch: Throwable -> L4
        L6:
            Throwable r0 = Result.m1424exceptionOrNullimpl(r5);
            if (r0 == null) goto L10;
            RunLog.INSTANCE.error("PrivacySdkInitTask", "onGetDeviceId failed: " + r0.getMessage(), r0);
        L10:
            if (Result.m1427isFailureimpl(r5) == false) goto L13;
            r5 = null;
        L13:
            return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        L4:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L6
        }

        @Override // com.bytedance.privacy.a.a
        public String e() {
            return "";
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/init/tasks/PrivacySdkInitTask$run$1$2", "Lcom/bytedance/privacy/bridge/IEnvBridge;", "onIsBoeEnv", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.bytedance.privacy.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9909a;

        c(boolean r1) {
            this.f9909a = r1;
        }

        @Override // com.bytedance.privacy.a.b
        public boolean a() {
            return this.f9909a;
        }
    }

    static {
        f9906a = new a(null);
    }

    public PrivacySdkInitTask() {
    }

    private final Map<String, String> a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        PrivacySdkInitTask r6 = (PrivacySdkInitTask) ZeusTransformUtils.preCheckCast(this, PrivacySdkInitTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        String r7 = SharedState.INSTANCE.getString("doubao_account_token_map", "");     // Catch: Throwable -> L16
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        r7 = null;
    L7:
        if (r7 != null) goto L9;
        Map r8 = MapsKt.emptyMap();     // Catch: Throwable -> L16
    L14:
        Object r9 = Result.m1421constructorimpl(r8);     // Catch: Throwable -> L16
    L19:
        if (Result.m1424exceptionOrNullimpl(r9) == null) goto L23;
        r9 = MapsKt.emptyMap();
    L23:
        return (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin");
    L9:
        JSONObject r2 = new JSONObject(r7);     // Catch: Throwable -> L16
        Iterator<String> r10 = r2.keys();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r10, "keys(...)");     // Catch: Throwable -> L16
        Sequence r11 = SequencesKt.asSequence(r10);     // Catch: Throwable -> L16
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L16
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L16
    L11:
        if (r12.hasNext() == false) goto L13;
        Object r4 = r12.next();     // Catch: Throwable -> L16
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(r4, r2.optString((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L16
        goto L11
    L13:
        r8 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static final /* synthetic */ Map a(PrivacySdkInitTask r0) {
        return r0.a();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean r0 = false;
        Object r1 = false;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        if (EnvManager.INSTANCE.getAdminNetEnv() != NetEnv.BOE) goto L6;
        r0 = true;
    L6:
        Object r2 = Result.m1421constructorimpl(Boolean.valueOf(r0));     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r2);
        if (r4 == null) goto L14;
        RunLog.INSTANCE.error("PrivacySdkInitTask", "resolveEnv failed: " + r4.getMessage(), r4);
    L14:
        if (Result.m1427isFailureimpl(r2) == true) goto L17;
        r1 = r2;
    L17:
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        RunLog.INSTANCE.info("PrivacySdkInitTask", "PrivacySdk.init start, isBoeEnv=" + r5 + ", tokenMapSize=" + a().size(), true);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L20
        PrivacySdk.init((com.bytedance.privacy.a.a) ZeusTransformUtils.preCheckCast(new b((PrivacySdkInitTask) ZeusTransformUtils.preCheckCast(this, PrivacySdkInitTask.class, "com.obric.memorydata.plugin"), this), com.bytedance.privacy.a.a.class, "com.obric.memorydata.plugin"), (com.bytedance.privacy.a.b) ZeusTransformUtils.preCheckCast(new c(r5), com.bytedance.privacy.a.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        Object r8 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L25;
        RunLog.INSTANCE.error("PrivacySdkInitTask", "PrivacySdk.init failed: " + r9.getMessage(), r9);
    L25:
        RunLog.INSTANCE.info("PrivacySdkInitTask", "PrivacySdk.init end, isBoeEnv=" + r5, true);
        return;
    L20:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
