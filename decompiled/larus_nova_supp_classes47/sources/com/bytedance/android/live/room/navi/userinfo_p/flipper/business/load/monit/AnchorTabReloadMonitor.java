package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import s91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/AnchorTabReloadMonitor;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BaseTabDataMonitor;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorTabReloadMonitor extends BaseTabDataMonitor {
    public final Lazy h;
    public final b i;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ AnchorTabReloadMonitor a;
        public final /* synthetic */ IRoom b;
        public final /* synthetic */ DataCenter c;

        public b(AnchorTabReloadMonitor r1, IRoom r2, DataCenter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r9) {
            KVData r10 = (KVData) r9;
            AnchorTabLabel r0 = null;
            if (r10 == null) goto L5;
            String r12 = (String) r10.getData();
        L6:
            if (r12 == null) goto L34;
            ALogger.i("AnchorTabReloadMonitor", "label change content: ".concat(r12));
            JSONObject r1 = new JSONObject(r12);     // Catch: JSONException -> L29
            String r13 = r1.optString("after_poi_name");     // Catch: JSONException -> L29
            long r3 = r1.optLong("after_poi_id");     // Catch: JSONException -> L29
            if (r3 <= 0) goto L18;
            IRoom r2 = this.b;     // Catch: JSONException -> L29
            if (r2 == null) goto L14;
            r0 = r2.getAnchorTabLabel();     // Catch: JSONException -> L29
        L14:
            if (r0 == null) goto L16;
            r0.setContent(r13);     // Catch: JSONException -> L29
        L16:
            if (r0 == null) goto L24;
            r0.setKey(String.valueOf(r3));     // Catch: JSONException -> L29
        L24:
            IRoom r14 = this.b;     // Catch: JSONException -> L29
            if (r14 == null) goto L27;
            int r15 = r14.getAnchorTabType();     // Catch: JSONException -> L29
            ((f) this.a.h.getValue()).c = Integer.valueOf(r15);     // Catch: JSONException -> L29
        L27:
            AnchorTabReloadMonitor r16 = this.a;     // Catch: JSONException -> L29
            r16.e((f) r16.h.getValue());     // Catch: JSONException -> L29
            return;
        L18:
            int r17 = com.bytedance.android.live.room.navi.userinfo_p.utils.a.a;     // Catch: JSONException -> L29
            int r18 = com.bytedance.android.live.room.navi.userinfo_p.utils.a.b(r1, this.b);     // Catch: JSONException -> L29
            IRoom r4 = this.b;     // Catch: JSONException -> L29
            if (r4 == null) goto L21;
            r4.setAnchorTabType(com.bytedance.android.live.room.navi.userinfo_p.utils.a.a(r18, this.c));     // Catch: JSONException -> L29
        L21:
            IRoom r19 = this.b;     // Catch: JSONException -> L29
            if (r19 == null) goto L24;
            Intrinsics.checkNotNullParameter(r1, "contentJson");     // Catch: JSONException -> L29
            r19.setAnchorTabLabel((AnchorTabLabel) JsonUtil.parse(r1.optString("anchor_tab_label"), AnchorTabLabel.class));     // Catch: JSONException -> L29
        L29:
            e = move-exception;
            ALogger.e("AnchorTabReloadMonitor", e);
            return;
        L34:
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void a() {
        super.a();
        this.f.observe("data_top_left_label", this.i);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void reset() {
        super.reset();
        this.f.removeObserver(this.i);
    }

    public AnchorTabReloadMonitor(DataContext r2, final DataCenter r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3, r4);
        this.h = LazyKt.lazy(new AnchorTabReloadMonitor$reloadParams$2(r3));
        this.i = new b(this, r4, r3);
    }
}
