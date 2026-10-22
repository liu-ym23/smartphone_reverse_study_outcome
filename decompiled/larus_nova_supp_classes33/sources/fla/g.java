package fla;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.miniapp.view.actionsheet.MiniAppActionSheetAdapter;
import com.obric.miniapp.view.actionsheet.VerticalSpaceItemDecoration;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public static WeakReference<OActionSheet> a;

    static {
    }

    public g() {
    }

    public static void a(OActionSheet r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        OActionSheet.f(r3);     // Catch: Throwable -> L11 Exception -> L16
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L14:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void b(Context r4, List r5, String r6, OInsetSheet.PanelWidth r7, final Function0 r8) {
        Resources r1 = Resources.getSystem();
        int r0 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "optionList");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r7, "widthStyle");
        WeakReference<OActionSheet> r2 = a;
        if (r2 == null) goto L7;
        OActionSheet r3 = r2.get();
        if (r3 == null) goto L7;
        a(r3);
    L7:
        OActionSheet r9 = new OActionSheet(r4, new OActionSheet.Companion.a(r7, r6, new c(r8)));
        RecyclerView r10 = new RecyclerView(r4);
        r10.setOverScrollMode(2);
        r10.setLayoutManager(new LinearLayoutManager(r4));
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-1, -2);
        r11.gravity = 16;
        r10.setLayoutParams(r11);
        r10.addItemDecoration(new VerticalSpaceItemDecoration(r0));
        MiniAppActionSheetAdapter r12 = new MiniAppActionSheetAdapter(r4);
        r10.setAdapter(r12);
        Intrinsics.checkNotNullParameter(r5, "items");
        ((ArrayList) r12.b).clear();
        ((ArrayList) r12.b).addAll(r5);
        r12.notifyDataSetChanged();
        Intrinsics.checkNotNullParameter(new e(), "dialogGetter");
        Function2<? super a, ? super Integer, Unit> r13 = new f();
        Intrinsics.checkNotNullParameter(r13, "listener");
        r12.c = r13;
        OInsetSheet.d(r9.b(), r10);
        r9.setOnCancelListener(new d(r8));
        WeakReference<OActionSheet> r14 = new WeakReference(r9);
        a = r14;
        OActionSheet r15 = r14.get();
        if (r15 != null) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r15);
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
    }
}
