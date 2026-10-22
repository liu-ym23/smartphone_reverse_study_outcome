package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final Message a;
    public final AudioContent b;
    public final String c;
    public final String d;
    public int e;

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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AudioContent r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((((r3 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioMsgInfo(audioMessage=" + this.a + ", audioContent=" + this.b + ", audioFileName=" + this.c + ", audioCid=" + this.d + ", audioDuration=" + this.e + ')';
    }

    public b(Message r2, AudioContent r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "audioFileName");
        Intrinsics.checkNotNullParameter(r5, "audioCid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = 0;
    }
}
