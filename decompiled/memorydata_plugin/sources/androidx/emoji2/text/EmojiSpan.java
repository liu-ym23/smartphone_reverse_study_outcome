package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class EmojiSpan extends ReplacementSpan {
    private short mHeight;
    private final EmojiMetadata mMetadata;
    private float mRatio;
    private final Paint.FontMetricsInt mTmpFontMetrics;
    private short mWidth;

    EmojiSpan(EmojiMetadata r2) {
        this.mTmpFontMetrics = new Paint.FontMetricsInt();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRatio = 1.0f;
        Preconditions.checkNotNull(r2, "metadata cannot be null");
        this.mMetadata = r2;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getId() {
        return getMetadata().getId();
    }

    public final EmojiMetadata getMetadata() {
        return this.mMetadata;
    }

    final float getRatio() {
        return this.mRatio;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        r1.getFontMetricsInt(this.mTmpFontMetrics);
        this.mRatio = (Math.abs(this.mTmpFontMetrics.descent - this.mTmpFontMetrics.ascent) * 1.0f) / this.mMetadata.getHeight();
        this.mHeight = (short) (this.mMetadata.getHeight() * this.mRatio);
        this.mWidth = (short) (this.mMetadata.getWidth() * this.mRatio);
        if (r5 == null) goto L6;
        r5.ascent = this.mTmpFontMetrics.ascent;
        r5.descent = this.mTmpFontMetrics.descent;
        r5.top = this.mTmpFontMetrics.top;
        r5.bottom = this.mTmpFontMetrics.bottom;
    L6:
        return this.mWidth;
    }

    final int getWidth() {
        return this.mWidth;
    }
}
