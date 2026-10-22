package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
    private boolean mDestroyed;

    public RegistrationPolicyApplicationStatus() {
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void destroy() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        ApplicationStatus.unregisterApplicationStateListener(this);
        this.mDestroyed = true;
    }

    @VisibleForTesting
    public int getApplicationState() {
        return ApplicationStatus.getStateForApplication();
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect r8) {
        super.init(r8);
        ApplicationStatus.registerApplicationStateListener(this);
        onApplicationStateChange(getApplicationState());
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.ApplicationStateListener
    public void onApplicationStateChange(int r8) {
        if (r8 != 1) goto L6;
        register();
        return;
    L6:
        if (r8 != 2) goto L10;
        unregister();
        return;
    }
}
