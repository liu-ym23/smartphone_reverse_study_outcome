package com.bytedance.android.live.room.report;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final /* synthetic */ int k = 0;
    public final ReportConstant$BusinessSource a;
    public final User b;
    public final IRoom c;
    public final String d;
    public final String e;
    public final String f;
    public final u g;
    public final boolean h;
    public final ReportObject i;
    public final Map<String, String> j;

    public static final class a {
        public static g a(y71.a r14) {
            Intrinsics.checkNotNullParameter(r14, "wrapper");
            Map<String, String> r0 = ReportTracer.a;
            ReportTracer.b(ReportTracer.EventName.generate_report_params);
            ReportTracer.a(r14.c, r14.d, r14.e, r14.f);
            IBaseUser r1 = r14.a;
            if ((r1 instanceof User) == true) goto L5;
            r1 = null;
        L5:
            User r5 = (User) r1;
            if (r5 != null) goto L8;
            return null;
        L8:
            IRoom r2 = r14.b;
            if ((r2 instanceof Room) == true) goto L11;
            r2 = null;
        L11:
            Room r6 = (Room) r2;
            if (r6 != null) goto L14;
            return null;
        L14:
            ReportConstant$BusinessSource r4 = r14.i;
            String r3 = r14.c;
            if (r3 != null) goto L17;
            String r7 = "";
        L18:
            String r8 = r14.d;
            if (r8 != null) goto L21;
            String r9 = "";
        L22:
            String r10 = r14.e;
            if (r10 != null) goto L25;
            String r12 = "";
        L27:
            return new g(r4, r5, r6, r7, r9, r12, r14.f, Intrinsics.areEqual(r5.getIdString(), r6.getOwnerUserIdString()), r14.g, r14.h);
        L25:
            r12 = r10;
            goto L27
        L21:
            r9 = r8;
            goto L22
        L17:
            r7 = r3;
            goto L18
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L28;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        if (this.h == r4.h) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v32 */
    public final int hashCode() {
        ReportConstant$BusinessSource r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        User r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        IRoom r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        u r20 = this.g;
        if (r20 == null) goto L29;
        int r22 = r20.hashCode();
    L30:
        int r23 = (((r19 + r22) * 31) + 0) * 31;
        boolean r24 = this.h;
        ?? r25 = r24;
        if (r24 == false) goto L33;
        r25 = 1;
    L33:
        int r26 = (r23 + r25) * 31;
        ReportObject r27 = this.i;
        if (r27 == null) goto L36;
        int r28 = r27.hashCode();
    L37:
        int r29 = (r26 + r28) * 31;
        Map<String, String> r30 = this.j;
        if (r30 == null) goto L41;
        r1 = r30.hashCode();
    L41:
        return r29 + r1;
    L36:
        r28 = 0;
        goto L37
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
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

    public final String toString() {
        return "ReportParams(businessSource=" + this.a + ", targetUser=" + this.b + ", room=" + this.c + ", fromSource=" + this.d + ", reportSource=" + this.e + ", reportTypeForLog=" + this.f + ", commentReportModel=" + this.g + ", channelLinkReportModel=null, targetUserIsAnchor=" + this.h + ", reportObject=" + this.i + ", extraParams=" + this.j + ")";
    }

    public /* synthetic */ g(ReportConstant$BusinessSource r12, User r13, IRoom r14, String r15, String r16, String r17, u r18, boolean r19) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, null, null);
    }

    public g(ReportConstant$BusinessSource r2, User r3, IRoom r4, String r5, String r6, String r7, u r8, boolean r9, ReportObject r10, Map r12) {
        Intrinsics.checkNotNullParameter(r2, "businessSource");
        Intrinsics.checkNotNullParameter(r3, "targetUser");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "fromSource");
        Intrinsics.checkNotNullParameter(r6, "reportSource");
        Intrinsics.checkNotNullParameter(r7, "reportTypeForLog");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
    }
}
