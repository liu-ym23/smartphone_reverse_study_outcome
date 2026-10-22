package com.bytedance.ies.argus.repository;

import ai.j0;
import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.settings.IGeckoRegister;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusSdkGeckoAppRegister;", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "<init>", "()V", "", "", "Lcom/bytedance/geckox/OptionCheckUpdateParams$CustomValue;", "registerCustomParams", "()Ljava/util/Map;", "Landroid/content/Context;", "context", "registerRootDir", "(Landroid/content/Context;)Ljava/lang/String;", "Companion", "com/bytedance/ies/argus/repository/b", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@ka.a(boeAccessKey = "afe58e0f6709cd80a6524f309678f67d", prodAccessKey = "d8feacce0eae150c8140e5c435ccbbda", testAccessKey = "e1927d8fdbbf6786914e8ca27307104b")
public final class ArgusSdkGeckoAppRegister implements IGeckoRegister {
    public static final String BOE_ACCESS_KEY = "afe58e0f6709cd80a6524f309678f67d";
    public static final b Companion = null;
    public static final String DIR_NAME = "offlineX";
    public static final String ONLINE_ACCESS_KEY = "d8feacce0eae150c8140e5c435ccbbda";
    public static final String TEST_ACCESS_KEY = "e1927d8fdbbf6786914e8ca27307104b";

    static {
        Companion = new b();
    }

    public ArgusSdkGeckoAppRegister() {
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public String registerRootDir(Context r5) {
        StringBuilder r10 = new StringBuilder();
        r10.append(df.c.c().getFilesDir().getAbsolutePath());
        return j0.q(r10, File.separator, "offlineX");
    }
}
