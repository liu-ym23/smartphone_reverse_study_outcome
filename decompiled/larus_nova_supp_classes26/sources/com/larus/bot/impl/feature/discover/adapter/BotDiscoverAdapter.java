package com.larus.bot.impl.feature.discover.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.larus.bot.impl.feature.discover.BotDiscoverListFragment;
import com.larus.utils.o0;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "children", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hasCreationButton", "", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/HashMap;Z)V", "value", "pageCount", "getPageCount", "()I", "setPageCount", "(I)V", "getItemCount", "createFragment", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotDiscoverAdapter extends FragmentStateAdapter {
    public final Fragment a;
    public final HashMap<Integer, Fragment> b;
    public final boolean c;
    public int d;

    public final int getItemCount() {
        return this.d;
    }

    public final Fragment createFragment(int r6) {
        Fragment r0 = this.b.get(Integer.valueOf(r6));
        if (r0 != null) goto L5;
        r0 = new BotDiscoverListFragment();
    L5:
        Bundle r1 = r0.getArguments();
        if (r1 == null) goto L14;
        Bundle r2 = this.a.getArguments();
        if (r2 == null) goto L10;
        String r3 = r2.getString("previous_page");
    L12:
        if (o0.d(r3) == false) goto L14;
        r1.putString("previous_page", r3);
        goto L14
    L10:
        r3 = null;
    L14:
        Integer r4 = Integer.valueOf(r6);
        this.b.put(r4, r0);
        Bundle r5 = this.a.getArguments();
        if (r5 != null) goto L17;
        r5 = new Bundle();
    L17:
        r0.setArguments(r5);
        Bundle r7 = r0.getArguments();
        if (r7 == null) goto L20;
        r7.putInt("position", r6);
    L20:
        Bundle r8 = r0.getArguments();
        if (r8 == null) goto L23;
        r8.putBoolean("has_creation_button", this.c);
    L23:
        return r0;
    }

    public BotDiscoverAdapter(Fragment r2, HashMap<Integer, Fragment> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "children");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 1;
    }
}
