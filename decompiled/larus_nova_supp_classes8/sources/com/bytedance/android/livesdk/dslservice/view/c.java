package com.bytedance.android.livesdk.dslservice.view;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.dslservice.slice.cache.f;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.experience.service.IExperienceProjectModeService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.d0;
import ev1.i;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import yt1.o;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements View.OnLongClickListener {
        public final /* synthetic */ Object a;
        public final /* synthetic */ o b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.dslservice.view.c$a$a, reason: collision with other inner class name */
        public static final class C0303a implements d0 {
            public final /* synthetic */ View a;

            public final void onFail(String r1) {
            }

            public C0303a(View r1) {
                this.a = r1;
            }

            public final void a(JavaOnlyMap r3) {
                Intrinsics.checkNotNullParameter(r3, "data");
                ip2.a r0 = new ip2.a();
                Intrinsics.checkNotNullParameter(GsonProtectorUtils.toJson(GsonHelper.getDefault(), r3.asHashMap()), "<set-?>");
                IExperienceProjectModeService r4 = (IExperienceProjectModeService) k.f(IExperienceProjectModeService.class);
                if (r4 == null) goto L6;
                r4.openDSLDialog(this.a.getContext(), r0);
                return;
            }
        }

        public a(Object r1, o r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r7) {
            int r0 = c.a;
            final Object r1 = this.a;
            o r2 = this.b;
            ip2.a r3 = null;
            Object r4 = null;
            if (r2 == null) goto L5;
            final q r5 = r2.b;
        L6:
            Intrinsics.checkNotNullParameter(r1, "dataProvider");
            if ((r1 instanceof r) == false) goto L18;
            ip2.a r6 = new ip2.a();
            Gson r8 = GsonHelper.getDefault();
            Map r9 = ((r) r1).b.j;
            if (r9 == null) goto L11;
            r4 = r9.get("data");
        L11:
            Intrinsics.checkNotNullParameter(GsonProtectorUtils.toJson(r8, r4), "<set-?>");
            if (r5 == null) goto L17;
            String r10 = f.c.a(r5);
            if (r10 != null) goto L16;
            r10 = "";
        L16:
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
        L17:
            new DSLDebugViewManager$getDebugData$$inlined$apply$lambda$1(r1, r5);
            r3 = r6;
        L18:
            if (r3 == null) goto L20;
            ((IExperienceProjectModeService) k.n(IExperienceProjectModeService.class)).openDSLDialog(r7.getContext(), r3);
        L20:
            Object r11 = this.a;
            if ((r11 instanceof AnnieXLynxView) == false) goto L25;
            ((AnnieXLynxView) r11).getCurrentData(new C0303a(r7));
            return false;
        L25:
            return false;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DSLDebugTextView a;

        public b(DSLDebugTextView r1) {
            this.a = r1;
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
        @Override // java.lang.Runnable
        public final void run() {
            this.a.measure(View.MeasureSpec.makeMeasureSpec(90, 1073741824), View.MeasureSpec.makeMeasureSpec(45, 1073741824));     // Catch: Throwable -> L4
            this.a.layout(0, 0, 90, 45);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.livesdk.dslservice.view.DSLDebugTextView] */
    public static void a(String r5, ViewGroup r6, Object r7, o r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        if (r6 != 0) goto L6;
        return;
    L6:
        if (v.a() == true) goto L9;
        return;
    L9:
        if (((Boolean) i.a.getValue()).booleanValue() == false) goto L11;
        return;
    L11:
        int r0 = r6.getChildCount();
        int r2 = 0;
    L12:
        if (r2 >= r0) goto L18;
        Object r3 = r6.getChildAt(r2);
        if ((r3 instanceof DSLDebugTextView) == true) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        ((DSLDebugTextView) r3).setData(com.bytedance.android.livesdk.dsl.util.c.g(r9));
        return;
    L18:
        ?? r1 = new DSLDebugTextView(r6.getContext());
        r1.setTemplateData(r8);
        r1.setData(com.bytedance.android.livesdk.dsl.util.c.g(r9));
        r1.setLayoutParams(new ViewGroup.LayoutParams(90, 45));
        r1.setText(r5);
        r1.setTextColor(-16777216);
        r1.setTextSize(1, 14.0f);
        r1.setBackgroundColor(-16711936);
        r1.setIncludeFontPadding(false);
        r1.post(new b(r1));
        r6.addView(r1);
        if (r7 == null) goto L24;
        r1.setOnLongClickListener(new a(r7, r8));
        return;
    }
}
