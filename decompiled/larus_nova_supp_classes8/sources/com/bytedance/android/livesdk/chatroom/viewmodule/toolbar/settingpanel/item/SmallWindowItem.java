package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import np1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SmallWindowItem {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class c {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class d {
        public static final d a = null;

        public d() {
        }

        static {
            a = new d();
        }

        public static final void a(d r0, View r1, TextView r2, LiveSwitchButton r3, boolean r4) {
            r0.getClass();
            r3.n(r3);
            if (r1 == null) goto L5;
            r1.setOnClickListener(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.b(r3));
        L5:
            r1.setImportantForAccessibility(1);
            StringBuilder r5 = new StringBuilder();
            if (r2 == null) goto L11;
            CharSequence r6 = r2.getText();
            if (r6 == null) goto L11;
            String r7 = r6.toString();
            if (r7 == null) goto L11;
        L12:
            r5.append(r7);
            r5.append(" ");
            if (r4 == false) goto L15;
            String r8 = "开启";
        L16:
            r5.append(r8);
            r1.setContentDescription(r5.toString());
            return;
        L15:
            r8 = "关闭";
        L11:
            r7 = s1.B(2131916681);
            goto L12
        }
    }

    static {
    }

    public static np1.b a(final np1.c r3) {
        Intrinsics.checkNotNullParameter(r3, "panelContext");
        Intrinsics.checkNotNullParameter(r3, "panelContext");
        DataCenter r0 = r3.getDataCenter();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L11:
        if (r1 == true) goto L14;
        return null;
    L14:
        np1.b.a r2 = np1.b.a;
        Function0<g> r4 = new SmallWindowItem$provide$1(r3);
        SmallWindowItem$provide$2 r5 = SmallWindowItem$provide$2.INSTANCE;
        r2.getClass();
        return np1.b.a.a(r4, r5);
    L5:
        if (z.e(r0, false) == true) goto L11;
        if (z.m(r0, true) == false) goto L11;
        if (p.c() == false) goto L11;
        r1 = true;
        goto L11
    }
}
