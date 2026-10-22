package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.CompoundButton;
import android.widget.Switch;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ AudioTalkSettingFragment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Map a;
        public final /* synthetic */ boolean b;

        public a(Map r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            ALogger.i("ttlive_link", "audioTalk update_setting " + this.a);
            com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.M0;
            Boolean r0 = Boolean.valueOf(this.b);
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
        }
    }

    public w(AudioTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r4, boolean r5) {
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("scene", 3);
        r6.put("audio_chat_only_accept_follower_apply", Boolean.valueOf(r5));
        r6.put("audio_chat_accept_need_verified", Boolean.valueOf(((Switch) this.a.aa0(2131387920)).isChecked()));
        Disposable r7 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.getRoom().getId(), r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6, r5));
        this.a.m.add(r7);
    }
}
