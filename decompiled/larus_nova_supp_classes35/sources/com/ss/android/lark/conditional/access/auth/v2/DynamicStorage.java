package com.ss.android.lark.conditional.access.auth.v2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0011J\b\u0010\u0016\u001a\u00020\u0017H\u0002R8\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`\t0\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/DynamicStorage;", BuildConfig.FLAVOR, "<init>", "()V", "cacheResult", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/conditional/access/auth/v2/OnceValidateResult;", "Lkotlin/collections/LinkedHashMap;", "get", "policyModel", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/PolicyModel;", "getAll", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "put", BuildConfig.FLAVOR, "pointKey", "taskID", "validateResult", "clear", "getMaxSize", BuildConfig.FLAVOR, "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicStorage {
    public static final a Companion = null;
    public static final String TAG = "FilePolicyAuthManager";

    @SerializedName("cacheResult")
    private final Map<String, LinkedHashMap<String, d>> cacheResult;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final void clear() {
        this.cacheResult.clear();
    }

    public final HashMap<String, d> getAll() {
        HashMap<String, d> r0 = new HashMap();
        Iterator<Map.Entry<String, LinkedHashMap<String, d>>> r1 = this.cacheResult.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.putAll(r1.next().getValue());
        goto L4
    L6:
        return r0;
    }

    public DynamicStorage() {
        this.cacheResult = new LinkedHashMap();
    }

    private final int getMaxSize() {
        return w4c.c.a().w().a();
    }

    public final d get(PolicyModel r3) {
        Intrinsics.checkNotNullParameter(r3, "policyModel");
        LinkedHashMap<String, d> r0 = this.cacheResult.get(r3.getPointKey());
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get(r3.getTaskId());
    }

    public final void put(String r4, String r5, d r6) {
        Intrinsics.checkNotNullParameter(r4, "pointKey");
        Intrinsics.checkNotNullParameter(r5, "taskID");
        Intrinsics.checkNotNullParameter(r6, "validateResult");
        LinkedHashMap<String, d> r0 = this.cacheResult.get(r4);
        if (r0 == null) goto L7;
        r0.put(r5, r6);
        if ((r0.size() % 100) != 0) goto L8;
        FileAuthMonitor.UpdateTrigger[] r7 = FileAuthMonitor.a;
        FileAuthMonitor.k(r4, r0.size());
    L8:
        int r8 = getMaxSize();
    L10:
        if (r0.size() <= r8) goto L14;
        if ((!r0.entrySet().isEmpty()) == false) goto L10;
        r0.remove(((Map.Entry) CollectionsKt.first(r0.entrySet())).getKey());
        goto L10
    L14:
        return;
    L7:
        r0 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(r5, r6)});
        this.cacheResult.put(r4, r0);
        goto L8
    }
}
