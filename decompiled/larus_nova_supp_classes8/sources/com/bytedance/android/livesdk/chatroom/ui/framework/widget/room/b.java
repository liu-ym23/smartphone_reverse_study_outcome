package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import android.text.SpannableString;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements q {
    public final /* synthetic */ Function1 a;

    public final void a(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    public b(Function1 r1) {
        this.a = r1;
    }

    public final void b(SpannableString r2, q.a r3) {
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r3, "info");
        this.a.invoke(r2.toString());
    }
}
