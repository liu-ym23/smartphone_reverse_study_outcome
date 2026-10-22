package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.base.model.message.z4;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends e implements wlc.b {
    public boolean b;
    public final a c;

    public static final class a<T> implements Observer {
        public final /* synthetic */ m a;

        public a(m r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            ALogger.i("IMStreamInfoCatcher", "update link state: " + r4);
            m r0 = this.a;
            if (r4 != null) goto L6;
        L8:
            boolean r5 = false;
        L9:
            r0.b = r5;
            return;
        L6:
            if (r4.intValue() != 2) goto L8;
            r5 = true;
            goto L9
        }
    }

    public final void Rk(IStreamMessage r4) {
        if (this.b == false) goto L6;
        return;
    L6:
        if ((r4 instanceof z4) == true) goto L8;
        r4 = null;
    L8:
        z4 r5 = (z4) r4;
        if (r5 == null) goto L18;
        String r0 = r5.getInfo();
        if (r0 == null) goto L19;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L14
        r1.put(r5.getKey(), new JSONObject(r0));     // Catch: Exception -> L14
        Unit r6 = Unit.INSTANCE;     // Catch: Exception -> L14
        a(r1, 1, r0);     // Catch: Exception -> L14
        return;
    L14:
        ALogger.e("IMStreamInfoCatcher", "to jsonObject fail");
        return;
    L19:
        return;
    }

    public m(DataCenter r2, p0 r3) {
        Intrinsics.checkNotNullParameter(r2, "mDataCenter");
        Intrinsics.checkNotNullParameter(r3, "processor");
        super(r3);
        this.c = new a(this);
        emc.a r4 = (emc.a) r2.get("data_stream_message_manager");
        if (r4 == null) goto L5;
        r4.addMessageListener(MessageType.STREAM_SYNC_MESSAGE.getWsMethod(), this);
    L5:
        hd0.c.f().c(this.c);
    }
}
