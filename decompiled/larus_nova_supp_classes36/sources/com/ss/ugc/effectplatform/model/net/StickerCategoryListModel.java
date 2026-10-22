package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J>\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/StickerCategoryListModel;", "", "id", "", "name", "", "icon_url", "Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;", "use_recommend", "", "(Ljava/lang/Long;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;Ljava/lang/Boolean;)V", "getIcon_url", "()Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;", "setIcon_url", "(Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getUse_recommend", "()Ljava/lang/Boolean;", "setUse_recommend", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;Ljava/lang/Boolean;)Lcom/ss/ugc/effectplatform/model/net/StickerCategoryListModel;", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class StickerCategoryListModel {
    private StickerUrlStruct icon_url;
    private Long id;
    private String name;
    private Boolean use_recommend;

    public StickerCategoryListModel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ StickerCategoryListModel copy$default(StickerCategoryListModel r0, Long r1, String r2, StickerUrlStruct r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.icon_url;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.use_recommend;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final StickerUrlStruct component3() {
        return this.icon_url;
    }

    public final Boolean component4() {
        return this.use_recommend;
    }

    public final StickerCategoryListModel copy(Long r2, String r3, StickerUrlStruct r4, Boolean r5) {
        return new StickerCategoryListModel(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof StickerCategoryListModel) == false) goto L14;
        StickerCategoryListModel r4 = (StickerCategoryListModel) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon_url, r4.icon_url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.use_recommend, r4.use_recommend) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Long r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        StickerUrlStruct r7 = this.icon_url;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.use_recommend;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "StickerCategoryListModel(id=" + this.id + ", name=" + this.name + ", icon_url=" + this.icon_url + ", use_recommend=" + this.use_recommend + ")";
    }

    public final StickerUrlStruct getIcon_url() {
        return this.icon_url;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getUse_recommend() {
        return this.use_recommend;
    }

    public final void setIcon_url(StickerUrlStruct r1) {
        this.icon_url = r1;
    }

    public final void setId(Long r1) {
        this.id = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setUse_recommend(Boolean r1) {
        this.use_recommend = r1;
    }

    public StickerCategoryListModel(Long r1, String r2, StickerUrlStruct r3, Boolean r4) {
        this.id = r1;
        this.name = r2;
        this.icon_url = r3;
        this.use_recommend = r4;
    }

    public /* synthetic */ StickerCategoryListModel(Long r2, String r3, StickerUrlStruct r4, Boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
