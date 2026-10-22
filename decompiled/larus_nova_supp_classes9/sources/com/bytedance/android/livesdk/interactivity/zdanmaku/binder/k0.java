package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0 extends tk6.e<q72.f, View> {
    public final View e;
    public final HSImageView f;
    public final HSImageView g;
    public final HSImageView h;
    public final StrokeColorTextView i;
    public final h80.d<p22.p> j;

    public k0(View r4, h80.d<p22.p> r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "danmakuSettingConfigSupplier");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.j = r5;
        this.e = r4.findViewById(2131367728);
        this.f = r4.findViewById(2131388176);
        this.g = r4.findViewById(2131388177);
        this.h = r4.findViewById(2131388179);
        this.i = (StrokeColorTextView) r4.findViewById(2131390473);
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
    public final void b(Object r10, RenderEntity r11) {
        q72.f r13 = (q72.f) r10;
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r11, "entity");
        p22.p r14 = (p22.p) this.j.get();
        IBaseUser r0 = r13.getUserInfo();
        if (r0 == null) goto L7;
        py.c r1 = r0.getMAuthenticationInfo();
        if (r1 == null) goto L7;
        String r2 = r1.getCustomVerify();
    L8:
        boolean r3 = !TextUtils.isEmpty(r2);
        int r4 = r14.e.c;
        if (r3 == false) goto L16;
        r4 = r4 - s1.f(2.0f);
        ViewGroup.LayoutParams r5 = this.g.getLayoutParams();
        if (r5 == null) goto L13;
        int r6 = r14.e.c;
        r5.height = r6;
        r5.width = r6;
        this.g.setLayoutParams(r5);
    L13:
        ViewGroup.LayoutParams r7 = this.h.getLayoutParams();
        if (r7 == null) goto L17;
        int r8 = r14.e.e;
        r7.height = r8;
        r7.width = r8;
        this.h.setLayoutParams(r7);
    L17:
        ViewGroup.LayoutParams r9 = this.f.getLayoutParams();
        if (r9 == null) goto L20;
        r9.height = r4;
        r9.width = r4;
        this.f.setLayoutParams(r9);
    L20:
        this.i.setText(com.bytedance.android.livesdk.interactivity.utils.b.b(r13, r14.e.a));
        List<String> r15 = r13.b();
        if (r15 != null) goto L23;
        r15 = CollectionsKt.emptyList();
    L23:
        int r16 = r13.k();
        if (r13.g() == true) goto L26;
    L28:
        this.i.setTextColor(r16);
    L29:
        int r17 = b62.e.d;
        b62.e r18 = b62.e.a.a(r13);
        StrokeTextView r19 = this.i;
        r19.x(r18.a, r18.b);
        float r20 = r18.a;
        r19.setShadowLayer(r20, r20, r20, r18.c);
        this.i.setTextSize(0, r14.e.d);
        if (r13.isSelfSendFake() == false) goto L41;
        List<String> r21 = r15;
        if (r21 != null) goto L34;
    L37:
        boolean r23 = true;
    L38:
        if (r23 == false) goto L40;
        this.e.setBackgroundResource(2131252001);
    L42:
        a1.k(this.e, r14.e.f);
        Bitmap r110 = r13.a;
        if (r110 == null) goto L47;
        this.f.setImageBitmap(r110);
        if (r3 == false) goto L48;
        UtilityKotlinExtentionsKt.w(this.g);
    L48:
        Bitmap r111 = r13.b;
        if (r111 == null) goto L52;
        if (r3 == false) goto L52;
        this.h.setImageBitmap(r111);
        return;
    L52:
        this.h.setImageBitmap(null);
        return;
    L47:
        this.f.setImageDrawable(null);
        UtilityKotlinExtentionsKt.t(this.g);
        goto L48
    L40:
        this.e.setBackground(new com.bytedance.android.livesdk.interactivity.barrage.view.b(0, r15, 1));
        goto L42
    L34:
        if (r21.isEmpty() == true) goto L37;
        r23 = false;
        goto L38
    L41:
        this.e.setBackground(null);
        goto L42
    L26:
        if (r15.size() <= 1) goto L28;
        this.i.y(com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(r15, 0)), com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(r15, 1)));
        goto L29
    L16:
        this.g.setVisibility(8);
    L7:
        r2 = null;
        goto L8
    }
}
