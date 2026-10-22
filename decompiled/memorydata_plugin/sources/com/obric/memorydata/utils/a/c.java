package com.obric.memorydata.utils.a;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/utils/appstate/AppStateRegistrationStrategyFactory;", "", "<init>", "()V", "TAG", "", "FOCUS_SWITCH_FEATURE", "createCandidates", "", "Lcom/obric/memorydata/utils/appstate/AppStateRegistrationStrategy;", "callback", "Lcom/obric/memorydata/utils/appstate/AppStateRegistrationCallback;", "isFocusSwitchSupported", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13148a = null;

    static {
        f13148a = new c();
    }

    private c() {
    }

    private static final List a(a r2, e r3) {
        return CollectionsKt.listOf(new b[]{new d((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")), r3});
    }

    private static final List a(e r7, Exception r8) {
        Intrinsics.checkNotNullParameter(r8, "e");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppStateStrategyFactory", "create focus strategy failed, fallback to legacy: " + r8.getMessage(), null, 4, null);
        return CollectionsKt.listOf(r7);
    }

    private final boolean a() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(y.a($$Lambda$c$a175Q3qBw2yhVpSV4NO1TXY95so.INSTANCE, $$Lambda$c$CaKhbiRCFFgXJcUcdwb0JQVRbI8.INSTANCE), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.booleanValue();
    }

    private static final boolean a(Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "e");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppStateStrategyFactory", "isOsFeatureSupported key=obric.focus.switch failed, fallback to legacy: " + r7.getMessage(), null, 4, null);
        return false;
    }

    private static final boolean b() {
        boolean r0 = com.obric.aiagent.product.a.a.f5964a.a("obric.focus.switch");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppStateStrategyFactory", "isOsFeatureSupported key=obric.focus.switch, supported=" + r0, false, 4, null);
        return r0;
    }

    public static /* synthetic */ boolean lambda$CaKhbiRCFFgXJcUcdwb0JQVRbI8() {
        return b();
    }

    public static /* synthetic */ List lambda$O37Zks9nIPp4qnmgk7tMqRkw_Zc(e r0, Exception r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ List lambda$TUkF0_ckYAwy0s5hCWwMb848aBk(a r0, e r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$a175Q3qBw2yhVpSV4NO1TXY95so(Exception r0) {
        return a(r0);
    }

    public final List<b> a(a r4) {
        final a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "callback");
        final e r0 = new e(r5);
        if (a() == false) goto L5;
        List<b> r3 = (List) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$c$O37Zks9nIPp4qnmgk7tMqRkw_Zc(r0), new $$Lambda$c$TUkF0_ckYAwy0s5hCWwMb848aBk(r5, r0)), List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        return r3;
    L9:
        return CollectionsKt.listOf(r0);
    L5:
        return CollectionsKt.listOf(r0);
    }
}
