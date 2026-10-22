package com.larus.bmhome.chat.auth.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/auth/model/PluginAuthType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "Ask", "Once", "Always", "Deny", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PluginAuthType extends Enum<PluginAuthType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PluginAuthType[] $VALUES = null;

    @SerializedName("2")
    public static final PluginAuthType Always = null;

    @SerializedName("0")
    public static final PluginAuthType Ask = null;
    public static final a Companion = null;

    @SerializedName("-1")
    public static final PluginAuthType Deny = null;

    @SerializedName("1")
    public static final PluginAuthType Once = null;
    public final int value;

    private static final /* synthetic */ PluginAuthType[] $values() {
        return new PluginAuthType[]{Ask, Once, Always, Deny};
    }

    public static EnumEntries<PluginAuthType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.bmhome.chat.auth.model.PluginAuthType$a] */
    static {
        Ask = new PluginAuthType("Ask", 0, 0);
        Once = new PluginAuthType("Once", 1, 1);
        Always = new PluginAuthType("Always", 2, 2);
        Deny = new PluginAuthType("Deny", 3, -1);
        PluginAuthType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new a();
    }

    public static PluginAuthType[] values() {
        return (PluginAuthType[]) $VALUES.clone();
    }

    public static PluginAuthType valueOf(String r1) {
        return (PluginAuthType) r27.a.a(PluginAuthType.class, r1);
    }

    private PluginAuthType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
