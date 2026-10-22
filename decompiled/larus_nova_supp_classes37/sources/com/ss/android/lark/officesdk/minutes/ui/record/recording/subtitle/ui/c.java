package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final Context a;
    public final e b;
    public final TextView c;
    public final ImageView d;
    public final View e;
    public final View f;
    public final View g;
    public final PopupWindow h;

    public static final class a {
    }

    static {
    }

    public c(Context r3, MmSubtitleFragment.b r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.a = r3;
        this.b = r4;
        View r5 = LayoutInflater.from(r3).inflate(2131564084, null);
        this.g = r5.findViewById(2131387646);
        this.e = r5.findViewById(2131362111);
        View r6 = r5.findViewById(2131362085);
        this.f = r6;
        this.d = (ImageView) r5.findViewById(2131376394);
        this.c = (TextView) r5.findViewById(2131390921);
        ((TextView) r5.findViewById(2131390405)).setText(2131893508);
        r6.setOnClickListener(new com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.a(this));
        PopupWindow r7 = new PopupWindow(r5, -2, -2, true);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setOutsideTouchable(true);
        r7.setOnDismissListener(new b(this));
        this.h = r7;
    }
}
