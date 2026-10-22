package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends tk6.e<com.bytedance.android.livesdk.interactivity.zdanmaku.j, View> {
    public final ImageView e;
    public final ImageView f;
    public final StrokeColorTextView g;
    public final LinearLayout h;
    public final boolean i;
    public final h80.d<p22.k> j;

    /* JADX WARN: Type inference failed for: r0v8, types: [android.widget.TextView, com.bytedance.android.livesdk.chatroom.ui.StrokeTextView, com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView] */
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
    public final void b(Object r9, RenderEntity r10) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.j r11 = (com.bytedance.android.livesdk.interactivity.zdanmaku.j) r9;
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r10, "entity");
        p22.k r13 = (p22.k) this.j.get();
        Drawable r0 = r11.a.getBadgeDrawable();
        ImageView r1 = this.e;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        ImageView r4 = null;
        if (r3 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        r1.setVisibility(0);
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        int r6 = r13.d.j;
        r5.height = r6;
        r5.width = (r11.a.getBadgeWidth() * r6) / r11.a.getBadgeHeight();
        r1.setLayoutParams(r5);
    L16:
        Drawable r7 = r11.a.getRecentBadgeDrawable();
        ImageView r8 = this.f;
        if (r7 != null) goto L19;
    L21:
        r2 = false;
    L22:
        if (r2 == false) goto L24;
        r4 = r8;
    L24:
        if (r4 == null) goto L26;
        r4.setVisibility(0);
        ViewGroup.LayoutParams r14 = r4.getLayoutParams();
        int r15 = r13.d.j;
        r14.height = r15;
        r14.width = (r11.a.getRecentBadgeWidth() * r15) / r11.a.getRecentBadgeHeight();
        r4.setLayoutParams(r14);
    L27:
        StrokeTextView r16 = this.g;
        int r17 = x52.a.a;
        s3 r18 = r11.a;
        r16.setText(x52.a.a(r18, r18.isLocalInsertMsgOld(), this.i, r13.d.a));
        ?? r19 = this.g;
        r19.setTextColor(r13.d.m);
        r19.setTextSize(0, r13.d.d);
        r19.x(s1.f(0.5f), -1);
        r19.setStrokeColor(r13.d.n);
        r19.setAlpha(r13.c / 100.0f);
        LinearLayout r20 = this.h;
        Pair<Drawable, Rect> r21 = b62.d.a(r20.getContext(), r11.a, r13.d.e);
        if (r21 != null) goto L30;
        r21 = b62.d.b(r11.a);
    L30:
        Drawable r23 = (Drawable) r21.component1();
        Rect r24 = (Rect) r21.component2();
        r20.setBackground(r23);
        r20.setPadding(r24.left, r24.top, r24.right, r24.bottom);
        r20.getBackground().setAlpha((int) ((r13.c / 100.0f) * 255));
        return;
    L26:
        this.f.setVisibility(8);
        goto L27
    L19:
        if (r11.a.getRecentBadgeHeight() <= 0) goto L21;
    L15:
        this.e.setVisibility(8);
        goto L16
    L5:
        if (r11.a.getBadgeHeight() <= 0) goto L7;
        r3 = true;
        goto L8
    }

    public d(View r4, boolean r5, h80.d<p22.k> r6) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r6, "danmakuSettingConfigSupplier");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.i = r5;
        this.j = r6;
        this.e = (ImageView) r4.findViewById(2131363968);
        this.f = (ImageView) r4.findViewById(2131383860);
        this.g = (StrokeColorTextView) r4.findViewById(2131362306);
        this.h = (LinearLayout) r4.findViewById(2131367728);
    }
}
