package com.bytedance.android.ec.adapter.api;

import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int g = 0;
    public String a;
    public Long b;
    public boolean c;
    public boolean d;
    public HashMap<String, String> e;
    public RelativeLayout.LayoutParams f;

    /* JADX INFO: renamed from: com.bytedance.android.ec.adapter.api.a$a, reason: collision with other inner class name */
    public static final class C0112a {
        public C0112a() {
        }

        public static void a(int r10, Double r11) {
            int r0 = a.g;
            HashMap r1 = new HashMap();
            r1.put("position_type", String.valueOf(0));
            r1.put("margin", String.valueOf(r10));
            if (r11 == null) goto L6;
            r1.put("ratio", String.valueOf(r11.doubleValue()));
            return;
        }
    }

    static {
        new C0112a();
    }

    public a() {
        this.a = "";
    }
}
