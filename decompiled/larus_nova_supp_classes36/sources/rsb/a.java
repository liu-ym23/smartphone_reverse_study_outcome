package rsb;

import android.graphics.Bitmap;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {

    /* JADX INFO: renamed from: rsb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0324a {
        void k0(int r1, List<String> r2);
    }

    @Deprecated(message = "replace with [getReactionOrEmojiBitmap]")
    Bitmap Hb(String r1, boolean r2);

    @Deprecated(message = "replace with [getReactionOrEmojiText]")
    String K9(String r1, boolean r2);

    ConcurrentHashMap<String, qsb.a> Q1();

    int U9();

    void V8(Set<? extends qsb.a> r1, int r2);

    qsb.a Yd(String r1);

    qsb.a b0(String r1);

    void c9(InterfaceC0324a r1);

    String df(String r1);

    void f3();

    void ge(String r1, boolean r2, IGetDataCallback<Boolean> r3, IGetDataCallback<Boolean> r4);

    ConcurrentHashMap<String, String> h2();

    boolean i7(String r1);

    /* JADX INFO: renamed from: if */
    boolean mo1505if(String r1);

    boolean l4(String r1);

    @Deprecated(message = "replace with [requestBitmap(String)]")
    void sb(String r1);

    String ub(String r1);

    Bitmap v1(String r1);
}
