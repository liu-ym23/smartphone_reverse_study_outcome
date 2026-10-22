package com.larus.calendar;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.common.apphost.AppHost;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CalendarManager {
    public static final Context a = null;
    public static final String[] b = null;
    public static final String c = null;

    public static final class a {
        public final long a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final int f;
        public final String g;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 != null) goto L5;
            int r4 = 0;
        L6:
            int r5 = (r1 + r4) * 31;
            String r6 = this.c;
            if (r6 != null) goto L9;
            int r7 = 0;
        L10:
            int r8 = (r5 + r7) * 31;
            String r9 = this.d;
            if (r9 != null) goto L13;
            int r10 = 0;
        L14:
            int r11 = (r8 + r10) * 31;
            String r12 = this.e;
            if (r12 != null) goto L17;
            int r13 = 0;
        L18:
            int r14 = (((r11 + r13) * 31) + this.f) * 31;
            String r15 = this.g;
            if (r15 == null) goto L23;
            r3 = r15.hashCode();
        L23:
            return r14 + r3;
        L17:
            r13 = r12.hashCode();
            goto L18
        L13:
            r10 = r9.hashCode();
            goto L14
        L9:
            r7 = r6.hashCode();
            goto L10
        L5:
            r4 = r2.hashCode();
            goto L6
        }

        public final String toString() {
            return "Calendar(id=" + this.a + ", name=" + this.b + ", displayName=" + this.c + ", accountType=" + this.d + ", accountName=" + this.e + ", visible=" + this.f + ", ownerAccount=" + this.g + ')';
        }

        public a() {
            this(0, null, null, null, null, 0, null);
        }

        public a(long r1, String r3, String r4, String r5, String r6, int r7, String r8) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    static {
        a = AppHost.a.getApplication();
        b = new String[]{"LOCAL", "com.android.huawei.phone", "com.xiaomi", "com.android.hihonor.phone"};
        c = "豆包事件提醒";
    }

    public static List e() {
        ContentResolver r2 = f();
        Cursor r0 = d(r2, CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", "name", "calendar_displayName", "account_name", "account_type", "visible", "ownerAccount"}, null, null);
        if (r0 == null) goto L15;
        Cursor r1 = r0;
        List r3 = SequencesKt.toList(SequencesKt.sequence(new CalendarManager$getCalendars$1$1(r1, null)));     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r1, null);
        if (r3 == null) goto L15;
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L15:
        return CollectionsKt.emptyList();
    }

    public static ContentResolver f() {
        return a.getContentResolver();
    }

    public static a g() {
        List r0 = e();
        Iterator r1 = r0.iterator();
    L3:
        Object r3 = null;
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (ArraysKt.contains(b, ((a) r2).d) == false) goto L3;
    L9:
        a r4 = (a) r2;
        if (r4 != null) goto L48;
        Iterator r5 = r0.iterator();
    L13:
        if (r5.hasNext() == false) goto L46;
        Object r6 = r5.next();
        a r7 = (a) r6;
        String r8 = r7.d;
        if (r8 == null) goto L43;
        int r9 = r8.hashCode();
        if (r9 == (-1116924142)) goto L36;
        if (r9 == 879034182) goto L28;
        if (r9 != 1664859374) goto L43;
        if (r8.equals("com.smartisan.localcalendar") == false) goto L43;
        boolean r10 = Intrinsics.areEqual(r7.g, "Local");
    L44:
        if (r10 == false) goto L13;
    L47:
        r4 = (a) r6;
        goto L48
    L28:
        if (r8.equals("com.google") == false) goto L43;
        String r11 = r7.e;
        if (r11 == null) goto L43;
        if (Intrinsics.areEqual(r11, r7.g) == false) goto L43;
    L42:
        r10 = true;
        goto L44
    L36:
        if (r8.equals("My calendar") == false) goto L43;
        if (Intrinsics.areEqual(r7.e, "My calendar") == false) goto L43;
        if (Intrinsics.areEqual(r7.g, "My calendar") == true) goto L42;
    L43:
        r10 = false;
        goto L44
    L46:
        r6 = null;
    L48:
        if (r4 != null) goto L57;
        ContentValues r12 = new ContentValues();
        String r13 = c;
        r12.put("account_name", r13);
        r12.put("account_type", "LOCAL");
        r12.put("name", "DoubaoMemberCalendar");
        r12.put("calendar_displayName", AppHost.a.getAppStringName());
        r12.put("calendar_access_level", 700);
        r12.put("ownerAccount", r13);
        r12.put("visible", 1);
        r12.put("sync_events", 1);
        c(f(), a(CalendarContract.Events.CONTENT_URI, r13), r12);
        Iterator r14 = e().iterator();
    L51:
        if (r14.hasNext() == false) goto L56;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((a) r15).e, c) == false) goto L51;
        r3 = r15;
    L56:
        return (a) r3;
    L57:
        return r4;
    L8:
        r2 = null;
        goto L9
    }

    public final Context getContext() {
        return a;
    }

    public static boolean h(String r6) {
        boolean r0 = true;
        Cursor r7 = d(f(), CalendarContract.Events.CONTENT_URI, new String[0], "sync_data1=? and (deleted != 1)", new String[]{r6});
        if (r7 == null) goto L16;
        Cursor r8 = r7;
        if (r8.getCount() > 0) goto L9;
        r0 = false;
    L9:
        CloseableKt.closeFinally(r8, null);
        return r0;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L16:
        return false;
    }

    public static Uri a(Uri r2, String r3) {
        return r2.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", r3).appendQueryParameter("account_type", "LOCAL").build();
    }

    public static int b(ContentResolver r21, Uri r22, String[] r23) {
        ArrayList r2 = new ArrayList();
        Object[] r3 = {r22, "sync_data1=?", r23};
        f06.b r14 = new f06.b();
        g06.a r4 = (g06.a) ApiHookConfig.b.get(240019);
        if (r4 == null) goto L5;
        f06.a[] r5 = r4.i;
    L6:
        f06.a[] r11 = r5;
        int r10 = r11.length;
        int r9 = 0;
    L8:
        if (r9 >= r10) goto L15;
        f06.a r8 = r11[r9];
        int r18 = r9;
        int r19 = r10;
        f06.a[] r20 = r11;
        d r6 = r8.preInvoke(240019, "android/content/ContentResolver", ShareChannel.DELETE, r21, r3, "int", r14);     // Catch: Exception -> L22
        if (r6.a == true) goto L17;
        r2.add(r8);     // Catch: Exception -> L22
    L17:
        if (r6.a == false) goto L21;
        return ((Integer) r6.b).intValue();
    L21:
        return r21.delete(r22, "sync_data1=?", r23);
    L14:
        r9 = r18 + 1;
        r10 = r19;
        r11 = r20;
        goto L8
    L15:
        r6 = new d(false, null);
        goto L17
    L5:
        r5 = ApiHookConfig.d;
        goto L6
    }

    public static Uri c(ContentResolver r18, Uri r19, ContentValues r20) {
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
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r19, r20);
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

    public static Cursor d(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17, null};
        f06.b r10 = new f06.b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, null);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
