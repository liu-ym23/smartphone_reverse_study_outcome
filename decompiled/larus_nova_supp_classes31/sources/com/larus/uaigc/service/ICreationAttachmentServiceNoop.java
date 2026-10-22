package com.larus.uaigc.service;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.o1;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.Component;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2$\u0010\u000e\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016Jl\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\t2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016¨\u0006#"}, d2 = {"Lcom/larus/uaigc/service/ICreationAttachmentServiceNoop;", "Lcom/larus/uaigc/service/ICreationAttachmentService;", "<init>", "()V", "uploadBeforeSendNestedFiles", "", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "ext", "", "originalLogic", "Lkotlin/Function3;", "isNestedFileProcessing", "", "identifier", "citeOrQuestionAttachmentToInput", "anchorView", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "vid", "coverUrl", "downloadUrl", "fromScene", "extra", "", "createSpringMultiAttachmentSelectorComponent", "Lcom/larus/ui/arch/component/external/api/Component;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationAttachmentServiceNoop implements ICreationAttachmentService {
    public ICreationAttachmentServiceNoop() {
    }

    @Override // com.larus.uaigc.service.ICreationAttachmentService
    public final Component M() {
        return null;
    }

    @Override // com.larus.uaigc.service.ICreationAttachmentService
    public final boolean N(View r1, Fragment r2, Message r3, String r4, String r5, String r6, String r7, String r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r1, "anchorView");
        Intrinsics.checkNotNullParameter(r8, "fromScene");
        return false;
    }

    @Override // com.larus.uaigc.service.ICreationAttachmentService
    public final boolean O(String r1) {
        return false;
    }

    @Override // com.larus.uaigc.service.ICreationAttachmentService
    public final void a(y8 r2, String r3, ICoreInputAbility.OnSendParams r4, Map r5, o1 r6) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        Intrinsics.checkNotNullParameter(r3, "originContent");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "ext");
        Intrinsics.checkNotNullParameter(r6, "originalLogic");
    }
}
