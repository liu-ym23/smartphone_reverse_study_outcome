package lda;

import com.obric.assistant.cocreationreview.Vote;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Vote.values().length];
            r0[Vote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Vote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final String a(String r6) {
        String r7 = StringsKt.replace$default(r6, "\n", "\\n", false, 4, null);
        if (r7.length() > 48) goto L6;
        return r7;
    L6:
        return StringsKt.take(r7, 48) + "...";
    }
}
