package com.obric.aiproactive.ui.progress;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/ui/progress/ContextSource;", "", "key", "", ActivityLifecycle.NAME, "firstSeenIndex", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getName", "getFirstSeenIndex", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6841b;
    private final int c;

    public p(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        this.f6840a = r2;
        this.f6841b = r3;
        this.c = r4;
    }

    public final String a() {
        return this.f6840a;
    }

    public final String b() {
        return this.f6841b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
        return false;
    L8:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6840a, r6.f6840a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6841b, r6.f6841b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f6840a.hashCode() * 31) + this.f6841b.hashCode()) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "ContextSource(key=" + this.f6840a + ", name=" + this.f6841b + ", firstSeenIndex=" + this.c + ')';
    }
}
