package com.ss.android.lark.chat.chatwindow.chat.v2.plugin;

import android.text.Editable;
import android.text.TextWatcher;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.event.l;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.statistics.Statistics;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a {
    public WeakReference<com.ss.android.lark.keyboard.b> g;
    public String h;
    public boolean i;
    public final b j;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.a$a, reason: collision with other inner class name */
    public static final class C0077a implements ChatWindowKeyboard.a {
        public final /* synthetic */ a a;

        public final void d() {
        }

        public final void f() {
        }

        public final void a() {
            final a r0 = this.a;
            WeakReference<com.ss.android.lark.keyboard.b> r1 = r0.g;
            if (r1 == null) goto L9;
            com.ss.android.lark.keyboard.b r2 = r1.get();
            if (r2 == null) goto L10;
            l r3 = r2.e().of(r0);
            r3.d(ImeState.class, new ChatFirstInputEventPlugin$setupKeyboardEvent$1$1(r0));
            r3.c(q.b.class, new ChatFirstInputEventPlugin$setupKeyboardEvent$1$2(r0));
            return;
        L10:
            return;
        }

        public C0077a(a r1) {
            this.a = r1;
        }

        public final void g(com.ss.android.lark.keyboard.b r3) {
            Intrinsics.checkNotNullParameter(r3, "keyboard");
            Intrinsics.checkNotNullParameter(r3, "keyboard");
            a r0 = this.a;
            r0.g = new WeakReference(r3);
        }
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ a a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            a r3 = this.a;
            if (r3.i == true) goto L10;
            r3.i = true;
            LinkedHashMap r0 = new LinkedHashMap();
            Map<String, Object> r4 = ChatParamUtils.f(r3.h);
            if (r4 == null) goto L8;
            r0.putAll(r4);
        L8:
            Statistics.sendEvent("im_chat_main_click", s5c.b.a(r0, r.V2).toJson());
            return;
        }
    }

    public a() {
        this.j = new b(this);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        super.C(r3, r4);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.track_editor_typing") == true) goto L5;
        return;
    L5:
        this.h = r4.e;
        ChatWindowKeyboard r5 = r3.n();
        if (r5 == null) goto L9;
        r5.m7(new C0077a(this));
        return;
    }
}
