package com.ss.android.lark.keyboard.biz.mention.inject;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements wnb.b<e> {
    public static final a f = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public boolean b;
    public com.ss.android.lark.keyboard.b c;
    public wnb.c d;
    public RoundedIconTextView e;

    public static final class a implements wnb.b.a<e> {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            com.ss.android.lark.keyboard.b r14 = this.a.c;
            if (r14 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("keyboard");
            r14 = null;
        L6:
            r14.H().f(KeyboardMenuItemKey.At);
            int r15 = xob.a.a;
            Context r16 = this.a.a.a.requireContext();
            String r0 = this.a.a.c.getId();
            Intrinsics.checkNotNullParameter(r16, "context");
            Intrinsics.checkNotNullParameter(r0, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r0), new Pair("click", "at_user_icon"), new Pair("target", "none"), new Pair("keyboard_status", xob.a.a(r16))});
            Context r4 = this.a.a.a.requireContext();
            String r5 = this.a.a.c.getId();
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r5), new Pair("click", "at_mention"), new Pair("target", "public_at_mention_select_view"), new Pair("keyboard_status", xob.a.a(r4))});
        }
    }

    static {
        f = new a();
    }

    @Override // wnb.b
    public final /* synthetic */ void onDestroy() {
    }

    @Override // wnb.b
    public final View a() {
        RoundedIconTextView r0 = new RoundedIconTextView(this.a.a.requireContext(), null, 6, 0);
        r0.setText("@ " + UIUtils.getString(r0.getContext(), 2131890108));
        r0.setTextBold(true);
        r0.setOnClickListener(new b(this));
        this.e = r0;
        com.ss.android.lark.biz.im.api.extension.chat_window.b r1 = this.a;
        com.ss.android.lark.biz.im.api.extension.chat_window.h r2 = r1.e;
        if (r2 == null) goto L7;
        MutableLiveData r3 = r2.c;
        if (r3 == null) goto L7;
        r3.observe(r1.a.getViewLifecycleOwner(), new f(this));
    L7:
        RoundedIconTextView r4 = this.e;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.keyboard.widget.RoundedIconTextView");
        return r4;
    }

    @Override // wnb.b
    public final wnb.e b() {
        com.ss.android.lark.biz.im.api.extension.chat_window.h r0 = this.a.e;
        if (r0 == null) goto L8;
        MutableLiveData r1 = r0.c;
        if (r1 == null) goto L8;
        Chat r2 = (Chat) r1.getValue();
        if (r2 == null) goto L8;
    L10:
        if (r2.isGroup() == true) goto L12;
    L14:
        int r3 = 0;
    L16:
        return new wnb.e(r3, UIHelper.dp2px(12.0f), UIHelper.dp2px(8.0f), UIHelper.dp2px(0.0f));
    L12:
        if (com.ss.android.lark.keyboard.utils.b.a(r2) == true) goto L14;
        r3 = UIHelper.dp2px(12.0f);
    L8:
        r2 = this.a.c;
        goto L10
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        if (this.b == false) goto L6;
        return InputInnerVisibilityMode.DYNAMIC;
    L6:
        return InputInnerVisibilityMode.ALWAYS_GONE;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.Top;
    }

    @Override // wnb.b
    public final wnb.b.a<e> getKey() {
        return f;
    }

    @Override // wnb.b
    public final boolean i() {
        return this.b;
    }

    public e(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }
}
