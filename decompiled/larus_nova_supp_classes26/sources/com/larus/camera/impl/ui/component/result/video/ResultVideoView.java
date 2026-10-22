package com.larus.camera.impl.ui.component.result.video;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.camera.impl.databinding.LarusLayoutResultVideoViewBinding;
import com.larus.camera.impl.ui.component.result.general.viewpager.e;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.utils.e1;
import f06.b;
import f06.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import wx8.f;
import wx8.g;
import wx8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000bJ\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/video/ResultVideoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/camera/impl/databinding/LarusLayoutResultVideoViewBinding;", "dragging", "", "latestDragSeekTime", "", "totalDuration", "callback", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/IResultVideoOperation;", "unifiedControlsEnabled", "setData", "", MusicAppletPage.KEY_PATH, "", "bitmap", "Landroid/graphics/Bitmap;", "key", "enableVideoClick", "enable", "dispatchEventToPlayerProgress", "event", "Landroid/view/MotionEvent;", "startVideo", "stopVideo", "pauseVideo", "setUnifiedControlsEnabled", "enabled", "initUnifiedControls", "refreshUnifiedPlayState", "refreshUnifiedMutedState", "unifiedControlBackground", "Landroid/graphics/drawable/GradientDrawable;", "initVideoView", "initRetryView", "initSeekbar", "getVideoDuration", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultVideoView extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public final LarusLayoutResultVideoViewBinding a;
    public boolean b;
    public long c;
    public long d;
    public e e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        if (this.f == true) goto L5;
        return;
    L5:
        LarusLayoutResultVideoViewBinding r0 = this.a;
        boolean r1 = r0.f.s;
        if (r1 == false) goto L8;
        int r2 = 2130971896;
    L9:
        if (r1 == false) goto L11;
        int r3 = 2131242314;
    L12:
        r0.b.setImageResource(c.b(r2, getContext(), r3));
        return;
    L11:
        r3 = 2131242327;
        goto L12
    L8:
        r2 = 2130971898;
        goto L9
    }

    public final void T5() {
        if (this.f == true) goto L5;
        return;
    L5:
        LarusLayoutResultVideoViewBinding r0 = this.a;
        ImageView r1 = r0.c;
        if (r0.f.r() == false) goto L8;
        int r2 = R.drawable.ic_media_pause;
    L9:
        r1.setImageResource(r2);
        return;
    L8:
        r2 = R.drawable.ic_media_play;
        goto L9
    }

    public ResultVideoView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static String R5(MediaMetadataRetriever r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {9};
        b r12 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        d r4 = r6.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r19, r1, "java.lang.String", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r19.extractMetadata(9);
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final void setUnifiedControlsEnabled(boolean r5) {
        this.f = r5;
        ImageView r0 = this.a.c;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        ImageView r2 = this.a.b;
        if (r5 == true) goto L10;
        r1 = 8;
    L10:
        r2.setVisibility(r1);
        if (r5 == false) goto L14;
        T5();
        S5();
        return;
    L14:
        return;
    L5:
        r3 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResultVideoView(Context r12, AttributeSet r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13);
        LayoutInflater.from(r12).inflate(2131562878, this);
        int r14 = 2131364161;
        if (((ImageView) ViewBindings.findChildViewById(this, 2131364161)) == null) goto L17;
        r14 = 2131371944;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(this, 2131371944);
        if (r15 == null) goto L17;
        r14 = 2131371945;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(this, 2131371945);
        if (r7 == null) goto L17;
        r14 = 2131382471;
        PlayerProgressView r8 = ViewBindings.findChildViewById(this, 2131382471);
        if (r8 == null) goto L17;
        r14 = 2131384472;
        RelativeLayout r9 = (RelativeLayout) ViewBindings.findChildViewById(this, 2131384472);
        if (r9 == null) goto L17;
        r14 = 2131392404;
        VideoPlayView r10 = ViewBindings.findChildViewById(this, 2131392404);
        if (r10 == null) goto L17;
        final LarusLayoutResultVideoViewBinding r16 = new LarusLayoutResultVideoViewBinding(this, r15, r7, r8, r9, r10);
        this.a = r16;
        r10.setForceUpdateProgress(true);
        r10.i(false);
        r10.w(new wx8.d(this));
        r10.d = new wx8.e(this);
        r10.setAfterClickCallBack(new h(this));
        r8.setSeekBarAlignToBottom(true);
        r8.k6(GuidePriority.MINOR_GUIDE_PRIORITY);
        r8.Y5(new f(), new g(r16, r8, this), 2);
        r9.setOnClickListener(new wx8.a(r16));
        GradientDrawable r17 = new GradientDrawable();
        r17.setShape(1);
        r17.setColor(ColorProtector.parseColor("#664E4E4E"));
        r7.setBackground(r17);
        GradientDrawable r18 = new GradientDrawable();
        r18.setShape(1);
        r18.setColor(ColorProtector.parseColor("#664E4E4E"));
        r15.setBackground(r18);
        e1.d(r7, new wx8.b(this));
        e1.d(r15, new wx8.c(this));
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r14)));
    }
}
