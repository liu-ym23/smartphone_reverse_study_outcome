package com.obric.aiproactive.impl.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/ArtifactStoreResult;", "", "ok", "", "errorCode", "", "artifact", "Lorg/json/JSONObject;", "affectedCount", "", "<init>", "(ZLjava/lang/String;Lorg/json/JSONObject;I)V", "getOk", "()Z", "getErrorCode", "()Ljava/lang/String;", "getArtifact", "()Lorg/json/JSONObject;", "getAffectedCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6406b;
    private final JSONObject c;
    private final int d;

    public f(boolean r2, String r3, JSONObject r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "errorCode");
        this.f6405a = r2;
        this.f6406b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ f(boolean r1, String r2, JSONObject r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = 0;
    L11:
        this(r1, r2, r3, r4);
    }

    public final boolean a() {
        return this.f6405a;
    }

    public final String b() {
        return this.f6406b;
    }

    public final JSONObject c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (this.f6405a == r6.f6405a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6406b, r6.f6406b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.f6405a) * 31) + this.f6406b.hashCode()) * 31;
        JSONObject r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Integer.hashCode(this.d);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ArtifactStoreResult(ok=" + this.f6405a + ", errorCode=" + this.f6406b + ", artifact=" + this.c + ", affectedCount=" + this.d + ')';
    }
}
