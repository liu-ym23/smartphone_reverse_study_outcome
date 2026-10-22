package p2a;

import com.larus.voice_setting.UgcVoiceRecommendScene;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final String f;
    public final UgcVoiceRecommendScene g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "UgcVoiceMatchRequest(botName=" + this.a + ", botDesc=" + this.b + ", voiceId=" + this.c + ", botId=" + this.d + ", botModelType=" + this.e + ", languageCode=" + this.f + ", scene=" + this.g + ')';
    }

    public k() {
        this(NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, 0, NameKeys.UnloadStrategy_No_Strategy, UgcVoiceRecommendScene.NULL);
    }

    public k(String r2, String r3, String r4, String r5, long r6, String r8, UgcVoiceRecommendScene r9) {
        Intrinsics.checkNotNullParameter(r2, "botName");
        Intrinsics.checkNotNullParameter(r3, "botDesc");
        Intrinsics.checkNotNullParameter(r4, "voiceId");
        Intrinsics.checkNotNullParameter(r5, "botId");
        Intrinsics.checkNotNullParameter(r8, "languageCode");
        Intrinsics.checkNotNullParameter(r9, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
    }
}
