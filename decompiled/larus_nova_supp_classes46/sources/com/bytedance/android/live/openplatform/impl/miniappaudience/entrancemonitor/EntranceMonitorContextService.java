package com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/entrancemonitor/EntranceMonitorContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceMonitorContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int c = 0;
    public final Map<EntranceType, ShowEntranceTask> a;
    public final b b;

    public static final class a {
    }

    public static final class b implements ShowEntranceTask.b {
        public final /* synthetic */ EntranceMonitorContextService a;

        public b(EntranceMonitorContextService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask.b
        public final void c(String r9, EntranceType r10, EntranceSource r11) {
            Intrinsics.checkNotNullParameter(r9, "mpId");
            Intrinsics.checkNotNullParameter(r10, "entranceType");
            Intrinsics.checkNotNullParameter(r11, "entranceSource");
            EntranceMonitorContextService.h(this.a, r9, r10, r11, ShowEntranceTask.Stage.Begin, 0);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask.b
        public final void b(String r9, EntranceType r10, EntranceSource r11, long r12) {
            Intrinsics.checkNotNullParameter(r9, "mpId");
            Intrinsics.checkNotNullParameter(r10, "entranceType");
            Intrinsics.checkNotNullParameter(r11, "entranceSource");
            EntranceMonitorContextService.h(this.a, r9, r10, r11, ShowEntranceTask.Stage.Success, r12);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask.b
        public final void d(String r9, EntranceType r10, EntranceSource r11, long r12, String r14) {
            Intrinsics.checkNotNullParameter(r9, "mpId");
            Intrinsics.checkNotNullParameter(r10, "entranceType");
            Intrinsics.checkNotNullParameter(r11, "entranceSource");
            Intrinsics.checkNotNullParameter(r14, "stageDesc");
            EntranceMonitorContextService r0 = this.a;
            ShowEntranceTask.Stage r3 = ShowEntranceTask.Stage.Running;
            int r1 = EntranceMonitorContextService.c;
            r0.getClass();
            EntranceMonitorContextService.g(r9, r10, r11, r3, r12, r14, null);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask.b
        public final void a(String r10, EntranceType r11, EntranceSource r12, long r13, String r15, JSONObject r16) {
            Intrinsics.checkNotNullParameter(r10, "mpId");
            Intrinsics.checkNotNullParameter(r11, "entranceType");
            Intrinsics.checkNotNullParameter(r12, "entranceSource");
            Intrinsics.checkNotNullParameter(r15, "stageDesc");
            EntranceMonitorContextService r4 = this.a;
            ShowEntranceTask.Stage r5 = ShowEntranceTask.Stage.Fail;
            int r6 = EntranceMonitorContextService.c;
            r4.getClass();
            EntranceMonitorContextService.g(r10, r11, r12, r5, r13, r15, r16);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        ShowEntranceTask r1 = (ShowEntranceTask) ((Map.Entry) r0.next()).getValue();
        ShowEntranceTask.d r2 = (ShowEntranceTask.d) r1.d.b();
        if (Intrinsics.areEqual(r2, ShowEntranceTask.d.a.a) == false) goto L9;
        r1.a("canceled", null);
    L11:
        StateMachine<ShowEntranceTask.d, ShowEntranceTask.a, ShowEntranceTask.c> r3 = r1.d;
        ShowEntranceTask.a.c r4 = ShowEntranceTask.a.c.a;
        StateMachine.a r5 = StateMachine.c;
        r3.d(r4, null);
        goto L4
    L9:
        if (Intrinsics.areEqual(r2, ShowEntranceTask.d.C0156d.a) == false) goto L11;
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        r1.a(String.format("request %s canceled", Arrays.copyOf(new Object[]{"shelf/info"}, 1)), null);
        goto L11
    L12:
        ((LinkedHashMap) this.a).clear();
    }

    public EntranceMonitorContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new LinkedHashMap();
        this.b = new b(this);
    }

    public final ShowEntranceTask f(EntranceType r4) {
        Intrinsics.checkNotNullParameter(r4, "entranceType");
        LinkedHashMap r0 = (LinkedHashMap) this.a;
        Object r1 = r0.get(r4);
        if (r1 != null) goto L6;
        r1 = new ShowEntranceTask(r4, this.b);
        r0.put(r4, r1);
    L6:
        return (ShowEntranceTask) r1;
    }

    public static /* synthetic */ void h(EntranceMonitorContextService r8, String r9, EntranceType r10, EntranceSource r11, ShowEntranceTask.Stage r12, long r13) {
        r8.getClass();
        g(r9, r10, r11, r12, r13, "", null);
    }

    public static void g(String r3, EntranceType r4, EntranceSource r5, ShowEntranceTask.Stage r6, long r7, String r9, JSONObject r10) {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("mp_id", r3);
        r1.put("entrance_type", r4.getValue());
        r1.put("entrance_source", r5.getValue());
        r1.put("stage", r6.getValue());
        r1.put("duration", String.valueOf(r7));
        r1.put("stage_desc", r9);
        String r8 = "";
        if (r10 == null) goto L6;
        String r11 = r10.toString();
        if (r11 == null) goto L6;
    L7:
        r1.put("stage_extra", r11);
        RoomContext r12 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r12 == null) goto L17;
        m r13 = r12.getRoom();
        if (r13 == null) goto L17;
        Room r14 = (Room) r13.getValue();
        if (r14 == null) goto L17;
        String r15 = String.valueOf(r14.appId);
        if (r15 == null) goto L17;
        r8 = r15;
    L17:
        r1.put("anchor_app_id", r8);
        Unit r16 = Unit.INSTANCE;
        r0.sendLog("livesdk_microapp_entrance_monitor", r1, new Object[]{Room.class});
        return;
    L6:
        r11 = "";
        goto L7
    }
}
