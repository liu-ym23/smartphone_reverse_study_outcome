package com.obric.assistant.settings.experience;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {

    /* JADX INFO: renamed from: com.obric.assistant.settings.experience.a$a, reason: collision with other inner class name */
    public static final class C0018a extends ClickableSpan {
        public final /* synthetic */ int a;

        public C0018a(int r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r4) {
            Intrinsics.checkNotNullParameter(r4, "widget");
            i r5 = SmartRouter.buildRoute(r4.getContext(), "//flow/webview");
            r5.c.putExtra("link_url", "https://os.obriccloud.com/agreement/ux_improvement_plan");
            r5.d();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setColor(this.a);
            r2.setUnderlineText(false);
        }
    }

    public static final CharSequence a(Context r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        String r10 = r7.getString(r8);
        String r0 = r7.getString(2131912687);
        int r1 = StringsKt.indexOf$default(r10, r0, 0, false, 6, null);
        if (r1 >= 0) goto L5;
        return r10;
    L5:
        int r11 = ContextCompat.getColor(r7, r9);
        SpannableString r12 = new SpannableString(r10);
        r12.setSpan(new C0018a(r11), r1, r0.length() + r1, 33);
        return r12;
    }
}
