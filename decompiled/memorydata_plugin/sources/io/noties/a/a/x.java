package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class x {
    public static io.noties.a.h.a a(io.noties.a.h r12) {
        io.noties.a.h.a r9 = null;
        io.noties.a.h.a r13 = io.noties.a.f.b(io.noties.a.f.a(r12, "clike"), "swift", new io.noties.a.h.f[]{io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\"|')(\\\\(?:\\((?:[^()]|\\([^)]+\\))+\\)|\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("interpolation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\\\\\((?:[^()]|\\([^)]+\\))+\\)"), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("delimiter", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^\\\\\\(|\\)$"), false, false, "variable")})}))})}))}), io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:as|associativity|break|case|catch|class|continue|convenience|default|defer|deinit|didSet|do|dynamic(?:Type)?|else|enum|extension|fallthrough|final|for|func|get|guard|if|import|in|infix|init|inout|internal|is|lazy|left|let|mutating|new|none|nonmutating|operator|optional|override|postfix|precedence|prefix|private|protocol|public|repeat|required|rethrows|return|right|safe|self|Self|set|static|struct|subscript|super|switch|throws?|try|Type|typealias|unowned|unsafe|var|weak|where|while|willSet|__(?:COLUMN__|FILE__|FUNCTION__|LINE__))\\b"))}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:[\\d_]+(?:\\.[\\de_]+)?|0x[a-f0-9_]+(?:\\.[a-f0-9p_]+)?|0b[01_]+|0o[0-7_]+)\\b", 2))})});
        List<io.noties.a.h.f> r0 = r13.b();
        r0.add(io.noties.a.h.a("constant", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:nil|[A-Z_]{2,}|k[A-Z][A-Za-z_]+)\\b"))}));
        r0.add(io.noties.a.h.a("atrule", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("@\\b(?:IB(?:Outlet|Designable|Action|Inspectable)|class_protocol|exported|noreturn|NS(?:Copying|Managed)|objc|UIApplicationMain|auto_closure)\\b"))}));
        r0.add(io.noties.a.h.a("builtin", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:[A-Z]\\S+|abs|advance|alignof(?:Value)?|assert|contains|count(?:Elements)?|debugPrint(?:ln)?|distance|drop(?:First|Last)|dump|enumerate|equal|filter|find|first|getVaList|indices|isEmpty|join|last|lexicographicalCompare|map|max(?:Element)?|min(?:Element)?|numericCast|overlaps|partition|print(?:ln)?|reduce|reflect|reverse|sizeof(?:Value)?|sort(?:ed)?|split|startsWith|stride(?:of(?:Value)?)?|suffix|swap|toDebugString|toString|transcode|underestimateCount|unsafeBitCast|with(?:ExtendedLifetime|Unsafe(?:MutablePointers?|Pointers?)|VaList))\\b"))}));
        io.noties.a.h.f r1 = io.noties.a.f.a(r13, "string/interpolation");
        if (r1 == null) goto L5;
        r9 = io.noties.a.f.a(r1);
    L5:
        if (r9 == null) goto L7;
        r9.b().addAll(r13.b());
    L7:
        return r13;
    }
}
