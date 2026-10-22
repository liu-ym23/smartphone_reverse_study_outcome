package com.ss.android.lark.feed.molten;

import com.bytedance.lark.lark_biz_feed_android.f1;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import eeb.a;
import geb.c;
import javax.inject.Provider;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory implements Factory<f1> {
    private final a module;
    private final Provider<UserSession> userSessionProvider;

    public f1 get() {
        return providesUserForegroundScope(this.module, (UserSession) this.userSessionProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1178get() {
        return get();
    }

    public FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory(a r1, Provider<UserSession> r2) {
        this.module = r1;
        this.userSessionProvider = r2;
    }

    public static FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory create(a r1, Provider<UserSession> r2) {
        return new FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory(r1, r2);
    }

    public static f1 providesUserForegroundScope(a r3, UserSession r4) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "userSession");
        ULong r5 = UStringsKt.toULongOrNull(r4.b);
        if (r5 == null) goto L5;
        long r0 = r5.unbox-impl();
    L6:
        c.d("FeedMoltenModuleIncluded", "providesUserForegroundScope uid:" + r4.b + ", userId: " + ULong.toString-impl(r0));
        return (f1) Preconditions.checkNotNullFromProvides(new f1(r0));
    L5:
        r0 = 0;
        goto L6
    }
}
