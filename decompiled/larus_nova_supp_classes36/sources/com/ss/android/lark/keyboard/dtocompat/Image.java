package com.ss.android.lark.keyboard.dtocompat;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/keyboard/dtocompat/Image;", "Ljava/io/Serializable;", "urls", "", "", "width", "", "height", "token", "<init>", "(Ljava/util/List;IILjava/lang/String;)V", "getUrls", "()Ljava/util/List;", "getWidth", "()I", "getHeight", "getToken", "()Ljava/lang/String;", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Image implements Serializable {
    private final int height;
    private final String token;
    private final List<String> urls;
    private final int width;

    public final int getHeight() {
        return this.height;
    }

    public final String getToken() {
        return this.token;
    }

    public final List<String> getUrls() {
        return this.urls;
    }

    public final int getWidth() {
        return this.width;
    }

    public Image(List<String> r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "urls");
        Intrinsics.checkNotNullParameter(r5, "token");
        this.urls = r2;
        this.width = r3;
        this.height = r4;
        this.token = r5;
    }
}
