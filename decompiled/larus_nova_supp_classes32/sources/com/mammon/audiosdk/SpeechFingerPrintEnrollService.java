package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAsrContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintDumpAudioDataParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintEnrollParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintEnrollRequest;
import com.mammon.audiosdk.structures.SpeechFingerprintLegacyEnrollMigrationParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechFingerPrintEnrollService {
    private String TAG;
    private SpeechFingerprintEnrollParameter parameter;
    private SAMICore samiCore;

    public int deleteEnrollResult() {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_DeleteEnrollResult;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public int forceReEnrollWakeupSid() {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_ForceReEnrollWakeupSid;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public SpeechFingerprintResult getAudioFeatureOnline() {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_AudioFeatureOnlineByUid;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Enroll_Result;
        this.samiCore.SAMICoreGetPropertyById(r1, r0);
        return (SpeechFingerprintResult) r0.dataObjectArray[0];
    }

    public int releaseHandle() {
        return this.samiCore.SAMICoreDestroyHandle();
    }

    public SpeechFingerPrintEnrollService() {
        this.TAG = "SpeechFingerPrintEnrollService";
        this.samiCore = new SAMICore();
    }

    public int checkAndEnrollASRSID(SpeechFingerprintEnrollRequest r6) {
        if (r6 != null) goto L5;
        return 100001;
    L5:
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_CheckAndEnrollASRSID;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Enroll_Request;
        r0.dataObjectArray = new SpeechFingerprintEnrollRequest[]{r6};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public int checkSNR(String r6) {
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.taskId = r6;
        SAMICoreProperty r7 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_CheckSNR;
        r7.id = r1;
        r7.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r7.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r0};
        r7.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r7);
    }

    public int createASR(SAMICoreVoiceAssistantContextCreateParameter r6) {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_CreateASR;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Context_Param;
        r0.dataObjectArray = new SAMICoreVoiceAssistantContextCreateParameter[]{r6};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public int createHandle(SpeechFingerprintEnrollParameter r3) {
        this.parameter = r3;
        return this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Speech_Fingerprint_Enroll, r3);
    }

    public int dumpAudioData2File(SpeechFingerprintDumpAudioDataParameter r6) {
        if (r6 != null) goto L5;
        return 100001;
    L5:
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_DumpAudioData2File;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Dump_Audio_Data_Param;
        r0.dataObjectArray = new SpeechFingerprintDumpAudioDataParameter[]{r6};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public int migrateLegacyEnrollToDb(SpeechFingerprintLegacyEnrollMigrationParameter r6) {
        if (r6 != null) goto L5;
        return 100001;
    L5:
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_MigrateLegacyEnrollToDb;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Legacy_Migration_Param;
        r0.dataObjectArray = new SpeechFingerprintLegacyEnrollMigrationParameter[]{r6};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public int removeAudioFeatureOnline(String r6) {
        SpeechFingerprintEnrollParameter r0 = new SpeechFingerprintEnrollParameter();
        r0.sn = r6;
        SAMICoreProperty r7 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_DelAudioFeature_Online;
        r7.id = r1;
        r7.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Enroll_Property_Param;
        r7.dataObjectArray = new SpeechFingerprintEnrollParameter[]{r0};
        r7.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r7);
    }

    public int saveSessionAudio(String r6) {
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.taskId = r6;
        SAMICoreProperty r7 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_SaveSessionAudio;
        r7.id = r1;
        r7.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r7.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r0};
        r7.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r7);
    }

    public int setAsrParam(SAMICoreAsrContextCreateParameter r6) {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_Set_Asr_Param;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Asr_Context_Param;
        r0.dataObjectArray = new SAMICoreAsrContextCreateParameter[]{r6};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public void setListener(SAMICoreCallBackListener r2) {
        this.samiCore.setListener(r2);
    }

    public int start(SAMICoreVoiceAssistantPropertyParameter r6) {
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_Start;
        r0.id = r1;
        r0.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r0.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r6};
        r0.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r0);
    }

    public int stop(String r6) {
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.taskId = r6;
        SAMICoreProperty r7 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_Stop;
        r7.id = r1;
        r7.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r7.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r0};
        r7.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r7);
    }

    public int uploadStoredAudio(String r6) {
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.taskId = r6;
        SAMICoreProperty r7 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_UploadStoredAudio;
        r7.id = r1;
        r7.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r7.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r0};
        r7.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r1, r7);
    }

    public int checkAndEnrollASRSID(String r2) {
        SpeechFingerprintEnrollRequest r0 = new SpeechFingerprintEnrollRequest();
        r0.taskId = r2;
        r0.bypassEnrollSid = 0;
        r0.bypassOnlineRegister = 0;
        return checkAndEnrollASRSID(r0);
    }

    public int dumpAudioData2File(String r2, String r3) {
        SpeechFingerprintDumpAudioDataParameter r0 = new SpeechFingerprintDumpAudioDataParameter();
        r0.outputDir = r2;
        r0.uid = r3;
        return dumpAudioData2File(r0);
    }

    public int checkAndEnrollASRSID(String r2, boolean r3, boolean r4) {
        SpeechFingerprintEnrollRequest r0 = new SpeechFingerprintEnrollRequest();
        r0.taskId = r2;
        r0.bypassEnrollSid = r3 ? 1 : 0;
        r0.bypassOnlineRegister = r4 ? 1 : 0;
        return checkAndEnrollASRSID(r0);
    }

    public int sendAudioData(byte[] r3, String r4, String r5) {
        SAMICoreVoiceAssistantAudioData r0 = new SAMICoreVoiceAssistantAudioData();
        r0.taskId = r4;
        r0.data = r3;
        r0.extra = r5;
        SAMICoreBlock r6 = new SAMICoreBlock();
        r6.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        r6.audioData = new SAMICoreVoiceAssistantAudioData[]{r0};
        r6.numberAudioData = 1;
        int r7 = this.samiCore.SAMICoreProcess(r6, null);
        if (r7 != 0) goto L5;
    L5:
        return r7;
    }
}
