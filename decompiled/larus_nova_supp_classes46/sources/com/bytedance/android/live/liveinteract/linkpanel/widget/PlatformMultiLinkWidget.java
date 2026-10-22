package com.bytedance.android.live.liveinteract.linkpanel.widget;

import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.kmp.core.KmpEnv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J'\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "", "multiLinkRoomScopeFallback", "onCreate", "onDestroy", "Ldn0/b;", "T", "Ljava/lang/Class;", "serviceType", "getScopeServiceInMultiLinkRoom", "(Ljava/lang/Class;)Ldn0/b;", "getScopeServiceOrNullInMultiLinkRoom", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class PlatformMultiLinkWidget extends BaseMultiLinkWidget {
    public void multiLinkRoomScopeFallback() {
        u60.a r2 = null;
        if (((Boolean) vm2.i.Q.getValue(null, vm2.i.a[41])).booleanValue() == true) goto L5;
        return;
    L5:
        if (getMultiLinkRoomScope() == null) goto L10;
        bn0.b r0 = getMultiLinkRoomScope();
        if (r0 != null) goto L9;
        return;
    L9:
        if (com.bytedance.android.scope.l.b(r0) == false) goto L10;
        return;
    L10:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.o r3 = com.bytedance.android.live.liveinteract.api.utils.m.k(this, r1);
    L14:
        com.bytedance.live.datacontext.n r4 = r3.getMultiLinkRoomScope();
        if (r4 == null) goto L17;
        bn0.b r5 = (bn0.b) r4.getValue();
    L18:
        if (r5 != null) goto L20;
    L23:
        com.bytedance.live.datacontext.j r6 = r3.z2();
        if (r6 == null) goto L28;
        com.bytedance.live.kmp.core.a r7 = (com.bytedance.live.kmp.core.a) r6.getValue();
        if (r7 == null) goto L28;
        r2 = r7.c();
    L28:
        if (r2 == null) goto L34;
        com.bytedance.android.scope.m.e.getClass();
        bn0.a r8 = (bn0.a) com.bytedance.android.scope.m.b(r2).a(Reflection.getOrCreateKotlinClass(bn0.a.class));
        if (r8 == null) goto L34;
        bn0.b r9 = r8.getMultiLinkRoomScope();
        if (r9 == null) goto L34;
        setMultiLinkRoomScope(r9);
    L34:
        KmpEnv r10 = KmpEnv.a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L37;
        return;
    L37:
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L39;
        return;
    L39:
        if (getMultiLinkRoomScope() != null) goto L41;
        String r11 = "_multiLinkRoomScope can not be null";
    L43:
        throw new Exception(r11);
    L41:
        r11 = "_multiLinkRoomScope is not entered";
        goto L43
    L20:
        if (com.bytedance.android.scope.l.b(r5) == false) goto L23;
        setMultiLinkRoomScope(r5);
        goto L34
    L17:
        r5 = null;
        goto L18
    L13:
        r3 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        multiLinkRoomScopeFallback();
        super.onCreate();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        multiLinkRoomScopeFallback();
        super.onDestroy();
    }

    public PlatformMultiLinkWidget() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public <T extends dn0.b> T getScopeServiceInMultiLinkRoom(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceType");
        return (T) super.getScopeServiceInMultiLinkRoom(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public <T extends dn0.b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceType");
        return (T) super.getScopeServiceOrNullInMultiLinkRoom(r2);
    }
}
