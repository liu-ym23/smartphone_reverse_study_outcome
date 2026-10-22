package com.larus.photopicker.v2.impl.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.databinding.LarusItemMediaBinding;
import com.larus.photopicker.v2.impl.e0;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.tencent.open.log.TraceLevel;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import op9.d;
import v19.c;
import vp9.m;
import vp9.v;
import vp9.w;
import vp9.x;
import wp9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tJ\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusItemMediaBinding;", "resizeOption", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "onItemClick", "Lkotlin/Function3;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "", "Lcom/larus/photopicker/v2/impl/ui/ClickType;", "", "<init>", "(Lcom/larus/photopicker/v2/impl/databinding/LarusItemMediaBinding;Lcom/facebook/imagepipeline/common/ResizeOptions;Lkotlin/jvm/functions/Function3;)V", "TAG", "", "currentMedia", "currentMediaPosition", "bind", "mediaItem", "mediaListState", "Lcom/larus/photopicker/v2/impl/ui/MediaListStateData;", "dataPosition", "bindImage", "uiMediaItem", "bindVideoDuration", "bindNonImage", "bindPayload", "updateSelectionHitTarget", "useCompactSelectionHitTarget", "", "refreshSelectionView", "bindAnimator", "updateAccessibility", "selected", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int g = 0;
    public final LarusItemMediaBinding a;
    public final ResizeOptions b;
    public final Function3<d, Integer, ClickType, Unit> c;
    public final String d;
    public d e;
    public int f;

    public static final class a {
    }

    static {
    }

    public final void V3(m r8) {
        Intrinsics.checkNotNullParameter(r8, "mediaListState");
        int r0 = e0.a;
        e0.b(this.d, "bindPayload: " + r8.d);
        this.a.b.getHierarchy().setRoundingParams(r8.a);
        if (r8.e == false) goto L5;
        int r1 = 40;
    L6:
        Resources r2 = ((RecyclerView.ViewHolder) this).itemView.getResources();
        int r3 = (int) (r1 * WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density);
        FrameLayout r4 = this.a.d;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.width = r3;
        r5.height = r3;
        r4.setLayoutParams(r5);
        int r6 = r8.d;
        int r7 = R.color.transparent;
        boolean r9 = true;
        if (r6 == 0) goto L13;
        if (r6 == 1) goto L12;
        if (r6 != 2) goto L14;
        this.a.d.setBackgroundResource(R.color.transparent);
        e1.x(this.a.d);
    L14:
        String r10 = this.d;
        StringBuilder r11 = new StringBuilder("refreshSelectionView: ");
        r11.append(r8.d);
        r11.append(' ');
        d r12 = this.e;
        Context r13 = null;
        if (r12 == null) goto L17;
        Boolean r14 = Boolean.valueOf(r12.b);
    L18:
        r11.append(r14);
        e0.b(r10, r11.toString());
        d r15 = this.e;
        if (r15 != null) goto L21;
    L23:
        r9 = false;
    L24:
        if (r9 == false) goto L32;
        AppCompatTextView r16 = this.a.c;
        if (r16 == null) goto L28;
        r13 = r16.getContext();
    L28:
        r16.setBackgroundResource(c.b(2130972337, r13, 2131243501));
        if (r8.d != 2) goto L31;
        this.a.e.setBackgroundResource(2131243504);
    L37:
        d r17 = this.e;
        if (r17 == null) goto L40;
        W3(r17, r17.b);
    L40:
        d r18 = this.e;
        if (r18 == null) goto L44;
        T3(r18, r8);
        return;
    L44:
        return;
    L31:
        this.a.e.setBackgroundResource(2131103326);
        goto L37
    L32:
        AppCompatTextView r19 = this.a.c;
        if (r8.d == 2) goto L36;
        r7 = 2131243500;
    L36:
        r19.setBackgroundResource(r7);
        goto L37
    L21:
        if (r15.b != true) goto L23;
    L17:
        r14 = null;
        goto L18
    L12:
        this.a.d.setBackgroundResource(2131243507);
        e1.x(this.a.d);
        goto L14
    L13:
        e1.o(this.a.d);
        goto L14
    L5:
        r1 = 64;
        goto L6
    }

    public final void T3(d r5, m r6) {
        boolean r1 = false;
        float r3 = 1.0f;
        if (r5.b == false) goto L10;
        if (r6.d != 2) goto L7;
        float r7 = 1.0f;
    L8:
        boolean r8 = true;
    L17:
        if (this.a.b.getAlpha() != r3) goto L19;
        boolean r0 = true;
    L20:
        if (r0 == true) goto L23;
        this.a.b.setAlpha(r3);
    L23:
        if (this.a.b.getScaleX() != r7) goto L25;
        r1 = true;
    L25:
        if (r1 == true) goto L27;
        this.a.b.animate().scaleY(r7).scaleX(r7).setDuration(10).start();
    L27:
        i.c(this.a.e, r8);
        return;
    L19:
        r0 = false;
        goto L20
    L7:
        r7 = 1.1f;
        goto L8
    L10:
        if (r6.c == true) goto L12;
    L14:
        float r9 = 0.3f;
    L15:
        r3 = r9;
        r7 = 1.0f;
        r8 = false;
        goto L17
    L12:
        if (r5.e == false) goto L14;
        r9 = 1.0f;
        goto L15
    }

    public final void U3(d r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "mediaItem");
        Intrinsics.checkNotNullParameter(r3, "mediaListState");
        int r4 = r2.c;
        if (r4 <= 0) goto L5;
        this.a.c.setText(String.valueOf(r4));
    L6:
        W3(r2, r2.b);
        return;
    L5:
        this.a.c.setText("");
        goto L6
    }

    public final void W3(d r18, boolean r19) {
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(r18.a.h * ((long) 1000));
        String r4 = String.valueOf(r2.get(1));
        String r6 = String.valueOf(r2.get(2) + 1);
        String r8 = String.valueOf(r2.get(5));
        String r9 = String.valueOf(r2.get(11));
        String r3 = String.valueOf(r2.get(12));
        if (r18.a.getType() != MediaType.VIDEO) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        int r10 = 2131898762;
    L9:
        if (r1 == false) goto L13;
        if (r19 == false) goto L12;
        int r5 = 2131898763;
    L16:
        LarusItemMediaBinding r12 = this.a;
        r12.b.setContentDescription(r12.a.getContext().getString(r10, new Object[]{r4, r6, r8, r9, r3}));
        LarusItemMediaBinding r11 = this.a;
        r11.c.setContentDescription(r11.a.getContext().getString(r5, new Object[]{r4, r6, r8, r9, r3}));
        return;
    L12:
        r5 = 2131898764;
        goto L16
    L13:
        if (r19 == false) goto L15;
        r5 = 2131898760;
        goto L16
    L15:
        r5 = 2131898761;
        goto L16
    L8:
        r10 = 2131898759;
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaViewHolder(LarusItemMediaBinding r2, ResizeOptions r3, Function3<? super d, ? super Integer, ? super ClickType, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r4, "onItemClick");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = "MediaViewHolder";
        ImagePipelineFactory.getInstance().setNewLocalVideoThumbnailOptEnabled(true);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new v(this));
        r2.d.setOnClickListener(new w(this));
        r2.c.setOnClickListener(new x(this));
    }
}
