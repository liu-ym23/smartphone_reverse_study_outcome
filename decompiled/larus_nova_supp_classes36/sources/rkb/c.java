package rkb;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.Key;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.impl.RequestCreator;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c {
    void clear(View r1);

    void clearMemoryCache(Context r1);

    File downloadOnly(int r1, int r2, RequestCreator r3);

    <R> void downloadOnly(Target<R> r1, RequestCreator r2);

    Bitmap getBitmap(int r1, int r2, RequestCreator r3);

    String getCacheFile(int r1, int r2, RequestCreator r3);

    void into(ImageView r1, RequestCreator r2);

    <R> void into(Target<R> r1, RequestCreator r2);

    void pauseRequests(RequestCreator r1);

    <T extends Key, Y> void registerLoadModelHook(Context r1, Class<T> r2, Class<Y> r3, e<T, Y> r4);

    void resumeRequests(RequestCreator r1);
}
