package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import android.os.Build;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.ExtraData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.light.processor.c0;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.span.PrefixSpanStyle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class j implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.a {
    public static final /* synthetic */ int b = 0;
    public final Context a;

    public static final class a {
        public static com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b b(MessageFullScreenLaunchData r5) {
            com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r0 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
            r0.p = r5.getMessageId();
            ExtraData r1 = r5.getExtraData();
            ValidateIMFileResult r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.getSenderTenantId();
        L6:
            r0.q = r3;
            ExtraData r4 = r5.getExtraData();
            if (r4 == null) goto L9;
            MessagePermissionUtil.ReceiveAuthorizationState r6 = r4.getReceiveAuthorizationState();
        L10:
            ValidateResult r7 = MessagePermissionUtil.b();
            ExtraData r8 = r5.getExtraData();
            if (r8 == null) goto L13;
            Boolean r9 = Boolean.valueOf(r8.getHasPreviewPermission());
        L14:
            ExtraData r10 = r5.getExtraData();
            if (r10 == null) goto L17;
            r2 = r10.getValidateIMFileResult();
        L17:
            if (r6 == null) goto L19;
            Intrinsics.checkNotNullParameter(r6, "receiveAuthorizationState");
            r0.B = r6;
        L19:
            r0.C = r2;
            r0.a(r7);
            if (r9 == null) goto L22;
            r0.o = r9.booleanValue();
        L22:
            r0.D = true;
            r0.E = true;
            r0.O = false;
            return r0;
        L13:
            r9 = null;
            goto L14
        L9:
            r6 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        @JvmStatic
        public static int a(Context r2, Function0 r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (r3 == null) goto L5;
            Integer r1 = (Integer) r3.invoke();
        L6:
            if (r1 != null) goto L8;
        L11:
            int r4 = DeviceUtils.getScreenWidth(r2);
        L12:
            int r5 = p.a;
            Intrinsics.checkNotNullParameter(r2, "context");
            int r6 = r4 - (qsb.i.a(28, r2) * 2);
            hac.b.a.b("MsgFSRichTextSetup", "code block max width :" + r6);
            return r6;
        L8:
            if (((Number) r3.invoke()).intValue() == 0) goto L11;
            r4 = ((Number) r3.invoke()).intValue();
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        public static void d(com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r7, Context r8) {
            if (Build.VERSION.SDK_INT <= 29) goto L5;
            int r0 = 2;
        L6:
            r7.Q = p.a(r8);
            Intrinsics.checkNotNullParameter(r8, "context");
            r7.R = zz7.b.g(r8, 23);
            Intrinsics.checkNotNullParameter(r8, "context");
            c0.b r4 = new c0.b(zz7.b.g(r8, 3), zz7.b.g(r8, 6));
            Intrinsics.checkNotNullParameter(r4, "urlIconMargin");
            r7.S = r4;
            Intrinsics.checkNotNullParameter(r8, "context");
            r7.T = zz7.b.g(r8, 30);
            r7.U = 2;
            r7.W = r0;
            r7.X = 0;
            PrefixSpanStyle r9 = PrefixSpanStyle.FULL_SCREEN;
            Intrinsics.checkNotNullParameter(r9, "prefixSpanStyle");
            r7.Y = r9;
            return;
        L5:
            r0 = 0;
            goto L6
        }

        public static void c(com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r3, Context r4, Function0 r5) {
            int r6 = a(r4, r5);
            if (Build.VERSION.SDK_INT <= 29) goto L5;
            int r0 = 2;
        L6:
            r3.V = r0;
            r3.y = r6;
            int r1 = (int) zz7.b.h(r4, 12);
            int r2 = zz7.b.g(r4, 16);
            CodeBlockV2ProcessParams.a r7 = new CodeBlockV2ProcessParams.a();
            r7.a = r6;
            CodeBlockV2ProcessParams.LineCountParams.Companion.getClass();
            CodeBlockV2ProcessParams.LineCountParams.a r8 = new CodeBlockV2ProcessParams.LineCountParams.a();
            r8.d = r1;
            r8.e = r2;
            CodeBlockV2ProcessParams.LineCountParams r9 = r8.a();
            Intrinsics.checkNotNullParameter(r9, "params");
            r7.f = r9;
            r7.c = UIUtils.dp2px(r4, 8.0f);
            r7.d = UIUtils.dp2px(r4, 8.0f);
            CodeBlockV2ProcessParams r10 = r7.a();
            Intrinsics.checkNotNullParameter(r10, "params");
            r3.z = r10;
            return;
        L5:
            r0 = 0;
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.a
    public final void clear() {
        TableUtils.a = null;
        ColumnsUtils.a = null;
    }

    public final Context getContext() {
        return this.a;
    }

    public j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public CharSequence a(RichText r7, q r8) {
        Intrinsics.checkNotNullParameter(r8, "config");
        if (r7 != null) goto L5;
        return null;
    L5:
        r r9 = (r) r8;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r1 = r9.a;
        String r2 = r1.p;
        if (r2 != null) goto L8;
        return null;
    L8:
        int r0 = TextLayoutRender.j;
        w2b.b r3 = w2b.b.d;
        TableUtils.a(r7, r1, this.a, r3, new TableUtils.CalculateTableLayoutSceneInfo(r2, "scene_full_message"));
        ColumnsUtils.a(r7, r1, this.a, r3, new ColumnsUtils.CalculateColumnsLayoutSceneInfo(r2, "scene_full_message"));
        r1.H = TableUtils.a;
        r1.I = ColumnsUtils.a;
        int r4 = v2b.d.a;
        Context r5 = this.a;
        int r10 = a.a(r5, r9.b);
        Intrinsics.checkNotNullParameter(r7, "oriRichText");
        Intrinsics.checkNotNullParameter(r1, "processParams");
        Intrinsics.checkNotNullParameter(r5, "context");
        return v2b.c.a(r7, r1, r5, r10);
    }
}
