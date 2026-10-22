package io.noties.markwon.f;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/noties/markwon/span/StandardLineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "height", "", "(I)V", "getHeight", "()I", "chooseHeight", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16543a;

    public c(int r2) {
        this.f16543a = r2;
        if (r2 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("Height: %d must be positive" + r2).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence r1, int r2, int r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter((CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin"), IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r6, "fm");
        int r7 = r6.descent - r6.ascent;
        if (r7 > 0) goto L5;
        return;
    L5:
        r6.descent = Math.round(r6.descent * ((this.f16543a * 1.0f) / r7));
        r6.ascent = r6.descent - this.f16543a;
    }
}
