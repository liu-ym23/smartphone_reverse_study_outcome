package com.ss.android.lark.keyboard.biz.emoji;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard_biz_emoji_office.OfficeDefaultEmojiFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements com.ss.android.lark.keyboard_biz_emoji_office.b {
    public final /* synthetic */ IMFaceKBPlugin a;

    @Override // com.ss.android.lark.keyboard_biz_emoji_office.a
    public final int a() {
        return this.a.n().L().c().length();
    }

    public final void c() {
        IMFaceKBPlugin r0 = this.a;
        r0.getClass();
        KeyEvent r13 = new KeyEvent(0, 0, 0, 67, 0, 0, 0, 0, 6);
        r0.n().L().c().dispatchKeyEvent(r13);
    }

    public e(IMFaceKBPlugin r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.keyboard_biz_emoji_office.a
    public final void d(OfficeDefaultEmojiFragment.b r2) {
        Intrinsics.checkNotNullParameter(r2, "textWatcher");
        EditText r0 = this.a.n().L().c();
        r0.removeTextChangedListener(r2);
        r0.addTextChangedListener(r2);
    }

    public final void e(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reactionKey");
        EditText r0 = this.a.n().L().c();
        String r1 = "[" + qsb.b.a().df(r8) + ']';
        qsb.a r2 = qsb.b.a().Yd(r8);
        if (r2 == null) goto L5;
        String r3 = r2.a;
    L6:
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        Log.i("IMFaceKBPlugin", "appendEmoji [" + r8 + "] failed, emoji key is null");
        return;
    L15:
        Drawable r5 = EmojiHandler.c(r3, null, null);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if ((r0 instanceof FunctionEditText) == false) goto L19;
        if (r5 == null) goto L19;
        ExtensionEditTextCompatKt.a(r0, r0.getContext(), r5, r3, r1);
        Unit r9 = Unit.INSTANCE;
        return;
    L19:
        Log.i("IMFaceKBPlugin", "appendEmoji [" + r8 + "] failed, emoji drawable is null");
        int r10 = r0.getSelectionStart();
        Editable r6 = r0.getEditableText();
        if (r10 >= 0) goto L22;
    L25:
        r6.append(r1);
        return;
    L22:
        if (r10 >= r6.length()) goto L25;
        r6.insert(r10, r1);
        return;
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void b(AppCompatImageView r2, com.ss.android.lark.keyboard.plugin.tool.face.d r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "stickerFileInfo");
        this.a.g.b(r2, r3);
        k.a.a(this.a.n().e(), q.a.a);
    }
}
