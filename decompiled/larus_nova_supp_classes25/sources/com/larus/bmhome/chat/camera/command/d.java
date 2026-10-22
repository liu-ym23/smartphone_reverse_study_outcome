package com.larus.bmhome.chat.camera.command;

import android.content.Intent;
import android.net.Uri;
import com.larus.platform.model.action.SuggestedAction;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface d {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        a = a.a;
    }

    void b(SuggestedAction r1);

    Intent c(String r1, Uri r2);

    void d(boolean r1, List<?> r2);

    Intent e(Uri r1);
}
