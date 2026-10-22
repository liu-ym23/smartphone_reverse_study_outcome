package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.picker.base.view.ColdAndHotViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchColdAndHotInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ColdAndHotBinder;", "Lcom/ss/android/lark/picker/base/view/binder/IViewBinder;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "bind", "", "position", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchColdAndHotInfo;", "holder", "Lcom/ss/android/lark/picker/base/view/ColdAndHotViewHolder;", "resetView", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ColdAndHotBinder implements IViewBinder {
    public static final Companion Companion = null;
    private static final String TAG = "LarkSearch.Common.ColdAndHotBinder";
    private final Context mContext;
    private final g mOnItemClickHandler;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ColdAndHotBinder$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ g access$getMOnItemClickHandler$p(ColdAndHotBinder r0) {
        return r0.mOnItemClickHandler;
    }

    public final void resetView(ColdAndHotViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        ProgressBar r0 = r3.getProgressBar();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        AppCompatTextView r4 = r3.getIconFrontTextView();
        if (r4 == null) goto L9;
        r4.setVisibility(0);
        return;
    }

    public ColdAndHotBinder(Context r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mOnItemClickHandler");
        this.mContext = r2;
        this.mOnItemClickHandler = r3;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.TextView, com.ss.android.lark.picker.base.view.CommonIconFrontTextView] */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.widget.TextView, com.ss.android.lark.picker.base.view.CommonIconFrontTextView] */
    public final void bind(final int r7, final SearchColdAndHotInfo r8, ColdAndHotViewHolder r9) {
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r9, "holder");
        resetView(r9);
        if (r8.getLoading() == false) goto L12;
        ProgressBar r10 = r9.getProgressBar();
        if (r10 == null) goto L7;
        r10.setVisibility(0);
    L7:
        AppCompatTextView r11 = r9.getIconFrontTextView();
        if (r11 == null) goto L10;
        r11.setVisibility(8);
    L10:
        r9.getView().setOnClickListener(null);
        return;
    L12:
        int r0 = r8.getColdAndHotType();
        if (r0 != 2) goto L15;
        ?? r1 = r9.getIconFrontTextView();
        if (r1 == 0) goto L26;
        Context r2 = this.mContext;
        r1.setCompoundDrawables(UDIconUtils.getIconDrawable(r2, 2131254260, UDColorUtils.getColor(r2, 2131105548)), null, null, null);
        r1.setText(r1.getResources().getString(2131890218));
        r1.setTextColor(UDColorUtils.getColor(this.mContext, 2131105548));
    L26:
        View.OnClickListener r3 = new ColdAndHotBinder$bind$clickListener$1(this, r8, r7);
        r9.getView().setOnClickListener(r3);
        return;
    L15:
        if (r0 == 3) goto L20;
        AppCompatTextView r12 = r9.getIconFrontTextView();
        if (r12 == null) goto L28;
        r12.setVisibility(8);
        return;
    L28:
        return;
    L20:
        ?? r4 = r9.getIconFrontTextView();
        if (r4 == 0) goto L26;
        r4.setCompoundDrawables(null, null, null, null);
        r4.setText(r4.getResources().getString(2131890208));
        r4.setTextColor(UDColorUtils.getColor(this.mContext, 2131106607));
        goto L26
    }
}
