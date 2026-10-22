package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<d> {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a$a, reason: collision with other inner class name */
    public static final class C0039a {
        public static /* synthetic */ Object a(a r7, String r8, boolean r9, g r10, Continuation r11) {
            return r7.z(r8, "", r9, r10, true, r11);
        }
    }

    void F0(HeadsetPromptSource r1);

    Object I(g r1, Continuation<? super Unit> r2);

    void M0(HeadsetPromptSource r1);

    void S0();

    void U();

    void W(MmAudioSaveType r1);

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
    i1<d> b();

    void g(String r1);

    void g0();

    void i(byte[] r1);

    @Override // fvb.a
    void onDestroy();

    Object r0(String r1, String r2, Continuation<? super Unit> r3);

    Object w(String r1, String r2, g r3, g r4, Continuation<? super Unit> r5);

    Object z(String r1, String r2, boolean r3, g r4, boolean r5, Continuation<? super p> r6);
}
