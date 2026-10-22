package com.bytedance.apm.battery.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1166b;
    private Uri c;
    private final HashMap<String, Integer> d;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.dao.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.battery.dao.a$a, reason: collision with other inner class name */
    public interface InterfaceC0085a<T> {
        T a(b r1);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Cursor f1167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<String, Integer> f1168b;

        private b(Cursor r3, HashMap<String, Integer> r4) {
            this.f1167a = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
            this.f1168b = r4;
        }

        /* synthetic */ b(Cursor r2, HashMap r3, AnonymousClass1 r4) {
            this((Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin"), r3);
        }

        private int d(String r4) {
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f1168b.get(r4), Integer.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L9;
            r0 = Integer.valueOf(this.f1167a.getColumnIndex(r4));     // Catch: Throwable -> L6
        L7:
            this.f1168b.put(r4, r0);
        L6:
            r0 = -1;
        L9:
            return r0.intValue();
        }

        public long a(String r2) {
            return this.f1167a.getLong(d(r2));
        L4:
            return -1;
        }

        public int b(String r2) {
            return this.f1167a.getInt(d(r2));
        L4:
            return -1;
        }

        public String c(String r2) {
            return this.f1167a.getString(d(r2));
        L4:
            return "";
        }
    }

    public a() {
        this.d = new HashMap();
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f1165a = r0;
        this.f1166b = r0.getPackageName() + CommonConsts.MONITOR_PROVIDER_SUFFIX;
    }

    private static void a(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (r3.isClosed() == true) goto L12;
        r3.close();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public String a() {
        return "apm_monitor_t1.db";
    }

    public abstract String b();

    public abstract String[] c();

    public Uri d() {
        if (this.c != null) goto L6;
        this.c = Uri.parse("content://" + this.f1166b + "/" + a() + "/" + b());
    L6:
        return this.c;
    }

    public int delete(String r3, String[] r4) {
        return ZeusProviderTransform.delete(this.f1165a.getContentResolver(), d(), r3, r4, "com.obric.memorydata.plugin");
    L4:
        return -1;
    }

    public synchronized <I extends T> long insert(ContentValues r6) {
        monitor-enter(this);
        if (r6 != null) goto L22;
        monitor-exit(this);
        return -1;
    L22:
        Uri r7 = ZeusProviderTransform.insert(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), d(), r6, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17 Exception -> L20
        if (r7 != null) goto L24;
        monitor-exit(this);
        return -1;
    L24:
        long r0 = Long.parseLong(r7.getLastPathSegment());     // Catch: Exception -> L14 Throwable -> L17
        monitor-exit(this);
        return r0;
    L14:
        return 1;
    L17:
        th = move-exception;
        throw th;
    L21:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<T> query(String r10, String[] r11, String r12, InterfaceC0085a<T> r13) {
        InterfaceC0085a r14 = (InterfaceC0085a) ZeusTransformUtils.wrapperContextForParams(r13, InterfaceC0085a.class, "com.obric.memorydata.plugin");
        Cursor r0 = null;
        Object[] r1 = 0;
        Cursor r15 = ZeusProviderTransform.query(this.f1165a.getContentResolver(), d(), c(), r10, r11, r12, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r15 != null) goto L34;
    L25:
        List<T> r9 = Collections.emptyList();     // Catch: Throwable -> L28
        a(r15);
        return r9;
    L34:
    L28:
        r0 = r15;
        goto L29
    L6:
        if (r15.getCount() <= 0) goto L25;
        int r16 = Integer.MAX_VALUE;
        if (TextUtils.isEmpty(r12) == true) goto L17;
        int r2 = r12.indexOf("LIMIT");     // Catch: Throwable -> L28
        if (r2 <= 0) goto L17;
        int r17 = r12.indexOf("OFF");     // Catch: Throwable -> L28
        int r3 = r2 + 5;     // Catch: Throwable -> L28
        if (r17 <= 0) goto L16;
        Integer r18 = Integer.valueOf(r12.substring(r3, r17).trim());     // Catch: Throwable -> L28
    L15:
        r16 = r18.intValue();     // Catch: Throwable -> L28
        goto L17
    L16:
        r18 = Integer.valueOf(r12.substring(r3).trim());     // Catch: Throwable -> L28
    L17:
        LinkedList r19 = new LinkedList();     // Catch: Throwable -> L28
        int r4 = 0;
    L19:
        if (r15.moveToNext() == false) goto L23;
        if (r4 >= r16) goto L23;
        r19.add(r14.a(new b(r15, this.d, r1 == true ? 1 : 0)));     // Catch: Throwable -> L28
        r4 = r4 + 1;
    L23:
        a(r15);
        return r19;
    L29:
        a(r0);
        return Collections.emptyList();
    }

    public int update(ContentValues r9, String r10, String[] r11) {
        if (r9 != null) goto L8;
        return -1;
    L8:
        return ZeusProviderTransform.update(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), d(), r9, r10, r11, "com.obric.memorydata.plugin");
    L7:
        return -1;
    }
}
