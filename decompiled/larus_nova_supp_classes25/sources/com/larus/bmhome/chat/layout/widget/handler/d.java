package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.bmhome.chat.layout.item.LynxBox;
import com.larus.crossplatform.card.impl.LynxRenderDataRepo;
import com.larus.im.bean.message.Message;
import com.larus.ivykit.plugin.TemplateInfo;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import va8.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements pw8.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ TemplateInfo b;
    public final /* synthetic */ c c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Boolean f;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        LynxBox r0 = new LynxBox(this.a, this.b.getGravity(), this.b, this.c.b, null, null, null, false, 240);
        r0.setImmerseBgColor(this.c.c);
        y r1 = (y) this.c.g.getValue();
        if (r1 == null) goto L7;
        c r2 = this.c;
        w0 r3 = r1.bn(r2.a, r2.b);
        if (r3 == null) goto L7;
        r0.w(r3);
    L7:
        String r4 = this.d;
        Intrinsics.checkNotNull(r4);
        if (r4.length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L21;
        c r6 = this.c;
        String r7 = this.d;
        Intrinsics.checkNotNull(r7);
        Message r8 = this.c.a;
        if (r8 == null) goto L16;
        String r9 = r8.getMessageId();
        if (r9 == null) goto L16;
    L17:
        r6.getClass();
        CoroutineScope r10 = LynxRenderDataRepo.a;
        Intrinsics.checkNotNullParameter(r9, "key");
        if (LynxRenderDataRepo.b.b(r9) == true) goto L20;
        r0.q(LynxBox.LynxShowState.LOADING);
        LynxRenderDataRepo.b(r7, r9, new b(r9, r6, r0));
    L30:
        ViewGroup.LayoutParams r11 = r0.getLayoutParams();
        if (r11 == null) goto L39;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r11;
        r13.setMarginStart(0);
        r13.setMarginEnd(0);
        r0.setLayoutParams(r13);
        int r14 = this.a.getResources().getDimensionPixelSize(2131167562);
        if (Intrinsics.areEqual(this.f, Boolean.TRUE) == false) goto L35;
        int r15 = this.a.getResources().getDimensionPixelSize(2131167562);
    L36:
        FLogger.a.i("updatePaddingRelative", "view:" + LynxBox.class.getSimpleName() + ",source:,start:0,top:" + r14 + ",end:0,bottom:" + r15);
        r0.setPaddingRelative(0, r14, 0, r15);
        r0.setTag(2131379591, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("lynx", 1)}));
        r12.addView(r0);
        return;
    L35:
        r15 = 0;
        goto L36
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L20:
        LynxRenderDataRepo.c(r9, new a(r9, r6, r0, r7));
    L16:
        r9 = "";
        goto L17
    L21:
        String r16 = this.e;
        Intrinsics.checkNotNull(r16);
        if (r16.length() <= 0) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L30;
        if (Intrinsics.areEqual(r0.getTemplateInfo().getTemplateId(), "9") == false) goto L29;
        c.d(this.c);
    L29:
        c r18 = this.c;
        String r19 = this.e;
        Intrinsics.checkNotNull(r19);
        r18.e(r0, r19);
        goto L30
    L24:
        r17 = false;
        goto L25
    L10:
        r5 = false;
        goto L11
    }

    public final void b(int r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "currentViewGroup");
    }

    public d(Context r1, TemplateInfo r2, c r3, String r4, String r5, Boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
