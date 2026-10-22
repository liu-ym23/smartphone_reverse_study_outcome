package com.ss.android.lark.compose.chatsetting.common.platform;

import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatterselector.FriendsSelectorForSettingKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AndroidChatSettingChildScreenHost implements a {
    public final FragmentActivity a;

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.a
    public final void c() {
        View r0 = this.a.getCurrentFocus();
        if (r0 == null) goto L5;
        r0.clearFocus();
    L5:
        Object r1 = this.a.getSystemService("input_method");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r2 = (InputMethodManager) r1;
        if (r0 == null) goto L9;
        IBinder r3 = r0.getWindowToken();
        if (r3 == null) goto L9;
    L15:
        r2.hideSoftInputFromWindow(r3, 0);
        return;
    L9:
        View r4 = this.a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L14:
        r3 = r4.getWindowToken();
        goto L15
    }

    public AndroidChatSettingChildScreenHost(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.a
    public final Modifier a(final boolean r3, final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onBack");
        return KeyInputModifierKt.onPreviewKeyEvent(Modifier.Companion, new AndroidChatSettingChildScreenHost$backKeyHandlerModifier$1(r3, r4));
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.a
    public final void b(final String r21, final Modifier r22, final Function1<? super List<String>, Unit> r23, final String r24, Composer r25, final int r26) {
        Intrinsics.checkNotNullParameter(r21, "chatId");
        Intrinsics.checkNotNullParameter(r22, "modifier");
        Intrinsics.checkNotNullParameter(r23, "onChanged");
        Intrinsics.checkNotNullParameter(r24, "searchPlaceholder");
        Composer r1 = r25.startRestartGroup(1073142236);
        if ((r26 & 6) == 0) goto L5;
        int r8 = r26;
    L11:
        if ((r26 & 48) != 0) goto L18;
        if (r1.changed(r22) == false) goto L15;
        int r9 = 32;
    L16:
        r8 = r8 | r9;
        goto L18
    L15:
        r9 = 16;
    L18:
        if ((r26 & 384) != 0) goto L25;
        if (r1.changedInstance(r23) == false) goto L22;
        int r10 = 256;
    L23:
        r8 = r8 | r10;
        goto L25
    L22:
        r10 = 128;
    L25:
        if ((r26 & 3072) != 0) goto L32;
        if (r1.changed(r24) == false) goto L29;
        int r11 = 2048;
    L30:
        r8 = r8 | r11;
        goto L32
    L29:
        r11 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L32:
        if ((r26 & 24576) != 0) goto L39;
        if (r1.changedInstance(this) == false) goto L36;
        int r12 = 16384;
    L37:
        r8 = r8 | r12;
        goto L39
    L36:
        r12 = 8192;
    L39:
        if ((r8 & 9363) != 9362) goto L45;
        if (r1.getSkipping() == false) goto L45;
        r1.skipToGroupEnd();
    L59:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L63;
        r13.updateScope(new AndroidChatSettingChildScreenHost$AddMemberSelector$2(this, r21, r22, r23, r24, r26));
        return;
    L63:
        return;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(1073142236, r8, -1, "com.ss.android.lark.compose.chatsetting.common.platform.AndroidChatSettingChildScreenHost.AddMemberSelector (AndroidChatSettingChildScreenHost.kt:20)");
    L47:
        FragmentActivity r0 = this.a;
        r1.startReplaceGroup(5004770);
        if ((r8 & 896) != 256) goto L50;
        boolean r14 = true;
    L51:
        Object r15 = r1.rememberedValue();
        if (r14 == false) goto L54;
    L55:
        r15 = new AndroidChatSettingChildScreenHost$AddMemberSelector$1$1(r23);
        r1.updateRememberedValue(r15);
    L56:
        r1.endReplaceGroup();
        FriendsSelectorForSettingKt.a(r0, r22, null, r21, null, null, null, (Function2) r15, r24, r1, ((r8 & 112) | ((r8 << 9) & 7168)) | ((r8 << 15) & 234881024), 116);
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventEnd();
        goto L59
    L54:
        if (r15 != Composer.Companion.getEmpty()) goto L56;
    L50:
        r14 = false;
        goto L51
    L5:
        if (r1.changed(r21) == false) goto L7;
        int r16 = 4;
    L8:
        r8 = r16 | r26;
        goto L11
    L7:
        r16 = 2;
        goto L8
    }
}
