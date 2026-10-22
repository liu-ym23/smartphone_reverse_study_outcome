package zo8;

import com.larus.bmhome.utils.c4;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements a {
    public final String a;
    public final c4 b;
    public final g c;
    public final int d;
    public final String e;
    public final VideoPlayView.a f;
    public final Function2<String, IVideoController, Unit> g;
    public final boolean h;
    public final Function0<Unit> i;
    public final Function4<g, String, String, Function1<? super Boolean, Unit>, Unit> j;
    public final String k;
    public final boolean l;
    public final boolean m;

    public e() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
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
        if (this.m == r6.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
        VideoPlayView.a r4 = this.f;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Function2<String, IVideoController, Unit> r7 = this.g;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        int r10 = 1231;
        if (this.h == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (((((r9 + r11) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        String r13 = this.k;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        if (this.l == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.m == true) goto L31;
        r10 = 1237;
    L31:
        return r16 + r10;
    L25:
        r15 = 1237;
        goto L26
    L17:
        r11 = 1237;
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
        return "VideoContent(creationIndex=" + this.a + ", eventParams=" + this.b + ", videoPlayData=" + this.c + ", initProgress=" + this.d + ", videoEngineKey=" + this.e + ", afterClickCallBack=" + this.f + ", onExit=" + this.g + ", showVideoExtendFunction=" + this.h + ", onVideoExtendShownBlk=" + this.i + ", toVideoExtendBlk=" + this.j + ", creationTaskId=" + this.k + ", canPublish=" + this.l + ", isBlockContent=" + this.m + ')';
    }

    @Override // zo8.a
    public final String a() {
        return this.k;
    }

    @Override // zo8.a
    public final String b() {
        return this.a;
    }

    public e(String r15, c4 r16, g r17, int r18, String r19, VideoPlayView.a r20, Function2 r21, boolean r22, Function0 r23, Function4 r24, String r25, boolean r26, boolean r27, int r28) {
        String r6 = null;
        if ((r28 & 1) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r28 & 32) == 0) goto L9;
        VideoPlayView.a r7 = null;
    L11:
        if ((r28 & 64) == 0) goto L13;
        Function2 r8 = null;
    L14:
        boolean r10 = false;
        if ((r28 & 128) == 0) goto L17;
        boolean r9 = false;
    L19:
        if ((r28 & 256) == 0) goto L21;
        Function0 r11 = new c();
    L23:
        if ((r28 & 512) == 0) goto L25;
        Function4 r12 = new d();
    L27:
        if ((r28 & 1024) != 0) goto L31;
        r6 = r25;
    L31:
        if ((r28 & 2048) == 0) goto L33;
        boolean r13 = true;
    L35:
        if ((r28 & 4096) != 0) goto L38;
        r10 = r27;
    L38:
        Intrinsics.checkNotNullParameter(r16, "eventParams");
        Intrinsics.checkNotNullParameter(r17, "videoPlayData");
        Intrinsics.checkNotNullParameter(r19, "videoEngineKey");
        Intrinsics.checkNotNullParameter(r11, "onVideoExtendShownBlk");
        Intrinsics.checkNotNullParameter(r12, "toVideoExtendBlk");
        this.a = r5;
        this.b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r12;
        this.k = r6;
        this.l = r13;
        this.m = r10;
        return;
    L33:
        r13 = r26;
        goto L35
    L25:
        r12 = r24;
        goto L27
    L21:
        r11 = r23;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r8 = r21;
        goto L14
    L9:
        r7 = r20;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }
}
