package com.larus.avlink.model;

import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/model/DoraVisionBizScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", WcbRenderStatus.DEFAULT, "DISCOVERY", "LIVE_AI", "ENV_OBSERVE", "FPA_MEETING", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum DoraVisionBizScene extends Enum<DoraVisionBizScene> {
    public static final a Companion = null;

    @SerialName("0")
    public static final DoraVisionBizScene DEFAULT = null;

    @SerialName("1")
    public static final DoraVisionBizScene DISCOVERY = null;

    @SerialName("3")
    public static final DoraVisionBizScene ENV_OBSERVE = null;

    @SerialName("5")
    public static final DoraVisionBizScene FPA_MEETING = null;

    @SerialName("2")
    public static final DoraVisionBizScene LIVE_AI = null;
    public static final /* synthetic */ DoraVisionBizScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static DoraVisionBizScene a(int r1) {
            if (r1 != 5) goto L6;
            return DoraVisionBizScene.DISCOVERY;
        L6:
            if (v88.a.c(Integer.valueOf(r1)) == false) goto L9;
            return DoraVisionBizScene.LIVE_AI;
        L9:
            if (v88.a.b(Integer.valueOf(r1)) == false) goto L12;
            return DoraVisionBizScene.ENV_OBSERVE;
        L12:
            return DoraVisionBizScene.DEFAULT;
        }
    }

    public static EnumEntries<DoraVisionBizScene> getEntries() {
        return b;
    }

    static {
        DoraVisionBizScene r0 = new DoraVisionBizScene(WcbRenderStatus.DEFAULT, 0, 0);
        DEFAULT = r0;
        DoraVisionBizScene r1 = new DoraVisionBizScene("DISCOVERY", 1, 1);
        DISCOVERY = r1;
        DoraVisionBizScene r3 = new DoraVisionBizScene("LIVE_AI", 2, 2);
        LIVE_AI = r3;
        DoraVisionBizScene r5 = new DoraVisionBizScene("ENV_OBSERVE", 3, 3);
        ENV_OBSERVE = r5;
        DoraVisionBizScene r7 = new DoraVisionBizScene("FPA_MEETING", 4, 5);
        FPA_MEETING = r7;
        DoraVisionBizScene[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static DoraVisionBizScene[] values() {
        return (DoraVisionBizScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DoraVisionBizScene valueOf(String r1) {
        return (DoraVisionBizScene) r27.a.a(DoraVisionBizScene.class, r1);
    }

    public DoraVisionBizScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
