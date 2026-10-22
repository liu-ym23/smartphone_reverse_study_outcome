package com.ss.ugc.effectplatform.util;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.UrlModel;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h {
    public static final h a = null;

    public h() {
    }

    static {
        a = new h();
    }

    public static String b(ProviderEffect r0) {
        ProviderEffect.StickerBean r1 = r0.getSticker_info();
        if (r1 == null) goto L7;
        String r2 = r1.getUrl();
        if (r2 == null) goto L7;
        return r2;
    L7:
        return "";
    }

    public static boolean c(UrlModel r2) {
        if (r2 == null) goto L15;
        List<String> r3 = r2.getUrl_list();
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r3.isEmpty() == true) goto L10;
        r4 = false;
        goto L11
    L15:
        return true;
    }

    public static List a(List r3, String r4) {
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        ArrayList r0 = new ArrayList();
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        r0.add(((String) r5.next()) + r4);
        goto L6
    L11:
        return r0;
    L8:
        return null;
    }

    public static void e(String r17, List r18) {
        if (r18 != null) goto L5;
        return;
    L5:
        Iterator r1 = r18.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Effect r2 = (Effect) r1.next();
        StringBuilder r3 = new StringBuilder();
        r3.append(r17);
        String r4 = FileManager.a;
        r3.append(r4);
        r3.append(StringsKt.replace$default(StringsKt.replace$default(r2.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
        r3.append(".zip");
        r2.setZipPath(r3.toString());
        r2.setUnzipPath(r17 + r4 + StringsKt.replace$default(StringsKt.replace$default(r2.getId(), "\"", "_", false, 4, null), "/", "_", false, 4, null));
        goto L7
    }

    public static void f(String r2, List r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L12;
        Effect r0 = (Effect) r4.next();
        if (r.b(r2) == true) goto L6;
        if (r2 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r0.setRecId(r2);
        goto L6
    }

    public static void g(String r16, List r17) {
        if (r17 == null) goto L26;
        Iterator r1 = r17.iterator();
    L6:
        if (r1.hasNext() == false) goto L38;
        InfoStickerEffect r2 = (InfoStickerEffect) r1.next();
        Integer r3 = r2.getSource();
        if (r3 == null) goto L13;
        if (r3.intValue() != 1) goto L13;
        Effect r4 = r2.getLoki_effect();
        StringBuilder r5 = new StringBuilder();
        r5.append(r16);
        String r6 = FileManager.a;
        r5.append(r6);
        r5.append(r2.getLoki_effect().getId());
        r5.append(".zip");
        r4.setZipPath(r5.toString());
        r2.getLoki_effect().setUnzipPath(r16 + r6 + r2.getLoki_effect().getId());
    L13:
        if (r3 == null) goto L6;
        if (r3.intValue() != 2) goto L6;
        h r7 = a;
        ProviderEffect r8 = r2.getSticker();
        r7.getClass();
        String r9 = b(r8);
        int r15 = StringsKt.lastIndexOf$default(r9, "/", 0, false, 6, null);
        int r11 = StringsKt.lastIndexOf$default(r9, ".", 0, false, 6, null);
        int r10 = StringsKt.lastIndexOf$default(r9, "?", 0, false, 6, null);
        if (1 > r15) goto L24;
        if (r11 <= r15) goto L24;
        if (r11 < r10) goto L23;
        r10 = r9.length();
    L23:
        String r12 = r9.substring(r11, r10);
    L25:
        r2.getSticker().setPath(r16 + FileManager.a + r2.getSticker().getId() + "_" + r9.hashCode() + r12);
    L24:
        r12 = "";
        goto L25
    L38:
        return;
    }

    public static void h(List r11, List r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        Iterator r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L99;
        Effect r0 = (Effect) r13.next();
        if (r0.getFile_url().getUrl_type() == null) goto L15;
        Integer r1 = r0.getFile_url().getUrl_type();
        if (r1 == null) goto L23;
        if (r1.intValue() == 0) goto L15;
    L23:
        if (r0.getIcon_url().getUrl_type() == null) goto L30;
        Integer r2 = r0.getIcon_url().getUrl_type();
        if (r2 != null) goto L28;
    L37:
        List<String> r3 = r0.getHint_icon().getUrl_list();
        boolean r4 = true;
        if (r3 != null) goto L40;
    L43:
        boolean r5 = true;
    L44:
        if (r5 == true) goto L58;
        if (r0.getHint_icon().getUrl_type() == null) goto L52;
        Integer r6 = r0.getHint_icon().getUrl_type();
        if (r6 == null) goto L58;
        if (r6.intValue() != 0) goto L58;
    L52:
        UrlModel r7 = r0.getHint_icon();
        List<String> r8 = a(r11, r0.getHint_icon().getUri());
        if (r8 != null) goto L56;
        r8 = new ArrayList();
    L56:
        r7.setUrl_list(r8);
    L58:
        if (r0.getDesigner_avatar().getUrl_type() == null) goto L64;
        Integer r9 = r0.getDesigner_avatar().getUrl_type();
        if (r9 != null) goto L63;
    L79:
        List<UrlModel> r10 = r0.getCovers();
        if (r10 == null) goto L6;
        Iterator<T> r14 = r10.iterator();
    L83:
        if (r14.hasNext() == false) goto L6;
        UrlModel r15 = (UrlModel) r14.next();
        if (r15.getUrl_type() == null) goto L92;
        Integer r16 = r15.getUrl_type();
        if (r16 == null) goto L83;
        if (r16.intValue() != 0) goto L83;
    L92:
        if (r15.getUri() != null) goto L93;
        Logger.e$default(Logger.INSTANCE, "EffectUtils", "effect " + r0.getId() + " covers uri is null", null, 4, null);
        goto L83
    L93:
        h r17 = a;
        String r18 = r15.getUri();
        r17.getClass();
        List<String> r19 = a(r11, r18);
        if (r19 != null) goto L97;
        r19 = new ArrayList();
    L97:
        r15.setUrl_list(r19);
        goto L83
    L63:
        if (r9.intValue() != 0) goto L79;
    L64:
        List<String> r20 = r0.getDesigner_avatar().getUrl_list();
        if (r20 != null) goto L67;
    L70:
        if (r4 == false) goto L79;
        if (r0.getDesigner_avatar().getUri() == null) goto L78;
        UrlModel r21 = r0.getDesigner_avatar();
        h r22 = a;
        String r23 = r0.getDesigner_avatar().getUri();
        r22.getClass();
        List<String> r24 = a(r11, r23);
        if (r24 != null) goto L77;
        r24 = new ArrayList();
    L77:
        r21.setUrl_list(r24);
        goto L79
    L78:
        Logger.e$default(Logger.INSTANCE, "EffectUtils", "effect " + r0.getId() + " designer avatar uri is null", null, 4, null);
        goto L79
    L67:
        if (r20.isEmpty() == true) goto L70;
        r4 = false;
        goto L70
    L40:
        if (r3.isEmpty() == true) goto L43;
        r5 = false;
        goto L44
    L28:
        if (r2.intValue() != 0) goto L37;
    L30:
        if (r0.getIcon_url().getUri() == null) goto L36;
        UrlModel r25 = r0.getIcon_url();
        h r26 = a;
        String r27 = r0.getIcon_url().getUri();
        r26.getClass();
        List<String> r28 = a(r11, r27);
        if (r28 != null) goto L35;
        r28 = new ArrayList();
    L35:
        r25.setUrl_list(r28);
        goto L37
    L36:
        Logger.e$default(Logger.INSTANCE, "EffectUtils", "effect " + r0.getId() + " icon uri is null", null, 4, null);
    L15:
        if (r0.getFile_url().getUri() == null) goto L21;
        UrlModel r29 = r0.getFile_url();
        h r30 = a;
        String r31 = r0.getFile_url().getUri();
        r30.getClass();
        List<String> r32 = a(r11, r31);
        if (r32 != null) goto L20;
        r32 = new ArrayList();
    L20:
        r29.setUrl_list(r32);
        goto L23
    L21:
        Logger.e$default(Logger.INSTANCE, "EffectUtils", "effect " + r0.getId() + " file uri is null", null, 4, null);
        goto L23
    }

    public static void d(String r4, String r5, List r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L12;
        Effect r0 = (Effect) r7.next();
        StringBuilder r1 = new StringBuilder();
        r1.append(r4);
        String r2 = FileManager.a;
        r1.append(r2);
        r1.append(r0.getId());
        r1.append(".zip");
        r0.setZipPath(r1.toString());
        r0.setUnzipPath(r4 + r2 + r0.getId());
        if (r5 == null) goto L10;
        String r3 = r5;
    L11:
        r0.setPanel(r3);
        goto L6
    L10:
        r3 = "";
        goto L11
    }
}
