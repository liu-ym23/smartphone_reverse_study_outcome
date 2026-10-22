package com.larus.chat.gallery.impl.preview.input;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.platform.model.action.SuggestedAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface e0 {

    public static final class a {
        public static boolean a(e0 r1, SuggestedAction r2, xy8.d r3) {
            Intrinsics.checkNotNullParameter(r2, "action");
            Intrinsics.checkNotNullParameter(r3, "data");
            String r4 = r2.getDisplayName();
            if (r4 != null) goto L6;
            r4 = "";
        L6:
            return r1.e(r4, r3, null);
        }
    }

    void a(com.larus.chat.gallery.impl.preview.provider.a0 r1);

    boolean b(SuggestedAction r1, xy8.d r2, String r3);

    void c(boolean r1);

    boolean d();

    boolean e(String r1, xy8.d r2, zy8.s r3);

    boolean f(String r1, CameraOutputContext r2, Map<String, String> r3);

    boolean g(SuggestedAction r1, CameraOutputContext r2, Map<String, String> r3);

    boolean h(String r1, xy8.d r2);

    SuggestedAction i();
}
