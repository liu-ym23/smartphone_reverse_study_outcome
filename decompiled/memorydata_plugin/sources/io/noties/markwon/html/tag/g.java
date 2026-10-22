package io.noties.markwon.html.tag;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.Collection;
import java.util.Collections;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: classes6.dex */
public class g extends i {
    public g() {
    }

    @Override // io.noties.markwon.html.tag.i
    public Object a(io.noties.markwon.i r2, t r3, io.noties.markwon.html.j r4) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(((io.noties.markwon.html.j) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.html.j.class, "com.obric.memorydata.plugin")).e().get("href"), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r5) == true) goto L8;
        w r6 = r2.f().a(Link.class);
        if (r6 == null) goto L10;
        CoreProps.g.b(r1, r5);
        return r6.a(r2, r1);
    L10:
        return null;
    L8:
        return null;
    }

    @Override // io.noties.markwon.html.u
    public Collection<String> b() {
        return Collections.singleton("a");
    }
}
