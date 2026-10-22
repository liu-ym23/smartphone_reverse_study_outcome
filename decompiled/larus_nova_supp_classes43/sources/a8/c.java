package a8;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.annie.debug.ui.BaseCommonDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final FragmentActivity a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r1 instanceof FragmentActivity) == false) goto L7;
        return (FragmentActivity) r1;
    L7:
        if ((r1 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return a(((ContextWrapper) r1).getBaseContext());
    }

    @JvmStatic
    public static final void b(Context r1, BaseCommonDialogFragment r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        FragmentActivity r12 = a(r1);
        if (r12 == null) goto L15;
        FragmentManager r13 = r12.getSupportFragmentManager();
        if (r13 == null) goto L16;
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, r11, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r10, r0) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r10.show(r13, r11);
        return;
    L17:
        return;
    L16:
        return;
    }
}
