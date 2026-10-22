package com.obric.livecard.api.island;

import android.content.Context;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.exception.IslandUnsupportedException;
import com.obric.livecard.api.impl.OnTopCardChangedListener;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0010H'J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0012H&J!\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/obric/livecard/api/island/IslandApi;", "", "addOnTopCardChangedListener", "", "callback", "Lcom/obric/livecard/api/impl/OnTopCardChangedListener;", "collapseIsland", "collapseNotificationPanel", "createSession", "", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "context", "Landroid/content/Context;", "destroySession", "getIslandVersion", "", "getPriority", "", "(Lcom/obric/livecard/api/entity/IslandSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshScene", "removeOnTopCardChangedListener", "sendEvent", "targetSession", "targetWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", "eventId", "", "jsonString", "setPriority", "priority", "tryExpand", "canFrontShow", "(Lcom/obric/livecard/api/entity/IslandSession;Ljava/lang/Boolean;)V", "updateAnimation", "(Lcom/obric/livecard/api/entity/IslandSession;Lcom/obric/livecard/api/entity/IslandWidget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAudioAmplitude", "amplitudes", "", "updateSessionFlags", "updateWidget", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IslandApi {
    void addOnTopCardChangedListener(OnTopCardChangedListener r1) throws IslandUnsupportedException;

    void collapseIsland();

    void collapseNotificationPanel() throws IslandUnsupportedException;

    boolean createSession(IslandSession r1, Context r2);

    void destroySession(IslandSession r1);

    @Deprecated(message = "请使用最新的方法: getVersion()", replaceWith = @ReplaceWith(expression = "ILiveCard.inst.getVersion()", imports = {}))
    int getIslandVersion();

    Object getPriority(IslandSession r1, Continuation<? super Long> r2) throws IslandUnsupportedException;

    void refreshScene(IslandSession r1) throws IslandUnsupportedException;

    void removeOnTopCardChangedListener(OnTopCardChangedListener r1) throws IslandUnsupportedException;

    void sendEvent(IslandSession r1, IslandWidget r2, String r3, String r4);

    void setPriority(IslandSession r1, long r2) throws IllegalArgumentException, IslandUnsupportedException;

    void tryExpand(IslandSession r1, Boolean r2);

    Object updateAnimation(IslandSession r1, IslandWidget r2, Continuation<? super Unit> r3);

    void updateAudioAmplitude(IslandSession r1, float r2) throws IslandUnsupportedException;

    void updateSessionFlags(IslandSession r1);

    void updateWidget(IslandSession r1, IslandWidget r2);
}
