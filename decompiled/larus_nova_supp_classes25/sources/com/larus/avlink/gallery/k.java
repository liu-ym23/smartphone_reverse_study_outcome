package com.larus.avlink.gallery;

import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    static {
    }

    public static String a() {
        return AppHost.a.getApplication().getFilesDir().getAbsolutePath() + File.separator + "doraG/" + IApplog.a.getUserID() + '/';
    }
}
