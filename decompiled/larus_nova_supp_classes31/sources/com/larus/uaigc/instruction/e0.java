package com.larus.uaigc.instruction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.BigImagePhotoViewerDialog;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.l1;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.IFlowSdkDepend;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 implements BaseResourceViewHolder.a {
    public final /* synthetic */ MultiAttachmentSelectorWidget a;

    public e0(MultiAttachmentSelectorWidget r1) {
        this.a = r1;
    }

    public final boolean b(String r1, View r2) {
        BaseResourceViewHolder.a.a.a(r1, r2);
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [android.view.ViewGroup, com.larus.bmhome.instruction.base.AbsInstructionWidget, com.larus.uaigc.instruction.MultiAttachmentSelectorWidget] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(String r31, int r32, View r33) {
        Intrinsics.checkNotNullParameter(r31, "key");
        Intrinsics.checkNotNullParameter(r33, "v");
        int r5 = -1;
        if (r32 != 109) goto L5;
        MultiAttachmentSelectorWidget r0 = this.a;
        int r2 = MultiAttachmentSelectorWidget.m;
        r0.getClass();
        r0.o7(false, -1, false);
        r0.E7();
        return;
    L5:
        if (r32 == 110) goto L173;
        String r4 = "";
        switch(r32) {
            case 101: goto L172;
            case 102: goto L135;
            case 103: goto L35;
            case 104: goto L9;
            default: goto L224;
        };
    L9:
        MultiAttachmentSelectorWidget r3 = this.a;
        Iterator<ResourceItemBean> r6 = r3.h.iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        ResourceItemBean r7 = r6.next();
        if (Intrinsics.areEqual(r7.getKey(), r31) == false) goto L11;
        ResourceItemBean r8 = r7;
    L16:
        ResourceItemBean r9 = r8;
        if (r9 != null) goto L20;
        return;
    L20:
        if (r9.getResourceType() != ResourceType.VIDEO) goto L26;
        mt8.b r10 = r9.getVideo();
        if (r10 == null) goto L32;
        String r11 = r10.e;
        if (r11 == null) goto L32;
    L31:
        r4 = r11;
    L32:
        ry9.h r12 = r3.i;
        if (r12 == null) goto L213;
        r12.nE(r31, r4);
        return;
    L213:
        return;
    L26:
        Image r13 = r9.getImage();
        if (r13 == null) goto L32;
        r11 = r13.localResPath;
        if (r11 != null) goto L31;
    L15:
        r8 = null;
        goto L16
    L35:
        ?? r14 = this.a;
        Iterator<ResourceItemBean> r15 = r14.h.iterator();
        int r16 = 0;
    L37:
        if (r15.hasNext() == false) goto L42;
        if (Intrinsics.areEqual(r15.next().getKey(), r31) == true) goto L43;
        r16 = r16 + 1;
    L43:
        ResourceItemBean r17 = (ResourceItemBean) CollectionsKt.getOrNull(r14.h, r16);
        if (r17 == null) goto L46;
        ResourceType r18 = r17.getResourceType();
    L48:
        if (r18 == ResourceType.AUDIO) goto L226;
        if (r17 == null) goto L52;
        ResourceType r19 = r17.getResourceType();
    L54:
        if (r19 == ResourceType.VIDEO) goto L191;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L133
        if (r17 == null) goto L74;
        HashMap r111 = r17.getExt();     // Catch: Throwable -> L133
        if (r111 == null) goto L74;
        boolean r112 = Intrinsics.areEqual(r111.get("ext_show_re_select_layout"), Boolean.TRUE);     // Catch: Throwable -> L133
    L75:
        if (r112 == false) goto L77;
        r14.o7(true, r16, true);     // Catch: Throwable -> L133
    L131:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L133
        return;
    L77:
        ArrayList<ResourceItemBean> r113 = r14.h;     // Catch: Throwable -> L133
        ArrayList r114 = new ArrayList();     // Catch: Throwable -> L133
        Iterator<ResourceItemBean> r115 = r113.iterator();     // Catch: Throwable -> L133
    L79:
        if (r115.hasNext() == false) goto L86;
        ResourceItemBean r116 = r115.next();     // Catch: Throwable -> L133
        if (r116.getResourceType() != ResourceType.IMAGE) goto L83;
        boolean r117 = true;
    L84:
        if (r117 == false) goto L79;
        r114.add(r116);     // Catch: Throwable -> L133
        goto L79
    L83:
        r117 = false;
        goto L84
    L86:
        ArrayList r118 = new ArrayList();     // Catch: Throwable -> L133
        Iterator r119 = r114.iterator();     // Catch: Throwable -> L133
    L88:
        if (r119.hasNext() == false) goto L123;
        ResourceItemBean r120 = (ResourceItemBean) r119.next();     // Catch: Throwable -> L133
        Image r121 = r120.getImage();     // Catch: Throwable -> L133
        if (r121 == null) goto L92;
        String r122 = r121.localResPath;     // Catch: Throwable -> L133
    L94:
        if (o0.d(r122) == true) goto L96;
    L105:
        Image r20 = r120.getImage();     // Catch: Throwable -> L133
        if (r20 == null) goto L111;
        ImageObj r21 = r20.imageThumb;     // Catch: Throwable -> L133
        if (r21 == null) goto L111;
        String r22 = r21.url;     // Catch: Throwable -> L133
        if (r22 == null) goto L111;
    L118:
        if (o0.d(r22) == false) goto L120;
        n1 r123 = new n1(r22);     // Catch: Throwable -> L133
    L121:
        if (r123 == null) goto L88;
        r118.add(r123);     // Catch: Throwable -> L133
        goto L88
    L120:
        r123 = null;
    L111:
        Image r23 = r120.getImage();     // Catch: Throwable -> L133
        if (r23 == null) goto L116;
        ImageObj r24 = r23.imageOri;     // Catch: Throwable -> L133
        if (r24 == null) goto L116;
        r22 = r24.url;     // Catch: Throwable -> L133
    L116:
        r22 = null;
        goto L118
    L96:
        if (r122 != null) goto L98;
        String r25 = "";
    L100:
        if (new PolarisFileWrapper(r25).exists() == false) goto L105;
        if (r122 != null) goto L104;
        r122 = "";
    L104:
        r123 = new n1(Uri.fromFile(new PolarisFileWrapper(r122)).toString());     // Catch: Throwable -> L133
        goto L121
    L98:
        r25 = r122;
        goto L100
    L92:
        r122 = null;
        goto L94
    L123:
        Iterator r26 = r114.iterator();     // Catch: Throwable -> L133
        int r124 = 0;
    L125:
        if (r26.hasNext() == false) goto L130;
        if (Intrinsics.areEqual(((ResourceItemBean) r26.next()).getKey(), r31) == true) goto L128;
        r124 = r124 + 1;     // Catch: Throwable -> L133
        goto L125
    L128:
        r5 = r124;
    L130:
        new BigImagePhotoViewerDialog(r14.getContext(), r118, null, new uo8.k(MapsKt.mapOf(new Pair[]{TuplesKt.to("source", "send_img_holder"), TuplesKt.to("user_type", "user"), TuplesKt.to("enter_picture_method", "chat"), TuplesKt.to("enter_from", "chat"), TuplesKt.to("message_id", ""), TuplesKt.to("conversation_id", ""), TuplesKt.to("bot_id", "")}), CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.to("pic_id", r31)))), false, null, null, null, null, null, null, false, false, false, 32752).v(r5, r33, MultiAttachmentSelectorWidget.class.getName());     // Catch: Throwable -> L133
    L74:
        r112 = false;
    L133:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L191:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L64
        if (Intrinsics.areEqual(r17.getExt().get("ext_show_re_select_layout"), Boolean.TRUE) == false) goto L58;
        r14.o7(true, r16, true);     // Catch: Throwable -> L64
    L62:
        Object r28 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L64
    L66:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L215;
        r29.printStackTrace();
        com.larus.platform.service.g.a.ensureNotReachHere(r29);
        return;
    L215:
        return;
    L58:
        Fragment r30 = r14.getFragment();     // Catch: Throwable -> L64
        if (r30 == null) goto L62;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r30.getViewLifecycleOwner()), Dispatchers.getMain(), null, new MultiAttachmentSelectorWidget$handleClickOpen$1$1(r30, r17, r14, r16, null), 2, null);     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L66
    L52:
        r19 = null;
        goto L54
    L226:
        return;
    L46:
        r18 = null;
        goto L48
    L42:
        r16 = -1;
        goto L43
    L135:
        MultiAttachmentSelectorWidget r35 = this.a;
        Iterator<ResourceItemBean> r36 = r35.h.iterator();
    L137:
        if (r36.hasNext() == false) goto L141;
        ResourceItemBean r37 = r36.next();
        if (Intrinsics.areEqual(r37.getKey(), r31) == false) goto L137;
        ResourceItemBean r38 = r37;
    L142:
        ResourceItemBean r39 = r38;
        if (r39 != null) goto L146;
        return;
    L146:
        if (r39.getResourceType() != ResourceType.VIDEO) goto L152;
        mt8.b r40 = r39.getVideo();
        if (r40 == null) goto L158;
        String r41 = r40.e;
        if (r41 == null) goto L158;
    L157:
        r4 = r41;
    L158:
        ry9.h r42 = r35.i;
        if (r42 == null) goto L161;
        r42.w60(r31, r4, "click_remove");
    L161:
        r35.h.remove(r39);
        if (r39.getResourceType() != ResourceType.AVATAR) goto L169;
        com.larus.bmhome.view.actionbar.edit.c r43 = r35.getViewModel();
        if (r43 == null) goto L166;
        r43.setChosenAvatarInstructionStatus(false);
    L166:
        com.larus.bmhome.view.actionbar.edit.c r44 = r35.getViewModel();
        if (r44 == null) goto L169;
        r44.onAvatarBtnCancel();
    L169:
        r35.w7();
        r35.G7();
        r35.H7();
        mt8.a r45 = r35.f;
        if (r45 == null) goto L218;
        r45.e(r35.h);
        return;
    L218:
        return;
    L152:
        Image r46 = r39.getImage();
        if (r46 == null) goto L158;
        r41 = r46.localResPath;
        if (r41 != null) goto L157;
    L141:
        r38 = null;
        goto L142
    L172:
        MultiAttachmentSelectorWidget r47 = this.a;
        int r48 = MultiAttachmentSelectorWidget.m;
        r47.getClass();
        r47.o7(false, -1, false);
        r47.E7();
        return;
    L224:
        return;
    L173:
        MultiAttachmentSelectorWidget r49 = this.a;
        int r50 = MultiAttachmentSelectorWidget.m;
        Fragment r51 = r49.getFragment();
        if (r51 == null) goto L177;
        Context r52 = r51.getContext();
        if (r52 == null) goto L177;
    L178:
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.h() == false) goto L221;
        Bundle r53 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_create_from", "from_creation_combine_panel")});
        IFlowSdkDepend r54 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r54 == null) goto L222;
        r54.H();
        l1 r55 = l1.a;
        Fragment r56 = r49.getFragment();
        if (r56 == null) goto L185;
        FragmentActivity r57 = r56.getActivity();
    L186:
        Intrinsics.checkNotNull(r52);
        r55.d(r57, r52, r53);
        return;
    L185:
        r57 = null;
        goto L186
    L222:
        return;
    L221:
        return;
    L177:
        r52 = AppHost.a.getApplication().getApplicationContext();
        goto L178
    }
}
