package tc;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.obric.oui.slider.a {
    public SeekBar.OnSeekBarChangeListener A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12367z;

    /* JADX INFO: renamed from: tc.a$a, reason: collision with other inner class name */
    public static final class C0166a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f12368a;

        public C0166a(a r8) {
            this.f12368a = r8;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r8, int r10, boolean r11) {
            Log.i("SeekBarCompat", String.valueOf(r10));
            a r12 = this.f12368a;
            SeekBar.OnSeekBarChangeListener r13 = r12.A;
            if (r13 == null) goto L6;
            r13.onProgressChanged(r8, r10 + r12.f12367z, r11);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r8) {
            SeekBar.OnSeekBarChangeListener r10 = this.f12368a.A;
            if (r10 == null) goto L6;
            r10.onStartTrackingTouch(r8);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r8) {
            SeekBar.OnSeekBarChangeListener r10 = this.f12368a.A;
            if (r10 == null) goto L6;
            r10.onStopTrackingTouch(r8);
            return;
        }
    }

    public a(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
    }

    public final int getMaxRealValue() {
        return getMax() + this.f12367z;
    }

    public final int getMinRealValue() {
        return 0 + this.f12367z;
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return super.getProgress() + this.f12367z;
    }

    public final void setMaxValue(int r8) {
        setMax(r8 - this.f12367z);
    }

    public final void setMinValue(int r8) {
        this.f12367z = r8;
        setMax(getMax() - this.f12367z);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r8) {
        this.A = r8;
        super.setOnSeekBarChangeListener(new C0166a(this));
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r8) {
        super.setProgress(r8 - this.f12367z);
    }

    public a(Context r8, AttributeSet r10, int r11) {
        i.f(r8, "context");
        super(r8, r10, r11);
    }

    @Override // android.widget.ProgressBar
    public final void setProgress(int r8, boolean r10) {
        super.setProgress(r8 - this.f12367z, r10);
    }
}
