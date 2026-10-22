package com.larus.bmhome.chat.detail.code.preview;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public static final m a = null;
    public static a b;
    public static Runnable c;
    public static final b d = null;

    public static final class a {
        public final AbsWebFragment a;
        public final String b;
        public final String c;
        public final WeakReference<FragmentActivity> d;
        public final int e;
        public CodePreviewStatus f;
        public final String g;

        public a(AbsWebFragment r3, String r4, String r5, WeakReference r6, int r7, String r8) {
            CodePreviewStatus r0 = CodePreviewStatus.LOADING;
            Intrinsics.checkNotNullParameter(r3, "webFragment");
            Intrinsics.checkNotNullParameter(r4, "codeId");
            Intrinsics.checkNotNullParameter(r5, "messageId");
            Intrinsics.checkNotNullParameter(r6, "activityRef");
            Intrinsics.checkNotNullParameter(r0, "status");
            Intrinsics.checkNotNullParameter(r8, "conversationId");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r0;
            this.g = r8;
        }
    }

    public static final class b implements nf9.c {
        public b() {
        }

        public final void B(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public final void C(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public final void A(Message r4) {
            Intrinsics.checkNotNullParameter(r4, "message");
            m r0 = m.a;
            a r1 = m.b;
            if (r1 == null) goto L6;
            String r2 = r1.c;
            if (r2 == null) goto L6;
        L7:
            r0.getClass();
            m.b(r2);
            FLogger.a.d("PreloadCodeWebViewManager", "onStreamEnd, conversationId[" + r4.getConversationId() + "], messageId[" + r4.getMessageId() + ']');
            Runnable r5 = m.c;
            if (r5 == null) goto L10;
            r5.run();
        L10:
            m.c = null;
            return;
        L6:
            r2 = "";
            goto L7
        }
    }

    public m() {
    }

    static {
        a = new m();
        d = new b();
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "messageId");
        a r1 = b;
        if (r1 == null) goto L7;
        String r2 = r1.g;
        if (r2 == null) goto L7;
        int r3 = com.larus.im.d.a;
        com.larus.im.internal.stream.b.a.e(r2, d);
    L7:
        a r4 = b;
        if (r4 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r4.c, r8) == true) goto L13;
        return;
    L13:
        Lazy r5 = i.a;
        String r6 = r4.b;
        Intrinsics.checkNotNullParameter(r6, "codeId");
        ((Map) i.b.getValue()).remove(r6);
        FragmentActivity r7 = r4.d.get();     // Catch: Exception -> L32
        if (r7 != null) goto L18;
    L34:
        b = null;
        FLogger.a.i("PreloadCodeWebViewManager", "destroyByMessageId, messageId[" + r8 + ']');
        return;
    L18:
        if (r7.isFinishing() == true) goto L34;
        if (r7.isDestroyed() == true) goto L34;
        r7.getSupportFragmentManager().beginTransaction().remove(r4.a).commitAllowingStateLoss();     // Catch: Exception -> L32
        View r9 = a(r7.getWindow());     // Catch: Exception -> L32
        if ((r9 instanceof ViewGroup) == false) goto L25;
        ViewGroup r10 = (ViewGroup) r9;     // Catch: Exception -> L32
    L26:
        if (r10 == null) goto L28;
        final View r11 = r10.findViewById(r4.e);     // Catch: Exception -> L32
    L29:
        if (r11 == null) goto L34;
        r10.post(new k(r11));     // Catch: Exception -> L32
        goto L34
    L28:
        r11 = null;
        goto L29
    L25:
        r10 = null;
    L32:
        e = move-exception;
        FLogger.a.e("PreloadCodeWebViewManager", "destroyEntry failed, codeId[" + r4.b + ']', e);
        goto L34
    }
}
