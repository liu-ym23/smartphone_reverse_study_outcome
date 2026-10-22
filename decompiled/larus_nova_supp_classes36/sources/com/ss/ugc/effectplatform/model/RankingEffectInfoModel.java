package com.ss.ugc.effectplatform.model;

import com.ss.ugc.effectplatform.task.StrategyCacheClearTask;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0017\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingEffectInfoModel;", "", StrategyCacheClearTask.RequestResourceInfo.TYPE_EFFECT, "Lcom/ss/ugc/effectplatform/model/Effect;", "simple_video_info", "", "Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;", "designer_name", "", "ranking_info", "Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "(Lcom/ss/ugc/effectplatform/model/Effect;[Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/RankingEffectModel;)V", "getDesigner_name", "()Ljava/lang/String;", "setDesigner_name", "(Ljava/lang/String;)V", "getEffect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setEffect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getRanking_info", "()Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "setRanking_info", "(Lcom/ss/ugc/effectplatform/model/RankingEffectModel;)V", "getSimple_video_info", "()[Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;", "setSimple_video_info", "([Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;)V", "[Lcom/ss/ugc/effectplatform/model/SimpleVideoInfo;", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingEffectInfoModel {
    private String designer_name;
    private Effect effect;
    private RankingEffectModel ranking_info;
    private SimpleVideoInfo[] simple_video_info;

    public RankingEffectInfoModel() {
        this(null, null, null, null, 15, null);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("RankingEffectInfoModel(effect=");
        r0.append(getEffect());
        r0.append(", simple_video_info=");
        SimpleVideoInfo[] r1 = getSimple_video_info();
        if (r1 == null) goto L5;
        String r2 = Arrays.toString(r1);
    L6:
        r0.append(r2);
        r0.append(", designer_name='");
        r0.append(getDesigner_name());
        r0.append("', ranking_info=");
        r0.append(getRanking_info());
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public String getDesigner_name() {
        return this.designer_name;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public RankingEffectModel getRanking_info() {
        return this.ranking_info;
    }

    public SimpleVideoInfo[] getSimple_video_info() {
        return this.simple_video_info;
    }

    public void setDesigner_name(String r1) {
        this.designer_name = r1;
    }

    public void setEffect(Effect r1) {
        this.effect = r1;
    }

    public void setRanking_info(RankingEffectModel r1) {
        this.ranking_info = r1;
    }

    public void setSimple_video_info(SimpleVideoInfo[] r1) {
        this.simple_video_info = r1;
    }

    public RankingEffectInfoModel(Effect r1, SimpleVideoInfo[] r2, String r3, RankingEffectModel r4) {
        this.effect = r1;
        this.simple_video_info = r2;
        this.designer_name = r3;
        this.ranking_info = r4;
    }

    public /* synthetic */ RankingEffectInfoModel(Effect r2, SimpleVideoInfo[] r3, String r4, RankingEffectModel r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
