package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreFirstWakeupProperty;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreSpeechWakeupServiceCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreWakeupAdaptiveEmbeddingSaveParameter;
import com.mammon.audiosdk.structures.SAMICoreWakeupAudioConfig;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechWakeupService {
    private SAMICoreSpeechWakeupServiceCreateParameter parameter;
    private final SAMICore samiCore;

    public int createSidExecutor() {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_WFP_Create_Sid_Executor;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public String getResult() {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_LP_KWS_Result;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_String;
        if (this.samiCore.SAMICoreGetPropertyById(r1, r0) != 0) goto L11;
        Object[] r2 = r0.dataObjectArray;
        if (r2 != null) goto L7;
        return null;
    L7:
        if (r2.length != 0) goto L10;
        return null;
    L10:
        return (String) r2[0];
    L11:
        return null;
    }

    public int releaseHandle() {
        return this.samiCore.SAMICoreDestroyHandle();
    }

    public int releaseSidExecutor() {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_WFP_Release_Sid_Executor;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public SpeechWakeupService() {
        this.samiCore = new SAMICore();
    }

    public int createHandle(SAMICoreSpeechWakeupServiceCreateParameter r3) {
        this.parameter = r3;
        return this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Speech_Wakeup_Service, r3);
    }

    public int init(SAMICoreWakeupAudioConfig r3) {
        return init(r3, null, true);
    }

    public int registerWakeupParamRequestCallback(SAMICoreWakeupParamRequestCallback r3) {
        SAMICoreNativeWakeupParamRequestCallback.setWakeupParamRequestCallback(r3);
        if (r3 != null) goto L6;
        return 0;
    L6:
        SAMICoreProperty r4 = new SAMICoreProperty();
        SAMICorePropertyId r0 = SAMICorePropertyId.SAMICorePropertyId_Speech_Wakeup_Param_Request_Callback;
        r4.id = r0;
        r4.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r0, r4);
    }

    public int registerWakeupUploadTaskCallback(SAMICoreWakeupUploadTaskCallback r3) {
        SAMICoreNativeWakeupUploadTaskCallback.setWakeupUploadTaskCallback(r3);
        if (r3 != null) goto L6;
        return 0;
    L6:
        SAMICoreProperty r4 = new SAMICoreProperty();
        SAMICorePropertyId r0 = SAMICorePropertyId.SAMICorePropertyId_Speech_Wakeup_Upload_Task_Callback;
        r4.id = r0;
        r4.type = SAMICoreDataType.SAMICoreDataType_Null;
        int r5 = this.samiCore.SAMICoreSetProperty(r0, r4);
        if (r5 == 0) goto L9;
        SAMICoreNativeWakeupUploadTaskCallback.setWakeupUploadTaskCallback(null);
    L9:
        return r5;
    }

    public int saveAdaptiveEmbedding(SAMICoreWakeupAdaptiveEmbeddingSaveParameter r6) {
        if (r6 != null) goto L5;
        return 100001;
    L5:
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Wakeup_Save_Adaptive_Embedding;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Speech_Wakeup_Adaptive_Embedding_Save_Param;
        r0.dataObjectArray = new SAMICoreWakeupAdaptiveEmbeddingSaveParameter[]{r6};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public int sendAudioData(byte[] r5) {
        SAMICoreAudioBin r0 = new SAMICoreAudioBin();
        r0.audioData = r5;
        SAMICoreBlock r6 = new SAMICoreBlock();
        r6.dataType = SAMICoreDataType.SAMICoreDataType_AudioBin;
        r6.audioData = new SAMICoreAudioBin[]{r0};
        r6.numberAudioData = 1;
        return this.samiCore.SAMICoreProcess(r6, null);
    }

    public int setFirstWakeupInfo(SAMICoreFirstWakeupProperty r6) {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_First_Wakeup_Info;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_AudioBin;
        r0.dataObjectArray = new SAMICoreFirstWakeupProperty[]{r6};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public void setListener(SAMICoreCallBackListener r2) {
        this.samiCore.setListener(r2);
    }

    public int setRetrying(boolean r6) {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_LP_KWS_RETRYING;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Int;
        r0.dataObjectArray = new Integer[]{Integer.valueOf(r6 ? 1 : 0)};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public int saveAdaptiveEmbedding(long r3) {
        return saveAdaptiveEmbedding(new SAMICoreWakeupAdaptiveEmbeddingSaveParameter(r3, 1));
    }

    public int saveAdaptiveEmbedding(String r3) {
        return saveAdaptiveEmbedding(new SAMICoreWakeupAdaptiveEmbeddingSaveParameter(r3, 1));
    }

    public int createHandle(String r2, String r3) {
        return createHandle(new SAMICoreSpeechWakeupServiceCreateParameter(r2, r3));
    }

    public int saveAdaptiveEmbedding(long r2, int r4) {
        return saveAdaptiveEmbedding(new SAMICoreWakeupAdaptiveEmbeddingSaveParameter(r2, r4));
    }

    public int saveAdaptiveEmbedding(String r2, int r3) {
        return saveAdaptiveEmbedding(new SAMICoreWakeupAdaptiveEmbeddingSaveParameter(r2, r3));
    }

    public int init(SAMICoreWakeupAudioConfig r6, String r7, boolean r8) {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_WFP_Init;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_AudioBin;
        r0.dataObjectArray = new SAMICoreWakeupAudioConfig[]{r6};
        r0.dataArrayLen = 1;
        if (r7 != null) goto L5;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r0.extraInfo = r7;
        r0.userContext = Boolean.valueOf(r8);
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }
}
