package com.larus.audio.audiov3.util;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import c68.b;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J3\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0012J-\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\f\"\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\u0012\u0010\u001f\u001a\u00020 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¨\u0006\""}, d2 = {"Lcom/larus/audio/audiov3/util/AudioDeviceHelperImpl;", "Lcom/larus/audio/audiov3/util/IAudioDeviceHelper;", "<init>", "()V", "pickDeviceType", "", "hasWired", "", "hasBluetooth", "hasBuiltin", "pickDeviceTypeFromDevices", "devices", "", "Landroid/media/AudioDeviceInfo;", "wiredTypes", "", "bluetoothTypes", "builtinTypes", "([Landroid/media/AudioDeviceInfo;[I[I[I)Ljava/lang/String;", "mergeTypes", "base", "extras", "([I[[I)[I", "sanitizeBluetoothDeviceName", "rawName", "", "getInputDeviceType", "context", "Landroid/content/Context;", "getOutputDeviceType", "getBluetoothDeviceName", "getAudioDeviceInfo", "Lcom/larus/audio/audiov3/util/IAudioDeviceHelper$DeviceInfo;", "Companion", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioDeviceHelperImpl implements IAudioDeviceHelper {
    public static final int[] a = null;
    public static final int[] b = null;
    public static final int[] c = null;
    public static final int[] d = null;
    public static final int[] e = null;
    public static final int[] f = null;
    public static final int[] g = null;
    public static final int[] h = null;
    public static final int[] i = null;
    public static final int[] j = null;
    public static final int[] k = null;
    public static final int[] l = null;

    public static final class a {
    }

    public AudioDeviceHelperImpl() {
    }

    static {
        a = new int[]{3, 5, 6, 11, 12, 19};
        b = new int[]{22};
        c = new int[]{3, 4, 5, 6, 9, 10, 11, 12, 13, 19};
        d = new int[]{22};
        e = new int[]{29};
        f = new int[]{31};
        g = new int[]{7, 8};
        h = new int[]{23};
        i = new int[]{26, 27, 30};
        j = new int[]{15};
        k = new int[]{2, 1};
        l = new int[]{24};
    }

    public static String d(CharSequence r5) {
        Character r0 = null;
        if (r5 == null) goto L21;
        String r6 = r5.toString();
        if (r6 == null) goto L21;
        boolean r3 = false;
        if (StringsKt.contains$default(r6, "\\u", false, 2, null) == true) goto L17;
        int r1 = 0;
    L11:
        if (r1 >= r6.length()) goto L16;
        char r2 = r6.charAt(r1);
        if (Character.isISOControl(r2) == true) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        r0 = Character.valueOf(r2);
    L16:
        if (r0 != null) goto L17;
    L18:
        if (r3 == false) goto L24;
        return "";
    L24:
        return r6;
    L17:
        r3 = true;
    L21:
        return null;
    }

    @Override // com.larus.audio.audiov3.util.IAudioDeviceHelper
    public final IAudioDeviceHelper.a a(Context r19) {
        Object r0 = r19.getSystemService("audio");
        if ((r0 instanceof AudioManager) == false) goto L5;
        AudioManager r1 = (AudioManager) r0;
    L6:
        int[] r3 = i;
        int[] r5 = g;
        int[] r6 = h;
        int r7 = 0;
        String r15 = "other";
        if (r1 != null) goto L99;
        String r4 = "other";
    L25:
        Object r2 = r19.getSystemService("audio");
        if ((r2 instanceof AudioManager) == false) goto L28;
        AudioManager r8 = (AudioManager) r2;
    L29:
        if (r8 == null) goto L61;
        int r9 = Build.VERSION.SDK_INT;     // Catch: Exception -> L57
        if (r9 < 23) goto L59;
        AudioDeviceInfo[] r10 = r8.getDevices(2);     // Catch: Exception -> L57
        int[] r11 = e;
        int[] r16 = d;
        int[] r12 = c;
        if (r9 < 34) goto L39;
        r12 = b(r12, new int[][]{r16, r11, f});     // Catch: Exception -> L57
    L45:
        if (r9 < 33) goto L48;
        int[] r13 = b(r5, new int[][]{r6, r3});     // Catch: Exception -> L57
    L52:
        int[] r14 = k;
        if (r9 < 34) goto L55;
        r14 = b(r14, new int[][]{l});     // Catch: Exception -> L57
    L55:
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L57
        r15 = c(r10, r12, r13, r14);     // Catch: Exception -> L57
        goto L61
    L48:
        if (r9 < 29) goto L51;
        r13 = b(r5, new int[][]{r6});     // Catch: Exception -> L57
        goto L52
    L51:
        r13 = r5;
        goto L52
    L39:
        if (r9 < 31) goto L42;
        r12 = b(r12, new int[][]{r16, r11});     // Catch: Exception -> L57
        goto L45
    L42:
        if (r9 < 26) goto L45;
        r12 = b(r12, new int[][]{r16});     // Catch: Exception -> L57
    L59:
        r15 = null;
    L57:
        e = move-exception;
        int r17 = b.a;
        b.b("AudioDeviceHelper", "getOutputDeviceType error: " + e.getMessage());
    L61:
        if (Intrinsics.areEqual(r4, "bluetooth") == false) goto L63;
    L64:
        int r20 = Build.VERSION.SDK_INT;
        if (r20 < 23) goto L94;
        Object r21 = r19.getSystemService("audio");
        if ((r21 instanceof AudioManager) == false) goto L69;
        AudioManager r22 = (AudioManager) r21;
    L71:
        if (r20 < 33) goto L74;
        r5 = b(r5, new int[][]{r6, r3});
    L76:
        if (r22 == null) goto L85;
        AudioDeviceInfo[] r23 = r22.getDevices(2);
        if (r23 == null) goto L85;
        int r24 = r23.length;
        int r25 = 0;
    L80:
        if (r25 >= r24) goto L85;
        AudioDeviceInfo r26 = r23[r25];
        if (ArraysKt.contains(r5, r26.getType()) == true) goto L83;
        r25 = r25 + 1;
        goto L80
    L83:
        String r27 = d(r26.getProductName());
    L96:
        return new IAudioDeviceHelper.a(r4, r15, r27);
    L85:
        if (r22 == null) goto L94;
        AudioDeviceInfo[] r29 = r22.getDevices(1);
        if (r29 == null) goto L94;
        int r30 = r29.length;
    L89:
        if (r7 >= r30) goto L94;
        AudioDeviceInfo r31 = r29[r7];
        if (ArraysKt.contains(r5, r31.getType()) == true) goto L92;
        r7 = r7 + 1;
        goto L89
    L92:
        r27 = d(r31.getProductName());
        goto L96
    L74:
        if (r20 < 29) goto L76;
        r5 = b(r5, new int[][]{r6});
        goto L76
    L69:
        r22 = null;
    L94:
        r27 = null;
        goto L96
    L63:
        if (Intrinsics.areEqual(r15, "bluetooth") == false) goto L94;
    L28:
        r8 = null;
        goto L29
    L99:
        int r32 = Build.VERSION.SDK_INT;     // Catch: Exception -> L22
        if (r32 < 23) goto L24;
        AudioDeviceInfo[] r33 = r1.getDevices(1);     // Catch: Exception -> L22
        int[] r110 = a;
        if (r32 < 26) goto L15;
        r110 = b(r110, new int[][]{b});     // Catch: Exception -> L22
    L15:
        if (r32 < 33) goto L17;
        int[] r34 = b(r5, new int[][]{r6, r3});     // Catch: Exception -> L22
    L20:
        Intrinsics.checkNotNull(r33);     // Catch: Exception -> L22
        r4 = c(r33, r110, r34, j);     // Catch: Exception -> L22
        goto L25
    L17:
        if (r32 < 29) goto L19;
        r34 = b(r5, new int[][]{r6});     // Catch: Exception -> L22
        goto L20
    L19:
        r34 = r5;
    L24:
        r4 = null;
    L22:
        e = move-exception;
        int r35 = b.a;
        b.b("AudioDeviceHelper", "getInputDeviceType error: " + e.getMessage());
        goto L24
    L5:
        r1 = null;
        goto L6
    }

    public static int[] b(int[] r3, int[]... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int[] r2 = r4[r1];
        if (r2 == null) goto L7;
        r3 = ArraysKt.plus(r3, r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r3;
    }

    public static String c(AudioDeviceInfo[] r8, int[] r9, int[] r10, int[] r11) {
        int r0 = r8.length;
        int r1 = 0;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r1 >= r0) goto L14;
        int r5 = r8[r1].getType();
        if (ArraysKt.contains(r9, r5) == false) goto L8;
        r2 = true;
    L13:
        r1 = r1 + 1;
        goto L3
    L8:
        if (ArraysKt.contains(r10, r5) == false) goto L11;
        r3 = true;
        goto L13
    L11:
        if (ArraysKt.contains(r11, r5) == false) goto L13;
        r4 = true;
        goto L13
    L14:
        if (r2 == false) goto L16;
        return "wired";
    L16:
        if (r3 == false) goto L18;
        return "bluetooth";
    L18:
        if (r4 == false) goto L20;
        return "builtin";
    L20:
        return "other";
    }
}
