package com.ss.android.lark.officesdk.minutes.service.foundation.network.request;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/MmMinutesCreateSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "SoundCoreHardware", "SoundCoreRecordWithSync", "DoubaoRecorder", "DoubaoWearableGlass", "DoubaoWearableHear", "LibertyHeadset", "Simultaneous", "LibertyHeadsetCase", "KnowledgeAi", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmMinutesCreateSource extends Enum<MmMinutesCreateSource> {
    public static final MmMinutesCreateSource Default = null;
    public static final MmMinutesCreateSource DoubaoRecorder = null;
    public static final MmMinutesCreateSource DoubaoWearableGlass = null;
    public static final MmMinutesCreateSource DoubaoWearableHear = null;
    public static final MmMinutesCreateSource KnowledgeAi = null;
    public static final MmMinutesCreateSource LibertyHeadset = null;
    public static final MmMinutesCreateSource LibertyHeadsetCase = null;
    public static final MmMinutesCreateSource Simultaneous = null;
    public static final MmMinutesCreateSource SoundCoreHardware = null;
    public static final MmMinutesCreateSource SoundCoreRecordWithSync = null;
    public static final /* synthetic */ MmMinutesCreateSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmMinutesCreateSource> getEntries() {
        return b;
    }

    static {
        MmMinutesCreateSource r0 = new MmMinutesCreateSource("Default", 0, 0);
        Default = r0;
        MmMinutesCreateSource r1 = new MmMinutesCreateSource("SoundCoreHardware", 1, 1);
        SoundCoreHardware = r1;
        MmMinutesCreateSource r3 = new MmMinutesCreateSource("SoundCoreRecordWithSync", 2, 2);
        SoundCoreRecordWithSync = r3;
        MmMinutesCreateSource r5 = new MmMinutesCreateSource("DoubaoRecorder", 3, 3);
        DoubaoRecorder = r5;
        MmMinutesCreateSource r7 = new MmMinutesCreateSource("DoubaoWearableGlass", 4, 4);
        DoubaoWearableGlass = r7;
        MmMinutesCreateSource r9 = new MmMinutesCreateSource("DoubaoWearableHear", 5, 5);
        DoubaoWearableHear = r9;
        MmMinutesCreateSource r11 = new MmMinutesCreateSource("LibertyHeadset", 6, 6);
        LibertyHeadset = r11;
        MmMinutesCreateSource r13 = new MmMinutesCreateSource("Simultaneous", 7, 7);
        Simultaneous = r13;
        MmMinutesCreateSource r15 = new MmMinutesCreateSource("LibertyHeadsetCase", 8, 9);
        LibertyHeadsetCase = r15;
        MmMinutesCreateSource r14 = new MmMinutesCreateSource("KnowledgeAi", 9, 1001);
        KnowledgeAi = r14;
        MmMinutesCreateSource[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static MmMinutesCreateSource[] values() {
        return (MmMinutesCreateSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmMinutesCreateSource valueOf(String r1) {
        return (MmMinutesCreateSource) a.a(MmMinutesCreateSource.class, r1);
    }

    public MmMinutesCreateSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
