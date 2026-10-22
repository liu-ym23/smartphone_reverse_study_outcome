package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.keyboard.plugin.tool.face.FaceViewPager;
import com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends TabLayout.ViewPagerOnTabSelectedListener {
    public final /* synthetic */ VoiceFaceKBPlugin a;

    public final void onTabSelected(TabLayout.Tab r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        super.onTabSelected(r3);
        View r0 = null;
        if (r3.getPosition() != 0) goto L14;
        View r4 = this.a.j;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDeleteEmojiBtn");
    L8:
        r0.setVisibility(0);
        VoiceFaceKBPlugin r1 = this.a;
        if (CollectionUtils.isEmpty(r1.n) == false) goto L12;
        return;
    L12:
        if ((ListProtector.get(r1.n, 0) instanceof EmojiPageNewFragment2) == false) goto L20;
        Object r5 = ListProtector.get(r1.n, 0);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2");
        ((EmojiPageNewFragment2) r5).Y90();
        return;
    L20:
        return;
    L7:
        r0 = r4;
        goto L8
    L14:
        View r6 = this.a.j;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDeleteEmojiBtn");
    L18:
        r0.setVisibility(8);
        return;
    L17:
        r0 = r6;
        goto L18
    }

    public c(VoiceFaceKBPlugin r1, FaceViewPager r2) {
        this.a = r1;
        super(r2);
    }
}
