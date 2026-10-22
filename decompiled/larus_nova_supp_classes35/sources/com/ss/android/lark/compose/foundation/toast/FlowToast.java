package com.ss.android.lark.compose.foundation.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowToast {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/compose/foundation/toast/FlowToast$Duration;", BuildConfig.FLAVOR, "flow-ud_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Duration {
    }

    public static class a {
        public final Context a;
        public CharSequence b;
        public Drawable c;
        public long d;
        public CharSequence e;
        public c f;
        public d g;
        public int h;
        public int i;
        public int j;

        public final g a() {
            int r0 = b.a;
            Intrinsics.checkNotNullParameter(this, "builder");
            int r1 = 1;
            int r5 = 48;
            if (this.e == null) goto L5;
        L8:
            int r2 = com.ss.android.lark.compose.foundation.toast.a.a;
            Context r3 = this.a;
            Intrinsics.checkNotNullParameter(r3, "<this>");
            if (com.ss.android.lark.compose.foundation.toast.a.a(r3) == null) goto L11;
            boolean r4 = true;
        L12:
            if (r4 == false) goto L46;
            com.ss.android.lark.compose.foundation.toast.b r6 = new com.ss.android.lark.compose.foundation.toast.b(this.a);
            CharSequence r7 = this.b;
            if (r7 == null) goto L16;
            Intrinsics.checkNotNullParameter(r7, "s");
            i r10 = r6.d;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r7, "s");
            r10.b.e.setText(r7);
        L16:
            Drawable r8 = this.c;
            if (r8 == null) goto L19;
            r6.setIcon(r8);
        L19:
            c r9 = this.f;
            if (r9 == null) goto L24;
            CharSequence r11 = this.e;
            if (r11 == null) goto L24;
            Intrinsics.checkNotNullParameter(r11, "s");
            Intrinsics.checkNotNullParameter(r9, Keys.API_PARAM_KEY_ACTION);
            i r12 = r6.d;
            com.ss.android.lark.compose.foundation.toast.c r13 = new com.ss.android.lark.compose.foundation.toast.c(r9, r6);
            r12.getClass();
            Intrinsics.checkNotNullParameter(r11, "s");
            Intrinsics.checkNotNullParameter(r13, Keys.API_PARAM_KEY_ACTION);
            TextView r14 = r12.b.b;
            r14.setText(r11);
            r14.setOnClickListener(r13);
            r14.setVisibility(0);
            r12.b.c.setVisibility(0);
        L24:
            int r15 = (int) h18.d.b(this.a, 128);
            if (this.f != null) goto L27;
            r15 = (int) h18.d.b(this.a, 100);
        L28:
            int r16 = this.h;
            if (r16 == 0) goto L32;
            r5 = r16;
        L32:
            int r17 = this.i;
            int r18 = this.j;
            if (r18 == 0) goto L36;
            r15 = r18;
        L36:
            r6.f = r5;
            r6.g = r17;
            r6.h = r15;
            long r19 = this.d;
            if (r19 != (-1)) goto L40;
        L44:
            r19 = 4000;
        L45:
            r6.i = r19;
            r6.j = this.g;
            g r20 = r6;
        L65:
            return r20;
        L40:
            if (r19 != (-2)) goto L43;
            r19 = 7000;
            goto L45
        L43:
            if (r19 >= 0) goto L45;
        L27:
            r5 = 80;
        L46:
            f r21 = new f(this.a);
            CharSequence r22 = this.b;
            if (r22 == null) goto L49;
            r21.setText(r22);
        L49:
            Drawable r23 = this.c;
            if (r23 == null) goto L52;
            r21.setIcon(r23);
        L52:
            int r24 = (int) h18.d.b(this.a, 100);
            int r25 = this.h;
            if (r25 == 0) goto L56;
            r5 = r25;
        L56:
            int r26 = this.i;
            int r27 = this.j;
            if (r27 == 0) goto L60;
            r24 = r27;
        L60:
            r21.setGravity(r5, r26, r24);
            if (this.d == (-2)) goto L64;
            r1 = 0;
        L64:
            r21.setDuration(r1);
            r20 = r21;
            goto L65
        L11:
            r4 = false;
            goto L12
        L5:
            if (this.d > 0) goto L8;
            if (this.g == null) goto L46;
            goto L8
        }

        public a(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r3;
            this.d = -1;
        }

        public final void d(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.c = r2;
        }

        public final void e(int r2) {
            this.b = this.a.getString(r2);
        }

        public final void b(int r2, c r3) {
            Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
            this.e = this.a.getString(r2);
            this.f = r3;
        }

        public final void c(int r1, int r2, int r3) {
            this.h = r1;
            this.i = r2;
            this.j = r3;
        }
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public interface c extends UDToast.b {
    }

    public interface d extends UDToast.c {
    }

    static {
    }

    @JvmStatic
    public static final a a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return new a(r1);
    }

    @JvmStatic
    public static final f b(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "text");
        f r0 = new f(r1);
        r0.setText(r2);
        return r0;
    }

    @JvmStatic
    public static final void c(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
        f r0 = new f(r1);
        r0.setText(r2);
        r0.show();
    }

    @JvmStatic
    public static final void d(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "text");
        b(r1, r2).show();
    }

    @JvmStatic
    public static final void e(Context r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "text");
        f r0 = new f(r2);
        r0.setText(r3);
        r0.setIcon(r4);
        r0.show();
    }
}
