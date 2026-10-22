package com.ss.android.lark.keyboard.biz.emoji;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.l;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.keyboard.keyboard2.i;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard_biz_emoji_office.OfficeEmojiPanelFragment;
import com.ss.android.lark.keyboard_biz_emoji_office.OfficeEmojiTabAdapter;
import com.ss.android.lark.log.Log;
import cya.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IMFaceKBPlugin extends PanelMenuItem {
    public boolean d;
    public final boolean e;
    public final FragmentManager f;
    public final d g;
    public View h;
    public ViewGroup i;
    public OfficeEmojiPanelFragment j;
    public boolean k;
    public boolean l;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return 2131254312;
    }

    public final void H() {
        if (this.k == false) goto L5;
    L9:
        boolean r0 = false;
    L10:
        this.d = r0;
        Fragment r3 = this.f.findFragmentByTag("OfficeEmojiPanelFragment");
        List<? extends com.ss.android.lark.keyboard_biz_emoji_office.c> r5 = null;
        if ((r3 instanceof OfficeEmojiPanelFragment) == false) goto L13;
        OfficeEmojiPanelFragment r4 = (OfficeEmojiPanelFragment) r3;
    L14:
        if (r4 != null) goto L16;
        return;
    L16:
        if (r4.g == r0) goto L30;
        r4.g = r0;
        Bundle r6 = r4.getArguments();
        if (r6 != null) goto L20;
        r6 = new Bundle();
    L20:
        r6.putBoolean("key_enable_custom_sticker", r0);
        r4.setArguments(r6);
        List<? extends com.ss.android.lark.keyboard_biz_emoji_office.c> r1 = CollectionsKt.mutableListOf(new com.ss.android.lark.keyboard_biz_emoji_office.c[]{com.ss.android.lark.keyboard_biz_emoji_office.c.b.b});
        if (r4.g == false) goto L23;
        r1.add(com.ss.android.lark.keyboard_biz_emoji_office.c.a.b);
    L23:
        r4.e = r1;
        OfficeEmojiTabAdapter r2 = (OfficeEmojiTabAdapter) r4.f.getValue();
        List<? extends com.ss.android.lark.keyboard_biz_emoji_office.c> r7 = r4.e;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("tabList");
    L27:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "tabList");
        ((ArrayList) r2.b).clear();
        ((ArrayList) r2.b).addAll(r5);
        r2.notifyDataSetChanged();
        return;
    L26:
        r5 = r7;
        goto L27
    L30:
        return;
    L13:
        r4 = null;
        goto L14
    L5:
        if (this.l == false) goto L9;
        if (this.d == false) goto L9;
        r0 = true;
        goto L10
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void u() {
        Log.i("IMFaceKBPlugin", "onCreate");
        l r0 = n().e().of(this);
        r0.d(h.class, new IMFaceKBPlugin$onCreate$1$1(this));
        r0.d(InputSupportType.class, new IMFaceKBPlugin$onCreate$1$2(this));
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return 2131914266;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return KeyboardMenuItemKey.Emoji;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r4) {
        Log.i("IMFaceKBPlugin", "onSelectChange, isSelect: " + r4);
        View r0 = this.h;
        OfficeEmojiPanelFragment r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r0 = null;
    L5:
        r0.setSelected(r4);
        k.a.a(n().e(), new com.ss.android.lark.keyboard.biz.emoji.a(r4));
        if (r4 == false) goto L12;
        FragmentTransaction r5 = this.f.beginTransaction();
        OfficeEmojiPanelFragment r2 = this.j;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
    L11:
        r5.setMaxLifecycle(r1, Lifecycle.State.RESUMED).commitNowAllowingStateLoss();
        return;
    L10:
        r1 = r2;
        goto L11
    L12:
        FragmentTransaction r6 = this.f.beginTransaction();
        OfficeEmojiPanelFragment r3 = this.j;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
    L16:
        r6.setMaxLifecycle(r1, Lifecycle.State.STARTED).commitNowAllowingStateLoss();
        return;
    L15:
        r1 = r3;
        goto L16
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "container");
        Log.i("IMFaceKBPlugin", "onCreatePanel");
        FrameLayout r0 = new FrameLayout(r6.getContext());
        r0.setId(2131371523);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.i = r0;
        r6.addView(r0);
        int r7 = OfficeEmojiPanelFragment.i;
        boolean r8 = this.d;
        OfficeEmojiPanelFragment r1 = new OfficeEmojiPanelFragment();
        Bundle r2 = new Bundle();
        r2.putBoolean("key_enable_custom_sticker", r8);
        r1.setArguments(r2);
        e r9 = new e(this);
        Intrinsics.checkNotNullParameter(r9, "listener");
        r1.h = r9;
        this.j = r1;
        FragmentTransaction r10 = this.f.beginTransaction();
        OfficeEmojiPanelFragment r3 = this.j;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        r3 = null;
    L6:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "OfficeEmojiPanelFragment", 2131371523) == true) goto L9;
        r10 = r10.add(2131371523, r3, "OfficeEmojiPanelFragment");
    L9:
        r10.commitNowAllowingStateLoss();
        ViewGroup r11 = this.i;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L13:
        return r11;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r2) {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r0 = null;
    L5:
        r0.setEnabled(r2);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r2) {
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
        View r3 = r2.a;
        this.h = r3;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r3 = null;
    L5:
        r3.setActivated(this.e);
    }

    public IMFaceKBPlugin(boolean r2, boolean r3, FragmentManager r4, b r5) {
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.l = true;
        H();
    }
}
