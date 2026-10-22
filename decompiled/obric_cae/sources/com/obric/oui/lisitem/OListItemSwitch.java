package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.obric.cae.R;
import com.obric.oui.oswitch.OSwitch;
import he.i;
import lc.f;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OListItemSwitch extends OListItemSettings {
    public final OSwitch L;
    public CompoundButton.OnCheckedChangeListener M;

    public static final class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OListItemSwitch f6365a;

        public a(OListItemSwitch r8) {
            this.f6365a = r8;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r8, boolean r10) {
            CompoundButton.OnCheckedChangeListener r11 = this.f6365a.M;
            if (r11 == null) goto L6;
            r11.onCheckedChanged(r8, r10);
            return;
        }
    }

    public OListItemSwitch(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10);
        setClickable(false);
        OSwitch r11 = new OSwitch(r8, null, 6);
        r11.setClickable(true);
        r11.setOnCheckedChangeListener(new a(this));
        j r12 = j.f13877a;
        this.L = r11;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        float r14 = 4;
        r13.leftMargin = android.aimedia.a.a("Resources.getSystem()", 1, r14);
        r13.rightMargin = android.aimedia.a.a("Resources.getSystem()", 1, r14);
        FrameLayout r15 = this.f9219r;
        if (r15 == null) goto L6;
        f.h(r15, r11, r13);
        return;
    L6:
        i.j("mTrailingElement");
        throw null;
    }

    @Override // com.obric.oui.lisitem.OListItemSettings, lc.f
    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_switch, this);
    }

    public final OSwitch getSwitch() {
        return this.L;
    }

    public final void setChecked(boolean r8) {
        this.L.setChecked(r8);
    }

    @Override // lc.f, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        this.L.setAlpha(1.0f);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r8) {
        this.M = r8;
    }
}
