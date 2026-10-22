package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
public abstract class EmojiSpan extends ReplacementSpan {
    private short mHeight;

    @NonNull
    private final EmojiMetadata mMetadata;
    private float mRatio;
    private final Paint.FontMetricsInt mTmpFontMetrics;
    private short mWidth;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    EmojiSpan(@NonNull EmojiMetadata r10) {
        this.mTmpFontMetrics = new Paint.FontMetricsInt();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRatio = 1.0f;
        Preconditions.checkNotNull(r10, "metadata cannot be null");
        this.mMetadata = r10;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getHeight() {
        return this.mHeight;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getId() {
        return getMetadata().getId();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final EmojiMetadata getMetadata() {
        return this.mMetadata;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    final float getRatio() {
        return this.mRatio;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint r10, @SuppressLint({"UnknownNullness"}) CharSequence r11, int r12, int r13, @Nullable Paint.FontMetricsInt r14) {
        r10.getFontMetricsInt(this.mTmpFontMetrics);
        Paint.FontMetricsInt r15 = this.mTmpFontMetrics;
        this.mRatio = (Math.abs(r15.descent - r15.ascent) * 1.0f) / this.mMetadata.getHeight();
        this.mHeight = (short) (this.mMetadata.getHeight() * this.mRatio);
        short r16 = (short) (this.mMetadata.getWidth() * this.mRatio);
        this.mWidth = r16;
        if (r14 == null) goto L5;
        Paint.FontMetricsInt r17 = this.mTmpFontMetrics;
        r14.ascent = r17.ascent;
        r14.descent = r17.descent;
        r14.top = r17.top;
        r14.bottom = r17.bottom;
    L5:
        return r16;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    final int getWidth() {
        return this.mWidth;
    }
}
