package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceAtStrategy extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.b {
    public final Lazy c;

    public static final class a extends ClickableSpan {
        public final String a;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r4) {
            Intrinsics.checkNotNullParameter(r4, "widget");
            if (Intrinsics.areEqual(this.a, "all") == false) goto L5;
            return;
        L5:
            Context r0 = r4.getContext();
            KeyboardVoiceModule.c r1 = KeyboardVoiceModule.a().getProfileDependency();
            Intrinsics.checkNotNull(r0);
            r1.a(r0, this.a);
            r4.clearFocus();
        }
    }

    public static final class b {
    }

    static {
    }

    public VoiceAtStrategy() {
        this.c = LazyKt.lazy(new VoiceAtStrategy$enableForceHighlight$2(this));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(final com.ss.android.lark.keyboard.edittext2.edittors.a r2, final hob.c r3) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r3, "data");
        return new VoiceAtStrategy$prepareAtSpanHolder$1(r2, r3, this);
    }
}
