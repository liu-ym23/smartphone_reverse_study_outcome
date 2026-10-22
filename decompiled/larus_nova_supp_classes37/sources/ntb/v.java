package ntb;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.di.core.deps.StorageVolume;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface v extends com.ss.android.lark.officesdk.di.core.b {
    PolarisFileWrapper A(Context r1, Uri r2, boolean r3);

    void b(String r1);

    boolean e();

    String getString();

    VFSFile i(String r1);

    InputStream k(String r1);

    File l0(StorageVolume r1, String... r2);
}
