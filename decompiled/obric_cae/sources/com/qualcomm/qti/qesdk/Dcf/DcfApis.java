package com.qualcomm.qti.qesdk.Dcf;

import com.qualcomm.qti.qesdkIntf.IQesdkFunctionType;

/* JADX INFO: loaded from: classes2.dex */
public final enum DcfApis extends Enum<DcfApis> implements IQesdkFunctionType {
    private static final /* synthetic */ DcfApis[] $VALUES = null;
    public static final DcfApis DCF_API_CANCELDUPLICATEDETECTION = null;
    public static final DcfApis DCF_API_CANCELTRIGGER = null;
    public static final DcfApis DCF_API_CONFIGUREDUPLICATEDETECTION = null;
    public static final DcfApis DCF_API_CONFIGUREDUPLICATEDETECTION2 = null;
    public static final DcfApis DCF_API_DEREGISTERCLIENT = null;
    public static final DcfApis DCF_API_GETVERSION = null;
    public static final DcfApis DCF_API_REGISTERCLIENT = null;
    public static final DcfApis DCF_API_SENDCUSTOMREQUEST = null;
    public static final DcfApis DCF_API_SETBATCHPERIODPREFERENCE = null;
    public static final DcfApis DCF_API_SETBLEADVERTISESTATUSCALLBACK = null;
    public static final DcfApis DCF_API_SETBLESCANSTATUSCALLBACK = null;
    public static final DcfApis DCF_API_SETCUSTOMEVENTCALLBACK = null;
    public static final DcfApis DCF_API_SETCUSTOMREQUESTSTATUSCALLBACK = null;
    public static final DcfApis DCF_API_SETDATAREADYCALLBACK = null;
    public static final DcfApis DCF_API_SETDUPLICATEDETECTIONSTATUSCALLBACK = null;
    public static final DcfApis DCF_API_SETPLATFORMSTATUSCALLBACK = null;
    public static final DcfApis DCF_API_SETTRIGGER = null;
    public static final DcfApis DCF_API_SETTRIGGERSTATUSCALLBACK = null;
    public static final DcfApis DCF_API_STARTBLEADVERTISING = null;
    public static final DcfApis DCF_API_STARTBLEADVERTISING2 = null;
    public static final DcfApis DCF_API_STARTBLESCAN = null;
    public static final DcfApis DCF_API_STOPBLEADVERTISING = null;
    public static final DcfApis DCF_API_STOPBLESCAN = null;
    private int functionId;
    private String functionName;
    private int functionVersion;
    private int numOfArgs;
    private String opCode;
    private int ssId;
    private String ssName;

