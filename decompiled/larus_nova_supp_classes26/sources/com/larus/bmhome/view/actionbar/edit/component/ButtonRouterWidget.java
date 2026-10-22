package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetButtonRouterBinding;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/ButtonRouterWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetButtonRouterBinding;", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/ButtonRouterController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/ButtonRouterController;", "curSelectedItem", "Lcom/larus/bmhome/view/actionbar/edit/component/SelectedItem;", "buttonShowReported", "", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "handleButtonClick", "launchTargetPage", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarButtonRouterTemplate;", "handleActivityResult", "selectedItem", "trackButtonShow", "trackButtonClick", "trackTemplateItemClick", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonRouterWidget extends AbsInstructionWidget {
    public LarusLayoutActionBarEditorWidgetButtonRouterBinding f;
    public i2 g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        xs8.a r1 = getController();
        if (r1 == null) goto L48;
        com.larus.bmhome.actionbar.model.a r2 = r1.l;
        if (r2 == null) goto L48;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r3 = this.f;
        String r4 = null;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L9:
        r3.d.setText(r2.b);
        if (this.h == true) goto L48;
        this.h = true;
        Map r5 = wa8.c0.a;
        wa8.c0.b(r2.d, ActionBarItemLocation.DETAIL_PANEL, null);
        com.larus.bmhome.view.actionbar.edit.c r6 = getViewModel();
        if (r6 == null) goto L17;
        ChatParam r7 = r6.getChatParam();
        if (r7 == null) goto L17;
        String r8 = r7.b;
    L18:
        com.larus.bmhome.view.actionbar.edit.c r9 = getViewModel();
        if (r9 == null) goto L23;
        ChatParam r10 = r9.getChatParam();
        if (r10 == null) goto L23;
        String r11 = r10.e;
    L24:
        com.larus.bmhome.view.actionbar.edit.c r12 = getViewModel();
        if (r12 == null) goto L27;
        String r13 = r12.getTemplateType();
    L28:
        com.larus.bmhome.view.actionbar.edit.c r14 = getViewModel();
        if (r14 == null) goto L31;
        String r15 = r14.getActionBarType();
    L32:
        com.larus.bmhome.view.actionbar.edit.c r16 = getViewModel();
        if (r16 == null) goto L37;
        com.larus.bmhome.actionbar.model.z0 r17 = r16.getCurrentCustomActionBarItem();
        if (r17 == null) goto L37;
        String r18 = r17.b;
    L38:
        String r19 = r2.b;
        String r110 = String.valueOf(r2.a);
        com.larus.bmhome.view.actionbar.edit.c r20 = getViewModel();
        if (r20 == null) goto L41;
        Boolean r26 = r20.isCreationActionBar();
    L42:
        com.larus.bmhome.view.actionbar.edit.c r21 = getViewModel();
        if (r21 == null) goto L47;
        ChatParam r22 = r21.getChatParam();
        if (r22 == null) goto L47;
        r4 = r22.c;
    L47:
        tx9.b.f(r8, r11, r13, r15, r18, null, null, r19, r110, 0, 0, null, null, null, null, "chat", null, null, null, "chat", r4, r26, 981088);
        goto L48
    L41:
        r26 = null;
    L37:
        r18 = null;
        goto L38
    L31:
        r15 = null;
        goto L32
    L27:
        r13 = null;
    L23:
        r11 = null;
    L17:
        r8 = null;
    L48:
        com.larus.bmhome.view.actionbar.edit.c r23 = getViewModel();
        if (r23 == null) goto L52;
        r23.onComponentVisibilityChanged(this, true);
        return;
    }

    private final xs8.a getController() {
        return (xs8.a) getController();
    }

    public ButtonRouterWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
    }

    public static Unit i6(ButtonRouterWidget r43, ConstraintLayout r44) {
        Intrinsics.checkNotNullParameter(r44, "it");
        xs8.a r1 = r43.getController();
        if (r1 == null) goto L89;
        com.larus.bmhome.actionbar.model.a r2 = r1.l;
        if (r2 == null) goto L89;
        Fragment r3 = r43.getFragment();
        String r4 = null;
        if (r3 == null) goto L52;
        FragmentActivity r5 = r3.getActivity();
        if (r5 == null) goto L52;
        ButtonRouterTargetPageStarter.a r6 = ButtonRouterTargetPageStarter.f;
        String r7 = r2.c;
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        i2 r8 = r43.g;
        if (r8 == null) goto L17;
        String r9 = r8.a;
        if (r9 == null) goto L17;
    L18:
        com.larus.bmhome.view.actionbar.edit.c r10 = r43.getViewModel();
        if (r10 == null) goto L26;
        com.larus.bmhome.actionbar.model.z0 r11 = r10.getCurrentCustomActionBarItem();
        if (r11 == null) goto L26;
        String r12 = r11.b;
        if (r12 == null) goto L26;
        String r13 = r12;
    L27:
        com.larus.bmhome.view.actionbar.edit.c r14 = r43.getViewModel();
        if (r14 == null) goto L30;
        String r15 = r14.getTemplateType();
    L31:
        com.larus.bmhome.view.actionbar.edit.c r16 = r43.getViewModel();
        if (r16 == null) goto L34;
        String r17 = r16.getActionBarType();
    L35:
        com.larus.bmhome.view.actionbar.edit.c r18 = r43.getViewModel();
        if (r18 == null) goto L40;
        ChatParam r19 = r18.getChatParam();
        if (r19 == null) goto L40;
        String r110 = r19.e;
    L41:
        com.larus.bmhome.view.actionbar.edit.c r20 = r43.getViewModel();
        if (r20 == null) goto L46;
        ChatParam r21 = r20.getChatParam();
        if (r21 == null) goto L46;
        String r111 = r21.b;
    L47:
        com.larus.bmhome.actionbar.model.u r22 = r43.getInstructionItem();
        if (r22 == null) goto L50;
        String r112 = r22.c;
    L51:
        j2 r23 = new j2(r7, r9, new p1(r15, r17, r13, "chat", r110, r111, "chat", r112, r2.b));
        h r24 = new h(r43);
        r6.getClass();
        ButtonRouterTargetPageStarter.a.a(r5, r23, r24);
        goto L52
    L50:
        r112 = null;
    L46:
        r111 = null;
    L40:
        r110 = null;
        goto L41
    L34:
        r17 = null;
        goto L35
    L30:
        r15 = null;
    L26:
        r13 = "";
    L17:
        r9 = "";
    L52:
        Map r25 = wa8.c0.a;
        wa8.c0.a(r2.d, ActionBarItemLocation.DETAIL_PANEL, null);
        com.larus.bmhome.view.actionbar.edit.c r26 = r43.getViewModel();
        if (r26 == null) goto L57;
        ChatParam r27 = r26.getChatParam();
        if (r27 == null) goto L57;
        String r28 = r27.b;
    L58:
        com.larus.bmhome.view.actionbar.edit.c r29 = r43.getViewModel();
        if (r29 == null) goto L63;
        ChatParam r30 = r29.getChatParam();
        if (r30 == null) goto L63;
        String r31 = r30.e;
    L64:
        com.larus.bmhome.view.actionbar.edit.c r32 = r43.getViewModel();
        if (r32 == null) goto L67;
        String r33 = r32.getTemplateType();
    L68:
        com.larus.bmhome.view.actionbar.edit.c r34 = r43.getViewModel();
        if (r34 == null) goto L71;
        String r35 = r34.getActionBarType();
    L72:
        com.larus.bmhome.view.actionbar.edit.c r36 = r43.getViewModel();
        if (r36 == null) goto L77;
        com.larus.bmhome.actionbar.model.z0 r37 = r36.getCurrentCustomActionBarItem();
        if (r37 == null) goto L77;
        String r38 = r37.b;
    L78:
        String r113 = r2.b;
        String r114 = String.valueOf(r2.a);
        com.larus.bmhome.view.actionbar.edit.c r39 = r43.getViewModel();
        if (r39 == null) goto L81;
        Boolean r210 = r39.isCreationActionBar();
    L82:
        com.larus.bmhome.view.actionbar.edit.c r0 = r43.getViewModel();
        if (r0 == null) goto L87;
        ChatParam r40 = r0.getChatParam();
        if (r40 == null) goto L87;
        r4 = r40.c;
    L87:
        tx9.b.e(r28, r31, r33, r35, r38, null, null, r113, r114, 0, 0, null, "select", null, null, null, null, null, "chat", null, null, null, "chat", r4, r210, null, null, null, null, null, null, null, null, null, null, null, null, -59250592, 127);
        goto L89
    L81:
        r210 = null;
    L77:
        r38 = null;
        goto L78
    L71:
        r35 = null;
        goto L72
    L67:
        r33 = null;
    L63:
        r31 = null;
    L57:
        r28 = null;
    L89:
        return Unit.INSTANCE;
    }

    public static final void k6(ButtonRouterWidget r45, i2 r46) {
        r45.getClass();
        FLogger.a.d("ButtonRouterWidget", "Received activity result: selectedId=" + r46.a + ", selectedName=" + r46.b + ", showPosition=" + r46.c);
        r45.g = r46;
        String r3 = null;
        if (r46.a != null) goto L5;
    L88:
        xs8.a r1 = r45.getController();
        if (r1 == null) goto L93;
        com.larus.bmhome.actionbar.model.a r2 = r1.l;
        if (r2 == null) goto L93;
        r2.j = new ArrayList();
    L93:
        String r0 = r45.f;
        if (r0 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L97:
        com.larus.utils.e1.o(((LarusLayoutActionBarEditorWidgetButtonRouterBinding) r3).e);
        return;
    L96:
        r3 = r0;
        goto L97
    L5:
        if (com.larus.utils.o0.d(r46.b) == false) goto L88;
        xs8.a r4 = r45.getController();
        String r6 = "";
        if (r4 == null) goto L24;
        com.larus.bmhome.actionbar.model.a r5 = r4.l;
        if (r5 == null) goto L24;
        com.larus.bmhome.actionbar.model.w[] r7 = new com.larus.bmhome.actionbar.model.w[1];
        String r8 = r46.b;
        if (r8 != null) goto L13;
        String r10 = "";
    L14:
        LinkedHashMap r14 = new LinkedHashMap();
        String r9 = r46.a;
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        r14.put("selected_id", r9);
        String r11 = r46.b;
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r14.put("selected_name", r11);
        Map<String, String> r12 = r46.d;
        if (r12 == null) goto L23;
        r14.putAll(r12);
    L23:
        Unit r13 = Unit.INSTANCE;
        r7[0] = new com.larus.bmhome.actionbar.model.w(null, r10, null, null, 0, r14, null, 8323069);
        r5.j = CollectionsKt.mutableListOf(r7);
        goto L24
    L13:
        r10 = r8;
    L24:
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r15 = r45.f;
        if (r15 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L27:
        AppCompatTextView r16 = r15.e;
        String r17 = r46.b;
        if (r17 == null) goto L30;
        r6 = r17;
    L30:
        r16.setText(r6);
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r18 = r45.f;
        if (r18 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L33:
        com.larus.utils.e1.x(r18.e);
        xs8.a r19 = r45.getController();
        if (r19 == null) goto L99;
        com.larus.bmhome.actionbar.model.a r20 = r19.l;
        if (r20 == null) goto L100;
        com.larus.bmhome.view.actionbar.edit.c r21 = r45.getViewModel();
        if (r21 == null) goto L42;
        ChatParam r22 = r21.getChatParam();
        if (r22 == null) goto L42;
        String r23 = r22.b;
    L43:
        com.larus.bmhome.view.actionbar.edit.c r24 = r45.getViewModel();
        if (r24 == null) goto L48;
        ChatParam r25 = r24.getChatParam();
        if (r25 == null) goto L48;
        String r26 = r25.e;
    L49:
        com.larus.bmhome.view.actionbar.edit.c r27 = r45.getViewModel();
        if (r27 == null) goto L52;
        String r28 = r27.getTemplateType();
    L53:
        i2 r29 = r45.g;
        if (r29 == null) goto L56;
        Integer r110 = r29.c;
    L57:
        com.larus.bmhome.view.actionbar.edit.c r30 = r45.getViewModel();
        if (r30 == null) goto L60;
        String r31 = r30.getActionBarType();
    L61:
        com.larus.bmhome.view.actionbar.edit.c r32 = r45.getViewModel();
        if (r32 == null) goto L66;
        com.larus.bmhome.actionbar.model.z0 r33 = r32.getCurrentCustomActionBarItem();
        if (r33 == null) goto L66;
        String r111 = r33.b;
    L67:
        com.larus.bmhome.actionbar.model.u r34 = r45.getInstructionItem();
        if (r34 == null) goto L70;
        String r112 = r34.c;
    L71:
        String r113 = r20.b;
        i2 r35 = r45.g;
        if (r35 == null) goto L74;
        String r114 = r35.b;
    L75:
        if (r35 == null) goto L77;
        String r115 = r35.a;
    L78:
        com.larus.bmhome.view.actionbar.edit.c r36 = r45.getViewModel();
        if (r36 == null) goto L81;
        Boolean r37 = r36.isCreationActionBar();
    L82:
        com.larus.bmhome.view.actionbar.edit.c r38 = r45.getViewModel();
        if (r38 == null) goto L87;
        ChatParam r39 = r38.getChatParam();
        if (r39 == null) goto L87;
        r3 = r39.c;
    L87:
        tx9.b.e(r23, r26, r28, r31, r111, r112, r113, r114, r115, 0, 0, r110, "select", null, null, null, null, "original", "chat", null, null, null, "chat", r3, r37, null, null, null, null, null, null, null, null, null, null, null, null, -59514880, 127);
        return;
    L81:
        r37 = null;
        goto L82
    L77:
        r115 = null;
        goto L78
    L74:
        r114 = null;
        goto L75
    L70:
        r112 = null;
    L66:
        r111 = null;
        goto L67
    L60:
        r31 = null;
        goto L61
    L56:
        r110 = null;
        goto L57
    L52:
        r28 = null;
    L48:
        r26 = null;
    L42:
        r23 = null;
        goto L43
    L100:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r3 = LarusLayoutActionBarEditorWidgetButtonRouterBinding.a(LayoutInflater.from(r1), this);
        this.f = r3;
        com.larus.utils.e1.d(r3.c, new g(this));
    }
}
