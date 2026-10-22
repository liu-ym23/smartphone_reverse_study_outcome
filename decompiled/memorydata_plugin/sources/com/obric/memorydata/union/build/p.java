package com.obric.memorydata.union.build;

import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.database.entity.iv;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticTypeSummaryHandler;", "", "data", "", "<init>", "(Ljava/lang/String;)V", "handle", "", "Companion", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13105a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13106b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticTypeSummaryHandler$Companion;", "", "<init>", "()V", "TAG", "", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends UnionSemanticTypeSummaryData>> {
        public b() {
        }
    }

    static {
        f13105a = new a(null);
    }

    public p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.f13106b = r2;
    }

    public final void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticTypeSummaryHandler", "start handle data length: " + this.f13106b.length(), false, 4, null);
        GsonUtil r0 = GsonUtil.INSTANCE;
        String r14 = this.f13106b;
        boolean r1 = true;
        List r3 = null;
        if (r14 != null) goto L5;
    L13:
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L16;
    L19:
        if (r1 == false) goto L22;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticTypeSummaryHandler", "handle error, items is null or empty", null, 4, null);
        return;
    L22:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r16.hasNext() == false) goto L26;
        UnionSemanticTypeSummaryData r2 = (UnionSemanticTypeSummaryData) ZeusTransformUtils.preCheckCast(r16.next(), UnionSemanticTypeSummaryData.class, "com.obric.memorydata.plugin");
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticTypeSummaryDao().insert(new iv(0, r2.getType(), r2.getTreePath(), r2.getSummary(), r2.getDescription(), r2.getCount(), r2.getCreateTime(), r2.getModifyTime(), 1, null));
        goto L24
    L26:
        return;
    L16:
        if (r15.isEmpty() == true) goto L19;
        r1 = false;
        goto L19
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r14 = null;
    L11:
        if (r14 == null) goto L13;
        r3 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r14, new b().getType()), List.class, "com.obric.memorydata.plugin");
        goto L13
    L7:
        r4 = false;
        goto L8
    }
}
