package com.larus.bmhome.view.item;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/view/item/ItemGroupTitle;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemGroupTitle extends AppCompatTextView {
    /* JADX WARN: Multi-variable type inference failed */
    public ItemGroupTitle(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        setTextSize(13.0f);
        setTextColor(ContextCompat.getColor(getContext(), c.b(2130972082, getContext(), 2131103146)));
        int r8 = i5.q();
        int r0 = i5.h();
        int r1 = i5.h();
        int r2 = getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r8 + ",top:" + r0 + ",end:" + r2 + ",bottom:" + r1);
        setPaddingRelative(r8, r0, r2, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemGroupTitle(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7);
        setTextSize(13.0f);
        setTextColor(ContextCompat.getColor(getContext(), c.b(2130972082, getContext(), 2131103146)));
        int r8 = i5.q();
        int r9 = i5.h();
        int r0 = i5.h();
        int r1 = getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r8 + ",top:" + r9 + ",end:" + r1 + ",bottom:" + r0);
        setPaddingRelative(r8, r9, r1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemGroupTitle(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        super(r5, r6, r7);
        setTextSize(13.0f);
        setTextColor(ContextCompat.getColor(getContext(), c.b(2130972082, getContext(), 2131103146)));
        int r8 = i5.q();
        int r9 = i5.h();
        int r10 = i5.h();
        int r0 = getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r8 + ",top:" + r9 + ",end:" + r0 + ",bottom:" + r10);
        setPaddingRelative(r8, r9, r0, r10);
    }
}
