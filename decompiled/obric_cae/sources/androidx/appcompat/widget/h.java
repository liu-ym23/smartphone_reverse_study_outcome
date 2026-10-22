package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CheckedTextView f1157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f1158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1162f;

    public h(CheckedTextView r8) {
        this.f1158b = null;
        this.f1159c = null;
        this.f1160d = false;
        this.f1161e = false;
        this.f1157a = r8;
    }

    public final void a() {
        CheckedTextView r8 = this.f1157a;
        Drawable r10 = r8.getCheckMarkDrawable();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f1160d == false) goto L7;
    L8:
        Drawable r11 = r10.mutate();
        if (this.f1160d == false) goto L12;
        b0.a.b.h(r11, this.f1158b);
    L12:
        if (this.f1161e == false) goto L15;
        b0.a.b.i(r11, this.f1159c);
    L15:
        if (r11.isStateful() == false) goto L17;
        r11.setState(r8.getDrawableState());
    L17:
        r8.setCheckMarkDrawable(r11);
        return;
    L7:
        if (this.f1161e == true) goto L8;
    }
}
