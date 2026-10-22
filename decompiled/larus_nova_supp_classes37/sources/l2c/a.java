package l2c;

import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.component.protocol.Biz;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.InputStream;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements rkb.a<InputStream> {
    public final String a;
    public InputStream b;
    public volatile boolean c;

    public final void cancel() {
        this.c = true;
    }

    public final void cleanup() {
        InputStream r0 = this.b;
        if (r0 == null) goto L12;
        r0.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.d("ReactionResourceFetcher", th.toString());
        return;
    }

    public final Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public a(String r1) {
        this.a = r1;
    }

    public final void loadData(Priority r7, rkb.a.a<? super InputStream> r8) {
        Log.d("ReactionResourceFetcher", "load reaction：" + this.a);
        if (this.c == false) goto L15;
        r8.onLoadFailed(new Exception("request is canceled：" + this.a));
        return;
    L15:
        int r0 = wsb.a.a;     // Catch: Exception -> L12
        String r1 = ((e) ApiUtils.getApi(e.class)).getImageService().getReactionImage(LarkFileStorage.b().b(f.h, new d(j6c.a.a(Biz.IM), "/emoji/picture/rust/")).getAbsolutePath(), this.a);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == false) goto L10;
        Log.e("ReactionResourceFetcher", "load reaction failed, key is:" + this.a);     // Catch: Exception -> L12
        r8.onLoadFailed(new Exception("load reaction failed, key is:" + this.a));     // Catch: Exception -> L12
        return;
    L10:
        InputStream r9 = VFSFiles.b.k(r1);     // Catch: Exception -> L12
        this.b = r9;     // Catch: Exception -> L12
        r8.onDataReady(r9);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        r8.onLoadFailed(e);
        e.printStackTrace();
    }
}
