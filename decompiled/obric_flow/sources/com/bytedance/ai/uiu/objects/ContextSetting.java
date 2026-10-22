package com.bytedance.ai.uiu.objects;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/uiu/objects/ContextSetting;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextSetting extends Enum<ContextSetting> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextSetting[] f2831a = null;

    static {
        ContextSetting[] r5 = {new ContextSetting("AUTO_DEFAULT_ALL", 0), new ContextSetting("AUTO_NODE_ALL", 1), new ContextSetting("AUTO_NODE_BASIC", 2)};
        f2831a = r5;
        EnumEntriesKt.enumEntries(r5);
    }

    public ContextSetting(String r5, int r10) {
        super(r5, r10);
    }

    public static ContextSetting valueOf(String r5) {
        return (ContextSetting) Enum.valueOf(ContextSetting.class, r5);
    }

    public static ContextSetting[] values() {
        return (ContextSetting[]) f2831a.clone();
    }
}
