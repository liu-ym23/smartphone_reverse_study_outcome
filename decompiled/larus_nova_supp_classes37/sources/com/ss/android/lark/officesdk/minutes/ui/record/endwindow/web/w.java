package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.graphics.Bitmap;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface w {
    com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a a();

    void b(String r1, JSONObject r2);

    Object c(String r1, String r2, int r3, Continuation<? super Bitmap> r4);

    String d();

    void e(String r1);

    void f(int r1);

    void g();

    com.ss.android.lark.officesdk.minutes.service.foundation.feature.a getFeatureService();

    com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b getSettingsService();

    void h(MmEndWindowChangeSpeakerOrigin r1, xwb.d r2);

    com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c i();

    boolean isDarkMode();

    void j(String r1);

    String k();

    void l();

    Object m(String r1, int r2, Continuation<? super Bitmap> r3);

    void n();

    Object o(String r1, Continuation<? super Result<String>> r2);
}
