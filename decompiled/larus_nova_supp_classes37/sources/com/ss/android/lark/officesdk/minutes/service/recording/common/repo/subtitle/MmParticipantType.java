package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmParticipantType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "LARK_USER", "ROOM", "DOC_USER", "NEO_USER", "NEO_GUEST_USER", "PSTN_USER", "SIP_USER", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmParticipantType extends Enum<MmParticipantType> {
    public static final a Companion = null;
    public static final MmParticipantType DOC_USER = null;
    public static final MmParticipantType LARK_USER = null;
    public static final MmParticipantType NEO_GUEST_USER = null;
    public static final MmParticipantType NEO_USER = null;
    public static final MmParticipantType PSTN_USER = null;
    public static final MmParticipantType ROOM = null;
    public static final MmParticipantType SIP_USER = null;
    public static final MmParticipantType UNKNOWN = null;
    public static final /* synthetic */ MmParticipantType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MmParticipantType> getEntries() {
        return b;
    }

    static {
        MmParticipantType r0 = new MmParticipantType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        MmParticipantType r1 = new MmParticipantType("LARK_USER", 1, 1);
        LARK_USER = r1;
        MmParticipantType r3 = new MmParticipantType("ROOM", 2, 2);
        ROOM = r3;
        MmParticipantType r5 = new MmParticipantType("DOC_USER", 3, 3);
        DOC_USER = r5;
        MmParticipantType r7 = new MmParticipantType("NEO_USER", 4, 4);
        NEO_USER = r7;
        MmParticipantType r9 = new MmParticipantType("NEO_GUEST_USER", 5, 5);
        NEO_GUEST_USER = r9;
        MmParticipantType r11 = new MmParticipantType("PSTN_USER", 6, 6);
        PSTN_USER = r11;
        MmParticipantType r13 = new MmParticipantType("SIP_USER", 7, 7);
        SIP_USER = r13;
        MmParticipantType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
        Companion = new a();
    }

    public static MmParticipantType[] values() {
        return (MmParticipantType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmParticipantType valueOf(String r1) {
        return (MmParticipantType) r27.a.a(MmParticipantType.class, r1);
    }

    public MmParticipantType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
