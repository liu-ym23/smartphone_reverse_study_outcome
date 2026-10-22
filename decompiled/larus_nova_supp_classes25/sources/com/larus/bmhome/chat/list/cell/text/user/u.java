package com.larus.bmhome.chat.list.cell.text.user;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.taskskill.model.SkillType;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.v2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u implements Function1 {
    public final /* synthetic */ UserTextCell a;
    public final /* synthetic */ com.larus.bmhome.chat.markdown.richtext.j b;

    public /* synthetic */ u(UserTextCell r1, com.larus.bmhome.chat.markdown.richtext.j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r24) {
        UserTextCell r2 = this.a;
        com.larus.bmhome.chat.markdown.richtext.j r1 = this.b;
        View r5 = (View) r24;
        int r3 = UserTextCell.z;
        Intrinsics.checkNotNullParameter(r5, "widget");
        r2.r.e();
        com.larus.bmhome.chat.markdown.richtext.r r4 = r1.e;
        boolean r6 = r4 instanceof com.larus.bmhome.chat.markdown.richtext.r.d;
        if (r6 == false) goto L6;
        String r7 = "skill";
    L16:
        r2.M(r7);
        boolean r8 = true;
        if ((r4 instanceof com.larus.bmhome.chat.markdown.richtext.r.a) == false) goto L40;
        com.larus.bmhome.chat.markdown.richtext.r.a r9 = (com.larus.bmhome.chat.markdown.richtext.r.a) r4;
        Message r10 = r2.h;
        if (r10 == null) goto L73;
        String r11 = r2.x(r10);
        UserTextCell$a r12 = r2.y(r10, r9.a);
        if (r12 == null) goto L24;
        r2.J(r5, r12);
        goto L73
    L24:
        String r13 = com.larus.im.bean.message.a.g(r10);
        if (r13 != null) goto L27;
    L30:
        if (r8 == false) goto L32;
        FLogger.a.i("UserTextCell", "attachment reference target not found in message");
        goto L73
    L32:
        Fragment r14 = lf8.a.d(r2);
        if (r14 == null) goto L73;
        LifecycleCoroutineScope r15 = LifecycleOwnerKt.getLifecycleScope(r14);
        if (r15 == null) goto L73;
        BuildersKt.launch$default(r15, null, null, new UserTextCell$openAttachmentReference$2(r2, r10, r9, r5, r11, null), 3, null);
        goto L73
    L27:
        if (StringsKt.isBlank(r13) == true) goto L30;
        r8 = false;
    L73:
        return Unit.INSTANCE;
    L40:
        if ((r4 instanceof com.larus.bmhome.chat.markdown.richtext.r.b) == false) goto L42;
        com.bytedance.router.i r16 = SmartRouter.buildRoute(r5.getContext(), "//flow/chat_page");
        r16.c.putExtras(BundleKt.bundleOf(new Pair[]{TuplesKt.to("argConversationId", ((com.larus.bmhome.chat.markdown.richtext.r.b) r4).a)}));
        r16.d();
        return Unit.INSTANCE;
    L42:
        if (r6 == true) goto L44;
        Uri r17 = UriProtector.parse(r1.d);
        IFlowSdkDepend r18 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r18 == null) goto L68;
        v2 r19 = r18.Y();
        if (r19 == null) goto L68;
        if (r19.a(r17) != true) goto L68;
    L69:
        if (r8 == true) goto L72;
        FLogger.a.i("UserTextCell", "resource click is not handled, scheme=" + r17.getScheme());
    L72:
        return Unit.INSTANCE;
    L68:
        r8 = false;
        goto L69
    L44:
        if (z2.a.enableMessageSkillDetailPage() == false) goto L75;
        com.larus.bmhome.chat.markdown.richtext.r.d r20 = (com.larus.bmhome.chat.markdown.richtext.r.d) r4;
        if (r20.getType() != SkillType.LOCAL.getValue()) goto L49;
        t19.s r21 = t19.s.a;
        Context r22 = r5.getContext();
        r21.getClass();
        t19.s.s(r22, 2131906718);
        return Unit.INSTANCE;
    L49:
        int r23 = d.a;
        Intrinsics.checkNotNullParameter(r20, "skill");
        String r25 = r20.b;
        String r26 = null;
        if (r25 != null) goto L52;
    L58:
        if (r26 != null) goto L60;
        FLogger.a.i("UserTextCell", "skill resource click is ignored because resource id is empty");
        return Unit.INSTANCE;
    L60:
        SmartRouter.buildRoute(r5.getContext(), r26).d();
        return Unit.INSTANCE;
    L52:
        if ((!StringsKt.isBlank(r25)) == false) goto L54;
        String r110 = r25;
    L55:
        if (r110 == null) goto L58;
        r26 = StringsKt.replace$default(StringsKt.replace$default("sslocal://lynxview_popup?bundle=template/skill-list/template.js&hide_nav_bar=1&show_loading=0&need_intercept_in_minor_mode=1&scene_key=skill_management&channel=flow_lynx_doubao_skill_template&use_anniex=1&loader_name=forest&enable_lynx_generic_fetcher=1&need_login_strict_mode=1&enable_prefetch=1&aid=482431&enable_securelink=1&sec_link_scene=im&gravity=bottom&height_percent=99&width_percent=100&pull_down_close=1&show_mask=1&mask_bg_color=00000036&radius=0&radius_use_dp=1&radius_top_left=24&radius_top_right=24&mix_container_type=annie&enable_pull_down_close=1&support_close_by_gesture=1&close_by_gesture=1&ninety_percent_screen=1&disable_outside_click_close=0&url=https%3A%2F%2Flf-doubao-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F11517%2Fgecko%2Fresource%2Fflow_lynx_doubao_skill_template%2Ftemplate%2Fskill-list%2Ftemplate.js%3Fenterprise_mode%3D1%26tenant_name%3DByteDance%26theme%3Dlight%26page_mode%3Ddetail_only%26display_mode%3Dnine_screen%26resource_type%3Dskill%26resource_id%3D<RESOURCE_ID>%26skill_type%3D<SKILL_TYPE>", "<RESOURCE_ID>", r110, false, 4, null), "<SKILL_TYPE>", String.valueOf(r20.getType()), false, 4, null);
        goto L58
    L54:
        r110 = null;
        goto L55
    L75:
        return Unit.INSTANCE;
    L6:
        if ((r4 instanceof com.larus.bmhome.chat.markdown.richtext.r.b) == false) goto L9;
        r7 = "conversation";
        goto L16
    L9:
        if ((r4 instanceof com.larus.bmhome.chat.markdown.richtext.r.c) == false) goto L11;
    L15:
        r7 = "attachment";
        goto L16
    L11:
        if ((r4 instanceof com.larus.bmhome.chat.markdown.richtext.r.a) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }
}
