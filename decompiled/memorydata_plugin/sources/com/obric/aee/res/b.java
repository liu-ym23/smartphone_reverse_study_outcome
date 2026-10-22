package com.obric.aee.res;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J[\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\"\u001a\u00020\u0003J\b\u0010#\u001a\u00020$H\u0016J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0006\u0010&\u001a\u00020\u0003R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006'"}, d2 = {"Lcom/obric/aee/res/PackageInfo;", "", ActivityLifecycle.NAME, "", "version", "path", "service", "libraries", "", "Lcom/obric/aee/res/LibraryInfo;", "resources", "Lcom/obric/aee/res/ResourceInfo;", WsConstants.KEY_EXTRA, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "getLibraries", "()Ljava/util/List;", "getName", "getPath", "getResources", "getService", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getServiceName", "hashCode", "", "toString", "uniqueName", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(ActivityLifecycle.NAME)
    private final String f5892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("version")
    private final String f5893b;

    @SerializedName("path")
    private final String c;

    @SerializedName("service")
    private final String d;

    @SerializedName("libraries")
    private final List<a> e;

    @SerializedName("resources")
    private final List<c> f;

    @SerializedName(WsConstants.KEY_EXTRA)
    private final String g;

    public b(String r3, String r4, String r5, String r6, List<a> r7, List<c> r8, String r9) {
        List<a> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<c> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "version");
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "service");
        Intrinsics.checkNotNullParameter(r10, "libraries");
        Intrinsics.checkNotNullParameter(r11, "resources");
        Intrinsics.checkNotNullParameter(r9, WsConstants.KEY_EXTRA);
        this.f5892a = r3;
        this.f5893b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r10;
        this.f = r11;
        this.g = r9;
    }

    public final String a() {
        return this.f5892a;
    }

    public final String b() {
        return this.f5893b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final List<a> e() {
        return this.e;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.aee.res.PackageInfo");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f5892a, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f5892a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f5893b, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f5893b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.c, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).c) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.d, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).d) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.e, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).e) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.g, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).g) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        r3 = null;
        goto L10
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.d, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        StringBuilder r1 = new StringBuilder().append("service-").append(this.f5892a).append('@');
        String r3 = this.f5893b;
    L9:
        return r1.append(r3).toString();
    L10:
        r1 = new StringBuilder().append("service-n-");
        r3 = this.d;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final List<c> getResources() {
        return this.f;
    }

    public final String h() {
        return this.f5892a + '@' + this.f5893b;
    }

    public int hashCode() {
        return (((((((((((this.f5892a.hashCode() * 31) + this.f5893b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "PackageInfo(name=" + this.f5892a + ", version=" + this.f5893b + ", path=" + this.c + ", service=" + this.d + ", libraries=" + this.e + ", resources=" + this.f + ", extra=" + this.g + ')';
    }
}
