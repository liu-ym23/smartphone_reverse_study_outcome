package b3c;

import android.content.Context;
import com.ss.android.lark.coremd.utils.BISURelocator;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {
    a a(RichTextElement.RichTextTag r1);

    RichTextExtraInfo b();

    com.ss.android.lark.richtextmd.parse.impl.b.C0130b c();

    BISURelocator d();

    com.ss.android.lark.richtextmd.parse.impl.c e(RichTextElement r1);

    Context getContext();

    RichTextElement getElement();

    RichTextElement getElementById(String r1);
}
