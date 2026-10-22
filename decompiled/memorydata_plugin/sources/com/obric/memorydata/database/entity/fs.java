package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u009f\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006>"}, d2 = {"Lcom/obric/memorydata/database/entity/RawChatEntity;", "", "dataVersion", "", "timestamp", "", "sequenceTime", "chatType", "chatName", "", "msgPerson", "msgType", "msgContent", "timeAccuracy", "chatPeopleNum", "refName", "refContent", "uploadState", ObricMemoryConstants.KEY_PACKAGE_NAME, OaidModel.KEY_ID, "<init>", "(IJJILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "getDataVersion", "()I", "getTimestamp", "()J", "getSequenceTime", "getChatType", "getChatName", "()Ljava/lang/String;", "getMsgPerson", "getMsgType", "getMsgContent", "getTimeAccuracy", "getChatPeopleNum", "getRefName", "getRefContent", "getUploadState", "getPackageName", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9133b;
    private final long c;
    private final long d;
    private final int e;
    private final String f;
    private final String g;
    private final int h;
    private final String i;
    private final int j;
    private final int k;
    private final String l;
    private final String m;
    private final int n;
    private final String o;
    private final long p;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/entity/RawChatEntity$Companion;", "", "<init>", "()V", "NEED_UPLOAD", "", "UPLOADED", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9132a = new a(null);
    }

    public fs(int r10, long r11, long r13, int r15, String r16, String r17, int r18, String r19, int r20, int r21, String r22, String r23, int r24, String r25, long r26) {
        Intrinsics.checkNotNullParameter(r16, "chatName");
        Intrinsics.checkNotNullParameter(r17, "msgPerson");
        Intrinsics.checkNotNullParameter(r19, "msgContent");
        Intrinsics.checkNotNullParameter(r22, "refName");
        Intrinsics.checkNotNullParameter(r23, "refContent");
        Intrinsics.checkNotNullParameter(r25, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.f9133b = r10;
        this.c = r11;
        this.d = r13;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r25;
        this.p = r26;
    }

    public final int a() {
        return this.f9133b;
    }

    public final long b() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, fs.class) == true) goto L8;
        return false;
    L8:
        fs r10 = (fs) ZeusTransformUtils.preCheckCast(r9, fs.class, "com.obric.memorydata.plugin");
        if (this.f9133b == r10.f9133b) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L33;
        return false;
    L33:
        if (this.j == r10.j) goto L36;
        return false;
    L36:
        if (this.k == r10.k) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L45;
        return false;
    L45:
        if (this.n == r10.n) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L51;
        return false;
    L51:
        if (this.p == r10.p) goto L53;
        return false;
    L53:
        return true;
    }

    public final String f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((Integer.hashCode(this.f9133b) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + Integer.hashCode(this.n)) * 31) + this.o.hashCode()) * 31) + Long.hashCode(this.p);
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    public final String l() {
        return this.m;
    }

    public final int m() {
        return this.n;
    }

    public final String n() {
        return this.o;
    }

    public final long o() {
        return this.p;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawChatEntity(dataVersion=").append(this.f9133b).append(", timestamp=").append(this.c).append(", sequenceTime=").append(this.d).append(", chatType=").append(this.e).append(", chatName=").append(this.f).append(", msgPerson=").append(this.g).append(", msgType=").append(this.h).append(", msgContent=").append(this.i).append(", timeAccuracy=").append(this.j).append(", chatPeopleNum=").append(this.k).append(", refName=").append(this.l).append(", refContent=");
        r0.append(this.m).append(", uploadState=").append(this.n).append(", packageName=").append(this.o).append(", id=").append(this.p).append(')');
        return r0.toString();
    }
}
