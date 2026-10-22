package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.UserType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.service.ICreationMetadataService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.b2;
import tx9.c2;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SaveImageMenuHandler extends a {
    public SaveImageMenuHandler() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.SAVE_IMAGE.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r18, View r19, final ef8.b r20) {
        Intrinsics.checkNotNullParameter(r18, "item");
        Intrinsics.checkNotNullParameter(r19, "view");
        Intrinsics.checkNotNullParameter(r20, "menuContext");
        df8.a r0 = r20.f;
        if (r0 == null) goto L5;
        ImageItem r4 = r0.b;
    L7:
        if (r18.getId() != MenuActionType.SAVE_IMAGE.getType()) goto L100;
        JSONObject r1 = r20.l;
        if (r1 == null) goto L11;
        String r2 = r1.optString("creation_task_id");
    L12:
        if (r0 == null) goto L14;
        Integer r3 = Integer.valueOf(r0.a);
    L15:
        final UserCreationFromIM r7 = ICreationMetadataService.a.I(r20.a, r2, String.valueOf(r3));
        com.larus.platform.service.o r8 = com.larus.platform.service.o.a;
        JSONObject r9 = new JSONObject();
        SearchImageInfo r10 = r20.g;
        if (r10 == null) goto L18;
        String r11 = r10.getItemId();
    L19:
        r9.putOpt("pic_id", r11);
        r9.put("click_method", "long_press_answer");
        r9.put("click_from", "click_download");
        r9.put("enter_picture_method", "chat");
        r9.put("download_method", "click_share_panel_icon");
        r9.put("message_id", r20.a.getMessageId());
        if (r3 == null) goto L22;
        int r5 = r3.intValue();
    L23:
        r9.putOpt("position", Integer.valueOf(r5 + 1));
        com.larus.bmhome.chat.api.q0.a r6 = r20.b;
        if (r6 == null) goto L28;
        com.larus.bmhome.chat.component.cvs.y r12 = r6.u0();
        if (r12 == null) goto L28;
        String r13 = r12.getBotId();
    L29:
        r9.putOpt("bot_id", r13);
        r9.put("conversation_id", r20.a.getConversationId());
        r9.put("is_replica_gen", Intrinsics.areEqual(ap8.a.b(r20.a), "avatar_image") ? 1 : 0);
        Message r14 = r20.a;
        if (com.larus.bmhome.chat.bean.d.y(r14) == false) goto L32;
        r9.put("is_feely_img", "1");
    L33:
        r9.put("is_search_card", 0);
        r9.put("is_image_edit", Intrinsics.areEqual(ap8.a.b(r20.a), "ai_beautify_image") ? 1 : 0);
        r9.put("is_deep_thinking", l3.f(Boolean.valueOf(com.larus.im.bean.message.a.C0(r14))));
        r9.put("ai_create_show_mode", tz9.a.a(r14));
        r9.put("creation_task_id", r2);
        if (r4 == null) goto L38;
        ImageEntity r15 = r4.getRefImage();
        if (r15 == null) goto L38;
        String r16 = r15.getUrl();
    L39:
        if (r16 != null) goto L41;
    L44:
        int r17 = 1;
    L45:
        r9.put("has_original_image", r17 ^ 1);
        r9.put("is_ai_creation", 1);
        if (r20.a.getUserType() != UserType.HUMAN.value) goto L48;
        String r21 = "user";
    L49:
        r9.put("user_type", r21);
        if (r7 == null) goto L52;
        String r22 = r7.getCreationId();
    L53:
        r9.put("creation_id", r22);
        Unit r23 = Unit.INSTANCE;
        JSONObject r24 = r20.l;
        if (r24 == null) goto L58;
        Object r25 = r24.opt("_mixed_richmedia_download_trace");
        if (r25 == null) goto L58;
        r9.put("_mixed_richmedia_download_trace", r25);
    L58:
        Iterator r26 = c2.a.iterator();
    L60:
        if (r26.hasNext() == false) goto L66;
        String r27 = (String) r26.next();
        JSONObject r110 = r20.l;
        if (r110 == null) goto L60;
        Object r111 = r110.opt(r27);
        if (r111 == null) goto L60;
        r9.putOpt(r27, r111);
        goto L60
    L66:
        r9.put("is_general_agent", com.larus.im.bean.message.a.r(r20.a));
        r9.put("chat_id", com.larus.im.bean.message.a.s(r20.a));
        b2.f(r9, true);
        Unit r28 = Unit.INSTANCE;
        r8.reportEvent("picture_download", r9);
        if (r4 == null) goto L74;
        ImageEntity r29 = r4.getImageOrigin();
        if (r29 == null) goto L74;
        String r30 = r29.getUrl();
        if (r30 == null) goto L74;
    L73:
        String r112 = r30;
        if (r20.a.getUserType() == UserType.HUMAN.value) goto L94;
        if (r7 == null) goto L94;
        boolean r113 = true;
    L95:
        if (r113 == false) goto L99;
        IFlowSdkDepend r31 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r31 == null) goto L99;
        r31.D0();
        com.larus.home.impl.sdk.b1 r32 = com.larus.home.impl.sdk.b1.a;
        r32.c("chat_long_press_download");
        r32.d(r112);
    L99:
        ImageSave r33 = ImageSave.a;
        Map r114 = ICreationMetadataService.a.L(r7, r2);
        Function3 r115 = new r0(r20, r7);
        SaveImageMenuHandler$handleAction$5 r116 = new SaveImageMenuHandler$handleAction$5(r7, r2, r20, null);
        SaveImageMenuHandler$handleAction$6 r117 = new SaveImageMenuHandler$handleAction$6(r112, r4, r20, r113, null);
        r33.getClass();
        ImageSave.w(r112, r114, r115, r116, r117, r113);
    L94:
        r113 = false;
    L74:
        if (r4 == null) goto L78;
        ImageEntity r34 = r4.getImageThumb();
        if (r34 == null) goto L78;
        r30 = r34.getUrl();
    L79:
        if (r30 != null) goto L73;
        List r35 = com.larus.bmhome.chat.bean.d.g(r20.a).imageList;
        if (r35 == null) goto L87;
        Image r36 = (Image) CollectionsKt.firstOrNull(r35);
        if (r36 == null) goto L87;
        ImageObj r37 = r36.imageOri;
        if (r37 == null) goto L87;
        r30 = r37.url;
    L88:
        if (r30 != null) goto L73;
        return false;
    L87:
        r30 = null;
    L78:
        r30 = null;
        goto L79
    L52:
        r22 = null;
        goto L53
    L48:
        r21 = "bot";
        goto L49
    L41:
        if (StringsKt.isBlank(r16) == true) goto L44;
        r17 = 0;
    L38:
        r16 = null;
        goto L39
    L32:
        r9.put("is_feely_img", "0");
    L28:
        r13 = null;
        goto L29
    L22:
        r5 = 0;
        goto L23
    L18:
        r11 = null;
        goto L19
    L14:
        r3 = null;
        goto L15
    L11:
        r2 = null;
    L100:
        return false;
    L5:
        r4 = null;
        goto L7
    }
}
