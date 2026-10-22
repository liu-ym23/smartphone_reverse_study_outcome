package com.bytedance.android.livesdk.interactivity.comment.frequentchat.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/FrequentChatSubPanelSource;", BuildConfig.FLAVOR, "ADD", "EDIT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FrequentChatSubPanelSource extends Enum<FrequentChatSubPanelSource> {
    public static final FrequentChatSubPanelSource ADD = null;
    public static final FrequentChatSubPanelSource EDIT = null;
    public static final /* synthetic */ FrequentChatSubPanelSource[] a = null;

    static {
        FrequentChatSubPanelSource r1 = new FrequentChatSubPanelSource("ADD", 0);
        ADD = r1;
        FrequentChatSubPanelSource r2 = new FrequentChatSubPanelSource("EDIT", 1);
        EDIT = r2;
        a = new FrequentChatSubPanelSource[]{r1, r2};
    }

    public static FrequentChatSubPanelSource valueOf(String r1) {
        return (FrequentChatSubPanelSource) r27.a.a(FrequentChatSubPanelSource.class, r1);
    }

    public static FrequentChatSubPanelSource[] values() {
        return (FrequentChatSubPanelSource[]) a.clone();
    }

    public FrequentChatSubPanelSource(String r1, int r2) {
        super(r1, r2);
    }
}
