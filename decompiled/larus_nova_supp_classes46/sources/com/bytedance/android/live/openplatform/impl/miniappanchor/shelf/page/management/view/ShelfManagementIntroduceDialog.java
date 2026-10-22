package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformBottomDialog;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementIntroduceDialog;", "Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformBottomDialog;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementIntroduceDialog extends OpenPlatformBottomDialog {
    public static final /* synthetic */ int e = 0;
    public Map<Integer, View> d;

    public static final class a {
        public static void a(FragmentActivity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            ShelfManagementIntroduceDialog r0 = new ShelfManagementIntroduceDialog();
            FragmentManager r4 = r3.getSupportFragmentManager();
            LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "ShelfManagementIntroduceDialog", r1);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r1) == true) goto L11;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r0.show(r4, "ShelfManagementIntroduceDialog");
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementIntroduceDialog a;

        public b(ShelfManagementIntroduceDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementIntroduceDialog a;

        public c(ShelfManagementIntroduceDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public ShelfManagementIntroduceDialog() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        ((ImageView) S90(2131366984)).setOnClickListener(new b(this));
        ((TextView) S90(2131376857)).setOnClickListener(new c(this));
        S90(2131375572).J(UtilityKotlinExtentionsKt.i(12), 0, UtilityKotlinExtentionsKt.i(12), 0);
        String r6 = i2.a;
        i2.h(S90(2131375572), "/openplatform/live_nativeapp_memory_shelf_tip@3x.png");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565771, r3, false);
    }
}
