package com.obric.memorydata.union.build.storage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003JU\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018¨\u0006)"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticConsumerCommitRequest;", "", "consumerId", "", "expectedCursor", "", "groupSeq", "outputs", "Lorg/json/JSONArray;", "replaceExisting", "", "expectedGroups", "", "fullSnapshotEmpty", "<init>", "(Ljava/lang/String;JJLorg/json/JSONArray;ZLjava/util/Set;Z)V", "getConsumerId", "()Ljava/lang/String;", "getExpectedCursor", "()J", "getGroupSeq", "getOutputs", "()Lorg/json/JSONArray;", "getReplaceExisting", "()Z", "getExpectedGroups", "()Ljava/util/Set;", "getFullSnapshotEmpty", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f13133b;
    private final long c;
    private final JSONArray d;
    private final boolean e;
    private final Set<String> f;
    private final boolean g;

    public o(String r3, long r4, long r6, JSONArray r8, boolean r9, Set<String> r10, boolean r11) {
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "consumerId");
        Intrinsics.checkNotNullParameter(r8, "outputs");
        Intrinsics.checkNotNullParameter(r12, "expectedGroups");
        this.f13132a = r3;
        this.f13133b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r9;
        this.f = r12;
        this.g = r11;
    }

    public final String a() {
        return this.f13132a;
    }

    public final long b() {
        return this.f13133b;
    }

    public final long c() {
        return this.c;
    }

    public final JSONArray d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, o.class) == true) goto L8;
        return false;
    L8:
        o r10 = (o) ZeusTransformUtils.preCheckCast(r9, o.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f13132a, r10.f13132a) == true) goto L12;
        return false;
    L12:
        if (this.f13133b == r10.f13133b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
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
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final Set<String> f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public int hashCode() {
        return (((((((((((this.f13132a.hashCode() * 31) + Long.hashCode(this.f13133b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g);
    }

    public String toString() {
        return "SemanticConsumerCommitRequest(consumerId=" + this.f13132a + ", expectedCursor=" + this.f13133b + ", groupSeq=" + this.c + ", outputs=" + this.d + ", replaceExisting=" + this.e + ", expectedGroups=" + this.f + ", fullSnapshotEmpty=" + this.g + ')';
    }
}
