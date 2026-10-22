package io.noties.markwon.html.tag;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.commonmark.node.Image;

/* JADX INFO: loaded from: classes6.dex */
public class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f16617a;

    public interface a {
        io.noties.markwon.a.h a(Map<String, String> r1);
    }

    public e(a r3) {
        this.f16617a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public static e a() {
        return new e(new f(io.noties.markwon.html.c.a()));
    }

    @Override // io.noties.markwon.html.tag.i
    public Object a(io.noties.markwon.i r5, t r6, io.noties.markwon.html.j r7) {
        t r8 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.memorydata.plugin");
        io.noties.markwon.html.j r9 = (io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r7, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r9.e().get("src"), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L7:
        w r1 = r5.f().a(Image.class);
        if (r1 != null) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty(r0) == true) goto L13;
        String r2 = r5.e().a(r0);
    L14:
        io.noties.markwon.a.h r4 = this.f16617a.a(r9.e());
        io.noties.markwon.a.g.f16398a.b(r8, r2);
        io.noties.markwon.a.g.c.b(r8, r4);
        io.noties.markwon.a.g.f16399b.b(r8, false);
        io.noties.markwon.a.g.d.b(r8, Integer.valueOf(r9.b()));
        io.noties.markwon.a.g.e.b(r8, Integer.valueOf(r9.c()));
        return r1.a(r5, r8);
    L13:
        r2 = "";
        goto L14
    L5:
        if (r5.a().B == true) goto L7;
        return null;
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Collections.singleton("img");
    }
}
