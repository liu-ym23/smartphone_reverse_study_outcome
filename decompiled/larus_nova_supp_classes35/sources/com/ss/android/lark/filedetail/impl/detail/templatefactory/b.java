package com.ss.android.lark.filedetail.impl.detail.templatefactory;

import android.content.Context;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView;
import com.ss.android.lark.forwardv2.dto.template.ForwardTargetFilter;
import com.ss.android.lark.forwardv2.dto.template.ForwardViewDependency;
import com.ss.android.lark.forwardv2.dto.template.config.AIConfig;
import com.ss.android.lark.forwardv2.dto.template.config.BotConfig;
import com.ss.android.lark.forwardv2.dto.template.config.Condition;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.dto.template.config.GroupChatConfig;
import com.ss.android.lark.forwardv2.dto.template.config.ThreadConfig;
import com.ss.android.lark.forwardv2.dto.template.config.UserConfig;
import com.ss.android.lark.forwardv2.e;
import com.ss.android.lark.utils.FileType;
import com.ss.android.lark.utils.a0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r8, final String r9, String r10, long r11, boolean r13, final String r14) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "fileKey");
        Intrinsics.checkNotNullParameter(r10, "fileName");
        Intrinsics.checkNotNullParameter(r14, "messageId");
        ForwardTemplate.b r0 = new ForwardTemplate.b();
        ArrayList r1 = new ArrayList();
        EntityItem.b r2 = new EntityItem.b();
        Condition.TenantCondition r3 = Condition.TenantCondition.ALL_TENANT;
        Condition.UserTypeCondition r4 = Condition.UserTypeCondition.ALL_USER;
        Condition.ShieldTypeCondition r5 = Condition.ShieldTypeCondition.ALL;
        Condition.TenantCondition r6 = Condition.TenantCondition.ALL_TENANT;
        UserConfig r7 = new UserConfig();
        UserConfig.access$000(r7, r5);
        r7.setTenantCondition(r6);
        r7.setUserTypeCondition(r4);
        r2.d(r7);
        r1.add(r2.a());
        EntityItem.b r12 = new EntityItem.b();
        Condition.GroupChatTypeCondition r15 = Condition.GroupChatTypeCondition.ALL_CHAT;
        Condition.PublicTypeCondition r16 = Condition.PublicTypeCondition.ALL_STATUS;
        GroupChatConfig r17 = new GroupChatConfig();
        r17.setGroupChatTypeCondition(r15);
        r17.setTenantCondition(r6);
        GroupChatConfig.access$000(r17, r16);
        GroupChatConfig.access$100(r17, r5);
        r12.b(r17);
        r1.add(r12.a());
        EntityItem.b r18 = new EntityItem.b();
        r18.c = new BotConfig();
        r18.b = null;
        r18.a = null;
        r18.d = null;
        r18.e = null;
        r1.add(r18.a());
        EntityItem.b r19 = new EntityItem.b();
        Condition.ThreadTypeCondition r20 = Condition.ThreadTypeCondition.ALL_THREAD;
        ThreadConfig r21 = new ThreadConfig();
        ThreadConfig.access$000(r21, r16);
        ThreadConfig.access$100(r21, r6);
        r21.setThreadTypeCondition(r20);
        r19.c(r21);
        r1.add(r19.a());
        EntityItem.b r22 = new EntityItem.b();
        r22.e = new AIConfig();
        r22.c = null;
        r22.b = null;
        r22.a = null;
        r22.d = null;
        r1.add(r22.a());
        new ArrayList();
        BusinessRecentVisitIncludeConfig r23 = new BusinessRecentVisitIncludeConfig();
        r23.a = r1;
        r0.a = r23;
        if (r13 == false) goto L5;
        int r110 = FileType.TYPE_FOLDER.getResId(0);
    L6:
        String r111 = "（" + FileUtils.h(r11) + 65289;
        BasicDialogContent r112 = new BasicDialogContent();
        r112.a = null;
        r112.b = r10;
        r112.c = null;
        r112.d = r111;
        r112.e = r110;
        r112.g = null;
        r112.f = null;
        r112.h = null;
        r112.i = 0;
        r112.j = false;
        r112.k = false;
        com.ss.android.lark.storage.a r113 = FileDetailModule.a;
        hfb.b r114 = FileDetailModule.a.a();
        if (r114 == null) goto L9;
        ForwardEnhancedView r115 = r114.getForwardEnhancedView();
    L10:
        ForwardViewDependency r116 = new ForwardViewDependency();
        r116.i = true;
        r116.d = null;
        r116.e = r112;
        r116.a = true;
        r116.b = null;
        r116.c = null;
        r116.f = r115;
        r116.g = null;
        r116.h = null;
        r116.j = true;
        r0.e = r116;
        ForwardTargetFilter r117 = new ForwardTargetFilter();
        r117.a = false;
        r117.b = false;
        r117.d = true;
        r117.c = false;
        r117.e = false;
        r117.f = false;
        r117.g = false;
        r117.i = false;
        r117.h = true;
        r117.j = false;
        r0.d = r117;
        final WeakReference r118 = new WeakReference(r8);
        e.c(r8, r0.a(new ShareCopyFileForwardTemplateFactory$getExecutor$1(r9, r14, r118)));
        return;
    L9:
        r115 = null;
        goto L10
    L5:
        r110 = a0.b(BuildConfig.FLAVOR, r10, 0);
        goto L6
    }
}
