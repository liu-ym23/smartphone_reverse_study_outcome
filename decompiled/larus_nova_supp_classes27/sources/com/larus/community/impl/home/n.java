package com.larus.community.impl.home;

import android.os.Bundle;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.platform.service.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n implements zs8.a {
    public final /* synthetic */ CommunityCreateFragment a;

    public final String Y1() {
        return null;
    }

    public final String a() {
        return null;
    }

    public final String c() {
        return null;
    }

    public final String d() {
        return null;
    }

    public final String e() {
        return null;
    }

    public final String f() {
        return null;
    }

    public final String g() {
        return null;
    }

    public final String getChatType() {
        return "default";
    }

    public final String getClickFrom() {
        return "ai_generate_feed_image";
    }

    public final String getTemplateType() {
        return null;
    }

    public final String h() {
        return null;
    }

    public final String i() {
        return null;
    }

    public final String j() {
        return null;
    }

    public final String k() {
        return null;
    }

    public final boolean l() {
        return false;
    }

    public final String m() {
        return null;
    }

    public final String n() {
        return null;
    }

    public final String o() {
        return null;
    }

    public final String p() {
        return null;
    }

    public final String b() {
        Bundle r0 = this.a.getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("current_page");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final String getBotId() {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.W();
    L7:
        return null;
    }

    public final String getEnterMethod() {
        if (z2.a.f1().f() == false) goto L5;
        return "create_button_panel";
    L5:
        return "click_tab";
    }

    public n(CommunityCreateFragment r1) {
        this.a = r1;
    }
}
