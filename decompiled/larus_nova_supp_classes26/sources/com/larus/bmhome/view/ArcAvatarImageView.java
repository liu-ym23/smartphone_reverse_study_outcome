package com.larus.bmhome.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/view/ArcAvatarImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", MusicAppletPage.KEY_PATH, "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ArcAvatarImageView extends SimpleDraweeView {
    public final Path a;

    public final Path getPath() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        this.a.moveTo(0.0f, 0.0f);
        this.a.lineTo(getWidth(), 0.0f);
        this.a.lineTo(getWidth(), i5.q());
        Path r0 = this.a;
        Lazy r2 = i5.u;
        r0.quadTo(((Number) r2.getValue()).intValue(), ((Number) r2.getValue()).intValue(), i5.q(), getHeight());
        this.a.lineTo(0.0f, getHeight());
        this.a.lineTo(0.0f, 0.0f);
        r7.clipPath(this.a);
        super/*android.widget.ImageView*/.onDraw(r7);
    }

    public ArcAvatarImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new Path();
    }
}
