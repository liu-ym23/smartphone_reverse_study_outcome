package com.obric.flow.cardlistpage.data;

import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001(Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\b\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u000b\u0010\u001dR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b&\u0010%¨\u0006)"}, d2 = {"Lcom/obric/flow/cardlistpage/data/TravelCardModel;", "Lcom/obric/flow/cardlistpage/base/BaseCardModel;", "", "id", "originalId", "", "spanX", "spanY", Constant.TITLE, Constant.DESCRIPTION, "", "isVisible", "sortIndex", "", "createTime", "modifyTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getOriginalId", "I", "getSpanX", "()I", "getSpanY", "getTitle", "getDescription", "Z", "()Z", "Ljava/lang/Integer;", "getSortIndex", "()Ljava/lang/Integer;", "setSortIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Long;", "getCreateTime", "()Ljava/lang/Long;", "getModifyTime", "Companion", "com/obric/flow/cardlistpage/data/s", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TravelCardModel extends BaseCardModel {
    public static final s Companion = null;
    public static final String ORIGINAL_ID = "external:travel";
    private final Long createTime;
    private final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f11467id;
    private final boolean isVisible;
    private final Long modifyTime;
    private final String originalId;
    private Integer sortIndex;
    private final int spanX;
    private final int spanY;
    private final String title;

    static {
        Companion = new s();
    }

    public /* synthetic */ TravelCardModel(String r11, String r12, int r13, int r14, String r15, String r16, boolean r17, Integer r18, Long r19, Long r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 2) == 0) goto L5;
        String r5 = ORIGINAL_ID;
    L6:
        int r10 = 4;
        if ((r21 & 4) == 0) goto L9;
        int r23 = 4;
    L11:
        if ((r21 & 8) != 0) goto L14;
        r10 = r14;
    L14:
        String r24 = "";
        if ((r21 & 16) == 0) goto L17;
        String r25 = "";
    L19:
        if ((r21 & 32) != 0) goto L23;
        r24 = r16;
    L23:
        if ((r21 & 64) == 0) goto L25;
        boolean r26 = true;
    L26:
        Long r27 = null;
        if ((r21 & 128) == 0) goto L29;
        Integer r28 = null;
    L31:
        if ((r21 & 256) == 0) goto L33;
        Long r29 = null;
    L35:
        if ((r21 & 512) != 0) goto L38;
        r27 = r20;
    L38:
        this(r11, r5, r23, r10, r25, r24, r26, r28, r29, r27);
        return;
    L33:
        r29 = r19;
        goto L35
    L29:
        r28 = r18;
        goto L31
    L25:
        r26 = r17;
        goto L26
    L17:
        r25 = r15;
        goto L19
    L9:
        r23 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L6
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
        return this.f11467id;
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

    public TravelCardModel(String r17, String r18, int r19, int r20, String r21, String r22, boolean r23, Integer r24, Long r25, Long r26) {
        Intrinsics.checkNotNullParameter(r17, "id");
        Intrinsics.checkNotNullParameter(r18, "originalId");
        Intrinsics.checkNotNullParameter(r21, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r22, Constant.DESCRIPTION);
        super(r17, r18, CardType.CUSTOM, r19, r20, r21, r22, r23, r24, r25, r26);
        this.f11467id = r17;
        this.originalId = r18;
        this.spanX = r19;
        this.spanY = r20;
        this.title = r21;
        this.description = r22;
        this.isVisible = r23;
        this.sortIndex = r24;
        this.createTime = r25;
        this.modifyTime = r26;
    }
}
