package ap0;

import android.widget.ImageView;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformSwitchButton;
import com.bytedance.android.live.openplatform.impl.base.view.RotatingDrawable;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements LiveSwitchButton.f {
    public final /* synthetic */ OpenPlatformSwitchButton a;

    public static final class a implements OpenPlatformSwitchButton.b {
        public final /* synthetic */ OpenPlatformSwitchButton.a a;
        public final /* synthetic */ b b;

        @Override // com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformSwitchButton.b
        public final void a(boolean r6) {
            this.a.b();
            OpenPlatformSwitchButton r0 = this.b.a;
            r0.c = false;
            r0.a(2131387878).setVisibility(0);
            ((ImageView) this.b.a.a(2131379042)).setVisibility(8);
            Object r1 = ((ImageView) this.b.a.a(2131379042)).getDrawable();
            if (r1 == null) goto L9;
            ((RotatingDrawable) r1).stop();
            if (r6 == false) goto L10;
            this.b.a.a(2131387878).f(true, false);
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.base.view.RotatingDrawable");
        }

        public a(OpenPlatformSwitchButton.a r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public b(OpenPlatformSwitchButton r1) {
        this.a = r1;
    }

    public final Boolean a(boolean r5) {
        OpenPlatformSwitchButton r0 = this.a;
        OpenPlatformSwitchButton.a r1 = r0.b;
        if (r1 == null) goto L15;
        if (r0.c == true) goto L7;
        r1.b();
        OpenPlatformSwitchButton r2 = this.a;
        r2.c = true;
        r2.a(2131387878).setVisibility(4);
        ((ImageView) this.a.a(2131379042)).setVisibility(0);
        Object r3 = ((ImageView) this.a.a(2131379042)).getDrawable();
        if (r3 == null) goto L13;
        ((RotatingDrawable) r3).start();
        r1.a(this.a, r5, new a(r1, this));
        return Boolean.TRUE;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.base.view.RotatingDrawable");
    L7:
        return Boolean.TRUE;
    L15:
        return Boolean.FALSE;
    }
}
