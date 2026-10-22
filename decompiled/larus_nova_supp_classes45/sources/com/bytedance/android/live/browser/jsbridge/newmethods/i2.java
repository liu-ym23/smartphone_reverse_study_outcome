package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.livehostapi.business.depend.livead.ICommerceMessage;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i2 implements com.bytedance.android.annie.bridge.q {
    public final IHybridComponent a;
    public final a b;

    public static final class a implements vlc.l {
        public final /* synthetic */ i2 a;
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.d0 b;

        public a(i2 r1, com.bytedance.ies.web.jsbridge2.d0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onMessage(tlc.d r6) {
            if (r6 != null) goto L4;
            return;
        L4:
            if (r6.getIntType() == 2001) goto L6;
        L8:
            boolean r0 = false;
        L9:
            if (r0 == true) goto L12;
            r6 = null;
        L12:
            if (r6 == null) goto L26;
            ICommerceMessage r7 = (ICommerceMessage) r6;
            if (r7.getMessageType() != 7) goto L27;
            String r8 = r7.getMessageContent();
            if (r8 == null) goto L28;
            IHybridComponent r1 = this.a.a;
            if (r1 == null) goto L21;
            if (r1 == null) goto L29;
            r1.sendJsEvent("updateRealTimeNum", r8);
            return;
        L29:
            return;
        L21:
            com.bytedance.ies.web.jsbridge2.d0 r2 = this.b;
            if (r2 == null) goto L31;
            r2.f("updateRealTimeNum", r8);
            return;
        L31:
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L6:
            if ((r6 instanceof ICommerceMessage) == false) goto L8;
            r0 = true;
            goto L9
        }
    }

    public static final class b extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
        public final /* synthetic */ i2 a;

        public final void onTerminate() {
        }

        public b(i2 r1) {
            this.a = r1;
        }

        public final void invoke(Object r2, CallContext r3) {
            JSONObject r4 = (JSONObject) r2;
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            if (Intrinsics.areEqual(r4.optString("enableMsgMonitor", "0"), GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L8;
            vlc.d r5 = com.bytedance.android.livesdk.chatroom.utils.n3.b();
            if (r5 == null) goto L9;
            r5.addMessageListener(2001, this.a.b);
            return;
        L9:
            return;
        }
    }

    public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
        return new b(this);
    }

    public final void release() {
        vlc.d r0 = com.bytedance.android.livesdk.chatroom.utils.n3.b();
        if (r0 == null) goto L6;
        r0.removeMessageListener(2001, this.b);
        return;
    }

    public i2(IHybridComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridComponent");
        this(null);
        this.a = r2;
    }

    public i2(com.bytedance.ies.web.jsbridge2.d0 r2) {
        this.b = new a(this, r2);
    }
}
