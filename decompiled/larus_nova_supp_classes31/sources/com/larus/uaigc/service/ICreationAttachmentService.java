package com.larus.uaigc.service;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.o1;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.Component;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 !2\u00020\u0001:\u0001!JZ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b2$\u0010\f\u001a \u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\rH&J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H&Jx\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u001eH&J\n\u0010\u001f\u001a\u0004\u0018\u00010 H&¨\u0006\""}, d2 = {"Lcom/larus/uaigc/service/ICreationAttachmentService;", "", "uploadBeforeSendNestedFiles", "", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "ext", "", "originalLogic", "Lkotlin/Function3;", "isNestedFileProcessing", "", "identifier", "citeOrQuestionAttachmentToInput", "anchorView", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "vid", "coverUrl", "downloadUrl", "fromScene", "extra", "", "createSpringMultiAttachmentSelectorComponent", "Lcom/larus/ui/arch/component/external/api/Component;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationAttachmentService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jm\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013H\u0096\u0001J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0096\u0001J[\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0 2$\u0010!\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00190\"H\u0096\u0001¨\u0006#"}, d2 = {"Lcom/larus/uaigc/service/ICreationAttachmentService$Companion;", "Lcom/larus/uaigc/service/ICreationAttachmentService;", "<init>", "()V", "citeOrQuestionAttachmentToInput", "", "anchorView", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "", "vid", "coverUrl", "downloadUrl", "fromScene", "extra", "", "createSpringMultiAttachmentSelectorComponent", "Lcom/larus/ui/arch/component/external/api/Component;", "isNestedFileProcessing", "identifier", "uploadBeforeSendNestedFiles", "", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "ext", "", "originalLogic", "Lkotlin/Function3;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationAttachmentService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationAttachmentService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationAttachmentService
        public final Component M() {
            return this.b.M();
        }

        @Override // com.larus.uaigc.service.ICreationAttachmentService
        public final boolean N(View r12, Fragment r13, Message r14, String r15, String r16, String r17, String r18, String r19, Map<String, String> r20) {
            Intrinsics.checkNotNullParameter(r12, "anchorView");
            Intrinsics.checkNotNullParameter(r19, "fromScene");
            return this.b.N(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        @Override // com.larus.uaigc.service.ICreationAttachmentService
        public final boolean O(String r2) {
            return this.b.O(r2);
        }

        @Override // com.larus.uaigc.service.ICreationAttachmentService
        public final void a(y8 r8, String r9, ICoreInputAbility.OnSendParams r10, Map r11, o1 r12) {
            Intrinsics.checkNotNullParameter(r8, "dependency");
            Intrinsics.checkNotNullParameter(r9, "originContent");
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "ext");
            Intrinsics.checkNotNullParameter(r12, "originalLogic");
            this.b.a(r8, r9, r10, r11, r12);
        }

        private Companion() {
            ICreationAttachmentService r0 = (ICreationAttachmentService) ServiceManager.get().getService(ICreationAttachmentService.class);
            if (r0 != null) goto L5;
            r0 = new ICreationAttachmentServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    Component M();

    boolean N(View r1, Fragment r2, Message r3, String r4, String r5, String r6, String r7, String r8, Map<String, String> r9);

    boolean O(String r1);

    void a(y8 r1, String r2, ICoreInputAbility.OnSendParams r3, Map r4, o1 r5);
}
