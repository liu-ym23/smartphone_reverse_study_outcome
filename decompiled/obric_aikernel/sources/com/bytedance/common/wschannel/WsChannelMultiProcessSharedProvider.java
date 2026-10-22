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
import android.os.Build;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f1275i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Uri f1276j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static UriMatcher f1277k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f1278l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f1279m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static c f1280n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f1281c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Object> f1282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f1283h;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f1284c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f1285g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ WsChannelMultiProcessSharedProvider f1286h;

        a(WsChannelMultiProcessSharedProvider r10, String r11, String r12) {
            this.f1286h = r10;
            this.f1284c = r11;
            this.f1285g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            WsChannelMultiProcessSharedProvider r10 = this.f1286h;
            WsChannelMultiProcessSharedProvider.a(r10, WsChannelMultiProcessSharedProvider.h(r10.getContext(), this.f1284c, this.f1285g));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f1287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ContentValues f1288b;

        private b(Context r10) {
            this.f1288b = new ContentValues();
            this.f1287a = r10.getApplicationContext();
        }

        /* synthetic */ b(Context r10, a r11) {
            this(r10);
        }

        public synchronized void a() {
            monitor-enter(this);
            this.f1287a.getContentResolver().insert(WsChannelMultiProcessSharedProvider.h(this.f1287a, "key", WsConstants.KEY_CONNECTION_TYPE), this.f1288b);     // Catch: Throwable -> L6
        L4:
            monitor-exit(this);
        }

        public synchronized void b() {
            monitor-enter(this);
            a();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public b c(String r10, boolean r11) {
            this.f1288b.put(r10, Boolean.valueOf(r11));
            return this;
        }

        public b d(String r10, String r11) {
            this.f1288b.put(r10, r11);
            return this;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f1289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SharedPreferences f1291c;

        private c(Context r10) {
            boolean r11 = false;
            this.f1290b = false;
            if (g2.c.i(r10) == true) goto L5;
        L7:
            this.f1290b = r11;
            Context r12 = r10.getApplicationContext();
            this.f1289a = r12;
            this.f1291c = r12.getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);
            if (Logger.debug() == false) goto L11;
            Logger.v("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (WsChannelMultiProcessSharedProvider.b() == false) goto L7;
            r11 = true;
            goto L7
        }

        /* synthetic */ c(Context r10, a r11) {
            this(r10);
        }

        public b a() {
            return new b(this.f1289a, null);
        }

        public boolean b(String r10, boolean r11) {
        L8:
            return r11;
        L3:
            if (this.f1290b == false) goto L7;
            return this.f1291c.getBoolean(r10, r11);
        L7:
            return WsChannelMultiProcessSharedProvider.e(this.f1289a.getContentResolver().query(WsChannelMultiProcessSharedProvider.h(this.f1289a, r10, TypedValues.Custom.S_BOOLEAN), null, null, null, null), r11);
        }

        public long c(String r10, long r11) {
        L8:
            return r11;
        L3:
            if (this.f1290b == false) goto L7;
            return this.f1291c.getLong(r10, r11);
        L7:
            return WsChannelMultiProcessSharedProvider.d(this.f1289a.getContentResolver().query(WsChannelMultiProcessSharedProvider.h(this.f1289a, r10, "long"), null, null, null, null), r11);
        }

        public String d(String r10, String r11) {
        L8:
            return r11;
        L3:
            if (this.f1290b == false) goto L7;
            return this.f1291c.getString(r10, r11);
        L7:
            return WsChannelMultiProcessSharedProvider.c(this.f1289a.getContentResolver().query(WsChannelMultiProcessSharedProvider.h(this.f1289a, r10, TypedValues.Custom.S_STRING), null, null, null, null), r11);
        }
    }

    static {
    }

    public WsChannelMultiProcessSharedProvider() {
        this.f1282g = new ConcurrentHashMap();
        this.f1283h = new Object();
    }

    static /* synthetic */ void a(WsChannelMultiProcessSharedProvider r10, Uri r11) {
        r10.p(r11);
    }

    static /* synthetic */ boolean b() {
        return f1278l;
    }

    static /* synthetic */ String c(Cursor r10, String r11) {
        return m(r10, r11);
    }

    static /* synthetic */ long d(Cursor r10, long r11) {
        return i(r10, r11);
    }

    static /* synthetic */ boolean e(Cursor r10, boolean r11) {
        return g(r10, r11);
    }

    private Runnable f(String r10, String r11) {
        return new a(this, r10, r11);
    }

    private static boolean g(Cursor r10, boolean r11) {
        if (r10 != null) goto L14;
        return r11;
    L14:
        if (r10.moveToFirst() == false) goto L16;
        if (r10.getInt(0) <= 0) goto L9;
        r11 = true;
        goto L16
    L9:
        r11 = false;
    L16:
        r10.close();     // Catch: Exception -> L13
    L11:
        return r11;
    }

    public static final synchronized Uri h(Context r10, String r11, String r12) {
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
            android.net.Uri r1 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.f1276j     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L1f
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
        L14:
            n(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            goto L1f
        L18:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L33
            r3 = 0
            monitor-exit(r0)
            return r3
        L1f:
            android.net.Uri r3 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.f1276j     // Catch: java.lang.Throwable -> L33
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.h(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    private static long i(Cursor r10, long r11) {
        if (r10 != null) goto L11;
        return r11;
    L11:
        if (r10.moveToFirst() == false) goto L13;
        r11 = r10.getLong(0);     // Catch: Throwable -> L9
    L13:
        r10.close();     // Catch: Exception -> L10
    L8:
        return r11;
    }

    private synchronized SharedPreferences j() {
        monitor-enter(this);
        SharedPreferences r10 = this.f1281c;     // Catch: Throwable -> L14
        if (r10 != null) goto L12;
        int r11 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        Context r12 = getContext().getApplicationContext();     // Catch: Throwable -> L14
        if (r11 < 11) goto L8;
        int r13 = 4;
    L9:
        SharedPreferences r14 = r12.getSharedPreferences("wschannel_multi_process_config", r13);     // Catch: Throwable -> L14
        this.f1281c = r14;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r14;
    L8:
        r13 = 0;
        goto L9
    L12:
        monitor-exit(this);
        return r10;
    L14:
        th = move-exception;
        throw th;
    }

    public static synchronized c k(Context r10) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f1280n != null) goto L7;
        f1280n = new c(r10, null);     // Catch: Throwable -> L10
    L7:
        c r11 = f1280n;     // Catch: Throwable -> L10
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r11;
    }

    public static String l(Context r10, String r11) {
        if (r10 != null) goto L5;
    L14:
        return null;
    L5:
        if (com.bytedance.common.utility.g.b(r11) == true) goto L14;
        ProviderInfo[] r12 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r13 = r12.length;     // Catch: Exception -> L15
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L14;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L15
        if (r11.equals(r15.name) == true) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        return r15.authority;
    }

    private static String m(Cursor r10, String r11) {
        if (r10 != null) goto L11;
        return r11;
    L11:
        if (r10.moveToFirst() == false) goto L13;
        r11 = r10.getString(0);     // Catch: Throwable -> L9
    L13:
        r10.close();     // Catch: Exception -> L10
    L8:
        return r11;
    }

    private static void n(Context r10) {
        if (TextUtils.isEmpty(f1275i) == false) goto L6;
        f1275i = l(r10, WsChannelMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f1275i) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", f1275i);
    L10:
        UriMatcher r11 = new UriMatcher(-1);
        f1277k = r11;
        r11.addURI(f1275i, "*/*", 65536);
        f1276j = Uri.parse("content://" + f1275i);
        return;
    L13:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    private void o() {
        if (f1279m == true) goto L23;
        Object r10 = this.f1283h;
        monitor-enter(r10);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f1279m == true) goto L18;
        SharedPreferences r11 = j();     // Catch: Throwable -> L20
        if (r11 != null) goto L13;
        f1279m = true;     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L13:
        Iterator<Map.Entry<String, ?>> r12 = r11.getAll().entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r12.hasNext() == false) goto L17;
        Map.Entry<String, ?> r13 = r12.next();     // Catch: Throwable -> L20
        String r14 = r13.getKey();     // Catch: Throwable -> L20
        Object r15 = r13.getValue();     // Catch: Throwable -> L20
        this.f1282g.put(r14, r15);     // Catch: Throwable -> L20
        goto L15
    L17:
        f1279m = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    }

    private void p(Uri r10) {
        getContext().getContentResolver().notifyChange(r10, null);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r10, ProviderInfo r11) {
        if (r11 == null) goto L4;
        f1275i = r11.authority;
    L4:
        super.attachInfo(r10, r11);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        if (f1277k.match(r10) != 65536) goto L8;
        j().edit().clear().commit();     // Catch: Exception -> L9
        this.f1282g.clear();     // Catch: Exception -> L9
        p(h(getContext(), "key", WsConstants.KEY_CONNECTION_TYPE));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return "vnd.android.cursor.item/vnd." + f1275i + ".item";
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"NewApi"})
    public Uri insert(Uri r11, ContentValues r12) {
        if (f1277k.match(r11) != 65536) goto L66;
        o();     // Catch: Exception -> L67
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L67
        Iterator<Map.Entry<String, Object>> r13 = r12.valueSet().iterator();     // Catch: Exception -> L67
        SharedPreferences.Editor r14 = null;
    L7:
        if (r13.hasNext() == false) goto L53;
        Map.Entry<String, Object> r15 = r13.next();     // Catch: Exception -> L67
        Object r16 = r15.getValue();     // Catch: Exception -> L67
        String r17 = r15.getKey();     // Catch: Exception -> L67
        if (Logger.debug() == false) goto L12;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r17 + " value = " + r16.toString());     // Catch: Exception -> L67
    L12:
        boolean r18 = false;
        if (r16 != null) goto L16;
        this.f1282g.remove(r17);     // Catch: Exception -> L67
    L15:
        r18 = true;
    L21:
        if (r18 == false) goto L7;
        if (Logger.debug() == true) goto L25;
    L29:
        if (r14 != null) goto L31;
        r14 = j().edit();     // Catch: Exception -> L67
    L31:
        if (r16 != null) goto L34;
        r14.remove(r17);     // Catch: Exception -> L67
        Runnable r19 = null;
    L49:
        if (r19 == null) goto L7;
        r10.add(r19);     // Catch: Exception -> L67
        goto L7
    L34:
        if ((r16 instanceof String) == false) goto L38;
        r14.putString(r17, (String) r16);     // Catch: Exception -> L67
        String r20 = TypedValues.Custom.S_STRING;
    L36:
        r19 = f(r17, r20);     // Catch: Exception -> L67
        goto L49
    L38:
        if ((r16 instanceof Boolean) == false) goto L41;
        r14.putBoolean(r17, ((Boolean) r16).booleanValue());     // Catch: Exception -> L67
        r20 = TypedValues.Custom.S_BOOLEAN;
        goto L36
    L41:
        if ((r16 instanceof Long) == false) goto L44;
        r14.putLong(r17, ((Long) r16).longValue());     // Catch: Exception -> L67
        r20 = "long";
        goto L36
    L44:
        if ((r16 instanceof Integer) == false) goto L47;
        r14.putInt(r17, ((Integer) r16).intValue());     // Catch: Exception -> L67
        r20 = TypedValues.Custom.S_INT;
        goto L36
    L47:
        if ((r16 instanceof Float) == false) goto L52;
        r14.putFloat(r17, ((Float) r16).floatValue());     // Catch: Exception -> L67
        r20 = TypedValues.Custom.S_FLOAT;
        goto L36
    L52:
        throw new IllegalArgumentException("Unsupported type " + r11);     // Catch: Exception -> L67
    L25:
        if (("MultiProcessShareProvider reallly insert key = " + r17 + " value = " + r16) == null) goto L27;
        String r21 = r16.toString();     // Catch: Exception -> L67
    L28:
        Logger.v("PushService", r21);     // Catch: Exception -> L67
        goto L29
    L27:
        r21 = "null";
        goto L28
    L16:
        Object r22 = this.f1282g.get(r17);     // Catch: Exception -> L67
        if (r22 != null) goto L19;
    L20:
        this.f1282g.put(r17, r16);     // Catch: Exception -> L67
        goto L15
    L19:
        if (r22.equals(r16) == true) goto L21;
    L53:
        if (r14 != null) goto L56;
        return null;
    L56:
        if (Build.VERSION.SDK_INT <= 8) goto L58;
        r14.apply();     // Catch: Exception -> L67
    L59:
        Iterator r110 = r10.iterator();     // Catch: Exception -> L67
    L61:
        if (r110.hasNext() == false) goto L64;
        ((Runnable) r110.next()).run();     // Catch: Exception -> L67
        goto L61
    L58:
        r14.commit();     // Catch: Exception -> L67
    L64:
        return null;
    L66:
        throw new IllegalArgumentException("Unsupported uri " + r11);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (g2.c.i(getContext()) == false) goto L5;
        f1278l = true;
    L5:
        k.e(getContext());
        if (f1277k == null) goto L16;
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
        n(getContext());     // Catch: Exception -> L12
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        if (f1277k.match(r10) != 65536) goto L54;
        ?? r15 = 0;
        int r16 = 1;
        if ("all".equals(r10.getPathSegments().get(1)) == false) goto L34;
        Map<String, ?> r17 = j().getAll();     // Catch: Exception -> L55
        MatrixCursor r18 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L55
        Iterator<Map.Entry<String, ?>> r19 = r17.entrySet().iterator();     // Catch: Exception -> L33
    L9:
        boolean r20 = r19.hasNext();     // Catch: Exception -> L33
        r15 = r20;
        if (r20 == false) goto L56;
        Map.Entry<String, ?> r21 = r19.next();     // Catch: Exception -> L33
        String r22 = r21.getKey();     // Catch: Exception -> L33
        Object r23 = r21.getValue();     // Catch: Exception -> L33
        MatrixCursor.RowBuilder r24 = r18.newRow();     // Catch: Exception -> L33
        boolean r25 = r23 instanceof String;     // Catch: Exception -> L33
        String r26 = TypedValues.Custom.S_STRING;
        if (r25 == true) goto L31;
        if ((r23 instanceof Boolean) == false) goto L23;
        r26 = TypedValues.Custom.S_BOOLEAN;
        if (((Boolean) r23).booleanValue() == false) goto L20;
        int r27 = 1;
    L21:
        r23 = Integer.valueOf(r27);     // Catch: Exception -> L33
        goto L31
    L20:
        r27 = 0;
        goto L21
    L23:
        if ((r23 instanceof Integer) == false) goto L26;
        r26 = TypedValues.Custom.S_INT;
        goto L31
    L26:
        if ((r23 instanceof Long) == false) goto L29;
        r26 = "long";
        goto L31
    L29:
        if ((r23 instanceof Float) == false) goto L31;
        r26 = TypedValues.Custom.S_FLOAT;
    L31:
        r24.add(r22);     // Catch: Exception -> L33
        r24.add(r23);     // Catch: Exception -> L33
        r24.add(r26);     // Catch: Exception -> L33
    L56:
        return r18;
    L33:
        r15 = r18;
        goto L69
    L34:
        String r28 = r10.getPathSegments().get(0);     // Catch: Exception -> L55
        o();     // Catch: Exception -> L55
        if (this.f1282g.containsKey(r28) == true) goto L37;
        return null;
    L37:
        MatrixCursor r29 = new MatrixCursor(new String[]{r28});     // Catch: Exception -> L55
        Object r30 = this.f1282g.get(r28);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r31 = r29.newRow();     // Catch: Exception -> L50
        if ((r30 instanceof Boolean) == false) goto L46;
        if (((Boolean) r30).booleanValue() == true) goto L44;
        r16 = 0;
    L44:
        r30 = Integer.valueOf(r16);     // Catch: Exception -> L50
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r28 + " value = " + r30.toString());     // Catch: Exception -> L50
    L48:
        r31.add(r30);     // Catch: Exception -> L50
        r18 = r29;
        r15 = r31;
    L50:
        r15 = r29;
    L69:
        return r15;
    L54:
        throw new IllegalArgumentException("Unsupported uri " + r10);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        throw new UnsupportedOperationException();
    }
}
