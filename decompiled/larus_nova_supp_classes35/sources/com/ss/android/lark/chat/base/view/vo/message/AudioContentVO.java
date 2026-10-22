package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.AudioContent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AudioContentVO extends f<AudioContent> {
    public e h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public AudioContent.a s;
    public String t;
    public int u;
    public byte[] v;
    public boolean w;
    public List<String> x;
    public List<String> y;

    public final long f() {
        return ((Number) this.q.getValue()).longValue();
    }

    public final int g() {
        return ((Number) this.k.getValue()).intValue();
    }

    public final String h() {
        return (String) this.i.getValue();
    }

    public final String i() {
        return (String) this.m.getValue();
    }

    public final boolean j() {
        return ((Boolean) this.r.getValue()).booleanValue();
    }

    public final boolean k() {
        return ((Boolean) this.l.getValue()).booleanValue();
    }

    public final boolean l() {
        return ((Boolean) this.p.getValue()).booleanValue();
    }

    public AudioContentVO(final AudioContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.i = LazyKt.lazy(new AudioContentVO$key$2(r2));
        this.j = LazyKt.lazy(new AudioContentVO$size$2(r2));
        this.k = LazyKt.lazy(new AudioContentVO$duration$2(r2));
        this.l = LazyKt.lazy(new AudioContentVO$isNeedHideText$2(r2));
        this.m = LazyKt.lazy(new AudioContentVO$recognizedText$2(r2));
        this.n = LazyKt.lazy(new AudioContentVO$recognizedRichText$2(r2));
        this.o = LazyKt.lazy(new AudioContentVO$copyText$2(r2));
        this.p = LazyKt.lazy(new AudioContentVO$isRecognizeFinished$2(r2));
        this.q = LazyKt.lazy(new AudioContentVO$audio2TextStartTime$2(r2));
        this.r = LazyKt.lazy(new AudioContentVO$isAudioWithText$2(r2));
        this.s = r2.getFileState();
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r7) {
        if (super.d(r7) == true) goto L6;
        return false;
    L6:
        if ((r7 instanceof AudioContentVO) == false) goto L37;
        AudioContentVO r8 = (AudioContentVO) r7;
        if (y28.a.a(h(), r8.h()) == true) goto L10;
        return false;
    L10:
        if (((Number) this.j.getValue()).longValue() == ((Number) r8.j.getValue()).longValue()) goto L12;
        return false;
    L12:
        if (g() == r8.g()) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.s, r8.s) == true) goto L16;
        return false;
    L16:
        if (k() == r8.k()) goto L18;
        return false;
    L18:
        if (y28.a.a(i(), r8.i()) == true) goto L20;
        return false;
    L20:
        if (l() == r8.l()) goto L22;
        return false;
    L22:
        if (f() == r8.f()) goto L24;
        return false;
    L24:
        if (j() == r8.j()) goto L26;
        return false;
    L26:
        if (this.w == r8.w) goto L28;
        return false;
    L28:
        if (this.u == r8.u) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.t, r8.t) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.x, r8.x) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.y, r8.y) == false) goto L51;
        return true;
    L51:
        return false;
    L37:
        return false;
    }
}
