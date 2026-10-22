package com.ss.android.lark.integrator.im.feed_shared.dependency;

import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.BadgeStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements peb.b.k {
    public final Map<peb.b.h, zob.b> a;

    public final void a() {
    }

    public final void d() {
    }

    public final boolean b() {
        com.ss.android.lark.usersetting.service.e.a.a.getClass();
        Object r0 = com.ss.android.lark.usersetting.service.badgestyle.a.c;
        com.ss.android.lark.usersetting.service.badgestyle.a.b.a.getClass();
        UserSetting r1 = aac.g.d.a.a.a();
        if (r1 != null) goto L5;
        BadgeStyle r2 = BadgeStyle.STRONG_REMIND;
    L7:
        if (r2 != BadgeStyle.STRONG_REMIND) goto L9;
        return true;
    L9:
        return false;
    L5:
        r2 = r1.getBadgeStyle();
        goto L7
    }

    public m() {
        this.a = new HashMap();
    }

    public final Locale getCacheLanguageSetting() {
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        return com.ss.android.lark.language.service.impl.a.b.a.getCacheLanguageSetting();
    }

    public final void c(final peb.b.h r3) {
        zob.b r0 = new l(r3);
        ((HashMap) this.a).put(r3, r0);
        yob.e.a().getClass();
        int r4 = com.ss.android.lark.language.service.impl.a.f;
        com.ss.android.lark.language.service.impl.a.b.a.c(r0);
    }

    public final boolean isInZenMode(long r1) {
        nmb.a.a().getCoreDependency().p();
        return false;
    }
}
