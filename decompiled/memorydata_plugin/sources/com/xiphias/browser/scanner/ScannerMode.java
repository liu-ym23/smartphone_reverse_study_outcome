package com.xiphias.browser.scanner;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0013"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerMode;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "BARCODE", "DOCUMENT", "GENERAL", "QUESTION", "TRANSLATE", "EXTRACT_TEXT", "GOODS", "isVisualSearch", "", "()Z", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ScannerMode extends Enum<ScannerMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ScannerMode[] $VALUES = null;
    public static final ScannerMode BARCODE = null;
    public static final a Companion = null;
    public static final ScannerMode DOCUMENT = null;
    public static final ScannerMode EXTRACT_TEXT = null;
    public static final ScannerMode GENERAL = null;
    public static final ScannerMode GOODS = null;
    public static final ScannerMode QUESTION = null;
    public static final ScannerMode TRANSLATE = null;
    private final String wireValue;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerMode$Companion;", "", "<init>", "()V", "fromName", "Lcom/xiphias/browser/scanner/ScannerMode;", EventBody.KEY_VALUE, "", "fromName$scanner_selectedRelease", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ScannerMode a(String r4) {
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(ScannerMode.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r0 = r3.next();
            if (Intrinsics.areEqual(((ScannerMode) ZeusTransformUtils.preCheckCast(r0, ScannerMode.class, "com.obric.memorydata.plugin")).name(), r4) == false) goto L4;
        L10:
            return (ScannerMode) ZeusTransformUtils.preCheckCast(r0, ScannerMode.class, "com.obric.memorydata.plugin");
        L8:
            r0 = null;
            goto L10
        }
    }

    private static final /* synthetic */ ScannerMode[] $values() {
        return new ScannerMode[]{BARCODE, DOCUMENT, GENERAL, QUESTION, TRANSLATE, EXTRACT_TEXT, GOODS};
    }

    static {
        BARCODE = new ScannerMode("BARCODE", 0, null);
        DOCUMENT = new ScannerMode("DOCUMENT", 1, null);
        GENERAL = new ScannerMode("GENERAL", 2, "scan");
        QUESTION = new ScannerMode("QUESTION", 3, "question");
        TRANSLATE = new ScannerMode("TRANSLATE", 4, "translate");
        EXTRACT_TEXT = new ScannerMode("EXTRACT_TEXT", 5, "extract_text");
        GOODS = new ScannerMode("GOODS", 6, "goods");
        ScannerMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private ScannerMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireValue = r3;
    }

    public static EnumEntries<ScannerMode> getEntries() {
        return $ENTRIES;
    }

    public static ScannerMode valueOf(String r2) {
        return (ScannerMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScannerMode.class, r2), ScannerMode.class, "com.obric.memorydata.plugin");
    }

    public static ScannerMode[] values() {
        return (ScannerMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScannerMode[].class, "com.obric.memorydata.plugin");
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public final boolean isVisualSearch() {
        if (this.wireValue == null) goto L5;
        return true;
    L5:
        return false;
    }
}
