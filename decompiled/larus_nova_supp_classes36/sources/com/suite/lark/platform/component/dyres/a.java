package com.suite.lark.platform.component.dyres;

import android.text.TextUtils;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.suite.lark.platform.component.dyres.a$a, reason: collision with other inner class name */
    public static class C0238a implements npb.a {
        public C0238a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final String getTag() {
            return "DyResSettingHandler";
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            int r1 = a.a;
            return new HashSet(Collections.singletonList(b.a));
        }
    }

    public static class b {
        public static final c a = null;
        public static final Map<String, String> b = null;

        static {
            a = new c();
            b = new HashMap();
        }
    }

    public static class c extends AbstractBaseSettingHandler {
        @Override // com.ss.android.lark.larkconfig.export.handler.a
        public final String a() {
            return "guide_config_data";
        }

        @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
        public final String f() {
            return "ResHandler";
        }

        public c() {
            AbstractBaseSettingHandler.a r0 = this.d;
            r0.c(new poc.b(this));
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            this.f = r0;
        }

        public static void j(JSONObject r4) {
            if (r4 != null) goto L5;
            Log.e("ResHandler", "parseRes dataObj is null");
            return;
        L5:
            Iterator<String> r0 = r4.keys();
        L7:
            if (r0.hasNext() == false) goto L12;
            String r1 = r0.next();
            String r2 = r4.optString(r1);
            if (TextUtils.isEmpty(r2) == true) goto L7;
            ((HashMap) b.b).put(r1, r2);
            goto L7
        }
    }

    static {
        DyResUtils.b.a r0 = DyResUtils.b.a;
        DyResUtils.b r1 = new poc.a();
        r0.getClass();
        DyResUtils.b.a.b = r1;
    }
}
