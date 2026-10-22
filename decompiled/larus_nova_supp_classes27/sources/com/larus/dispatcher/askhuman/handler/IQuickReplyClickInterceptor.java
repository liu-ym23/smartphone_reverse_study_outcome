package com.larus.dispatcher.askhuman.handler;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.standarduikit.IStandardUiKitService;
import com.larus.common.apphost.AppHost;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.dispatcher.api.UploadToolCallRequest;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface IQuickReplyClickInterceptor {

    public static final class DefaultImpls {

        public static final class a implements IIMCallback<OmniDispatchCommandResponse> {
            public final /* synthetic */ IQuickReplyClickInterceptor a;
            public final /* synthetic */ o b;

            public final boolean mustInMain() {
                return true;
            }

            public final void onFailure(IIMError r4) {
                Intrinsics.checkNotNullParameter(r4, "error");
                Intrinsics.checkNotNullParameter(r4, "error");
                t19.s r0 = t19.s.a;
                Application r1 = AppHost.a.getApplication();
                r0.getClass();
                t19.s.b(r1, 2131899926, false);
                FLogger r2 = FLogger.a;
                StringBuilder r3 = new StringBuilder("[sendCommand][");
                r3.append(this.a.getClass().getSimpleName());
                r3.append("] sendDispatchCommand failed, errorCode: ");
                r3.append(r4.getCode());
                r3.append(", errorMsg: ");
                r3.append(r4.getTips());
                r3.append(", exception: ");
                Throwable r5 = r4.getException();
                if (r5 == null) goto L5;
                String r6 = r5.getLocalizedMessage();
            L6:
                r3.append(r6);
                r2.e("QuickReplyClickInterceptorManager", r3.toString());
                o r7 = this.b;
                if (r7.l == false) goto L9;
                Set<Integer> r8 = n.a;
                n.c(r7.g);
            L9:
                Function1<com.larus.bmhome.taskskill.service.k, Unit> r9 = this.b.k;
                if (r9 == null) goto L13;
                r9.invoke(new com.larus.bmhome.taskskill.service.k.b("dispatch_failed"));
                return;
            L13:
                return;
            L5:
                r6 = null;
                goto L6
            }

            public final void onSuccess(Object r3) {
                Intrinsics.checkNotNullParameter((OmniDispatchCommandResponse) r3, "result");
                FLogger.a.i("QuickReplyClickInterceptorManager", "[sendCommand][" + this.a.getClass().getSimpleName() + "] sendDispatchCommand success");
                Function1<com.larus.bmhome.taskskill.service.k, Unit> r4 = this.b.k;
                if (r4 == null) goto L6;
                r4.invoke(com.larus.bmhome.taskskill.service.k.g.a);
                return;
            }

            public a(IQuickReplyClickInterceptor r1, o r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            FLogger.a.i("QuickReplyClickInterceptorManager", r2);
        }

        public static p b(o r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "interceptorContext");
            Function1<com.larus.bmhome.taskskill.service.k, Unit> r4 = r2.k;
            if (r4 == null) goto L9;
            if (r3 == false) goto L6;
            com.larus.bmhome.taskskill.service.k.e r0 = com.larus.bmhome.taskskill.service.k.e.a;
        L7:
            r4.invoke(r0);
            goto L9
        L6:
            r0 = new com.larus.bmhome.taskskill.service.k.b("pc_guide_unavailable");
        L9:
            return new p(r3, false);
        }

        public static void e(o r8, Function1 r9) {
            Intrinsics.checkNotNullParameter(r8, "interceptorContext");
            Intrinsics.checkNotNullParameter(r9, "call");
            Function1<com.larus.bmhome.taskskill.service.k, Unit> r0 = r8.k;
            if (r0 == null) goto L5;
            r0.invoke(com.larus.bmhome.taskskill.service.k.f.a);
        L5:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new IQuickReplyClickInterceptor$uploadHttpResult$1(r9, r8, null), 2, null);
        }

        public static void f(IQuickReplyClickInterceptor r2, o r3, UploadToolCallRequest r4) {
            Intrinsics.checkNotNullParameter(r3, "interceptorContext");
            Intrinsics.checkNotNullParameter(r4, "request");
            r2.a(r3, new IQuickReplyClickInterceptor$uploadToolCallResult$1(r4, null));
        }

        public static boolean c(IQuickReplyClickInterceptor r9, o r10, String r11, DispatchCommandPayload r12) {
            Intrinsics.checkNotNullParameter(r10, "interceptorContext");
            Intrinsics.checkNotNullParameter(r12, "payload");
            int r1 = 0;
            if (r11 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L15;
            FLogger.a.i("QuickReplyClickInterceptorManager", "[sendCommand][" + r9.getClass().getSimpleName() + "] targetDeviceId is null or empty, guide user to PC");
            boolean r13 = r9.d(r10.c, r10.h, r10.j, r10.m, r10.n, r10.o);
            if (r10.l == false) goto L13;
            Set<Integer> r14 = n.a;
            n.c(r10.g);
        L13:
            r9.b(r10, r13);
            return false;
        L15:
            Function1<com.larus.bmhome.taskskill.service.k, Unit> r3 = r10.k;
            if (r3 == null) goto L18;
            r3.invoke(com.larus.bmhome.taskskill.service.k.f.a);
        L18:
            GetAllDevicesRepo r4 = GetAllDevicesRepo.a;
            Integer r5 = GetAllDevicesRepo.c(r11);
            if (r5 == null) goto L21;
            r1 = r5.intValue();
        L21:
            com.larus.im.d.b().sendDispatchCommand(new OmniDispatchCommandRequest(r11, r1, r12), new a(r9, r10));
            return true;
        L5:
            if (r11.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public static boolean d(IQuickReplyClickInterceptor r7, FragmentActivity r8, String r9, Integer r10, String r11, String r12, String r13) {
            if (r8 != null) goto L5;
        L27:
            r7.f("[showGoToPcTipDialog][" + r7.getClass().getSimpleName() + "] activity is null or destroyed or finishing");
            return false;
        L5:
            if (r8.isDestroyed() == true) goto L27;
            if (r8.isFinishing() == true) goto L27;
            FragmentManager r14 = r8.getSupportFragmentManager();
            if (r14.isStateSaved() == false) goto L13;
            r7.f("[showGoToPcTipDialog][" + r7.getClass().getSimpleName() + "] fragmentManager state is saved");
            return false;
        L13:
            Fragment r15 = IStandardUiKitService.a.a(r9, r10, r11, r12, r13);
            if (r11 != null) goto L17;
            r11 = r7.getClass().getSimpleName();
        L17:
            if ((r15 instanceof Fragment) == false) goto L19;
            Fragment r16 = r15;
        L20:
            LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, r11, r17);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r16, r17) == true) goto L32;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
        L24:
            r15.show(r14, r11);
            return true;
        L32:
            return true;
        L19:
            r16 = null;
            goto L20
        }
    }

    void a(o r1, Function1<? super Continuation<? super dm9.a<Unit>>, ? extends Object> r2);

    p b(o r1, boolean r2);

    String c();

    boolean d(FragmentActivity r1, String r2, Integer r3, String r4, String r5, String r6);

    boolean e(k r1);

    void f(String r1);

    p g(o r1);
}
