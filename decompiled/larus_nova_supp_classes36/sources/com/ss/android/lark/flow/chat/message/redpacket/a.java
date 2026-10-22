package com.ss.android.lark.flow.chat.message.redpacket;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDAvatarList;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends UDAvatarList.AvatarAdapter<ChatterInfo> {
    public final List<ChatterInfo> a;

    public final UDAvatar getMoreAvatar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return getAvatar(r2, getMaxCount() - 1);
    }

    public a(int r2, List<? extends ChatterInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "avatarList");
        super(r2, r3);
        this.a = r3;
    }

    public final UDAvatar getAvatar(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (((ChatterInfo) getItem(r4)) == null) goto L6;
        UDAvatar r0 = new UDAvatar(r3);
        r0.setBorderColor(UDColorUtils.getColor(r3, 2131103530));
        r0.setBorderWidth(Float.valueOf(UIUtils.dp2px(r3, 1.0f)));
        r0.setAvatarSize(getAvatarSize());
        r0.setBackgroundColor(UDColorUtils.getColor(r3, 2131100556));
        onItemCreated(r0, r4);
        return r0;
    L6:
        return null;
    }

    public final void onItemCreated(UDAvatar r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "avatar");
        ChatterInfo r6 = (ChatterInfo) getItem(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        AvatarImage r7 = AvatarImage.Builder.obtain(r6.getAvatarKey(), r6.getId(), getAvatarSize(), getAvatarSize()).build();
        ImageLoader.with(r4.getContext()).load(r7).placeholder(new ColorDrawable(UIUtils.getColor(r4.getContext(), 2131101955))).override(getAvatarSize(), getAvatarSize()).into(r4);
    }
}
