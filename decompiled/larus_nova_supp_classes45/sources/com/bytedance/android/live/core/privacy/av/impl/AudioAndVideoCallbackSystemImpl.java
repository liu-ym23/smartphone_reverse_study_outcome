package com.bytedance.android.live.core.privacy.av.impl;

import android.os.Handler;
import android.util.Log;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.privacy.av.api.AudioAndVideoException;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AudioAndVideoCallbackSystemImpl implements com.bytedance.android.live.core.privacy.av.api.b {
    public boolean b;
    public final Lazy c;
    public final PrivacyConfig d;
    public final com.bytedance.android.live.core.privacy.av.api.h e;

    public static final class a {
    }

    static {
    }

    public AudioAndVideoCallbackSystemImpl(PrivacyConfig r2, com.bytedance.android.live.core.privacy.av.api.h r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "logger");
        this.d = r2;
        this.e = r3;
        this.c = LazyKt.lazy(AudioAndVideoCallbackSystemImpl$mainHandler$2.INSTANCE);
    }

    public static void e(String r3, String r4, String r5, String r6, Map r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L17
        r1.put("status", r3);     // Catch: Throwable -> L17
        r1.put("biz", r4);     // Catch: Throwable -> L17
        r1.put("sense", r5);     // Catch: Throwable -> L17
        r1.put("type", r6);     // Catch: Throwable -> L17
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L17
        Iterator r9 = r7.entrySet().iterator();     // Catch: Throwable -> L17
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r9.next();     // Catch: Throwable -> L17
        r8.put((String) r2.getKey(), r2.getValue());     // Catch: Throwable -> L17
        goto L4
    L6:
        LiveTracingMonitor.i("ttlive_audio_and_video_check_all", r1, null, r8);     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r3, "error") == true) goto L9;
    L15:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L9:
        if (Intrinsics.areEqual(r4, "common") == false) goto L14;
        Iterator r11 = r7.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r11.hasNext() == false) goto L14;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L17
        r1.put((String) r12.getKey(), r12.getValue());     // Catch: Throwable -> L17
    L14:
        LiveTracingMonitor.i("ttlive_audio_and_video_check_failed", r1, null, r8);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void b(String r11, String r12, String r13, Map<String, String> r14, com.bytedance.android.live.core.privacy.av.api.a r15) {
        Intrinsics.checkNotNullParameter(r11, "biz");
        Intrinsics.checkNotNullParameter(r12, "sense");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r15, "ensureConfig");
        this.e.a("onStart# seq=" + r15.a + ", biz=" + r11 + ", sense=" + r12 + ", type=" + r13);
        if (this.d.h() == false) goto L10;
        List<String> r16 = this.d.d();
        if (r16 != null) goto L7;
        return;
    L7:
        if (r16.contains("trigger_detection") != true) goto L12;
        this.e.c(new com.bytedance.android.live.core.privacy.av.api.i("trigger_detection", NewBroadcastMonitor.STAGE.START, 0, r13.concat("-start"), r11, r12, r13, r14));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void c(String r11, String r12, String r13, Map<String, String> r14, com.bytedance.android.live.core.privacy.av.api.a r15) {
        Intrinsics.checkNotNullParameter(r11, "biz");
        Intrinsics.checkNotNullParameter(r12, "sense");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r15, "ensureConfig");
        this.e.a("onCancel# seq=" + r15.a + ", biz=" + r11 + ", sense=" + r12 + ", type=" + r13);
        e("cancel", r11, r12, r13, r14);
        if (this.d.h() == false) goto L10;
        List<String> r16 = this.d.d();
        if (r16 != null) goto L7;
        return;
    L7:
        if (r16.contains("trigger_detection") != true) goto L12;
        this.e.c(new com.bytedance.android.live.core.privacy.av.api.i("trigger_detection", "cancel", -1, r13.concat("-cancel"), r11, r12, r13, r14));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void d(String r11, String r12, String r13, Map<String, String> r14, com.bytedance.android.live.core.privacy.av.api.a r15) {
        Intrinsics.checkNotNullParameter(r11, "biz");
        Intrinsics.checkNotNullParameter(r12, "sense");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r15, "ensureConfig");
        this.e.a("trackSuccess# seq=" + r15.a + ", biz=" + r11 + ", sense=" + r12 + ", type=" + r13);
        e("success", r11, r12, r13, r14);
        if (this.d.h() == false) goto L10;
        List<String> r16 = this.d.d();
        if (r16 != null) goto L7;
        return;
    L7:
        if (r16.contains("trigger_detection") != true) goto L12;
        this.e.c(new com.bytedance.android.live.core.privacy.av.api.i("trigger_detection", "success", 0, r13.concat("-success"), r11, r12, r13, r14));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void a(String r16, String r17, String r18, Map r19, com.bytedance.android.live.core.privacy.av.api.a r21, AudioAndVideoException r22) {
        Intrinsics.checkNotNullParameter(r16, "biz");
        Intrinsics.checkNotNullParameter(r17, "sense");
        Intrinsics.checkNotNullParameter(r18, "type");
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r21, "ensureConfig");
        Intrinsics.checkNotNullParameter(r22, "exception");
        this.e.b("trackError# seq=" + r21.a + ", biz=" + r16 + ", sense=" + r17 + ", type=" + r18 + ", e=" + r22, null);
        e("error", r16, r17, r18, r19);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L39
        if (this.d.g() == false) goto L33;
        if (Intrinsics.areEqual(r16, "common") == true) goto L9;
        com.bytedance.crash.d.e(r22, r16 + '-' + r17 + '-' + r18 + " check failed", r19);     // Catch: Throwable -> L39
        goto L33
    L9:
        if (r19.isEmpty() == true) goto L29;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L39
        Iterator r11 = r19.entrySet().iterator();     // Catch: Throwable -> L39
    L12:
        if (r11.hasNext() == false) goto L28;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L39
        CharSequence r13 = (CharSequence) r12.getKey();     // Catch: Throwable -> L39
        boolean r14 = false;
        if (r13 != null) goto L16;
    L19:
        boolean r15 = true;
    L20:
        if (r15 == true) goto L12;
        CharSequence r110 = (CharSequence) r12.getValue();     // Catch: Throwable -> L39
        if (r110 != null) goto L24;
    L25:
        r14 = true;
    L26:
        if (r14 == true) goto L12;
        r1.append("-");     // Catch: Throwable -> L39
        r1.append((String) r12.getKey());     // Catch: Throwable -> L39
        r1.append(":");     // Catch: Throwable -> L39
        r1.append((String) r12.getValue());     // Catch: Throwable -> L39
        goto L12
    L24:
        if (StringsKt.isBlank(r110) == false) goto L26;
    L16:
        if (StringsKt.isBlank(r13) == true) goto L19;
        r15 = false;
        goto L20
    L28:
        String r2 = r1.toString();     // Catch: Throwable -> L39
    L30:
        com.bytedance.crash.d.e(r22, r16 + '-' + r17 + '-' + r18 + r2 + " check failed", r19);     // Catch: Throwable -> L39
        goto L33
    L29:
        r2 = "";
    L33:
        if (this.d.f() == true) goto L35;
    L37:
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L45;
        this.e.b("upload monitor failed:" + r4.getMessage(), null);
    L45:
        if (this.d.h() == false) goto L61;
        List<String> r5 = this.d.d();
        if (r5 != null) goto L49;
        return;
    L49:
        if (r5.contains("trigger_detection") != true) goto L63;
        this.e.c(new com.bytedance.android.live.core.privacy.av.api.i("trigger_detection", "error", 1, r18 + "-error-" + Log.getStackTraceString(r22), r16, r17, r18, r19));
        return;
    L63:
        return;
    L61:
        return;
    L35:
        if (this.b == true) goto L37;
        ((Handler) this.c.getValue()).postDelayed(new com.bytedance.android.live.core.privacy.av.impl.a(this, r16, r19, r17), this.d.b());     // Catch: Throwable -> L39
        this.b = true;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    }
}
