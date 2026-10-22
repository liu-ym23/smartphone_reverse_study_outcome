package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class s {
    public static io.noties.a.h.a a(io.noties.a.h r18) {
        io.noties.a.h.a r0 = io.noties.a.f.b(io.noties.a.f.a(r18, "markup"), "markdown", new io.noties.a.h.f[0]);
        io.noties.a.h.f r3 = io.noties.a.h.a("bold", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^\\\\])(\\*\\*|__)(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2"), true, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^\\*\\*|^__|\\*\\*$|__$"))})}))});
        io.noties.a.h.f r4 = io.noties.a.h.a("italic", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^\\\\])([*_])(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2"), true, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^[*_]|[*_]$"))})}))});
        io.noties.a.h.f r5 = io.noties.a.h.a("url", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("!?\\[[^\\]]+\\](?:\\([^\\s)]+(?:[\\t ]+\"(?:\\\\.|[^\"\\\\])*\")?\\)| ?\\[[^\\]\\n]*\\])"), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("variable", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(!?\\[)[^\\]]+(?=\\]$)"), true)}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\"(?:\\\\.|[^\"\\\\])*\"(?=\\)$)"))})}))});
        io.noties.a.f.a(r0, "prolog", new io.noties.a.h.f[]{io.noties.a.h.a("blockquote", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^>(?:[\\t ]*>)*", 8))}), io.noties.a.h.a("code", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^(?: {4}|\\t).+", 8), false, false, "keyword"), io.noties.a.h.a(Pattern.compile("``.+?``|`[^`\\n]+`"), false, false, "keyword")}), io.noties.a.h.a("title", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\w+.*(?:\\r?\\n|\\r)(?:==+|--+)"), false, false, "important", io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("==+$|--+$"))})})), io.noties.a.h.a(Pattern.compile("(^\\s*)#+.+", 8), true, false, "important", io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^#+|#+$"))})}))}), io.noties.a.h.a("hr", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^\\s*)([*-])(?:[\\t ]*\\2){2,}(?=\\s*$)", 8), true, false, "punctuation")}), io.noties.a.h.a(Constants.KEY_LIST, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^\\s*)(?:[*+-]|\\d+\\.)(?=[\\t ].)", 8), true, false, "punctuation")}), io.noties.a.h.a("url-reference", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("!?\\[[^\\]]+\\]:[\\t ]+(?:\\S+|<(?:\\\\.|[^>\\\\])+>)(?:[\\t ]+(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|\\((?:\\\\.|[^)\\\\])*\\)))?"), false, false, "url", io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("variable", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^(!?\\[)[^\\]]+"), true)}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|\\((?:\\\\.|[^)\\\\])*\\))$"))}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^[\\[\\]!:]|[<>]"))})}))}), r3, r4, r5});
        a(io.noties.a.f.a(r3), r5, r4);
        a(io.noties.a.f.a(r4), r5, r3);
        return r0;
    }

    private static void a(io.noties.a.h.a r2, io.noties.a.h.f r3, io.noties.a.h.f r4) {
        io.noties.a.h.a r5 = (io.noties.a.h.a) ZeusTransformUtils.wrapperContextForParams(r2, io.noties.a.h.a.class, "com.obric.memorydata.plugin");
        io.noties.a.h.f r6 = (io.noties.a.h.f) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.a.h.f.class, "com.obric.memorydata.plugin");
        io.noties.a.h.f r7 = (io.noties.a.h.f) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.a.h.f.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        r5.b().add(r6);
        r5.b().add(r7);
        return;
    }
}
