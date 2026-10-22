package v2a;

import android.content.Context;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.utils.a4;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.mix.VoiceEditArea;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ VoiceEditArea b;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r5) {
        AppCompatTextView r6 = this.a.j();
        Context r0 = this.b.getContext();
        ConstraintLayout r1 = this.a.a();
        if (r1 == null) goto L5;
        Context r2 = r1.getContext();
    L6:
        r6.setTextColor(ContextCompat.getColor(r0, v19.c.b(2130972079, r2, 2131103136)));
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r5) {
        Function1<? super Float, Unit> r0 = this.b.b;
        if (r0 != null) goto L5;
    L9:
        AppCompatTextView r6 = this.a.j();
        Context r1 = this.b.getContext();
        ConstraintLayout r2 = this.a.a();
        if (r2 == null) goto L12;
        Context r3 = r2.getContext();
    L13:
        r6.setTextColor(ContextCompat.getColor(r1, v19.c.b(2130972081, r3, 2131103143)));
        return;
    L12:
        r3 = null;
        goto L13
    L5:
        if (r5 == null) goto L7;
        int r7 = r5.getProgress();
    L8:
        r0.invoke(Float.valueOf((r7 - 6) / 2.0f));
        goto L9
    L7:
        r7 = 6;
        goto L8
    }

    public l(a r1, VoiceEditArea r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r7, int r8, boolean r9) {
        double r0 = ((double) (r8 - 6)) / 2.0d;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r0)}, 1)));     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L11;
        FLogger.a.e("VoiceEditArea", "pitch progress changed failed, progress = " + r8, r13);
    L11:
        if (Result.isFailure-impl(r12) == false) goto L13;
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        this.a.j().setText((String) r12);
        a4.a.getClass();
        a4.a(5);
        VoiceEditArea.R5(this.b, "voice_pitch", (float) r0, (this.a.i().getProgress() + 14) / 20.0f);
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
