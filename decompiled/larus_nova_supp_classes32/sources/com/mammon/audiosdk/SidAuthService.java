package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreSidAuthCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRegisterResult;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRequest;
import com.mammon.audiosdk.structures.SAMICoreSidAuthResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SidAuthService {
    private final SAMICore samiCore;

    public int releaseHandle() {
        return this.samiCore.SAMICoreDestroyHandle();
    }

    public SidAuthService() {
        this.samiCore = new SAMICore();
    }

    public int createHandle(SAMICoreSidAuthCreateParameter r3) {
        return this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Sid_Auth_Service, r3);
    }

    public int register(SAMICoreSidAuthRegisterResult r5) {
        if (r5 != null) goto L5;
        return 100001;
    L5:
        SAMICoreBlock r0 = new SAMICoreBlock();
        r0.dataType = SAMICoreDataType.SAMICoreDataType_Sid_Auth_Register_Request;
        r0.audioData = null;
        r0.numberAudioData = 0;
        SAMICoreBlock r2 = new SAMICoreBlock();
        int r1 = this.samiCore.SAMICoreProcess(r0, r2);
        if (r1 == 0) goto L8;
        return r1;
    L8:
        Object[] r3 = r2.audioData;
        if (r3 != null) goto L11;
        return 100004;
    L11:
        if (r3.length == 0) goto L19;
        Object r4 = r3[0];
        if ((r4 instanceof SAMICoreSidAuthRegisterResult) == false) goto L20;
        SAMICoreSidAuthRegisterResult r6 = (SAMICoreSidAuthRegisterResult) r4;
        r5.embedJson = r6.embedJson;
        r5.voiceFingerId = r6.voiceFingerId;
        r5.sidId = r6.sidId;
        return r1;
    L20:
        return 100004;
    L19:
        return 100004;
    }

    public int auth(SAMICoreSidAuthRequest r5, SAMICoreSidAuthResult r6) {
        if (r5 == null) goto L19;
        if (r6 == null) goto L23;
        SAMICoreBlock r0 = new SAMICoreBlock();
        r0.dataType = SAMICoreDataType.SAMICoreDataType_Sid_Auth_Request;
        r0.audioData = new SAMICoreSidAuthRequest[]{r5};
        r0.numberAudioData = 1;
        SAMICoreBlock r7 = new SAMICoreBlock();
        int r1 = this.samiCore.SAMICoreProcess(r0, r7);
        if (r1 == 0) goto L8;
        return r1;
    L8:
        Object[] r8 = r7.audioData;
        if (r8 != null) goto L11;
        return 100004;
    L11:
        if (r8.length == 0) goto L21;
        Object r9 = r8[0];
        if ((r9 instanceof SAMICoreSidAuthResult) == false) goto L22;
        SAMICoreSidAuthResult r10 = (SAMICoreSidAuthResult) r9;
        r6.embedJson = r10.embedJson;
        r6.score = r10.score;
        r6.sv = r10.sv;
        return r1;
    L22:
        return 100004;
    L21:
        return 100004;
    L23:
        return 100001;
    L19:
        return 100001;
    }

    public int createHandle(String r10, String r11, String r12, String r13, String r14, String r15) {
        return createHandle(r10, r11, r12, r13, r14, r15, null, null);
    }

    public int createHandle(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        if (r2 == null) goto L8;
        if (r3 == null) goto L10;
        if (r4 == null) goto L11;
        SAMICoreSidAuthCreateParameter r0 = new SAMICoreSidAuthCreateParameter();
        r0.modelPath = r2;
        r0.dbPath = r3;
        r0.uid = r4;
        r0.sidModelMd5 = r5;
        r0.appId = r6;
        r0.sidAuthEncKeyInfo = r7;
        r0.appKey = r8;
        r0.businessType = r9;
        return createHandle(r0);
    L11:
        return 100001;
    L10:
        return 100001;
    L8:
        return 100001;
    }
}
