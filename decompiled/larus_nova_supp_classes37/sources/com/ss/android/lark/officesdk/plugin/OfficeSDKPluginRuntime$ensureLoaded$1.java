package com.ss.android.lark.officesdk.plugin;

import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginStage;
import com.ss.android.lark.picker.base.view.ItemViewType;
import io.reactivex.Completable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class OfficeSDKPluginRuntime$ensureLoaded$1 extends Lambda implements Function0<Completable> {
    final /* synthetic */ String $pluginId;

    public OfficeSDKPluginRuntime$ensureLoaded$1(String r1) {
        this.$pluginId = r1;
        super(0);
    }

    public final Completable invoke() {
        final String r0 = this.$pluginId;
        ConcurrentHashMap<String, Completable> r1 = d.a;
        Intrinsics.checkNotNullParameter(r0, "pluginId");
        ConcurrentHashMap<String, Completable> r2 = d.a;
        Completable r3 = null;
        if (StringsKt.isBlank(r0) == false) goto L5;
        OfficeSDKPluginException r4 = d.e(OfficeSDKPluginStage.QUERY, OfficeSDKPluginErrorCode.INVALID_PLUGIN_ID, "Plugin id must not be blank", null);
    L6:
        if (r4 == null) goto L8;
        Completable r5 = Completable.error(r4);
    L23:
        final String r6 = this.$pluginId;
        return r5.andThen(Completable.defer(new AnonymousClass1(r6)));
    L8:
        ConcurrentHashMap<String, Completable> r7 = d.a;
        Function0<Completable> r8 = new OfficeSDKPluginRuntime$ensureInstalled$2(r0);
        monitor-enter(r7);
        Completable r9 = r7.get(r0);     // Catch: Throwable -> L25
        if (r9 == null) goto L14;
        monitor-exit(r7);
        r5 = r9;
        goto L23
    L14:
        Ref.ObjectRef r10 = new Ref.ObjectRef();     // Catch: Throwable -> L25
        Completable r11 = ((Completable) r8.invoke()).doFinally(new c(r7, r0, r10)).cache();     // Catch: Throwable -> L25
        r10.element = r11;     // Catch: Throwable -> L25
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("task");     // Catch: Throwable -> L25
        r11 = null;
    L17:
        r7.put(r0, r11);     // Catch: Throwable -> L25
        Object r12 = r10.element;     // Catch: Throwable -> L25
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("task");     // Catch: Throwable -> L25
    L21:
        monitor-exit(r7);
        r5 = r3;
        goto L23
    L20:
        r3 = (Completable) r12;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L5:
        r4 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m543invoke() {
        return invoke();
    }
}
