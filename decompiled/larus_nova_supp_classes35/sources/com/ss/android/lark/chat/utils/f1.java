package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f1 {
    public static pl.droidsonroids.gif.d a;
    public static final pl.droidsonroids.gif.m b = null;

    public interface a {
        void a(String r1);

        void o1();
    }

    public static class b extends ClickableSpan {
        public long a;
        public final a b;
        public final SystemMessageType c;
        public final Context d;

        public interface a {
            void a(SystemMessageType r1);
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r5) {
            long r0 = SystemClock.uptimeMillis();
            long r2 = r0 - this.a;
            this.a = r0;
            if (r2 >= 500) goto L5;
            return;
        L5:
            a r6 = this.b;
            if (r6 == null) goto L9;
            r6.a(this.c);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            super.updateDrawState(r3);
            r3.setColor(UIUtils.getColor(this.d, 2131102093));
            r3.setUnderlineText(false);
        }

        public b(FragmentActivity r1, SystemMessageType r2, a r3) {
            this.d = r1;
            this.b = r3;
            this.c = r2;
        }
    }

    static {
        b = new pl.droidsonroids.gif.m(true);
        new CopyOnWriteArrayList();
    }

    public static ncc.f b(Context r1, boolean r2, boolean r3) {
        if (r3 == false) goto L4;
        int r4 = -9395969;
    L5:
        if (r2 == false) goto L7;
        int r0 = 2131109339;
    L8:
        int r5 = UIUtils.getColor(r1, r0);
        if (r2 == false) goto L11;
        Paint.Style r6 = Paint.Style.FILL;
    L13:
        return new ncc.f(r5, r4, r6);
    L11:
        r6 = Paint.Style.STROKE;
        goto L13
    L7:
        int r7 = p3b.a.W;
        r0 = v4b.a.o;
        goto L8
    L4:
        int r8 = p3b.a.W;
        r4 = UIUtils.getColor(r1, v4b.a.t);
        goto L5
    }

    public static void a(Context r4, SpannableStringBuilder r5, int r6, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.y r7) {
        int r0 = r5.length();
        r5.append("…" + UIHelper.mustacheFormat(2131890352, "number", Integer.toString(r6)));
        int r8 = r5.length();
        r5.setSpan(new e1(r4, r7), r0, r8, 33);
        r5.setSpan(new ForegroundColorSpan(UIUtils.getColor(r4, 2131106620)), r0, r8, 33);
    }

    public static SpannableStringBuilder c(FragmentActivity r5, SystemMessageType r6, String r7, String r8, b.a r9) {
        String r10 = "[pic]" + r7;
        int r0 = r10.lastIndexOf(r8);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        int r11 = r8.length() + r0;
        SpannableStringBuilder r1 = new SpannableStringBuilder(r10);
        if (r5 != null) goto L9;
        return r1;
    L9:
        Drawable r12 = UIUtils.getDrawable(r5, 2131255056);
        r12.setBounds(0, 0, UIUtils.dp2px(r5, 16.0f), UIUtils.dp2px(r5, 16.0f));
        r1.setSpan(new ImageSpan(r12), 0, 5, 17);
        r1.setSpan(new b(r5, r6, r9), r0, r11, 17);
        return r1;
    }
}
