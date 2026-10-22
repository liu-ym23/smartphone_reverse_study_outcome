package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes6.dex */
public final enum EscherRecordTypes extends Enum<EscherRecordTypes> {
    private static final /* synthetic */ EscherRecordTypes[] $VALUES = null;
    public static final EscherRecordTypes ALIGN_RULE = null;
    public static final EscherRecordTypes ANCHOR = null;
    public static final EscherRecordTypes ARC_RULE = null;
    public static final EscherRecordTypes BLIP_DIB = null;
    public static final EscherRecordTypes BLIP_EMF = null;
    public static final EscherRecordTypes BLIP_END = null;
    public static final EscherRecordTypes BLIP_JPEG = null;
    public static final EscherRecordTypes BLIP_PICT = null;
    public static final EscherRecordTypes BLIP_PNG = null;
    public static final EscherRecordTypes BLIP_START = null;
    public static final EscherRecordTypes BLIP_TIFF = null;
    public static final EscherRecordTypes BLIP_WMF = null;
    public static final EscherRecordTypes BSE = null;
    public static final EscherRecordTypes BSTORE_CONTAINER = null;
    public static final EscherRecordTypes CALLOUT_RULE = null;
    public static final EscherRecordTypes CHILD_ANCHOR = null;
    public static final EscherRecordTypes CLIENT_ANCHOR = null;
    public static final EscherRecordTypes CLIENT_DATA = null;
    public static final EscherRecordTypes CLIENT_RULE = null;
    public static final EscherRecordTypes CLIENT_TEXTBOX = null;
    public static final EscherRecordTypes CLSID = null;
    public static final EscherRecordTypes COLOR_MRU = null;
    public static final EscherRecordTypes COLOR_SCHEME = null;
    public static final EscherRecordTypes CONNECTOR_RULE = null;
    public static final EscherRecordTypes DELETED_PSPL = null;
    public static final EscherRecordTypes DG = null;
    public static final EscherRecordTypes DGG = null;
    public static final EscherRecordTypes DGG_CONTAINER = null;
    public static final EscherRecordTypes DG_CONTAINER = null;
    private static final Map<Short, EscherRecordTypes> LOOKUP = null;
    public static final EscherRecordTypes OLE_OBJECT = null;
    public static final EscherRecordTypes OPT = null;
    public static final EscherRecordTypes REGROUP_ITEMS = null;
    public static final EscherRecordTypes SELECTION = null;
    public static final EscherRecordTypes SOLVER_CONTAINER = null;
    public static final EscherRecordTypes SP = null;
    public static final EscherRecordTypes SPGR = null;
    public static final EscherRecordTypes SPGR_CONTAINER = null;
    public static final EscherRecordTypes SPLIT_MENU_COLORS = null;
    public static final EscherRecordTypes SP_CONTAINER = null;
    public static final EscherRecordTypes TEXTBOX = null;
    public static final EscherRecordTypes UNKNOWN = null;
    public static final EscherRecordTypes USER_DEFINED = null;
    public final Supplier<? extends EscherRecord> constructor;
    public final String description;
    public final String recordName;
    public final short typeID;

