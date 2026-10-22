package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class JdkPattern extends e implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    private static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matcher f4284a;

        a(Matcher r3) {
            this.f4284a = (Matcher) ZeusTransformUtils.preCheckCast(n.a(r3), Matcher.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.d
        public boolean a() {
            return this.f4284a.find();
        }
    }

    JdkPattern(Pattern r3) {
        this.pattern = (Pattern) ZeusTransformUtils.preCheckCast(n.a(r3), Pattern.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.base.e
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.e
    public d matcher(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return new a(this.pattern.matcher(r4));
    }

    @Override // com.google.common.base.e
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // com.google.common.base.e
    public String toString() {
        return this.pattern.toString();
    }
}
