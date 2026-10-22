package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmAILayoutDataType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "AI_LAYOUT_FISH_BONE", "AI_LAYOUT_TOPIC", "AI_LAYOUT_SUBTITLE_EFFECT", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAILayoutDataType extends Enum<MmAILayoutDataType> {
    public static final MmAILayoutDataType AI_LAYOUT_FISH_BONE = null;
    public static final MmAILayoutDataType AI_LAYOUT_SUBTITLE_EFFECT = null;
    public static final MmAILayoutDataType AI_LAYOUT_TOPIC = null;
    public static final a Companion = null;
    public static final MmAILayoutDataType UNKNOWN = null;
    public static final /* synthetic */ MmAILayoutDataType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static MmAILayoutDataType a(int r1) {
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return MmAILayoutDataType.UNKNOWN;
        L14:
            return MmAILayoutDataType.AI_LAYOUT_SUBTITLE_EFFECT;
        L15:
            return MmAILayoutDataType.AI_LAYOUT_TOPIC;
        L12:
            return MmAILayoutDataType.AI_LAYOUT_FISH_BONE;
        }
    }

    @JvmStatic
    public static final MmAILayoutDataType forNumber(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<MmAILayoutDataType> getEntries() {
        return b;
    }

    static {
        MmAILayoutDataType r0 = new MmAILayoutDataType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        MmAILayoutDataType r1 = new MmAILayoutDataType("AI_LAYOUT_FISH_BONE", 1, 1);
        AI_LAYOUT_FISH_BONE = r1;
        MmAILayoutDataType r3 = new MmAILayoutDataType("AI_LAYOUT_TOPIC", 2, 2);
        AI_LAYOUT_TOPIC = r3;
        MmAILayoutDataType r5 = new MmAILayoutDataType("AI_LAYOUT_SUBTITLE_EFFECT", 3, 3);
        AI_LAYOUT_SUBTITLE_EFFECT = r5;
        MmAILayoutDataType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static MmAILayoutDataType[] values() {
        return (MmAILayoutDataType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final MmAILayoutDataType valueOf(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static MmAILayoutDataType valueOf(String r1) {
        return (MmAILayoutDataType) r27.a.a(MmAILayoutDataType.class, r1);
    }

    public MmAILayoutDataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
