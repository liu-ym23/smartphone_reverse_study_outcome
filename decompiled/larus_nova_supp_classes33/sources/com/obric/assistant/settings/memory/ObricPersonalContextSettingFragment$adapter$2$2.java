package com.obric.assistant.settings.memory;

import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ItemObricLocalDataSearchSelectBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.settings.ToggleName;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricPersonalContextSettingFragment$adapter$2$2 extends FunctionReferenceImpl implements Function1<ToggleName, Unit> {
    public ObricPersonalContextSettingFragment$adapter$2$2(Object r8) {
        super(1, r8, ObricPersonalContextSettingFragment.class, "handleDataSourceClick", "handleDataSourceClick(Lcom/obric/assistant/settings/ToggleName;)V", 0);
    }

    public final void invoke(final ToggleName r10) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        final ObricPersonalContextSettingFragment r0 = (ObricPersonalContextSettingFragment) ((CallableReference) this).receiver;
        int r1 = ObricPersonalContextSettingFragment.l;
        r0.getClass();
        int[] r2 = ObricPersonalContextSettingFragment.b.a;
        switch(r2[r10.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L12;
        };
    L5:
        r0.getString(2131912127);
        r0.getString(2131912136);
        r0.W90(r10);
        return;
    L6:
        r0.getString(2131912124);
        r0.getString(2131912132);
        r0.W90(r10);
        return;
    L7:
        r0.getString(2131912123);
        r0.getString(2131912130);
        r0.W90(r10);
        return;
    L8:
        r0.getString(2131912128);
        r0.getString(2131912138);
        r0.W90(r10);
        return;
    L9:
        r0.getString(2131912125);
        r0.getString(2131912133);
        r0.W90(r10);
        return;
    L10:
        r0.getString(2131912126);
        r0.getString(2131912135);
        r0.W90(r10);
        return;
    L12:
        switch(r2[r10.ordinal()]) {
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            default: goto L13;
        };
    L13:
        String r3 = "";
    L24:
        int r4 = r2[r10.ordinal()];
        if (r4 != 7) goto L27;
        String r5 = r0.getString(2131912139, new Object[]{tga.b.a()});
    L40:
        if (r5 == null) goto L71;
        FLogger.a.i("ObricPersonalContextSettingFragment", "showCustomPermissionToggleDialog, toggleName: " + r10 + ", title: " + r3);
        FragmentActivity r6 = r0.getActivity();
        if (r6 == null) goto L69;
        final ItemObricLocalDataSearchSelectBinding r7 = ItemObricLocalDataSearchSelectBinding.a(r0.getLayoutInflater(), null);
        OCardListItem r8 = r7.a;
        r8.setCardType(0);
        r8.p(false);
        r8.setTitle(r3);
        r8.s(true);
        r8.setSubTitle(r5);
        if (r5.length() <= 0) goto L47;
        boolean r9 = true;
    L48:
        r8.q(r9);
        r8.setDefaultCustomEndView(1);
        r8.m(true);
        r8.r(false);
        OCardListItem.h(r8, 0);
        r8.setOnContentClickListener(null);
        OSwitch r11 = r8.getEndSwitch();
        if (r11 == null) goto L51;
        r11.setOnCheckedChangeListener(null);
    L51:
        OSwitch r12 = r8.getEndSwitch();
        if (r12 == null) goto L54;
        r12.setChecked(true);
    L54:
        com.obric.oui.dialog.v2.alert.g r13 = new com.obric.oui.dialog.v2.alert.g(r6);
        r13.w = false;
        String r14 = r0.getString(2131912238);
        r13.j = false;
        r13.h = r14;
        zla.g r15 = new zla.g(new r(r7));
        Intrinsics.checkNotNullParameter(r15, "controller");
        r13.x = r15;
        com.obric.oui.dialog.v2.alert.g.c(r13);
        r13.e(r0.getString(2131912236), new f());
        r13.h(r0.getString(2131912237), new g(r7, r0, r10));
        com.obric.oui.dialog.v2.alert.c r16 = r13.a();
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L61;
        DialogLancet.handleBlockedDialogShow(r16);
        return;
    L61:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L60
    L58:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        return;
    L47:
        r9 = false;
        goto L48
    L69:
        return;
    L71:
        return;
    L27:
        if (r4 != 8) goto L29;
        r5 = r0.getString(2131912134);
        goto L40
    L29:
        if (r4 != 9) goto L31;
        r5 = r0.getString(2131912140);
        goto L40
    L31:
        if (r4 != 14) goto L33;
        r5 = r0.getString(2131912129);
        goto L40
    L33:
        if (r4 == 16) goto L35;
        r5 = null;
        goto L40
    L35:
        r5 = r0.getString(2131912137);
        goto L40
    L14:
        r3 = r0.getString(2131912160);
        goto L24
    L15:
        r3 = r0.getString(2131912162);
        goto L24
    L16:
        r3 = r0.getString(2131912146);
        goto L24
    L17:
        r3 = r0.getString(2131912164);
        goto L24
    L18:
        r3 = r0.getString(2131912159);
        goto L24
    L19:
        r3 = r0.getString(2131912163);
        goto L24
    L20:
        r3 = r0.getString(2131912158);
        goto L24
    L21:
        r3 = r0.getString(2131912170);
        goto L24
    L22:
        r3 = r0.getString(2131912152);
        goto L24
    L23:
        r3 = tga.b.a();
        goto L24
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ToggleName) r1);
        return Unit.INSTANCE;
    }
}
