package com.bytedance.common.wschannel;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r5.f;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f3854n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Uri f3855o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static UriMatcher f3856p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f3857q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile boolean f3858r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static b f3859s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f3860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3861b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f3862m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f3863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ContentValues f3864b;

        public a(Context r8) {
            this.f3864b = new ContentValues();
            this.f3863a = r8.getApplicationContext();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f3865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SharedPreferences f3867c;

        public b(Context r8) {
            boolean r10 = false;
            this.f3866b = false;
            if (k6.a.c(r8) == true) goto L5;
        L7:
            this.f3866b = r10;
            Context r11 = r8.getApplicationContext();
            this.f3865a = r11;
            this.f3867c = r11.getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);
            if (Logger.debug() == false) goto L11;
            Logger.v("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (WsChannelMultiProcessSharedProvider.f3857q == false) goto L7;
            r10 = true;
            goto L7
        }

        public final boolean a(String r8, boolean r10) {
            Context r11 = this.f3865a;
            if (this.f3866b == true) goto L6;
            Cursor r12 = r11.getContentResolver().query(WsChannelMultiProcessSharedProvider.a(r11, r8, "boolean"), null, null, null, null);     // Catch: Throwable -> L21
            if (r12 == null) goto L27;
            if (r12.moveToFirst() == false) goto L15;
            boolean r13 = false;
            if (r12.getInt(0) <= 0) goto L25;
            r13 = true;
        L25:
            r12.close();     // Catch: Exception -> L19 Throwable -> L21
        L18:
            return r13;
        L15:
            r13 = r10;
            goto L25
        L27:
            return r10;
        L6:
            return this.f3867c.getBoolean(r8, r10);
        L28:
            return r10;
        }

        public final long b(String r8, long r10) {
            Context r11 = this.f3865a;
            if (this.f3866b == true) goto L6;
            Cursor r12 = r11.getContentResolver().query(WsChannelMultiProcessSharedProvider.a(r11, r8, MultiProcessSharedProvider.LONG_TYPE), null, null, null, null);     // Catch: Throwable -> L20
            if (r12 == null) goto L26;
            if (r12.moveToFirst() == false) goto L14;
            long r13 = r12.getLong(0);     // Catch: Throwable -> L19
        L22:
            r12.close();     // Catch: Exception -> L18 Throwable -> L20
        L17:
            return r13;
        L14:
            r13 = r10;
            goto L22
        L26:
            return r10;
        L6:
            return this.f3867c.getLong(r8, r10);
        L27:
            return r10;
        }
    }

    public WsChannelMultiProcessSharedProvider() {
        this.f3861b = new ConcurrentHashMap();
        this.f3862m = new Object();
    }

    public static final synchronized Uri a(Context r8, String r10, String r11) {
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
            java.lang.Class<com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider> r0 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.f3855o     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L1f
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
        L14:
            c(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            goto L1f
        L18:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            r3 = 0
            return r3
        L1f:
            android.net.Uri r3 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.f3855o     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L33
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            return r3
        L33:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.a(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static void c(Context r8) {
        if (TextUtils.isEmpty(f3854n) == false) goto L19;
        String r10 = WsChannelMultiProcessSharedProvider.class.getName();
        if (r8 != null) goto L7;
    L16:
        String r11 = null;
    L17:
        f3854n = r11;
        goto L19
    L7:
        if (f.b(r10) == true) goto L16;
        ProviderInfo[] r12 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 8).providers;     // Catch: Exception -> L27
        int r13 = r12.length;     // Catch: Exception -> L27
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L16;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L27
        if (r10.equals(r15.name) == true) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        r11 = r15.authority;     // Catch: Exception -> L27
    L19:
        if (TextUtils.isEmpty(f3854n) == true) goto L26;
        if (Logger.debug() == false) goto L23;
        Logger.v("MultiProcessSharedProvider", f3854n);
    L23:
        UriMatcher r16 = new UriMatcher(-1);
        f3856p = r16;
        r16.addURI(f3854n, "*/*", 65536);
        f3855o = Uri.parse("content://" + f3854n);
        return;
    L26:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r8, ProviderInfo r10) {
        if (r10 == null) goto L4;
        f3854n = r10.authority;
    L4:
        super.attachInfo(r8, r10);
    }

    public final synchronized SharedPreferences b() {
        monitor-enter(this);
        SharedPreferences r8 = this.f3860a;     // Catch: Throwable -> L10
        if (r8 != null) goto L8;
        SharedPreferences r10 = getContext().getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);     // Catch: Throwable -> L10
        this.f3860a = r10;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r10;
    L8:
        monitor-exit(this);
        return r8;
    L10:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (f3858r == true) goto L23;
        Object r8 = this.f3862m;
        monitor-enter(r8);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f3858r == true) goto L18;
        SharedPreferences r10 = b();     // Catch: Throwable -> L20
        if (r10 != null) goto L13;
        f3858r = true;     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
        return;
    L13:
        Iterator<Map.Entry<String, ?>> r11 = r10.getAll().entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r11.hasNext() == false) goto L17;
        Map.Entry<String, ?> r12 = r11.next();     // Catch: Throwable -> L20
        String r13 = r12.getKey();     // Catch: Throwable -> L20
        Object r14 = r12.getValue();     // Catch: Throwable -> L20
        this.f3861b.put(r13, r14);     // Catch: Throwable -> L20
        goto L15
    L17:
        f3858r = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r8);     // Catch: Throwable -> L20
        return;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r8, String r10, String[] r11) {
        if (f3856p.match(r8) != 65536) goto L8;
        b().edit().clear().commit();     // Catch: Exception -> L9
        this.f3861b.clear();     // Catch: Exception -> L9
        Uri r12 = a(getContext(), "key", "type");     // Catch: Exception -> L9
        getContext().getContentResolver().notifyChange(r12, null);     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException(defpackage.b.b("Unsupported uri ", r8));
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r8) {
        return android.aimedia.a.i(new StringBuilder("vnd.android.cursor.item/vnd."), f3854n, ".item");
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"NewApi"})
    public final Uri insert(Uri r10, ContentValues r11) {
        if (f3856p.match(r10) != 65536) goto L63;
        d();     // Catch: Exception -> L64
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L64
        Iterator<Map.Entry<String, Object>> r12 = r11.valueSet().iterator();     // Catch: Exception -> L64
        SharedPreferences.Editor r13 = null;
    L7:
        if (r12.hasNext() == false) goto L54;
        Map.Entry<String, Object> r14 = r12.next();     // Catch: Exception -> L64
        Object r15 = r14.getValue();     // Catch: Exception -> L64
        String r16 = r14.getKey();     // Catch: Exception -> L64
        if (Logger.debug() == false) goto L12;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r16 + " value = " + r15.toString());     // Catch: Exception -> L64
    L12:
        ConcurrentHashMap r17 = this.f3861b;
        if (r15 != null) goto L15;
        r17.remove(r16);     // Catch: Exception -> L64
    L22:
        boolean r18 = true;
    L23:
        if (r18 == false) goto L7;
        if (Logger.debug() == true) goto L27;
    L31:
        if (r13 != null) goto L33;
        r13 = b().edit();     // Catch: Exception -> L64
    L33:
        if (r15 != null) goto L36;
        r13.remove(r16);     // Catch: Exception -> L64
        w5.b r19 = null;
    L50:
        if (r19 == null) goto L7;
        r8.add(r19);     // Catch: Exception -> L64
        goto L7
    L36:
        if ((r15 instanceof String) == false) goto L39;
        r13.putString(r16, (String) r15);     // Catch: Exception -> L64
        r19 = new w5.b(this, r16, "string");     // Catch: Exception -> L64
        goto L50
    L39:
        if ((r15 instanceof Boolean) == false) goto L42;
        r13.putBoolean(r16, ((Boolean) r15).booleanValue());     // Catch: Exception -> L64
        r19 = new w5.b(this, r16, "boolean");     // Catch: Exception -> L64
        goto L50
    L42:
        if ((r15 instanceof Long) == false) goto L45;
        r13.putLong(r16, ((Long) r15).longValue());     // Catch: Exception -> L64
        r19 = new w5.b(this, r16, MultiProcessSharedProvider.LONG_TYPE);     // Catch: Exception -> L64
        goto L50
    L45:
        if ((r15 instanceof Integer) == false) goto L48;
        r13.putInt(r16, ((Integer) r15).intValue());     // Catch: Exception -> L64
        r19 = new w5.b(this, r16, MultiProcessSharedProvider.INT_TYPE);     // Catch: Exception -> L64
        goto L50
    L48:
        if ((r15 instanceof Float) == false) goto L53;
        r13.putFloat(r16, ((Float) r15).floatValue());     // Catch: Exception -> L64
        r19 = new w5.b(this, r16, "float");     // Catch: Exception -> L64
        goto L50
    L53:
        throw new IllegalArgumentException("Unsupported type " + r10);     // Catch: Exception -> L64
    L27:
        if (("MultiProcessShareProvider reallly insert key = " + r16 + " value = " + r15) == null) goto L29;
        String r20 = r15.toString();     // Catch: Exception -> L64
    L30:
        Logger.v("PushService", r20);     // Catch: Exception -> L64
        goto L31
    L29:
        r20 = "null";
        goto L30
    L15:
        Object r21 = r17.get(r16);     // Catch: Exception -> L64
        if (r21 != null) goto L18;
    L21:
        r17.put(r16, r15);     // Catch: Exception -> L64
        goto L22
    L18:
        if (r21.equals(r15) == false) goto L21;
        r18 = false;
        goto L23
    L54:
        if (r13 != null) goto L56;
        return null;
    L56:
        r13.apply();     // Catch: Exception -> L64
        Iterator r22 = r8.iterator();     // Catch: Exception -> L64
    L58:
        if (r22.hasNext() == false) goto L61;
        ((Runnable) r22.next()).run();     // Catch: Exception -> L64
    L61:
        return null;
    L63:
        throw new IllegalArgumentException(defpackage.b.b("Unsupported uri ", r10));
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (k6.a.c(getContext()) == false) goto L6;
        f3857q = true;
    L6:
        if (f3856p == null) goto L16;
    L15:
        return true;
    L16:
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L12
    L10:
        c(getContext());     // Catch: Exception -> L12
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public final Cursor query(Uri r8, String[] r10, String r11, String[] r12, String r13) {
        if (f3856p.match(r8) != 65536) goto L57;
        Object r14 = null;
        String r15 = null;
        int r16 = 1;
        if ("all".equals(r8.getPathSegments().get(1)) == false) goto L35;
        Map<String, ?> r17 = b().getAll();     // Catch: Exception -> L58
        MatrixCursor r18 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L58
        Iterator<Map.Entry<String, ?>> r19 = r17.entrySet().iterator();     // Catch: Exception -> L34
    L9:
        r14 = r15;
        if (r19.hasNext() == false) goto L59;
        Map.Entry<String, ?> r20 = r19.next();     // Catch: Exception -> L34
        String r21 = r20.getKey();     // Catch: Exception -> L34
        Object r22 = r20.getValue();     // Catch: Exception -> L34
        MatrixCursor.RowBuilder r23 = r18.newRow();     // Catch: Exception -> L34
        if ((r22 instanceof String) == false) goto L15;
    L31:
        String r24 = "string";
    L32:
        r23.add(r21);     // Catch: Exception -> L34
        r23.add(r22);     // Catch: Exception -> L34
        r23.add(r24);     // Catch: Exception -> L34
        r15 = r21;
        goto L9
    L15:
        if ((r22 instanceof Boolean) == false) goto L22;
        r24 = "boolean";
        if (((Boolean) r22).booleanValue() == false) goto L19;
        int r25 = 1;
    L20:
        r22 = Integer.valueOf(r25);     // Catch: Exception -> L34
        goto L32
    L19:
        r25 = 0;
        goto L20
    L22:
        if ((r22 instanceof Integer) == false) goto L25;
        r24 = MultiProcessSharedProvider.INT_TYPE;
        goto L32
    L25:
        if ((r22 instanceof Long) == false) goto L28;
        r24 = MultiProcessSharedProvider.LONG_TYPE;
        goto L32
    L28:
        if ((r22 instanceof Float) == false) goto L31;
        r24 = "float";
    L59:
        return r18;
    L34:
        r14 = r18;
        goto L71
    L35:
        String r26 = r8.getPathSegments().get(0);     // Catch: Exception -> L58
        d();     // Catch: Exception -> L58
        ConcurrentHashMap r27 = this.f3861b;
        if (r27.containsKey(r26) == true) goto L40;
        return null;
    L40:
        MatrixCursor r28 = new MatrixCursor(new String[]{r26});     // Catch: Exception -> L58
        Object r29 = r27.get(r26);     // Catch: Exception -> L53
        MatrixCursor.RowBuilder r30 = r28.newRow();     // Catch: Exception -> L53
        if ((r29 instanceof Boolean) == false) goto L49;
        if (((Boolean) r29).booleanValue() == true) goto L47;
        r16 = 0;
    L47:
        r29 = Integer.valueOf(r16);     // Catch: Exception -> L53
    L49:
        if (Logger.debug() == false) goto L51;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r26 + " value = " + r29.toString());     // Catch: Exception -> L53
    L51:
        r30.add(r29);     // Catch: Exception -> L53
        r18 = r28;
        r14 = r30;
    L53:
        r14 = r28;
    L71:
        return r14;
    L57:
        throw new IllegalArgumentException(defpackage.b.b("Unsupported uri ", r8));
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        throw new UnsupportedOperationException();
    }
}
