package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "IDLE", "SHOW", "END", "Companion", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScrollGuideStatus extends Enum<ScrollGuideStatus> {
    private static final /* synthetic */ ScrollGuideStatus[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ScrollGuideStatus END = null;
    public static final ScrollGuideStatus IDLE = null;
    public static final ScrollGuideStatus SHOW = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus$Companion;", BuildConfig.FLAVOR, "()V", "fromOrdinal", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus;", "status", BuildConfig.FLAVOR, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ScrollGuideStatus fromOrdinal(int r7) {
            ScrollGuideStatus[] r0 = ScrollGuideStatus.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            ScrollGuideStatus r4 = r0[r3];
            if (r4.ordinal() != r7) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return ScrollGuideStatus.IDLE;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    static {
        ScrollGuideStatus r1 = new ScrollGuideStatus("IDLE", 0);
        IDLE = r1;
        ScrollGuideStatus r2 = new ScrollGuideStatus("SHOW", 1);
        SHOW = r2;
        ScrollGuideStatus r3 = new ScrollGuideStatus("END", 2);
        END = r3;
        $VALUES = new ScrollGuideStatus[]{r1, r2, r3};
        Companion = new Companion(null);
    }

    public static ScrollGuideStatus valueOf(String r1) {
        return (ScrollGuideStatus) a.a(ScrollGuideStatus.class, r1);
    }

    public static ScrollGuideStatus[] values() {
        return (ScrollGuideStatus[]) $VALUES.clone();
    }

    private ScrollGuideStatus(String r1, int r2) {
        super(r1, r2);
    }
}
