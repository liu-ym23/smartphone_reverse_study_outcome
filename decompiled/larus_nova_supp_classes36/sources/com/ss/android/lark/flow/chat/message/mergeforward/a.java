package com.ss.android.lark.flow.chat.message.mergeforward;

import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements k<View> {
    public final View a;
    public final View b;
    public final TextView c;
    public final ThreadReplyExposureView d;

    public final View getView() {
        return this.a;
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
        this.b = r2.findViewById(2131384813);
        this.c = (TextView) r2.findViewById(2131379956);
        this.d = r2.findViewById(2131379949);
    }
}
