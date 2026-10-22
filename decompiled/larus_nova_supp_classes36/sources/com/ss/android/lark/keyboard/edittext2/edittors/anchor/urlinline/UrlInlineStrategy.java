package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import android.text.Spannable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.widget.richtext.RichTextElement;
import fob.f;
import hob.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/urlinline/UrlInlineStrategy;", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/base/IAnchorStrategy;", "Lcom/ss/android/lark/keyboard/edittext2/edittors/editinfo/UrlInline;", "urlPreviewConfig", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/urlinline/UrlInlinePreviewConfig;", "<init>", "(Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/urlinline/UrlInlinePreviewConfig;)V", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "provideUrlRegexResolver", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/base/IAnchorResolver;", "Landroid/text/Spannable;", "", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/base/UrlRegexResolver$ResolvedUrl;", "editor", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/AnchorEditor;", "provideAnchorPropertyResolver", "Lcom/ss/android/lark/widget/richtext/RichTextElement$AnchorProperty;", "prepareAnchorSpanHolder", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/base/AnchorSpanHolder;", "data", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class UrlInlineStrategy implements fob.d<j> {
    public static final a c = null;
    public final UrlInlinePreviewConfig a;
    public final Class<j> b;

    public static final class a extends UrlInlineStrategy {
        public a() {
            super(0);
        }
    }

    public UrlInlineStrategy() {
        this(0);
    }

    static {
        c = new a();
    }

    @Override // fob.d
    public Class<j> getType() {
        return this.b;
    }

    public UrlInlineStrategy(int r2) {
        int r3 = UrlInlinePreviewConfig.b;
        UrlInlinePreviewConfig r4 = UrlInlinePreviewConfig.a.a();
        Intrinsics.checkNotNullParameter(r4, "urlPreviewConfig");
        this.a = r4;
        this.b = j.class;
    }

    @Override // fob.d
    public final fob.c<Spannable, List<f.b<j>>> a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new b(this, r2);
    }

    @Override // fob.d
    public final fob.c<RichTextElement.AnchorProperty, j> b(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a(r2);
    }

    @Override // fob.d
    public final fob.b c(eob.a r2, hob.b r3) {
        j r4 = (j) r3;
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new d(r4, this.a);
    }
}
