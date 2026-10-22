package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.CompoundButton;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ AudioTalkSettingFragment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ p a;
        public final /* synthetic */ boolean b;

        public a(p r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
            com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.c.B0;
            Boolean r0 = Boolean.valueOf(this.b);
            r7.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r7, r0);
            com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.c.C0;
            Boolean r1 = Boolean.TRUE;
            r8.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r8, r1);
            this.a.a.d.dismiss();
            if (this.b == false) goto L5;
            String r9 = "stage_enlarge";
        L6:
            HashMap r2 = new HashMap();
            AudioTalkSettingFragment r3 = this.a.a;
            if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r3.getRoom()) == false) goto L9;
            String r4 = "party";
        L10:
            AudioTalkSettingFragment.ca0(r3, r2, r4, "radio");
            r2.put("layout_type", r9);
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_layout_change", r2, new Object[]{IRoom.class, am2.x.class});
            return;
        L9:
            r4 = "radio";
            goto L10
        L5:
            r9 = "normal";
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ApiServerException r3 = (Throwable) r2;
            if ((r3 instanceof ApiServerException) == false) goto L7;
            String r4 = r3.getPrompt();
            if (r4 == null) goto L7;
            f2.c(r4, 0);
        L7:
            this.a.a.d.dismiss();
        }
    }

    public p(AudioTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r4, boolean r5) {
        Disposable r6 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateEnlargeStageSettings(this.a.getRoom().getId(), r5, false).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r5), new b(this));
        this.a.m.add(r6);
    }
}
