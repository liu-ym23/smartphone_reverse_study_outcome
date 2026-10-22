package v98;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.avlink.gallery.view.y0;
import com.larus.avlink.gallery.view.z0;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final PopupWindow a(FragmentActivity r9, View r10, View r11, final y0 r12, final z0 r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "anchorView");
        Intrinsics.checkNotNullParameter(r11, "sharePanelView");
        Intrinsics.checkNotNullParameter(r12, "onClose");
        Intrinsics.checkNotNullParameter(r13, "onSelectAllClicked");
        View r0 = LayoutInflater.from(r9).inflate(2131562994, null);
        final PopupWindow r7 = new PopupWindow(r0, -1, -2, false);
        r7.setBackgroundDrawable(ContextCompat.getDrawable(r9, R.color.transparent));
        r7.setOutsideTouchable(false);
        r7.setAnimationStyle(2131954384);
        r0.findViewById(2131362480).setOnClickListener(new e(r7, r12));
        r0.findViewById(2131362478).setOnClickListener(new f(r13));
        FrameLayout r14 = (FrameLayout) r0.findViewById(2131362481);
        if (r14 == null) goto L6;
        r11.setVisibility(0);
        r14.addView(r11, -1, -2);
    L6:
        if (PopupWindowLancet.hasSubWindowToken(r10) == false) goto L9;
    L15:
        return r7;
    L9:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r7) == false) goto L11;
        r7.showAtLocation(r10, 80, 0, 0);
        goto L15
    L11:
        OverlaySource r15 = PopupWindowLancet.resolveSource(r10);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r7, r10, r15, 80, 0, 0) == true) goto L15;
        r7.showAtLocation(r10, 80, 0, 0);
        PopupWindowLancet.trackAfterShow(r7, r15, r10);
        goto L15
    }
}
