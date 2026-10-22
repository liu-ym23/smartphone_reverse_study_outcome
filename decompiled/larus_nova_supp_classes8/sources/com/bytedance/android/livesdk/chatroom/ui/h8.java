package com.bytedance.android.livesdk.chatroom.ui;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h8 {
    public final ConstraintLayout a;
    public final ImageView b;
    public i8 c;
    public final Function0<String> d;
    public final Function1<? super String, String> e;
    public final Function1<? super i8, Unit> f;
    public final Function1<? super String, Unit> g;

    public h8(ConstraintLayout r2, ImageView r3, TextView r4, i8 r5, Function0<String> r6, Function1<? super String, String> r7, Function1<? super i8, Unit> r8, LiveMode r9, Function1<? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r2, "probeLayout");
        Intrinsics.checkNotNullParameter(r3, "stateImageView");
        Intrinsics.checkNotNullParameter(r4, "stateTextView");
        Intrinsics.checkNotNullParameter(r5, "curProbeResult");
        Intrinsics.checkNotNullParameter(r6, "defaultProbeKey");
        Intrinsics.checkNotNullParameter(r7, "findNameFunc");
        Intrinsics.checkNotNullParameter(r8, "reportLog");
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "updateFunc");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r10;
    }
}
