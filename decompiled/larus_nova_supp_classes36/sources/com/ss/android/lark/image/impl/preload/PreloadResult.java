package com.ss.android.lark.image.impl.preload;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\"\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/PreloadResult;", "", "scene", "", "sceneID", "imageKey", "startTime", "", "preloadingDuration", "", "state", "Lcom/ss/android/lark/image/impl/preload/ResultState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILcom/ss/android/lark/image/impl/preload/ResultState;)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getSceneID", "setSceneID", "getImageKey", "setImageKey", "getStartTime", "()J", "setStartTime", "(J)V", "getPreloadingDuration", "()I", "setPreloadingDuration", "(I)V", "getState", "()Lcom/ss/android/lark/image/impl/preload/ResultState;", "setState", "(Lcom/ss/android/lark/image/impl/preload/ResultState;)V", "toString", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PreloadResult {
    private String imageKey;
    private int preloadingDuration;
    private String scene;
    private String sceneID;
    private long startTime;
    private ResultState state;

    public String toString() {
        return "scene:" + this.scene + ",sceneID:" + this.sceneID + ",imageKey:" + this.imageKey + ",startTime:" + this.startTime + ",preloadingDuration:" + this.preloadingDuration + ",state:" + this.state.getValue();
    }

    public final String getImageKey() {
        return this.imageKey;
    }

    public final int getPreloadingDuration() {
        return this.preloadingDuration;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSceneID() {
        return this.sceneID;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final ResultState getState() {
        return this.state;
    }

    public final void setPreloadingDuration(int r1) {
        this.preloadingDuration = r1;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public final void setState(ResultState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.state = r2;
    }

    public PreloadResult(String r2, String r3, String r4, long r5, int r7, ResultState r8) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "sceneID");
        Intrinsics.checkNotNullParameter(r4, "imageKey");
        Intrinsics.checkNotNullParameter(r8, "state");
        this.scene = r2;
        this.sceneID = r3;
        this.imageKey = r4;
        this.startTime = r5;
        this.preloadingDuration = r7;
        this.state = r8;
    }
}
