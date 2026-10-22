package com.ss.android.lark.flow.group;

import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.flow.group.page.FlowQRCodeGroupCardActivity;
import com.ss.android.lark.flow.group.page.FlowQRCodeGroupCardActivity$onCreate$1$onJoinGroupButtonClick$1;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowJoinGroupChatUtil {
    public static final int a = 0;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/flow/group/FlowJoinGroupChatUtil$CallbackWrap;", "Lcom/ss/android/lark/member_manage/export/callback/IJoinGroupCallback;", "callback", "<init>", "(Lcom/ss/android/lark/member_manage/export/callback/IJoinGroupCallback;)V", "getCallback", "()Lcom/ss/android/lark/member_manage/export/callback/IJoinGroupCallback;", "sendApplySuccess", "", "joinGroupChatSuccess", "chatId", "", "onError", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "onSendApplyError", "onCancelSendApply", "onShowSendApplyDialog", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class CallbackWrap implements IJoinGroupCallback {
        private final IJoinGroupCallback callback;

        public static final class a implements Runnable {
            public final /* synthetic */ CallbackWrap a;
            public final /* synthetic */ String b;

            public a(CallbackWrap r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r0 = this.a.getCallback();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.joinGroupChatSuccess(this.b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ CallbackWrap a;

            public b(CallbackWrap r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r0 = this.a.getCallback();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.onCancelSendApply();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ CallbackWrap a;
            public final /* synthetic */ ErrorResult b;

            public c(CallbackWrap r1, ErrorResult r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r0 = this.a.getCallback();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.onError(this.b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class d implements Runnable {
            public final /* synthetic */ CallbackWrap a;
            public final /* synthetic */ ErrorResult b;

            public d(CallbackWrap r1, ErrorResult r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r0 = this.a.getCallback();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.onSendApplyError(this.b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class e implements Runnable {
            public final /* synthetic */ CallbackWrap a;

            public e(CallbackWrap r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r0 = this.a.getCallback();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.onShowSendApplyDialog();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class f implements Runnable {
            public final /* synthetic */ CallbackWrap a;

            public f(CallbackWrap r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IJoinGroupCallback r0 = this.a.getCallback();     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.sendApplySuccess();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onCancelSendApply() {
            UICallbackExecutor.execute(new b(this));
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onShowSendApplyDialog() {
            UICallbackExecutor.execute(new e(this));
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void sendApplySuccess() {
            UICallbackExecutor.execute(new f(this));
        }

        public final IJoinGroupCallback getCallback() {
            return this.callback;
        }

        public CallbackWrap(IJoinGroupCallback r1) {
            this.callback = r1;
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void joinGroupChatSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            UICallbackExecutor.execute(new a(this, r2));
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onError(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "errorResult");
            UICallbackExecutor.execute(new c(this, r2));
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onSendApplyError(ErrorResult r2) {
            UICallbackExecutor.execute(new d(this, r2));
        }
    }

    static {
        owa.a.b().getClass();
        a = 260008;
    }

    public static void a(final FlowQRCodeGroupCardActivity r8, final String r9, final List r10, final String r11, final String r12, FlowQRCodeGroupCardActivity$onCreate$1$onJoinGroupButtonClick$1 r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "userList");
        Intrinsics.checkNotNullParameter(r11, "inviterId");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L11:
        Exception r14 = new Exception("unknown error");
        ErrorResult r15 = new ErrorResult(0);
        ErrorResult.access$002(r15, -1);
        ErrorResult.access$102(r15, -9999);
        ErrorResult.access$202(r15, 0);
        ErrorResult.access$302(r15, r14);
        ErrorResult.access$402(r15, "");
        ErrorResult.access$502(r15, "joinGroupViaQRCode params invalid");
        ErrorResult.access$602(r15, "");
        ErrorResult.access$702(r15, "");
        ErrorResult.access$802(r15, 0);
        ErrorResult.access$902(r15, null);
        ErrorResult.access$1002(r15, null);
        ErrorResult.access$1102(r15, null);
        r13.onError(r15);
        return;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L11;
        if (TextUtils.isEmpty(r9) == true) goto L11;
        final CallbackWrap r5 = new CallbackWrap(r13);
        RxScheduledExecutor.justInIO(new FlowJoinGroupChatUtil$joinGroupViaQRCode$1(r9, r11, r12, r5, r8, r10));
    }
}
