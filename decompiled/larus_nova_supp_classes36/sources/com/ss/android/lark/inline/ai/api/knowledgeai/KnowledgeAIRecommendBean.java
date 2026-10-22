package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003JE\u0010\u000e\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R(\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR(\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIRecommendBean;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIRecommend;", "mainRecommend", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIRecommendation;", "Lkotlin/collections/ArrayList;", "keyboardRecommend", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getMainRecommend", "()Ljava/util/ArrayList;", "getKeyboardRecommend", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class KnowledgeAIRecommendBean implements IKnowledgeAIRecommend {
    private final ArrayList<KnowledgeAIRecommendation> keyboardRecommend;
    private final ArrayList<KnowledgeAIRecommendation> mainRecommend;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KnowledgeAIRecommendBean copy$default(KnowledgeAIRecommendBean r0, ArrayList r1, ArrayList r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.mainRecommend;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.keyboardRecommend;
    L9:
        return r0.copy(r1, r2);
    }

    public final ArrayList<KnowledgeAIRecommendation> component1() {
        return this.mainRecommend;
    }

    public final ArrayList<KnowledgeAIRecommendation> component2() {
        return this.keyboardRecommend;
    }

    public final KnowledgeAIRecommendBean copy(ArrayList<KnowledgeAIRecommendation> r2, ArrayList<KnowledgeAIRecommendation> r3) {
        return new KnowledgeAIRecommendBean(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KnowledgeAIRecommendBean) == true) goto L8;
        return false;
    L8:
        KnowledgeAIRecommendBean r6 = (KnowledgeAIRecommendBean) r5;
        if (Intrinsics.areEqual(this.mainRecommend, r6.mainRecommend) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keyboardRecommend, r6.keyboardRecommend) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ArrayList<KnowledgeAIRecommendation> r0 = this.mainRecommend;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ArrayList<KnowledgeAIRecommendation> r4 = this.keyboardRecommend;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "KnowledgeAIRecommendBean(mainRecommend=" + this.mainRecommend + ", keyboardRecommend=" + this.keyboardRecommend + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommend
    public /* bridge */ /* synthetic */ List getKeyboardRecommend() {
        return getKeyboardRecommend();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommend
    public /* bridge */ /* synthetic */ List getMainRecommend() {
        return getMainRecommend();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommend
    public ArrayList<KnowledgeAIRecommendation> getKeyboardRecommend() {
        return this.keyboardRecommend;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommend
    public ArrayList<KnowledgeAIRecommendation> getMainRecommend() {
        return this.mainRecommend;
    }

    public KnowledgeAIRecommendBean(ArrayList<KnowledgeAIRecommendation> r1, ArrayList<KnowledgeAIRecommendation> r2) {
        this.mainRecommend = r1;
        this.keyboardRecommend = r2;
    }
}
