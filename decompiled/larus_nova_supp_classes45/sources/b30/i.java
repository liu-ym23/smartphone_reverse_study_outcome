package b30;

import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji;
import com.bytedance.android.livesdkapi.depend.model.live.episode.SelectAtUser;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final a e;
    public final h f;
    public final String g;
    public final String h;
    public final long i;
    public final boolean j;
    public final JsonObject k;
    public final String l;
    public final String m;
    public final String n;

    public interface a {

        /* JADX INFO: renamed from: b30.i$a$a, reason: collision with other inner class name */
        public static class C0002a implements a {
            public C0002a() {
            }

            @Override // b30.i.a
            public final void onCommentSuccess(CharSequence r1, ISelfEmoji r2, List<SelectAtUser> r3) {
            }
        }

        void onCommentSuccess(CharSequence r1, ISelfEmoji r2, List<SelectAtUser> r3);
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof i) == false) goto L32;
        i r7 = (i) r6;
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L20;
        return false;
    L20:
        if (this.i == r7.i) goto L22;
        return false;
    L22:
        if (this.j == r7.j) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v42 */
    public final int hashCode() {
        String r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        a r11 = this.e;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        h r14 = this.f;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r21 = this.h;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        long r24 = this.i;
        int r25 = (r23 + ((int) (r24 ^ (r24 >>> 32)))) * 31;
        boolean r26 = this.j;
        ?? r27 = r26;
        if (r26 == false) goto L33;
        r27 = 1;
    L33:
        int r28 = (r25 + r27) * 31;
        JsonObject r29 = this.k;
        if (r29 == null) goto L36;
        int r31 = r29.hashCode();
    L37:
        int r32 = (r28 + r31) * 31;
        String r33 = this.l;
        if (r33 == null) goto L40;
        int r34 = r33.hashCode();
    L41:
        int r35 = (r32 + r34) * 31;
        String r36 = this.m;
        if (r36 == null) goto L44;
        int r37 = r36.hashCode();
    L45:
        int r38 = (r35 + r37) * 31;
        String r39 = this.n;
        if (r39 == null) goto L49;
        r1 = r39.hashCode();
    L49:
        return r38 + r1;
    L44:
        r37 = 0;
        goto L45
    L40:
        r34 = 0;
        goto L41
    L36:
        r31 = 0;
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
        return "OpenCommentPanelEvent(content=" + this.b + ", requestPage=" + this.c + ", messageSource=" + this.d + ", commentCallback=" + this.e + ", atUserParam=" + this.f + ", requestSource=" + this.g + ", defaultPanel=" + this.h + ", createTime=" + this.i + ", isFromJsb=" + this.j + ", trackParams=" + this.k + ", previewGuideText=" + this.l + ", roomId=" + this.m + ", hint=" + this.n + ")";
    }

    public i(String r16, String r17, String r18, a r19, h r21, String r22, String r23, long r24, boolean r25, JsonObject r26, String r27, String r28, String r29, int r31) {
        boolean r6 = false;
        if ((r31 & 16) == 0) goto L5;
        h r5 = new h(0);
    L6:
        String r8 = "";
        if ((r31 & 32) == 0) goto L9;
        String r7 = "";
    L10:
        String r11 = null;
        if ((r31 & 64) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r31 & 128) == 0) goto L17;
        long r12 = System.currentTimeMillis();
    L19:
        if ((r31 & 256) != 0) goto L23;
        r6 = r25;
    L23:
        if ((r31 & 512) == 0) goto L25;
        JsonObject r13 = null;
    L27:
        if ((r31 & RomUtils.SZ) != 0) goto L31;
        r8 = r27;
    L31:
        if ((r31 & 2048) == 0) goto L33;
        String r14 = null;
    L35:
        if ((r31 & 4096) != 0) goto L38;
        r11 = r29;
    L38:
        Intrinsics.checkNotNullParameter(r17, "requestPage");
        Intrinsics.checkNotNullParameter(r18, "messageSource");
        Intrinsics.checkNotNullParameter(r19, "commentCallback");
        Intrinsics.checkNotNullParameter(r5, "atUserParam");
        Intrinsics.checkNotNullParameter(r8, "previewGuideText");
        this.b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r5;
        this.g = r7;
        this.h = r9;
        this.i = r12;
        this.j = r6;
        this.k = r13;
        this.l = r8;
        this.m = r14;
        this.n = r11;
        return;
    L33:
        r14 = r28;
        goto L35
    L25:
        r13 = r26;
        goto L27
    L17:
        r12 = r24;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r7 = r22;
        goto L10
    L5:
        r5 = r21;
        goto L6
    }
}
