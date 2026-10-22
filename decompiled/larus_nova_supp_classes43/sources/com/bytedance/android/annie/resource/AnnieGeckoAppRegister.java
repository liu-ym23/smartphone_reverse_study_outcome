package com.bytedance.android.annie.resource;

import android.content.Context;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@GeckoRegister(boeAccessKey = "92549089bbfda222da88c565422ff344", prodAccessKey = "6e5ea4687a1ae236f7677bed242a0bdd", testAccessKey = "5436709938b15832912cf5322009c03d")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/resource/AnnieGeckoAppRegister;", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "()V", "registerCustomParams", "", "", "Lcom/bytedance/geckox/OptionCheckUpdateParams$CustomValue;", "registerRootDir", "context", "Landroid/content/Context;", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AnnieGeckoAppRegister implements IGeckoRegister {
    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        int r0 = f.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("business_version", e.a);
        return r1;
    }

    public AnnieGeckoAppRegister() {
    }

    public String registerRootDir(Context r10) {
        int r11 = f.a;
        return com.bytedance.geckox.b.a.a.getContext().getFilesDir().getAbsolutePath() + File.separator + "offlineX";
    }
}
