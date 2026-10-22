package com.ss.android.lark.chat.message.menu;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.a1;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.select.g;
import com.ss.android.lark.widget.select.m;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static WeakReference<m> a;
    public static WeakReference<View> b;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.message.menu.a$a, reason: collision with other inner class name */
    public static final class C0099a implements m.d {
        public final /* synthetic */ Function3<CharSequence, Boolean, PartialReplyInfo.PartialContentRelativePosition, Unit> a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ m2b.a c;
        public final /* synthetic */ Function0<Unit> d;
        public final /* synthetic */ m e;
        public final /* synthetic */ LKUILightTextView f;
        public final /* synthetic */ int g;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.message.menu.a$a$a, reason: collision with other inner class name */
        public static final class C0100a implements u.c {
            public final /* synthetic */ m a;
            public final /* synthetic */ LKUILightTextView b;
            public final /* synthetic */ m2b.a c;
            public final /* synthetic */ Function3<CharSequence, Boolean, PartialReplyInfo.PartialContentRelativePosition, Unit> d;
            public final /* synthetic */ int e;
            public final /* synthetic */ int f;
            public final /* synthetic */ int g;
            public final /* synthetic */ int h;
            public final /* synthetic */ boolean i;
            public final /* synthetic */ int j;

            /* JADX INFO: renamed from: com.ss.android.lark.chat.message.menu.a$a$a$a, reason: collision with other inner class name */
            public static final class RunnableC0101a implements Runnable {
                public final /* synthetic */ m a;
                public final /* synthetic */ LKUILightTextView b;
                public final /* synthetic */ m2b.a c;
                public final /* synthetic */ Function3<CharSequence, Boolean, PartialReplyInfo.PartialContentRelativePosition, Unit> d;

                /* JADX WARN: Multi-variable type inference failed */
                public RunnableC0101a(m r1, LKUILightTextView r2, m2b.a r3, Function3<? super CharSequence, ? super Boolean, ? super PartialReplyInfo.PartialContentRelativePosition, Unit> r4) {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                }

                public final void a() {
                    WeakReference<m> r0 = a.a;
                    if (r0 == null) goto L5;
                    m r1 = r0.get();
                L6:
                    boolean r3 = true;
                    if (r1 != this.a) goto L9;
                    boolean r2 = true;
                L10:
                    WeakReference<View> r4 = a.b;
                    if (r4 == null) goto L13;
                    View r5 = r4.get();
                L15:
                    if (r5 == this.b) goto L18;
                    r3 = false;
                L18:
                    if (r2 == true) goto L22;
                    if (r3 == false) goto L22;
                    this.a.f();
                L23:
                    if (r2 == false) goto L29;
                    m2b.a r6 = this.c;
                    if (r6 == null) goto L27;
                    r6.v8(null);
                L27:
                    this.d.invoke(BuildConfig.FLAVOR, Boolean.FALSE, PartialReplyInfo.PartialContentRelativePosition.UNKNOWN);
                    return;
                L29:
                    return;
                L22:
                    this.a.a();
                    goto L23
                L13:
                    r5 = null;
                    goto L15
                L9:
                    r2 = false;
                    goto L10
                L5:
                    r1 = null;
                    goto L6
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final void a() {
                UICallbackExecutor.post(new RunnableC0101a(this.a, this.b, this.c, this.d));
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final void b() {
                this.a.b();
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final void c() {
                this.a.f();     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                Log.e("IMTextSelectHelperUtil", "dismiss select window failed, error=" + e.getMessage());
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final void d(int[] r2) {
                this.a.g(r2);
            }

            @Override // com.ss.android.lark.chat.utils.u.c
            public final a1 e(boolean r9) {
                if (r9 == true) goto L4;
                g r10 = this.a.c();
                if (r10 != null) goto L10;
                return null;
            L10:
                return new a1(r10.b, r10.c, r10.d, r10.e, r10.f, this.j);
            L4:
                return new a1(this.e, this.f, this.g, this.h, this.i, this.j);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0100a(m r1, LKUILightTextView r2, m2b.a r3, Function3<? super CharSequence, ? super Boolean, ? super PartialReplyInfo.PartialContentRelativePosition, Unit> r4, int r5, int r6, int r7, int r8, boolean r9, boolean r10, int r11) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
                this.g = r7;
                this.h = r8;
                this.i = r9;
                this.j = r11;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0099a(Function3<? super CharSequence, ? super Boolean, ? super PartialReplyInfo.PartialContentRelativePosition, Unit> r1, boolean r2, m2b.a r3, Function0<Unit> r4, m r5, LKUILightTextView r6, int r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void a(g r21) {
            Intrinsics.checkNotNullParameter(r21, "<destruct>");
            CharSequence r2 = r21.a;
            int r15 = r21.b;
            int r14 = r21.c;
            int r13 = r21.d;
            int r11 = r21.e;
            boolean r12 = r21.f;
            boolean r10 = r21.g;
            Message.PartialReplyInfo.PartialContentRelativePosition r0 = r21.h;
            C0100a r9 = new C0100a(this.e, this.f, this.c, this.a, r15, r14, r13, r11, r12, r10, this.g);
            u r3 = u.a.a;
            monitor-enter(r3);
            r3.c();     // Catch: Throwable -> L11
            r3.a = r9;     // Catch: Throwable -> L11
            monitor-exit(r3);
            Function3<CharSequence, Boolean, PartialReplyInfo.PartialContentRelativePosition, Unit> r4 = this.a;
            Boolean r5 = Boolean.valueOf(this.b);
            PartialReplyInfo.PartialContentRelativePosition.a r6 = PartialReplyInfo.PartialContentRelativePosition.Companion;
            int r1 = r0.getValue();
            r6.getClass();
            r4.invoke(r2, r5, PartialReplyInfo.PartialContentRelativePosition.a.a(r1));
            m2b.a r7 = this.c;
            if (r7 == null) goto L9;
            r7.v8(new int[]{r15, r14, r13});
        L9:
            r3.c = r10;
            r3.d = true;
            this.d.invoke();
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public static final class b implements m.c {
        public b() {
        }

        public final /* synthetic */ void a() {
        }

        public final void b() {
            u r0 = u.a.a;
            monitor-enter(r0);
            r0.c();     // Catch: Throwable -> L8
            r0.a = null;     // Catch: Throwable -> L8
            monitor-exit(r0);
            r0.e();
            r0.g = 1;
            r0.f = true;
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public static MovableView a(View r3) {
        if ((r3 instanceof MovableView) == false) goto L7;
        return (MovableView) r3;
    L7:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L18;
        MovableView r2 = a(r4.getChildAt(r1));
        if (r2 != null) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return r2;
    L18:
        return null;
    L14:
        return null;
    }

    @JvmStatic
    public static final boolean b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        WeakReference<View> r0 = b;
        if (r0 == null) goto L33;
        View r1 = r0.get();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r5, r1) == true) goto L27;
        Object r2 = r1.getParent();
    L11:
        if ((r2 instanceof View) == false) goto L16;
        if (Intrinsics.areEqual(r2, r5) == true) goto L14;
        r2 = ((View) r2).getParent();
        goto L11
    L14:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L27;
        Object r6 = r5.getParent();
    L20:
        if ((r6 instanceof View) == false) goto L25;
        if (Intrinsics.areEqual(r6, r1) == true) goto L23;
        r6 = ((View) r6).getParent();
        goto L20
    L23:
        boolean r7 = true;
    L26:
        if (r7 == true) goto L27;
        return false;
    L25:
        r7 = false;
        goto L26
    L16:
        r3 = false;
    L27:
        return true;
    L33:
        return false;
    }

    @JvmStatic
    public static final void c(LKUILightTextView r9, m2b.a r10, boolean r11, Function3<? super CharSequence, ? super Boolean, ? super PartialReplyInfo.PartialContentRelativePosition, Unit> r12, Function0<Unit> r13, Integer r14, IntRange r15) {
        Intrinsics.checkNotNullParameter(r9, "selectableView");
        Intrinsics.checkNotNullParameter(r12, "changeCopyTextAction");
        Intrinsics.checkNotNullParameter(r13, "onTextSelectedAction");
        b = new WeakReference(r9);
        if (r14 == null) goto L5;
        int r16 = r14.intValue();
    L6:
        com.ss.android.lark.widget.select.b r1 = new com.ss.android.lark.widget.select.b(r9);
        if (r10 == null) goto L9;
        FragmentActivity r2 = r10.getContext();
    L10:
        m.a r0 = new m.a(r1, r2);
        r0.c = r16;
        r0.d = UIHelper.dp2px(15.0f);
        if (r10 == null) goto L13;
        com.ss.android.lark.coremd.clickcompat.c r17 = (com.ss.android.lark.coremd.clickcompat.c) r10.d0(com.ss.android.lark.coremd.clickcompat.c.class);
    L13:
        m r18 = new m(r0);
        a = new WeakReference(r18);
        int[] r3 = new int[2];
        r9.getLocationOnScreen(r3);
        r18.m = new C0099a(r12, r11, r10, r13, r18, r9, r3[0]);
        r18.n = new b();
        if (r15 == null) goto L16;
        r18.l(r15.getFirst(), r15.getLast() + 1);
        return;
    L16:
        r18.show();
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r16 = v2c.a.b(r9.getContext(), 2131105548);
        goto L6
    }

    public static /* synthetic */ void d(LKUILightTextView r7, m2b.a r8, boolean r9, Function3 r10, Function0 r11, Integer r12, int r13) {
        if ((r13 & 32) == 0) goto L5;
        r12 = null;
    L5:
        c(r7, r8, r9, r10, r11, r12, null);
    }
}
