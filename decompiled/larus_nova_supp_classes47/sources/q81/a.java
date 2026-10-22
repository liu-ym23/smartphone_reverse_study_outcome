package q81;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {

    /* JADX INFO: renamed from: q81.a$a, reason: collision with other inner class name */
    public static final class C0300a {
        public final MutableLiveData<Boolean> a;
        public final MutableLiveData<String> b;

        public C0300a() {
            this.a = new MutableLiveData();
            this.b = new MutableLiveData();
        }
    }

    void a();

    void b(ILivePlayerClient r1);

    void c(ILivePlayerClient r1, gs0.c r2, View r3, View r4);

    void d(RoomSession r1, AbsLivePlayerView r2);

    void e();

    void f();

    void g(boolean r1);

    C0300a getEventHub();

    void reset();
}
