package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIRecommend;", "Ljava/io/Serializable;", "mainRecommend", "", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIRecommendation;", "getMainRecommend", "()Ljava/util/List;", "keyboardRecommend", "getKeyboardRecommend", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface IKnowledgeAIRecommend extends Serializable {
    List<IKnowledgeAIRecommendation> getKeyboardRecommend();

    List<IKnowledgeAIRecommendation> getMainRecommend();
}
