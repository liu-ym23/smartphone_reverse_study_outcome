package com.ss.android.lark.desktopmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EmptyFrameFragment extends DesktopCompatFragment {
    public EmptyFrameFragment() {
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131561072, r3, false);
        ImageView r6 = (ImageView) r5.findViewById(2131374441);
        if (getArguments() == null) goto L7;
        int r7 = getArguments().getInt("holder");
        if (r7 == (-1)) goto L7;
        r6.setImageResource(r7);
    L7:
        return r5;
    }
}
