package com.bytedance.common.wschannel;

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
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessSharedProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Uri f1994b = null;
    private static UriMatcher c = null;
    private static boolean f = false;
    private static volatile boolean g = false;
    private static b i;
    private SharedPreferences d;
    private Map<String, Object> e;
    private final Object h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f1997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ContentValues f1998b;

        private a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.f1998b = new ContentValues();
            this.f1997a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        /* synthetic */ a(Context r2, AnonymousClass1 r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        }

        public a a(String r2, String r3) {
            this.f1998b.put(r2, r3);
            return this;
        }

        public a a(String r2, boolean r3) {
            this.f1998b.put(r2, Boolean.valueOf(r3));
            return this;
        }

        public synchronized void a() {
            monitor-enter(this);
            ZeusProviderTransform.insert(this.f1997a.getContentResolver(), WsChannelMultiProcessSharedProvider.a(this.f1997a, "key", "type"), this.f1998b, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
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
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f1999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2000b;
        private SharedPreferences c;

        private b(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            boolean r0 = false;
            this.f2000b = false;
            if (com.bytedance.common.wschannel.c.c.a(r5) == true) goto L5;
        L7:
            this.f2000b = r0;
            Context r6 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.f1999a = r6;
            this.c = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("wschannel_multi_process_config", 4);
            if (Logger.debug() == false) goto L11;
            Logger.v("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (WsChannelMultiProcessSharedProvider.a() == false) goto L7;
            r0 = true;
            goto L7
        }

        /* synthetic */ b(Context r2, AnonymousClass1 r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        }

        public long a(String r9, long r10) {
        L8:
            return r10;
        L3:
            if (this.f2000b == false) goto L7;
            return this.c.getLong(r9, r10);
        L7:
            return WsChannelMultiProcessSharedProvider.a(ZeusProviderTransform.query(this.f1999a.getContentResolver(), WsChannelMultiProcessSharedProvider.a(this.f1999a, r9, "long"), null, null, null, null, "com.obric.memorydata.plugin"), r10);
        }

        public a a() {
            return new a(this.f1999a, null);
        }

        public String a(String r9, String r10) {
        L8:
            return r10;
        L3:
            if (this.f2000b == false) goto L7;
            return this.c.getString(r9, r10);
        L7:
            return WsChannelMultiProcessSharedProvider.a(ZeusProviderTransform.query(this.f1999a.getContentResolver(), WsChannelMultiProcessSharedProvider.a(this.f1999a, r9, TypedValues.Custom.S_STRING), null, null, null, null, "com.obric.memorydata.plugin"), r10);
        }

        public boolean a(String r9, boolean r10) {
        L8:
            return r10;
        L3:
            if (this.f2000b == false) goto L7;
            return this.c.getBoolean(r9, r10);
        L7:
            return WsChannelMultiProcessSharedProvider.a(ZeusProviderTransform.query(this.f1999a.getContentResolver(), WsChannelMultiProcessSharedProvider.a(this.f1999a, r9, TypedValues.Custom.S_BOOLEAN), null, null, null, null, "com.obric.memorydata.plugin"), r10);
        }
    }

    static {
    }

    public WsChannelMultiProcessSharedProvider() {
        this.e = new ConcurrentHashMap();
        this.h = new Object();
    }

    static /* synthetic */ long a(Cursor r2, long r3) {
        return b((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final synchronized Uri a(Context r3, String r4, String r5) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (f1994b == null) goto L23;
    L16:
        Uri r7 = f1994b.buildUpon().appendPath(r4).appendPath(r5).build();     // Catch: Throwable -> L19
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r7;
    L23:
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        return null;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d("MultiProcessSharedProvider", "init form getContentUri");     // Catch: Exception -> L11 Throwable -> L19
    L9:
        b(r6);     // Catch: Exception -> L11 Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static synchronized b a(Context r3) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (i != null) goto L7;
        i = new b(r4, null);     // Catch: Throwable -> L10
    L7:
        b r5 = i;     // Catch: Throwable -> L10
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private Runnable a(final String r2, final String r3) {
        return new AnonymousClass1(this, r2, r3);
    }

    public static String a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L14:
        return null;
    L5:
        if (com.bytedance.common.utility.h.a(r6) == true) goto L14;
        ProviderInfo[] r8 = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r1 = r8.length;     // Catch: Exception -> L15
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        ProviderInfo r3 = r8[r2];     // Catch: Exception -> L15
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    }

    static /* synthetic */ String a(Cursor r2, String r3) {
        return b((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin"), r3);
    }

    private void a(Uri r3) {
        ZeusProviderTransform.notifyChange(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r3, null, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ void a(WsChannelMultiProcessSharedProvider r0, Uri r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a() {
        return f;
    }

    static /* synthetic */ boolean a(Cursor r2, boolean r3) {
        return b((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin"), r3);
    }

    private static long b(Cursor r2, long r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L15;
        return r3;
    L15:
    L11:
        if (r4 != null) goto L17;
    L13:
        return r3;
    L17:
        r4.close();     // Catch: Exception -> L14
        goto L13
    L6:
        if (r4.moveToFirst() == false) goto L8;
        r3 = r4.getLong(0);     // Catch: Throwable -> L11
    L8:
        if (r4 == null) goto L13;
        goto L13
    }

    private synchronized SharedPreferences b() {
        monitor-enter(this);
        SharedPreferences r0 = this.d;     // Catch: Throwable -> L14
        if (r0 != null) goto L12;
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 < 11) goto L8;
        int r3 = 4;
    L9:
        SharedPreferences r4 = r2.getSharedPreferences("wschannel_multi_process_config", r3);     // Catch: Throwable -> L14
        this.d = r4;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L8:
        r3 = 0;
        goto L9
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    private static String b(Cursor r2, String r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L15;
        return r3;
    L15:
    L11:
        if (r4 != null) goto L17;
    L13:
        return r3;
    L17:
        r4.close();     // Catch: Exception -> L14
        goto L13
    L6:
        if (r4.moveToFirst() == false) goto L8;
        r3 = r4.getString(0);     // Catch: Throwable -> L11
    L8:
        if (r4 == null) goto L13;
        goto L13
    }

    private static void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(f1993a) == false) goto L6;
        f1993a = a(r4, WsChannelMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f1993a) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", f1993a);
    L10:
        UriMatcher r5 = new UriMatcher(-1);
        c = r5;
        r5.addURI(f1993a, "*/*", 65536);
        f1994b = Uri.parse("content://" + f1993a);
        return;
    L13:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    private static boolean b(Cursor r2, boolean r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L18;
        return r3;
    L18:
    L14:
        if (r4 != null) goto L20;
    L16:
        return r3;
    L20:
        r4.close();     // Catch: Exception -> L17
        goto L16
    L6:
        if (r4.moveToFirst() == false) goto L11;
        if (r4.getInt(0) <= 0) goto L10;
        r3 = true;
        goto L11
    L10:
        r3 = false;
    L11:
        if (r4 == null) goto L16;
        goto L16
    }

    private void c() {
        if (g == true) goto L23;
        Object r0 = this.h;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (g == true) goto L18;
        SharedPreferences r1 = b();     // Catch: Throwable -> L20
        if (r1 != null) goto L13;
        g = true;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L13:
        Iterator<Map.Entry<String, ?>> r2 = r1.getAll().entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r2.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Object r5 = r3.getValue();     // Catch: Throwable -> L20
        this.e.put(r4, r5);     // Catch: Throwable -> L20
        goto L15
    L17:
        g = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    }

    public void attachInfo(Context r3, ProviderInfo r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        f1993a = r4.authority;
    L5:
        super.attachInfo(r5, r4);
    }

    public int delete(Uri r2, String r3, String[] r4) {
        if (c.match(r2) != 65536) goto L8;
        b().edit().clear().commit();     // Catch: Exception -> L9
        this.e.clear();     // Catch: Exception -> L9
        a(a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "key", "type"));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException("Unsupported uri " + r2);
    }

    public String getType(Uri r1) {
        return "vnd.android.cursor.item/vnd." + f1993a + ".item";
    }

    public Uri insert(Uri r12, ContentValues r13) {
        if (c.match(r12) != 65536) goto L67;
        c();     // Catch: Exception -> L68
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L68
        Iterator<Map.Entry<String, Object>> r14 = r13.valueSet().iterator();     // Catch: Exception -> L68
        SharedPreferences.Editor r2 = null;
    L8:
        if (r14.hasNext() == false) goto L54;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L68
        Object r5 = r3.getValue();     // Catch: Exception -> L68
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L68
        if (Logger.debug() == false) goto L13;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r4 + " value = " + r5.toString());     // Catch: Exception -> L68
    L13:
        boolean r6 = false;
        if (r5 != null) goto L17;
        this.e.remove(r4);     // Catch: Exception -> L68
    L16:
        r6 = true;
    L22:
        if (r6 == false) goto L8;
        if (Logger.debug() == true) goto L26;
    L30:
        if (r2 != null) goto L32;
        r2 = b().edit();     // Catch: Exception -> L68
    L32:
        if (r5 != null) goto L35;
        r2.remove(r4);     // Catch: Exception -> L68
        Runnable r7 = null;
    L50:
        if (r7 == null) goto L8;
        r1.add(r7);     // Catch: Exception -> L68
        goto L8
    L35:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L39;
        r2.putString(r4, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L68
        String r8 = TypedValues.Custom.S_STRING;
    L37:
        r7 = a(r4, r8);     // Catch: Exception -> L68
        goto L50
    L39:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L42;
        r2.putBoolean(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());     // Catch: Exception -> L68
        r8 = TypedValues.Custom.S_BOOLEAN;
        goto L37
    L42:
        if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L45;
        r2.putLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Exception -> L68
        r8 = "long";
        goto L37
    L45:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L48;
        r2.putInt(r4, ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Exception -> L68
        r8 = TypedValues.Custom.S_INT;
        goto L37
    L48:
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L53;
        r2.putFloat(r4, ((Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.memorydata.plugin")).floatValue());     // Catch: Exception -> L68
        r8 = TypedValues.Custom.S_FLOAT;
        goto L37
    L53:
        throw new IllegalArgumentException("Unsupported type " + r12);     // Catch: Exception -> L68
    L26:
        if (("MultiProcessShareProvider reallly insert key = " + r4 + " value = " + r5) == null) goto L28;
        String r9 = r5.toString();     // Catch: Exception -> L68
    L29:
        Logger.v("PushService", r9);     // Catch: Exception -> L68
        goto L30
    L28:
        r9 = "null";
        goto L29
    L17:
        Object r10 = this.e.get(r4);     // Catch: Exception -> L68
        if (r10 != null) goto L20;
    L21:
        this.e.put(r4, r5);     // Catch: Exception -> L68
        goto L16
    L20:
        if (r10.equals(r5) == true) goto L22;
    L54:
        if (r2 != null) goto L57;
        return null;
    L57:
        if (Build.VERSION.SDK_INT <= 8) goto L59;
        r2.apply();     // Catch: Exception -> L68
    L60:
        Iterator r11 = r1.iterator();     // Catch: Exception -> L68
    L62:
        if (r11.hasNext() == false) goto L65;
        ((Runnable) ZeusTransformUtils.preCheckCast(r11.next(), Runnable.class, "com.obric.memorydata.plugin")).run();     // Catch: Exception -> L68
        goto L62
    L59:
        r2.commit();     // Catch: Exception -> L68
    L65:
        return null;
    L67:
        throw new IllegalArgumentException("Unsupported uri " + r12);
    }

    public boolean onCreate() {
        if (com.bytedance.common.wschannel.c.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
        f = true;
    L5:
        k.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (c == null) goto L16;
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
        b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L12
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public Cursor query(Uri r5, String[] r6, String r7, String[] r8, String r9) {
        if (c.match(r5) != 65536) goto L54;
        ?? r10 = 0;
        int r11 = 1;
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL.equals((String) ZeusTransformUtils.preCheckCast(r5.getPathSegments().get(1), String.class, "com.obric.memorydata.plugin")) == false) goto L34;
        Map<String, ?> r4 = b().getAll();     // Catch: Exception -> L55
        MatrixCursor r12 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L55
        Iterator<Map.Entry<String, ?>> r13 = r4.entrySet().iterator();     // Catch: Exception -> L33
    L9:
        boolean r14 = r13.hasNext();     // Catch: Exception -> L33
        r10 = r14;
        if (r14 == false) goto L60;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L33
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L33
        Object r17 = r15.getValue();     // Catch: Exception -> L33
        MatrixCursor.RowBuilder r1 = r12.newRow();     // Catch: Exception -> L33
        boolean r2 = ZeusTransformUtils.instanceOf(r17, String.class);     // Catch: Exception -> L33
        String r3 = TypedValues.Custom.S_STRING;
        if (r2 == true) goto L31;
        if (ZeusTransformUtils.instanceOf(r17, Boolean.class) == false) goto L23;
        r3 = TypedValues.Custom.S_BOOLEAN;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L20;
        int r18 = 1;
    L21:
        r17 = Integer.valueOf(r18);     // Catch: Exception -> L33
        goto L31
    L20:
        r18 = 0;
        goto L21
    L23:
        if (ZeusTransformUtils.instanceOf(r17, Integer.class) == false) goto L26;
        r3 = TypedValues.Custom.S_INT;
        goto L31
    L26:
        if (ZeusTransformUtils.instanceOf(r17, Long.class) == false) goto L29;
        r3 = "long";
        goto L31
    L29:
        if (ZeusTransformUtils.instanceOf(r17, Float.class) == false) goto L31;
        r3 = TypedValues.Custom.S_FLOAT;
    L31:
        r1.add(r16);     // Catch: Exception -> L33
        r1.add(r17);     // Catch: Exception -> L33
        r1.add(r3);     // Catch: Exception -> L33
    L60:
        return r12;
    L33:
        r10 = r12;
        goto L69
    L34:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r5.getPathSegments().get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        c();     // Catch: Exception -> L55
        if (this.e.containsKey(r19) == true) goto L37;
        return null;
    L37:
        MatrixCursor r20 = new MatrixCursor(new String[]{r19});     // Catch: Exception -> L55
        Object r21 = this.e.get(r19);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r22 = r20.newRow();     // Catch: Exception -> L50
        if (ZeusTransformUtils.instanceOf(r21, Boolean.class) == false) goto L46;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r21, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L44;
        r11 = 0;
    L44:
        r21 = Integer.valueOf(r11);     // Catch: Exception -> L50
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r19 + " value = " + r21.toString());     // Catch: Exception -> L50
    L48:
        r22.add(r21);     // Catch: Exception -> L50
        r12 = r20;
        r10 = r22;
    L50:
        r10 = r20;
    L69:
        return r10;
    L54:
        throw new IllegalArgumentException("Unsupported uri " + r5);
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }
}
