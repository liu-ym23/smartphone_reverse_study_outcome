package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.ss.android.lark.chat.entity.message.Message;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final Message a;
    public final int b;
    public final String c;
    public final ByteBuffer d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        String r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((r3 + r1) * 31) + this.d.hashCode()) * 31;
        int r6 = 1231;
        if (this.e == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r5 + r7) * 31;
        if (this.f == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.g == true) goto L23;
        r6 = 1237;
    L23:
        return r10 + r6;
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioRecordData(message=" + this.a + ", sequenceId=" + this.b + ", uploadId=" + this.c + ", data=" + this.d + ", isFinish=" + this.e + ", needUploadAudioData=" + this.f + ", isNeedUsePush=" + this.g + ')';
    }

    public /* synthetic */ c(Message r9, int r10, String r11, ByteBuffer r12, boolean r13, boolean r14) {
        this(r9, r10, r11, r12, r13, false, r14);
    }

    public c(Message r2, int r3, String r4, ByteBuffer r5, boolean r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
