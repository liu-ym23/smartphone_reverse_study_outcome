package sf8;

import android.view.View;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.item.u;
import com.larus.bmhome.chat.list.cell.deepsearch.DeepSearchCell;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.CollectionDetail;
import com.larus.platform.model.MessageCollection;
import hq9.k0;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements View.OnClickListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ View b;
    public final /* synthetic */ DeepSearchCell c;

    public /* synthetic */ d(i r1, View r2, DeepSearchCell r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        i r13 = this.a;
        View r0 = this.b;
        DeepSearchCell r1 = this.c;
        Map r2 = r13.a.getExt();
        String r4 = null;
        if (r2 == null) goto L5;
        final String r3 = (String) r2.get("deep_search_from_id");
    L6:
        com.bytedance.router.i r5 = SmartRouter.buildRoute(((u) r0).getContext(), "//flow/deep_search");
        r5.c.putExtra("deep_search_message_id", r13.a.getMessageId());
        r5.c.putExtra("deep_search_from_id", r3);
        r5.c.putExtra("argConversationId", r13.a.getConversationId());
        q0 r14 = lf8.a.b(r1);
        if (r14 == null) goto L13;
        q0.a r15 = r14.getProvider();
        if (r15 == null) goto L13;
        y r16 = r15.u0();
        if (r16 == null) goto L13;
        String r17 = r16.getBotId();
    L14:
        r5.c.putExtra("bot_id", r17);
        r5.c.putExtra("enter_from", "deep_search_card");
        q0 r18 = lf8.a.b(r1);
        if (r18 == null) goto L23;
        q0.a r19 = r18.getProvider();
        if (r19 == null) goto L23;
        com.larus.bmhome.chat.component.collection.o r110 = r19.i2();
        if (r110 == null) goto L23;
        boolean r6 = true;
        if (r110.i0() != true) goto L23;
    L24:
        r5.c.putExtra("is_collection_mode", r6);
        q0 r111 = lf8.a.b(r1);
        if (r111 == null) goto L37;
        q0.a r112 = r111.getProvider();
        if (r112 == null) goto L37;
        com.larus.bmhome.chat.component.collection.o r113 = r112.i2();
        if (r113 == null) goto L37;
        MessageCollection r114 = r113.lA();
        if (r114 == null) goto L37;
        List r115 = r114.getCollectionDetails();
        if (r115 == null) goto L37;
        CollectionDetail r116 = (CollectionDetail) CollectionsKt.getOrNull(r115, 0);
        if (r116 == null) goto L37;
        Message r117 = k0.a(r116);
    L38:
        r5.c.putExtra("collection_message", r117);
        r5.d = 2130772401;
        r5.e = 2130772399;
        r5.d();
        de8.c r118 = (de8.c) r1.e.getValue();
        if (r118 == null) goto L41;
        String r7 = r118.p();
    L42:
        i r119 = (i) ((BaseMessageListCell) r1).d;
        if (r119 == null) goto L47;
        Message r120 = r119.a;
        if (r120 == null) goto L47;
        String r8 = r120.getMessageId();
    L48:
        if (r3 != null) goto L50;
        r3 = "no_ext";
    L50:
        i r121 = (i) ((BaseMessageListCell) r1).d;
        if (r121 == null) goto L55;
        Message r122 = r121.a;
        if (r122 == null) goto L55;
        String r9 = r122.getConversationId();
    L56:
        y r123 = (y) r1.f.getValue();
        if (r123 == null) goto L59;
        r4 = r123.getBotId();
    L59:
        Intrinsics.checkNotNullParameter(r3, "parentMessageId");
        n.b("deep_search_card_click", r7, r8, r9, r4, new l(r3));
        return;
    L55:
        r9 = null;
    L47:
        r8 = null;
        goto L48
    L41:
        r7 = null;
    L37:
        r117 = null;
    L23:
        r6 = false;
    L13:
        r17 = null;
        goto L14
    L5:
        r3 = null;
        goto L6
    }
}
