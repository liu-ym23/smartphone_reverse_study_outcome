package com.ss.android.lark.keyboard.biz.emoji.inject;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.event.r;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import wnb.c;
import wnb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EmojiTopPlugin implements wnb.b<EmojiTopPlugin> {
    public static final a h = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public com.ss.android.lark.keyboard.b b;
    public c c;
    public RoundedIconTextView d;
    public boolean e;
    public Boolean f;
    public boolean g;

    public static final class a implements wnb.b.a<EmojiTopPlugin> {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ EmojiTopPlugin a;

        public b(EmojiTopPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r15) {
            m r16 = this.a.f().H().k();
            if (r16 == null) goto L5;
            KeyboardMenuItemKey r17 = r16.g();
        L6:
            KeyboardMenuItemKey r0 = KeyboardMenuItemKey.Emoji;
            if (r17 != r0) goto L9;
            boolean r18 = true;
        L10:
            this.a.f = Boolean.valueOf(!r18);
            EmojiTopPlugin r3 = this.a;
            r3.g = false;
            if (r18 == false) goto L13;
            r3.f().H().h();
        L14:
            int r19 = xob.a.a;
            Context r110 = this.a.a.a.requireContext();
            String r1 = this.a.a.c.getId();
            Intrinsics.checkNotNullParameter(r110, "context");
            Intrinsics.checkNotNullParameter(r1, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r1), new Pair("click", "reaction_icon"), new Pair("target", "none"), new Pair("keyboard_status", xob.a.a(r110))});
            return;
        L13:
            r3.f().H().f(r0);
            int r111 = xob.a.a;
            Context r112 = this.a.a.a.requireContext();
            String r2 = this.a.a.c.getId();
            Intrinsics.checkNotNullParameter(r112, "context");
            Intrinsics.checkNotNullParameter(r2, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r2), new Pair("click", "input_emoji"), new Pair("target", "public_emoji_panel_select_view"), new Pair("keyboard_status", xob.a.a(r112))});
            goto L14
        L9:
            r18 = false;
            goto L10
        L5:
            r17 = null;
            goto L6
        }
    }

    static {
        h = new a();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final View a() {
        KeyboardMenuItemKey r2 = null;
        RoundedIconTextView r0 = new RoundedIconTextView(this.a.a.requireContext(), null, 6, 0);
        this.d = r0;
        r0.setIcon(2131235907);
        r0.setText(UIUtils.getString(r0.getContext(), 2131889988));
        r0.setTextBold(true);
        r0.setInputTopActionCheckedStyle(PluginUtils.c());
        r0.setOnClickListener(new b(this));
        m r3 = f().H().k();
        if (r3 == null) goto L6;
        r2 = r3.g();
    L6:
        if (r2 != KeyboardMenuItemKey.Emoji) goto L8;
        boolean r4 = true;
    L9:
        r0.d(r4, false);
        if (this.e == true) goto L12;
        this.e = true;
        f().e().of(this).d(r.class, new EmojiTopPlugin$getPluginView$pluginView$1$2(this));
        f().e().of(this).c(com.ss.android.lark.keyboard.biz.emoji.a.class, new EmojiTopPlugin$getPluginView$pluginView$1$3(this));
    L12:
        com.ss.android.lark.biz.im.api.extension.chat_window.b r1 = this.a;
        h r5 = r1.e;
        if (r5 == null) goto L17;
        MutableLiveData r6 = r5.c;
        if (r6 == null) goto L17;
        r6.observe(r1.a.getViewLifecycleOwner(), new com.ss.android.lark.keyboard.biz.emoji.inject.a(this));
    L17:
        return r0;
    L8:
        r4 = false;
        goto L9
    }

    @Override // wnb.b
    public final e b() {
        h r0 = this.a.e;
        if (r0 == null) goto L8;
        MutableLiveData r1 = r0.c;
        if (r1 == null) goto L8;
        Chat r2 = (Chat) r1.getValue();
        if (r2 == null) goto L8;
    L10:
        if (r2.isGroup() == false) goto L12;
    L14:
        int r3 = 0;
    L16:
        return new e(r3, UIHelper.dp2px(12.0f), 0, UIHelper.dp2px(0.0f));
    L12:
        if (com.ss.android.lark.keyboard.utils.b.a(r2) == true) goto L14;
        r3 = UIHelper.dp2px(12.0f);
    L8:
        r2 = this.a.c;
        goto L10
    }

    public final com.ss.android.lark.keyboard.b f() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    @Override // wnb.b
    public final c h() {
        c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        if (this.b == null) goto L5;
        f().e().of(this).a();
    L5:
        this.d = null;
        this.e = false;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.Top;
    }

    @Override // wnb.b
    public final wnb.b.a<EmojiTopPlugin> getKey() {
        return h;
    }

    public EmojiTopPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
