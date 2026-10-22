package com.obric.memorydata.dc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/dc/PageContextState;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "TIMEOUT", "SECURE", "NULL", "deep_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PageContextState extends Enum<PageContextState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PageContextState[] $VALUES = null;
    public static final PageContextState FAILURE = null;
    public static final PageContextState NULL = null;
    public static final PageContextState SECURE = null;
    public static final PageContextState SUCCESS = null;
    public static final PageContextState TIMEOUT = null;

    private static final /* synthetic */ PageContextState[] $values() {
        return new PageContextState[]{SUCCESS, FAILURE, TIMEOUT, SECURE, NULL};
    }

    static {
        SUCCESS = new PageContextState("SUCCESS", 0);
        FAILURE = new PageContextState("FAILURE", 1);
        TIMEOUT = new PageContextState("TIMEOUT", 2);
        SECURE = new PageContextState("SECURE", 3);
        NULL = new PageContextState("NULL", 4);
        PageContextState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PageContextState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PageContextState> getEntries() {
        return $ENTRIES;
    }

    public static PageContextState valueOf(String r2) {
        return (PageContextState) ZeusTransformUtils.preCheckCast(Enum.valueOf(PageContextState.class, r2), PageContextState.class, "com.obric.memorydata.plugin");
    }

    public static PageContextState[] values() {
        return (PageContextState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PageContextState[].class, "com.obric.memorydata.plugin");
    }
}
