package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.middleware.api.settings.App;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/PageContextSettings;", "", "enabled", "", "minVersion", "", "apps", "", "Lcom/obric/memorydata/middleware/api/settings/App;", "contexts", "", "<init>", "(ZJLjava/util/List;Ljava/lang/String;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getMinVersion", "()J", "setMinVersion", "(J)V", "getApps", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "getContexts", "()Ljava/lang/String;", "setContexts", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enabled")
    private boolean f11862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("minVersion")
    private long f11863b;

    @SerializedName("apps")
    private List<App> c;

    @SerializedName("contexts")
    private String d;

    public g() {
        this(false, 0, null, null, 15, null);
    }

    public g(boolean r3, long r4, List<App> r6, String r7) {
        List<App> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.f11862a = r3;
        this.f11863b = r4;
        this.c = r8;
        this.d = r7;
    }

    public /* synthetic */ g(boolean r7, long r8, List r10, String r11, int r12, DefaultConstructorMarker r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = false;
    L5:
        boolean r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = -1;
    L8:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        List r4 = null;
    L13:
        if ((r12 & 8) == 0) goto L15;
        String r5 = null;
    L16:
        this(r1, r2, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L11:
        r4 = r14;
        goto L13
    }

    public final boolean a() {
        return this.f11862a;
    }

    public final long b() {
        return this.f11863b;
    }

    public final List<App> c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
        if (this.f11862a == r10.f11862a) goto L12;
        return false;
    L12:
        if (this.f11863b == r10.f11863b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.f11862a) * 31) + Long.hashCode(this.f11863b)) * 31;
        List<App> r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "PageContextSettings(enabled=" + this.f11862a + ", minVersion=" + this.f11863b + ", apps=" + this.c + ", contexts=" + this.d + ')';
    }
}
