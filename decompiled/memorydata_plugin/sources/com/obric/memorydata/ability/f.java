package com.obric.memorydata.ability;

import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/ability/AbilityParams;", "", "dataId", "", TrackerImpl.PARAMS, "", "", "<init>", "(ILjava/util/Map;)V", "getDataId", "()I", "getParams", "()Ljava/util/Map;", "isValid", "", "equals", "other", "hashCode", "component1", "component2", "copy", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f8358b;

    public f(int r3, Map<String, ? extends Object> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        this.f8357a = r3;
        this.f8358b = r5;
    }

    public final int a() {
        return this.f8357a;
    }

    public final Map<String, Object> b() {
        return this.f8358b;
    }

    public final boolean c() {
        if (this.f8357a > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f8358b == null) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L6;
        return false;
    L6:
        if (r5 != this) goto L9;
        return true;
    L9:
        if (this.f8357a == ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin")).f8357a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f8357a)});
    }

    public String toString() {
        return "AbilityParams(dataId=" + this.f8357a + ", params=" + this.f8358b + ')';
    }
}
