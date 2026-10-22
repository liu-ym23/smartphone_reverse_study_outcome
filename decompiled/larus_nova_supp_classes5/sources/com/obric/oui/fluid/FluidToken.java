package com.obric.oui.fluid;

import com.obric.oui.material.r;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J&\u0010\r\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/fluid/FluidToken;", "", "", DBDefinition.NAME, "Lcom/obric/oui/fluid/a;", "parse", "customTokenOwner", "", "overrideExisting", "", "register", "", "customTokens", "registerTokens", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens", "OUI_Effect_Fluid_Thin_Light", "Lcom/obric/oui/fluid/a;", "OUI_Effect_Fluid_Thin_Dark", "OUI_Effect_Fluid_Regular_Light", "OUI_Effect_Fluid_Regular_Dark", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class FluidToken {
    public static final FluidToken INSTANCE = null;
    public static final a OUI_Effect_Fluid_Regular_Dark = null;
    public static final a OUI_Effect_Fluid_Regular_Light = null;
    public static final a OUI_Effect_Fluid_Thin_Dark = null;
    public static final a OUI_Effect_Fluid_Thin_Light = null;
    private static final Lazy tokens$delegate = null;

    private FluidToken() {
    }

    static {
        INSTANCE = new FluidToken();
        tokens$delegate = LazyKt.lazy(FluidToken$tokens$2.INSTANCE);
        OUI_Effect_Fluid_Thin_Light = c.a(FluidTokenCore.OUI_Effect_Fluid_Thin_Light);
        OUI_Effect_Fluid_Thin_Dark = c.a(FluidTokenCore.OUI_Effect_Fluid_Thin_Dark);
        OUI_Effect_Fluid_Regular_Light = c.a(FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Effect_Fluid_Regular_Dark = c.a(FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
    }

    private final ConcurrentHashMap<String, a> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final a parse(String r1) {
        int r0 = r.a;
        return (a) r.a(r1, INSTANCE.getTokens());
    }

    @JvmStatic
    public static final void register(Object r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "customTokenOwner");
        int r0 = r.a;
        ConcurrentHashMap<String, a> r1 = INSTANCE.getTokens();
        LinkedHashMap r2 = new LinkedHashMap();
        Field[] r3 = r9.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r4 = r3.length;     // Catch: Exception -> L11
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L12;
        Field r6 = r3[r5];     // Catch: Exception -> L11
        r5 = r5 + 1;     // Catch: Exception -> L11
        if (a.class.isAssignableFrom(r6.getType()) == false) goto L4;
        r6.setAccessible(true);     // Catch: Exception -> L11
        Object r7 = r6.get(r9);     // Catch: Exception -> L11
        if ((r7 instanceof a) == false) goto L4;
        r2.put(r6.getName().toLowerCase(Locale.ROOT), r7);     // Catch: Exception -> L11
    L12:
        r.b(r1, r2, r10);
        return;
    L11:
        Intrinsics.stringPlus("Failed to parse tokens from ", r9.getClass().getSimpleName());
        goto L12
    }

    @JvmStatic
    public static final void registerTokens(Map<String, a> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        int r0 = r.a;
        r.b(INSTANCE.getTokens(), r1, r2);
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    public static /* synthetic */ void registerTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerTokens(r0, r1);
    }
}
