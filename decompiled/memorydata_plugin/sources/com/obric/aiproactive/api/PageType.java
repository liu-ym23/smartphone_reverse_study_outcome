package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/api/PageType;", "", "<init>", "(Ljava/lang/String;I)V", "NOW", "ALL", "listenerType", "", "getListenerType", "()Ljava/lang/String;", "Companion", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PageType extends Enum<PageType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PageType[] $VALUES = null;
    public static final PageType ALL = null;
    public static final a Companion = null;
    public static final PageType NOW = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/api/PageType$Companion;", "", "<init>", "()V", "fromNameOrDefault", "Lcom/obric/aiproactive/api/PageType;", "raw", "", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    private static final /* synthetic */ PageType[] $values() {
        return new PageType[]{NOW, ALL};
    }

    static {
        NOW = new PageType("NOW", 0);
        ALL = new PageType("ALL", 1);
        PageType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private PageType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PageType> getEntries() {
        return $ENTRIES;
    }

    public static PageType valueOf(String r2) {
        return (PageType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PageType.class, r2), PageType.class, "com.obric.memorydata.plugin");
    }

    public static PageType[] values() {
        return (PageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PageType[].class, "com.obric.memorydata.plugin");
    }

    public final String getListenerType() {
        return name();
    }
}
