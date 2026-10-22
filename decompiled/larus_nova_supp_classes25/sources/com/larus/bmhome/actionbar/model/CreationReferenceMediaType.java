package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/actionbar/model/CreationReferenceMediaType;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "IMAGE", SuggestActionType.VIDEO, "AUDIO", "Companion", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CreationReferenceMediaType extends Enum<CreationReferenceMediaType> {
    public static final CreationReferenceMediaType AUDIO = null;
    public static final a Companion = null;
    public static final CreationReferenceMediaType IMAGE = null;
    public static final CreationReferenceMediaType VIDEO = null;
    public static final /* synthetic */ CreationReferenceMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String wireValue;

    public static final class a {
        public a() {
        }

        public static CreationReferenceMediaType a(String r6) {
            if (r6 == null) goto L7;
            String r7 = StringsKt.trim(r6).toString();
            if (r7 == null) goto L7;
            String r8 = r7.toLowerCase(Locale.ROOT);
        L8:
            CreationReferenceMediaType[] r1 = CreationReferenceMediaType.values();
            int r2 = r1.length;
            int r3 = 0;
        L9:
            if (r3 >= r2) goto L17;
            CreationReferenceMediaType r4 = r1[r3];
            if (Intrinsics.areEqual(r4.getWireValue(), r8) == true) goto L14;
            r3 = r3 + 1;
            goto L9
        L14:
            return r4;
        L17:
            return null;
        L7:
            r8 = null;
            goto L8
        }
    }

    public static EnumEntries<CreationReferenceMediaType> getEntries() {
        return b;
    }

    static {
        CreationReferenceMediaType r0 = new CreationReferenceMediaType("IMAGE", 0, "image");
        IMAGE = r0;
        CreationReferenceMediaType r1 = new CreationReferenceMediaType(SuggestActionType.VIDEO, 1, "video");
        VIDEO = r1;
        CreationReferenceMediaType r3 = new CreationReferenceMediaType("AUDIO", 2, "audio");
        AUDIO = r3;
        CreationReferenceMediaType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static CreationReferenceMediaType[] values() {
        return (CreationReferenceMediaType[]) a.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public static CreationReferenceMediaType valueOf(String r1) {
        return (CreationReferenceMediaType) r27.a.a(CreationReferenceMediaType.class, r1);
    }

    public CreationReferenceMediaType(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireValue = r3;
    }
}
