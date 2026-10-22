package com.bytedance.android.ec.core.apt;

import com.bytedance.android.ec.core.event.a;
import kotlin.Deprecated;
import kotlin.Metadata;
import lg.c;
import lg.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J$\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/core/apt/IECAPTService;", "", "Llg/c;", "node", "", "record", "Llg/i;", "plugin", "registerPlugin", "", a.KEY_LUBAN_TAG, "oldValue", "newValue", "diff", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECAPTService {
    void diff(String r1, String r10, String r11);

    @Deprecated(message = "use tracker")
    void record(c r1);

    void registerPlugin(i r1);
}
