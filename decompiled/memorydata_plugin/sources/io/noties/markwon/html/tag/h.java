package io.noties.markwon.html.tag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.html.o;
import io.noties.markwon.html.u;
import io.noties.markwon.q;
import io.noties.markwon.t;
import io.noties.markwon.w;
import io.noties.markwon.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.commonmark.node.ListItem;

/* JADX INFO: loaded from: classes6.dex */
public class h extends u {
    public h() {
    }

    private static int a(io.noties.markwon.html.j.a r3) {
        io.noties.markwon.html.j.a r4 = (io.noties.markwon.html.j.a) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.html.j.a.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        r4 = r4.i();
        if (r4 == null) goto L10;
        if ("ul".equals(r4.a()) == true) goto L9;
        if ("ol".equals(r4.a()) == false) goto L3;
    L9:
        r0 = r0 + 1;
        goto L3
    L10:
        return r0;
    }

    @Override // io.noties.markwon.html.u
    public void a(io.noties.markwon.n r12, o r13, io.noties.markwon.html.j r14) {
        io.noties.markwon.n r11 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r12, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r15 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r14, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        if (r15.g() == true) goto L5;
        return;
    L5:
        io.noties.markwon.html.j.a r16 = r15.h();
        boolean r17 = "ol".equals(r16.a());
        boolean r1 = "ul".equals(r16.a());
        if (r17 == true) goto L9;
        if (r1 == true) goto L9;
        return;
    L9:
        io.noties.markwon.i r2 = r11.a();
        t r3 = r11.b();
        w r4 = r2.f().a(ListItem.class);
        int r5 = a(r16);
        Iterator<io.noties.markwon.html.j.a> r18 = r16.j().iterator();
        int r6 = 1;
    L11:
        if (r18.hasNext() == false) goto L21;
        io.noties.markwon.html.j.a r7 = (io.noties.markwon.html.j.a) ZeusTransformUtils.preCheckCast(r18.next(), io.noties.markwon.html.j.a.class, "com.obric.memorydata.plugin");
        a(r11, r13, r7);
        if (r4 == null) goto L11;
        if ("li".equals(r7.a()) == false) goto L11;
        CoreProps.e.b(r11.b(), true);
        q<CoreProps.ListItemType> r8 = CoreProps.f16408a;
        if (r17 == false) goto L19;
        r8.b(r3, CoreProps.ListItemType.ORDERED);
        CoreProps.d.b(r3, Integer.valueOf(r6));
        CoreProps.f16409b.b(r3, Integer.valueOf(r5));
        r6 = r6 + 1;
    L20:
        x.a(r11.c(), r4.a(r2, r3), r7.b(), r7.c());
        goto L11
    L19:
        r8.b(r3, CoreProps.ListItemType.BULLET);
        CoreProps.f16409b.b(r3, Integer.valueOf(r5));
        goto L20
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Arrays.asList(new String[]{"ol", "ul"});
    }
}
