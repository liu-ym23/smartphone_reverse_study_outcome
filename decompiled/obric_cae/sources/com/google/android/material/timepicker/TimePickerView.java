package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int B = 0;
    public final Chip A;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TimePickerView f5153a;

        public a(TimePickerView r8) {
            this.f5153a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            int r10 = TimePickerView.B;
            this.f5153a.getClass();
        }
    }

    public TimePickerView(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        a r11 = new a(this);
        LayoutInflater.from(r8).inflate(R.layout.material_timepicker, this);
        ClockFaceView r12 = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup r13 = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        MaterialButtonToggleGroup.d r14 = new d(this);
        r13.f4465m.add(r14);
        Chip r15 = (Chip) findViewById(R.id.material_minute_tv);
        Chip r16 = (Chip) findViewById(R.id.material_hour_tv);
        this.A = r16;
        ClockHandView r17 = (ClockHandView) findViewById(R.id.material_clock_hand);
        f r18 = new f(new GestureDetector(getContext(), new e(this)));
        r15.setOnTouchListener(r18);
        r16.setOnTouchListener(r18);
        r15.setTag(R.id.selection_type, 12);
        r16.setTag(R.id.selection_type, 10);
        r15.setOnClickListener(r11);
        r16.setOnClickListener(r11);
        r15.setAccessibilityClassName("android.view.View");
        r16.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r8, int r10) {
        super.onVisibilityChanged(r8, r10);
        if (r8 != this) goto L7;
        if (r10 != 0) goto L8;
        this.A.sendAccessibilityEvent(8);
        return;
    L8:
        return;
    }
}
