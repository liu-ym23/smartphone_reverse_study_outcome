package com.xiphias.browser.scanner;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/xiphias/browser/scanner/BarcodeScanEngine;", "", "<init>", "(Ljava/lang/String;I)V", "BACH", "ZXING", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BarcodeScanEngine extends Enum<BarcodeScanEngine> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BarcodeScanEngine[] $VALUES = null;
    public static final BarcodeScanEngine BACH = null;
    public static final BarcodeScanEngine ZXING = null;

    private static final /* synthetic */ BarcodeScanEngine[] $values() {
        return new BarcodeScanEngine[]{BACH, ZXING};
    }

    static {
        BACH = new BarcodeScanEngine("BACH", 0);
        ZXING = new BarcodeScanEngine("ZXING", 1);
        BarcodeScanEngine[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private BarcodeScanEngine(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<BarcodeScanEngine> getEntries() {
        return $ENTRIES;
    }

    public static BarcodeScanEngine valueOf(String r2) {
        return (BarcodeScanEngine) ZeusTransformUtils.preCheckCast(Enum.valueOf(BarcodeScanEngine.class, r2), BarcodeScanEngine.class, "com.obric.memorydata.plugin");
    }

    public static BarcodeScanEngine[] values() {
        return (BarcodeScanEngine[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BarcodeScanEngine[].class, "com.obric.memorydata.plugin");
    }
}
