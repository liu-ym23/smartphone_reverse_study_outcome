package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003Je\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006)"}, d2 = {"Lcom/obric/memorydata/database/entity/ProactiveUserSubscriptionEntity;", "", "subscriptionId", "", Params.CONTENT, "uiData", "isActive", "", "created", "", "updated", "isDelete", "timestamp", OaidModel.KEY_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJZJJ)V", "getSubscriptionId", "()Ljava/lang/String;", "getContent", "getUiData", "()Z", "getCreated", "()J", "getUpdated", "getTimestamp", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9115b;
    private final String c;
    private final boolean d;
    private final long e;
    private final long f;
    private final boolean g;
    private final long h;
    private final long i;

    public fd(String r2, String r3, String r4, boolean r5, long r6, long r8, boolean r10, long r11, long r13) {
        Intrinsics.checkNotNullParameter(r2, "subscriptionId");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        this.f9114a = r2;
        this.f9115b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r10;
        this.h = r11;
        this.i = r13;
    }

    public /* synthetic */ fd(String r17, String r18, String r19, boolean r20, long r21, long r23, boolean r25, long r26, long r28, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r30 & 8) == 0) goto L9;
        boolean r6 = true;
    L11:
        if ((r30 & 64) == 0) goto L13;
        boolean r11 = false;
    L15:
        if ((r30 & 128) == 0) goto L17;
        long r12 = System.currentTimeMillis();
    L19:
        if ((r30 & 256) == 0) goto L21;
        long r14 = 0;
    L22:
        this(r17, r18, r5, r6, r21, r23, r11, r12, r14);
        return;
    L21:
        r14 = r28;
        goto L22
    L17:
        r12 = r26;
        goto L19
    L13:
        r11 = r25;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r5 = r19;
        goto L7
    }

    public final String a() {
        return this.f9114a;
    }

    public final String b() {
        return this.f9115b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, fd.class) == true) goto L8;
        return false;
    L8:
        fd r10 = (fd) ZeusTransformUtils.preCheckCast(r9, fd.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9114a, r10.f9114a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9115b, r10.f9115b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((this.f9114a.hashCode() * 31) + this.f9115b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((((r0 + r2) * 31) + Boolean.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final long i() {
        return this.i;
    }

    public String toString() {
        return "ProactiveUserSubscriptionEntity(subscriptionId=" + this.f9114a + ", content=" + this.f9115b + ", uiData=" + this.c + ", isActive=" + this.d + ", created=" + this.e + ", updated=" + this.f + ", isDelete=" + this.g + ", timestamp=" + this.h + ", id=" + this.i + ')';
    }
}
