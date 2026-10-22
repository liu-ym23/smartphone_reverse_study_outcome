package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class n {
    public static io.noties.a.h.a a(io.noties.a.h r12) {
        io.noties.a.h.a r0 = io.noties.a.f.b(io.noties.a.f.a(r12, "clike"), "javascript", new io.noties.a.h.f[]{io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:as|async|await|break|case|catch|class|const|continue|debugger|default|delete|do|else|enum|export|extends|finally|for|from|function|get|if|implements|import|in|instanceof|interface|let|new|null|of|package|private|protected|public|return|set|static|super|switch|this|throw|try|typeof|var|void|while|with|yield)\\b"))}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:0[xX][\\dA-Fa-f]+|0[bB][01]+|0[oO][0-7]+|NaN|Infinity)\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))}), io.noties.a.h.a("function", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*(?=\\s*\\()", 2))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("-[-=]?|\\+[+=]?|!=?=?|<<?=?|>>?>?=?|=(?:==?|>)?|&[&=]?|\\|[|=]?|\\*\\*?=?|\\/=?|~|\\^=?|%=?|\\?|\\.{3}"))})});
        io.noties.a.f.a(r0, "keyword", new io.noties.a.h.f[]{io.noties.a.h.a("regex", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("((?:^|[^$\\w\\xA0-\\uFFFF.\"'\\])\\s])\\s*)\\/(\\[[^\\]\\r\\n]+]|\\\\.|[^/\\\\\\[\\r\\n])+\\/[gimyu]{0,5}(?=\\s*($|[\\r\\n,.;})\\]]))"), true, true)}), io.noties.a.h.a("function-variable", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*(?=\\s*=\\s*(?:function\\b|(?:\\([^()]*\\)|[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*)\\s*=>))", 2), false, false, "function")}), io.noties.a.h.a("constant", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b[A-Z][A-Z\\d_]*\\b"))})});
        io.noties.a.h.f r1 = io.noties.a.h.a("interpolation", new io.noties.a.h.c[0]);
        io.noties.a.f.a(r0, TypedValues.Custom.S_STRING, new io.noties.a.h.f[]{io.noties.a.h.a("template-string", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("`(?:\\\\[\\s\\S]|\\$\\{[^}]+\\}|[^\\\\`])*`"), false, true, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{r1, io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[\\s\\S]+"))})}))})});
        ArrayList r3 = new ArrayList(r0.b().size() + 1);
        r3.add(io.noties.a.h.a("interpolation-punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^\\$\\{|\\}$"), false, false, "punctuation")}));
        r3.addAll(r0.b());
        r1.b().add(io.noties.a.h.a(Pattern.compile("\\$\\{[^}]+\\}"), false, false, null, io.noties.a.h.a("inside", r3)));
        io.noties.a.h.a r13 = r12.a("markup");
        if (r13 == null) goto L5;
        io.noties.a.f.a(r13, LocationMonitorConst.TAG, new io.noties.a.h.f[]{io.noties.a.h.a("script", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(<script[\\s\\S]*?>)[\\s\\S]*?(?=<\\/script>)", 2), true, true, "language-javascript", r0)})});
    L5:
        return r0;
    }
}
