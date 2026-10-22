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

    EmojiMetadata(@NonNull MetadataRepo r10, @IntRange(from = 0) int r11) {
        this.mHasGlyph = 0;
        this.mMetadataRepo = r10;
        this.mIndex = r11;
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> r10 = sMetadataItem;
        MetadataItem r11 = r10.get();
        if (r11 != null) goto L5;
        r11 = new MetadataItem();
        r10.set(r11);
    L5:
        this.mMetadataRepo.getMetadataList().list(r11, this.mIndex);
        return r11;
    }

    public void draw(@NonNull Canvas r10, float r11, float r12, @NonNull Paint r13) {
        Typeface r14 = this.mMetadataRepo.getTypeface();
        Typeface r15 = r13.getTypeface();
        r13.setTypeface(r14);
        int r16 = this.mIndex * 2;
        r10.drawText(this.mMetadataRepo.getEmojiCharArray(), r16, 2, r11, r12, r13);
        r13.setTypeface(r15);
    }

    public int getCodepointAt(int r10) {
        return getMetadataItem().codepoints(r10);
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
    public void setHasGlyph(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 2;
    L5:
        this.mHasGlyph = r11;
        return;
    L4:
        r11 = 1;
        goto L5
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(super.toString());
        r10.append(", id:");
        r10.append(Integer.toHexString(getId()));
        r10.append(", codepoints:");
        int r11 = getCodepointsLength();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append(Integer.toHexString(getCodepointAt(r12)));
        r10.append(" ");
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }
}
