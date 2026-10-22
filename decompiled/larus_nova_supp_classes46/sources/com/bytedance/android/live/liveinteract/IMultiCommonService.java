package com.bytedance.android.live.liveinteract;

import com.bytedance.android.live.base.IService;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/IMultiCommonService;", "Lcom/bytedance/android/live/base/IService;", "checkCommonSetting", "", "scenes", "", "", "useGalileoData", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMultiCommonService extends IService {
    boolean checkCommonSetting(Set<Integer> r1);

    boolean useGalileoData();
}
