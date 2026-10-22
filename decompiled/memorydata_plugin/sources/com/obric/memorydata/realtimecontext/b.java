package com.obric.memorydata.realtimecontext;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.settings.ActionRecommendSceneActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 +2\u00020\u0001:\u0001+BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ActionRecommendScenePreparedRule;", "", MemoryInfoSectionEditActivity.KIND_SCENE, "", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "versionCode", "", "activity", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneActivity;", "compiledRule", "Lcom/obric/memorydata/realtimecontext/CompiledActionRecommendSceneRule;", "missingReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneActivity;Lcom/obric/memorydata/realtimecontext/CompiledActionRecommendSceneRule;Ljava/lang/String;)V", "getScene", "()Ljava/lang/String;", "getPackageName", "getActivityName", "getVersionCode", "()J", "getActivity", "()Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneActivity;", "getCompiledRule", "()Lcom/obric/memorydata/realtimecontext/CompiledActionRecommendSceneRule;", "getMissingReason", "needsViewTree", "", "getNeedsViewTree", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12443a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12444b;
    private final String c;
    private final String d;
    private final long e;
    private final ActionRecommendSceneActivity f;
    private final k g;
    private final String h;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ActionRecommendScenePreparedRule$Companion;", "", "<init>", "()V", "missing", "Lcom/obric/memorydata/realtimecontext/ActionRecommendScenePreparedRule;", MemoryInfoSectionEditActivity.KIND_SCENE, "", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "versionCode", "", InfoRequestQPSOptTraceLogger.REASON, "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final b a(String r10, String r11, String r12, long r13, String r15) {
            Intrinsics.checkNotNullParameter(r10, MemoryInfoSectionEditActivity.KIND_SCENE);
            Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r12, "activityName");
            Intrinsics.checkNotNullParameter(r15, InfoRequestQPSOptTraceLogger.REASON);
            return new b(r10, r11, r12, r13, null, null, r15);
        }
    }

    static {
        f12443a = new a(null);
    }

    public b(String r2, String r3, String r4, long r5, ActionRecommendSceneActivity r7, k r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.KIND_SCENE);
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, "activityName");
        this.f12444b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public /* synthetic */ b(String r11, String r12, String r13, long r14, ActionRecommendSceneActivity r16, k r17, String r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 64) == 0) goto L5;
        String r9 = null;
    L6:
        this(r11, r12, r13, r14, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final String a() {
        return this.f12444b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final k d() {
        return this.g;
    }

    public final String e() {
        return this.h;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12444b, r10.f12444b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final boolean f() {
        k r2 = this.g;
        if (r2 == null) goto L8;
        if (r2.c() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public final ActionRecommendSceneActivity getActivity() {
        return this.f;
    }

    public int hashCode() {
        int r0 = ((((((this.f12444b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31;
        ActionRecommendSceneActivity r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        k r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.h;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionRecommendScenePreparedRule(scene=" + this.f12444b + ", packageName=" + this.c + ", activityName=" + this.d + ", versionCode=" + this.e + ", activity=" + this.f + ", compiledRule=" + this.g + ", missingReason=" + this.h + ')';
    }
}
