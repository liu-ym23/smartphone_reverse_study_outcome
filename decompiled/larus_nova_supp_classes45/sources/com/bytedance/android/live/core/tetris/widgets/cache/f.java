package com.bytedance.android.live.core.tetris.widgets.cache;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements d {
    public final ArrayList<String> a;
    public final ConcurrentHashMap<Class<?>, com.bytedance.android.live.core.tetris.widgets.a> b;

    @Override // com.bytedance.android.live.core.tetris.widgets.cache.d
    public final void onDestory() {
        ConcurrentHashMap<Class<?>, com.bytedance.android.live.core.tetris.widgets.a> r0 = this.b;
        if (r0 == null) goto L12;
        Iterator<Map.Entry<Class<?>, com.bytedance.android.live.core.tetris.widgets.a>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        Map.Entry<Class<?>, com.bytedance.android.live.core.tetris.widgets.a> r2 = r1.next();
        if (r2 == null) goto L6;
        com.bytedance.android.live.core.tetris.widgets.a r3 = r2.getValue();
        if (r3 == null) goto L6;
        r3.clearAfterDestroyed();
    L12:
        ConcurrentHashMap<Class<?>, com.bytedance.android.live.core.tetris.widgets.a> r4 = this.b;
        if (r4 == null) goto L23;
        r4.clear();
        return;
    }

    public f() {
        this.a = LiveInfraSettingKeys.LIVE_WIDGET_CACHE_WHITELIST.getValue();
        this.b = new ConcurrentHashMap();
        CacheStrategyType r0 = CacheStrategyType.NORMAL;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.cache.d
    public final void b(c r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "manager");
        Intrinsics.checkNotNullParameter(r8, "uniqueID");
        e r1 = r7.b();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "deluniqueID");
        r1.b.remove(r8);
        e r2 = r7.b();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, "uniqueID");
        Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a> r0 = r2.a.remove(r8);
        if (r0 == null) goto L8;
        r7.a().c(r8, r0);
        b.a("该直播间的缓存移入ActiveCache", new String[]{r8});
        Iterator<Map.Entry<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a>> r3 = r0.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a> r4 = r3.next();
        int r5 = b.a;
        b.b("该直播间的缓存移入ActiveCache", new String[]{r8, "当前被移入的是：".concat(r4.getValue().getClass().getName())});
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.cache.d
    public final void c(c r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "manager");
        Intrinsics.checkNotNullParameter(r8, "uniqueID");
        a r1 = r7.a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "uniqueID");
        Map<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a> r0 = r1.a.remove(r8);
        if (r0 == null) goto L8;
        r7.b().c(r8, r0);
        e r9 = r7.b();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "adduniqueID");
        r9.b.addFirst(r8);
        b.a("该直播间的缓存移入ReusableCache", new String[]{r8});
        Iterator<Map.Entry<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a>> r2 = r0.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<Class<? extends com.bytedance.android.live.core.tetris.widgets.a>, com.bytedance.android.live.core.tetris.widgets.a> r3 = r2.next();
        int r4 = b.a;
        b.b("该直播间的缓存移入ReusableCache", new String[]{r8, "当前被移入的是：".concat(r3.getValue().getClass().getName())});
        goto L6
    L10:
        return;
    }

    public final com.bytedance.android.live.core.tetris.widgets.a d(c r6, Class<? extends com.bytedance.android.live.core.tetris.widgets.a> r7) {
        if (this.a.contains(r7.getSimpleName()) == false) goto L5;
        int r0 = b.a;
        b.c(new String[]{"在白名单中，但是未复用到  ".concat(r7.getSimpleName())});
    L5:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "clazz");
        com.bytedance.android.live.core.tetris.widgets.a r8 = r7.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L12
        r8.setRecyclable();     // Catch: InstantiationException -> L9 IllegalAccessException -> L12
        int r1 = b.a;
        b.c(new String[]{"创建新的Instance ".concat(r7.getSimpleName())});
        return r8;
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.cache.d
    public final com.bytedance.android.live.core.tetris.widgets.a a(final c r9, String r11, final Class<? extends com.bytedance.android.live.core.tetris.widgets.a> r12) {
        Intrinsics.checkNotNullParameter(r9, "manager");
        Intrinsics.checkNotNullParameter(r11, "uniqueID");
        Intrinsics.checkNotNullParameter(r12, "clazz");
        ArrayList<String> r1 = this.a;
        com.bytedance.android.live.core.tetris.widgets.a r2 = null;
        Object r3 = null;
        if (r1 != null) goto L5;
    L51:
        Intrinsics.checkNotNullParameter(r9, "manager");
        Intrinsics.checkNotNullParameter(r12, "clazz");
        com.bytedance.android.live.core.tetris.widgets.a r13 = this.b.get(r12);
        if (i60.c.a.getValue().booleanValue() == false) goto L65;
        if (r13 != null) goto L55;
    L69:
        boolean r0 = false;
    L70:
        if (r13 == null) goto L74;
        if (r0 == false) goto L74;
        r13.clearAfterDestroyed();
        r13 = null;
    L74:
        if ((r13 instanceof LifecycleOwner) == false) goto L89;
        LifecycleOwner r4 = (LifecycleOwner) r13;
        if ((r4.getLifecycle() instanceof LifecycleRegistry) == false) goto L89;
        LifecycleRegistry r5 = r4.getLifecycle();
        if (r5 == null) goto L88;
        if (r5.getObserverCount() <= 0) goto L82;
        r13.clearAfterDestroyed();
    L90:
        if (r2 == null) goto L101;
        int r14 = b.a;
        b.c(new String[]{"非白名单___找到缓存，直接提供 ___  ".concat(r12.getName())});
    L100:
        return r2;
    L101:
        r2 = d(r9, r12);     // Catch: InstantiationException -> L93 IllegalAccessException -> L96
        Intrinsics.checkNotNull(r2);     // Catch: InstantiationException -> L93 IllegalAccessException -> L96
        r2.setRecyclable();     // Catch: InstantiationException -> L93 IllegalAccessException -> L96
        this.b.put(r12, r2);
        int r15 = b.a;
        b.c(new String[]{"非白名单___未找到缓存，直接创建 ___  ".concat(r12.getName())});
        goto L100
    L96:
        e = move-exception;
        throw new RuntimeException(e);
    L93:
        e = move-exception;
        throw new RuntimeException(e);
    L82:
        LifecycleRegistry r6 = r4.getLifecycle();
        if (r6 == null) goto L86;
        r6.markState(Lifecycle.State.INITIALIZED);
        goto L89
    L86:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
    L88:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
    L89:
        r2 = r13;
        goto L90
    L55:
        if (r13.isAlive() == false) goto L57;
    L68:
        r0 = true;
        goto L70
    L57:
        if ((r13 instanceof LiveRecyclableWidget) == true) goto L59;
        com.bytedance.android.live.core.tetris.widgets.a r7 = null;
    L60:
        LiveRecyclableWidget r8 = (LiveRecyclableWidget) r7;
        if (r8 == null) goto L69;
        if (r8.isAsyncLoading() != true) goto L69;
    L59:
        r7 = r13;
        goto L60
    L65:
        if (r13 == null) goto L69;
        if (r13.isAlive() == false) goto L69;
    L5:
        if (r1.size() <= 0) goto L51;
        if (this.a.contains(r12.getSimpleName()) == false) goto L51;
        if (LiveInfraSettingKeys.LIVE_WIDGET_WHITELIST_NOCACHE.getValue().booleanValue() == false) goto L12;
        int r16 = b.a;
        b.c(new String[]{"在白名单中，但是不允许走复用逻辑，直接创建  ".concat(r12.getSimpleName())});
        return d(r9, r12);
    L12:
        g r17 = (g) r9.c.getValue();
        Function0<com.bytedance.android.live.core.tetris.widgets.a> r18 = new SingleWidgetSizedWhitelistCacheStrategy$handleCacheWithRecycle$1(this, r9, r12);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r12, "widgetClass");
        Intrinsics.checkNotNullParameter(r18, "newInstance");
        LinkedHashMap r19 = (LinkedHashMap) r17.a;
        Object r21 = r19.get(r12);
        Object r22 = r21;
        if (r21 != null) goto L15;
        LinkedList r23 = new LinkedList();
        r19.put(r12, r23);
        r22 = r23;
    L15:
        LinkedList r24 = (LinkedList) r22;
        Iterator r25 = r24.iterator();
    L17:
        if (r25.hasNext() == false) goto L43;
        Object r26 = r25.next();
        com.bytedance.android.live.core.tetris.widgets.a r27 = (com.bytedance.android.live.core.tetris.widgets.a) r26;
        if (MultiRoomConfig.INSTANCE.fixWidgetGetter() == false) goto L40;
        if (r27 != null) goto L23;
    L36:
        boolean r28 = false;
    L37:
        if (r28 == true) goto L39;
        boolean r29 = true;
    L41:
        if (r29 == false) goto L17;
        r3 = r26;
        goto L43
    L39:
        r29 = false;
        goto L41
    L23:
        if (i60.c.a.getValue().booleanValue() == true) goto L25;
        boolean r31 = r27.isAlive();
    L34:
        if (r31 == false) goto L36;
        r27.clearAfterDestroyed();
        r28 = true;
        goto L37
    L25:
        if (r27.isAlive() == false) goto L27;
    L32:
        r31 = true;
        goto L34
    L27:
        if ((r27 instanceof LiveRecyclableWidget) == true) goto L29;
    L31:
        r31 = false;
        goto L34
    L29:
        if (((LiveRecyclableWidget) r27).isAsyncLoading() == false) goto L31;
    L40:
        r29 = !r27.isAlive();
    L43:
        com.bytedance.android.live.core.tetris.widgets.a r32 = (com.bytedance.android.live.core.tetris.widgets.a) r3;
        if (r32 == null) goto L46;
        r24.remove(r32);
        r24.add(r32);
        int r33 = b.a;
        b.a("使用到了可复用的缓存组件 " + r12.getSimpleName() + ", 当前这个组件在缓存池中，存在" + r24.size() + 20010, new String[0]);
        return r32;
    L46:
        int r34 = b.a;
        b.a("未找到可复用的缓存组件 ".concat(r12.getSimpleName()), new String[0]);
        if (r24.size() >= r17.b) goto L50;
        com.bytedance.android.live.core.tetris.widgets.a r35 = (com.bytedance.android.live.core.tetris.widgets.a) r18.invoke();
        r24.add(r35);
        return r35;
    L50:
        return (com.bytedance.android.live.core.tetris.widgets.a) r18.invoke();
    }
}
