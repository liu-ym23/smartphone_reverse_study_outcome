package com.bytedance.android.livesdk.interactivity.like;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.like.view.CustomDiggTabCountView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1 implements v32.a, v32.c {
    public View a;
    public DataCenter b;
    public CustomDiggTabCountView c;
    public final HashSet<Bitmap> d;
    public final Context e;
    public final v32.d f;

    @Override // v32.a
    public final void unload() {
    }

    @Override // v32.a
    public final void clear() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Bitmap) r0.next()).recycle();
        goto L4
    }

    @Override // v32.a
    public final void load() {
        DataCenter r0 = this.b;
        if (r0 == null) goto L9;
        IRoom r1 = com.bytedance.android.live.core.utils.z.b(r0).a;
        if ((r1 instanceof Room) == true) goto L7;
        r1 = null;
    L7:
        Room r2 = (Room) r1;
        return;
    }

    public final Context getContext() {
        return this.e;
    }

    @Override // v32.a
    public final void b(DataCenter r6) {
        if (r6 == null) goto L4;
        this.b = r6;
    L4:
        Context r7 = this.e;
        if (r7 == null) goto L9;
        Resources r8 = r7.getResources();
        if (r8 == null) goto L9;
        this.d.add(BitmapFactory.decodeResource(r8, 2131250899));
    L9:
        View r9 = this.f.b();
        if ((r9 instanceof com.bytedance.android.livesdk.interactivity.like.view.y) == true) goto L12;
        Object r0 = null;
    L13:
        com.bytedance.android.livesdk.interactivity.like.view.y r1 = (com.bytedance.android.livesdk.interactivity.like.view.y) r0;
        if (r1 == null) goto L16;
        r1.setBitmapSize(this.f.d());
    L16:
        Unit r2 = Unit.INSTANCE;
        this.a = r9;
        ViewGroup r10 = this.f.a();
        CustomDiggTabCountView r3 = new CustomDiggTabCountView(r10.getContext(), null, 6, 0);
        r10.addView(r3, new ViewGroup.LayoutParams(-1, -1));
        r3.setBitmapSize(this.f.e());
        r3.setShowOffset(this.f.f());
        this.c = r3;
        View r4 = this.a;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");
    L19:
        r10.addView(r4, new ViewGroup.LayoutParams(-1, -1));
        return;
    L12:
        r0 = r9;
        goto L13
    }

    public f1(Context r2, v32.d r3) {
        Intrinsics.checkNotNullParameter(r3, "initializer");
        this.e = r2;
        this.f = r3;
        this.d = new HashSet();
    }

    @Override // v32.c
    public final void a(PointF r11, int r13) {
        Intrinsics.checkNotNullParameter(r11, "pointF");
        Bitmap r2 = this.f.c();
        if (r2 == null) goto L53;
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "tapStartPosition");
        View r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");
    L8:
        if ((r0 instanceof com.bytedance.android.livesdk.interactivity.like.view.z) == true) goto L10;
        r0 = null;
    L10:
        com.bytedance.android.livesdk.interactivity.like.view.z r1 = (com.bytedance.android.livesdk.interactivity.like.view.z) r0;
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.like.view.z.a.a(r1, r2, r11, new PointF(), com.bytedance.android.live.core.utils.z.e(this.b, false), -25.0f, null, 80);
    L13:
        CustomDiggTabCountView r3 = this.c;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("diggTapCountView");
    L16:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r11, "position");
        if (r13 < 10) goto L41;
        if ((r13 % 10) != 0) goto L25;
        int r4 = r13 + 10;
        r3.h.clear();
        int r5 = r13;
    L22:
        if (r5 >= r4) goto L25;
        r3.h.add(Integer.valueOf(r5));
        r5 = r5 + Random.Default.nextInt(2, 4);
    L25:
        if (r3.h.contains(Integer.valueOf(r13)) == false) goto L41;
        r3.i.a();
        r3.e = new PointF(r11.x, r11.y);
        r3.b.setText(String.valueOf(r13));
        if (10 > r13) goto L33;
        if (49 < r13) goto L33;
        int r14 = -1;
    L39:
        r3.b.setTextColor(r14);
        r3.c.setTextColor(r14);
        UtilityKotlinExtentionsKt.v(r3.d, false);
        r3.b.post(new com.bytedance.android.livesdk.interactivity.like.view.h(r3));
    L33:
        if (50 <= r13) goto L36;
    L38:
        r14 = ColorProtector.parseColor("#FFA9A9");
        goto L39
    L36:
        if (99 < r13) goto L38;
        r14 = ColorProtector.parseColor("#FFEBB6");
    L41:
        if (this.f.needPerformHapticFeedback() == false) goto L54;
        View r15 = this.a;     // Catch: NullPointerException -> L47
        if (r15 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("tapView");     // Catch: NullPointerException -> L47
    L45:
        r15.performHapticFeedback(1, 2);     // Catch: NullPointerException -> L47
        return;
    L47:
        e = move-exception;
        ALogger.e("DiggWidget", "performHapticFeedback npe: " + e);
        return;
    L54:
        return;
    }
}
