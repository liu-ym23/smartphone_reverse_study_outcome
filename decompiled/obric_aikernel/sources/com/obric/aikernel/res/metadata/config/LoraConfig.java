package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PrmContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class LoraConfig extends UpdateTaskConfig {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f5018l = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f5019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f5020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f5021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f5022k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean a(k r10) {
            Intrinsics.checkNotNullParameter(r10, "json");
            return r10.w("base_model");
        }
    }

    static {
        f5018l = new a(null);
    }

    public LoraConfig(String r10, final k r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "json");
        super("lora", r10, r11);
        this.f5019h = LazyKt.lazy(new LoraConfig$baseModelTag$2(r11));
        this.f5020i = LazyKt.lazy(new LoraConfig$packageMinVersion$2(r11));
        this.f5021j = LazyKt.lazy(new LoraConfig$packageName$2(r11));
        this.f5022k = LazyKt.lazy(new LoraConfig$autoDownload$2(r11));
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public boolean j(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return false;
    }

    @Override // com.obric.aikernel.res.metadata.config.UpdateTaskConfig
    public List<DistConfig> m() {
        return r();
    }

    public final String n() {
        return "loraType=" + g() + " version=" + i() + " packageName=" + t() + " packageMinVersion=" + s() + " autoDownload=" + p() + " models=" + CollectionsKt.joinToString$default(r(), null, "[", "]", 0, null, LoraConfig$describeForLog$models$1.INSTANCE, 25, null);
    }

    public final String o() {
        return CollectionsKt.joinToString$default(r(), null, "[", "]", 0, null, LoraConfig$describeModelVersionsForLog$1.INSTANCE, 25, null);
    }

    public final boolean p() {
        return ((Boolean) this.f5022k.getValue()).booleanValue();
    }

    public final String q() {
        return (String) this.f5019h.getValue();
    }

    public final List<d> r() {
        k r10 = f().u("model_center_conf");
        Set<String> r11 = r10.x();
        Intrinsics.checkNotNullExpressionValue(r11, "modelConf.keySet()");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        k r14 = r10.u((String) r13.next());
        Intrinsics.checkNotNullExpressionValue(r14, "partConfig");
        r12.add(new d(com.obric.aikernel.res.metadata.config.a.c(r14, ActivityLifecycle.NAME), r14));
        goto L4
    L6:
        return r12;
    }

    public final String s() {
        return (String) this.f5020i.getValue();
    }

    public final String t() {
        return (String) this.f5021j.getValue();
    }
}
