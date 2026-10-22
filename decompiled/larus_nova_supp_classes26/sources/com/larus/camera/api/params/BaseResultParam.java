package com.larus.camera.api.params;

import com.larus.bmhome.music.applet.MusicAppletPage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0000H&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/larus/camera/api/params/BaseResultParam;", "Ljava/io/Serializable;", "<init>", "()V", MusicAppletPage.KEY_PATH, "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "width", "", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "size", "", "getSize", "()J", "setSize", "(J)V", "createdTime", "getCreatedTime", "setCreatedTime", "clone", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseResultParam implements Serializable {
    private long createdTime;
    private int height;
    private String path;
    private long size;
    private int width;

    public abstract BaseResultParam clone();

    public BaseResultParam() {
        this.path = "";
        this.createdTime = System.currentTimeMillis();
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setCreatedTime(long r1) {
        this.createdTime = r1;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.path = r2;
    }

    public final void setSize(long r1) {
        this.size = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }
}
