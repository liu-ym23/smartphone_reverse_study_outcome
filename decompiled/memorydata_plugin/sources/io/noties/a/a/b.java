package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static io.noties.a.h.a a(io.noties.a.h r10) {
        io.noties.a.h.a r11 = io.noties.a.f.a(io.noties.a.f.a(r10, "clike"), "c", new AnonymousClass1(), new io.noties.a.h.f[]{io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:_Alignas|_Alignof|_Atomic|_Bool|_Complex|_Generic|_Imaginary|_Noreturn|_Static_assert|_Thread_local|asm|typeof|inline|auto|break|case|char|const|continue|default|do|double|else|enum|extern|float|for|goto|if|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|union|unsigned|void|volatile|while)\\b"))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("-[>-]?|\\+\\+?|!=?|<<?=?|>>?=?|==?|&&?|\\|\\|?|[~^%?*\\/]"))}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(?:\\b0x[\\da-f]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?)[ful]*", 2))})});
        io.noties.a.f.a(r11, TypedValues.Custom.S_STRING, new io.noties.a.h.f[]{io.noties.a.h.a("macro", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^\\s*)#\\s*[a-z]+(?:[^\\r\\n\\\\]|\\\\(?:\\r\\n|[\\s\\S]))*", 10), true, false, "property", io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(#\\s*include\\s*)(?:<.+?>|(\"|')(?:\\\\?.)+?\\2)"), true)}), io.noties.a.h.a("directive", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(#\\s*)\\b(?:define|defined|elif|else|endif|error|ifdef|ifndef|if|import|include|line|pragma|undef|using)\\b"), true, false, "keyword")})}))}), io.noties.a.h.a("constant", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:__FILE__|__LINE__|__DATE__|__TIME__|__TIMESTAMP__|__func__|EOF|NULL|SEEK_CUR|SEEK_END|SEEK_SET|stdin|stdout|stderr)\\b"))})});
        return r11;
    }
}
