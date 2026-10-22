package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.DialogInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends mx.l {
    public static final /* synthetic */ int r = 0;
    public final Room p;
    public final ListDialogAbility q;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ LiveSwitchButton b;
        public final /* synthetic */ Room c;

        public b(g r1, LiveSwitchButton r2, Room r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            r5.dismiss();
            this.b.setChecked(false);
            com.bytedance.android.livesdk.log.g r7 = com.bytedance.android.livesdk.log.u.l();
            g r0 = this.a;
            Room r1 = this.c;
            r0.getClass();
            HashMap r2 = new HashMap();
            r2.put("anchor_id", r1.getOwnerUserIdString());
            r2.put("room_id", r1.getIdStr());
            r7.sendLog("livesdk_profile_hide_confirm", r2, new Object[0]);
            this.a.g(this.c.getOwnerUserIdString(), this.c.id, false);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ LiveSwitchButton a;

        public c(LiveSwitchButton r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.setChecked(true);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Response r2 = (Response) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ g a;

        public e(g r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ApiServerException r4 = (Throwable) r3;
            if ((r4 instanceof ApiServerException) == false) goto L13;
            ApiServerException r5 = r4;
            int r0 = r5.getErrorCode();
            int r1 = g.r;
            if (r0 != 10001) goto L7;
        L8:
            f2.c(r5.getPrompt(), 0);
            MultiTypeAdapter r6 = this.a.q.listAdapter();
            if (r6 == null) goto L15;
            int r2 = mx.l.o;
            g r7 = this.a;
            mx.l.a.b(r6, r7, !((mx.l) r7).l);
            return;
        L15:
            return;
        L7:
            if (r5.getErrorCode() == 400001) goto L8;
            return;
        }
    }

    static {
    }

    public g(Room r10, ListDialogAbility r11) {
        Intrinsics.checkNotNullParameter(r11, "ability");
        String r2 = s1.B(2131922476);
        if (r10 == null) goto L7;
        RoomAuthStatus r0 = r10.getRoomAuthStatus();
        if (r0 == null) goto L7;
        boolean r4 = r0.getEnableUserCard();
    L8:
        super(r2, null, r4, false, false, s1.B(2131915833), 74);
        this.p = r10;
        this.q = r11;
        return;
    L7:
        r4 = true;
        goto L8
    }

    public final void c(SwitchSettingViewHolder r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r7, "holder");
        ((mx.l) this).l = r8;
        LiveSwitchButton r0 = r7.d;
        Room r1 = this.p;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r8 == false) goto L8;
        g(r1.getOwnerUserIdString(), r1.id, true);
    L9:
        HashMap r9 = new HashMap();
        r9.put("anchor_id", r1.getOwnerUserIdString());
        r9.put("room_id", r1.getIdStr());
        if (r8 == true) goto L12;
        String r10 = "open";
    L13:
        r9.put("action", r10);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_profile_permission_switch", r9, new Object[0]);
        return;
    L12:
        r10 = "close";
        goto L13
    L8:
        x0.b r4 = new x0.b(((RecyclerView.ViewHolder) r7).itemView.getContext(), 0);
        r4.l(2131915835);
        r4.i(0, 2131915915, new b(this, r0, r1));
        r4.i(1, 2131915919, new c(r0));
        x0.d r11 = r4.a;
        r11.l = false;
        r11.k = false;
        r4.n();
        goto L9
    }

    public final void g(String r3, long r4, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        Disposable r0 = ((mx.l) this).m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((mx.l) this).m = ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).updateBanUserCardStatus(r3, r4, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(d.a, new e(this));
    }
}
