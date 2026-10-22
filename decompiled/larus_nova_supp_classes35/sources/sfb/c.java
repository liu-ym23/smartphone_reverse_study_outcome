package sfb;

import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final h b() {
        VFSFiles.b.getClass();
        return VFSFiles.b(true);
    }

    @JvmStatic
    public static final String a(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return BuildConfig.FLAVOR;
    L10:
        if (b().i(r1).exists() == false) goto L14;
        return r1;
    L14:
        return BuildConfig.FLAVOR;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @JvmStatic
    public static final boolean c(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L13:
        return false;
    L11:
        if (b().i(r3).exists() == false) goto L13;
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
