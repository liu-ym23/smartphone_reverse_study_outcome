package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001b\u0010\b\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "type", "", ActivityLifecycle.NAME, "json", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "depVersion", "getDepVersion", "()Ljava/lang/String;", "depVersion$delegate", "Lkotlin/Lazy;", "res", "", "getRes", "()Ljava/util/List;", "res$delegate", "getResources", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class k extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f6075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f6076b;

    public k(String r2, String r3, final JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "json");
        super(r2, r3, r4);
        this.f6075a = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new UpdateTaskConfig$depVersion$2(r4), Function0.class, "com.obric.memorydata.plugin"));
        this.f6076b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new UpdateTaskConfig$res$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public List<a> getResources() {
        return CollectionsKt.emptyList();
    }

    public final String l() {
        return (String) ZeusTransformUtils.preCheckCast(this.f6075a.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final List<a> m() {
        return (List) ZeusTransformUtils.preCheckCast(this.f6076b.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public String toString() {
        return a() + '@' + c() + '@' + l() + '|' + getType();
    }
}
