package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState;", "", "type", "Lcom/obric/aiproactive/ui/entry/NowAgentStatusType;", "suggestionCount", "", "sourceRecordId", "", "expiresAtMillis", "<init>", "(Lcom/obric/aiproactive/ui/entry/NowAgentStatusType;IJJ)V", "getType", "()Lcom/obric/aiproactive/ui/entry/NowAgentStatusType;", "getSuggestionCount", "()I", "getSourceRecordId", "()J", "getExpiresAtMillis", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6620a = null;
    private static final j f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NowAgentStatusType f6621b;
    private final int c;
    private final long d;
    private final long e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState$Companion;", "", "<init>", "()V", "SENSING", "Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState;", "getSENSING", "()Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final j a() {
            return j.d();
        }
    }

    static {
        f6620a = new a(null);
        f = new j(NowAgentStatusType.SENSING, 0, 0, 0, 14, null);
    }

    public j(NowAgentStatusType r2, int r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.f6621b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public /* synthetic */ j(NowAgentStatusType r8, int r9, long r10, long r12, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = 0;
    L5:
        int r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        long r3 = 0;
    L10:
        if ((r14 & 8) == 0) goto L12;
        long r5 = 0;
    L13:
        this(r8, r2, r3, r5);
        return;
    L12:
        r5 = r12;
        goto L13
    L8:
        r3 = r10;
        goto L10
    }

    public static /* synthetic */ j a(j r4, NowAgentStatusType r5, int r6, long r7, long r9, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.f6621b;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.c;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.d;
    L11:
        long r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.e;
    L14:
        NowAgentStatusType r8 = r5;
        return r4.a(r8, r13, r0, r9);
    }

    public static final /* synthetic */ j d() {
        return f;
    }

    public final int a() {
        return this.c;
    }

    public final j a(NowAgentStatusType r8, int r9, long r10, long r12) {
        Intrinsics.checkNotNullParameter(r8, "type");
        return new j(r8, r9, r10, r12);
    }

    public final long b() {
        return this.d;
    }

    public final long c() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.memorydata.plugin");
        if (this.f6621b == r10.f6621b) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L20;
        return false;
    L20:
        return true;
    }

    public final NowAgentStatusType getType() {
        return this.f6621b;
    }

    public int hashCode() {
        return (((((this.f6621b.hashCode() * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "NowAgentStatusBarState(type=" + this.f6621b + ", suggestionCount=" + this.c + ", sourceRecordId=" + this.d + ", expiresAtMillis=" + this.e + ')';
    }
}
