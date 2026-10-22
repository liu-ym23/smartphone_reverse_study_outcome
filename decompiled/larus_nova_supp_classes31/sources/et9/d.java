package et9;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.setting.api.data.FlowSettingsScene;
import com.larus.setting.api.data.SettingsItemAction;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(FlowSettingsScene r8, ItemGroup r9, final zs9.b r10) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r9, "group");
        Intrinsics.checkNotNullParameter(r10, "item");
        String r2 = "";
        if (r10.g != SettingsItemAction.TOGGLE) goto L22;
        final ItemTextToggle r11 = new ItemTextToggle(r9.getContext());
        r11.setTextFontWeight(500);
        r11.setBackgroundResource(2131239210);
        r9.addView(r11);
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r12;
        r13.width = -1;
        r13.height = -2;
        r11.setMinHeight(j19.c.c(56));
        String r14 = r10.c;
        if (r14 != null) goto L7;
        r14 = "";
    L7:
        r11.setSubText(r14);
        String r15 = r10.b;
        if (r15 == null) goto L10;
        r2 = r15;
    L10:
        r11.setText(r2);
        Integer r16 = r10.d;
        if (r16 == null) goto L13;
        r11.setImageSrc(r16.intValue());
    L14:
        CustomSwitchCompat r17 = r11.getToggleView();
        Boolean r0 = r10.e;
        if (r0 == null) goto L17;
        boolean r1 = r0.booleanValue();
    L18:
        r17.setChecked(r1);
        r11.getToggleView().setEnabled(r10.f);
        if (r10.f == false) goto L21;
        r11.getToggleView().setOnCheckedChangeListener(new a(r11, r10));
        return;
    L21:
        r11.getToggleView().a = true;
        r11.setAlpha(0.3f);
        e1.d(r11, new b(r10));
        return;
    L17:
        r1 = false;
        goto L18
    L13:
        r11.S5(null);
        goto L14
    L22:
        ItemTextArrow r18 = new ItemTextArrow(r9.getContext());
        r18.setTextFontWeight(500);
        r18.setBackgroundResource(2131239218);
        r9.addView(r18);
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r20 = (LinearLayout.LayoutParams) r19;
        r20.width = -1;
        r20.height = -2;
        r18.setMinHeight(j19.c.c(56));
        String r21 = r10.c;
        if (r21 != null) goto L25;
        r21 = "";
    L25:
        r18.Z5(r21, null);
        Integer r22 = r10.d;
        if (r22 == null) goto L28;
        r18.setImageSrc(r22.intValue());
    L29:
        String r23 = r10.b;
        if (r23 == null) goto L32;
        r2 = r23;
    L32:
        r18.setText(r2);
        e1.d(r18, new c(r10));
        return;
    L28:
        r18.S5(null);
        goto L29
    }
}
