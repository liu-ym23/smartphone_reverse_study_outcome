package com.larus.platform.model.camera;

import com.larus.im.bean.conversation.BotConversationType;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0018\u001a\u00020\u0019H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/camera/ICameraEventExt;", "Ljava/io/Serializable;", "setEnterPageEvent", "", "previousPage", "", "clickFrom", "enterPageEventExt", "Lorg/json/JSONObject;", "enterCameraEventExt", "cameraItemShowEventExt", "clickCameraButtonEventExt", "leaveCameraConfirmEventExt", "leaveCameraEventExt", "clickAlbumOnCapturePageEventExt", "getExtraParams", "getConversationId", "getBotConversationType", "", "()Ljava/lang/Integer;", "getBotId", "getClickFrom", "getChatType", "copy", "chatKey", "", "referenceFromType", "referenceMessageId", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICameraEventExt extends Serializable {
    public static final a Companion = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }

    JSONObject cameraItemShowEventExt();

    long chatKey();

    JSONObject clickAlbumOnCapturePageEventExt();

    JSONObject clickCameraButtonEventExt();

    ICameraEventExt copy();

    JSONObject enterCameraEventExt();

    JSONObject enterPageEventExt();

    @BotConversationType
    Integer getBotConversationType();

    String getBotId();

    String getChatType();

    String getClickFrom();

    String getConversationId();

    JSONObject getExtraParams();

    JSONObject leaveCameraConfirmEventExt();

    JSONObject leaveCameraEventExt();

    String referenceFromType();

    String referenceMessageId();

    void setEnterPageEvent(String r1, String r2);
}
