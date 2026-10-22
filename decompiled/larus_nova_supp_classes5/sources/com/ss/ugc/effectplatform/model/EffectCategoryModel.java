package com.ss.ugc.effectplatform.model;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\b\u0017\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0002\u0010\u0013J\u0006\u00105\u001a\u00020\u000eR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001d¨\u00066"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "", "id", "", DBDefinition.NAME, "key", "icon", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "icon_selected", "effects", "", "tags", "tags_updated_at", "is_default", "", DBDefinition.EXTRA, "parent_category", "", "children_categories", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ILjava/util/List;)V", "getChildren_categories", "()Ljava/util/List;", "setChildren_categories", "(Ljava/util/List;)V", "getEffects", "setEffects", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getIcon", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setIcon", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getIcon_selected", "setIcon_selected", "getId", "setId", "()Z", "set_default", "(Z)V", "getKey", "setKey", "getName", "setName", "getParent_category", "()I", "setParent_category", "(I)V", "getTags", "setTags", "getTags_updated_at", "setTags_updated_at", "checkValued", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectCategoryModel {
    private List<Integer> children_categories;
    private List<String> effects;
    private String extra;
    private UrlModel icon;
    private UrlModel icon_selected;
    private String id;
    private boolean is_default;
    private String key;
    private String name;
    private int parent_category;
    private List<String> tags;
    private String tags_updated_at;

    public EffectCategoryModel() {
        this(null, null, null, null, null, null, null, null, false, null, 0, null, 4095, null);
    }

    public final boolean checkValued() {
        if (getIcon() != null) goto L6;
        setIcon(new UrlModel(null, null, null, null, 15, null));
    L6:
        if (getIcon() != null) goto L8;
    L14:
        return false;
    L8:
        if (getIcon_selected() != null) goto L11;
        setIcon_selected(new UrlModel(null, null, null, null, 15, null));
    L11:
        if (getIcon_selected() == null) goto L14;
        return !Intrinsics.areEqual(getId(), "");
    }

    public List<Integer> getChildren_categories() {
        return this.children_categories;
    }

    public List<String> getEffects() {
        return this.effects;
    }

    public String getExtra() {
        return this.extra;
    }

    public UrlModel getIcon() {
        return this.icon;
    }

    public UrlModel getIcon_selected() {
        return this.icon_selected;
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

    public int getParent_category() {
        return this.parent_category;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTags_updated_at() {
        return this.tags_updated_at;
    }

    public boolean is_default() {
        return this.is_default;
    }

    public void setChildren_categories(List<Integer> r1) {
        this.children_categories = r1;
    }

    public void setEffects(List<String> r1) {
        this.effects = r1;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setIcon(UrlModel r1) {
        this.icon = r1;
    }

    public void setIcon_selected(UrlModel r1) {
        this.icon_selected = r1;
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

    public void setParent_category(int r1) {
        this.parent_category = r1;
    }

    public void setTags(List<String> r1) {
        this.tags = r1;
    }

    public void setTags_updated_at(String r1) {
        this.tags_updated_at = r1;
    }

    public void set_default(boolean r1) {
        this.is_default = r1;
    }

    public EffectCategoryModel(String r1, String r2, String r3, UrlModel r4, UrlModel r5, List<String> r6, List<String> r7, String r8, boolean r9, String r10, int r11, List<Integer> r12) {
        this.id = r1;
        this.name = r2;
        this.key = r3;
        this.icon = r4;
        this.icon_selected = r5;
        this.effects = r6;
        this.tags = r7;
        this.tags_updated_at = r8;
        this.is_default = r9;
        this.extra = r10;
        this.parent_category = r11;
        this.children_categories = r12;
    }

    public /* synthetic */ EffectCategoryModel(String r14, String r15, String r16, UrlModel r17, UrlModel r18, List r19, List r20, String r21, boolean r22, String r23, int r24, List r25, int r26, DefaultConstructorMarker r27) {
        String r2 = "";
        if ((r26 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r26 & 4) != 0) goto L14;
        r2 = r16;
    L14:
        String r5 = null;
        if ((r26 & 8) == 0) goto L17;
        UrlModel r4 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        UrlModel r6 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        List r7 = new ArrayList();
    L27:
        if ((r26 & 64) == 0) goto L29;
        List r8 = new ArrayList();
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = null;
    L34:
        int r11 = 0;
        if ((r26 & 256) == 0) goto L37;
        boolean r10 = false;
    L39:
        if ((r26 & 512) != 0) goto L43;
        r5 = r23;
    L43:
        if ((r26 & 1024) != 0) goto L47;
        r11 = r24;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        List r0 = new ArrayList();
    L50:
        this(r1, r3, r2, r4, r6, r7, r8, r9, r10, r5, r11, r0);
        return;
    L49:
        r0 = r25;
        goto L50
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L34
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r4 = r17;
        goto L19
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
