package com.obric.aiproactive.ui.artifact;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentPreviewKind;", "", "<init>", "(Ljava/lang/String;I)V", "MARKDOWN", "HTML", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DocumentPreviewKind extends Enum<DocumentPreviewKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DocumentPreviewKind[] $VALUES = null;
    public static final DocumentPreviewKind HTML = null;
    public static final DocumentPreviewKind MARKDOWN = null;

    private static final /* synthetic */ DocumentPreviewKind[] $values() {
        return new DocumentPreviewKind[]{MARKDOWN, HTML};
    }

    static {
        MARKDOWN = new DocumentPreviewKind("MARKDOWN", 0);
        HTML = new DocumentPreviewKind("HTML", 1);
        DocumentPreviewKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private DocumentPreviewKind(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<DocumentPreviewKind> getEntries() {
        return $ENTRIES;
    }

    public static DocumentPreviewKind valueOf(String r2) {
        return (DocumentPreviewKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(DocumentPreviewKind.class, r2), DocumentPreviewKind.class, "com.obric.memorydata.plugin");
    }

    public static DocumentPreviewKind[] values() {
        return (DocumentPreviewKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DocumentPreviewKind[].class, "com.obric.memorydata.plugin");
    }
}
