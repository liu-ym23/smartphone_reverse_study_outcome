package com.ss.android.pushmanager.setting;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.utils.f;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class PushMultiProcessSharedProvider extends ContentProvider {
    public static String e;
    public static Uri f;
    public static UriMatcher g;
    public static boolean h;
    public static b i;
    public SharedPreferences a;
    public final Map<String, Object> b;
    public volatile boolean c;
    public final Object d;

    public static class a {
        public final Context a;
        public final ContentValues b;
        public final SharedPreferences c;

        public final synchronized void a() {
            monitor-enter(this);
        L34:
            th = move-exception;
            throw th;
        L4:
            if (PushMultiProcessSharedProvider.a(this.a) == true) goto L38;
            SharedPreferences.Editor r0 = this.c.edit();     // Catch: Throwable -> L34
            Set<String> r1 = this.b.keySet();     // Catch: Throwable -> L34
            if (r1 == null) goto L32;
            Object[] r2 = r1.toArray();     // Catch: Throwable -> L34
            if (r2 != null) goto L13;
            monitor-exit(this);
            return;
        L13:
            int r3 = r2.length;     // Catch: Throwable -> L34
            int r4 = 0;
        L14:
            if (r4 >= r3) goto L31;
            String r5 = (String) r2[r4];     // Catch: Throwable -> L34
            Object r6 = this.b.get(r5);     // Catch: Throwable -> L34
            if ((r6 instanceof String) == false) goto L19;
            r0.putString(r5, (String) r6);     // Catch: Throwable -> L34
        L30:
            r4 = r4 + 1;     // Catch: Throwable -> L34
            goto L14
        L19:
            if ((r6 instanceof Long) == false) goto L22;
            r0.putLong(r5, ((Long) r6).longValue());     // Catch: Throwable -> L34
            goto L30
        L22:
            if ((r6 instanceof Boolean) == false) goto L25;
            r0.putBoolean(r5, ((Boolean) r6).booleanValue());     // Catch: Throwable -> L34
            goto L30
        L25:
            if ((r6 instanceof Integer) == false) goto L28;
            r0.putInt(r5, ((Integer) r6).intValue());     // Catch: Throwable -> L34
            goto L30
        L28:
            if ((r6 instanceof Float) == false) goto L30;
            r0.putFloat(r5, ((Float) r6).floatValue());     // Catch: Throwable -> L34
            goto L30
        L31:
            r0.apply();     // Catch: Throwable -> L34
        L32:
            monitor-exit(this);
            return;
        L38:
            b(this.a.getContentResolver(), PushMultiProcessSharedProvider.c(this.a, "key", EffectConfiguration.KEY_TYPE), this.b);     // Catch: Throwable -> L37
            goto L32
        }

        public a(Context r3) {
            this.b = new ContentValues();
            Context r4 = r3.getApplicationContext();
            this.a = r4;
            this.c = r4.getApplicationContext().getSharedPreferences("push_multi_process_config", 4);
        }

        public static void b(ContentResolver r18, Uri r19, ContentValues r20) {
            ArrayList r0 = new ArrayList();
            Object[] r1 = {r19, r20};
            f06.b r11 = new f06.b();
            g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
            if (r2 == null) goto L5;
            f06.a[] r3 = r2.i;
        L6:
            f06.a[] r15 = r3;
            int r9 = r15.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r7 = r15[r8];
            int r16 = r8;
            int r17 = r9;
            d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
            if (r4.a == true) goto L17;
            r0.add(r7);     // Catch: Exception -> L22
        L17:
            if (r4.a == false) goto L20;
            Uri r5 = (Uri) r4.b;
            return;
        L20:
            r18.insert(r19, r20);
            return;
        L14:
            r8 = r16 + 1;
            r9 = r17;
            goto L8
        L15:
            r4 = new d(false, null);
            goto L17
        L5:
            r3 = ApiHookConfig.d;
            goto L6
        }
    }

    public static class b {
        public final Context a;
        public final SharedPreferences b;

        public final a b() {
            return new a(this.a);
        }

        public b(Context r3) {
            Context r4 = r3.getApplicationContext();
            this.a = r4;
            this.b = r4.getApplicationContext().getSharedPreferences("push_multi_process_config", 4);
            if (f.a == false) goto L6;
            f.b("PushService", "MultiProcessShared create");
            return;
        }

        public final String e(String r5) {
        L21:
            return "";
        L4:
            if (PushMultiProcessSharedProvider.h == true) goto L20;
            if (PushMultiProcessSharedProvider.a(this.a) == false) goto L20;
            Cursor r6 = a(this.a.getContentResolver(), PushMultiProcessSharedProvider.c(this.a, r5, "string"));     // Catch: Throwable -> L21
            if (r6 == null) goto L29;
            if (r6.moveToFirst() == false) goto L15;
            String r1 = r6.getString(0);     // Catch: Throwable -> L23
        L26:
            r6.close();     // Catch: Exception -> L22 Throwable -> L21
        L18:
            return r1;
        L15:
            r1 = "";
            goto L26
        L29:
            return "";
        L20:
            return this.b.getString(r5, "");
        }

        public static Cursor a(ContentResolver r12, Uri r13) {
            c r8 = new c();
            Object[] r9 = {r13, null, null, null, null};
            f06.b r10 = new f06.b();
            d r11 = r8.b(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, "android.database.Cursor", r10);
            if (r11.a == false) goto L6;
            r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, null, r10, false);
            return (Cursor) r11.b;
        L6:
            Cursor r14 = r12.query(r13, null, null, null, null);
            r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, r14, r10, true);
            return r14;
        }

        public final boolean c(String r4, boolean r5) {
        L21:
            return r5;
        L3:
            if (PushMultiProcessSharedProvider.h == true) goto L20;
            if (PushMultiProcessSharedProvider.a(this.a) == false) goto L20;
            Cursor r6 = a(this.a.getContentResolver(), PushMultiProcessSharedProvider.c(this.a, r4, "boolean"));     // Catch: Throwable -> L21
            if (r6 == null) goto L29;
            if (r6.moveToFirst() == false) goto L15;
            boolean r0 = false;
            if (r6.getInt(0) <= 0) goto L26;
            r0 = true;
        L26:
            r6.close();     // Catch: Exception -> L22 Throwable -> L21
        L18:
            return r0;
        L15:
            r0 = r5;
            goto L26
        L29:
            return r5;
        L20:
            return this.b.getBoolean(r4, r5);
        }

        public final int d(String r4, int r5) {
        L20:
            return r5;
        L3:
            if (PushMultiProcessSharedProvider.h == true) goto L19;
            if (PushMultiProcessSharedProvider.a(this.a) == false) goto L19;
            Cursor r6 = a(this.a.getContentResolver(), PushMultiProcessSharedProvider.c(this.a, r4, "integer"));     // Catch: Throwable -> L20
            if (r6 == null) goto L28;
            if (r6.moveToFirst() == false) goto L14;
            int r0 = r6.getInt(0);     // Catch: Throwable -> L22
        L24:
            r6.close();     // Catch: Exception -> L21 Throwable -> L20
        L17:
            return r0;
        L14:
            r0 = r5;
            goto L24
        L28:
            return r5;
        L19:
            return this.b.getInt(r4, r5);
        }
    }

    public final synchronized SharedPreferences d() {
        monitor-enter(this);
        SharedPreferences r0 = this.a;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        SharedPreferences r1 = getContext().getApplicationContext().getSharedPreferences("push_multi_process_config", 4);     // Catch: Throwable -> L10
        this.a = r1;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        h = true;
        Context r1 = getContext();
        if (r1 == null) goto L6;
        AppProvider.initApp((Application) r1.getApplicationContext());
    L6:
        if (g != null) goto L17;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (f.a == false) goto L10;
        f.b("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L12
    L10:
        f(r1);     // Catch: Exception -> L12
        return true;
    L17:
        return true;
    }

    public static boolean g() {
        if (TextUtils.isEmpty(e) == false) goto L6;
        return true;
    L6:
        if (g == null) goto L10;
        return false;
    L10:
        return true;
    }

    public final void b() {
        if (this.c == true) goto L24;
        Object r0 = this.d;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (this.c == true) goto L19;
        SharedPreferences r1 = d();     // Catch: Throwable -> L21
        if (r1 == null) goto L18;
        Iterator<Map.Entry<String, ?>> r2 = r1.getAll().entrySet().iterator();     // Catch: Throwable -> L21
    L13:
        if (r2.hasNext() == false) goto L18;
        Map.Entry<String, ?> r3 = r2.next();     // Catch: Throwable -> L21
        String r4 = r3.getKey();     // Catch: Throwable -> L21
        Object r5 = r3.getValue();     // Catch: Throwable -> L21
        if (r4 == null) goto L13;
        if (r5 == null) goto L13;
        ((ConcurrentHashMap) this.b).put(r4, r5);     // Catch: Throwable -> L21
    L18:
        this.c = true;     // Catch: Throwable -> L21
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    }

    public PushMultiProcessSharedProvider() {
        this.b = new ConcurrentHashMap();
        this.c = false;
        this.d = new Object();
    }

    public static boolean a(Context r4) {
        boolean r0 = ToolUtils.isSmpProcess(r4);
        f.b("PushMultiProcessSP", "mAllowStartOthersProcess  is false isSmpProcess is " + r0);
        if (r0 == true) goto L5;
        return true;
    L5:
        Boolean r5 = ToolUtils.isMainProcessStart(r4);
        f.b("PushMultiProcessSP", "isMainProcessStartEd is " + r5);
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r5.booleanValue() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static synchronized b e(Context r2) {
        monitor-enter(PushMultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (i != null) goto L7;
        i = new b(r2);     // Catch: Throwable -> L10
    L7:
        b r3 = i;     // Catch: Throwable -> L10
        monitor-exit(PushMultiProcessSharedProvider.class);
        return r3;
    }

    public static void f(Context r7) throws IllegalStateException {
        if (TextUtils.isEmpty(e) == false) goto L20;
        String r0 = PushMultiProcessSharedProvider.class.getName();
        f.b("MultiProcessSharedProvider", "getProviderAuthority:".concat(r0));
        if (r7 != null) goto L7;
    L17:
        String r8 = null;
    L18:
        e = r8;
        goto L20
    L7:
        if (StringUtils.isEmpty(r0) == true) goto L17;
        ProviderInfo[] r2 = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 8).providers;     // Catch: Exception -> L28
        int r3 = r2.length;     // Catch: Exception -> L28
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L16;
        ProviderInfo r5 = r2[r4];     // Catch: Exception -> L28
        if (r0.equals(r5.name) == true) goto L13;
        r4 = r4 + 1;
        goto L10
    L13:
        r8 = r5.authority;     // Catch: Exception -> L28
    L16:
        r8 = r7.getPackageName() + ".push.SHARE_PROVIDER_AUTHORITY";
    L20:
        if (TextUtils.isEmpty(e) == true) goto L27;
        if (f.a == false) goto L24;
        f.b("MultiProcessSharedProvider", e);
    L24:
        UriMatcher r9 = new UriMatcher(-1);
        g = r9;
        r9.addURI(e, "*/*", 65536);
        f = UriProtector.parse("content://" + e);
        return;
    L27:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        f.b("MultiProcessSharedProvider", "getType:" + r3.toString());
        h = true;
        b();
        return "vnd.android.cursor.item/vnd." + e + ".item";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r2, ProviderInfo r3) {
        if (r3 == null) goto L4;
        e = r3.authority;
    L4:
        h = true;
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r11, ContentValues r12) {
        f.b("MultiProcessSharedProvider", "delete:" + r11.toString());
        h = true;
        b();
        if (g() == false) goto L6;
        return null;
    L6:
        if (g.match(r11) != 65536) goto L66;
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L62
        Iterator<Map.Entry<String, Object>> r13 = r12.valueSet().iterator();     // Catch: Exception -> L62
        SharedPreferences.Editor r3 = null;
    L9:
        if (r13.hasNext() == false) goto L55;
        Map.Entry<String, Object> r4 = r13.next();     // Catch: Exception -> L62
        Object r5 = r4.getValue();     // Catch: Exception -> L62
        String r6 = r4.getKey();     // Catch: Exception -> L62
        if (f.a == false) goto L14;
        f.b("PushService", "MultiProcessShareProvider insert key = " + r6 + " value = " + r5.toString());     // Catch: Exception -> L62
    L14:
        if (r5 != null) goto L17;
        ((ConcurrentHashMap) this.b).remove(r6);     // Catch: Exception -> L62
    L16:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L9;
        if (f.a == true) goto L28;
    L32:
        if (r3 != null) goto L34;
        r3 = d().edit();     // Catch: Exception -> L62
    L34:
        if (r5 != null) goto L37;
        r3.remove(r6);     // Catch: Exception -> L62
        bgc.a r8 = null;
    L51:
        if (r8 == null) goto L9;
        r1.add(r8);     // Catch: Exception -> L62
        goto L9
    L37:
        if ((r5 instanceof String) == false) goto L40;
        r3.putString(r6, (String) r5);     // Catch: Exception -> L62
        r8 = new bgc.a(this, r6, "string");     // Catch: Exception -> L62
        goto L51
    L40:
        if ((r5 instanceof Boolean) == false) goto L43;
        r3.putBoolean(r6, ((Boolean) r5).booleanValue());     // Catch: Exception -> L62
        r8 = new bgc.a(this, r6, "boolean");     // Catch: Exception -> L62
        goto L51
    L43:
        if ((r5 instanceof Long) == false) goto L46;
        r3.putLong(r6, ((Long) r5).longValue());     // Catch: Exception -> L62
        r8 = new bgc.a(this, r6, "long");     // Catch: Exception -> L62
        goto L51
    L46:
        if ((r5 instanceof Integer) == false) goto L49;
        r3.putInt(r6, ((Integer) r5).intValue());     // Catch: Exception -> L62
        r8 = new bgc.a(this, r6, "integer");     // Catch: Exception -> L62
        goto L51
    L49:
        if ((r5 instanceof Float) == false) goto L54;
        r3.putFloat(r6, ((Float) r5).floatValue());     // Catch: Exception -> L62
        r8 = new bgc.a(this, r6, "float");     // Catch: Exception -> L62
        goto L51
    L54:
        throw new IllegalArgumentException("Unsupported type " + r11);     // Catch: Exception -> L62
    L28:
        if (("MultiProcessShareProvider reallly insert key = " + r6 + " value = " + r5) == null) goto L30;
        String r9 = r5.toString();     // Catch: Exception -> L62
    L31:
        f.b("PushService", r9);     // Catch: Exception -> L62
        goto L32
    L30:
        r9 = "null";
        goto L31
    L17:
        Object r10 = ((ConcurrentHashMap) this.b).get(r6);     // Catch: Exception -> L62
        if (r10 != null) goto L20;
    L23:
        ((ConcurrentHashMap) this.b).put(r6, r5);     // Catch: Exception -> L62
        goto L16
    L20:
        if (r10.equals(r5) == false) goto L23;
        r7 = false;
        goto L24
    L55:
        if (r3 != null) goto L57;
        return null;
    L57:
        r3.apply();     // Catch: Exception -> L62
        Iterator r14 = r1.iterator();     // Catch: Exception -> L62
    L59:
        if (r14.hasNext() == false) goto L64;
        ((Runnable) r14.next()).run();     // Catch: Exception -> L62
    L64:
        return null;
    L62:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L66:
        throw new IllegalArgumentException("Unsupported uri " + r11);
    }

    public static final synchronized Uri c(Context r3, String r4, String r5) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider> r0 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.f     // Catch: java.lang.Throwable -> L31
            if (r1 != 0) goto L1d
            boolean r1 = com.bytedance.push.utils.f.a     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L31
            if (r1 == 0) goto L12
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.push.utils.f.b(r1, r2)     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L31
        L12:
            f(r3)     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L31
            goto L1d
        L16:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L31
            monitor-exit(r0)
            r3 = 0
            return r3
        L1d:
            android.net.Uri r3 = com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.f     // Catch: java.lang.Throwable -> L31
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L31
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L31
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L31
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L31
            monitor-exit(r0)
            return r3
        L31:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.c(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r2, String r3, String[] r4) {
        f.b("MultiProcessSharedProvider", "delete:" + r2.toString() + " " + r3);
        h = true;
        b();
        if (g() == false) goto L6;
        return 0;
    L6:
        if (g.match(r2) != 65536) goto L9;
        return 0;
    L9:
        throw new IllegalArgumentException("Unsupported uri " + r2);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        h = true;
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r5, String[] r6, String r7, String[] r8, String r9) {
        f.b("MultiProcessSharedProvider", "query:" + r5.toString());
        int r10 = 1;
        h = true;
        b();
        Object r11 = null;
        String r12 = null;
        if (g() == false) goto L6;
        return null;
    L6:
        if (g.match(r5) != 65536) goto L67;
        if (DownloadConstants.ENCODING_SCENE_ALL.equals((String) ListProtector.get(r5.getPathSegments(), 1)) == false) goto L36;
        Map<String, ?> r13 = d().getAll();     // Catch: Exception -> L68
        MatrixCursor r14 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L68
        Iterator<Map.Entry<String, ?>> r15 = r13.entrySet().iterator();     // Catch: Exception -> L35
    L11:
        r11 = r12;
        if (r15.hasNext() == false) goto L73;
        Map.Entry<String, ?> r16 = r15.next();     // Catch: Exception -> L35
        String r17 = r16.getKey();     // Catch: Exception -> L35
        Object r18 = r16.getValue();     // Catch: Exception -> L35
        MatrixCursor.RowBuilder r1 = r14.newRow();     // Catch: Exception -> L35
        String r3 = "string";
        if ((r18 instanceof String) == true) goto L33;
        if ((r18 instanceof Boolean) == false) goto L25;
        r3 = "boolean";
        if (((Boolean) r18).booleanValue() == false) goto L22;
        int r19 = 1;
    L23:
        r18 = Integer.valueOf(r19);     // Catch: Exception -> L35
        goto L33
    L22:
        r19 = 0;
        goto L23
    L25:
        if ((r18 instanceof Integer) == false) goto L28;
        r3 = "integer";
        goto L33
    L28:
        if ((r18 instanceof Long) == false) goto L31;
        r3 = "long";
        goto L33
    L31:
        if ((r18 instanceof Float) == false) goto L33;
        r3 = "float";
    L33:
        r1.add(r17);     // Catch: Exception -> L35
        r1.add(r18);     // Catch: Exception -> L35
        r1.add(r3);     // Catch: Exception -> L35
        r12 = r17;
    L73:
        return r14;
    L35:
        r11 = r14;
        goto L82
    L36:
        String r20 = (String) ListProtector.get(r5.getPathSegments(), 0);     // Catch: Exception -> L68
        boolean r21 = StringUtils.equal(r20, "current_app_state");     // Catch: Exception -> L68
        boolean r2 = StringUtils.equal(r20, "current_app_foreground");     // Catch: Exception -> L68
        if (((ConcurrentHashMap) this.b).containsKey(r20) == true) goto L41;
        if (r21 == true) goto L41;
        if (r2 == true) goto L41;
        return null;
    L41:
        MatrixCursor r4 = new MatrixCursor(new String[]{r20});     // Catch: Exception -> L68
        if (r21 == false) goto L45;
        Object r22 = Boolean.valueOf(ActivityLifecycleObserver.getIns().isApplicationActive());     // Catch: Exception -> L44
    L52:
        MatrixCursor.RowBuilder r23 = r4.newRow();     // Catch: Exception -> L44
        if ((r22 instanceof Boolean) == false) goto L60;
        if (((Boolean) r22).booleanValue() == true) goto L58;
        r10 = 0;
    L58:
        r22 = Integer.valueOf(r10);     // Catch: Exception -> L44
    L60:
        if (f.a == false) goto L62;
        f.b("PushService", "MultiProcessShareProvider reallly get key = " + r20 + " value = " + r22.toString());     // Catch: Exception -> L44
    L62:
        r23.add(r22);     // Catch: Exception -> L44
        r14 = r4;
        r11 = r23;
        goto L73
    L45:
        if (r2 == true) goto L47;
        r22 = ((ConcurrentHashMap) this.b).get(r20);     // Catch: Exception -> L44
        goto L52
    L47:
        if (ActivityLifecycleObserver.getIns().isBackGround() == true) goto L49;
        boolean r24 = true;
    L50:
        r22 = Boolean.valueOf(r24);     // Catch: Exception -> L44
        goto L52
    L49:
        r24 = false;
    L44:
        r11 = r4;
    L82:
        return r11;
    L67:
        throw new IllegalArgumentException("Unsupported uri " + r5);
    }
}
