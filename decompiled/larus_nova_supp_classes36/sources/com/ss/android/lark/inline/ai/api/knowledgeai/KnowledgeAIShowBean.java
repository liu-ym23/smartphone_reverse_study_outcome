package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010%\u001a\u00020\u000fH\u0016J\t\u0010&\u001a\u00020\u0003HÆ\u0003J)\u0010'\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J)\u0010(\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J²\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00100J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R4\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R4\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019¨\u00062"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIShowBean;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIShow;", "show", "", "bizParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "trackerParams", "query", "quote", "sendRequest", "disableScopeItem", "scene", "", "topicId", "<init>", "(ZLjava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getShow", "()Z", "getBizParams", "()Ljava/util/HashMap;", "getTrackerParams", "getQuery", "()Ljava/lang/String;", "getQuote", "getSendRequest", "getDisableScopeItem", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopicId", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIShowBean;", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class KnowledgeAIShowBean implements IKnowledgeAIShow {
    private final HashMap<String, Object> bizParams;
    private final Boolean disableScopeItem;
    private final String query;
    private final String quote;
    private final Integer scene;
    private final boolean sendRequest;
    private final boolean show;
    private final String topicId;
    private final HashMap<String, Object> trackerParams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KnowledgeAIShowBean copy$default(KnowledgeAIShowBean r10, boolean r11, HashMap r12, HashMap r13, String r14, String r15, boolean r16, Boolean r17, Integer r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        boolean r2 = r10.show;
    L7:
        if ((r20 & 2) == 0) goto L9;
        HashMap r3 = r10.bizParams;
    L11:
        if ((r20 & 4) == 0) goto L13;
        HashMap r4 = r10.trackerParams;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.query;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.quote;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r7 = r10.sendRequest;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Boolean r8 = r10.disableScopeItem;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Integer r9 = r10.scene;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.topicId;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final boolean component1() {
        return this.show;
    }

    public final HashMap<String, Object> component2() {
        return this.bizParams;
    }

    public final HashMap<String, Object> component3() {
        return this.trackerParams;
    }

    public final String component4() {
        return this.query;
    }

    public final String component5() {
        return this.quote;
    }

    public final boolean component6() {
        return this.sendRequest;
    }

    public final Boolean component7() {
        return this.disableScopeItem;
    }

    public final Integer component8() {
        return this.scene;
    }

    public final String component9() {
        return this.topicId;
    }

    public final KnowledgeAIShowBean copy(boolean r12, HashMap<String, Object> r13, HashMap<String, Object> r14, String r15, String r16, boolean r17, Boolean r18, Integer r19, String r20) {
        return new KnowledgeAIShowBean(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public String toString() {
        return "KnowledgeAIShowBean(show=" + this.show + ", bizParams=" + this.bizParams + ", trackerParams=" + this.trackerParams + ", query=" + this.query + ", quote=" + this.quote + ", sendRequest=" + this.sendRequest + ", disableScopeItem=" + this.disableScopeItem + ", scene=" + this.scene + ", topicId=" + this.topicId + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public /* bridge */ /* synthetic */ Map getBizParams() {
        return getBizParams();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public /* bridge */ /* synthetic */ Map getTrackerParams() {
        return getTrackerParams();
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public Boolean getDisableScopeItem() {
        return this.disableScopeItem;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public String getQuery() {
        return this.query;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public String getQuote() {
        return this.quote;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public Integer getScene() {
        return this.scene;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public boolean getSendRequest() {
        return this.sendRequest;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public boolean getShow() {
        return this.show;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public String getTopicId() {
        return this.topicId;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public HashMap<String, Object> getBizParams() {
        return this.bizParams;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public HashMap<String, Object> getTrackerParams() {
        return this.trackerParams;
    }

    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    public KnowledgeAIShowBean(boolean r1, HashMap<String, Object> r2, HashMap<String, Object> r3, String r4, String r5, boolean r6, Boolean r7, Integer r8, String r9) {
        this.show = r1;
        this.bizParams = r2;
        this.trackerParams = r3;
        this.query = r4;
        this.quote = r5;
        this.sendRequest = r6;
        this.disableScopeItem = r7;
        this.scene = r8;
        this.topicId = r9;
    }

    public /* synthetic */ KnowledgeAIShowBean(boolean r14, HashMap r15, HashMap r16, String r17, String r18, boolean r19, Boolean r20, Integer r21, String r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r23 & 2) == 0) goto L9;
        HashMap r5 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        HashMap r6 = null;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r23 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r23 & 64) == 0) goto L29;
        Boolean r10 = null;
    L31:
        if ((r23 & 256) == 0) goto L33;
        String r12 = null;
    L34:
        this(r4, r5, r6, r7, r8, r9, r10, r21, r12);
        return;
    L33:
        r12 = r22;
        goto L34
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }
}
