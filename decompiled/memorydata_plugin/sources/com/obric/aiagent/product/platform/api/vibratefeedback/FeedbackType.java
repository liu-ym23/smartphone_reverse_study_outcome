package com.obric.aiagent.product.platform.api.vibratefeedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "WAKE_UP", "LONG_PRESS", "TICK", "WARNING", "CONFIRM", "RIGID", "SOFT", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum FeedbackType extends Enum<FeedbackType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FeedbackType[] $VALUES = null;
    public static final FeedbackType CONFIRM = null;
    public static final Companion Companion = null;
    public static final FeedbackType LONG_PRESS = null;
    public static final FeedbackType RIGID = null;
    public static final FeedbackType SOFT = null;
    public static final FeedbackType TICK = null;
    public static final FeedbackType WAKE_UP = null;
    public static final FeedbackType WARNING = null;
    private final String typeName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType$Companion;", "", "<init>", "()V", "getByTypeName", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "typeName", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final FeedbackType getByTypeName(String r5) {
            Intrinsics.checkNotNullParameter(r5, "typeName");
            FeedbackType[] r4 = FeedbackType.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            FeedbackType r2 = r4[r1];
            if (Intrinsics.areEqual(r2.getTypeName(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ FeedbackType[] $values() {
        return new FeedbackType[]{WAKE_UP, LONG_PRESS, TICK, WARNING, CONFIRM, RIGID, SOFT};
    }

    static {
        WAKE_UP = new FeedbackType("WAKE_UP", 0, "EFFECT_WAKE_UP");
        LONG_PRESS = new FeedbackType("LONG_PRESS", 1, "EFFECT_LONG_PRESS");
        TICK = new FeedbackType("TICK", 2, "EFFECT_TICK");
        WARNING = new FeedbackType("WARNING", 3, "EFFECT_WARNING");
        CONFIRM = new FeedbackType("CONFIRM", 4, "EFFECT_CONFIRM");
        RIGID = new FeedbackType("RIGID", 5, "EFFECT_RIGID");
        SOFT = new FeedbackType("SOFT", 6, "EFFECT_SOFT");
        FeedbackType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new Companion(null);
    }

    private FeedbackType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }

    public static EnumEntries<FeedbackType> getEntries() {
        return $ENTRIES;
    }

    public static FeedbackType valueOf(String r2) {
        return (FeedbackType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FeedbackType.class, r2), FeedbackType.class, "com.obric.memorydata.plugin");
    }

    public static FeedbackType[] values() {
        return (FeedbackType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FeedbackType[].class, "com.obric.memorydata.plugin");
    }

    public final String getTypeName() {
        return this.typeName;
    }
}
