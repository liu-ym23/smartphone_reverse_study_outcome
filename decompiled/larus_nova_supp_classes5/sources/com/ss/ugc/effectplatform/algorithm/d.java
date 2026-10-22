package com.ss.ugc.effectplatform.algorithm;

import android.content.Context;
import android.content.res.AssetManager;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.util.k;
import com.ss.ugc.effectplatform.util.p;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public final z.b<String, String> a;
    public final z.b<String, Boolean> b;
    public final z.b<String, String> c;
    public final ArrayList<String> d;
    public final Object e;
    public final String f;
    public final boolean g;

    public final String a(String r9) {
        String r0 = (String) this.a.get(r9);
        if (r0 == null) goto L22;
        return r0;
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        int r2 = StringsKt.lastIndexOf$default(r9, "/", 0, false, 6, null);     // Catch: Throwable -> L11
        if (r9 == null) goto L10;
        Object r3 = Result.constructor-impl(r9.substring(0, r2));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r3) == false) goto L16;
        r3 = "";
    L16:
        String r4 = (String) r3;
        if (StringsKt.startsWith$default(r4, "tt", false, 2, null) == false) goto L19;
        String r5 = StringsKt.replace$default(r9, r4, "algo" + r4.substring(2, r4.length()), false, 4, null);
    L20:
        String r6 = k.d(r9);
        String r7 = StringsKt.replace$default(r5, r6, bytekn.foundation.utils.c.a(r6), false, 4, null);
        this.a.put(r9, r7);
        return r7;
    L19:
        r5 = r9;
        goto L20
    L10:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final boolean b(String r3) {
        String r4 = p.a("model") + a(r3);
        boolean r1 = false;
        if (g(r4) == false) goto L14;
    L12:
        return r1;
    L14:
        bytekn.foundation.io.file.b r5 = e(r4);     // Catch: Throwable -> L10 Exception -> L13
        if (r5 == null) goto L8;
        r1 = true;
    L8:
        if (r5 == null) goto L12;
        FileManager.b(r5);
        goto L12
    L10:
        th = move-exception;
        throw th;
    }

    public final List<String> c(String r8) {
        Object r0 = this.e;
        if ((r0 instanceof Context) == true) goto L18;
        return null;
    L18:
        String[] r1 = ((Context) r0).getApplicationContext().getAssets().list(r8);     // Catch: Exception -> L15
        if (r1 == null) goto L23;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L15
        int r3 = r1.length;     // Catch: Exception -> L15
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L13;
        String r5 = r1[r4];     // Catch: Exception -> L15
        if ((!g(r5)) == false) goto L12;
        r2.add(r5);     // Catch: Exception -> L15
    L12:
        r4 = r4 + 1;     // Catch: Exception -> L15
        goto L8
    L13:
        return CollectionsKt.toList(r2);
    L23:
        return null;
    L15:
        e = move-exception;
        Logger.INSTANCE.e("effect_platform", "error in list file: " + r8, e);
        return null;
    }

    public final bytekn.foundation.io.file.b e(String r5) {
        if ((this.e instanceof Context) == true) goto L6;
        return null;
    L6:
        if (g(r5) == false) goto L8;
        return null;
    L8:
        Object r0 = this.e;
        if (r0 == null) goto L20;
        AssetManager r1 = ((Context) r0).getApplicationContext().getAssets();
        String r2 = k.d(r5);
        if (this.f != null) goto L13;
    L17:
        bytekn.foundation.io.file.b r3 = new bytekn.foundation.io.file.b();
        r3.a = r1.open(r5, 2);
        return r3;
    L13:
        if (new Regex(this.f).matches(r2) == false) goto L17;
        throw new RuntimeException(r5 + " manually excluded by DownloadableModelSupport.exclusionPattern");
    L20:
        throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
    }

    public final String f(String r6) {
        if ((this.e instanceof Context) == true) goto L6;
        return null;
    L6:
        if (g(r6) == false) goto L23;
        return null;
    L23:
        BufferedReader r2 = new BufferedReader(new InputStreamReader(((Context) this.e).getApplicationContext().getAssets().open(r6)));     // Catch: Exception -> L21
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L16
        Ref.ObjectRef r3 = new Ref.ObjectRef();     // Catch: Throwable -> L16
    L10:
        String r4 = r2.readLine();     // Catch: Throwable -> L16
        r3.element = r4;     // Catch: Throwable -> L16
        if (r4 == null) goto L13;
        r0.append(r4);     // Catch: Throwable -> L16
        goto L10
    L13:
        String r1 = r0.toString();     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L21
        return r1;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L21
        throw th;     // Catch: Exception -> L21
    L21:
        Logger.INSTANCE.d("effect_platform", "AssetUtils#loadJson::jsonFilePath=" + r6 + ", file not exists");
        return null;
    }

    public final boolean g(String r13) {
        if (this.g == true) goto L6;
        Logger.INSTANCE.d("JKL", "[Model][BuiltIn][ignore built in model switch is CLOSED]");
        return false;
    L6:
        int r0 = StringsKt.lastIndexOf$default(r13, '/', 0, false, 6, null) + 1;
        if (r0 >= r13.length()) goto L12;
        boolean r4 = k.a;
        String r1 = k.d(r13.substring(r0));
        if (this.d.contains(r1) == false) goto L12;
        Logger.e$default(Logger.INSTANCE, "JKL", "[Model][BuiltIn][Match ignore: " + r1 + ']', null, 4, null);
        return true;
    L12:
        Logger.INSTANCE.w("JKL", "[Model][BuiltIn][Not Match ignore: " + r13 + ']');
        return false;
    }

    public final boolean d(String r9, Function1<? super String, Unit> r10) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        int r2 = StringsKt.lastIndexOf$default(r9, "/", 0, false, 6, null);     // Catch: Throwable -> L8
        if (r9 == null) goto L7;
        Object r3 = Result.constructor-impl(r9.substring(0, r2));     // Catch: Throwable -> L8
    L10:
        String r4 = "";
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = "";
    L13:
        String r5 = (String) r3;
        if (StringsKt.startsWith$default(r5, "tt", false, 2, null) == false) goto L16;
        r5 = "algo" + r5.substring(2, r5.length());
    L16:
        StringBuilder r6 = new StringBuilder("model");
        if (r5.length() <= 0) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        r4 = "/".concat(r5);
    L22:
        r6.append(r4);
        String r8 = r6.toString();
        List<String> r11 = c(r8);
        String r12 = bytekn.foundation.utils.c.a(k.d(r9));
        if (r11 == null) goto L31;
        Iterator<T> r13 = r11.iterator();
    L26:
        if (r13.hasNext() == false) goto L31;
        String r14 = (String) r13.next();
        if (Intrinsics.areEqual(k.d(r14), r12) == false) goto L26;
        r10.invoke("asset://" + r8 + '/' + r14);
        return true;
    L31:
        return false;
    L19:
        r7 = false;
        goto L20
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public d(Object r1, String r2, boolean r3) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.a = new z.b(true);
        this.b = new z.b(true);
        this.c = new z.b(true);
        this.d = CollectionsKt.arrayListOf(new String[]{"algo_ggl1pqhlhmg7p"});
    }
}
