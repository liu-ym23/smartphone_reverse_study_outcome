package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.dialog.TraverseLayoutChildIdUtilsKt;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/message/card/view/richtext/RichTextRenderAdapter;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", "context", "Landroid/content/Context;", "itemLayout", "", "checkIndex", "<init>", "(Landroid/content/Context;II)V", "getContext", "()Landroid/content/Context;", "getItemLayout", "()I", "onCreateViewHolder", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "RichTextRenderViewHolder", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RichTextRenderAdapter extends UDBaseListDialogAdapter {
    public final Context i;
    public final int j;
    public final int k;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/message/card/view/richtext/RichTextRenderAdapter$RichTextRenderViewHolder;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class RichTextRenderViewHolder extends UDBaseListDialogAdapter.UDDialogListItemViewHolder {
        public final UDCheckBox b;

        public RichTextRenderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.b = r2.findViewById(2131378553);
        }
    }

    public final Context getContext() {
        return this.i;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r1, r2);
    }

    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.y2(r4, r5);
        UDCheckBox r1 = null;
        if ((r4 instanceof RichTextRenderViewHolder) == false) goto L5;
        RichTextRenderViewHolder r6 = (RichTextRenderViewHolder) r4;
    L7:
        if (r5 != this.k) goto L14;
        if (r6 == null) goto L10;
        r1 = r6.b;
    L10:
        if (r1 == null) goto L12;
        r1.setVisibility(0);
    L12:
        if (r1 == null) goto L21;
        r1.setChecked(true);
        return;
    L21:
        return;
    L14:
        if (r6 == null) goto L16;
        r1 = r6.b;
    L16:
        if (r1 == null) goto L18;
        r1.setVisibility(8);
    L18:
        if (r1 == null) goto L23;
        r1.setChecked(false);
        return;
    L23:
        return;
    L5:
        r6 = null;
        goto L7
    }

    public final UDBaseListDialogAdapter.UDDialogListItemViewHolder z2(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(this.i).inflate(this.j, r3, false);
        TraverseLayoutChildIdUtilsKt.a(r5);
        return new RichTextRenderViewHolder(r5);
    }

    public RichTextRenderAdapter(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.i = r2;
        this.j = r3;
        this.k = r4;
    }
}
