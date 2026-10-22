package com.obric.memorydata.memory.tracker;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/tracker/PendingPersonalInfoTracker;", "", "<init>", "()V", "show", "", "memoryId", "", "surface", "Lcom/obric/memorydata/memory/tracker/PendingPersonalInfoTracker$Surface;", "pendingCount", "", "click", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM, "", "Surface", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PendingPersonalInfoTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PendingPersonalInfoTracker f10529a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/tracker/PendingPersonalInfoTracker$Surface;", "", "showCardType", "", "clickCardType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getShowCardType", "()Ljava/lang/String;", "getClickCardType", "PENDING_AREA", "CONSUME_DIALOG", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Surface extends Enum<Surface> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Surface[] $VALUES = null;
        public static final Surface CONSUME_DIALOG = null;
        public static final Surface PENDING_AREA = null;
        private final String clickCardType;
        private final String showCardType;

        private static final /* synthetic */ Surface[] $values() {
            return new Surface[]{PENDING_AREA, CONSUME_DIALOG};
        }

        static {
            PENDING_AREA = new Surface("PENDING_AREA", 0, "confirm_card_pending_area", "pending_area");
            CONSUME_DIALOG = new Surface("CONSUME_DIALOG", 1, "confirm_card_consume_dialog", "consume_dialog");
            Surface[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Surface(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.showCardType = r3;
            this.clickCardType = r4;
        }

        public static EnumEntries<Surface> getEntries() {
            return $ENTRIES;
        }

        public static Surface valueOf(String r2) {
            return (Surface) ZeusTransformUtils.preCheckCast(Enum.valueOf(Surface.class, r2), Surface.class, "com.obric.memorydata.plugin");
        }

        public static Surface[] values() {
            return (Surface[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Surface[].class, "com.obric.memorydata.plugin");
        }

        public final String getClickCardType() {
            return this.clickCardType;
        }

        public final String getShowCardType() {
            return this.showCardType;
        }
    }

    static {
        f10529a = new PendingPersonalInfoTracker();
    }

    private PendingPersonalInfoTracker() {
    }

    public final void a(String r3, Surface r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "surface");
        Tracker r2 = Tracker.INSTANCE;
        JSONObject r6 = new JSONObject().put("memory_id", r3).put("card_type", r4.getShowCardType()).put("pending_count", r5);
        Intrinsics.checkNotNullExpressionValue(r6, "put(...)");
        r2.reportEvent("memory_card_show", r6);
    }

    public final void a(String r3, Surface r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "surface");
        Tracker r2 = Tracker.INSTANCE;
        JSONObject r6 = new JSONObject().put("memory_id", r3);
        if (r5 == false) goto L5;
        String r7 = ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM;
    L6:
        JSONObject r8 = r6.put("button_type", r7).put("card_type", r4.getClickCardType());
        Intrinsics.checkNotNullExpressionValue(r8, "put(...)");
        r2.reportEvent("memory_card_click", r8);
        return;
    L5:
        r7 = "ignore";
        goto L6
    }
}
