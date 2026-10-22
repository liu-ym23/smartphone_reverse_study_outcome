package com.obric.oui.calendar;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a0 extends AppCompatTextView {
    public mla.h a;
    public DayOfWeek b;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Context r3, DayOfWeek r4) {
        super(r3);
        this.a = mla.h.a;
        setGravity(17);
        setTextAlignment(4);
        setTextSize(12.0f);
        setTypeface(Typeface.create(Typeface.DEFAULT, WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS, false));
        this.b = r4;
        setText(this.a.a(r4));
    }
}
