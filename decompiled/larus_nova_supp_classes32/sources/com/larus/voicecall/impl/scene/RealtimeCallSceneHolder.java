package com.larus.voicecall.impl.scene;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.av_call.constant.ThemeType;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \f*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \f*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \f*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/voicecall/impl/scene/RealtimeCallSceneHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/av_call/constant/ThemeType;Landroid/view/View;)V", "getThemeType", "()Lcom/larus/av_call/constant/ThemeType;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "sceneTitle", "Landroid/widget/TextView;", "sceneDesc", "sceneIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "sceneLoading", "Landroid/widget/ProgressBar;", "sceneIconArea", "Landroid/widget/FrameLayout;", "colorAnimator", "Landroid/animation/ObjectAnimator;", "bindData", NameKeys.UnloadStrategy_No_Strategy, "item", "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "closeClick", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSceneHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int h = 0;
    public final ThemeType a;
    public final Context b;
    public final TextView c;
    public final TextView d;
    public final SimpleDraweeView e;
    public final ProgressBar f;
    public final FrameLayout g;

    public RealtimeCallSceneHolder(ThemeType r2, ConstraintLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "themeType");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.a = r2;
        this.b = r3.getContext();
        this.c = (TextView) r3.findViewById(2131385164);
        this.d = (TextView) r3.findViewById(2131385151);
        this.e = r3.findViewById(2131385152);
        this.f = (ProgressBar) r3.findViewById(2131385154);
        this.g = (FrameLayout) r3.findViewById(2131385153);
    }
}
