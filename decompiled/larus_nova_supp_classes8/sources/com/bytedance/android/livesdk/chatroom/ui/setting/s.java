package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s extends mx.j {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ListDialogAbility a;

        public a(ListDialogAbility r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.jumpSubpage(6);
        }
    }

    public s(ListDialogAbility r5) {
        Intrinsics.checkNotNullParameter(r5, "ability");
        if (tb1.c.a == false) goto L5;
        String r0 = "拉黑与禁言设置";
    L6:
        super(r0, null, false, 14);
        ((mx.j) this).l = new a(r5);
        return;
    L5:
        r0 = s1.B(2131919754);
        goto L6
    }
}
