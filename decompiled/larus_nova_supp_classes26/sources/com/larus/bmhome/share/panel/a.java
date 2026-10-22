package com.larus.bmhome.share.panel;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a extends FrameLayout {
    public void a(List<j> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
    }

    public void b() {
    }

    public abstract boolean c(String r1, boolean r2);

    public abstract void d(b r1, h r2);

    public abstract void setPanelViewClickable(boolean r1);

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
