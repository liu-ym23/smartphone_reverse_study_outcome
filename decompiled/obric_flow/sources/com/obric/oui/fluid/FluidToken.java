package com.obric.oui.fluid;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.room.jarjarred.org.antlr.v4.gui.TestRig;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0011\u0010\u0012R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/fluid/FluidToken;", "", "<init>", "()V", "", "name", "Lcom/obric/oui/fluid/a;", "parse", "(Ljava/lang/String;)Lcom/obric/oui/fluid/a;", "customTokenOwner", "", "overrideExisting", "", "register", "(Ljava/lang/Object;Z)V", "", "customTokens", "registerTokens", "(Ljava/util/Map;Z)V", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", TestRig.LEXER_START_RULE_NAME, "OUI_Effect_Fluid_Thin_Light", "Lcom/obric/oui/fluid/a;", "OUI_Effect_Fluid_Thin_Dark", "OUI_Effect_Fluid_Regular_Light", "OUI_Effect_Fluid_Regular_Dark", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidToken {
    public static final FluidToken INSTANCE = null;

    @JvmField
    public static final a OUI_Effect_Fluid_Regular_Dark = null;

    @JvmField
    public static final a OUI_Effect_Fluid_Regular_Light = null;

    @JvmField
    public static final a OUI_Effect_Fluid_Thin_Dark = null;

    @JvmField
    public static final a OUI_Effect_Fluid_Thin_Light = null;
    private static final Lazy tokens$delegate = null;

    static {
        INSTANCE = new FluidToken();
        tokens$delegate = LazyKt.lazy(FluidToken$tokens$2.INSTANCE);
        OUI_Effect_Fluid_Thin_Light = b.f13228c;
        OUI_Effect_Fluid_Thin_Dark = b.d;
        OUI_Effect_Fluid_Regular_Light = b.f13226a;
        OUI_Effect_Fluid_Regular_Dark = b.f13227b;
    }

    private FluidToken() {
    }

    private final ConcurrentHashMap<String, a> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final a parse(String r5) {
        ConcurrentHashMap<String, a> r10 = INSTANCE.getTokens();
        Intrinsics.checkNotNullParameter(r10, TestRig.LEXER_START_RULE_NAME);
        a r11 = null;
        if (r5 != null) goto L5;
    L4:
        String r12 = null;
    L9:
        if (r12 == null) goto L15;
        if (r12.length() == 0) goto L15;
        r11 = r10.get(r12);
    L15:
        return r11;
    L5:
        String r13 = r5.toLowerCase(Locale.ROOT);
        if (r13 == null) goto L4;
        r12 = StringsKt.trim(r13).toString();
        goto L9
    }

    @JvmStatic
    public static final void register(Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "customTokenOwner");
        ConcurrentHashMap<String, a> r5 = INSTANCE.getTokens();
        LinkedHashMap r12 = new LinkedHashMap();
        Field[] r13 = r10.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r14 = r13.length;     // Catch: Exception -> L11
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L13;
        Field r16 = r13[r15];     // Catch: Exception -> L11
        r15 = r15 + 1;     // Catch: Exception -> L11
        if (a.class.isAssignableFrom(r16.getType()) == false) goto L4;
        r16.setAccessible(true);     // Catch: Exception -> L11
        Object r17 = r16.get(r10);     // Catch: Exception -> L11
        if ((r17 instanceof a) == false) goto L4;
        r12.put(r16.getName().toLowerCase(Locale.ROOT), r17);     // Catch: Exception -> L11
    L13:
        cl.a.K(r5, r12, r11);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r10.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void register$default(Object r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        register(r5, r10);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, a> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        cl.a.K(INSTANCE.getTokens(), r5, r10);
    }

    public static /* synthetic */ void registerTokens$default(Map r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerTokens(r5, r10);
    }
}
