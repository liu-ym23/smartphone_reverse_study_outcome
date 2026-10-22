package com.bytedance.android.livesdk.commonpop;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.message.model.m3;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends n<ICommonPopupMessageView> implements l {
    public a e;

    public class a extends dmc.e {
        public final /* synthetic */ h d;

        public final void onMessage(tlc.d r2) {
            this.d.onMessage(r2);
        }

        public a(h r1, Set r2, Set r3, dmc.d r4) {
            this.d = r1;
            super(r2, r3, r4);
        }
    }

    public final void detachView() {
        super.detachView();
        a r0 = this.e;
        if (r0 == null) goto L12;
        vlc.d r1 = ((n) this).d;
        int r2 = d4.a;
        if ((r1 instanceof dmc.a) == true) goto L7;
        r1 = null;
    L7:
        dmc.a r3 = (dmc.a) r1;
        if (r3 == null) goto L10;
        r3.o(r0);
    L10:
        this.e = null;
        return;
    }

    public h() {
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((ICommonPopupMessageView) r1);
    }

    public final void g0(ICommonPopupMessageView r5) {
        super.c0(r5);
        HashSet r6 = new HashSet();
        r6.add(Integer.valueOf(MessageType.COMMON_POPUP_MESSAGE.getIntType()));
        a r0 = new a(this, r6, new HashSet(), new dmc.d(0));
        this.e = r0;
        vlc.d r7 = ((n) this).d;
        int r1 = d4.a;
        if ((r7 instanceof dmc.a) == true) goto L5;
        r7 = null;
    L5:
        dmc.a r8 = (dmc.a) r7;
        if (r8 == null) goto L9;
        r8.C(r0);
        return;
    }

    public final void onMessage(tlc.d r6) {
        if (((q46.b) this).a == null) goto L27;
        if (r6 != null) goto L7;
        return;
    L7:
        if ((r6 instanceof m3) == false) goto L28;
        m3 r7 = (m3) r6;
        boolean r0 = r7.E();
        DataCenter r1 = ((n) this).c;
        if (r1 == null) goto L11;
        boolean r2 = ((Boolean) r1.get("data_is_anchor", Boolean.FALSE)).booleanValue();
    L13:
        if (TextUtils.isEmpty(r7.getSchemaUrl()) == false) goto L15;
        return;
    L15:
        if (((q46.b) this).a == null) goto L30;
        if (r0 == true) goto L19;
        if (r2 == false) goto L19;
        return;
    L19:
        LiveSlardarMonitor.monitorStatus("ttlive_show_common_dialog", 0, new JSONObject());
        ((ICommonPopupMessageView) ((q46.b) this).a).J2(r7.getSchemaUrl());
        ALogger.d("COMMON_POPUP_DIALOG_SHOW", r7.getSchemaUrl());     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
        return;
    L30:
        return;
    L11:
        r2 = false;
        goto L13
    L28:
        return;
    }
}
