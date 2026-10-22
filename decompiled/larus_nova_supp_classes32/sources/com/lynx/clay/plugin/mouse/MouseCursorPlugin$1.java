package com.lynx.clay.plugin.mouse;

import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.lynx.tasm.event.LynxTouchEvent;
import com.mammon.speechaudiosdk.jni.enums.SpeechNativePropertyId;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class MouseCursorPlugin$1 extends HashMap<String, Integer> {
    private static final long serialVersionUID = 1;
    final /* synthetic */ a this$0;

    public MouseCursorPlugin$1(a r6) {
        put("alias", Integer.valueOf(SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_WAKEUP_INTENT_RESULT));
        put("allScroll", 1013);
        put("basic", 1000);
        put("cell", Integer.valueOf(SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_LOUDNESS_RESET));
        put(LynxTouchEvent.EVENT_CLICK, 1002);
        put("contextMenu", 1001);
        put("copy", 1011);
        put("forbidden", 1012);
        put("grab", 1020);
        put("grabbing", 1021);
        put("help", 1003);
        put("move", 1013);
        put(VoiceDisplayScene.NONE, 0);
        put("noDrop", 1012);
        put("precise", Integer.valueOf(SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_PLAYER_EVENT));
        put("text", 1008);
        put("resizeColumn", 1014);
        put("resizeDown", 1015);
        put("resizeUpLeft", 1016);
        put("resizeDownRight", 1017);
        put("resizeLeft", 1014);
        put("resizeLeftRight", 1014);
        put("resizeRight", 1014);
        put("resizeRow", 1015);
        put("resizeUp", 1015);
        put("resizeUpDown", 1015);
        put("resizeUpLeft", 1017);
        put("resizeUpRight", 1016);
        put("resizeUpLeftDownRight", 1017);
        put("resizeUpRightDownLeft", 1016);
        put("verticalText", Integer.valueOf(SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_VAD_PARAM));
        put("wait", Integer.valueOf(SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_LOUDNESS_PARAM));
        put("zoomIn", 1018);
        put("zoomOut", 1019);
    }
}
