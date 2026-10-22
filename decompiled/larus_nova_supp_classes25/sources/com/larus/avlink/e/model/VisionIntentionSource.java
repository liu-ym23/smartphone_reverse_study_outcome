package com.larus.avlink.e.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/e/model/VisionIntentionSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "KWS", "ASR", "LLM", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum VisionIntentionSource extends Enum<VisionIntentionSource> {
    public static final VisionIntentionSource ASR = null;
    public static final VisionIntentionSource KWS = null;
    public static final VisionIntentionSource LLM = null;
    public static final VisionIntentionSource UNKNOWN = null;
    public static final /* synthetic */ VisionIntentionSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<VisionIntentionSource> getEntries() {
        return b;
    }

    static {
        VisionIntentionSource r0 = new VisionIntentionSource("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        VisionIntentionSource r1 = new VisionIntentionSource("KWS", 1, 1);
        KWS = r1;
        VisionIntentionSource r3 = new VisionIntentionSource("ASR", 2, 2);
        ASR = r3;
        VisionIntentionSource r5 = new VisionIntentionSource("LLM", 3, 3);
        LLM = r5;
        VisionIntentionSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static VisionIntentionSource[] values() {
        return (VisionIntentionSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static VisionIntentionSource valueOf(String r1) {
        return (VisionIntentionSource) a.a(VisionIntentionSource.class, r1);
    }

    public VisionIntentionSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
