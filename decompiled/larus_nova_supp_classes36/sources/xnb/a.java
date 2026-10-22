package xnb;

import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.LoadParams;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T, R> implements Function {
    public static final a<T, R> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r5) {
        Image r6 = (Image) r5;
        Intrinsics.checkNotNullParameter(r6, LoadParams.ImageFormat.IMAGE);
        return new com.ss.android.lark.keyboard.dtocompat.Image(r6.getUrls(), r6.getWidth(), r6.getHeight(), r6.getToken());
    }
}
