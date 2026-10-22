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
    public EmojiSpan(@NonNull EmojiMetadata r5) {
        this.mTmpFontMetrics = new Paint.FontMetricsInt();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRatio = 1.0f;
        Preconditions.checkNotNull(r5, "metadata cannot be null");
        this.mMetadata = r5;
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
    public final float getRatio() {
        return this.mRatio;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint r5, @SuppressLint({"UnknownNullness"}) CharSequence r10, int r11, int r12, @Nullable Paint.FontMetricsInt r13) {
        r5.getFontMetricsInt(this.mTmpFontMetrics);
        Paint.FontMetricsInt r14 = this.mTmpFontMetrics;
        this.mRatio = (Math.abs(r14.descent - r14.ascent) * 1.0f) / this.mMetadata.getHeight();
        this.mHeight = (short) (this.mMetadata.getHeight() * this.mRatio);
        short r15 = (short) (this.mMetadata.getWidth() * this.mRatio);
        this.mWidth = r15;
        if (r13 == null) goto L5;
        Paint.FontMetricsInt r16 = this.mTmpFontMetrics;
        r13.ascent = r16.ascent;
        r13.descent = r16.descent;
        r13.top = r16.top;
        r13.bottom = r16.bottom;
    L5:
        return r15;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final int getWidth() {
        return this.mWidth;
    }
}
