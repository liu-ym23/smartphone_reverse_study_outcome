package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/checkbox/OCheckMark;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isChecked", "", "markDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "setChecked", "checked", "toggle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCheckMark extends AppCompatImageView implements Checkable {
    private boolean isChecked;
    private Drawable markDrawable;

    public OCheckMark(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.markDrawable = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_mark, "drawable", "o_card_list_item_tail_icon_mark"));
        this.isChecked = true;
        init();
    }

    public OCheckMark(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        super(r5, r6);
        this.markDrawable = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_mark, "drawable", "o_card_list_item_tail_icon_mark"));
        this.isChecked = true;
        init();
    }

    public OCheckMark(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7, r5);
        this.markDrawable = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_mark, "drawable", "o_card_list_item_tail_icon_mark"));
        this.isChecked = true;
        init();
    }

    private final void init() {
        setMinimumWidth(this.markDrawable.getMinimumWidth());
        setMinimumHeight(this.markDrawable.getMinimumHeight());
        setBackgroundDrawable(this.markDrawable);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.isChecked != r2) goto L5;
        return;
    L5:
        this.isChecked = r2;
        if (r2 == false) goto L8;
        Drawable r3 = this.markDrawable;
    L9:
        setBackgroundDrawable(r3);
        invalidate();
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isChecked);
    }
}
