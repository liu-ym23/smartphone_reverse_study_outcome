package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeColorTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuWidget;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i0 extends tk6.e<com.bytedance.android.livesdk.interactivity.api.publicscreen.d, View> {
    public final StrokeColorTextView e;
    public final h80.d<p22.n> f;

    public i0(View r4, PortraitSimpleZDanmakuWidget.c r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "danmakuSettingConfigSupplier");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.f = r5;
        this.e = (StrokeColorTextView) r4.findViewById(2131390473);
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
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r10 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) r8;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r9, "entity");
        p22.n r11 = (p22.n) this.f.get();
        boolean r0 = r10.isSelfSendFake();
        List<String> r1 = r10.b();
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        int r2 = r10.k();
        if (r10.g() == true) goto L8;
    L10:
        this.e.setTextColor(r2);
    L11:
        int r3 = b62.e.d;
        b62.e r4 = b62.e.a.a(r10);
        StrokeTextView r5 = this.e;
        r5.x(r4.a, r4.b);
        float r6 = r4.a;
        r5.setShadowLayer(r6, r6, r6, r4.c);
        if (r0 == false) goto L14;
        a1.k(this.e, (int) r11.d);
        this.e.setBackground(new com.bytedance.android.livesdk.interactivity.barrage.view.b(r2, null, 2));
    L15:
        this.e.setTextSize(0, r11.i);
        StrokeTextView r7 = this.e;
        int r13 = x52.a.a;
        r10.isSelfSendFake();
        CharSequence r14 = x52.a.b(r10, r11.i, false);
        Unit r15 = Unit.INSTANCE;
        r7.setText(r14);
        return;
    L14:
        this.e.setBackground(null);
        goto L15
    L8:
        if (r1.size() <= 1) goto L10;
        this.e.y(com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(r1, 0)), com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(r1, 1)));
        goto L11
    }
}
