package com.ss.android.lark.flow.chat.setting;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.setting.api.LarkSocialSettingUtils;
import com.larus.setting.api.q;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.usersetting.entity.NotificationSettingV2;
import com.ss.android.lark.usersetting.entity.NotificationSettingWrapper;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class FlowHumansChatSettingsServiceImpl implements aza.b {
    public static final AtomicBoolean d = null;
    public final CopyOnWriteArraySet<aza.a> a;
    public final Lazy b;
    public volatile NotificationSettingV2.ChatMsgNotificationState c;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.usersetting.service.notification.a {
        public final /* synthetic */ FlowHumansChatSettingsServiceImpl a;

        public b(FlowHumansChatSettingsServiceImpl r1) {
            this.a = r1;
        }

        public final void a(NotificationSettingWrapper r3) {
            Intrinsics.checkNotNullParameter(r3, "settingWrapper");
            NotificationSettingV2 r4 = r3.getNotificationSettingV2();
            if (r4 == null) goto L5;
            NotificationSettingV2.ChatMsgNotificationState r5 = r4.getChatMsgState();
        L6:
            if (r5 != null) goto L8;
            return;
        L8:
            if (this.a.c == r5) goto L10;
            Log.i("FlowHumansChatSettingsServiceImpl", "onPushNotificationSetting: old=" + this.a.c + ", new=" + r5);
        L10:
            FlowHumansChatSettingsServiceImpl.d(this.a, r5);
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
        d = new AtomicBoolean(false);
    }

    public final com.ss.android.lark.usersetting.service.a f() {
        return (com.ss.android.lark.usersetting.service.a) this.b.getValue();
    }

    @Inject
    public FlowHumansChatSettingsServiceImpl() {
        this.a = new CopyOnWriteArraySet();
        this.b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FlowHumansChatSettingsServiceImpl$userSettingFacade$2.INSTANCE);
        AtomicBoolean r0 = new AtomicBoolean(false);
        AtomicBoolean r2 = new AtomicBoolean(false);
        b r3 = new b(this);
        if (r2.compareAndSet(false, true) == false) goto L11;
        Log.i("FlowHumansChatSettingsServiceImpl", "ensureInitFetch start");
        f().c();
        if (d.compareAndSet(false, true) == false) goto L8;
        Log.i("FlowHumansChatSettingsServiceImpl", "registerPushOnce");
        f().d();
    L9:
        Log.i("FlowHumansChatSettingsServiceImpl", "ensureInitFetch fetch initial NotificationSettingV2");
        f().a(new FlowHumansChatSettingsServiceImpl$ensureInitFetch$1(this));
        goto L11
    L8:
        Log.i("FlowHumansChatSettingsServiceImpl", "registerPushOnce skipped: already registered");
    L11:
        if (r0.compareAndSet(false, true) == false) goto L14;
        Log.i("FlowHumansChatSettingsServiceImpl", "registerNotificationSettingObserver");
        f().b(r3);
        return;
    }

    public static pza.b e(boolean r2) {
        return new pza.b(UIHelper.getString(2131890176), r2);
    }

    public final void a(final q r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        Log.i("FlowHumansChatSettingsServiceImpl", "getHumansChatSettings called, cachedState=" + this.c);
        NotificationSettingV2.ChatMsgNotificationState r0 = this.c;
        if (r0 == null) goto L10;
        Log.i("FlowHumansChatSettingsServiceImpl", "getHumansChatSettings cache hit: " + r0);
        if (r0 != NotificationSettingV2.ChatMsgNotificationState.OPEN) goto L7;
        boolean r1 = true;
    L8:
        r5.a(e(r1));
        return;
    L7:
        r1 = false;
        goto L8
    L10:
        Log.i("FlowHumansChatSettingsServiceImpl", "getHumansChatSettings cache miss, fetch from userSettingFacade");
        f().a(new FlowHumansChatSettingsServiceImpl$getHumansChatSettings$2(r5, this));
    }

    public static final void d(FlowHumansChatSettingsServiceImpl r2, NotificationSettingV2.ChatMsgNotificationState r3) {
        r2.getClass();
        Log.i("FlowHumansChatSettingsServiceImpl", "updateCacheAndDispatch: old=" + r2.c + ", new=" + r3 + ", listeners=" + r2.a.size());
        r2.c = r3;
        if (r3 != NotificationSettingV2.ChatMsgNotificationState.OPEN) goto L5;
        boolean r4 = true;
    L6:
        pza.b r5 = e(r4);
        Iterator<aza.a> r6 = r2.a.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r6.next().a(r5);
        goto L8
    L10:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void b(pza.b r4, final LarkSocialSettingUtils.toSettingsItem.2.1.1 r5) {
        Intrinsics.checkNotNullParameter(r4, "item");
        boolean r6 = r4.d;
        if (r6 == false) goto L5;
        final NotificationSettingV2.ChatMsgNotificationState r0 = NotificationSettingV2.ChatMsgNotificationState.OPEN;
    L6:
        Log.i("FlowHumansChatSettingsServiceImpl", "updateHumansChatSettings called: enabled=" + r6 + ", targetState=" + r0 + ", cachedState=" + this.c);
        if (this.c != r0) goto L10;
        Log.i("FlowHumansChatSettingsServiceImpl", "updateHumansChatSettings no-op: cachedState already equals targetState");
        r5.onSuccess(Unit.INSTANCE);
        return;
    L10:
        f().a(new FlowHumansChatSettingsServiceImpl$updateHumansChatSettings$1(r0, this, r5));
        return;
    L5:
        r0 = NotificationSettingV2.ChatMsgNotificationState.CLOSED;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.ss.android.lark.flow.chat.setting.FlowHumansChatSettingsServiceImpl$syncSettings$1] */
    public static final void c(final FlowHumansChatSettingsServiceImpl r2, NotificationSettingV2 r3, final NotificationSettingV2.ChatMsgNotificationState r4, final IGetDataCallback r5) {
        r2.getClass();
        Log.i("FlowHumansChatSettingsServiceImpl", "persist setNotificationSettingV2: targetState=" + r4);
        r2.f().e(r3, new FlowHumansChatSettingsServiceImpl$syncSettings$1(r4, r2, r5));
    }
}
