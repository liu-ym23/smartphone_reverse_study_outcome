package dob;

import android.text.Spannable;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends com.ss.android.lark.keyboard.edittext2.edittors.richText.b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichTextElement.RichTextTag.values().length];
            r0[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public c() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final RichTextExtraInfo a(RichTextExtraInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "richTextExtraInfo");
        com.ss.android.lark.keyboard.edittext2.base.b r0 = getTarget();
        if ((r0 instanceof FlowKeyboardFunctionEditText) == false) goto L5;
        FlowKeyboardFunctionEditText r1 = (FlowKeyboardFunctionEditText) r0;
    L6:
        if (r1 == null) goto L9;
        String r2 = r1.getCurChatId();
        if (r2 == null) goto L9;
    L11:
        if (r2.length() <= 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        r3.setCurChatId(r2);
    L16:
        return r3;
    L13:
        r4 = false;
    L9:
        r2 = "";
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final RichTextElement f(RichTextElement r4) {
        Intrinsics.checkNotNullParameter(r4, "anchorElement");
        RichTextElement.AnchorProperty r0 = r4.getProperty();
        if (r0.getScene() != RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT) goto L5;
    L9:
        Log.i("RichTextGenerator", "genAnchorElement: element is custom anchor");
        return r4;
    L5:
        if (r0.isCustom() == true) goto L9;
        return super.f(r4);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final boolean o(Spannable r12, Object r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "editable");
        Intrinsics.checkNotNullParameter(r13, "span");
        boolean r1 = false;
        if ((r13 instanceof p) == false) goto L26;
        p r16 = (p) r13;
        Object r0 = r16.b;
        if ((r0 instanceof RichTextElement) == false) goto L28;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement");
        RichTextElement r2 = (RichTextElement) r0;
        RichTextElement.RichTextTag r3 = r2.getTag();
        if (r3 != null) goto L10;
        int r4 = -1;
    L12:
        if (r4 != 1) goto L27;
        RichTextElement.AnchorProperty r5 = r2.getProperty();
        if (r5.getScene() != RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT) goto L29;
        Log.i("RichTextGenerator", "interceptPossibleLinkIfNeed: anchorTag is possible link, double check content change");
        String r6 = r12.subSequence(r14, r15).toString();
        if (Intrinsics.areEqual(r5.getHref(), r6) == true) goto L30;
        ArrayList r17 = new ArrayList();
        r12.removeSpan(r16);
        com.ss.android.lark.keyboard.edittext2.utils.b.e(r6, r17);
        if (r17.size() != 1) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
        String r18 = ((com.ss.android.lark.keyboard.edittext2.utils.b.a) CollectionsKt.first(r17)).a;
        r5.setHref(r18);
        r5.setContent(r18);
        int r7 = StringsKt.indexOf$default(r6, r18, 0, false, 6, null) + r14;
        r12.setSpan(r16, r7, r18.length() + r7, 33);
        Log.i("RichTextGenerator", "isAnchorValid: custom link update: from: " + r5.getHref() + " to " + r18);
    L24:
        return true;
    L30:
        return false;
    L29:
        return false;
    L27:
        return false;
    L10:
        r4 = a.a[r3.ordinal()];
        goto L12
    L28:
        return false;
    L26:
        return false;
    }
}
