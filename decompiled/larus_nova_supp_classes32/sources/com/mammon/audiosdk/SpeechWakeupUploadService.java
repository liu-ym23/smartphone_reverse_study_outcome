package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerCommonContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreTruthCollectorData;
import com.mammon.audiosdk.structures.SAMICoreWakeupUploadResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechWakeupUploadService {
    private final SAMICoreServerCommonContextCreateParameter createParameter;
    private final SAMICore samiCore;

    public SpeechWakeupUploadService() {
        this(null);
    }

    public int createHandle() {
        return this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Speech_Wakeup_Upload_Service, this.createParameter);
    }

    public int releaseHandle() {
        return this.samiCore.SAMICoreDestroyHandle();
    }

    public SpeechWakeupUploadService(SAMICoreServerCommonContextCreateParameter r2) {
        this.samiCore = new SAMICore();
        this.createParameter = r2;
    }

    public SAMICoreWakeupUploadResult upload(SAMICoreTruthCollectorData r6) {
        SAMICoreWakeupUploadResult r0 = new SAMICoreWakeupUploadResult();
        if (r6 == null) goto L17;
        byte[] r1 = r6.audio_data;
        if (r1 == null) goto L17;
        if (r1.length == 0) goto L17;
        SAMICoreBlock r2 = new SAMICoreBlock();
        r2.dataType = SAMICoreDataType.SAMICoreDataType_Speech_Wakeup_Truth_Collector_Data;
        r2.audioData = new Object[]{r6};
        r2.numberAudioData = 1;
        SAMICoreBlock r7 = new SAMICoreBlock();
        r0.ret = this.samiCore.SAMICoreProcess(r2, r7);
        Object[] r8 = r7.audioData;
        if (r8 != null) goto L12;
    L16:
        return r0;
    L12:
        if (r8.length <= 0) goto L16;
        Object r9 = r8[0];
        if ((r9 instanceof String) == false) goto L16;
        r0.response = (String) r9;
    L17:
        r0.ret = 100001;
        return r0;
    }

    public int upload(byte[] r5, String r6) {
        if (r5 != null) goto L4;
        return 100001;
    L4:
        if (r5.length == 0) goto L10;
        SAMICoreAudioBin r0 = new SAMICoreAudioBin();
        r0.audioData = r5;
        SAMICoreBlock r7 = new SAMICoreBlock();
        r7.dataType = SAMICoreDataType.SAMICoreDataType_AudioBin;
        r7.audioData = new SAMICoreAudioBin[]{r0};
        r7.numberAudioData = 1;
        r7.userContext = r6;
        return this.samiCore.SAMICoreProcess(r7, null);
    L10:
        return 100001;
    }
}
