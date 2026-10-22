package com.obric.memorydata.awareness.impl.gate;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\rH\u0016J*\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProviderRouter;", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProvider;", "kevaProvider", "systemSettingsProvider", "<init>", "(Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProvider;Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProvider;)V", "getBoolean", "", "repo", "", "key", "defaultValue", "getInt", "", "replaceObservedKeys", "", "keys", "", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;", "onChanged", "Lkotlin/Function1;", "release", "providerFor", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f8685b;
    private final d c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProviderRouter$Companion;", "", "<init>", "()V", "REPO_ANDROID_SETTINGS_SYSTEM", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8684a = new a(null);
    }

    public e(d r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "kevaProvider");
        Intrinsics.checkNotNullParameter(r6, "systemSettingsProvider");
        this.f8685b = r5;
        this.c = r6;
    }

    private final d a(String r2) {
        if (Intrinsics.areEqual(r2, "android.settings.system") == false) goto L6;
        return this.c;
    L6:
        return this.f8685b;
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public int a(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        Intrinsics.checkNotNullParameter(r3, "key");
        return a(r2).a(r2, r3, r4);
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public void a(Set<c> r7, Function1<? super c, Unit> r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Function1<? super c, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "keys");
        Intrinsics.checkNotNullParameter(r10, "onChanged");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin")).a(), "android.settings.system") == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        Set<c> r4 = (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin");
        this.c.a(r4, r10);
        this.f8685b.a(SetsKt.minus(r9, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), r10);
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public boolean a(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        Intrinsics.checkNotNullParameter(r3, "key");
        return a(r2).a(r2, r3, r4);
    }
}
