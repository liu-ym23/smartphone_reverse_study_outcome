package com.larus.platform.model.camera;

import com.larus.im.bean.conversation.BotConversationType;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\rH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010#\u001a\u00020\u001aH\u0002J\b\u0010$\u001a\u00020\u0001H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/larus/platform/model/camera/RealtimeCameraEventExt;", "Lcom/larus/platform/model/camera/ICameraEventExt;", "<init>", "()V", "ifCall", "", "getIfCall", "()Ljava/lang/Integer;", "setIfCall", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "businessGeneralParams", "", "", "", "getBusinessGeneralParams", "()Ljava/util/Map;", "setBusinessGeneralParams", "(Ljava/util/Map;)V", "chatKey", "", "getChatKey", "()J", "setChatKey", "(J)V", "enterCameraEventExt", "Lorg/json/JSONObject;", "cameraItemShowEventExt", "clickCameraButtonEventExt", "leaveCameraEventExt", "leaveCameraConfirmEventExt", "getConversationId", "getBotId", "getClickFrom", "getChatType", "getAllExtParams", "copy", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RealtimeCameraEventExt implements ICameraEventExt {
    private Map<String, ? extends Object> businessGeneralParams;
    private long chatKey;
    private Integer ifCall;

    public RealtimeCameraEventExt() {
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject clickAlbumOnCapturePageEventExt() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject enterPageEventExt() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    @BotConversationType
    public Integer getBotConversationType() {
        return 0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject getExtraParams() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String referenceFromType() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String referenceMessageId() {
        return null;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public void setEnterPageEvent(String r1, String r2) {
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        Map<String, ? extends Object> r1 = this.businessGeneralParams;
        if (r1 == null) goto L8;
        Iterator<Map.Entry<String, ? extends Object>> r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r3 = r2.next();
        r0.put(r3.getKey(), r3.getValue());
    L8:
        Integer r4 = this.ifCall;
        if (r4 == null) goto L11;
        r0.put("if_call", r4.intValue());
    L11:
        return r0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public ICameraEventExt copy() {
        RealtimeCameraEventExt r0 = new RealtimeCameraEventExt();
        r0.businessGeneralParams = this.businessGeneralParams;
        r0.ifCall = this.ifCall;
        return r0;
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getBotId() {
        Map<String, ? extends Object> r0 = this.businessGeneralParams;
        if (r0 == null) goto L5;
        Object r1 = r0.get("bot_id");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r1;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getChatType() {
        Map<String, ? extends Object> r0 = this.businessGeneralParams;
        if (r0 == null) goto L5;
        Object r1 = r0.get("chat_type");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r1;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getClickFrom() {
        Map<String, ? extends Object> r0 = this.businessGeneralParams;
        if (r0 == null) goto L5;
        Object r1 = r0.get("click_from");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r1;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public String getConversationId() {
        Map<String, ? extends Object> r0 = this.businessGeneralParams;
        if (r0 == null) goto L5;
        Object r1 = r0.get("conversation_id");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r1;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.platform.model.camera.ICameraEventExt
    public JSONObject cameraItemShowEventExt() {
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

    public final Map<String, Object> getBusinessGeneralParams() {
        return this.businessGeneralParams;
    }

    public final long getChatKey() {
        return this.chatKey;
    }

    public final Integer getIfCall() {
        return this.ifCall;
    }

    public final void setBusinessGeneralParams(Map<String, ? extends Object> r1) {
        this.businessGeneralParams = r1;
    }

    public final void setChatKey(long r1) {
        this.chatKey = r1;
    }

    public final void setIfCall(Integer r1) {
        this.ifCall = r1;
    }
}
