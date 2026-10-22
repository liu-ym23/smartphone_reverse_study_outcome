package vr9;

import android.content.Context;
import com.larus.podcast.api.PodcastClickSource;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final Context a;
    public final CoroutineScope b;
    public final String c;
    public final String d;
    public final boolean e;
    public final PodcastClickSource f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        CoroutineScope r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        int r9 = (r7 + r2) * 31;
        if (this.e == false) goto L17;
        int r10 = 1231;
    L19:
        return ((r9 + r10) * 31) + this.f.hashCode();
    L17:
        r10 = 1237;
        goto L19
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PodcastGenerateContext(context=" + this.a + ", scope=" + this.b + ", messageId=" + this.c + ", conversationId=" + this.d + ", needFullscreenPlayer=" + this.e + ", clickSource=" + this.f + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r2, CoroutineScope r3, String r4, String r5, PodcastClickSource r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "clickSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = false;
        this.f = r6;
    }
}
