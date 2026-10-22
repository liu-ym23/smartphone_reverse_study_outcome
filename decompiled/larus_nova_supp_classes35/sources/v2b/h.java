package v2b;

import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public static final char[] a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichTextElement.RichTextTag.values().length];
            r0[RichTextElement.RichTextTag.AT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RichTextElement.RichTextTag.TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new char[]{1847, 1846};
    }

    public static String a(String r4) {
        char[] r0 = a;
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L7;
        r4 = new Regex(String.valueOf(r0[r1])).replace(r4, BuildConfig.FLAVOR);
        r1 = r1 + 1;
        goto L4
    L7:
        return r4.toString();
    }
}
