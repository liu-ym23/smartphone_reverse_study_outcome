package t82;

import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class e<V extends MediaInteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {
    public final String b;
    public final V c;

    public e(V r2) {
        this.b = getClass().getSimpleName();
        this.c = r2;
        ((com.bytedance.android.livesdk.common.c) this).a = r2;
    }
}
