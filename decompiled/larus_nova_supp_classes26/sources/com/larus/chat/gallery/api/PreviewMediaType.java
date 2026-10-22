package com.larus.chat.gallery.api;

import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", InstructionHandlerType.VIDEO, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewMediaType extends Enum<PreviewMediaType> {
    public static final PreviewMediaType IMAGE = null;
    public static final PreviewMediaType VIDEO = null;
    public static final /* synthetic */ PreviewMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PreviewMediaType> getEntries() {
        return b;
    }

    static {
        PreviewMediaType r0 = new PreviewMediaType("IMAGE", 0);
        IMAGE = r0;
        PreviewMediaType r1 = new PreviewMediaType(InstructionHandlerType.VIDEO, 1);
        VIDEO = r1;
        PreviewMediaType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PreviewMediaType[] values() {
        return (PreviewMediaType[]) a.clone();
    }

    public static PreviewMediaType valueOf(String r1) {
        return (PreviewMediaType) r27.a.a(PreviewMediaType.class, r1);
    }

    public PreviewMediaType(String r1, int r2) {
        super(r1, r2);
    }
}
