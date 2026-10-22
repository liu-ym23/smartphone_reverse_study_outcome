package com.bytedance.android.ec.core.gallery2.opt;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002R*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/opt/GalleryTitleItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "update", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "b", "I", "getCheckPos", "()I", "setCheckPos", "(I)V", "checkPos", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryTitleItemView extends AppCompatTextView {
    public int a;
    public int b;

    public GalleryTitleItemView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public GalleryTitleItemView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void update() {
        int r0 = this.b;
        int r1 = this.a;
        if (r0 != r1) goto L5;
        ExtensionsKt.visible(this);
        setTextColor(-1);
        return;
    L5:
        if (r0 <= 0) goto L8;
        if (r1 <= 0) goto L8;
        ExtensionsKt.visible(this);
    L9:
        Integer r10 = s.b("#9B9DA9");
        if (r10 == null) goto L14;
        setTextColor(r10.intValue());
        return;
    L14:
        return;
    L8:
        setVisibility(4);
        goto L9
    }

    public final int getCheckPos() {
        return this.b;
    }

    public final void setCheckPos(int r1) {
        this.b = r1;
        update();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryTitleItemView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = -1;
        setTextSize(14.0f);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setGravity(19);
        setMaxWidth(vf4.a.b(180));
        Integer r13 = s.b("#9B9DA9");
        if (r13 == null) goto L5;
        setTextColor(r13.intValue());
    L5:
        setLineSpacing(vf4.a.b(3), 1.0f);
    }

    public /* synthetic */ GalleryTitleItemView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
