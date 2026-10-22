package com.ss.ugc.effectplatform.model;

import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0019\b\u0017\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010#\u001a\u00020\u0003H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingCategoryModel;", "", "id", "", "name", "icon", "Lcom/ss/ugc/effectplatform/model/UrlModel;", TabAppInfo.IMAGE_JSON_KEY, "type", "", "tags", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Ljava/lang/String;Ljava/lang/Integer;[Ljava/lang/String;)V", "getIcon", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setIcon", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getKey", "setKey", "getName", "setName", "getTags", "()[Ljava/lang/String;", "setTags", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toString", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingCategoryModel {
    private UrlModel icon;
    private String id;
    private String key;
    private String name;
    private String[] tags;
    private Integer type;

    public String toString() {
        StringBuilder r0 = new StringBuilder("RankingCategoryModel(id='");
        r0.append(getId());
        r0.append("', name='");
        r0.append(getName());
        r0.append("', icon=");
        r0.append(getIcon());
        r0.append(", key='");
        r0.append(getKey());
        r0.append("', type=");
        r0.append(getType());
        r0.append(", tags=");
        String[] r1 = getTags();
        if (r1 == null) goto L5;
        String r2 = Arrays.toString(r1);
    L6:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public UrlModel getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String[] getTags() {
        return this.tags;
    }

    public Integer getType() {
        return this.type;
    }

    public void setIcon(UrlModel r1) {
        this.icon = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setTags(String[] r1) {
        this.tags = r1;
    }

    public void setType(Integer r1) {
        this.type = r1;
    }

    public RankingCategoryModel(String r1, String r2, UrlModel r3, String r4, Integer r5, String[] r6) {
        this.id = r1;
        this.name = r2;
        this.icon = r3;
        this.key = r4;
        this.type = r5;
        this.tags = r6;
    }

    public /* synthetic */ RankingCategoryModel(String r13, String r14, UrlModel r15, String r16, Integer r17, String[] r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r19 & 4) == 0) goto L13;
        UrlModel r5 = new UrlModel(null, null, null, null, 15, null);
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r19 & 32) == 0) goto L21;
        String[] r8 = null;
    L22:
        this(r3, r4, r5, r6, r17, r8);
        return;
    L21:
        r8 = r18;
        goto L22
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }
}
