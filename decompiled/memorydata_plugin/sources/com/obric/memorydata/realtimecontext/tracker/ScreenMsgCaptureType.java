package com.obric.memorydata.realtimecontext.tracker;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/realtimecontext/tracker/ScreenMsgCaptureType;", "", "<init>", "(Ljava/lang/String;I)V", "AssistantStructure", "Ocr", "AppEntity", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ScreenMsgCaptureType extends Enum<ScreenMsgCaptureType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ScreenMsgCaptureType[] $VALUES = null;
    public static final ScreenMsgCaptureType AppEntity = null;
    public static final ScreenMsgCaptureType AssistantStructure = null;
    public static final ScreenMsgCaptureType Ocr = null;

    private static final /* synthetic */ ScreenMsgCaptureType[] $values() {
        return new ScreenMsgCaptureType[]{AssistantStructure, Ocr, AppEntity};
    }

    static {
        AssistantStructure = new ScreenMsgCaptureType("AssistantStructure", 0);
        Ocr = new ScreenMsgCaptureType("Ocr", 1);
        AppEntity = new ScreenMsgCaptureType("AppEntity", 2);
        ScreenMsgCaptureType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ScreenMsgCaptureType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ScreenMsgCaptureType> getEntries() {
        return $ENTRIES;
    }

    public static ScreenMsgCaptureType valueOf(String r2) {
        return (ScreenMsgCaptureType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScreenMsgCaptureType.class, r2), ScreenMsgCaptureType.class, "com.obric.memorydata.plugin");
    }

    public static ScreenMsgCaptureType[] values() {
        return (ScreenMsgCaptureType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScreenMsgCaptureType[].class, "com.obric.memorydata.plugin");
    }
}
