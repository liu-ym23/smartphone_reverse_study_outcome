package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes6.dex */
public class p {
    public static io.noties.a.h.a a(io.noties.a.h r11) {
        io.noties.a.h.a r12 = io.noties.a.f.a(io.noties.a.f.a(r11, "clike"), "kotlin", new AnonymousClass1(), new io.noties.a.h.f[]{io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^.])\\b(?:abstract|actual|annotation|as|break|by|catch|class|companion|const|constructor|continue|crossinline|data|do|dynamic|else|enum|expect|external|final|finally|for|fun|get|if|import|in|infix|init|inline|inner|interface|internal|is|lateinit|noinline|null|object|open|operator|out|override|package|private|protected|public|reified|return|sealed|set|super|suspend|tailrec|this|throw|to|try|typealias|val|var|vararg|when|where|while)\\b"), true)}), io.noties.a.h.a("function", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\w+(?=\\s*\\()")), io.noties.a.h.a(Pattern.compile("(\\.)\\w+(?=\\s*\\{)"), true)}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:0[xX][\\da-fA-F]+(?:_[\\da-fA-F]+)*|0[bB][01]+(?:_[01]+)*|\\d+(?:_\\d+)*(?:\\.\\d+(?:_\\d+)*)?(?:[eE][+-]?\\d+(?:_\\d+)*)?[fFL]?)\\b"))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\+[+=]?|-[-=>]?|==?=?|!(?:!|==?)?|[\\/*%<>]=?|[?:]:?|\\.\\.|&&|\\|\\||\\b(?:and|inv|or|shl|shr|ushr|xor)\\b"))})});
        io.noties.a.f.a(r12, TypedValues.Custom.S_STRING, new io.noties.a.h.f[]{io.noties.a.h.a("raw-string", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\"\"\"|''')[\\s\\S]*?\\1"), false, false, TypedValues.Custom.S_STRING)})});
        io.noties.a.f.a(r12, "keyword", new io.noties.a.h.f[]{io.noties.a.h.a("annotation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\B@(?:\\w+:)?(?:[A-Z]\\w*|\\[[^\\]]+\\])"), false, false, "builtin")})});
        io.noties.a.f.a(r12, "function", new io.noties.a.h.f[]{io.noties.a.h.a(AnnotatedPrivateKey.LABEL, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\w+@|@\\w+"), false, false, "symbol")})});
        ArrayList r0 = new ArrayList(r12.b().size() + 1);
        r0.add(io.noties.a.h.a("delimiter", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^\\$\\{|\\}$"), false, false, "variable")}));
        r0.addAll(r12.b());
        io.noties.a.h.a r1 = io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("interpolation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\$\\{[^}]+\\}"), false, false, null, io.noties.a.h.a("inside", r0)), io.noties.a.h.a(Pattern.compile("\\$\\w+"), false, false, "variable")})});
        io.noties.a.h.f r2 = io.noties.a.f.a(r12, TypedValues.Custom.S_STRING);
        io.noties.a.h.f r3 = io.noties.a.f.a(r12, "raw-string");
        if (r2 == null) goto L8;
        if (r3 == null) goto L8;
        io.noties.a.h.c r4 = (io.noties.a.h.c) ZeusTransformUtils.preCheckCast(r2.b().get(0), io.noties.a.h.c.class, "com.obric.memorydata.plugin");
        io.noties.a.h.c r5 = (io.noties.a.h.c) ZeusTransformUtils.preCheckCast(r3.b().get(0), io.noties.a.h.c.class, "com.obric.memorydata.plugin");
        r2.b().add(io.noties.a.h.a(r4.a(), r4.b(), r4.c(), r4.d(), r1));
        r3.b().add(io.noties.a.h.a(r5.a(), r5.b(), r5.c(), r5.d(), r1));
        r2.b().remove(0);
        r3.b().remove(0);
        return r12;
    L8:
        throw new RuntimeException("Unexpected state, cannot find `string` and/or `raw-string` tokens inside kotlin grammar");
    }
}
