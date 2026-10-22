package com.bytedance.common.wschannel;

import ai.j0;
import android.app.Application;
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
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import c5.a;
import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.b;
import g8.c;
import g8.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jg.k;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {
    public static String d = null;
    public static Uri e = null;
    public static UriMatcher f = null;
    public static boolean g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f3969h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f3970i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f3971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3973c;

    public WsChannelMultiProcessSharedProvider() {
        this.f3972b = new ConcurrentHashMap();
        this.f3973c = new Object();
    }

    public static final synchronized Uri b(Context r5, String r10, String r11) {
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
            android.net.Uri r1 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.e     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L23
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            if (r1 == 0) goto L19
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            goto L19
        L15:
            r3 = move-exception
            goto L37
        L17:
            r3 = move-exception
            goto L1d
        L19:
            c(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            goto L23
        L1d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            r3 = 0
            return r3
        L23:
            android.net.Uri r3 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.e     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L15
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L15
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            return r3
        L37:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.b(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static void c(Context r10) {
        if (TextUtils.isEmpty(d) == false) goto L18;
        String r5 = WsChannelMultiProcessSharedProvider.class.getName();
        String r11 = null;
        if (r10 != null) goto L7;
    L16:
        d = r11;
        goto L18
    L7:
        if (b.b(r5) == true) goto L16;
        ProviderInfo[] r12 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 8).providers;     // Catch: Exception -> L26
        int r13 = r12.length;     // Catch: Exception -> L26
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L16;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L26
        if (r5.equals(r15.name) == true) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        r11 = r15.authority;     // Catch: Exception -> L26
    L18:
        if (TextUtils.isEmpty(d) == true) goto L25;
        if (Logger.debug() == false) goto L22;
        Logger.v("MultiProcessSharedProvider", d);
    L22:
        UriMatcher r16 = new UriMatcher(-1);
        f = r16;
        r16.addURI(d, "*/*", 65536);
        e = Uri.parse("content://" + d);
        return;
    L25:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    public final synchronized SharedPreferences a() {
        monitor-enter(this);
        SharedPreferences r5 = this.f3971a;     // Catch: Throwable -> L8
        if (r5 != null) goto L10;
        SharedPreferences r10 = getContext().getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);     // Catch: Throwable -> L8
        this.f3971a = r10;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r10;
    L10:
        monitor-exit(this);
        return r5;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r5, ProviderInfo r10) {
        if (r10 == null) goto L4;
        d = r10.authority;
    L4:
        super.attachInfo(r5, r10);
    }

    public final void d() {
        if (f3969h == true) goto L24;
        Object r5 = this.f3973c;
        monitor-enter(r5);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f3969h == true) goto L20;
        SharedPreferences r10 = a();     // Catch: Throwable -> L13
        if (r10 != null) goto L15;
        f3969h = true;     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        return;
    L15:
        Iterator<Map.Entry<String, ?>> r11 = r10.getAll().entrySet().iterator();     // Catch: Throwable -> L13
    L17:
        if (r11.hasNext() == false) goto L19;
        Map.Entry<String, ?> r12 = r11.next();     // Catch: Throwable -> L13
        String r13 = r12.getKey();     // Catch: Throwable -> L13
        Object r14 = r12.getValue();     // Catch: Throwable -> L13
        this.f3972b.put(r13, r14);     // Catch: Throwable -> L13
        goto L17
    L19:
        f3969h = true;     // Catch: Throwable -> L13
    L20:
        monitor-exit(r5);     // Catch: Throwable -> L13
        return;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r5, String r10, String[] r11) {
        if (f.match(r5) != 65536) goto L8;
        a().edit().clear().commit();     // Catch: Exception -> L9
        this.f3972b.clear();     // Catch: Exception -> L9
        Uri r12 = b(getContext(), STGroup.DICT_KEY, "type");     // Catch: Exception -> L9
        getContext().getContentResolver().notifyChange(r12, null);     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException(j0.i(r5, "Unsupported uri "));
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r5) {
        return j0.q(new StringBuilder("vnd.android.cursor.item/vnd."), d, ".item");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r10, ContentValues r11) {
        if (f.match(r10) != 65536) goto L59;
        d();     // Catch: Exception -> L60
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L60
        Iterator<Map.Entry<String, Object>> r12 = r11.valueSet().iterator();     // Catch: Exception -> L60
        SharedPreferences.Editor r13 = null;
    L7:
        if (r12.hasNext() == false) goto L50;
        Map.Entry<String, Object> r14 = r12.next();     // Catch: Exception -> L60
        Object r15 = r14.getValue();     // Catch: Exception -> L60
        String r16 = r14.getKey();     // Catch: Exception -> L60
        if (Logger.debug() == false) goto L12;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r16 + " value = " + r15.toString());     // Catch: Exception -> L60
    L12:
        ConcurrentHashMap r17 = this.f3972b;
        if (r15 == null) goto L14;
        Object r18 = r17.get(r16);     // Catch: Exception -> L60
        if (r18 == null) goto L19;
        if (r18.equals(r15) == true) goto L7;
    L19:
        r17.put(r16, r15);     // Catch: Exception -> L60
    L21:
        if (Logger.debug() == true) goto L23;
    L27:
        if (r13 != null) goto L29;
        r13 = a().edit();     // Catch: Exception -> L60
    L29:
        if (r15 != null) goto L32;
        r13.remove(r16);     // Catch: Exception -> L60
        i r19 = null;
    L46:
        if (r19 == null) goto L7;
        r5.add(r19);     // Catch: Exception -> L60
        goto L7
    L32:
        if ((r15 instanceof String) == false) goto L35;
        r13.putString(r16, (String) r15);     // Catch: Exception -> L60
        r19 = new i(this, 16, r16, "string");     // Catch: Exception -> L60
        goto L46
    L35:
        if ((r15 instanceof Boolean) == false) goto L38;
        r13.putBoolean(r16, ((Boolean) r15).booleanValue());     // Catch: Exception -> L60
        r19 = new i(this, 16, r16, "boolean");     // Catch: Exception -> L60
        goto L46
    L38:
        if ((r15 instanceof Long) == false) goto L41;
        r13.putLong(r16, ((Long) r15).longValue());     // Catch: Exception -> L60
        r19 = new i(this, 16, r16, "long");     // Catch: Exception -> L60
        goto L46
    L41:
        if ((r15 instanceof Integer) == false) goto L44;
        r13.putInt(r16, ((Integer) r15).intValue());     // Catch: Exception -> L60
        r19 = new i(this, 16, r16, "integer");     // Catch: Exception -> L60
        goto L46
    L44:
        if ((r15 instanceof Float) == false) goto L49;
        r13.putFloat(r16, ((Float) r15).floatValue());     // Catch: Exception -> L60
        r19 = new i(this, 16, r16, "float");     // Catch: Exception -> L60
        goto L46
    L49:
        throw new IllegalArgumentException("Unsupported type " + r10);     // Catch: Exception -> L60
    L23:
        if (("MultiProcessShareProvider reallly insert key = " + r16 + " value = " + r15) == null) goto L25;
        String r20 = r15.toString();     // Catch: Exception -> L60
    L26:
        Logger.v("PushService", r20);     // Catch: Exception -> L60
        goto L27
    L25:
        r20 = "null";
        goto L26
    L14:
        r17.remove(r16);     // Catch: Exception -> L60
        goto L21
    L50:
        if (r13 != null) goto L52;
        return null;
    L52:
        r13.apply();     // Catch: Exception -> L60
        Iterator r21 = r5.iterator();     // Catch: Exception -> L60
    L54:
        if (r21.hasNext() == false) goto L57;
        ((Runnable) r21.next()).run();     // Catch: Exception -> L60
    L57:
        return null;
    L59:
        throw new IllegalArgumentException(j0.i(r10, "Unsupported uri "));
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r5 = getContext();
        String r10 = t8.a.a(r5);
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L9;
    L11:
        Context r11 = getContext();
        ConcurrentHashMap r12 = e.f17066a;
        Application r13 = (Application) r11.getApplicationContext();
        c r14 = new c();
        r14.f17062a = new k(r13, 8);
        r13.registerActivityLifecycleCallbacks(r14);
        if (f == null) goto L23;
    L22:
        return true;
    L23:
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L14:
        if (Logger.debug() == false) goto L18;
        Logger.v("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L16
    L18:
        c(getContext());     // Catch: Exception -> L16
        goto L22
    L9:
        if (r10.equals(r5.getPackageName()) == false) goto L11;
        g = true;
        goto L11
    L5:
        if (r10.contains(":") == false) goto L7;
        goto L7
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r5, String[] r10, String r11, String[] r12, String r13) {
        if (f.match(r5) != 65536) goto L48;
        MatrixCursor r14 = null;
        if ("all".equals(r5.getPathSegments().get(1)) == false) goto L31;
        Map<String, ?> r15 = a().getAll();     // Catch: Exception -> L49
        MatrixCursor r16 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L49
        Iterator<Map.Entry<String, ?>> r17 = r15.entrySet().iterator();     // Catch: Exception -> L30
    L9:
        if (r17.hasNext() == false) goto L29;
        Map.Entry<String, ?> r18 = r17.next();     // Catch: Exception -> L30
        String r19 = r18.getKey();     // Catch: Exception -> L30
        Object r20 = r18.getValue();     // Catch: Exception -> L30
        MatrixCursor.RowBuilder r21 = r16.newRow();     // Catch: Exception -> L30
        String r22 = "string";
        if ((r20 instanceof String) == true) goto L27;
        if ((r20 instanceof Boolean) == false) goto L19;
        r22 = "boolean";
        r20 = Integer.valueOf(((Boolean) r20).booleanValue() ? 1 : 0);     // Catch: Exception -> L30
        goto L27
    L19:
        if ((r20 instanceof Integer) == false) goto L22;
        r22 = "integer";
        goto L27
    L22:
        if ((r20 instanceof Long) == false) goto L25;
        r22 = "long";
        goto L27
    L25:
        if ((r20 instanceof Float) == false) goto L27;
        r22 = "float";
    L27:
        r21.add(r19);     // Catch: Exception -> L30
        r21.add(r20);     // Catch: Exception -> L30
        r21.add(r22);     // Catch: Exception -> L30
        goto L9
    L29:
        return r16;
    L30:
        r14 = r16;
    L52:
        goto L46
    L31:
        String r23 = r5.getPathSegments().get(0);     // Catch: Exception -> L49
        d();     // Catch: Exception -> L49
        ConcurrentHashMap r24 = this.f3972b;
        if (r24.containsKey(r23) == true) goto L36;
        return null;
    L36:
        MatrixCursor r25 = new MatrixCursor(new String[]{r23});     // Catch: Exception -> L49
        Object r26 = r24.get(r23);     // Catch: Exception -> L45
        MatrixCursor.RowBuilder r27 = r25.newRow();     // Catch: Exception -> L45
        if ((r26 instanceof Boolean) == false) goto L41;
        r26 = Integer.valueOf(((Boolean) r26).booleanValue() ? 1 : 0);     // Catch: Exception -> L45
    L41:
        if (Logger.debug() == false) goto L43;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r23 + " value = " + r26.toString());     // Catch: Exception -> L45
    L43:
        r27.add(r26);     // Catch: Exception -> L45
        return r25;
    L45:
        r14 = r25;
    L46:
        return r14;
    L48:
        throw new IllegalArgumentException(j0.i(r5, "Unsupported uri "));
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r5, ContentValues r10, String r11, String[] r12) {
        throw new UnsupportedOperationException();
    }
}
