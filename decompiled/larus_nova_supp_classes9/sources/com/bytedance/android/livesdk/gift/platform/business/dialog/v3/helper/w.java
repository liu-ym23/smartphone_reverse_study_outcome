package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/w;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "vmInitBarrier", "Z", "d", "()Z", "setVmInitBarrier", "(Z)V", "mutateBatchReduce", "b", "setMutateBatchReduce", "lazyLoadPageContent", "a", "setLazyLoadPageContent", "vmMemoryLeakFix", "e", "setVmMemoryLeakFix", BuildConfig.FLAVOR, "uiTaskPostType", "I", "c", "()I", "setUiTaskPostType", "(I)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("lazy_load_page_content")
    private boolean lazyLoadPageContent;

    @SerializedName("mutate_batch_reduce")
    private boolean mutateBatchReduce;

    @SerializedName("ui_task_post_type")
    private int uiTaskPostType;

    @SerializedName("vm_init_barrier")
    private boolean vmInitBarrier;

    @SerializedName("vm_memory_leak_fix")
    private boolean vmMemoryLeakFix;

    public w() {
    }

    public final boolean a() {
        return this.lazyLoadPageContent;
    }

    public final boolean b() {
        return this.mutateBatchReduce;
    }

    public final int c() {
        return this.uiTaskPostType;
    }

    public final boolean d() {
        return this.vmInitBarrier;
    }

    public final boolean e() {
        return this.vmMemoryLeakFix;
    }
}
