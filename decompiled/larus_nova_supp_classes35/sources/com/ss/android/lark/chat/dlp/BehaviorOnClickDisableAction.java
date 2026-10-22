package com.ss.android.lark.chat.dlp;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/dlp/BehaviorOnClickDisableAction;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SHOW_TOAST", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BehaviorOnClickDisableAction extends Enum<BehaviorOnClickDisableAction> {
    public static final BehaviorOnClickDisableAction SHOW_TOAST = null;
    public static final BehaviorOnClickDisableAction UNKNOWN = null;
    public static final /* synthetic */ BehaviorOnClickDisableAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BehaviorOnClickDisableAction> getEntries() {
        return b;
    }

    static {
        BehaviorOnClickDisableAction r0 = new BehaviorOnClickDisableAction("UNKNOWN", 0);
        UNKNOWN = r0;
        BehaviorOnClickDisableAction r1 = new BehaviorOnClickDisableAction("SHOW_TOAST", 1);
        SHOW_TOAST = r1;
        BehaviorOnClickDisableAction[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BehaviorOnClickDisableAction[] values() {
        return (BehaviorOnClickDisableAction[]) a.clone();
    }

    public static BehaviorOnClickDisableAction valueOf(String r1) {
        return (BehaviorOnClickDisableAction) r27.a.a(BehaviorOnClickDisableAction.class, r1);
    }

    public BehaviorOnClickDisableAction(String r1, int r2) {
        super(r1, r2);
    }
}
