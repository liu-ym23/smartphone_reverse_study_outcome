package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.middleware.api.settings.IOcrSetting;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0000H\u0016R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000b8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/OcrSettings;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/obric/memorydata/middleware/api/settings/IOcrSetting;", "<init>", "()V", "create", "useCloud", "", "getUseCloud", "()Z", "resizeMaxWidth", "", "getResizeMaxWidth", "()I", "resizeMaxHeight", "getResizeMaxHeight", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f implements IOcrSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("useCloud")
    private final boolean f11860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("resizeMaxWidth")
    private final int f11861b;

    @SerializedName("resizeMaxHeight")
    private final int c;

    public f() {
        this.f11861b = 1280;
        this.c = 1280;
    }

    public f a() {
        return new f();
    }

    @Override // com.obric.memorydata.middleware.api.settings.IOcrSetting
    public int getResizeMaxHeight() {
        return this.c;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IOcrSetting
    public int getResizeMaxWidth() {
        return this.f11861b;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IOcrSetting
    public boolean getUseCloud() {
        return this.f11860a;
    }
}
