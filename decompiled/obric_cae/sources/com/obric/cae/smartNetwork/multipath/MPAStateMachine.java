package com.obric.cae.smartNetwork.multipath;

import android.os.Message;
import com.android.internal.util.IState;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class MPAStateMachine extends StateMachine {
    public static final int CMD_CELL_DISABLED = 12;
    public static final int CMD_CELL_ENABLED = 11;
    public static final int CMD_CELL_QUALITY_GOOD = 6;
    public static final int CMD_CELL_QUALITY_POOR = 5;
    public static final int CMD_CELL_RTT_GOOD = 8;
    public static final int CMD_CELL_RTT_POOR = 7;
    public static final int CMD_CELL_SYNC = 14;
    public static final int CMD_WLANCELL_SYNC = 15;
    public static final int CMD_WLAN_DISABLED = 10;
    public static final int CMD_WLAN_ENABLED = 9;
    public static final int CMD_WLAN_QUALITY_GOOD = 2;
    public static final int CMD_WLAN_QUALITY_POOR = 1;
    public static final int CMD_WLAN_RTT_GOOD = 4;
    public static final int CMD_WLAN_RTT_POOR = 3;
    public static final int CMD_WLAN_SYNC = 13;
    private static final String TAG = "MPAStateMachine";
    private CELLONLY_STATE mCellState;
    private NONETWORK_STATE mNoNetworkState;
    private WLANCELL_RR_STATE mRRState;
    private WLANCELL_STATE mWlanCellState;
    private WLANCELL_WLANRTTPOOR_STATE mWlanCellWlanRTTPoorState;
    private WLANONLY_STATE mWlanState;

    public class CELLONLY_STATE extends State {
        final /* synthetic */ MPAStateMachine this$0;

        public CELLONLY_STATE(MPAStateMachine r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(MPAStateMachine.TAG, "CELLONLY_STATE.enter");
        }

        public void exit() {
            CaeLog.d(MPAStateMachine.TAG, "CELLONLY_STATE.exit");
        }

        public boolean processMessage(Message r8) {
            defpackage.a.j(new StringBuilder("CELLONLY_STATE.processMessage what="), r8.what, MPAStateMachine.TAG);
            int r10 = r8.what;
            if (r10 == 1) goto L19;
            if (r10 == 2) goto L19;
            if (r10 == 9) goto L19;
            if (r10 != 15) goto L11;
            CaeLog.d(MPAStateMachine.TAG, "get CMD_WLANCELL_SYNC in Cell Only State");
            MultiPathManager.getInstance().setOnlyCellular();
        L26:
            return true;
        L11:
            if (r10 != 12) goto L13;
            MPAStateMachine r11 = this.this$0;
            IState r12 = MPAStateMachine.access$300(r11);
        L21:
            r11.transitionTo(r12);
            goto L26
        L13:
            if (r10 == 13) goto L15;
            String r13 = "processMessage() unknown message=" + r8.what;
        L24:
            CaeLog.d(MPAStateMachine.TAG, r13);
            return false;
        L15:
            r11 = this.this$0;
            r12 = MPAStateMachine.access$000(r11);
        L19:
            if (MultiPathManager.getInstance().setBothWifiAndCellular() == false) goto L23;
            r11 = this.this$0;
            r12 = MPAStateMachine.access$200(r11);
            goto L21
        L23:
            r13 = "setBothWifiAndCellular() failed";
            goto L24
        }
    }

    public class NONETWORK_STATE extends State {
        final /* synthetic */ MPAStateMachine this$0;

        public NONETWORK_STATE(MPAStateMachine r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(MPAStateMachine.TAG, "NONETWORK_STATE.enter");
        }

        public void exit() {
            CaeLog.d(MPAStateMachine.TAG, "NONETWORK_STATE.exit");
        }

        public boolean processMessage(Message r8) {
            defpackage.a.j(new StringBuilder("NONETWORK_STATE.processMessage what="), r8.what, MPAStateMachine.TAG);
            switch(r8.what) {
                case 9: goto L17;
                case 10: goto L4;
                case 11: goto L13;
                case 12: goto L4;
                case 13: goto L18;
                case 14: goto L14;
                case 15: goto L6;
                default: goto L4;
            };
        L4:
            String r10 = "processMessage() unknown message=" + r8.what;
        L21:
            CaeLog.d(MPAStateMachine.TAG, r10);
            return false;
        L14:
            MPAStateMachine r11 = this.this$0;
            IState r12 = MPAStateMachine.access$100(r11);
        L19:
            r11.transitionTo(r12);
            return true;
        L18:
            r11 = this.this$0;
            r12 = MPAStateMachine.access$000(r11);
            goto L19
        L6:
            if (MultiPathManager.getInstance().isWiFiNetworkAvailable() == false) goto L9;
            MultiPathManager.getInstance().setOnlyWifi();
            goto L18
        L9:
            if (MultiPathManager.getInstance().isCellularNetworkAvailable() == false) goto L11;
            MultiPathManager.getInstance().setOnlyCellular();
            goto L14
        L11:
            r10 = "get CMD_WLANCELL_SYNC: but Wi-Fi & Cell are unavailable";
            goto L21
        L13:
            if (MultiPathManager.getInstance().setOnlyCellular() == true) goto L14;
            r10 = "setOnlyCellular() failed";
            goto L21
        L17:
            if (MultiPathManager.getInstance().setOnlyWifi() == true) goto L18;
            r10 = "setOnlyWifi() failed";
            goto L21
        }
    }

    public class WLANCELL_RR_STATE extends State {
        final /* synthetic */ MPAStateMachine this$0;

        public WLANCELL_RR_STATE(MPAStateMachine r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(MPAStateMachine.TAG, "WLANCELL_RR_STATE.enter");
        }

        public void exit() {
            CaeLog.d(MPAStateMachine.TAG, "WLANCELL_RR_STATE.exit");
        }

        public boolean processMessage(Message r8) {
            defpackage.a.j(new StringBuilder("WLANCELL_RR_STATE.processMessage what="), r8.what, MPAStateMachine.TAG);
            int r10 = r8.what;
            if (r10 != 2) goto L5;
            return true;
        L5:
            if (r10 == 3) goto L9;
            defpackage.a.j(new StringBuilder("processMessage() unknown message="), r8.what, MPAStateMachine.TAG);
            return false;
        L9:
            return true;
        }
    }

    public class WLANCELL_STATE extends State {
        final /* synthetic */ MPAStateMachine this$0;

        public WLANCELL_STATE(MPAStateMachine r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(MPAStateMachine.TAG, "WLANCELL_STATE.enter");
        }

        public void exit() {
            CaeLog.d(MPAStateMachine.TAG, "WLANCELL_STATE.exit");
        }

        public boolean processMessage(Message r8) {
            defpackage.a.j(new StringBuilder("WLANCELL_STATE.processMessage what="), r8.what, MPAStateMachine.TAG);
            int r10 = r8.what;
            if (r10 == 2) goto L19;
            if (r10 == 10) goto L12;
            if (r10 != 13) goto L9;
        L20:
            MPAStateMachine r11 = this.this$0;
            IState r12 = MPAStateMachine.access$000(r11);
        L21:
            r11.transitionTo(r12);
            return true;
        L9:
            if (r10 == 14) goto L15;
            String r13 = "processMessage() unknown message=" + r8.what;
        L23:
            CaeLog.d(MPAStateMachine.TAG, r13);
            return false;
        L15:
            r11 = this.this$0;
            r12 = MPAStateMachine.access$100(r11);
            goto L21
        L12:
            if (MultiPathManager.getInstance().isCellularNetworkAvailable() == true) goto L14;
            CaeLog.d(MPAStateMachine.TAG, "isCellularNetworkAvailable() is false");
            r11 = this.this$0;
            r12 = MPAStateMachine.access$300(r11);
            goto L21
        L14:
            if (MultiPathManager.getInstance().setOnlyCellular() == true) goto L15;
            r13 = "setOnlyCellular() failed";
            goto L23
        L19:
            if (MultiPathManager.getInstance().setOnlyWifi() == true) goto L20;
            r13 = "setOnlyWifi() failed";
            goto L23
        }
    }

    public class WLANCELL_WLANRTTPOOR_STATE extends State {
        final /* synthetic */ MPAStateMachine this$0;

        public WLANCELL_WLANRTTPOOR_STATE(MPAStateMachine r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(MPAStateMachine.TAG, "WLANCELL_WLANRTTPOOR_STATE.enter");
        }

        public void exit() {
            CaeLog.d(MPAStateMachine.TAG, "WLANCELL_WLANRTTPOOR_STATE.exit");
        }

        public boolean processMessage(Message r8) {
            defpackage.a.j(new StringBuilder("WLANCELL_WLANRTTPOOR_STATE.processMessage what="), r8.what, MPAStateMachine.TAG);
            int r10 = r8.what;
            if (r10 == 4) goto L19;
            if (r10 == 10) goto L12;
            if (r10 != 13) goto L9;
        L20:
            MPAStateMachine r11 = this.this$0;
            IState r12 = MPAStateMachine.access$000(r11);
        L21:
            r11.transitionTo(r12);
            return true;
        L9:
            if (r10 == 14) goto L15;
            String r13 = "processMessage() unknown message=" + r8.what;
        L23:
            CaeLog.d(MPAStateMachine.TAG, r13);
            return false;
        L15:
            r11 = this.this$0;
            r12 = MPAStateMachine.access$100(r11);
            goto L21
        L12:
            if (MultiPathManager.getInstance().isCellularNetworkAvailable() == true) goto L14;
            CaeLog.d(MPAStateMachine.TAG, "isCellularNetworkAvailable() is false");
            r11 = this.this$0;
            r12 = MPAStateMachine.access$300(r11);
            goto L21
        L14:
            if (MultiPathManager.getInstance().setOnlyCellular() == true) goto L15;
            r13 = "setOnlyCellular() failed";
            goto L23
        L19:
            if (MultiPathManager.getInstance().setOnlyWifi() == true) goto L20;
            r13 = "setOnlyWifi() failed";
            goto L23
        }
    }

    public class WLANONLY_STATE extends State {
        final /* synthetic */ MPAStateMachine this$0;

        public WLANONLY_STATE(MPAStateMachine r8) {
            this.this$0 = r8;
        }

        public void enter() {
            CaeLog.d(MPAStateMachine.TAG, "WLAN_ONLY_STATE.enter");
        }

        public void exit() {
            CaeLog.d(MPAStateMachine.TAG, "WLAN_ONLY_STATE.exit");
        }

        public boolean processMessage(Message r8) {
            defpackage.a.j(new StringBuilder("WLANONLY_STATE.processMessage what="), r8.what, MPAStateMachine.TAG);
            int r10 = r8.what;
            if (r10 == 1) goto L27;
            if (r10 == 3) goto L22;
            if (r10 == 10) goto L15;
            if (r10 != 14) goto L11;
        L18:
            MPAStateMachine r11 = this.this$0;
            IState r12 = MPAStateMachine.access$100(r11);
        L33:
            r11.transitionTo(r12);
        L35:
            return true;
        L11:
            if (r10 == 15) goto L13;
            String r13 = "processMessage() unknown message=" + r8.what;
        L20:
            CaeLog.d(MPAStateMachine.TAG, r13);
            return false;
        L13:
            CaeLog.d(MPAStateMachine.TAG, "get CMD_WLANCELL_SYNC in WLAN Only State");
            MultiPathManager.getInstance().setOnlyWifi();
            goto L35
        L15:
            if (MultiPathManager.getInstance().isCellularNetworkAvailable() == true) goto L17;
        L32:
            CaeLog.d(MPAStateMachine.TAG, "isCellularNetworkAvailable() is false");
            r11 = this.this$0;
            r12 = MPAStateMachine.access$300(r11);
            goto L33
        L17:
            if (MultiPathManager.getInstance().setOnlyCellular() == true) goto L18;
            r13 = "setOnlyCellular() failed";
            goto L20
        L22:
            if (MultiPathManager.getInstance().isCellularNetworkAvailable() == false) goto L32;
            if (MultiPathManager.getInstance().setBothWifiAndCellular() == false) goto L31;
            r11 = this.this$0;
            r12 = MPAStateMachine.access$400(r11);
        L31:
            CaeLog.d(MPAStateMachine.TAG, "setBothWifiAndCellular() failed");
            return false;
        L27:
            if (MultiPathManager.getInstance().isCellularNetworkAvailable() == false) goto L32;
            if (MultiPathManager.getInstance().setBothWifiAndCellular() == false) goto L31;
            r11 = this.this$0;
            r12 = MPAStateMachine.access$200(r11);
            goto L33
        }
    }

    private MPAStateMachine(String r8) {
        super(r8);
        this.mWlanState = new WLANONLY_STATE(this);
        this.mRRState = new WLANCELL_RR_STATE(this);
        this.mWlanCellState = new WLANCELL_STATE(this);
        this.mCellState = new CELLONLY_STATE(this);
        this.mNoNetworkState = new NONETWORK_STATE(this);
        this.mWlanCellWlanRTTPoorState = new WLANCELL_WLANRTTPOOR_STATE(this);
        CaeLog.d(TAG, "MPA StateMachine construct start");
        addState(this.mWlanState);
        addState(this.mRRState);
        addState(this.mWlanCellState);
        addState(this.mCellState);
        addState(this.mNoNetworkState);
        addState(this.mWlanCellWlanRTTPoorState);
        if (MultiPathManager.getInstance().isWiFiNetworkAvailable() == false) goto L7;
        MultiPathManager.getInstance().setOnlyWifi();
        State r10 = this.mWlanState;
    L5:
        setInitialState(r10);
        CaeLog.d(TAG, "MPA StateMachine construct end");
        return;
    L7:
        if (MultiPathManager.getInstance().isCellularNetworkAvailable() == false) goto L9;
        MultiPathManager.getInstance().setOnlyCellular();
        r10 = this.mCellState;
        goto L5
    L9:
        r10 = this.mNoNetworkState;
        goto L5
    }

    public static /* synthetic */ WLANONLY_STATE access$000(MPAStateMachine r8) {
        return r8.mWlanState;
    }

    public static /* synthetic */ CELLONLY_STATE access$100(MPAStateMachine r8) {
        return r8.mCellState;
    }

    public static /* synthetic */ WLANCELL_STATE access$200(MPAStateMachine r8) {
        return r8.mWlanCellState;
    }

    public static /* synthetic */ NONETWORK_STATE access$300(MPAStateMachine r8) {
        return r8.mNoNetworkState;
    }

    public static /* synthetic */ WLANCELL_WLANRTTPOOR_STATE access$400(MPAStateMachine r8) {
        return r8.mWlanCellWlanRTTPoorState;
    }

    public static MPAStateMachine makeHsm() {
        CaeLog.i(TAG, "MPA StateMachine start");
        MPAStateMachine r8 = new MPAStateMachine(TAG);
        r8.start();
        CaeLog.i(TAG, "MPA StateMachine end");
        return r8;
    }

    public void onHalting() {
        CaeLog.d(TAG, "halting");
        monitor-enter(this);
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
