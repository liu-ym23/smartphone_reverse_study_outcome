package com.bytedance.pia.core.setting;

import com.bytedance.pia.core.utils.i;
import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0013R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\b\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/pia/core/setting/a;", "", "", "", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "expectedFeatures", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "version", "streaming", "", "d", "Z", "()Z", "isFromMock", "io/reactivex/internal/observers/h", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class a {
    public static final a f = null;
    public static final a g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("features")
    private final Set<String> f7081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("version")
    private final String f7082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("streaming")
    private final String f7083c;

    @SerializedName("isMocked")
    private final boolean d;
    public final Lazy e;

    static {
        f = new a(null, 15);
        g = new a(SetsKt.setOf(new String[]{"prefetch", "nsr", "snapshot", "cache", "streaming", "preload"}), 14);
    }

    public a() {
        this(null, 15);
    }

    public final Set a() {
        return this.f7081a;
    }

    public final String b() {
        return this.f7083c;
    }

    public final String c() {
        return this.f7082b;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        if (this.f7082b.length() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean f() {
        if (((Set) this.e.getValue()).contains("streaming") == true) goto L5;
        return false;
    L5:
        if (this.f7083c.length() <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final String toString() {
        return i.a().toJson(this);
    }

    public a(Set r5, int r10) {
        if ((r10 & 1) == 0) goto L5;
        r5 = SetsKt.emptySet();
    L5:
        Intrinsics.checkNotNullParameter(r5, "expectedFeatures");
        Intrinsics.checkNotNullParameter("", "version");
        Intrinsics.checkNotNullParameter("", "streaming");
        this.f7081a = r5;
        this.f7082b = "";
        this.f7083c = "";
        this.d = false;
        this.e = LazyKt.lazy(new Config$enabledFeatures$2(this));
    }
}
