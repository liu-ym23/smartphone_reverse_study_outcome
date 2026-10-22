package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.bytedance.android.livesdk.interactivity.api.input.ActivityEmojiAutoTestUtil;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ e.d a;
    public final /* synthetic */ com.bytedance.android.live.base.model.data.activityemoji.b b;

    public t(e.d r1, com.bytedance.android.live.base.model.data.activityemoji.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Bitmap r7 = (Bitmap) r6;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.a.a.a;
        if (r1 == null) goto L7;
        Activity r2 = r1.getActivity();
        if (r2 == null) goto L7;
        Resources r3 = r2.getResources();
    L8:
        BitmapDrawable r0 = new BitmapDrawable(r3, r7);
        float r4 = r7.getWidth() / (r7.getHeight() + 0.0f);
        int r8 = com.bytedance.android.live.core.utils.s1.f(18.0f);
        com.bytedance.android.livesdk.interactivity.comment.input.a r5 = new com.bytedance.android.livesdk.interactivity.comment.input.a(r0, this.b, (int) (r4 * r8), r8);
        SpannableStringBuilder r9 = new SpannableStringBuilder(this.b.getName());
        String r10 = this.b.getName();
        if (r10 == null) goto L11;
        int r11 = r10.length();
    L12:
        r9.setSpan(r5, 0, r11, 33);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r13 = this.a.a.a;
        if (r13 == null) goto L17;
        EditText r14 = r13.a;
        if (r14 == null) goto L17;
        int r15 = r14.getSelectionStart();
    L18:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r16 = this.a.a.a;
        if (r16 == null) goto L26;
        EditText r17 = r16.a;
        if (r17 == null) goto L26;
        Editable r18 = r17.getEditableText();
        if (r18 == null) goto L26;
        r18.insert(r15, r9);
    L26:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L37;
        ActivityEmojiAutoTestUtil.c.getClass();
        if (ActivityEmojiAutoTestUtil.a == false) goto L38;
        long r19 = this.b.getId();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L40;
        Lazy r20 = ActivityEmojiAutoTestUtil.b;
        List<Long> r21 = ((com.bytedance.android.livesdk.interactivity.api.input.a) r20.getValue()).c;
        if (r21 == null) goto L35;
        r21.add(Long.valueOf(r19));
        return;
    L35:
        ((com.bytedance.android.livesdk.interactivity.api.input.a) r20.getValue()).c = CollectionsKt.mutableListOf(new Long[]{Long.valueOf(r19)});
        return;
    L40:
        return;
    L38:
        return;
    L37:
        return;
    L17:
        r15 = 0;
        goto L18
    L11:
        r11 = 0;
    L7:
        r3 = null;
        goto L8
    }
}
