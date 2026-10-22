package uib;

import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.forwardv3.configuration.ConvertMessageParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.g;
import com.ss.android.lark.forwardv3.forward.imageforward.ImageForwardContent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ConvertMessageParamsHandler
public final class a implements g<ImageForwardContent> {
    public a() {
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g, com.ss.android.lark.forwardv3.configuration.a
    public int getType() {
        return 5;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g
    public final Object a(IForwardContent r4) {
        ImageForwardContent r5 = (ImageForwardContent) r4;
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.b.iterator();
    L7:
        if (r6.hasNext() == false) goto L10;
        String r1 = (String) r6.next();
        p0.a r2 = new p0.a();
        r2.A = r1;
        r0.add(r2);
        goto L7
    L10:
        return r0;
    }
}
