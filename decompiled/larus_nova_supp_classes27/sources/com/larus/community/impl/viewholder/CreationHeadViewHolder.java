package com.larus.community.impl.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.community.impl.view.CreationHeadItemView;
import com.larus.platform.api.creation.AbsCreationFeedHeaderViewHolder;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BY\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationHeadViewHolder;", "Lcom/larus/platform/api/creation/AbsCreationFeedHeaderViewHolder;", "onClickInstructionDTOItem", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/larus/platform/model/creation/InstructionDTO;", "instructionDTO", "", "avatarWhiteUrlLiveData", "Landroidx/lifecycle/LiveData;", "", "itemView", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function2;Landroidx/lifecycle/LiveData;Landroid/view/View;)V", "creationConfig", "Lcom/larus/platform/model/creation/CreativityLaunchConfig;", "avatarCellView", "Lcom/larus/community/impl/view/CreationHeadItemView;", "isPad", "", "avatarWhiteUrlObserver", "Landroidx/lifecycle/Observer;", "onViewRecycled", "onBindViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationHeadViewHolder extends AbsCreationFeedHeaderViewHolder {
    public final void onViewRecycled() {
    }

    public final void T3() {
        FLogger.a.i("CreationHeadViewHolder", "avatarWhiteUrlLiveData url: null");
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof LinearLayout) == false) goto L5;
        LinearLayout r1 = (LinearLayout) r0;
    L6:
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        int r3 = 0;
    L10:
        if (r3 >= 2) goto L23;
        LinearLayout r5 = new LinearLayout(((RecyclerView.ViewHolder) this).itemView.getContext());
        r5.setOrientation(0);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-1, -2);
        if (r3 != 0) goto L14;
        r6.bottomMargin = i5.r0();
    L14:
        r5.setLayoutParams(r6);
        int r7 = 0;
    L15:
        if (r7 >= 2) goto L20;
        ConstraintLayout r8 = new CreationHeadItemView(((RecyclerView.ViewHolder) this).itemView.getContext(), null);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(0, c7.b(64), 1.0f);
        if (r7 != 0) goto L19;
        r9.rightMargin = i5.r0();
    L19:
        r8.setLayoutParams(r9);
        r5.addView(r8);
        r7 = r7 + 1;
        goto L15
    L20:
        if (r1 == null) goto L22;
        r1.addView(r5);
    L22:
        r3 = r3 + 1;
        goto L10
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
