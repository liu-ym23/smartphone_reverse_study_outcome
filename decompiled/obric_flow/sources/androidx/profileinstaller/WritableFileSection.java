package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    public WritableFileSection(@NonNull FileSectionType r5, int r10, @NonNull byte[] r11, boolean r12) {
        this.mType = r5;
        this.mExpectedInflateSize = r10;
        this.mContents = r11;
        this.mNeedsCompression = r12;
    }
}
