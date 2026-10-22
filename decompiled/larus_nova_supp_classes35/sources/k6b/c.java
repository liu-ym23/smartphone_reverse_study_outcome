package k6b;

import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final String a(String r4, String r5, Long r6) {
        String r7 = r4 + r5 + UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG.getValue();
        if (r6 != null) goto L5;
        return r7;
    L5:
        if (r6.longValue() > 0) goto L7;
        return r7;
    L7:
        return r7 + '_' + r6;
    }
}
