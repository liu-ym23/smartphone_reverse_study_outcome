package com.larus.uaigc.service;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.o1;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent;
import com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor;
import com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2$\u0010\u000e\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016Jl\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\t2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016¨\u0006#"}, d2 = {"Lcom/larus/uaigc/service/CreationAttachmentServiceImpl;", "Lcom/larus/uaigc/service/ICreationAttachmentService;", "<init>", "()V", "uploadBeforeSendNestedFiles", "", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "ext", "", "originalLogic", "Lkotlin/Function3;", "isNestedFileProcessing", "", "identifier", "citeOrQuestionAttachmentToInput", "anchorView", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "vid", "coverUrl", "downloadUrl", "fromScene", "extra", "", "createSpringMultiAttachmentSelectorComponent", "Lcom/larus/ui/arch/component/external/api/Component;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationAttachmentServiceImpl implements ICreationAttachmentService {
    public CreationAttachmentServiceImpl() {
    }

    @Override // com.larus.uaigc.service.ICreationAttachmentService
    public final Component M() {
        return new SpringMultiAttachmentSelectorComponent();
    }

    @Override // com.larus.uaigc.service.ICreationAttachmentService
    public final boolean O(String r4) {
        if (UgcUploadingSendMessageProcessor.a.contains(r4) == true) goto L20;
        Set<String> r0 = CreationMultiAttachmentProcessor.b;
        if (r4.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r4 = null;
    L11:
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L21;
        return false;
    L21:
        return true;
    L13:
        if (CreationMultiAttachmentProcessor.b.contains(r4) != true) goto L15;
        r5 = true;
        goto L16
    L7:
        r1 = false;
        goto L8
    L20:
        return true;
    }

    @Override // com.larus.uaigc.service.ICreationAttachmentService
    public final void a(final y8 r52, String r53, final ICoreInputAbility.OnSendParams r54, final Map r55, final o1 r56) {
        Intrinsics.checkNotNullParameter(r52, "dependency");
        Intrinsics.checkNotNullParameter(r53, "originContent");
        Intrinsics.checkNotNullParameter(r54, "params");
        Intrinsics.checkNotNullParameter(r55, "ext");
        Intrinsics.checkNotNullParameter(r56, "originalLogic");
        final UgcUploadingSendMessageProcessor r6 = new UgcUploadingSendMessageProcessor();
        Intrinsics.checkNotNullParameter(r52, "dependency");
        Intrinsics.checkNotNullParameter(r53, "originContent");
        Intrinsics.checkNotNullParameter(r54, "params");
        Intrinsics.checkNotNullParameter(r55, "ext");
        Intrinsics.checkNotNullParameter(r56, "originalLogic");
        MultiAttachmentInfo r0 = r54.getMultiAttachment();
        if (r0 == null) goto L14;
        String r1 = r0.getLocalMsgId();
        if (r1 == null) goto L14;
        if (r1.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L14;
    L20:
        String r12 = r1;
        CustomMultiAttachmentInfo r2 = r54.getCustomMultiAttachment();
        if (r2 == null) goto L23;
        NestedFileContent r13 = r2.getNestedFileContent();
    L24:
        if (r13 == null) goto L39;
        List r4 = r13.getEntities();
        if (r4 == null) goto L39;
        ArrayList r5 = new ArrayList();
        Iterator r7 = r4.iterator();
    L29:
        if (r7.hasNext() == false) goto L40;
        Object r8 = r7.next();
        Integer r9 = ((UplinkFileEntity) r8).getUpLinkStatus();
        int r10 = UpLinkState.SUCCESS.getValue();
        if (r9 != null) goto L34;
    L35:
        boolean r11 = true;
    L37:
        if (r11 == false) goto L29;
        r5.add(r8);
        goto L29
    L34:
        if (r9.intValue() != r10) goto L35;
        r11 = false;
    L40:
        if (r13 == null) goto L55;
        List r14 = r13.getEntities();
        if (r14 == null) goto L55;
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L45:
        if (r16.hasNext() == false) goto L56;
        Object r17 = r16.next();
        Integer r18 = ((UplinkFileEntity) r17).getFileReviewStatus();
        int r19 = FileReviewState.ACCESS.getValue();
        if (r18 != null) goto L50;
    L51:
        boolean r20 = true;
    L53:
        if (r20 == false) goto L45;
        r15.add(r17);
        goto L45
    L50:
        if (r18.intValue() != r19) goto L51;
        r20 = false;
    L56:
        if (r5 != null) goto L58;
    L61:
        boolean r21 = true;
    L62:
        if (r21 == false) goto L79;
        if (r15 != null) goto L65;
    L68:
        boolean r22 = true;
    L69:
        if (r22 == false) goto L79;
        NestedFileContent r23 = CreationNoWatermarkManager.a.b0(r13);
        if (r23 != null) goto L73;
        NestedFileContent r110 = r13;
    L74:
        CustomMultiAttachmentInfo r111 = r54.getCustomMultiAttachment();
        if (r111 == null) goto L77;
        CustomMultiAttachmentInfo r50 = CustomMultiAttachmentInfo.copy$default(r111, null, null, r110, false, false, false, false, null, 251, null);
    L78:
        r56.invoke(ICoreInputAbility.OnSendParams.copy$default(r54, null, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, r50, null, null, null, null, null, null, -67108865, 1, null), null, null);
        return;
    L77:
        r50 = null;
        goto L78
    L73:
        r110 = r23;
        goto L74
    L65:
        if (r15.isEmpty() == true) goto L68;
        r22 = false;
    L79:
        final long r24 = System.currentTimeMillis();
        com.larus.uaigc.helper.f.a.getClass();
        final boolean r25 = com.larus.uaigc.helper.f.a();
        FLogger r26 = FLogger.a;
        StringBuilder r112 = new StringBuilder("[uploadBeforeSendNestedFiles] Before updating identifiers, entities count: ");
        List r113 = r13.getEntities();
        if (r113 == null) goto L82;
        Integer r114 = Integer.valueOf(r113.size());
    L83:
        r112.append(r114);
        r26.i("NestedFileSendMessageProcessor", r112.toString());
        List r27 = r13.getEntities();
        if (r27 == null) goto L125;
        Iterator r28 = r27.iterator();
        int r115 = 0;
    L87:
        if (r28.hasNext() == false) goto L125;
        Object r116 = r28.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L91;
        CollectionsKt.throwIndexOverflow();
    L91:
        UplinkFileEntity r29 = (UplinkFileEntity) r116;
        FLogger r30 = FLogger.a;
        Iterator r118 = r28;
        r30.i("NestedFileSendMessageProcessor", "[uploadBeforeSendNestedFiles] entity " + r115 + " before: fileIdentifier=" + r29.getFileIdentifier());
        if (r25 == false) goto L101;
        String r31 = r29.getFileIdentifier();
        if (r31 == null) goto L101;
        if (r31.length() <= 0) goto L98;
        boolean r32 = true;
    L99:
        if (r32 == false) goto L101;
    L102:
        if (r31 != null) goto L104;
        r31 = UUID.randomUUID().toString();
    L104:
        r29.setFileIdentifier(r31);
        if (r25 == false) goto L119;
        UplinkEntityContent r33 = r29.getUplinkEntityContent();
        if (r33 == null) goto L111;
        Image r34 = r33.getUplinkImageInfo();
        if (r34 == null) goto L111;
        String r35 = r34.identifier;
    L112:
        if (r35 != null) goto L114;
    L117:
        boolean r36 = true;
    L118:
        if (r36 == true) goto L119;
    L124:
        r30.i("NestedFileSendMessageProcessor", "[uploadBeforeSendNestedFiles] entity " + r115 + ": use identifier=" + r31 + ", pipelineEnabled=" + r25);
        r115 = r117;
        r28 = r118;
        goto L87
    L114:
        if (r35.length() == 0) goto L117;
        r36 = false;
    L111:
        r35 = null;
    L119:
        UplinkEntityContent r37 = r29.getUplinkEntityContent();
        if (r37 == null) goto L124;
        Image r38 = r37.getUplinkImageInfo();
        if (r38 == null) goto L124;
        r38.identifier = r31;
        goto L124
    L98:
        r32 = false;
    L101:
        r31 = null;
    L125:
        FLogger.a.i("NestedFileSendMessageProcessor", "[uploadBeforeSendNestedFiles] After updating identifiers");
        com.larus.bmhome.chat.component.cvs.y r39 = r52.u0();
        if (r39 == null) goto L150;
        wc9.e r119 = r39.h();
        if (r119 == null) goto L151;
        String r120 = r119.a;
        gd8.g r40 = r52.h2();
        if (r40 == null) goto L132;
        r40.mh(r120, "send_multi_attachment", OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
    L132:
        final NestedFileContent r41 = r13;
        u1.a.b(RepoDispatcherDelegate.b.e().getSender(), r53, r13, r12, r119, r120, r55, r54.getReferenceInfo(), r54.chatPageContext, new com.larus.uaigc.createpage.utils.r(r41, r24, r6, r54, r55, r56, r52, r25), 64);
        return;
    L151:
        return;
    L150:
        return;
    L82:
        r114 = null;
        goto L83
    L58:
        if (r5.isEmpty() == true) goto L61;
        r21 = false;
    L55:
        r15 = null;
    L39:
        r5 = null;
        goto L40
    L23:
        r13 = null;
        goto L24
    L9:
        r3 = false;
    L14:
        CustomMultiAttachmentInfo r42 = r54.getCustomMultiAttachment();
        if (r42 == null) goto L17;
        r1 = r42.getLocalMsgId();
    L18:
        if (r1 != null) goto L20;
        r1 = "";
        goto L20
    L17:
        r1 = null;
        goto L18
    }

    @Override // com.larus.uaigc.service.ICreationAttachmentService
    public final boolean N(View r2, Fragment r3, Message r4, String r5, String r6, String r7, String r8, String r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        Intrinsics.checkNotNullParameter(r9, "fromScene");
        CreationChatItemClickHelper.a.getClass();
        return CreationChatItemClickHelper.e(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
