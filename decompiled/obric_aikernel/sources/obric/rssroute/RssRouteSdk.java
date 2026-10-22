package obric.rssroute;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import obric.rssroute.core.RssNativeBridge;
import obric.rssroute.model.RssInt2Result;
import obric.rssroute.model.RssIntResult;
import obric.rssroute.model.RssSessionInferenceData;
import obric.rssroute.model.RssSessionPolicyDatas;
import obric.rssroute.model.RssSessionQosListener;
import obric.rssroute.model.RssSessionUidStatusListener;
import obric.rssroute.model.RssUIntResult;

/* JADX INFO: loaded from: classes3.dex */
public final class RssRouteSdk {
    private static final RssRouteSdk INSTANCE = null;

    public static final class InfoData {
        private final LinkedHashMap<String, Object> mValues;

        public InfoData() {
            this.mValues = new LinkedHashMap();
        }

        public InfoData putBoolean(String r10, boolean r11) {
            if (r10 != null) goto L4;
        L6:
            return this;
        L4:
            if (r10.isEmpty() == true) goto L6;
            this.mValues.put(r10, Boolean.valueOf(r11));
            goto L6
        }

        public InfoData putFloat(String r10, float r11) {
            if (r10 != null) goto L4;
        L6:
            return this;
        L4:
            if (r10.isEmpty() == true) goto L6;
            this.mValues.put(r10, Float.valueOf(r11));
            goto L6
        }

        public InfoData putInt(String r10, int r11) {
            if (r10 != null) goto L4;
        L6:
            return this;
        L4:
            if (r10.isEmpty() == true) goto L6;
            this.mValues.put(r10, Integer.valueOf(r11));
            goto L6
        }

        public InfoData putLong(String r10, long r11) {
            if (r10 != null) goto L4;
        L6:
            return this;
        L4:
            if (r10.isEmpty() == true) goto L6;
            this.mValues.put(r10, Long.valueOf(r11));
            goto L6
        }

        public InfoData putString(String r10, String r11) {
            if (r10 != null) goto L4;
        L7:
            return this;
        L4:
            if (r10.isEmpty() == true) goto L7;
            if (r11 == null) goto L7;
            this.mValues.put(r10, r11);
            goto L7
        }

        public Map<String, Object> values() {
            return Collections.unmodifiableMap(this.mValues);
        }
    }

    static {
        INSTANCE = new RssRouteSdk();
    }

    private RssRouteSdk() {
        RssNativeBridge.init();
    }

    public static RssRouteSdk getInstance() {
        return INSTANCE;
    }

    private int reportInfoData(int r10, InfoData r11) {
        if (r11 != null) goto L5;
        return -3;
    L5:
        if (r11.values().isEmpty() == true) goto L41;
        int r12 = r11.values().size();
        String[] r13 = new String[r12];
        int[] r14 = new int[r12];
        long[] r15 = new long[r12];
        float[] r16 = new float[r12];
        String[] r17 = new String[r12];
        int r18 = 0;
        Iterator<Map.Entry<String, Object>> r19 = r11.values().entrySet().iterator();
    L9:
        if (r19.hasNext() == false) goto L32;
        Map.Entry<String, Object> r20 = r19.next();
        Object r21 = r20.getValue();
        r13[r18] = r20.getKey();
        if ((r21 instanceof Integer) == false) goto L14;
        r14[r18] = 1;
        r15[r18] = ((Integer) r21).intValue();
    L29:
        r18 = r18 + 1;
        goto L9
    L14:
        if ((r21 instanceof Long) == false) goto L17;
        r14[r18] = 2;
        r15[r18] = ((Long) r21).longValue();
        goto L29
    L17:
        if ((r21 instanceof Float) == false) goto L20;
        r14[r18] = 3;
        r16[r18] = ((Float) r21).floatValue();
        goto L29
    L20:
        if ((r21 instanceof Boolean) == false) goto L27;
        r14[r18] = 4;
        if (((Boolean) r21).booleanValue() == false) goto L24;
        long r22 = 1;
    L25:
        r15[r18] = r22;
        goto L29
    L24:
        r22 = 0;
        goto L25
    L27:
        if ((r21 instanceof String) == false) goto L30;
        r14[r18] = 5;
        r17[r18] = (String) r21;
        goto L29
    L30:
        return -3;
    L32:
        return RssNativeBridge.reportDataInfo(r10, r13, r14, r15, r16, r17);
    L41:
        return -3;
    }

    public String getLastDebugString() {
        return RssNativeBridge.getLastDebugString();
    }

    public int getProductType() {
        return RssNativeBridge.getProductType();
    }

    public int getSdkVersion() {
        return 1;
    }

    public int init() {
        return RssNativeBridge.init();
    }

