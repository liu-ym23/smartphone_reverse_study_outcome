package com.ss.android.lark.feed.shared.fg;

import com.ss.android.lark.biz.im.api.b0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static boolean a = false;
    public static boolean b = true;
    public static final Object c = null;
    public static final Map<String, Boolean> d = null;

    public class a implements b0 {
        public a() {
        }
    }

    static {
        c = new Object();
        new a();
        HashMap r0 = new HashMap();
        d = r0;
        Boolean r1 = Boolean.TRUE;
        r0.put("feed.shortcut", r1);
        r0.put("urgent.urgentList", r1);
        r0.put("secretChat", r1);
        r0.put("label", r1);
    }
}
