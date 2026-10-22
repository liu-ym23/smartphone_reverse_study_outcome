package com.ss.android.lark.keyboard.edittext2.edittors;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.span.VideoImageSpan;
import hob.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class e extends BaseFunctionEditor<g> implements com.ss.android.lark.keyboard.edittext2.base.c {
    public static final a e = null;
    public final int c;
    public final int d;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<e> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<e> a() {
            return this.a.a;
        }

        public a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(e.class);
        }
    }

    static {
        e = new a();
    }

    public void V() {
    }

    public e() {
        this.c = -1;
        this.d = 1;
    }

    public void U(SpannableStringBuilder r12, g r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "data");
        Editable r0 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getText();
        boolean r3 = false;
        if ((r0.getSpans(0, r0.length(), VideoImageSpan.class).length + r12.getSpans(0, r12.length(), VideoImageSpan.class).length) >= this.d) goto L5;
        r3 = true;
    L5:
        if (r3 == true) goto L9;
        V();
        return;
    L9:
        if (r13.e != null) goto L12;
        FrameInfo r1 = r13.d;
        VideoInfo r2 = r13.c;
        String r4 = r2.getPath();
        String r5 = r2.getCompressPath();
        String r6 = r1.getPath();
        int r7 = r1.getWidth();
        int r8 = r1.getHeight();
        String r9 = r2.getMimeType();
        int r10 = (int) r2.getDuration();
        long r11 = r2.getSize();
        Map r14 = RichTextElementCreator.a;
        Intrinsics.checkNotNullParameter(r4, "originPath");
        Intrinsics.checkNotNullParameter(r5, "compressPath");
        Intrinsics.checkNotNullParameter(r6, "coverPath");
        Intrinsics.checkNotNullParameter(r9, "mimeType");
        RichTextElement.MediaProperty r15 = new RichTextElement.MediaProperty();
        r15.setOriginPath(r4);
        r15.setCompressPath(r5);
        r15.setCoverPath(r6);
        r15.setWidth(r7);
        r15.setHeight(r8);
        r15.setMime(r9);
        r15.setDuration(r10);
        r15.setSize(r11);
        r15.setMediaUploadId(r2.getMediaUploadId());
        r15.setImageUploadId(r2.getImageUploadId());
        r15.setKey(r2.getKey());
        r15.setOriginImage(r2.getOriginImage());
        r15.setUrl(r2.getUrl());
        r13.e = r15;
    L12:
        int r16 = r12.length();
        String r17 = UIHelper.getString(2131891923);
        VideoImageSpan r18 = new VideoImageSpan(context(), com.larksuite.framework.utils.e.g(r13.b), r13.a, new MediaEditor$onInsert$span$1(this));
        ((com.ss.android.lark.widget.span.b) r18).m = UIUtils.dp2px(context(), 2.0f);
        ((com.ss.android.lark.widget.span.b) r18).n = UIUtils.dp2px(context(), 1.0f);
        ((com.ss.android.lark.widget.span.b) r18).p = this.c;
        r12.append(r17);
        r12.setSpan(r18, r16, r17.length() + r16, 33);
        com.ss.android.lark.keyboard.edittext2.widget.c.a.getClass();
        r12.setSpan(new com.ss.android.lark.keyboard.edittext2.widget.b(), r16, r17.length() + r16, 33);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, g r2, int r3) {
        U(r1, r2);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(g r3, SpannableStringBuilder r4, int r5, int r6) {
        g r7 = r3;
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r4, "text");
        RichTextElement.MediaProperty r8 = r7.e;
        if (r8 == null) goto L6;
        r4.setSpan(new p(RichTextElementCreator.h(r8), r4.subSequence(r5, r6).toString()), r5, r6, 33);
        return;
    }
}
