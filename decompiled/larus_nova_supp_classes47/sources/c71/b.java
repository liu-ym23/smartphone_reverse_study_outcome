package c71;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b<State, Event> {
    ICardLifecycle$State m();

    void n(State r1);

    Observable<State> v();
}
