package com.bytedance.applog.priority.original;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/priority/original/EventDatabasePool;", "", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "context", "Landroid/content/Context;", "appId", "", "(Lcom/bytedance/applog/log/AbsLogger;Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "getDb", "Lcom/bytedance/applog/priority/original/DatabaseInterface;", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1840a = null;
    private static final Lazy<ConcurrentHashMap<Model.PriorityName, g>> e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.log.a f1841b;
    private final Context c;
    private final String d;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applog/priority/original/EventDatabasePool$Companion;", "", "()V", "DB_POOL", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "Lcom/bytedance/applog/priority/original/DatabaseInterface;", "getDB_POOL", "()Ljava/util/concurrent/ConcurrentHashMap;", "DB_POOL$delegate", "Lkotlin/Lazy;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final ConcurrentHashMap<Model.PriorityName, g> a() {
            return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(k.a().getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ ConcurrentHashMap a(a r0) {
            return r0.a();
        }
    }

    static {
        f1840a = new a(null);
        e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(EventDatabasePool$Companion$DB_POOL$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public k(com.bytedance.applog.log.a r3, Context r4, String r5) {
        com.bytedance.applog.log.a r6 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "logger");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r5, "appId");
        this.f1841b = r6;
        this.c = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.d = r5;
    }

    public static final /* synthetic */ Lazy a() {
        return e;
    }

    public final g a(Model.PriorityName r6) {
        Intrinsics.checkNotNullParameter(r6, "priorityName");
        ConcurrentMap r0 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(a.a(f1840a), ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r1 = r0.get(r6);
        if (r1 != null) goto L8;
        g r5 = (g) ZeusTransformUtils.preCheckCast(new j(this.f1841b, this.c, this.d, r6), g.class, "com.obric.memorydata.plugin");
        Object r7 = r0.putIfAbsent(r6, r5);
        if (r7 != null) goto L7;
        r1 = r5;
        goto L8
    L7:
        r1 = r7;
    L8:
        Intrinsics.checkNotNullExpressionValue(r1, "DB_POOL.getOrPut(priorit…, priorityName)\n        }");
        return (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
    }

    public final Context getContext() {
        return this.c;
    }
}
