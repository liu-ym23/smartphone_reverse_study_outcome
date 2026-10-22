package u62;

import android.app.Activity;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.comment.input.LiveCommonInputDialog;
import kotlin.jvm.internal.Intrinsics;
import v62.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b implements v62.a.InterfaceC0287a {
    public final /* synthetic */ v62.a.InterfaceC0287a a;

    @Override // v62.a.InterfaceC0287a
    public final void a() {
        this.a.a();
    }

    public abstract void b();

    @Override // v62.a.InterfaceC0287a
    public final void c(BaseEmoji r2, String r3) {
        this.a.c(r2, r3);
    }

    public abstract int d();

    @Override // v62.a.InterfaceC0287a
    public final void dismissDialog() {
        this.a.dismissDialog();
    }

    public abstract void e();

    public abstract Activity getActivity();

    public b(LiveCommonInputDialog.c r3) {
        d.a r0 = d.a;
        Intrinsics.checkNotNullParameter(r3, "emojiPanelBridge");
        Intrinsics.checkNotNullParameter(r0, "screenChatPanelBridge");
        this.a = r3;
    }
}
