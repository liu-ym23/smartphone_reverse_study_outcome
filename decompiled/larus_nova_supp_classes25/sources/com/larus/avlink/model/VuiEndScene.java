package com.larus.avlink.model;

import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/model/VuiEndScene;", "", "<init>", "(Ljava/lang/String;I)V", WcbRenderStatus.DEFAULT, "MediaFocus", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum VuiEndScene extends Enum<VuiEndScene> {
    public static final VuiEndScene DEFAULT = null;
    public static final VuiEndScene MediaFocus = null;
    public static final /* synthetic */ VuiEndScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<VuiEndScene> getEntries() {
        return b;
    }

    static {
        VuiEndScene r0 = new VuiEndScene(WcbRenderStatus.DEFAULT, 0);
        DEFAULT = r0;
        VuiEndScene r1 = new VuiEndScene("MediaFocus", 1);
        MediaFocus = r1;
        VuiEndScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static VuiEndScene[] values() {
        return (VuiEndScene[]) a.clone();
    }

    public static VuiEndScene valueOf(String r1) {
        return (VuiEndScene) r27.a.a(VuiEndScene.class, r1);
    }

    public VuiEndScene(String r1, int r2) {
        super(r1, r2);
    }
}
