package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final UDTabLayout a;
    public final ImageView b;
    public boolean c;
    public ValueAnimator d;

    public g(UDTabLayout r2, ImageView r3) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
        Intrinsics.checkNotNullParameter(r3, "hintIcon");
        this.a = r2;
        this.b = r3;
    }
}
