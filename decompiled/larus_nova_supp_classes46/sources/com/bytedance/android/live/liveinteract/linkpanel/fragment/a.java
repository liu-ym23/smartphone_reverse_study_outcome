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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ApplyPermissionSwitchFragment a;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.fragment.a$a, reason: collision with other inner class name */
    public static final class C0039a<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ boolean c;

        public C0039a(a r1, Ref.ObjectRef r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
            ALogger.i("ttlive_link", "videoTalk update_setting " + ((HashMap) this.b.element));
            com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.s1;
            Boolean r0 = Boolean.valueOf(this.c);
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
            xs2.b.a().post(new jd0.m(this.c));
            ApplyPermissionSwitchFragment r6 = this.a.a;
            int r1 = ApplyPermissionSwitchFragment.o;
            r6.da0();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public a(ApplyPermissionSwitchFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        HashMap r0 = new HashMap();
        r7.element = r0;
        r0.put("scene", 4);
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        r2.put("key", 40);
        if (r6 == false) goto L5;
        int r3 = 1;
    L6:
        r2.put("value", r3);
        r1.put(r2);
        ((HashMap) r7.element).put("incremental_update", r1);
        LinkApi r4 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r8 = this.a.j;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L9:
        Disposable r9 = r4.updateSetting(r8.getId(), (HashMap) r7.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0039a(this, r7, r6), b.a);
        this.a.l.add(r9);
        return;
    L5:
        r3 = 2;
        goto L6
    }
}
