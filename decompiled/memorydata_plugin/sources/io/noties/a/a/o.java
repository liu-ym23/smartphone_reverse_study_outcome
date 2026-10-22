package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class o {
    public static io.noties.a.h.a a(io.noties.a.h r5) {
        return io.noties.a.h.a("json", new io.noties.a.h.f[]{io.noties.a.h.a("property", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?=\\s*:)", 2))}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?!\\s*:)"), false, true)}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[{}\\[\\]);,]"))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile(ParameterizedMessage.ERROR_MSG_SEPARATOR))}), io.noties.a.h.a(TypedValues.Custom.S_BOOLEAN, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:true|false)\\b", 2))}), io.noties.a.h.a("null", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\bnull\\b", 2))})});
    }
}
