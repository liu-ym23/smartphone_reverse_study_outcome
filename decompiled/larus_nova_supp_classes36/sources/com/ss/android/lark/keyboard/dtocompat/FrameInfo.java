package com.ss.android.lark.keyboard.dtocompat;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/dtocompat/FrameInfo;", "Ljava/io/Serializable;", "path", "", "width", "", "height", "<init>", "(Ljava/lang/String;II)V", "getPath", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FrameInfo implements Serializable {
    private final int height;
    private final String path;
    private final int width;

    public final int getHeight() {
        return this.height;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }

    public FrameInfo(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "path");
        this.path = r2;
        this.width = r3;
        this.height = r4;
    }
}
