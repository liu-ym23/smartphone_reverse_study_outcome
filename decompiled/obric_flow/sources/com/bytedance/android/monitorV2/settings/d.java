package com.bytedance.android.monitorV2.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/d;", "", "<init>", "()V", "", "a", "Z", "d", "()Z", "setEnableVirtualAid", "(Z)V", "enableVirtualAid", "b", "setEnableHandlePerfMix", "enableHandlePerfMix", "c", "setEnableKernelBlankLog", "enableKernelBlankLog", "setEnableLynxNavigationFix", "enableLynxNavigationFix", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("is_enable_virtual_aid")
    private boolean f3723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("is_enable_handle_perfmix")
    private boolean f3724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("is_enable_kernel_blank_log")
    private boolean f3725c;

    @SerializedName("is_enable_lynx_navigation_fix")
    private boolean d;

    public d() {
        this.f3723a = true;
        this.f3724b = true;
        this.f3725c = true;
        this.d = true;
    }

    public final boolean a() {
        return this.f3724b;
    }

    public final boolean b() {
        return this.f3725c;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.f3723a;
    }
}
