package io.noties.a.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class h {
    public static io.noties.a.h.a a(io.noties.a.h r11) {
        io.noties.a.h.a r12 = r11.a("css");
        if (r12 == null) goto L8;
        io.noties.a.h.f r1 = io.noties.a.f.a(r12, "selector");
        if (r1 == null) goto L7;
        io.noties.a.h.c r6 = io.noties.a.h.a(Pattern.compile("[^{}\\s][^{}]*(?=\\s*\\{)"), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("pseudo-element", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile(":(?:after|before|first-letter|first-line|selection)|::[-\\w]+"))}), io.noties.a.h.a("pseudo-class", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile(":[-\\w]+(?:\\(.*\\))?"))}), io.noties.a.h.a("class", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\.[-:.\\w]+"))}), io.noties.a.h.a(OaidModel.KEY_ID, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("#[-:.\\w]+"))}), io.noties.a.h.a("attribute", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\[[^\\]]+\\]"))})}));
        r1.b().clear();
        r1.b().add(r6);
    L7:
        io.noties.a.f.a(r12, "function", new io.noties.a.h.f[]{io.noties.a.h.a("hexcode", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("#[\\da-f]{3,8}", 2))}), io.noties.a.h.a("entity", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\\\[\\da-f]{1,8}", 2))}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[\\d%.]+"))})});
    L8:
        return null;
    }
}
