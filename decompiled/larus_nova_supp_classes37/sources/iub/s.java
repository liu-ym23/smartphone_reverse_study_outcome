package iub;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s {
    public final String a;
    public final List<h> b;

    public s(String r2, List<h> r3) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r3, "subtitles");
        this.a = r2;
        this.b = r3;
    }
}
