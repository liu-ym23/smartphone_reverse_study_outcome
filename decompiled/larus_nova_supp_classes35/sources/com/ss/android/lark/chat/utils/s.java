package com.ss.android.lark.chat.utils;

import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(FileContentVO r2) {
        Intrinsics.checkNotNullParameter(r2, "contentVO");
        Map<String, PreviewHangPoint> r3 = r2.j();
        if (r3.isEmpty() == true) goto L15;
        Iterator<Map.Entry<String, PreviewHangPoint>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L16;
        if (r4.next().getValue().isValidCardData() == false) goto L7;
        return true;
    L16:
        return false;
    L15:
        return false;
    }

    public static boolean c(y6b.a r1) {
        Intrinsics.checkNotNullParameter(r1, "messageVO");
        if (l1.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (ReplyInThreadUtil.b(r1) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean b(jdb.g r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "fgService");
        Intrinsics.checkNotNullParameter(r8, IPortraitService.NAME);
        boolean r1 = r7.isEnable("messenger.message.online_edit_excel");
        boolean r2 = r7.isEnable("ccm.slides.im_ppt_message_new_card");
        boolean r3 = r7.isEnable("ccm.ai.markdown_preview_in_im");
        boolean r9 = r7.isEnable("ccm.ai.html_preview_in_im");
        if (r3 == false) goto L16;
        Intrinsics.checkNotNullParameter(r8, IPortraitService.NAME);
        String r4 = FileUtils.m(r8);
        if (StringsKt.equals(".md", r4, true) == false) goto L7;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L16;
    L55:
        return true;
    L7:
        if (StringsKt.equals(".markdown", r4, true) == true) goto L14;
        if (StringsKt.equals(".mdown", r4, true) == true) goto L14;
        if (StringsKt.equals(".mkdn", r4, true) == true) goto L14;
        r5 = false;
    L16:
        if (r1 == false) goto L39;
        String r6 = FileUtils.m(r8);
        if (StringsKt.equals(".xls", r6, true) == false) goto L20;
    L37:
        boolean r10 = true;
    L38:
        if (r10 == true) goto L55;
    L20:
        if (StringsKt.equals(".xlsx", r6, true) == true) goto L37;
        if (StringsKt.equals(".xlsm", r6, true) == true) goto L37;
        if (StringsKt.equals(".xlt", r6, true) == true) goto L37;
        if (StringsKt.equals(".xltx", r6, true) == true) goto L37;
        if (StringsKt.equals(".xltm", r6, true) == true) goto L37;
        if (StringsKt.equals(".xlm", r6, true) == true) goto L37;
        if (StringsKt.equals(".csv", r6, true) == true) goto L37;
        if (StringsKt.equals(".et", r6, true) == true) goto L37;
        r10 = false;
    L39:
        if (r2 == true) goto L41;
    L42:
        if (r9 == false) goto L57;
        Intrinsics.checkNotNullParameter(r8, IPortraitService.NAME);
        String r11 = FileUtils.m(r8);
        if (StringsKt.equals(".html", r11, true) == false) goto L46;
    L53:
        boolean r12 = true;
    L54:
        if (r12 == true) goto L55;
        return false;
    L46:
        if (StringsKt.equals(".htm", r11, true) == true) goto L53;
        if (StringsKt.equals(".xhtml", r11, true) == true) goto L53;
        if (StringsKt.equals(".xht", r11, true) == true) goto L53;
        r12 = false;
        goto L54
    L57:
        return false;
    L41:
        if (StringsKt.equals(".pptx", FileUtils.m(r8), true) == true) goto L55;
        goto L42
    }
}
