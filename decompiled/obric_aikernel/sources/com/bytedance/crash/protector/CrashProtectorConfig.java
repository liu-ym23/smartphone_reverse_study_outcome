package com.bytedance.crash.protector;

import android.os.Build;
import android.util.Pair;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.NpthLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

        ConfigInfo(CrashProtectorConfig r10) {
            this.this$0 = r10;
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
            int r10 = r12.position();
            int r11 = 0;
            int r13 = r12.prependInt32(0);
            r12.writeInt32(this.flag);
            r12.writeByte(this.scope.getBytes().length);
            r12.writeByte(this.elfListCount);
            r12.writeByte(this.returnFrameIndex);
            r12.writeByte(this.maxIgnoreDepth);
            r12.writeByte(this.framesCount);
            ArrayList<Pair<Integer, Long>> r14 = this.regs;
            if (r14 != null) goto L5;
            int r15 = 0;
        L6:
            r12.writeByte(r15);
            r12.writeInt32(this.maxResumeCount);
            r12.writeInt32(this.intervalTimeMs);
            r12.writeInt64(this.signal);
            int r16 = r12.prependInt32(0);
            int r17 = r12.prependInt32(0);
            int r18 = r12.prependInt32(0);
            int r19 = r12.prependInt32(0);
            int r20 = r12.prependInt32(0);
            int r21 = r12.prependInt32(0);
            r12.writeInt32At(r16, r12.position() - r10);
            r12.write(this.scope.getBytes());
            r12.writeByte(0);
            String r22 = this.abortMsg;
            if (r22 != null) goto L9;
        L11:
            r12.writeInt32At(r18, r12.position() - r10);
            r12.write(this.elfList.data(), 0, this.elfList.position());
            r12.writeInt32At(r19, r12.position() - r10);
            r12.write(this.frameList.data(), 0, this.frameList.position());
            ArrayList<Pair<Integer, Long>> r23 = this.regs;
            if (r23 != null) goto L14;
        L29:
            r12.align(8);
            r12.writeInt32At(r13, r12.position() - r10);
            return;
        L14:
            if (r23.isEmpty() == true) goto L29;
            r12.writeInt32At(r20, r12.position() - r10);
            int r24 = 0;
        L17:
            if (r24 >= this.regs.size()) goto L20;
            r12.writeByte(((Integer) this.regs.get(r24).first).intValue());
            r24 = r24 + 1;
            goto L17
        L20:
            if (CrashProtectorConfig.access$000(this.this$0) == false) goto L25;
            r12.align(8);
            r12.writeInt32At(r21, r12.position() - r10);
        L23:
            if (r11 >= this.regs.size()) goto L29;
            r12.writeInt64(((Long) this.regs.get(r11).second).longValue());
            r11 = r11 + 1;
            goto L23
        L25:
            r12.align(4);
            r12.writeInt32At(r21, r12.position() - r10);
        L27:
            if (r11 >= this.regs.size()) goto L29;
            r12.writeInt32(((Long) this.regs.get(r11).second).intValue());
            r11 = r11 + 1;
            goto L27
        L9:
            if (r22.isEmpty() == true) goto L11;
            r12.writeInt32At(r17, r12.position() - r10);
            r12.write(this.abortMsg.getBytes());
            r12.writeByte(0);
            goto L11
        L5:
            r15 = r14.size();
            goto L6
        }
    }

    static final enum ElfTag extends Enum<ElfTag> {
        private static final /* synthetic */ ElfTag[] $VALUES = null;
        public static final ElfTag ELF_BUILD_ID = null;
        public static final ElfTag ELF_NAME = null;
        public static final ElfTag ELF_PATH = null;

        static {
            ElfTag r10 = new ElfTag("ELF_BUILD_ID", 0);
            ELF_BUILD_ID = r10;
            ElfTag r11 = new ElfTag("ELF_PATH", 1);
            ELF_PATH = r11;
            ElfTag r12 = new ElfTag("ELF_NAME", 2);
            ELF_NAME = r12;
            $VALUES = new ElfTag[]{r10, r11, r12};
        }

        private ElfTag(String r10, int r11) {
            super(r10, r11);
        }

        public static ElfTag valueOf(String r10) {
            return (ElfTag) Enum.valueOf(ElfTag.class, r10);
        }

        public static ElfTag[] values() {
            return (ElfTag[]) $VALUES.clone();
        }
    }

    static final enum SymbolTag extends Enum<SymbolTag> {
        private static final /* synthetic */ SymbolTag[] $VALUES = null;
        public static final SymbolTag SYMBOL_ALL = null;
        public static final SymbolTag SYMBOL_NAME = null;
        public static final SymbolTag SYMBOL_OFFSET = null;

        static {
            SymbolTag r10 = new SymbolTag("SYMBOL_ALL", 0);
            SYMBOL_ALL = r10;
            SymbolTag r11 = new SymbolTag("SYMBOL_OFFSET", 1);
            SYMBOL_OFFSET = r11;
            SymbolTag r12 = new SymbolTag("SYMBOL_NAME", 2);
            SYMBOL_NAME = r12;
            $VALUES = new SymbolTag[]{r10, r11, r12};
        }

        private SymbolTag(String r10, int r11) {
            super(r10, r11);
        }

        public static SymbolTag valueOf(String r10) {
            return (SymbolTag) Enum.valueOf(SymbolTag.class, r10);
        }

        public static SymbolTag[] values() {
            return (SymbolTag[]) $VALUES.clone();
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

    static /* synthetic */ boolean access$000(CrashProtectorConfig r10) {
        return r10.mIs64BitRuntime;
    }

    public static boolean addConfig(JSONObject r10) {
        if (sScopeList != null) goto L6;
        sScopeList = new JSONObject();
    L6:
        if (sConfigList != null) goto L20;
        sConfigList = new JSONObject();
    L20:
        String r11 = r10.optString("scope");     // Catch: Exception -> L17
        if (r11.isEmpty() == false) goto L12;
    L16:
        return false;
    L12:
        if (r11.startsWith("com.bytedance.") == false) goto L16;
        sConfigList.put(r11, r10);     // Catch: Exception -> L17
        sScopeList.put(r11, 1);     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        NpthLog.e(LOG_TAG, e.getMessage());
        return false;
    }

    private static Long hexStringToLong(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof String) == true) goto L8;
        return null;
    L8:
        String r11 = (String) r10;
        if (r11.isEmpty() == false) goto L12;
        return null;
    L12:
        if (r11.startsWith("0x") == true) goto L20;
        if (r11.startsWith("0X") == true) goto L20;
    L18:
        return null;
    L20:
        return Long.valueOf(Long.parseLong(r11.substring(2), 16));
    }

    public static boolean isValidRegLabel(String r10) {
        if (r10.length() == 2) goto L5;
        return false;
    L5:
        char r11 = Character.toLowerCase(r10.charAt(0));
        int r12 = r10.charAt(1) - '0';
        if (r12 >= 0) goto L9;
        return false;
    L9:
        if (r12 >= 8) goto L19;
        if (r11 == 'x') goto L23;
        if (r11 == 'w') goto L23;
        if (r11 == 'd') goto L23;
        if (r11 != 's') goto L19;
    L23:
        return true;
    L19:
        if (r12 < 4) goto L21;
        return false;
    L21:
        if (r11 == 'r') goto L23;
        return false;
    }

    public static boolean isValidScopeName(String r10) {
        if (r10.length() < 256) goto L5;
    L7:
        return false;
    L5:
        if (sScopePattern.matcher(r10).matches() == false) goto L7;
        return true;
    }

    private static boolean matchesScope(String r10, ArrayList<String> r11, ArrayList<String> r12) {
        if (isValidScopeName(r10) == true) goto L5;
        return false;
    L5:
        int r13 = 0;
    L7:
        if (r13 >= r11.size()) goto L16;
        if (r10.startsWith(r11.get(r13)) == false) goto L15;
        if (r11.get(r13).length() == r10.length()) goto L14;
        if (r10.charAt(r11.get(r13).length()) != '.') goto L15;
    L14:
        return false;
    L15:
        r13 = r13 + 1;
        goto L7
    L16:
        int r14 = 0;
    L18:
        if (r14 >= r12.size()) goto L28;
        if (r10.startsWith(r12.get(r14)) == false) goto L27;
        if (r12.get(r14).length() == r10.length()) goto L25;
        if (r10.charAt(r12.get(r14).length()) != '.') goto L27;
        return true;
    L25:
        return true;
    L27:
        r14 = r14 + 1;
        goto L18
    L28:
        return false;
    }

    private boolean parse(JSONObject r10, JSONObject r11) {
        if (parseScopeListInfo(r10) == true) goto L5;
        return false;
    L5:
        this.mIs64BitRuntime = NativeBridge.is64BitRuntime();
        BufferWriter r12 = new BufferWriter();
        r12.write(MAGIC_NUMBER);
        r12.write(MAGIC_VERSION);
        if (this.mIs64BitRuntime == false) goto L8;
        int r13 = 2;
    L9:
        r12.writeByte(r13);
        r12.write(ENDIAN_TAG);
        int r14 = r12.prependInt32(0);
        int r15 = r12.prependInt32(0);
        r12.align(8);
        int r16 = r12.position();
        int r17 = writeConfigListInfo(r12, r11);
        NpthLog.i(LOG_TAG, "config count: " + r17);
        if (r17 > 0) goto L12;
        return false;
    L12:
        r12.writeInt32At(r15, r12.position() - r16);
        r12.writeInt32At(r14, r17);
        writeCheckSum(r12);
        this.mConfigData = r12.data();
        this.mConfigSize = r12.position();
        return true;
    L8:
        r13 = 1;
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
        JSONArray r10 = r19;
        ?? r11 = 0;
        if (r10 != null) goto L5;
        return false;
    L5:
        int r12 = r19.length();
        int r13 = 255;
        if (r12 <= 255) goto L8;
        r12 = 255;
    L8:
        r18.framesCount = r12;
        BufferWriter r14 = new BufferWriter();
        r18.frameList = r14;
        BufferWriter r15 = new BufferWriter();
        r18.elfList = r15;
        int r16 = -1;
        int r17 = 0;
        int r20 = -1;
    L9:
        if (r17 >= r12) goto L97;
        JSONObject r110 = r10.optJSONObject(r17);
        if (r20 == r16) goto L13;
    L15:
        String r111 = r110.optString("elf_build_id");
        ?? r112 = r110.optString("elf_path");
        String r113 = r110.optString("elf_name");
        if (r111.isEmpty() == true) goto L25;
        r111 = r111.replace(" ", "");
        int r114 = r111.length() / 2;
        byte[] r115 = new byte[r114];
        ?? r116 = r11;
    L18:
        if (r116 >= r114) goto L21;
        int r21 = r116 * 2;
        r115[r116] = (byte) (Integer.parseInt(r111.substring(r21, r21 + 2), 16) & r13);     // Catch: Throwable -> L23
        r116 = r116 + 1;     // Catch: Throwable -> L23
    L23:
        return r11;
    L21:
        ElfTag r22 = ElfTag.ELF_BUILD_ID;     // Catch: Throwable -> L23
    L33:
        if (r115 == null) goto L93;
        if (r115.length >= 256) goto L93;
        byte[] r117 = r15.data();
        ?? r118 = r11;
    L39:
        if (r118 >= r15.position()) goto L56;
        byte r119 = r117[r118];
        byte r23 = r117[r118 + 1];
        if (r119 != r22.ordinal()) goto L54;
        if (r23 != r115.length) goto L54;
        int r24 = 0;
    L46:
        if (r24 >= r115.length) goto L51;
        if (r117[(r118 + 2) + r24] != r115[r24]) goto L49;
        r24 = r24 + 1;
        goto L46
    L49:
        boolean r25 = false;
    L52:
        if (r25 == false) goto L54;
    L51:
        r25 = true;
    L54:
        r118 = r118 + (r23 + 3);
    L56:
        if (r118 > r15.position()) goto L57;
        if (r118 != r15.position()) goto L62;
        r18.elfListCount++;
        r15.writeByte(r22.ordinal());
        r15.writeByte(r115.length);
        r15.write(r115);
        r15.writeByte(0);
    L62:
        r14.writeUleb128((long) r118);
        if (r110.optInt("redacted_match") == 0) goto L66;
        r14.writeByte(SymbolTag.SYMBOL_ALL.ordinal());
    L89:
        r17 = r17 + 1;
        r10 = r19;
        r11 = 0;
        r13 = 255;
        r16 = -1;
        goto L9
    L66:
        if (r110.has("offset_start") == true) goto L68;
        String r26 = r110.optString("symbol_name");
        if (r26.isEmpty() == true) goto L90;
        r14.writeByte(SymbolTag.SYMBOL_NAME.ordinal());
        r14.writeString(r26);
        goto L89
    L90:
        return false;
    L68:
        if (r111.isEmpty() == true) goto L69;
        Long r27 = hexStringToLong(r110.opt("offset_start"));
        if (r27 != null) goto L74;
        r27 = Long.valueOf(r110.optLong("offset_start"));
    L74:
        Long r28 = hexStringToLong(r110.opt("offset_next"));
        if (r28 != null) goto L78;
        r28 = Long.valueOf(r110.optLong("offset_next"));
    L78:
        if (r27.longValue() == 0) goto L84;
        if (r28.longValue() == 0) goto L127;
        if (r27.longValue() >= r28.longValue()) goto L128;
        r14.writeByte(SymbolTag.SYMBOL_OFFSET.ordinal());
        r14.writeUleb128(r27.longValue());
        r14.writeUleb128(r28.longValue());
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
        return r11;
    L25:
        if (r112.isEmpty() == true) goto L31;
        if (r112.charAt(r11) != '/') goto L28;
        r22 = ElfTag.ELF_PATH;
        r115 = r112.getBytes();
        goto L33
    L28:
        return r11;
    L31:
        if (r113.isEmpty() == true) goto L95;
        r22 = ElfTag.ELF_NAME;
        r115 = r113.getBytes();
        goto L33
    L95:
        return r11;
    L13:
        if (r110.optInt("return_from_current_stack") == 0) goto L15;
        r20 = r17;
        goto L15
    L97:
        if (r20 != r16) goto L99;
        r18.flag |= 2;
        return true;
    L99:
        r18.returnFrameIndex = r20;
        return true;
    }

    private boolean parseRegsInfo(ConfigInfo r13, JSONObject r14) {
        if (r14 != null) goto L5;
        return false;
    L5:
        r13.regs = new ArrayList();
        Iterator<String> r10 = r14.keys();
    L7:
        if (r10.hasNext() == false) goto L46;
        String r11 = r10.next();
        if (r11.length() != 2) goto L7;
        char r12 = Character.toLowerCase(r11.charAt(0));
        int r15 = r11.charAt(1) - '0';
        if (r15 < 0) goto L7;
        if (this.mIs64BitRuntime == true) goto L17;
        if (r15 >= 4) goto L7;
        if (r12 != 'r') goto L7;
    L31:
        Long r16 = hexStringToLong(r14.opt(r11));
        if (r16 == null) goto L34;
        long r17 = r16.longValue();
    L39:
        if (r12 == 'w') goto L42;
        if (r12 == 's') goto L42;
        if (r12 == 'r') goto L42;
    L44:
        if (r17 == 0) goto L7;
        r13.regs.add(new Pair(Integer.valueOf(r15), Long.valueOf(r17)));
    L42:
        r17 = r17 & 4294967295L;
        goto L44
    L34:
        if (r12 != 'd') goto L36;
        r17 = Double.doubleToLongBits(r14.optDouble(r11));
        goto L39
    L36:
        if (r12 != 's') goto L38;
        r17 = Float.floatToIntBits((float) r14.optDouble(r11));
        goto L39
    L38:
        r17 = r14.optLong(r11);
        goto L39
    L17:
        if (r15 >= 8) goto L7;
        if (r12 == 'x') goto L24;
        if (r12 == 'w') goto L24;
        if (r12 == 'd') goto L24;
        if (r12 != 's') goto L7;
    L24:
        if (r12 == 'd') goto L26;
        if (r12 != 's') goto L31;
    L26:
        r15 = r15 + 34;
        goto L31
    L46:
        return true;
    }

    private boolean parseScopeListInfo(JSONObject r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterator<String> r11 = r10.keys();
        this.mWhiteList = new ArrayList();
        this.mBlackList = new ArrayList();
    L6:
        boolean r12 = true;
        if (r11.hasNext() == false) goto L19;
        String r13 = r11.next();
        if (isValidScopeName(r13) == false) goto L6;
        if (r10.optInt(r13) != 0) goto L15;
        r12 = false;
    L15:
        if (r12 == false) goto L17;
        ArrayList<String> r14 = this.mWhiteList;
    L18:
        r14.add(r13);
        goto L6
    L17:
        r14 = this.mBlackList;
        goto L18
    L19:
        NpthLog.i(LOG_TAG, "white list size: " + this.mWhiteList.size());
        return !this.mWhiteList.isEmpty();
    }

    public static int signalStringToNumber(String r10) {
        if (r10 != null) goto L5;
    L61:
        return 0;
    L5:
        if (r10.isEmpty() == true) goto L61;
        byte r11 = -1;
        switch(r10.hashCode()) {
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
        switch(r11) {
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
        if (r10.equals("SIGSTKFLT") == false) goto L46;
        r11 = 8;
        goto L46
    L15:
        if (r10.equals("SIGTRAP") == false) goto L46;
        r11 = 7;
        goto L46
    L19:
        if (r10.equals("SIGSEGV") == false) goto L46;
        r11 = 6;
        goto L46
    L23:
        if (r10.equals("SIGPIPE") == false) goto L46;
        r11 = 5;
        goto L46
    L27:
        if (r10.equals("SIGABRT") == false) goto L46;
        r11 = 4;
        goto L46
    L31:
        if (r10.equals("SIGSYS") == false) goto L46;
        r11 = 3;
        goto L46
    L35:
        if (r10.equals("SIGILL") == false) goto L46;
        r11 = 2;
        goto L46
    L39:
        if (r10.equals("SIGFPE") == false) goto L46;
        r11 = 1;
        goto L46
    L43:
        if (r10.equals("SIGBUS") == false) goto L46;
        r11 = 0;
        goto L46
    }

    public static void updateConfig(JSONObject r10) {
        JSONObject r11 = null;
        if (r10 == null) goto L5;
        r11 = r10.optJSONObject("scope_list");
        JSONObject r12 = r10.optJSONObject("config_list");
    L6:
        if (r11 != null) goto L8;
        r11 = new JSONObject();
    L8:
        if (r12 != null) goto L24;
        r12 = new JSONObject();
    L24:
        JSONObject r13 = sConfigList;     // Catch: Exception -> L20
        if (r13 == null) goto L18;
        Iterator<String> r14 = r13.keys();     // Catch: Exception -> L20
    L14:
        if (r14.hasNext() == false) goto L18;
        JSONObject r15 = sConfigList.optJSONObject(r14.next());     // Catch: Exception -> L20
        if (r15 == null) goto L14;
        String r16 = r15.optString("scope");     // Catch: Exception -> L20
        r12.put(r16, r15);     // Catch: Exception -> L20
        r11.put(r16, 1);     // Catch: Exception -> L20
    L18:
        r11.put("com.bytedance.__default__", 1);     // Catch: Exception -> L20
        r12.put("__default__.unwindstack.maps", "{ \"scope\": \"com.bytedance.__default__.unwindstack.maps\",\"signals\": [\"SIGSEGV\"], \"backtraces\":[ { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack6Global19FindAndReadVariableEPNS_4MapsEPKc\", \"return_from_current_stack\": 1 }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE14ForEachSymfileIZNS3_15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPmEUlPS1_E_EEbS6_mT_\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPm\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack8Unwinder14FillInDexFrameEv\" } ] } ");     // Catch: Exception -> L20
    L22:
        sScopeList = r11;
        sConfigList = r12;
        NpthLog.i(LOG_TAG, "update config");
        return;
    L20:
        e = move-exception;
        NpthLog.e(LOG_TAG, e.getMessage());
        goto L22
    L5:
        r12 = null;
        goto L6
    }

    private void writeCheckSum(BufferWriter r10) {
        byte[] r11 = new byte[8];
        r10.align(8);
        byte[] r12 = r10.data();
        int r13 = r10.position();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = 0;
    L5:
        if (r15 >= 8) goto L7;
        r11[r15] = (byte) (r11[r15] ^ r12[r14 + r15]);
        r15 = r15 + 1;
        goto L5
    L7:
        r14 = r14 + 8;
        goto L3
    L8:
        r10.write(r11);
    }

    private boolean writeConfigInfo(BufferWriter r12, JSONObject r13) {
        if (r13 != null) goto L5;
        return false;
    L5:
        String r10 = r13.optString("scope");
        if (matchesScope(r10, this.mBlackList, this.mWhiteList) == true) goto L8;
        return false;
    L8:
        int r11 = r13.optInt("min_api_level", 0);
        int r14 = r13.optInt("max_api_level", 100);
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < r11) goto L57;
        if (r15 > r14) goto L57;
        JSONArray r16 = r13.optJSONArray("api_levels");
        if (r16 == null) goto L24;
        int r17 = 0;
    L16:
        if (r17 >= r16.length()) goto L21;
        if (Build.VERSION.SDK_INT == r16.optInt(r17)) goto L19;
        r17 = r17 + 1;
        goto L16
    L19:
        boolean r18 = true;
    L22:
        if (r18 == true) goto L24;
        return false;
    L21:
        r18 = false;
    L24:
        ConfigInfo r19 = new ConfigInfo(this);
        r19.scope = r10;
        String r20 = r13.optString("abi", "both");
        if (r20.equals("both") == false) goto L27;
    L35:
        JSONArray r21 = r13.optJSONArray("signals");
        if (r21 == null) goto L44;
        int r22 = 0;
    L39:
        if (r22 >= r21.length()) goto L44;
        int r23 = signalStringToNumber(r21.optString(r22));
        if (r23 == 0) goto L43;
        r19.signal |= 1 << r23;
    L43:
        r22 = r22 + 1;
    L44:
        r19.abortMsg = r13.optString("abort_message");
        r19.maxResumeCount = r13.optInt("max_resume_count", 3);
        r19.intervalTimeMs = r13.optInt("interval_time_ms", 3000);
        r19.returnFrameIndex = r13.optInt("return_frame_index");
        if (r13.optInt("dump_all") == 0) goto L47;
        r19.flag |= 1;
    L47:
        int r24 = r13.optInt("max_ignore_depth_before_meet_first_match");
        if (r24 >= 0) goto L50;
        r24 = 0;
    L52:
        r19.maxIgnoreDepth = r24;
        if (parseFramesInfo(r19, r13.optJSONArray("backtraces")) == true) goto L55;
        return false;
    L55:
        parseRegsInfo(r19, r13.optJSONObject("registers"));
        r19.encode(r12);
        this.mEnabledScopeList.add(r10);
        NpthLog.i(LOG_TAG, "add scope: " + r10);
        return true;
    L50:
        if (r24 <= 255) goto L52;
        r24 = 255;
        goto L52
    L27:
        if (this.mIs64BitRuntime == false) goto L31;
        if (r20.equals("arm64-v8a") == true) goto L35;
    L31:
        if (this.mIs64BitRuntime == false) goto L33;
    L34:
        return false;
    L33:
        if (r20.equals("armeabi-v7a") == true) goto L35;
    L57:
        return false;
    }

    private int writeConfigListInfo(BufferWriter r10, JSONObject r11) {
        int r12 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        Iterator<String> r13 = r11.keys();
    L7:
        if (r13.hasNext() == false) goto L19;
        String r14 = r13.next();
        JSONObject r15 = r11.optJSONObject(r14);
        if (r15 != null) goto L17;
        String r16 = r11.optString(r14);
        if (r16.isEmpty() == false) goto L21;
    L14:
        if (r15 != null) goto L17;
    L21:
        r15 = new JSONObject(r16);     // Catch: Throwable -> L20
    L17:
        if (writeConfigInfo(r10, r15) == false) goto L7;
        r12 = r12 + 1;
        goto L7
    L19:
        return r12;
    }

    public byte[] getConfigData() {
        return this.mConfigData;
    }

    public int getConfigSize() {
        return this.mConfigSize;
    }

    public boolean isConfigEnabled(JSONObject r10) {
        return isScopeEnabled(r10.optString("scope"));
    }

    public boolean isScopeEnabled(String r10) {
        if (isValidScopeName(r10) == true) goto L5;
        return false;
    L5:
        Iterator<String> r11 = this.mEnabledScopeList.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (r11.next().equals(r10) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public boolean parse() {
        return parse(sScopeList, sConfigList);
    }
}
