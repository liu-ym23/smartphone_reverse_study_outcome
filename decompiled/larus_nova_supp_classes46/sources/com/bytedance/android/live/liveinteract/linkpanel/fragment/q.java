package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.CompoundButton;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ AudioTalkSettingFragment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ q a;
        public final /* synthetic */ boolean b;

        public a(q r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
            com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.A0;
            Boolean r0 = Boolean.valueOf(this.b);
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
            DataCenter r6 = this.a.a.l;
            if (r6 == null) goto L6;
            r6.put("data_voice_chat_pre_online_on", Boolean.valueOf(this.b));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public q(AudioTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        HashMap r7 = new HashMap();
        r7.put("scene", 4);
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put("key", 47);
        if (r6 == false) goto L5;
        int r2 = 1;
    L6:
        r1.put("value", r2);
        r0.put(r1);
        r7.put("incremental_update", r0);
        Disposable r8 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.getRoom().getId(), r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r6), b.a);
        this.a.m.add(r8);
        return;
    L5:
        r2 = 2;
        goto L6
    }
}
