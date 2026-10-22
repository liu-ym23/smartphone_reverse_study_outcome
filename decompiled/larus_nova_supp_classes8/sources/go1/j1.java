package go1;

import android.util.SparseArray;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j1 implements AbsKtvControlWidget.a {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.a a;

    public j1(com.bytedance.android.livesdk.chatroom.ui.framework.a r1) {
        this.a = r1;
        new SparseArray();
    }

    public final void k(Widget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.a.Uj(r2);
    }

    public final void a(AbsKtvControlWidget.WidgetType r4, Widget r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "widget");
        switch(i1.a[r4.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L11;
        };
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.a, 2131380107, r5, false, 12);
        return;
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.b(this.a, r5, 6);
        return;
    L7:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.a, 2131376921, r5, false, 12);
        return;
    }
}
