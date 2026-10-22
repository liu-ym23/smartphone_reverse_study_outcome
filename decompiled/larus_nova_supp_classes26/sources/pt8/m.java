package pt8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.common_res.common_ui.databinding.LarusScreenTinyMenuLayoutBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m implements ot8.b {

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

    public m() {
    }

    @Override // ot8.b
    public void update(ot8.a r9, View r10) {
        Intrinsics.checkNotNullParameter(r9, "item");
        if (r10 == null) goto L5;
        Context r0 = r10.getContext();
    L6:
        Context r1 = r0;
        if ((r9 instanceof g) == false) goto L16;
        if (r10 == null) goto L17;
        if (r1 == null) goto L18;
        g r11 = (g) r9;
        if (r11.c.size() == 2) goto L14;
        return;
    L14:
        pt8.b r3 = (pt8.b) ListProtector.get(r11.c, 0);
        pt8.b r4 = (pt8.b) ListProtector.get(r11.c, 1);
        c(r1, LarusScreenTinyMenuLayoutBinding.a(r10), r3, r4, null, null, false);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ot8.b
    public final View a(CommonMenu r9, int r10, int r11, ot8.a r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "item");
        if ((r12 instanceof g) == true) goto L5;
        return null;
    L5:
        g r13 = (g) r12;
        if (r13.c.size() == 2) goto L8;
        return null;
    L8:
        pt8.b r3 = (pt8.b) ListProtector.get(r13.c, 0);
        pt8.b r4 = (pt8.b) ListProtector.get(r13.c, 1);
        FrameLayout r14 = new FrameLayout(r9.getContext());
        r14.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, i5.m0()));
        LayoutInflater.from(r9.getContext()).inflate(2131563106, r14);
        LarusScreenTinyMenuLayoutBinding r2 = LarusScreenTinyMenuLayoutBinding.a(r14);
        c(r9.getContext(), r2, r3, r4, Integer.valueOf(r10), Integer.valueOf(r11), true);
        return r14;
    }

    @Override // ot8.b
    public final void b(CommonMenu r2, final ot8.a r3, View r4, final Function1<? super ot8.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if ((r3 instanceof g) == false) goto L5;
        g r6 = (g) r3;
    L6:
        if (r6 == null) goto L16;
        if (r4 == null) goto L11;
        View r7 = r4.findViewById(2131377798);
        if (r7 == null) goto L11;
        r7.setOnClickListener(new k(r3, r5));
    L11:
        if (r4 == null) goto L17;
        View r8 = r4.findViewById(2131384609);
        if (r8 == null) goto L18;
        r8.setOnClickListener(new l(r3, r5));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static void c(Context r2, final LarusScreenTinyMenuLayoutBinding r3, pt8.b r4, pt8.b r5, Integer r6, Integer r7, boolean r8) {
        if (r8 == false) goto L23;
        if (r7 != null) goto L7;
    L9:
        if (r6 != null) goto L12;
    L14:
        if (r7 == null) goto L21;
        int r9 = r7.intValue() - 1;
        if (r6 == null) goto L21;
        if (r6.intValue() != r9) goto L21;
        Pair r10 = new Pair(AppCompatResources.getDrawable(r2, v19.c.b(2130970724, r2, 2131239286)), AppCompatResources.getDrawable(r2, v19.c.b(2130970727, r2, 2131239295)));
    L22:
        r3.c.setBackground((Drawable) r10.getFirst());
        r3.g.setBackground((Drawable) r10.getSecond());
    L21:
        r10 = new Pair(AppCompatResources.getDrawable(r2, v19.c.b(2130970621, r2, 2131238859)), AppCompatResources.getDrawable(r2, v19.c.b(2130970621, r2, 2131238859)));
        goto L22
    L12:
        if (r6.intValue() != 0) goto L14;
        r10 = new Pair(AppCompatResources.getDrawable(r2, v19.c.b(2130970718, r2, 2131239268)), AppCompatResources.getDrawable(r2, v19.c.b(2130970721, r2, 2131239277)));
        goto L22
    L7:
        if (r7.intValue() != 1) goto L9;
        r10 = new Pair(AppCompatResources.getDrawable(r2, v19.c.b(2130970730, r2, 2131239304)), AppCompatResources.getDrawable(r2, v19.c.b(2130970733, r2, 2131239313)));
    L23:
        r3.d.setText(r4.c);
        r3.h.setText(r5.c);
        r3.h.post(new h(r3));
        Integer r11 = r4.e;
        if (r11 == null) goto L26;
        r3.d.setTextColor(r11.intValue());
    L26:
        Integer r12 = r5.e;
        if (r12 == null) goto L29;
        r3.h.setTextColor(r12.intValue());
    L29:
        String r13 = r4.d;
        if (r13 == null) goto L32;
        e1.x(r3.f);
        ImageLoaderKt.y(r3.f, r13, "default_menu", new i(), 4);
    L33:
        String r14 = r5.d;
        if (r14 == null) goto L36;
        e1.x(r3.j);
        ImageLoaderKt.y(r3.j, r14, "default_menu", new j(), 4);
    L37:
        r3.c.setEnabled(!r4.h);
        r3.g.setEnabled(!r5.h);
        r3.c.setSelected(r4.f);
        r3.g.setSelected(r5.f);
        return;
    L36:
        e1.q(r3.f);
        goto L37
    L32:
        e1.q(r3.f);
        goto L33
    }
}
