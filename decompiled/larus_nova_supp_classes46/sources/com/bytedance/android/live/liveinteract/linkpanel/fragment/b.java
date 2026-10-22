package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.widget.CompoundButton;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ApplyPermissionSwitchFragment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ boolean c;

        public a(b r1, Ref.ObjectRef r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
            int r5 = this.a.a.k;
            if (r5 != 1) goto L5;
            ALogger.i("ttlive_link", "videoTalk update_setting " + ((HashMap) this.b.element));
            com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.c.p1;
            Boolean r0 = Boolean.valueOf(this.c);
            r6.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r6, r0);
            return;
        L5:
            if (r5 != 3) goto L11;
            ALogger.i("ttlive_link", "audioTalk update_setting " + ((HashMap) this.b.element));
            com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.c.M0;
            Boolean r1 = Boolean.valueOf(this.c);
            r7.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r7, r1);
            return;
        }
    }

    public b(ApplyPermissionSwitchFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        HashMap r0 = new HashMap();
        r7.element = r0;
        r0.put("scene", Integer.valueOf(this.a.k));
        int r1 = this.a.k;
        if (r1 != 1) goto L5;
        ((HashMap) r7.element).put("big_party_only_accept_follower_apply", Boolean.valueOf(r6));
        ((HashMap) r7.element).put("big_party_accept_need_verified", com.bytedance.android.livesdk.sharedpref.c.t1.getValue());
    L9:
        LinkApi r2 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r3 = this.a.j;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L12:
        Disposable r8 = r2.updateSetting(r3.getId(), (HashMap) r7.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r7, r6));
        this.a.l.add(r8);
        return;
    L5:
        if (r1 != 3) goto L9;
        ((HashMap) r7.element).put("audio_chat_only_accept_follower_apply", Boolean.valueOf(r6));
        ((HashMap) r7.element).put("audio_chat_accept_need_verified", com.bytedance.android.livesdk.sharedpref.c.L0.getValue());
        goto L9
    }
}
