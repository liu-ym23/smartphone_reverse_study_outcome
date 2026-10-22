package cf;

import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.smartNetwork.netAccel.AccelMetric;
import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;
import com.sdk.bwdl.Utils.BWDLInnerConstant;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f3594b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f3595c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f3596d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3597a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a[] f3598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3600c;

        public a() {
            this.f3598a = new a[256];
            this.f3599b = 0;
            this.f3600c = 0;
        }

        public a(int r8, int r10) {
            this.f3598a = null;
            this.f3599b = r8;
            int r11 = r10 & 7;
            if (r11 != 0) goto L5;
            r11 = 8;
        L5:
            this.f3600c = r11;
        }
    }

    static {
        f3594b = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, BWDLInnerConstant.LINK_RECOVERY, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, IdlErrors.E_RejectInferDeviceOverheat, 120, 121, 122, AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        f3595c = new byte[]{13, BWDLCommandBuilder.DEVICE_CAPABILITIES, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, BWDLCommandBuilder.DATA_LINK_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DATA_LINK_RESP, BWDLCommandBuilder.DATA_LINK_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, 24, BWDLCommandBuilder.DEVICE_CAPABILITIES, 24, 24, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, 24, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, 24, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.DATA_LINK_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, 24, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.DATA_LINK_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, 26, 26, BWDLCommandBuilder.DATA_LINK_RESP, 19, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, 26, 27, 27, 26, 27, 24, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, 26, 26, 28, 27, 27, 27, BWDLCommandBuilder.DATA_LINK_RESP, 24, BWDLCommandBuilder.DATA_LINK_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.CHANNEL_CONFIG_REQ, BWDLCommandBuilder.DEVICE_CAPABILITIES, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, BWDLCommandBuilder.CHANNEL_CONFIG_RESP, 25, 25, 24, 24, 26, BWDLCommandBuilder.DEVICE_CAPABILITIES, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f3596d = new q();
    }

    public q() {
        this.f3597a = new a();
        int r8 = 0;
    L3:
        byte[] r10 = f3595c;
        if (r8 >= r10.length) goto L21;
        int r11 = f3594b[r8];
        byte r12 = r10[r8];
        a r13 = new a(r8, r12);
        a r14 = this.f3597a;
    L7:
        if (r12 <= 8) goto L16;
        r12 = (byte) (r12 - 8);
        int r15 = (r11 >>> r12) & 255;
        a[] r16 = r14.f3598a;
        if (r16 == null) goto L15;
        if (r16[r15] != null) goto L13;
        r16[r15] = new a();
    L13:
        r14 = r16[r15];
        goto L7
    L15:
        throw new IllegalStateException("invalid dictionary: prefix not unique");
    L16:
        int r17 = 8 - r12;
        int r18 = (r11 << r17) & 255;
        int r19 = 1 << r17;
        int r20 = r18;
    L18:
        if (r20 >= (r18 + r19)) goto L20;
        r14.f3598a[r20] = r13;
        r20 = r20 + 1;
        goto L18
    L20:
        r8 = r8 + 1;
        goto L3
    }
}
