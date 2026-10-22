package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maincore.TabType;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.maintab.export.TabAppType;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g0 implements com.bytedance.ee.bear.lark.dependency.s {
    public g0() {
    }

    public final void isEnableWikiTab() {
    }

    public final boolean enableFgMainTabContainer() {
        vqb.a r0 = (vqb.a) ApiUtils.getApi(vqb.a.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.enableFgMainTabContainer();
    }

    public final TabType getTabType() {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).getTabType();
    }

    public final void a(Context r1) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).P0();
    }

    public final void b(wb5.d r12) {
        if (enableFgMainTabContainer() == true) goto L5;
        return;
    L5:
        vqb.a r0 = (vqb.a) ApiUtils.getApi(vqb.a.class);
        if (r0 == null) goto L20;
        if (r12 == null) goto L21;
        String r1 = c(r12.getType(), r12.f);
        if (r1.equals("icon_file-unknow_colorful") == true) goto L18;
    L16:
        String r3 = r12.b;
        TabAppInfo.BizType r4 = TabAppInfo.BizType.CCM;
        TabAppType r5 = TabAppType.APP_TYPE_URL;
        String r6 = r12.c;
        TabAppInfo.CustomNavigationAppLogoType r7 = TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_UD_TOKEN;
        com.ss.android.lark.maintab.export.a r2 = new com.ss.android.lark.maintab.export.a(r3, r4, r5, r6, r7, r1, r12.d, "");
        r2.i = Integer.toString(r12.getType());
        r0.addVisitRecord(r2);
        return;
    L18:
        int r8 = CastIntegerProtector.parseInt(r12.f);     // Catch: Throwable -> L13
    L15:
        r1 = c(r8, r12.f);
    L13:
        th = move-exception;
        Log.e("SafeParseUtils", th.getMessage());
        r8 = -1;
        goto L15
    L21:
        return;
    }

    public static String c(int r1, String r2) {
        int r0 = lmb.a.a;
        Intrinsics.checkNotNullParameter(r2, "subType");
        if (r1 != sbb.e.g.b) goto L6;
        return "icon_file-doc_colorful";
    L6:
        if (r1 != sbb.e.h.b) goto L9;
        return "icon_file-sheet_colorful";
    L9:
        if (r1 != sbb.e.i.b) goto L12;
        return "icon_file-bitable_colorful";
    L12:
        if (r1 != sbb.e.k.b) goto L15;
        return "icon_file-mindnote_colorful";
    L15:
        if (r1 != sbb.e.m.b) goto L18;
        return "icon_wiki-slides_colorful";
    L18:
        if (r1 != sbb.e.o.b) goto L21;
        return "icon_file-docx_colorful";
    L21:
        if (r1 == sbb.e.l.b) goto L23;
    L130:
        return "icon_file-unknow_colorful";
    L23:
        if (TextUtils.isEmpty(r2) == true) goto L130;
        String r3 = r2.toLowerCase();
        Iterator r4 = ArrayIteratorKt.iterator(rbb.e.a);
    L27:
        if (r4.hasNext() == false) goto L31;
        if (TextUtils.equals((String) r4.next(), r3) == false) goto L27;
        return "icon_file-image_colorful";
    L31:
        Iterator r5 = ArrayIteratorKt.iterator(rbb.e.b);
    L33:
        if (r5.hasNext() == false) goto L37;
        if (TextUtils.equals((String) r5.next(), r3) == false) goto L33;
        return "icon_file-video_colorful";
    L37:
        Iterator r6 = ArrayIteratorKt.iterator(rbb.e.c);
    L39:
        if (r6.hasNext() == false) goto L44;
        if (TextUtils.equals((String) r6.next(), r3) == false) goto L39;
        return "icon_file-audio_colorful";
    L44:
        if (TextUtils.equals("pdf", r3) == false) goto L46;
        return "icon_file-pdf_colorful";
    L46:
        Iterator r7 = ArrayIteratorKt.iterator(rbb.e.d);
    L48:
        if (r7.hasNext() == false) goto L52;
        if (TextUtils.equals((String) r7.next(), r3) == false) goto L48;
        return "icon_file-text_colorful";
    L52:
        Iterator r8 = ArrayIteratorKt.iterator(rbb.e.e);
    L54:
        if (r8.hasNext() == false) goto L58;
        if (TextUtils.equals((String) r8.next(), r3) == false) goto L54;
        return "icon_file-code_colorful";
    L58:
        Iterator r9 = ArrayIteratorKt.iterator(rbb.e.f);
    L60:
        if (r9.hasNext() == false) goto L64;
        if (TextUtils.equals((String) r9.next(), r3) == false) goto L60;
        return "icon_file-word_colorful";
    L64:
        Iterator r10 = ArrayIteratorKt.iterator(rbb.e.g);
    L66:
        if (r10.hasNext() == false) goto L70;
        if (TextUtils.equals((String) r10.next(), r3) == false) goto L66;
        return "icon_file-excel_colorful";
    L70:
        Iterator r11 = ArrayIteratorKt.iterator(rbb.e.h);
    L72:
        if (r11.hasNext() == false) goto L77;
        if (TextUtils.equals((String) r11.next(), r3) == false) goto L72;
        return "icon_file-ppt_colorful";
    L77:
        if (TextUtils.equals("pages", r3) == false) goto L80;
        return "icon_file-pages_colorful";
    L80:
        if (TextUtils.equals("numbers", r3) == false) goto L82;
        return "icon_file-numbers_colorful";
    L82:
        Iterator r12 = ArrayIteratorKt.iterator(rbb.e.i);
    L84:
        if (r12.hasNext() == false) goto L88;
        if (TextUtils.equals((String) r12.next(), r3) == false) goto L84;
        return "icon_file-keynote_colorful";
    L88:
        Iterator r13 = ArrayIteratorKt.iterator(rbb.e.j);
    L90:
        if (r13.hasNext() == false) goto L94;
        if (TextUtils.equals((String) r13.next(), r3) == false) goto L90;
        return "icon_file-zip_colorful";
    L94:
        Iterator r14 = ArrayIteratorKt.iterator(rbb.e.k);
    L96:
        if (r14.hasNext() == false) goto L100;
        if (TextUtils.equals((String) r14.next(), r3) == false) goto L96;
        return "icon_file-md_colorful";
    L100:
        Iterator r15 = ArrayIteratorKt.iterator(rbb.e.l);
    L102:
        if (r15.hasNext() == false) goto L107;
        if (TextUtils.equals((String) r15.next(), r3) == false) goto L102;
        return "icon_file-ps_colorful";
    L107:
        if (TextUtils.equals("ipa", r3) == false) goto L110;
        return "icon_file-ios_colorful";
    L110:
        if (TextUtils.equals("apk", r3) == false) goto L113;
        return "icon_file-android_colorful";
    L113:
        if (TextUtils.equals("aep", r3) == false) goto L116;
        return "icon_file-ae_colorful";
    L116:
        if (TextUtils.equals("ai", r3) == false) goto L119;
        return "icon_file-ai_colorful";
    L119:
        if (TextUtils.equals("sketch", r3) == false) goto L122;
        return "icon_file-sketch_colorful";
    L122:
        if (TextUtils.equals("csv", r3) == false) goto L125;
        return "icon_file-csv_colorful";
    L125:
        if (TextUtils.equals("eml", r3) == false) goto L128;
        return "icon_file-eml_colorful";
    L128:
        if (TextUtils.equals("msg", r3) == false) goto L130;
        return "icon_file-msg_colorful";
    }

    public final void launchMainWindow(Context r1, String r2, Bundle r3) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).T0();
    }
}
