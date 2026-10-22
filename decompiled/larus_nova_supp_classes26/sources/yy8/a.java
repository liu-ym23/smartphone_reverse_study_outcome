package yy8;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.d;
import com.larus.chat.gallery.impl.preview.toolbar.action.y;
import com.larus.chat.gallery.impl.preview.toolbar.action.z;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements d {
    public final /* synthetic */ xy8.a a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> d;
    public final /* synthetic */ Function0<Unit> e;

    @Override // com.larus.bmhome.share.panel.d
    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void f() {
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void onDismiss() {
        FLogger.a.d("PreviewSharePanelIntegration", "分享面板关闭");
        b.a(this.c, this.d, this.e);
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void e(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.d.element = r2;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final boolean b(Context r3, DialogFragment r4, View r5, jr9.a r6) {
        Intrinsics.checkNotNullParameter(r6, "shareItemConfig");
        String r7 = r6.b();
        if (Intrinsics.areEqual(r7, ShareChannel.PUBLISH) == false) goto L14;
        FLogger.a.i("PreviewSharePanelIntegration", "拦截 PUBLISH 点击");
        if (r4 != null) goto L29;
    L12:
        b.a(this.c, this.d, this.e);
        this.a.k();
    L24:
        return true;
    L29:
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L12;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    L14:
        if (Intrinsics.areEqual(r7, ShareChannel.SET_PRIVATE) == false) goto L25;
        FLogger.a.i("PreviewSharePanelIntegration", "拦截 SET_PRIVATE 点击");
        if (r4 != null) goto L27;
    L23:
        b.a(this.c, this.d, this.e);
        this.a.g();
        this.b.invoke();
        goto L24
    L27:
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L23;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    L25:
        return false;
    }

    public a(xy8.a r1, z r2, Ref.BooleanRef r3, Ref.ObjectRef r4, y r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
