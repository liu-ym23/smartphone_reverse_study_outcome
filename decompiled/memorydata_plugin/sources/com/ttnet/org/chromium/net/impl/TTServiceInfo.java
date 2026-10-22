package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
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
            ServicePriority r0 = new ServicePriority("Low", 0, 0);
            Low = r0;
            ServicePriority r1 = new ServicePriority("Medium", 1, 1);
            Medium = r1;
            ServicePriority r3 = new ServicePriority("High", 2, 2);
            High = r3;
            $VALUES = new ServicePriority[]{r0, r1, r3};
        }

        private ServicePriority(String r1, int r2, int r3) {
            super(r1, r2);
            this.priority = r3;
        }

        public static ServicePriority valueOf(String r2) {
            return (ServicePriority) ZeusTransformUtils.preCheckCast(Enum.valueOf(ServicePriority.class, r2), ServicePriority.class, "com.obric.memorydata.plugin");
        }

        public static ServicePriority[] values() {
            return (ServicePriority[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ServicePriority[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.priority;
        }
    }

    public TTServiceInfo(int r3, CronetFrontierClient.IServiceMessageReceiver r4) {
        CronetFrontierClient.IServiceMessageReceiver r5 = (CronetFrontierClient.IServiceMessageReceiver) ZeusTransformUtils.wrapperContextForParams(r4, CronetFrontierClient.IServiceMessageReceiver.class, "com.obric.memorydata.plugin");
        this.sequence = true;
        this.priority = ServicePriority.Low;
        if (r3 <= 0) goto L10;
        if (r5 == null) goto L8;
        this.identity = r3;
        this.listener = r5;
        return;
    L8:
        throw new IllegalArgumentException("Service listener must not be null.");
    L10:
        throw new IllegalArgumentException("Service identity must be set greater than 0.");
    }
}
