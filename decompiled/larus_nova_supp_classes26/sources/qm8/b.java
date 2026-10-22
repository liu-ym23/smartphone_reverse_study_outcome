package qm8;

import com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mi8.e;
import mi8.f;
import mi8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements e {
    public final /* synthetic */ com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a a;
    public final /* synthetic */ com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b b;
    public final /* synthetic */ QuickReplyItem c;
    public final /* synthetic */ int d;
    public final /* synthetic */ QuickReplyItem e;
    public final /* synthetic */ int f;

    public final void onHidden() {
    }

    public final void a() {
        com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a.j(this.a, this.e, this.f);
    }

    public final void onRefuse() {
        com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a.j(this.a, this.c, this.d);
    }

    public final void onShow() {
        this.a.i.c(this.b);
        com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a r0 = this.a;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r1 = this.b;
        r0.getClass();
        int r2 = mi8.c.a;
        QuickReplyBlock r3 = r1.i;
        if (r3 == null) goto L5;
        List r4 = r3.getItems();
    L6:
        if (r4 != null) goto L8;
        r4 = CollectionsKt.emptyList();
    L8:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        String r7 = ((QuickReplyItem) r6.next()).getSchemaPayload();
        if (r7 == null) goto L10;
        r5.add(r7);
        goto L10
    L14:
        String r8 = r1.b;
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        h r9 = new h(r5, new f(r8));
        Intrinsics.checkNotNullParameter(r9, "request");
        IMoaGrantingAppletService r10 = mi8.c.a();
        if (r10 == null) goto L20;
        r10.c(r9);
    L20:
        com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a r11 = this.a;
        List<Pair<Integer, QuickReplyItem>> r12 = r11.f;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r13 = this.b;
        Iterator<T> r14 = r12.iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        Pair r15 = (Pair) r14.next();
        ((Number) r15.component1()).intValue();
        QuickReplyItem r16 = (QuickReplyItem) r15.component2();
        r11.i.a(r13, r16, r16.getTrackIndex());
        goto L22
    L24:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public b(com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a r1, com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r2, QuickReplyItem r3, int r4, QuickReplyItem r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
