package com.obric.aiproactive.impl.aidb.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/entity/AiProactivePreferenceEntity;", "", OaidModel.KEY_ID, "", "timestamp", Params.CONTENT, "", "type", "created", "updated", "<init>", "(JJLjava/lang/String;Ljava/lang/String;JJ)V", "getId", "()J", "getTimestamp", "getContent", "()Ljava/lang/String;", "getType", "getCreated", "getUpdated", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f6297b;
    private final String c;
    private final String d;
    private final long e;
    private final long f;

    public f(long r2, long r4, String r6, String r7, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r6, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r7, "type");
        this.f6296a = r2;
        this.f6297b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r10;
    }

    public /* synthetic */ f(long r14, long r16, String r18, String r19, long r20, long r22, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 1) == 0) goto L5;
        long r3 = 0;
    L6:
        this(r3, r16, r18, r19, r20, r22);
        return;
    L5:
        r3 = r14;
        goto L6
    }

    public static /* synthetic */ f a(f r11, long r12, long r14, String r16, String r17, long r18, long r20, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r1 = r11.f6296a;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r3 = r11.f6297b;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r5 = r11.c;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r6 = r11.d;
    L19:
        if ((r22 & 16) == 0) goto L21;
        long r7 = r11.e;
    L23:
        if ((r22 & 32) == 0) goto L25;
        long r9 = r11.f;
    L27:
        return r11.a(r1, r3, r5, r6, r7, r9);
    L25:
        r9 = r20;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final long a() {
        return this.f6296a;
    }

    public final f a(long r13, long r15, String r17, String r18, long r19, long r21) {
        Intrinsics.checkNotNullParameter(r17, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r18, "type");
        return new f(r13, r15, r17, r18, r19, r21);
    }

    public final long b() {
        return this.f6297b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (this.f6296a == r10.f6296a) goto L12;
        return false;
    L12:
        if (this.f6297b == r10.f6297b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getType() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f6296a) * 31) + Long.hashCode(this.f6297b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "AiProactivePreferenceEntity(id=" + this.f6296a + ", timestamp=" + this.f6297b + ", content=" + this.c + ", type=" + this.d + ", created=" + this.e + ", updated=" + this.f + ')';
    }
}
