package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class e {
    public static io.noties.a.h.a a(io.noties.a.h r7) {
        io.noties.a.h.a r8 = io.noties.a.f.b(io.noties.a.f.a(r7, "c"), "cpp", new io.noties.a.h.f[]{io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:alignas|alignof|asm|auto|bool|break|case|catch|char|char16_t|char32_t|class|compl|const|constexpr|const_cast|continue|decltype|default|delete|do|double|dynamic_cast|else|enum|explicit|export|extern|float|for|friend|goto|if|inline|int|int8_t|int16_t|int32_t|int64_t|uint8_t|uint16_t|uint32_t|uint64_t|long|mutable|namespace|new|noexcept|nullptr|operator|private|protected|public|register|reinterpret_cast|return|short|signed|sizeof|static|static_assert|static_cast|struct|switch|template|this|thread_local|throw|try|typedef|typeid|typename|union|unsigned|using|virtual|void|volatile|wchar_t|while)\\b"))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("--?|\\+\\+?|!=?|<{1,2}=?|>{1,2}=?|->|:{1,2}|={1,2}|\\^|~|%|&{1,2}|\\|\\|?|\\?|\\*|\\/|\\b(?:and|and_eq|bitand|bitor|not|not_eq|or|or_eq|xor|xor_eq)\\b"))})});
        io.noties.a.f.a(r8, "function", new io.noties.a.h.f[]{io.noties.a.h.a(TypedValues.Custom.S_BOOLEAN, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:true|false)\\b"))})});
        io.noties.a.f.a(r8, "keyword", new io.noties.a.h.f[]{io.noties.a.h.a("class-name", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(class\\s+)\\w+", 2), true)})});
        io.noties.a.f.a(r8, TypedValues.Custom.S_STRING, new io.noties.a.h.f[]{io.noties.a.h.a("raw-string", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("R\"([^()\\\\ ]{0,16})\\([\\s\\S]*?\\)\\1\""), false, true, TypedValues.Custom.S_STRING)})});
        return r8;
    }
}
