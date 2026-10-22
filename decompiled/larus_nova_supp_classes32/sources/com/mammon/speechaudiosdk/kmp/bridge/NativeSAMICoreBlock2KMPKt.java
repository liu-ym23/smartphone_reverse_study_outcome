package com.mammon.speechaudiosdk.kmp.bridge;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioNetConnectionEventParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionDownlinkEventParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioNetConnectionStateType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"toDownlinkEventKmp", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionDownlinkEventParam;", "Lcom/mammon/audiosdk/structures/SAMICoreBlock;", "toNetConnectionEventKmp", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioNetConnectionEventParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NativeSAMICoreBlock2KMPKt {
    public static final SpeechVoiceAssistantSessionDownlinkEventParam toDownlinkEventKmp(SAMICoreBlock r19) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        Object[] r1 = r19.audioData;
        boolean r2 = true;
        if (r1 == null) goto L12;
        if (r1.length != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L12;
        r2 = false;
        goto L12
    L7:
        r4 = false;
    L12:
        if (r2 == false) goto L15;
        return null;
    L15:
        if (r19.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L24;
        Object r0 = r1[0];
        if ((r0 instanceof SAMICoreServerEvent) == false) goto L19;
        SAMICoreServerEvent r3 = (SAMICoreServerEvent) r0;
    L20:
        if (r3 != null) goto L23;
        return null;
    L23:
        return new SpeechVoiceAssistantSessionDownlinkEventParam(r3.event, r3.statusCode, r3.statusText, r3.taskId, r3.sessionId, r3.messageId, r3.textMsg, r3.extra, r3.binaryData, 0, 512, null);
    L19:
        r3 = null;
        goto L20
    L24:
        return null;
    }

    public static final SpeechAudioNetConnectionEventParam toNetConnectionEventKmp(SAMICoreBlock r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Object[] r0 = r4.audioData;
        boolean r1 = true;
        if (r0 == null) goto L12;
        if (r0.length != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        r1 = false;
        goto L12
    L7:
        r3 = false;
    L12:
        if (r1 == false) goto L15;
        return null;
    L15:
        if (r4.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event) goto L24;
        Object r5 = r0[0];
        if ((r5 instanceof SAMICoreWebSocketConnectionEvent) == false) goto L19;
        SAMICoreWebSocketConnectionEvent r6 = (SAMICoreWebSocketConnectionEvent) r5;
    L20:
        if (r6 != null) goto L23;
        return null;
    L23:
        return new SpeechAudioNetConnectionEventParam(SpeechAudioNetConnectionStateType.Companion.fromInt(r6.state), r6.url, r6.textMsg);
    L19:
        r6 = null;
        goto L20
    L24:
        return null;
    }
}
