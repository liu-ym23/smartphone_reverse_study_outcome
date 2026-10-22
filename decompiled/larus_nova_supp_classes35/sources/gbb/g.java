package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface g {

    public interface a {
        boolean write(File r1);
    }

    PolarisFileWrapper a(String r1) throws IOException, DecryptException;

    File b();

    File c(String r1) throws IOException;

    void d(String r1, a r2) throws IOException;

    void delete() throws IOException;

    void remove(String r1) throws IOException;
}
