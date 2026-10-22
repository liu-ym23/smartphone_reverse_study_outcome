package com.ss.android.lark.coremd.facade;

import b3c.d;
import com.ss.android.lark.coremd.facade.richtext.IMRichTextTagHandlers;
import com.ss.android.lark.richtextmd.parse.DefaultRichTextToMarkdownConfig;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/coremd/facade/IMRichTextToMarkdownConfig;", "Lcom/ss/android/lark/richtextmd/parse/DefaultRichTextToMarkdownConfig;", "<init>", "()V", "configure", BuildConfig.FLAVOR, "generator", "Lcom/ss/android/lark/richtextmd/parse/base/RichTextToNodeGenerator;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IMRichTextToMarkdownConfig extends DefaultRichTextToMarkdownConfig {

    public static final class a extends IMRichTextToMarkdownConfig {
        public a(int r1) {
        }
    }

    static {
        new a(0);
    }

    public IMRichTextToMarkdownConfig() {
    }

    public void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "generator");
        super.a(r3);
        Lazy r0 = IMRichTextTagHandlers.a;
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.IMG, (IMRichTextTagHandlers.ImageHandler) IMRichTextTagHandlers.b.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.MEDIA, (IMRichTextTagHandlers.MediaHandler) IMRichTextTagHandlers.c.getValue());
        com.ss.android.lark.richtextmd.parse.ext.a.c(r3, RichTextElement.RichTextTag.AT, (IMRichTextTagHandlers.AtTagHandler) IMRichTextTagHandlers.a.getValue());
    }
}
