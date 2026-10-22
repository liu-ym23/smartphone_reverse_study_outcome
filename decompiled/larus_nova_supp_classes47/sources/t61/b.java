package t61;

import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimType;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {
    void a(CardAnimType r1);

    Observable<CardAnimState> f();

    void h(CardAnimType r1);
}
