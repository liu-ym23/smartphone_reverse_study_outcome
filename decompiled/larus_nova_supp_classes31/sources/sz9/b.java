package sz9;

import com.larus.bmhome.bigimg.l;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zo8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final Message a;
    public final Boolean b;
    public final zo8.b c;
    public final e d;
    public final l e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final JSONObject i;
    public final String j;
    public final Map<String, UserCreationFromIM> k;
    public final boolean l;
    public final Integer m;
    public final Integer n;

    public b() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        zo8.b r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        e r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        l r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        int r16 = 1231;
        if (this.f == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.g == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.h == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        JSONObject r23 = this.i;
        if (r23 != null) goto L37;
        int r24 = 0;
    L38:
        int r25 = (((((r22 + r24) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        if (this.l == true) goto L42;
        r16 = 1237;
    L42:
        int r26 = (r25 + r16) * 31;
        Integer r27 = this.m;
        if (r27 != null) goto L45;
        int r28 = 0;
    L46:
        int r29 = (r26 + r28) * 31;
        Integer r30 = this.n;
        if (r30 == null) goto L51;
        r1 = r30.hashCode();
    L51:
        return r29 + r1;
    L45:
        r28 = r27.hashCode();
        goto L46
    L37:
        r24 = r23.hashCode();
        goto L38
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
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
        return "CreationGalleryData(message=" + this.a + ", isCaseMode=" + this.b + ", imageContent=" + this.c + ", videoContent=" + this.d + ", imageInfo=" + this.e + ", disableCollection=" + this.f + ", isBlockContent=" + this.g + ", isMixed=" + this.h + ", reportParams=" + this.i + ", desc=" + this.j + ", creationStatus=" + this.k + ", noWatermarkSelected=" + this.l + ", currentCreationTypeFromIM=" + this.m + ", taskType=" + this.n + ')';
    }

    public b(Message r17, Boolean r18, zo8.b r19, e r20, boolean r21, boolean r22, JSONObject r23, String r24, Map r25, boolean r26, Integer r27, Integer r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        Message r3 = null;
    L7:
        if ((r29 & 2) == 0) goto L9;
        Boolean r5 = Boolean.FALSE;
    L11:
        if ((r29 & 4) == 0) goto L13;
        zo8.b r6 = null;
    L15:
        if ((r29 & 8) == 0) goto L17;
        e r7 = null;
    L19:
        if ((r29 & 32) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r29 & 128) == 0) goto L25;
        boolean r10 = false;
    L27:
        if ((r29 & 256) == 0) goto L29;
        JSONObject r11 = null;
    L31:
        if ((r29 & 512) == 0) goto L33;
        String r12 = "";
    L35:
        if ((r29 & 2048) == 0) goto L37;
        boolean r13 = false;
    L39:
        if ((r29 & 4096) == 0) goto L41;
        Integer r14 = null;
    L43:
        if ((r29 & 8192) == 0) goto L45;
        Integer r2 = null;
    L46:
        Intrinsics.checkNotNullParameter(r12, "desc");
        Intrinsics.checkNotNullParameter(r25, "creationStatus");
        this.a = r3;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = null;
        this.f = r8;
        this.g = false;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r25;
        this.l = r13;
        this.m = r14;
        this.n = r2;
        return;
    L45:
        r2 = r28;
        goto L46
    L41:
        r14 = r27;
        goto L43
    L37:
        r13 = r26;
        goto L39
    L33:
        r12 = r24;
        goto L35
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r8 = r21;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }
}
