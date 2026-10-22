package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003JW\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR4\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIRecommendation;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIRecommendation;", "icon", "", "id", "content", "bizParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getIcon", "()Ljava/lang/String;", "getId", "getContent", "getBizParams", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class KnowledgeAIRecommendation implements IKnowledgeAIRecommendation {
    private final HashMap<String, Object> bizParams;
    private final String content;
    private final String icon;
    private final String id;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KnowledgeAIRecommendation copy$default(KnowledgeAIRecommendation r0, String r1, String r2, String r3, HashMap r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.icon;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.id;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.content;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.bizParams;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.content;
    }

    public final HashMap<String, Object> component4() {
        return this.bizParams;
    }

    public final KnowledgeAIRecommendation copy(String r2, String r3, String r4, HashMap<String, Object> r5) {
        return new KnowledgeAIRecommendation(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KnowledgeAIRecommendation) == true) goto L8;
        return false;
    L8:
        KnowledgeAIRecommendation r6 = (KnowledgeAIRecommendation) r5;
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizParams, r6.bizParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.icon;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.content;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        HashMap<String, Object> r10 = this.bizParams;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "KnowledgeAIRecommendation(icon=" + this.icon + ", id=" + this.id + ", content=" + this.content + ", bizParams=" + this.bizParams + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public /* bridge */ /* synthetic */ Map getBizParams() {
        return getBizParams();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public String getContent() {
        return this.content;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public String getIcon() {
        return this.icon;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public String getId() {
        return this.id;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIRecommendation
    public HashMap<String, Object> getBizParams() {
        return this.bizParams;
    }

    public KnowledgeAIRecommendation(String r1, String r2, String r3, HashMap<String, Object> r4) {
        this.icon = r1;
        this.id = r2;
        this.content = r3;
        this.bizParams = r4;
    }

    public /* synthetic */ KnowledgeAIRecommendation(String r1, String r2, String r3, HashMap r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }
}
