package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.bmhome.share.ShareScene;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationShareService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.v1;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v0 extends a {
    public v0() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.SHARE_IMAGE.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r91, View r92, ef8.b r93) {
        Intrinsics.checkNotNullParameter(r91, "item");
        Intrinsics.checkNotNullParameter(r92, "view");
        Intrinsics.checkNotNullParameter(r93, "menuContext");
        if (x0.a(r93) == false) goto L5;
        return true;
    L5:
        df8.a r6 = r93.f;
        String r1 = null;
        boolean r10 = false;
        if (r6 != null) goto L47;
        List r5 = com.larus.bmhome.chat.bean.d.g(r93.a).imageList;
        if (r5 == null) goto L46;
        Image r7 = (Image) CollectionsKt.firstOrNull(r5);
        if (r7 == null) goto L46;
        ImageObj r8 = r7.imageOri;
        if (r8 == null) goto L18;
        String r9 = r8.url;
        if (r9 == null) goto L18;
    L17:
        String r14 = r9;
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L27;
        r11.D0();
        com.larus.home.impl.sdk.b1 r12 = com.larus.home.impl.sdk.b1.a;
        r12.c("chat_long_press_share_save");
        r12.d(r14);
    L27:
        JSONObject r4 = r93.l;
        if (r4 == null) goto L30;
        String r13 = r4.optString("creation_task_id");
    L31:
        JSONObject r15 = r93.l;
        if (r15 == null) goto L34;
        Integer r45 = Integer.valueOf(r15.optInt("position"));
    L35:
        ICreationMetadataService.Companion r16 = ICreationMetadataService.a;
        Message r17 = r93.a;
        if (r45 == null) goto L38;
        String r18 = r45.toString();
    L39:
        UserCreationFromIM r19 = r16.I(r17, r13, r18);
        wc9.e r110 = r93.c();
        BotModel r111 = r93.a();
        String r22 = r93.a.getMessageId();
        String r46 = tz9.a.a(r93.a);
        Boolean r47 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r93.a));
        if (r19 == null) goto L42;
        r1 = r19.getCreationId();
    L42:
        com.larus.bmhome.share.panel.h r20 = new com.larus.bmhome.share.panel.h(r110, r111, null, null, null, null, r22, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r13, r45, r46, r47, null, null, null, null, null, null, null, null, null, r1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 1073741692, -4100, 1023);
        Context r112 = r92.getContext();
        if (r112 == null) goto L45;
        ICreationShareService.a.a(ICreationShareService.a, r112, r14, null, null, r20, r93.d, r19, null, null, 908);
        Unit r0 = Unit.INSTANCE;
    L45:
        return true;
    L38:
        r18 = null;
        goto L39
    L34:
        r45 = null;
        goto L35
    L30:
        r13 = null;
    L18:
        ImageObj r21 = r7.imageThumb;
        if (r21 == null) goto L21;
        r9 = r21.url;
    L22:
        if (r9 != null) goto L17;
        return false;
    L21:
        r9 = null;
    L46:
        return false;
    L47:
        ImageItem r113 = r6.b;
        IFlowSdkDepend r23 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        String r114 = "";
        if (r23 == null) goto L60;
        r23.D0();
        com.larus.home.impl.sdk.b1 r24 = com.larus.home.impl.sdk.b1.a;
        r24.c("chat_long_press_share_save");
        ImageEntity r25 = r113.getImageOrigin();
        if (r25 == null) goto L53;
        String r26 = r25.getUrl();
        if (r26 == null) goto L53;
    L57:
        if (r26 != null) goto L59;
        r26 = "";
    L59:
        r24.d(r26);
    L53:
        ImageEntity r27 = r113.getImageThumb();
        if (r27 == null) goto L56;
        r26 = r27.getUrl();
        goto L57
    L56:
        r26 = null;
    L60:
        ICreationReportService.Companion r115 = ICreationReportService.a;
        ky9.b r28 = r115.j().e();
        ImageShareClickMethod r116 = ImageShareClickMethod.LongPressMenuClick;
        r28.a(r116, r6, ap8.a.b(r93.a), r93.l);
        ky9.b r29 = r115.j().e();
        String r30 = ap8.a.b(r93.a);
        if (r30 == null) goto L63;
        Integer r31 = Integer.valueOf(ap8.a.d(r30));
    L64:
        com.larus.bmhome.share.panel.h r210 = r29.c(r116, r6, r31, r93.l, r93.a);
        FragmentActivity r2 = r92.getContext();
        if (r2 == null) goto L211;
        com.larus.bmhome.chat.api.q0.a r32 = r93.b;
        if (r32 == null) goto L69;
        LifecycleCoroutineScope r33 = r32.F9();
    L71:
        if (r33 == null) goto L91;
        ICreationShareService.Companion r34 = ICreationShareService.a;
        String[] r35 = new String[4];
        ImageEntity r36 = r113.getImageOrigin();
        if (r36 == null) goto L75;
        String r37 = r36.getUrl();
    L76:
        r35[0] = r37;
        ImageEntity r38 = r113.getPreviewImage();
        if (r38 == null) goto L79;
        String r39 = r38.getUrl();
    L80:
        r35[1] = r39;
        ImageEntity r40 = r113.getImageThumb();
        if (r40 == null) goto L83;
        String r41 = r40.getUrl();
    L84:
        r35[2] = r41;
        ImageEntity r42 = r113.getRawImage();
        if (r42 == null) goto L87;
        String r43 = r42.getUrl();
    L88:
        r35[3] = r43;
        if (r34.O(r2, r33, CollectionsKt.listOf(r35)) == false) goto L91;
        return true;
    L87:
        r43 = null;
        goto L88
    L83:
        r41 = null;
        goto L84
    L79:
        r39 = null;
        goto L80
    L75:
        r37 = null;
    L91:
        JSONObject r44 = r93.l;
        if (r44 == null) goto L94;
        String r48 = r44.optString("creation_task_id");
    L95:
        int r49 = r93.f.a;
        z2 r50 = z2.a;
        v1 r51 = r50.getCreationShareSettings().a();
        if (r51 != null) goto L98;
    L100:
        boolean r52 = false;
    L101:
        if (r52 == false) goto L200;
        v1 r53 = r50.getCreationShareSettings().a();
        if (r53 != null) goto L105;
    L107:
        boolean r54 = false;
    L109:
        if (r54 == false) goto L119;
        if (Intrinsics.areEqual(ap8.a.b(r93.a), "avatar_image") == true) goto L133;
        Integer r55 = r93.f.b.getTaskType();
        if (r55 != null) goto L116;
    L132:
        boolean r56 = true;
    L134:
        if (r56 == false) goto L200;
        ky9.b r57 = r115.j().e();
        df8.a r58 = r93.f;
        String r59 = ap8.a.b(r93.a);
        if (r59 == null) goto L138;
        Integer r117 = Integer.valueOf(ap8.a.d(r59));
    L139:
        com.larus.bmhome.share.panel.h r211 = r57.c(r116, r58, r117, r93.l, r93.a);
        if (Build.VERSION.SDK_INT > 26) goto L142;
    L161:
        ImageEntity r60 = r113.getPreviewImage();
        if (r60 == null) goto L164;
        String r61 = r60.getUrl();
    L165:
        String r62 = String.valueOf(r61);
    L166:
        String r212 = r62;
    L168:
        if ((r2 instanceof FragmentActivity) == false) goto L170;
        FragmentActivity r3 = r2;
    L171:
        if (r3 == null) goto L211;
        FragmentManager r63 = r3.getSupportFragmentManager();
        if (r63 == null) goto L211;
        IFlowSdkDepend r64 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r64 == null) goto L211;
        r64.r0();
        e2 r65 = e2.a;
        ImageEntity r66 = r113.getImageOrigin();
        if (r66 == null) goto L179;
        String r67 = r66.getUrl();
    L180:
        String r213 = String.valueOf(r67);
        ImageEntity r68 = r113.getRawImage();
        if (r68 == null) goto L183;
        String r214 = r68.getUrl();
    L185:
        if (ap8.a.c(r93.a) == true) goto L190;
        ImageEntity r69 = r113.getRefImage();
        if (r69 == null) goto L190;
        String r215 = r69.getUrl();
    L191:
        ShareScene r216 = ShareScene.IMAGE_VIEWER;
        ImageEntity r70 = r113.getImageOrigin();
        if (r70 == null) goto L194;
        long r310 = r70.getHeight();
    L195:
        ImageEntity r71 = r113.getImageOrigin();
        if (r71 == null) goto L198;
        long r217 = r71.getWidth();
    L199:
        sq9.i r72 = new sq9.i("share", r93.a.getMessageId(), null, 4);
        ICreationMetadataService.Companion r73 = ICreationMetadataService.a;
        r65.Z0(r63, new sq9.j(null, r212, r213, r214, r215, null, r211, r216, r217, r310, r72, r73.L(r73.I(r93.a, r48, String.valueOf(r49)), r48), 0, null, r113.getTaskType(), null, null, 110625));
        Unit r74 = Unit.INSTANCE;
        goto L211
    L198:
        r217 = -1;
        goto L199
    L194:
        r310 = -1;
    L190:
        r215 = null;
        goto L191
    L183:
        r214 = null;
        goto L185
    L179:
        r67 = null;
        goto L180
    L170:
        r3 = null;
        goto L171
    L164:
        r61 = null;
        goto L165
    L142:
        if (com.larus.bmhome.chat.bean.d.k(r93.a) == false) goto L161;
        ImageEntity r75 = r113.getPreviewImage();
        if (r75 == null) goto L146;
        r62 = r75.getUrlV2();
    L147:
        if (r62 != null) goto L150;
        r62 = "";
    L150:
        if (r62.length() != 0) goto L152;
        r10 = true;
    L152:
        if (r10 == false) goto L166;
        ImageEntity r76 = r113.getPreviewImage();
        if (r76 == null) goto L156;
        String r77 = r76.getUrl();
    L157:
        if (r77 == null) goto L160;
        r114 = r77;
    L160:
        r212 = r114;
        goto L168
    L156:
        r77 = null;
        goto L157
    L146:
        r62 = null;
        goto L147
    L138:
        r117 = null;
        goto L139
    L116:
        if (r55.intValue() != 5) goto L132;
    L133:
        r56 = false;
        goto L134
    L119:
        if (Intrinsics.areEqual(ap8.a.b(r93.a), "avatar_image") == true) goto L133;
        if (Intrinsics.areEqual(ap8.a.b(r93.a), "image") == true) goto L133;
        Integer r78 = r93.f.b.getTaskType();
        if (r78 != null) goto L126;
    L127:
        Integer r79 = r93.f.b.getTaskType();
        if (r79 == null) goto L132;
        if (r79.intValue() == 1) goto L133;
    L126:
        if (r78.intValue() == 5) goto L133;
    L105:
        if (r53.f() != true) goto L107;
        r54 = true;
    L200:
        ImageEntity r80 = r113.getImageOrigin();
        if (r80 == null) goto L206;
        String r81 = r80.getUrl();
        if (r81 == null) goto L206;
        String r118 = r81;
    L210:
        ICreationShareService.a.a(ICreationShareService.a, r2, r118, null, null, r210, r93.d, ICreationMetadataService.a.I(r93.a, r48, String.valueOf(r49)), r113.getTaskType(), null, 652);
        Unit r82 = Unit.INSTANCE;
    L206:
        ImageEntity r83 = r113.getImageThumb();
        if (r83 == null) goto L209;
        r1 = r83.getUrl();
    L209:
        r118 = r1;
        goto L210
    L98:
        if (r51.e() != true) goto L100;
        r52 = true;
        goto L101
    L94:
        r48 = null;
        goto L95
    L69:
        r33 = null;
    L211:
        return true;
    L63:
        r31 = null;
        goto L64
    }
}
