package com.larus.audio.audiov3.audio;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.record.AudioRecordType;
import com.larus.audio.record.factory.IAudioRecorderFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p58.d;
import p58.e;
import r58.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/audio/audiov3/audio/AudioRecorderFactory;", "Lcom/larus/audio/record/factory/IAudioRecorderFactory;", "<init>", "()V", "create", "Lcom/larus/audio/audiov3/audio/record/IAudioRecorder;", "type", "Lcom/larus/audio/record/AudioRecordType;", "params", "", "", "", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioRecorderFactory implements IAudioRecorderFactory {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioRecordType.values().length];
            r0[AudioRecordType.AudioRecord.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AudioRecordType.BackTraceRecord.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public AudioRecorderFactory() {
    }

    @Override // com.larus.audio.record.factory.IAudioRecorderFactory
    public final c a(AudioRecordType r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "params");
        int r8 = a.a[r6.ordinal()];
        int r2 = -1;
        Integer r3 = null;
        if (r8 != 1) goto L5;
        Object r9 = r7.get("bufferSize");
        if ((r9 instanceof Integer) == false) goto L28;
        r3 = (Integer) r9;
    L28:
        if (r3 == null) goto L30;
        r2 = r3.intValue();
    L30:
        c r10 = new d(r2);
    L31:
        return r10;
    L5:
        if (r8 != 2) goto L24;
        Object r0 = r7.get("context");
        if ((r0 instanceof Context) == false) goto L9;
        Context r1 = (Context) r0;
    L10:
        Object r4 = r7.get("bufferSize");
        if ((r4 instanceof Integer) == false) goto L13;
        Integer r5 = (Integer) r4;
    L14:
        if (r5 == null) goto L16;
        int r11 = r5.intValue();
    L17:
        Object r12 = r7.get("sessionId");
        if ((r12 instanceof Integer) == false) goto L20;
        r3 = (Integer) r12;
    L20:
        if (r3 == null) goto L22;
        r2 = r3.intValue();
    L22:
        r10 = new e(r1, r11, r2);
        goto L31
    L16:
        r11 = -1;
        goto L17
    L13:
        r5 = null;
        goto L14
    L9:
        r1 = null;
        goto L10
    L24:
        throw new NoWhenBranchMatchedException();
    }
}
