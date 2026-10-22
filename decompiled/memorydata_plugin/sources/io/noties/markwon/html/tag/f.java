package io.noties.markwon.html.tag;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class f implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.html.c f16618a;

    public f(io.noties.markwon.html.c r1) {
        this.f16618a = r1;
    }

    io.noties.markwon.a.h.a a(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        int r5 = r6.length();
        int r1 = r5 - 1;
        int r2 = r1;
    L7:
        if (r2 <= (-1)) goto L19;
        if (Character.isDigit(r6.charAt(r2)) == true) goto L10;
        r2 = r2 - 1;
        goto L7
    L10:
        int r4 = r2 + 1;
        float r3 = Float.parseFloat(r6.substring(0, r4));     // Catch: NumberFormatException -> L17
        if (r2 != r1) goto L14;
        String r7 = null;
    L15:
        return new io.noties.markwon.a.h.a(r3, r7);
    L14:
        r7 = r6.substring(r4, r5);     // Catch: NumberFormatException -> L17
    L17:
        return null;
    L19:
        return null;
    }

    @Override // io.noties.markwon.html.tag.e.a
    public io.noties.markwon.a.h a(Map<String, String> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.get("style"), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r0) == true) goto L16;
        Iterator<io.noties.markwon.html.d> r1 = this.f16618a.a(r0).iterator();
        io.noties.markwon.a.h.a r2 = null;
        io.noties.markwon.a.h.a r6 = null;
    L6:
        if (r1.hasNext() == false) goto L17;
        io.noties.markwon.html.d r7 = (io.noties.markwon.html.d) ZeusTransformUtils.preCheckCast(r1.next(), io.noties.markwon.html.d.class, "com.obric.memorydata.plugin");
        String r8 = r7.a();
        if ("width".equals(r8) == false) goto L11;
        r2 = a(r7.b());
    L13:
        if (r2 == null) goto L6;
        if (r6 == null) goto L6;
    L11:
        if ("height".equals(r8) == false) goto L13;
        r6 = a(r7.b());
    L17:
        if (r2 == null) goto L21;
        if (r6 == null) goto L21;
        return new io.noties.markwon.a.h(r2, r6);
    L21:
        if (r2 != null) goto L23;
        r2 = a((String) ZeusTransformUtils.preCheckCast(r12.get("width"), String.class, "com.obric.memorydata.plugin"));
    L23:
        if (r6 != null) goto L25;
        r6 = a((String) ZeusTransformUtils.preCheckCast(r12.get("height"), String.class, "com.obric.memorydata.plugin"));
    L25:
        if (r2 != null) goto L29;
        if (r6 != null) goto L29;
        return null;
    L29:
        return new io.noties.markwon.a.h(r2, r6);
    L16:
        r2 = null;
        r6 = null;
        goto L17
    }
}
