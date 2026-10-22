package com.larus.bmhome.chat.component.share;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.share.panel.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatShareBottomComponent$f implements d {
    public final /* synthetic */ ChatShareBottomComponent a;

    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    public final void f() {
    }

    public final void onDismiss() {
    }

    public ChatShareBottomComponent$f(ChatShareBottomComponent r1) {
        this.a = r1;
    }

    public final void e(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public final boolean b(Context r1, DialogFragment r2, View r3, jr9.a r4) {
        Intrinsics.checkNotNullParameter(r4, "shareItemConfig");
        if (ChatShareBottomComponent.B3(this.a, r1, r4) == false) goto L6;
        return true;
    L6:
        if (this.a.e4().hasPreloadShareMessage() == true) goto L10;
        u7 r5 = this.a.Z3();
        if (r5 == null) goto L10;
        r5.showLoading();
    L10:
        this.a.e4().shareMessageWithPreload(r4);
        return true;
    }
}
