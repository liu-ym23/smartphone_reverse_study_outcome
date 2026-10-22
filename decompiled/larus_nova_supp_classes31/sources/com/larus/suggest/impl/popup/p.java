package com.larus.suggest.impl.popup;

import com.larus.bmhome.chat.bean.PopWindowCandidateConf;
import com.larus.bmhome.chat.bean.PopWindowMedia;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p {
    public final PopWindowCandidateConf a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public final String a() {
        List r0 = this.a.getMediaList();
        if (r0 == null) goto L18;
        PopWindowMedia r1 = (PopWindowMedia) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L19;
        Integer r2 = r1.getMediaType();
        if (r2 != null) goto L10;
    L13:
        if (r2 != null) goto L16;
        return "";
    L16:
        if (r2.intValue() != 2) goto L21;
        String r3 = "video";
    L20:
        return r3;
    L21:
        return "";
    L10:
        if (r2.intValue() != 1) goto L13;
        r3 = "pic";
        goto L20
    L19:
        return "";
    L18:
        return "";
    }

    public final void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "clickType");
        JSONObject r0 = new JSONObject();
        r0.put("current_page", this.b);
        r0.put("media_type", a());
        r0.put("group_id", this.c);
        r0.put("activity_id", this.d);
        r0.put("name", this.a.getName());
        r0.put("click_type", r8);
        com.larus.platform.service.o.a.reportEvent("pop_click", r0);
        if (Intrinsics.areEqual(r8, "click_button") == false) goto L14;
        String r9 = this.e;
        if (r9 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r9, "ug_free_subs_download_pc") == true) goto L10;
        r9 = null;
    L10:
        String r1 = r9;
        if (r1 == null) goto L16;
        x1.e(r1, "popup_window", null, null, this.f, null, 108);
        return;
    L16:
        return;
    }

    public p(PopWindowCandidateConf r2, String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "windowConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