    static {
        EscherRecordTypes r7 = new EscherRecordTypes("DGG_CONTAINER", 0, 61440, "DggContainer", null, $$Lambda$UkrJb21kH7REMSc0sFqgtces4P4.INSTANCE);
        DGG_CONTAINER = r7;
        EscherRecordTypes r0 = new EscherRecordTypes("BSTORE_CONTAINER", 1, 61441, "BStoreContainer", null, $$Lambda$UkrJb21kH7REMSc0sFqgtces4P4.INSTANCE);
        BSTORE_CONTAINER = r0;
        EscherRecordTypes r1 = new EscherRecordTypes("DG_CONTAINER", 2, 61442, "DgContainer", null, $$Lambda$UkrJb21kH7REMSc0sFqgtces4P4.INSTANCE);
        DG_CONTAINER = r1;
        EscherRecordTypes r2 = new EscherRecordTypes("SPGR_CONTAINER", 3, 61443, "SpgrContainer", null, $$Lambda$UkrJb21kH7REMSc0sFqgtces4P4.INSTANCE);
        SPGR_CONTAINER = r2;
        EscherRecordTypes r3 = new EscherRecordTypes("SP_CONTAINER", 4, 61444, "SpContainer", null, $$Lambda$UkrJb21kH7REMSc0sFqgtces4P4.INSTANCE);
        SP_CONTAINER = r3;
        EscherRecordTypes r4 = new EscherRecordTypes("SOLVER_CONTAINER", 5, 61445, "SolverContainer", null, $$Lambda$UkrJb21kH7REMSc0sFqgtces4P4.INSTANCE);
        SOLVER_CONTAINER = r4;
        EscherRecordTypes r5 = new EscherRecordTypes("DGG", 6, 61446, "Dgg", "MsofbtDgg", $$Lambda$jvfIG53MDweahnNtcW6ZJgp8vIQ.INSTANCE);
        DGG = r5;
        EscherRecordTypes r6 = new EscherRecordTypes("BSE", 7, 61447, "BSE", "MsofbtBSE", $$Lambda$A3Z0_p36tOLTlHMFApMeOaDxxT8.INSTANCE);
        BSE = r6;
        EscherRecordTypes r8 = new EscherRecordTypes("DG", 8, 61448, "Dg", "MsofbtDg", $$Lambda$umWWRqhR0sscgEjnOtEvx6m4YQ.INSTANCE);
        DG = r8;
        EscherRecordTypes r16 = new EscherRecordTypes("SPGR", 9, 61449, "Spgr", "MsofbtSpgr", $$Lambda$REfBYf9mXM3pDLcH7pPkRVsJyoA.INSTANCE);
        SPGR = r16;
        EscherRecordTypes r9 = new EscherRecordTypes("SP", 10, 61450, "Sp", "MsofbtSp", $$Lambda$FsDinTpWS8casZ92bp4RjoXH42A.INSTANCE);
        SP = r9;
        EscherRecordTypes r10 = new EscherRecordTypes("OPT", 11, 61451, "Opt", "msofbtOPT", $$Lambda$9k78blUtUuhMfdg3QWjyc264uI.INSTANCE);
        OPT = r10;
        EscherRecordTypes r11 = new EscherRecordTypes("TEXTBOX", 12, 61452, null, null, $$Lambda$NW1b6s7Gkq60vZ2Uzg__talWjKg.INSTANCE);
        TEXTBOX = r11;
        EscherRecordTypes r12 = new EscherRecordTypes("CLIENT_TEXTBOX", 13, 61453, "ClientTextbox", "msofbtClientTextbox", $$Lambda$NW1b6s7Gkq60vZ2Uzg__talWjKg.INSTANCE);
        CLIENT_TEXTBOX = r12;
        EscherRecordTypes r13 = new EscherRecordTypes("ANCHOR", 14, 61454, null, null, null);
        ANCHOR = r13;
        EscherRecordTypes r14 = new EscherRecordTypes("CHILD_ANCHOR", 15, 61455, "ChildAnchor", "MsofbtChildAnchor", $$Lambda$801r2NQUzbbJXraZOut_l37ENo.INSTANCE);
        CHILD_ANCHOR = r14;
        EscherRecordTypes r15 = new EscherRecordTypes("CLIENT_ANCHOR", 16, 61456, "ClientAnchor", "MsofbtClientAnchor", $$Lambda$Lok4fjq_SnxWFoACfB_Eno4UTm0.INSTANCE);
        CLIENT_ANCHOR = r15;
        EscherRecordTypes r17 = new EscherRecordTypes("CLIENT_DATA", 17, 61457, "ClientData", "MsofbtClientData", $$Lambda$WBW3o6uAUraXOD8jgjPSdl6PX0.INSTANCE);
        CLIENT_DATA = r17;
        EscherRecordTypes r25 = new EscherRecordTypes("CONNECTOR_RULE", 18, 61458, null, null, null);
        CONNECTOR_RULE = r25;
        EscherRecordTypes r18 = new EscherRecordTypes("ALIGN_RULE", 19, 61459, null, null, null);
        ALIGN_RULE = r18;
        EscherRecordTypes r19 = new EscherRecordTypes("ARC_RULE", 20, 61460, null, null, null);
        ARC_RULE = r19;
        EscherRecordTypes r20 = new EscherRecordTypes("CLIENT_RULE", 21, 61461, null, null, null);
        CLIENT_RULE = r20;
        EscherRecordTypes r21 = new EscherRecordTypes("CLSID", 22, 61462, null, null, null);
        CLSID = r21;
        EscherRecordTypes r22 = new EscherRecordTypes("CALLOUT_RULE", 23, 61463, null, null, null);
        CALLOUT_RULE = r22;
        EscherRecordTypes r23 = new EscherRecordTypes("BLIP_START", 24, 61464, "Blip", "msofbtBlip", null);
        BLIP_START = r23;
        EscherRecordTypes r24 = new EscherRecordTypes("BLIP_EMF", 25, 61466, "BlipEmf", null, $$Lambda$jZ37oYcSom4vjOvdAlNgBTN2AqU.INSTANCE);
        BLIP_EMF = r24;
        EscherRecordTypes r26 = new EscherRecordTypes("BLIP_WMF", 26, 61467, "BlipWmf", null, $$Lambda$jZ37oYcSom4vjOvdAlNgBTN2AqU.INSTANCE);
        BLIP_WMF = r26;
        EscherRecordTypes r34 = new EscherRecordTypes("BLIP_PICT", 27, 61468, "BlipPict", null, $$Lambda$jZ37oYcSom4vjOvdAlNgBTN2AqU.INSTANCE);
        BLIP_PICT = r34;
        EscherRecordTypes r27 = new EscherRecordTypes("BLIP_JPEG", 28, 61469, "BlipJpeg", null, $$Lambda$BSgR9CblJZULwfeG5XUzuSjIIE.INSTANCE);
        BLIP_JPEG = r27;
        EscherRecordTypes r28 = new EscherRecordTypes("BLIP_PNG", 29, 61470, "BlipPng", null, $$Lambda$BSgR9CblJZULwfeG5XUzuSjIIE.INSTANCE);
        BLIP_PNG = r28;
        EscherRecordTypes r29 = new EscherRecordTypes("BLIP_DIB", 30, 61471, "BlipDib", null, $$Lambda$BSgR9CblJZULwfeG5XUzuSjIIE.INSTANCE);
        BLIP_DIB = r29;
        EscherRecordTypes r30 = new EscherRecordTypes("BLIP_TIFF", 31, 61481, "BlipTiff", null, $$Lambda$BSgR9CblJZULwfeG5XUzuSjIIE.INSTANCE);
        BLIP_TIFF = r30;
        EscherRecordTypes r31 = new EscherRecordTypes("BLIP_END", 32, 61719, "Blip", "msofbtBlip", null);
        BLIP_END = r31;
        EscherRecordTypes r32 = new EscherRecordTypes("REGROUP_ITEMS", 33, 61720, null, null, null);
        REGROUP_ITEMS = r32;
        EscherRecordTypes r33 = new EscherRecordTypes("SELECTION", 34, 61721, null, null, null);
        SELECTION = r33;
        EscherRecordTypes r35 = new EscherRecordTypes("COLOR_MRU", 35, 61722, null, null, null);
        COLOR_MRU = r35;
        EscherRecordTypes r43 = new EscherRecordTypes("DELETED_PSPL", 36, 61725, null, null, null);
        DELETED_PSPL = r43;
        EscherRecordTypes r36 = new EscherRecordTypes("SPLIT_MENU_COLORS", 37, 61726, "SplitMenuColors", "MsofbtSplitMenuColors", $$Lambda$aJeOg9RgRLsO7X7yFnWj2gDSsDU.INSTANCE);
        SPLIT_MENU_COLORS = r36;
        EscherRecordTypes r37 = new EscherRecordTypes("OLE_OBJECT", 38, 61727, null, null, null);
        OLE_OBJECT = r37;
        EscherRecordTypes r38 = new EscherRecordTypes("COLOR_SCHEME", 39, 61728, null, null, null);
        COLOR_SCHEME = r38;
        EscherRecordTypes r39 = new EscherRecordTypes("USER_DEFINED", 40, 61730, "TertiaryOpt", null, $$Lambda$TGOv2BgBzR7Rv27qs0zTSYIN0MQ.INSTANCE);
        USER_DEFINED = r39;
        EscherRecordTypes r40 = new EscherRecordTypes("UNKNOWN", 41, 65535, "unknown", "unknown", $$Lambda$JkxpoELxDKaCsvKFw1leavjEJ_8.INSTANCE);
        UNKNOWN = r40;
        $VALUES = new EscherRecordTypes[]{r7, r0, r1, r2, r3, r4, r5, r6, r8, r16, r9, r10, r11, r12, r13, r14, r15, r17, r25, r18, r19, r20, r21, r22, r23, r24, r26, r34, r27, r28, r29, r30, r31, r32, r33, r35, r43, r36, r37, r38, r39, r40};
        LOOKUP = (Map) ZeusTransformUtils.preCheckCast(Stream.of(values()).collect(Collectors.toMap($$Lambda$EscherRecordTypes$_n9wGlvF58MT24hgw0XttuOpG8s.INSTANCE, Function.identity())), Map.class, "com.obric.memorydata.plugin");
    }

