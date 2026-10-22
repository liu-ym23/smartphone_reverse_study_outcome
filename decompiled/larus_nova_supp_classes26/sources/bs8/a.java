package bs8;

import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final C0004a h = null;
    public final String a;
    public final String b;
    public final Integer c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: bs8.a$a, reason: collision with other inner class name */
    public static final class C0004a {
        public C0004a() {
        }

        public static a a(String r13) {
            if (r13 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            Object r2 = null;
            if (r1 == false) goto L41;
            return null;
        L41:
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L30
            JSONObject r4 = new JSONObject(new JSONObject(r13).optString("agent_task_param"));     // Catch: Throwable -> L30
            String r14 = r4.optString("device_name");     // Catch: Throwable -> L30
            Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L30
            if ((!StringsKt.isBlank(r14)) == false) goto L15;
            String r5 = r14;
        L16:
            String r15 = r4.optString("folder_name");     // Catch: Throwable -> L30
            Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L30
            if ((!StringsKt.isBlank(r15)) == false) goto L19;
            String r6 = r15;
        L20:
            int r16 = r4.optInt("runtime_type");     // Catch: Throwable -> L30
            String r7 = r4.optString("local_device_id");     // Catch: Throwable -> L30
            Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L30
            if ((!StringsKt.isBlank(r7)) == false) goto L23;
            String r9 = r7;
        L24:
            String r8 = r4.optString("workspace");     // Catch: Throwable -> L30
            Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L30
            if ((true ^ StringsKt.isBlank(r8)) == false) goto L27;
            String r10 = r8;
        L28:
            Object r17 = Result.constructor-impl(new a(r5, r6, Integer.valueOf(r16), r10, r9, null, null, 96));     // Catch: Throwable -> L30
        L33:
            if (Result.exceptionOrNull-impl(r17) == null) goto L36;
            FLogger.a.w("ConversationAgentTaskParam", "[fromExt] parse ext failed");
        L36:
            if (Result.isFailure-impl(r17) == true) goto L40;
            r2 = r17;
        L40:
            return (a) r2;
        L27:
            r10 = null;
            goto L28
        L23:
            r9 = null;
            goto L24
        L19:
            r6 = null;
            goto L20
        L15:
            r5 = null;
        L30:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L33
        L5:
            if (StringsKt.isBlank(r13) == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    public a() {
        this(null, null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationAgentTaskParam(deviceName=" + this.a + ", folderName=" + this.b + ", runtimeType=" + this.c + ", workspace=" + this.d + ", localPcDeviceId=" + this.e + ", connectPcDeviceType=" + this.f + ", localAppId=" + this.g + ')';
    }

    static {
        h = new C0004a();
    }

    public final boolean b() {
        Integer r0 = this.c;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public final boolean c() {
        Integer r0 = this.c;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 2) goto L8;
        return true;
    }

    public a(String r1, String r2, Integer r3, String r4, String r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public static a a(a r8, String r9, Integer r10, String r11, String r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        String r1 = r9;
        if ((r14 & 2) == 0) goto L8;
        String r2 = r8.b;
    L10:
        if ((r14 & 4) == 0) goto L12;
        r10 = r8.c;
    L12:
        Integer r3 = r10;
        if ((r14 & 8) == 0) goto L15;
        String r4 = r8.d;
    L17:
        if ((r14 & 16) == 0) goto L19;
        r11 = r8.e;
    L19:
        String r5 = r11;
        if ((r14 & 32) == 0) goto L22;
        r12 = r8.f;
    L22:
        String r6 = r12;
        if ((r14 & 64) == 0) goto L26;
        r13 = r8.g;
    L26:
        return new a(r1, r2, r3, r4, r5, r6, r13);
    L15:
        r4 = null;
        goto L17
    L8:
        r2 = null;
        goto L10
    }

    public /* synthetic */ a(String r8, String r9, Integer r10, String r11, String r12, String r13, String r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        Integer r3 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r4 = null;
    L19:
        if ((r15 & 16) == 0) goto L21;
        String r5 = null;
    L23:
        if ((r15 & 32) == 0) goto L25;
        String r6 = null;
    L27:
        if ((r15 & 64) == 0) goto L29;
        String r16 = null;
    L30:
        this(r0, r2, r3, r4, r5, r6, r16);
        return;
    L29:
        r16 = r14;
        goto L30
    L25:
        r6 = r13;
        goto L27
    L21:
        r5 = r12;
        goto L23
    L17:
        r4 = r11;
        goto L19
    L13:
        r3 = r10;
        goto L15
    L9:
        r2 = r9;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }
}
