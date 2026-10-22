package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TypefaceEmojiSpan extends EmojiSpan {

    @Nullable
    private static Paint sDebugPaint;

    public TypefaceEmojiSpan(@NonNull EmojiMetadata r5) {
        super(r5);
    }

    @NonNull
    private static Paint getDebugPaint() {
        if (sDebugPaint != null) goto L6;
        TextPaint r5 = new TextPaint();
        sDebugPaint = r5;
        r5.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
        sDebugPaint.setStyle(Paint.Style.FILL);
    L6:
        return sDebugPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas r10, @SuppressLint({"UnknownNullness"}) CharSequence r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, float r14, int r15, int r16, int r17, @NonNull Paint r18) {
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled() == false) goto L5;
        r10.drawRect(r14, r15, r14 + getWidth(), r17, getDebugPaint());
    L5:
        getMetadata().draw(r10, r14, r16, r18);
    }
}
