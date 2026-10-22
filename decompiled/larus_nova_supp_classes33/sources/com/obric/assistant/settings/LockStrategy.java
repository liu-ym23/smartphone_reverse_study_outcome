package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/settings/LockStrategy;", "", "value", "", "item", "Lcom/obric/assistant/settings/LockedUseAuthSettingItem;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/obric/assistant/settings/LockedUseAuthSettingItem;)V", "getItem", "()Lcom/obric/assistant/settings/LockedUseAuthSettingItem;", "Chat", "SimpleIntent", "LocalData", "ChatHistory", "Memory", "AutoGui", "getName", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LockStrategy extends Enum<LockStrategy> {
    public static final LockStrategy AutoGui = null;
    public static final LockStrategy Chat = null;
    public static final LockStrategy ChatHistory = null;
    public static final a Companion = null;
    public static final LockStrategy LocalData = null;
    public static final LockStrategy Memory = null;
    public static final LockStrategy SimpleIntent = null;
    public static final /* synthetic */ LockStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final LockedUseAuthSettingItem item;
    private final String value;

    public static EnumEntries<LockStrategy> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.settings.LockStrategy$a] */
    static {
        LockStrategy r0 = new LockStrategy("Chat", 0, "Chat", LockedUseAuthSettingItem.CHAT_AND_ONLINE_QA);
        Chat = r0;
        LockStrategy r1 = new LockStrategy("SimpleIntent", 1, "SimpleIntent", LockedUseAuthSettingItem.SIMPLE_COMMAND);
        SimpleIntent = r1;
        LockStrategy r2 = new LockStrategy("LocalData", 2, "LocalData", LockedUseAuthSettingItem.LOCAL_APP_DATA);
        LocalData = r2;
        LockStrategy r4 = new LockStrategy("ChatHistory", 3, "ChatHistory", LockedUseAuthSettingItem.CHAT_HISTORY);
        ChatHistory = r4;
        LockStrategy r6 = new LockStrategy("Memory", 4, "Memory", LockedUseAuthSettingItem.GLOBAL_MEMORY);
        Memory = r6;
        LockStrategy r8 = new LockStrategy("AutoGui", 5, "AutoGui", LockedUseAuthSettingItem.AUTO_GUI);
        AutoGui = r8;
        LockStrategy[] r10 = {r0, r1, r2, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public static LockStrategy[] values() {
        return (LockStrategy[]) a.clone();
    }

    public final LockedUseAuthSettingItem getItem() {
        return this.item;
    }

    public final String getName() {
        return this.value;
    }

    public static final /* synthetic */ String access$getValue$p(LockStrategy r0) {
        return r0.value;
    }

    public static LockStrategy valueOf(String r1) {
        return (LockStrategy) r27.a.a(LockStrategy.class, r1);
    }

    public LockStrategy(String r1, int r2, String r3, LockedUseAuthSettingItem r4) {
        super(r1, r2);
        this.value = r3;
        this.item = r4;
    }
}
