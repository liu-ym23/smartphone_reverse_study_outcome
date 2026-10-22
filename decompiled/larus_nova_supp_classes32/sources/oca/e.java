package oca;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemDownloadAppBinding;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends b {
    public final Lazy x;
    public String y;

    public static final class a {
    }

    static {
    }

    private final ObricCardItemDownloadAppBinding getBinding() {
        return (ObricCardItemDownloadAppBinding) this.x.getValue();
    }

    public e(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.x = LazyKt.lazy(new d(r2, this));
    }

    public static List s(PackageManager r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {Integer.valueOf(LynxTouchEvent.kPseudoStateFocusTransition)};
        f06.b r11 = new f06.b();
        f06.d r12 = r8.b(101304, "android/content/pm/PackageManager", "getInstalledApplications", r13, r9, "java.util.List", r11);
        if (r12.a == false) goto L6;
        r8.a(101304, "android/content/pm/PackageManager", "getInstalledApplications", r13, r9, null, r11, false);
        return (List) r12.b;
    L6:
        List<ApplicationInfo> r10 = r13.getInstalledApplications(LynxTouchEvent.kPseudoStateFocusTransition);
        r8.a(101304, "android/content/pm/PackageManager", "getInstalledApplications", r13, r9, r10, r11, true);
        return r10;
    }

    @Override // oca.b
    public final Map<String, String> q(AppIntentMessage r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("card_type", "app_download_intent");
        r4.put("card_content_type", "app_installed");
        return r4;
    }

    public static ApplicationInfo t(Context r4, String r5) {
        PackageManager r6 = r4.getPackageManager();     // Catch: Exception -> L8
        Iterator r0 = s(r6).iterator();     // Catch: Exception -> L8
    L4:
        if (r0.hasNext() == false) goto L17;
        ApplicationInfo r1 = (ApplicationInfo) r0.next();     // Catch: Exception -> L8
        if (StringsKt.equals(r6.getApplicationLabel(r1).toString(), r5, true) == false) goto L4;
        return r1;
    L17:
        return null;
    L8:
        e = move-exception;
        FLogger.a.e("DownloadAppEntityBox", "getInstalledAppByName: error getting app info for " + r5, e);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oca.b
    public final void o(final AppIntentMessage r5, Message r6) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r6, "message");
        Map r7 = r5.getExt();
        if (r7 != null) goto L5;
        r7 = MapsKt.emptyMap();
    L5:
        n(getBinding().a, ContextCompat.getColor(getContext(), 2131100492));
        String r8 = (String) r7.get("KEY_APP_NAME");
        if (r8 != null) goto L8;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        this.y = r8;
        TextView r9 = getBinding().c;
        String r0 = this.y;
        Intrinsics.checkNotNull(r0);
        r9.setText(StringsKt.trim(r0).toString());
        Context r10 = getContext();
        String r1 = this.y;
        Intrinsics.checkNotNull(r1);
        ApplicationInfo r2 = t(r10, r1);
        if (r2 != null) goto L21;
    L15:
        Drawable r11 = null;
    L16:
        if (r11 == null) goto L18;
        getBinding().b.setImageDrawable(r11);
    L19:
        getBinding().d.setOnClickListener(new c(this, r5));
        return;
    L18:
        getBinding().b.setImageResource(2131244448);
        goto L19
    L21:
        r11 = r10.getPackageManager().getApplicationIcon(r2);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        FLogger.a.e("DownloadAppEntityBox", "getAppIconByName: error getting icon for " + r1, e);
        goto L15
    }
}
