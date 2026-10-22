package com.bytedance.android.livesdk.interactivity.comment.frequentchat.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/FrequentChatShowMode;", BuildConfig.FLAVOR, "READ", "EDIT", "SORT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FrequentChatShowMode extends Enum<FrequentChatShowMode> {
    public static final FrequentChatShowMode EDIT = null;
    public static final FrequentChatShowMode READ = null;
    public static final FrequentChatShowMode SORT = null;
    public static final /* synthetic */ FrequentChatShowMode[] a = null;

    static {
        FrequentChatShowMode r1 = new FrequentChatShowMode("READ", 0);
        READ = r1;
        FrequentChatShowMode r2 = new FrequentChatShowMode("EDIT", 1);
        EDIT = r2;
        FrequentChatShowMode r3 = new FrequentChatShowMode("SORT", 2);
        SORT = r3;
        a = new FrequentChatShowMode[]{r1, r2, r3};
    }

    public static FrequentChatShowMode valueOf(String r1) {
        return (FrequentChatShowMode) r27.a.a(FrequentChatShowMode.class, r1);
    }

    public static FrequentChatShowMode[] values() {
        return (FrequentChatShowMode[]) a.clone();
    }

    public FrequentChatShowMode(String r1, int r2) {
        super(r1, r2);
    }
}
