package tgb;

import android.content.Context;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chatwindow.launcher.ChatLauncherV2;
import com.ss.android.lark.chatwindow.launcher.starter.BaseStarter;
import com.ss.android.lark.chatwindow.launcher.starter.StartKey;
import com.ss.android.lark.chatwindow.launcher.transform.d;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.threadwindow.i;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@StartKey(RealLaunchData.ChatDirection.THREAD)
public final class b extends BaseStarter {
    @Inject
    public b() {
    }

    public final boolean c(ChatLauncherV2.b r8, d r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "result");
        ChatBundleV2 r10 = r9.a;
        String r1 = r10.i.a;
        Log.i("ChatLauncherV2", "route open thread window " + r1);
        boolean r6 = false;
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        Log.e("ChatLauncherV2", "route open thread window failed, chatId is empty");
        return false;
    L10:
        if (OfficeSDKManager.isAvailable() == true) goto L13;
        Log.i("ChatLauncherV2", "route open thread window " + r1 + ", office sdk not ready");
        return false;
    L13:
        ChatBundle.a r3 = new ChatBundle.a();
        r3.a = r1;
        r3.b = r10.i.b;
        r3.a(Chat.ChatMode.THREAD_V2);
        r3.c = r10.o();
        r3.G = ((Boolean) r10.F.a(ChatBundleV2.H[34])).booleanValue();
        r3.b(Boolean.valueOf(r10.D()));
        ChatBundle r11 = new ChatBundle(r3);
        int r4 = FlowChatModule.d;
        FlowChatModule r5 = FlowChatModule.a.a();
        Context r12 = r8.getContext();
        Intrinsics.checkNotNull(r11);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r11, "chatBundle");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r11, "chatBundle");
        KeyboardUtils.hideKeyboard(r12);
        String r0 = r11.a;
        if (r0 != null) goto L16;
    L17:
        r6 = true;
    L18:
        if (r6 == false) goto L21;
    L33:
        return true;
    L21:
        if (r11.G == true) goto L23;
    L34:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L27
        i.c(r12, r11);     // Catch: Throwable -> L27
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L30:
        if (Result.isSuccess-impl(r13) == false) goto L32;
        Unit r14 = (Unit) r13;
    L32:
        Result.exceptionOrNull-impl(r13);
    L27:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L23:
        if (FlowChatModule.c(r11.a) == false) goto L34;
    L16:
        if (r0.length() != 0) goto L18;
    L5:
        r2 = false;
        goto L6
    }
}
