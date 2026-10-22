package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EmojiMetadata {
    public static final int HAS_GLYPH_ABSENT = 1;
    public static final int HAS_GLYPH_EXISTS = 2;
    public static final int HAS_GLYPH_UNKNOWN = 0;
    private static final ThreadLocal<MetadataItem> sMetadataItem = null;
    private volatile int mHasGlyph;
    private final int mIndex;

    @NonNull
    private final MetadataRepo mMetadataRepo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    static {
        sMetadataItem = new ThreadLocal();
    }

    public EmojiMetadata(@NonNull MetadataRepo r5, @IntRange(from = 0) int r10) {
        this.mHasGlyph = 0;
        this.mMetadataRepo = r5;
        this.mIndex = r10;
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> r5 = sMetadataItem;
        MetadataItem r10 = r5.get();
        if (r10 != null) goto L5;
        r10 = new MetadataItem();
        r5.set(r10);
    L5:
        this.mMetadataRepo.getMetadataList().list(r10, this.mIndex);
        return r10;
    }

    public void draw(@NonNull Canvas r10, float r11, float r12, @NonNull Paint r13) {
        Typeface r5 = this.mMetadataRepo.getTypeface();
        Typeface r14 = r13.getTypeface();
        r13.setTypeface(r5);
        int r15 = this.mIndex * 2;
        r10.drawText(this.mMetadataRepo.getEmojiCharArray(), r15, 2, r11, r12, r13);
        r13.setTypeface(r14);
    }

    public int getCodepointAt(int r5) {
        return getMetadataItem().codepoints(r5);
    }

    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    public short getCompatAdded() {
        return getMetadataItem().compatAdded();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getHasGlyph() {
        return this.mHasGlyph;
    }

    public short getHeight() {
        return getMetadataItem().height();
    }

    public int getId() {
        return getMetadataItem().id();
    }

    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    @NonNull
    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    public short getWidth() {
        return getMetadataItem().width();
    }

    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void resetHasGlyphCache() {
        this.mHasGlyph = 0;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setHasGlyph(boolean r5) {
        if (r5 == false) goto L4;
        int r10 = 2;
    L5:
        this.mHasGlyph = r10;
        return;
    L4:
        r10 = 1;
        goto L5
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(super.toString());
        r5.append(", id:");
        r5.append(Integer.toHexString(getId()));
        r5.append(", codepoints:");
        int r10 = getCodepointsLength();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        r5.append(Integer.toHexString(getCodepointAt(r11)));
        r5.append(" ");
        r11 = r11 + 1;
        goto L3
    L6:
        return r5.toString();
    }
}
