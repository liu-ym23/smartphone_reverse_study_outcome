package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class NetworkChangeNotifierAutoDetect$RegistrationPolicy {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private NetworkChangeNotifierAutoDetect mNotifier;

    public NetworkChangeNotifierAutoDetect$RegistrationPolicy() {
    }

    public abstract void destroy();

    public final void register() {
        this.mNotifier.register();
    }

    public final void unregister() {
        this.mNotifier.unregister();
    }

    static {
    }

    public void init(NetworkChangeNotifierAutoDetect r1) {
        this.mNotifier = r1;
    }
}
