package hq9;

import androidx.fragment.app.Fragment;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumSettingConfig;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 {
    public final WeakReference<Fragment> a;
    public final Function1<xp9.i, Unit> b;
    public final Function1<xp9.i, Unit> c;
    public final AlbumSettingConfig d;
    public final String e;
    public final Function0<Unit> f;
    public final int g;
    public final kq9.e h;
    public final Function0<Unit> i;
    public final Function0<Unit> j;
    public final boolean k;
    public final MediaPickerUIMode l;
    public final com.larus.platform.api.b0 m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;

    public b0() {
        this(null, null, null, null, 0, null, null, null, null, null, 131071);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
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
        if (this.g == r6.g) goto L30;
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
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        WeakReference<Fragment> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Function1<xp9.i, Unit> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Function1<xp9.i, Unit> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        AlbumSettingConfig r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.e.hashCode()) * 31;
        Function0<Unit> r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((r12 + r14) * 31) + this.g) * 31;
        kq9.e r16 = this.h;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Function0<Unit> r19 = this.i;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Function0<Unit> r22 = this.j;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        int r25 = 1231;
        if (this.k == false) goto L37;
        int r26 = 1231;
    L38:
        int r27 = (((r24 + r26) * 31) + this.l.hashCode()) * 31;
        com.larus.platform.api.b0 r28 = this.m;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        int r29 = (r27 + r1) * 31;
        if (this.n == false) goto L45;
        int r30 = 1231;
    L46:
        int r31 = (r29 + r30) * 31;
        if (this.o == false) goto L49;
        int r32 = 1231;
    L50:
        int r33 = (r31 + r32) * 31;
        if (this.p == false) goto L53;
        int r34 = 1231;
    L54:
        int r35 = (r33 + r34) * 31;
        if (this.q == true) goto L59;
        r25 = 1237;
    L59:
        return r35 + r25;
    L53:
        r34 = 1237;
        goto L54
    L49:
        r32 = 1237;
        goto L50
    L45:
        r30 = 1237;
        goto L46
    L37:
        r26 = 1237;
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
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
        return "BottomPhotoPickerPageConfig(quickAlbumInputHost=" + this.a + ", resultCallback=" + this.b + ", multiResultCallback=" + this.c + ", albumSettingConfig=" + this.d + ", displayType=" + this.e + ", guideCallback=" + this.f + ", bottomPeekHeight=" + this.g + ", traceInfo=" + this.h + ", dismissCallback=" + this.i + ", backCallback=" + this.j + ", needEnterInAnimation=" + this.k + ", pageMode=" + this.l + ", pageSlideCallback=" + this.m + ", isImmerseStyle=" + this.n + ", forceDayMode=" + this.o + ", useBottomPhotoPickerFragmentV3=" + this.p + ", enableEmbeddedTouchIntercept=" + this.q + ')';
    }

    public /* synthetic */ b0(Function1 r20, AlbumSettingConfig r21, String r22, Function0 r23, int r24, kq9.e r25, Function0 r26, Function0 r27, MediaPickerUIMode r28, com.larus.platform.api.b0 r29, int r30) {
        if ((r30 & 2) == 0) goto L5;
        Function1 r2 = null;
    L7:
        if ((r30 & 8) == 0) goto L9;
        AlbumSettingConfig r5 = null;
    L11:
        if ((r30 & 16) == 0) goto L13;
        String r6 = "album_display";
    L15:
        if ((r30 & 32) == 0) goto L17;
        Function0 r7 = null;
    L19:
        if ((r30 & 64) == 0) goto L21;
        int r8 = 0;
    L23:
        if ((r30 & 128) == 0) goto L25;
        kq9.e r9 = null;
    L27:
        if ((r30 & 256) == 0) goto L29;
        Function0 r10 = null;
    L31:
        if ((r30 & 512) == 0) goto L33;
        Function0 r11 = null;
    L35:
        if ((r30 & 2048) == 0) goto L37;
        MediaPickerUIMode r13 = MediaPickerUIMode.NORMAL;
    L39:
        if ((r30 & 4096) == 0) goto L41;
        com.larus.platform.api.b0 r14 = null;
    L42:
        this(null, r2, null, r5, r6, r7, r8, r9, r10, r11, false, r13, r14, false, false, false, false);
        return;
    L41:
        r14 = r29;
        goto L42
    L37:
        r13 = r28;
        goto L39
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r5 = r21;
        goto L11
    L5:
        r2 = r20;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(WeakReference<Fragment> r5, Function1<? super xp9.i, Unit> r6, Function1<? super xp9.i, Unit> r7, AlbumSettingConfig r8, String r9, Function0<Unit> r10, int r11, kq9.e r12, Function0<Unit> r13, Function0<Unit> r14, boolean r15, MediaPickerUIMode r16, com.larus.platform.api.b0 r17, boolean r18, boolean r19, boolean r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r9, "displayType");
        Intrinsics.checkNotNullParameter(r16, "pageMode");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
        this.o = r19;
        this.p = r20;
        this.q = r21;
    }
}
