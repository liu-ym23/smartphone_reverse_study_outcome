package oa2;

import android.net.Uri;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ HSImageView a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.barrage.model.a b;
    public final /* synthetic */ ChatCarnivalView c;

    public c(HSImageView r1, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2, ChatCarnivalView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        ChatCarnivalView r0 = this.c;
        PipelineDraweeControllerBuilder r1 = Fresco.newDraweeControllerBuilder();
        r0.o = r1.setUri((Uri) r3).setAutoPlayAnimations(true).build();
        this.a.setController(this.c.o);
    }
}
