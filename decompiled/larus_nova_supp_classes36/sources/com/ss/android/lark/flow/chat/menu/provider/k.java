package com.ss.android.lark.flow.chat.menu.provider;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements yya.m {

    public static final class a {
    }

    public static final class b implements yya.i {
        public final yya.a a;

        public final Map<String, Object> R4() {
            return null;
        }

        public final boolean c() {
            return false;
        }

        public final Integer e() {
            return null;
        }

        public final boolean f() {
            return false;
        }

        public final s5c.d g() {
            return null;
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return "copy message id";
        }

        public final boolean isEnable() {
            return true;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final boolean isVisible() {
            OfficeSDKInitConfig.AppBuildConfig r0 = OfficeSDKManager.getAppBuildConfig();
            if (DevEnvUtil.isDevelopPackage(this.a.getContext()) == false) goto L5;
            return true;
        L5:
            if (DevEnvUtil.isDebugMode(this.a.getContext()) == false) goto L7;
            return true;
        L7:
            if (r0 != null) goto L9;
        L11:
            boolean r3 = false;
        L12:
            if (r3 == true) goto L24;
            if (r0 != null) goto L15;
        L17:
            boolean r1 = false;
        L18:
            if (r1 == true) goto L25;
            return false;
        L25:
            return true;
        L15:
            if (r0.isTestChannel() != true) goto L17;
            r1 = true;
            goto L18
        L24:
            return true;
        L9:
            if (r0.isDebug() != true) goto L11;
            r3 = true;
            goto L12
        }

        public MessageActionType getType() {
            return MessageActionType.COPY_MESSAGE_ID;
        }

        public b(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UDIconUtils.getIconDrawable(r2, 2131254921);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r6, "view");
            Chat r8 = this.a.getChat();
            if (r8 == null) goto L5;
            String r9 = r8.getId();
        L6:
            String r10 = "chatId = " + r9 + ", messageId = " + this.a.m().getId();
            Context r0 = this.a.getContext();
            if (r0 != null) goto L9;
            return;
        L9:
            Object r1 = r0.getSystemService("clipboard");
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.content.ClipboardManager");
            qf7.a.a.a((ClipboardManager) r1, ClipData.newPlainText("", r10), new Token("LARK-PSDA-messenger-android-copy-message-id"));     // Catch: Exception -> L12 SensitiveAPIException -> L14
            UDToast.show(r0, 2131891640);     // Catch: Exception -> L12 SensitiveAPIException -> L14
        L20:
            return;
        L12:
            e = move-exception;
            Log.e("FlowDebugCopyMessageIdActionProvider", "Copy failed", e, true);
            return;
        L14:
            e = move-exception;
            UDToast.show(r0, 2131891032);
            Log.e("FlowDebugCopyMessageIdActionProvider", "copy failed: " + e.getMessage());
            return;
        L5:
            r9 = null;
            goto L6
        }
    }

    static {
    }

    public k() {
    }

    public final String getTAG() {
        return "FlowDebugCopyMessageIdActionProvider";
    }

    public final List<PageType> b() {
        return vya.a.a;
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(r2);
    }
}
