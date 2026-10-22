package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/entity/ProactiveMemorySyncPendingEntity;", "", OaidModel.KEY_ID, "", "timestamp", "type", "", "entityId", "", "status", "<init>", "(JJILjava/lang/String;I)V", "getId", "()J", "getTimestamp", "getType", "()I", "getEntityId", "()Ljava/lang/String;", "getStatus", "setStatus", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9100a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9101b;
    private final long c;
    private final int d;
    private final String e;
    private int f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/entity/ProactiveMemorySyncPendingEntity$Companion;", "", "<init>", "()V", "SYNC_STATUS_PENDING", "", "SYNC_STATUS_SUCCESS", "SYNC_STATUS_FAILED", "TYPE_SCREEN_OBSERVATION", "TYPE_PROFILE", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9100a = new a(null);
    }

    public ew(long r2, long r4, int r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "entityId");
        this.f9101b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }

    public /* synthetic */ ew(long r11, long r13, int r15, String r16, int r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r18 & 16) == 0) goto L9;
        int r9 = 0;
    L10:
        this(r3, r13, r15, r16, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r3 = r11;
        goto L7
    }

    public final long a() {
        return this.f9101b;
    }

    public final void a(int r1) {
        this.f = r1;
    }

    public final long b() {
        return this.c;
    }

    public final String c() {
        return this.e;
    }

    public final int d() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ew.class) == true) goto L8;
        return false;
    L8:
        ew r10 = (ew) ZeusTransformUtils.preCheckCast(r9, ew.class, "com.obric.memorydata.plugin");
        if (this.f9101b == r10.f9101b) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getType() {
        return this.d;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f9101b) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "ProactiveMemorySyncPendingEntity(id=" + this.f9101b + ", timestamp=" + this.c + ", type=" + this.d + ", entityId=" + this.e + ", status=" + this.f + ')';
    }
}
