package com.bytedance.crash;

import android.app.ApplicationExitInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IExitReasonListCallback {
    void findExitReasons(List<ApplicationExitInfo> r1);
}
