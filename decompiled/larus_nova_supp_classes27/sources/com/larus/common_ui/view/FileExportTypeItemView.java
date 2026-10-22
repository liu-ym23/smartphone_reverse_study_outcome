package com.larus.common_ui.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/view/FileExportTypeItemView;", "Lcom/larus/common_ui/widget/roundlayout/RoundConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fileTypeIcon", "Landroid/widget/ImageView;", "fileTypeName", "Landroid/widget/TextView;", "value", "Lcom/larus/common_ui/view/FileExportType;", "fileType", "getFileType", "()Lcom/larus/common_ui/view/FileExportType;", "setItemType", "", "type", "setSelected", "selected", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileExportTypeItemView extends RoundConstraintLayout {
    public final ImageView c;
    public final TextView d;
    public FileExportType e;

    public FileExportTypeItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FileExportTypeItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final FileExportType getFileType() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setItemType(FileExportType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        this.d.setText(getContext().getString(r4.nameRes()));
        this.c.setImageResource(r4.iconRes());
        this.e = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r5) {
        super/*android.view.ViewGroup*/.setSelected(r5);
        Context r0 = null;
        if (r5 == false) goto L9;
        ImageView r1 = this.c;
        if (r1 == null) goto L7;
        Context r2 = r1.getContext();
    L8:
        int r3 = v19.c.b(2130972127, r2, 2131103215);
    L14:
        if (r5 == false) goto L19;
        ImageView r6 = this.c;
        if (r6 == null) goto L18;
        r0 = r6.getContext();
    L18:
        int r7 = v19.c.b(2130972123, r0, 2131103203);
    L20:
        getDelegate().a(ContextCompat.getColor(getContext(), r3));
        getDelegate().g(ContextCompat.getColor(getContext(), r7));
        return;
    L19:
        r7 = R.color.transparent;
        goto L20
    L7:
        r2 = null;
        goto L8
    L9:
        ImageView r4 = this.c;
        if (r4 == null) goto L12;
        Context r8 = r4.getContext();
    L13:
        r3 = v19.c.b(2130970537, r8, 2131102554);
        goto L14
    L12:
        r8 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileExportTypeItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = FileExportType.word;
        View r5 = LayoutInflater.from(r2).inflate(2131562815, this);
        this.c = (ImageView) r5.findViewById(2131372395);
        this.d = (TextView) r5.findViewById(2131372396);
        getDelegate().d(12);
        c29.a r6 = getDelegate();
        Resources r7 = r6.b.getResources();
        r6.m = (int) ((1 * WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density) + 0.5f);
        r6.c();
        setSelected(false);
    }

    public /* synthetic */ FileExportTypeItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
