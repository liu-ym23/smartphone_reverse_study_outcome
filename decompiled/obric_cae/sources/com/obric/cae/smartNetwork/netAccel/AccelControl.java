package com.obric.cae.smartNetwork.netAccel;

import android.content.Context;
import android.os.Message;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import com.cae.caed.SocketFilterParcel;
import com.cae.caed.SocketTupleParcel;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.mpflow.MpflowInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AccelControl extends StateMachine {
    private static final int CMD_DENY_NET_ACCEL = 4;
    private static final int CMD_DISABLE_ACCEL = 2;
    private static final int CMD_DISCONNECT_SOCKET_BY_FILTER = 6;
    private static final int CMD_DISCONNECT_SOCKET_BY_UID = 9;
    private static final int CMD_ENABLE_ACCEL = 1;
    private static final int CMD_SCHED_SOCKET_TO_NEXT_NET = 7;
    private static final int CMD_SET_ACCEL_UID_ENABLE = 3;
    private static final int CMD_SET_DEFAULT_NET_TYPE = 5;
    private static final int CMD_UPDATE_ALL_ACCEL_UID_ENABLE = 8;
    private static final int PRIVATE_BASE = 0;
    private static final String TAG = null;
    private AccelMetric mAccelMetric;
    private AcceleratingState mAcceleratingState;
    private Context mContext;
    private final FlowSched mFlowSched;
    private MpflowInterface mMpflowInterface;
    private MultiNetInfo mMultiNetInfo;
    private final NetPreception mNetPreception;
    private NoAccelerationState mNoAccelerationState;
    private StopAcceleratingState mStopAcceleratingState;
    private final ConcurrentHashMap<Integer, Integer> mUidLimitNetworkType;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.netAccel.AccelControl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class AcceleratingState extends BaseAccelState {
        final /* synthetic */ AccelControl this$0;

        private AcceleratingState(AccelControl r8) {
            this.this$0 = r8;
            super(r8, null);
        }

        public void enter() {
            CaeLog.d(AccelControl.access$400(), "AcceleratingState");
            Iterator<Map.Entry<Integer, MultiNetInfo.AccelNet>> r8 = AccelControl.access$700(this.this$0).getAvailableNetMap().entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            Map.Entry<Integer, MultiNetInfo.AccelNet> r10 = r8.next();
            AccelControl.access$300(this.this$0).setGlobalAccelMaxQuota(r10.getKey().byteValue(), r10.getValue().getQuota());
            CaeLog.i(AccelControl.access$400(), "type: " + r10.getKey() + ", quota: " + r10.getValue().getQuota());
            goto L4
        L6:
            Iterator<Map.Entry<Integer, Boolean>> r11 = AccelControl.access$700(this.this$0).getEnabledUidMap().entrySet().iterator();
        L8:
            if (r11.hasNext() == false) goto L12;
            Map.Entry<Integer, Boolean> r12 = r11.next();
            int r13 = r12.getKey().intValue();
            AccelControl r14 = this.this$0;
            int r15 = AccelControl.access$800(r14, r13, AccelControl.access$700(r14).makeAvailableNetType());
            if (r15 == 0) goto L8;
            AccelControl.access$300(this.this$0).enableAccelByUid(r15, r13, r12.getValue().booleanValue());
            goto L8
        L12:
            AccelControl.access$900(this.this$0).start(AccelControl.access$700(this.this$0));
            AccelControl.access$1000(this.this$0).start(AccelControl.access$700(this.this$0));
            AccelControl.access$1100(this.this$0);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelControl.BaseAccelState
        public boolean processMessage(Message r8) {
            if (super.processMessage(r8) == false) goto L5;
            return true;
        L5:
            int r10 = r8.what;
            if (r10 != 2) goto L8;
            AccelControl r11 = this.this$0;
            r11.transitionTo(AccelControl.access$1200(r11));
            return true;
        L8:
            if (r10 == 3) goto L41;
            boolean r12 = false;
            if (r10 != 4) goto L12;
            int r13 = r8.arg1;
            if (r8.arg2 == 0) goto L36;
            r12 = true;
        L36:
            Iterator<Map.Entry<Integer, Boolean>> r14 = AccelControl.access$700(this.this$0).getEnabledUidMap().entrySet().iterator();
        L38:
            if (r14.hasNext() == false) goto L40;
            AccelControl.access$300(this.this$0).denyAccelByUid((byte) r13, r14.next().getKey().intValue(), r12);
            goto L38
        L40:
            return true;
        L12:
            if (r10 != 6) goto L14;
            SocketFilterParcel r15 = (SocketFilterParcel) r8.obj;
            Iterator<Map.Entry<Integer, Boolean>> r16 = AccelControl.access$700(this.this$0).getEnabledUidMap().entrySet().iterator();
        L30:
            if (r16.hasNext() == false) goto L32;
            r15.f4177a = r16.next().getKey().intValue();
            AccelControl.access$300(this.this$0).disconnectSocketByFilter(r15);
            goto L30
        L32:
            return true;
        L14:
            if (r10 != 7) goto L16;
            SocketTupleParcel r17 = (SocketTupleParcel) r8.obj;
            AccelControl.access$300(this.this$0).SetNextPriorityAccel((byte) r8.arg1, r8.arg2);
            AccelControl.access$300(this.this$0).disconnectSocketByTuple(r17);
            return true;
        L16:
            if (r10 == 8) goto L18;
            return false;
        L18:
            int r18 = AccelControl.access$700(this.this$0).makeAvailableNetType();
            Iterator<Map.Entry<Integer, Boolean>> r19 = AccelControl.access$700(this.this$0).getEnabledUidMap().entrySet().iterator();
        L20:
            if (r19.hasNext() == false) goto L24;
            Map.Entry<Integer, Boolean> r20 = r19.next();
            int r21 = r20.getKey().intValue();
            int r22 = AccelControl.access$800(this.this$0, r21, r18);
            if (r22 == 0) goto L20;
            AccelControl.access$300(this.this$0).enableAccelByUid(r22, r21, r20.getValue().booleanValue());
            goto L20
        L24:
            AccelControl.access$1100(this.this$0);
            return true;
        L41:
            int r23 = ((Integer) r8.obj).intValue();
            boolean r24 = AccelControl.access$700(this.this$0).getEnabledUid(r23).booleanValue();
            AccelControl r25 = this.this$0;
            int r26 = AccelControl.access$800(r25, r23, AccelControl.access$700(r25).makeAvailableNetType());
            if (r26 == 0) goto L44;
            AccelControl.access$300(this.this$0).enableAccelByUid(r26, r23, r24);
        L44:
            AccelControl.access$1300(this.this$0, r23, r24);
            return true;
        }

        public /* synthetic */ AcceleratingState(AccelControl r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class BaseAccelState extends State {
        final /* synthetic */ AccelControl this$0;

        private BaseAccelState(AccelControl r8) {
            this.this$0 = r8;
        }

        public boolean processMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 5) goto L5;
            int r11 = r8.arg1;
            AccelControl.access$300(this.this$0).setDefaultNetType((byte) r11);
            String r12 = AccelControl.access$400();
            StringBuilder r13 = new StringBuilder("Set default net type to: ");
        L10:
            defpackage.b.p(r13, r11, r12);
            return true;
        L5:
            if (r10 == 9) goto L8;
            return false;
        L8:
            r11 = r8.arg1;
            AccelControl.access$300(this.this$0).disconnectSocketByUid(r11);
            r12 = AccelControl.access$400();
            r13 = new StringBuilder("disconnectSocketByUid: uid=");
            goto L10
        }

        public /* synthetic */ BaseAccelState(AccelControl r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class NoAccelerationState extends BaseAccelState {
        final /* synthetic */ AccelControl this$0;

        private NoAccelerationState(AccelControl r8) {
            this.this$0 = r8;
            super(r8, null);
        }

        public void enter() {
            CaeLog.i(AccelControl.access$400(), "NoAccelerationState");
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelControl.BaseAccelState
        public boolean processMessage(Message r8) {
            if (super.processMessage(r8) == false) goto L6;
            return true;
        L6:
            if (r8.what == 1) goto L9;
            return false;
        L9:
            AccelControl r10 = this.this$0;
            r10.transitionTo(AccelControl.access$600(r10));
            return true;
        }

        public /* synthetic */ NoAccelerationState(AccelControl r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class StopAcceleratingState extends BaseAccelState {
        final /* synthetic */ AccelControl this$0;

        private StopAcceleratingState(AccelControl r8) {
            this.this$0 = r8;
            super(r8, null);
        }

        public void enter() {
            CaeLog.d(AccelControl.access$400(), "StopAcceleratingState");
            AccelControl.access$900(this.this$0).stop();
            AccelControl.access$1000(this.this$0).stop();
            Iterator<Map.Entry<Integer, MultiNetInfo.AccelNet>> r8 = AccelControl.access$700(this.this$0).getAvailableNetMap().entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            Map.Entry<Integer, MultiNetInfo.AccelNet> r10 = r8.next();
            AccelControl.access$300(this.this$0).setGlobalAccelMaxQuota(r10.getKey().byteValue(), 0);
            CaeLog.i(AccelControl.access$400(), "type: " + r10.getKey() + ", quota: " + r10.getValue().getQuota() + "-> 0");
            goto L4
        L6:
            Iterator<Map.Entry<Integer, Boolean>> r11 = AccelControl.access$700(this.this$0).getEnabledUidMap().entrySet().iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            AccelControl.access$300(this.this$0).enableAccelByUid(0, r11.next().getKey().intValue(), false);
            goto L8
        L10:
            AccelControl.access$1100(this.this$0);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelControl.BaseAccelState
        public boolean processMessage(Message r8) {
            if (super.processMessage(r8) == false) goto L6;
            return true;
        L6:
            if (r8.what == 1) goto L9;
            return false;
        L9:
            AccelControl r10 = this.this$0;
            r10.transitionTo(AccelControl.access$600(r10));
            return true;
        }

        public /* synthetic */ StopAcceleratingState(AccelControl r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    static {
        TAG = "MultiNetwork-AccelControl";
    }

    private AccelControl(String r8, Context r10) {
        super(r8);
        AnonymousClass1 r11 = null;
        this.mNoAccelerationState = new NoAccelerationState(this, r11);
        this.mAcceleratingState = new AcceleratingState(this, r11);
        this.mStopAcceleratingState = new StopAcceleratingState(this, r11);
        this.mUidLimitNetworkType = new ConcurrentHashMap();
        this.mContext = r10;
        addState(this.mNoAccelerationState);
        addState(this.mAcceleratingState);
        addState(this.mStopAcceleratingState);
        this.mMpflowInterface = new MpflowInterface();
        this.mNetPreception = new NetPreception(r10, this);
        this.mFlowSched = new FlowSched(r10, this);
        this.mAccelMetric = AccelMetric.getInstance(r10);
        setInitialState(this.mNoAccelerationState);
    }

    public static /* synthetic */ FlowSched access$1000(AccelControl r8) {
        return r8.mFlowSched;
    }

    public static /* synthetic */ void access$1100(AccelControl r8) {
        r8.reportAccelUidCapability();
    }

    public static /* synthetic */ StopAcceleratingState access$1200(AccelControl r8) {
        return r8.mStopAcceleratingState;
    }

    public static /* synthetic */ void access$1300(AccelControl r8, int r10, boolean r11) {
        r8.reportSingleUidAccelCapability(r10, r11);
    }

    public static /* synthetic */ MpflowInterface access$300(AccelControl r8) {
        return r8.mMpflowInterface;
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    public static /* synthetic */ AcceleratingState access$600(AccelControl r8) {
        return r8.mAcceleratingState;
    }

    public static /* synthetic */ MultiNetInfo access$700(AccelControl r8) {
        return r8.mMultiNetInfo;
    }

    public static /* synthetic */ int access$800(AccelControl r8, int r10, int r11) {
        return r8.getUidAllowedNetType(r10, r11);
    }

    public static /* synthetic */ NetPreception access$900(AccelControl r8) {
        return r8.mNetPreception;
    }

    private int getUidAllowedNetType(int r8, int r10) {
        return (~getUidDenyNetworkBitmask(r8)) & r10;
    }

    private int getUidDenyNetworkBitmask(int r8) {
        Integer r10 = this.mUidLimitNetworkType.get(Integer.valueOf(r8));
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.intValue();
    }

    public static AccelControl makeAccelControl(Context r8) {
        AccelControl r10 = new AccelControl("AccelControl", r8);
        r10.start();
        return r10;
    }

    private void reportAccelUidCapability() {
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L14
        Iterator<Map.Entry<Integer, Boolean>> r10 = this.mMultiNetInfo.getEnabledUidMap().entrySet().iterator();     // Catch: Exception -> L14
    L4:
        if (r10.hasNext() == false) goto L11;
        Map.Entry<Integer, Boolean> r11 = r10.next();     // Catch: Exception -> L14
        int r12 = r11.getKey().intValue();     // Catch: Exception -> L14
        boolean r13 = r11.getValue().booleanValue();     // Catch: Exception -> L14
        AccelUidCapability.AppInfo.Builder r14 = AccelUidCapability.AppInfo.newBuilder();     // Catch: Exception -> L14
        if (r13 == false) goto L8;
        int r15 = 0;
    L9:
        r8.add(r14.setState(r15).setUid(r12).build());     // Catch: Exception -> L14
        goto L4
    L8:
        r15 = 1;
        goto L9
    L11:
        if (r8.isEmpty() == true) goto L22;
        this.mAccelMetric.reportAccelUidCapability(r8);     // Catch: Exception -> L14
        return;
    L22:
        return;
    L14:
        e = move-exception;
        String r16 = TAG;
        defpackage.b.k(e, new StringBuilder("reportAccelUidCapability failed: "), r16);
    }

    private void reportSingleUidAccelCapability(int r8, boolean r10) {
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L8
        AccelUidCapability.AppInfo.Builder r12 = AccelUidCapability.AppInfo.newBuilder();     // Catch: Exception -> L8
        if (r10 == false) goto L5;
        int r13 = 0;
    L6:
        r11.add(r12.setState(r13).setUid(r8).build());     // Catch: Exception -> L8
        this.mAccelMetric.reportAccelUidCapability(r11);     // Catch: Exception -> L8
        return;
    L5:
        r13 = 1;
    L8:
        e = move-exception;
        String r14 = TAG;
        defpackage.b.k(e, new StringBuilder("reportSingleUidAccelCapability failed: "), r14);
    }

    public void denyNetAccel(int r8, boolean r10) {
        Message r11 = obtainMessage(4);
        r11.arg1 = r8;
        r11.arg2 = r10 ? 1 : 0;
        sendMessage(r11);
    }

    public void disableAccel() {
        sendMessage(obtainMessage(2));
    }

    public void disconnectSocket(String r8, String r10, int r11) {
        Message r12 = obtainMessage(6);
        SocketFilterParcel r13 = new SocketFilterParcel();
        r13.f4178b = r8;
        r13.f4179m = r10;
        r13.f4180n = r11;
        r12.obj = r13;
        sendMessage(r12);
    }

    public void disconnectSocketByUid(int r8) {
        Message r10 = obtainMessage(9);
        r10.arg1 = r8;
        sendMessage(r10);
    }

    public void enableAccel(MultiNetInfo r8) {
        this.mMultiNetInfo = r8;
        sendMessage(obtainMessage(1));
    }

    public void schedSocketToNextNet(SocketTupleParcel r8, byte r10, int r11) {
        Message r12 = obtainMessage(7);
        r12.obj = r8;
        r12.arg1 = r10;
        r12.arg2 = r11;
        sendMessage(r12);
    }

    public void setDefaultNetType(int r8) {
        Message r10 = obtainMessage(5);
        r10.arg1 = r8;
        sendMessage(r10);
    }

    public void setUidDenyNetworkType(byte r8, int r10, boolean r11) {
        int r12 = getUidDenyNetworkBitmask(r10);
        if (r11 == false) goto L5;
        this.mUidLimitNetworkType.put(Integer.valueOf(r10), Integer.valueOf((1 << r8) | r12));
    L9:
        String r13 = TAG;
        StringBuilder r14 = defpackage.a.g("setUidDenyNetworkType: netType=", r8, ", uid=", r10, ", deny=");
        r14.append(r11);
        CaeLog.i(r13, r14.toString());
        sendMessage(obtainMessage(8));
        return;
    L5:
        int r15 = (~(1 << r8)) & r12;
        if (r15 != 0) goto L8;
        this.mUidLimitNetworkType.remove(Integer.valueOf(r10));
        goto L9
    L8:
        this.mUidLimitNetworkType.put(Integer.valueOf(r10), Integer.valueOf(r15));
        goto L9
    }

    public void setUidEnabled(int r8) {
        Message r10 = obtainMessage(3);
        r10.obj = Integer.valueOf(r8);
        sendMessage(r10);
    }

    public void updateAllAccelUidEnable() {
        sendMessage(obtainMessage(8));
    }
}
