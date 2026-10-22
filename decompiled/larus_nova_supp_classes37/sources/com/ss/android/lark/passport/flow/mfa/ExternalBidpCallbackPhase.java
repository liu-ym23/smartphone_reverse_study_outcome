package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/ExternalBidpCallbackPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "WAITING_CALLBACK", "RESUMED_WAITING_CALLBACK", "DISPATCHING", "TIMED_OUT", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final enum ExternalBidpCallbackPhase extends Enum<ExternalBidpCallbackPhase> {
    public static final ExternalBidpCallbackPhase DISPATCHING = null;
    public static final ExternalBidpCallbackPhase IDLE = null;
    public static final ExternalBidpCallbackPhase RESUMED_WAITING_CALLBACK = null;
    public static final ExternalBidpCallbackPhase TIMED_OUT = null;
    public static final ExternalBidpCallbackPhase WAITING_CALLBACK = null;
    public static final /* synthetic */ ExternalBidpCallbackPhase[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExternalBidpCallbackPhase> getEntries() {
        return b;
    }

    static {
        ExternalBidpCallbackPhase r0 = new ExternalBidpCallbackPhase("IDLE", 0);
        IDLE = r0;
        ExternalBidpCallbackPhase r1 = new ExternalBidpCallbackPhase("WAITING_CALLBACK", 1);
        WAITING_CALLBACK = r1;
        ExternalBidpCallbackPhase r3 = new ExternalBidpCallbackPhase("RESUMED_WAITING_CALLBACK", 2);
        RESUMED_WAITING_CALLBACK = r3;
        ExternalBidpCallbackPhase r5 = new ExternalBidpCallbackPhase("DISPATCHING", 3);
        DISPATCHING = r5;
        ExternalBidpCallbackPhase r7 = new ExternalBidpCallbackPhase("TIMED_OUT", 4);
        TIMED_OUT = r7;
        ExternalBidpCallbackPhase[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ExternalBidpCallbackPhase[] values() {
        return (ExternalBidpCallbackPhase[]) a.clone();
    }

    public static ExternalBidpCallbackPhase valueOf(String r1) {
        return (ExternalBidpCallbackPhase) r27.a.a(ExternalBidpCallbackPhase.class, r1);
    }

    public ExternalBidpCallbackPhase(String r1, int r2) {
        super(r1, r2);
    }
}
