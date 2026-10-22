package com.obric.memorydata.realtimecontext.cache;

import android.content.ComponentName;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.memorydata.realtimecontext.screen.ScreenViewTree;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B=\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003JI\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u00060"}, d2 = {"Lcom/obric/memorydata/realtimecontext/cache/ViewTreeCache;", "Lcom/obric/memorydata/realtimecontext/cache/BaseCache;", "Lcom/obric/memorydata/realtimecontext/screen/ScreenViewTree;", "key", "state", "Lcom/obric/memorydata/realtimecontext/cache/State;", "componentName", "Landroid/content/ComponentName;", "appEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "metaValues", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "<init>", "(Lcom/obric/memorydata/realtimecontext/screen/ScreenViewTree;Lcom/obric/memorydata/realtimecontext/cache/State;Landroid/content/ComponentName;Ljava/util/List;Ljava/util/List;)V", "getKey", "()Lcom/obric/memorydata/realtimecontext/screen/ScreenViewTree;", "setKey", "(Lcom/obric/memorydata/realtimecontext/screen/ScreenViewTree;)V", "getState", "()Lcom/obric/memorydata/realtimecontext/cache/State;", "setState", "(Lcom/obric/memorydata/realtimecontext/cache/State;)V", "getComponentName", "()Landroid/content/ComponentName;", "setComponentName", "(Landroid/content/ComponentName;)V", "getAppEntities", "()Ljava/util/List;", "setAppEntities", "(Ljava/util/List;)V", "getMetaValues", "setMetaValues", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g extends com.obric.memorydata.realtimecontext.cache.a<ScreenViewTree> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScreenViewTree f12460b;
    private State c;
    private ComponentName d;
    private List<? extends AppEntity> e;
    private List<? extends MetaValue> f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/realtimecontext/cache/ViewTreeCache$Companion;", "", "<init>", "()V", "dummy", "Lcom/obric/memorydata/realtimecontext/cache/ViewTreeCache;", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final g a() {
            return new g(null, State.CLEARED, new ComponentName("", ""), CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
    }

    static {
        f12459a = new a(null);
    }

    public g(ScreenViewTree r9, State r10, ComponentName r11, List<? extends AppEntity> r12, List<? extends MetaValue> r13) {
        List<? extends AppEntity> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<? extends MetaValue> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "componentName");
        Intrinsics.checkNotNullParameter(r14, "appEntities");
        Intrinsics.checkNotNullParameter(r15, "metaValues");
        super(r9, r10, r11, r14, r15);
        this.f12460b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r14;
        this.f = r15;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public /* synthetic */ ScreenViewTree a() {
        return g();
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public void a(ComponentName r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public void a(State r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(ScreenViewTree r1) {
        this.f12460b = r1;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public /* synthetic */ void a(ScreenViewTree r3) {
        a2((ScreenViewTree) ZeusTransformUtils.preCheckCast(r3, ScreenViewTree.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public void a(List<? extends AppEntity> r3) {
        List<? extends AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.e = r4;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public State b() {
        return this.c;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public void b(List<? extends MetaValue> r3) {
        List<? extends MetaValue> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f = r4;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public ComponentName c() {
        return this.d;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public List<AppEntity> d() {
        return this.e;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public List<MetaValue> e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12460b, r6.f12460b) == true) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public ScreenViewTree g() {
        return this.f12460b;
    }

    public int hashCode() {
        ScreenViewTree r0 = this.f12460b;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((r1 * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ViewTreeCache(key=" + this.f12460b + ", state=" + this.c + ", componentName=" + this.d + ", appEntities=" + this.e + ", metaValues=" + this.f + ')';
    }
}
