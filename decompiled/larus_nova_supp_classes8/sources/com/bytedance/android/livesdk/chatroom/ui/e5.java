package com.bytedance.android.livesdk.chatroom.ui;

import android.util.SparseArray;
import com.bytedance.android.live.core.tetris.IComponentManager;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e5 implements AbsKtvControlWidget.a {
    public final /* synthetic */ IComponentManager a;
    public final /* synthetic */ RecyclableWidgetManager b;

    public final void k(Widget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.b.unload(r2);
    }

    public e5(IComponentManager r1, RecyclableWidgetManager r2) {
        this.a = r1;
        this.b = r2;
        new SparseArray();
    }

    public final void a(AbsKtvControlWidget.WidgetType r2, Widget r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "widget");
        switch(b5.a[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L6;
            default: goto L20;
        };
    L20:
        return;
    L6:
        if (((WidgetManager) this.b).widgets.contains(r3) == true) goto L15;
        this.b.load(2131380107, r3);
        return;
    L15:
        return;
    L9:
        if (((WidgetManager) this.b).widgets.contains(r3) == true) goto L17;
        this.b.load(r3);
        return;
    L17:
        return;
    L12:
        if (((WidgetManager) this.b).widgets.contains(r3) == true) goto L19;
        this.b.load(2131376921, r3);
        return;
    }
}
