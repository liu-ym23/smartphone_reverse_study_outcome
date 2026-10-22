package com.larus.bmhome.view.actionbar.edit;

import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.platform.kmp.chat.TemplateInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface c {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c r10, z0 r11, r r12, int r13, String r14, aq8.e r15, Integer r16, Function0 r17, int r18) {
            if ((r18 & 8) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r18 & 16) == 0) goto L9;
            aq8.e r7 = null;
        L11:
            if ((r18 & 32) == 0) goto L13;
            Integer r8 = null;
        L15:
            if ((r18 & 64) == 0) goto L17;
            Function0 r9 = null;
        L18:
            r10.onActionBarInstructionChanged(r11, r12, r13, r6, r7, r8, r9);
            return;
        L17:
            r9 = r17;
            goto L18
        L13:
            r8 = r16;
            goto L15
        L9:
            r7 = r15;
            goto L11
        L5:
            r6 = r14;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(c r10, boolean r11, boolean r12, boolean r13, ArrayList r14, boolean r15, boolean r16, int r17, int r18) {
            if ((r18 & 4) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r18 & 8) == 0) goto L9;
            ArrayList r6 = new ArrayList();
        L11:
            if ((r18 & 16) == 0) goto L13;
            boolean r7 = false;
        L15:
            if ((r18 & 32) == 0) goto L17;
            boolean r8 = false;
        L19:
            if ((r18 & 64) == 0) goto L21;
            int r9 = 0;
        L22:
            r10.onMediaContainerStatusChanged(r11, r12, r5, r6, r7, r8, r9);
            return;
        L21:
            r9 = r17;
            goto L22
        L17:
            r8 = r16;
            goto L19
        L13:
            r7 = r15;
            goto L15
        L9:
            r6 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L7
        }
    }

    void bindChatParam(ChatParam r1);

    d1<aq8.j> getActionBarInstructionChanged();

    d1<Boolean> getActionBarInstructionInputSendReady();

    Boolean getActionBarInstructionInputSendReadyState();

    String getActionBarName();

    String getActionBarType();

    i1<List<ResourceItemBean>> getAttachmentResources();

    d1<Unit> getAvatarBtnCancelFlow();

    d1<Boolean> getAvatarBtnClickFlow();

    ChatParam getChatParam();

    d1<String> getChosenAvatarInstructionFlow();

    i1<Boolean> getChosenAvatarInstructionStatus();

    d1<fq8.e> getChosenImgInspirationFlow();

    fq8.e getChosenImgInspirePrompt();

    p1 getChosenMsgInstruction();

    d1<p1> getChosenMsgInstructionFlow();

    d1<Pair<ConstraintLayout, Boolean>> getComponentVisibilityChangedFlow();

    List<w> getCurImageList();

    z0 getCurrentCustomActionBarItem();

    r getCurrentInstructionConf();

    r getCurrentInstructionUsuallyConfig();

    CoroutineScope getCurrentViewModelScope();

    Long getDefaultSelectedImageStyleId();

    d1<Triple<ab8.a, Integer, String>> getDigitalAvatarTemplateChooseFlow();

    Function0<Boolean> getDropDownSelectorClickInterceptor();

    i1<Boolean> getEnableOriginalRatioFlow();

    i1<ArrayList<Integer>> getHideInstructionFlow();

    String getHintStr(int r1, int r2);

    d1<List<w>> getImageListSelectorWithMoreRefreshFlow();

    d1<String> getInputBoxHintChanged();

    Map<String, ?> getInstructionDefaultParams();

    d1<com.larus.bmhome.actionbar.model.f> getInstructionDigitalAvatarTemplatePrompt();

    d1<Boolean> getInstructionFeatureDialogDismiss();

    d1<String> getInstructionFeatureSelectedForPrompt();

    d1<String> getInstructionFeatureUnSelectedForPrompt();

    String getInstructionInputBoxHint();

    d1<Boolean> getInstructionMusicTemplateDetailOpen();

    d1<bq8.a> getInstructionMusicTemplatePrompt();

    d1<m> getInstructionPhotoTemplatePrompt();

    r getInstructionRebuildStateConf();

    AttachmentInfo getInstructionReferenceImage();

    i1<Integer> getInstructionReferenceImageUploadStatus();

    i1<Integer> getInstructionSelectMenuPosition();

    d1<i0> getInstructionTabSelected();

    Integer getInstructionType();

    d1<String> getInstructionVideoTemplatePrompt();

    Flow<Unit> getJumpToCompleteVideoAvatarEvent();

    i1<Boolean> getMediaSelectedFlow();

    t1 getOptionParamFilterConf();

    d1<t1> getOptionParamFilterConfChanged();

    boolean getRatioCanBeEmpty();

    List<w> getRatioOptionList();

    d1<Unit> getResetImageStyleListFlow();

    d1<o> getSelectDurationFlow();

    i1<p> getSelectModelFlow();

    d1<q> getSelectRatioFlow();

    i1<p> getSelectVideoModelFlow();

    Map<Integer, Long> getSelectedClickRatioIdRegistry();

    Long getSelectedRatioId();

    Long getSelectedVideoModelId();

    i1<Long> getSelectedVideoStyle();

    String getTemplateType();

    Function0<Boolean> getVideoModelDropDownSelectorClickInterceptor();

    Function2<Long, Boolean, Boolean> getVideoModelSelectionInterceptor();

    Boolean isCreationActionBar();

    boolean isInVideoTab();

    void markInputSendReadyState(boolean r1);

    void onActionBarInstructionChanged(z0 r1, r r2, int r3, String r4, aq8.e r5, Integer r6, Function0<Unit> r7);

    void onAvatarBtnCancel();

    void onAvatarBtnClick(boolean r1);

    void onAvatarInstructionClicked(String r1);

    void onComponentVisibilityChanged(Object r1, boolean r2);

    void onDigitalAvatarTemplateChoose(ab8.a r1, int r2, String r3);

    void onFeatureOptionDialogDismiss();

    void onFeatureOptionSelected(w r1);

    void onFeatureOptionUnSelected(w r1);

    void onImgInspirationClick(fq8.e r1);

    void onInputBoxTextChanged(String r1);

    void onInputHintChanged(String r1, String r2);

    void onInstructionDigitalAvatarTemplateSelected(com.larus.bmhome.actionbar.model.f r1);

    void onInstructionImageTemplateSelected(TemplateInfo.TemplateInfo r1, Uri r2);

    void onInstructionMusicTemplateSelected(bq8.a r1);

    void onInstructionReferenceImageChanged(AttachmentInfo r1);

    void onInstructionReferenceImageUploadStatus(int r1);

    void onMediaContainerStatusChanged(boolean r1, boolean r2, boolean r3, ArrayList<Integer> r4, boolean r5, boolean r6, int r7);

    void onMsgInstructionClicked(p1 r1);

    void onMusicDetailDialogDismiss();

    void onMusicDetailDialogOpen();

    void onParamFilterConfChanged(t1 r1);

    void onTabSelected(i0 r1);

    void refreshImageListSelectorWithMore(List<w> r1);

    void selectDuration(long r1);

    void selectInstructionMenu(int r1);

    boolean selectModel(int r1, long r2);

    void selectRatio(int r1, long r2);

    void selectRatio(long r1);

    boolean selectVideoModel(long r1);

    void selectedVideoStyleItem(long r1);

    void setActionBarInstructionInputSendReady(boolean r1);

    void setActionBarName(String r1, String r2, String r3);

    void setChosenAvatarInstructionStatus(boolean r1);

    void setChosenImgInspirePrompt(fq8.e r1);

    void setChosenMsgInstruction(p1 r1);

    void setCreationActionBar(Boolean r1);

    void setCurImageList(List<w> r1);

    void setCurrentCustomActionBarItem(z0 r1);

    void setCurrentInstructionConfig(r r1);

    void setDefaultSelectedImageStyleId(Long r1);

    void setEnableResetTemplateCacheAfterDetach(boolean r1);

    void setImageStyleRadioSelected(boolean r1);

    void setMsgExtMap(Map<String, String> r1, String r2);

    void setOptionParamFilterConf(t1 r1);

    void setOriginalRatioEnable(boolean r1);

    void setRatioCanBeEmpty(boolean r1);

    void setRatioDropDownSelectorClickInterceptor(Function0<Boolean> r1);

    void setRatioOptionList(List<w> r1);

    void setSelectedRatioId(Long r1);

    void setVideoModelDropDownSelectorClickInterceptor(Function0<Boolean> r1);

    void setVideoModelSelectionInterceptor(Function2<? super Long, ? super Boolean, Boolean> r1);

    void syncVideoModel(long r1);

    void updateAttachmentResources(List<ResourceItemBean> r1);

    void updateInputBoxPlaceHolder(int r1, h1 r2);
}
