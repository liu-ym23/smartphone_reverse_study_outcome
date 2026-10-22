package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import com.obric.common.oui.R$dimen;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/indexscrollbar/AlphabetView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AlphabetView extends TextView {
    @JvmOverloads
    public AlphabetView(Context r5) {
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @JvmOverloads
    public AlphabetView(Context r5, AttributeSet r10) {
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ AlphabetView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public AlphabetView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        setGravity(17);
        setTextSize(0, getResources().getDimension(R$dimen.bytedance_quickbarex_gridview_font_size));
        setTypeface(null, 1);
        setTextColor(Color.parseColor("#80000000"));
    }
}
