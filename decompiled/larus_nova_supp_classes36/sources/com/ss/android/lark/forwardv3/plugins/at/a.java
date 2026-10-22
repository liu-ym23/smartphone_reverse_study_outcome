package com.ss.android.lark.forwardv3.plugins.at;

import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import hob.c;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.keyboard.edittext2.edittors.at.a<c> implements com.ss.android.lark.keyboard.edittext2.edittors.at.b<c> {
    public static final /* synthetic */ int e = 0;
    public final com.ss.android.lark.keyboard.edittext2.edittors.a c;
    public final c d;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.plugins.at.a$a, reason: collision with other inner class name */
    public static final class C0075a extends ClickableSpan {
        public final String a;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
        }

        public C0075a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "widget");
            Log.i("ForwardAtSpanHolder", "forward mention at chatter onclick " + this.a);
            if (Intrinsics.areEqual(this.a, "all") == false) goto L5;
            return;
        L5:
            ForwardModuleV3.a().startProfile(r3.getContext(), this.a);
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.b
    public final void b() {
        f(new ForwardAtSpanHolder$prepareSpan$1(this, this.d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.a, com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public final void c(FunctionEditText r8) {
        Intrinsics.checkNotNullParameter(r8, "editText");
        Editable r0 = r8.getEditableText();
        r0.append(" ");
        Intrinsics.checkNotNull(r0);
        Pair<Integer, Integer> r1 = g(r0);
        int r2 = ((Number) r1.component1()).intValue();
        int r3 = ((Number) r1.component2()).intValue();
        r0.setSpan(e(this.c).component2(), r2, r3, 33);
        com.ss.android.lark.keyboard.edittext2.edittors.at.a.j(this.d);
        RichTextElement.AtProperty r4 = this.d.g;
        if (r4 == null) goto L6;
        r0.setSpan(new p(RichTextElementCreator.h(r4), r0.subSequence(r2, r3).toString()), r2, r3, 33);
        super.c(r8);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.b
    public final void d(c r3) {
        c r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        Log.i("ForwardAtSpanHolder", "onDataLoadedSuccess: " + r4.a + ",  " + r4.d);
        f(new ForwardAtSpanHolder$prepareSpan$1(this, r4));
    }

    public a(ForwardAtStrategy.c r2, com.ss.android.lark.keyboard.edittext2.edittors.a r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        Intrinsics.checkNotNullParameter(r3, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        super(r4, "ForwardAtSpanHolder");
        this.c = r3;
        this.d = r4;
        if (r4.e == false) goto L5;
        Log.i("ForwardAtSpanHolder", "at chatter is anonymous and not load chatter");
        return;
    L5:
        r2.a(r4, this);
    }
}
