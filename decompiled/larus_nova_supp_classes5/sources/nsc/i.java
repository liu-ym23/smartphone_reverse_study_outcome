package nsc;

import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.LinkSpan;
import java.util.Map;
import lsc.t;
import lsc.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class i implements x {
    public i() {
    }

    @Override // lsc.x
    public Object a(lsc.h r5, t r6) {
        return new LinkSpan(r5.a, (String) CoreProps.g.b(r6), (Map) CoreProps.h.a(r6), r5.c);
    }
}
