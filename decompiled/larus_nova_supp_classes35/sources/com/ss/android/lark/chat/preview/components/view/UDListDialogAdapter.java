package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/UDListDialogAdapter;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", "context", "Landroid/content/Context;", "selectItemPosition", BuildConfig.FLAVOR, "selectItemColor", "<init>", "(Landroid/content/Context;II)V", "getContext", "()Landroid/content/Context;", "getSelectItemPosition", "()I", "getSelectItemColor", "onBindViewHolder", BuildConfig.FLAVOR, "holder", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "position", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDListDialogAdapter extends UDBaseListDialogAdapter {
    public final Context i;
    public final int j;
    public final int k;

    public final Context getContext() {
        return this.i;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r1, r2);
    }

    public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.y2(r2, r3);
        if (r3 != this.j) goto L5;
        r2.a.setTextColor(this.i.getResources().getColor(this.k));
        return;
    L5:
        r2.a.setTextColor(this.i.getResources().getColor(2131106622));
    }

    public UDListDialogAdapter(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.i = r2;
        this.j = r3;
        this.k = r4;
    }
}
