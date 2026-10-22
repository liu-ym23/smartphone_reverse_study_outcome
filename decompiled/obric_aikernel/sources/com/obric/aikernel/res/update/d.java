package com.obric.aikernel.res.update;

import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5169c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<UpdateTaskConfig>> f5170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MetadataRequestException f5171b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final d a(MetadataRequestException r10) {
            Intrinsics.checkNotNullParameter(r10, "failure");
            return new d(MapsKt.emptyMap(), r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final d b(Map<String, ? extends List<? extends UpdateTaskConfig>> r10) {
            Intrinsics.checkNotNullParameter(r10, "configs");
            return new d(r10, null, 2, 0 == true ? 1 : 0);
        }
    }

    static {
        f5169c = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Map<String, ? extends List<? extends UpdateTaskConfig>> r10, MetadataRequestException r11) {
        Intrinsics.checkNotNullParameter(r10, "configs");
        this.f5170a = r10;
        this.f5171b = r11;
    }

    public /* synthetic */ d(Map r10, MetadataRequestException r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final Map<String, List<UpdateTaskConfig>> a() {
        return this.f5170a;
    }

    public final MetadataRequestException b() {
        return this.f5171b;
    }

    public final MetadataRequestFailureKind c() {
        MetadataRequestException r10 = this.f5171b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getKind();
    }

    public final boolean d() {
        if (this.f5171b != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.f5170a, r11.f5170a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5171b, r11.f5171b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r10 = this.f5170a.hashCode() * 31;
        MetadataRequestException r11 = this.f5171b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "MetadataRequestOutcome(configs=" + this.f5170a + ", failure=" + this.f5171b + ')';
    }
}
