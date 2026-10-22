package tub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final RecordingPriorityScene a;
    public final String b;
    public final b c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        return "RecordingSceneInstance(scene=" + this.a + ", sceneInstanceId=" + this.b + ", priorityContext=" + this.c + ')';
    }

    public d(String r3, b r4) {
        Intrinsics.checkNotNullParameter(null, "scene");
        Intrinsics.checkNotNullParameter(r3, "sceneInstanceId");
        Intrinsics.checkNotNullParameter(r4, "priorityContext");
        this.a = null;
        this.b = r3;
        this.c = r4;
    }
}
