package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/LarkSocialFeedPresentationMode;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "MIXED_PENDING", "MIXED_ACTIVE", "usesMixedProductShape", "", "getUsesMixedProductShape", "()Z", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum LarkSocialFeedPresentationMode extends Enum<LarkSocialFeedPresentationMode> {
    public static final LarkSocialFeedPresentationMode MIXED_ACTIVE = null;
    public static final LarkSocialFeedPresentationMode MIXED_PENDING = null;
    public static final LarkSocialFeedPresentationMode NATIVE = null;
    public static final /* synthetic */ LarkSocialFeedPresentationMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LarkSocialFeedPresentationMode> getEntries() {
        return b;
    }

    static {
        LarkSocialFeedPresentationMode r0 = new LarkSocialFeedPresentationMode("NATIVE", 0);
        NATIVE = r0;
        LarkSocialFeedPresentationMode r1 = new LarkSocialFeedPresentationMode("MIXED_PENDING", 1);
        MIXED_PENDING = r1;
        LarkSocialFeedPresentationMode r3 = new LarkSocialFeedPresentationMode("MIXED_ACTIVE", 2);
        MIXED_ACTIVE = r3;
        LarkSocialFeedPresentationMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static LarkSocialFeedPresentationMode[] values() {
        return (LarkSocialFeedPresentationMode[]) a.clone();
    }

    public final boolean getUsesMixedProductShape() {
        if (this == NATIVE) goto L5;
        return true;
    L5:
        return false;
    }

    public static LarkSocialFeedPresentationMode valueOf(String r1) {
        return (LarkSocialFeedPresentationMode) a.a(LarkSocialFeedPresentationMode.class, r1);
    }

    public LarkSocialFeedPresentationMode(String r1, int r2) {
        super(r1, r2);
    }
}
