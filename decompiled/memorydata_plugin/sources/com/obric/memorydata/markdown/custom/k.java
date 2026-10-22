package com.obric.memorydata.markdown.custom;

import android.text.Spannable;
import android.text.Spanned;
import android.text.style.URLSpan;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000b\u001a\u00020\u0005JM\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\n¢\u0006\u0002\u0010\u0018JY\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/markdown/custom/PlainUrlSpanUtils;", "", "<init>", "()V", "TAG", "", "log", "", NotificationCompat.CATEGORY_MESSAGE, "isLikelyUrl", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "extractUrls", "", "annotate", "spannable", "Landroid/text/Spannable;", "urls", "underlineColor", "", "gapPx", "thicknessPx", "textColor", "bold", "(Landroid/text/Spannable;Ljava/util/List;Ljava/lang/Integer;IILjava/lang/Integer;Z)V", "applySpan", CommonConsts.APM_INNER_EVENT_COST_START, "end", "url", "(Landroid/text/Spannable;IILjava/lang/String;Ljava/lang/Integer;IILjava/lang/Integer;Z)V", "hasOverlap", "s", "Landroid/text/Spanned;", "st", "en", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f9995a = null;

    static {
        f9995a = new k();
    }

    private k() {
    }

    private final void a(Spannable r16, int r17, int r18, String r19, Integer r20, int r21, int r22, Integer r23, boolean r24) {
        Spannable r2 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r16, Spannable.class, "com.obric.memorydata.plugin");
        l r13 = new l(r20, r22, r21);
        r2.setSpan(new b(r19, r23, r24, r13, null, (d) ZeusTransformUtils.preCheckCast(new n(null, 1, null), d.class, "com.obric.memorydata.plugin"), 16, null), r17, r18, 33);
        r2.setSpan(r13, r17, r18, 33);
    }

    private final void a(String r3) {
        RunLog.INSTANCE.debug("PlainUrlSpanUtils", "[UrlSpanDebug] " + r3);
    }

    private final boolean a(Spanned r4, int r5, int r6) {
        Spanned r3 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r4, Spanned.class, "com.obric.memorydata.plugin");
        Object[] r7 = r3.getSpans(r5, r6, URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(r7, "getSpans(...)");
        if (r7.length != 0) goto L5;
        boolean r8 = true;
    L7:
        if ((!r8) == true) goto L21;
        Object[] r9 = r3.getSpans(r5, r6, CustomLinkSpan.class);
        Intrinsics.checkNotNullExpressionValue(r9, "getSpans(...)");
        if (r9.length != 0) goto L11;
        boolean r10 = true;
    L13:
        if ((!r10) == true) goto L21;
        Object[] r11 = r3.getSpans(r5, r6, b.class);
        Intrinsics.checkNotNullExpressionValue(r11, "getSpans(...)");
        if (r11.length != 0) goto L17;
        boolean r12 = true;
    L19:
        if ((!r12) == true) goto L21;
        return false;
    L17:
        r12 = false;
        goto L19
    L11:
        r10 = false;
    L21:
        return true;
    L5:
        r8 = false;
        goto L7
    }

    public final void a(Spannable r18, List<String> r19, Integer r20, int r21, int r22, Integer r23, boolean r24) {
        Spannable r12 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r18, Spannable.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "spannable");
        Intrinsics.checkNotNullParameter(r0, "urls");
        String r13 = r12.toString();
        a("=== annotate START === text='" + r13 + "', urls=" + r0);
        Iterator r14 = r0.iterator();
    L4:
        if (r14.hasNext() == false) goto L13;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L6:
        int r2 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), r15, r3, false, 4, null);
        if (r2 < 0) goto L4;
        int r9 = r2 + r15.length();
        a("annotate[urls]: matched '" + r15 + "' at " + r2 + '-' + r9);
        if (a((Spanned) ZeusTransformUtils.preCheckCast(r12, Spanned.class, "com.obric.memorydata.plugin"), r2, r9) == false) goto L11;
        a("annotate[urls]: skipped - span overlap");
    L12:
        r3 = r9;
        goto L6
    L11:
        a(r12, r2, r9, r15, r20, r21, r22, r23, r24);
        goto L12
    L13:
        a("=== annotate END ===");
    }
}
