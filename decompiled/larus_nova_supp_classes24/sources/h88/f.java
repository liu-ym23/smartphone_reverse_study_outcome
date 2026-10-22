package h88;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends d {
    public final String e;

    public f() {
        this.e = "TakePhotoButtonState";
    }

    @Override // h88.d
    public String getType() {
        return this.e;
    }

    @Override // h88.d
    public final void d(boolean r3) {
        AppCompatImageView r0 = null;
        if (r3 == false) goto L9;
        View r4 = this.a;
        if ((r4 instanceof AppCompatImageView) == false) goto L7;
        r0 = (AppCompatImageView) r4;
    L7:
        if (r0 == null) goto L27;
        r0.setImageResource(2131243227);
        return;
    L27:
        return;
    L9:
        IRealtimeCallConfigDependency r5 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        if (r5 == null) goto L14;
        boolean r1 = true;
        if (r5.enableAudioBgSimpleColor() != true) goto L14;
    L15:
        if (r1 == false) goto L21;
        View r6 = this.a;
        if ((r6 instanceof AppCompatImageView) == false) goto L19;
        r0 = (AppCompatImageView) r6;
    L19:
        if (r0 == null) goto L29;
        r0.setImageResource(2131243228);
        return;
    L29:
        return;
    L21:
        View r7 = this.a;
        if ((r7 instanceof AppCompatImageView) == false) goto L24;
        r0 = (AppCompatImageView) r7;
    L24:
        if (r0 == null) goto L31;
        r0.setImageResource(2131243226);
        return;
    L31:
        return;
    L14:
        r1 = false;
        goto L15
    }
}