    private EscherRecordTypes(String r3, int r4, int r5, String r6, String r7, Supplier r8) {
        Supplier<? extends EscherRecord> r9 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r8, Supplier.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.typeID = (short) r5;
        this.recordName = r6;
        this.description = r7;
        this.constructor = r9;
    }

    public static EscherRecordTypes forTypeID(int r2) {
        if (r2 == 61482) goto L5;
        EscherRecordTypes r3 = (EscherRecordTypes) ZeusTransformUtils.preCheckCast(LOOKUP.get(Short.valueOf((short) r2)), EscherRecordTypes.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        return r3;
    L10:
        return UNKNOWN;
    L5:
        return BLIP_JPEG;
    }

    private Short getTypeId() {
        return Short.valueOf(this.typeID);
    }

    public static /* synthetic */ Short lambda$_n9wGlvF58MT24hgw0XttuOpG8s(EscherRecordTypes r0) {
        return r0.getTypeId();
    }

    public static EscherRecordTypes valueOf(String r2) {
        return (EscherRecordTypes) ZeusTransformUtils.preCheckCast(Enum.valueOf(EscherRecordTypes.class, r2), EscherRecordTypes.class, "com.obric.memorydata.plugin");
    }

    public static EscherRecordTypes[] values() {
        return (EscherRecordTypes[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EscherRecordTypes[].class, "com.obric.memorydata.plugin");
    }
}
