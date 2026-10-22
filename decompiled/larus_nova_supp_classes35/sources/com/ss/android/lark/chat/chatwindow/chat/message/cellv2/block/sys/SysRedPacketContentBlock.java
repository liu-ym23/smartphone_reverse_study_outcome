package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.f1;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.authorization.ThridPartySDKAuthEffectType;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.dialog.CommonLoadingDialog;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w4b.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SysRedPacketContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.chat.base.view.vo.message.d>, Object> {
    public final IMMessageKeys$Blocks g;

    public static final class a implements k<View> {
        public final View a;
        public final View b;
        public final TextView c;

        public final View getView() {
            return this.a;
        }

        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = r2.findViewById(2131387975);
            this.c = (TextView) r2.findViewById(2131387971);
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SystemMessageType.values().length];
            r0[SystemMessageType.GRAB_OTHER_HONGBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[SystemMessageType.OTHER_GRAB_MY_HONGBAO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[SystemMessageType.LAST_HONGBAO_IS_GRABBED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[SystemMessageType.SEND_HONGBAO_MESSAGE_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final class d implements f1.b.a {
        public final /* synthetic */ SysRedPacketContentBlock a;
        public final /* synthetic */ Map<String, String> b;

        public d(SysRedPacketContentBlock r1, Map<String, String> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.chat.utils.f1.b.a
        public final void a(SystemMessageType r4) {
            Intrinsics.checkNotNullParameter(r4, "systemMessageType");
            if (SysRedPacketContentBlock.h(this.a) == true) goto L6;
            LKUIToast.show(this.a.c.getContext(), 2131890594);
            return;
        L6:
            String r0 = this.b.get("message_id");
            String r1 = this.b.get("hongbao_id");
            if (this.a.c.a() == false) goto L11;
            ChatCoreModule.a().getChatDependency().m(this.a.c.getContext());
            Log.i("SysRedPacketContentBlock", "showDialogWhenInterceptClickForVcVisitor");
            return;
        L11:
            if (TextUtils.isEmpty(r1) == true) goto L21;
            ChatCoreModule.a().getMiraDependency().isPluginInstalled(ChatCoreModule.a().getMoneyDependency().getMoneyPluginPackageName());
            ChatCoreModule.a().getMiraDependency().isPluginLoaded(ChatCoreModule.a().getMoneyDependency().getMoneyPluginPackageName());
            y5c.a r2 = y5c.a.a;
            Statistics.sendEvent("money_plugin", new JSONObject().put("scene", "open_red_packet").put("install_status", 0).put("load_status", 0));
            this.a.getClass();
            if (r4 != SystemMessageType.OTHER_GRAB_MY_HONGBAO) goto L15;
        L19:
            x r5 = ChatCoreModule.a().getMoneyDependency();
            new CommonLoadingDialog();
            r5.a();
            return;
        L15:
            if (r4 == SystemMessageType.LAST_HONGBAO_IS_GRABBED) goto L19;
            if (r4 == SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO) goto L19;
            SystemMessageType r3 = SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM;
            goto L19
        }
    }

    public static final class e implements f1.b.a {
        public final /* synthetic */ SysRedPacketContentBlock a;

        public e(SysRedPacketContentBlock r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.utils.f1.b.a
        public final void a(SystemMessageType r3) {
            if (SysRedPacketContentBlock.h(this.a) == true) goto L6;
            LKUIToast.show(this.a.c.getContext(), 2131890594);
            return;
        L6:
            ChatCoreModule.a().getMiraDependency().isPluginInstalled(ChatCoreModule.a().getMoneyDependency().getMoneyPluginPackageName());
            ChatCoreModule.a().getMiraDependency().isPluginLoaded(ChatCoreModule.a().getMoneyDependency().getMoneyPluginPackageName());
            y5c.a r4 = y5c.a.a;
            Statistics.sendEvent("money_plugin", new JSONObject().put("scene", "open_wallet").put("install_status", 0).put("load_status", 0));
            x r5 = ChatCoreModule.a().getMoneyDependency();
            new CommonLoadingDialog();
            r5.a();
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public SysRedPacketContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.SYS_RED_PACKET;
    }

    public static final boolean h(SysRedPacketContentBlock r3) {
        r3.getClass();
        Pair r4 = AuditManager.getInstance().checkAuthorityWithErrorType(28, "SDK", String.valueOf(ThridPartySDKAuthEffectType.PaySDK.getValue()));
        Log.i("SysRedPacketContentBlock", "checkAuthority" + r4.first + " , error: " + r4.second);
        Integer r5 = (Integer) r4.first;
        if (r5 != null) goto L6;
        return true;
    L6:
        if (r5.intValue() != 1) goto L11;
        return false;
    L11:
        return true;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.d>> r6, q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.d>> r7, y6b.a<com.ss.android.lark.chat.base.view.vo.message.d> r8) {
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "layout");
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        SystemContent r9 = (SystemContent) r8.b().a;
        String r10 = r9.getFormattedContent();
        a r11 = (a) r7.c(this.g, IMMessageKeys$Slots.CONTENT, SysRedPacketContentBlock$update$blockView$1.INSTANCE);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r11.a.setVisibility(8);
    L6:
        Map<String, String> r0 = r9.getContents();
        if (CollectionUtils.isEmpty(r0) == false) goto L9;
        return;
    L9:
        SystemMessageType r2 = r9.getType();
        switch(c.a[r2.ordinal()]) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L12;
            default: goto L20;
        };
    L12:
        String r1 = r0.get("wallet");
        if (TextUtils.isEmpty(r1) == true) goto L20;
        SpannableStringBuilder r12 = f1.c(this.c.getContext(), r9.getType(), r10, r1, new e(this));
    L21:
        if (r12 == null) goto L30;
        r11.c.setText(r12);
        r11.c.setMovementMethod(LinkMovementMethod.getInstance());
        r11.c.setHighlightColor(0);
        ChatThemeInfo r13 = this.c.r8();
        if (r13 == null) goto L30;
        if (r13.getComponentScene() == ChatThemeInfo.Scene.DEFAULT_SCENE) goto L28;
        r11.c.setBackground(UIUtils.getDrawable(this.c.getContext(), 2131232172));
        r11.c.setTextColor(p.c(this.c.getContext()));
        goto L30
    L28:
        TextView r14 = r11.c;
        FragmentActivity r15 = this.c.getContext();
        int r3 = p.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        r14.setBackgroundColor(UIUtils.getColor(r15, 2131106784));
        r11.c.setTextColor(p.e(this.c.getContext()));
    L30:
        if (this.c.s8() == true) goto L33;
        r11.b.setVisibility(8);
        return;
    L33:
        return;
    L16:
        String r4 = r0.get("hongbao");
        if (TextUtils.isEmpty(r4) == true) goto L20;
        r12 = f1.c(this.c.getContext(), r9.getType(), r10, r4, new d(this, r0));
    L20:
        r12 = null;
        goto L21
    L5:
        r11.c.setText(r10);
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.d>> r1, q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.d>> r2, y6b.a<com.ss.android.lark.chat.base.view.vo.message.d> r3) {
        update2(r1, r2, r3);
    }
}
