package do8;

import com.larus.chat.gallery.api.PreviewScene;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VLMMixerSearchResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final int a;
    public final String b;
    public final Message c;
    public final VLMMixerSearchResult d;
    public final Integer e;
    public final boolean f;
    public final JSONObject g;
    public final j h;
    public final i i;
    public final Boolean j;
    public final PreviewScene k;
    public final boolean l;
    public final Function1<Integer, Unit> m;
    public final Boolean n;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
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
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Message r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.d.hashCode()) * 31;
        Integer r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        int r11 = 1231;
        if (this.f == false) goto L17;
        int r12 = 1231;
    L18:
        int r13 = (r10 + r12) * 31;
        JSONObject r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((r13 + r15) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        Boolean r17 = this.j;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((r16 + r18) * 31) + this.k.hashCode()) * 31;
        if (this.l == true) goto L30;
        r11 = 1237;
    L30:
        int r20 = (r19 + r11) * 31;
        Function1<Integer, Unit> r21 = this.m;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        Boolean r24 = this.n;
        if (r24 == null) goto L39;
        r2 = r24.hashCode();
    L39:
        return r23 + r2;
    L33:
        r22 = r21.hashCode();
        goto L34
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = 1237;
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "VLMContainerVMData(maxWidth=" + this.a + ", toolName=" + this.b + ", message=" + this.c + ", model=" + this.d + ", cardPosition=" + this.e + ", enableCrossGroupPreview=" + this.f + ", eventParams=" + this.g + ", uiConfig=" + this.h + ", preloadAndRecommendConfig=" + this.i + ", disableNewImagePreview=" + this.j + ", previewScene=" + this.k + ", isVLM=" + this.l + ", customClickListener=" + this.m + ", enableShimmer=" + this.n + ')';
    }

    public /* synthetic */ k(int r19, String r20, Message r21, VLMMixerSearchResult r22, Integer r23, boolean r24, JSONObject r25, j r26, i r27, Boolean r28, PreviewScene r29, Function1 r30, Boolean r31, int r32) {
        if ((r32 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r32 & 4) == 0) goto L9;
        Message r6 = null;
    L11:
        if ((r32 & 16) == 0) goto L13;
        Integer r8 = null;
    L15:
        if ((r32 & 32) == 0) goto L17;
        boolean r9 = false;
    L19:
        if ((r32 & 64) == 0) goto L21;
        JSONObject r10 = null;
    L23:
        if ((r32 & 128) == 0) goto L25;
        j r11 = new j(false, false, false, false, null, 63);
    L27:
        if ((r32 & 256) == 0) goto L29;
        i r12 = new i(0);
    L31:
        if ((r32 & 512) == 0) goto L33;
        Boolean r13 = null;
    L35:
        if ((r32 & 1024) == 0) goto L37;
        PreviewScene r14 = PreviewScene.MESSAGE;
    L39:
        if ((r32 & 2048) == 0) goto L41;
        boolean r15 = true;
    L43:
        if ((r32 & 4096) == 0) goto L45;
        Function1 r16 = null;
    L47:
        if ((r32 & 8192) == 0) goto L49;
        Boolean r17 = Boolean.FALSE;
    L50:
        this(r19, r5, r6, r22, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        return;
    L49:
        r17 = r31;
        goto L50
    L45:
        r16 = r30;
        goto L47
    L41:
        r15 = false;
        goto L43
    L37:
        r14 = r29;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r9 = r24;
        goto L19
    L13:
        r8 = r23;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(int r2, String r3, Message r4, VLMMixerSearchResult r5, Integer r6, boolean r7, JSONObject r8, j r9, i r10, Boolean r11, PreviewScene r12, boolean r13, Function1<? super Integer, Unit> r14, Boolean r15) {
        Intrinsics.checkNotNullParameter(r5, "model");
        Intrinsics.checkNotNullParameter(r9, "uiConfig");
        Intrinsics.checkNotNullParameter(r10, "preloadAndRecommendConfig");
        Intrinsics.checkNotNullParameter(r12, "previewScene");
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
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }
}
