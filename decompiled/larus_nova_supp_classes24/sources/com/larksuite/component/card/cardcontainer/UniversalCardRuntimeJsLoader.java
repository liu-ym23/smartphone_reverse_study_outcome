package com.larksuite.component.card.cardcontainer;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.TemplateBundle;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardRuntimeJsLoader {
    public static volatile b a;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Map<String, String> b;
        public final TemplateBundle c;

        public final String toString() {
            return "JSInfo(version=" + this.a + ", map=" + this.b + ", template=" + this.c + ')';
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            TemplateBundle r1 = this.c;
            if (r1 == null) goto L5;
            int r2 = System.identityHashCode(r1);
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.card.cardcontainer.UniversalCardRuntimeJsLoader.JSInfo");
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public b(String r2, Map<String, String> r3, TemplateBundle r4) {
            Intrinsics.checkNotNullParameter(r2, "version");
            Intrinsics.checkNotNullParameter(r3, "map");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public UniversalCardRuntimeJsLoader() {
    }

    public final synchronized b a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (a == null) goto L8;
        b r0 = a;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        a = b(LarkContext.getApplication());     // Catch: Throwable -> L11
        b r1 = a;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    public static b b(Context r12) {
        IUniversalCardJsService r4 = (IUniversalCardJsService) LarkContext.spiByDwarf(IUniversalCardJsService.class);     // Catch: Exception -> L30
        String r5 = r4.getJsBundleVersion(r12);     // Catch: Exception -> L30
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        String r6 = r4.getJsBundleFile(r12);     // Catch: Exception -> L30
        if (r6 != null) goto L10;
        Log.e("RuntimeJsLoader", "jsService return null, version: " + r5 + ", filePath: " + r6);     // Catch: Exception -> L30
        return null;
    L10:
        HashMap r2 = new HashMap();     // Catch: Exception -> L30
        final PolarisFileWrapper r7 = new PolarisFileWrapper(r6);     // Catch: Exception -> L30
        Log.i("RuntimeJsLoader", "getRuntimeJS from rust: " + r7.getAbsolutePath());     // Catch: Exception -> L30
        if (r7.exists() == true) goto L13;
    L28:
        Log.e("RuntimeJsLoader", "file error");     // Catch: Exception -> L30
    L32:
        Log.e("RuntimeJsLoader", "read error");
        return null;
    L13:
        if (r7.isFile() == false) goto L28;
        File r1 = r7.getParentFile();     // Catch: Exception -> L30
        if (r1 != null) goto L17;
    L22:
        byte[] r13 = r4.loadTemplate(r12, r7);     // Catch: Exception -> L30
        if (r13 != null) goto L27;
        Log.e("RuntimeJsLoader", "read localTemplate failed");     // Catch: Exception -> L30
        return null;
    L27:
        return new b(r5, r2, TemplateBundle.b(r13));
    L17:
        if (r1.exists() == false) goto L22;
        Iterator r8 = SequencesKt.filter(FilesKt.walk$default(r1, null, 1, null), new UniversalCardRuntimeJsLoader$loadJSFromFile$1(r7)).iterator();     // Catch: Exception -> L30
    L20:
        if (r8.hasNext() == false) goto L22;
        File r9 = (File) r8.next();     // Catch: Exception -> L30
        String r10 = r9.getAbsolutePath().substring(r1.getAbsolutePath().length());     // Catch: Exception -> L30
        Log.i("RuntimeJsLoader", "preload js file " + r10);     // Catch: Exception -> L30
        r2.put(r10, r9.getAbsolutePath());     // Catch: Exception -> L30
    L30:
        e = move-exception;
        Log.e("RuntimeJsLoader", "file error " + e);
        goto L32
    }
}
