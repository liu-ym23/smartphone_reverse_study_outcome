package ir8;

import android.widget.FrameLayout;
import com.larus.bmhome.music.player.j;
import com.larus.bmhome.music.widget.LyricsToSongCardView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final j a;
    public final MusicCreationContent b;
    public final int c;
    public final boolean d;
    public final Message e;
    public final FrameLayout f;
    public final Function0<Unit> g;
    public final Function0<Boolean> h;
    public final Function1<LyricsToSongCardView.b, Unit> i;

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
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        Message r3 = this.e;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        FrameLayout r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Function0<Unit> r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Function0<Boolean> r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Function1<LyricsToSongCardView.b, Unit> r16 = this.i;
        if (r16 == null) goto L27;
        r4 = r16.hashCode();
    L27:
        return r15 + r4;
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
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MusicAppletDetailData(playerData=" + this.a + ", musicContent=" + this.b + ", initProgress=" + this.c + ", outPullingFinished=" + this.d + ", message=" + this.e + ", bindShareContainer=" + this.f + ", onSelfDismissed=" + this.g + ", onAppletBackgroundPlaybackHandoff=" + this.h + ", onMessageChangeListenerReady=" + this.i + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(j r2, MusicCreationContent r3, int r4, boolean r5, Message r6, FrameLayout r7, Function0<Unit> r8, Function0<Boolean> r9, Function1<? super LyricsToSongCardView.b, Unit> r10) {
        Intrinsics.checkNotNullParameter(r2, "playerData");
        Intrinsics.checkNotNullParameter(r3, "musicContent");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
