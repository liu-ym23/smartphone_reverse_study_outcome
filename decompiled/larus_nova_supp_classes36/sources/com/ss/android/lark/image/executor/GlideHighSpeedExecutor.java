package com.ss.android.lark.image.executor;

import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.custom.FiloBlockingQueue;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.rustinfrabridge.netstate.impl.d;
import com.ss.android.lark.storage.a;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class GlideHighSpeedExecutor {
    public static final a a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static GlideExecutor f;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$GlideHighSpeedExecutorConfig;", "", "sceneEnable", "Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$SceneEnable;", "filoBlockingQueueEnable", "", "threadCount", "Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$ThreadCount;", "<init>", "(Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$SceneEnable;ILcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$ThreadCount;)V", "getSceneEnable", "()Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$SceneEnable;", "setSceneEnable", "(Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$SceneEnable;)V", "getFiloBlockingQueueEnable", "()I", "setFiloBlockingQueueEnable", "(I)V", "getThreadCount", "()Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$ThreadCount;", "setThreadCount", "(Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$ThreadCount;)V", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class GlideHighSpeedExecutorConfig {

        @SerializedName("filo_blocking_queue_enable")
        private int filoBlockingQueueEnable;

        @SerializedName("scene_enable")
        private SceneEnable sceneEnable;

        @SerializedName("thread_count")
        private ThreadCount threadCount;

        public GlideHighSpeedExecutorConfig() {
            this(null, 0, null, 7, null);
        }

        public final int getFiloBlockingQueueEnable() {
            return this.filoBlockingQueueEnable;
        }

        public final SceneEnable getSceneEnable() {
            return this.sceneEnable;
        }

        public final ThreadCount getThreadCount() {
            return this.threadCount;
        }

        public final void setFiloBlockingQueueEnable(int r1) {
            this.filoBlockingQueueEnable = r1;
        }

        public final void setSceneEnable(SceneEnable r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.sceneEnable = r2;
        }

        public final void setThreadCount(ThreadCount r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.threadCount = r2;
        }

        public GlideHighSpeedExecutorConfig(SceneEnable r2, int r3, ThreadCount r4) {
            Intrinsics.checkNotNullParameter(r2, "sceneEnable");
            Intrinsics.checkNotNullParameter(r4, "threadCount");
            this.sceneEnable = r2;
            this.filoBlockingQueueEnable = r3;
            this.threadCount = r4;
        }

        public /* synthetic */ GlideHighSpeedExecutorConfig(SceneEnable r7, int r8, ThreadCount r9, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L6;
            int r1 = 0;
            r7 = new SceneEnable(r1, r1, 3, null);
        L6:
            if ((r10 & 2) == 0) goto L9;
            r8 = 1;
        L9:
            if ((r10 & 4) == 0) goto L11;
            r9 = new ThreadCount(0, 0, 0, 7, null);
        L11:
            this(r7, r8, r9);
        }
    }

    @AppConfig(key = "glide_high_speed_executor_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$GlideHighSpeedExecutorSettings;", "", "<init>", "()V", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class GlideHighSpeedExecutorSettings {
        public GlideHighSpeedExecutorSettings() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$SceneEnable;", "", "feedAvatarEnable", "", "chatEncryptEnable", "<init>", "(II)V", "getFeedAvatarEnable", "()I", "setFeedAvatarEnable", "(I)V", "getChatEncryptEnable", "setChatEncryptEnable", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class SceneEnable {

        @SerializedName("chat_encrypt_enable")
        private int chatEncryptEnable;

        @SerializedName("feed_avatar_enable")
        private int feedAvatarEnable;

        public SceneEnable() {
            int r2 = 0;
            this(r2, r2, 3, null);
        }

        public final int getChatEncryptEnable() {
            return this.chatEncryptEnable;
        }

        public final int getFeedAvatarEnable() {
            return this.feedAvatarEnable;
        }

        public final void setChatEncryptEnable(int r1) {
            this.chatEncryptEnable = r1;
        }

        public final void setFeedAvatarEnable(int r1) {
            this.feedAvatarEnable = r1;
        }

        public SceneEnable(int r1, int r2) {
            this.feedAvatarEnable = r1;
            this.chatEncryptEnable = r2;
        }

        public /* synthetic */ SceneEnable(int r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 1;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = 1;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/image/executor/GlideHighSpeedExecutor$ThreadCount;", "", "high", "", "middle", "low", "<init>", "(III)V", "getHigh", "()I", "setHigh", "(I)V", "getMiddle", "setMiddle", "getLow", "setLow", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ThreadCount {

        @SerializedName("high")
        private int high;

        @SerializedName("low")
        private int low;

        @SerializedName("middle")
        private int middle;

        public ThreadCount() {
            this(0, 0, 0, 7, null);
        }

        public final int getHigh() {
            return this.high;
        }

        public final int getLow() {
            return this.low;
        }

        public final int getMiddle() {
            return this.middle;
        }

        public final void setHigh(int r1) {
            this.high = r1;
        }

        public final void setLow(int r1) {
            this.low = r1;
        }

        public final void setMiddle(int r1) {
            this.middle = r1;
        }

        public ThreadCount(int r1, int r2, int r3) {
            this.high = r1;
            this.middle = r2;
            this.low = r3;
        }

        public /* synthetic */ ThreadCount(int r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = 12;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = 8;
        L9:
            if ((r4 & 4) == 0) goto L11;
            r3 = 4;
        L11:
            this(r1, r2, r3);
        }
    }

    public GlideHighSpeedExecutor() {
    }

    static {
        a = new a("Image");
        b = LazyKt.lazy(GlideHighSpeedExecutor$FIRST_OPEN_APP_RECORD$2.INSTANCE);
        c = LazyKt.lazy(GlideHighSpeedExecutor$isFirstOpenApp$2.INSTANCE);
        d = LazyKt.lazy(GlideHighSpeedExecutor$config$2.INSTANCE);
        e = LazyKt.lazy(GlideHighSpeedExecutor$sceneEnable$2.INSTANCE);
    }

    @JvmStatic
    public static final GlideExecutor a() {
        List r0 = d.a;
        d.b.a.getClass();
        Object r1 = LarkNetworkLevelManager.d;
        NetworkLevelListener.NetworkLevel r2 = LarkNetworkLevelManager.a.a().getCurNetWorkLevel();
        if (f != null) goto L23;
        if (r2 == NetworkLevelListener.NetworkLevel.EVALUATING) goto L23;
        Lazy r3 = d;
        int r4 = ((GlideHighSpeedExecutorConfig) r3.getValue()).getThreadCount().getLow();
        if (r2 != NetworkLevelListener.NetworkLevel.EXCELLENT) goto L9;
        boolean r5 = true;
    L10:
        Lazy r6 = c;
        if (((Boolean) r6.getValue()).booleanValue() == false) goto L15;
        if (r5 == false) goto L15;
        r4 = ((GlideHighSpeedExecutorConfig) r3.getValue()).getThreadCount().getHigh();
    L18:
        Log.i("GlideHighSpeedExecutor", "get high speed executor, netLevel:" + r2 + ", threadCount:" + r4);
        GlideExecutor.Builder r7 = GlideExecutor.newSourceBuilder().setName("lk-high-custom-source").setThreadCount(r4);
        if (((GlideHighSpeedExecutorConfig) r3.getValue()).getFiloBlockingQueueEnable() != 1) goto L21;
        r7.setWorkQueue(new FiloBlockingQueue());
    L21:
        f = r7.build();
    L15:
        if (((Boolean) r6.getValue()).booleanValue() == true) goto L17;
        if (r5 == false) goto L18;
    L17:
        r4 = ((GlideHighSpeedExecutorConfig) r3.getValue()).getThreadCount().getMiddle();
        goto L18
    L9:
        r5 = false;
    L23:
        return f;
    }
}
