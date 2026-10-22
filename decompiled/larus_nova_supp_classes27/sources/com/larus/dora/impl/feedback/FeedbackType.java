package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/feedback/FeedbackType;", "", "serverType", "", "str", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getServerType", "()I", "getStr", "()Ljava/lang/String;", "NONE", "GLASSES_APP_FAULT", "DOUBAO_CONVERSATION_PROBLEM", "PRODUCT_SUGGESTION", "QUICK_FEEDBACK", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackType extends Enum<FeedbackType> {
    public static final a Companion = null;
    public static final FeedbackType DOUBAO_CONVERSATION_PROBLEM = null;
    public static final FeedbackType GLASSES_APP_FAULT = null;
    public static final FeedbackType NONE = null;
    public static final FeedbackType PRODUCT_SUGGESTION = null;
    public static final FeedbackType QUICK_FEEDBACK = null;
    public static final /* synthetic */ FeedbackType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int serverType;
    private final String str;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FeedbackType> getEntries() {
        return b;
    }

    static {
        int r1 = com.larus.utils.j0.a;
        FeedbackType r0 = new FeedbackType("NONE", 0, 0, com.larus.utils.j0.d(2131902734));
        NONE = r0;
        FeedbackType r2 = new FeedbackType("GLASSES_APP_FAULT", 1, 1, com.larus.utils.j0.d(2131902731));
        GLASSES_APP_FAULT = r2;
        FeedbackType r3 = new FeedbackType("DOUBAO_CONVERSATION_PROBLEM", 2, 2, com.larus.utils.j0.d(2131902730));
        DOUBAO_CONVERSATION_PROBLEM = r3;
        FeedbackType r4 = new FeedbackType("PRODUCT_SUGGESTION", 3, 3, com.larus.utils.j0.d(2131902732));
        PRODUCT_SUGGESTION = r4;
        FeedbackType r6 = new FeedbackType("QUICK_FEEDBACK", 4, 4, com.larus.utils.j0.d(2131902886));
        QUICK_FEEDBACK = r6;
        FeedbackType[] r8 = {r0, r2, r3, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
        Companion = new a();
    }

    public static FeedbackType[] values() {
        return (FeedbackType[]) a.clone();
    }

    public final int getServerType() {
        return this.serverType;
    }

    public final String getStr() {
        return this.str;
    }

    public static FeedbackType valueOf(String r1) {
        return (FeedbackType) r27.a.a(FeedbackType.class, r1);
    }

    public FeedbackType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.serverType = r3;
        this.str = r4;
    }
}
