package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer;
import com.bytedance.android.anniex.utils.ThreadSafeFixedSizeFIFOMap;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.x;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\tJ\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0004J.\u0010\u001b\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00190\u0018j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0019`\u001aJ\"\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010'R'\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R'\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R&\u00103\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00190.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104RC\u00108\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00190\u0018j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0019`\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010*\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/bytedance/android/anniex/container/util/AnnieXContainerManager;", "", "Lia/c;", "self", "", "bdxTag", "", "clearTopActivity", "container", "", "isTopContainer", "instanceId", "pureTemplateUrl", "putTemplateUrlFromEngineHashCode", "putAliveTemplateUrlFromEngineHashCode", "schemaUrl", "getPureTemplateUrl", "addContainer", "containerId", "isNestingDollScene", "closeContainerById", "release", "removeContainerById", "getContainerById", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/LinkedHashMap;", "getAllContainer", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "launchMode", "triggerNestingDoll", "saveTemplateUrlFromEngineHashCode", "", "hashCode", "Lia/a;", "containerProxy", "saveContainerProxyFromEngineHashCode", "removeContainerProxyFromEngineHashCode", "TAG", "Ljava/lang/String;", "Lcom/bytedance/android/anniex/utils/ThreadSafeFixedSizeFIFOMap;", "engineUrlMap$delegate", "Lkotlin/Lazy;", "getEngineUrlMap", "()Lcom/bytedance/android/anniex/utils/ThreadSafeFixedSizeFIFOMap;", "engineUrlMap", "Ljava/util/concurrent/ConcurrentHashMap;", "engineAliveUrlMap$delegate", "getEngineAliveUrlMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "engineAliveUrlMap", "aliveContainerProxyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "containerMap$delegate", "getContainerMap", "()Ljava/util/LinkedHashMap;", "containerMap", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXContainerManager {
    public static final AnnieXContainerManager INSTANCE = null;
    public static final String TAG = "AnnieXContainerManager";
    private static final ConcurrentHashMap<Integer, WeakReference<ia.a>> aliveContainerProxyMap = null;
    private static final Lazy containerMap$delegate = null;
    private static final Lazy engineAliveUrlMap$delegate = null;
    private static final Lazy engineUrlMap$delegate = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LaunchMode.values().length];
            r0[LaunchMode.REMOVE_SAME_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LaunchMode.CLEAR_TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final /* synthetic */ t36.d a;

        public final String getName() {
            return "clearTopEvent";
        }

        public final Object getParams() {
            JSONObject r0 = new JSONObject();
            r0.put("new_url", this.a.getOriginUrl());
            return r0;
        }

        public b(t36.d r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;

        public c(String r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "emitter");
            String r0 = AnnieXContainerManager.access$getPureTemplateUrl(AnnieXContainerManager.INSTANCE, this.a);
            if (r0 == null) goto L5;
            r10.onNext(r0);
        L5:
            r10.onComplete();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;

        public d(String r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            String r11 = (String) r10;
            AnnieXContainerManager r0 = AnnieXContainerManager.INSTANCE;
            AnnieXContainerManager.access$putTemplateUrlFromEngineHashCode(r0, this.a, r11);
            AnnieXContainerManager.access$putAliveTemplateUrlFromEngineHashCode(r0, this.a, r11);
        }
    }

    private AnnieXContainerManager() {
    }

    static {
        INSTANCE = new AnnieXContainerManager();
        engineUrlMap$delegate = LazyKt.lazy(AnnieXContainerManager$engineUrlMap$2.INSTANCE);
        engineAliveUrlMap$delegate = LazyKt.lazy(AnnieXContainerManager$engineAliveUrlMap$2.INSTANCE);
        aliveContainerProxyMap = new ConcurrentHashMap();
        containerMap$delegate = LazyKt.lazy(AnnieXContainerManager$containerMap$2.INSTANCE);
    }

    private final LinkedHashMap<String, WeakReference<ia.c>> getContainerMap() {
        return (LinkedHashMap) containerMap$delegate.getValue();
    }

    public final ConcurrentHashMap<String, String> getEngineAliveUrlMap() {
        return (ConcurrentHashMap) engineAliveUrlMap$delegate.getValue();
    }

    public final ThreadSafeFixedSizeFIFOMap<String, String> getEngineUrlMap() {
        return (ThreadSafeFixedSizeFIFOMap) engineUrlMap$delegate.getValue();
    }

    public final LinkedHashMap<String, WeakReference<ia.c>> getAllContainer() {
        return getContainerMap();
    }

    private final String getPureTemplateUrl(String r10) {
        Object r11 = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L14
        Uri r13 = UriProtector.parse(r10);     // Catch: Throwable -> L14
        if (StringsKt.startsWith$default(r10, "http", false, 2, null) == false) goto L7;
    L12:
        Uri r14 = UriProtector.parse(r10);     // Catch: Throwable -> L14
        return new Uri.Builder().scheme(r14.getScheme()).authority(r14.getAuthority()).path(r14.getPath()).build().toString();
    L7:
        if (UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL) == null) goto L10;
        r10 = UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L14
        goto L12
    L10:
        if (UriProtector.getQueryParameter(r13, "surl") == null) goto L12;
        r10 = UriProtector.getQueryParameter(r13, "surl");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.exceptionOrNull-impl(r15) != null) goto L19;
        r11 = r15;
    L19:
        return (String) r11;
    }

    @JvmStatic
    public static final boolean isTopContainer(ia.c r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Set<Map.Entry<String, WeakReference<ia.c>>> r0 = INSTANCE.getAllContainer().entrySet();
        ia.c r11 = null;
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L13;
        Map.Entry r1 = (Map.Entry) CollectionsKt.last(r0);
        if (r1 == null) goto L13;
        WeakReference r12 = (WeakReference) r1.getValue();
        if (r12 == null) goto L13;
        r11 = (ia.c) r12.get();
    L13:
        return Intrinsics.areEqual(r11, r10);
    }

    public final void addContainer(ia.c r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        String r0 = r10.getBDXTag();
        if (r0 == null) goto L5;
        INSTANCE.triggerNestingDoll(r0, r10.getBDXLaunchMode(), r10);
    L5:
        getContainerMap().put(r10.getContainerId(), new WeakReference(r10));
    }

    public final ia.c getContainerById(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        WeakReference<ia.c> r11 = getContainerMap().get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.get();
    }

    public final void removeContainerProxyFromEngineHashCode(int r10) {
        if (r10 != (-1)) goto L5;
        return;
    L5:
        aliveContainerProxyMap.remove(Integer.valueOf(r10));
    }

    public static final /* synthetic */ String access$getPureTemplateUrl(AnnieXContainerManager r0, String r1) {
        return r0.getPureTemplateUrl(r1);
    }

    private final void clearTopActivity(ia.c r10, String r11) {
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L9;
        w26.e r12 = (w26.e) r1.n0(w26.e.class);
        if (r12 == null) goto L9;
        Boolean r13 = r12.q0();
        if (r13 == null) goto L9;
        boolean r14 = r13.booleanValue();
    L10:
        if (r14 == true) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r10.getViewType(), AIStateLogRequest.SOURCE_PAGE) == true) goto L15;
        return;
    L15:
        List r15 = CollectionsKt.asReversed(CollectionsKt.toList(getContainerMap().entrySet()));
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L16:
        Object r18 = null;
        if (r17.hasNext() == false) goto L33;
        ia.c r19 = (ia.c) ((WeakReference) ((Map.Entry) r17.next()).getValue()).get();
        if (Intrinsics.areEqual(r19, r10) == true) goto L28;
        if (r19 == null) goto L22;
        String r20 = r19.getBDXTag();
    L24:
        if (Intrinsics.areEqual(r20, r11) == false) goto L28;
        if (Intrinsics.areEqual(r19.getViewType(), AIStateLogRequest.SOURCE_PAGE) == false) goto L28;
        r16.add(r19);
    L34:
        r16.remove(r10);
        if (r19 != null) goto L37;
        return;
    L37:
        t36.d r21 = r19.getCurrentSchema();
        if (r21 == null) goto L40;
        Uri r22 = r21.getOriginUrl();
    L41:
        String.valueOf(r22);
        WeakReference<Context> r23 = r19.getWeakContext();
        if (r23 == null) goto L44;
        Context r24 = r23.get();
    L46:
        if ((r24 instanceof Activity) == false) goto L48;
        Activity r25 = (Activity) r24;
    L49:
        if (r25 != null) goto L51;
        return;
    L51:
        x r26 = x.a;
        LinkedList r27 = x.c;
        Activity[] r28 = (Activity[]) r27.toArray(new Activity[r27.size()]);
        if (r28 == null) goto L55;
        List r29 = ArraysKt.reversed(r28);
        if (r29 == null) goto L55;
    L56:
        ArrayList r30 = new ArrayList();
        Context r31 = r10.getWeakContext().get();
        if ((r31 instanceof Activity) == false) goto L59;
        r18 = (Activity) r31;
    L59:
        Iterator r32 = r29.iterator();
    L61:
        if (r32.hasNext() == false) goto L68;
        Activity r33 = (Activity) r32.next();
        if (Intrinsics.areEqual(r25, r33) == true) goto L64;
        if (Intrinsics.areEqual(r33, r18) == true) goto L61;
        r30.add(r33);
        goto L61
    L64:
        r30.add(r33);
    L68:
        Iterator r34 = r16.iterator();
    L70:
        if (r34.hasNext() == false) goto L72;
        INSTANCE.closeContainerById(((ia.c) r34.next()).getContainerId(), true);
        goto L70
    L72:
        Iterator r35 = r30.iterator();
    L74:
        if (r35.hasNext() == false) goto L89;
        Activity r36 = (Activity) r35.next();
        boolean r37 = false;
        if (r36 != null) goto L78;
    L80:
        boolean r38 = false;
    L81:
        if (r38 == true) goto L74;
        if (r36 != null) goto L84;
    L86:
        if (r37 == true) goto L74;
        if (r36 == null) goto L74;
        r36.finish();
        goto L74
    L84:
        if (r36.isDestroyed() != true) goto L86;
        r37 = true;
        goto L86
    L78:
        if (r36.isFinishing() != true) goto L80;
        r38 = true;
        goto L81
    L89:
        t36.d r39 = r10.getCurrentSchema();
        if (r39 != null) goto L92;
        return;
    L92:
        if (Intrinsics.areEqual((Boolean) ((y36.i) new y36.a(r39, "send_clear_top_event", Boolean.FALSE)).b, Boolean.TRUE) == false) goto L118;
        r10.sendEvent(new b(r39));
        return;
    L118:
        return;
    L55:
        r29 = new LinkedList();
        goto L56
    L48:
        r25 = null;
        goto L49
    L44:
        r24 = null;
        goto L46
    L40:
        r22 = null;
        goto L41
    L22:
        r20 = null;
    L28:
        if (r19 == null) goto L31;
        r18 = r19.getViewType();
    L31:
        if (Intrinsics.areEqual(r18, AIStateLogRequest.SOURCE_PAGE) == false) goto L16;
        r16.add(r19);
        goto L16
    L33:
        r19 = null;
    L9:
        r14 = true;
        goto L10
    }

    private final void putAliveTemplateUrlFromEngineHashCode(String r10, String r11) {
        if (r11 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L18;
        return;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        getEngineAliveUrlMap().put(r10, r11);     // Catch: Throwable -> L12
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L20;
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.i(TAG, "parse url failure " + r13.getMessage() + ",url is :" + r11, null, 12);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L4:
        if (r11.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    private final void putTemplateUrlFromEngineHashCode(String r10, String r11) {
        if (r11 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L18;
        return;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        ThreadSafeFixedSizeFIFOMap<String, String> r12 = getEngineUrlMap();     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L12
        r12.put(r10, r11);     // Catch: Throwable -> L12
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L20;
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.i(TAG, "parse url failure " + r14.getMessage() + ",url is :" + r11, null, 12);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L4:
        if (r11.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final boolean closeContainerById(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        WeakReference<ia.c> r12 = getContainerMap().remove(r10);
        if (r12 == null) goto L5;
        ia.c r13 = r12.get();
    L6:
        if (r13 == null) goto L37;
        r13.close();
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L14;
        w26.e r14 = (w26.e) r1.n0(w26.e.class);
        if (r14 == null) goto L14;
        Boolean r15 = r14.Q();
        if (r15 == null) goto L14;
        boolean r16 = r15.booleanValue();
    L15:
        if (r16 == true) goto L17;
    L20:
        w26.g r17 = (w26.g) x26.a.a(w26.g.class);
        if (r17 == null) goto L27;
        w26.e r18 = (w26.e) r17.n0(w26.e.class);
        if (r18 == null) goto L27;
        Boolean r19 = r18.K();
        if (r19 == null) goto L27;
        boolean r20 = r19.booleanValue();
    L28:
        if (r20 == true) goto L30;
    L35:
        r13.release();
        return true;
    L30:
        if (Intrinsics.areEqual(r13.getViewType(), AIStateLogRequest.SOURCE_PAGE) == false) goto L32;
    L33:
        if (r11 == true) goto L35;
        return true;
    L32:
        if (Intrinsics.areEqual(r13.getViewType(), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L35;
    L27:
        r20 = true;
        goto L28
    L17:
        if ((r13 instanceof AnnieXFlowPageContainer) == false) goto L20;
        if (r11 == true) goto L20;
        return true;
    L14:
        r16 = true;
        goto L15
    L37:
        return false;
    L5:
        r13 = null;
        goto L6
    }

    public final boolean removeContainerById(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        WeakReference<ia.c> r12 = getContainerMap().remove(r10);
        if (r12 == null) goto L5;
        ia.c r13 = r12.get();
    L6:
        if (r13 == null) goto L11;
        if (r11 == false) goto L13;
        r13.release();
        return true;
    L13:
        return true;
    L11:
        return false;
    L5:
        r13 = null;
        goto L6
    }

    public final void saveContainerProxyFromEngineHashCode(int r10, ia.a r11) {
        Intrinsics.checkNotNullParameter(r11, "containerProxy");
        if (r10 != (-1)) goto L5;
        return;
    L5:
        com.bytedance.android.anniex.assemble.a.h();
        aliveContainerProxyMap.put(Integer.valueOf(r10), new WeakReference(r11));
    }

    public final void saveTemplateUrlFromEngineHashCode(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "instanceId");
        Intrinsics.checkNotNullParameter(r11, "schemaUrl");
        Observable.create(new c(r11)).subscribeOn(Schedulers.io()).subscribe(new d(r10));
    }

    public static final /* synthetic */ void access$putAliveTemplateUrlFromEngineHashCode(AnnieXContainerManager r0, String r1, String r10) {
        r0.putAliveTemplateUrlFromEngineHashCode(r1, r10);
    }

    public static final /* synthetic */ void access$putTemplateUrlFromEngineHashCode(AnnieXContainerManager r0, String r1, String r10) {
        r0.putTemplateUrlFromEngineHashCode(r1, r10);
    }

    public final void triggerNestingDoll(String r10, LaunchMode r11, ia.c r12) {
        Intrinsics.checkNotNullParameter(r10, "bdxTag");
        Intrinsics.checkNotNullParameter(r11, "launchMode");
        int r13 = a.a[r11.ordinal()];
        if (r13 != 1) goto L5;
        ArrayList r14 = new ArrayList();
        Iterator<Map.Entry<String, WeakReference<ia.c>>> r15 = getContainerMap().entrySet().iterator();
    L20:
        if (r15.hasNext() == false) goto L47;
        Map.Entry<String, WeakReference<ia.c>> r16 = r15.next();
        ia.c r17 = r16.getValue().get();
        if (r17 == null) goto L24;
        String r18 = r17.getBDXTag();
    L26:
        if (Intrinsics.areEqual(r18, r10) == false) goto L20;
        Map r19 = x26.a.a;
        w26.g r20 = (w26.g) x26.a.a(w26.g.class);
        if (r20 == null) goto L34;
        w26.e r21 = (w26.e) r20.n0(w26.e.class);
        if (r21 == null) goto L34;
        Boolean r22 = r21.I1();
        if (r22 == null) goto L34;
        boolean r23 = r22.booleanValue();
    L35:
        if (r23 == true) goto L36;
        r14.add(r16.getKey());
        goto L20
    L36:
        ia.c r24 = r16.getValue().get();
        if (r24 == null) goto L39;
        Context r25 = r24.getSystemContext();
    L40:
        if (r12 == null) goto L42;
        Context r26 = r12.getSystemContext();
    L44:
        if (Intrinsics.areEqual(r25, r26) == true) goto L20;
        r14.add(r16.getKey());
        goto L20
    L42:
        r26 = null;
        goto L44
    L39:
        r25 = null;
    L34:
        r23 = true;
        goto L35
    L24:
        r18 = null;
        goto L26
    L47:
        Iterator r27 = r14.iterator();
    L49:
        if (r27.hasNext() == false) goto L67;
        closeContainerById((String) r27.next(), true);
        goto L49
    L67:
        return;
    L5:
        if (r13 != 2) goto L66;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L13
        if (r12 == null) goto L10;
        clearTopActivity(r12, r10);     // Catch: Throwable -> L13
        Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L13
    L15:
        Throwable r31 = Result.exceptionOrNull-impl(r30);
        if (r31 == null) goto L51;
        HybridLogger r32 = HybridLogger.a;
        HybridLogger.i(TAG, "clearTopActivity error:" + r31.getMessage(), null, 12);
        return;
    L51:
        return;
    L10:
        r29 = null;
    L13:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static /* synthetic */ boolean closeContainerById$default(AnnieXContainerManager r0, String r1, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r10 = false;
    L6:
        return r0.closeContainerById(r1, r10);
    }

    public static /* synthetic */ boolean removeContainerById$default(AnnieXContainerManager r0, String r1, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r10 = true;
    L6:
        return r0.removeContainerById(r1, r10);
    }

    public static /* synthetic */ void triggerNestingDoll$default(AnnieXContainerManager r0, String r1, LaunchMode r10, ia.c r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        r0.triggerNestingDoll(r1, r10, r11);
    }
}
