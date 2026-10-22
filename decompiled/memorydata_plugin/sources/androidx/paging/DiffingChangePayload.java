package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/DiffingChangePayload;", "", "(Ljava/lang/String;I)V", "ITEM_TO_PLACEHOLDER", "PLACEHOLDER_TO_ITEM", "PLACEHOLDER_POSITION_CHANGE", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum DiffingChangePayload extends Enum<DiffingChangePayload> {
    private static final /* synthetic */ DiffingChangePayload[] $VALUES = null;
    public static final DiffingChangePayload ITEM_TO_PLACEHOLDER = null;
    public static final DiffingChangePayload PLACEHOLDER_POSITION_CHANGE = null;
    public static final DiffingChangePayload PLACEHOLDER_TO_ITEM = null;

    private static final /* synthetic */ DiffingChangePayload[] $values() {
        return new DiffingChangePayload[]{ITEM_TO_PLACEHOLDER, PLACEHOLDER_TO_ITEM, PLACEHOLDER_POSITION_CHANGE};
    }

    static {
        ITEM_TO_PLACEHOLDER = new DiffingChangePayload("ITEM_TO_PLACEHOLDER", 0);
        PLACEHOLDER_TO_ITEM = new DiffingChangePayload("PLACEHOLDER_TO_ITEM", 1);
        PLACEHOLDER_POSITION_CHANGE = new DiffingChangePayload("PLACEHOLDER_POSITION_CHANGE", 2);
        $VALUES = $values();
    }

    private DiffingChangePayload(String r1, int r2) {
        super(r1, r2);
    }

    public static DiffingChangePayload valueOf(String r2) {
        return (DiffingChangePayload) ZeusTransformUtils.preCheckCast(Enum.valueOf(DiffingChangePayload.class, r2), DiffingChangePayload.class, "com.obric.memorydata.plugin");
    }

    public static DiffingChangePayload[] values() {
        return (DiffingChangePayload[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DiffingChangePayload[].class, "com.obric.memorydata.plugin");
    }
}
