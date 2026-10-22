package nq9;

import com.larus.bmhome.chat.trace.j;
import com.larus.im.bean.message.Message;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface f {
    OldUgcGenImgPerfMonitor a(boolean r1);

    void b();

    void c(String r1, String r2, int r3);

    void d(j r1);

    void e(String r1, ISDKPointCallback.EndMsg r2);

    void f(String r1, String r2);

    void g(String r1, String r2, String r3, int r4, String r5, String r6, List<Message> r7, long r8);

    void o4(Message r1);
}
