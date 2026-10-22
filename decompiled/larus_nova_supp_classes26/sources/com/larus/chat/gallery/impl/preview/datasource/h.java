package com.larus.chat.gallery.impl.preview.datasource;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.LocalImageMeta;
import com.larus.im.bean.message.LocalVideoData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public static String b(MediaMetadataRetriever r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {9};
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        f06.d r4 = r6.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r19, r1, "java.lang.String", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r19.extractMetadata(9);
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static boolean c(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        List r7 = vd9.r.a(r6);
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L62;
        Block r0 = (Block) r8.next();
        if (r0.getBlockType() != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L47;
        BlockContent r1 = r0.getContent();
        if (r1 == null) goto L44;
        CreationBlock r2 = r1.getCreationBlock();
        if (r2 == null) goto L44;
        List r3 = r2.creations;
        if (r3 == null) goto L44;
        List r4 = r3;
        if ((r4 instanceof Collection) == true) goto L21;
    L23:
        Iterator r5 = r4.iterator();
    L25:
        if (r5.hasNext() == false) goto L41;
        CreationItem r9 = (CreationItem) r5.next();
        Integer r10 = r9.type;
        if (r10 != null) goto L30;
    L31:
        Integer r11 = r9.type;
        if (r11 != null) goto L35;
    L37:
        boolean r12 = false;
    L39:
        if (r12 == false) goto L25;
        boolean r13 = true;
    L42:
        if (r13 != true) goto L44;
        boolean r14 = true;
    L45:
        if (r14 == false) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L9;
        return true;
    L35:
        if (r11.intValue() != 4) goto L37;
    L38:
        r12 = true;
        goto L39
    L30:
        if (r10.intValue() == 3) goto L38;
    L41:
        r13 = false;
        goto L42
    L21:
        if (r4.isEmpty() == false) goto L23;
    L44:
        r14 = false;
    L47:
        r15 = false;
        goto L48
    L62:
        return false;
    L5:
        if (r7.isEmpty() == false) goto L7;
        return false;
    }

    public static String e(String r4) {
        Object r0 = null;
        if (r4 == null) goto L34;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 != null) goto L7;
        return null;
    L7:
        if (r5.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L36;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        if (StringsKt.startsWith(r5, "file://", true) == false) goto L19;
        r5 = UriProtector.parse(r5).getPath();     // Catch: Throwable -> L24
    L22:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r6) == true) goto L31;
        r0 = r6;
    L31:
        return (String) r0;
    L19:
        if (StringsKt.startsWith$default(r5, "/", false, 2, null) == true) goto L22;
        r5 = null;
    L24:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L36:
        return null;
    L9:
        r1 = false;
        goto L10
    L34:
        return null;
    }

    public static String f(LocalVideoData r2) {
        Cover r0 = r2.cover;
        String r1 = null;
        if (r0 == null) goto L7;
        LocalImageMeta r3 = r0.localImagePreview;
        if (r3 == null) goto L7;
        String r4 = r3.path;
    L8:
        String r5 = e(r4);
        if (r5 != null) goto L15;
        Cover r6 = r2.cover;
        if (r6 == null) goto L14;
        r1 = r6.key;
    L14:
        return e(r1);
    L15:
        return r5;
    L7:
        r4 = null;
        goto L8
    }

    public static String g(LocalImageData r1) {
        LocalImageMeta r2 = r1.localImageOriRaw;
        if (r2 == null) goto L9;
        String r3 = r2.path;
        if (r3 == null) goto L9;
        if ((!StringsKt.isBlank(r3)) == false) goto L9;
        return r3;
    L9:
        return null;
    }

    public static String h(String r2) {
        Object r0 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r2)) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L23;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r3 = Result.constructor-impl(Uri.fromFile(new PolarisFileWrapper(r2)).toString());     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r3) == true) goto L19;
        r0 = r3;
    L19:
        return (String) r0;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L23:
        return null;
    }

    public static String i(String r2) {
        if (r2 == null) goto L20;
        String r3 = StringsKt.trim(r2).toString();
        if (r3 == null) goto L20;
        if (r3.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L20;
        String r0 = h(e(r3));
        if (r0 != null) goto L19;
        return r3;
    L19:
        return r0;
    L9:
        r1 = false;
    L20:
        return null;
    }

    public static Map a(Message r4, boolean r5) {
        Pair[] r0 = new Pair[5];
        String r1 = r4.getMessageId();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[0] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r1);
        String r3 = r4.getConversationId();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0[1] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r3);
        if (r5 == false) goto L11;
        String r6 = "picture_detail";
    L12:
        r0[2] = TuplesKt.to("current_page", r6);
        r0[3] = TuplesKt.to("enter_from", "chat");
        String r7 = r4.getReplyId();
        if (r7 == null) goto L16;
        r2 = r7;
    L16:
        r0[4] = TuplesKt.to("reply_id", r2);
        Map r8 = MapsKt.mutableMapOf(r0);
        Map r9 = r4.getExt();
        if (r9 == null) goto L21;
        String r10 = (String) r9.get("req_id");
        if (r10 == null) goto L21;
        r8.put("req_id", r10);
    L21:
        return r8;
    L11:
        r6 = "video_detail";
        goto L12
    }

    public static String d(Message r2, int r3, int r4) {
        StringBuilder r0 = new StringBuilder("creation_");
        String r5 = r2.getMessageId();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.append(r5);
        r0.append('_');
        r0.append(r3);
        r0.append('_');
        r0.append(r4);
        return r0.toString();
    }
}
