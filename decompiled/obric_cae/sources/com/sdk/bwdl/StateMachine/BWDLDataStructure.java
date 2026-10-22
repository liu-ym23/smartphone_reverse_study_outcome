package com.sdk.bwdl.StateMachine;

import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLDataStructure {

    /* JADX INFO: renamed from: com.sdk.bwdl.StateMachine.BWDLDataStructure$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType = null;

        static {
            int[] r8 = new int[BWDLConstant.LinkType.values().length];
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType = r8;
            r8[BWDLConstant.LinkType.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType[BWDLConstant.LinkType.Socket.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType[BWDLConstant.LinkType.SocketChannel.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class BWDLCommandStructure {
        private short mCID;
        private byte mCommandType;
        private byte[] mData;
        private byte mProcedureType;
        private short mPropertyType;

        public BWDLCommandStructure(short r8, byte r10, short r11, byte r12, byte[] r13) {
            this.mPropertyType = r8;
            this.mProcedureType = r10;
            this.mCID = r11;
            this.mCommandType = r12;
            this.mData = r13;
        }

        public byte[] buildCmd() {
            ByteArrayOutputStream r8 = new ByteArrayOutputStream();
            r8.write(BWDLUtil.shortToByte(this.mPropertyType));
            r8.write(this.mProcedureType);
            r8.write(BWDLUtil.shortToByte(this.mCID));
            r8.write(this.mCommandType);
            r8.write(this.mData);
            return r8.toByteArray();
        }
    }

    public static class DataLinkParamStructure {
        public static final byte BT_SPP = 32;
        public static final byte LINK_PARAM = 2;
        public static final byte LINK_TYPE = 1;
        public static final byte NFC = 48;
        public static final byte SOCKET = 17;
        public static final byte SOCKET_CHANNEL = 19;
        public static final byte STATUS_ACCEPT = 1;
        public static final byte STATUS_REJECT_FOR_BUSY = 2;
        public static final byte STATUS_REJECT_FOR_ROLE = 3;
        public static final byte STATUS_REJECT_FOR_SOFT_AP = 4;
        public static final byte WIFI = 18;
        public static final byte WIFI_P2P = 16;
        private byte mLength;
        private byte mLinkParam;
        private byte mLinkType;
        private byte[] mLinkTypeData;
        private byte[] mParam;
        private short mParamLength;

        public DataLinkParamStructure(byte[] r8, byte[] r10) {
            this.mLinkType = 1;
            this.mLength = (byte) r8.length;
            this.mLinkTypeData = r8;
            this.mLinkParam = 2;
            this.mParamLength = (short) r10.length;
            this.mParam = r10;
        }

        public static BWDLConstant.LinkType[] ByteToLinkType(byte[] r8) {
            BWDLConstant.LinkType[] r10 = new BWDLConstant.LinkType[r8.length];
            int r11 = r8.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r12 >= r11) goto L16;
            byte r14 = r8[r12];
            if (r14 != 16) goto L7;
            int r15 = r13 + 1;
            r10[r13] = BWDLConstant.LinkType.P2P;
        L14:
            r13 = r15;
        L15:
            r12 = r12 + 1;
            goto L3
        L7:
            if (r14 != 17) goto L9;
            r15 = r13 + 1;
            r10[r13] = BWDLConstant.LinkType.Socket;
            goto L14
        L9:
            if (r14 != 19) goto L15;
            r15 = r13 + 1;
            r10[r13] = BWDLConstant.LinkType.SocketChannel;
            goto L14
        L16:
            return r10;
        }

        public byte LinkTypeToByte(BWDLConstant.LinkType r8) {
            int r10 = AnonymousClass1.$SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType[r8.ordinal()];
            if (r10 != 1) goto L5;
            return WIFI_P2P;
        L5:
            if (r10 != 2) goto L7;
            return SOCKET;
        L7:
            if (r10 == 3) goto L9;
            return 0;
        L9:
            return 19;
        }

        public byte[] buildData() {
            ByteArrayOutputStream r8 = new ByteArrayOutputStream();
            r8.write(this.mLinkType);
            r8.write(this.mLength);
            r8.write(this.mLinkTypeData);
            r8.write(this.mLinkParam);
            r8.write(BWDLUtil.shortToByte(this.mParamLength));
            r8.write(this.mParam);
            return r8.toByteArray();
        }

        public DataLinkParamStructure(BWDLConstant.LinkType[] r8, byte[] r10) {
            int r11 = r8.length;
            byte[] r12 = new byte[r11];
            int r13 = r8.length;
            int r14 = 0;
            int r15 = 0;
        L3:
            if (r14 >= r13) goto L5;
            r12[r15] = LinkTypeToByte(r8[r14]);
            r14 = r14 + 1;
            r15 = r15 + 1;
            goto L3
        L5:
            this.mLinkType = 1;
            this.mLength = (byte) r11;
            this.mLinkTypeData = r12;
            this.mLinkParam = 2;
            this.mParamLength = (short) r10.length;
            this.mParam = r10;
        }
    }

    public BWDLDataStructure() {
    }
}
