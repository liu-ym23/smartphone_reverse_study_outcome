package com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model;

import com.bytedance.android.livesdk.sharedpref.e;
import d52.c;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class BaseStyleSettingModel<T extends c> {
    public final Lazy a;

    public abstract T a();

    public abstract String c();

    public abstract T d(int r1);

    public T b() {
        return (T) d(((Number) ((e) this.a.getValue()).getValue()).intValue());
    }

    public BaseStyleSettingModel() {
        this.a = LazyKt.lazy(new BaseStyleSettingModel$pluginProperty$2(this));
    }
}
