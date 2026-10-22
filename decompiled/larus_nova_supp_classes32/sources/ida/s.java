package ida;

import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewAudioTranscriptCode;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MemoryReviewAudioTranscriptCode.values().length];
            r0[MemoryReviewAudioTranscriptCode.EMPTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemoryReviewAudioTranscriptCode.OK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static String a(String r9, com.obric.assistant.cocreationreview.modules.memory.a r10) {
        Intrinsics.checkNotNullParameter(r9, "recordId");
        Intrinsics.checkNotNullParameter(r10, "bridge");
        if (StringsKt.isBlank(r9) == false) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        LinkedHashSet r2 = new LinkedHashSet();
        int r3 = 0;
        String r4 = null;
    L7:
        if (r3 >= 32) goto L48;
        hda.a r5 = r10.e(r9, r4);
        int r6 = a.a[r5.a.ordinal()];
        if (r6 == 1) goto L34;
        if (r6 != 2) goto L12;
        r0.append(r5.b);
        if (r5.d == false) goto L15;
        String r7 = r5.c;
        if (r7 == null) goto L33;
        if ((!StringsKt.isBlank(r7)) == true) goto L25;
        r7 = null;
    L25:
        if (r7 == null) goto L33;
        if (Intrinsics.areEqual(r7, r4) == true) goto L33;
        if (r2.add(r7) == false) goto L33;
        r3 = r3 + 1;
        r4 = r7;
    L33:
        return null;
    L15:
        String r11 = r0.toString();
        if ((!StringsKt.isBlank(r11)) == true) goto L18;
        return null;
    L18:
        return r11;
    L12:
        return null;
    L34:
        String r12 = r0.toString();
        if ((!StringsKt.isBlank(r12)) == true) goto L37;
        return null;
    L37:
        return r12;
    L48:
        return null;
    }
}
