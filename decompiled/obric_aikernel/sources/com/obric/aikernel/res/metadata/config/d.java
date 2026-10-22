package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.i;
import com.google.gson.k;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.data.AIModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends DistConfig {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5039f;

    public d(String r10, k r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "json");
        super("model", r10, r11);
        i r12 = r11.s("version");
        if (r12 != null) goto L5;
    L11:
        String r13 = "";
    L12:
        this.f5039f = r13;
        return;
    L5:
        if (r12.l() == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L11;
        r13 = Integer.valueOf(r12.c()).toString();
        if (r13 != null) goto L12;
        goto L11
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public void a(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "downloadRoot");
        Intrinsics.checkNotNullParameter(r11, "targetRoot");
        com.obric.aikernel.res.metadata.data.b.a r12 = com.obric.aikernel.res.metadata.data.b.f5079l;
        String r13 = r11.getPath();
        Intrinsics.checkNotNullExpressionValue(r13, "targetRoot.path");
        List<b> r14 = d();
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L10;
        b r17 = (b) r16.next();
        String r18 = r17.o();
        if (Intrinsics.areEqual(r17.n(), b.f5025q.a()) == false) goto L8;
        int r19 = r17.s();
    L9:
        Pair r20 = new Pair(r18, Long.valueOf(r19));
        r15.put(r20.getFirst(), r20.getSecond());
        goto L4
    L8:
        r19 = r17.r();
        goto L9
    L10:
        r12.d(r13, r15);
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public List<b> d() {
        ArrayList r10 = new ArrayList();
        if (f().w("weight_files") == false) goto L10;
        com.google.gson.f r11 = f().t("weight_files");
        Intrinsics.checkNotNullExpressionValue(r11, "json.getAsJsonArray(\"weight_files\")");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<i> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        i r14 = r13.next();
        String r15 = g();
        k r16 = r14.e();
        Intrinsics.checkNotNullExpressionValue(r16, "it.asJsonObject");
        r12.add(new b(r15, r16, 1, false, 8, null));
        goto L6
    L8:
        r10.addAll(r12);
    L10:
        if (f().w("tokenizer_file") == false) goto L12;
        String r17 = g();
        k r18 = f().u("tokenizer_file");
        Intrinsics.checkNotNullExpressionValue(r18, "json.getAsJsonObject(\"tokenizer_file\")");
        r10.add(new b(r17, r18, 1, false, 8, null));
    L12:
        return r10;
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public String i() {
        return this.f5039f;
    }

    @Override // com.obric.aikernel.res.metadata.config.DistConfig
    public boolean j(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return new AIModel(g(), i(), r10.getConfig()).n();
    }
}
