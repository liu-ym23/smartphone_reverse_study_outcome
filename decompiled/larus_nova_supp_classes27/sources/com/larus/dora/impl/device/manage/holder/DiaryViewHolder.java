package com.larus.dora.impl.device.manage.holder;

import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementDiaryBinding;
import com.larus.dora.impl.device.manage.DiaryDisplayMode;
import com.larus.dora.impl.device.manage.p0;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010BO\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/DiaryViewHolder;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementDiaryBinding;", "onDiaryListClick", "Lkotlin/Function0;", "", "onDiaryContentClick", "Lkotlin/Function1;", "", "onEmptyStateAction", "<init>", "(Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementDiaryBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "onBind", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiaryViewHolder extends BaseViewHolder<p0> {
    public static final /* synthetic */ int e = 0;
    public final LarusItemDoraGDeviceManagementDiaryBinding a;
    public final Function0<Unit> b;
    public final Function1<String, Unit> c;
    public final Function0<Unit> d;

    public static final class a {
    }

    static {
    }

    public DiaryViewHolder() {
        throw null;
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
    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void U3(p0 r9) {
        final p0 r10 = r9;
        Intrinsics.checkNotNullParameter(r10, "data");
        if ((r10 instanceof com.larus.dora.impl.device.manage.d) == true) goto L5;
        g49.d.d("DiaryViewHolder", "data is not DoraGDeviceManagementDiaryItem");
        return;
    L5:
        StringBuilder r0 = new StringBuilder("onBind: isLoading=");
        com.larus.dora.impl.device.manage.d r2 = (com.larus.dora.impl.device.manage.d) r10;
        r0.append(r2.j);
        r0.append(" isEmpty=");
        r0.append(r2.i);
        r0.append(" displayMode=");
        r0.append(r2.l);
        r0.append(" subtitle=");
        r0.append(r2.c);
        r0.append(" content=");
        r0.append(r2.d);
        r0.append(" isSodaBannerVisible=");
        r0.append(r2.n);
        g49.d.d("DiaryViewHolder", r0.toString());
        ViewGroup.LayoutParams r1 = this.a.a.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1;
    L9:
        if (r3 != null) goto L11;
    L18:
        this.a.l.setText(r2.b);
        this.a.b.setOnClickListener(null);
        this.a.h.setOnClickListener(null);
        this.a.d.setOnClickListener(null);
        if (r2.j == false) goto L22;
        this.a.i.setVisibility(0);
        this.a.d.setVisibility(8);
        this.a.f.setVisibility(8);
        return;
    L22:
        if (r2.l != DiaryDisplayMode.ENVIRONMENT_OFF) goto L24;
        this.a.i.setVisibility(8);
        this.a.d.setVisibility(8);
        this.a.f.setVisibility(0);
        this.a.g.setText(r2.d);
        this.a.e.setVisibility(0);
        this.a.e.setOnClickListener(new d(this));
        return;
    L24:
        this.a.i.setVisibility(8);
        this.a.f.setVisibility(8);
        this.a.d.setVisibility(0);
        String r4 = r2.c;
        boolean r5 = true;
        if (r4 != null) goto L27;
    L30:
        boolean r6 = true;
    L31:
        if (r6 == false) goto L33;
        this.a.j.setVisibility(8);
    L34:
        AppCompatTextView r7 = this.a.c;
        CharSequence r8 = r2.d;
        if (r8 != null) goto L38;
        r8 = "";
    L38:
        r7.setText(r8);
        DiaryDisplayMode r11 = r2.l;
        if (r11 != DiaryDisplayMode.NO_CONTENT) goto L41;
    L46:
        boolean r12 = true;
    L47:
        if (r12 == false) goto L49;
        LarusItemDoraGDeviceManagementDiaryBinding r13 = this.a;
        r13.c.setTextColor(ve8.d.a(2131103143, r13.a.getContext()));
    L50:
        ViewGroup.LayoutParams r14 = this.a.c.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        String r16 = r2.h;
        if (r16 != null) goto L53;
    L56:
        if (r5 == true) goto L58;
        this.a.k.setVisibility(0);
        this.a.k.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(i5.r0()));
        ImageLoaderKt.u(this.a.k, r2.h, "dora_diary_thumbnail");
        r15.setMarginEnd(i5.q());
    L59:
        this.a.c.setLayoutParams(r15);
        this.a.b.setOnClickListener(new e(this));
        this.a.h.setOnClickListener(new f(this));
        if (r2.m == false) goto L62;
        this.a.d.setOnClickListener(new g(this, r10));
        return;
    L62:
        this.a.d.setOnClickListener(null);
        this.a.d.setClickable(false);
        return;
    L58:
        this.a.k.setVisibility(8);
        r15.setMarginEnd(0);
        goto L59
    L53:
        if (r16.length() == 0) goto L56;
        r5 = false;
        goto L56
    L49:
        LarusItemDoraGDeviceManagementDiaryBinding r17 = this.a;
        r17.c.setTextColor(ve8.d.a(2131103136, r17.a.getContext()));
        goto L50
    L41:
        if (r11 == DiaryDisplayMode.NETWORK_ERROR) goto L46;
        String r18 = r2.d;
        int r20 = com.larus.utils.j0.a;
        if (Intrinsics.areEqual(r18, com.larus.utils.j0.d(2131902664)) == true) goto L46;
        r12 = false;
        goto L47
    L33:
        this.a.j.setVisibility(0);
        this.a.j.setText(r2.c);
        goto L34
    L27:
        if (r4.length() == 0) goto L30;
        r6 = false;
        goto L31
    L11:
        if (r2.n == false) goto L13;
    L16:
        r3.topMargin = i5.h();
    L17:
        this.a.a.setLayoutParams(r3);
        goto L18
    L13:
        if (r2.o == true) goto L16;
        r3.topMargin = i5.q();
        goto L17
    L8:
        r3 = null;
        goto L9
    }

    public DiaryViewHolder(LarusItemDoraGDeviceManagementDiaryBinding r2, Function0 r3, Function1 r4, Function0 r5) {
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
