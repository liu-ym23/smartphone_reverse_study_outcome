package po1;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final byte[] a = null;
    public static final Pattern b = null;

    static {
        a = new byte[4096];
        b = PatternProtector.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");
    }
}
