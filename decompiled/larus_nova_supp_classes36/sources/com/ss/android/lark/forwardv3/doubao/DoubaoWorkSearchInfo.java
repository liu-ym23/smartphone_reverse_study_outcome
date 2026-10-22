package com.ss.android.lark.forwardv3.doubao;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/doubao/DoubaoWorkSearchInfo;", "Lcom/ss/android/lark/search/dto/info/SearchChatInfo;", "original", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "externalTargetId", "", "<init>", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Ljava/lang/String;)V", "copySearchMetadataFrom", "", "configureExternalTarget", "getEntityIdForReport", "getResultTypeForReport", "getSubResultTypeForReport", "getTagForReport", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoWorkSearchInfo extends SearchChatInfo {
    private final SearchBaseInfo original;

    public String getEntityIdForReport() {
        return this.original.getEntityIdForReport();
    }

    public String getResultTypeForReport() {
        return this.original.getResultTypeForReport();
    }

    public String getSubResultTypeForReport() {
        return this.original.getSubResultTypeForReport();
    }

    public String getTagForReport() {
        return this.original.getTagForReport();
    }

    public DoubaoWorkSearchInfo(SearchBaseInfo r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "original");
        Intrinsics.checkNotNullParameter(r4, "externalTargetId");
        this.original = r3;
        setSpotlightDataInServerPos(r3.getSpotlightDataInServerPos());
        setVoiceInput(r3.isVoiceInput());
        setValueForFeedback(r3.getValueForFeedback());
        setSpotlight(r3.isSpotlight());
        setOnlySpotlight(r3.isOnlySpotlight());
        setFirstInfoForInit(r3.isFirstInfoForInit());
        setSectionType(r3.getSectionType());
        setSectionResult(r3.isSectionResult());
        setSectionID(r3.getSectionID());
        setTitle(r3.getTitle());
        setTitleHitTerms(r3.getTitleHitTerms());
        setSubTitleHitTerms(r3.getSubTitleHitTerms());
        setSubTitle(r3.getSubTitle());
        setSingleChoice(r3.isSingleChoice());
        setHeaderLabel(r3.getHeaderLabel());
        setHasMore(r3.isHasMore());
        setShowBadge(r3.isShowBadge());
        setNewMsgCount(r3.getNewMsgCount());
        setRemind(r3.isRemind());
        setCrossTenant(r3.isCrossTenant());
        setExtraTitle(r3.getExtraTitle());
        setExtraTitleHitTerms(r3.getExtraTitleHitTerms());
        setImprId(r3.getImprId());
        setSession(r3.getSession());
        setRequestId(r3.getRequestId());
        setBid(r3.getBid());
        setEntityType(r3.getEntityType());
        setScene(r3.getScene());
        setSource(r3.getSource());
        setDataSource(r3.getDataSource());
        setGuessYouWant(r3.isGuessYouWant());
        setChatInsideShow(r3.isChatInsideShow());
        setCrossWithKa(r3.isCrossWithKa());
        setTitleTagList(r3.getTitleTagList());
        setSubTitleTagList(r3.getSubTitleTagList());
        setExtraTitleTagList(r3.getExtraTitleTagList());
        setExtraInfoSummary(r3.getExtraInfoSummary());
        setQuery(r3.getQuery());
        setFilterStatus(r3.getFilterStatus());
        setGrammarType(r3.getGrammarType());
        setPickerShow(r3.isPickerShow());
        setSearchLocation(r3.getSearchLocation());
        setClickEventExtraParams(r3.getClickEventExtraParams());
        setShowEventExtraParams(r3.getShowEventExtraParams());
        setBaseOnResult(r3.isBaseOnResult());
        setAvatarStyle(r3.getAvatarStyle());
        setOwnedCardTitle(r3.getOwnedCardTitle());
        setTagData(r3.getTagData());
        setSourceType(r3.getSourceType());
        setMatchedChineseNameSegment(r3.getMatchedChineseNameSegment());
        setTrackingMeta(r3.getTrackingMeta());
        setRecallScene(r3.getRecallScene());
        setPbType(r3.getPbType());
        setRawTitle(r3.getRawTitle());
        setTimeStamp(r3.getTimeStamp());
        selected(r3.isSelected());
        required(r3.isRequired());
        setId(r4);
        setHeaderId(0);
        setExplanationTags(CollectionsKt.emptyList());
        setUserCountVisible(false);
        setAvatarKey("");
        Map r5 = r3.getExtraParams();
        if (r5 != null) goto L5;
        r5 = MapsKt.emptyMap();
    L5:
        setExtraParams(MapsKt.plus(r5, TuplesKt.to("external_target_avatar_provider_marker", Boolean.TRUE)));
    }
}
