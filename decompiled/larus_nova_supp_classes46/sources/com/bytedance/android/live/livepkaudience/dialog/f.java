package com.bytedance.android.live.livepkaudience.dialog;

import android.widget.CompoundButton;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PkApplyPermissionSwitchDialog a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ boolean c;

        public a(f r1, Ref.ObjectRef r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            if (this.a.a.e != 1) goto L7;
            ALogger.i("ttlive_pk", "pk update_setting " + ((HashMap) this.b.element));
            com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.p1;
            Boolean r0 = Boolean.valueOf(this.c);
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
            return;
        }
    }

    public f(PkApplyPermissionSwitchDialog r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        HashMap r0 = new HashMap();
        r7.element = r0;
        r0.put("scene", Integer.valueOf(this.a.e));
        if (this.a.e != 1) goto L6;
        ((HashMap) r7.element).put("big_party_only_accept_follower_apply", Boolean.valueOf(r6));
        ((HashMap) r7.element).put("big_party_accept_need_verified", com.bytedance.android.livesdk.sharedpref.c.t1.getValue());
    L6:
        Disposable r8 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.d.id, (HashMap) r7.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r7, r6));
        this.a.a.add(r8);
    }
}
