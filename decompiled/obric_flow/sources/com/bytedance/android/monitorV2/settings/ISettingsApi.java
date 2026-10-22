package com.bytedance.android.monitorV2.settings;

import androidx.annotation.Keep;
import ci.g0;
import ci.l;
import ci.t;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JE\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/ISettingsApi;", "", "", "url", "", "Lbi/c;", "header", "", "fieldMap", "Lai/c;", "doPost", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lai/c;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ISettingsApi {
    @ci.g
    @t
    ai.c doPost(@g0 String r5, @l List<bi.c> r10, @ci.f Map<String, String> r11);
}
