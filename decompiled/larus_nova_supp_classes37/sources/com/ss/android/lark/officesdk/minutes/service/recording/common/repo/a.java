package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    void g(String r1);

    MmRecordingSpeakerRepo h();

    MmRecordingQuotaCtaRepo i();

    Object j(b r1, Continuation<? super Unit> r2);

    String k();

    MmRecordingLanguageRepo l();

    void m(String r1);

    com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a n();

    String o();
}
