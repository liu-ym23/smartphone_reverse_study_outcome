package com.obric.memorydata.markdown.custom;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/markdown/custom/UnderlineMetaSpan;", "Landroid/text/style/CharacterStyle;", TypedValues.Custom.S_COLOR, "", "thicknessPx", "gapPx", "<init>", "(Ljava/lang/Integer;II)V", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getThicknessPx", "()I", "getGapPx", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f9996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9997b;
    private final int c;

    public l(Integer r1, int r2, int r3) {
        this.f9996a = r1;
        this.f9997b = r2;
        this.c = r3;
    }

    public final int a() {
        return this.f9997b;
    }

    public final int b() {
        return this.c;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
        Intrinsics.checkNotNullParameter(r1, "tp");
    }
}
