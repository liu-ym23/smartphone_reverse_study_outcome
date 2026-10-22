package com.larus.drive.biz.api.model;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int k = 0;
    public final String a;
    public String b;
    public final String c;
    public final DriveFileType d;
    public final String e;
    public DriveUploadStatus f;
    public Integer g;
    public Long h;
    public Long i;
    public final JSONObject j;

    /* JADX INFO: renamed from: com.larus.drive.biz.api.model.a$a, reason: collision with other inner class name */
    public static final class C0110a {
        public static a a(JSONObject r13) {
            Integer r0 = null;
            if (r13 != null) goto L5;
            return null;
        L5:
            Object r1 = r13.opt("item_id");
            if ((r1 instanceof String) == false) goto L8;
            String r3 = (String) r1;
        L9:
            if (r3 != null) goto L11;
            return null;
        L11:
            Object r2 = r13.opt("task_id");
            if ((r2 instanceof String) == false) goto L14;
            String r4 = (String) r2;
        L15:
            if (r4 != null) goto L17;
            return null;
        L17:
            Object r5 = r13.opt("file_name");
            if ((r5 instanceof String) == false) goto L20;
            String r6 = (String) r5;
        L21:
            if (r6 != null) goto L23;
            return null;
        L23:
            DriveFileType.a r7 = DriveFileType.Companion;
            Object r8 = r13.opt("file_type");
            if ((r8 instanceof String) == false) goto L26;
            String r9 = (String) r8;
        L27:
            if (r9 != null) goto L29;
            return null;
        L29:
            r7.getClass();
            DriveFileType r10 = DriveFileType.a.a(r9);
            String r11 = r13.optString("parent_drive_token", "");
            DriveUploadStatus.a r12 = DriveUploadStatus.Companion;
            Object r14 = r13.opt("status");
            if ((r14 instanceof String) == false) goto L32;
            String r15 = (String) r14;
        L33:
            if (r15 != null) goto L35;
            return null;
        L35:
            r12.getClass();
            Intrinsics.checkNotNullParameter(r15, "value");
            Iterator r16 = DriveUploadStatus.getEntries().iterator();
        L37:
            if (r16.hasNext() == false) goto L41;
            Object r17 = r16.next();
            if (Intrinsics.areEqual(((DriveUploadStatus) r17).getValue(), r15) == false) goto L37;
        L42:
            DriveUploadStatus r18 = (DriveUploadStatus) r17;
            if (StringsKt.isBlank(r3) == false) goto L45;
        L59:
            return null;
        L45:
            if (StringsKt.isBlank(r4) == true) goto L59;
            if (StringsKt.isBlank(r6) == true) goto L59;
            if (r10 == null) goto L59;
            if (r18 == null) goto L59;
            Intrinsics.checkNotNull(r11);
            if (r13.has("error_tip_res_id") == false) goto L54;
            r0 = Integer.valueOf(r13.optInt("error_tip_res_id"));
        L54:
            Integer r20 = r0;
            Long r110 = Long.valueOf(r13.optLong("bytes_total"));
            Long r111 = Long.valueOf(r13.optLong("bytes_transferred"));
            JSONObject r112 = r13.optJSONObject("event_params");
            if (r112 != null) goto L58;
            r112 = new JSONObject();
        L58:
            return new a(r3, r4, r6, r10, r11, r18, r20, r110, r111, r112);
        L41:
            r17 = null;
            goto L42
        L32:
            r15 = null;
            goto L33
        L26:
            r9 = null;
            goto L27
        L20:
            r6 = null;
            goto L21
        L14:
            r4 = null;
            goto L15
        L8:
            r3 = null;
            goto L9
        }
    }

    static {
    }

    public final a a() {
        return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    public final int hashCode() {
        Long r0 = this.h;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.i;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((((((((((((r3 + r5) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        Integer r7 = this.g;
        if (r7 == null) goto L13;
        int r8 = r7.intValue();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.h;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.i;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.drive.biz.api.model.DriveUploadItem");
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L22;
        return false;
    L22:
        if (this.d == r6.d) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L28;
        return false;
    L28:
        if (this.f == r6.f) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L39;
        return false;
    L39:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public a(String r2, String r3, String r4, DriveFileType r5, String r6, DriveUploadStatus r7, Integer r8, Long r9, Long r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "fileType");
        Intrinsics.checkNotNullParameter(r6, "parentDriveToken");
        Intrinsics.checkNotNullParameter(r7, "status");
        Intrinsics.checkNotNullParameter(r11, "eventParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
