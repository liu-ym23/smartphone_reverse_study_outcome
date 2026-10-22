package com.ss.android.lark.conditional.access.display;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k {
    public static final Pattern a = null;

    static {
        a = PatternProtector.compile("(?i)https?://[A-Za-z0-9\\-._~:/?#\\[\\]@!$&'()*+,;=%]+");
    }
}
