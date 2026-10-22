package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class r {
    public static io.noties.a.h.a a(io.noties.a.h r8) {
        return io.noties.a.h.a("makefile", new io.noties.a.h.f[]{io.noties.a.h.a("comment", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^\\\\])#(?:\\\\(?:\\r\\n|[\\s\\S])|[^\\\\\\r\\n])*"), true)}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)}), io.noties.a.h.a("builtin", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\.[A-Z][^:#=\\s]+(?=\\s*:(?!=))"))}), io.noties.a.h.a("symbol", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^[^:=\\r\\n]+(?=\\s*:(?!=))", 8), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("variable", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\$+(?:[^(){}:#=\\s]+|(?=[({]))"))})}))}), io.noties.a.h.a("variable", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\$+(?:[^(){}:#=\\s]+|\\([@*%<^+?][DF]\\)|(?=[({]))"))}), io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("-include\\b|\\b(?:define|else|endef|endif|export|ifn?def|ifn?eq|include|override|private|sinclude|undefine|unexport|vpath)\\b")), io.noties.a.h.a(Pattern.compile("(\\()(?:addsuffix|abspath|and|basename|call|dir|error|eval|file|filter(?:-out)?|findstring|firstword|flavor|foreach|guile|if|info|join|lastword|load|notdir|or|origin|patsubst|realpath|shell|sort|strip|subst|suffix|value|warning|wildcard|word(?:s|list)?)(?=[ \\t])"), true)}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(?:::|[?:+!])?=|[|@]"))}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[:;(){}]"))})});
    }
}
