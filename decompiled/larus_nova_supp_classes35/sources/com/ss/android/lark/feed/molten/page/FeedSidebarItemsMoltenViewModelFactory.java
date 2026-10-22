package com.ss.android.lark.feed.molten.page;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.feed.shared.page.u;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class FeedSidebarItemsMoltenViewModelFactory implements u {
    public final m a;
    public final com.ss.android.lark.feed.molten.cache.b b;

    @Override // com.ss.android.lark.feed.shared.page.u
    public final s a(ViewModelStoreOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "storeOwner");
        return new ViewModelProvider(r3, new FeedSidebarItemsMoltenViewModelFactory$create$1(this)).get(Reflection.getOrCreateKotlinClass(FeedSidebarItemsMoltenViewModel.class));
    }

    @Inject
    public FeedSidebarItemsMoltenViewModelFactory(m r2, com.ss.android.lark.feed.molten.cache.b r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "localCache");
        this.a = r2;
        this.b = r3;
    }
}
