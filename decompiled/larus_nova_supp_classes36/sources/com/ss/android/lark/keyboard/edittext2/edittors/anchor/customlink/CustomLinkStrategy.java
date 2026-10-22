package com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink;

import android.text.Spannable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.widget.richtext.RichTextElement;
import fob.c;
import fob.d;
import fob.e;
import fob.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00110\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/customlink/CustomLinkStrategy;", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/base/IAnchorStrategy;", "Lcom/ss/android/lark/keyboard/edittext2/edittors/editinfo/CustomLink;", "<init>", "()V", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "prepareAnchorSpanHolder", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/base/AnchorSpanHolder;", "editor", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/AnchorEditor;", "data", "provideUrlRegexResolver", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/base/IAnchorResolver;", "Landroid/text/Spannable;", "", "Lcom/ss/android/lark/keyboard/edittext2/edittors/anchor/base/UrlRegexResolver$ResolvedUrl;", "provideAnchorPropertyResolver", "Lcom/ss/android/lark/widget/richtext/RichTextElement$AnchorProperty;", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class CustomLinkStrategy implements d<hob.a> {
    public static final a b = null;
    public final Class<hob.a> a;

    public static final class a extends CustomLinkStrategy {
        public a(int r1) {
        }
    }

    static {
        b = new a(0);
    }

    public CustomLinkStrategy() {
        this.a = hob.a.class;
    }

    @Override // fob.d
    public Class<hob.a> getType() {
        return this.a;
    }

    @Override // fob.d
    public final c<Spannable, List<f.b<hob.a>>> a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        int r3 = f.b;
        return new e();
    }

    @Override // fob.d
    public final c<RichTextElement.AnchorProperty, hob.a> b(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        return new com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink.a(r2);
    }

    @Override // fob.d
    public final fob.b c(eob.a r2, hob.b r3) {
        hob.a r4 = (hob.a) r3;
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new CustomLinkSpanHolder(r4);
    }
}
