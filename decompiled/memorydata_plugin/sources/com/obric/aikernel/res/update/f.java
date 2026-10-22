package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u001cJ\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequestOutcome;", "", "configs", "", "", "", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "failure", "Lcom/obric/aikernel/res/update/MetadataRequestException;", "(Ljava/util/Map;Lcom/obric/aikernel/res/update/MetadataRequestException;)V", "getConfigs", "()Ljava/util/Map;", "getFailure", "()Lcom/obric/aikernel/res/update/MetadataRequestException;", "failureKind", "Lcom/obric/aikernel/res/update/MetadataRequestFailureKind;", "getFailureKind", "()Lcom/obric/aikernel/res/update/MetadataRequestFailureKind;", "success", "", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "packageConfigCount", "toString", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6128a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<com.obric.aikernel.res.metadata.config.k>> f6129b;
    private final MetadataRequestException c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005J \u0010\u0006\u001a\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequestOutcome$Companion;", "", "()V", "failure", "Lcom/obric/aikernel/res/update/MetadataRequestOutcome;", "Lcom/obric/aikernel/res/update/MetadataRequestException;", "success", "configs", "", "", "", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final f a(MetadataRequestException r2) {
            Intrinsics.checkNotNullParameter(r2, "failure");
            return new f(MapsKt.emptyMap(), r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final f a(Map<String, ? extends List<? extends com.obric.aikernel.res.metadata.config.k>> r3) {
            Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "configs");
            return new f(r2, null, 2, 0 == true ? 1 : 0);
        }
    }

    static {
        f6128a = new a(null);
    }

    public f(Map<String, ? extends List<? extends com.obric.aikernel.res.metadata.config.k>> r3, MetadataRequestException r4) {
        Map<String, List<com.obric.aikernel.res.metadata.config.k>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "configs");
        this.f6129b = r5;
        this.c = r4;
    }

    public /* synthetic */ f(Map r2, MetadataRequestException r3, int r4, DefaultConstructorMarker r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r6, r3);
    }

    public final Map<String, List<com.obric.aikernel.res.metadata.config.k>> a() {
        return this.f6129b;
    }

    public final MetadataRequestException b() {
        return this.c;
    }

    public final boolean c() {
        if (this.c != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final MetadataRequestFailureKind d() {
        MetadataRequestException r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKind();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6129b, r6.f6129b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f6129b.hashCode() * 31;
        MetadataRequestException r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MetadataRequestOutcome(configs=" + this.f6129b + ", failure=" + this.c + ')';
    }
}
