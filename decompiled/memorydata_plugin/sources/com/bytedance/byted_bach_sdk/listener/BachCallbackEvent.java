package com.bytedance.byted_bach_sdk.listener;

import com.bytedance.byted_bach_sdk.buffer.BachAlgorithmMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class BachCallbackEvent {
    public int algType;
    public BachAlgorithmMap dataMap;
    public String graphName;
    public String nodeName;
    public BachCallbackType type;

    public static final enum BachCallbackType extends Enum<BachCallbackType> {
        private static final /* synthetic */ BachCallbackType[] $VALUES = null;
        public static final BachCallbackType ASYNC_EXECUTE = null;
        public static final BachCallbackType ASYNC_INIT = null;
        public static final BachCallbackType CUSTOM = null;
        public static final BachCallbackType ENIGMA = null;
        public static final BachCallbackType INVALID = null;
        public static final BachCallbackType LLM_VLM = null;
        public static final BachCallbackType SCRIPT = null;

        static {
            BachCallbackType r0 = new BachCallbackType("INVALID", 0);
            INVALID = r0;
            BachCallbackType r1 = new BachCallbackType("ASYNC_INIT", 1);
            ASYNC_INIT = r1;
            BachCallbackType r3 = new BachCallbackType("ASYNC_EXECUTE", 2);
            ASYNC_EXECUTE = r3;
            BachCallbackType r5 = new BachCallbackType("ENIGMA", 3);
            ENIGMA = r5;
            BachCallbackType r7 = new BachCallbackType("SCRIPT", 4);
            SCRIPT = r7;
            BachCallbackType r9 = new BachCallbackType("LLM_VLM", 5);
            LLM_VLM = r9;
            BachCallbackType r11 = new BachCallbackType("CUSTOM", 6);
            CUSTOM = r11;
            $VALUES = new BachCallbackType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private BachCallbackType(String r1, int r2) {
            super(r1, r2);
        }

        public static BachCallbackType valueOf(String r2) {
            return (BachCallbackType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BachCallbackType.class, r2), BachCallbackType.class, "com.obric.memorydata.plugin");
        }

        public static BachCallbackType[] values() {
            return (BachCallbackType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BachCallbackType[].class, "com.obric.memorydata.plugin");
        }
    }

    BachCallbackEvent() {
        this.type = BachCallbackType.INVALID;
        this.algType = -1;
    }

    BachCallbackEvent(int r2) {
        this.type = BachCallbackType.INVALID;
        this.algType = -1;
        this.type = BachCallbackType.values()[r2];
    }

    BachCallbackEvent(BachCallbackType r2) {
        this.type = BachCallbackType.INVALID;
        this.algType = -1;
        this.type = r2;
    }
}
