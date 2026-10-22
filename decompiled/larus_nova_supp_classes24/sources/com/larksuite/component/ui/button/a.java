package com.larksuite.component.ui.button;

import android.R;
import android.content.res.ColorStateList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static ColorStateList a(int r9) {
        int r10 = r9 - (-805306368);
        return new ColorStateList(new int[][]{new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910}, new int[]{R.attr.state_checked, R.attr.state_pressed}, new int[]{-16842912, R.attr.state_pressed}, new int[]{R.attr.state_checked}, new int[]{-16842912}}, new int[]{r9 - (-520093696), 268435456, r10, 536870912, r10, 536870912});
    }

    public static ColorStateList b(int r9) {
        int r3 = r9 - (-1728053248);
        return new ColorStateList(new int[][]{new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910}, new int[]{R.attr.state_pressed, -16842912}, new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_checked}, new int[]{-16842912}}, new int[]{r9 - (-1442840576), -4539718, r3, r3, r9 | (-16777216), -1118482});
    }
}
