package com.larus.bmhome.chat.markdown.reference;

import com.larus.im.bean.message.Reference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public static final boolean a(SearchReferenceData r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        String r1 = r3.getTitle();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L62;
        List<Reference> r4 = r3.getReference();
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L62;
        List<String> r6 = r3.getQueries();
        if (r6 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == false) goto L62;
        String r8 = r3.getSearchLoadingText();
        if (r8 != null) goto L32;
    L35:
        boolean r9 = true;
    L36:
        if (r9 == false) goto L62;
        String r10 = r3.getIcon();
        if (r10 != null) goto L40;
    L43:
        boolean r11 = true;
    L44:
        if (r11 == false) goto L62;
        String r12 = r3.getIconDark();
        if (r12 != null) goto L48;
    L51:
        boolean r13 = true;
    L52:
        if (r13 == false) goto L62;
        String r14 = r3.getToolType();
        if (r14 != null) goto L56;
    L59:
        boolean r15 = true;
    L60:
        if (r15 == false) goto L62;
        return true;
    L56:
        if (r14.length() == 0) goto L59;
        r15 = false;
        goto L60
    L48:
        if (r12.length() == 0) goto L51;
        r13 = false;
        goto L52
    L40:
        if (r10.length() == 0) goto L43;
        r11 = false;
        goto L44
    L32:
        if (r8.length() == 0) goto L35;
        r9 = false;
        goto L36
    L24:
        if (r6.isEmpty() == true) goto L27;
        r7 = false;
        goto L28
    L16:
        if (r4.isEmpty() == true) goto L19;
        r5 = false;
    L62:
        return false;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public static final boolean b(SearchReferenceData r2) {
        if (r2 == null) goto L11;
        Integer r3 = r2.getStage();
        int r1 = Stage.Searched.getValue();
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.intValue() != r1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static final boolean c(SearchReferenceData r2) {
        if (r2 == null) goto L11;
        Integer r3 = r2.getStage();
        int r1 = Stage.Searching.getValue();
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.intValue() != r1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static final boolean d(ToolType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1 != ToolType.SearchPlugin) goto L5;
    L18:
        return true;
    L5:
        if (r1 == ToolType.ScholarSearch) goto L18;
        if (r1 == ToolType.ImageAnalysis) goto L18;
        if (r1 == ToolType.SearchImage) goto L18;
        if (r1 == ToolType.TextSearchImage) goto L18;
        if (r1 == ToolType.CodeRunning) goto L18;
        if (r1 == ToolType.BrowserControl) goto L18;
        return false;
    }
}
