package lq8;

import com.larus.bmhome.interactionpanel.InteractionPanelSource;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final InteractionPanelSource a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "InteractionPanelSourceId(source=" + this.a + ", conversationId=" + this.b + ", threadId=" + this.c + ')';
    }

    public c(InteractionPanelSource r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "threadId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
