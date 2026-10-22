package c;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.zte.miboard.cards.CardCallback;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends LinearLayout implements CardCallback {
    public a(Context r5) {
        this(r5, null);
    }

    public a(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public a(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
