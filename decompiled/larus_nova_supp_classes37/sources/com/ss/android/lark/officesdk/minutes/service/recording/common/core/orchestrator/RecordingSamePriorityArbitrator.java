package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RecordingSamePriorityArbitrator {
    public static final Map<b, SamePriorityArbitrationPolicy> b = null;
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/orchestrator/RecordingSamePriorityArbitrator$SamePriorityArbitrationPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "LATER_STARTED_AT_WINS", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum SamePriorityArbitrationPolicy extends Enum<SamePriorityArbitrationPolicy> {
        public static final SamePriorityArbitrationPolicy LATER_STARTED_AT_WINS = null;
        public static final /* synthetic */ SamePriorityArbitrationPolicy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SamePriorityArbitrationPolicy> getEntries() {
            return b;
        }

        static {
            SamePriorityArbitrationPolicy r0 = new SamePriorityArbitrationPolicy();
            LATER_STARTED_AT_WINS = r0;
            SamePriorityArbitrationPolicy[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public SamePriorityArbitrationPolicy() {
            super("LATER_STARTED_AT_WINS", 0);
        }

        public static SamePriorityArbitrationPolicy[] values() {
            return (SamePriorityArbitrationPolicy[]) a.clone();
        }

        public static SamePriorityArbitrationPolicy valueOf(String r1) {
            return (SamePriorityArbitrationPolicy) r27.a.a(SamePriorityArbitrationPolicy.class, r1);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final RecordingPriorityScene a;
        public final RecordingPriorityScene b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "SamePriorityArbitrationKey(activeScene=" + this.a + ", requestedScene=" + this.b + ')';
        }

        public b(RecordingPriorityScene r2, RecordingPriorityScene r3) {
            Intrinsics.checkNotNullParameter(r2, "activeScene");
            Intrinsics.checkNotNullParameter(r3, "requestedScene");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final LinkedHashMap<b, SamePriorityArbitrationPolicy> a;

        public c() {
            this.a = new LinkedHashMap();
        }

        public final void a(RecordingPriorityScene r3, RecordingPriorityScene r4, SamePriorityArbitrationPolicy r5) {
            Intrinsics.checkNotNullParameter(r3, "firstScene");
            Intrinsics.checkNotNullParameter(r4, "secondScene");
            Intrinsics.checkNotNullParameter(r5, "policy");
            this.a.put(new b(r3, r4), r5);
            this.a.put(new b(r4, r3), r5);
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SamePriorityArbitrationPolicy.values().length];
            r0[SamePriorityArbitrationPolicy.LATER_STARTED_AT_WINS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
        RecordingSamePriorityArbitrator$Companion$samePriorityArbitrationPolicies$1 r0 = RecordingSamePriorityArbitrator$Companion$samePriorityArbitrationPolicies$1.INSTANCE;
        c r1 = new c();
        r0.invoke(r1);
        b = MapsKt.toMap(r1.a);
    }

    public RecordingSamePriorityArbitrator() {
        this.a = "RecordingSamePriorityArbitrator_" + hashCode();
    }
}
