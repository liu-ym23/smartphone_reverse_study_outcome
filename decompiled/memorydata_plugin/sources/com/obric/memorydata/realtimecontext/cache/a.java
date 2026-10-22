package com.obric.memorydata.realtimecontext.cache;

import android.content.ComponentName;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B=\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020'H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f¨\u0006("}, d2 = {"Lcom/obric/memorydata/realtimecontext/cache/BaseCache;", "K", "", "key", "state", "Lcom/obric/memorydata/realtimecontext/cache/State;", "componentName", "Landroid/content/ComponentName;", "appEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "metaValues", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "<init>", "(Ljava/lang/Object;Lcom/obric/memorydata/realtimecontext/cache/State;Landroid/content/ComponentName;Ljava/util/List;Ljava/util/List;)V", "getKey", "()Ljava/lang/Object;", "setKey", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getState", "()Lcom/obric/memorydata/realtimecontext/cache/State;", "setState", "(Lcom/obric/memorydata/realtimecontext/cache/State;)V", "getComponentName", "()Landroid/content/ComponentName;", "setComponentName", "(Landroid/content/ComponentName;)V", "getAppEntities", "()Ljava/util/List;", "setAppEntities", "(Ljava/util/List;)V", "getMetaValues", "setMetaValues", "sameKey", "", "new", "(Ljava/lang/Object;)Z", "clear", "", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class a<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private K f12447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private State f12448b;
    private ComponentName c;
    private List<? extends AppEntity> d;
    private List<? extends MetaValue> e;

    public a(K r3, State r4, ComponentName r5, List<? extends AppEntity> r6, List<? extends MetaValue> r7) {
        List<? extends AppEntity> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<? extends MetaValue> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "componentName");
        Intrinsics.checkNotNullParameter(r8, "appEntities");
        Intrinsics.checkNotNullParameter(r9, "metaValues");
        this.f12447a = r3;
        this.f12448b = r4;
        this.c = r5;
        this.d = r8;
        this.e = r9;
    }

    public K a() {
        return this.f12447a;
    }

    public void a(ComponentName r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public void a(State r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f12448b = r2;
    }

    public void a(K r1) {
        this.f12447a = r1;
    }

    public void a(List<? extends AppEntity> r3) {
        List<? extends AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.d = r4;
    }

    public State b() {
        return this.f12448b;
    }

    public void b(List<? extends MetaValue> r3) {
        List<? extends MetaValue> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.e = r4;
    }

    public boolean b(K r1) {
        return Intrinsics.areEqual(r1, a());
    }

    public ComponentName c() {
        return this.c;
    }

    public List<AppEntity> d() {
        return this.d;
    }

    public List<MetaValue> e() {
        return this.e;
    }

    public void f() {
        a(null);
        a(State.CLEARED);
        a(new ComponentName("", ""));
        b(CollectionsKt.emptyList());
        a(CollectionsKt.emptyList());
    }
}
