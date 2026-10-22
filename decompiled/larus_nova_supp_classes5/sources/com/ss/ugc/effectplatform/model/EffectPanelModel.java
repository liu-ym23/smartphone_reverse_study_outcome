package com.ss.ugc.effectplatform.model;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001e\u001a\u00020\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006 "}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "", "text", "", "id", "icon", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "tags", "", "tags_updated_at", DBDefinition.EXTRA, "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getIcon", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setIcon", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getId", "setId", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTags_updated_at", "setTags_updated_at", "getText", "setText", "checkValued", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectPanelModel {
    private String extra;
    private UrlModel icon;
    private String id;
    private List<String> tags;
    private String tags_updated_at;
    private String text;

    public EffectPanelModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final boolean checkValued() {
        if (getIcon() != null) goto L7;
        setIcon(new UrlModel(null, null, null, null, 15, null));
        return true;
    L7:
        return true;
    }

    public String getExtra() {
        return this.extra;
    }

    public UrlModel getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTags_updated_at() {
        return this.tags_updated_at;
    }

    public String getText() {
        return this.text;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setIcon(UrlModel r1) {
        this.icon = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setTags(List<String> r1) {
        this.tags = r1;
    }

    public void setTags_updated_at(String r1) {
        this.tags_updated_at = r1;
    }

    public void setText(String r1) {
        this.text = r1;
    }

    public EffectPanelModel(String r1, String r2, UrlModel r3, List<String> r4, String r5, String r6) {
        this.text = r1;
        this.id = r2;
        this.icon = r3;
        this.tags = r4;
        this.tags_updated_at = r5;
        this.extra = r6;
    }

    public /* synthetic */ EffectPanelModel(String r12, String r13, UrlModel r14, List r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r1 = null;
        if ((r18 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        UrlModel r3 = new UrlModel(null, null, null, null, 15, null);
    L15:
        if ((r18 & 8) == 0) goto L17;
        List r4 = new ArrayList();
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r5 = null;
    L23:
        if ((r18 & 32) != 0) goto L26;
        r1 = r17;
    L26:
        this(r0, r2, r3, r4, r5, r1);
        return;
    L21:
        r5 = r16;
        goto L23
    L17:
        r4 = r15;
        goto L19
    L13:
        r3 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r0 = r12;
        goto L7
    }
}
