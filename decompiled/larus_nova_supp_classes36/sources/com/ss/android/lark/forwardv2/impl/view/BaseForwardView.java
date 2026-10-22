package com.ss.android.lark.forwardv2.impl.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$GroupChatTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$PublicTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ShieldTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$TenantCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$ThreadTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.Condition$UserTypeCondition;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.dto.template.config.GroupChatConfig;
import com.ss.android.lark.forwardv2.dto.template.config.ThreadConfig;
import com.ss.android.lark.forwardv2.dto.template.config.UserConfig;
import com.ss.android.lark.forwardv2.impl.ForwardPickFragment;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.AIConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.BotConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.widget.ChatPicker;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.UIHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseForwardView implements iib.c {
    public final Activity a;
    public final Fragment b;
    public final c c;
    public iib.c.a d;
    public TextView e;
    public int f;
    public final a g;

    @BindView(9124)
    ChatPicker mChatPicker;

    @BindView(9802)
    CommonTitleBar mTitleBar;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DIS_MODE {
        public static final int SEARCH = 0;
        public static final int SHOW_RECENT = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SELECT_TYPE {
        public static final int MULTI = 1;
        public static final int SINGLE = 0;
    }

    public class a {
        public final /* synthetic */ BaseForwardView a;

        public a(BaseForwardView r1) {
            this.a = r1;
        }
    }

    public class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ BaseForwardView b;

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            if (this.a == false) goto L6;
            this.b.a.finish();
            return;
        }

        public b(BaseForwardView r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface c {
        void a(Context r1, String r2);

        void b(String r1);

        void c();

        void d(int r1, Intent r2);

        void e(iib.c r1);

        void f(Bundle r1);

        void finish();

        Context getContext();

        FragmentManager getFragmentManager();

        void setResult(int r1, Intent r2);
    }

    @Override // iib.c
    public abstract void z6(List<SearchBaseInfo> r1);

    public final void create() {
        this.c.e(this);
        final d0 r1 = (d0) this;
        if (r1.q == false) goto L6;
        r1.f = 1;
    L6:
        if (r1.h.e.a == true) goto L8;
        r1.mTitleBar.setVisibility(8);
    L17:
        int r2 = lib.a.a;
        BusinessRecentVisitEnableConfig r3 = r1.h.b;
        Intrinsics.checkNotNullParameter(r3, "enableConfig");
        StringBuilder r6 = new StringBuilder();
        Iterator<T> r4 = r3.c.iterator();
    L19:
        if (r4.hasNext() == false) goto L75;
        EntityItem r7 = (EntityItem) r4.next();
        if (r7.a == null) goto L36;
        r6.append("UserConfig: ");
        StringBuilder r8 = new StringBuilder("tenantCondition is ");
        UserConfig r12 = r7.a;
        if (r12 == null) goto L25;
        Condition$TenantCondition r13 = r12.getTenantCondition();
    L26:
        r8.append(r13);
        r8.append(',');
        r6.append(r8.toString());
        StringBuilder r9 = new StringBuilder("userTypeCondition is ");
        UserConfig r14 = r7.a;
        if (r14 == null) goto L29;
        Condition$UserTypeCondition r15 = r14.getUserTypeCondition();
    L30:
        r9.append(r15);
        r9.append(',');
        r6.append(r9.toString());
        StringBuilder r10 = new StringBuilder("shieldTypeCondition is ");
        UserConfig r16 = r7.a;
        if (r16 == null) goto L33;
        Condition$ShieldTypeCondition r17 = r16.getShieldTypeCondition();
    L34:
        r10.append(r17);
        r10.append(",\n");
        r6.append(r10.toString());
        goto L36
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L25:
        r13 = null;
    L36:
        if (r7.b == null) goto L55;
        r6.append("GroupChatConfig: ");
        StringBuilder r11 = new StringBuilder(" tenantCondition is ");
        GroupChatConfig r18 = r7.b;
        if (r18 == null) goto L40;
        Condition$TenantCondition r19 = r18.getTenantCondition();
    L41:
        r11.append(r19);
        r11.append(',');
        r6.append(r11.toString());
        StringBuilder r20 = new StringBuilder("groupChatTypeCondition is ");
        GroupChatConfig r110 = r7.b;
        if (r110 == null) goto L44;
        Condition$GroupChatTypeCondition r111 = r110.getGroupChatTypeCondition();
    L45:
        r20.append(r111);
        r20.append(',');
        r6.append(r20.toString());
        StringBuilder r21 = new StringBuilder("publicTypeCondition is ");
        GroupChatConfig r112 = r7.b;
        if (r112 == null) goto L48;
        Condition$PublicTypeCondition r113 = r112.getPublicTypeCondition();
    L49:
        r21.append(r113);
        r21.append(',');
        r6.append(r21.toString());
        StringBuilder r22 = new StringBuilder("shieldTypeCondition is ");
        GroupChatConfig r23 = r7.b;
        if (r23 == null) goto L52;
        Condition$ShieldTypeCondition r24 = r23.getShieldTypeCondition();
    L53:
        r22.append(r24);
        r22.append('\n');
        r6.append(r22.toString());
        goto L55
    L52:
        r24 = null;
        goto L53
    L48:
        r113 = null;
        goto L49
    L44:
        r111 = null;
        goto L45
    L40:
        r19 = null;
    L55:
        if (r7.d == null) goto L70;
        r6.append("ThreadConfig: ");
        StringBuilder r25 = new StringBuilder("tenantCondition is ");
        ThreadConfig r26 = r7.d;
        if (r26 == null) goto L59;
        Condition$TenantCondition r27 = r26.getTenantCondition();
    L60:
        r25.append(r27);
        r25.append(',');
        r6.append(r25.toString());
        StringBuilder r28 = new StringBuilder("publicTypeCondition is ");
        ThreadConfig r29 = r7.d;
        if (r29 == null) goto L63;
        Condition$PublicTypeCondition r30 = r29.getPublicTypeCondition();
    L64:
        r28.append(r30);
        r28.append(',');
        r6.append(r28.toString());
        StringBuilder r31 = new StringBuilder("threadTypeCondition is ");
        ThreadConfig r32 = r7.d;
        if (r32 == null) goto L67;
        Condition$ThreadTypeCondition r33 = r32.getThreadTypeCondition();
    L68:
        r31.append(r33);
        r31.append('\n');
        r6.append(r31.toString());
        goto L70
    L67:
        r33 = null;
        goto L68
    L63:
        r30 = null;
        goto L64
    L59:
        r27 = null;
    L70:
        if (r7.c == null) goto L73;
        r6.append("BotConfig: \n");
    L73:
        if (r7.e == null) goto L19;
        r6.append("AIConfig: \n");
        goto L19
    L75:
        Log.i("Android_Recent_Visit", "enableConfigs is\n" + r6);
        WeakReference<Message> r5 = ForwardDataUtils.a;
        com.ss.android.lark.forwardv3.utils.b.d();
        String r34 = UIHelper.getString(2131891132);
        Intrinsics.checkNotNull(r34);
        ForwardDataUtils.d = r34;
        int r35 = lib.a.a;
        BusinessRecentVisitIncludeConfig r36 = r1.h.a;
        Intrinsics.checkNotNullParameter(r36, "includeConfig");
        Log.i("Android_Recent_Visit", "start getSearchPickerParams");
        final lib.a.C0293a r37 = new lib.a.C0293a();
        Iterator<T> r38 = r36.a.iterator();
    L77:
        if (r38.hasNext() == false) goto L113;
        EntityItem r39 = (EntityItem) r38.next();
        UserConfig r114 = r39.a;
        if (r114 == null) goto L91;
        Condition$TenantCondition r115 = r114.getTenantCondition();
        if (r115 != null) goto L83;
        int r116 = -1;
    L84:
        if (r116 == 1) goto L90;
        if (r116 == 2) goto L89;
        if (r116 != 3) goto L91;
        Log.i("Android_Recent_Visit", "only include outer users not supported");
        goto L91
    L89:
        r37.c = false;
        goto L91
    L90:
        r37.c = true;
        r37.a = false;
        goto L91
    L83:
        r116 = lib.a.b.a[r115.ordinal()];
    L91:
        GroupChatConfig r117 = r39.b;
        if (r117 == null) goto L105;
        Condition$TenantCondition r118 = r117.getTenantCondition();
        if (r118 != null) goto L96;
        int r119 = -1;
    L97:
        if (r119 == 1) goto L103;
        if (r119 == 2) goto L102;
        if (r119 != 3) goto L105;
        Log.i("Android_Recent_Visit", "only include outer group chats not supported");
        goto L105
    L102:
        r37.b = false;
        goto L105
    L103:
        r37.b = true;
        goto L105
    L96:
        r119 = lib.a.b.a[r118.ordinal()];
    L105:
        if (r39.c == null) goto L108;
        r37.d = true;
    L108:
        if (r39.d == null) goto L111;
        r37.e = true;
    L111:
        if (r39.e == null) goto L77;
        r37.f = true;
        goto L77
    L113:
        Log.i("Android_Recent_Visit", "end getSearchPickerParams, result: \nexcludeOuterUser is " + r37.a + " \nincludeOutGroupChat is " + r37.b + " \nneedSearchOuterTenant is " + r37.c + " \nincludeBot is " + r37.d + " \nincludeThread is " + r37.e);
        r1.mChatPicker.attachMultiple(r1.q).attachPermissions(Collections.singletonList(ActionType.SHARE_MESSAGE_SELECT_USER)).attachOnPickerParamsLoader(new com.ss.android.lark.forwardv2.impl.view.a(r37)).attachDependency(new x(r1)).attachOnPickerNotify(new w(r1)).attachOnBusinessConsumeItem(new t(r1)).attachChatCountStyle(true).attachScene("msg_forward").attachIsEnableChatPreview(r1.h.c.k);
        if (r1.h.c.c == false) goto L196;
        View r40 = View.inflate(r1.a, 2131558483, null);
        boolean r41 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_chat_with_filter", false);
        Log.i("FGUtils", "FG key: lark.forward.create_group_chat_with_filter, is " + r41);
        if (r41 == false) goto L194;
        com.ss.android.lark.forwardv3.plugins.f r42 = r1.n;
        int r43 = lib.a.a;
        ForwardTemplate r44 = r1.h;
        Intrinsics.checkNotNullParameter(r44, "forwardTemplateV2");
        IncludeConfig.a r45 = new IncludeConfig.a();
        Iterator<T> r46 = r44.a.a.iterator();
    L119:
        if (r46.hasNext() == false) goto L155;
        EntityItem r120 = (EntityItem) r46.next();
        UserConfig r121 = r120.a;
        if (r121 == null) goto L133;
        Condition$TenantCondition r122 = r121.getTenantCondition();
        if (r122 != null) goto L125;
        int r123 = -1;
    L126:
        if (r123 == 1) goto L132;
        if (r123 == 2) goto L131;
        if (r123 == 3) goto L130;
        Unit r124 = Unit.INSTANCE;
        goto L133
    L130:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r125 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r126 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r126.b(Condition$Tenant.CROSS_TENANT);
        r125.f(r126.a());
        r45.a(r125.c());
        goto L133
    L131:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r127 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r128 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r128.b(Condition$Tenant.NOT_CROSS_TENANT);
        r127.f(r128.a());
        r45.a(r127.c());
        goto L133
    L132:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r129 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r130 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r130.b(Condition$Tenant.ALL);
        r129.f(r130.a());
        r45.a(r129.c());
        goto L133
    L125:
        r123 = lib.a.b.a[r122.ordinal()];
    L133:
        GroupChatConfig r131 = r120.b;
        if (r131 == null) goto L147;
        Condition$TenantCondition r132 = r131.getTenantCondition();
        if (r132 != null) goto L138;
        int r133 = -1;
    L139:
        if (r133 == 1) goto L145;
        if (r133 == 2) goto L144;
        if (r133 == 3) goto L143;
        Unit r134 = Unit.INSTANCE;
        goto L147
    L143:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r135 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r136 = new GroupConfig.a();
        r136.b(Condition$Tenant.CROSS_TENANT);
        r135.d(r136.a());
        r45.a(r135.c());
        goto L147
    L144:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r137 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r138 = new GroupConfig.a();
        r138.b(Condition$Tenant.NOT_CROSS_TENANT);
        r137.d(r138.a());
        r45.a(r137.c());
        goto L147
    L145:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r139 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r140 = new GroupConfig.a();
        r140.b(Condition$Tenant.ALL);
        r139.d(r140.a());
        r45.a(r139.c());
        goto L147
    L138:
        r133 = lib.a.b.a[r132.ordinal()];
    L147:
        if (r120.c == null) goto L150;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r141 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r141.b(new BotConfig());
        r45.a(r141.c());
    L150:
        if (r120.d == null) goto L153;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r142 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r142.e(new com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig.a().a());
        r45.a(r142.c());
    L153:
        if (r120.e == null) goto L119;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r143 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r143.a(new AIConfig());
        r45.a(r143.c());
        goto L119
    L155:
        DisableConfig.a r47 = new DisableConfig.a();
        if (CollectionUtils.isEmpty(r44.b.c) == true) goto L191;
        Iterator<T> r48 = r44.b.c.iterator();
    L159:
        if (r48.hasNext() == false) goto L191;
        EntityItem r49 = (EntityItem) r48.next();
        UserConfig r144 = r49.a;
        if (r144 == null) goto L171;
        Condition$TenantCondition r145 = r144.getTenantCondition();
        if (r145 != null) goto L165;
        int r146 = -1;
    L166:
        if (r146 == 2) goto L170;
        if (r146 != 3) goto L171;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r147 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r148 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r148.b(Condition$Tenant.NOT_CROSS_TENANT);
        r147.f(r148.a());
        r47.a(r147.c());
        goto L171
    L170:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r149 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a r150 = new com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig.a();
        r150.b(Condition$Tenant.CROSS_TENANT);
        r149.f(r150.a());
        r47.a(r149.c());
        goto L171
    L165:
        r146 = lib.a.b.a[r145.ordinal()];
    L171:
        GroupChatConfig r151 = r49.b;
        if (r151 == null) goto L183;
        Condition$TenantCondition r152 = r151.getTenantCondition();
        if (r152 != null) goto L176;
        int r153 = -1;
    L177:
        if (r153 == 2) goto L181;
        if (r153 != 3) goto L183;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r154 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r155 = new GroupConfig.a();
        r155.b(Condition$Tenant.NOT_CROSS_TENANT);
        r154.d(r155.a());
        r47.a(r154.c());
        goto L183
    L181:
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r156 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        GroupConfig.a r157 = new GroupConfig.a();
        r157.b(Condition$Tenant.CROSS_TENANT);
        r156.d(r157.a());
        r47.a(r156.c());
        goto L183
    L176:
        r153 = lib.a.b.a[r152.ordinal()];
    L183:
        if (r49.c != null) goto L186;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r158 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r158.b(new BotConfig());
        r47.a(r158.c());
    L186:
        if (r49.d != null) goto L189;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r159 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r159.e(new com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig.a().a());
        r47.a(r159.c());
    L189:
        if (r49.e != null) goto L159;
        com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a r50 = new com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem.a();
        r50.a(new AIConfig());
        r47.a(r50.c());
    L191:
        ForwardTargetConfig.a r51 = new ForwardTargetConfig.a();
        IncludeConfig r52 = r45.b();
        Intrinsics.checkNotNullParameter(r52, "includeConfig");
        r51.d = r52;
        DisableConfig r53 = r47.b();
        Intrinsics.checkNotNullParameter(r53, "disableConfig");
        r51.e = r53;
        ForwardTargetConfig r54 = r51.a();
        ForwardTemplateNew.a r55 = new ForwardTemplateNew.a();
        Intrinsics.checkNotNullParameter(r54, "forwardTargetConfig");
        r55.a = r54;
        r42.c("forward_plugin_crate_group_chat", new ForwardCreateGroupChatPlugin(r55.a(), new y(r1)));
        com.ss.android.lark.forwardv3.plugins.i r56 = r1.n.b("forward_plugin_crate_group_chat");
        if (r56 == null) goto L195;
        r56.b((FragmentActivity) r1.a, r1.b, r40);
    L195:
        r1.mChatPicker.attachTopCustomView(r40);
        goto L196
    L194:
        r40.setOnClickListener(new d(r1));
    L196:
        r1.h.c.a();
        Log.i("NewForward", "disable recent forward");
        int r57 = kib.c.a;
        Statistics.sendEvent("public_multi_select_share_view");
        return;
    L8:
        r1.mTitleBar.setVisibility(0);
        r1.mTitleBar.setMainTitleColor(UIUtils.getColor(r1.a, 2131106622));
        String r58 = r1.h.e.b;
        CommonTitleBar r59 = r1.mTitleBar;
        if (TextUtils.isEmpty(r58) == false) goto L11;
        r58 = UIUtils.getString(r1.a, 2131892188);
    L11:
        r59.setTitle(r58);
        r1.mTitleBar.setLeftClickListener(new a0(r1));
        r1.mTitleBar.setLeftImageResource(CommonTitleBarConstants.ICON_CLOSE);
        r1.mTitleBar.setImmersive(true);
        if (r1.k == false) goto L14;
    L15:
        r1.mTitleBar.addAction(new c0(r1, UIUtils.getString(r1.a, 2131892181)));
        TextView r60 = r1.mTitleBar.getRightText();
        r1.e = r60;
        r60.setPadding(0, 0, UIUtils.dp2px(r1.a, 15.0f), 0);
        int r61 = DesktopUtil.a;
    L16:
        r1.z6(null);
        goto L17
    L14:
        if (r1.q == false) goto L16;
        goto L15
    }

    public void destroy() {
        this.mChatPicker.destroy();
    }

    @Override // iib.c
    public final void s7(List<SearchBaseInfo> r1) {
        z6(r1);
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.d = (iib.c.a) r1;
    }

    @Override // iib.c
    public final void L0(String r2, boolean r3) {
        LKUIToast.show(this.a, r2);
        if (r3 == false) goto L6;
        this.a.finish();
        return;
    }

    public BaseForwardView(FragmentActivity r2, Fragment r3, ForwardPickFragment.a r4) {
        this.f = 0;
        this.g = new a(this);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // iib.c
    public final void e6(String r4, String r5, boolean r6) {
        com.larksuite.component.ui.dialog.d r0 = new com.larksuite.component.ui.dialog.d(this.a);
        r0.c.cancelable(true);
        r0.c.cancelOnTouchOutside(false);
        b r1 = new b(this, r6);
        r0.c.onDismissListener(r1);
        r0.k(r4);
        r0.h(r5);
        r0.a(2131378551, 2131893531, null);
        r0.i();
    }
}
