package com.bytedance.geckox;

import ai.j0;
import android.content.Context;
import android.net.Uri;
import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f4747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f4748b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f4749c = null;

    static {
        f4747a = new LinkedHashMap();
        f4748b = new AtomicBoolean(false);
        f4749c = new ConcurrentHashMap();
    }

    public static d a(Context r11, String r12, String r13, String r14) {
        String r5 = File.separator;
        if (StringsKt.P(r14, r5) == false) goto L5;
        String r10 = r14;
    L6:
        ConcurrentHashMap r15 = f4749c;
        String r16 = null;
        Long r17 = null;
        String r18 = null;
        if (r15.containsKey(r12 + r13) == false) goto L56;
        d r19 = (d) r15.get(r12 + r13);
        if (r19 == null) goto L11;
        String r20 = r19.f4743a;
    L13:
        if (Intrinsics.areEqual(r20, "deleted_path") == true) goto L50;
        if (r19 == null) goto L16;
        String r21 = r19.f4743a;
    L18:
        if (Intrinsics.areEqual(r21, "empty_path") == true) goto L50;
        StringBuilder r22 = new StringBuilder();
        if (r19 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        r22.append(r19.f4743a);
        r22.append(r10);
        Uri r23 = Uri.parse(r22.toString());
        String r24 = r23.getPath();
        if (r24 == null) goto L56;
        String r25 = r23.getScheme();
        if (r25 == null) goto L49;
        int r26 = r25.hashCode();
        if (r26 == 3143036) goto L42;
        if (r26 != 93121264) goto L49;
        if (r25.equals("asset") == false) goto L49;
        if (e(r11, r24) == true) goto L38;
        StringBuilder r27 = new StringBuilder("build-in bundle does not exist in assets path:");
        f8.b.e(r27, r19.f4743a, ",accessKey:", r12, ",channel:");
        return new d(null, null, f4.b.b(r27, r13, ",bundle:", r14));
    L38:
        return new d(r23.toString(), r19.f4744b);
    L42:
        if (r25.equals("file") == false) goto L49;
        if (new File(r23.getPath()).exists() == true) goto L46;
        StringBuilder r28 = new StringBuilder("build-in bundle does not exist in file path:");
        f8.b.e(r28, r19.f4743a, ",accessKey:", r12, ",channel:");
        return new d(null, null, f4.b.b(r28, r13, ",bundle:", r14));
    L46:
        return new d(r23.toString(), r19.f4744b);
    L49:
        StringBuilder r29 = new StringBuilder("build-in cached channel path:");
        f8.b.e(r29, r19.f4743a, " is incorrect,accessKey:", r12, ",channel:");
        r29.append(r13);
        r29.append(",bundle:");
        r29.append(r14);
        GeckoLogger.a(r29.toString());
        goto L56
    L16:
        r21 = null;
    L50:
        String r110 = r19.f4745c;
        if (r110 != null) goto L54;
        r110 = "";
    L54:
        GeckoLogger.a(r110);
        return new d(null, null, r19.f4745c);
    L11:
        r20 = null;
    L56:
        String r111 = com.lynx.tasm.utils.g.d("offline", r5, r13);
        if (g(r11, "offline", r13) == true) goto L59;
        StringBuilder r112 = new StringBuilder();
        r112.append("gecko_build_in" + r5 + r12);
        r112.append(r5);
        r112.append(r13);
        String r113 = r112.toString();
        String r30 = com.lynx.tasm.utils.k.j(r113, r5, "res");
        if (g(r11, r113, "res") == false) goto L72;
        r111 = new Uri.Builder().scheme("asset").authority("").path(r30).build().toString();
        if (e(r11, r30 + r10) == false) goto L70;
        String r114 = new Uri.Builder().scheme("asset").authority("").path(io.reactivex.internal.observers.h.b(r30, r10)).build().toString();
    L61:
        String r31 = null;
        r16 = r111;
        String r115 = r114;
        r17 = null;
    L142:
        String r116 = io.reactivex.internal.observers.h.b(r12, r13);
        if (r16 != null) goto L145;
        r16 = "empty_path";
    L145:
        r15.put(r116, new d(r17, r16, r31));
        return new d(r17, r115, r31);
    L70:
        StringBuilder r117 = com.lynx.tasm.base.a.e("build-in bundle does not exist in assets path:", r30, ",accessKey:", r12, ",channel:");
        r117.append(r13);
        String r118 = r117.toString();
    L63:
        r31 = r118;
        r16 = r111;
    L64:
        r115 = r16;
        goto L142
    L72:
        if (f(r11, r12, r13, false) == false) goto L75;
        r31 = com.lynx.tasm.utils.b.j("build-in channel is offline in current App version,accessKey:", r12, ",channel:", r13);
        r115 = null;
        r16 = "deleted_path";
        r17 = null;
        goto L142
    L75:
        if (r15.get(r12 + r13) != null) goto L112;
        LinkedHashMap r119 = f4747a;
        monitor-enter(r119);
        Object r32 = r119.get(r12 + r13);     // Catch: Throwable -> L82
        if (r32 != null) goto L84;
        r32 = new Object();     // Catch: Throwable -> L82
        r119.put(r12 + r13, r32);     // Catch: Throwable -> L82
    L84:
        monitor-exit(r119);
        monitor-enter(r32);
    L93:
        th = move-exception;
        throw th;
    L87:
        if (r15.get(r12 + r13) != null) goto L105;
        Pair r120 = c(r11, r12, r13);     // Catch: Throwable -> L93
        Long r33 = (Long) r120.getFirst();     // Catch: Throwable -> L93
        if (r33 == null) goto L102;
        long r34 = r33.longValue();     // Catch: Throwable -> L93
        StringBuilder r35 = new StringBuilder();     // Catch: Throwable -> L93
        r35.append(r11.getFilesDir() + r5 + "gecko_build_in" + r5 + r12 + r5 + r13);     // Catch: Throwable -> L93
        r35.append(r5);     // Catch: Throwable -> L93
        r35.append(r34);     // Catch: Throwable -> L93
        r35.append(r5);     // Catch: Throwable -> L93
        r35.append("res");     // Catch: Throwable -> L93
        String r121 = r35.toString();     // Catch: Throwable -> L93
        String r36 = r12 + r13;     // Catch: Throwable -> L93
        if (StringsKt.g(r121, "@") == true) goto L95;
        String r122 = Uri.fromFile(new File(r121)).toString();     // Catch: Throwable -> L93
    L96:
        r15.put(r36, new d((Long) r120.getFirst(), r122, (String) r120.getSecond()));     // Catch: Throwable -> L93
        Object r123 = r15.get(r12 + r13);     // Catch: Throwable -> L93
        if (r123 != null) goto L99;
        Intrinsics.throwNpe();     // Catch: Throwable -> L93
    L99:
        d r124 = (d) r123;     // Catch: Throwable -> L93
        monitor-exit(r32);
    L131:
        String r125 = r124.f4745c;
        String r37 = r124.f4743a;
        if (r37 == null) goto L141;
        r17 = r124.f4744b;
        File r38 = new File(Uri.parse(r37).getPath(), r10);
        if (r38.exists() == false) goto L139;
        String r39 = r38.getAbsolutePath();
        if (StringsKt.g(r39, "@") == true) goto L138;
        r18 = Uri.fromFile(new File(r39)).toString();
    L140:
        r31 = r125;
        r115 = r18;
        r16 = r37;
        goto L142
    L138:
        r18 = td.d.b("file:///", r39);
        goto L140
    L139:
        r125 = f4.b.b(com.lynx.tasm.base.a.e("build-in bundle does not exist in file path:", r37, ",accessKey:", r12, ",channel:"), r13, ",bundle:", r10);
        goto L140
    L141:
        r31 = r125;
        goto L64
    L95:
        r122 = "file:///" + r121;     // Catch: Throwable -> L93
        goto L96
    L102:
        r124 = new d(null, null, (String) r120.getSecond());     // Catch: Throwable -> L93
        monitor-exit(r32);
        goto L131
    L105:
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L93
        monitor-exit(r32);
    L82:
        th = move-exception;
        throw th;
    L112:
        Object r127 = r15.get(r12 + r13);
        if (r127 != null) goto L116;
        Intrinsics.throwNpe();
    L116:
        if (Intrinsics.areEqual(((d) r127).f4743a, "empty_path") == true) goto L127;
        Object r128 = r15.get(r12 + r13);
        if (r128 != null) goto L121;
        Intrinsics.throwNpe();
    L121:
        if (Intrinsics.areEqual(((d) r128).f4743a, "deleted_path") == true) goto L127;
        Object r129 = r15.get(r12 + r13);
        if (r129 != null) goto L126;
        Intrinsics.throwNpe();
    L126:
        r124 = (d) r129;
    L127:
        Object r130 = r15.get(r12 + r13);
        if (r130 != null) goto L130;
        Intrinsics.throwNpe();
    L130:
        r124 = new d(null, null, ((d) r130).f4745c);
        goto L131
    L59:
        if (e(r11, r111 + r10) == false) goto L62;
        r114 = new Uri.Builder().scheme("asset").authority("").path(io.reactivex.internal.observers.h.b(r111, r10)).build().toString();
        goto L61
    L62:
        StringBuilder r131 = com.lynx.tasm.base.a.e("build-in bundle does not exist in assets path:", r111, ",accessKey:", r12, ",channel:");
        r131.append(r13);
        r118 = r131.toString();
        goto L63
    L5:
        r10 = io.reactivex.internal.observers.h.b(r5, r14);
        goto L6
    }

    public static Long b(File r12) {
        File[] r5 = r12.listFiles();
        Long r10 = null;
        boolean r11 = false;
        if (r5 == null) goto L22;
        boolean r13 = true;
        if (r5.length > 1) goto L8;
        r13 = false;
    L8:
        int r14 = r5.length;
        int r15 = 0;
        Long r16 = null;
    L9:
        if (r15 >= r14) goto L21;
        File r17 = r5[r15];
        if (r17.isDirectory() == false) goto L20;
        if (StringsKt.k(r17.getName(), "--pending-delete") == true) goto L20;
        if (StringsKt.k(r17.getName(), "--updating") == true) goto L20;
        if (r16 != null) goto L18;
    L19:
        Long r18 = Long.valueOf(r17.lastModified());
        r16 = r18;
        r10 = Long.valueOf(Long.parseLong(r17.getName()));
        goto L20
    L18:
        if (r16.longValue() < r17.lastModified()) goto L19;
    L20:
        r15 = r15 + 1;
        goto L9
    L21:
        r11 = r13;
    L22:
        if (r11 == false) goto L24;
        d(r12.getAbsolutePath(), r10);
    L24:
        return r10;
    }

    public static Pair c(Context r10, String r11, String r12) {
        GeckoLogger.a("build-in decompress channel,accessKey:" + r11 + ",channel:" + r12);     // Catch: Throwable -> L7
        StringBuilder r5 = new StringBuilder("gecko_build_in");     // Catch: Throwable -> L7
        String r13 = File.separator;     // Catch: Throwable -> L7
        r5.append(r13);     // Catch: Throwable -> L7
        r5.append(r11);     // Catch: Throwable -> L7
        if (g(r10, r5.toString(), r12) == true) goto L9;
        String r14 = "build-in channel does not exist in assets dir,accessKey:" + r11 + ",channel:" + r12;     // Catch: Throwable -> L7
        GeckoLogger.a(r14);     // Catch: Throwable -> L7
        return new Pair(null, r14);
    L9:
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L7
        r15.append("gecko_build_in" + r13 + r11);     // Catch: Throwable -> L7
        r15.append(r13);     // Catch: Throwable -> L7
        r15.append(r12);     // Catch: Throwable -> L7
        String r16 = r15.toString();     // Catch: Throwable -> L7
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L19
        String[] r18 = r10.getAssets().list(r16);     // Catch: Throwable -> L19
        if (r18 == null) goto L21;
        int r19 = r18.length;     // Catch: Throwable -> L19
        int r20 = 0;
        Long r21 = null;
    L14:
        if (r20 >= r19) goto L18;
        r21 = Long.valueOf(Long.parseLong(r18[r20]));     // Catch: Throwable -> L16
        r20 = r20 + 1;     // Catch: Throwable -> L16
    L16:
        th = th;
    L24:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L7
        Object r23 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L7
    L25:
        Throwable r24 = Result.m127exceptionOrNullimpl(r23);     // Catch: Throwable -> L7
        if (r24 == null) goto L29;
        String r110 = "build-in get channel version failed,accessKey:" + r11 + ",channel:" + r12 + ",path:" + r16 + ",error:" + r24.getMessage();     // Catch: Throwable -> L7
        GeckoLogger.a(r110);     // Catch: Throwable -> L7
        return new Pair(null, r110);
    L29:
        StringBuilder r25 = new StringBuilder();     // Catch: Throwable -> L7
        r25.append(r10.getFilesDir());     // Catch: Throwable -> L7
        String r26 = File.separator;     // Catch: Throwable -> L7
        r25.append(r26);     // Catch: Throwable -> L7
        r25.append("gecko_build_in");     // Catch: Throwable -> L7
        r25.append(r26);     // Catch: Throwable -> L7
        r25.append(r11);     // Catch: Throwable -> L7
        r25.append(r26);     // Catch: Throwable -> L7
        r25.append(r12);     // Catch: Throwable -> L7
        File r27 = new File(r25.toString());     // Catch: Throwable -> L7
        if (r27.exists() == false) goto L32;
        Long r28 = b(r27);     // Catch: Throwable -> L7
    L33:
        if (r21 == null) goto L46;
        if (Intrinsics.areEqual(r28, r21) == true) goto L46;
        InputStream r111 = r10.getAssets().open(r16 + r26 + r21 + r26 + "res.zst");     // Catch: Throwable -> L7
        StringBuilder r29 = new StringBuilder();     // Catch: Throwable -> L7
        r29.append(r21);     // Catch: Throwable -> L7
        r29.append("--updating");     // Catch: Throwable -> L7
        File r30 = new File(r27, r29.toString());     // Catch: Throwable -> L7
        com.bytedance.geckox.utils.d.j(r30);     // Catch: Throwable -> L7
        if (r30.exists() == true) goto L40;
        r30.mkdirs();     // Catch: Throwable -> L7
    L40:
        File r31 = new File(r30, "res_temp");     // Catch: Throwable -> L7
        r31.createNewFile();     // Catch: Throwable -> L7
        com.bytedance.geckox.utils.d.e(r31, r111);     // Catch: Throwable -> L7
        com.bytedance.geckox.utils.d.g(new FileInputStream(r31), r30.getAbsolutePath(), r12);     // Catch: Throwable -> L7
        new File(r30, r12).renameTo(new File(r30, "res"));     // Catch: Throwable -> L7
        r30.renameTo(new File(r27, String.valueOf(r21)));     // Catch: Throwable -> L7
        r31.delete();     // Catch: Throwable -> L7
        if (r28 == null) goto L44;
        GeckoLogger.a("build-in remove old version in storage,accessKey:" + r11 + ",channel:" + r12 + ",old version:" + r28);     // Catch: Throwable -> L7
        d(r27.getAbsolutePath(), r21);     // Catch: Throwable -> L7
    L44:
        return new Pair(r21, null);
    L46:
        return new Pair(r28, null);
    L32:
        r28 = null;
        goto L33
    L18:
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L22:
        r23 = Result.m124constructorimpl(r32);     // Catch: Throwable -> L16
        goto L25
    L21:
        r32 = null;
        r21 = null;
    L19:
        th = th;
        r21 = null;
    L7:
        th = move-exception;
        String r112 = "decompress build-in resource failed:" + th.getMessage() + ",accessKey:" + r11 + ",channel:" + r12;
        GeckoLogger.b(r112);
        return new Pair(null, r112);
    }

    public static void d(String r5, Long r10) {
        String r11 = String.valueOf(r10);
        File[] r12 = new File(r5).listFiles(e.f4746a);
        int r13 = 0;
        if (r12 == null) goto L11;
        int r14 = r12.length;
        int r15 = 0;
    L5:
        if (r13 >= r14) goto L10;
        File r16 = r12[r13];
        if (Intrinsics.areEqual(r16.getName(), r11) == true) goto L9;
        GeckoLogger.a("delete buildin file: " + r16.getAbsolutePath());
        com.lynx.tasm.behavior.utils.d.f(r16);
        r15 = 1;
    L9:
        r13 = r13 + 1;
        goto L5
    L10:
        r13 = r15;
    L11:
        if (r13 == 0) goto L17;
        com.lynx.tasm.behavior.utils.d.i();
        return;
    }

    public static boolean e(Context r5, String r10) {
        if (StringsKt.P(r10, File.separator) == false) goto L12;
        if (r10 == null) goto L7;
        r10 = r10.substring(1);
        goto L12
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L12:
        CloseableKt.closeFinally(r5.getAssets().open(r10), null);     // Catch: IOException -> L10
        return true;
    L10:
        return false;
    }

    public static boolean f(Context r11, String r12, String r13, boolean r14) {
        if (f4748b.get() == false) goto L5;
        return false;
    L5:
        StringBuilder r5 = new StringBuilder();
        r5.append(r11.getFilesDir());
        String r10 = File.separator;
        f8.b.e(r5, r10, "gecko_build_in", r10, r12);
        File r15 = new File(j0.q(r5, r10, r13));
        if (r15.exists() == true) goto L8;
        return false;
    L8:
        ConcurrentHashMap r16 = f4749c;
        d r17 = (d) r16.get(r12 + r13);
        if (r17 == null) goto L11;
        String r18 = r17.f4743a;
    L13:
        if (Intrinsics.areEqual(r18, "deleted_path") == false) goto L19;
        GeckoLogger.a("build-in channel is offline return,accessKey:" + r12 + ",channel:" + r13);
        if (r14 == false) goto L17;
        com.bytedance.geckox.utils.d.j(r15);
        GeckoLogger.a("build-in offline channel is deleted,accessKey:" + r12 + ",channel:" + r13);
    L17:
        return true;
    L19:
        if (b(r15) != null) goto L21;
    L26:
        return false;
    L21:
        if (g(r11, "gecko_build_in" + r10 + r12, r13) == true) goto L26;
        GeckoLogger.a("build-in channel is offline check,accessKey:" + r12 + ",channel:" + r13);
        StringBuilder r19 = new StringBuilder();
        r19.append(r12);
        r19.append(r13);
        r16.put(r19.toString(), new d(null, "deleted_path", com.lynx.tasm.utils.b.j("build-in channel is offline in current App version,accessKey:", r12, ",channel:", r13)));
        if (r14 == false) goto L25;
        com.bytedance.geckox.utils.d.j(r15);
        GeckoLogger.a("build-in offline channel is deleted,accessKey:" + r12 + ",channel:" + r13 + ",storage dir:" + r15);
    L25:
        return true;
    L11:
        r18 = null;
        goto L13
    }

    public static boolean g(Context r5, String r10, String r11) {
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L4
        Object r13 = Result.m124constructorimpl(r5.getAssets().list(r10));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r13) == false) goto L9;
        r13 = null;
    L9:
        String[] r14 = (String[]) r13;
        if (r14 != null) goto L12;
    L14:
        return false;
    L12:
        if (ArraysKt.contains(r14, r11) != true) goto L14;
        return true;
    L4:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
