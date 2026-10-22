package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JF\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/core/spans/CustomExtraLineHeightSpan;", "Lio/noties/markwon/core/spans/ExtraLineHeightSpan;", "blankLineMulti", "", "textLineMulti", "loading", "", "(FFZ)V", "chooseHeight", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "paint", "Landroid/text/TextPaint;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f16468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f16469b;
    private final boolean c;

    public h(float r1, float r2, boolean r3) {
        super(r1, r2);
        this.f16468a = r1;
        this.f16469b = r2;
        this.c = r3;
    }

    @Override // io.noties.markwon.core.spans.j, android.text.style.LineHeightSpan.WithDensity
    public void chooseHeight(CharSequence r8, int r9, int r10, int r11, int r12, Paint.FontMetricsInt r13, TextPaint r14) {
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L5;
        return;
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        if (r15 != null) goto L9;
        return;
    L9:
        Paint.FontMetricsInt r16 = r14.getFontMetricsInt();
        if ((r16.descent - r16.ascent) > 0) goto L13;
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r15, Spanned.class) == false) goto L32;
        ReplacementSpan[] r17 = (ReplacementSpan[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r15, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r9, r10, ReplacementSpan.class), ReplacementSpan[].class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r17 == null) goto L23;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r3 = r17.length;
        int r4 = 0;
    L17:
        if (r4 >= r3) goto L22;
        ReplacementSpan r5 = r17[r4];
        if ((!ZeusTransformUtils.instanceOf(r5, com.larus.business.markdown.api.b.class)) == false) goto L21;
        r2.add(r5);
    L21:
        r4 = r4 + 1;
        goto L17
    L22:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L24:
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L27;
    L28:
        r1 = true;
    L29:
        if (r1 == true) goto L32;
        return;
    L27:
        if (r19.isEmpty() == false) goto L29;
    L23:
        r18 = null;
    L32:
        if (j.a(r15.subSequence(r9, r10)) == true) goto L34;
    L38:
        float r7 = this.f16469b;
    L39:
        r13.ascent = Math.round(r16.ascent * r7);
        r13.descent = Math.round(r16.descent * r7);
        r13.top = Math.round(r16.top * r7);
        r13.bottom = Math.round(r16.bottom * r7);
        return;
    L34:
        if (this.c == true) goto L36;
    L37:
        r7 = this.f16468a;
        goto L39
    L36:
        if (r15.length() == (r10 - 1)) goto L38;
        goto L37
    }
}
