package i8a;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.RemoteException;
import android.view.View;
import com.lynx.tasm.service.IServiceProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface h extends IServiceProvider {
    void a(ClipData r1) throws RemoteException;

    void b();

    Bitmap c(View r1, Bitmap.Config r2);

    void d();

    String extractMetadata(MediaMetadataRetriever r1, int r2);

    String getLocale();

    void openCamera() throws RuntimeException;

    void releaseCamera();
}
