package com.bytedance.geckox.settings;

import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.geckox.OptionCheckUpdateParams;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IGeckoRegister {
    Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams();

    String registerRootDir(Context r5);
}
