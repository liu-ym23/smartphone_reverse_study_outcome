package com.obric.assistant.chat.component.list.pipeline.update;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/chat/component/list/pipeline/update/RecordingOperationCardKind;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "TRANSIENT", "TERMINAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordingOperationCardKind extends Enum<RecordingOperationCardKind> {
    public static final RecordingOperationCardKind TERMINAL = null;
    public static final RecordingOperationCardKind TRANSIENT = null;
    public static final /* synthetic */ RecordingOperationCardKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RecordingOperationCardKind> getEntries() {
        return b;
    }

    static {
        RecordingOperationCardKind r0 = new RecordingOperationCardKind("TRANSIENT", 0);
        TRANSIENT = r0;
        RecordingOperationCardKind r1 = new RecordingOperationCardKind("TERMINAL", 1);
        TERMINAL = r1;
        RecordingOperationCardKind[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RecordingOperationCardKind[] values() {
        return (RecordingOperationCardKind[]) a.clone();
    }

    public static RecordingOperationCardKind valueOf(String r1) {
        return (RecordingOperationCardKind) a.a(RecordingOperationCardKind.class, r1);
    }

    public RecordingOperationCardKind(String r1, int r2) {
        super(r1, r2);
    }
}
