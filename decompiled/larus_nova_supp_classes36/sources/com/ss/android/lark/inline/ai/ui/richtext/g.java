package com.ss.android.lark.inline.ai.ui.richtext;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public final LarkWebView a;
    public final wlb.e b;
    public final NSCLarkWebView.b c;
    public at5.j d;
    public AIPreviewData e;
    public final Handler f;
    public amb.d g;
    public final h h;
    public InterfaceC0111g i;

    public final class a implements at5.f<AIConversation, LarkWebView> {
        public final /* synthetic */ g a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public a(g r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            AIConversation r5 = (AIConversation) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            Log.i("RichtextPreviewBridge", "biz.render.AIContent.complete: " + r5);
            if (r5 == null) goto L8;
            InterfaceC0111g r6 = this.a.i;
            if (r6 == null) goto L9;
            r6.a(r5);
            return;
        L9:
            return;
        }
    }

    public final class b implements at5.f<com.ss.android.lark.inline.ai.ui.richtext.d, LarkWebView> {
        public final /* synthetic */ g a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public b(g r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            com.ss.android.lark.inline.ai.ui.richtext.d r5 = (com.ss.android.lark.inline.ai.ui.richtext.d) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            if (r5 == null) goto L10;
            String r6 = r5.a;
            if (r6 == null) goto L10;
            wlb.e r7 = this.a.b;
            if (r7 == null) goto L12;
            r7.f(r6);
            return;
        L12:
            return;
        L10:
            Log.e("RichtextPreviewBridge", "open link but url is null！");
        }
    }

    public final class c implements at5.f<AIConversation, LarkWebView> {
        public final /* synthetic */ g a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public c(g r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            Log.i("RichtextPreviewBridge", "biz.render.AIContent: " + ((AIConversation) r1) + " , mCurrentAIPreviewData: " + this.a.e);
            g r5 = this.a;
            r5.d = r2;
            r5.f.removeCallbacks(r5.h);
            g r6 = this.a;
            AIPreviewData r7 = r6.e;
            if (r7 == null) goto L6;
            r6.a(r7);
            this.a.e = null;
            return;
        }
    }

    public final class d implements at5.f<com.ss.android.lark.inline.ai.ui.richtext.e, LarkWebView> {
        public final boolean shouldRunInUIThread() {
            return true;
        }

        public d() {
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            com.ss.android.lark.inline.ai.ui.richtext.e r5 = (com.ss.android.lark.inline.ai.ui.richtext.e) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            if (r5 == null) goto L10;
            String r6 = r5.a;
            if (r6 == null) goto L10;
            if (r4 != null) goto L9;
            Log.e("RichtextPreviewBridge", "open profile but context is null！");
            return;
        L9:
            Log.i("RichtextPreviewBridge", "open profile userId is ".concat(r6));
            ContactSource.a r7 = new ContactSource.a();
            com.ss.android.lark.profile.utils.a.a(r4.getContext(), r6, new ContactSource(r7));
            return;
        L10:
            Log.e("RichtextPreviewBridge", "open profile but userId is null！");
        }
    }

    public static final class e {
    }

    public final class f implements at5.f<RoadsterData, LarkWebView> {
        public final /* synthetic */ g a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public f(g r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            RoadsterData r5 = (RoadsterData) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            StringBuilder r6 = new StringBuilder("onSendMessageToDocs, data = ");
            String r7 = null;
            if (r5 == null) goto L5;
            String r8 = r5.getData();
        L6:
            r6.append(r8);
            Log.i("RichtextPreviewBridge", r6.toString());
            wlb.e r9 = this.a.b;
            if (r9 == null) goto L12;
            if (r5 == null) goto L10;
            r7 = r5.getData();
        L10:
            r9.t(String.valueOf(r7));
            return;
        L12:
            return;
        L5:
            r8 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.ui.richtext.g$g, reason: collision with other inner class name */
    public interface InterfaceC0111g {
        void a(AIConversation r1);
    }

    static {
    }

    public final void a(AIPreviewData r4) {
        Log.i("RichtextPreviewBridge", "renderAIContent  aiPreviewData = " + r4 + "  ,   mCallback = " + this.d);
        at5.j r0 = this.d;
        if (r0 == null) goto L7;
        if (r4 == null) goto L9;
        if (r0 == null) goto L10;
        r0.a(Status.SUCCESS, GsonProtectorUtils.toJson(new Gson(), r4));
        return;
    L10:
        return;
    L9:
        return;
    L7:
        this.e = r4;
    }

    public g(LarkWebView r2, wlb.e r3, RichtextPreviewWebview.d r4) {
        Intrinsics.checkNotNullParameter(r2, "mWebview");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.f = new Handler(Looper.getMainLooper());
        this.h = h.a;
    }
}
