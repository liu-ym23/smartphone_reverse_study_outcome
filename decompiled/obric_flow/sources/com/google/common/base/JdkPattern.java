package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class JdkPattern extends j implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    public JdkPattern(Pattern r5) {
        r5.getClass();
        this.pattern = r5;
    }

    @Override // com.google.common.base.j
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.j
    public i matcher(CharSequence r5) {
        return new s(this.pattern.matcher(r5));
    }

    @Override // com.google.common.base.j
    public String pattern() {
        return this.pattern.pattern();
    }

    public String toString() {
        return this.pattern.toString();
    }
}
