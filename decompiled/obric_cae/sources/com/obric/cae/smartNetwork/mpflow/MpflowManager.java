package com.obric.cae.smartNetwork.mpflow;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ServiceManager;
import com.obric.cae.libs.mpflow.ICaeMpflowManager;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class MpflowManager {
    private static final String SERVICE_NAME = "cae_mpflow";
    private static final String TAG = "MpflowManager";
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private MpflowInterface mMpflowInterface;
    private MpflowService mMpflowService;
    private NetMonitor mNetMonitor;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.mpflow.MpflowManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class MpflowService extends ICaeMpflowManager.Stub {
        final /* synthetic */ MpflowManager this$0;

        private MpflowService(MpflowManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void H2(MpflowService r8, int r10) {
            r8.lambda$disconnectSocketByUid$0(r10);
        }

        public static /* synthetic */ void I2(MpflowService r8, int r10) {
            r8.lambda$disconnectSocketByPid$1(r10);
        }

        private /* synthetic */ void lambda$disconnectSocketByPid$1(int r8) {
            int r10 = MpflowManager.access$100(this.this$0).disconnectSocketByPid(r8);
            CaeLog.i(MpflowManager.access$300(), "disconnectSocketByPid: " + r8 + ", ret: " + r10);
        }

        private /* synthetic */ void lambda$disconnectSocketByUid$0(int r8) {
            int r10 = MpflowManager.access$100(this.this$0).disconnectSocketByUid(r8);
            CaeLog.i(MpflowManager.access$300(), "disconnectSocketByUid: " + r8 + ", ret: " + r10);
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByPid(int r8, int r10, boolean r11) {
            return MpflowManager.access$100(this.this$0).bindNetByPid((byte) r8, r10, r11);
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByUid(int r8, int r10, boolean r11) {
            return MpflowManager.access$100(this.this$0).bindNetByUid((byte) r8, r10, r11);
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByPid(final int r8) {
            MpflowManager.access$200(this.this$0).post(new b(this, r8));
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByUid(final int r8) {
            MpflowManager.access$200(this.this$0).post(new a(this, r8));
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int modifyNetName(int r8, String r10) {
            return MpflowManager.access$100(this.this$0).modifyNetName((byte) r8, r10);
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int setSocketOptByUid(int r8, int r10, int r11) {
            return MpflowManager.access$100(this.this$0).setSocketOptByUid(r8, r10, r11);
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByPid(int r8, int r10, boolean r11) {
            return MpflowManager.access$100(this.this$0).switchNetByPid((byte) r8, r10, r11);
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByUid(int r8, int r10, boolean r11) {
            return MpflowManager.access$100(this.this$0).switchNetByUid((byte) r8, r10, r11);
        }

        public /* synthetic */ MpflowService(MpflowManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public MpflowManager(Context r8) {
        this.mMpflowInterface = new MpflowInterface();
        this.mContext = r8;
        MpflowService r10 = new MpflowService(this, null);
        this.mMpflowService = r10;
        ServiceManager.addService(SERVICE_NAME, r10);
        NetMonitor r11 = new NetMonitor(this.mContext);
        this.mNetMonitor = r11;
        r11.start();
        HandlerThread r12 = new HandlerThread("MpflowManagerHandler");
        this.mHandlerThread = r12;
        r12.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public static /* synthetic */ MpflowInterface access$100(MpflowManager r8) {
        return r8.mMpflowInterface;
    }

    public static /* synthetic */ Handler access$200(MpflowManager r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ String access$300() {
        return TAG;
    }
}
