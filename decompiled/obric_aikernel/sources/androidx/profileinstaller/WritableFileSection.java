package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    WritableFileSection(@NonNull FileSectionType r10, int r11, @NonNull byte[] r12, boolean r13) {
        this.mType = r10;
        this.mExpectedInflateSize = r11;
        this.mContents = r12;
        this.mNeedsCompression = r13;
    }
}
