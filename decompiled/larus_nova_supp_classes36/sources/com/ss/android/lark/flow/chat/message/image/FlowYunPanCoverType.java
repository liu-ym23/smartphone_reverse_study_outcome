package com.ss.android.lark.flow.chat.message.image;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/image/FlowYunPanCoverType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Thumbnail", "Middle", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum FlowYunPanCoverType extends Enum<FlowYunPanCoverType> {
    public static final FlowYunPanCoverType Middle = null;
    public static final FlowYunPanCoverType Thumbnail = null;
    public static final /* synthetic */ FlowYunPanCoverType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<FlowYunPanCoverType> getEntries() {
        return b;
    }

    static {
        FlowYunPanCoverType r0 = new FlowYunPanCoverType("Thumbnail", 0, "thumbnail");
        Thumbnail = r0;
        FlowYunPanCoverType r1 = new FlowYunPanCoverType("Middle", 1, "middle");
        Middle = r1;
        FlowYunPanCoverType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static FlowYunPanCoverType[] values() {
        return (FlowYunPanCoverType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static FlowYunPanCoverType valueOf(String r1) {
        return (FlowYunPanCoverType) r27.a.a(FlowYunPanCoverType.class, r1);
    }

    public FlowYunPanCoverType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
