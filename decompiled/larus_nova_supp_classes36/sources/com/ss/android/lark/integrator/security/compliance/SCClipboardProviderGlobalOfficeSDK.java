package com.ss.android.lark.integrator.security.compliance;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.ActionMode;
import android.view.Menu;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import com.suite.lark.emm.impl.clipboard.utils.ServiceHookNPEFixHelper;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class SCClipboardProviderGlobalOfficeSDK implements com.suite.lark.emm.impl.clipboard.userscope.export.a {
    public final doc.d a;
    public final Lazy b;
    public final a c;

    public static final class a implements boc.b {
        public SCClipboardScene a;
        public final /* synthetic */ SCClipboardProviderGlobalOfficeSDK b;

        /* JADX INFO: renamed from: com.ss.android.lark.integrator.security.compliance.SCClipboardProviderGlobalOfficeSDK$a$a, reason: collision with other inner class name */
        public static final class RunnableC0121a implements Runnable {
            public static final RunnableC0121a a = null;

            static {
                a = new RunnableC0121a();
            }

            public RunnableC0121a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.suite.lark.emm.impl.clipboard.adpater.a.b.wa();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.suite.lark.emm.impl.clipboard.adpater.a.b.wa();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final boolean L0() {
            return this.b.a.L0();
        }

        public final boolean f() {
            if (SCClipboardProvider.b() == true) goto L33;
        L8:
            ClipboardManager r0 = (ClipboardManager) this.b.b.getValue();
            ArrayList r11 = new ArrayList();
            Object[] r13 = new Object[0];
            f06.b r14 = new f06.b();
            g06.a r3 = (g06.a) ApiHookConfig.b.get(101805);
            if (r3 == null) goto L11;
            f06.a[] r4 = r3.i;
        L12:
            f06.a[] r10 = r4;
            int r9 = r10.length;
            int r8 = 0;
        L14:
            if (r8 >= r9) goto L21;
            f06.a r7 = r10[r8];
            int r18 = r8;
            int r19 = r9;
            f06.a[] r20 = r10;
            f06.d r5 = r7.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r0, r13, "boolean", r14);     // Catch: Exception -> L32
            if (r5.a == true) goto L23;
            r11.add(r7);     // Catch: Exception -> L32
        L23:
            if (r5.a == false) goto L25;
            boolean r1 = ((Boolean) r5.b).booleanValue();
        L26:
            Log.i("SCClipboardManager", "handleHasPrimaryClip system:" + r1);
            if (r1 == false) goto L30;
            return true;
        L30:
            boolean r2 = com.suite.lark.emm.impl.clipboard.adpater.a.b.E6();
            Log.i("SCClipboardManager", "handleHasPrimaryClip inner:" + r2);
            return r2;
        L25:
            r1 = r0.hasPrimaryClip();
        L20:
            r8 = r18 + 1;
            r9 = r19;
            r10 = r20;
            goto L14
        L21:
            r5 = new f06.d(false, null);
            goto L23
        L11:
            r4 = ApiHookConfig.d;
            goto L12
        L33:
            com.suite.lark.emm.impl.clipboard.utils.d.a((ClipboardManager) this.b.b.getValue());     // Catch: Exception -> L6
        L6:
            e = move-exception;
            Log.e("SCClipboardManager", "handleHasPrimaryClip forceReportWebviewClipChanged failed: " + e);
            goto L8
        }

        public a(SCClipboardProviderGlobalOfficeSDK r1) {
            this.b = r1;
        }

        public final void N0(Menu r2) {
            Intrinsics.checkNotNullParameter(r2, "menu");
            if (r2 != null) goto L5;
            Lazy r3 = TextViewMenuUtilsKt.a;
            return;
        L5:
            TextViewMenuUtilsKt.c(r2, 4);
        }

        public final void O0(SCClipboardScene r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.b.a.Ob(r2);
        }

        public final void Q0(SCClipboardScene r4) {
            Intrinsics.checkNotNullParameter(r4, "scene");
            Log.i("SCClipboardManager", "setScene: " + r4);
            if (r4 == SCClipboardScene.SCENE_ENCRYPT) goto L5;
        L7:
            this.a = r4;
            return;
        L5:
            if ((r4.getParam() instanceof String) == true) goto L7;
            Log.e("SCClipboardManager", "encrypt scene but wrong param: " + r4.getParam() + ", ignore scene");
            r4 = null;
            goto L7
        }

        public final ActionMode.Callback R0(ActionMode.Callback r3) {
            if (r3 != null) goto L4;
            return r3;
        L4:
            Lazy r0 = TextViewMenuUtilsKt.a;
            Intrinsics.checkNotNullParameter(r3, "original");
            if (com.suite.lark.emm.impl.clipboard.utils.a.a() == true) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == false) goto L11;
            return r3;
        L11:
            return TextViewMenuUtilsKt.d(r3, true);
        L7:
            coc.f.a.b.b();
            r1 = false;
            goto L8
        }

        public final void S0(Menu r2) {
            Intrinsics.checkNotNullParameter(r2, "menu");
            TextViewMenuUtilsKt.b(r2, 3);
        }

        public final ClipData T0(Token r3) {
            Intrinsics.checkNotNullParameter(r3, "token");
            this.b.a.Ob(this.a);
            return a(r3);
        L5:
            e = move-exception;
            this.b.a.wa();
            throw e;
        }

        public final ClipData a(Token r8) {
            ClipData r9 = qf7.a.a.d((ClipboardManager) this.b.b.getValue(), r8);
            if (r9 != null) goto L5;
            boolean r0 = true;
        L6:
            com.suite.lark.emm.impl.clipboard.adpater.a r1 = com.suite.lark.emm.impl.clipboard.adpater.a.b;
            if (r1.b(r9) == false) goto L13;
            if (r1.a(r9) == true) goto L13;
            Log.i("SCClipboardManager", "handlePrimaryClipGet: system1, null?" + r0);
            return r9;
        L13:
            if (r1.xb(r9) == 0) goto L15;
            ClipData r2 = r1.Ma();
            if (SCClipboardProvider.b() == false) goto L28;
            ThreadUtils.runOnUIThread(b.a, 50);
        L29:
            if (r2 == null) goto L32;
            Log.i("SCClipboardManager", "handlePrimaryClipGet: inner");
            return r2;
        L32:
            Log.i("SCClipboardManager", "handlePrimaryClipGet: system3, null?" + r0);
            return r9;
        L28:
            r1.wa();
            goto L29
        L15:
            if (SCClipboardProvider.b() == false) goto L17;
            ThreadUtils.runOnUIThread(RunnableC0121a.a, 50);
        L18:
            if (r9 == null) goto L20;
        L23:
            Log.i("SCClipboardManager", "handlePrimaryClipGet: system2, null?" + r0);
            return r9;
        L20:
            if (r1.E6() == false) goto L23;
            Log.i("SCClipboardManager", "handlePrimaryClipGet: blank");
            return ClipData.newPlainText("", " ");
        L17:
            r1.wa();
            goto L18
        L5:
            r0 = false;
            goto L6
        }

        public final void d(ClipboardManager.OnPrimaryClipChangedListener r2) {
            this.b.a.d(r2);
        }

        public final void e(ClipboardManager.OnPrimaryClipChangedListener r2) {
            this.b.a.e(r2);
        }

        public final void M0(ClipData r3, Token r4) {
            Intrinsics.checkNotNullParameter(r3, "clip");
            Intrinsics.checkNotNullParameter(r4, "token");
            this.b.a.Ob(this.a);
            if (this.a != SCClipboardScene.SCENE_SYSTEM_ONCE) goto L10;
            this.a = null;
        L10:
            b(r3, r4);     // Catch: SensitiveAPIException -> L7
            return;
        L7:
            e = move-exception;
            this.b.a.wa();
            throw e;
        }

        public final ActionMode.Callback P0(ActionMode.Callback r2, Boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "original");
            if (r3 == null) goto L5;
            boolean r4 = r3.booleanValue();
        L7:
            return TextViewMenuUtilsKt.d(r2, r4);
        L5:
            r4 = true;
            goto L7
        }

        public final void b(ClipData r5, Token r6) {
            com.suite.lark.emm.impl.clipboard.adpater.a r0 = com.suite.lark.emm.impl.clipboard.adpater.a.b;
            if (r0.b(r5) == true) goto L5;
        L15:
            Log.i("SCClipboardManager", "handlePrimaryClipSet: system");
            qf7.a.a.a((ClipboardManager) this.b.b.getValue(), r5, r6);
            return;
        L5:
            if (r0.a(r5) == false) goto L15;
            int r1 = r0.Ua();
            if (r1 != 0) goto L10;
            r0.L3();
            r0.wa();
            Log.i("SCClipboardManager", "handlePrimaryClipSet: system");
            qf7.a.a.a((ClipboardManager) this.b.b.getValue(), r5, r6);
            return;
        L10:
            if (r1 == 2) goto L12;
            Log.i("SCClipboardManager", "handlePrimaryClipSet: inner");
            r0.Ze(r5);
            r0.Sd();
            r0.wa();
            return;
        L12:
            Log.i("SCClipboardManager", "handlePrimaryClipSet: disable set");
        }
    }

    public final boc.b getClipboardManager() {
        return this.c;
    }

    @Inject
    public SCClipboardProviderGlobalOfficeSDK(doc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "clipboardService");
        this.a = r2;
        this.b = LazyKt.lazy(SCClipboardProviderGlobalOfficeSDK$clipboardManager$2.INSTANCE);
        new ServiceHookNPEFixHelper();
        this.c = new a(this);
    }
}
