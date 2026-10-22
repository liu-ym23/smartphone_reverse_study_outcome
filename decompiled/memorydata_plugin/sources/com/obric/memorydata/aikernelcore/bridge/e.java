package com.obric.memorydata.aikernelcore.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u0007J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0018JP\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SQLResult;", "", "success", "", "errorCode", "", "errorMessage", "", "data", "", "Lcom/obric/memorydata/aikernelcore/bridge/SQLColumn;", "insertedRowId", "", "<init>", "(ZILjava/lang/String;Ljava/util/List;Ljava/lang/Long;)V", "getSuccess", "()Z", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getData", "()Ljava/util/List;", "getInsertedRowId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "serializeToString", "component1", "component2", "component3", "component4", "component5", "copy", "(ZILjava/lang/String;Ljava/util/List;Ljava/lang/Long;)Lcom/obric/memorydata/aikernelcore/bridge/SQLResult;", "equals", "other", "hashCode", "toString", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8475b;
    private final String c;
    private final List<List<d>> d;
    private final Long e;

    public e(boolean r3, int r4, String r5, List<? extends List<d>> r6, Long r7) {
        List<List<d>> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        this.f8474a = r3;
        this.f8475b = r4;
        this.c = r5;
        this.d = r8;
        this.e = r7;
    }

    public /* synthetic */ e(boolean r7, int r8, String r9, List r10, Long r11, int r12, DefaultConstructorMarker r13) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r4, r11);
    }

    public final List<List<d>> a() {
        return this.d;
    }

    public final String b() {
        JSONObject r0 = new JSONObject();
        r0.put("code", this.f8475b);
        r0.put("message", this.c);
        Long r1 = this.e;
        if (r1 == null) goto L8;
        r0.put("data", r1.longValue());
    L5:
        String r11 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        return r11;
    L8:
        if (this.d == null) goto L5;
        JSONArray r2 = new JSONArray();
        r0.put("data", r2);
        int r3 = 0;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r12.hasNext() == false) goto L5;
        Object r5 = r12.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        JSONObject r8 = new JSONObject();
        r2.put(r3, r8);
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r4.hasNext() == false) goto L29;
        d r9 = (d) ZeusTransformUtils.preCheckCast(r4.next(), d.class, "com.obric.memorydata.plugin");
        int r10 = r9.getType();
        if (r10 != 1) goto L22;
        r8.put(r9.a(), r9.c());
        goto L18
    L22:
        if (r10 != 2) goto L24;
        r8.put(r9.a(), r9.b());
        goto L18
    L24:
        if (r10 != 3) goto L25;
        r8.put(r9.a(), r9.d());
        goto L18
    L25:
        r8.put(r9.a(), null);
        goto L18
    L29:
        r3 = r6;
        goto L12
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (this.f8474a == r6.f8474a) goto L12;
        return false;
    L12:
        if (this.f8475b == r6.f8475b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Boolean.hashCode(this.f8474a) * 31) + Integer.hashCode(this.f8475b)) * 31) + this.c.hashCode()) * 31;
        List<List<d>> r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SQLResult(success=" + this.f8474a + ", errorCode=" + this.f8475b + ", errorMessage=" + this.c + ", data=" + this.d + ", insertedRowId=" + this.e + ')';
    }
}
