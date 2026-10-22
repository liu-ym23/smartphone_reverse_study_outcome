package pa;

import android.text.TextUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.utils.d;
import df.c;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet f21323a = null;

    static {
        f21323a = new CopyOnWriteArraySet();
    }

    public static void a(a r10, String r11, String r12, long r13) {
        if (r10 == null) goto L30;
        File r5 = new File((String) c.d.get(r11));
        String r14 = null;
        if (TextUtils.isEmpty(r11) == false) goto L6;
    L26:
        LocalPackageModel r15 = new LocalPackageModel(r11, r12);
        r15.setLatestVersion(r13);
        r15.setChannelPath(r14);
        r10.b(r15);
        return;
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L26;
        if (r13 == 0) goto L26;
        if (r5.exists() == false) goto L26;
        if (r5.isDirectory() == false) goto L26;
        String r16 = d.b(r12);
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L24
        String r18 = File.separator;     // Catch: Throwable -> L24
        r17.append(r18);     // Catch: Throwable -> L24
        r17.append(r11);     // Catch: Throwable -> L24
        File r19 = new File(r5, r17.toString());     // Catch: Throwable -> L24
        if (r19.exists() == false) goto L26;
        String r20 = r19.getAbsolutePath();     // Catch: Throwable -> L24
        if (new File(r20, r16).exists() == false) goto L26;
        r14 = r20 + r18 + r16 + r18 + r13 + r18 + "res";     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        GeckoLogger.a("getChannelPath:error:", th);
        goto L26
    }
}
