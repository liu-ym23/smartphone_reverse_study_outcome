package com.bytedance.applog.priority.original;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applog/priority/original/AppSessionLaunch;", "", ObricMemoryConstants.KEY_SESSION_ID, "", "isForeground", "", "extraParams", "Lorg/json/JSONObject;", "timestamp", "", "(Ljava/lang/String;ZLorg/json/JSONObject;J)V", "getExtraParams", "()Lorg/json/JSONObject;", "()Z", "setForeground", "(Z)V", "getSessionId", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1829b;
    private final JSONObject c;
    private final long d;

    public b(String r2, boolean r3, JSONObject r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
        this.f1828a = r2;
        this.f1829b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final String a() {
        return this.f1828a;
    }

    public final boolean b() {
        return this.f1829b;
    }

    public final JSONObject c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
        return false;
    L8:
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f1828a, r8.f1828a) == true) goto L12;
        return false;
    L12:
        if (this.f1829b == r8.f1829b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r8.d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int r0 = this.f1828a.hashCode() * 31;
        boolean r1 = this.f1829b;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        JSONObject r4 = this.c;
        if (r4 != null) goto L8;
        int r5 = 0;
    L10:
        return ((r3 + r5) * 31) + Long.hashCode(this.d);
    L8:
        r5 = r4.hashCode();
        goto L10
    }

    public String toString() {
        return "AppSessionLaunch(sessionId=" + this.f1828a + ", isForeground=" + this.f1829b + ", extraParams=" + this.c + ", timestamp=" + this.d + ')';
    }
}
