package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003Jm\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00069"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/PendingContextOld;", "", OaidModel.KEY_ID, "", "contextId", "", "sourceType", "messagesJson", "expiresAtMs", "state", ObricMemoryConstants.KEY_SESSION_ID, "preBuildTime", WsConstants.KEY_EXTRA, "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "getId", "()J", "setId", "(J)V", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "getSourceType", "setSourceType", "getMessagesJson", "setMessagesJson", "getExpiresAtMs", "setExpiresAtMs", "getState", "setState", "getSessionId", "setSessionId", "getPreBuildTime", "setPreBuildTime", "getExtra", "setExtra", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9543b;
    private String c;
    private String d;
    private long e;
    private String f;
    private String g;
    private long h;
    private String i;
    private final boolean j;

    public t(long r2, String r4, String r5, String r6, long r7, String r9, String r10, long r11, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r4, "contextId");
        Intrinsics.checkNotNullParameter(r5, "sourceType");
        Intrinsics.checkNotNullParameter(r6, "messagesJson");
        Intrinsics.checkNotNullParameter(r9, "state");
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r13, WsConstants.KEY_EXTRA);
        this.f9542a = r2;
        this.f9543b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r13;
        this.j = r14;
    }

    public final long a() {
        return this.f9542a;
    }

    public final String b() {
        return this.f9543b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, t.class) == true) goto L8;
        return false;
    L8:
        t r10 = (t) ZeusTransformUtils.preCheckCast(r9, t.class, "com.obric.memorydata.plugin");
        if (this.f9542a == r10.f9542a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9543b, r10.f9543b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((Long.hashCode(this.f9542a) * 31) + this.f9543b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Boolean.hashCode(this.j);
    }

    public final String i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public String toString() {
        return "PendingContextOld(id=" + this.f9542a + ", contextId=" + this.f9543b + ", sourceType=" + this.c + ", messagesJson=" + this.d + ", expiresAtMs=" + this.e + ", state=" + this.f + ", sessionId=" + this.g + ", preBuildTime=" + this.h + ", extra=" + this.i + ", personalDbSplitMigrated=" + this.j + ')';
    }
}
