package com.obric.aiproactive.impl.aidb;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0018\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/RecommendationQuerySpec;", "", "sql", "", "args", "", "<init>", "(Ljava/lang/String;[Ljava/lang/Object;)V", "getSql", "()Ljava/lang/String;", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "toSQLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/obric/aiproactive/impl/aidb/RecommendationQuerySpec;", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f6380b;

    public u(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, "sql");
        Intrinsics.checkNotNullParameter(r3, "args");
        this.f6379a = r2;
        this.f6380b = r3;
    }

    public final SupportSQLiteQuery a() {
        return (SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(this.f6379a, this.f6380b), SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6379a, r6.f6379a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6380b, r6.f6380b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f6379a.hashCode() * 31) + Arrays.hashCode(this.f6380b);
    }

    public String toString() {
        return "RecommendationQuerySpec(sql=" + this.f6379a + ", args=" + Arrays.toString(this.f6380b) + ')';
    }
}
