package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.livesdk.config.hc;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v extends mx.j {
    public final ListDialogAbility m;
    public final Function0<Boolean> n;
    public final Function0<Boolean> o;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ILiveActionHandler r0 = jc1.k.f(ILiveActionHandler.class);
            if (r0 == null) goto L5;
            r0.handle(r3.getContext(), hc.a.getValue());
        L5:
            this.a.m.dismissDialog();
            com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.C0;
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, 100);
        }
    }

    public v(ListDialogAbility r7, Function0<Boolean> r8, Function0<Boolean> r9) {
        Intrinsics.checkNotNullParameter(r7, "dialogAbility");
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.J0.getValue()).booleanValue() == false) goto L5;
        String r0 = "直播回放与高光";
    L7:
        if (((Boolean) r8.invoke()).booleanValue() != true) goto L12;
        Boolean r1 = (Boolean) r9.invoke();
        if (r1 != null) goto L13;
        boolean r2 = false;
    L14:
        if (r2 == false) goto L16;
        String r3 = "已开启";
    L17:
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.B0;
        super(r0, r3, ((Boolean) r4.getValue()).booleanValue(), 4);
        this.m = r7;
        this.n = r8;
        this.o = r9;
        ((mx.j) this).l = new a(this);
        if (v22.a.a() == true) goto L20;
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Boolean.FALSE);
        return;
    L20:
        com.bytedance.android.livesdk.sharedpref.e r10 = com.bytedance.android.livesdk.sharedpref.b.C0;
        Integer r11 = (Integer) r10.getValue();
        if (r11.intValue() < 4) goto L23;
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Boolean.FALSE);
        return;
    L23:
        com.bytedance.android.livesdk.sharedpref.f.d(r10, Integer.valueOf(r11.intValue() + 1));
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Boolean.TRUE);
        return;
    L16:
        r3 = "已关闭";
    L13:
        r2 = r1.booleanValue();
        goto L14
    L12:
        r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.L0.getValue();
        goto L13
    L5:
        r0 = "直播高光";
        goto L7
    }
}
