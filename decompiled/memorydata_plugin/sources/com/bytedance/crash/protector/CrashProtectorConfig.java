package com.bytedance.crash.protector;

import android.os.Build;
import android.util.Pair;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CrashProtectorConfig {
    private static final byte[] ENDIAN_TAG = null;
    private static final String LOG_TAG = "NPTH_PROT";
    private static final byte[] MAGIC_NUMBER = null;
    private static final byte[] MAGIC_VERSION = null;
    private static JSONObject sConfigList;
    private static JSONObject sScopeList;
    private static final Pattern sScopePattern = null;
    private ArrayList<String> mBlackList;
    private byte[] mConfigData;
    private int mConfigSize;
    private ArrayList<String> mEnabledScopeList;
    private boolean mIs64BitRuntime;
    private ArrayList<String> mWhiteList;

    class ConfigInfo {
        String abortMsg;
        BufferWriter elfList;
        int elfListCount;
        int flag;
        BufferWriter frameList;
        int framesCount;
        int intervalTimeMs;
        int maxIgnoreDepth;
        int maxResumeCount;
        ArrayList<Pair<Integer, Long>> regs;
        int returnFrameIndex;
        String scope;
        long signal;
        final /* synthetic */ CrashProtectorConfig this$0;

        ConfigInfo(CrashProtectorConfig r3) {
            this.this$0 = r3;
            this.flag = 0;
            this.elfListCount = 0;
            this.returnFrameIndex = 0;
            this.maxIgnoreDepth = 0;
            this.framesCount = 0;
            this.maxResumeCount = 0;
            this.intervalTimeMs = 0;
            this.signal = 0;
            this.regs = null;
        }

        public void encode(BufferWriter r12) {
            r12.align(8);
            int r1 = r12.position();
            int r2 = 0;
            int r3 = r12.prependInt32(0);
            r12.writeInt32(this.flag);
            r12.writeByte(this.scope.getBytes().length);
            r12.writeByte(this.elfListCount);
            r12.writeByte(this.returnFrameIndex);
            r12.writeByte(this.maxIgnoreDepth);
            r12.writeByte(this.framesCount);
            ArrayList<Pair<Integer, Long>> r4 = this.regs;
            if (r4 != null) goto L5;
            int r5 = 0;
        L6:
            r12.writeByte(r5);
            r12.writeInt32(this.maxResumeCount);
            r12.writeInt32(this.intervalTimeMs);
            r12.writeInt64(this.signal);
            int r6 = r12.prependInt32(0);
            int r7 = r12.prependInt32(0);
            int r8 = r12.prependInt32(0);
            int r9 = r12.prependInt32(0);
            int r10 = r12.prependInt32(0);
            int r11 = r12.prependInt32(0);
            r12.writeInt32At(r6, r12.position() - r1);
            r12.write(this.scope.getBytes());
            r12.writeByte(0);
            String r13 = this.abortMsg;
            if (r13 != null) goto L9;
        L11:
            r12.writeInt32At(r8, r12.position() - r1);
            r12.write(this.elfList.data(), 0, this.elfList.position());
            r12.writeInt32At(r9, r12.position() - r1);
            r12.write(this.frameList.data(), 0, this.frameList.position());
            ArrayList<Pair<Integer, Long>> r14 = this.regs;
            if (r14 != null) goto L14;
        L29:
            r12.align(8);
            r12.writeInt32At(r3, r12.position() - r1);
            return;
        L14:
            if (r14.isEmpty() == true) goto L29;
            r12.writeInt32At(r10, r12.position() - r1);
            int r15 = 0;
        L17:
            if (r15 >= this.regs.size()) goto L20;
            r12.writeByte(((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.regs.get(r15), Pair.class, "com.obric.memorydata.plugin")).first, Integer.class, "com.obric.memorydata.plugin")).intValue());
            r15 = r15 + 1;
            goto L17
        L20:
            if (CrashProtectorConfig.access$000(this.this$0) == false) goto L25;
            r12.align(8);
            r12.writeInt32At(r11, r12.position() - r1);
        L23:
            if (r2 >= this.regs.size()) goto L29;
            r12.writeInt64(((Long) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.regs.get(r2), Pair.class, "com.obric.memorydata.plugin")).second, Long.class, "com.obric.memorydata.plugin")).longValue());
            r2 = r2 + 1;
            goto L23
        L25:
            r12.align(4);
            r12.writeInt32At(r11, r12.position() - r1);
        L27:
            if (r2 >= this.regs.size()) goto L29;
            r12.writeInt32(((Long) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.regs.get(r2), Pair.class, "com.obric.memorydata.plugin")).second, Long.class, "com.obric.memorydata.plugin")).intValue());
            r2 = r2 + 1;
            goto L27
        L9:
            if (r13.isEmpty() == true) goto L11;
            r12.writeInt32At(r7, r12.position() - r1);
            r12.write(this.abortMsg.getBytes());
            r12.writeByte(0);
            goto L11
        L5:
            r5 = r4.size();
            goto L6
        }
    }

    static final enum ElfTag extends Enum<ElfTag> {
        private static final /* synthetic */ ElfTag[] $VALUES = null;
        public static final ElfTag ELF_BUILD_ID = null;
        public static final ElfTag ELF_NAME = null;
        public static final ElfTag ELF_PATH = null;

        static {
            ElfTag r0 = new ElfTag("ELF_BUILD_ID", 0);
            ELF_BUILD_ID = r0;
            ElfTag r1 = new ElfTag("ELF_PATH", 1);
            ELF_PATH = r1;
            ElfTag r3 = new ElfTag("ELF_NAME", 2);
            ELF_NAME = r3;
            $VALUES = new ElfTag[]{r0, r1, r3};
        }

        private ElfTag(String r1, int r2) {
            super(r1, r2);
        }

        public static ElfTag valueOf(String r2) {
            return (ElfTag) ZeusTransformUtils.preCheckCast(Enum.valueOf(ElfTag.class, r2), ElfTag.class, "com.obric.memorydata.plugin");
        }

        public static ElfTag[] values() {
            return (ElfTag[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ElfTag[].class, "com.obric.memorydata.plugin");
        }
    }

    static final enum SymbolTag extends Enum<SymbolTag> {
        private static final /* synthetic */ SymbolTag[] $VALUES = null;
        public static final SymbolTag SYMBOL_ALL = null;
        public static final SymbolTag SYMBOL_NAME = null;
        public static final SymbolTag SYMBOL_OFFSET = null;

        static {
            SymbolTag r0 = new SymbolTag("SYMBOL_ALL", 0);
            SYMBOL_ALL = r0;
            SymbolTag r1 = new SymbolTag("SYMBOL_OFFSET", 1);
            SYMBOL_OFFSET = r1;
            SymbolTag r3 = new SymbolTag("SYMBOL_NAME", 2);
            SYMBOL_NAME = r3;
            $VALUES = new SymbolTag[]{r0, r1, r3};
        }

        private SymbolTag(String r1, int r2) {
            super(r1, r2);
        }

        public static SymbolTag valueOf(String r2) {
            return (SymbolTag) ZeusTransformUtils.preCheckCast(Enum.valueOf(SymbolTag.class, r2), SymbolTag.class, "com.obric.memorydata.plugin");
        }

        public static SymbolTag[] values() {
            return (SymbolTag[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SymbolTag[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        MAGIC_NUMBER = new byte[]{80, 82, 79, 84};
        MAGIC_VERSION = new byte[]{48, 48, 52};
        ENDIAN_TAG = new byte[]{120, 86, 52, 18};
        sScopePattern = Pattern.compile("^com\\.bytedance(\\.\\w+)*$");
        sScopeList = null;
        sConfigList = null;
    }

    CrashProtectorConfig() {
        this.mEnabledScopeList = new ArrayList();
        this.mConfigData = null;
        this.mConfigSize = 0;
        this.mIs64BitRuntime = true;
    }

    static /* synthetic */ boolean access$000(CrashProtectorConfig r0) {
        return r0.mIs64BitRuntime;
    }

    public static boolean addConfig(JSONObject r3) {
        if (sScopeList != null) goto L6;
        sScopeList = new JSONObject();
    L6:
        if (sConfigList != null) goto L20;
        sConfigList = new JSONObject();
    L20:
        String r1 = r3.optString("scope");     // Catch: Exception -> L17
        if (r1.isEmpty() == false) goto L12;
    L16:
        return false;
    L12:
        if (r1.startsWith("com.bytedance.") == false) goto L16;
        sConfigList.put(r1, r3);     // Catch: Exception -> L17
        sScopeList.put(r1, 1);     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        NpthLog.e(LOG_TAG, e.getMessage());
        return false;
    }

    private static Long hexStringToLong(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L8;
        return null;
    L8:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L12;
        return null;
    L12:
        if (r4.startsWith("0x") == true) goto L20;
        if (r4.startsWith("0X") == true) goto L20;
    L18:
        return null;
    L20:
        return Long.valueOf(Long.parseLong(r4.substring(2), 16));
    }

    public static boolean isValidRegLabel(String r4) {
        if (r4.length() == 2) goto L5;
        return false;
    L5:
        char r0 = Character.toLowerCase(r4.charAt(0));
        int r5 = r4.charAt(1) - '0';
        if (r5 >= 0) goto L9;
        return false;
    L9:
        if (r5 >= 8) goto L19;
        if (r0 == 'x') goto L23;
        if (r0 == 'w') goto L23;
        if (r0 == 'd') goto L23;
        if (r0 != 's') goto L19;
    L23:
        return true;
    L19:
        if (r5 < 4) goto L21;
        return false;
    L21:
        if (r0 == 'r') goto L23;
        return false;
    }

    public static boolean isValidScopeName(String r2) {
        if (r2.length() < 256) goto L5;
    L7:
        return false;
    L5:
        if (sScopePattern.matcher(r2).matches() == false) goto L7;
        return true;
    }

    private static boolean matchesScope(String r6, ArrayList<String> r7, ArrayList<String> r8) {
        if (isValidScopeName(r6) == true) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r7.size()) goto L16;
        if (r6.startsWith((String) ZeusTransformUtils.preCheckCast(r7.get(r0), String.class, "com.obric.memorydata.plugin")) == false) goto L15;
        if (((String) ZeusTransformUtils.preCheckCast(r7.get(r0), String.class, "com.obric.memorydata.plugin")).length() == r6.length()) goto L14;
        if (r6.charAt(((String) ZeusTransformUtils.preCheckCast(r7.get(r0), String.class, "com.obric.memorydata.plugin")).length()) != '.') goto L15;
    L14:
        return false;
    L15:
        r0 = r0 + 1;
        goto L7
    L16:
        int r9 = 0;
    L18:
        if (r9 >= r8.size()) goto L28;
        if (r6.startsWith((String) ZeusTransformUtils.preCheckCast(r8.get(r9), String.class, "com.obric.memorydata.plugin")) == false) goto L27;
        if (((String) ZeusTransformUtils.preCheckCast(r8.get(r9), String.class, "com.obric.memorydata.plugin")).length() == r6.length()) goto L25;
        if (r6.charAt(((String) ZeusTransformUtils.preCheckCast(r8.get(r9), String.class, "com.obric.memorydata.plugin")).length()) != '.') goto L27;
        return true;
    L25:
        return true;
    L27:
        r9 = r9 + 1;
        goto L18
    L28:
        return false;
    }

    private boolean parse(JSONObject r8, JSONObject r9) {
        if (parseScopeListInfo(r8) == true) goto L5;
        return false;
    L5:
        this.mIs64BitRuntime = NativeBridge.is64BitRuntime();
        BufferWriter r10 = new BufferWriter();
        r10.write(MAGIC_NUMBER);
        r10.write(MAGIC_VERSION);
        if (this.mIs64BitRuntime == false) goto L8;
        int r1 = 2;
    L9:
        r10.writeByte(r1);
        r10.write(ENDIAN_TAG);
        int r2 = r10.prependInt32(0);
        int r3 = r10.prependInt32(0);
        r10.align(8);
        int r4 = r10.position();
        int r11 = writeConfigListInfo(r10, r9);
        NpthLog.i(LOG_TAG, "config count: " + r11);
        if (r11 > 0) goto L12;
        return false;
    L12:
        r10.writeInt32At(r3, r10.position() - r4);
        r10.writeInt32At(r2, r11);
        writeCheckSum(r10);
        this.mConfigData = r10.data();
        this.mConfigSize = r10.position();
        return true;
    L8:
        r1 = 1;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [int] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8, types: [int] */
    /* JADX WARN: Type inference failed for: r15v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    private boolean parseFramesInfo(ConfigInfo r18, JSONArray r19) {
        JSONArray r1 = r19;
        ?? r2 = 0;
        if (r1 != null) goto L5;
        return false;
    L5:
        int r3 = r19.length();
        int r4 = 255;
        if (r3 <= 255) goto L8;
        r3 = 255;
    L8:
        r18.framesCount = r3;
        r18.frameList = new BufferWriter();
        BufferWriter r5 = r18.frameList;
        r18.elfList = new BufferWriter();
        BufferWriter r6 = r18.elfList;
        int r7 = -1;
        int r8 = 0;
        int r9 = -1;
    L9:
        if (r8 >= r3) goto L97;
        JSONObject r11 = r1.optJSONObject(r8);
        if (r9 == r7) goto L13;
    L15:
        String r12 = r11.optString("elf_build_id");
        ?? r13 = r11.optString("elf_path");
        String r14 = r11.optString("elf_name");
        if (r12.isEmpty() == true) goto L25;
        r12 = r12.replace(" ", "");
        int r15 = r12.length() / 2;
        byte[] r16 = new byte[r15];
        ?? r17 = r2;
    L18:
        if (r17 >= r15) goto L21;
        int r10 = r17 * 2;
        r16[r17] = (byte) (Integer.parseInt(r12.substring(r10, r10 + 2), 16) & r4);     // Catch: Throwable -> L23
        r17 = r17 + 1;     // Catch: Throwable -> L23
    L23:
        return r2;
    L21:
        ElfTag r20 = ElfTag.ELF_BUILD_ID;     // Catch: Throwable -> L23
    L33:
        if (r16 == null) goto L93;
        if (r16.length >= 256) goto L93;
        byte[] r110 = r6.data();
        ?? r111 = r2;
    L39:
        if (r111 >= r6.position()) goto L56;
        byte r112 = r110[r111];
        byte r21 = r110[r111 + 1];
        if (r112 != r20.ordinal()) goto L54;
        if (r21 != r16.length) goto L54;
        int r22 = 0;
    L46:
        if (r22 >= r16.length) goto L51;
        if (r110[(r111 + 2) + r22] != r16[r22]) goto L49;
        r22 = r22 + 1;
        goto L46
    L49:
        boolean r23 = false;
    L52:
        if (r23 == false) goto L54;
    L51:
        r23 = true;
    L54:
        r111 = r111 + (r21 + 3);
    L56:
        if (r111 > r6.position()) goto L57;
        if (r111 != r6.position()) goto L62;
        r18.elfListCount++;
        r6.writeByte(r20.ordinal());
        r6.writeByte(r16.length);
        r6.write(r16);
        r6.writeByte(0);
    L62:
        r5.writeUleb128((long) r111);
        if (r11.optInt("redacted_match") == 0) goto L66;
        r5.writeByte(SymbolTag.SYMBOL_ALL.ordinal());
    L89:
        r8 = r8 + 1;
        r1 = r19;
        r2 = 0;
        r4 = 255;
        r7 = -1;
        goto L9
    L66:
        if (r11.has("offset_start") == true) goto L68;
        String r24 = r11.optString("symbol_name");
        if (r24.isEmpty() == true) goto L90;
        r5.writeByte(SymbolTag.SYMBOL_NAME.ordinal());
        r5.writeString(r24);
        goto L89
    L90:
        return false;
    L68:
        if (r12.isEmpty() == true) goto L69;
        Long r25 = hexStringToLong(r11.opt("offset_start"));
        if (r25 != null) goto L74;
        r25 = Long.valueOf(r11.optLong("offset_start"));
    L74:
        Long r26 = hexStringToLong(r11.opt("offset_next"));
        if (r26 != null) goto L78;
        r26 = Long.valueOf(r11.optLong("offset_next"));
    L78:
        if (r25.longValue() == 0) goto L84;
        if (r26.longValue() == 0) goto L127;
        if (r25.longValue() >= r26.longValue()) goto L128;
        r5.writeByte(SymbolTag.SYMBOL_OFFSET.ordinal());
        r5.writeUleb128(r25.longValue());
        r5.writeUleb128(r26.longValue());
        goto L89
    L128:
        return false;
    L127:
        return false;
    L84:
        return false;
    L69:
        return false;
    L57:
        return false;
    L93:
        return r2;
    L25:
        if (r13.isEmpty() == true) goto L31;
        if (r13.charAt(r2) != '/') goto L28;
        r20 = ElfTag.ELF_PATH;
        r16 = r13.getBytes();
        goto L33
    L28:
        return r2;
    L31:
        if (r14.isEmpty() == true) goto L95;
        r20 = ElfTag.ELF_NAME;
        r16 = r14.getBytes();
        goto L33
    L95:
        return r2;
    L13:
        if (r11.optInt("return_from_current_stack") == 0) goto L15;
        r9 = r8;
        goto L15
    L97:
        if (r9 != r7) goto L99;
        r18.flag |= 2;
        return true;
    L99:
        r18.returnFrameIndex = r9;
        return true;
    }

    private boolean parseRegsInfo(ConfigInfo r13, JSONObject r14) {
        if (r14 != null) goto L5;
        return false;
    L5:
        r13.regs = new ArrayList();
        Iterator<String> r1 = r14.keys();
    L7:
        if (r1.hasNext() == false) goto L46;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r2.length() != 2) goto L7;
        char r4 = Character.toLowerCase(r2.charAt(0));
        int r3 = r2.charAt(1) - '0';
        if (r3 < 0) goto L7;
        if (this.mIs64BitRuntime == true) goto L17;
        if (r3 >= 4) goto L7;
        if (r4 != 'r') goto L7;
    L31:
        Long r5 = hexStringToLong(r14.opt(r2));
        if (r5 == null) goto L34;
        long r10 = r5.longValue();
    L39:
        if (r4 == 'w') goto L42;
        if (r4 == 's') goto L42;
        if (r4 == 'r') goto L42;
    L44:
        if (r10 == 0) goto L7;
        r13.regs.add(new Pair(Integer.valueOf(r3), Long.valueOf(r10)));
    L42:
        r10 = r10 & 4294967295L;
        goto L44
    L34:
        if (r4 != 'd') goto L36;
        r10 = Double.doubleToLongBits(r14.optDouble(r2));
        goto L39
    L36:
        if (r4 != 's') goto L38;
        r10 = Float.floatToIntBits((float) r14.optDouble(r2));
        goto L39
    L38:
        r10 = r14.optLong(r2);
        goto L39
    L17:
        if (r3 >= 8) goto L7;
        if (r4 == 'x') goto L24;
        if (r4 == 'w') goto L24;
        if (r4 == 'd') goto L24;
        if (r4 != 's') goto L7;
    L24:
        if (r4 == 'd') goto L26;
        if (r4 != 's') goto L31;
    L26:
        r3 = r3 + 34;
        goto L31
    L46:
        return true;
    }

    private boolean parseScopeListInfo(JSONObject r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        Iterator<String> r1 = r7.keys();
        this.mWhiteList = new ArrayList();
        this.mBlackList = new ArrayList();
    L6:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L19;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (isValidScopeName(r2) == false) goto L6;
        if (r7.optInt(r2) != 0) goto L15;
        r3 = false;
    L15:
        if (r3 == false) goto L17;
        ArrayList<String> r4 = this.mWhiteList;
    L18:
        r4.add(r2);
        goto L6
    L17:
        r4 = this.mBlackList;
        goto L18
    L19:
        NpthLog.i(LOG_TAG, "white list size: " + this.mWhiteList.size());
        return !this.mWhiteList.isEmpty();
    }

    public static int signalStringToNumber(String r8) {
        if (r8 != null) goto L5;
    L61:
        return 0;
    L5:
        if (r8.isEmpty() == true) goto L61;
        r8.hashCode();
        byte r1 = -1;
        switch(r8.hashCode()) {
            case -1849149425: goto L43;
            case -1849145750: goto L39;
            case -1849142984: goto L35;
            case -1849132964: goto L31;
            case -1489105324: goto L27;
            case -1488651809: goto L23;
            case -1488566542: goto L19;
            case -1488524450: goto L15;
            case -274378251: goto L11;
            default: goto L46;
        };
    L46:
        switch(r1) {
            case 0: goto L60;
            case 1: goto L59;
            case 2: goto L58;
            case 3: goto L56;
            case 4: goto L55;
            case 5: goto L53;
            case 6: goto L51;
            case 7: goto L50;
            case 8: goto L48;
            default: goto L47;
        };
    L47:
        return 0;
    L48:
        return 16;
    L50:
        return 5;
    L51:
        return 11;
    L53:
        return 13;
    L55:
        return 6;
    L56:
        return 31;
    L58:
        return 4;
    L59:
        return 8;
    L60:
        return 7;
    L11:
        if (r8.equals("SIGSTKFLT") == false) goto L46;
        r1 = 8;
        goto L46
    L15:
        if (r8.equals("SIGTRAP") == false) goto L46;
        r1 = 7;
        goto L46
    L19:
        if (r8.equals("SIGSEGV") == false) goto L46;
        r1 = 6;
        goto L46
    L23:
        if (r8.equals("SIGPIPE") == false) goto L46;
        r1 = 5;
        goto L46
    L27:
        if (r8.equals("SIGABRT") == false) goto L46;
        r1 = 4;
        goto L46
    L31:
        if (r8.equals("SIGSYS") == false) goto L46;
        r1 = 3;
        goto L46
    L35:
        if (r8.equals("SIGILL") == false) goto L46;
        r1 = 2;
        goto L46
    L39:
        if (r8.equals("SIGFPE") == false) goto L46;
        r1 = 1;
        goto L46
    L43:
        if (r8.equals("SIGBUS") == false) goto L46;
        r1 = 0;
        goto L46
    }

    public static void updateConfig(JSONObject r8) {
        JSONObject r1 = null;
        if (r8 == null) goto L5;
        r1 = r8.optJSONObject("scope_list");
        JSONObject r9 = r8.optJSONObject("config_list");
    L6:
        if (r1 != null) goto L8;
        r1 = new JSONObject();
    L8:
        if (r9 != null) goto L24;
        r9 = new JSONObject();
    L24:
        JSONObject r2 = sConfigList;     // Catch: Exception -> L20
        if (r2 == null) goto L18;
        Iterator<String> r3 = r2.keys();     // Catch: Exception -> L20
    L14:
        if (r3.hasNext() == false) goto L18;
        JSONObject r4 = sConfigList.optJSONObject((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L20
        if (r4 == null) goto L14;
        String r5 = r4.optString("scope");     // Catch: Exception -> L20
        r9.put(r5, r4);     // Catch: Exception -> L20
        r1.put(r5, 1);     // Catch: Exception -> L20
    L18:
        r1.put("com.bytedance.__default__", 1);     // Catch: Exception -> L20
        r9.put("__default__.unwindstack.maps", "{ \"scope\": \"com.bytedance.__default__.unwindstack.maps\",\"signals\": [\"SIGSEGV\"], \"backtraces\":[ { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack6Global19FindAndReadVariableEPNS_4MapsEPKc\", \"return_from_current_stack\": 1 }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE14ForEachSymfileIZNS3_15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPmEUlPS1_E_EEbS6_mT_\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPm\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack8Unwinder14FillInDexFrameEv\" } ] } ");     // Catch: Exception -> L20
    L22:
        sScopeList = r1;
        sConfigList = r9;
        NpthLog.i(LOG_TAG, "update config");
        return;
    L20:
        e = move-exception;
        NpthLog.e(LOG_TAG, e.getMessage());
        goto L22
    L5:
        r9 = null;
        goto L6
    }

    private void writeCheckSum(BufferWriter r9) {
        byte[] r0 = new byte[8];
        r9.align(8);
        byte[] r1 = r9.data();
        int r2 = r9.position();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= 8) goto L7;
        r0[r5] = (byte) (r0[r5] ^ r1[r4 + r5]);
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 8;
        goto L3
    L8:
        r9.write(r0);
    }

    private boolean writeConfigInfo(BufferWriter r12, JSONObject r13) {
        if (r13 != null) goto L5;
        return false;
    L5:
        String r1 = r13.optString("scope");
        if (matchesScope(r1, this.mBlackList, this.mWhiteList) == true) goto L8;
        return false;
    L8:
        int r2 = r13.optInt("min_api_level", 0);
        int r3 = r13.optInt("max_api_level", 100);
        if (Build.VERSION.SDK_INT >= r2) goto L11;
    L58:
        return false;
    L11:
        if (Build.VERSION.SDK_INT > r3) goto L58;
        JSONArray r4 = r13.optJSONArray("api_levels");
        if (r4 == null) goto L25;
        int r5 = 0;
    L17:
        if (r5 >= r4.length()) goto L22;
        if (Build.VERSION.SDK_INT == r4.optInt(r5)) goto L20;
        r5 = r5 + 1;
        goto L17
    L20:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L25;
        return false;
    L22:
        r6 = false;
    L25:
        ConfigInfo r7 = new ConfigInfo(this);
        r7.scope = r1;
        String r8 = r13.optString("abi", "both");
        if (r8.equals("both") == false) goto L28;
    L36:
        JSONArray r9 = r13.optJSONArray("signals");
        if (r9 == null) goto L45;
        int r10 = 0;
    L40:
        if (r10 >= r9.length()) goto L45;
        int r11 = signalStringToNumber(r9.optString(r10));
        if (r11 == 0) goto L44;
        r7.signal |= 1 << r11;
    L44:
        r10 = r10 + 1;
    L45:
        r7.abortMsg = r13.optString("abort_message");
        r7.maxResumeCount = r13.optInt("max_resume_count", 3);
        r7.intervalTimeMs = r13.optInt("interval_time_ms", 3000);
        r7.returnFrameIndex = r13.optInt("return_frame_index");
        if (r13.optInt("dump_all") == 0) goto L48;
        r7.flag |= 1;
    L48:
        int r14 = r13.optInt("max_ignore_depth_before_meet_first_match");
        if (r14 >= 0) goto L51;
        r14 = 0;
    L53:
        r7.maxIgnoreDepth = r14;
        if (parseFramesInfo(r7, r13.optJSONArray("backtraces")) == true) goto L56;
        return false;
    L56:
        parseRegsInfo(r7, r13.optJSONObject("registers"));
        r7.encode(r12);
        this.mEnabledScopeList.add(r1);
        NpthLog.i(LOG_TAG, "add scope: " + r1);
        return true;
    L51:
        if (r14 <= 255) goto L53;
        r14 = 255;
        goto L53
    L28:
        if (this.mIs64BitRuntime == false) goto L32;
        if (r8.equals("arm64-v8a") == true) goto L36;
    L32:
        if (this.mIs64BitRuntime == false) goto L34;
    L35:
        return false;
    L34:
        if (r8.equals("armeabi-v7a") == true) goto L36;
        goto L35
    }

    private int writeConfigListInfo(BufferWriter r6, JSONObject r7) {
        int r0 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        Iterator<String> r1 = r7.keys();
    L7:
        if (r1.hasNext() == false) goto L19;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        JSONObject r3 = r7.optJSONObject(r2);
        if (r3 != null) goto L17;
        String r4 = r7.optString(r2);
        if (r4.isEmpty() == false) goto L21;
    L14:
        if (r3 != null) goto L17;
    L21:
        r3 = new JSONObject(r4);     // Catch: Throwable -> L20
    L17:
        if (writeConfigInfo(r6, r3) == false) goto L7;
        r0 = r0 + 1;
        goto L7
    L19:
        return r0;
    }

    public byte[] getConfigData() {
        return this.mConfigData;
    }

    public int getConfigSize() {
        return this.mConfigSize;
    }

    public boolean isConfigEnabled(JSONObject r2) {
        return isScopeEnabled(r2.optString("scope"));
    }

    public boolean isScopeEnabled(String r5) {
        if (isValidScopeName(r5) == true) goto L5;
        return false;
    L5:
        Iterator<String> r4 = this.mEnabledScopeList.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")).equals(r5) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public boolean parse() {
        return parse(sScopeList, sConfigList);
    }
}
