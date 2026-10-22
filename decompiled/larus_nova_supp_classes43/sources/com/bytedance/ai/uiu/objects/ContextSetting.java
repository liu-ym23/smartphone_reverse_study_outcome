package com.bytedance.ai.uiu.objects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/uiu/objects/ContextSetting;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_DEFAULT_ALL", "AUTO_NODE_ALL", "AUTO_NODE_BASIC", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextSetting extends Enum<ContextSetting> {
    public static final ContextSetting AUTO_DEFAULT_ALL = null;
    public static final ContextSetting AUTO_NODE_ALL = null;
    public static final ContextSetting AUTO_NODE_BASIC = null;
    public static final /* synthetic */ ContextSetting[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ContextSetting> getEntries() {
        return b;
    }

    static {
        ContextSetting r0 = new ContextSetting("AUTO_DEFAULT_ALL", 0);
        AUTO_DEFAULT_ALL = r0;
        ContextSetting r1 = new ContextSetting("AUTO_NODE_ALL", 1);
        AUTO_NODE_ALL = r1;
        ContextSetting r10 = new ContextSetting("AUTO_NODE_BASIC", 2);
        AUTO_NODE_BASIC = r10;
        ContextSetting[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ContextSetting[] values() {
        return (ContextSetting[]) a.clone();
    }

    public static ContextSetting valueOf(String r1) {
        return (ContextSetting) a.a(ContextSetting.class, r1);
    }

    public ContextSetting(String r1, int r10) {
        super(r1, r10);
    }
}
