package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.i;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends UpdateTaskConfig {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f5040i = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f5041h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean a(k r10) {
            Intrinsics.checkNotNullParameter(r10, "json");
            return r10.w("dependency");
        }
    }

    static {
        f5040i = new a(null);
    }

    public e(String r10, k r11, PackageResourceManager.PresmConfig r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "json");
        Intrinsics.checkNotNullParameter(r12, "presmConfig");
        super("package", r10, r11);
        this.f5041h = r12;
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public boolean j(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return false;
    }

    @Override // com.obric.aikernel.res.metadata.config.UpdateTaskConfig
    public List<DistConfig> m() {
        ArrayList r10 = new ArrayList();
        k r11 = f().u("dependency");
        boolean r12 = Intrinsics.areEqual(i(), "debug");
        String r13 = g();
        k r14 = r11.u("handler");
        Intrinsics.checkNotNullExpressionValue(r14, "depend.getAsJsonObject(\"handler\")");
        r10.add(new f(r13, r14, i()));
        if (r11.w("bridge") == false) goto L9;
        k r15 = r11.u("bridge");
        if (r12 == false) goto L7;
        r15.p("from", "debug");
    L7:
        Intrinsics.checkNotNullExpressionValue(r15, "libCfg");
        r10.add(new c("bridge", r15));
    L9:
        if (r11.w("libs") == false) goto L18;
        k r16 = r11.u("libs");
        Set<String> r17 = r16.x();
        Intrinsics.checkNotNullExpressionValue(r17, "libs.keySet()");
        Iterator<T> r18 = r17.iterator();
    L12:
        if (r18.hasNext() == false) goto L18;
        String r19 = (String) r18.next();
        k r110 = r16.u(r19);
        if (r12 == false) goto L16;
        r110.p("from", "debug");
    L16:
        Intrinsics.checkNotNullExpressionValue(r19, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r110, "libCfg");
        r10.add(new c(r19, r110));
    L18:
        if (this.f5041h.getUseAIKernelModel() == false) goto L20;
    L27:
        return r10;
    L20:
        if (r11.w("model_center_name") == false) goto L27;
        if (r11.w("model_center_conf") == false) goto L27;
        k r20 = r11.u("model_center_conf");
        com.google.gson.f r111 = r11.t("model_center_name");
        Intrinsics.checkNotNullExpressionValue(r111, "depend.getAsJsonArray(\"model_center_name\")");
        Iterator<i> r112 = r111.iterator();
    L25:
        if (r112.hasNext() == false) goto L27;
        k r21 = r20.u(r112.next().h());
        Intrinsics.checkNotNullExpressionValue(r21, "modelConfig");
        r10.add(new d(com.obric.aikernel.res.metadata.config.a.c(r21, ActivityLifecycle.NAME), r21));
        goto L25
    }
}
