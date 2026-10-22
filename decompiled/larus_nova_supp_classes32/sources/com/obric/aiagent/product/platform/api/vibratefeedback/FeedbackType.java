package com.obric.aiagent.product.platform.api.vibratefeedback;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", NameKeys.UnloadStrategy_No_Strategy, "typeName", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "WAKE_UP", "LONG_PRESS", "TICK", "WARNING", "CONFIRM", "RIGID", "SOFT", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackType extends Enum<FeedbackType> {
    public static final FeedbackType CONFIRM = null;
    public static final a Companion = null;
    public static final FeedbackType LONG_PRESS = null;
    public static final FeedbackType RIGID = null;
    public static final FeedbackType SOFT = null;
    public static final FeedbackType TICK = null;
    public static final FeedbackType WAKE_UP = null;
    public static final FeedbackType WARNING = null;
    public static final /* synthetic */ FeedbackType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String typeName;

    public static EnumEntries<FeedbackType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType$a] */
    static {
        FeedbackType r0 = new FeedbackType("WAKE_UP", 0, "EFFECT_WAKE_UP");
        WAKE_UP = r0;
        FeedbackType r1 = new FeedbackType("LONG_PRESS", 1, "EFFECT_LONG_PRESS");
        LONG_PRESS = r1;
        FeedbackType r3 = new FeedbackType("TICK", 2, "EFFECT_TICK");
        TICK = r3;
        FeedbackType r5 = new FeedbackType("WARNING", 3, "EFFECT_WARNING");
        WARNING = r5;
        FeedbackType r7 = new FeedbackType("CONFIRM", 4, "EFFECT_CONFIRM");
        CONFIRM = r7;
        FeedbackType r9 = new FeedbackType("RIGID", 5, "EFFECT_RIGID");
        RIGID = r9;
        FeedbackType r11 = new FeedbackType("SOFT", 6, "EFFECT_SOFT");
        SOFT = r11;
        FeedbackType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static FeedbackType[] values() {
        return (FeedbackType[]) a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static FeedbackType valueOf(String r1) {
        return (FeedbackType) r27.a.a(FeedbackType.class, r1);
    }

    public FeedbackType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
