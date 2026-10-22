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
public final class m implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ VoiceEditArea b;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r5) {
        AppCompatTextView r6 = this.a.c();
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
        if (r5 == null) goto L4;
        int r6 = r5.getProgress();
    L5:
        float r7 = (r6 + 14) / 20.0f;
        Function1<? super Float, Unit> r0 = this.b.c;
        if (r0 == null) goto L8;
        r0.invoke(Float.valueOf(r7));
    L8:
        AppCompatTextView r8 = this.a.c();
        Context r1 = this.b.getContext();
        ConstraintLayout r2 = this.a.a();
        if (r2 == null) goto L11;
        Context r3 = r2.getContext();
    L12:
        r8.setTextColor(ContextCompat.getColor(r1, v19.c.b(2130972081, r3, 2131103143)));
        return;
    L11:
        r3 = null;
        goto L12
    L4:
        r6 = 6;
        goto L5
    }

    public m(a r1, VoiceEditArea r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r6, int r7, boolean r8) {
        float r9 = (r7 + 14) / 20.0f;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r9)}, 1)));     // Catch: Throwable -> L5
    L7:
        Throwable r0 = Result.exceptionOrNull-impl(r12);
        if (r0 == null) goto L11;
        FLogger.a.e("VoiceEditArea", "rate progress changed failed, progress = " + r7, r0);
    L11:
        if (Result.isFailure-impl(r12) == false) goto L13;
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        this.a.c().setText((String) r12);
        a4.a.getClass();
        a4.a(5);
        VoiceEditArea.R5(this.b, "voice_speed", (float) (((double) (this.a.g().getProgress() - 6)) / 2.0d), r9);
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
