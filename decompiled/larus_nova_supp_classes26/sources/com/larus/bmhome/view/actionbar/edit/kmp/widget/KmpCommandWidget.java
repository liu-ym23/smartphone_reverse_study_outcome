package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import bt8.k;
import bt8.l;
import bt8.m;
import bt8.n;
import bt8.o;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.actionbar.model.c;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetKmpCommandBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import cq8.a0;
import cq8.i;
import cq8.z0;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t1a.b;
import v19.h;
import v19.i5;
import wa8.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001cH\u0014J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u000f\u0010&\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0002J\u001f\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020+H\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020+H\u0002J\u000f\u00102\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0002\u00104J\u0012\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0012\u00108\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpCommandWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedColor", "unselectedColor", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetKmpCommandBinding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/CommandDescriptor;", "hasReportShow", "", "hasAddedCalendarPermissionObserver", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "render", "renderSelection", "renderIcon", "commandOption", "Lcom/larus/bmhome/actionbar/model/ActionBarCommandOption;", "trackCommandShowOnce", "doReportShow", "trackCommandClick", "calculateShowPosition", "()Ljava/lang/Integer;", "findMultiRowContainer", "Landroid/widget/LinearLayout;", "rowParent", "Landroid/view/ViewGroup;", "calculatePositionInMultiRow", "multiRowContainer", "(Landroid/widget/LinearLayout;Landroid/view/ViewGroup;)Ljava/lang/Integer;", "countCommandWidgets", "row", "indexOfCommandWidgetInRow", "getConversationIdAsLong", "", "()Ljava/lang/Long;", "isPodcastOptionCommand", "command", "", "renderCommandVisibilityIfNeeded", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpCommandWidget extends AbsKmpInstructionWidget {
    public static final /* synthetic */ int m = 0;
    public final int f;
    public final int g;
    public final Lazy h;
    public LarusLayoutActionBarEditorWidgetKmpCommandBinding i;
    public i j;
    public boolean k;
    public boolean l;

    public static final class a {
    }

    static {
    }

    public KmpCommandWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpCommandWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final y getChatConversationAbility() {
        return (y) this.h.getValue();
    }

    private final Long getConversationIdAsLong() {
        y r0 = getChatConversationAbility();
        if (r0 == null) goto L5;
        String r1 = r0.Y1();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return StringsKt.toLongOrNull(r1);
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Integer Z5() {
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 != null) goto L9;
        return null;
    L9:
        if ((r1 instanceof LinearLayout) == false) goto L28;
        ViewParent r2 = ((LinearLayout) r1).getParent();
        if ((r2 instanceof LinearLayout) == false) goto L14;
        LinearLayout r3 = (LinearLayout) r2;
    L15:
        if (r3 == null) goto L28;
        Iterator r4 = ViewGroupKt.getChildren(r3).iterator();
        int r5 = 0;
    L19:
        if (r4.hasNext() == false) goto L26;
        if ((((View) r4.next()) instanceof LinearLayout) == false) goto L19;
        r5 = r5 + 1;
        if (r5 >= 0) goto L19;
        CollectionsKt.throwCountOverflow();
        goto L19
    L26:
        if (r5 < 2) goto L28;
    L29:
        if (r3 == null) goto L57;
        Iterator r6 = ViewGroupKt.getChildren(r3).iterator();
        int r7 = 0;
    L32:
        if (r6.hasNext() == false) goto L89;
        View r8 = (View) r6.next();
        if ((r8 instanceof LinearLayout) == false) goto L32;
        if (r8 == r1) goto L36;
        Iterator r9 = ViewGroupKt.getChildren((ViewGroup) r8).iterator();
        int r10 = 0;
    L49:
        if (r9.hasNext() == false) goto L55;
        if ((((View) r9.next()) instanceof KmpCommandWidget) == false) goto L49;
        r10 = r10 + 1;
        if (r10 >= 0) goto L49;
        CollectionsKt.throwCountOverflow();
        goto L49
    L55:
        r7 = r7 + r10;
        goto L32
    L36:
        Iterator r11 = ViewGroupKt.getChildren((ViewGroup) r8).iterator();
        int r12 = -1;
        int r13 = -1;
    L38:
        if (r11.hasNext() == false) goto L44;
        View r14 = (View) r11.next();
        if ((r14 instanceof KmpCommandWidget) == false) goto L38;
        r13 = r13 + 1;
        if (r14 != this) goto L38;
        r12 = r13;
    L44:
        if (r12 >= 0) goto L56;
        return null;
    L56:
        return Integer.valueOf((r7 + r12) + 1);
    L89:
        return null;
    L57:
        int r15 = r1.indexOfChild(this);
        if (r15 >= 0) goto L61;
        return null;
    L61:
        return Integer.valueOf(r15 + 1);
    L14:
        r3 = null;
    L28:
        r3 = null;
        goto L29
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v8, types: [bt8.l] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r11) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Object r2 = null;
        if ((r11 instanceof i) == true) goto L5;
        r11 = null;
    L5:
        i r12 = (i) r11;
        if (r12 == null) goto L207;
        Intrinsics.checkNotNullParameter(r12, "descriptor");
        this.j = r12;
        c r0 = r12.f;
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r1 = this.i;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L11:
        AppCompatTextView r3 = r1.d;
        if (r0 == null) goto L14;
        String r4 = r0.b;
    L15:
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        r3.setText(r4);
        c r5 = r12.f;
        boolean r6 = false;
        if (r5 == null) goto L25;
        Integer r7 = r5.i;
        if (r7 == null) goto L25;
        if (r7.intValue() != 1) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L28;
    L30:
        boolean r9 = false;
    L31:
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r10 = this.i;
        if (r10 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L34:
        r10.a.setSelected(r9);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r13 = this.i;
        if (r13 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L37:
        AppCompatTextView r14 = r13.d;
        if (r9 == false) goto L40;
        int r15 = this.f;
    L41:
        r14.setTextColor(r15);
        b r16 = getVContext();
        if (r16 == null) goto L44;
        com.larus.bmhome.chat.component.immerse.a r17 = (com.larus.bmhome.chat.component.immerse.a) r16.getAbility(com.larus.bmhome.chat.component.immerse.a.class);
    L45:
        if (r17 != null) goto L47;
    L49:
        boolean r18 = false;
    L50:
        boolean r19 = h.a;
        if (h.b(getContext()) == true) goto L55;
        if (r18 == true) goto L55;
        boolean r20 = false;
    L56:
        if (r20 == false) goto L61;
        if (r0 == null) goto L65;
        g1 r21 = r0.f;
        if (r21 == null) goto L65;
        String r22 = r21.b;
    L66:
        if (r20 == false) goto L71;
        if (r0 == null) goto L75;
        g1 r23 = r0.h;
        if (r23 == null) goto L75;
        String r24 = r23.b;
    L76:
        if (r22 != null) goto L78;
    L81:
        boolean r25 = true;
    L83:
        if (r25 == false) goto L88;
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r26 = this.i;
        if (r26 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L87:
        e1.o(r26.b);
    L95:
        if (r24 != null) goto L97;
    L100:
        boolean r27 = true;
    L102:
        if (r27 == false) goto L124;
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r28 = this.i;
        if (r28 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L106:
        e1.o(r28.c);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r29 = this.i;
        if (r29 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L109:
        AppCompatTextView r30 = r29.d;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if (r31 == null) goto L123;
        ViewGroup.MarginLayoutParams r32 = (ViewGroup.MarginLayoutParams) r31;
        if (r22 != null) goto L114;
    L117:
        boolean r33 = true;
    L118:
        if (r33 == false) goto L120;
        int r34 = i5.m();
    L121:
        r32.setMarginStart(r34);
        r32.setMarginEnd(i5.m());
        r30.setLayoutParams(r32);
    L151:
        if (r0 != null) goto L153;
    L155:
        if (r6 == true) goto L157;
    L171:
        if (r0 == null) goto L173;
        String r110 = r0.d;
    L175:
        if (Intrinsics.areEqual(r110, "sync_calendar") == false) goto L208;
        final ?? r111 = new l(this);
        if (((Boolean) r111.invoke()).booleanValue() == false) goto L180;
        FLogger.a.d("KmpCommandWidget", "[renderCommandVisibilityIfNeeded] gone");
        e1.o(this);
    L182:
        if (this.l == true) goto L204;
        this.l = true;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L186
        Object r36 = Result.constructor-impl(CompatKt.findFragment(this));     // Catch: Throwable -> L186
    L189:
        if (Result.isFailure-impl(r36) == true) goto L192;
        r2 = r36;
    L192:
        Fragment r37 = (Fragment) r2;
        if (r37 == null) goto L205;
        Lifecycle r38 = r37.getLifecycle();
        if (r38 == null) goto L206;
        r38.addObserver(new KmpCommandWidget$renderCommandVisibilityIfNeeded$2(r111, this));
        return;
    L206:
        return;
    L205:
        return;
    L186:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L189
    L204:
        return;
    L180:
        FLogger.a.d("KmpCommandWidget", "[renderCommandVisibilityIfNeeded] visible");
        e1.x(this);
        goto L182
    L208:
        return;
    L173:
        r110 = null;
        goto L175
    L157:
        if (this.k == true) goto L171;
        this.k = true;
        if (getParent() != null) goto L162;
    L170:
        addOnAttachStateChangeListener(new o(this, r12, r0));
        goto L171
    L162:
        if (isAttachedToWindow() == false) goto L170;
        if (isLaidOut() == true) goto L167;
    L169:
        addOnLayoutChangeListener(new n(this, r12, r0));
        goto L171
    L167:
        if (isLayoutRequested() == true) goto L169;
        Y5(this, r12, r0);
        goto L171
    L153:
        if (r0.k != true) goto L155;
        r6 = true;
        goto L155
    L120:
        r34 = i5.j0();
        goto L121
    L114:
        if (r22.length() == 0) goto L117;
        r33 = false;
        goto L118
    L123:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L124:
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r40 = this.i;
        if (r40 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r40 = null;
    L127:
        e1.x(r40.c);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r41 = this.i;
        if (r41 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r41 = null;
    L130:
        ImageLoaderKt.u(r41.c, r24, "custom_actionbar_icon");
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r42 = this.i;
        if (r42 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r42 = null;
    L133:
        AppCompatTextView r43 = r42.d;
        ViewGroup.LayoutParams r44 = r43.getLayoutParams();
        if (r44 == null) goto L201;
        ViewGroup.MarginLayoutParams r45 = (ViewGroup.MarginLayoutParams) r44;
        if (r22 != null) goto L138;
    L141:
        boolean r46 = true;
    L142:
        if (r46 == false) goto L144;
        int r47 = i5.m();
    L145:
        r45.setMarginStart(r47);
        r45.setMarginEnd(0);
        r43.setLayoutParams(r45);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r48 = this.i;
        if (r48 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r48 = null;
    L148:
        SimpleDraweeView r49 = r48.c;
        ViewGroup.LayoutParams r50 = r49.getLayoutParams();
        if (r50 == null) goto L199;
        ViewGroup.MarginLayoutParams r51 = (ViewGroup.MarginLayoutParams) r50;
        r51.setMarginEnd(i5.h());
        r49.setLayoutParams(r51);
        goto L151
    L199:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L144:
        r47 = i5.j0();
        goto L145
    L138:
        if (r22.length() == 0) goto L141;
        r46 = false;
        goto L142
    L201:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L97:
        if (r24.length() == 0) goto L100;
        r27 = false;
        goto L102
    L88:
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r52 = this.i;
        if (r52 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r52 = null;
    L91:
        e1.x(r52.b);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r53 = this.i;
        if (r53 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r53 = null;
    L94:
        ImageLoaderKt.u(r53.b, r22, "custom_actionbar_icon");
        goto L95
    L78:
        if (r22.length() == 0) goto L81;
        r25 = false;
    L75:
        r24 = null;
        goto L76
    L71:
        if (r0 == null) goto L75;
        g1 r54 = r0.g;
        if (r54 == null) goto L75;
        r24 = r54.b;
    L65:
        r22 = null;
        goto L66
    L61:
        if (r0 == null) goto L65;
        g1 r55 = r0.e;
        if (r55 == null) goto L65;
        r22 = r55.b;
    L55:
        r20 = true;
        goto L56
    L47:
        if (r17.pl() != true) goto L49;
        r18 = true;
        goto L50
    L44:
        r17 = null;
        goto L45
    L40:
        r15 = this.g;
        goto L41
    L28:
        if (r12.g == false) goto L30;
        r9 = true;
    L25:
        r8 = false;
        goto L26
    L14:
        r4 = null;
        goto L15
    }

    public static Unit V5(KmpCommandWidget r43, View r44) {
        Intrinsics.checkNotNullParameter(r44, "it");
        i r1 = r43.j;
        if (r1 == null) goto L28;
        c r2 = r1.f;
        if (r2 == null) goto L26;
        Integer r14 = r43.Z5();
        Map r3 = c0.a;
        c0.a(r2.c, ActionBarItemLocation.DETAIL_PANEL, r14);
        String r4 = r2.d;
        if (Intrinsics.areEqual(r4, "single_file") == false) goto L10;
    L13:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L21;
        Integer r6 = r2.a;
        if (r6 == null) goto L19;
        String r42 = r6.toString();
    L20:
        String r10 = r2.b;
        z0 r7 = r1.h;
        tx9.b.e(r7.a, r7.c, null, null, null, null, null, r10, r42, null, 1, r14, null, null, null, r43.getConversationIdAsLong(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -36228, 127);
        goto L26
    L19:
        r42 = null;
        goto L20
    L21:
        z0 r0 = r1.h;
        String r8 = r0.a;
        String r9 = r0.c;
        String r11 = r0.d;
        String r12 = r0.f;
        String r13 = r0.g;
        String r15 = r2.b;
        Integer r16 = r2.a;
        if (r16 == null) goto L24;
        String r17 = r16.toString();
    L25:
        tx9.b.c(r8, r9, r11, r12, r13, r15, r17, r14);
        goto L26
    L24:
        r17 = null;
        goto L25
    L10:
        if (Intrinsics.areEqual(r4, "paste_url") == true) goto L13;
        r5 = false;
    L26:
        r1.d.a(new cq8.h(r1.c));
        return Unit.INSTANCE;
    L28:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        LayoutInflater.from(r3).inflate(2131562721, this);
        int r5 = 2131374692;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(this, 2131374692);
        if (r6 == null) goto L11;
        r5 = 2131374696;
        SimpleDraweeView r0 = ViewBindings.findChildViewById(this, 2131374696);
        if (r0 == null) goto L11;
        r5 = 2131390830;
        AppCompatTextView r1 = ViewBindings.findChildViewById(this, 2131390830);
        if (r1 == null) goto L11;
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r7 = new LarusLayoutActionBarEditorWidgetKmpCommandBinding(this, r6, r0, r1);
        this.i = r7;
        e1.d(r7.a, new m(this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public KmpCommandWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = ContextCompat.getColor(r2, v19.c.b(2130972123, r2, 2131103203));
        this.g = ContextCompat.getColor(r2, v19.c.b(2130972079, r2, 2131103136));
        this.h = LazyKt.lazy(new k(this));
    }

    public static final void Y5(KmpCommandWidget r25, i r26, c r27) {
        Integer r12 = r25.Z5();
        Map r2 = c0.a;
        c0.b(r27.c, ActionBarItemLocation.DETAIL_PANEL, r12);
        String r3 = r27.d;
        if (Intrinsics.areEqual(r3, "single_file") == false) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L16;
        Integer r5 = r27.a;
        if (r5 == null) goto L14;
        String r24 = r5.toString();
    L15:
        String r8 = r27.b;
        z0 r0 = r26.h;
        tx9.b.f(r0.a, r0.c, null, null, null, null, null, r8, r24, null, 1, r12, null, r25.getConversationIdAsLong(), null, null, null, null, null, null, null, null, 8376956);
        return;
    L14:
        r24 = null;
        goto L15
    L16:
        z0 r1 = r26.h;
        String r6 = r1.a;
        String r7 = r1.c;
        String r9 = r1.d;
        String r10 = r1.f;
        String r11 = r1.g;
        String r13 = r27.b;
        Integer r14 = r27.a;
        if (r14 == null) goto L19;
        String r15 = r14.toString();
    L20:
        tx9.b.d(r6, r7, r9, r10, r11, r13, r15, r12);
        return;
    L19:
        r15 = null;
        goto L20
    L5:
        if (Intrinsics.areEqual(r3, "paste_url") == true) goto L8;
        r4 = false;
        goto L10
    }

    public /* synthetic */ KmpCommandWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
