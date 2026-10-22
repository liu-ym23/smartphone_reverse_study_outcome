package com.larus.platform.model.camera;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001d\u001a\u00020\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u0005J\u0010\u0010%\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0010\u0010&\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0010\u0010'\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0010\u0010(\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u001c\u0010)\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020+H\u0016J\b\u0010/\u001a\u00020+H\u0016J\b\u00100\u001a\u00020+H\u0016J\b\u00101\u001a\u00020+H\u0016J\n\u00102\u001a\u0004\u0018\u00010+H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u00104\u001a\u0004\u0018\u00010\u0005H\u0016J\u000f\u00105\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u00106J\n\u00107\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00109\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020\u0001H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/platform/model/camera/IMCameraEventExt;", "Lcom/larus/platform/model/camera/ICameraEventExt;", "<init>", "()V", "botId", "", "botConversationType", "", "Ljava/lang/Integer;", "chatType", "conversationId", "chatKey", "", "templateId", "templateType", "clickFrom", "actionBarKey", "actionBarInstructionType", "actionBarInstructionItemsTemplate", "onboardingItemId", "recoRequestId", "previousPage", "referenceFromType", "referenceMessageId", "extraParams", "setChatInfo", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;J)V", "setTemplateInfo", "setClickFrom", "setActionBarKey", "setActionBarInstructionType", "(Ljava/lang/Integer;)V", "setActionBarInstructionItemsTemplate", "setOnboardingItemId", "setRecoRequestId", "requestId", "setPreviousPage", "setExtraParams", "setReferenceFromType", "setReferenceMessageId", "setEnterPageEvent", "enterPageEventExt", "Lorg/json/JSONObject;", "enterCameraEventExt", "cameraItemShowEventExt", "clickCameraButtonEventExt", "leaveCameraEventExt", "leaveCameraConfirmEventExt", "clickAlbumOnCapturePageEventExt", "getExtraParams", "getConversationId", "getBotId", "getBotConversationType", "()Ljava/lang/Integer;", "getClickFrom", "getChatType", "getAllExtParams", "copy", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class IMCameraEventExt implements ICameraEventExt {
    private String actionBarInstructionItemsTemplate;
    private Integer actionBarInstructionType;
    private String actionBarKey;
    private Integer botConversationType;
    private String botId;
    private long chatKey;
    private String chatType;
    private String clickFrom;
    private String conversationId;
    private String extraParams;
    private String onboardingItemId;
    private String previousPage;
    private String recoRequestId;
    private String referenceFromType;
    private String referenceMessageId;
    private String templateId;
    private String templateType;

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        String r1 = this.botId;
        if (r1 == null) goto L5;
        r0.put("bot_id", r1);
    L5:
        String r2 = this.chatType;
        if (r2 == null) goto L8;
        r0.put("chat_type", r2);
    L8:
        String r3 = this.clickFrom;
        if (r3 == null) goto L11;
        r0.put("click_from", r3);
    L11:
        String r4 = this.templateId;
        if (r4 == null) goto L14;
        r0.put("action_bar_template_id", r4);
    L14:
        String r5 = this.templateType;
        if (r5 == null) goto L17;
        r0.put("action_bar_template_type", r5);
    L17:
        String r6 = this.actionBarKey;
        if (r6 == null) goto L20;
        r0.put("action_bar_key", r6);
    L20:
        Integer r7 = this.actionBarInstructionType;
        if (r7 == null) goto L23;
        r0.put("action_bar_instruction_type", r7.intValue());
    L23:
        String r8 = this.actionBarInstructionItemsTemplate;
        if (r8 == null) goto L26;
        r0.put("action_bar_instruction_items_template", r8);
    L26:
        String r9 = this.onboardingItemId;
        if (r9 == null) goto L29;
        r0.put("onboarding_item_id", r9);
    L29:
        String r10 = this.recoRequestId;
        if (r10 == null) goto L32;
        r0.put("reco_request_id", r10);
    L32:
        String r11 = this.referenceFromType;
        if (r11 == null) goto L35;
        r0.put("cited_from_user_type", r11);
    L35:
        String r12 = this.referenceMessageId;
        if (r12 == null) goto L38;
        r0.put("cited_message_id", r12);
    L38:
        JSONObject r13 = getExtraParams();
        if (r13 == null) goto L48;
        String r14 = r13.optString("common_venue_type");
        if (r14 == null) goto L48;
        if ((!StringsKt.isBlank(r14)) == true) goto L46;
        r14 = null;
    L46:
        if (r14 == null) goto L48;
        r0.put("common_venue_type", r14);
    L48:
        return r0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public ICameraEventExt copy() {
        IMCameraEventExt r0 = new IMCameraEventExt();
        r0.botId = this.botId;
        r0.botConversationType = this.botConversationType;
        r0.chatType = this.chatType;
        r0.conversationId = this.conversationId;
        r0.clickFrom = this.clickFrom;
        r0.templateId = this.templateId;
        r0.templateType = this.templateType;
        r0.actionBarKey = this.actionBarKey;
        r0.actionBarInstructionType = this.actionBarInstructionType;
        r0.actionBarInstructionItemsTemplate = this.actionBarInstructionItemsTemplate;
        r0.onboardingItemId = this.onboardingItemId;
        r0.recoRequestId = this.recoRequestId;
        r0.chatKey = this.chatKey;
        r0.extraParams = this.extraParams;
        return r0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject enterPageEventExt() {
        JSONObject r0 = new JSONObject();
        String r1 = this.botId;
        if (r1 == null) goto L5;
        r0.put("bot_id", r1);
    L5:
        String r2 = this.chatType;
        if (r2 == null) goto L8;
        r0.put("chat_type", r2);
    L8:
        String r3 = this.clickFrom;
        if (r3 == null) goto L11;
        r0.put("enter_method", r3);
    L11:
        String r4 = this.previousPage;
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == true) goto L20;
        r0.put("previous_page", this.previousPage);
    L20:
        return r0;
    L14:
        if (r4.length() == 0) goto L17;
        r5 = false;
        goto L18
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject getExtraParams() {
        String r0 = this.extraParams;
        if (r0 != null) goto L9;
        return null;
    L9:
        return new JSONObject(r0);
    L11:
        return null;
    }

    public IMCameraEventExt() {
        this.botConversationType = 0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject cameraItemShowEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject clickAlbumOnCapturePageEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject clickCameraButtonEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject enterCameraEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject leaveCameraConfirmEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject leaveCameraEventExt() {
        return a();
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public long chatKey() {
        return this.chatKey;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public Integer getBotConversationType() {
        return this.botConversationType;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getBotId() {
        return this.botId;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getChatType() {
        return this.chatType;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getClickFrom() {
        return this.clickFrom;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getConversationId() {
        return this.conversationId;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String referenceFromType() {
        return this.referenceFromType;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String referenceMessageId() {
        return this.referenceMessageId;
    }

    public final void setActionBarInstructionItemsTemplate(String r1) {
        this.actionBarInstructionItemsTemplate = r1;
    }

    public final void setActionBarInstructionType(Integer r1) {
        this.actionBarInstructionType = r1;
    }

    public final void setActionBarKey(String r1) {
        this.actionBarKey = r1;
    }

    public final void setClickFrom(String r1) {
        this.clickFrom = r1;
    }

    public final void setExtraParams(String r1) {
        this.extraParams = r1;
    }

    public final void setOnboardingItemId(String r1) {
        this.onboardingItemId = r1;
    }

    public final void setPreviousPage(String r1) {
        this.previousPage = r1;
    }

    public final void setRecoRequestId(String r1) {
        this.recoRequestId = r1;
    }

    public final void setReferenceFromType(String r1) {
        this.referenceFromType = r1;
    }

    public final void setReferenceMessageId(String r1) {
        this.referenceMessageId = r1;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public void setEnterPageEvent(String r4, String r5) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        this.previousPage = r4;
    L11:
        if (r5 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == true) goto L18;
        this.clickFrom = r5;
        return;
    L18:
        return;
    L13:
        if (r5.length() != 0) goto L15;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void setTemplateInfo(String r1, String r2) {
        this.templateId = r1;
        this.templateType = r2;
    }

    public final void setChatInfo(String r1, Integer r2, String r3, String r4, long r5) {
        this.botId = r1;
        this.botConversationType = r2;
        this.chatType = r3;
        this.conversationId = r4;
        this.chatKey = r5;
    }
}
