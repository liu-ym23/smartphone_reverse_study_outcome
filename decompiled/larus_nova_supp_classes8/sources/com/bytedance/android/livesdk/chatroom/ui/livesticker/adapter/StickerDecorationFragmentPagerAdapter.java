package com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.android.livesdk.chatroom.model.e3;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.StickerDecorationPageFragment;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.StickerDecorationType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/StickerDecorationFragmentPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerDecorationFragmentPagerAdapter extends FragmentPagerAdapter {
    public final DataCenter a;
    public final e3 b;

    public static final class a {
    }

    static {
    }

    public final int getCount() {
        return 2;
    }

    public final CharSequence getPageTitle(int r2) {
        if (r2 != 0) goto L4;
        return "文字贴纸";
    L4:
        if (r2 == 1) goto L6;
        return "";
    L6:
        return "图片贴纸";
    }

    public final Fragment getItem(int r5) {
        if (r5 == 0) goto L4;
        StickerDecorationType r0 = StickerDecorationType.IMAGE_STICKER;
    L5:
        String r6 = String.valueOf(getPageTitle(r5));
        int r1 = StickerDecorationPageFragment.k;
        DataCenter r2 = this.a;
        e3 r3 = this.b;
        Intrinsics.checkNotNullParameter(r0, "pageType");
        Intrinsics.checkNotNullParameter(r6, "pageTitle");
        StickerDecorationPageFragment r4 = new StickerDecorationPageFragment();
        r4.e = r2;
        r4.f = r0;
        r4.g = r6;
        r4.h = r3;
        return r4;
    L4:
        r0 = StickerDecorationType.TEXT_STICKER;
        goto L5
    }

    public StickerDecorationFragmentPagerAdapter(FragmentManager r2, DataCenter r3, e3 r4) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        super(r2);
        this.a = r3;
        this.b = r4;
    }
}
