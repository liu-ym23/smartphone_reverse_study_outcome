package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v1 implements com.bytedance.ee.bear.lark.dependency.h0 {
    public static a a;

    public static class a implements com.bytedance.ee.bear.lark.dependency.h0.a {
        public final boc.b a;
        public String b;

        public final void c() {
            int r0 = com.suite.lark.emm.impl.a.a;
            com.suite.lark.emm.impl.a.a.a().getClass();
            SCClipboardProvider.a().O0(SCClipboardScene.SCENE_DISABLE_COPY);
        }

        public final Boolean f() {
            boc.b r0 = this.a;
            if (r0 != null) goto L7;
            tt5.a.h("SecurityClipboardImpl", "hasPrimaryClip... iscClipboardManager is null");
            return Boolean.FALSE;
        L7:
            return Boolean.valueOf(r0.f());
        }

        public final void i() {
            int r0 = com.suite.lark.emm.impl.a.a;
            com.suite.lark.emm.impl.a.a.a().getClass();
            SCClipboardProvider.a().O0(n());
        }

        public final SCClipboardScene n() {
            if (TextUtils.isEmpty(this.b) == true) goto L5;
            SCClipboardScene r0 = SCClipboardScene.SCENE_ENCRYPT;
            r0.setParam(this.b);
            return r0;
        L5:
            return SCClipboardScene.SCENE_DEFAULT;
        }

        public final Boolean b() {
            if (n() != SCClipboardScene.SCENE_ENCRYPT) goto L5;
            boolean r0 = true;
        L7:
            return Boolean.valueOf(r0);
        L5:
            r0 = false;
            goto L7
        }

        public a(boc.b r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            this.b = r2;
            boc.b r3 = this.a;
            if (r3 == null) goto L5;
            r3.Q0(n());
            return;
        L5:
            tt5.a.h("SecurityClipboardImpl", "setEncryptId... iscClipboardManager is null");
        }

        public final void d(ClipboardManager.OnPrimaryClipChangedListener r2) {
            boc.b r0 = this.a;
            if (r0 != null) goto L6;
            tt5.a.h("SecurityClipboardImpl", "removePrimaryClipChangedListener... iscClipboardManager is null");
            return;
        L6:
            r0.d(r2);
        }

        public final void e(ClipboardManager.OnPrimaryClipChangedListener r2) {
            boc.b r0 = this.a;
            if (r0 != null) goto L6;
            tt5.a.h("SecurityClipboardImpl", "addPrimaryClipChangedListener... iscClipboardManager is null");
            return;
        L6:
            r0.e(r2);
        }

        public final void j(String r3) {
            SCClipboardScene r0 = SCClipboardScene.SCENE_DEFAULT;
            if (TextUtils.isEmpty(r3) == true) goto L5;
            r0 = SCClipboardScene.SCENE_ENCRYPT;
            r0.setParam(r3);
        L5:
            int r4 = com.suite.lark.emm.impl.a.a;
            com.suite.lark.emm.impl.a.a.a().getClass();
            SCClipboardProvider.a().O0(r0);
        }

        public final ClipData l(Token r4) {
            boc.b r0 = this.a;
            if (r0 != null) goto L11;
            tt5.a.h("SecurityClipboardImpl", "getPrimaryClip... iscClipboardManager is null");
            return null;
        L11:
            return r0.T0(r4);
        L8:
            e = move-exception;
            tt5.a.f("SecurityClipboardImpl", e, false);
            return null;
        }

        public final boolean h(ClipData r2, Token r3) {
            return m(r2, true, r3);
        }

        public final ClipData k(String r4, Token r5) {
            if (this.a != null) goto L15;
            tt5.a.h("SecurityClipboardImpl", "getPrimaryClip... iscClipboardManager is null");
            return null;
        L15:
        L12:
            e = move-exception;
            tt5.a.f("SecurityClipboardImpl", e, false);
            return null;
        L7:
            if (TextUtils.isEmpty(r4) == false) goto L9;
            SCClipboardScene r6 = SCClipboardScene.SCENE_DEFAULT;     // Catch: SensitiveAPIException -> L12
        L10:
            this.a.Q0(r6);     // Catch: SensitiveAPIException -> L12
            ClipData r7 = this.a.T0(r5);     // Catch: SensitiveAPIException -> L12
            this.a.Q0(n());     // Catch: SensitiveAPIException -> L12
            return r7;
        L9:
            SCClipboardScene r0 = SCClipboardScene.SCENE_ENCRYPT;     // Catch: SensitiveAPIException -> L12
            r0.setParam(r4);     // Catch: SensitiveAPIException -> L12
            r6 = r0;
            goto L10
        }

        public final boolean m(ClipData r5, boolean r6, Token r7) {
            boc.b r0 = this.a;
            boolean r2 = false;
            if (r0 != null) goto L6;
            tt5.a.h("SecurityClipboardImpl", "setPrimaryClip... iscClipboardManager is null");
            return false;
        L6:
            if (r6 == true) goto L15;
            r0.Q0(SCClipboardScene.SCENE_SYSTEM);
        L15:
            this.a.M0(r5, r7);     // Catch: SensitiveAPIException -> L10
            r2 = true;
        L12:
            if (r6 == true) goto L14;
            this.a.Q0(n());
        L14:
            return r2;
        L10:
            e = move-exception;
            tt5.a.f("SecurityClipboardImpl", e, false);
            goto L12
        }

        public final boolean g(String r4, ClipData r5, boolean r6, Token r7) {
            boolean r2 = false;
            if (this.a != null) goto L7;
            tt5.a.h("SecurityClipboardImpl", "setPrimaryClip... iscClipboardManager is null");
            return false;
        L7:
            if (TextUtils.isEmpty(r4) == true) goto L11;
            if (r6 == false) goto L11;
            SCClipboardScene r8 = SCClipboardScene.SCENE_ENCRYPT;
            r8.setParam(r4);
        L12:
            this.a.Q0(r8);
            this.a.M0(r5, r7);     // Catch: SensitiveAPIException -> L15
            r2 = true;
        L17:
            this.a.Q0(n());
            return r2;
        L15:
            e = move-exception;
            tt5.a.f("SecurityClipboardImpl", e, false);
        L11:
            r8 = SCClipboardScene.SCENE_DEFAULT;
            goto L12
        }
    }

    public v1() {
    }

    public final com.bytedance.ee.bear.lark.dependency.h0.a a() {
        if (a != null) goto L6;
        int r0 = com.suite.lark.emm.impl.a.a;
        com.suite.lark.emm.impl.a.a.a().getClass();
        a = new a(SCClipboardProvider.a());
    L6:
        return a;
    }
}
