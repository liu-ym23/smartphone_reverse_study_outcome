package com.obric.widget.host.runtime;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002R\u0018\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/widget/host/runtime/SharedPreferencesWidgetRenderStateStore;", "Lcom/obric/widget/host/runtime/WidgetRenderStateStore;", "context", "Landroid/content/Context;", "name", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "appContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "preferences$delegate", "Lkotlin/Lazy;", "hasRendered", "", "hostId", "appletId", "widgetId", "markRendered", "", "renderStateKey", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedPreferencesWidgetRenderStateStore implements WidgetRenderStateStore {
    public static final Companion Companion = null;
    private static final String KEY_RENDERED_PREFIX = "rendered";
    public static final String PREF_RENDER_STATE = "widget_render_state_sp";
    private final Context appContext;
    private final Lazy preferences$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/widget/host/runtime/SharedPreferencesWidgetRenderStateStore$Companion;", "", "<init>", "()V", "PREF_RENDER_STATE", "", "KEY_RENDERED_PREFIX", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SharedPreferencesWidgetRenderStateStore(Context r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "name");
        this.appContext = r5.getApplicationContext();
        this.preferences$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new a2.a(3, this, r10));
    }

    public static /* synthetic */ SharedPreferences a(SharedPreferencesWidgetRenderStateStore r5, String r10) {
        return preferences_delegate$lambda$0(r5, r10);
    }

    private final SharedPreferences getPreferences() {
        return (SharedPreferences) this.preferences$delegate.getValue();
    }

    private static final SharedPreferences preferences_delegate$lambda$0(SharedPreferencesWidgetRenderStateStore r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$name");
        return r5.appContext.getSharedPreferences(r10, 0);
    }

    private final String renderStateKey(String r5, String r10, String r11) {
        if (StringsKt.isBlank(r5) == true) goto L14;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (StringsKt.isBlank(r10) == true) goto L18;
        if (r11 != null) goto L10;
        return null;
    L10:
        if (StringsKt.isBlank(r11) == true) goto L19;
        StringBuilder r12 = androidx.constraintlayout.motion.widget.a.y("rendered:", r5, ":", r10, ":");
        r12.append(r11);
        return r12.toString();
    L19:
        return null;
    L18:
        return null;
    L14:
        return null;
    }

    @Override // com.obric.widget.host.runtime.WidgetRenderStateStore
    public boolean hasRendered(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        String r12 = renderStateKey(r5, r10, r11);
        if (r12 != null) goto L6;
        return false;
    L6:
        return getPreferences().getBoolean(r12, false);
    }

    @Override // com.obric.widget.host.runtime.WidgetRenderStateStore
    public void markRendered(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        String r12 = renderStateKey(r5, r10, r11);
        if (r12 != null) goto L5;
        return;
    L5:
        getPreferences().edit().putBoolean(r12, true).apply();
    }

    public /* synthetic */ SharedPreferencesWidgetRenderStateStore(Context r5, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = PREF_RENDER_STATE;
    L5:
        this(r5, r10);
    }
}
