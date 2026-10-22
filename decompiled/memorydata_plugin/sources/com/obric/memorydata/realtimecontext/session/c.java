package com.obric.memorydata.realtimecontext.session;

import android.content.ComponentName;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.realtimecontext.RealTimeContextService;
import com.obric.memorydata.sdk.realtime.ActionContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u001e\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0016J\u0010\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0016H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001cJ\r\u0010+\u001a\u00020\u001cH\u0000¢\u0006\u0002\b,J\b\u0010-\u001a\u00020\u001cH\u0016R*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/obric/memorydata/realtimecontext/session/RealTimeData;", "", "<init>", "()V", EventBody.KEY_VALUE, "", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "screenMetaValues", "getScreenMetaValues", "()Ljava/util/List;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "screenAppEntities", "getScreenAppEntities", "", "topActivityClassName", "getTopActivityClassName", "()Ljava/lang/String;", "topPackageName", "getTopPackageName", "topAppName", "getTopAppName", "resultFlag", "", "getResultFlag", "()I", "setResultFlag", "(I)V", "updateScreenMetaValues", "", "metaValues", "updateScreenAppEntities", "appEntities", "updateTopActivity", "componentName", "Landroid/content/ComponentName;", "commit", "flag", "commitAction", "actionContext", "Lcom/obric/memorydata/sdk/realtime/ActionContext;", "isFinish", "", "clearScreen", "resetResultFlag", "resetResultFlag$realtime_context_obricRelease", "clear", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12483a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<? extends MetaValue> f12484b;
    private List<? extends AppEntity> c;
    private String d;
    private String e;
    private String f;
    private int g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/realtimecontext/session/RealTimeData$Companion;", "", "<init>", "()V", "FLAG_EMPTY", "", "FLAG_APP_ENTITY", "FLAG_APP_ENTITY_META_VALUE", "FLAG_SCREEN_META_VALUE", "FLAG_FINISH", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12483a = new a(null);
    }

    public c() {
        this.f12484b = CollectionsKt.emptyList();
        this.c = CollectionsKt.emptyList();
        this.d = "";
        this.e = "";
        this.f = "";
    }

    public final List<MetaValue> a() {
        return this.f12484b;
    }

    public void a(int r8) {
        this.g |= r8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "commit, flag: " + r8 + " -> " + this.g, false, 4, null);
    }

    public final void a(ComponentName r5) {
        String r0 = "";
        if (r5 == null) goto L6;
        String r1 = r5.getPackageName();
        if (r1 == null) goto L6;
    L7:
        this.e = r1;
        if (r5 == null) goto L11;
        String r2 = r5.getClassName();
        if (r2 == null) goto L11;
    L12:
        this.d = r2;
        if (r5 == null) goto L22;
        String r6 = r5.getPackageName();
        if (r6 == null) goto L22;
        String r3 = null;
        com.obric.memorydata.utils.c.a r7 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r6, null, 2, null);
        if (r7 == null) goto L19;
        r3 = r7.a();
    L19:
        if (r3 == null) goto L22;
        r0 = r3;
    L22:
        this.f = r0;
        return;
    L11:
        r2 = "";
    L6:
        r1 = "";
        goto L7
    }

    public void a(ActionContext r1) {
        Intrinsics.checkNotNullParameter(r1, "actionContext");
    }

    public void a(List<? extends MetaValue> r3) {
        List<? extends MetaValue> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "metaValues");
        this.f12484b = r4;
    }

    public final List<AppEntity> b() {
        return this.c;
    }

    public void b(List<? extends AppEntity> r3) {
        List<? extends AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "appEntities");
        this.c = r4;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }

    public final boolean g() {
        if (this.g != 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final void h() {
        a(CollectionsKt.emptyList());
        b(CollectionsKt.emptyList());
        this.e = "";
        this.d = "";
        this.f = "";
        i();
    }

    public final void i() {
        this.g = 0;
    }

    public void j() {
        h();
    }
}
