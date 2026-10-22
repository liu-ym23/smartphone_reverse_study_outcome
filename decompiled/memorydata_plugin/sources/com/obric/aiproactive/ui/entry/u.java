package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/obric/aiproactive/ui/entry/ParsedNowAgentLifecycle;", "", "recordId", "", "type", "", "suggestionCount", "", "recordedAtMillis", "<init>", "(JLjava/lang/String;IJ)V", "getRecordId", "()J", "getType", "()Ljava/lang/String;", "getSuggestionCount", "()I", "getRecordedAtMillis", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6638b;
    private final int c;
    private final long d;

    public u(long r2, String r4, int r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "type");
        this.f6637a = r2;
        this.f6638b = r4;
        this.c = r5;
        this.d = r6;
    }

    public final long a() {
        return this.f6637a;
    }

    public final int b() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.memorydata.plugin");
        if (this.f6637a == r10.f6637a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6638b, r10.f6638b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getType() {
        return this.f6638b;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f6637a) * 31) + this.f6638b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "ParsedNowAgentLifecycle(recordId=" + this.f6637a + ", type=" + this.f6638b + ", suggestionCount=" + this.c + ", recordedAtMillis=" + this.d + ')';
    }
}
