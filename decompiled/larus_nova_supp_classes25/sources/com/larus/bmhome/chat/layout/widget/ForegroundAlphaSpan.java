package com.larus.bmhome.chat.layout.widget;

import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ForegroundAlphaSpan;", "Landroid/text/style/ForegroundColorSpan;", "Lio/noties/markwon/core/spans/MarkdownSpanInfo;", "color", "", "alpha", "<init>", "(II)V", "getAlpha", "()I", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ForegroundAlphaSpan extends ForegroundColorSpan implements io.noties.markwon.core.spans.o {
    public final int a;

    public final int getAlpha() {
        return this.a;
    }

    @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "textPaint");
        r2.setAlpha(this.a);
    }

    public ForegroundAlphaSpan(int r1, int r2) {
        super(r1);
        this.a = r2;
    }
}
