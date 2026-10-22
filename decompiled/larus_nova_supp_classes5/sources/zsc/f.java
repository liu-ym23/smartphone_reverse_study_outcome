package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f extends i {
    public static final Pattern e = null;

    @Override // zsc.i
    public final char d() {
        return '&';
    }

    static {
        e = PatternProtector.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    }

    @Override // zsc.i
    public final uvc.b b() {
        String r0 = a(e);
        if (r0 != null) goto L5;
        return null;
    L5:
        return f(tvc.b.a(r0));
    }

    public f() {
    }
}
