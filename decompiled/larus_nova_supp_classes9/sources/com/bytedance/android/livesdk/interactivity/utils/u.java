package com.bytedance.android.livesdk.interactivity.utils;

import android.view.View;
import com.bytedance.live.artist.render.RenderEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u {

    public static final class a implements tc2.d {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        @Override // tc2.d
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Function1 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r3 = (Unit) r0.invoke(r2);
            return;
        }
    }

    public static final void a(RenderEntity r2, Function1<? super View, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$setOnClickListener");
        r2.a(tc2.d.class, new a(r3));
    }
}
