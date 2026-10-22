package com.obric.memorydata.markdown.stream;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/markdown/stream/LinkColorStyleSpan;", "Landroid/text/style/CharacterStyle;", TypedValues.Custom.S_COLOR, "", "<init>", "(I)V", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class g extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10020a;

    public g(int r1) {
        this.f10020a = r1;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "textPaint");
        r2.setColor(this.f10020a);
        r2.setUnderlineText(false);
    }
}
