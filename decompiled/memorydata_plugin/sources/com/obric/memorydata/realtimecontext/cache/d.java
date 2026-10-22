package com.obric.memorydata.realtimecontext.cache;

import android.content.ComponentName;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 .2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001.BC\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002HÆ\u0003JO\u0010&\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002HÆ\u0001J\u0013\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011¨\u0006/"}, d2 = {"Lcom/obric/memorydata/realtimecontext/cache/DonationCache;", "Lcom/obric/memorydata/realtimecontext/cache/BaseCache;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "key", "state", "Lcom/obric/memorydata/realtimecontext/cache/State;", "componentName", "Landroid/content/ComponentName;", "appEntities", "metaValues", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/realtimecontext/cache/State;Landroid/content/ComponentName;Ljava/util/List;Ljava/util/List;)V", "getKey", "()Ljava/util/List;", "setKey", "(Ljava/util/List;)V", "getState", "()Lcom/obric/memorydata/realtimecontext/cache/State;", "setState", "(Lcom/obric/memorydata/realtimecontext/cache/State;)V", "getComponentName", "()Landroid/content/ComponentName;", "setComponentName", "(Landroid/content/ComponentName;)V", "getAppEntities", "setAppEntities", "getMetaValues", "setMetaValues", "sameKey", "", "new", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends com.obric.memorydata.realtimecontext.cache.a<List<? extends AppEntity>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<? extends AppEntity> f12454b;
    private State c;
    private ComponentName d;
    private List<? extends AppEntity> e;
    private List<? extends MetaValue> f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/realtimecontext/cache/DonationCache$Companion;", "", "<init>", "()V", "dummy", "Lcom/obric/memorydata/realtimecontext/cache/DonationCache;", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final d a() {
            return new d(null, State.CLEARED, new ComponentName("", ""), CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
    }

    static {
        f12453a = new a(null);
    }

    public d(List<? extends AppEntity> r9, State r10, ComponentName r11, List<? extends AppEntity> r12, List<? extends MetaValue> r13) {
        List<? extends AppEntity> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<? extends AppEntity> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<? extends MetaValue> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r11, "componentName");
        Intrinsics.checkNotNullParameter(r15, "appEntities");
        Intrinsics.checkNotNullParameter(r16, "metaValues");
        super(r14, r10, r11, r15, r16);
        this.f12454b = r14;
        this.c = r10;
        this.d = r11;
        this.e = r15;
        this.f = r16;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public /* synthetic */ List<? extends AppEntity> a() {
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

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public /* synthetic */ void a(List<? extends AppEntity> r3) {
        c((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(List<? extends AppEntity> r3) {
        List<? extends AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.e = r4;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public State b() {
        return this.c;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.realtimecontext.cache.a
    public void b(List<? extends MetaValue> r3) {
        List<? extends MetaValue> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f = r4;
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public /* synthetic */ boolean b(List<? extends AppEntity> r3) {
        return d((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public ComponentName c() {
        return this.d;
    }

    public void c(List<? extends AppEntity> r3) {
        this.f12454b = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public List<AppEntity> d() {
        return this.e;
    }

    public boolean d(List<? extends AppEntity> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "new");
        List<AppEntity> r0 = g();
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        if (r1 != r7.hashCode()) goto L21;
        List<AppEntity> r5 = g();
        if (r5 != null) goto L11;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == true) goto L20;
        return false;
    L20:
        return true;
    L11:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        if (Intrinsics.areEqual(((AppEntity) ZeusTransformUtils.preCheckCast(r7.get(0), AppEntity.class, "com.obric.memorydata.plugin")).getExtra(), ((AppEntity) ZeusTransformUtils.preCheckCast(r5.get(0), AppEntity.class, "com.obric.memorydata.plugin")).getExtra()) == false) goto L17;
        r8 = true;
        goto L18
    L21:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.obric.memorydata.realtimecontext.cache.a
    public List<MetaValue> e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12454b, r6.f12454b) == true) goto L12;
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

    public List<AppEntity> g() {
        return this.f12454b;
    }

    public int hashCode() {
        List<? extends AppEntity> r0 = this.f12454b;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((r1 * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "DonationCache(key=" + this.f12454b + ", state=" + this.c + ", componentName=" + this.d + ", appEntities=" + this.e + ", metaValues=" + this.f + ')';
    }
}
