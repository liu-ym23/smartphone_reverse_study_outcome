package com.obric.flow.cardlistpage.data;

import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\b\u0017\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u0006#"}, d2 = {"Lcom/obric/flow/cardlistpage/data/WidgetCardModel;", "Lcom/obric/flow/cardlistpage/base/BaseCardModel;", "id", "", "originalId", "spanX", "", "spanY", Constant.TITLE, Constant.DESCRIPTION, "isVisible", "", "sortIndex", "createTime", "", "modifyTime", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDescription", "()Ljava/lang/String;", "getId", "()Z", "getModifyTime", "getOriginalId", "getSortIndex", "()Ljava/lang/Integer;", "setSortIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSpanX", "()I", "getSpanY", "getTitle", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class WidgetCardModel extends BaseCardModel {
    private final Long createTime;
    private final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f11468id;
    private final boolean isVisible;
    private final Long modifyTime;
    private final String originalId;
    private Integer sortIndex;
    private final int spanX;
    private final int spanY;
    private final String title;

    public WidgetCardModel(String r20, String r21, int r22, int r23, String r24, String r25, boolean r26, Integer r27, Long r28, Long r29) {
        Intrinsics.checkNotNullParameter(r20, "id");
        Intrinsics.checkNotNullParameter(r21, "originalId");
        Intrinsics.checkNotNullParameter(r24, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r25, Constant.DESCRIPTION);
        super(r20, r21, CardType.WIDGET, r22, r23, r24, null, false, null, null, null, 1984, null);
        this.f11468id = r20;
        this.originalId = r21;
        this.spanX = r22;
        this.spanY = r23;
        this.title = r24;
        this.description = r25;
        this.isVisible = r26;
        this.sortIndex = r27;
        this.createTime = r28;
        this.modifyTime = r29;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public Long getCreateTime() {
        return this.createTime;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public String getDescription() {
        return this.description;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public String getId() {
        return this.f11468id;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public Long getModifyTime() {
        return this.modifyTime;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public String getOriginalId() {
        return this.originalId;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public Integer getSortIndex() {
        return this.sortIndex;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public int getSpanX() {
        return this.spanX;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public int getSpanY() {
        return this.spanY;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public String getTitle() {
        return this.title;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public boolean isVisible() {
        return this.isVisible;
    }

    @Override // com.obric.flow.cardlistpage.base.BaseCardModel
    public void setSortIndex(Integer r5) {
        this.sortIndex = r5;
    }
}
