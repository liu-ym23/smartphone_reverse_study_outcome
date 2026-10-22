package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public abstract class g {
    public static io.noties.a.h.a a(io.noties.a.h r15) {
        io.noties.a.h.a r0 = io.noties.a.h.a("css", new io.noties.a.h.f[]{io.noties.a.h.a("comment", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\/\\*[\\s\\S]*?\\*\\/"))}), io.noties.a.h.a("atrule", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("@[\\w-]+?.*?(?:;|(?=\\s*\\{))", 2), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("rule", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("@[\\w-]+"))})}))}), io.noties.a.h.a("url", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("url\\((?:([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1|.*?)\\)", 2))}), io.noties.a.h.a("selector", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[^{}\\s][^{};]*?(?=\\s*\\{)"))}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\"|')(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)}), io.noties.a.h.a("property", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[-_a-z\\xA0-\\uFFFF][-\\w\\xA0-\\uFFFF]*(?=\\s*:)", 2))}), io.noties.a.h.a("important", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\B!important\\b", 2))}), io.noties.a.h.a("function", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[-a-z0-9]+(?=\\()", 2))}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[(){};:]"))})});
        io.noties.a.h.a r2 = io.noties.a.f.a((io.noties.a.h.f) ZeusTransformUtils.preCheckCast(r0.b().get(1), io.noties.a.h.f.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L10;
        Iterator<io.noties.a.h.f> r10 = r0.b().iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        io.noties.a.h.f r12 = (io.noties.a.h.f) ZeusTransformUtils.preCheckCast(r10.next(), io.noties.a.h.f.class, "com.obric.memorydata.plugin");
        if ("atrule".equals(r12.a()) == true) goto L6;
        r2.b().add(r12);
    L10:
        io.noties.a.h.a r16 = r15.a("markup");
        if (r16 == null) goto L19;
        io.noties.a.f.a(r16, LocationMonitorConst.TAG, new io.noties.a.h.f[]{io.noties.a.h.a("style", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(<style[\\s\\S]*?>)[\\s\\S]*?(?=<\\/style>)", 2), true, true, "language-css", r0)})});
        io.noties.a.h.f r3 = io.noties.a.f.a(r16, LocationMonitorConst.TAG);
        if (r3 == null) goto L17;
        io.noties.a.h.a r4 = io.noties.a.f.a(r3);
        if (r4 == null) goto L18;
        r4 = io.noties.a.f.a(r4);
    L18:
        io.noties.a.f.a(r16, "tag/attr-value", new io.noties.a.h.f[]{io.noties.a.h.a("style-attr", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\s*style=(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1", 2), false, false, "language-css", io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("attr-name", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^\\s*style", 2), false, false, null, r4)}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^\\s*=\\s*['\"]|['\"]\\s*$"))}), io.noties.a.h.a("attr-value", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile(".+", 2), false, false, null, r0)})}))})});
        goto L19
    L17:
        r4 = null;
    L19:
        return r0;
    }
}
