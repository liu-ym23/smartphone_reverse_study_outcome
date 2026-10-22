package com.larus.uaigc.chat.markdown.video.statemanager;

import android.graphics.drawable.Animatable;
import android.widget.ImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l extends BaseControllerListener<Object> {
    public final /* synthetic */ i a;

    public l(i r1) {
        this.a = r1;
    }

    public final void onIntermediateImageSet(String r1, Object r2) {
        super.onIntermediateImageSet(r1, r2);
        this.a.a().hide();
        LarusWidgetMarkdownCreationSingleVideoBinding r3 = this.a.d0();
        if (r3 == null) goto L7;
        VideoPlayView r4 = r3.i;
        if (r4 == null) goto L7;
        r4.setAlpha(1.0f);
    L7:
        LarusWidgetMarkdownCreationSingleVideoBinding r5 = this.a.d0();
        if (r5 == null) goto L12;
        ImageView r6 = r5.b;
        if (r6 == null) goto L12;
        r6.setAlpha(1.0f);
    L12:
        LarusWidgetMarkdownCreationSingleVideoBinding r7 = this.a.d0();
        if (r7 == null) goto L18;
        ImageView r8 = r7.d;
        if (r8 == null) goto L19;
        r8.setAlpha(1.0f);
        return;
    L19:
        return;
    }

    public final void onFailure(String r1, ImageRequest r2, Throwable r3) {
        super.onFailure(r1, r2, r3);
        this.a.a().hide();
        LarusWidgetMarkdownCreationSingleVideoBinding r4 = this.a.d0();
        if (r4 == null) goto L7;
        VideoPlayView r5 = r4.i;
        if (r5 == null) goto L7;
        r5.setAlpha(1.0f);
    L7:
        LarusWidgetMarkdownCreationSingleVideoBinding r6 = this.a.d0();
        if (r6 == null) goto L12;
        ImageView r7 = r6.b;
        if (r7 == null) goto L12;
        r7.setAlpha(1.0f);
    L12:
        LarusWidgetMarkdownCreationSingleVideoBinding r8 = this.a.d0();
        if (r8 == null) goto L18;
        ImageView r9 = r8.d;
        if (r9 == null) goto L19;
        r9.setAlpha(1.0f);
        return;
    L19:
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        this.a.a().hide();
        LarusWidgetMarkdownCreationSingleVideoBinding r4 = this.a.d0();
        if (r4 == null) goto L7;
        VideoPlayView r5 = r4.i;
        if (r5 == null) goto L7;
        r5.setAlpha(1.0f);
    L7:
        LarusWidgetMarkdownCreationSingleVideoBinding r6 = this.a.d0();
        if (r6 == null) goto L12;
        ImageView r7 = r6.b;
        if (r7 == null) goto L12;
        r7.setAlpha(1.0f);
    L12:
        LarusWidgetMarkdownCreationSingleVideoBinding r8 = this.a.d0();
        if (r8 == null) goto L18;
        ImageView r9 = r8.d;
        if (r9 == null) goto L19;
        r9.setAlpha(1.0f);
        return;
    L19:
        return;
    }
}
