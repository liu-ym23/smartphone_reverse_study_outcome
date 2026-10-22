package com.ss.android.token;

import android.aimedia.a;
import android.app.ActivityManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import defpackage.b;
import defpackage.c;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import r5.f;
import vd.d;

/* JADX INFO: loaded from: classes2.dex */
public class AuthTokenMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f6721o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Uri f6722p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static UriMatcher f6723q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f6724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f6725b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f6726m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f6727n;

    public AuthTokenMultiProcessSharedProvider() {
        this.f6725b = new ConcurrentHashMap();
        this.f6726m = false;
        this.f6727n = new Object();
    }

    public static final synchronized Uri b(Context r8, String r10, String r11) {
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
            java.lang.Class<com.ss.android.token.AuthTokenMultiProcessSharedProvider> r0 = com.ss.android.token.AuthTokenMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.ss.android.token.AuthTokenMultiProcessSharedProvider.f6722p     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L1f
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
        L14:
            d(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            goto L1f
        L18:
            r3 = move-exception
            defpackage.c.S(r3)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            r3 = 0
            return r3
        L1f:
            android.net.Uri r3 = com.ss.android.token.AuthTokenMultiProcessSharedProvider.f6722p     // Catch: java.lang.Throwable -> L33
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.token.AuthTokenMultiProcessSharedProvider.b(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static void d(Context r8) {
        if (TextUtils.isEmpty(f6721o) == false) goto L22;
        String r10 = AuthTokenMultiProcessSharedProvider.class.getName();
        if (r8 != null) goto L7;
    L19:
        String r11 = null;
    L20:
        f6721o = r11;
        goto L22
    L7:
        if (f.b(r10) == true) goto L19;
        ProviderInfo[] r12 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 8).providers;     // Catch: Exception -> L16
        int r13 = r12.length;     // Catch: Exception -> L16
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L18;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L16
        if (r10.equals(r15.name) == true) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        r11 = r15.authority;     // Catch: Exception -> L16
    L18:
        r11 = r8.getPackageName() + ".auth_token.SHARE_PROVIDER_AUTHORITY";
    L16:
        e = move-exception;
        c.S(e);
    L22:
        if (TextUtils.isEmpty(f6721o) == true) goto L29;
        if (Logger.debug() == false) goto L26;
        Logger.d("AuthTokenMultiProcessSharedProvider", f6721o);
    L26:
        UriMatcher r16 = new UriMatcher(-1);
        f6723q = r16;
        r16.addURI(f6721o, "*/*", 65536);
        f6722p = Uri.parse("content://" + f6721o);
        return;
    L29:
        throw new IllegalStateException("Must Set AuthTokenMultiProcessSharedProvider Authority");
    }

    public static boolean e() {
        if (TextUtils.isEmpty(f6721o) == false) goto L6;
        return true;
    L6:
        if (f6723q == null) goto L10;
        return false;
    L10:
        return true;
    }

    public final void a() {
        if (this.f6726m == true) goto L14;
        Object r8 = this.f6727n;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f6726m == true) goto L9;
        f();     // Catch: Throwable -> L11
        this.f6726m = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r8, ProviderInfo r10) {
        if (r10 == null) goto L4;
        f6721o = r10.authority;
    L4:
        super.attachInfo(r8, r10);
    }

    public final synchronized SharedPreferences c() {
        monitor-enter(this);
        SharedPreferences r8 = this.f6724a;     // Catch: Throwable -> L10
        if (r8 != null) goto L8;
        SharedPreferences r10 = getContext().getApplicationContext().getSharedPreferences("token_shared_preference", 4);     // Catch: Throwable -> L10
        this.f6724a = r10;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r10;
    L8:
        monitor-exit(this);
        return r8;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r8, String r10, String[] r11) {
        a();
        if (e() == false) goto L6;
        return 0;
    L6:
        if (f6723q.match(r8) != 65536) goto L13;
        this.f6725b.clear();     // Catch: Exception -> L9
        c().edit().clear().commit();     // Catch: Exception -> L9
        Uri r12 = b(getContext(), "key", "type");     // Catch: Exception -> L9
        getContext().getContentResolver().notifyChange(r12, null);     // Catch: Exception -> L9
    L11:
        return 0;
    L9:
        e = move-exception;
        c.S(e);
        goto L11
    L13:
        throw new IllegalArgumentException(b.b("Unsupported uri ", r8));
    }

    public final void f() {
        SharedPreferences r8 = c();
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ?>> r10 = r8.getAll().entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L16;
        Map.Entry<String, ?> r11 = r10.next();
        String r12 = r11.getKey();
        Object r13 = r11.getValue();
        if (r13 == null) goto L17;
        if (r12 == null) goto L17;
        this.f6725b.put(r12, r13);
    L17:
        Logger.d("AuthTokenMultiProcessShared", "MultiProcessShareProvider loadValues key_ = " + r12 + " value_ = " + r13);     // Catch: Exception -> L14
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L14
        r14.put("key_", r12);     // Catch: Exception -> L14
        r14.put("value_", r13);     // Catch: Exception -> L14
        t2.b.M(r14);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        c.S(e);
        goto L7
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r8) {
        a();
        return a.i(new StringBuilder("vnd.android.cursor.item/vnd."), f6721o, ".item");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r11, ContentValues r12) {
        a();
        if (e() == false) goto L6;
        return null;
    L6:
        if (f6723q.match(r11) != 65536) goto L54;
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L50
        Iterator<Map.Entry<String, Object>> r13 = r12.valueSet().iterator();     // Catch: Exception -> L50
        SharedPreferences.Editor r10 = null;
    L9:
        if (r13.hasNext() == false) goto L43;
        Map.Entry<String, Object> r14 = r13.next();     // Catch: Exception -> L50
        Object r15 = r14.getValue();     // Catch: Exception -> L50
        String r16 = r14.getKey();     // Catch: Exception -> L50
        Logger.d("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r16 + " value = " + vd.c.a(r15));     // Catch: Exception -> L50
        if (r16 == null) goto L9;
        ConcurrentHashMap r17 = this.f6725b;
        Object r18 = r17.get(r16);     // Catch: Exception -> L50
        if (r18 != null) goto L17;
    L20:
        r17.put(r16, r15);     // Catch: Exception -> L50
        boolean r19 = true;
    L21:
        if (r19 == false) goto L9;
        Logger.d("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r16 + " value = " + vd.c.a(r15));     // Catch: Exception -> L50
        if (r10 != null) goto L26;
        r10 = c().edit();     // Catch: Exception -> L50
    L26:
        if ((r15 instanceof String) == false) goto L29;
        r10.putString(r16, (String) r15);     // Catch: Exception -> L50
        vd.a r20 = new vd.a(this, r16, "string");     // Catch: Exception -> L50
    L40:
        r8.add(r20);     // Catch: Exception -> L50
        goto L9
    L29:
        if ((r15 instanceof Boolean) == false) goto L32;
        r10.putBoolean(r16, ((Boolean) r15).booleanValue());     // Catch: Exception -> L50
        r20 = new vd.a(this, r16, "boolean");     // Catch: Exception -> L50
        goto L40
    L32:
        if ((r15 instanceof Long) == false) goto L35;
        r10.putLong(r16, ((Long) r15).longValue());     // Catch: Exception -> L50
        r20 = new vd.a(this, r16, MultiProcessSharedProvider.LONG_TYPE);     // Catch: Exception -> L50
        goto L40
    L35:
        if ((r15 instanceof Integer) == false) goto L38;
        r10.putInt(r16, ((Integer) r15).intValue());     // Catch: Exception -> L50
        r20 = new vd.a(this, r16, MultiProcessSharedProvider.INT_TYPE);     // Catch: Exception -> L50
        goto L40
    L38:
        if ((r15 instanceof Float) == false) goto L42;
        r10.putFloat(r16, ((Float) r15).floatValue());     // Catch: Exception -> L50
        r20 = new vd.a(this, r16, "float");     // Catch: Exception -> L50
        goto L40
    L42:
        throw new IllegalArgumentException("Unsupported type " + r11);     // Catch: Exception -> L50
    L17:
        if (r18.equals(r15) == false) goto L20;
        r19 = false;
        goto L21
    L43:
        if (r10 != null) goto L45;
        return null;
    L45:
        r10.apply();     // Catch: Exception -> L50
        Iterator r110 = r8.iterator();     // Catch: Exception -> L50
    L47:
        if (r110.hasNext() == false) goto L52;
        ((Runnable) r110.next()).run();     // Catch: Exception -> L50
    L52:
        return null;
    L50:
        e = move-exception;
        c.S(e);
        goto L52
    L54:
        throw new IllegalArgumentException(b.b("Unsupported uri ", r11));
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (Logger.debug() == false) goto L62;
        Context r8 = getContext();
        String r10 = d.f12846a;
        if (f.b(r10) == true) goto L76;
    L41:
        if (r10 != null) goto L43;
    L45:
        if (r10 != null) goto L47;
    L49:
        boolean r11 = false;
    L50:
        if (r11 == true) goto L62;
        throw new IllegalAccessError("should be create in main process");
    L47:
        if (r10.equals(r8.getPackageName()) == false) goto L49;
        r11 = true;
        goto L50
    L43:
        if (r10.contains(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L45;
    L76:
        int r12 = Process.myPid();     // Catch: Exception -> L17
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r8.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L17
    L9:
        if (r13.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L17
        if (r14.pid != r12) goto L9;
        if (Logger.debug() == false) goto L15;
        Logger.d("Process", "processName = " + r14.processName);     // Catch: Exception -> L17
    L15:
        r10 = r14.processName;     // Catch: Exception -> L17
        d.f12846a = r10;     // Catch: Exception -> L17
    L19:
        String r15 = null;
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L32
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L30
    L22:
        int r18 = r16.read();     // Catch: Throwable -> L30
        if (r18 <= 0) goto L26;
        r17.append((char) r18);     // Catch: Throwable -> L30
        goto L22
    L26:
        if (Logger.debug() == false) goto L28;
        Logger.d("Process", "get processName = " + r17.toString());     // Catch: Throwable -> L30
    L28:
        r15 = r17.toString();     // Catch: Throwable -> L30
    L80:
        r16.close();     // Catch: Exception -> L38
    L40:
        r10 = r15;
        d.f12846a = r10;
    L38:
        e = move-exception;
        c.S(e);
    L30:
        th = th;
    L82:
        c.S(th);     // Catch: Throwable -> L54
        if (r16 == null) goto L40;
    L54:
        th = move-exception;
        if (r16 != null) goto L74;
    L60:
        throw th;
    L74:
        r16.close();     // Catch: Exception -> L58
    L58:
        e = move-exception;
        c.S(e);
    L32:
        th = th;
        r16 = null;
    L17:
        e = move-exception;
        c.S(e);
    L62:
        if (f6723q == null) goto L78;
    L71:
        return true;
    L78:
    L68:
        e = move-exception;
        c.S(e);
        e.printStackTrace();
        return false;
    L64:
        if (Logger.debug() == false) goto L66;
        Logger.d("AuthTokenMultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L68
    L66:
        d(getContext());     // Catch: Exception -> L68
        goto L71
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public final Cursor query(Uri r8, String[] r10, String r11, String[] r12, String r13) {
        a();
        MatrixCursor.RowBuilder r14 = null;
        if (e() == false) goto L6;
        return null;
    L6:
        if (f6723q.match(r8) != 65536) goto L59;
        int r15 = 1;
        if ("all".equals(r8.getPathSegments().get(1)) == false) goto L38;
        Map<String, ?> r16 = c().getAll();     // Catch: Exception -> L55
        MatrixCursor r17 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L55
        Iterator<Map.Entry<String, ?>> r18 = r16.entrySet().iterator();     // Catch: Exception -> L36
    L11:
        if (r18.hasNext() == false) goto L62;
        Map.Entry<String, ?> r19 = r18.next();     // Catch: Exception -> L36
        String r20 = r19.getKey();     // Catch: Exception -> L36
        Object r21 = r19.getValue();     // Catch: Exception -> L36
        r14 = r17.newRow();     // Catch: Exception -> L36
        if ((r21 instanceof String) == false) goto L17;
    L33:
        String r22 = "string";
    L34:
        r14.add(r20);     // Catch: Exception -> L36
        r14.add(r21);     // Catch: Exception -> L36
        r14.add(r22);     // Catch: Exception -> L36
        goto L11
    L17:
        if ((r21 instanceof Boolean) == false) goto L24;
        r22 = "boolean";
        if (((Boolean) r21).booleanValue() == false) goto L21;
        int r23 = 1;
    L22:
        r21 = Integer.valueOf(r23);     // Catch: Exception -> L36
        goto L34
    L21:
        r23 = 0;
        goto L22
    L24:
        if ((r21 instanceof Integer) == false) goto L27;
        r22 = MultiProcessSharedProvider.INT_TYPE;
        goto L34
    L27:
        if ((r21 instanceof Long) == false) goto L30;
        r22 = MultiProcessSharedProvider.LONG_TYPE;
        goto L34
    L30:
        if ((r21 instanceof Float) == false) goto L33;
        r22 = "float";
    L62:
        return r17;
    L36:
        e = e;
        r14 = r17;
    L56:
        c.S(e);
        return r14;
    L38:
        String r24 = r8.getPathSegments().get(0);     // Catch: Exception -> L55
        ConcurrentHashMap r25 = this.f6725b;
        if (r25.containsKey(r24) == true) goto L43;
        return null;
    L43:
        MatrixCursor r26 = new MatrixCursor(new String[]{r24});     // Catch: Exception -> L55
        Object r27 = r25.get(r24);     // Catch: Exception -> L53
        r14 = r26.newRow();     // Catch: Exception -> L53
        if ((r27 instanceof Boolean) == true) goto L47;
    L51:
        Logger.d("AuthTokenMultiProcessShared", "MultiProcessShareProvider  get key = " + r24 + " value = " + vd.c.a(r27) + " " + Log.getStackTraceString(new Exception()));     // Catch: Exception -> L53
        r14.add(r27);     // Catch: Exception -> L53
        r17 = r26;
        goto L62
    L47:
        if (((Boolean) r27).booleanValue() == true) goto L50;
        r15 = 0;
    L50:
        r27 = Integer.valueOf(r15);     // Catch: Exception -> L53
    L53:
        e = e;
        r14 = r26;
    L55:
        e = e;
        goto L56
    L59:
        throw new IllegalArgumentException(b.b("Unsupported uri ", r8));
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        throw new UnsupportedOperationException();
    }
}
