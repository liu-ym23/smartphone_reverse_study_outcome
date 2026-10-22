package q78;

import android.app.Application;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import m58.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final boolean a(AudioRecord r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "tag");
        boolean r4 = false;
        if (Build.VERSION.SDK_INT < 29) goto L46;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L34
        CharSequence r3 = null;
        if (r6 == null) goto L7;
        AudioRecordingConfiguration r5 = r6.getActiveRecordingConfiguration();     // Catch: Throwable -> L34
    L8:
        if (r5 == null) goto L32;
        int r8 = c68.b.a;     // Catch: Throwable -> L34
        StringBuilder r9 = new StringBuilder("[");     // Catch: Throwable -> L34
        r9.append(r7);     // Catch: Throwable -> L34
        r9.append("][checkActiveRecordingConfiguration] AudioRecord(");     // Catch: Throwable -> L34
        r9.append(r6);     // Catch: Throwable -> L34
        r9.append("), isClientSilenced: ");     // Catch: Throwable -> L34
        r9.append(r5.isClientSilenced());     // Catch: Throwable -> L34
        r9.append(", AudioRecord.state: ");     // Catch: Throwable -> L34
        if (r6 == null) goto L12;
        Integer r10 = Integer.valueOf(r6.getState());     // Catch: Throwable -> L34
    L13:
        r9.append(r10);     // Catch: Throwable -> L34
        r9.append(", AudioRecord.getRecordingState: ");     // Catch: Throwable -> L34
        if (r6 == null) goto L16;
        Integer r11 = Integer.valueOf(r6.getRecordingState());     // Catch: Throwable -> L34
    L17:
        r9.append(r11);     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", r9.toString());     // Catch: Throwable -> L34
        if (r5.isClientSilenced() == false) goto L31;
        StringBuilder r12 = new StringBuilder("[");     // Catch: Throwable -> L34
        r12.append(r7);     // Catch: Throwable -> L34
        r12.append("][checkActiveRecordingConfiguration] audioDevice.id: ");     // Catch: Throwable -> L34
        AudioDeviceInfo r13 = r5.getAudioDevice();     // Catch: Throwable -> L34
        if (r13 == null) goto L22;
        Integer r14 = Integer.valueOf(r13.getId());     // Catch: Throwable -> L34
    L23:
        r12.append(r14);     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", r12.toString());     // Catch: Throwable -> L34
        StringBuilder r15 = new StringBuilder("[");     // Catch: Throwable -> L34
        r15.append(r7);     // Catch: Throwable -> L34
        r15.append("][checkActiveRecordingConfiguration] audioDevice.type: ");     // Catch: Throwable -> L34
        AudioDeviceInfo r16 = r5.getAudioDevice();     // Catch: Throwable -> L34
        if (r16 == null) goto L26;
        Integer r17 = Integer.valueOf(r16.getType());     // Catch: Throwable -> L34
    L27:
        r15.append(r17);     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", r15.toString());     // Catch: Throwable -> L34
        StringBuilder r19 = new StringBuilder("[");     // Catch: Throwable -> L34
        r19.append(r7);     // Catch: Throwable -> L34
        r19.append("][checkActiveRecordingConfiguration] audioDevice.productName: ");     // Catch: Throwable -> L34
        AudioDeviceInfo r20 = r5.getAudioDevice();     // Catch: Throwable -> L34
        if (r20 == null) goto L30;
        r3 = r20.getProductName();     // Catch: Throwable -> L34
    L30:
        r19.append(r3);     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", r19.toString());     // Catch: Throwable -> L34
        c68.b.d("AudioRecordUtils", "[" + r7 + "][checkActiveRecordingConfiguration] clientAudioSource: " + r5.getClientAudioSource());     // Catch: Throwable -> L34
        goto L31
    L26:
        r17 = null;
        goto L27
    L22:
        r14 = null;
    L31:
        r4 = r5.isClientSilenced();     // Catch: Throwable -> L34
        goto L32
    L16:
        r11 = null;
        goto L17
    L12:
        r10 = null;
    L32:
        Object r21 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L34
    L36:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (r22 == null) goto L39;
        int r23 = c68.b.a;
        c68.b.b("AudioRecordUtils", "[" + r7 + "]checkActiveRecordingConfiguration error :" + r22);
    L39:
        Boolean r24 = Boolean.FALSE;
        if (Result.isFailure-impl(r21) == false) goto L43;
        r21 = r24;
    L43:
        return ((Boolean) r21).booleanValue();
    L7:
        r5 = null;
    L34:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L46:
        return false;
    }

    public static final void b(f r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "caller");
        if (Build.VERSION.SDK_INT < 29) goto L19;
        AudioManager.AudioRecordingCallback r7 = (AudioManager.AudioRecordingCallback) r5.a.getValue();
        if (r7 == null) goto L21;
        m58.b r0 = h.k;
        if (r0 == null) goto L11;
        Application r1 = r0.getApplication();
        if (r1 == null) goto L11;
        Object r2 = r1.getSystemService("audio");
    L13:
        if ((r2 instanceof AudioManager) == false) goto L15;
        AudioManager r3 = (AudioManager) r2;
    L16:
        if (r3 == null) goto L18;
        r3.registerAudioRecordingCallback(r7, null);
    L18:
        int r4 = c68.b.a;
        c68.b.d("AudioRecordUtils", "[" + r6 + "] register callback_" + r7.hashCode() + " success");
        return;
    L15:
        r3 = null;
    L11:
        r2 = null;
        goto L13
    L21:
        return;
    L19:
        int r8 = c68.b.a;
        c68.b.d("AudioRecordUtils", "[" + r6 + "] register callback is not supported before Q");
    }

    public static final void c(f r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "caller");
        if (Build.VERSION.SDK_INT < 29) goto L18;
        AudioManager.AudioRecordingCallback r7 = (AudioManager.AudioRecordingCallback) r5.a.getValue();
        if (r7 == null) goto L20;
        m58.b r0 = h.k;
        AudioManager r1 = null;
        if (r0 == null) goto L11;
        Application r2 = r0.getApplication();
        if (r2 == null) goto L11;
        Object r3 = r2.getSystemService("audio");
    L13:
        if ((r3 instanceof AudioManager) == false) goto L15;
        r1 = (AudioManager) r3;
    L15:
        if (r1 == null) goto L17;
        r1.unregisterAudioRecordingCallback(r7);
    L17:
        int r4 = c68.b.a;
        c68.b.d("AudioRecordUtils", "[" + r6 + "] unregister callback_" + r7.hashCode() + " success");
        return;
    L11:
        r3 = null;
        goto L13
    L20:
        return;
    L18:
        int r8 = c68.b.a;
        c68.b.d("AudioRecordUtils", "[" + r6 + "] unregister callback is not supported before Q");
    }
}
