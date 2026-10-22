package fn8;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaOverlayAlignment;
import com.larus.common_ui.video.VideoPlayView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w extends FrameLayout {
    public final SimpleDraweeView a;
    public VideoPlayView b;
    public MarkdownSourceImageView c;
    public AppCompatImageView d;
    public AppCompatTextView e;
    public LinearLayout f;
    public LinearLayout g;
    public String h;
    public c0 i;
    public o j;
    public e k;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), i5.r0());
        }
    }

    public static final class b {
    }

    static {
    }

    public static GradientDrawable a() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(i5.r0());
        r0.setColor(Color.argb(77, 0, 0, 0));
        return r0;
    }

    public w(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        SimpleDraweeView r0 = new SimpleDraweeView(r5);
        r0.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        GradientDrawable r1 = new GradientDrawable();
        r1.setCornerRadius(i5.r0());
        r1.setColor(ColorUtils.setAlphaComponent(ContextCompat.getColor(r5, v19.c.b(2130972079, r5, 2131103136)), 10));
        r0.setBackground(r1);
        this.a = r0;
        setOutlineProvider(new a());
        setClipToOutline(true);
        addView(r0, new FrameLayout.LayoutParams(-1, -1));
    }

    public static FrameLayout.LayoutParams b(int r4) {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, i5.O(), r4 | 80);
        if (r4 != 8388611) goto L5;
        r0.setMarginStart(i5.r0());
    L6:
        r0.bottomMargin = i5.r0();
        return r0;
    L5:
        r0.setMarginEnd(i5.r0());
        goto L6
    }

    public static FrameLayout.LayoutParams e(RichMediaOverlayAlignment r5) {
        int r1 = i5.q();
        int r2 = i5.q();
        RichMediaOverlayAlignment r3 = RichMediaOverlayAlignment.START;
        if (r5 != r3) goto L5;
        int r4 = 8388611;
    L6:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r1, r2, r4 | 48);
        if (r5 != r3) goto L9;
        r0.setMarginStart(i5.j0());
        r0.topMargin = i5.j0();
    L10:
        return r0;
    L9:
        r0.setMarginEnd(i5.r0());
        r0.topMargin = i5.r0();
        goto L10
    L5:
        r4 = 8388613;
        goto L6
    }

    public final void c(boolean r5) {
        if (r5 == false) goto L7;
        AppCompatImageView r6 = this.d;
        if (r6 != null) goto L6;
        r6 = new AppCompatImageView(getContext());
        r6.setImageResource(2131243016);
        this.d = r6;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(i5.A(), i5.A(), 8388661);
        r0.setMarginEnd(i5.j0());
        r0.topMargin = i5.j0();
        Unit r1 = Unit.INSTANCE;
        addView(r6, r0);
    L6:
        r6.setVisibility(0);
        return;
    L7:
        AppCompatImageView r7 = this.d;
        if (r7 == null) goto L12;
        r7.setVisibility(8);
        return;
    }

    public final void d(boolean r4) {
        String r0 = this.h;
        if (r0 == null) goto L7;
        c0 r1 = this.i;
        if (r1 == null) goto L7;
        r1.h(r0);
    L7:
        VideoPlayView r2 = this.b;
        if (r2 == null) goto L10;
        r2.setOnClickListener(null);
        r2.setOnLongClickListener(null);
        r2.setVisibility(8);
    L10:
        if (r4 == false) goto L15;
        VideoPlayView r5 = this.b;
        if (r5 == null) goto L14;
        removeView(r5);
    L14:
        this.b = null;
    L15:
        this.a.setVisibility(0);
    }
}
