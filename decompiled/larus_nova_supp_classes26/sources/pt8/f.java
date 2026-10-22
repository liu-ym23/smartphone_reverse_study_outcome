package pt8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.common_res.common_ui.databinding.LarusScreenWidgetMenuItemLayoutBinding;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements ot8.b {

    public static final class a extends BasePostprocessor {
        public a() {
        }

        public final void process(Bitmap r4) {
            super.process(r4);
            if (r4 != null) goto L5;
            return;
        L5:
            new Canvas(r4).drawBitmap(r4, 0.0f, 0.0f, new Paint());
        }
    }

    public static final class b extends BasePostprocessor {
        public b() {
        }

        public final void process(Bitmap r4) {
            super.process(r4);
            if (r4 != null) goto L5;
            return;
        L5:
            new Canvas(r4).drawBitmap(r4, 0.0f, 0.0f, new Paint());
        }
    }

    public f() {
    }

    @Override // ot8.b
    public void update(ot8.a r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "item");
        if (r7 == null) goto L5;
        Context r0 = r7.getContext();
    L7:
        if ((r6 instanceof pt8.b) == false) goto L31;
        if (r7 == null) goto L32;
        if (r0 == null) goto L33;
        pt8.b r8 = (pt8.b) r6;
        r7.setSelected(r8.f);
        r7.setEnabled(!r8.h);
        LarusScreenWidgetMenuItemLayoutBinding r9 = LarusScreenWidgetMenuItemLayoutBinding.a(r7);
        r9.b.setText(r8.c);
        SimpleDraweeView r1 = r9.c;
        String r3 = r8.d;
        int r4 = 0;
        if (r3 != null) goto L14;
    L17:
        boolean r5 = true;
    L19:
        if ((true ^ r5) == true) goto L22;
        r4 = 8;
    L22:
        r1.setVisibility(r4);
        Integer r2 = r8.e;
        if (r2 == null) goto L25;
        r9.b.setTextColor(r2.intValue());
    L26:
        String r10 = r8.d;
        if (r10 == null) goto L29;
        ImageLoaderKt.y(r9.c, r10, "default_menu", new e(), 4);
    L29:
        r9.a.setSelected(r8.f);
        return;
    L25:
        r9.b.setTextColor(ContextCompat.getColor(r0, v19.c.b(2130972079, r0, 2131103136)));
        goto L26
    L14:
        if (r3.length() == 0) goto L17;
        r5 = false;
        goto L19
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L5:
        r0 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ot8.b
    public final View a(CommonMenu r6, int r7, int r8, ot8.a r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r9, "item");
        if ((r9 instanceof pt8.b) == true) goto L6;
        return null;
    L6:
        FrameLayout r0 = new FrameLayout(r6.getContext());
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, i5.d0()));
        r0.setPadding(i5.q(), r0.getPaddingTop(), i5.A(), r0.getPaddingBottom());
        if (r8 != 1) goto L9;
        Drawable r10 = r0.getContext().getDrawable(v19.c.b(2130970624, r0.getContext(), 2131238869));
    L15:
        r0.setBackground(r10);
        pt8.b r11 = (pt8.b) r9;
        r0.setEnabled(!r11.h);
        LayoutInflater.from(r6.getContext()).inflate(2131563108, r0);
        LarusScreenWidgetMenuItemLayoutBinding r12 = LarusScreenWidgetMenuItemLayoutBinding.a(r0);
        r12.b.setText(r11.c);
        SimpleDraweeView r13 = r12.c;
        String r2 = r11.d;
        int r3 = 0;
        if (r2 != null) goto L18;
    L21:
        boolean r4 = true;
    L23:
        if ((true ^ r4) == true) goto L26;
        r3 = 8;
    L26:
        r13.setVisibility(r3);
        Integer r14 = r11.e;
        if (r14 == null) goto L29;
        r12.b.setTextColor(r14.intValue());
    L30:
        String r15 = r11.d;
        if (r15 == null) goto L33;
        ImageLoaderKt.y(r12.c, r15, "default_menu", new d(), 4);
    L33:
        r12.a.setSelected(r11.f);
        return r0;
    L29:
        r12.b.setTextColor(ContextCompat.getColor(r6.getContext(), v19.c.b(2130972079, r6.getContext(), 2131103136)));
        goto L30
    L18:
        if (r2.length() == 0) goto L21;
        r4 = false;
        goto L23
    L9:
        if (r7 != 0) goto L12;
        r10 = r0.getContext().getDrawable(v19.c.b(2130970615, r0.getContext(), 2131238839));
        goto L15
    L12:
        if (r7 != (r8 - 1)) goto L14;
        r10 = r0.getContext().getDrawable(v19.c.b(2130970618, r0.getContext(), 2131238849));
        goto L15
    L14:
        r10 = r0.getContext().getDrawable(v19.c.b(2130970621, r0.getContext(), 2131238859));
        goto L15
    }

    @Override // ot8.b
    public final void b(CommonMenu r2, final ot8.a r3, View r4, final Function1<? super ot8.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if ((r3 instanceof pt8.b) == false) goto L5;
        pt8.b r6 = (pt8.b) r3;
    L6:
        if (r6 == null) goto L10;
        if (r4 == null) goto L11;
        r4.setOnClickListener(new c(r3, r5));
        return;
    L11:
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
