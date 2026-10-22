package com.bytedance.forest.model;

import ai.j0;
import android.os.Handler;
import androidx.room.solver.CodeGenScope;
import androidx.room.writer.DaoWriter;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.keva.Keva;
import com.lynx.tasm.ui.image.f0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f4395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile File f4396c;
    public String d;
    public int e;
    public long f;
    public WeakReference g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference f4397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4398i;

    public o(String r5, String r10) {
        this.f4398i = r5;
        this.f4395b = true;
        List r11 = StringsKt.K(r10, new String[]{DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD}, 0, 6);
        if (r11.size() != 3) goto L21;
        Integer r12 = StringsKt.toIntOrNull((String) r11.get(1));
        if (r12 == null) goto L19;
        this.e = r12.intValue();
        Long r13 = StringsKt.toLongOrNull((String) r11.get(2));
        if (r13 == null) goto L17;
        this.f = r13.longValue();
        File r14 = new File((File) com.bytedance.forest.pollyfill.b.f4507a.getValue(), r10);
        if (r14.exists() == false) goto L15;
        if (r14.isFile() == false) goto L15;
        this.d = r10;
        this.f4396c = r14;
        return;
    L15:
        throw new IllegalArgumentException("cache not exists or not a file");
    L17:
        throw new IllegalArgumentException("file name not valid");
    L19:
        throw new IllegalArgumentException("file name not valid");
    L21:
        throw new IllegalArgumentException("file name not valid");
    }

    public final q a(Request r5, com.bytedance.forest.utils.e r10) {
        q r11 = null;
        if (d() == true) goto L5;
        return null;
    L5:
        WeakReference r12 = this.g;
        if (r12 == null) goto L8;
        q r13 = (q) r12.get();
    L10:
        if (r13 != null) goto L12;
    L14:
        File r14 = this.f4396c;
        if (r14 != null) goto L17;
    L19:
        if (r11 == null) goto L21;
        this.g = new WeakReference(r11);
    L21:
        return r11;
    L17:
        if (r14.isFile() != true) goto L19;
        r11 = r10.a(new ug.e(this, 3), r5);
        goto L19
    L12:
        if (r13.isCacheProvided$forest_release() != true) goto L14;
        r11 = r13;
        goto L19
    L8:
        r13 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v35, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.String] */
    public final void b(com.bytedance.forest.pollyfill.d r23, q r24, w r25) {
        this.g = new WeakReference(r24);
        final StringBuilder r5 = new StringBuilder(this.f4398i);
        r5.append(':');
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        r10.element = true;
        List r11 = com.bytedance.forest.utils.k.f4646a;
        Function2<String, Map<String, ? extends String>, String> r12 = new HttpResponseCache$updateFromOnline$result$1(r10, r5);
        HashMap r13 = new HashMap();
        Iterator r14 = r23.f4528c.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.put(r15.getKey(), r15.getValue());
        goto L4
    L6:
        String r16 = (String) r13.get("vary");
        if (r16 == null) goto L13;
        String r17 = StringsKt.trim(r16).toString();
        if (r17 == null) goto L13;
        String r18 = r17.toLowerCase(Locale.ENGLISH);
        if (r18 == null) goto L13;
        List r19 = StringsKt.K(r18, new String[]{","}, 0, 6);
    L14:
        if (r19 != null) goto L17;
        r19 = CollectionsKt.emptyList();
    L17:
        List r20 = CollectionsKt.sorted(r19);
        r13.put("vary", CollectionsKt.q(r20, ",", null, null, 0, null, null, 62));
        r13.put("forest-append-on-request", String.valueOf(r23.e));
        Iterator r21 = r20.iterator();
    L19:
        if (r21.hasNext() == false) goto L25;
        String r110 = (String) r21.next();
        String r111 = td.d.b("forest-append-", r110);
        Map<String, ? extends String> r112 = r23.d.f4524b;
        if (r112 != null) goto L24;
        r112 = MapsKt.emptyMap();
    L24:
        r13.put(r111, r12.mo2invoke(r110, r112));
        goto L19
    L25:
        Pair r22 = new Pair(r13, Integer.valueOf(r20.size()));
        Map r26 = (Map) r22.getFirst();
        this.f4397h = new WeakReference(r26);
        Long r27 = com.bytedance.forest.utils.k.b(r23);
        if (r27 == null) goto L91;
        long r113 = r27.longValue();
        final Ref.ObjectRef r28 = new Ref.ObjectRef();
        StringBuilder r29 = new StringBuilder();
        String r30 = MD5Utils.stringToMd5(r5.toString());
        if (r30 == null) goto L89;
        r29.append(r30.substring(0, 8));
        r29.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r29.append(((Number) r22.getSecond()).intValue());
        r29.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r29.append(r113);
        r28.element = r29.toString();
    L30:
        Keva r31 = com.bytedance.forest.utils.l.f4649a;
        String r32 = (String) r28.element;
        Keva r33 = com.bytedance.forest.utils.l.f4649a;
        if (r33 == null) goto L33;
        boolean r34 = r33.contains(r32);
    L34:
        if (r34 == false) goto L36;
        r28.element = "forest_" + ((String) r28.element);
        goto L30
    L36:
        com.bytedance.forest.utils.d r35 = r25.B;
        if (this.f4396c == null) goto L50;
        File r36 = this.f4396c;
        if (r36 == null) goto L41;
        String r37 = r36.getName();
    L43:
        if (Intrinsics.areEqual(r37, (String) r28.element) == true) goto L50;
        String r114 = this.d;
        if (r114 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L47:
        this.d = (String) r28.element;
        this.e = ((Number) r22.getSecond()).intValue();
        this.f = r113;
        ((Handler) com.bytedance.forest.utils.q.f4657b.getValue()).post(new n(this, r28, r35, r25, r26, r114));
        return;
    L41:
        r37 = null;
    L50:
        if (this.f4396c != null) goto L87;
        this.d = (String) r28.element;
        this.e = ((Number) r22.getSecond()).intValue();
        this.f = r113;
        Lazy r38 = com.bytedance.forest.pollyfill.b.f4507a;
        File r39 = new File((File) r38.getValue(), j0.q(new StringBuilder(), (String) r28.element, CodeGenScope.TMP_VAR_DEFAULT_PREFIX));
        File r115 = new File((File) r38.getValue(), (String) r28.element);
        com.bytedance.forest.utils.d.b(r35, 4, "ResponseCache", "start to write file, " + ((String) r28.element), false, null, null, 56);     // Catch: Throwable -> L60
        r39.delete();     // Catch: Throwable -> L60
        r115.delete();     // Catch: Throwable -> L60
        InputStream r40 = r24.provideInputStream(r25);     // Catch: Throwable -> L60
        if (r40 != null) goto L95;
        int r116 = -1;
    L77:
        if (r116 <= 0) goto L83;
        r39.renameTo(r115);     // Catch: Throwable -> L60
        r25.f4443t = r115.getAbsolutePath();     // Catch: Throwable -> L60
        final String r41 = com.bytedance.forest.utils.k.f4647b.toJson(r26);     // Catch: Throwable -> L60
        String r42 = (String) r28.element;     // Catch: Throwable -> L60
        if (r33 == null) goto L81;
        r33.storeStringJustDisk(r42, r41);     // Catch: Throwable -> L60
    L81:
        com.bytedance.forest.utils.d.c(r35, 4, "ResponseCache", null, null, new HttpResponseCache$updateFromOnline$3(r41), 28);     // Catch: Throwable -> L60
        this.f4396c = r115;     // Catch: Throwable -> L60
        final String r43 = MD5Utils.stringToMd5(r41);     // Catch: Throwable -> L60
        com.bytedance.forest.utils.d.c(r35, 4, "ResponseCache", null, null, new HttpResponseCache$updateFromOnline$4(r43, r28), 24);     // Catch: Throwable -> L60
        return;
    L83:
        c(true);     // Catch: Throwable -> L60
        r39.delete();     // Catch: Throwable -> L60
        throw new IOException("written file size is unexpected");     // Catch: Throwable -> L60
    L95:
        FileOutputStream r44 = new FileOutputStream(r39);     // Catch: Throwable -> L62
        r116 = (int) ByteStreamsKt.copyTo$default(r40, r44, 0, 2, null);     // Catch: Throwable -> L64
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r44, null);     // Catch: Throwable -> L62
        CloseableKt.closeFinally(r40, null);     // Catch: Throwable -> L60
        goto L77
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        CloseableKt.closeFinally(r44, th);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        CloseableKt.closeFinally(r40, th);     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        f0.g(112, "ResponseCache", "write file failed", th);
        this.f4395b = false;
        r39.delete();
        r115.delete();
        this.f4396c = null;
        throw th;
    L87:
        return;
    L33:
        r34 = false;
        goto L34
    L89:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L91:
        throw new IllegalArgumentException("Cache not supported since no expired time provided");
    L13:
        r19 = null;
        goto L14
    }

    public final void c(boolean r5) {
        this.f4395b = false;
        Keva r10 = com.bytedance.forest.utils.l.f4649a;
        String r11 = this.d;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L5:
        Keva r12 = com.bytedance.forest.utils.l.f4649a;
        if (r12 == null) goto L8;
        r12.erase(r11);
    L8:
        if (r5 == true) goto L21;
        h();
        return;
    L21:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L12
        File r14 = this.f4396c;     // Catch: Throwable -> L12
        if (r14 == null) goto L14;
        Boolean r15 = Boolean.valueOf(r14.delete());     // Catch: Throwable -> L12
    L15:
        Result.m124constructorimpl(r15);     // Catch: Throwable -> L12
        return;
    L14:
        r15 = null;
    L12:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public final boolean d() {
        if (this.f4395b == true) goto L9;
        StringBuilder r5 = new StringBuilder();
        String r10 = this.d;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L7:
        r5.append(r10);
        r5.append(" is not valid");
        f0.n(4, "ResponseCache", r5.toString());
    L9:
        return this.f4395b;
    }

    public final String e() {
        String r5 = this.d;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L5:
        return r5;
    }

    public final o f() {
        i r5 = (i) this.f4376a.get();
        if ((r5 instanceof o) == true) goto L6;
        r5 = null;
    L6:
        return (o) r5;
    }

    public final Map g() {
        Map r5 = null;
        if (d() == true) goto L5;
        return null;
    L5:
        WeakReference r10 = this.f4397h;
        if (r10 == null) goto L10;
        Map r11 = (Map) r10.get();
        if (r11 == null) goto L10;
        r5 = r11;
    L19:
        if (r5 == null) goto L21;
        this.f4397h = new WeakReference(r5);
    L21:
        return r5;
    L10:
        Keva r12 = com.bytedance.forest.utils.l.f4649a;
        String r13 = this.d;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
    L13:
        Keva r14 = com.bytedance.forest.utils.l.f4649a;
        if (r14 == null) goto L16;
        String r15 = r14.getStringJustDisk(r13, null);
    L17:
        if (r15 == null) goto L19;
        r5 = (Map) com.bytedance.forest.utils.k.f4647b.fromJson(r15, new HashMap().getClass());
        goto L19
    L16:
        r15 = null;
        goto L17
    }

    public final void h() {
        WeakReference r5 = this.g;
        if (r5 == null) goto L5;
        q r10 = (q) r5.get();
    L6:
        if (r10 != null) goto L8;
    L22:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L14
        File r12 = this.f4396c;     // Catch: Throwable -> L14
        if (r12 == null) goto L16;
        Boolean r13 = Boolean.valueOf(r12.delete());     // Catch: Throwable -> L14
    L17:
        Result.m124constructorimpl(r13);     // Catch: Throwable -> L14
    L20:
        this.f4396c = null;
        return;
    L16:
        r13 = null;
    L14:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L20
    L8:
        if (r10.isCacheReady$forest_release() == true) goto L22;
        ((Handler) com.bytedance.forest.utils.q.f4657b.getValue()).postDelayed(new a6.a(this, 13), 300000);
        return;
    L5:
        r10 = null;
        goto L6
    }

    public o(com.bytedance.forest.pollyfill.d r5, q r10, w r11) {
        this.f4398i = r5.d.f4525c;
        this.f4395b = true;
        if (r10.isCacheProvided$forest_release() == false) goto L7;
        b(r5, r10, r11);
        return;
    L7:
        throw new IllegalArgumentException("forest buffer not support cache");
    }
}
