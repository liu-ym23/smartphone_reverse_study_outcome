package com.larus.community.impl.detail.prompt;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.community.impl.detail.c0;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.ugc.community.adapter.RefViewAdapter;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020$H\u0002J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010/\u001a\u000200H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u00103\u001a\u000202H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b,\u0010-R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationDetailPromptComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;", "<init>", "()V", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "creationDetailTopToolsAbility", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "getCreationDetailTopToolsAbility", "()Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "creationDetailTopToolsAbility$delegate", "Lkotlin/Lazy;", "creationDetailBottomToolsAbility", "Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "getCreationDetailBottomToolsAbility", "()Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "creationDetailBottomToolsAbility$delegate", "creationDetailLoadingAbility", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "getCreationDetailLoadingAbility", "()Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "creationDetailLoadingAbility$delegate", "creationDetailFragmentAbility", "Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "getCreationDetailFragmentAbility", "()Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "creationDetailFragmentAbility$delegate", "creationTrackParams", "Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "getCreationTrackParams", "()Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "onAttach", "", "bindView", "creation", "initObserver", "getToolsView", "Landroid/view/View;", "screenHeight", "", "getScreenHeight", "()I", "screenHeight$delegate", "isToolsViewVisibleInWindow", "", "containerView", "Lcom/larus/community/impl/detail/prompt/CreationDetailPromptView;", "creationDetailPromptView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailPromptComponent extends ComponentFeature implements a {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public CreationDetailPromptView m;

    @Override // com.larus.community.impl.detail.prompt.a
    public final boolean vG() {
        CreationDetailPromptView r0 = this.m;
        if (r0 == null) goto L17;
        View r1 = r0.getToolsView();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.isShown() == true) goto L10;
        return false;
    L10:
        int[] r3 = new int[2];
        r1.getLocationOnScreen(r3);
        int r5 = (r3[1] + r1.getHeight()) + c7.b(12);
        FLogger r6 = FLogger.a;
        r6.i("CreationDetailPromptComponent", "view position top is " + r5 + " left is " + r3[0] + " width is " + r1.getWidth() + " height is " + r1.getHeight());
        if (r5 >= (((Number) this.l.getValue()).intValue() / 2)) goto L13;
        return true;
    L13:
        int r2 = ((Number) this.l.getValue()).intValue();
        int r4 = r2 - c7.b(76);
        r6.i("CreationDetailPromptComponent", "viewTop is " + r5 + " visibleBottom is " + r4 + " windowHeight is " + r2);
        if (r5 >= (r4 + c7.b(10))) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, a.class);
    }

    public CreationDetailPromptComponent() {
        this.h = LazyKt.lazy(new f(this));
        this.i = LazyKt.lazy(new g(this));
        this.j = LazyKt.lazy(new h(this));
        this.k = LazyKt.lazy(new i(this));
        this.l = LazyKt.lazy(new j(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.larus.community.impl.detail.prompt.CreationDetailPromptView] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.larus.community.impl.detail.prompt.c, java.lang.Object, kotlin.jvm.functions.Function1] */
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
    public final void F2(final UserCreation r15) {
        final ?? r0 = this.m;
        if (r0 == 0) goto L82;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        boolean r2 = true;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        j29.a r4 = (j29.a) s1a.d.a(this).a(j29.a.class);
        Intrinsics.checkNotNullParameter(r15, "userCreation");
        r0.b = r15;
        r0.c = r3;
        r0.e = r4;
        r0.a.d.setText(r15.d());
        ViewGroup.LayoutParams r5 = r0.a.d.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
    L14:
        UserCreation r7 = r0.b;
        if (r7 == null) goto L26;
        CreationPublishExtra r8 = r7.p;
        if (r8 == null) goto L26;
        String r9 = r8.c;
        if (r9 == null) goto L26;
        if (r9.length() <= 0) goto L23;
        boolean r10 = true;
    L24:
        if (r10 != true) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L39;
        e1.x(r0.a.b);
        AppCompatTextView r12 = r0.a.b;
        UserCreation r13 = r0.b;
        if (r13 == null) goto L35;
        CreationPublishExtra r14 = r13.p;
        if (r14 == null) goto L35;
        String r16 = r14.c;
        if (r16 == null) goto L35;
        String r17 = StringsKt.replace$default(r16, "\n", " ", false, 4, null);
    L36:
        r12.setText(r17);
        if (r6 == null) goto L42;
        r6.topMargin = i5.q();
    L42:
        AppCompatTextView r18 = r0.a.d;
        if (r18 == null) goto L45;
        r18.setLayoutParams(r6);
    L45:
        r0.a.e.T5(r15.b(), r15, false);
        AuthorInfo r20 = r15.g;
        if (r20 == null) goto L48;
        String r21 = r20.b;
    L50:
        if (Intrinsics.areEqual(r21, AccountService.a.getUserId()) == true) goto L58;
        CreationPublishExtra r22 = r15.p;
        if (r22 == null) goto L54;
        boolean r23 = Intrinsics.areEqual(r22.b, Boolean.FALSE);
    L55:
        if (r23 == false) goto L58;
        final boolean r24 = false;
    L59:
        List r25 = f0a.b.a(r15.o, r24);
        if ((!r25.isEmpty()) == false) goto L67;
        e1.x(r0.a.f);
        RefViewAdapter r26 = new RefViewAdapter(new n(r0, r15, r24));
        r0.d = r26;
        r0.a.f.setAdapter(r26);
        r0.a.f.setLayoutManager(new LinearLayoutManager(r0.getContext(), 0, false));
        if (r0.a.f.getItemDecorationCount() != 0) goto L64;
        r0.a.f.addItemDecoration(new CreationDetailPromptView$fillRefImage$2());
    L64:
        RefViewAdapter r27 = r0.d;
        if (r27 == null) goto L68;
        Intrinsics.checkNotNullParameter(r25, "data");
        r27.b = r25;
        r27.notifyDataSetChanged();
    L68:
        r0.R5(r15, Boolean.valueOf(r3), false);
        Function0 r110 = new b(this);
        final ?? r28 = new c(this);
        boolean r30 = z2.a.m();
        Intrinsics.checkNotNullParameter(r110, "likeAction");
        Intrinsics.checkNotNullParameter(r28, "makeSameAction");
        r0.a.e.setMakeSameActionVisible(r30);
        r0.a.e.R5(r110, r28, null);
        if (r30 == false) goto L71;
        e1.d(r0.a.d, new o(r28));
    L72:
        r0.a.d.setOnLongClickListener(new p(r0));
        c0 r111 = (c0) this.k.getValue();
        if (r111 != null) goto L75;
    L77:
        r2 = false;
    L78:
        if (r2 == true) goto L80;
        e1.o(r0.a.c);
        e1.o(r0.a.e);
        return;
    L80:
        e1.x(r0.a.c);
        e1.x(r0.a.e);
        return;
    L75:
        if (r111.yN() != true) goto L77;
    L71:
        r0.a.d.setOnClickListener(null);
        goto L72
    L67:
        e1.o(r0.a.f);
        goto L68
    L54:
        r23 = false;
    L58:
        r24 = true;
        goto L59
    L48:
        r21 = null;
    L35:
        r17 = null;
        goto L36
    L39:
        e1.o(r0.a.b);
        if (r6 == null) goto L42;
        r6.topMargin = 0;
        goto L42
    L23:
        r10 = false;
    L26:
        r11 = false;
        goto L27
    L13:
        r6 = null;
        goto L14
    L7:
        if (r1.getBoolean("show_usage_count", true) != true) goto L9;
        r3 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.community.impl.detail.prompt.a
    public final void ut(CreationDetailPromptView r15) {
        Intrinsics.checkNotNullParameter(r15, "creationDetailPromptView");
        this.m = r15;
        if (r15 == 0) goto L5;
        e1.x(r15);
    L5:
        CreationDetailPromptView r16 = this.m;
        if (r16 == null) goto L8;
        r16.setOnRefVideoOpenListener(new d(this));
    L8:
        CreationDetailPromptView r17 = this.m;
        if (r17 == null) goto L11;
        r17.setOnRefVideoCloseListener(new e(this));
    L11:
        j29.c r18 = (j29.c) s1a.d.a(this).a(j29.c.class);
        if (r18 == null) goto L14;
        UserCreation r110 = r18.a;
    L15:
        if (r110 == null) goto L21;
        CreationDetailPromptView r1 = this.m;
        if (r1 == null) goto L19;
        F2(r110);
    L20:
        if (r1 == null) goto L21;
    L22:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailPromptComponent$initObserver$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailPromptComponent$initObserver$2(this, null), 3, null);
        return;
    L19:
        r1 = null;
    L21:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailPromptComponent$bindView$5$1(this, null), 3, null);
        goto L22
    L14:
        r110 = null;
        goto L15
    }
}
