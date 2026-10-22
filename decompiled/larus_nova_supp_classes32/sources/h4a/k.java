package h4a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ivy.ivykit.api.bridge.inject.ActionSheetBuilder;
import com.ivy.ivykit.api.bridge.inject.DialogBuilder;
import com.ivy.ivykit.api.bridge.inject.ToastBuilder;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.utils.o0;
import com.lynx.tasm.LynxError;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements hx7.g {

    public static final class a {
    }

    public static final class b implements p0 {
        public final /* synthetic */ DialogBuilder a;

        public final void confirm() {
            DialogInterface.OnClickListener r0 = this.a.getPositiveClickListener();
            if (r0 == null) goto L6;
            r0.onClick(null, 0);
            return;
        }

        public b(DialogBuilder r1) {
            this.a = r1;
        }
    }

    public static final class c implements u {
        public final /* synthetic */ DialogBuilder a;

        public final void cancel() {
            DialogInterface.OnClickListener r0 = this.a.getNegativeClickListener();
            if (r0 == null) goto L6;
            r0.onClick(null, 1);
            return;
        }

        public c(DialogBuilder r1) {
            this.a = r1;
        }
    }

    static {
    }

    public k() {
    }

    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void e(ActionSheetBuilder r2, tx7.h.a r3) {
        Intrinsics.checkNotNullParameter(r2, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r3, "showActionSheetListener");
    }

    public final void b(ToastBuilder r9) {
        Intrinsics.checkNotNullParameter(r9, "toastBuilder");
        String r0 = r9.getMessage();
        if (r0 != null) goto L5;
        return;
    L5:
        AppHost.Companion r1 = AppHost.a;
        Activity r2 = r1.a().getCurrentActivity();
        if (r2 != null) goto L8;
        Context r3 = r1.getApplication();
    L9:
        Map r4 = r9.getExt();
        if (r4 == null) goto L12;
        Object r5 = r4.get("yOffsetPx");
    L14:
        if ((r5 instanceof Number) == false) goto L17;
        Float r6 = Float.valueOf(((Number) r5).floatValue());
    L20:
        if (r6 == null) goto L32;
        float r7 = r6.floatValue();
        if (Float.isInfinite(r7) == false) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == true) goto L30;
        r6 = null;
    L30:
        if (r6 == null) goto L32;
        float r10 = r6.floatValue();
        Resources r11 = r3.getResources();
        Integer r12 = Integer.valueOf(MathKt.roundToInt(r10 * WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density));
    L34:
        if (Intrinsics.areEqual("info", r9.getCustomIcon()) == false) goto L37;
        s r13 = s.a;
        Integer r14 = r9.getDuration();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "text");
        s.i(r3, r0, r14, false, false, r12);
        return;
    L37:
        String r15 = r9.getIcon();
        if (r15 != null) goto L40;
        r15 = r9.getType();
    L40:
        if (r15 == null) goto L60;
        int r16 = r15.hashCode();
        if (r16 == (-1867169789)) goto L57;
        if (r16 == 3641990) goto L53;
        if (r16 != 96784904) goto L60;
        if (r15.equals("error") == false) goto L60;
        s r17 = s.a;
        Integer r18 = r9.getDuration();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r0, "text");
        s.l(r3, 2131243493, r0, r18, r12, false);
        return;
    L53:
        if (r15.equals(LynxError.LEVEL_WARN) == false) goto L60;
        s r19 = s.a;
        Integer r20 = r9.getDuration();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r0, "text");
        s.l(r3, v19.c.b(2130972336, null, 2131243497), r0, r20, r12, false);
        return;
    L57:
        if (r15.equals("success") == false) goto L60;
        s r21 = s.a;
        Integer r22 = r9.getDuration();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r0, "text");
        s.l(r3, v19.c.b(2130972335, null, 2131243494), r0, r22, r12, false);
        return;
    L60:
        s r23 = s.a;
        Integer r24 = r9.getDuration();
        r23.getClass();
        s.i(r3, r0, r24, true, false, r12);
        return;
    L24:
        if (Float.isNaN(r7) == true) goto L26;
        r8 = true;
    L32:
        r12 = null;
        goto L34
    L17:
        if ((r5 instanceof String) == false) goto L19;
        r6 = StringsKt.toFloatOrNull((String) r5);
        goto L20
    L19:
        r6 = null;
        goto L20
    L12:
        r5 = null;
        goto L14
    L8:
        r3 = r2;
        goto L9
    }

    public final boolean d(DialogBuilder r7) {
        Intrinsics.checkNotNullParameter(r7, "dialogBuilder");
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        boolean r2 = false;
        if ((r0 instanceof FragmentActivity) == true) goto L5;
        return false;
    L5:
        CommonDialog.a r1 = new CommonDialog.a();
        String r3 = r7.getTitle();
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L8;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        Intrinsics.checkNotNullParameter(r3, "title");
        r1.a = r3;
        String r5 = r7.getMessage();
        if (r5 == null) goto L12;
        r4 = r5;
    L12:
        Intrinsics.checkNotNullParameter(r4, "message");
        r1.i = r4;
        CommonDialog.a.f(r1, new b(r7), r7.getPositiveBtnText(), false, 12);
        if (o0.d(r7.getNegativeBtnText()) == true) goto L15;
    L17:
        r1.z = r7.getCancelOnTouchOutside();
        String r8 = r7.getMessage();
        if (r8 != null) goto L20;
    L21:
        r2 = true;
    L22:
        if (r2 == false) goto L24;
        CommonDialog r9 = r1.c();
    L25:
        FragmentManager r6 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, null, r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r9, r10) == false) goto L32;
    L30:
        return true;
    L32:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L29:
        r9.show(r6, null);
        goto L30
    L24:
        r9 = r1.a();
        goto L25
    L20:
        if (r8.length() != 0) goto L22;
    L15:
        if (r7.getNegativeClickListener() == null) goto L17;
        CommonDialog.a.e(r1, new c(r7), r7.getNegativeBtnText(), 4);
        goto L17
    }
}
