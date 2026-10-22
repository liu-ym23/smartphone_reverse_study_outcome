package cb8;

import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s1 implements kc8.h {
    public final /* synthetic */ t1 a;

    @Override // kc8.h
    public final boolean a() {
        com.larus.bmhome.chat.component.cvs.y r0 = this.a.L();
        if (r0 == null) goto L5;
        wc9.e r1 = r0.h();
    L7:
        return ic8.n.v(r1);
    L5:
        r1 = null;
        goto L7
    }

    @Override // kc8.h
    public final String b() {
        com.larus.bmhome.chat.component.cvs.y r0 = this.a.L();
        if (r0 == null) goto L7;
        wc9.e r1 = r0.h();
        if (r1 == null) goto L7;
        return r1.B;
    L7:
        return null;
    }

    @Override // kc8.h
    public final boolean i0() {
        com.larus.bmhome.chat.component.collection.o r0 = (com.larus.bmhome.chat.component.collection.o) this.a.D.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.i0() != true) goto L7;
        return true;
    }

    public s1(t1 r1) {
        this.a = r1;
    }

    @Override // kc8.h
    public final int c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        va8.p r0 = this.a.M();
        if (r0 == null) goto L13;
        List r1 = r0.getCurrentList();
        if (r1 == null) goto L13;
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((Message) r2.next()).getMessageId(), r4) == true) goto L17;
        r3 = r3 + 1;
        goto L8
    L17:
        return r3;
    L13:
        return -1;
    }
}
