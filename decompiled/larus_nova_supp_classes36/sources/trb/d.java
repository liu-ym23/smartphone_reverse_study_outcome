package trb;

import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.message.vote.VoteCardOptionsAdapter;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ b b;
    public final /* synthetic */ irb.b c;
    public final /* synthetic */ VoteCardOptionsAdapter d;
    public final /* synthetic */ com.ss.android.lark.message.vote.c e;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        this.a.setEnabled(false);
        b r7 = this.b;
        if (r7 == null) goto L20;
        String r0 = this.c.d;
        com.ss.android.lark.message.vote.c r1 = this.e;
        VoteCardOptionsAdapter r2 = this.d;
        r1.getClass();
        HashMap r3 = new HashMap();
        if (r2 == null) goto L13;
        Iterator r4 = r2.getItems().iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        irb.a r5 = (irb.a) r4.next();
        if (r5.e == false) goto L9;
        r3.put(r5.b, r5.c);
    L13:
        ((com.ss.android.lark.message.vote.message.a) r7).a(r0, r3);
        return;
    }

    public d(com.ss.android.lark.message.vote.c r1, TextView r2, b r3, irb.b r4, VoteCardOptionsAdapter r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
