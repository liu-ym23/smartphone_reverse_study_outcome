package com.bytedance.geckox.utils;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.tasm.p;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/geckox/utils/BsPatch;", "", "", OpenPageMethod.APP_FULL, "dest", "patch", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class BsPatch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BsPatch f4780a = null;

    static {
        f4780a = new BsPatch();
        d.h("geckox_bspatch");
    }

    private final native int patch(String r5, String r10, String r11);

    public final void a(File r5, File r10, File r11, String r12) {
        if (r5.exists() == false) goto L25;
        if (r10.exists() == false) goto L23;
        if (r11.exists() == false) goto L14;
        if (r11.isFile() == true) goto L12;
    L15:
        File r13 = new File(r11, r12);
        r13.delete();
        int r14 = patch(r5.getAbsolutePath(), r13.getAbsolutePath(), r10.getAbsolutePath());
        if (r14 != 0) goto L18;
        return;
    L18:
        StringBuilder r15 = p.d(r14, "patch failed: ", ", ");
        r15.append(r5.getAbsolutePath());
        r15.append(", ");
        r15.append(r10.getAbsolutePath());
        r15.append(", ");
        r15.append(r13.getAbsolutePath());
        throw new RuntimeException(r15.toString());
    L12:
        throw new RuntimeException("create dir failed: path is a file");
    L14:
        if (r11.mkdirs() == true) goto L15;
        throw new RuntimeException("create dir failed: " + r11.getPath());
    L23:
        throw new FileNotFoundException("patch package not exist：" + r10.getAbsolutePath());
    L25:
        throw new FileNotFoundException("full package not exist：" + r5.getAbsolutePath());
    }
}