    static {
        DcfApis r10 = new DcfApis("DCF_API_GETVERSION", 0, 0, "getVersion", 0, 2682, "Dcf", 1);
        DCF_API_GETVERSION = r10;
        DcfApis r8 = new DcfApis("DCF_API_REGISTERCLIENT", 1, 1, "registerClient", 3, 2682, "Dcf", 1);
        DCF_API_REGISTERCLIENT = r8;
        DcfApis r11 = new DcfApis("DCF_API_DEREGISTERCLIENT", 2, 2, "deregisterClient", 1, 2682, "Dcf", 1);
        DCF_API_DEREGISTERCLIENT = r11;
        DcfApis r12 = new DcfApis("DCF_API_SETPLATFORMSTATUSCALLBACK", 3, 3, "setPlatformStatusCallback", 3, 2682, "Dcf", 1);
        DCF_API_SETPLATFORMSTATUSCALLBACK = r12;
        DcfApis r13 = new DcfApis("DCF_API_SETDATAREADYCALLBACK", 4, 4, "setDataReadyCallback", 3, 2682, "Dcf", 1);
        DCF_API_SETDATAREADYCALLBACK = r13;
        DcfApis r14 = new DcfApis("DCF_API_SETTRIGGERSTATUSCALLBACK", 5, 5, "setTriggerStatusCallback", 3, 2682, "Dcf", 1);
        DCF_API_SETTRIGGERSTATUSCALLBACK = r14;
        DcfApis r15 = new DcfApis("DCF_API_SETDUPLICATEDETECTIONSTATUSCALLBACK", 6, 6, "setDuplicateDetectionStatusCallback", 3, 2682, "Dcf", 1);
        DCF_API_SETDUPLICATEDETECTIONSTATUSCALLBACK = r15;
        DcfApis r16 = new DcfApis("DCF_API_SETBLESCANSTATUSCALLBACK", 7, 7, "setBleScanStatusCallback", 3, 2682, "Dcf", 1);
        DCF_API_SETBLESCANSTATUSCALLBACK = r16;
        DcfApis r17 = new DcfApis("DCF_API_SETBLEADVERTISESTATUSCALLBACK", 8, 8, "setBleAdvertiseStatusCallback", 3, 2682, "Dcf", 1);
        DCF_API_SETBLEADVERTISESTATUSCALLBACK = r17;
        DcfApis r18 = new DcfApis("DCF_API_SETTRIGGER", 9, 9, "setTrigger", 3, 2682, "Dcf", 1);
        DCF_API_SETTRIGGER = r18;
        DcfApis r19 = new DcfApis("DCF_API_CANCELTRIGGER", 10, 10, "cancelTrigger", 2, 2682, "Dcf", 1);
        DCF_API_CANCELTRIGGER = r19;
        DcfApis r20 = new DcfApis("DCF_API_CONFIGUREDUPLICATEDETECTION", 11, 11, "configureDuplicateDetection", 4, 2682, "Dcf", 1);
        DCF_API_CONFIGUREDUPLICATEDETECTION = r20;
        DcfApis r21 = new DcfApis("DCF_API_CANCELDUPLICATEDETECTION", 12, 12, "cancelDuplicateDetection", 2, 2682, "Dcf", 1);
        DCF_API_CANCELDUPLICATEDETECTION = r21;
        DcfApis r22 = new DcfApis("DCF_API_STARTBLESCAN", 13, 13, "startBleScan", 3, 2682, "Dcf", 1);
        DCF_API_STARTBLESCAN = r22;
        DcfApis r23 = new DcfApis("DCF_API_STOPBLESCAN", 14, 14, "stopBleScan", 1, 2682, "Dcf", 1);
        DCF_API_STOPBLESCAN = r23;
        DcfApis r24 = new DcfApis("DCF_API_STARTBLEADVERTISING", 15, 15, "startBleAdvertising", 4, 2682, "Dcf", 1);
        DCF_API_STARTBLEADVERTISING = r24;
        DcfApis r25 = new DcfApis("DCF_API_STOPBLEADVERTISING", 16, 16, "stopBleAdvertising", 1, 2682, "Dcf", 1);
        DCF_API_STOPBLEADVERTISING = r25;
        DcfApis r26 = new DcfApis("DCF_API_SETBATCHPERIODPREFERENCE", 17, 17, "setBatchPeriodPreference", 2, 2682, "Dcf", 2);
        DCF_API_SETBATCHPERIODPREFERENCE = r26;
        DcfApis r27 = new DcfApis("DCF_API_CONFIGUREDUPLICATEDETECTION2", 18, 18, "configureDuplicateDetection2", 5, 2682, "Dcf", 3);
        DCF_API_CONFIGUREDUPLICATEDETECTION2 = r27;
        DcfApis r28 = new DcfApis("DCF_API_SETCUSTOMREQUESTSTATUSCALLBACK", 19, 19, "setCustomRequestStatusCallback", 3, 2682, "Dcf", 4);
        DCF_API_SETCUSTOMREQUESTSTATUSCALLBACK = r28;
        DcfApis r29 = new DcfApis("DCF_API_SETCUSTOMEVENTCALLBACK", 20, 20, "setCustomEventCallback", 3, 2682, "Dcf", 4);
        DCF_API_SETCUSTOMEVENTCALLBACK = r29;
        DcfApis r30 = new DcfApis("DCF_API_SENDCUSTOMREQUEST", 21, 21, "sendCustomRequest", 2, 2682, "Dcf", 4);
        DCF_API_SENDCUSTOMREQUEST = r30;
        DcfApis r31 = new DcfApis("DCF_API_STARTBLEADVERTISING2", 22, 22, "startBleAdvertising2", 5, 2682, "Dcf", 6);
        DCF_API_STARTBLEADVERTISING2 = r31;
        $VALUES = new DcfApis[]{r10, r8, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31};
    }

    private DcfApis(String r8, int r10, int r11, String r12, int r13, int r14, String r15, int r16) {
        super(r8, r10);
        this.functionId = r11;
        this.ssId = r14;
        this.opCode = "0x63";
        this.functionName = r12;
        this.ssName = r15;
        this.numOfArgs = r13;
        this.functionVersion = r16;
    }

    private String[] getArgNamesInternal() {
        int r8 = getNumberOfArgs();
        String[] r10 = new String[r8];
        int r11 = 0;
        if (r8 == 0) goto L5;
    L6:
        if (r11 >= r8) goto L8;
        r10[r11] = Integer.toString(r11);
        r11 = r11 + 1;
        goto L6
    L8:
        return r10;
    L5:
        return new String[0];
    }

    public static DcfApis valueOf(String r8) {
        return (DcfApis) Enum.valueOf(DcfApis.class, r8);
    }

    public static DcfApis[] values() {
        return (DcfApis[]) $VALUES.clone();
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public String[] getArgNames() {
        return getArgNamesInternal();
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public int getFunctionId() {
        return this.functionId;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public String getFunctionName() {
        return this.functionName;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public int getFunctionVersion() {
        return this.functionVersion;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public int getNumberOfArgs() {
        return this.numOfArgs;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public String getOpCode() {
        return this.opCode;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public int getSSId() {
        return this.ssId;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdkFunctionType
    public String getSSName() {
        return this.ssName;
    }
}
