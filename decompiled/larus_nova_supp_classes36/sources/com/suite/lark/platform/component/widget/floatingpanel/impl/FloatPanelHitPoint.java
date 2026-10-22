package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import z5c.k;
import z5c.w3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FloatPanelHitPoint {
    public static Long a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatPanelHitPoint$ButtonPositionValue;", "", "Companion", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonPositionValue {
        public static final int BACK_KEY = 2;
        public static final int BOTTOM = 1;
        public static final a Companion = null;
        public static final int TOP = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    static {
    }

    public static void a(int r1, int r2) {
        Statistics.sendEvent("im_floating_panel_collapse_list_click", s5c.d.b.b(w3.c.a(String.valueOf(r1)), k.c.a(String.valueOf(r2))).toJson());
    }

    public static void b(int r1, int r2) {
        if (r1 != 0) goto L4;
        return;
    L4:
        Statistics.sendEvent("core_float_dialog_show_card", s5c.d.b.b(z5c.c.c.a(String.valueOf(r1)), w3.c.a(String.valueOf(r2))).toJson());
    }
}
