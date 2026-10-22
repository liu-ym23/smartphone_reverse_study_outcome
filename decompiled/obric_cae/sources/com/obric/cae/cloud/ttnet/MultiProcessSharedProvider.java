package com.obric.cae.cloud.ttnet;

import android.aimedia.a;
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
import defpackage.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r5.f;

/* JADX INFO: loaded from: classes.dex */
public class MultiProcessSharedProvider extends ContentProvider {
    public static final String ALL_TYPE = "all";
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    private static final String KEY = "key";
    private static final String KEY_COLUMN = "key_column";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 65536;
    private static final String SP_CONFIG_NAME = "multi_process_config";
    public static final String STRING_TYPE = "string";
    private static final String TYPE = "type";
    private static final String TYPE_COLUMN = "type_column";
    private static final String VALUE_COLUMN = "value_column";
    public static Uri sBaseUri;
    private static MultiProcessShared sInstance;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;
    private Map<String, Object> mContentValues;
    private SharedPreferences mSharedPreferences;

    /* JADX INFO: renamed from: com.obric.cae.cloud.ttnet.MultiProcessSharedProvider$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Editor {
        Context mContext;
        private ContentValues mValues;

        private Editor(Context r8) {
            this.mValues = new ContentValues();
            this.mContext = r8.getApplicationContext();
        }

        public synchronized void apply() {
            monitor-enter(this);
            this.mContext.getContentResolver().insert(MultiProcessSharedProvider.getContentUri(this.mContext, MultiProcessSharedProvider.KEY, "type"), this.mValues);     // Catch: Throwable -> L6
        L4:
            monitor-exit(this);
        }

        public void clear() {
            this.mContext.getContentResolver().delete(MultiProcessSharedProvider.getContentUri(this.mContext, MultiProcessSharedProvider.KEY, "type"), null, null);     // Catch: Throwable -> L4
            return;
        }

        public synchronized void commit() {
            monitor-enter(this);
            apply();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public Editor putBoolean(String r8, boolean r10) {
            this.mValues.put(r8, Boolean.valueOf(r10));
            return this;
        }

        public Editor putFloat(String r8, float r10) {
            this.mValues.put(r8, Float.valueOf(r10));
            return this;
        }

        public Editor putInt(String r8, int r10) {
            this.mValues.put(r8, Integer.valueOf(r10));
            return this;
        }

        public Editor putLong(String r8, long r10) {
            this.mValues.put(r8, Long.valueOf(r10));
            return this;
        }

        public Editor putString(String r8, String r10) {
            this.mValues.put(r8, r10);
            return this;
        }

        public void remove(String r8) {
            this.mValues.putNull(r8);
        }

        public /* synthetic */ Editor(Context r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static class MultiProcessShared {
        private Context mContext;

        private MultiProcessShared(Context r8) {
            this.mContext = r8.getApplicationContext();
            if (Logger.debug() == false) goto L6;
            Logger.d("PushService", "MultiProcessShared create");
            return;
        }

        public Editor edit() {
            return new Editor(this.mContext, null);
        }

        public boolean getBoolean(String r8, boolean r10) {
            return MultiProcessSharedProvider.access$500(this.mContext.getContentResolver().query(MultiProcessSharedProvider.getContentUri(this.mContext, r8, "boolean"), null, null, null, null), r10);
        L4:
            return r10;
        }

        public float getFloat(String r8, float r10) {
            return MultiProcessSharedProvider.access$400(this.mContext.getContentResolver().query(MultiProcessSharedProvider.getContentUri(this.mContext, r8, "float"), null, null, null, null), r10);
        L4:
            return r10;
        }

        public int getInt(String r8, int r10) {
            return MultiProcessSharedProvider.access$600(this.mContext.getContentResolver().query(MultiProcessSharedProvider.getContentUri(this.mContext, r8, MultiProcessSharedProvider.INT_TYPE), null, null, null, null), r10);
        L4:
            return r10;
        }

        public long getLong(String r8, long r10) {
            return MultiProcessSharedProvider.access$300(this.mContext.getContentResolver().query(MultiProcessSharedProvider.getContentUri(this.mContext, r8, MultiProcessSharedProvider.LONG_TYPE), null, null, null, null), r10);
        L4:
            return r10;
        }

        public String getString(String r8, String r10) {
            return MultiProcessSharedProvider.access$200(this.mContext.getContentResolver().query(MultiProcessSharedProvider.getContentUri(this.mContext, r8, "string"), null, null, null, null), r10);
        L4:
            return r10;
        }

        public /* synthetic */ MultiProcessShared(Context r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public MultiProcessSharedProvider() {
        this.mContentValues = new ConcurrentHashMap();
    }

    public static /* synthetic */ String access$200(Cursor r8, String r10) {
        return getStringValue(r8, r10);
    }

    public static /* synthetic */ long access$300(Cursor r8, long r10) {
        return getLongValue(r8, r10);
    }

    public static /* synthetic */ float access$400(Cursor r8, float r10) {
        return getFloatValue(r8, r10);
    }

    public static /* synthetic */ boolean access$500(Cursor r8, boolean r10) {
        return getBooleanValue(r8, r10);
    }

    public static /* synthetic */ int access$600(Cursor r8, int r10) {
        return getIntValue(r8, r10);
    }

    public static Editor edit(Context r8) {
        return new Editor(r8, null);
    }

    private static boolean getBooleanValue(Cursor r8, boolean r10) {
        if (r8 != null) goto L14;
        return r10;
    L14:
        if (r8.moveToFirst() == false) goto L16;
        if (r8.getInt(0) <= 0) goto L9;
        r10 = true;
        goto L16
    L9:
        r10 = false;
    L16:
        r8.close();     // Catch: Exception -> L13
    L11:
        return r10;
    }

    public static final synchronized Uri getContentUri(Context r8, String r10, String r11) {
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
            java.lang.Class<com.obric.cae.cloud.ttnet.MultiProcessSharedProvider> r0 = com.obric.cae.cloud.ttnet.MultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.obric.cae.cloud.ttnet.MultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L1f
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
        L14:
            init(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            goto L1f
        L18:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            r3 = 0
            return r3
        L1f:
            android.net.Uri r3 = com.obric.cae.cloud.ttnet.MultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L33
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
        throw new UnsupportedOperationException("Method not decompiled: com.obric.cae.cloud.ttnet.MultiProcessSharedProvider.getContentUri(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    private static float getFloatValue(Cursor r8, float r10) {
        if (r8 != null) goto L11;
        return r10;
    L11:
        if (r8.moveToFirst() == false) goto L13;
        r10 = r8.getFloat(0);     // Catch: Throwable -> L9
    L13:
        r8.close();     // Catch: Exception -> L10
    L8:
        return r10;
    }

    private static int getIntValue(Cursor r8, int r10) {
        if (r8 != null) goto L11;
        return r10;
    L11:
        if (r8.moveToFirst() == false) goto L13;
        r10 = r8.getInt(0);     // Catch: Throwable -> L9
    L13:
        r8.close();     // Catch: Exception -> L10
    L8:
        return r10;
    }

    private static long getLongValue(Cursor r8, long r10) {
        if (r8 != null) goto L11;
        return r10;
    L11:
        if (r8.moveToFirst() == false) goto L13;
        r10 = r8.getLong(0);     // Catch: Throwable -> L9
    L13:
        r8.close();     // Catch: Exception -> L10
    L8:
        return r10;
    }

    private synchronized SharedPreferences getMultiProcessSharedPreferences() {
        monitor-enter(this);
        SharedPreferences r8 = this.mSharedPreferences;     // Catch: Throwable -> L10
        if (r8 != null) goto L8;
        SharedPreferences r10 = getContext().getApplicationContext().getSharedPreferences(SP_CONFIG_NAME, 4);     // Catch: Throwable -> L10
        this.mSharedPreferences = r10;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r10;
    L8:
        monitor-exit(this);
        return r8;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized MultiProcessShared getMultiprocessShared(Context r8) {
        monitor-enter(MultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new MultiProcessShared(r8, null);     // Catch: Throwable -> L10
    L7:
        MultiProcessShared r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(MultiProcessSharedProvider.class);
        return r10;
    }

    private static String getStringValue(Cursor r8, String r10) {
        if (r8 != null) goto L11;
        return r10;
    L11:
        if (r8.moveToFirst() == false) goto L13;
        r10 = r8.getString(0);     // Catch: Throwable -> L9
    L13:
        r8.close();     // Catch: Exception -> L10
    L8:
        return r10;
    }

    private static void init(Context r8) {
        String r10 = MultiProcessSharedProvider.class.getName();
        if (r8 != null) goto L5;
    L14:
        String r11 = null;
    L15:
        sShareAuthority = r11;
        if (TextUtils.isEmpty(r11) == true) goto L23;
        if (Logger.debug() == false) goto L20;
        Logger.d("MultiProcessSharedProvider", sShareAuthority);
    L20:
        UriMatcher r12 = new UriMatcher(-1);
        sMatcher = r12;
        r12.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
        return;
    L23:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    L5:
        if (f.b(r10) == true) goto L14;
        ProviderInfo[] r13 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 8).providers;     // Catch: Exception -> L24
        int r14 = r13.length;     // Catch: Exception -> L24
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L14;
        ProviderInfo r16 = r13[r15];     // Catch: Exception -> L24
        if (r10.equals(r16.name) == true) goto L11;
        r15 = r15 + 1;
        goto L8
    L11:
        r11 = r16.authority;     // Catch: Exception -> L24
        goto L15
    }

    private void loadValues() {
        SharedPreferences r8 = getMultiProcessSharedPreferences();
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ?>> r10 = r8.getAll().entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<String, ?> r11 = r10.next();
        String r12 = r11.getKey();
        Object r13 = r11.getValue();
        this.mContentValues.put(r12, r13);
        goto L7
    }

    private void notifyContentChanged(Uri r8) {
        getContext().getContentResolver().notifyChange(r8, null);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r8, String r10, String[] r11) {
        if (sMatcher.match(r8) != 65536) goto L8;
        getMultiProcessSharedPreferences().edit().clear().commit();     // Catch: Exception -> L9
        this.mContentValues.clear();     // Catch: Exception -> L9
        notifyContentChanged(getContentUri(getContext(), KEY, "type"));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException(b.b("Unsupported uri ", r8));
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r8) {
        return a.i(new StringBuilder("vnd.android.cursor.item/vnd."), sShareAuthority, ".item");
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"NewApi"})
    public Uri insert(Uri r10, ContentValues r11) {
        if (sMatcher.match(r10) != 65536) goto L57;
        Iterator<Map.Entry<String, Object>> r12 = r11.valueSet().iterator();     // Catch: Exception -> L58
        SharedPreferences.Editor r8 = null;
    L7:
        if (r12.hasNext() == false) goto L52;
        Map.Entry<String, Object> r13 = r12.next();     // Catch: Exception -> L58
        Object r14 = r13.getValue();     // Catch: Exception -> L58
        String r15 = r13.getKey();     // Catch: Exception -> L58
        if (Logger.debug() == false) goto L12;
        Logger.d("PushService", "MultiProcessShareProvider insert key = " + r15 + " value = " + r14.toString());     // Catch: Exception -> L58
    L12:
        boolean r16 = true;
        if (r14 != null) goto L15;
        this.mContentValues.remove(r15);     // Catch: Exception -> L58
    L22:
        if (r16 == false) goto L7;
        if (Logger.debug() == true) goto L26;
    L30:
        if (r8 != null) goto L32;
        r8 = getMultiProcessSharedPreferences().edit();     // Catch: Exception -> L58
    L32:
        if (r14 == null) goto L33;
        if ((r14 instanceof String) == false) goto L38;
        r8.putString(r15, (String) r14);     // Catch: Exception -> L58
        Context r17 = getContext();     // Catch: Exception -> L58
        String r18 = "string";
    L49:
        notifyContentChanged(getContentUri(r17, r15, r18));     // Catch: Exception -> L58
        goto L7
    L38:
        if ((r14 instanceof Boolean) == false) goto L41;
        r8.putBoolean(r15, ((Boolean) r14).booleanValue());     // Catch: Exception -> L58
        r17 = getContext();     // Catch: Exception -> L58
        r18 = "boolean";
        goto L49
    L41:
        if ((r14 instanceof Long) == false) goto L44;
        r8.putLong(r15, ((Long) r14).longValue());     // Catch: Exception -> L58
        r17 = getContext();     // Catch: Exception -> L58
        r18 = LONG_TYPE;
        goto L49
    L44:
        if ((r14 instanceof Integer) == false) goto L47;
        r8.putInt(r15, ((Integer) r14).intValue());     // Catch: Exception -> L58
        r17 = getContext();     // Catch: Exception -> L58
        r18 = INT_TYPE;
        goto L49
    L47:
        if ((r14 instanceof Float) == false) goto L51;
        r8.putFloat(r15, ((Float) r14).floatValue());     // Catch: Exception -> L58
        r17 = getContext();     // Catch: Exception -> L58
        r18 = "float";
        goto L49
    L51:
        throw new IllegalArgumentException("Unsupported type " + r10);     // Catch: Exception -> L58
    L33:
        r8.remove(r15);     // Catch: Exception -> L58
        goto L7
    L26:
        if (("MultiProcessShareProvider reallly insert key = " + r15 + " value = " + r14) == null) goto L28;
        String r19 = r14.toString();     // Catch: Exception -> L58
    L29:
        Logger.d("PushService", r19);     // Catch: Exception -> L58
        goto L30
    L28:
        r19 = "null";
        goto L29
    L15:
        Object r20 = this.mContentValues.get(r15);     // Catch: Exception -> L58
        if (r20 != null) goto L18;
    L21:
        this.mContentValues.put(r15, r14);     // Catch: Exception -> L58
        goto L22
    L18:
        if (r20.equals(r14) == false) goto L21;
        r16 = false;
        goto L22
    L52:
        if (r8 != null) goto L54;
        return null;
    L54:
        r8.apply();     // Catch: Exception -> L58
    L55:
        return null;
    L57:
        throw new IllegalArgumentException(b.b("Unsupported uri ", r10));
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (sMatcher == null) goto L14;
        return true;
    L14:
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L9
    L7:
        init(getContext());     // Catch: Exception -> L9
        loadValues();     // Catch: Exception -> L9
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r8, String[] r10, String r11, String[] r12, String r13) {
        if (sMatcher.match(r8) != 65536) goto L54;
        Object r14 = null;
        String r15 = null;
        int r16 = 1;
        if ("all".equals(r8.getPathSegments().get(1)) == false) goto L34;
        Map<String, ?> r17 = getMultiProcessSharedPreferences().getAll();     // Catch: Exception -> L55
        MatrixCursor r18 = new MatrixCursor(new String[]{KEY_COLUMN, VALUE_COLUMN, TYPE_COLUMN});     // Catch: Exception -> L55
        Iterator<Map.Entry<String, ?>> r19 = r17.entrySet().iterator();     // Catch: Exception -> L33
    L9:
        r14 = r15;
        if (r19.hasNext() == false) goto L56;
        Map.Entry<String, ?> r20 = r19.next();     // Catch: Exception -> L33
        String r21 = r20.getKey();     // Catch: Exception -> L33
        Object r22 = r20.getValue();     // Catch: Exception -> L33
        MatrixCursor.RowBuilder r23 = r18.newRow();     // Catch: Exception -> L33
        String r24 = "string";
        if ((r22 instanceof String) == true) goto L31;
        if ((r22 instanceof Boolean) == false) goto L23;
        r24 = "boolean";
        if (((Boolean) r22).booleanValue() == false) goto L20;
        int r25 = 1;
    L21:
        r22 = Integer.valueOf(r25);     // Catch: Exception -> L33
        goto L31
    L20:
        r25 = 0;
        goto L21
    L23:
        if ((r22 instanceof Integer) == false) goto L26;
        r24 = INT_TYPE;
        goto L31
    L26:
        if ((r22 instanceof Long) == false) goto L29;
        r24 = LONG_TYPE;
        goto L31
    L29:
        if ((r22 instanceof Float) == false) goto L31;
        r24 = "float";
    L31:
        r23.add(r21);     // Catch: Exception -> L33
        r23.add(r22);     // Catch: Exception -> L33
        r23.add(r24);     // Catch: Exception -> L33
        r15 = r21;
    L56:
        return r18;
    L33:
        r14 = r18;
        goto L69
    L34:
        String r26 = r8.getPathSegments().get(0);     // Catch: Exception -> L55
        if (this.mContentValues.containsKey(r26) == true) goto L37;
        return null;
    L37:
        MatrixCursor r27 = new MatrixCursor(new String[]{r26});     // Catch: Exception -> L55
        Object r28 = this.mContentValues.get(r26);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r29 = r27.newRow();     // Catch: Exception -> L50
        if ((r28 instanceof Boolean) == false) goto L46;
        if (((Boolean) r28).booleanValue() == true) goto L44;
        r16 = 0;
    L44:
        r28 = Integer.valueOf(r16);     // Catch: Exception -> L50
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.d("PushService", "MultiProcessShareProvider reallly get key = " + r26 + " value = " + r28.toString());     // Catch: Exception -> L50
    L48:
        r29.add(r28);     // Catch: Exception -> L50
        r18 = r27;
        r14 = r29;
    L50:
        r14 = r27;
    L69:
        return r14;
    L54:
        throw new IllegalArgumentException(b.b("Unsupported uri ", r8));
    }

    @Override // android.content.ContentProvider
    public int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        throw new UnsupportedOperationException();
    }
}
