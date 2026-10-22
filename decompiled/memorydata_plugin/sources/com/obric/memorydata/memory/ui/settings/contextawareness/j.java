package com.obric.memorydata.memory.ui.settings.contextawareness;

import android.content.Context;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsStateOwner;", "", "gateway", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsGateway;", "<init>", "(Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsGateway;)V", "_snapshot", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsSnapshot;", "snapshot", "Lkotlinx/coroutines/flow/StateFlow;", "getSnapshot", "()Lkotlinx/coroutines/flow/StateFlow;", "authorityChanges", "Lkotlinx/coroutines/flow/Flow;", "", "getAuthorityChanges", "()Lkotlinx/coroutines/flow/Flow;", "refresh", "changeSystemApp", "", "app", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSystemApp;", "enabled", "changeGlobalSource", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessGlobalSource;", "changeCellularUpload", "changeEnhancedTimeliness", "changeRecorderAmbientVoiceCollectionDebug", "openScreenContentSettings", "context", "Landroid/content/Context;", "openRecorderSettings", "openSmartGlassesSettings", "openBlockMemorySettings", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f11458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ae<i> f11459b;
    private final ar<i> c;
    private final kotlinx.coroutines.flow.i<Unit> d;

    /* JADX WARN: Multi-variable type inference failed */
    public j() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public j(f r10) {
        f r11 = (f) ZeusTransformUtils.wrapperContextForParams(r10, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "gateway");
        this.f11458a = r11;
        ae<i> r0 = at.a(r11.h());
        this.f11459b = r0;
        this.c = (ar) ZeusTransformUtils.preCheckCast(r0, ar.class, "com.obric.memorydata.plugin");
        this.d = kotlinx.coroutines.flow.k.a(kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r11.a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r11.b(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r11.c(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r11.d(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r11.e(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function6) ZeusTransformUtils.preCheckCast(new ContextAwarenessSettingsStateOwner$authorityChanges$1(null), Function6.class, "com.obric.memorydata.plugin")), r11.g(), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r11.f(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function4) ZeusTransformUtils.preCheckCast(new ContextAwarenessSettingsStateOwner$authorityChanges$2(null), Function4.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ j(f r9, int r10, DefaultConstructorMarker r11) {
        f r12 = (f) ZeusTransformUtils.wrapperContextForParams(r9, f.class, "com.obric.memorydata.plugin");
        if ((r10 & 1) == 0) goto L5;
        r12 = (f) ZeusTransformUtils.preCheckCast(new n(null, null, null, null, 15, null), f.class, "com.obric.memorydata.plugin");
    L5:
        this(r12);
    }

    public final ar<i> a() {
        return this.c;
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f11458a.a(r4);
    }

    public final boolean a(ContextAwarenessGlobalSource r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        boolean r0 = this.f11458a.a(r3, r4);
        c();
        if (r0 == true) goto L5;
    L7:
        return false;
    L5:
        if (g.a((i) ZeusTransformUtils.preCheckCast(this.c.c(), i.class, "com.obric.memorydata.plugin"), r3) != r4) goto L7;
        return true;
    }

    public final boolean a(ContextAwarenessSystemApp r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "app");
        boolean r0 = this.f11458a.a(r3, r4);
        c();
        if (r0 == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((i) ZeusTransformUtils.preCheckCast(this.c.c(), i.class, "com.obric.memorydata.plugin")).f().get(r3), Boolean.valueOf(r4)) == false) goto L7;
        return true;
    }

    public final boolean a(boolean r3) {
        this.f11458a.a(r3);
        c();
        if (((i) ZeusTransformUtils.preCheckCast(this.c.c(), i.class, "com.obric.memorydata.plugin")).k() != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public final kotlinx.coroutines.flow.i<Unit> b() {
        return this.d;
    }

    public final boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return this.f11458a.b(r4);
    }

    public final boolean b(boolean r3) {
        boolean r0 = this.f11458a.b(r3);
        c();
        if (r0 == true) goto L5;
    L7:
        return false;
    L5:
        if (((i) ZeusTransformUtils.preCheckCast(this.c.c(), i.class, "com.obric.memorydata.plugin")).n() != r3) goto L7;
        return true;
    }

    public final void c() {
        this.f11459b.b(this.f11458a.h());
    }

    public final boolean c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return this.f11458a.c(r4);
    }

    public final boolean c(boolean r3) {
        boolean r0 = this.f11458a.c(r3);
        c();
        if (r0 == true) goto L5;
    L7:
        return false;
    L5:
        if (((i) ZeusTransformUtils.preCheckCast(this.c.c(), i.class, "com.obric.memorydata.plugin")).p() != r3) goto L7;
        return true;
    }

    public final void d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f11458a.d(r4);
    }
}
