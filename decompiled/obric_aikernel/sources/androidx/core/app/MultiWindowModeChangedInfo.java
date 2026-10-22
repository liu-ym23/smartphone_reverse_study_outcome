package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class MultiWindowModeChangedInfo {
    private final boolean mIsInMultiWindowMode;
    private final Configuration mNewConfig;

    public MultiWindowModeChangedInfo(boolean r10) {
        this.mIsInMultiWindowMode = r10;
        this.mNewConfig = null;
    }

    @RequiresApi(26)
    public MultiWindowModeChangedInfo(boolean r10, @NonNull Configuration r11) {
        this.mIsInMultiWindowMode = r10;
        this.mNewConfig = r11;
    }

    @NonNull
    @RequiresApi(26)
    public Configuration getNewConfig() {
        Configuration r10 = this.mNewConfig;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
    }

    public boolean isInMultiWindowMode() {
        return this.mIsInMultiWindowMode;
    }
}
