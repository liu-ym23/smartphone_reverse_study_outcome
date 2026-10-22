package com.ss.ugc.effectplatform.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\b\u0010,\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)¨\u0006-"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoModel;", "", "designer_id", "", "designer_encrypted_id", "name", "small_icon_url", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "ranking_url", "follow_status", "", "following_count", "effect_count", "effects", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getDesigner_encrypted_id", "()Ljava/lang/String;", "setDesigner_encrypted_id", "(Ljava/lang/String;)V", "getDesigner_id", "setDesigner_id", "getEffect_count", "()Ljava/lang/Integer;", "setEffect_count", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "getFollow_status", "setFollow_status", "getFollowing_count", "setFollowing_count", "getName", "setName", "getRanking_url", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setRanking_url", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getSmall_icon_url", "setSmall_icon_url", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingDesignerInfoModel {
    private String designer_encrypted_id;
    private String designer_id;
    private Integer effect_count;
    private List<? extends Effect> effects;
    private Integer follow_status;
    private Integer following_count;
    private String name;
    private UrlModel ranking_url;
    private UrlModel small_icon_url;

    public String toString() {
        return "RankingDesignerInfoModel(designer_id=" + getDesigner_id() + ", designer_encrypted_id=" + getDesigner_encrypted_id() + ", name=" + getName() + ", small_icon_url=" + getSmall_icon_url() + ", ranking_url=" + getRanking_url() + ", follow_status=" + getFollow_status() + ", following_count=" + getFollowing_count() + ", effect_count=" + getEffect_count() + ", effects=" + getEffects() + ')';
    }

    public String getDesigner_encrypted_id() {
        return this.designer_encrypted_id;
    }

    public String getDesigner_id() {
        return this.designer_id;
    }

    public Integer getEffect_count() {
        return this.effect_count;
    }

    public List<Effect> getEffects() {
        return this.effects;
    }

    public Integer getFollow_status() {
        return this.follow_status;
    }

    public Integer getFollowing_count() {
        return this.following_count;
    }

    public String getName() {
        return this.name;
    }

    public UrlModel getRanking_url() {
        return this.ranking_url;
    }

    public UrlModel getSmall_icon_url() {
        return this.small_icon_url;
    }

    public void setDesigner_encrypted_id(String r1) {
        this.designer_encrypted_id = r1;
    }

    public void setDesigner_id(String r1) {
        this.designer_id = r1;
    }

    public void setEffect_count(Integer r1) {
        this.effect_count = r1;
    }

    public void setEffects(List<? extends Effect> r1) {
        this.effects = r1;
    }

    public void setFollow_status(Integer r1) {
        this.follow_status = r1;
    }

    public void setFollowing_count(Integer r1) {
        this.following_count = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setRanking_url(UrlModel r1) {
        this.ranking_url = r1;
    }

    public void setSmall_icon_url(UrlModel r1) {
        this.small_icon_url = r1;
    }

    public RankingDesignerInfoModel(String r1, String r2, String r3, UrlModel r4, UrlModel r5, Integer r6, Integer r7, Integer r8, List<? extends Effect> r9) {
        this.designer_id = r1;
        this.designer_encrypted_id = r2;
        this.name = r3;
        this.small_icon_url = r4;
        this.ranking_url = r5;
        this.follow_status = r6;
        this.following_count = r7;
        this.effect_count = r8;
        this.effects = r9;
    }

    public /* synthetic */ RankingDesignerInfoModel(String r16, String r17, String r18, UrlModel r19, UrlModel r20, Integer r21, Integer r22, Integer r23, List r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r25 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r25 & 8) == 0) goto L17;
        UrlModel r7 = new UrlModel(null, null, null, null, 15, null);
    L19:
        if ((r25 & 16) == 0) goto L21;
        UrlModel r8 = new UrlModel(null, null, null, null, 15, null);
    L23:
        if ((r25 & 256) == 0) goto L25;
        List r12 = null;
    L26:
        this(r4, r5, r6, r7, r8, r21, r22, r23, r12);
        return;
    L25:
        r12 = r24;
        goto L26
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }
}
