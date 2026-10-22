package com.ss.android.lark.picker.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.extra.OnNumberUpdateListener;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0014\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001bJ\u0006\u0010\u001c\u001a\u00020\u0018R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/picker/preview/SelectedPreviewView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mSelectedList", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "selectedTv", "Landroid/widget/TextView;", "rootView", "Landroid/view/View;", "onNumberUpdateListener", "Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;", "getOnNumberUpdateListener", "()Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;", "setOnNumberUpdateListener", "(Lcom/ss/android/lark/picker/extra/OnNumberUpdateListener;)V", "initView", "", "refreshSelectedData", "selectedData", "", "rootRefresh", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SelectedPreviewView extends ConstraintLayout {
    private Context mContext;
    private List<SearchBaseInfo> mSelectedList;
    private OnNumberUpdateListener onNumberUpdateListener;
    private View rootView;
    private TextView selectedTv;

    public final void rootRefresh() {
        View r0 = this.rootView;
        if (r0 == null) goto L6;
        r0.requestLayout();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        this.selectedTv = (TextView) findViewById(2131382287);
        this.rootView = findViewById(2131384813);
    }

    public final OnNumberUpdateListener getOnNumberUpdateListener() {
        return this.onNumberUpdateListener;
    }

    public SelectedPreviewView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void refreshSelectedData(List<? extends SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r3, "selectedData");
        this.mSelectedList = CollectionsKt.toMutableList(r3);
        TextView r0 = this.selectedTv;
        if (r0 == null) goto L10;
        OnNumberUpdateListener r1 = this.onNumberUpdateListener;
        if (r1 == null) goto L7;
        String r4 = r1.onUpdate(r3.size());
    L8:
        r0.setText(r4);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void setOnNumberUpdateListener(OnNumberUpdateListener r1) {
        this.onNumberUpdateListener = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectedPreviewView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.mSelectedList = new ArrayList();
        this.mContext = r2;
        LayoutInflater.from(r2).inflate(2131568202, this, true);
        initView();
    }
}
