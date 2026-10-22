package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public final Function0<Unit> a;
    public f b;
    public g c;
    public List<QuickReplyItem> d;
    public Integer e;
    public boolean f;
    public boolean g;
    public int h;
    public com.larus.bmhome.taskskill.service.l i;
    public final e j;
    public boolean k;
    public Integer l;
    public final b m;

    public static final class a {
    }

    public static final class b implements sl8.b {
        public final /* synthetic */ m a;

        public final void b() {
            m r0 = this.a;
            r0.k = true;
            r0.j.d();
            m r1 = this.a;
            f r2 = r1.b;
            if (r2 != null) goto L5;
            return;
        L5:
            g r3 = r1.c;
            if (r3 == null) goto L9;
            r3.b(r2);
            return;
        }

        public b(m r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.bmhome.chat.standarduikit.interaction.viewmodel.k] */
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
        @Override // sl8.b
        public final void a(final int r15) {
            final m r0 = this.a;
            if (r0.g == true) goto L7;
            if (r0.f == true) goto L7;
        L9:
            f r1 = r0.b;
            if (r1 != null) goto L12;
            FLogger.a.w("InteractionQuickReplyVM", "[click] missing vmData, visibleIndex=" + r15);
            return;
        L12:
            g r4 = r0.c;
            if (r4 != 0) goto L15;
            FLogger.a.w("InteractionQuickReplyVM", "[click] missing dependency, visibleIndex=" + r15);
            return;
        L15:
            QuickReplyItem r5 = (QuickReplyItem) CollectionsKt.getOrNull(r0.d, r15);
            if (r5 != null) goto L18;
            FLogger.a.w("InteractionQuickReplyVM", "[click] invalid visibleIndex=" + r15 + ", itemCount=" + r0.d.size());
            return;
        L18:
            final int r6 = r0.h;
            r0.l = r5.getActionType();
            e r7 = r0.j;
            Integer r8 = r5.getActionType();
            e.b r9 = r7.d;
            if (r9 == null) goto L23;
            if (r8 == null) goto L23;
            int r10 = r8.intValue();
            Function2<String, JSONObject, Unit> r11 = r7.c;
            JSONObject r12 = e.a(r9, true);
            r12.put("button_type", r10);
            Unit r13 = Unit.INSTANCE;
            r11.invoke("click_interaction_button", r12);
        L23:
            FLogger.a.i("InteractionQuickReplyVM", "[click] accepted, actionType=" + r5.getActionType() + ", visibleIndex=" + r15 + ", bindingVersion=" + r6);
            com.larus.bmhome.taskskill.service.l r2 = r0.i;
            if (r2 == null) goto L26;
            r2.dispose();
        L26:
            r0.f = true;
            r0.e = Integer.valueOf(r15);
            r0.a.invoke();
            r0.i = r4.a(r1, r5, r15, new k(r0, r6, r15));
            return;
        L7:
            if (r0.e == null) goto L9;
            FLogger.a.d("InteractionQuickReplyVM", "[click] ignored, visibleIndex=" + r15 + ", bindingVersion=" + r0.h + ", finished=" + r0.g + ", actionInFlight=" + r0.f);
        }
    }

    static {
    }

    public m(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "invalidate");
        this.a = r2;
        this.d = CollectionsKt.emptyList();
        this.j = new e(0);
        this.m = new b(this);
    }
}
