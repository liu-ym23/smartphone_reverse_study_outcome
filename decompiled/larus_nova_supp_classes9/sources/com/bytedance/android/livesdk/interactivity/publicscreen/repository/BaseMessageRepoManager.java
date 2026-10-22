package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vlc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\r\b&\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0004J \u0010\u0013\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0016\u0010\u001b\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0014J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0004J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0004J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R \u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u00118\u0004X\u0084\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/BaseMessageRepoManager;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/IPSMessageRepoManager;", "Lvlc/h;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/IPSMessageRepoManager$Listener;", "listener", BuildConfig.FLAVOR, "bind", "unbind", "Ltlc/d;", "messages", BuildConfig.FLAVOR, "canReceiveServerMessage", "message", "canReceiveMessage", "iMessage", "canReceiveServerMessageWithSetting", BuildConfig.FLAVOR, "historyFlag", "onFirstMessage", BuildConfig.FLAVOR, "msgMethod", "dynamicAddMessageType", "Lcom/bytedance/android/live/base/model/message/t;", "msg", "insertLocalMessage", BuildConfig.FLAVOR, "insertBackendTopMessage", "onCleared", "notifyMessage", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/IPSMessageRepoManager$Listener$Event;", "event", "notifyEvent", "onInsertLocalMessage", "onDynamicAddMessageType", "isCleared", "Z", BuildConfig.FLAVOR, "listeners", "Ljava/util/Set;", "getListeners", "()Ljava/util/Set;", "dynamicMessageTypes", "Ljava/util/List;", "getDynamicMessageTypes", "()Ljava/util/List;", "<init>", "()V", "Companion", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseMessageRepoManager extends ViewModel implements IPSMessageRepoManager, h {
    public static final a Companion = null;
    private static final String TAG = "BaseMessageRepoManager";
    private final List<String> dynamicMessageTypes;
    private boolean isCleared;
    private final Set<IPSMessageRepoManager.Listener> listeners;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public boolean canReceiveMessage(d r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return true;
    }

    public boolean canReceiveServerMessage(d r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager
    public boolean insertBackendTopMessage(List<? extends d> r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        return true;
    }

    public void onDynamicAddMessageType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgMethod");
    }

    public void onInsertLocalMessage(t r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public void onCleared() {
        this.listeners.clear();
        this.dynamicMessageTypes.clear();
        this.isCleared = true;
    }

    public BaseMessageRepoManager() {
        this.listeners = new LinkedHashSet();
        this.dynamicMessageTypes = new ArrayList();
    }

    public final List<String> getDynamicMessageTypes() {
        return this.dynamicMessageTypes;
    }

    public final Set<IPSMessageRepoManager.Listener> getListeners() {
        return this.listeners;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager
    public void bind(IPSMessageRepoManager.Listener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        this.listeners.add(r2);
    }

    public final boolean canReceiveServerMessageWithSetting(d r2) {
        Intrinsics.checkNotNullParameter(r2, "iMessage");
        return canReceiveServerMessage(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager
    public void dynamicAddMessageType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgMethod");
        if (this.isCleared == false) goto L6;
        return;
    L6:
        if (this.dynamicMessageTypes.contains(r2) == true) goto L9;
        this.dynamicMessageTypes.add(r2);
        onDynamicAddMessageType(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager
    public void insertLocalMessage(t r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        onInsertLocalMessage(r2);
    }

    public final void notifyEvent(IPSMessageRepoManager.Listener.Event r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.listeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((IPSMessageRepoManager.Listener) r0.next()).d(r3);
        goto L7
    }

    public final void notifyMessage(d r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.listeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((IPSMessageRepoManager.Listener) r0.next()).onMessage(r3);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager
    public void unbind(IPSMessageRepoManager.Listener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.isCleared == false) goto L5;
        return;
    L5:
        this.listeners.remove(r2);
    }

    public void onFirstMessage(List<d> r5, boolean r6) {
        if (this.isCleared == false) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        Iterator<d> r0 = r5.iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        d r1 = r0.next();
        if (canReceiveServerMessageWithSetting(r1) == true) goto L9;
        ALogger.i(TAG, "remove message: " + r1.getMessageMethod());
        r0.remove();
        goto L9
    L13:
        Iterator<IPSMessageRepoManager.Listener> r2 = this.listeners.iterator();
    L15:
        if (r2.hasNext() == false) goto L27;
        IPSMessageRepoManager.Listener r3 = r2.next();
        if ((this instanceof NormalMessageRepoManagerV2) == true) goto L18;
        Lazy r4 = PublicScreenABHelper.a;
        if (PublicScreenABHelper.R == false) goto L26;
        if ((this instanceof VSLiveShowMessageRepoManager) == true) goto L25;
        if ((this instanceof VSFirstShowMessageRepoManager) == false) goto L26;
    L25:
        r3.a(r5, r6);
    L26:
        r3.onFirstMessage(r5, r6);
        goto L15
    L18:
        r3.a(r5, r6);
        goto L15
    }
}
