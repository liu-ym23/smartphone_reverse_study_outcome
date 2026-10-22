package com.ss.android.lark.edit.keyboard.producer;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseKeyboardHeightProducer {
    public final Activity a;
    public ViewGroup b;
    public final Lazy c;
    public Long d;

    public static final class a {
    }

    public static final class b {
        public int a;
        public final int b;
        public final int c;
        public boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "KeyboardData(imeHeight=" + this.a + ", navHeight=" + this.b + ", capHeight=" + this.c + ", isVisible=" + this.d + ')';
        }

        public b(int r1, int r2, int r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final PopupWindow a() {
        return (PopupWindow) this.c.getValue();
    }

    public BaseKeyboardHeightProducer(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.c = LazyKt.lazy(new BaseKeyboardHeightProducer$mPopupWindow$2(this));
    }
}
