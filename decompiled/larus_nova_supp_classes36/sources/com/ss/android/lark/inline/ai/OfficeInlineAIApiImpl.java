package com.ss.android.lark.inline.ai;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.knowledgeai.CCMKnowledgePageConfig;
import com.ss.android.lark.inline.ai.creationai.ICreationAIUISdkImpl;
import com.ss.android.lark.inline.ai.logic.e;
import com.ss.android.lark.inline.ai.logic.i;
import com.ss.android.lark.inline.ai.ui.IInlineAIUISdkImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import slb.f;
import slb.g;
import wlb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(slb.b.class)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/inline/ai/OfficeInlineAIApiImpl;", "Lcom/ss/android/lark/inline/ai/api/IInlineAIApi;", "<init>", "()V", "createUISdk", "Lcom/ss/android/lark/inline/ai/api/ui/IInlineAIUISdk;", "config", "Lcom/ss/android/lark/inline/ai/api/ui/InlineAIConfig;", "callback", "Lcom/ss/android/lark/inline/ai/api/ui/IOperationCallback;", "createAsrSdk", "Lcom/ss/android/lark/inline/ai/api/asr/IInlineAIAsrSdk;", "inlineAIParams", "Lcom/ss/android/lark/inline/ai/api/InlineAIParams;", "createKnowledgeAISdk", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgeAISdk;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgePageConfig;", "createCreationAISdk", "Lcom/ss/android/lark/inline/ai/api/creationai/ICreationAISdk;", "creationAIConfig", "Lcom/ss/android/lark/inline/ai/api/creationai/CreationAIConfig;", "Lcom/ss/android/lark/inline/ai/api/creationai/ICreationAIOpCallback;", "createSdk", "Lcom/ss/android/lark/inline/ai/api/IInlineAISdk;", "getRustInterface", "Lcom/ss/android/lark/inline/ai/api/IInlineAIRustInterface;", "getInlineAIUtils", "Lcom/ss/android/lark/inline/ai/api/IInlineAIUtils;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OfficeInlineAIApiImpl implements slb.b {
    public OfficeInlineAIApiImpl() {
    }

    public f getInlineAIUtils() {
        return i.a;
    }

    public slb.d getRustInterface() {
        return e.a;
    }

    public tlb.c createAsrSdk(g r2) {
        Intrinsics.checkNotNullParameter(r2, "inlineAIParams");
        return new com.ss.android.lark.inline.ai.asr.b(r2);
    }

    @Override // slb.b
    public com.ss.android.lark.inline.ai.api.knowledgeai.c createKnowledgeAISdk(CCMKnowledgePageConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        int r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "config");
        return b.a;
    }

    @Override // slb.b
    public slb.e createSdk(g r2) {
        Intrinsics.checkNotNullParameter(r2, "inlineAIParams");
        return new IInlineAISdkImpl(r2);
    }

    @Override // slb.b
    public vlb.c createCreationAISdk(vlb.a r2, vlb.b r3) {
        Intrinsics.checkNotNullParameter(r2, "creationAIConfig");
        Intrinsics.checkNotNullParameter(r3, "callback");
        return new ICreationAIUISdkImpl(r2, r3);
    }

    @Override // slb.b
    public wlb.c createUISdk(h r2, wlb.e r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "callback");
        return new IInlineAIUISdkImpl(r2, r3);
    }
}
