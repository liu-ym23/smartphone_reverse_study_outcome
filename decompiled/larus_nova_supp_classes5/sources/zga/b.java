package zga;

import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public final String a;
    public final String b;
    public final ObricInteractionType c;
    public final String d;
    public final ForegroundInteractionPhase e;

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
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
        String r7 = this.d;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.e.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionProjection(botId=" + this.a + ", conversationId=" + this.b + ", currentInteractionType=" + this.c + ", currentModeSessionId=" + this.d + ", foregroundPhase=" + this.e + ')';
    }

    public final boolean b() {
        ForegroundInteractionPhase r0 = this.e;
        if (r0 != ForegroundInteractionPhase.Activate) goto L5;
    L10:
        return true;
    L5:
        if (r0 == ForegroundInteractionPhase.Connecting) goto L10;
        if (r0 == ForegroundInteractionPhase.Listen) goto L10;
        return false;
    }

    public static b a(b r6, ForegroundInteractionPhase r7) {
        String r1 = r6.a;
        String r2 = r6.b;
        ObricInteractionType r3 = r6.c;
        String r4 = r6.d;
        Intrinsics.checkNotNullParameter(r3, "currentInteractionType");
        Intrinsics.checkNotNullParameter(r7, "foregroundPhase");
        return new b(r1, r2, r3, r4, r7);
    }

    public b(String r2, String r3, ObricInteractionType r4, String r5, ForegroundInteractionPhase r6) {
        Intrinsics.checkNotNullParameter(r4, "currentInteractionType");
        Intrinsics.checkNotNullParameter(r6, "foregroundPhase");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
