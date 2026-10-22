package com.larksuite.component.ignition.widget.setting_group;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        RecyclerView.Adapter r0 = r3.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        SettingGroupAdapter r1 = new SettingGroupAdapter(r3.getContext(), r0);
        if (r1.c == 2131101932) goto L9;
        r1.c = 2131101932;
    L9:
        r3.setAdapter(r1);
        SettingGroupDividerItemDecoration r2 = new SettingGroupDividerItemDecoration(r3.getContext());
        int r4 = UIUtils.getColor(r3.getContext(), 2131100557);
        SettingGroupDividerDrawable r5 = r2.a;
        r5.c = r4;
        r5.invalidateSelf();
        r3.addItemDecoration(r2);
        int r6 = UIUtils.dp2px(r3.getContext(), 16.0f);
        r3.setPadding(r6, r3.getPaddingTop(), r6, r3.getPaddingBottom());
        r3.setOverScrollMode(2);
    }

    @JvmStatic
    public static final void b(RecyclerView r3, int r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        RecyclerView.Adapter r0 = r3.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        SettingGroupAdapter r1 = new SettingGroupAdapter(r3.getContext(), r0);
        if (r1.c == r6) goto L9;
        r1.c = r6;
    L9:
        r3.setAdapter(r1);
        if (r5 == false) goto L12;
        SettingGroupDividerItemDecoration r7 = new SettingGroupDividerItemDecoration(r3.getContext());
        SettingGroupDividerDrawable r8 = r7.a;
        r8.b = r4;
        r8.invalidateSelf();
        r3.addItemDecoration(r7);
    L12:
        int r9 = UIUtils.dp2px(r3.getContext(), 16.0f);
        r3.setPadding(r9, r3.getPaddingTop(), r9, r3.getPaddingBottom());
        r3.setOverScrollMode(2);
    }
}
