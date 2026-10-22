package w4b;

import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.ss.android.lark.core.keyboard.KeyboardBaseModuleDependencyImpl;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface f {
    Object a(List<PreviewHangPoint> r1, Continuation<? super Map<String, UrlCardPreviewEntity>> r2);

    void b();

    xcb.a c(Map<String, wxa.e> r1);

    void d(String r1, long r2, long r4, KeyboardBaseModuleDependencyImpl.C04431 r6);
}
