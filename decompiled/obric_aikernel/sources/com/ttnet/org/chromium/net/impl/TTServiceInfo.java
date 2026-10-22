package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes2.dex */
public class TTServiceInfo {
    public boolean connected;
    public int identity;
    public boolean lazy;
    public CronetFrontierClient.IServiceMessageReceiver listener;
    public ServicePriority priority;
    public boolean sequence;

    public static final enum ServicePriority extends Enum<ServicePriority> {
        private static final /* synthetic */ ServicePriority[] $VALUES = null;
        public static final ServicePriority High = null;
        public static final ServicePriority Low = null;
        public static final ServicePriority Medium = null;
        final int priority;

        static {
            ServicePriority r10 = new ServicePriority("Low", 0, 0);
            Low = r10;
            ServicePriority r11 = new ServicePriority("Medium", 1, 1);
            Medium = r11;
            ServicePriority r12 = new ServicePriority("High", 2, 2);
            High = r12;
            $VALUES = new ServicePriority[]{r10, r11, r12};
        }

        private ServicePriority(String r10, int r11, int r12) {
            super(r10, r11);
            this.priority = r12;
        }

        public static ServicePriority valueOf(String r10) {
            return (ServicePriority) Enum.valueOf(ServicePriority.class, r10);
        }

        public static ServicePriority[] values() {
            return (ServicePriority[]) $VALUES.clone();
        }

        public int getValue() {
            return this.priority;
        }
    }

    public TTServiceInfo(int r10, CronetFrontierClient.IServiceMessageReceiver r11) {
        this.sequence = true;
        this.priority = ServicePriority.Low;
        if (r10 <= 0) goto L10;
        if (r11 == null) goto L8;
        this.identity = r10;
        this.listener = r11;
        return;
    L8:
        throw new IllegalArgumentException("Service listener must not be null.");
    L10:
        throw new IllegalArgumentException("Service identity must be set greater than 0.");
    }
}
