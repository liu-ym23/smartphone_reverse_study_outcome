package com.ss.android.lark.keyboard.biz.mention.inject;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AtDoubaoTopPlugin implements wnb.b<AtDoubaoTopPlugin> {
    public static final a i = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public com.ss.android.lark.keyboard.b b;
    public wnb.c c;
    public final Lazy d;
    public Chatter e;
    public RoundedIconTextView f;
    public boolean g;
    public Boolean h;

    public static final class a implements wnb.b.a<AtDoubaoTopPlugin> {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AtDoubaoTopPlugin a;
        public final /* synthetic */ RoundedIconTextView b;

        public b(AtDoubaoTopPlugin r1, RoundedIconTextView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            AtDoubaoTopPlugin r7 = this.a;
            boolean r0 = !r7.g;
            r7.g = r0;
            this.b.d(r0, true);
            boolean r8 = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
            com.ss.android.lark.keyboard.biz.mention.inject.b.a = this.a.g;
            k.a.a(this.a.g().e(), new com.ss.android.lark.keyboard.biz.mention.inject.a(this.a.g));
            int r9 = xob.a.a;
            Context r10 = this.a.a.a.requireContext();
            String r1 = this.a.a.c.getId();
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r1, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r1), new Pair("click", "at_doubao_icon"), new Pair("target", "none"), new Pair("keyboard_status", xob.a.a(r10))});
        }
    }

    static {
        i = new a();
    }

    @Override // wnb.b
    public final View a() {
        RoundedIconTextView r0 = new RoundedIconTextView(this.a.a.requireContext(), null, 6, 0);
        boolean r1 = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        this.g = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        itb.a r2 = OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r2 == null) goto L6;
        String r3 = r2.i();
        if (r3 == null) goto L6;
    L7:
        r0.setText("@ ".concat(r3));
        r0.setTextBold(true);
        r0.setInputTopActionCheckedStyle(PluginUtils.c());
        r0.d(this.g, false);
        com.ss.android.lark.keyboard.biz.mention.inject.b.a = this.g;
        r0.setOnClickListener(new b(this, r0));
        this.f = r0;
        Lifecycle r4 = g().l().b;
        if (r4 == null) goto L12;
        LifecycleCoroutineScope r5 = LifecycleKt.getCoroutineScope(r4);
        if (r5 == null) goto L12;
        BuildersKt.launch$default(r5, null, null, new AtDoubaoTopPlugin$getDoubaoChatter$1(this, null), 3, null);
    L12:
        g().e().of(this).c(q.b.class, new AtDoubaoTopPlugin$refreshUI$1(this));
        g().e().of(this).c(j.class, new AtDoubaoTopPlugin$refreshUI$2(this));
        boolean r6 = j();
        if (r6 == true) goto L15;
        f();
    L15:
        this.h = Boolean.valueOf(r6);
        Log.i("AtDoubaoTopPlugin", "init Doubao top entry visibility, visible=" + this.h);
        com.ss.android.lark.biz.im.api.extension.chat_window.b r7 = this.a;
        com.ss.android.lark.biz.im.api.extension.chat_window.h r8 = r7.e;
        if (r8 == null) goto L20;
        MutableLiveData r9 = r8.c;
        if (r9 == null) goto L20;
        r9.observe(r7.a.getViewLifecycleOwner(), new c(this));
    L20:
        RoundedIconTextView r10 = this.f;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.keyboard.widget.RoundedIconTextView");
        return r10;
    L6:
        r3 = "";
        goto L7
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(8.0f), UIHelper.dp2px(0.0f));
    }

    public final void f() {
        boolean r1 = true;
        if (this.g == true) goto L15;
        boolean r0 = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        if (com.ss.android.lark.keyboard.biz.mention.inject.b.a == true) goto L15;
        RoundedIconTextView r2 = this.f;
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L15;
        r1 = false;
        goto L15
    L9:
        if (r2.l != true) goto L11;
        r3 = true;
    L15:
        this.g = false;
        boolean r4 = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        com.ss.android.lark.keyboard.biz.mention.inject.b.a = false;
        RoundedIconTextView r5 = this.f;
        if (r5 == null) goto L18;
        r5.d(false, false);
    L18:
        if (r1 == false) goto L21;
        k.a.a(g().e(), new com.ss.android.lark.keyboard.biz.mention.inject.a(false));
        return;
    }

    public final com.ss.android.lark.keyboard.b g() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    public final boolean j() {
        com.ss.android.lark.biz.im.api.extension.chat_window.h r0 = this.a.e;
        if (r0 == null) goto L8;
        MutableLiveData r1 = r0.c;
        if (r1 == null) goto L8;
        Chat r2 = (Chat) r1.getValue();
        if (r2 == null) goto L8;
    L10:
        return com.ss.android.lark.keyboard.utils.b.a(r2);
    L8:
        r2 = this.a.c;
        goto L10
    }

    @Override // wnb.b
    public final void onDestroy() {
        boolean r0 = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        com.ss.android.lark.keyboard.biz.mention.inject.b.a = false;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        if (j() == false) goto L6;
        return InputInnerVisibilityMode.DYNAMIC;
    L6:
        return InputInnerVisibilityMode.ALWAYS_GONE;
    }

    @Override // wnb.b
    public final boolean i() {
        return j();
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
    public final wnb.b.a<AtDoubaoTopPlugin> getKey() {
        return i;
    }

    public AtDoubaoTopPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
        this.d = LazyKt.lazy(AtDoubaoTopPlugin$model$2.INSTANCE);
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
