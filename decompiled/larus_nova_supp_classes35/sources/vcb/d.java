package vcb;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.chatwindow.view.preview.g;
import com.ss.android.lark.export.params.URLPreviewParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends r6c.a {
    public final LifecycleOwner b;
    public a c;
    public final URLPreviewParams d;
    public bdb.a e;
    public boolean f;

    public /* synthetic */ d(Context r8, LifecycleOwner r9, URLPreviewParams r10) {
        this(r8, r9, null, r10, null, false);
    }

    public d(Context r2, LifecycleOwner r3, g r4, URLPreviewParams r5, bdb.a r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "urlPreviewParams");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