    public int reportAiData(InfoData r10) {
        if (r10 != null) goto L6;
        return -3;
    L6:
        return reportDataInfo(13010, r10);
    }

    public int reportDataInfo(int r10, InfoData r11) {
        return reportInfoData(r10, r11);
    }

    public int sessionAddProc(int r10, int r11) {
        return RssNativeBridge.sessionAddProc(r10, r11);
    }

    public int sessionAddThread(int r10, int r11) {
        return RssNativeBridge.sessionAddThread(r10, r11);
    }

    public RssIntResult sessionCreateGrp(int r10) {
        int[] r11 = RssNativeBridge.sessionCreateGrp(r10);
        if (r11 == null) goto L10;
        if (r11.length < 2) goto L10;
        return new RssIntResult(r11[0], r11[1]);
    L10:
        return new RssIntResult(-2, 0);
    }

    public RssIntResult sessionCreateMemPoolGrp() {
        int[] r10 = RssNativeBridge.sessionCreateMemPoolGrp();
        if (r10 == null) goto L10;
        if (r10.length < 2) goto L10;
        return new RssIntResult(r10[0], r10[1]);
    L10:
        return new RssIntResult(-2, 0);
    }

    public int sessionDeleteGrp(int r10) {
        return RssNativeBridge.sessionDeleteGrp(r10);
    }

    public int sessionEnableNpuPowerModeAutoFit(int r10) {
        return RssNativeBridge.sessionEnableNpuPowerModeAutoFit(r10);
    }

    public RssUIntResult sessionGetNetlinkListenerPortId() {
        int[] r10 = RssNativeBridge.sessionGetNetlinkListenerPortId();
        if (r10 == null) goto L10;
        if (r10.length < 2) goto L10;
        return new RssUIntResult(r10[0], r10[1]);
    L10:
        return new RssUIntResult(-2, 0);
    }

    public RssIntResult sessionGetNpuPowerGear(int r10) {
        int[] r11 = RssNativeBridge.sessionGetNpuPowerGear(r10);
        if (r11 == null) goto L10;
        if (r11.length < 2) goto L10;
        return new RssIntResult(r11[0], r11[1]);
    L10:
        return new RssIntResult(-2, 0);
    }

    public RssInt2Result sessionGetTaskQos(int r10) {
        int[] r11 = RssNativeBridge.sessionGetTaskQos(r10);
        if (r11 == null) goto L10;
        if (r11.length < 3) goto L10;
        return new RssInt2Result(r11[0], r11[1], r11[2]);
    L10:
        return new RssInt2Result(-2, 0, 0);
    }

    public RssIntResult sessionRegisterQosListener(RssSessionQosListener r10) {
        int[] r11 = RssNativeBridge.sessionRegisterQosListener(r10);
        if (r11 == null) goto L10;
        if (r11.length < 2) goto L10;
        return new RssIntResult(r11[0], r11[1]);
    L10:
        return new RssIntResult(-2, 0);
    }

    public RssIntResult sessionRegisterUidStatusListener(RssSessionUidStatusListener r10) {
        int[] r11 = RssNativeBridge.sessionRegisterUidStatusListener(r10);
        if (r11 == null) goto L10;
        if (r11.length < 2) goto L10;
        return new RssIntResult(r11[0], r11[1]);
    L10:
        return new RssIntResult(-2, 0);
    }

    public int sessionRemoveProc(int r10) {
        return RssNativeBridge.sessionRemoveProc(r10);
    }

    public int sessionRemoveThread(int r10) {
        return RssNativeBridge.sessionRemoveThread(r10);
    }

    public int sessionSetClientUid(int r10, int r11) {
        return RssNativeBridge.sessionSetClientUid(r10, r11);
    }

    public int sessionSetInferenceInfo(RssSessionInferenceData r10) {
        return RssNativeBridge.sessionSetInferenceInfo(r10);
    }

    public int sessionSetNetlinkPortId(int r10) {
        return RssNativeBridge.sessionSetNetlinkPortId(r10);
    }

    public int sessionSetPolicy(RssSessionPolicyDatas r10) {
        return RssNativeBridge.sessionSetPolicy(r10);
    }

    public int sessionSetQos(int r10, int r11) {
        return RssNativeBridge.sessionSetQos(r10, r11);
    }

    public int sessionStartNetlinkListener() {
        return RssNativeBridge.sessionStartNetlinkListener();
    }

    public void sessionStopNetlinkListener() {
        RssNativeBridge.sessionStopNetlinkListener();
    }

    public int sessionUnregisterQosListener(int r10) {
        return RssNativeBridge.sessionUnregisterQosListener(r10);
    }

    public int sessionUnregisterUidStatusListener(int r10) {
        return RssNativeBridge.sessionUnregisterUidStatusListener(r10);
    }

    public int shutdown() {
        return RssNativeBridge.shutdown();
    }
}
