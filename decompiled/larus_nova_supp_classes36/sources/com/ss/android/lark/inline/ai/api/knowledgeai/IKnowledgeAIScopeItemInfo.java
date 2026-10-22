package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIScopeItemInfo;", "Ljava/io/Serializable;", "entityScope", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIEntityScope;", "getEntityScope", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIEntityScope;", "id", "", "getId", "()Ljava/lang/String;", "icon", "getIcon", "text", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IAiScopeItemI18nText;", "getText", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/IAiScopeItemI18nText;", "entityType", "", "getEntityType", "()Ljava/lang/Integer;", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface IKnowledgeAIScopeItemInfo extends Serializable {
    IKnowledgeAIEntityScope getEntityScope();

    Integer getEntityType();

    String getIcon();

    String getId();

    IAiScopeItemI18nText getText();
}
