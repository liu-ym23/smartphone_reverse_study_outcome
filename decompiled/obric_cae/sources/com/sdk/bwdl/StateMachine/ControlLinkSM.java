package com.sdk.bwdl.StateMachine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import com.sdk.bwdl.AdapterLayer.GATT.GattAdapter.GattOriginal;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLink;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import defpackage.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class ControlLinkSM extends BWDLStateMachine {
    private static final String TAG = "ControlLinkSM";
    private ActiveState mActiveState;
    private IBWDLAdapter mBWDLAdapter;
    private CapabilityExchangeState mCapabilityExchangeState;
    private ChannelConfiguration mChannelConfiguration;
    private ConfigurationState mConfigurationState;
    private ConnectedState mConnectedState;
    private ConnectingState mConnectingState;
    private final Context mContext;
    private ControlLinkHandler mControlLinkHandler;
    private List<ControlLink> mControlLinkList;
    private BWDLInnerConstant.ControlLinkSmState mCurrentState;
    private BWDLDevice mDevice;
    private DisconnectedState mDisconnectedState;
    private boolean mEncryptFlag;
    private boolean mEncryption;
    private LinkLossState mLinkLossState;
    private List<IControlLinkSMListener> mListenerList;
    private PowerSaving mPowerSaving;
    private PowerSavingState mPowerSavingState;
    private IBWDLState mPreState;
    private boolean mRoleNegotiateFlag;
    private RoleNegotiationState mRoleNegotiationState;
    private SecurityState mSecurityState;
    private StateListener mStateListener;

    public class ActiveState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public ActiveState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.ActiveState);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            this.this$0.removeMessages(108);
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$2000(r8));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("ActiveState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            this.this$0.removeMessages(108);
            int r11 = r8.what;
            if (r11 != 101) goto L5;
            ControlLinkSM.access$600(this.this$0).disconnect(ControlLinkSM.access$800(this.this$0));
        L26:
            return true;
        L5:
            if (r11 != 104) goto L7;
            ((ControlLink) r8.obj).sendConnectedToUpper();
            goto L26
        L7:
            if (r11 == 106) goto L20;
            if (r11 != 108) goto L10;
            ControlLinkSM.access$2100(this.this$0).enterPowerSaving();
            ControlLinkSM r12 = this.this$0;
            IBWDLState r13 = ControlLinkSM.access$2200(r12);
        L23:
            r12.transitionTo(r13);
            goto L26
        L10:
            if (r11 == 300) goto L13;
            return false;
        L13:
            StringBuilder r14 = new StringBuilder("process message:");
            b.j(r8.arg1, r14, ControlLinkSM.TAG);
            int r15 = r8.arg1;
            if (r15 != 2) goto L16;
            r12 = this.this$0;
            r13 = ControlLinkSM.access$400(r12);
            goto L23
        L16:
            if (r15 != 1) goto L26;
            r12 = this.this$0;
            r13 = ControlLinkSM.access$1000(r12);
            goto L23
        L20:
            if (ControlLinkSM.access$200(this.this$0) == false) goto L22;
            BWDLLog.d(ControlLinkSM.TAG, "Link is already encryption");
            goto L26
        L22:
            r12 = this.this$0;
            r13 = ControlLinkSM.access$1900(r12);
            goto L23
        }
    }

    public class CapabilityExchangeState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public CapabilityExchangeState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.CapabilityExchangeState);     // Catch: Throwable -> L7
            new BWDLDeviceCapabilities(ControlLinkSM.access$1600(this.this$0), ((ControlLink) ControlLinkSM.access$1700(this.this$0).get(0)).getControlLinkProperty()).exchangeDeviceCapabilities();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$1500(r8));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("CapabilityExchangeState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            int r11 = r8.what;
            if (r11 != 101) goto L5;
            ControlLinkSM.access$600(this.this$0).disconnect(ControlLinkSM.access$800(this.this$0));
        L21:
            return true;
        L5:
            if (r11 != 107) goto L7;
            boolean r12 = ControlLinkSM.access$1800(this.this$0);
            ControlLinkSM r13 = this.this$0;
            if (r12 == false) goto L18;
            IBWDLState r14 = ControlLinkSM.access$1900(r13);
        L19:
            r13.transitionTo(r14);
            goto L21
        L18:
            r14 = ControlLinkSM.access$2000(r13);
            goto L19
        L7:
            if (r11 == 300) goto L10;
            return false;
        L10:
            StringBuilder r15 = new StringBuilder("process message:");
            b.j(r8.arg1, r15, ControlLinkSM.TAG);
            int r16 = r8.arg1;
            if (r16 != 2) goto L13;
            r13 = this.this$0;
            r14 = ControlLinkSM.access$400(r13);
            goto L19
        L13:
            if (r16 != 1) goto L21;
            r13 = this.this$0;
            r14 = ControlLinkSM.access$1000(r13);
            goto L19
        }
    }

    public class ConfigurationState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public ConfigurationState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.ConfigurationState);     // Catch: Throwable -> L7
            ControlLinkSM.access$1400(this.this$0).channelConfig();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$1300(r8));
            this.this$0.removeMessages(203);
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("ConfigurationState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            int r11 = r8.what;
            if (r11 != 101) goto L5;
        L18:
            ControlLinkSM.access$600(this.this$0).disconnect(ControlLinkSM.access$800(this.this$0));
        L19:
            ControlLinkSM r12 = this.this$0;
            IBWDLState r13 = ControlLinkSM.access$400(r12);
        L20:
            r12.transitionTo(r13);
        L21:
            return true;
        L5:
            if (r11 != 104) goto L7;
            r12 = this.this$0;
            r13 = ControlLinkSM.access$1500(r12);
            goto L20
        L7:
            if (r11 == 203) goto L18;
            if (r11 == 300) goto L12;
            return false;
        L12:
            StringBuilder r14 = new StringBuilder("process message:");
            b.j(r8.arg1, r14, ControlLinkSM.TAG);
            int r15 = r8.arg1;
            if (r15 == 2) goto L19;
            if (r15 != 1) goto L21;
            r12 = this.this$0;
            r13 = ControlLinkSM.access$1000(r12);
            goto L20
        }
    }

    public class ConnectedState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public ConnectedState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.ConnectedState);     // Catch: Throwable -> L11
            if (ControlLinkSM.access$1100(this.this$0) == false) goto L7;
            ControlLinkSM r8 = this.this$0;     // Catch: Throwable -> L11
            IBWDLState r10 = ControlLinkSM.access$1200(r8);     // Catch: Throwable -> L11
        L6:
            r8.transitionTo(r10);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            r8 = this.this$0;     // Catch: Throwable -> L11
            r10 = ControlLinkSM.access$1300(r8);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$900(r8));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("ConnectedState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            int r11 = r8.what;
            if (r11 != 101) goto L5;
            ControlLinkSM.access$600(this.this$0).disconnect(ControlLinkSM.access$800(this.this$0));
        L15:
            return true;
        L5:
            if (r11 == 300) goto L8;
            return false;
        L8:
            StringBuilder r12 = new StringBuilder("process message:");
            b.j(r8.arg1, r12, ControlLinkSM.TAG);
            int r13 = r8.arg1;
            if (r13 != 2) goto L11;
            ControlLinkSM r14 = this.this$0;
            IBWDLState r15 = ControlLinkSM.access$400(r14);
        L13:
            r14.transitionTo(r15);
            goto L15
        L11:
            if (r13 != 1) goto L15;
            r14 = this.this$0;
            r15 = ControlLinkSM.access$1000(r14);
            goto L13
        }
    }

    public class ConnectingState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public ConnectingState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.ConnectingState);     // Catch: Throwable -> L7
            this.this$0.sendMessageDelayed(200, 30000);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$700(r8));
            this.this$0.removeMessages(200);
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("ConnectingState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            int r11 = r8.what;
            if (r11 != 101) goto L5;
        L19:
            ControlLinkSM.access$600(this.this$0).disconnect(ControlLinkSM.access$800(this.this$0));
        L20:
            return true;
        L5:
            if (r11 != 200) goto L7;
            ControlLinkSM r12 = this.this$0;
            ControlLinkSM.access$000(r12, ControlLinkSM.access$700(r12), 200);
            goto L19
        L7:
            if (r11 != 300) goto L20;
            StringBuilder r13 = new StringBuilder("process message:");
            b.j(r8.arg1, r13, ControlLinkSM.TAG);
            int r14 = r8.arg1;
            if (r14 != 2) goto L13;
            ControlLinkSM r15 = this.this$0;
            IBWDLState r16 = ControlLinkSM.access$400(r15);
        L17:
            r15.transitionTo(r16);
            goto L20
        L13:
            if (r14 != 4) goto L15;
            r15 = this.this$0;
            r16 = ControlLinkSM.access$900(r15);
            goto L17
        L15:
            if (r14 != 1) goto L20;
            r15 = this.this$0;
            r16 = ControlLinkSM.access$1000(r15);
            goto L17
        }
    }

    public class DisconnectedState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public DisconnectedState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.DisconnectedState);     // Catch: Throwable -> L7
            ControlLinkSM.access$202(this.this$0, false);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$400(r8));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("DisconnectedState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            int r11 = r8.what;
            if (r11 == 100) goto L18;
            if (r11 != 102) goto L7;
            ControlLinkSM.access$600(this.this$0).listen();
        L19:
            ControlLinkSM r12 = this.this$0;
            IBWDLState r13 = ControlLinkSM.access$700(r12);
        L20:
            r12.transitionTo(r13);
            return true;
        L7:
            if (r11 == 300) goto L10;
            return false;
        L10:
            StringBuilder r14 = new StringBuilder("process message:");
            b.j(r8.arg1, r14, ControlLinkSM.TAG);
            int r15 = r8.arg1;
            if (r15 == 3) goto L19;
            if (r15 != 4) goto L23;
            r12 = this.this$0;
            r13 = ControlLinkSM.access$900(r12);
            goto L20
        L23:
            return true;
        L18:
            if (ControlLinkSM.access$600(this.this$0).connect(ControlLinkSM.access$800(this.this$0)) == true) goto L19;
            return true;
        }
    }

    public interface IControlLinkSMListener {
        void onStateChanged(BWDLDevice r8, BWDLInnerConstant.ControlLinkSmState r10, BWDLInnerConstant.ControlLinkSmState r11, int r12);
    }

    public class LinkLossState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public LinkLossState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.LinkLossState);     // Catch: Throwable -> L7
            this.this$0.sendMessage(BWDLInnerConstant.LINK_RECOVERY);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$1000(r8));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("LinkLossState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            int r11 = r8.what;
            if (r11 != 106) goto L5;
            this.this$0.deferMessage(r8);
            return true;
        L5:
            if (r11 != 112) goto L7;
            ControlLinkSM.access$600(this.this$0).connect(ControlLinkSM.access$800(this.this$0));
            return true;
        L7:
            if (r11 != 300) goto L26;
            StringBuilder r12 = new StringBuilder("process message:");
            b.j(r8.arg1, r12, ControlLinkSM.TAG);
            int r13 = r8.arg1;
            if (r13 != 2) goto L13;
            ControlLinkSM r14 = this.this$0;
            IBWDLState r15 = ControlLinkSM.access$400(r14);
        L18:
            r14.transitionTo(r15);
            return true;
        L13:
            if (r13 == 4) goto L15;
            return true;
        L15:
            if (ControlLinkSM.access$300(this.this$0) != ControlLinkSM.access$700(this.this$0)) goto L17;
            ControlLinkSM r16 = this.this$0;
            r16.transitionTo(ControlLinkSM.access$900(r16));
        L17:
            r14 = this.this$0;
            r15 = ControlLinkSM.access$300(r14);
            goto L18
        L26:
            return true;
        }
    }

    public class PowerSavingState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public PowerSavingState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.PowerSavingState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$2200(r8));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("PowerSavingState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            int r11 = r8.what;
            if (r11 != 101) goto L5;
            ControlLinkSM.access$600(this.this$0).disconnect(ControlLinkSM.access$800(this.this$0));
        L18:
            return true;
        L5:
            if (r11 != 106) goto L7;
            this.this$0.deferMessage(r8);
            ControlLinkSM.access$2100(this.this$0).exitPowerSaving();
            ControlLinkSM r12 = this.this$0;
            IBWDLState r13 = ControlLinkSM.access$2000(r12);
        L16:
            r12.transitionTo(r13);
            goto L18
        L7:
            if (r11 == 300) goto L10;
            return false;
        L10:
            StringBuilder r14 = new StringBuilder("process message:");
            b.j(r8.arg1, r14, ControlLinkSM.TAG);
            int r15 = r8.arg1;
            if (r15 != 2) goto L13;
            r12 = this.this$0;
            r13 = ControlLinkSM.access$400(r12);
            goto L16
        L13:
            if (r15 != 1) goto L18;
            r12 = this.this$0;
            r13 = ControlLinkSM.access$1000(r12);
            goto L16
        }
    }

    public class RoleNegotiationState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public RoleNegotiationState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.RoleNegotiationState);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$1200(r8));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        @SuppressLint({"MissingPermission"})
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("RoleNegotiationState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            if (r8.what == 300) goto L6;
            return false;
        L6:
            StringBuilder r11 = new StringBuilder("process message:");
            b.j(r8.arg1, r11, ControlLinkSM.TAG);
            int r12 = r8.arg1;
            if (r12 != 2) goto L9;
            ControlLinkSM r13 = this.this$0;
            IBWDLState r14 = ControlLinkSM.access$400(r13);
        L11:
            r13.transitionTo(r14);
        L12:
            return true;
        L9:
            if (r12 != 1) goto L12;
            r13 = this.this$0;
            r14 = ControlLinkSM.access$1000(r13);
            goto L11
        }
    }

    public class SecurityState implements IBWDLState {
        final /* synthetic */ ControlLinkSM this$0;

        public SecurityState(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void enter() {
            monitor-enter(this);
            ControlLinkSM.access$102(this.this$0, BWDLInnerConstant.ControlLinkSmState.SecurityState);     // Catch: Throwable -> L7
            ControlLinkSM.access$600(this.this$0).encrypt(ControlLinkSM.access$800(this.this$0));     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            BWDLLog.d(ControlLinkSM.TAG, "Enter:" + ControlLinkSM.access$100(this.this$0));
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public void exit() {
            BWDLLog.d(ControlLinkSM.TAG, "Exit:" + ControlLinkSM.access$100(this.this$0));
            ControlLinkSM r8 = this.this$0;
            ControlLinkSM.access$302(r8, ControlLinkSM.access$1900(r8));
        }

        @Override // com.sdk.bwdl.StateMachine.IBWDLState
        public boolean processMessage(Message r8) {
            StringBuilder r10 = new StringBuilder("SecurityState process message:");
            b.j(r8.what, r10, ControlLinkSM.TAG);
            int r11 = r8.what;
            if (r11 != 101) goto L5;
            ControlLinkSM.access$600(this.this$0).disconnect(ControlLinkSM.access$800(this.this$0));
        L26:
            return true;
        L5:
            if (r11 != 104) goto L7;
            this.this$0.deferMessage(r8);
            goto L26
        L7:
            if (r11 != 300) goto L9;
            StringBuilder r12 = new StringBuilder("process message:");
            b.j(r8.arg1, r12, ControlLinkSM.TAG);
            int r13 = r8.arg1;
            if (r13 != 2) goto L21;
            ControlLinkSM r14 = this.this$0;
            IBWDLState r15 = ControlLinkSM.access$400(r14);
        L23:
            r14.transitionTo(r15);
            goto L26
        L21:
            if (r13 != 1) goto L26;
            r14 = this.this$0;
            r15 = ControlLinkSM.access$1000(r14);
            goto L23
        L9:
            if (r11 == 301) goto L12;
            return false;
        L12:
            int r16 = r8.arg1;
            if (r16 != 6) goto L16;
            ControlLinkSM.access$202(this.this$0, true);
        L17:
            r14 = this.this$0;
            r15 = ControlLinkSM.access$2000(r14);
            goto L23
        L16:
            if (r16 != 7) goto L26;
            goto L17
        }
    }

    public class StateListener implements BWDLStateMachine.IStateListener {
        final /* synthetic */ ControlLinkSM this$0;

        public StateListener(ControlLinkSM r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.BWDLStateMachine.IStateListener
        public void onStateChanged(IBWDLState r8) {
            ControlLinkSM.access$000(this.this$0, r8, 0);
        }
    }

    public ControlLinkSM(Context r8, BWDLDevice r10) {
        super(TAG);
        this.mEncryption = false;
        this.mControlLinkList = new CopyOnWriteArrayList();
        this.mListenerList = new CopyOnWriteArrayList();
        this.mEncryptFlag = false;
        this.mRoleNegotiateFlag = false;
        BWDLLog.d(TAG, "newInstance for device " + r10.getDeviceInfo());
        this.mContext = r8;
        this.mDevice = r10;
        init();
    }

    public static /* synthetic */ void access$000(ControlLinkSM r8, IBWDLState r10, int r11) {
        r8.sendStateChangeToListener(r10, r11);
    }

    public static /* synthetic */ BWDLInnerConstant.ControlLinkSmState access$100(ControlLinkSM r8) {
        return r8.mCurrentState;
    }

    public static /* synthetic */ LinkLossState access$1000(ControlLinkSM r8) {
        return r8.mLinkLossState;
    }

    public static /* synthetic */ BWDLInnerConstant.ControlLinkSmState access$102(ControlLinkSM r8, BWDLInnerConstant.ControlLinkSmState r10) {
        r8.mCurrentState = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1100(ControlLinkSM r8) {
        return r8.mRoleNegotiateFlag;
    }

    public static /* synthetic */ RoleNegotiationState access$1200(ControlLinkSM r8) {
        return r8.mRoleNegotiationState;
    }

    public static /* synthetic */ ConfigurationState access$1300(ControlLinkSM r8) {
        return r8.mConfigurationState;
    }

    public static /* synthetic */ ChannelConfiguration access$1400(ControlLinkSM r8) {
        return r8.mChannelConfiguration;
    }

    public static /* synthetic */ CapabilityExchangeState access$1500(ControlLinkSM r8) {
        return r8.mCapabilityExchangeState;
    }

    public static /* synthetic */ Context access$1600(ControlLinkSM r8) {
        return r8.mContext;
    }

    public static /* synthetic */ List access$1700(ControlLinkSM r8) {
        return r8.mControlLinkList;
    }

    public static /* synthetic */ boolean access$1800(ControlLinkSM r8) {
        return r8.mEncryptFlag;
    }

    public static /* synthetic */ SecurityState access$1900(ControlLinkSM r8) {
        return r8.mSecurityState;
    }

    public static /* synthetic */ boolean access$200(ControlLinkSM r8) {
        return r8.mEncryption;
    }

    public static /* synthetic */ ActiveState access$2000(ControlLinkSM r8) {
        return r8.mActiveState;
    }

    public static /* synthetic */ boolean access$202(ControlLinkSM r8, boolean r10) {
        r8.mEncryption = r10;
        return r10;
    }

    public static /* synthetic */ PowerSaving access$2100(ControlLinkSM r8) {
        return r8.mPowerSaving;
    }

    public static /* synthetic */ PowerSavingState access$2200(ControlLinkSM r8) {
        return r8.mPowerSavingState;
    }

    public static /* synthetic */ IBWDLState access$300(ControlLinkSM r8) {
        return r8.mPreState;
    }

    public static /* synthetic */ IBWDLState access$302(ControlLinkSM r8, IBWDLState r10) {
        r8.mPreState = r10;
        return r10;
    }

    public static /* synthetic */ DisconnectedState access$400(ControlLinkSM r8) {
        return r8.mDisconnectedState;
    }

    public static /* synthetic */ String access$500(int r8) {
        return transformIntegerToString(r8);
    }

    public static /* synthetic */ IBWDLAdapter access$600(ControlLinkSM r8) {
        return r8.mBWDLAdapter;
    }

    public static /* synthetic */ ConnectingState access$700(ControlLinkSM r8) {
        return r8.mConnectingState;
    }

    public static /* synthetic */ BWDLDevice access$800(ControlLinkSM r8) {
        return r8.mDevice;
    }

    public static /* synthetic */ ConnectedState access$900(ControlLinkSM r8) {
        return r8.mConnectedState;
    }

    private void sendStateChangeToListener(IBWDLState r8, int r10) {
        Iterator<IControlLinkSMListener> r11 = this.mListenerList.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onStateChanged(this.mDevice, transformStateToSmState(this.mPreState), this.mCurrentState, r10);
        goto L4
    }

    private static String transformIntegerToString(int r8) {
        if (r8 != 100) goto L5;
        return "CONNECT";
    L5:
        if (r8 != 101) goto L7;
        return "DISCONNECT";
    L7:
        if (r8 != 104) goto L9;
        return "CHANNEL_CONFIG_COMPLETE";
    L9:
        if (r8 != 112) goto L11;
        return "LINK_RECOVERY";
    L11:
        if (r8 != 200) goto L13;
        return "CONNECT_TIMEOUT";
    L13:
        if (r8 != 203) goto L15;
        return "CHANNEL_CONFIG_TIMEOUT";
    L15:
        if (r8 != 300) goto L17;
        return "ConnectionStateChange";
    L17:
        if (r8 == 301) goto L40;
        switch(r8) {
            case 1: goto L38;
            case 2: goto L36;
            case 3: goto L34;
            case 4: goto L32;
            case 5: goto L30;
            case 6: goto L28;
            default: goto L19;
        };
    L19:
        switch(r8) {
            case 106: goto L26;
            case 107: goto L24;
            case 108: goto L22;
            default: goto L20;
        };
    L20:
        return "Unknown";
    L22:
        return "ENTER_POWER_SAVING";
    L24:
        return "CAPABILITIES_EXCHANGE_COMPLETE";
    L26:
        return "ENCRYPT";
    L28:
        return "Encrypted";
    L30:
        return "Encrypting";
    L32:
        return "Connected";
    L34:
        return "Connecting";
    L36:
        return "Disconnected";
    L38:
        return "LinkLoss";
    L40:
        return "BondStateChange";
    }

    private BWDLInnerConstant.ControlLinkSmState transformStateToSmState(IBWDLState r8) {
        if (r8.equals(this.mDisconnectedState) == false) goto L7;
        return BWDLInnerConstant.ControlLinkSmState.DisconnectedState;
    L7:
        if (r8.equals(this.mConnectingState) == false) goto L11;
        return BWDLInnerConstant.ControlLinkSmState.ConnectingState;
    L11:
        if (r8.equals(this.mConnectedState) == false) goto L15;
        return BWDLInnerConstant.ControlLinkSmState.ConnectedState;
    L15:
        if (r8.equals(this.mRoleNegotiationState) == false) goto L19;
        return BWDLInnerConstant.ControlLinkSmState.RoleNegotiationState;
    L19:
        if (r8.equals(this.mConfigurationState) == false) goto L23;
        return BWDLInnerConstant.ControlLinkSmState.ConfigurationState;
    L23:
        if (r8.equals(this.mSecurityState) == false) goto L27;
        return BWDLInnerConstant.ControlLinkSmState.SecurityState;
    L27:
        if (r8.equals(this.mCapabilityExchangeState) == false) goto L31;
        return BWDLInnerConstant.ControlLinkSmState.CapabilityExchangeState;
    L31:
        if (r8.equals(this.mActiveState) == false) goto L35;
        return BWDLInnerConstant.ControlLinkSmState.ActiveState;
    L35:
        if (r8.equals(this.mPowerSavingState) == false) goto L39;
        return BWDLInnerConstant.ControlLinkSmState.PowerSavingState;
    L39:
        if (r8.equals(this.mLinkLossState) == true) goto L41;
        return null;
    L41:
        return BWDLInnerConstant.ControlLinkSmState.LinkLossState;
    }

    public boolean addControlLinkToSm(ControlLink r8) {
        List<ControlLink> r10 = this.mControlLinkList;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mControlLinkList.contains(r8) == false) goto L9;
        monitor-exit(r10);     // Catch: Throwable -> L13
        return false;
    L9:
        this.mControlLinkList.add(r8);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return true;
    }

    public void cleanup() {
        BWDLLog.d(TAG, "cleanup");
        this.mListenerList.clear();
        this.mControlLinkList.clear();
        quitNow();
    }

    public ChannelConfiguration getChannelConfiguration() {
        return this.mChannelConfiguration;
    }

    public ControlLinkHandler getControlLinkHandler() {
        return this.mControlLinkHandler;
    }

    public List<ControlLink> getControlLinkList() {
        return this.mControlLinkList;
    }

    public BWDLInnerConstant.ControlLinkSmState getCurrentSmState() {
        return this.mCurrentState;
    }

    public void init() {
        if (this.mDevice.getConnectivityType() != BWDLInnerConstant.ConnectivityType.GATT) goto L6;
        this.mBWDLAdapter = GattOriginal.getInstance(this.mContext);
    L6:
        if (this.mControlLinkHandler != null) goto L8;
        this.mControlLinkHandler = new ControlLinkHandler(this.mContext, this, this.mDevice);
    L8:
        this.mChannelConfiguration = new ChannelConfiguration(this.mContext, this, this.mDevice);
        this.mPowerSaving = new PowerSaving();
        this.mDisconnectedState = new DisconnectedState(this);
        this.mConnectingState = new ConnectingState(this);
        this.mConnectedState = new ConnectedState(this);
        this.mRoleNegotiationState = new RoleNegotiationState(this);
        this.mConfigurationState = new ConfigurationState(this);
        this.mSecurityState = new SecurityState(this);
        this.mCapabilityExchangeState = new CapabilityExchangeState(this);
        this.mActiveState = new ActiveState(this);
        this.mPowerSavingState = new PowerSavingState(this);
        this.mLinkLossState = new LinkLossState(this);
        IBWDLState r8 = this.mDisconnectedState;
        this.mPreState = r8;
        this.mCurrentState = BWDLInnerConstant.ControlLinkSmState.DisconnectedState;
        addState(r8);
        addState(this.mConnectingState);
        addState(this.mConnectedState);
        addState(this.mRoleNegotiationState);
        addState(this.mConfigurationState);
        addState(this.mSecurityState);
        addState(this.mCapabilityExchangeState);
        addState(this.mActiveState);
        addState(this.mPowerSavingState);
        addState(this.mLinkLossState);
        setInitialState(this.mDisconnectedState);
        start();
        StateListener r10 = new StateListener(this);
        this.mStateListener = r10;
        setStateListener(r10);
    }

    public void removeControlLinkSMListener(IControlLinkSMListener r8) {
        List<IControlLinkSMListener> r10 = this.mListenerList;
        monitor-enter(r10);
        this.mListenerList.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean removeControlLinkToSm(ControlLink r8) {
        List<ControlLink> r10 = this.mControlLinkList;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mControlLinkList.contains(r8) == false) goto L10;
        this.mControlLinkList.remove(r8);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return true;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return false;
    }

    public void setControlLinkSMListener(IControlLinkSMListener r8) {
        List<IControlLinkSMListener> r10 = this.mListenerList;
        monitor-enter(r10);
        this.mListenerList.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
