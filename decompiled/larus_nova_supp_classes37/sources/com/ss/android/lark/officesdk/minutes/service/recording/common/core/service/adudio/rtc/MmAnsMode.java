package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmAnsMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ANS_MODE_DISABLE", "ANS_MODE_LOW", "ANS_MODE_MEDIUM", "ANS_MODE_HIGH", "ANS_MODE_AUTOMATIC", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAnsMode extends Enum<MmAnsMode> {
    public static final MmAnsMode ANS_MODE_AUTOMATIC = null;
    public static final MmAnsMode ANS_MODE_DISABLE = null;
    public static final MmAnsMode ANS_MODE_HIGH = null;
    public static final MmAnsMode ANS_MODE_LOW = null;
    public static final MmAnsMode ANS_MODE_MEDIUM = null;
    public static final a Companion = null;
    public static final /* synthetic */ MmAnsMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MmAnsMode> getEntries() {
        return b;
    }

    static {
        MmAnsMode r0 = new MmAnsMode("ANS_MODE_DISABLE", 0, 0);
        ANS_MODE_DISABLE = r0;
        MmAnsMode r1 = new MmAnsMode("ANS_MODE_LOW", 1, 1);
        ANS_MODE_LOW = r1;
        MmAnsMode r3 = new MmAnsMode("ANS_MODE_MEDIUM", 2, 2);
        ANS_MODE_MEDIUM = r3;
        MmAnsMode r5 = new MmAnsMode("ANS_MODE_HIGH", 3, 3);
        ANS_MODE_HIGH = r5;
        MmAnsMode r7 = new MmAnsMode("ANS_MODE_AUTOMATIC", 4, 4);
        ANS_MODE_AUTOMATIC = r7;
        MmAnsMode[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static MmAnsMode[] values() {
        return (MmAnsMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmAnsMode valueOf(String r1) {
        return (MmAnsMode) r27.a.a(MmAnsMode.class, r1);
    }

    public MmAnsMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
