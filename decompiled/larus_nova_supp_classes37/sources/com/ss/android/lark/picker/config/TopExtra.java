package com.ss.android.lark.picker.config;

import com.bytedance.lark.pb.search.v2.BaseEntity;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.Scene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u00101\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$¨\u0006<"}, d2 = {"Lcom/ss/android/lark/picker/config/TopExtra;", "Lcom/ss/android/lark/picker/config/Extra;", "<init>", "()V", "needInsertDoubaoWork", "", "getNeedInsertDoubaoWork", "()Ljava/lang/Boolean;", "setNeedInsertDoubaoWork", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "searchExtrasString", "", "getSearchExtrasString", "()Ljava/lang/String;", "setSearchExtrasString", "(Ljava/lang/String;)V", "queryInputState", "", "getQueryInputState", "()I", "setQueryInputState", "(I)V", "queryCompositionInfo", "Lcom/bytedance/lark/pb/search/v2/BaseEntity$SearchExtras$QueryCompositionInfo;", "getQueryCompositionInfo", "()Lcom/bytedance/lark/pb/search/v2/BaseEntity$SearchExtras$QueryCompositionInfo;", "setQueryCompositionInfo", "(Lcom/bytedance/lark/pb/search/v2/BaseEntity$SearchExtras$QueryCompositionInfo;)V", "impressionId", "getImpressionId", "setImpressionId", "needShowPath", "getNeedShowPath", "()Z", "setNeedShowPath", "(Z)V", "enableFolder", "getEnableFolder", "setEnableFolder", "explanationTagEnable", "getExplanationTagEnable", "setExplanationTagEnable", "renderDataEnable", "getRenderDataEnable", "setRenderDataEnable", "enableSpotlight", "getEnableSpotlight", "setEnableSpotlight", "spotlightTag", "getSpotlightTag", "setSpotlightTag", "searchScene", "Lcom/ss/android/lark/search/dto/Scene$Type;", "getSearchScene", "()Lcom/ss/android/lark/search/dto/Scene$Type;", "setSearchScene", "(Lcom/ss/android/lark/search/dto/Scene$Type;)V", "isForceServer", "setForceServer", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class TopExtra implements Extra {
    private boolean enableFolder;
    private boolean enableSpotlight;
    private boolean explanationTagEnable;
    private String impressionId;
    private boolean isForceServer;
    private Boolean needInsertDoubaoWork;
    private boolean needShowPath;
    private transient BaseEntity.SearchExtras.QueryCompositionInfo queryCompositionInfo;
    private int queryInputState;
    private boolean renderDataEnable;
    private String searchExtrasString;
    private Scene.Type searchScene;
    private String spotlightTag;

    public TopExtra() {
        this.enableSpotlight = true;
        this.spotlightTag = PickerStatistics.Scene.Unknown.getValue();
        this.searchScene = Scene.Type.SEARCH_GLOBAL;
    }

    public final boolean getEnableFolder() {
        return this.enableFolder;
    }

    public final boolean getEnableSpotlight() {
        return this.enableSpotlight;
    }

    public final boolean getExplanationTagEnable() {
        return this.explanationTagEnable;
    }

    public final String getImpressionId() {
        return this.impressionId;
    }

    public final Boolean getNeedInsertDoubaoWork() {
        return this.needInsertDoubaoWork;
    }

    public final boolean getNeedShowPath() {
        return this.needShowPath;
    }

    public final BaseEntity.SearchExtras.QueryCompositionInfo getQueryCompositionInfo() {
        return this.queryCompositionInfo;
    }

    public final int getQueryInputState() {
        return this.queryInputState;
    }

    public final boolean getRenderDataEnable() {
        return this.renderDataEnable;
    }

    public final String getSearchExtrasString() {
        return this.searchExtrasString;
    }

    public final Scene.Type getSearchScene() {
        return this.searchScene;
    }

    public final String getSpotlightTag() {
        return this.spotlightTag;
    }

    public final boolean isForceServer() {
        return this.isForceServer;
    }

    public final void setEnableFolder(boolean r1) {
        this.enableFolder = r1;
    }

    public final void setEnableSpotlight(boolean r1) {
        this.enableSpotlight = r1;
    }

    public final void setExplanationTagEnable(boolean r1) {
        this.explanationTagEnable = r1;
    }

    public final void setForceServer(boolean r1) {
        this.isForceServer = r1;
    }

    public final void setImpressionId(String r1) {
        this.impressionId = r1;
    }

    public final void setNeedInsertDoubaoWork(Boolean r1) {
        this.needInsertDoubaoWork = r1;
    }

    public final void setNeedShowPath(boolean r1) {
        this.needShowPath = r1;
    }

    public final void setQueryCompositionInfo(BaseEntity.SearchExtras.QueryCompositionInfo r1) {
        this.queryCompositionInfo = r1;
    }

    public final void setQueryInputState(int r1) {
        this.queryInputState = r1;
    }

    public final void setRenderDataEnable(boolean r1) {
        this.renderDataEnable = r1;
    }

    public final void setSearchExtrasString(String r1) {
        this.searchExtrasString = r1;
    }

    public final void setSearchScene(Scene.Type r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchScene = r2;
    }

    public final void setSpotlightTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.spotlightTag = r2;
    }
}
