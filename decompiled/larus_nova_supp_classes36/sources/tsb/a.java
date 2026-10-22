package tsb;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements rkb.a<InputStream> {
    public final String a;
    public InputStream b;
    public volatile boolean c;

    @Override // rkb.a
    public final void cancel() {
        this.c = true;
    }

    @Override // rkb.a
    public final void cleanup() {
        InputStream r0 = this.b;
        if (r0 == null) goto L12;
        r0.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.d("EmojiResourceDataFetcher", th.toString());
        return;
    }

    @Override // rkb.a
    public final Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // rkb.a
    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public a(String r1) {
        this.a = r1;
    }

    @Override // rkb.a
    public final void loadData(Priority r7, rkb.a.InterfaceC0322a<? super InputStream> r8) {
        Log.d("EmojiResourceDataFetcher", "load emoji image：" + this.a);
        if (this.c == false) goto L15;
        r8.onLoadFailed(new Exception("request is canceled：" + this.a));
        return;
    L15:
        int r0 = wsb.a.a;     // Catch: Exception -> L12
        String r1 = ((e) ApiUtils.getApi(e.class)).getImageService().getEmojiImage(LarkFileStorage.b().b(f.h, new d(j6c.a.a(Biz.IM), "/emoji/picture/rust/")).getAbsolutePath(), this.a);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == false) goto L10;
        Log.e("EmojiResourceDataFetcher", "load emoji image failed, key is:" + this.a);     // Catch: Exception -> L12
        r8.onLoadFailed(new Exception("load emoji image failed, key is:" + this.a));     // Catch: Exception -> L12
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
