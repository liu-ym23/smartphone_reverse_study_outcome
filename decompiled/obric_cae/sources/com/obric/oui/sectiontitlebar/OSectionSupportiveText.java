package com.obric.oui.sectiontitlebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.cae.R;
import defpackage.c;
import he.i;
import pc.a;
import xd.f;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public final class OSectionSupportiveText extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f6507a;

    public OSectionSupportiveText(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        this.f6507a = c.R(new a(this));
        LayoutInflater.from(r8).inflate(R.layout.o_view_section_supportive_text, this, true);
        TypedArray r11 = r8.obtainStyledAttributes(r10, nb.a.f9504r, 0, 0);
        String r12 = r11.getString(0);
        getSectionDes().setText(r12);
        r11.recycle();
    }

    private final TextView getSectionDes() {
        return (TextView) this.f6507a.getValue();
    }

    public final void setSectionDes(String r8) {
        i.f(r8, "sectionText");
        getSectionDes().setText(r8);
    }
}
