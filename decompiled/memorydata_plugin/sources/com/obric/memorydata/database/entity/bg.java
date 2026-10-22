package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006!"}, d2 = {"Lcom/obric/memorydata/database/entity/EmbeddingVectorCacheEntity;", "", "timestamp", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "type", "", "vector", OaidModel.KEY_ID, "<init>", "(JLjava/lang/String;ILjava/lang/String;J)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "getText", "()Ljava/lang/String;", "getType", "()I", "getVector", "getId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8928b;
    private final int c;
    private final String d;
    private final long e;

    public bg(long r2, String r4, int r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r6, "vector");
        this.f8927a = r2;
        this.f8928b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }

    public final long a() {
        return this.f8927a;
    }

    public final String b() {
        return this.f8928b;
    }

    public final String c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bg.class) == true) goto L8;
        return false;
    L8:
        bg r10 = (bg) ZeusTransformUtils.preCheckCast(r9, bg.class, "com.obric.memorydata.plugin");
        if (this.f8927a == r10.f8927a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8928b, r10.f8928b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getType() {
        return this.c;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f8927a) * 31) + this.f8928b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "EmbeddingVectorCacheEntity(timestamp=" + this.f8927a + ", text=" + this.f8928b + ", type=" + this.c + ", vector=" + this.d + ", id=" + this.e + ')';
    }
}
