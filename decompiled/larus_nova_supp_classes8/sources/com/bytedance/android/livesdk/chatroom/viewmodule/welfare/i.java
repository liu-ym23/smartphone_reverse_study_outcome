package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends BaseJsBridgeMethodFactory {
    public final /* synthetic */ WelfareAnchorServiceWidget a;

    public static final class a extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5, CallContext r6) {
            Intrinsics.checkNotNullParameter((JSONObject) r5, "params");
            Intrinsics.checkNotNullParameter(r6, "context");
            yt2.b.b("getDonationActivity, id: " + this.a.a.c);
            JSONObject r7 = WelfareAnchorServiceWidget.wq(this.a.a);
            long r0 = this.a.a.c;
            if (r0 <= 0) goto L5;
            String r8 = String.valueOf(r0);
        L6:
            r7.put("value", r8);
            return r7;
        L5:
            r8 = "";
            goto L6
        }
    }

    public static final class b extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        public final Object invoke(Object r18, CallContext r19) {
            JSONObject r1 = (JSONObject) r18;
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r19, "context");
            Long r2 = StringsKt.toLongOrNull(r1.optString("id", "0"));
            if (r2 == null) goto L5;
            long r5 = r2.longValue();
        L6:
            String r3 = r1.optString("from");
            yt2.b.b("setDonationActivity, id: " + r5);
            MainThreadPostUtils.e(j.a);
            WelfareAnchorServiceWidget r4 = this.a.a;
            if (r5 > 0) goto L9;
            r4.getClass();
        L19:
            WelfareAppLogger.d(r5, r3);
            return WelfareAnchorServiceWidget.wq(this.a.a);
        L9:
            if (r4.c <= 0) goto L14;
            RoomContext r6 = r4.getDataContext();
            if (r6 == null) goto L19;
            r4.b.add(((IWelfareApi) r4.a.getValue()).operateWelfareProject(2, ((Room) r6.getRoom().getValue()).id, ((Room) r6.getRoom().getValue()).getOwnerUserIdString(), r5, r4.d).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r4, r5), h.a));
            goto L19
        L14:
            RoomContext r7 = r4.getDataContext();
            if (r7 == null) goto L19;
            r4.b.add(((IWelfareApi) r4.a.getValue()).operateWelfareProject(1, ((Room) r7.getRoom().getValue()).id, ((Room) r7.getRoom().getValue()).getOwnerUserIdString(), r5, r4.d).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.welfare.e(r4, r5), f.a));
            goto L19
        L5:
            r5 = 0;
            goto L6
        }
    }

    public static final class c extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            WelfareAppLogger.e(this.a.a.c);
            MainThreadPostUtils.e(new k(this));
            yt2.b.b("removeDonationActivity");
            return WelfareAnchorServiceWidget.wq(this.a.a);
        }
    }

    public static final class d extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ i a;

        public d(i r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            MainThreadPostUtils.e(new l(this));
            yt2.b.b("openDonationFrequencySetting");
            return WelfareAnchorServiceWidget.wq(this.a.a);
        }
    }

    public static final class e extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ i a;

        public e(i r1) {
            this.a = r1;
        }

        public final Object invoke(Object r3, CallContext r4) {
            Intrinsics.checkNotNullParameter((JSONObject) r3, "params");
            Intrinsics.checkNotNullParameter(r4, "context");
            JSONObject r5 = WelfareAnchorServiceWidget.wq(this.a.a);
            r5.put("value", String.valueOf(this.a.a.d));
            return r5;
        }
    }

    public i(WelfareAnchorServiceWidget r1) {
        this.a = r1;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideStatelessMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        HashMap r4 = new HashMap();
        r4.put("getDonationActivity", new a(this));
        r4.put("setDonationActivity", new b(this));
        r4.put("removeDonationActivity", new c(this));
        r4.put("openDonationFrequencySetting", new d(this));
        r4.put("getDonationPanelFrequency", new e(this));
        return r4;
    }
}
