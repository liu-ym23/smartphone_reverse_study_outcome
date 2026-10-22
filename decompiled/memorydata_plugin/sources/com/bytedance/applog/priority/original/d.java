package com.bytedance.applog.priority.original;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/applog/priority/original/AppSessionTerminate;", "", ObricMemoryConstants.KEY_SESSION_ID, "", "duration", "", "pageNames", "Lorg/json/JSONArray;", "extraParams", "Lorg/json/JSONObject;", "(Ljava/lang/String;JLorg/json/JSONArray;Lorg/json/JSONObject;)V", "getDuration", "()J", "setDuration", "(J)V", "getExtraParams", "()Lorg/json/JSONObject;", "getPageNames", "()Lorg/json/JSONArray;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1831b;
    private final JSONArray c;
    private final JSONObject d;

    public d(String r2, long r3, JSONArray r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r5, "pageNames");
        Intrinsics.checkNotNullParameter(r6, "extraParams");
        this.f1830a = r2;
        this.f1831b = r3;
        this.c = r5;
        this.d = r6;
    }

    public final String a() {
        return this.f1830a;
    }

    public final void a(long r1) {
        this.f1831b = r1;
    }

    public final long b() {
        return this.f1831b;
    }

    public final JSONArray c() {
        return this.c;
    }

    public final JSONObject d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f1830a, r10.f1830a) == true) goto L12;
        return false;
    L12:
        if (this.f1831b == r10.f1831b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f1830a.hashCode() * 31) + Long.hashCode(this.f1831b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AppSessionTerminate(sessionId=" + this.f1830a + ", duration=" + this.f1831b + ", pageNames=" + this.c + ", extraParams=" + this.d + ')';
    }
}
