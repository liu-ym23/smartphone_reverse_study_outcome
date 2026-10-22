package com.obric.memorydata.sdk.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/WindowState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CHAT_WINDOW", "HALF_WINDOW", "FULL_SCREEN", "INVISIBLE", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WindowState extends Enum<WindowState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WindowState[] $VALUES = null;
    public static final WindowState CHAT_WINDOW = null;
    public static final a Companion = null;
    public static final WindowState FULL_SCREEN = null;
    public static final WindowState HALF_WINDOW = null;
    public static final WindowState INVISIBLE = null;
    public static final WindowState NA = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/WindowState$Companion;", "", "<init>", "()V", "fromOrdinal", "Lcom/obric/memorydata/sdk/assistant/WindowState;", "ordinal", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final WindowState a(int r2) {
            return (WindowState) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(WindowState.values(), r2), WindowState.class, "com.obric.memorydata.plugin");
        }
    }

    private static final /* synthetic */ WindowState[] $values() {
        return new WindowState[]{NA, CHAT_WINDOW, HALF_WINDOW, FULL_SCREEN, INVISIBLE};
    }

    static {
        NA = new WindowState("NA", 0);
        CHAT_WINDOW = new WindowState("CHAT_WINDOW", 1);
        HALF_WINDOW = new WindowState("HALF_WINDOW", 2);
        FULL_SCREEN = new WindowState("FULL_SCREEN", 3);
        INVISIBLE = new WindowState("INVISIBLE", 4);
        WindowState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private WindowState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<WindowState> getEntries() {
        return $ENTRIES;
    }

    public static WindowState valueOf(String r2) {
        return (WindowState) ZeusTransformUtils.preCheckCast(Enum.valueOf(WindowState.class, r2), WindowState.class, "com.obric.memorydata.plugin");
    }

    public static WindowState[] values() {
        return (WindowState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WindowState[].class, "com.obric.memorydata.plugin");
    }
}
