package com.obric.flow.cardlistpage.base;

import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\b\u0017\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0019R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/obric/flow/cardlistpage/base/BaseCardModel;", "", "id", "", "originalId", "type", "Lcom/obric/flow/cardlistpage/base/CardType;", "spanX", "", "spanY", Constant.TITLE, Constant.DESCRIPTION, "isVisible", "", "sortIndex", "createTime", "", "modifyTime", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/flow/cardlistpage/base/CardType;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDescription", "()Ljava/lang/String;", "getId", "()Z", "getModifyTime", "getOriginalId", "getSortIndex", "()Ljava/lang/Integer;", "setSortIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSpanX", "()I", "getSpanY", "getTitle", "getType", "()Lcom/obric/flow/cardlistpage/base/CardType;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BaseCardModel {
    private final Long createTime;
    private final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f11457id;
    private final boolean isVisible;
    private final Long modifyTime;
    private final String originalId;
    private Integer sortIndex;
    private final int spanX;
    private final int spanY;
    private final String title;
    private final CardType type;

    public BaseCardModel(String r5, String r10, CardType r11, int r12, int r13, String r14, String r15, boolean r16, Integer r17, Long r18, Long r19) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r10, "originalId");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r14, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r15, Constant.DESCRIPTION);
        this.f11457id = r5;
        this.originalId = r10;
        this.type = r11;
        this.spanX = r12;
        this.spanY = r13;
        this.title = r14;
        this.description = r15;
        this.isVisible = r16;
        this.sortIndex = r17;
        this.createTime = r18;
        this.modifyTime = r19;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.f11457id;
    }

    public Long getModifyTime() {
        return this.modifyTime;
    }

    public String getOriginalId() {
        return this.originalId;
    }

    public Integer getSortIndex() {
        return this.sortIndex;
    }

    public int getSpanX() {
        return this.spanX;
    }

    public int getSpanY() {
        return this.spanY;
    }

    public String getTitle() {
        return this.title;
    }

    public CardType getType() {
        return this.type;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setSortIndex(Integer r5) {
        this.sortIndex = r5;
    }

    public /* synthetic */ BaseCardModel(String r16, String r17, CardType r18, int r19, int r20, String r21, String r22, boolean r23, Integer r24, Long r25, Long r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 32) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r27 & 64) == 0) goto L9;
        String r11 = "";
    L11:
        if ((r27 & 128) == 0) goto L13;
        boolean r12 = true;
    L15:
        if ((r27 & 256) == 0) goto L17;
        Integer r13 = null;
    L19:
        if ((r27 & 512) == 0) goto L21;
        Long r14 = null;
    L23:
        if ((r27 & 1024) == 0) goto L25;
        Long r15 = null;
    L26:
        this(r16, r17, r18, r19, r20, r10, r11, r12, r13, r14, r15);
        return;
    L25:
        r15 = r26;
        goto L26
    L21:
        r14 = r25;
        goto L23
    L17:
        r13 = r24;
        goto L19
    L13:
        r12 = r23;
        goto L15
    L9:
        r11 = r22;
        goto L11
    L5:
        r10 = r21;
        goto L7
    }
}
