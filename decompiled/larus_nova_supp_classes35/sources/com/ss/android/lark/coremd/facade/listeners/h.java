package com.ss.android.lark.coremd.facade.listeners;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chatwindow.view.readstate.ReadStateView;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.impl.parse.k;
import com.ss.android.lark.coremdbiz.facade.p;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements com.ss.android.lark.coremd.base.parse.f {
    public final m2b.a c;
    public final c d;
    public final boolean e;
    public final boolean f;
    public final float g;
    public final b h;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final ChatDisplayModeSetting h;
        public final boolean i;
        public final boolean j;
        public final float k;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (Float.compare(this.k, r6.k) == 0) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            int r4 = 1231;
            if (this.b == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r3 + r5) * 31;
            if (this.c == false) goto L13;
            int r7 = 1231;
        L14:
            int r8 = (r6 + r7) * 31;
            if (this.d == false) goto L17;
            int r9 = 1231;
        L18:
            int r10 = (r8 + r9) * 31;
            if (this.e == false) goto L21;
            int r11 = 1231;
        L22:
            int r12 = (r10 + r11) * 31;
            if (this.f == false) goto L25;
            int r13 = 1231;
        L26:
            int r14 = (r12 + r13) * 31;
            if (this.g == false) goto L29;
            int r15 = 1231;
        L30:
            int r16 = (r14 + r15) * 31;
            ChatDisplayModeSetting r17 = this.h;
            if (r17 == null) goto L34;
            r1 = r17.hashCode();
        L34:
            int r18 = (r16 + r1) * 31;
            if (this.i == false) goto L37;
            int r19 = 1231;
        L38:
            int r20 = (r18 + r19) * 31;
            if (this.j == true) goto L43;
            r4 = 1237;
        L43:
            return ((r20 + r4) * 31) + Float.floatToIntBits(this.k);
        L37:
            r19 = 1237;
            goto L38
        L29:
            r15 = 1237;
            goto L30
        L25:
            r13 = 1237;
            goto L26
        L21:
            r11 = 1237;
            goto L22
        L17:
            r9 = 1237;
            goto L18
        L13:
            r7 = 1237;
            goto L14
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReadStateCacheKey(chatId=" + this.a + ", isP2pChat=" + this.b + ", isGroup=" + this.c + ", isChatThread=" + this.d + ", isReplyInThread=" + this.e + ", isThread=" + this.f + ", isSecretChat=" + this.g + ", chatDisplayModeSetting=" + this.h + ", isRootMessage=" + this.i + ", onlyIReadEnabled=" + this.j + ", iconSizeInDp=" + this.k + ')';
        }

        public b(String r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, ChatDisplayModeSetting r8, boolean r9, boolean r10, float r11) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
        }
    }

    public static final class c {
        public final String a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final ChatDisplayModeSetting h;
        public final jdb.g i;
        public final boolean j;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            int r4 = 1231;
            if (this.b == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r3 + r5) * 31;
            if (this.c == false) goto L13;
            int r7 = 1231;
        L14:
            int r8 = (r6 + r7) * 31;
            if (this.d == false) goto L17;
            int r9 = 1231;
        L18:
            int r10 = (r8 + r9) * 31;
            if (this.e == false) goto L21;
            int r11 = 1231;
        L22:
            int r12 = (r10 + r11) * 31;
            if (this.f == false) goto L25;
            int r13 = 1231;
        L26:
            int r14 = (r12 + r13) * 31;
            if (this.g == false) goto L29;
            int r15 = 1231;
        L30:
            int r16 = (r14 + r15) * 31;
            ChatDisplayModeSetting r17 = this.h;
            if (r17 == null) goto L34;
            r1 = r17.hashCode();
        L34:
            int r18 = (((r16 + r1) * 31) + this.i.hashCode()) * 31;
            if (this.j == true) goto L39;
            r4 = 1237;
        L39:
            return r18 + r4;
        L29:
            r15 = 1237;
            goto L30
        L25:
            r13 = 1237;
            goto L26
        L21:
            r11 = 1237;
            goto L22
        L17:
            r9 = 1237;
            goto L18
        L13:
            r7 = 1237;
            goto L14
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ThreadReadStateListenerDependency(chatId=" + this.a + ", isP2pChat=" + this.b + ", isGroup=" + this.c + ", isChatThread=" + this.d + ", isReplyInThread=" + this.e + ", isThread=" + this.f + ", isSecretChat=" + this.g + ", chatDisplayModeSetting=" + this.h + ", fgService=" + this.i + ", isRootMessage=" + this.j + ')';
        }

        public c(String r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, ChatDisplayModeSetting r9, jdb.g r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "fgService");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }
    }

    static {
    }

    public final int hashCode() {
        if (this.e == false) goto L10;
        int r0 = System.identityHashCode(this.c) * 31;
        b r1 = this.h;
        if (r1 == null) goto L7;
        int r2 = r1.hashCode();
    L11:
        return r0 + r2;
    L7:
        r2 = 0;
        goto L11
    L10:
        return System.identityHashCode(this);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
    L15:
        return true;
    L4:
        if (this.e == true) goto L6;
    L14:
        return false;
    L6:
        if ((r3 instanceof h) == false) goto L14;
        h r4 = (h) r3;
        if (r4.e == false) goto L14;
        if (this.c != r4.c) goto L14;
        if (Intrinsics.areEqual(this.h, r4.h) == false) goto L14;
        goto L14
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(k r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public h(m2b.a r14, c r15) {
        Intrinsics.checkNotNullParameter(r14, "chatContext");
        Intrinsics.checkNotNullParameter(r15, "threadReadStateListenerDependency");
        this.c = r14;
        this.d = r15;
        boolean r16 = p.a();
        this.e = r16;
        if (r16 == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.f = r11;
        if (r16 == false) goto L11;
        float r12 = zz7.b.f(16.0f);
    L12:
        this.g = r12;
        if (r16 == false) goto L15;
        b r17 = new b(r15.a, r15.b, r15.c, r15.d, r15.e, r15.f, r15.g, r15.h, r15.j, r11, r12);
    L16:
        this.h = r17;
        return;
    L15:
        r17 = null;
        goto L16
    L11:
        r12 = 0.0f;
        goto L12
    L5:
        if (r15.i.isEnable("messenger.thread.read_receipt_myreply_opt") == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void a(s r1, Spannable r2) {
        com.ss.android.lark.coremd.base.parse.f.a.b(r1, r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void b(com.ss.android.lark.coremd.impl.parse.d r1, s r2) {
        com.ss.android.lark.coremd.base.parse.f.a.a(r1, r2);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void g(final com.ss.android.lark.coremd.impl.parse.d r18, SpannableStringBuilder r19) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "charSequence");
        IMContextExtend.a r1 = IMContextExtend.A;
        final List r4 = (List) r1.b(new ThreadReadStateListener$onParseEnd$allAtChatterIds$1(r18));
        final List r2 = (List) r1.b(new ThreadReadStateListener$onParseEnd$readStateList$1(r18));
        if (((Boolean) r1.b(new ThreadReadStateListener$onParseEnd$1(r4, r2, this))).booleanValue() == false) goto L6;
        Log.e("ThreadReadStateListener", "message info missing");
        return;
    L6:
        final String r3 = (String) r1.b(new ThreadReadStateListener$onParseEnd$messageId$1(r18));
        if (((Boolean) r1.b(new ThreadReadStateListener$onParseEnd$2(r18))).booleanValue() == false) goto L63;
        int r10 = ((Number) ListProtector.get(r2, 0)).intValue() - 1;
        int r5 = ((Number) ListProtector.get(r2, 1)).intValue();
        if (this.e == false) goto L11;
        boolean r12 = this.f;
    L12:
        if (r12 == false) goto L20;
        c r13 = this.d;
        if (r13.e == false) goto L20;
        if (r13.j == true) goto L20;
        if (r10 != 0) goto L20;
        if (r5 != 0) goto L20;
        boolean r14 = true;
    L21:
        int r15 = r10 + r5;
        if (r15 <= 0) goto L24;
        float r6 = r10 / r15;
    L28:
        Log.d("ThreadReadStateListener", r3 + ", has read count: " + r10 + " / " + r15);
        if (this.e == false) goto L31;
        float r8 = this.g;
    L32:
        q7b.a.C0280a r9 = q7b.a.a;
        Context r11 = (Context) r1.b(new ThreadReadStateListener$onParseEnd$readStateDrawable$1(r18));
        Intrinsics.checkNotNullParameter(r11, "context");
        Drawable r0 = null;
        if (r6 <= 0.0f) goto L37;
        float r16 = 0.125f;
        if (r6 >= 0.125f) goto L37;
    L46:
        StringBuilder r17 = new StringBuilder();
        r17.append(r16);
        r17.append('-');
        r17.append(r8);
        String r110 = r17.toString();
        q7b.a.C0280a r111 = q7b.a.a;
        WeakReference<Drawable> r112 = r111.get(r110);
        if (r112 == null) goto L49;
        r0 = r112.get();
    L49:
        if (r0 != null) goto L52;
        int r7 = UIUtils.dp2px(r11, r8);
        ReadStateView r20 = new ReadStateView(r11);
        r20.setLayoutParams(new ViewGroup.LayoutParams(r7, r7));
        r20.setProgress(r6);
        float r21 = r7 / UIUtils.dp2px(r11, 20.0f);
        float r113 = UIUtils.dp2px(r11, 7.825f * r21);
        float r114 = UIUtils.dp2px(r11, 1.85f * r21);
        float r22 = UIUtils.dp2px(r11, r21 * 5.0f);
        Log.i("ReadStateView", "OuterRadius: " + r113 + " Px,OuterWidth: " + r114 + " Px,InnerRadius: " + r22);
        r20.b = r113;
        r20.c = r114;
        r20.a = (int) r22;
        r20.invalidate();
        r20.measure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), View.MeasureSpec.makeMeasureSpec(r7, 1073741824));
        r20.layout(0, 0, r20.getMeasuredWidth(), r20.getMeasuredHeight());
        Bitmap r23 = Bitmap.createBitmap(r20.getMeasuredWidth(), r20.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        r20.draw(new Canvas(r23));
        BitmapDrawable r24 = new BitmapDrawable(r11.getResources(), r23);
        r111.put(r110, new WeakReference(r24));
        r0 = r24;
    L52:
        if (r0 != null) goto L54;
        return;
    L54:
        r0.setBounds(0, 0, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        SpannableStringBuilder r25 = new SpannableStringBuilder("\u200b");
        if (((Boolean) IMThemeExtend.s.b(new ThreadReadStateListener$onParseEnd$startMargin$1(r18))).booleanValue() == true) goto L57;
    L59:
        float r115 = 4.0f;
    L60:
        r25.setSpan(new q7b.b(r0, UIUtils.dp2px((Context) r1.b(new ThreadReadStateListener$onParseEnd$marginInPx$1(r18)), r115)), 0, 1, 33);
        final boolean r26 = r14;
        r25.setSpan(new ThreadReadStateListener$onParseEnd$readStateClickableSpan$1(this, r3, r26, r4, r18), 0, 1, 33);
        int r27 = com.ss.android.lark.coremd.utils.b.a;
        r19.append("\u2060");
        r19.append(r25);
        return;
    L57:
        if (((Boolean) r1.b(new ThreadReadStateListener$onParseEnd$startMargin$2(r18))).booleanValue() == false) goto L59;
        r115 = 0.0f;
    L37:
        r16 = 0.875f;
        if (r6 <= 0.875f) goto L43;
        if (r6 < 1.0f) goto L46;
    L43:
        if (r6 >= 0.0f) goto L45;
        Log.e("ReadStateDrawableUtil", "read state progress < 0");
        goto L52
    L45:
        r16 = r6;
        goto L46
    L31:
        r8 = zz7.b.f(16.0f);
        goto L32
    L24:
        if (r15 != 0) goto L61;
        if (r14 == false) goto L27;
        r6 = 0.0f;
        goto L28
    L27:
        r6 = 1.0f;
        goto L28
    L61:
        Log.e("ThreadReadStateListener", "error info: readCount=" + r10 + ",unReadCount=" + r5);
        return;
    L20:
        r14 = false;
        goto L21
    L11:
        r12 = this.d.i.isEnable("messenger.thread.read_receipt_myreply_opt");
        goto L12
    }
}
