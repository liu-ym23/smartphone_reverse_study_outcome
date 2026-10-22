package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink.CustomLinkStrategy;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.list.EditorListApplier;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/usecase/VoiceKeyboardFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isVoiceInputMarkdown", "", "beforeTextPaste", "handleUnSupportElement", "", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "setupListApplier", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VoiceKeyboardFunctionEditText extends KeyboardFunctionEditText {
    public final boolean k;

    public static final class a {
    }

    static {
    }

    public VoiceKeyboardFunctionEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceKeyboardFunctionEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText
    public final boolean f() {
        ClipData r0 = RichTextCopyUtils.d(getContext());
        if (r0 != null) goto L7;
        return false;
    L7:
        return RichTextCopyUtils.h(r0, new VoiceKeyboardFunctionEditText$beforeTextPaste$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceKeyboardFunctionEditText(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        boolean r6 = KeyboardVoiceFGUtils.g(KeyboardVoiceFGUtils.a, "im.messenger.voice_input_markdown");
        this.k = r6;
        if (r6 == false) goto L16;
        d(com.ss.android.lark.keyboard.edittext2.edittors.richText.a.class);
        d(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.class);
        d(com.ss.android.lark.keyboard.edittext2.edittors.richText.b.class);
        ((RichTextEditor) q(RichTextEditor.t)).e = true;
        if (KeyboardVoiceFGUtils.i() == false) goto L7;
        int r7 = com.ss.android.lark.keyboard.edittext2.list.b.f;
        Context r8 = getContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        com.ss.android.lark.keyboard.edittext2.list.b r9 = new com.ss.android.lark.keyboard.edittext2.list.b(getContext(), new com.ss.android.lark.keyboard.edittext2.list.b.c(-1, UIUtils.getColor(r8, 2131108619), -1.0f, 12));
    L8:
        float r10 = UIHelper.px2dp(getTextSize());
        com.ss.android.lark.keyboard.edittext2.list.b.C0144b.a r11 = new com.ss.android.lark.keyboard.edittext2.list.b.C0144b.a();
        r11.a = Float.valueOf(r10);
        Integer r12 = r9.e.b;
        if (r12 == null) goto L11;
        r11.b = Integer.valueOf(r12.intValue());
    L11:
        r9.e = new com.ss.android.lark.keyboard.edittext2.list.b.C0144b(r11.a, r11.b);
        if (KeyboardVoiceFGUtils.i() == false) goto L14;
        EditorListApplier r13 = new com.ss.android.lark.keyboard.edittext2.list.a(this, r9);
    L15:
        r13.b();
        EditorListApplier.b r14 = new EditorListApplier.b(r13);
        Intrinsics.checkNotNullParameter(r14, "onKeyListener");
        this.i.add(r14);
        goto L16
    L14:
        r13 = new EditorListApplier(this, r9);
        goto L15
    L7:
        r9 = new com.ss.android.lark.keyboard.edittext2.list.b(getContext());
    L16:
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) q(com.ss.android.lark.keyboard.edittext2.edittors.a.e)).W(CollectionsKt.listOf(new VoiceAtStrategy()));
        ((eob.a) q(eob.a.f)).U(CustomLinkStrategy.b);
    }

    public /* synthetic */ VoiceKeyboardFunctionEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
