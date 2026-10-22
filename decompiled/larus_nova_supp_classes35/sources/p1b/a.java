package p1b;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatDelegate;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.ui.IUI$AppThemeInfo;
import com.ss.android.lark.chameleonv2.lkapi.ui.IUI$Ipc$EventType;
import com.ss.android.lark.chameleonv2.lkapi.ui.IUI$Ipc$IpcType;
import com.ss.android.lark.chameleonv2.lkapi.ui.IUI$Ipc$ThemeEventDetail;
import com.ss.android.lark.chameleonv2.lkapi.ui.IUI$ThemeStyle;
import com.ss.android.lark.chameleonv2.lkapi.ui.IUI$ZoomLevel;
import com.ss.android.lark.chameleonv2.lkapi.ui.IUI$ZoomLevelInfo;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.LarkContext;
import h18.f;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {
    public static final /* synthetic */ int d = 0;
    public IChameleonHandlerContext a;
    public IUI$ThemeStyle b;
    public final e c;

    /* JADX INFO: renamed from: p1b.a$a, reason: collision with other inner class name */
    public static final class C0274a {
    }

    public final class b extends AbsChameleonHandler<Unit> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public b(a r1) {
            this.b = r1;
            this.a = LKAPIModules.UI.GetAppThemeInfo.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r4) {
            Intrinsics.checkNotNullParameter(r4, "callback");
            a r1 = this.b;
            int r2 = a.d;
            r4.success(new IUI$AppThemeInfo(r1.f()));
        }
    }

    public final class c extends AbsChameleonHandler<Unit> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public c(a r1) {
            this.b = r1;
            this.a = LKAPIModules.UI.GetZoomLevel.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r7) {
            Intrinsics.checkNotNullParameter(r7, "callback");
            float r0 = zz7.b.d().getMultiplier();
            IChameleonHandlerContext r1 = getContext();
            if (r1 == null) goto L9;
            WebView r2 = r1.getWebview();
            if (r2 == null) goto L9;
            WebSettings r3 = r2.getSettings();
            if (r3 == null) goto L9;
            r3.setTextZoom(100);
        L9:
            a r4 = this.b;
            int r5 = a.d;
            r4.getClass();
            int r6 = d.a[zz7.b.d().ordinal()];
            if (r6 != 1) goto L12;
            IUI$ZoomLevel r8 = IUI$ZoomLevel.SMALL;
        L25:
            r7.success(new IUI$ZoomLevelInfo(r8, String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r0)}, 1))));
            return;
        L12:
            if (r6 != 2) goto L14;
            r8 = IUI$ZoomLevel.LARGE1;
            goto L25
        L14:
            if (r6 != 3) goto L16;
            r8 = IUI$ZoomLevel.LARGE2;
            goto L25
        L16:
            if (r6 != 4) goto L18;
            r8 = IUI$ZoomLevel.LARGE3;
            goto L25
        L18:
            if (r6 == 5) goto L20;
            r8 = IUI$ZoomLevel.NORMAL;
            goto L25
        L20:
            r8 = IUI$ZoomLevel.LARGE4;
            goto L25
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ZoomLevel6.values().length];
            r0[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ZoomLevel6.LARGE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ZoomLevel6.LARGE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ZoomLevel6.LARGE3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ZoomLevel6.LARGE4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class e implements ComponentCallbacks {
        public final /* synthetic */ a a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public e(a r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r5) {
            Intrinsics.checkNotNullParameter(r5, "osConfig");
            this.a.getClass();
            int r0 = AppCompatDelegate.getDefaultNightMode();
            char r2 = 1;
            if (r0 == 1) goto L6;
            if (r0 == 2) goto L7;
            r2 = 2;
        L7:
            if (r2 != 2) goto L20;
            boolean r6 = f.b(r5);
            j.e("LK_API_TAG_UI", "systemThemeStyleChange isNightMode=" + r6);
            if (r6 == false) goto L11;
            IUI$ThemeStyle r7 = IUI$ThemeStyle.Dark;
        L12:
            a r1 = this.a;
            IUI$ThemeStyle r3 = r1.b;
            if (r3 == null) goto L15;
            if (r3 != r7) goto L15;
            return;
        L15:
            IChameleonHandlerContext r4 = r1.a;
            if (r4 == null) goto L18;
            r4.sendEvent(IUI$Ipc$EventType.THEME_EVENT.getValue(), new IUI$Ipc$ThemeEventDetail(IUI$Ipc$IpcType.APP_THEME_CHANGE.getValue(), r7));
        L18:
            this.a.b = r7;
            return;
        L11:
            r7 = IUI$ThemeStyle.Light;
            goto L12
        L20:
            return;
        L6:
            r2 = 0;
            goto L7
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new b(this), new c(this)});
    }

    public a() {
        this.c = new e(this);
    }

    public final IUI$ThemeStyle f() {
        int r0 = AppCompatDelegate.getDefaultNightMode();
        boolean r1 = false;
        if (r0 == 1) goto L8;
        char r3 = 2;
        if (r0 != 2) goto L9;
        r3 = 1;
    L9:
        if (r3 == 0) goto L21;
        if (r3 != 1) goto L12;
        IUI$ThemeStyle r2 = IUI$ThemeStyle.Dark;
    L22:
        j.e("LK_API_TAG_UI", "getCurrentSystemThemeStyle themeStyle=" + r2);
        return r2;
    L12:
        if (Build.VERSION.SDK_INT < 29) goto L14;
        r1 = true;
    L14:
        if (r1 == true) goto L16;
        r2 = IUI$ThemeStyle.Light;
        goto L22
    L16:
        if (f.a(LarkContext.getApplication()) == false) goto L18;
        r2 = IUI$ThemeStyle.Dark;
        goto L22
    L18:
        r2 = IUI$ThemeStyle.Light;
        goto L22
    L21:
        r2 = IUI$ThemeStyle.Light;
        goto L22
    L8:
        r3 = 0;
        goto L9
    }

    @Override // z0b.a
    public final void d(IChameleonHandlerContext r2) {
        if (r2 == null) goto L4;
        Context r0 = r2.getCmlContext();
    L5:
        this.a = r2;
        this.b = f();
        if (r0 == null) goto L9;
        r0.registerComponentCallbacks(this.c);
        return;
    L9:
        return;
    L4:
        r0 = null;
        goto L5
    }

    @Override // z0b.a
    public final void e(IChameleonHandlerContext r3) {
        if (r3 == null) goto L5;
        Context r4 = r3.getCmlContext();
    L6:
        if (r4 == null) goto L8;
        r4.unregisterComponentCallbacks(this.c);
    L8:
        this.a = null;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
