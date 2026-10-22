package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s extends FrameLayout {
    public final TextView a;
    public final SimpleDraweeView b;
    public final TextView c;

    public s(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        FrameLayout.inflate(r2, 2131563246, this);
        this.a = (TextView) findViewById(2131365728);
        this.b = findViewById(2131365727);
        this.c = (TextView) findViewById(2131365731);
    }
}
