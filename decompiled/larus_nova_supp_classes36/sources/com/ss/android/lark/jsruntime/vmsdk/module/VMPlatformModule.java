package com.ss.android.lark.jsruntime.vmsdk.module;

import android.content.Context;
import android.os.Build;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/jsruntime/vmsdk/module/VMPlatformModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "platformInfo", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableMap;", "getAPIVersion", "", "Companion", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VMPlatformModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "VMPlatform";
    private static final String TAG = "VMSDK_VMPlatformModule";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final String getAPIVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @JSMethod
    public final WritableMap platformInfo() {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("systemName", "android");
        r0.put("osVersion", getAPIVersion());
        rnb.c.c(TAG, "platformInfo: " + CollectionsKt.joinToString$default(r0.entrySet(), " / ", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null));
        return r0;
    }

    public VMPlatformModule(Context r1) {
        super(r1);
    }
}
