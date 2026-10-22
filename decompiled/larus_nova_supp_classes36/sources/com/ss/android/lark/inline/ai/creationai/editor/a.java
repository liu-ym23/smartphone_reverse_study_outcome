package com.ss.android.lark.inline.ai.creationai.editor;

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
public final class a {
    public final LarkWebView a;
    public final vlb.b b;
    public at5.j c;
    public AIPreviewData d;
    public final Handler e;
    public at5.j f;
    public at5.j g;
    public final com.ss.android.lark.inline.ai.creationai.editor.b h;
    public i i;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.creationai.editor.a$a, reason: collision with other inner class name */
    public final class C0102a implements at5.f<AIConversation, LarkWebView> {
        public final /* synthetic */ a a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public C0102a(a r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            AIConversation r5 = (AIConversation) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            Log.i("CreationAIEditorBridge", "biz.creationAI.renderComplete: " + r5);
            if (r5 == null) goto L8;
            i r6 = this.a.i;
            if (r6 == null) goto L9;
            r6.a(r5);
            return;
        L9:
            return;
        }
    }

    public final class b implements at5.f<LinkInfo, LarkWebView> {
        public final /* synthetic */ a a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            LinkInfo r5 = (LinkInfo) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            if (r5 == null) goto L10;
            String r6 = r5.getUrl();
            if (r6 == null) goto L10;
            vlb.b r7 = this.a.b;
            if (r7 == null) goto L12;
            r7.f(r6);
            return;
        L12:
            return;
        L10:
            Log.e("CreationAIEditorBridge", "open link but url is null！");
        }
    }

    public final class c implements at5.f<AIConversation, LarkWebView> {
        public final /* synthetic */ a a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public c(a r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            Log.i("CreationAIEditorBridge", "biz.creationAI.render: " + ((AIConversation) r1) + " , mCurrentAIPreviewData: " + this.a.d);
            a r5 = this.a;
            r5.c = r2;
            r5.e.removeCallbacks(r5.h);
            a r6 = this.a;
            AIPreviewData r7 = r6.d;
            if (r7 == null) goto L6;
            r6.a(r7);
            this.a.d = null;
            return;
        }
    }

    public final class d implements at5.f<ProfileModel, LarkWebView> {
        public final boolean shouldRunInUIThread() {
            return true;
        }

        public d() {
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            ProfileModel r5 = (ProfileModel) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            if (r5 == null) goto L10;
            String r6 = r5.getUserId();
            if (r6 == null) goto L10;
            if (r4 != null) goto L9;
            Log.e("CreationAIEditorBridge", "open profile but context is null！");
            return;
        L9:
            Log.i("CreationAIEditorBridge", "open profile userId is ".concat(r6));
            ContactSource.a r7 = new ContactSource.a();
            com.ss.android.lark.profile.utils.a.a(r4.getContext(), r6, new ContactSource(r7));
            return;
        L10:
            Log.e("CreationAIEditorBridge", "open profile but userId is null！");
        }
    }

    public static final class e {
    }

    public final class f implements at5.f<Object, LarkWebView> {
        public final /* synthetic */ a a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public f(a r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            Log.i("CreationAIEditorBridge", "onSendMessageToDocs, data ");
            vlb.b r5 = this.a.b;
            if (r5 == null) goto L6;
            r5.i(r1);
            return;
        }
    }

    public final class g implements at5.f<LoggerMessage, LarkWebView> {
        public final boolean shouldRunInUIThread() {
            return true;
        }

        public g() {
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            LoggerMessage r5 = (LoggerMessage) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            if (r5 == null) goto L5;
            String r6 = r5.getLogMessage();
        L6:
            Log.i("CreationAIEditorBridge", r6);
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public final class h implements at5.f<String, LarkWebView> {
        public final /* synthetic */ a a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public h(a r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            String r5 = (String) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            Log.i("CreationAIEditorBridge", "biz.creationAI.sendMessageToPreviewComponent, data ");
            this.a.f = r2;
        }
    }

    public interface i {
        void a(AIConversation r1);
    }

    public final class j implements at5.f<String, LarkWebView> {
        public final /* synthetic */ a a;

        public final boolean shouldRunInUIThread() {
            return true;
        }

        public j(a r1) {
            this.a = r1;
        }

        public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            Log.i("CreationAIEditorBridge", "ResetHandler, data = " + ((String) r1));
            this.a.g = r2;
        }
    }

    static {
    }

    public final void a(AIPreviewData r4) {
        Log.i("CreationAIEditorBridge", "renderAIContent  aiPreviewData = " + r4 + "  ,   mCallback = " + this.c);
        at5.j r0 = this.c;
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
        this.d = r4;
    }

    public a(LarkWebView r1, vlb.b r2, CreationAIEditorWebview.d r3) {
        Intrinsics.checkNotNullParameter(r1, "mWebview");
        this.a = r1;
        this.b = r2;
        this.e = new Handler(Looper.getMainLooper());
        this.h = com.ss.android.lark.inline.ai.creationai.editor.b.a;
    }
}
