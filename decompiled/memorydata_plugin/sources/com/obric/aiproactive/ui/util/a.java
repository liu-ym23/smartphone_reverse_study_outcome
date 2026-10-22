package com.obric.aiproactive.ui.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016Jh\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/ui/util/AgentRunBulletListSpan;", "Landroid/text/style/LeadingMarginSpan;", "leadingMargin", "", "diameter", "", "markerColor", "<init>", "(IFI)V", "getLeadingMargin", "first", "", "drawLeadingMargin", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "x", "dir", "top", "baseline", "bottom", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "layout", "Landroid/text/Layout;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class a implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f6873b;
    private final int c;

    public a(int r1, float r2, int r3) {
        this.f6872a = r1;
        this.f6873b = r2;
        this.c = r3;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r13, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r12, "layout");
        if (r11 == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r13, Spanned.class) == false) goto L7;
        Spanned r14 = (Spanned) ZeusTransformUtils.preCheckCast(r13, Spanned.class, "com.obric.memorydata.plugin");
    L8:
        boolean r15 = false;
        if (r14 != null) goto L11;
    L13:
        if (r15 == false) goto L29;
        float r16 = this.f6873b / 2.0f;
        float r17 = r3;
        if (r4 <= 0) goto L18;
        float r18 = r17 + r16;
    L19:
        float r19 = r6 + ((r2.ascent() + r2.descent()) / 2.0f);
        int r20 = r2.getColor();
        Paint.Style r21 = r2.getStyle();
        r2.setColor(this.c);     // Catch: Throwable -> L23
        r2.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L23
        r1.drawCircle(r18, r19, r16, r2);     // Catch: Throwable -> L23
        r2.setColor(r20);
        r2.setStyle(r21);
        return;
    L23:
        th = move-exception;
        r2.setColor(r20);
        r2.setStyle(r21);
        throw th;
    L18:
        r18 = r17 - r16;
        goto L19
    L29:
        return;
    L11:
        if (r14.getSpanStart(this) != r9) goto L13;
        r15 = true;
        goto L13
    L7:
        r14 = null;
        goto L8
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r1) {
        return this.f6872a;
    }
}
