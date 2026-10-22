package com.ss.android.lark.keyboard.editor.input.interceptor;

import com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.AudioPanelType;
import com.ss.android.lark.keyboard.editor.input.ChatEditorCurET;
import com.ss.android.lark.keyboard.editor.input.ChatEditorEnable;
import com.ss.android.lark.keyboard.event.l;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.c;
import com.ss.android.lark.keyboard.keyboard2.e;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.log.Log;
import cya.h;
import java.util.EnumSet;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ChatKeyboardMenuInterceptor implements c {
    public static final a l = null;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public com.ss.android.lark.keyboard.b e;
    public final Set<KeyboardMenuItemKey> f;
    public final Set<KeyboardMenuItemKey> g;
    public final Set<KeyboardMenuItemKey> h;
    public final Set<KeyboardMenuItemKey> i;
    public final Set<KeyboardMenuItemKey> j;
    public final b k;

    public static final class a implements c.a<ChatKeyboardMenuInterceptor> {
        public a() {
        }
    }

    public static final class b implements e {
        public final /* synthetic */ ChatKeyboardMenuInterceptor a;

        public b(ChatKeyboardMenuInterceptor r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.e
        public final boolean n(m r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            return this.a.a;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.e
        public final boolean u(m r6) {
            Intrinsics.checkNotNullParameter(r6, "item");
            cya.c r0 = this.a.a().L();
            if ((r0 instanceof cya.c) == false) goto L5;
            cya.c r1 = r0;
        L6:
            if (r1 != null) goto L9;
            Log.w("ChatKeyboardMenuInterceptor", "isItemVisible: invalid input editor type, method return");
            return false;
        L9:
            int r2 = r1.a().d().a();
            if (this.a.a().L().getInputType() != InputSupportType.Post) goto L18;
            if (r2 == 4) goto L17;
            if (r2 == 8) goto L17;
            ChatKeyboardMenuInterceptor r3 = this.a;
            if (r3.d == false) goto L16;
            Set<KeyboardMenuItemKey> r4 = r3.f;
        L23:
            return r4.contains(r6.g());
        L16:
            r4 = r3.g;
        L17:
            r4 = this.a.h;
            goto L23
        L18:
            if (r2 == 4) goto L21;
            if (r2 == 8) goto L21;
            r4 = this.a.i;
        L21:
            r4 = this.a.j;
            goto L23
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        l = new a();
    }

    public final com.ss.android.lark.keyboard.b a() {
        com.ss.android.lark.keyboard.b r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public ChatKeyboardMenuInterceptor() {
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        KeyboardMenuItemKey r1 = KeyboardMenuItemKey.AaStyle;
        KeyboardMenuItemKey r2 = KeyboardMenuItemKey.At;
        KeyboardMenuItemKey r3 = KeyboardMenuItemKey.Emoji;
        KeyboardMenuItemKey r4 = KeyboardMenuItemKey.Photo;
        EnumSet r5 = EnumSet.of(r1, r2, r3, r4);
        if (KeyboardVoiceFGUtils.e() == false) goto L5;
        r5.add(KeyboardMenuItemKey.Voice);
    L5:
        this.f = r5;
        KeyboardMenuItemKey r6 = KeyboardMenuItemKey.Voice;
        this.g = SetsKt.minus(r5, r6);
        this.h = EnumSet.of(r3, r2, r4, r1);
        this.i = EnumSet.of(r6, new KeyboardMenuItemKey[]{r2, r3, r4, KeyboardMenuItemKey.BurnLife, KeyboardMenuItemKey.Plus, KeyboardMenuItemKey.UploadLog, r1, KeyboardMenuItemKey.RestrictedBurnLife});
        this.j = EnumSet.of(r3, r2, r1);
        this.k = new b(this);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        a().H().M(this.k);
        l r0 = a().e().of(this);
        r0.d(InputSupportType.class, new ChatKeyboardMenuInterceptor$onAttached$1$1(this));
        r0.d(h.class, new ChatKeyboardMenuInterceptor$onAttached$1$2(this));
        r0.c(ChatEditorCurET.class, new ChatKeyboardMenuInterceptor$onAttached$1$3(this));
        r0.c(ChatEditorEnable.class, new ChatKeyboardMenuInterceptor$onAttached$1$4(this));
        r0.c(AudioPanelType.class, new ChatKeyboardMenuInterceptor$onAttached$1$5(this));
        e();
    }

    public final void e() {
        a().H().m();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
        a().e().of(this).a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }
}
