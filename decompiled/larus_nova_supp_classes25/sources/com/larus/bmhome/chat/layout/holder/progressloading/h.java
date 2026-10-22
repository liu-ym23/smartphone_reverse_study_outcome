package com.larus.bmhome.chat.layout.holder.progressloading;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.layout.holder.image.ImageHolderDispatcher;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import hq9.v3;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new f());
        b = LazyKt.lazy(new g());
    }

    public static LoadingType a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (dp8.a.a(r2) == false) goto L7;
        return LoadingType.IMAGE_SCROLL_LOADING;
    L7:
        if (((v3) a.getValue()).a != 0) goto L10;
        return null;
    L10:
        if (d(r2) == true) goto L12;
        return null;
    L12:
        if (((Boolean) b.getValue()).booleanValue() == true) goto L16;
        return LoadingType.TEXT_PROGRESS_LOADING;
    L16:
        if (b0.h(r2) == false) goto L20;
        return LoadingType.COMMON_LOADING;
    L20:
        if (((Boolean) ImageHolderDispatcher.a.getValue()).booleanValue() == true) goto L35;
        ImageContentData r3 = ImageHolderDispatcher.a(e(r2));
        if (r3 == null) goto L29;
        List<ImageItem> r4 = r3.getImageList();
        if (r4 == null) goto L29;
        boolean r0 = true;
        if (r4.size() != 1) goto L29;
    L30:
        if (r0 == false) goto L33;
        return LoadingType.SINGLE_IMAGE_LOADING;
    L33:
        return LoadingType.IMAGE4_LOADING;
    L29:
        r0 = false;
        goto L30
    L35:
        return LoadingType.IMAGE_SCROLL_LOADING;
    }

    public static String b(Message r4) {
        if (com.larus.im.bean.message.a.r0(r4) == false) goto L12;
        Map r0 = r4.getExt();
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("message_id");
    L8:
        FLogger.a.i("ProgressLoadingHolderDispatcher", "getResultMessageId result msgId of serverLoading " + r1);
        if (o0.d(r1) == false) goto L12;
        return r1;
    L7:
        r1 = null;
    L12:
        return r4.getMessageId();
    }

    public static boolean c(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (com.larus.bmhome.chat.bean.d.a0(r2) == false) goto L5;
        return false;
    L5:
        LoadingType r3 = a(r2);
        if (r3 != LoadingType.IMAGE_SCROLL_LOADING) goto L8;
    L11:
        return true;
    L8:
        if (r3 == LoadingType.SINGLE_IMAGE_LOADING) goto L11;
        if (r3 == LoadingType.IMAGE4_LOADING) goto L11;
        return false;
    }

    public static boolean d(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"image", "avatar_image", "ai_beautify_image"}), ap8.a.b(r4)) == false) goto L7;
        if (com.larus.im.bean.message.a.r0(r4) == false) goto L7;
        return true;
    L7:
        if (r4.getContentType() != 6) goto L16;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (b0.h(r4) == true) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L16;
        return true;
    L11:
        if (r4.getContentType() != 6) goto L13;
        r5 = true;
    L16:
        return false;
    }

    public static Message e(Message r46) {
        Intrinsics.checkNotNullParameter(r46, "<this>");
        String r0 = ap8.a.b(r46);
        if (r0 == null) goto L55;
        int r2 = r0.hashCode();
        if (r2 == (-2096799662)) goto L18;
        if (r2 == (-578836747)) goto L15;
        if (r2 != 100313435) goto L55;
        if (r0.equals("image") == false) goto L55;
    L21:
        if (Intrinsics.areEqual(ap8.a.b(r46), "image") == false) goto L23;
    L26:
        JsonObject r1 = new JsonObject();
        JsonArray r3 = new JsonArray();
        Map r4 = r46.getExt();
        int r5 = 1;
        if (r4 == null) goto L33;
        String r6 = (String) r4.get("creativity_resp_num");
        if (r6 == null) goto L33;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L33;
        int r8 = r7.intValue();
    L34:
        Map r9 = r46.getExt();
        int r10 = 300;
        if (r9 == null) goto L41;
        String r11 = (String) r9.get("creativity_img_width_scale");
        if (r11 == null) goto L41;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L41;
        int r13 = r12.intValue();
    L42:
        Map r14 = r46.getExt();
        if (r14 == null) goto L49;
        String r15 = (String) r14.get("creativity_img_height_scale");
        if (r15 == null) goto L49;
        Integer r16 = StringsKt.toIntOrNull(r15);
        if (r16 == null) goto L49;
        r10 = r16.intValue();
    L49:
        if (1 > r8) goto L53;
    L50:
        JsonObject r17 = new JsonObject();
        r17.addProperty("key", "image_sketch_loading_" + r5);
        r17.addProperty("key", "image_sketch_loading_" + r5);
        JsonObject r18 = new JsonObject();
        r18.addProperty("width", Integer.valueOf(r13));
        r18.addProperty("height", Integer.valueOf(r10));
        r17.add("image_ori", r18);
        r3.add(r17);
        if (r5 == r8) goto L53;
        r5 = r5 + 1;
    L53:
        r1.add("image_list", r3);
        return Message.copy$default(r46, null, null, null, 0, 0, null, 6, false, null, r1.toString(), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -577, 31, null);
    L41:
        r13 = 300;
    L33:
        r8 = 1;
        goto L34
    L23:
        if (Intrinsics.areEqual(ap8.a.b(r46), "avatar_image") == true) goto L26;
        if (Intrinsics.areEqual(ap8.a.b(r46), "ai_beautify_image") == false) goto L55;
    L15:
        if (r0.equals("avatar_image") == false) goto L55;
    L18:
        if (r0.equals("ai_beautify_image") == true) goto L21;
    L55:
        return r46;
    }
}
