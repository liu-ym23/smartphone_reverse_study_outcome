package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.BaseSettingViewHolder;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ SwitchSettingViewHolder c;
    public final /* synthetic */ long d;
    public final /* synthetic */ String e;

    public b(a r1, boolean r2, SwitchSettingViewHolder r3, long r4, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void accept(Object r7) {
        if (((Response) r7) == null) goto L15;
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.d3;
        a r0 = this.a;
        boolean r1 = this.b;
        r0.getClass();
        if (r1 == false) goto L8;
        long r2 = 1;
    L9:
        Long r3 = Long.valueOf(r2);
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r3);
        if (this.b == false) goto L12;
        ((BaseSettingViewHolder) this.c).b.setText(s1.B(2131922471));
    L13:
        this.a.q.refreshSettingItems();
        a.g(this.a, this.d, this.e, this.b, true);
        return;
    L12:
        ((BaseSettingViewHolder) this.c).b.setText(s1.B(2131922472));
        goto L13
    L8:
        r2 = 2;
        goto L9
    }
}
