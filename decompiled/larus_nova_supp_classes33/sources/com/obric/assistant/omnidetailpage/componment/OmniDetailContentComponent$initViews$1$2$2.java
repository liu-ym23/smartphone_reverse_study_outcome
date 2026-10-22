package com.obric.assistant.omnidetailpage.componment;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.utils.logger.FLogger;
import java.util.List;
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
final /* synthetic */ class OmniDetailContentComponent$initViews$1$2$2 extends FunctionReferenceImpl implements Function2<ifa.f.i, Integer, Unit> {
    public OmniDetailContentComponent$initViews$1$2$2(Object r8) {
        super(2, r8, OmniDetailContentComponent.class, "handleQuickReplyClick", "handleQuickReplyClick(Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$QuickReply;I)V", 0);
    }

    public final void invoke(ifa.f.i r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "p0");
        OmniDetailContentComponent r0 = (OmniDetailContentComponent) ((CallableReference) this).receiver;
        int r1 = OmniDetailContentComponent.I;
        r0.getClass();
        BlockContent r9 = r7.b.getContent();
        if (r9 == null) goto L63;
        QuickReplyBlock r10 = r9.getQuickReplyBlock();
        if (r10 == null) goto L64;
        List r11 = r10.getItems();
        if (r11 == null) goto L65;
        QuickReplyItem r12 = (QuickReplyItem) CollectionsKt.getOrNull(r11, r8);
        if (r12 == null) goto L68;
        String r2 = null;
        boolean r3 = false;
        if (OmniDetailContentComponent.X3(r12) == false) goto L26;
        String r13 = r12.getSchemaPayload();
        if (r13 == null) goto L17;
        String r14 = StringsKt.trim(r13).toString();
    L18:
        Context r4 = r0.getContext();
        if (r4 == null) goto L26;
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r5 = ICommerceMembershipService.a.a();
        if (r5 == null) goto L26;
        String r15 = r5.A(r14);
        if (r15 == null) goto L26;
        SmartRouter.buildRoute(r4, r15).d();
        r5.w(r15, null);
        boolean r16 = true;
    L28:
        if (r16 == true) goto L66;
        Integer r17 = r12.getActionType();
        if (r17 == null) goto L45;
        int r18 = r17.intValue();
        String r6 = r12.getSchemaPayload();
        if (r6 == null) goto L34;
        String r19 = StringsKt.trim(r6).toString();
    L36:
        if (r18 < ActionType.OPERATION.getValue()) goto L45;
        if (r19 != null) goto L39;
    L42:
        boolean r20 = true;
    L43:
        if (r20 == true) goto L45;
        boolean r21 = true;
    L46:
        if (r21 == false) goto L61;
        String r22 = r12.getSchemaPayload();
        if (r22 == null) goto L50;
        r2 = StringsKt.trim(r22).toString();
    L50:
        if (r2 != null) goto L52;
        r2 = "";
    L52:
        Context r23 = r0.getContext();
        if (r23 != null) goto L56;
        return;
    L56:
        if (r2.length() != 0) goto L58;
        r3 = true;
    L58:
        if (r3 == true) goto L70;
        SmartRouter.buildRoute(r23, r2).d();
        return;
    L70:
        return;
    L61:
        FLogger.a.i("OmniDetailContentComponent", "unsupported quickReply actionType=" + r12.getActionType());
        return;
    L39:
        if (r19.length() == 0) goto L42;
        r20 = false;
        goto L43
    L34:
        r19 = null;
    L45:
        r21 = false;
        goto L46
    L66:
        return;
    L17:
        r14 = null;
    L26:
        r16 = false;
        goto L28
    L68:
        return;
    L65:
        return;
    L64:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((ifa.f.i) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
