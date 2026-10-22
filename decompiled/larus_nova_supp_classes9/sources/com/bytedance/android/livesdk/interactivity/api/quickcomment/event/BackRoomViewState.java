package com.bytedance.android.livesdk.interactivity.api.quickcomment.event;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BackRoomViewState {
    public final ChangeType a;
    public final int b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/event/BackRoomViewState$ChangeType;", BuildConfig.FLAVOR, "VISIBLE", "GONE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ChangeType extends Enum<ChangeType> {
        public static final ChangeType GONE = null;
        public static final ChangeType VISIBLE = null;
        public static final /* synthetic */ ChangeType[] a = null;

        static {
            ChangeType r1 = new ChangeType("VISIBLE", 0);
            VISIBLE = r1;
            ChangeType r2 = new ChangeType("GONE", 1);
            GONE = r2;
            a = new ChangeType[]{r1, r2};
        }

        public static ChangeType valueOf(String r1) {
            return (ChangeType) a.a(ChangeType.class, r1);
        }

        public static ChangeType[] values() {
            return (ChangeType[]) a.clone();
        }

        public ChangeType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public BackRoomViewState(ChangeType r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changeType");
        this.a = r2;
        this.b = r3;
    }
}
