package com.ss.android.token;

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
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AuthTokenMultiProcessSharedProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15713a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Uri f15714b = null;
    private static UriMatcher c = null;
    private static String h = "token_shared_preference";
    private SharedPreferences d;
    private Map<String, Object> e;
    private volatile boolean f;
    private final Object g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f15717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ContentValues f15718b;

        private a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.f15718b = new ContentValues();
            this.f15717a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        /* synthetic */ a(Context r2, AnonymousClass1 r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        }

        public a a(String r2, String r3) {
            this.f15718b.put(r2, r3);
            return this;
        }

        public a a(String r2, boolean r3) {
            this.f15718b.put(r2, Boolean.valueOf(r3));
            return this;
        }

        public synchronized void a() {
            monitor-enter(this);
            SharedPreferences.Editor r0 = AuthTokenMultiProcessSharedProvider.a(this.f15717a).edit();     // Catch: Throwable -> L26
            Iterator<Map.Entry<String, Object>> r1 = this.f15718b.valueSet().iterator();     // Catch: Throwable -> L26
        L5:
            if (r1.hasNext() == false) goto L24;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
            Object r3 = r2.getValue();     // Catch: Throwable -> L26
            String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
            com.ss.android.c.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply key = " + r4 + " value = " + e.a(r3));     // Catch: Throwable -> L26
            if (r3 == null) goto L8;
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L11;
            if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == true) goto L14;
            if (ZeusTransformUtils.instanceOf(r3, Long.class) == true) goto L17;
            if (ZeusTransformUtils.instanceOf(r3, Integer.class) == true) goto L20;
            if (ZeusTransformUtils.instanceOf(r3, Float.class) == false) goto L5;
            r0.putFloat(r4, ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.memorydata.plugin")).floatValue());     // Catch: Throwable -> L26
            goto L5
        L20:
            r0.putInt(r4, ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L26
            goto L5
        L17:
            r0.putLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L26
            goto L5
        L14:
            r0.putBoolean(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());     // Catch: Throwable -> L26
            goto L5
        L11:
            r0.putString(r4, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L26
            goto L5
        L8:
            r0.remove(r4);     // Catch: Throwable -> L26
            goto L5
        L24:
            r0.commit();     // Catch: Throwable -> L26
            ZeusProviderTransform.insert(this.f15717a.getContentResolver(), AuthTokenMultiProcessSharedProvider.a(this.f15717a, "key", "type"), this.f15718b, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        L28:
            monitor-exit(this);
            return;
        L26:
            th = move-exception;
            com.ss.android.c.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply error = " + Log.getStackTraceString(th));     // Catch: Throwable -> L30
            d.a(th);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f15719a;

        public a a() {
            return new a(this.f15719a, null);
        }
    }

    static {
    }

    public AuthTokenMultiProcessSharedProvider() {
        this.e = new ConcurrentHashMap();
        this.f = false;
        this.g = new Object();
    }

    private synchronized SharedPreferences a() {
        monitor-enter(this);
        SharedPreferences r0 = this.d;     // Catch: Throwable -> L14
        if (r0 != null) goto L12;
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        String r3 = h;     // Catch: Throwable -> L14
        if (r1 < 11) goto L8;
        int r4 = 4;
    L9:
        SharedPreferences r5 = r2.getSharedPreferences(r3, r4);     // Catch: Throwable -> L14
        this.d = r5;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r5;
    L8:
        r4 = 0;
        goto L9
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public static SharedPreferences a(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(h, 4);
    }

    public static final synchronized Uri a(Context r3, String r4, String r5) {
        monitor-enter(AuthTokenMultiProcessSharedProvider.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (f15714b == null) goto L23;
    L16:
        Uri r7 = f15714b.buildUpon().appendPath(r4).appendPath(r5).build();     // Catch: Throwable -> L19
        monitor-exit(AuthTokenMultiProcessSharedProvider.class);
        return r7;
    L23:
    L11:
        e = move-exception;
        d.a(e);     // Catch: Throwable -> L19
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

    private Runnable a(final String r2, final String r3) {
        return new AnonymousClass1(this, r2, r3);
    }

    public static String a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return null;
    L5:
        if (h.a(r6) == true) goto L24;
        ProviderInfo[] r0 = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 8).providers;     // Catch: Exception -> L14
        int r1 = r0.length;     // Catch: Exception -> L14
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        ProviderInfo r3 = r0[r2];     // Catch: Exception -> L14
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    L17:
        return r7.getPackageName() + ".auth_token.SHARE_PROVIDER_AUTHORITY";
    L14:
        e = move-exception;
        d.a(e);
        goto L17
    L24:
        return null;
    }

    private void a(Uri r3) {
        ZeusProviderTransform.notifyChange(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r3, null, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ void a(AuthTokenMultiProcessSharedProvider r0, Uri r1) {
        r0.a(r1);
    }

    private static void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(f15713a) == false) goto L6;
        f15713a = a(r4, AuthTokenMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f15713a) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.d("AuthTokenMultiProcessSharedProvider", f15713a);
    L10:
        UriMatcher r5 = new UriMatcher(-1);
        c = r5;
        r5.addURI(f15713a, "*/*", 65536);
        f15714b = Uri.parse("content://" + f15713a);
        return;
    L13:
        throw new IllegalStateException("Must Set AuthTokenMultiProcessSharedProvider Authority");
    }

    private static boolean b() {
        if (TextUtils.isEmpty(f15713a) == false) goto L6;
        return true;
    L6:
        if (c == null) goto L10;
        return false;
    L10:
        return true;
    }

    private void c() {
        if (this.f == true) goto L14;
        Object r0 = this.g;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f == true) goto L9;
        d();     // Catch: Throwable -> L11
        this.f = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    }

    private void d() {
        SharedPreferences r0 = a();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ?>> r1 = r0.getAll().entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r4 = r2.getValue();
        if (r4 == null) goto L17;
        if (r3 == null) goto L17;
        this.e.put(r3, r4);
    L17:
        com.ss.android.c.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider loadValues key_ = " + r3 + " value_ = " + r4);     // Catch: Exception -> L14
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L14
        r5.put("key_", r3);     // Catch: Exception -> L14
        r5.put("value_", r4);     // Catch: Exception -> L14
        com.bytedance.sdk.account.f.a.a("token_sp_error", r5);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        d.a(e);
        goto L7
    }

    public void attachInfo(Context r3, ProviderInfo r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        f15713a = r4.authority;
    L5:
        super.attachInfo(r5, r4);
    }

    public int delete(Uri r3, String r4, String[] r5) {
        c();
        if (b() == false) goto L6;
        return 0;
    L6:
        if (c.match(r3) != 65536) goto L13;
        this.e.clear();     // Catch: Exception -> L9
        a().edit().clear().commit();     // Catch: Exception -> L9
        a(a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "key", "type"));     // Catch: Exception -> L9
    L11:
        return 0;
    L9:
        e = move-exception;
        d.a(e);
        goto L11
    L13:
        throw new IllegalArgumentException("Unsupported uri " + r3);
    }

    public String getType(Uri r1) {
        c();
        return "vnd.android.cursor.item/vnd." + f15713a + ".item";
    }

    public Uri insert(Uri r13, ContentValues r14) {
        c();
        if (b() == false) goto L6;
        return null;
    L6:
        if (c.match(r13) != 65536) goto L64;
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L60
        Iterator<Map.Entry<String, Object>> r15 = r14.valueSet().iterator();     // Catch: Exception -> L60
        SharedPreferences.Editor r5 = null;
    L10:
        if (r15.hasNext() == false) goto L49;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L60
        Object r8 = r6.getValue();     // Catch: Exception -> L60
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L60
        com.ss.android.c.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r7 + " value = " + e.a(r8));     // Catch: Exception -> L60
        if (r7 == null) goto L10;
        boolean r9 = false;
        if (r8 != null) goto L18;
        this.e.remove(r7);     // Catch: Exception -> L60
    L17:
        r9 = true;
    L23:
        if (r9 == false) goto L10;
        com.ss.android.c.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r7 + " value = " + e.a(r8));     // Catch: Exception -> L60
        if (r5 != null) goto L27;
        r5 = a().edit();     // Catch: Exception -> L60
    L27:
        if (r8 != null) goto L30;
        r5.remove(r7);     // Catch: Exception -> L60
        Runnable r10 = null;
    L45:
        if (r10 == null) goto L10;
        r3.add(r10);     // Catch: Exception -> L60
        goto L10
    L30:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L34;
        r5.putString(r7, (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L60
        String r11 = TypedValues.Custom.S_STRING;
    L32:
        r10 = a(r7, r11);     // Catch: Exception -> L60
        goto L45
    L34:
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L37;
        r5.putBoolean(r7, ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());     // Catch: Exception -> L60
        r11 = TypedValues.Custom.S_BOOLEAN;
        goto L32
    L37:
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L40;
        r5.putLong(r7, ((Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Exception -> L60
        r11 = "long";
        goto L32
    L40:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L43;
        r5.putInt(r7, ((Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Exception -> L60
        r11 = TypedValues.Custom.S_INT;
        goto L32
    L43:
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == false) goto L48;
        r5.putFloat(r7, ((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.memorydata.plugin")).floatValue());     // Catch: Exception -> L60
        r11 = TypedValues.Custom.S_FLOAT;
        goto L32
    L48:
        throw new IllegalArgumentException("Unsupported type " + r13);     // Catch: Exception -> L60
    L18:
        Object r12 = this.e.get(r7);     // Catch: Exception -> L60
        if (r12 != null) goto L21;
    L22:
        this.e.put(r7, r8);     // Catch: Exception -> L60
        goto L17
    L21:
        if (r12.equals(r8) == true) goto L23;
    L49:
        if (r5 != null) goto L52;
        return null;
    L52:
        if (Build.VERSION.SDK_INT <= 8) goto L54;
        r5.apply();     // Catch: Exception -> L60
    L55:
        Iterator r16 = r3.iterator();     // Catch: Exception -> L60
    L57:
        if (r16.hasNext() == false) goto L62;
        ((Runnable) ZeusTransformUtils.preCheckCast(r16.next(), Runnable.class, "com.obric.memorydata.plugin")).run();     // Catch: Exception -> L60
    L62:
        return null;
    L54:
        r5.commit();     // Catch: Exception -> L60
    L60:
        e = move-exception;
        d.a(e);
        goto L62
    L64:
        throw new IllegalArgumentException("Unsupported uri " + r13);
    }

    public boolean onCreate() {
        if (Logger.debug() == false) goto L10;
        if (f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L10;
        throw new IllegalAccessError("should be create in main process");
    L10:
        if (c == null) goto L21;
        return true;
    L21:
    L16:
        e = move-exception;
        d.a(e);
        e.printStackTrace();
        return false;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d("AuthTokenMultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L16
    L14:
        b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L16
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    public Cursor query(Uri r5, String[] r6, String r7, String[] r8, String r9) {
        c();
        Object r10 = null;
        String r11 = null;
        if (b() == false) goto L6;
        return null;
    L6:
        if (c.match(r5) != 65536) goto L56;
        int r12 = 1;
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL.equals((String) ZeusTransformUtils.preCheckCast(r5.getPathSegments().get(1), String.class, "com.obric.memorydata.plugin")) == false) goto L37;
        Map<String, ?> r4 = a().getAll();     // Catch: Exception -> L52
        MatrixCursor r13 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L52
        Iterator<Map.Entry<String, ?>> r14 = r4.entrySet().iterator();     // Catch: Exception -> L35
    L11:
        r10 = r11;
        if (r14.hasNext() == false) goto L59;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
        Object r17 = r15.getValue();     // Catch: Exception -> L35
        MatrixCursor.RowBuilder r1 = r13.newRow();     // Catch: Exception -> L35
        boolean r2 = ZeusTransformUtils.instanceOf(r17, String.class);     // Catch: Exception -> L35
        String r3 = TypedValues.Custom.S_STRING;
        if (r2 == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r17, Boolean.class) == false) goto L25;
        r3 = TypedValues.Custom.S_BOOLEAN;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L22;
        int r18 = 1;
    L23:
        r17 = Integer.valueOf(r18);     // Catch: Exception -> L35
        goto L33
    L22:
        r18 = 0;
        goto L23
    L25:
        if (ZeusTransformUtils.instanceOf(r17, Integer.class) == false) goto L28;
        r3 = TypedValues.Custom.S_INT;
        goto L33
    L28:
        if (ZeusTransformUtils.instanceOf(r17, Long.class) == false) goto L31;
        r3 = "long";
        goto L33
    L31:
        if (ZeusTransformUtils.instanceOf(r17, Float.class) == false) goto L33;
        r3 = TypedValues.Custom.S_FLOAT;
    L33:
        r1.add(r16);     // Catch: Exception -> L35
        r1.add(r17);     // Catch: Exception -> L35
        r1.add(r3);     // Catch: Exception -> L35
        r11 = r16;
    L59:
        return r13;
    L35:
        e = e;
        r10 = r13;
    L53:
        d.a(e);
        return r10;
    L37:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r5.getPathSegments().get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L52
        if (this.e.containsKey(r19) == true) goto L40;
        return null;
    L40:
        MatrixCursor r20 = new MatrixCursor(new String[]{r19});     // Catch: Exception -> L52
        Object r21 = this.e.get(r19);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r22 = r20.newRow();     // Catch: Exception -> L50
        if (ZeusTransformUtils.instanceOf(r21, Boolean.class) == true) goto L44;
    L48:
        com.ss.android.c.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider  get key = " + r19 + " value = " + e.a(r21) + " " + Log.getStackTraceString(new Exception()));     // Catch: Exception -> L50
        r22.add(r21);     // Catch: Exception -> L50
        r13 = r20;
        r10 = r22;
        goto L59
    L44:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r21, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L47;
        r12 = 0;
    L47:
        r21 = Integer.valueOf(r12);     // Catch: Exception -> L50
    L50:
        e = e;
        r10 = r20;
    L52:
        e = e;
        goto L53
    L56:
        throw new IllegalArgumentException("Unsupported uri " + r5);
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException();
    }
}
