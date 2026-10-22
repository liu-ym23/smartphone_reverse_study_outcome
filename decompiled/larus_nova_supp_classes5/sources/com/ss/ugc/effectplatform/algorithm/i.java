package com.ss.ugc.effectplatform.algorithm;

import android.content.Context;
import android.content.res.AssetManager;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.g;
import bytekn.foundation.logger.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i {
    public static final ConcurrentHashMap<String, ArrayList<String>> a = null;
    public static volatile Method b;
    public static volatile Class<?> c;
    public static volatile boolean d;
    public static final i e = null;

    public i() {
    }

    static {
        e = new i();
        a = new ConcurrentHashMap();
        d = true;
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("effect", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> effect");
        com.bytedance.librarian.a.c("effect");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> effect");
    }

    public static String[] b(String[] r7) {
        Object r3 = null;
        if (c != null) goto L5;
    L6:
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L49;
        Class<?> r4 = Class.forName("com.bef.effectsdk.RequirementResourceMapper");     // Catch: Throwable -> L12
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L34;
        FastClassNotFoundHandler.a("com.bef.effectsdk.RequirementResourceMapper");     // Catch: Throwable -> L12
    L34:
        c = r4;
        Class<?> r2 = c;
        if (r2 == null) goto L37;
        Method r5 = r2.getDeclaredMethod("peekResourcesNeededByRequirements", new Class[]{String[].class});
    L38:
        b = r5;
        Method r6 = b;
        if (r6 == null) goto L41;
        r6.setAccessible(true);
    L41:
        Method r8 = b;
        if (r8 == null) goto L45;
        r3 = r8.invoke(null, new Object[]{r7});
    L45:
        return (String[]) r3;
    L37:
        r5 = null;
    L12:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.b("com.bef.effectsdk.RequirementResourceMapper");
    L16:
        throw th;
    L49:
        r4 = Class.forName("com.bef.effectsdk.RequirementResourceMapper");     // Catch: Throwable -> L21
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L34;
        FastClassNotFoundHandler.a("com.bef.effectsdk.RequirementResourceMapper");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L26;
        FastClassNotFoundHandler.b("com.bef.effectsdk.RequirementResourceMapper");
    L26:
        if ((th instanceof PluginClassNotFoundException) == false) goto L28;
        throw th;
    L28:
        if ((th instanceof ClassNotFoundException) == false) goto L30;
    L33:
        r4 = MiraPluginFix.forName("com.bef.effectsdk.RequirementResourceMapper");
        goto L34
    L30:
        if ((th instanceof NoClassDefFoundError) == true) goto L33;
        throw th;
    L5:
        if (b != null) goto L41;
        goto L6
    }

    public static String[] c(String[] r3) {
        return b(r3);
    L4:
        e = move-exception;
        Throwable r4 = e.getTargetException();
        r4.printStackTrace();
        if ((r4 instanceof UnsatisfiedLinkError) == false) goto L9;
        throw r4;
    L9:
        throw new Exception("Effect SDK try failed - " + bytekn.foundation.utils.b.a(r4, 4));
    }

    @JvmStatic
    public static final String[] d(String[] r11, dlc.a r12, Object r13) {
        boolean r1 = true;
        if (r11.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        ConcurrentHashMap<String, ArrayList<String>> r3 = a;
        g r4 = null;
        if (r3.isEmpty() == false) goto L65;
        i r5 = e;
        monitor-enter(r5);
    L61:
        th = move-exception;
        throw th;
    L17:
        if (r3.isEmpty() == true) goto L19;
    L59:
        monitor-exit(r5);
        goto L65
    L19:
        if (d == false) goto L59;
        if (r13 == null) goto L58;
        AssetManager r14 = ((Context) r13).getApplicationContext().getAssets();     // Catch: Throwable -> L61
        g r6 = new bytekn.foundation.io.file.b();     // Catch: Throwable -> L43 Exception -> L47
        InputStream r15 = r14.open("model/resources.json", 2);     // Catch: Throwable -> L43 Exception -> L47
        ((bytekn.foundation.io.file.b) r6).a = r15;     // Catch: Throwable -> L43 Exception -> L47
        if (r12 == null) goto L31;
        if (r15 == null) goto L122;
    L30:
        Map<? extends String, ? extends ArrayList<String>> r16 = (Map) r12.a.convertJsonToObj(new String(ByteStreamsKt.readBytes(r15), Charsets.UTF_8), Map.class);     // Catch: Throwable -> L27 Exception -> L29
    L32:
        if (r16 != null) goto L34;
    L37:
        boolean r17 = true;
    L38:
        if (r17 == true) goto L42;
        r3.clear();     // Catch: Throwable -> L27 Exception -> L29
        r3.putAll(r16);     // Catch: Throwable -> L27 Exception -> L29
    L27:
        th = th;
        r4 = r6;
    L44:
        if (r4 == null) goto L46;
        String r18 = FileManager.a;     // Catch: Throwable -> L61
        FileManager.b(r4);     // Catch: Throwable -> L61
    L46:
        throw th;     // Catch: Throwable -> L61
    L48:
        if (r6 != null) goto L42;
    L52:
        if (a.isEmpty() == false) goto L54;
        d = false;     // Catch: Throwable -> L61
    L54:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L61
        monitor-exit(r5);
    L42:
        String r110 = FileManager.a;     // Catch: Throwable -> L61
        FileManager.b(r6);     // Catch: Throwable -> L61
        goto L52
    L34:
        if (r16.isEmpty() == true) goto L37;
        r17 = false;
        goto L38
    L122:
        Intrinsics.throwUninitializedPropertyAccessException("inputStream");     // Catch: Throwable -> L27 Exception -> L29
        goto L30
    L31:
        r16 = null;
        goto L32
    L47:
        r6 = null;
    L43:
        th = th;
        goto L44
    L58:
        throw new TypeCastException("null cannot be cast to non-null type android.content.Context");     // Catch: Throwable -> L61
    L65:
        if (a.isEmpty() == true) goto L77;
        HashSet r111 = new HashSet();
        int r112 = r11.length;
        int r7 = 0;
    L67:
        if (r7 >= r112) goto L72;
        ArrayList<String> r8 = a.get(r11[r7]);
        if (r8 == null) goto L71;
        r111.addAll(r8);
    L71:
        r7 = r7 + 1;
        goto L67
    L72:
        Object[] r113 = r111.toArray(new String[0]);
        if (r113 == null) goto L76;
        String[] r114 = (String[]) r113;
    L78:
        if (r114 != null) goto L80;
    L86:
        if (r1 == true) goto L117;
        return r114;
    L117:
        return c(r11);
    L90:
        Logger.e$default(Logger.INSTANCE, "RequirementResourceMapper", "not load effect so", null, 4, null);
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L93
        b.a.loadLibrary("effect");     // Catch: Throwable -> L93
        Object r116 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L93
    L96:
        if (Result.isFailure-impl(r116) == false) goto L106;
        Logger r9 = Logger.INSTANCE;
        StringBuilder r117 = new StringBuilder("load effect so error: ");
        Throwable r118 = Result.exceptionOrNull-impl(r116);
        if (r118 == null) goto L100;
        r4 = r118.getMessage();
    L100:
        r117.append(r4);
        Logger.e$default(r9, "RequirementResourceMapper", r117.toString(), null, 4, null);
        a();     // Catch: Throwable -> L103
        r116 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
    L106:
        if (Result.isSuccess-impl(r116) == false) goto L112;
        return c(r11);
    L110:
        throw new Exception("Effect SDK retry suc, but invoke failed - UnsatisfiedLinkError");
    L112:
        throw new Exception("Effect SDK retry failed - UnsatisfiedLinkError");
    L93:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L96
    L80:
        if (r114.length != 0) goto L82;
        boolean r121 = true;
    L83:
        if (r121 == true) goto L86;
        r1 = false;
        goto L86
    L82:
        r121 = false;
        goto L83
    L76:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L77:
        r114 = null;
        goto L78
    L11:
        return new String[0];
    L8:
        r2 = false;
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}
