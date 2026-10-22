package jn0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b extends cn0.a, dn0.b {
    DataContext Jn(DataContext r1);

    cg6.a Pl();

    BehaviorSubject<List<ILinkPlayerInfoBridge>> Xh();

    String Ya();

    BehaviorSubject<Integer> b5();

    BehaviorSubject<Boolean> dk();

    tc0.b getLinkInRoomDataHolderKt();

    dn0.c getLinkSecurityService();

    jb6.a getLinkServiceScopeService();
}
