package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IMusicControlNode {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/music/control/IMusicControlNode$OperationType;", "", "ADD_MUSIC", "CUT_MUSIC", "PAUSE_MUSIC", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum OperationType extends Enum<OperationType> {
        public static final OperationType ADD_MUSIC = null;
        public static final OperationType CUT_MUSIC = null;
        public static final OperationType PAUSE_MUSIC = null;
        public static final /* synthetic */ OperationType[] a = null;

        static {
            OperationType r1 = new OperationType("ADD_MUSIC", 0);
            ADD_MUSIC = r1;
            OperationType r2 = new OperationType("CUT_MUSIC", 1);
            CUT_MUSIC = r2;
            OperationType r3 = new OperationType("PAUSE_MUSIC", 2);
            PAUSE_MUSIC = r3;
            a = new OperationType[]{r1, r2, r3};
        }

        public static OperationType valueOf(String r1) {
            return (OperationType) r27.a.a(OperationType.class, r1);
        }

        public static OperationType[] values() {
            return (OperationType[]) a.clone();
        }

        public OperationType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a(b r1);

        void b(b r1);
    }

    public static final class b {
        public final OperationType a;
        public final MusicPanel b;

        public final OperationType getType() {
            return this.a;
        }

        public b(OperationType r2, MusicPanel r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "panel");
            this.a = r2;
            this.b = r3;
        }
    }

    void a();

    void b(g r1);

    OperationType getType();
}
