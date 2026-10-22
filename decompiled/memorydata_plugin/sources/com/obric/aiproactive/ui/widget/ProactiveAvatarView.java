package com.obric.aiproactive.ui.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0004IJKLB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0018J\u0010\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u001cJ\u0010\u0010+\u001a\u00020#2\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0010\u0010.\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016H\u0002J\u0018\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0002J(\u00102\u001a\u00020#2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00162\u0006\u00103\u001a\u00020 H\u0002J(\u00104\u001a\u00020#2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00162\u0006\u00103\u001a\u00020 H\u0002J\u0018\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00162\u0006\u00103\u001a\u00020 H\u0002J\u0018\u00106\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00162\u0006\u00103\u001a\u00020 H\u0002J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\u0010\u0010:\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u00142\u0006\u0010$\u001a\u00020\u0016H\u0002J$\u0010<\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00142\n\u0010>\u001a\u00060?j\u0002`@H\u0002J\f\u0010A\u001a\u00020B*\u00020CH\u0002J\b\u0010D\u001a\u00020\fH\u0002J\b\u0010E\u001a\u00020FH\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0HH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundVideoView", "Lcom/obric/aiproactive/ui/widget/AvatarTextureVideoView;", "foregroundVideoView", "fallbackView", "Landroid/widget/ImageView;", "cachedFallbackBitmaps", "", "Landroid/graphics/Bitmap;", "cachedVideoPaths", "", "currentSource", "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$Source;", "transitionSpec", "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$TransitionSpec;", "playbackListener", "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$PlaybackListener;", "boundLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "useBackgroundAsForeground", "", "playbackGeneration", "", "playbackEnabled", "setSource", "", AILabCheckPermissionTask.KEY_SOURCE, "setTransitionSpec", "spec", "setPlaybackListener", "listener", "bindLifecycle", "owner", "onResume", "onStop", "onDestroy", "startPlayback", "prepareVideoLayers", "foreground", TraceCons.METRIC_BACKGROUND, "bindPlaybackCallbacks", PendingPersonalInfoNotificationTask.KEY_GENERATION, "startCrossfade", "fadeOutFallbackIfCurrent", "isCurrentPlayback", "pausePlayback", "release", "releaseVideoLayers", "showFallback", "ensureVideoCacheFile", "reportSourceFailure", "operation", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "toPublicError", "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$PlaybackError;", "Lcom/obric/aiproactive/ui/widget/AvatarTextureVideoView$PlaybackError;", "createVideoView", "matchParentLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViews", "", "Source", "TransitionSpec", "PlaybackError", "PlaybackListener", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveAvatarView extends FrameLayout implements DefaultLifecycleObserver {
    private final AvatarTextureVideoView backgroundVideoView;
    private LifecycleOwner boundLifecycleOwner;
    private final Map<Integer, Bitmap> cachedFallbackBitmaps;
    private final Map<Integer, String> cachedVideoPaths;
    private c currentSource;
    private final ImageView fallbackView;
    private final AvatarTextureVideoView foregroundVideoView;
    private boolean playbackEnabled;
    private long playbackGeneration;
    private b playbackListener;
    private d transitionSpec;
    private boolean useBackgroundAsForeground;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$PlaybackError;", "", "operation", "", "what", "", WsConstants.KEY_EXTRA, "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/String;IILjava/lang/Exception;)V", "getOperation", "()Ljava/lang/String;", "getWhat", "()I", "getExtra", "getCause", "()Ljava/lang/Exception;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6914b;
        private final int c;
        private final Exception d;

        public a(String r2, int r3, int r4, Exception r5) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            this.f6913a = r2;
            this.f6914b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final String a() {
            return this.f6913a;
        }

        public final int b() {
            return this.f6914b;
        }

        public final int c() {
            return this.c;
        }

        public final Exception d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6913a, r6.f6913a) == true) goto L12;
            return false;
        L12:
            if (this.f6914b == r6.f6914b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f6913a.hashCode() * 31) + Integer.hashCode(this.f6914b)) * 31) + Integer.hashCode(this.c)) * 31;
            Exception r2 = this.d;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "PlaybackError(operation=" + this.f6913a + ", what=" + this.f6914b + ", extra=" + this.c + ", cause=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$PlaybackListener;", "", "onFirstFrame", "", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$Source;", "onPlaybackError", "error", "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$PlaybackError;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            public static void a(b r2, c r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
            }
        }

        void a(c r1);

        void a(c r1, a r2);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$Source;", "", "videoResId", "", "fallbackResId", "<init>", "(II)V", "getVideoResId", "()I", "getFallbackResId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6916b;

        public c(int r1, int r2) {
            this.f6915a = r1;
            this.f6916b = r2;
        }

        public final int a() {
            return this.f6915a;
        }

        public final int b() {
            return this.f6916b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f6915a == r6.f6915a) goto L12;
            return false;
        L12:
            if (this.f6916b == r6.f6916b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f6915a) * 31) + Integer.hashCode(this.f6916b);
        }

        public String toString() {
            return "Source(videoResId=" + this.f6915a + ", fallbackResId=" + this.f6916b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$TransitionSpec;", "", "videoFadeInMillis", "", "previousVideoFadeOutMillis", "fallbackFadeOutDelayMillis", "fallbackFadeOutMillis", "<init>", "(JJJJ)V", "getVideoFadeInMillis", "()J", "getPreviousVideoFadeOutMillis", "getFallbackFadeOutDelayMillis", "getFallbackFadeOutMillis", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6918b;
        private final long c;
        private final long d;

        public d() {
            this(0, 0, 0, 0, 15, null);
        }

        public d(long r1, long r3, long r5, long r7) {
            this.f6917a = r1;
            this.f6918b = r3;
            this.c = r5;
            this.d = r7;
        }

        public /* synthetic */ d(long r9, long r11, long r13, long r15, int r17, DefaultConstructorMarker r18) {
            if ((r17 & 1) == 0) goto L5;
            long r0 = 120;
        L7:
            if ((r17 & 2) == 0) goto L9;
            long r2 = 350;
        L11:
            if ((r17 & 4) == 0) goto L13;
            long r4 = 80;
        L15:
            if ((r17 & 8) == 0) goto L17;
            long r6 = 180;
        L18:
            this(r0, r2, r4, r6);
            return;
        L17:
            r6 = r15;
            goto L18
        L13:
            r4 = r13;
            goto L15
        L9:
            r2 = r11;
            goto L11
        L5:
            r0 = r9;
            goto L7
        }

        public final long a() {
            return this.f6917a;
        }

        public final long b() {
            return this.f6918b;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (this.f6917a == r10.f6917a) goto L12;
            return false;
        L12:
            if (this.f6918b == r10.f6918b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Long.hashCode(this.f6917a) * 31) + Long.hashCode(this.f6918b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "TransitionSpec(videoFadeInMillis=" + this.f6917a + ", previousVideoFadeOutMillis=" + this.f6918b + ", fallbackFadeOutDelayMillis=" + this.c + ", fallbackFadeOutMillis=" + this.d + ')';
        }
    }

    public ProactiveAvatarView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ProactiveAvatarView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ProactiveAvatarView(Context r18, AttributeSet r19, int r20) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r19, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r3, r20);
        AvatarTextureVideoView r4 = createVideoView();
        this.backgroundVideoView = r4;
        AvatarTextureVideoView r5 = createVideoView();
        this.foregroundVideoView = r5;
        ImageView r6 = new ImageView(r1);
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(matchParentLayoutParams(), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r6.setVisibility(8);
        this.fallbackView = r6;
        this.cachedFallbackBitmaps = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.cachedVideoPaths = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.transitionSpec = new d(0, 0, 0, 0, 15, null);
        addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ ProactiveAvatarView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void bindPlaybackCallbacks(final AvatarTextureVideoView r9, final AvatarTextureVideoView r10, final c r11, final long r12) {
        r9.setOnPlaybackPendingListener(new $$Lambda$ProactiveAvatarView$i5LtZKxSJkkJ1uZ7DPMfaI4fbI(this, r11, r12, r9));
        r9.setOnPlaybackErrorListener(new $$Lambda$ProactiveAvatarView$bfzxew0vd3rDCE4Mbwqqkzkdp8Y(this, r11, r12, r9));
        r9.setOnFirstFrameListener(new $$Lambda$ProactiveAvatarView$uIDk0K5AP3i5whCc3TjRUMwIkU(this, r11, r12, r9, r10));
    }

    private static final Unit bindPlaybackCallbacks$lambda$4(ProactiveAvatarView r0, c r1, long r2, AvatarTextureVideoView r4) {
        if (r0.isCurrentPlayback(r1, r2) == false) goto L5;
        r4.animate().cancel();
        r4.setAlpha(0.0f);
        r0.showFallback(r1);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit bindPlaybackCallbacks$lambda$5(ProactiveAvatarView r1, c r2, long r3, AvatarTextureVideoView r5, AvatarTextureVideoView.a r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        if (r1.isCurrentPlayback(r2, r3) == false) goto L5;
        r1.showFallback(r2);
        r5.setVisibility(8);
        b r4 = r1.playbackListener;
        if (r4 == null) goto L10;
        r4.a(r2, r1.toPublicError(r6));
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit bindPlaybackCallbacks$lambda$6(ProactiveAvatarView r6, c r7, long r8, AvatarTextureVideoView r10, AvatarTextureVideoView r11) {
        if (r6.isCurrentPlayback(r7, r8) == false) goto L5;
        b r0 = r6.playbackListener;
        if (r0 == null) goto L9;
        r0.a(r7);
    L9:
        r6.startCrossfade(r10, r11, r7, r8);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final AvatarTextureVideoView createVideoView() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        AvatarTextureVideoView r6 = new AvatarTextureVideoView(r1, null, 0, 6, null);
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(matchParentLayoutParams(), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6.setVisibility(8);
        r6.setAlpha(0.0f);
        return r6;
    }

    private final String ensureVideoCacheFile(c r10) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.cachedVideoPaths.get(Integer.valueOf(r10.a())), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L37;
        if (new File(r0).exists() == false) goto L37;
        return r0;
    L37:
        File r3 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getResourceEntryName(r10.a()) + ".mp4");     // Catch: SecurityException -> L24 IOException -> L26
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").openRawResource(r10.a()), Closeable.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L24 IOException -> L26
        InputStream r4 = (InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r3), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        FileOutputStream r6 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r5, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L14
        ByteStreamsKt.copyTo$default(r4, (OutputStream) ZeusTransformUtils.preCheckCast(r6, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r1, null);     // Catch: SecurityException -> L24 IOException -> L26
        String r2 = r3.getAbsolutePath();     // Catch: SecurityException -> L24 IOException -> L26
        this.cachedVideoPaths.put(Integer.valueOf(r10.a()), r2);     // Catch: SecurityException -> L24 IOException -> L26
        return r2;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: SecurityException -> L24 IOException -> L26
        throw th;     // Catch: SecurityException -> L24 IOException -> L26
    L26:
        e = move-exception;
        Exception r7 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
        String r8 = "cache file copy";
    L28:
        reportSourceFailure(r10, r8, r7);
        return null;
    L24:
        e = move-exception;
        r7 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
        r8 = "cache file access";
        goto L28
    }

    private final void fadeOutFallbackIfCurrent(final c r5, final long r6) {
        if (isCurrentPlayback(r5, r6) == true) goto L5;
        return;
    L5:
        this.fallbackView.animate().cancel();
        this.fallbackView.animate().alpha(0.0f).setStartDelay(this.transitionSpec.c()).setDuration(this.transitionSpec.d()).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new FastOutSlowInInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$ProactiveAvatarView$NqH0ief3f8z30Nis8zvdNYR2Hg(this, r5, r6)).start();
    }

    private static final void fadeOutFallbackIfCurrent$lambda$9(ProactiveAvatarView r0, c r1, long r2) {
        if (r0.isCurrentPlayback(r1, r2) == false) goto L6;
        r0.fallbackView.setVisibility(8);
        r0.fallbackView.setImageDrawable(null);
        return;
    }

    private final boolean isCurrentPlayback(c r2, long r3) {
        if (this.playbackEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(this.currentSource, r2) == false) goto L9;
        if (this.playbackGeneration != r3) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: lambda$-NqH0ief3f8z30Nis8zvdNYR2Hg, reason: not valid java name */
    public static /* synthetic */ void m360lambda$NqH0ief3f8z30Nis8zvdNYR2Hg(ProactiveAvatarView r0, c r1, long r2) {
        fadeOutFallbackIfCurrent$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$bfzxew0vd3rDCE4Mbwqqkzkdp8Y(ProactiveAvatarView r0, c r1, long r2, AvatarTextureVideoView r4, AvatarTextureVideoView.a r5) {
        return bindPlaybackCallbacks$lambda$5(r0, r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$i-5LtZKxSJkkJ1uZ7DPMfaI4fbI, reason: not valid java name */
    public static /* synthetic */ Unit m361lambda$i5LtZKxSJkkJ1uZ7DPMfaI4fbI(ProactiveAvatarView r0, c r1, long r2, AvatarTextureVideoView r4) {
        return bindPlaybackCallbacks$lambda$4(r0, r1, r2, r4);
    }

    /* JADX INFO: renamed from: lambda$tI-3r_HUJz41ycmcNXnaGOw0oeA, reason: not valid java name */
    public static /* synthetic */ void m362lambda$tI3r_HUJz41ycmcNXnaGOw0oeA(ProactiveAvatarView r0, c r1, long r2) {
        startCrossfade$lambda$7(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$u-IDk0K5AP3i5whCc3TjRUMwIkU, reason: not valid java name */
    public static /* synthetic */ Unit m363lambda$uIDk0K5AP3i5whCc3TjRUMwIkU(ProactiveAvatarView r0, c r1, long r2, AvatarTextureVideoView r4, AvatarTextureVideoView r5) {
        return bindPlaybackCallbacks$lambda$6(r0, r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$wd6aCc29Db-ElFHwULVyb0R8Hg0, reason: not valid java name */
    public static /* synthetic */ void m364lambda$wd6aCc29DbElFHwULVyb0R8Hg0(ProactiveAvatarView r0, c r1, long r2, AvatarTextureVideoView r4) {
        startCrossfade$lambda$8(r0, r1, r2, r4);
    }

    private final FrameLayout.LayoutParams matchParentLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    private final void pausePlayback() {
        this.playbackEnabled = false;
        this.playbackGeneration++;
        c r0 = this.currentSource;
        if (r0 == null) goto L5;
        showFallback(r0);
    L5:
        releaseVideoLayers();
    }

    private final void prepareVideoLayers(AvatarTextureVideoView r2, AvatarTextureVideoView r3) {
        r2.animate().cancel();
        r3.animate().cancel();
        r2.setVisibility(0);
        r2.setAlpha(0.0f);
        r2.bringToFront();
        this.fallbackView.bringToFront();
    }

    private final void release() {
        this.playbackEnabled = false;
        this.playbackGeneration++;
        this.currentSource = null;
        this.playbackListener = null;
        this.fallbackView.animate().cancel();
        this.fallbackView.setImageDrawable(null);
        releaseVideoLayers();
        this.cachedFallbackBitmaps.clear();
        this.cachedVideoPaths.clear();
    }

    private final void releaseVideoLayers() {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(videoViews(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        AvatarTextureVideoView r0 = (AvatarTextureVideoView) ZeusTransformUtils.preCheckCast(r3.next(), AvatarTextureVideoView.class, "com.obric.memorydata.plugin");
        r0.animate().cancel();
        r0.setOnPlaybackPendingListener(null);
        r0.setOnFirstFrameListener(null);
        r0.setOnPlaybackErrorListener(null);
        r0.a();
        r0.setAlpha(0.0f);
        r0.setVisibility(8);
        goto L4
    }

    private final void reportSourceFailure(c r4, String r5, Exception r6) {
        b r3 = this.playbackListener;
        if (r3 == null) goto L6;
        r3.a(r4, new a(r5, 1, 0, r6));
        return;
    }

    private final void showFallback(c r4) {
        Bitmap r0 = (Bitmap) ZeusTransformUtils.preCheckCast(this.cachedFallbackBitmaps.get(Integer.valueOf(r4.b())), Bitmap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        r0 = BitmapFactory.decodeResource(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), r4.b());
        if (r0 == null) goto L8;
        this.cachedFallbackBitmaps.put(Integer.valueOf(r4.b()), r0);
        goto L9
    L8:
        throw new IllegalArgumentException(("Unable to decode avatar fallback resource " + r4.b()).toString());
    L9:
        this.fallbackView.animate().cancel();
        ImageView r5 = this.fallbackView;
        RoundedBitmapDrawable r1 = RoundedBitmapDrawableFactory.create(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), r0);
        r1.setCircular(true);
        r1.setAntiAlias(true);
        r5.setImageDrawable((Drawable) ZeusTransformUtils.preCheckCast(r1, Drawable.class, "com.obric.memorydata.plugin"));
        this.fallbackView.setAlpha(1.0f);
        this.fallbackView.setVisibility(0);
        this.fallbackView.bringToFront();
    }

    private final void startCrossfade(AvatarTextureVideoView r8, final AvatarTextureVideoView r9, final c r10, final long r11) {
        r8.animate().alpha(1.0f).setDuration(this.transitionSpec.a()).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new FastOutSlowInInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$ProactiveAvatarView$tI3r_HUJz41ycmcNXnaGOw0oeA(this, r10, r11)).start();
        r9.animate().alpha(0.0f).setDuration(this.transitionSpec.b()).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new FastOutSlowInInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$ProactiveAvatarView$wd6aCc29DbElFHwULVyb0R8Hg0(this, r10, r11, r9)).start();
    }

    private static final void startCrossfade$lambda$7(ProactiveAvatarView r0, c r1, long r2) {
        r0.fadeOutFallbackIfCurrent(r1, r2);
    }

    private static final void startCrossfade$lambda$8(ProactiveAvatarView r0, c r1, long r2, AvatarTextureVideoView r4) {
        if (r0.isCurrentPlayback(r1, r2) == false) goto L6;
        r4.a();
        r4.setVisibility(8);
        return;
    }

    private final void startPlayback(c r11) {
        if (Intrinsics.areEqual(this.currentSource, r11) == true) goto L5;
        return;
    L5:
        long r8 = this.playbackGeneration + 1;
        this.playbackGeneration = r8;
        boolean r0 = this.useBackgroundAsForeground;
        if (r0 == false) goto L8;
        AvatarTextureVideoView r1 = this.backgroundVideoView;
    L9:
        if (r0 == false) goto L11;
        AvatarTextureVideoView r2 = this.foregroundVideoView;
    L12:
        AvatarTextureVideoView r6 = r2;
        this.useBackgroundAsForeground = !r0;
        prepareVideoLayers(r1, r6);
        String r3 = ensureVideoCacheFile(r11);
        if (r3 != null) goto L16;
        ((ProactiveAvatarView) ZeusTransformUtils.preCheckCast(this, ProactiveAvatarView.class, "com.obric.memorydata.plugin")).releaseVideoLayers();
        return;
    L16:
        bindPlaybackCallbacks(r1, r6, r11, r8);
        r1.setVideoPath(r3);
        return;
    L11:
        r2 = this.backgroundVideoView;
        goto L12
    L8:
        r1 = this.foregroundVideoView;
        goto L9
    }

    private final a toPublicError(AvatarTextureVideoView.a r4) {
        return new a(r4.a(), r4.b(), r4.c(), r4.d());
    }

    private final List<AvatarTextureVideoView> videoViews() {
        return CollectionsKt.listOf(new AvatarTextureVideoView[]{this.foregroundVideoView, this.backgroundVideoView});
    }

    public final void bindLifecycle(LifecycleOwner r4) {
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "owner");
        LifecycleOwner r0 = this.boundLifecycleOwner;
        if (r0 != r5) goto L5;
        return;
    L5:
        if (r0 == null) goto L10;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L10;
        r1.removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
    L10:
        if (this.playbackEnabled == false) goto L12;
        pausePlayback();
    L12:
        this.boundLifecycleOwner = r5;
        r5.getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        if (r5.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L15;
        return;
    L15:
        if (this.playbackEnabled == true) goto L21;
        this.playbackEnabled = true;
        c r6 = this.currentSource;
        if (r6 == null) goto L22;
        startPlayback(r6);
        return;
    L22:
        return;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner r4) {
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "owner");
        release();
        r5.getLifecycle().removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        if (this.boundLifecycleOwner != r5) goto L6;
        this.boundLifecycleOwner = null;
        return;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin"), "owner");
        this.playbackEnabled = true;
        c r4 = this.currentSource;
        if (r4 == null) goto L6;
        startPlayback(r4);
        return;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin"), "owner");
        pausePlayback();
    }

    public final void setPlaybackListener(b r3) {
        this.playbackListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setSource(c r6) {
        Intrinsics.checkNotNullParameter(r6, AILabCheckPermissionTask.KEY_SOURCE);
        if (Intrinsics.areEqual(this.currentSource, r6) == false) goto L17;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(videoViews(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L7;
    L9:
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        if (((AvatarTextureVideoView) ZeusTransformUtils.preCheckCast(r1.next(), AvatarTextureVideoView.class, "com.obric.memorydata.plugin")).getHasVideoSource() == false) goto L11;
        r3 = true;
    L15:
        if (r3 == false) goto L17;
        return;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L17:
        this.currentSource = r6;
        showFallback(r6);
        if (this.playbackEnabled == false) goto L24;
        startPlayback(r6);
        return;
    }

    public final void setTransitionSpec(d r9) {
        Intrinsics.checkNotNullParameter(r9, "spec");
        boolean r1 = true;
        if (r9.a() < 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L32;
        if (r9.b() < 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L30;
        if (r9.c() < 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L28;
        if (r9.d() >= 0) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L26;
        this.transitionSpec = r9;
        return;
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L28:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L16:
        r3 = false;
        goto L17
    L30:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L11:
        r2 = false;
        goto L12
    L32:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L7
    }
}
