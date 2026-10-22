package com.obric.aikernel.middleware.impl.appcontext;

import android.content.Context;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.IReceiverRegister;
import com.obric.aikernel.middleware.api.appcontext.receiver.ChargingStateListener;
import com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener;
import com.obric.aikernel.middleware.api.appcontext.receiver.a;
import com.obric.aikernel.middleware.api.appcontext.receiver.b;
import com.obric.aikernel.middleware.api.appcontext.receiver.d;
import com.obric.aikernel.middleware.api.appcontext.receiver.e;
import com.obric.aikernel.middleware.api.appcontext.receiver.f;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class ReceiverRegisterImpl implements IReceiverRegister {
    public static final ReceiverRegisterImpl INSTANCE = null;
    private static final String TAG = "ReceiverRegisterImpl";
    private static final AtomicBoolean initialized = null;
    private static final String[] listenConfigs = null;

    static {
        INSTANCE = new ReceiverRegisterImpl();
        listenConfigs = new String[]{"sys_res_mgr", "bluetooth_on"};
        initialized = new AtomicBoolean(false);
    }

    private ReceiverRegisterImpl() {
    }

    @JvmStatic
    public static final ReceiverRegisterImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IReceiverRegister
    public void init() {
        int r10 = 0;
        if (initialized.compareAndSet(false, true) == true) goto L6;
        AIKLog.INSTANCE.d(TAG, "init skipped: already initialized");
        return;
    L6:
        Context r11 = AppContext.INSTANCE.getContext();
        e.f4540a.c(r11);
        NetworkStateListener.f4510a.k(r11);
        d.f4534a.d(r11);
        ChargingStateListener.f4508a.d(r11);
        a.f4528a.d(r11);
        n7.a.f11264a.c(r11);
        b.f4531a.a();
        String[] r12 = listenConfigs;
        int r13 = r12.length;
    L7:
        if (r10 >= r13) goto L9;
        String r14 = r12[r10];
        f.f4546a.c(r11, r14);
        r10 = r10 + 1;
        goto L7
    }
}
