package com.bytedance.android.live.liveinteract.widget.widget;

import android.widget.CompoundButton;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ChatRoomGuestSettingDialog a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            com.bytedance.android.livesdk.sharedpref.e r4 = b6.q;
            Boolean r0 = Boolean.valueOf(this.a);
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
            int r5 = LinkDistributeSettingDialog.i;
            LinkDistributeSettingDialog.a.b();
            if (this.a == false) goto L5;
            int r6 = 2131917262;
        L6:
            f2.b(r6, 0);
            return;
        L5:
            r6 = 2131917261;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            r3.printStackTrace();
        }
    }

    public d(ChatRoomGuestSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "<anonymous parameter 0>");
        JSONArray r7 = new JSONArray();
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        if (r6 == false) goto L6;
        int r3 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.ordinal();     // Catch: JSONException -> L9
    L7:
        r1.put("status", r3);     // Catch: JSONException -> L9
        r0.put("key", ILinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_DELEGATED_TO_FRIENDS.getValue());     // Catch: JSONException -> L9
        r0.put("value", r1);     // Catch: JSONException -> L9
        r7.put(r0);     // Catch: JSONException -> L9
    L11:
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L14;
        IRoom r4 = (IRoom) r2.getValue();
    L15:
        if (r4 == null) goto L20;
        Disposable r8 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).updateAudienceSettings(r4.getId(), r7.toString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6), b.a);
        this.a.a.add(r8);
        return;
    L20:
        return;
    L14:
        r4 = null;
        goto L15
    L6:
        r3 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.ordinal();     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
