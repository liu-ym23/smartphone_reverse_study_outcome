package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes7.dex */
public class h extends Element {
    private final Elements f;

    public h(org.jsoup.parser.f r1, String r2, b r3) {
        super(r1, r2, r3);
        this.f = new Elements();
    }

    public h b() {
        return (h) ZeusTransformUtils.preCheckCast(super.m(), h.class, "com.obric.memorydata.plugin");
    }

    public h b(Element r2) {
        this.f.add(r2);
        return this;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public /* synthetic */ Object clone() {
        return b();
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public /* synthetic */ j d() {
        return b();
    }

    @Override // org.jsoup.nodes.j
    public void i(j r1) {
        super.i(r1);
        this.f.remove(r1);
    }

    @Override // org.jsoup.nodes.Element
    public /* synthetic */ Element m() {
        return b();
    }
}
