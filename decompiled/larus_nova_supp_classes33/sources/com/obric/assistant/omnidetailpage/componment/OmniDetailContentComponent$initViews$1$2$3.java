package com.obric.assistant.omnidetailpage.componment;

import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OmniDetailContentComponent$initViews$1$2$3 extends FunctionReferenceImpl implements Function2<ifa.f.i, Integer, Unit> {
    public OmniDetailContentComponent$initViews$1$2$3(Object r8) {
        super(2, r8, OmniDetailContentComponent.class, "handleQuickReplyShow", "handleQuickReplyShow(Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$QuickReply;I)V", 0);
    }

    public final void invoke(ifa.f.i r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "p0");
        OmniDetailContentComponent r2 = (OmniDetailContentComponent) ((CallableReference) this).receiver;
        int r3 = OmniDetailContentComponent.I;
        r2.getClass();
        BlockContent r4 = r18.b.getContent();
        if (r4 == null) goto L41;
        QuickReplyBlock r5 = r4.getQuickReplyBlock();
        if (r5 == null) goto L42;
        List r6 = r5.getItems();
        if (r6 == null) goto L43;
        QuickReplyItem r7 = (QuickReplyItem) CollectionsKt.getOrNull(r6, r19);
        if (r7 != null) goto L12;
        return;
    L12:
        if (OmniDetailContentComponent.X3(r7) == false) goto L45;
        String[] r8 = new String[4];
        String r0 = r18.b.getBlockId();
        String r9 = "";
        if (r0 != null) goto L17;
        r0 = "";
    L17:
        r8[0] = r0;
        Map r1 = r7.getExtraParams();
        String r10 = null;
        if (r1 == null) goto L20;
        String r11 = (String) r1.get("item_id");
    L21:
        if (r11 == null) goto L24;
        r9 = r11;
    L24:
        r8[1] = r9;
        r8[2] = String.valueOf(r7.getTrackIndex());
        r8[3] = String.valueOf(r19);
        if (r2.H.add(CollectionsKt.joinToString$default(CollectionsKt.listOf(r8), "#", null, null, 0, null, null, 62, null)) == true) goto L28;
        return;
    L28:
        if (OmniDetailContentComponent.X3(r7) == false) goto L47;
        String r12 = r7.getSchemaPayload();
        if (r12 == null) goto L33;
        r10 = StringsKt.trim(r12).toString();
    L33:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r13 = ICommerceMembershipService.a.a();
        if (r13 == null) goto L48;
        String r14 = r13.A(r10);
        if (r14 == null) goto L49;
        OmniDetailContentComponent.a4(r14, r13);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L20:
        r11 = null;
        goto L21
    L45:
        return;
    L43:
        return;
    L42:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((ifa.f.i) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
