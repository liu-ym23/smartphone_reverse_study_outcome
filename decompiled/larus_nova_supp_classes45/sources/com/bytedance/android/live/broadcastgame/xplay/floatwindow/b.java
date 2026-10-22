package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import io.reactivex.functions.Consumer;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends FrameLayout {
    public final XplayFloatWindowView a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

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
        public final void accept(Object r7) {
            Boolean r8 = (Boolean) r7;
            int r0 = XplayLog.a;
            XplayLog.c("XplayFloatWindowLayer", "showFloatWindow: " + r8);
            if (r8.booleanValue() == true) goto L5;
            b r9 = this.a;
            r9.removeView(r9.a);
            ArraysKt.fill$default(this.a.a.g.d, 0, 0, 0, 6, null);
            return;
        L5:
            if (this.a.a.getParent() != null) goto L9;
            b r11 = this.a;
            r11.addView(r11.a);
            return;
        }
    }

    public b(Context r4, com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r5, XplayInternalContext r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "floatWindowContext");
        Intrinsics.checkNotNullParameter(r6, "internalContext");
        super(r4);
        Object r7 = LayoutInflater.from(r4).inflate(2131568050, this, false);
        if (r7 == null) goto L7;
        XplayFloatWindowView r8 = (XplayFloatWindowView) r7;
        this.a = r8;
        Intrinsics.checkNotNullParameter(r5, "floatWindowContext");
        r8.c = r5;
        r8.d = new XplayFloatWindowView.ViewHolder(r8, r8, r5);
        r6.getShowFloatWindow().a().startWith(r6.getShowFloatWindow().getValue()).subscribe(new a(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.xplay.floatwindow.XplayFloatWindowView");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        if (r3 == false) goto L4;
        this.a.j = true;
    L4:
        super.onLayout(r3, r4, r5, r6, r7);
    }
}
