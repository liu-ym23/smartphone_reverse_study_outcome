package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends mx.j {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ListDialogAbility a;

        public a(ListDialogAbility r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.j1;
            Boolean r1 = Boolean.TRUE;
            r0.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
            r3.getContext();
            this.a.dismissDialog();
            xs2.b.a().post(new jd0.i());
        }
    }

    public f(ListDialogAbility r5) {
        Intrinsics.checkNotNullParameter(r5, "ability");
        super(s1.B(2131918851), null, false, 14);
        ((mx.j) this).l = new a(r5);
    }
}
