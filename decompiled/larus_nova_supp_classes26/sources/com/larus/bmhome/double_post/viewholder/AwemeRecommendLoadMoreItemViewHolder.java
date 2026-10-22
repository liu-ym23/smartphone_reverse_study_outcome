package com.larus.bmhome.double_post.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.video.Content;
import com.larus.common_res.common_ui.databinding.LarusItemAwemeLoadMoreBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.e1;
import ip8.b;
import ip8.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import lp8.g;
import lp8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/double_post/viewholder/AwemeRecommendLoadMoreItemViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/bmhome/double_post/viewholder/IAwemeRecommendViewHolder;", "viewBinding", "Lcom/larus/common_res/common_ui/databinding/LarusItemAwemeLoadMoreBinding;", "spaceHeight", "", "<init>", "(Lcom/larus/common_res/common_ui/databinding/LarusItemAwemeLoadMoreBinding;I)V", "status", "bindData", "", "data", "Lcom/larus/bmhome/video/Content;", "position", "dependency", "Lcom/larus/bmhome/double_post/adapter/IAwemeRecommendAdapterDependency;", "updateStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeRecommendLoadMoreItemViewHolder extends ViewBindingHolder implements h {
    public static final /* synthetic */ int b = 0;
    public final LarusItemAwemeLoadMoreBinding a;

    public AwemeRecommendLoadMoreItemViewHolder(LarusItemAwemeLoadMoreBinding r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewBinding");
        super(r3);
        this.a = r3;
        StaggeredGridLayoutManager.LayoutParams r0 = r3.a.getLayoutParams();
        if ((r0 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L5;
        StaggeredGridLayoutManager.LayoutParams r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.setFullSpan(true);
        r3.a.setLayoutParams(r1);
    L8:
        ViewGroup.LayoutParams r5 = r3.d.getLayoutParams();
        if (r5 == null) goto L12;
        r5.height = r4;
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // lp8.h
    public final void n2(Content r5, f r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Map<String, String> r7 = r5.getClientExt();     // Catch: Throwable -> L10
        if (r7 == null) goto L7;
        String r8 = r7.get("load_more_status");     // Catch: Throwable -> L10
        if (r8 == null) goto L7;
        Integer r9 = Integer.valueOf(CastIntegerProtector.parseInt(r8));     // Catch: Throwable -> L10
    L8:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r10) == false) goto L15;
        r10 = 2;
    L15:
        Integer r11 = (Integer) r10;
        if (r11 == null) goto L18;
        int r12 = r11.intValue();
    L20:
        if (r12 == 1) goto L27;
        if (r12 != 2) goto L23;
        this.a.c.setVisibility(8);
        this.a.b.setVisibility(8);
    L28:
        final b r13 = (b) r6;
        e1.d(this.a.b, new g(r13));
        return;
    L23:
        if (r12 != 3) goto L28;
        this.a.c.setVisibility(0);
        this.a.b.setVisibility(8);
        goto L28
    L27:
        this.a.c.setVisibility(8);
        this.a.b.setVisibility(0);
        goto L28
    L18:
        r12 = 2;
    L7:
        r9 = null;
    L10:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
