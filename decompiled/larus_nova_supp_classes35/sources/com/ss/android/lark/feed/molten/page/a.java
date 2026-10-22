package com.ss.android.lark.feed.molten.page;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.feed.shared.page.t;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a implements t {
    public final m a;
    public final com.ss.android.lark.feed.molten.cache.b b;

    @Override // com.ss.android.lark.feed.shared.page.t
    public final s a(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "storeOwner");
        return new ViewModelProvider(r3, new FeedItemsMoltenViewModelFactory$create$1(this)).get(Reflection.getOrCreateKotlinClass(FeedItemsMoltenViewModel.class));
    }

    @Inject
    public a(m r2, com.ss.android.lark.feed.molten.cache.b r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "localCache");
        this.a = r2;
        this.b = r3;
    }
}
