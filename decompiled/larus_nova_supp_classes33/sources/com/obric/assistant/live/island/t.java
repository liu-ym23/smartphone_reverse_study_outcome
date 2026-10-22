package com.obric.assistant.live.island;

import android.app.PendingIntent;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.livecard.api.DefaultIslandCardCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t {
    public final PendingIntent a;
    public final JsonObject b;
    public final DefaultIslandCardCallback c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        DefaultIslandCardCallback r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "SessionBehavior(intent=" + this.a + ", ext=" + this.b + ", callback=" + this.c + ')';
    }

    public t(PendingIntent r2, JsonObject r3, DefaultIslandCardCallback r4) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r3, "ext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
