package fw8;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.view.actionbar.api.IActionBarFilter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ss8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements IActionBarFilter {
    public final String a;
    public final String b;
    public final IActionBarFilter.FilterMode c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final int getPriority() {
        return 500;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final String b() {
        return this.b;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final IActionBarFilter.FilterMode getMode() {
        return this.c;
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "actionBarScopeId");
        this.a = r2;
        Intrinsics.checkNotNullParameter(r2, "actionBarScopeId");
        this.b = "applet_chat_action_bar_snapshot_".concat(r2);
        this.c = IActionBarFilter.FilterMode.BLACKLIST;
    }

    @Override // com.larus.bmhome.view.actionbar.api.IActionBarFilter
    public final boolean a(z0 r5, d r6) {
        Intrinsics.checkNotNullParameter(r5, "item");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (Intrinsics.areEqual(r6.f.get("action_bar_scope_id"), this.a) == false) goto L13;
        String r7 = r5.b;
        if (r7 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.startsWith$default(r7, "applet_chat_action_bar_", false, 2, null) != true) goto L9;
        r8 = true;
        goto L10
    L13:
        return false;
    }
}
