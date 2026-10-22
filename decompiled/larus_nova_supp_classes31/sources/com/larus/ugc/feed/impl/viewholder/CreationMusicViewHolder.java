package com.larus.ugc.feed.impl.viewholder;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.chat.api.IMusicService;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.uaigc.music.widget.LyricsToSongTemplatePlayerView;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JH\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0001\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%J\u001a\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\"\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u001c\u0010*\u001a\u00020\u00192\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0004H\u0002JV\u0010.\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u00106\u001a\u00020\u001b2\b\b\u0002\u00107\u001a\u00020\u001bH\u0002J\b\u00108\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/CreationMusicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Lcom/larus/bmhome/chat/plugin/image4/view/ImageViewWithLastMotion;", "authorInfoLayout", "Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "iconTemplate", "titleText", "Landroid/widget/TextView;", "genreTextView", "bottomBarrier", "Landroidx/constraintlayout/widget/Barrier;", "playerView", "Landroid/widget/FrameLayout;", "shadowLayer", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "downloadIcon", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "bindData", "", "position", "", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "itemWidth", "creationClickCallBack", "Lcom/larus/ugc/feed/impl/adapter/ICreationClickCallBack;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "creationFeedType", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "handleDownLoadIcon", "userCreation", "setHeight", "initClickListener", "setShapeCornerColorTint", "colorString", "", "adjustToView", "adjustViewBgGradient", "view", "topLeftRadius", "", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "startColor", "middleColor", "endColor", "onViewRecycled", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationMusicViewHolder extends RecyclerView.ViewHolder implements zp9.q {
    public static final /* synthetic */ int i = 0;
    public final ImageViewWithLastMotion a;
    public final CommonAuthorInfoLayout b;
    public final View c;
    public final TextView d;
    public final TextView e;
    public final FrameLayout f;
    public final View g;
    public final CommonDownLoadLayout h;

    @Override // zp9.q
    public final void onViewRecycled() {
        this.h.onDestroy();
        bp8.a r0 = this.f;
        if ((r0 instanceof bp8.a) == false) goto L5;
        bp8.a r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.destroy();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CreationMusicViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.a = r4.findViewById(2131375775);
        this.b = r4.findViewById(2131377437);
        View r0 = r4.findViewById(2131374752);
        if (ICommunityService.a.f1().e() != 0) goto L5;
        r0.setBackgroundResource(2131239556);
    L6:
        this.c = r0;
        this.d = (TextView) r4.findViewById(2131380526);
        this.e = (TextView) r4.findViewById(2131380491);
        Barrier r1 = r4.findViewById(2131363973);
        this.g = r4.findViewById(2131386037);
        ConstraintLayout r2 = r4.findViewById(2131380483);
        this.h = r4.findViewById(2131370173);
        w0.e(r4, i5.Y());
        r1.setReferencedIds(new int[]{2131380526, 2131380491});
        IMusicService r3 = (IMusicService) ServiceManager.get().getService(IMusicService.class);
        if (r3 == null) goto L9;
        LyricsToSongTemplatePlayerView r5 = r3.a(r4.getContext());
    L10:
        this.f = r5;
        ViewGroup.LayoutParams r6 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ConstraintLayout.LayoutParams) r6).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r6).topToTop = 0;
        r2.addView(r5, r6);
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r0.setBackgroundResource(2131239557);
        goto L6
    }

    public final void U3(String r9, View r10) {
    L10:
        e = move-exception;
        FLogger.a.e("CreationMusicViewHolder", "error parsing tint color ", e);
        return;
    L3:
        if (TextUtils.isEmpty(r9) == false) goto L7;
        if (r9 != null) goto L6;
        int r11 = Color.argb(0, 0, 0, 0);     // Catch: IllegalArgumentException -> L10
    L8:
        int r7 = Color.argb(0, 0, 0, 0);     // Catch: IllegalArgumentException -> L10
        float r5 = i5.Y();     // Catch: IllegalArgumentException -> L10
        T3(this, r10, r5, r5, r11, r7);     // Catch: IllegalArgumentException -> L10
        return;
    L6:
        r11 = Color.parseColor("#B6BACD");     // Catch: IllegalArgumentException -> L10
        goto L8
    L7:
        r11 = Color.parseColor(r9);     // Catch: IllegalArgumentException -> L10
        goto L8
    }

    public static void T3(CreationMusicViewHolder r3, View r4, float r5, float r6, int r7, int r8) {
        r3.getClass();
        if (r4 == null) goto L7;
        GradientDrawable r9 = new GradientDrawable();
        r9.setColors(new int[]{r7, r8});
        r9.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r9.setShape(0);
        r9.setCornerRadii(new float[]{r5, r5, r6, r6, 0.0f, 0.0f, 0.0f, 0.0f});
        r4.setBackground(r9);
        return;
    }
}
