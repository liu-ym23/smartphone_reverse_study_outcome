package com.obric.assistant.omnidetailpage.componment;

import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OmniDetailContentComponent$initViews$1$2$4 extends FunctionReferenceImpl implements Function1<ifa.f.b, Unit> {
    public OmniDetailContentComponent$initViews$1$2$4(Object r8) {
        super(1, r8, OmniDetailContentComponent.class, "handleContentShow", "handleContentShow(Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Content;)V", 0);
    }

    public final void invoke(ifa.f.b r14) {
        Intrinsics.checkNotNullParameter(r14, "p0");
        OmniDetailContentComponent r0 = (OmniDetailContentComponent) ((CallableReference) this).receiver;
        int r1 = OmniDetailContentComponent.I;
        r0.getClass();
        BlockContent r2 = r14.b.getContent();
        if (r2 == null) goto L7;
        TextBlock r3 = r2.getTextBlock();
        if (r3 == null) goto L7;
        String r4 = r3.text;
    L8:
        String r5 = "";
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r6 = ICommerceMembershipService.a.a();
        if (r6 != null) goto L15;
        return;
    L15:
        if (r6.l(r4) == false) goto L30;
        String r7 = r6.t(r4);
        if (r7 == null) goto L31;
        String[] r8 = new String[3];
        r8[0] = "content";
        String r15 = r14.b.getBlockId();
        if (r15 == null) goto L24;
        r5 = r15;
    L24:
        r8[1] = r5;
        r8[2] = r7;
        String r16 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r8), "#", null, null, 0, null, null, 62, null);
        if (r0.H.add(r16) == false) goto L32;
        OmniDetailContentComponent.a4(r7, r6);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ifa.f.b) r1);
        return Unit.INSTANCE;
    }
}
