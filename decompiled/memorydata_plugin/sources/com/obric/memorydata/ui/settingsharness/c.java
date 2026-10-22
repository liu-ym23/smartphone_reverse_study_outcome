package com.obric.memorydata.ui.settingsharness;

import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0005J\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsActionCoordinator;", "", "<init>", "()V", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "pendingRows", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "pendingSwitchTargets", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "openBinding", "invalidateBinding", "", "isCurrent", "expectedGeneration", "tryStart", "action", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "pageState", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageState;", "finish", "rowId", "snapshot", "Lcom/obric/memorydata/ui/settingsharness/SettingsPendingSnapshot;", "clearPending", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f13034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<String> f13035b;
    private final LinkedHashMap<String, Boolean> c;

    public c() {
        this.f13035b = new LinkedHashSet();
        this.c = new LinkedHashMap();
    }

    private final void d() {
        this.f13035b.clear();
        this.c.clear();
    }

    public final long a() {
        this.f13034a++;
        d();
        return this.f13034a;
    }

    public final boolean a(long r3) {
        if (r3 != this.f13034a) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(long r3, b r5, i r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "action");
        Intrinsics.checkNotNullParameter(r6, "pageState");
        if (a(r3) == true) goto L5;
    L22:
        return false;
    L5:
        if (this.f13035b.contains(r7.a()) == true) goto L22;
        o r4 = (o) ZeusTransformUtils.preCheckCast(r6.a().get(r7.a()), o.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
        return false;
    L11:
        if (r4.a() == false) goto L22;
        if (r4.b() == false) goto L22;
        if (r4.c() == true) goto L22;
        ((Collection) ZeusTransformUtils.preCheckCast(this.f13035b, Collection.class, "com.obric.memorydata.plugin")).add(r7.a());
        if (ZeusTransformUtils.instanceOf(r7, b.c.class) == false) goto L23;
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(((b.c) ZeusTransformUtils.preCheckCast(r7, b.c.class, "com.obric.memorydata.plugin")).a(), Boolean.valueOf(((b.c) ZeusTransformUtils.preCheckCast(r7, b.c.class, "com.obric.memorydata.plugin")).b()));
        return true;
    L23:
        return true;
    }

    public final boolean a(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "rowId");
        if (a(r2) == true) goto L5;
        return false;
    L5:
        if (this.f13035b.remove(r4) == false) goto L11;
        this.c.remove(r4);
        return true;
    L11:
        return false;
    }

    public final void b() {
        this.f13034a++;
        d();
    }

    public final k c() {
        return new k(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(this.f13035b, Iterable.class, "com.obric.memorydata.plugin")), MapsKt.toMap((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")));
    }
}
