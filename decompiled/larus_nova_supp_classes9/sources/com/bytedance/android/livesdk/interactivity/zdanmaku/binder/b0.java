package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 extends tk6.e<q72.e, View> {
    public final View e;
    public final ImageView f;
    public final StrokeColorTextView g;
    public final ImageView h;
    public final h80.d<p22.p> i;

    public b0(View r4, h80.d<p22.p> r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "danmakuSettingConfigSupplier");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.i = r5;
        this.e = r4.findViewById(2131367728);
        this.f = (ImageView) r4.findViewById(2131388176);
        this.g = (StrokeColorTextView) r4.findViewById(2131390473);
        this.h = (ImageView) r4.findViewById(2131374718);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(Object r8, RenderEntity r9) {
        q72.e r10 = (q72.e) r8;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r9, "entity");
        p22.p r11 = (p22.p) this.i.get();
        ViewGroup.LayoutParams r1 = this.f.getLayoutParams();
        if (r1 == null) goto L5;
        int r2 = r11.e.c;
        r1.height = r2;
        r1.width = r2;
        this.f.setLayoutParams(r1);
    L5:
        this.g.setText(com.bytedance.android.livesdk.interactivity.utils.b.b(r10, r11.e.a));
        List<String> r3 = r10.b();
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        int r4 = r10.k();
        if (r10.g() == true) goto L11;
    L13:
        this.g.setTextColor(r4);
    L14:
        int r5 = b62.e.d;
        b62.e r6 = b62.e.a.a(r10);
        StrokeTextView r7 = this.g;
        r7.x(r6.a, r6.b);
        float r13 = r6.a;
        r7.setShadowLayer(r13, r13, r13, r6.c);
        this.g.setTextSize(0, r11.e.d);
        int r0 = Color.parseColor("#" + r10.d());     // Catch: Exception -> L17
        View r14 = this.e;     // Catch: Exception -> L17
        GradientDrawable r15 = new GradientDrawable();     // Catch: Exception -> L17
        r15.setCornerRadius(60.0f);     // Catch: Exception -> L17
        r15.setColors(new int[]{ColorUtils.setAlphaComponent(r0, (int) 178.5f), ColorUtils.setAlphaComponent(r0, (int) 0.0f)});     // Catch: Exception -> L17
        r15.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L17
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L17
        r14.setBackground(r15);     // Catch: Exception -> L17
    L18:
        a1.k(this.e, r11.e.f);
        Bitmap r17 = r10.a;
        if (r17 == null) goto L21;
        this.f.setImageBitmap(r17);
    L22:
        Bitmap r18 = r10.c;
        if (r18 == null) goto L25;
        UtilityKotlinExtentionsKt.w(this.h);
        this.h.setImageBitmap(r18);
        return;
    L25:
        UtilityKotlinExtentionsKt.t(this.h);
        return;
    L21:
        this.f.setImageDrawable(null);
        goto L22
    L11:
        if (r3.size() <= 1) goto L13;
        this.g.y(com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(r3, 0)), com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(r3, 1)));
        goto L14
    }
}
