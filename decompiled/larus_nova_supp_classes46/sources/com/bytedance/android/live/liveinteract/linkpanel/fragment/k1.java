package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.CompoundButton;
import android.widget.Switch;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ boolean b;

        public a(Ref.ObjectRef r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
            ALogger.i("ttlive_link", "videoTalk update_setting " + ((HashMap) this.a.element));
            com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.t1;
            Boolean r0 = Boolean.valueOf(this.b);
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
            xs2.b.a().post(new jd0.m(this.b));
        }
    }

    public k1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        HashMap r0 = new HashMap();
        r7.element = r0;
        r0.put("scene", 1);
        ((HashMap) r7.element).put("big_party_only_accept_follower_apply", Boolean.valueOf(((Switch) this.a.aa0(2131387922)).isChecked()));
        ((HashMap) r7.element).put("big_party_accept_need_verified", Boolean.valueOf(r6));
        Disposable r8 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.getRoom().getId(), (HashMap) r7.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r7, r6));
        this.a.q.add(r8);
    }
}
