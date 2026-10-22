package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.messages.PutMessageLinkResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chat/chatwindow/chat/menu/handler/CopyMessageLinkHandler$copyMessageLink$callback$1", "Lcom/larksuite/framework/callback/UIGetDataCallback;", "Lcom/ss/android/lark/pb/messages/PutMessageLinkResponse;", "onSuccessed", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onErrored", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CopyMessageLinkHandler$copyMessageLink$callback$1 extends UIGetDataCallback<PutMessageLinkResponse> {
    final /* synthetic */ Context $context;

    public CopyMessageLinkHandler$copyMessageLink$callback$1(Context r1) {
        this.$context = r1;
    }

    public void onErrored(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        UDToast.makeToast(this.$context, 2131891209).show();
        Log.e("CopyMessageLinkHandler", "Command.PUT_MESSAGE_LINK isError :" + r3.getDebugMsg());
    }

    public void onSuccessed(PutMessageLinkResponse r5) {
        String r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.mtoken_url;
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L25;
        Object r2 = this.$context.getSystemService("clipboard");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager r3 = (ClipboardManager) r2;
        if (r5 != null) goto L27;
    L13:
        Pattern r6 = com.ss.android.lark.utils.o.a;     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r0) == false) goto L17;
        String r7 = BuildConfig.FLAVOR;
    L22:
        INVOKEVIRTUAL_com_ss_android_lark_chat_chatwindow_chat_menu_handler_CopyMessageLinkHandler$copyMessageLink$callback$1_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(r3, ClipData.newPlainText(BuildConfig.FLAVOR, r7));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        UDToast.makeToast(this.$context, 2131891209).show();
        Log.e("CopyMessageLinkHandler", "Copy failed", e, true);
        goto L25
    L17:
        StringBuffer r8 = new StringBuffer();     // Catch: Exception -> L11
        Matcher r4 = com.ss.android.lark.utils.o.a.matcher(r0);     // Catch: Exception -> L11
    L19:
        if (r4.find() == false) goto L21;
        r4.appendReplacement(r8, Matcher.quoteReplacement(r4.group(2)));     // Catch: Exception -> L11
        goto L19
    L21:
        r4.appendTail(r8);     // Catch: Exception -> L11
        r7 = r8.toString();     // Catch: Exception -> L11
        goto L22
    L27:
        r0 = r5.mtoken_url;     // Catch: Exception -> L11
    L25:
        UDToast.makeToast(this.$context, 2131891208).show();
        return;
    L5:
        r1 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ void onSuccessed(Object r1) {
        onSuccessed((PutMessageLinkResponse) r1);
    }

    @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
    public static void INVOKEVIRTUAL_com_ss_android_lark_chat_chatwindow_chat_menu_handler_CopyMessageLinkHandler$copyMessageLink$callback$1_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(ClipboardManager r3, ClipData r4) {
        Intrinsics.checkNotNullParameter(r4, "clip");
        FLogger.a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        com_ss_android_lark_chat_chatwindow_chat_menu_handler_CopyMessageLinkHandler$copyMessageLink$callback$1_android_content_ClipboardManager_setPrimaryClip(r3, r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }

    private static void com_ss_android_lark_chat_chatwindow_chat_menu_handler_CopyMessageLinkHandler$copyMessageLink$callback$1_android_content_ClipboardManager_setPrimaryClip(ClipboardManager r18, ClipData r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101807);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.setPrimaryClip(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
