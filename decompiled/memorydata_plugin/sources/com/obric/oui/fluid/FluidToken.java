package com.obric.oui.fluid;

import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.material.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007J&\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00182\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/fluid/FluidToken;", "", "()V", "OUI_Effect_Fluid_Regular_Dark", "Lcom/obric/oui/fluid/FluidConfig;", "OUI_Effect_Fluid_Regular_Light", "OUI_Effect_Fluid_Thin_Dark", "OUI_Effect_Fluid_Thin_Light", "tokens", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "parse", ActivityLifecycle.NAME, "register", "", "customTokenOwner", "overrideExisting", "", "registerTokens", "customTokens", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidToken {
    public static final FluidToken INSTANCE = null;
    public static final a OUI_Effect_Fluid_Regular_Dark = null;
    public static final a OUI_Effect_Fluid_Regular_Light = null;
    public static final a OUI_Effect_Fluid_Thin_Dark = null;
    public static final a OUI_Effect_Fluid_Thin_Light = null;
    private static final Lazy tokens$delegate = null;

    static {
        INSTANCE = new FluidToken();
        tokens$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(FluidToken$tokens$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        b r0 = FluidTokenCore.OUI_Effect_Fluid_Thin_Light;
        Intrinsics.checkNotNullExpressionValue(r0, "OUI_Effect_Fluid_Thin_Light");
        OUI_Effect_Fluid_Thin_Light = c.a(r0);
        b r1 = FluidTokenCore.OUI_Effect_Fluid_Thin_Dark;
        Intrinsics.checkNotNullExpressionValue(r1, "OUI_Effect_Fluid_Thin_Dark");
        OUI_Effect_Fluid_Thin_Dark = c.a(r1);
        b r2 = FluidTokenCore.OUI_Effect_Fluid_Regular_Light;
        Intrinsics.checkNotNullExpressionValue(r2, "OUI_Effect_Fluid_Regular_Light");
        OUI_Effect_Fluid_Regular_Light = c.a(r2);
        b r3 = FluidTokenCore.OUI_Effect_Fluid_Regular_Dark;
        Intrinsics.checkNotNullExpressionValue(r3, "OUI_Effect_Fluid_Regular_Dark");
        OUI_Effect_Fluid_Regular_Dark = c.a(r3);
    }

    private FluidToken() {
    }

    private final ConcurrentHashMap<String, a> getTokens() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokens$delegate.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final a parse(String r4) {
        return (a) ZeusTransformUtils.preCheckCast(n.f14027a.a(r4, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.memorydata.plugin")), a.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final void register(Object r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "customTokenOwner");
        n r0 = n.f14027a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (a.class.isAssignableFrom(r8.getType()) == false) goto L4;
        r8.setAccessible(true);     // Catch: Exception -> L11
        Object r9 = r8.get(r12);     // Catch: Exception -> L11
        if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L4;
        String r10 = r8.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "field.name");     // Catch: Exception -> L11
        Locale r11 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r11, "ROOT");     // Catch: Exception -> L11
        String r14 = r10.toLowerCase(r11);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        r4.put(r14, r9);     // Catch: Exception -> L11
    L13:
        r0.a(r1, r4, r13);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r12.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L13
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, a> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "customTokens");
        n.f14027a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.memorydata.plugin"), r6, r5);
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }
}
